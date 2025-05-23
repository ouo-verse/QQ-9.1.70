package com.qzone.feed.business.service;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_visit_rsp;
import NS_MOBILE_MAIN_PAGE.s_user;
import NS_MOBILE_MAIN_PAGE.s_visit;
import android.os.Handler;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.feed.business.protocol.QZoneGetVisitNotifyRequest;
import com.qzone.util.al;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements IQZoneServiceListener {

    /* renamed from: h, reason: collision with root package name */
    public static String f47218h = "QZoneVisitNotifyService";

    /* renamed from: i, reason: collision with root package name */
    private static final al<c, Void> f47219i = new a();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<s_user> f47220d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public int f47221e;

    /* renamed from: f, reason: collision with root package name */
    public int f47222f;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<c, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(Void r16) {
            return new c();
        }
    }

    public static c a() {
        return f47219i.get(null);
    }

    public int b() {
        return this.f47222f;
    }

    public int c() {
        return this.f47221e;
    }

    public void d(long j3, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneGetVisitNotifyRequest(j3, ""), handler, this, 1));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 1) {
            return;
        }
        e(qZoneTask);
    }

    public void e(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000097);
        this.f47221e = 0;
        if (qZoneTask.succeeded()) {
            mobile_sub_get_visit_rsp mobile_sub_get_visit_rspVar = (mobile_sub_get_visit_rsp) qZoneTask.mRequest.rsp;
            if (mobile_sub_get_visit_rspVar != null) {
                this.f47220d.clear();
                s_visit s_visitVar = mobile_sub_get_visit_rspVar.visit;
                if (s_visitVar != null) {
                    this.f47220d.addAll(s_visitVar.datalist);
                    result.setData(this.f47220d);
                    result.setSucceed(true);
                    this.f47221e = mobile_sub_get_visit_rspVar.visit.totalnum;
                }
                this.f47222f = mobile_sub_get_visit_rspVar.nextTimeInterval;
            } else {
                result.setSucceed(false);
                result.setMessage(qZoneTask.f45835msg);
            }
        } else {
            QZLog.e(QZLog.TO_DEVICE_TAG, f47218h + "onGetVisitNotifyResponse failed: " + qZoneTask.mResultCode + "msg:" + qZoneTask.f45835msg);
            result.setSucceed(false);
            result.setMessage(qZoneTask.f45835msg);
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(f47218h, 4, f47218h + "VisitNotify respone send ServiceHandlerEvent.MST_GET_VISIT_NOTIFY msg to UI");
        }
        qZoneTask.sendResultMsg(result);
    }
}
