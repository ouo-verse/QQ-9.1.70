package com.tencent.mobileqq.richmedia.ordersend.impl;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.richmedia.ordersend.MediaMsgController;
import com.tencent.mobileqq.richmedia.ordersend.a;
import com.tencent.mobileqq.richmedia.ordersend.c;
import com.tencent.mobileqq.richmedia.ordersend.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OrderMediaMsgServiceImpl implements IOrderMediaMsgService, d.c {
    public static final String TAG = "OrderMediaMsgService";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQRichMediaImpl/Inject_MediaMsgController.yml", version = 1)
    public static ArrayList<Class<? extends a>> sInjectMediaMsgCtrlList;
    private AppRuntime mApp;
    private a mMediaMsgController;
    protected HashMap<String, d> mOrderMediaMsgSessionMap = new HashMap<>();

    static {
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        sInjectMediaMsgCtrlList = arrayList;
        arrayList.add(MediaMsgController.class);
    }

    @NonNull
    private d getOrderMediaMsgSession(@NonNull String str) {
        d dVar;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getOrderMediaMsgSession error, sessionUin is empty!");
        }
        synchronized (this.mOrderMediaMsgSessionMap) {
            if (this.mOrderMediaMsgSessionMap.containsKey(str)) {
                dVar = this.mOrderMediaMsgSessionMap.get(str);
            } else {
                d dVar2 = new d(str, getMsgController());
                dVar2.x(this);
                this.mOrderMediaMsgSessionMap.put(str, dVar2);
                dVar = dVar2;
            }
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public boolean addCallback(String str, long j3, View view, r rVar) {
        if (!TextUtils.isEmpty(str) && this.mOrderMediaMsgSessionMap.containsKey(str)) {
            return getOrderMediaMsgSession(str).p().a(this.mApp, j3, view, rVar);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void addOrderMsg(MessageRecord messageRecord, String str) {
        if (TextUtils.isEmpty(messageRecord.frienduin)) {
            QLog.e(TAG, 1, "addOrderMsg error, mr.frienduin is empty!");
            return;
        }
        d orderMediaMsgSession = getOrderMediaMsgSession(messageRecord.frienduin);
        if (orderMediaMsgSession.q(messageRecord.uniseq, str)) {
            orderMediaMsgSession.j(messageRecord, messageRecord.uniseq, str, true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addOrderMsg but not in queue, uniseq:" + messageRecord.uniseq + ", path:" + str);
        }
        getMsgController().a(messageRecord);
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void addOrderMsgStatus(String str, MessageRecord messageRecord, String str2) {
        if (TextUtils.isEmpty(messageRecord.frienduin)) {
            QLog.e(TAG, 1, "addOrderMsgStatus error, mr.frienduin is empty!");
            return;
        }
        d orderMediaMsgSession = getOrderMediaMsgSession(messageRecord.frienduin);
        if (!orderMediaMsgSession.q(messageRecord.uniseq, str2)) {
            enqueueMediaMsgByUniseq(str, messageRecord.uniseq);
        }
        orderMediaMsgSession.j(messageRecord, messageRecord.uniseq, str2, false);
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void enqueueMediaMsgByMsgList(String str, ArrayList<ChatMessage> arrayList) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "enqueueMediaMsgByMsgList error, sessionUin is empty!");
            return;
        }
        if (arrayList != null) {
            Iterator<ChatMessage> it = arrayList.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                ChatMessage next = it.next();
                i3++;
                if (getMsgController().e(next.msgtype)) {
                    i16++;
                    getOrderMediaMsgSession(str).n(next.uniseq, "", getMsgController().i(next));
                }
            }
            c.a(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void enqueueMediaMsgByPath(String str, String str2) {
        if (getMsgController().h(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "enqueueMediaMsgByPath error, sessionUin is empty!");
        } else {
            getOrderMediaMsgSession(str).m(0L, str2);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void enqueueMediaMsgByUniseq(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "enqueueMediaMsgByUniseq error, sessionUin is empty!");
        } else {
            getOrderMediaMsgSession(str).m(j3, "");
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public a getMsgController() {
        if (this.mMediaMsgController == null) {
            try {
                this.mMediaMsgController = sInjectMediaMsgCtrlList.get(0).newInstance();
            } catch (Exception e16) {
                QLog.d(TAG, 1, "getMsgCtr error!", e16);
            }
        }
        return this.mMediaMsgController;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public boolean isMediaMsgInQueue(String str, long j3) {
        if (TextUtils.isEmpty(str) || !this.mOrderMediaMsgSessionMap.containsKey(str) || getOrderMediaMsgSession(str).p().f(j3) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public boolean isMediaMsgInQueueNotHead(String str, long j3) {
        if (TextUtils.isEmpty(str) || !this.mOrderMediaMsgSessionMap.containsKey(str) || getOrderMediaMsgSession(str).p().f(j3) != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public boolean isSessionOrderSending(String str) {
        if (!TextUtils.isEmpty(str) && this.mOrderMediaMsgSessionMap.containsKey(str)) {
            return !getOrderMediaMsgSession(str).r();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.d.c
    public void onAllCompleted(String str) {
        d dVar;
        Object obj;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mOrderMediaMsgSessionMap) {
                dVar = this.mOrderMediaMsgSessionMap.remove(str);
            }
        } else {
            dVar = null;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("remove orderSession, suin = ");
            sb5.append(str);
            sb5.append(", addr = ");
            if (dVar != null) {
                obj = dVar.toString();
            } else {
                obj = 0;
            }
            sb5.append(obj);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        HashMap<String, d> hashMap = this.mOrderMediaMsgSessionMap;
        if (hashMap != null) {
            Iterator<d> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().k();
            }
            this.mOrderMediaMsgSessionMap.clear();
        }
        this.mApp = null;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void removeMediaMsgByUniseq(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "removeMediaMsgByUniseq error, sessionUin is empty!");
        } else {
            getOrderMediaMsgSession(str).u(j3);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void sendOrderMsg(MessageRecord messageRecord, bo boVar) {
        sendOrderMsg(messageRecord, boVar, null);
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void updateMediaMsgByUniseq(String str, long j3, long j16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "updateMediaMsgByUniseq error, sessionUin is empty!");
        } else {
            getOrderMediaMsgSession(str).y(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
    public void sendOrderMsg(MessageRecord messageRecord, bo boVar, IOrderMediaMsgService.a aVar) {
        if (TextUtils.isEmpty(messageRecord.frienduin)) {
            QLog.e(TAG, 1, "sendOrderMsg error, mr.frienduin is empty!");
            return;
        }
        d orderMediaMsgSession = getOrderMediaMsgSession(messageRecord.frienduin);
        if (orderMediaMsgSession.q(messageRecord.uniseq, getMsgController().g(messageRecord))) {
            orderMediaMsgSession.w(messageRecord, boVar, aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendOrderMsg but not in queue, uniseq:" + messageRecord.uniseq);
        }
        getMsgController().c(messageRecord, boVar, aVar);
    }
}
