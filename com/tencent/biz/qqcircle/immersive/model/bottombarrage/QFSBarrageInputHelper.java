package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSBottomBarrageHintTextEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputPopupWindow;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBarrageInputHelper {

    /* renamed from: g, reason: collision with root package name */
    private static final int f87250g = uq3.c.M0();

    /* renamed from: h, reason: collision with root package name */
    private static volatile QFSBarrageInputHelper f87251h;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<e> f87253b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<QFSBarrageInputPopupWindow> f87254c;

    /* renamed from: e, reason: collision with root package name */
    private String f87256e;

    /* renamed from: f, reason: collision with root package name */
    private long f87257f;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f87252a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private long f87255d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSBaseInputPopupWindow.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f87263a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f87264b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QFSBarrageInputPopupWindow f87265c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.model.bottombarrage.c f87266d;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Activity activity, QFSBarrageInputPopupWindow qFSBarrageInputPopupWindow, com.tencent.biz.qqcircle.immersive.model.bottombarrage.c cVar) {
            this.f87263a = feedCloudMeta$StFeed;
            this.f87264b = activity;
            this.f87265c = qFSBarrageInputPopupWindow;
            this.f87266d = cVar;
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
        public void a() {
            e eVar;
            QLog.d("QDM-QFSBarrageInputHelper", 1, "onClickSend()");
            QFSBarrageInputHelper.this.k(this.f87263a);
            if (!QCircleBindPhoneNumberHelper.a()) {
                QCircleBindPhoneNumberHelper.b(this.f87264b, 4);
                return;
            }
            if (this.f87264b.isFinishing()) {
                QLog.d("QDM-QFSBarrageInputHelper", 1, "onBarrageSend(): mBarrageInputPopupWindow null");
                return;
            }
            String j06 = this.f87265c.j0();
            if (TextUtils.isEmpty(j06.trim())) {
                QCircleToast.o(this.f87264b.getString(R.string.f1902341j), 0);
                return;
            }
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QCircleToast.j(QCircleToast.f91645e, this.f87264b.getString(R.string.f181603e8), 0);
                this.f87265c.dismiss();
                return;
            }
            if (QFSBarrageInputHelper.this.f87255d != -1) {
                QFSBarrageInputHelper qFSBarrageInputHelper = QFSBarrageInputHelper.this;
                if (qFSBarrageInputHelper.t(qFSBarrageInputHelper.f87255d)) {
                    QCircleToast.j(QCircleToast.f91645e, this.f87264b.getString(R.string.f1902441k), 0);
                    this.f87265c.dismiss();
                    return;
                }
            }
            if (this.f87263a == null) {
                QLog.e("QDM-QFSBarrageInputHelper", 1, "feed is null");
                return;
            }
            if (QFSBarrageInputHelper.this.f87253b != null) {
                eVar = (e) QFSBarrageInputHelper.this.f87253b.get();
            } else {
                eVar = null;
            }
            FeedCloudMeta$StBarrage feedCloudMeta$StBarrage = new FeedCloudMeta$StBarrage();
            feedCloudMeta$StBarrage.f398446id.set("fakeId_" + System.currentTimeMillis());
            feedCloudMeta$StBarrage.content.set(j06);
            feedCloudMeta$StBarrage.createTime.set((long) ((int) (System.currentTimeMillis() / 1000)));
            feedCloudMeta$StBarrage.postUser.set(QCirclePluginGlobalInfo.m());
            if (eVar != null) {
                QLog.d("QDM-QFSBarrageInputHelper", 1, "addFakeBarrage barrageInputListener callback success");
                eVar.b(feedCloudMeta$StBarrage);
            } else {
                QLog.e("QDM-QFSBarrageInputHelper", 1, "addFakeBarrage barrageInputListener null");
            }
            this.f87265c.C0("");
            this.f87265c.dismiss();
            QFSBarrageInputHelper.this.u(this.f87263a);
            QFSBarrageInputHelper.this.f87255d = SystemClock.elapsedRealtime();
            QFSBarrageInputHelper.this.v(84, 3, this.f87263a, this.f87266d.f(), j06);
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.b
        public /* synthetic */ void b() {
            com.tencent.biz.qqcircle.comment.c.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSBarrageInputPopupWindow.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f87268a;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f87268a = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputPopupWindow.d
        public void a(View view) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.f87268a));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PLAY_SETTING_BUTTON_STATE, Integer.valueOf(com.tencent.biz.qqcircle.manager.d.b().d() ? 1 : 0));
            buildElementParams.put("dt_pgid", QFSBarrageInputHelper.this.f87256e);
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_SETTING_BUTTON);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("dt_clck", view, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f87270d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSBarrageInputPopupWindow f87271e;

        c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSBarrageInputPopupWindow qFSBarrageInputPopupWindow) {
            this.f87270d = feedCloudMeta$StFeed;
            this.f87271e = qFSBarrageInputPopupWindow;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            String str;
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f87270d;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(11, str, true));
            String o16 = QFSBarrageInputHelper.this.o(this.f87270d);
            if (o16 != null) {
                this.f87271e.C0(o16);
            } else {
                this.f87271e.C0("");
            }
            this.f87271e.I = true;
            QFSBarrageInputHelper.this.l(this.f87270d, null);
            QFSBarrageInputHelper.this.f87257f = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements QFSBaseInputPopupWindow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f87273a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSBarrageInputPopupWindow f87274b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f87275c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f87276d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f87277e;

        d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSBarrageInputPopupWindow qFSBarrageInputPopupWindow, String str, e eVar, int i3) {
            this.f87273a = feedCloudMeta$StFeed;
            this.f87274b = qFSBarrageInputPopupWindow;
            this.f87275c = str;
            this.f87276d = eVar;
            this.f87277e = i3;
        }

        @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow.c
        public void onDismiss() {
            String str;
            if (!r.F0()) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f87273a;
                if (feedCloudMeta$StFeed == null) {
                    str = "";
                } else {
                    str = feedCloudMeta$StFeed.f398449id.get();
                }
                simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(11, str, false));
            }
            String j06 = this.f87274b.j0();
            QFSBarrageInputHelper.this.z(this.f87273a, j06);
            this.f87274b.C0("");
            this.f87274b.y0(QFSBarrageInputHelper.this.q(this.f87275c));
            SimpleEventBus.getInstance().dispatchEvent(new QFSBottomBarrageHintTextEvent(this.f87273a, j06));
            e eVar = this.f87276d;
            if (eVar != null) {
                eVar.a(this.f87277e);
            }
            long currentTimeMillis = System.currentTimeMillis() - QFSBarrageInputHelper.this.f87257f;
            RFWLog.d("QDM-QFSBarrageInputHelper", RFWLog.USR, "onDismiss time:" + currentTimeMillis + ",mInputShowTime:" + QFSBarrageInputHelper.this.f87257f);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_EM_LVTM, String.valueOf(currentTimeMillis));
            QFSBarrageInputHelper.this.l(this.f87273a, hashMap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface e {
        void a(int i3);

        void b(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage);
    }

    QFSBarrageInputHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.e(feedCloudMeta$StFeed));
        buildElementParams.put("xsj_action_type", "ev_xsj_abnormal_clck");
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_PUBLISH_BUTTON);
        buildElementParams.put("xsj_custom_pgid", this.f87256e);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        buildElementParams.putAll(ua0.c.e(feedCloudMeta$StFeed));
        buildElementParams.put("xsj_action_type", "ev_xsj_abnormal_imp");
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_BULLET_SCREEN_PUBLISH_BUTTON);
        buildElementParams.put("xsj_custom_pgid", this.f87256e);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private String m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        } else {
            str = "";
        }
        return n(str);
    }

    private String n(String str) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        } else {
            sb5.append("0");
        }
        return sb5.toString();
    }

    public static QFSBarrageInputHelper r() {
        if (f87251h == null) {
            synchronized (QFSBarrageInputHelper.class) {
                if (f87251h == null) {
                    f87251h = new QFSBarrageInputHelper();
                }
            }
        }
        return f87251h;
    }

    private void s(QFSBarrageInputPopupWindow qFSBarrageInputPopupWindow, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, e eVar, int i3, String str) {
        if (qFSBarrageInputPopupWindow == null) {
            return;
        }
        qFSBarrageInputPopupWindow.setOnShowListener(new c(feedCloudMeta$StFeed, qFSBarrageInputPopupWindow));
        qFSBarrageInputPopupWindow.B0(new d(feedCloudMeta$StFeed, qFSBarrageInputPopupWindow, str, eVar, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(long j3) {
        if (SystemClock.elapsedRealtime() - j3 <= f87250g) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final int i3, final int i16, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final long j3, final String str) {
        if (feedCloudMeta$StFeed != null && j3 >= 0) {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed)).setActionType(i3).setSubActionType(i16).setActTime(System.currentTimeMillis()).setVideoPlayTime(j3).setSealTransfer(feedCloudMeta$StFeed.recomInfo.recomTrace.get()).setExt1(str));
                }
            });
            return;
        }
        QLog.e("QCircleReportHelper_QDM-QFSBarrageInputHelper", 1, "lost feed, actionType:" + i3 + ",subActionType:" + i16 + ",videoPlayTime:" + j3);
    }

    public void A(String str, String str2) {
        this.f87252a.put(str, str2);
    }

    public String o(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String m3 = m(feedCloudMeta$StFeed);
        if (this.f87252a.containsKey(m3)) {
            return this.f87252a.get(m3);
        }
        return "";
    }

    public QFSBarrageInputPopupWindow p() {
        WeakReference<QFSBarrageInputPopupWindow> weakReference = this.f87254c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String q(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return QCircleApplication.APP.getResources().getString(R.string.f1902541l);
    }

    public void u(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f87252a.remove(m(feedCloudMeta$StFeed));
        if (feedCloudMeta$StFeed != null) {
            this.f87252a.remove(feedCloudMeta$StFeed.f398449id.get());
        }
    }

    public void w(String str) {
        this.f87256e = str;
    }

    public void x(Activity activity, com.tencent.biz.qqcircle.immersive.model.bottombarrage.c cVar, e eVar) {
        y(activity, cVar, eVar, 100);
    }

    public void y(Activity activity, com.tencent.biz.qqcircle.immersive.model.bottombarrage.c cVar, e eVar, int i3) {
        if (activity != null && cVar != null && !fb0.a.b("QDM-QFSBarrageInputHelper", 500L)) {
            FeedCloudMeta$StFeed b16 = cVar.b();
            FeedCloudMeta$StBarrage a16 = cVar.a();
            QFSBarrageInputPopupWindow qFSBarrageInputPopupWindow = new QFSBarrageInputPopupWindow(activity, cVar.e());
            this.f87254c = new WeakReference<>(qFSBarrageInputPopupWindow);
            this.f87253b = new WeakReference<>(eVar);
            qFSBarrageInputPopupWindow.y0(q(cVar.c()));
            qFSBarrageInputPopupWindow.z0(new a(b16, activity, qFSBarrageInputPopupWindow, cVar));
            qFSBarrageInputPopupWindow.l1(new b(b16));
            s(qFSBarrageInputPopupWindow, b16, a16, eVar, i3, cVar.c());
            qFSBarrageInputPopupWindow.getWindow().setSoftInputMode(4);
            qFSBarrageInputPopupWindow.m1(b16, cVar.d());
            return;
        }
        QLog.e("QDM-QFSBarrageInputHelper", 1, "showInputPopupWindow param error");
    }

    public void z(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        A(m(feedCloudMeta$StFeed), str);
    }
}
