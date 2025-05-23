package com.tencent.biz.qqcircle.immersive.personal.request;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.d;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.e;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDelViewHistoryRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageCommDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSMainPageLayerShareAdRequest;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.immersive.request.QFSDoUrgeRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.utils.bq;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase$ViewedFeed;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Call.OnRspCallBack {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSDoUrgeRequest f89015d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f89016e;

        a(QFSDoUrgeRequest qFSDoUrgeRequest, String str) {
            this.f89015d = qFSDoUrgeRequest;
            this.f89016e = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
            w wVar;
            QLog.i("QFSPersonalRequestManager", 1, "[sendPushMoreRequest] -> traceId = " + this.f89015d.getTraceId() + " , isSuccess = " + z16 + " , retCode = " + j3 + " , errMsg = " + str);
            if (z16 && j3 == 0 && obj2 != null) {
                MutableLiveData globalData = w20.a.j().getGlobalData(w.class, this.f89015d.getUin());
                if (globalData != null) {
                    wVar = (w) globalData.getValue();
                } else {
                    wVar = null;
                }
                if (wVar == null) {
                    wVar = new w(this.f89015d.getUin());
                }
                wVar.Z(2);
                w20.a.j().initOrUpdateGlobalState((w20.a) wVar, true);
                QCircleToast.o(c.Y2(), 0);
                bq.g(this.f89016e);
                return;
            }
            if (j3 == 120013) {
                QCircleToast.o(str, 0);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.request.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0902b {

        /* renamed from: a, reason: collision with root package name */
        private final String f89017a;

        /* renamed from: b, reason: collision with root package name */
        private final int f89018b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f89019c = false;

        public C0902b(String str, int i3) {
            this.f89017a = str;
            this.f89018b = i3;
        }

        private QFSGetFeedListRequest b(String str, int i3, boolean z16) {
            QFSGetFeedListRequest.b h16 = new QFSGetFeedListRequest.b(str).h(0);
            switch (i3) {
                case ErrorCode.ERROR_CMD_INVALID /* 20101 */:
                    h16.k(8);
                    break;
                case ErrorCode.ERROR_APPID_NOT_FOUND /* 20102 */:
                    h16.k(42);
                    break;
                case ErrorCode.ERROR_VERIFY_FAILED /* 20103 */:
                    h16.k(9);
                    break;
                case ErrorCode.ERROR_TIMESTAMP_INVALID /* 20105 */:
                    h16.j(1);
                    break;
                case ErrorCode.ERROR_CHECKLEGALAPP_SYS_ERROR /* 20106 */:
                    h16.j(0);
                    break;
                case ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP /* 20107 */:
                    h16.k(57);
                    break;
            }
            if (z16) {
                h16.d();
            }
            return h16.a();
        }

        public QCircleRequestCall a() {
            QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
            b16.h(false).addRequest(b(this.f89017a, this.f89018b, this.f89019c));
            return b16;
        }

        public C0902b c(boolean z16) {
            this.f89019c = z16;
            return this;
        }
    }

    private static QFSGetMainPageBasicDataRequest a(String str, boolean z16, int i3, String str2, HashMap<String, String> hashMap) {
        QFSGetMainPageBasicDataRequest.b bVar = new QFSGetMainPageBasicDataRequest.b(str);
        if (z16) {
            bVar.d();
        }
        bVar.f(i3);
        bVar.i(str2);
        bVar.g(hashMap);
        return bVar.a();
    }

    private static QFSGetFeedListRequest b(String str, int i3, boolean z16) {
        QFSGetFeedListRequest.b h16 = new QFSGetFeedListRequest.b(str).h(0);
        switch (i3) {
            case ErrorCode.ERROR_APPID_NOT_FOUND /* 20102 */:
                h16.k(42);
                break;
            case ErrorCode.ERROR_VERIFY_FAILED /* 20103 */:
                h16.k(9);
                break;
            case ErrorCode.ERROR_TIMESTAMP_INVALID /* 20105 */:
                h16.j(1);
                break;
            case ErrorCode.ERROR_CHECKLEGALAPP_SYS_ERROR /* 20106 */:
                h16.j(0);
                break;
            case ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP /* 20107 */:
                h16.k(57).m(QFSRecentlyWatchedRecorder.i().k());
                break;
        }
        if (z16) {
            h16.d();
        }
        return h16.a();
    }

    private static QFSGetMainPageCommDataRequest c(String str, boolean z16, int i3, int i16) {
        QFSGetMainPageCommDataRequest.b bVar = new QFSGetMainPageCommDataRequest.b(str);
        if (z16) {
            bVar.d();
        }
        if (i3 != -1) {
            bVar.i(i3);
        }
        if (i16 == 2) {
            bVar.j(i16);
        }
        return bVar.a();
    }

    private static int d(boolean z16) {
        if (z16) {
            return 2;
        }
        return 0;
    }

    private static void e(QCircleRequestCall qCircleRequestCall, int i3, String str) {
        if (i3 == 20107) {
            qCircleRequestCall.f(AppSetting.SUPVERSION + str);
        }
    }

    public static void f(String str, QFSUIStateBaseManager qFSUIStateBaseManager, Call.OnRspCallBack onRspCallBack, boolean z16) {
        int d16 = d(z16);
        QLog.i("QFSPersonalRequestManager", 1, "loadMoreProducts, isPrivateProds:" + z16 + ", feedListType:" + d16);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(qFSUIStateBaseManager).i(true).addRequest(c(str, false, -1, d16)).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void g(int i3, String str, boolean z16) {
        QFSGetFeedListRequest b16 = b(str, i3, !z16);
        if (BaseRequest.isCacheExist(b16)) {
            BaseRequest.reMoveCache(b16);
        }
    }

    public static void h(List<QQCircleFeedBase$ViewedFeed> list, Call.OnRspCallBack<QFSAddViewHistoryRequest> onRspCallBack) {
        QLog.i("QFSPersonalRequestManager", 1, "requestAddViewHistory");
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSAddViewHistoryRequest(list)).m250setRspOnCallBack((Call.OnRspCallBack) onRspCallBack).execute();
    }

    public static void i(String str, Call.OnRspCallBack onRspCallBack, boolean z16, int i3, String str2, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.i("QFSPersonalRequestManager", RFWLog.USR, "uin is empty");
            return;
        }
        QFSGetMainPageBasicDataRequest a16 = a(str, z16, i3, str2, hashMap);
        QLog.i("QFSPersonalRequestManager", 1, "requestBasicData, uin = " + str + ", traceId: " + a16.getTraceId());
        QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2001");
        sb5.append(str);
        b16.f(sb5.toString()).addRequest(a16).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void j(Call.OnRspCallBack onRspCallBack) {
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSDelViewHistoryRequest.a(1).a()).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static C0902b k(String str, int i3) {
        return new C0902b(str, i3);
    }

    public static void l(int i3, String str, d dVar, Call.OnRspCallBack onRspCallBack, RspInterceptor rspInterceptor, boolean z16, boolean z17) {
        boolean z18;
        QFSGetFeedListRequest b16 = b(str, i3, z16);
        if (z16 && !z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        b16.setEnableCache(z18);
        QCircleRequestCall b17 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
        if (z17) {
            b17.i(true);
        } else {
            e(b17, i3, str);
        }
        b17.j(dVar).h(false).addRequest(b16).m250setRspOnCallBack(onRspCallBack).addRspInterceptor(rspInterceptor).execute();
    }

    public static void m(String str, e eVar, Call.OnRspCallBack onRspCallBack, String str2, long j3) {
        QLog.i("QFSPersonalRequestManager", 1, "requestJustSee");
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(eVar).addRequest(new QFSGetMainPageCommDataRequest.b(str).l(4, str, str2, j3).a()).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void n(List<String> list, String str, String str2, int i3, int i16, Call.OnRspCallBack onRspCallBack) {
        QLog.i("QFSPersonalRequestManager", 1, "requestMainLayerPageShareAd");
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(new QFSMainPageLayerShareAdRequest.a(list, str, str2).g(i3).f(i16).a()).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void o(String str, QFSUIStateBaseManager qFSUIStateBaseManager, Call.OnRspCallBack onRspCallBack, boolean z16, int i3, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.i("QFSPersonalRequestManager", RFWLog.USR, "uin is empty");
            return;
        }
        int d16 = d(z17);
        QLog.i("QFSPersonalRequestManager", 1, "requestProducts, isPrivateProds:" + z17 + ", feedListType:" + d16);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().f("2011" + str + "_" + d16).j(qFSUIStateBaseManager).addRequest(c(str, z16, i3, d16)).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void p(String str, Call.OnRspCallBack onRspCallBack, int i3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.i("QFSPersonalRequestManager", RFWLog.USR, "uin is empty");
            return;
        }
        QFSGetMainPageBasicDataRequest.b bVar = new QFSGetMainPageBasicDataRequest.b(str);
        if (z16) {
            bVar.d();
        }
        QFSGetMainPageBasicDataRequest a16 = bVar.h(i3).a();
        QLog.i("QOK-QFSPersonalRequestManager", 1, "requestBasicData, uin = " + str + ", from: " + i3 + ", traceId: " + a16.getTraceId());
        QCircleRequestCall b16 = com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("2001");
        sb5.append(str);
        b16.f(sb5.toString()).addRequest(a16).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void q(w wVar) {
        r(wVar, 0);
    }

    public static void r(w wVar, int i3) {
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSPersonalRequestManager", 1, "[sendPushMoreRequest] forbid push more because of sencebeat");
            return;
        }
        if (wVar == null) {
            return;
        }
        if (wVar.e().urgeStatus.get() == 2) {
            QCircleToast.o(c.X1(), 0);
        } else if (bq.e("QFSPersonalRequestManager_sendPushMoreRequest", c.M2())) {
            QLog.d("QFSPersonalRequestManager", 1, "sendPushMoreRequest is exceed limit");
            QCircleToast.o(h.a(R.string.f1908943b), 0);
        } else {
            QFSDoUrgeRequest a16 = new QFSDoUrgeRequest.a(wVar.L(), i3).a();
            com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(a16).m250setRspOnCallBack((Call.OnRspCallBack) new a(a16, "QFSPersonalRequestManager_sendPushMoreRequest")).execute();
        }
    }
}
