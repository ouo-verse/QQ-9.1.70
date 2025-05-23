package com.tencent.mobileqq.qcircle.api.helper;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import qqcircle.QQCircleCounter$PrivateMessage;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleChatBoxHelper {
    private static final String LINK_KEY = "&";
    private static final String TAG = "QCircleChatBoxHelper";
    private static volatile QCircleChatBoxHelper sInstance;
    private final ArrayList<String> mOnlyShowBubbleUinList;
    private volatile Pair<Integer, List<QQCircleCounter$PrivateMessage>> mUnReadInfo;
    private volatile int mUnReadNum;
    private final List<QQCircleCounter$PrivateMessage> mUnReadUinList = new LinkedList();

    public QCircleChatBoxHelper() {
        ArrayList<String> qQCircleOnlyShowBubbleUins = QzoneConfig.getQQCircleOnlyShowBubbleUins();
        this.mOnlyShowBubbleUinList = qQCircleOnlyShowBubbleUins;
        QLog.d(TAG, 1, "mOnlyShowBubbleUinList:" + qQCircleOnlyShowBubbleUins.toString());
    }

    public static QCircleChatBoxHelper getInstance() {
        if (sInstance == null) {
            synchronized (QCircleChatBoxHelper.class) {
                if (sInstance == null) {
                    sInstance = new QCircleChatBoxHelper();
                }
            }
        }
        return sInstance;
    }

    private void loadUnReadInfoFromSp() {
        this.mUnReadInfo = new Pair<>(0, new LinkedList());
        try {
            SharedPreferences qCircleSp = ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
            if (qCircleSp != null) {
                String string = qCircleSp.getString("key_qcircle_unread_message_infos", "");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("&");
                    if (split.length > 1) {
                        this.mUnReadNum = Integer.parseInt(split[0]);
                        for (String str : Arrays.asList(split).subList(1, split.length)) {
                            QQCircleCounter$PrivateMessage qQCircleCounter$PrivateMessage = new QQCircleCounter$PrivateMessage();
                            if (Proto2JsonUtil.json2Pb(str, qQCircleCounter$PrivateMessage)) {
                                this.mUnReadUinList.add(qQCircleCounter$PrivateMessage);
                            }
                        }
                    }
                    QLog.d(TAG, 1, "getUnReadMessages from sp:Num" + this.mUnReadInfo.first);
                    this.mUnReadInfo = new Pair<>(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    public static void releaseInstance() {
        QLog.e(TAG, 1, "releaseInstance");
        if (sInstance != null) {
            synchronized (QCircleChatBoxHelper.class) {
                if (sInstance != null) {
                    sInstance = new QCircleChatBoxHelper();
                }
            }
        }
    }

    private void storeUnReadInfo(int i3, List<QQCircleCounter$PrivateMessage> list) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        for (QQCircleCounter$PrivateMessage qQCircleCounter$PrivateMessage : list) {
            sb5.append("&");
            sb5.append(Proto2JsonUtil.proto2Json(qQCircleCounter$PrivateMessage));
        }
        SharedPreferences qCircleSp = ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putString("key_qcircle_unread_message_infos", sb5.toString()).apply();
            QLog.d(TAG, 1, "saveUnReadInfo unReadNum:" + i3);
        }
    }

    private void updateUnReadInfo() {
        this.mUnReadInfo = new Pair<>(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
        storeUnReadInfo(this.mUnReadNum, this.mUnReadUinList);
    }

    public synchronized void clearUnReadInfo() {
        QLog.d(TAG, 1, "clearUnReadInfo");
        this.mUnReadNum = 0;
        this.mUnReadUinList.clear();
        updateUnReadInfo();
        SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent("QCircleChatBoxHelper clearUnReadInfo", true));
    }

    public synchronized int getUnReadChatNum() {
        int size;
        if (this.mUnReadInfo == null) {
            loadUnReadInfoFromSp();
        }
        size = ((List) this.mUnReadInfo.second).size();
        QLog.d(TAG, 1, "getUnReadChatNum unReadNum:" + size);
        return size;
    }

    public synchronized Pair<Integer, List<QQCircleCounter$PrivateMessage>> getUnReadMessages() {
        if (this.mUnReadInfo == null) {
            loadUnReadInfoFromSp();
        } else {
            QLog.d(TAG, 1, "getUnReadMessages not null return readInfoNum:" + this.mUnReadInfo.first);
        }
        return new Pair<>((Integer) this.mUnReadInfo.first, new LinkedList((Collection) this.mUnReadInfo.second));
    }

    public synchronized void insertUnReadMessage(QQCircleCounter$PrivateMessage qQCircleCounter$PrivateMessage) {
        if (qQCircleCounter$PrivateMessage == null) {
            return;
        }
        if (TextUtils.isEmpty(qQCircleCounter$PrivateMessage.uID.get())) {
            return;
        }
        for (QQCircleCounter$PrivateMessage qQCircleCounter$PrivateMessage2 : this.mUnReadUinList) {
            if (qQCircleCounter$PrivateMessage2 != null && TextUtils.equals(qQCircleCounter$PrivateMessage.uID.get(), qQCircleCounter$PrivateMessage2.uID.get()) && qQCircleCounter$PrivateMessage.timestamp.get() == qQCircleCounter$PrivateMessage2.timestamp.get()) {
                return;
            }
        }
        this.mUnReadNum++;
        this.mUnReadUinList.add(qQCircleCounter$PrivateMessage);
        updateUnReadInfo();
        QLog.d(TAG, 1, "insertUnReadMessage uin:" + qQCircleCounter$PrivateMessage.uID.get() + ",allUnReadNum:" + this.mUnReadNum);
    }
}
