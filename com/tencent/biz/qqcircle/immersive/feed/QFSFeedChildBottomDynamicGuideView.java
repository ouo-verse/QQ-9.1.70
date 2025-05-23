package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.events.QFSCommentHintTextEvent;
import com.tencent.biz.qqcircle.events.QFSLayerPageDecorationPopupEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.biz.qqcircle.immersive.model.feeds.QFSFeedYuHengModel;
import com.tencent.biz.qqcircle.requests.QFSGetDecorationRequest;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StActivityInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StYuHengMaterialInfo;
import feedcloud.FeedCloudRead$GetDecorationRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$AdPlacementInfo;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedChildBottomDynamicGuideView extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements View.OnClickListener, Observer<com.tencent.biz.qqcircle.immersive.personal.data.w>, SimpleEventReceiver {

    @ColorInt
    private static final int T = Color.parseColor("#1AFFFFFF");

    @ColorInt
    private static final int U = Color.parseColor("#FF0099FF");

    @ColorInt
    private static final int V = Color.parseColor("#FF5F89FF");

    @ColorInt
    private static final int W = Color.parseColor("#FFC7C7C7");

    @ColorInt
    private static final int X = Color.parseColor("#FFFFFFFF");
    private w50.a D;
    private boolean E;
    private View F;
    private TextView G;
    private View H;
    private View I;
    private ChangePublishLayoutStyleActionTask J;
    private ImageView K;
    private QCircleAsyncTextView L;
    private com.tencent.biz.qqcircle.immersive.personal.data.w M;
    private int N;
    private FeedCloudRead$GetDecorationRsp P;
    private String Q;
    private final v50.a R;
    private final Runnable S;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static final class ChangePublishLayoutStyleActionTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSFeedChildBottomDynamicGuideView> f85046d;

        public ChangePublishLayoutStyleActionTask(QFSFeedChildBottomDynamicGuideView qFSFeedChildBottomDynamicGuideView) {
            this.f85046d = new WeakReference<>(qFSFeedChildBottomDynamicGuideView);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSFeedChildBottomDynamicGuideView qFSFeedChildBottomDynamicGuideView;
            WeakReference<QFSFeedChildBottomDynamicGuideView> weakReference = this.f85046d;
            if (weakReference == null) {
                qFSFeedChildBottomDynamicGuideView = null;
            } else {
                qFSFeedChildBottomDynamicGuideView = weakReference.get();
            }
            if (qFSFeedChildBottomDynamicGuideView != null) {
                qFSFeedChildBottomDynamicGuideView.G0();
            } else {
                QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[run] presenter == null.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f85047a;

        a(String str) {
            this.f85047a = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QFSFeedChildBottomDynamicGuideView.this.a0(this.f85047a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSFeedChildBottomDynamicGuideView.this.F.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QFSFeedChildBottomDynamicGuideView.this.G.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static final class d extends QFSAsyncUtils.Callback<FeedCloudMeta$StFeed, w50.a> {

        /* renamed from: a, reason: collision with root package name */
        private FeedCloudMeta$StFeed f85051a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<QFSFeedChildBottomDynamicGuideView> f85052b;

        public d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QFSFeedChildBottomDynamicGuideView qFSFeedChildBottomDynamicGuideView) {
            this.f85051a = feedCloudMeta$StFeed;
            this.f85052b = new WeakReference<>(qFSFeedChildBottomDynamicGuideView);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public w50.a doBackgroundAction(FeedCloudMeta$StFeed... feedCloudMeta$StFeedArr) {
            List<FeedCloudMeta$StYuHengMaterialInfo> list;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f85051a;
            if (feedCloudMeta$StFeed == null) {
                list = null;
            } else {
                list = feedCloudMeta$StFeed.yuhengMaterInfos.get();
            }
            return QFSFeedYuHengModel.a(list);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(w50.a aVar) {
            QFSFeedChildBottomDynamicGuideView qFSFeedChildBottomDynamicGuideView;
            WeakReference<QFSFeedChildBottomDynamicGuideView> weakReference = this.f85052b;
            if (weakReference == null) {
                qFSFeedChildBottomDynamicGuideView = null;
            } else {
                qFSFeedChildBottomDynamicGuideView = weakReference.get();
            }
            if (qFSFeedChildBottomDynamicGuideView == null) {
                QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[doMainAction] presenter == null.");
                return;
            }
            QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[doMainAction] updateDynamicGuideInfoToView bean =" + aVar);
            qFSFeedChildBottomDynamicGuideView.v0(aVar);
        }
    }

    public QFSFeedChildBottomDynamicGuideView(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.N = 0;
        this.R = new v50.a();
        this.S = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomDynamicGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (QFSFeedChildBottomDynamicGuideView.this.D != null) {
                    str = QFSFeedChildBottomDynamicGuideView.this.D.e();
                } else {
                    str = null;
                }
                QLog.d(QFSFeedChildBottomDynamicGuideView.this.m(), 1, "[autoShowHalfScreenWebPanel] runnable execute, url:" + str);
                r30.c.f430661a.i(QFSFeedChildBottomDynamicGuideView.this.j(), str, QFSFeedChildBottomDynamicGuideView.this.l(), Boolean.TRUE);
            }
        };
        this.J = new ChangePublishLayoutStyleActionTask(this);
    }

    private void A0() {
        I();
        C0();
        B0();
        u0(this.D);
    }

    private void B0() {
        if (this.F != null && this.G != null) {
            int i3 = U;
            int i16 = X;
            if (V() || X()) {
                i3 = T;
                i16 = W;
            }
            this.F.setAlpha(1.0f);
            this.F.setBackgroundColor(i3);
            this.G.setTextColor(i16);
        }
    }

    private void C0() {
        boolean z16;
        if (X() && V()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            J();
            t0(8);
        } else {
            t0(0);
        }
    }

    private void D0(String str, int i3) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FeedCloudMeta$StFeed e06 = e0();
        if (e06 == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = e06.poster;
        }
        if (feedCloudMeta$StUser != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null && TextUtils.equals(pBStringField.get(), str)) {
            feedCloudMeta$StUser.followState.set(i3);
            A0();
        }
    }

    private void E(Map<String, Object> map) {
        map.put("xsj_resource_type", 4);
        Pair<String, String> a16 = com.tencent.biz.qqcircle.wink.j.f93954a.a(this.D.e());
        map.put("xsj_material_type", a16.getFirst());
        map.put("xsj_material_id", a16.getSecond());
    }

    private void E0() {
        I();
        F0();
        x0(this.D);
    }

    private void F(final int i3, final int i16) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomDynamicGuideView.5
            @Override // java.lang.Runnable
            public void run() {
                if (((com.tencent.biz.qqcircle.immersive.views.banner.bottom.c) QFSFeedChildBottomDynamicGuideView.this).f90602e == null) {
                    return;
                }
                QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(((com.tencent.biz.qqcircle.immersive.views.banner.bottom.c) QFSFeedChildBottomDynamicGuideView.this).f90602e)).setActionType(i3).setSubActionType(i16));
            }
        });
    }

    private void F0() {
        com.tencent.biz.qqcircle.immersive.personal.data.w wVar;
        if (this.F != null && this.G != null && (wVar = this.M) != null) {
            int i3 = U;
            int i16 = X;
            if (wVar.B()) {
                i3 = T;
                i16 = W;
            }
            this.F.setAlpha(1.0f);
            this.F.setBackgroundColor(i3);
            this.G.setTextColor(i16);
        }
    }

    private void G() {
        QCircleInitBean qCircleInitBean;
        View view = this.f90604h;
        String str = null;
        if (view != null) {
            qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(view.getContext());
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean == null) {
            QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] fail, initBean is null");
            return;
        }
        if (!qCircleInitBean.isAutoShowPanel()) {
            QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] fail, not need auto show panel, initBean.hashCode:" + qCircleInitBean.hashCode());
            return;
        }
        String l3 = l();
        if (qCircleInitBean instanceof QCircleFolderBean) {
            QCircleFolderBean qCircleFolderBean = (QCircleFolderBean) qCircleInitBean;
            if (!TextUtils.equals(l3, qCircleFolderBean.getForcedInsertedFeedId())) {
                QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] fail, feedid not equals, curFeedId:" + l3 + ", forceInsertedFeedId:" + qCircleFolderBean.getForcedInsertedFeedId());
                return;
            }
        } else if (!TextUtils.equals(l3, qCircleInitBean.getFeedId())) {
            QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] fail, feedid not equals, curFeedId:" + l3 + ", feedId:" + qCircleInitBean.getFeedId());
            return;
        }
        w50.a aVar = this.D;
        if (aVar != null) {
            str = aVar.e();
        }
        QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] mDynamicJumpBean:" + this.D + ",url:" + str);
        String j3 = r30.c.f430661a.j(j(), str);
        if (TextUtils.isEmpty(j3)) {
            QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] h5Url is empty");
            return;
        }
        QLog.d(m(), 1, "[autoShowHalfScreenWebPanel] success, initBean.hashCode:" + qCircleInitBean.hashCode() + ", preload h5 url:" + j3);
        qCircleInitBean.setAutoShowPanel(false);
        n().removeCallbacks(this.S);
        n().postDelayed(this.S, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void G0() {
        ValueAnimator ofInt;
        w50.a aVar = this.D;
        if (aVar != null && this.F != null) {
            if (aVar.d() != null) {
                this.F.setAlpha(0.1f);
                if (this.D.d() instanceof NinePatchDrawable) {
                    ((NinePatchDrawable) this.D.d()).setTargetDensity(this.F.getResources().getDisplayMetrics());
                }
                this.F.setBackgroundDrawable(this.D.d());
                ofInt = ObjectAnimator.ofFloat(this.F, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f);
            } else {
                ofInt = ValueAnimator.ofInt(T, U);
                ofInt.setEvaluator(com.tencent.biz.qqcircle.immersive.utils.m.a());
                ofInt.addUpdateListener(new b());
            }
            ofInt.setDuration(500L);
            this.F.setTag(ofInt);
            ofInt.start();
            ValueAnimator ofInt2 = ValueAnimator.ofInt(W, X);
            ofInt2.setEvaluator(com.tencent.biz.qqcircle.immersive.utils.m.a());
            ofInt2.setDuration(500L);
            ofInt2.addUpdateListener(new c());
            this.G.setTag(ofInt2);
            ofInt2.start();
            this.E = true;
        }
    }

    private QFSCommentInfo H(boolean z16) {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.f90601d;
        qFSCommentInfo.mFeed = this.f90602e;
        qFSCommentInfo.mReportBean = p();
        qFSCommentInfo.mRelocationScrollType = 100;
        QCircleExtraTypeInfo k3 = k();
        qFSCommentInfo.mExtraTypeInfo = k3;
        k3.mDataPosition = this.f90603f;
        qFSCommentInfo.mIsShowEmotion = z16;
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mNeedShowAt = true;
        qFSCommentInfo.mActionBean = actionBean;
        return qFSCommentInfo;
    }

    private void H0() {
        w50.a aVar;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_dynamic_view_support_high_priority", true) || (aVar = this.D) == null) {
            return;
        }
        String e16 = aVar.e();
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        boolean c06 = c0(e16);
        QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[updateViewOrder] needHighPriority:" + c06);
        if (c06) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this, RFWOrderElementManager.OrderMode.FORCE_MODE);
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(getContextHashCode(), getGroup());
        }
    }

    @SuppressLint({"NewApi"})
    private void I() {
        if (this.F == null) {
            QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[cancelDynamicButtonAnimation] mDynamicButtonLayout is null");
            return;
        }
        J();
        if (this.F.getTag() instanceof ValueAnimator) {
            ((ValueAnimator) this.F.getTag()).cancel();
            ((ValueAnimator) this.F.getTag()).removeAllUpdateListeners();
            this.F.setTag(null);
        }
        if (this.G.getTag() instanceof ValueAnimator) {
            ((ValueAnimator) this.G.getTag()).cancel();
            ((ValueAnimator) this.G.getTag()).removeAllUpdateListeners();
            this.G.setTag(null);
        }
        l0();
    }

    private void I0(View view, int i3) {
        if (view != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private void J() {
        if (this.J == null) {
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.J);
    }

    private void K(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSFeedChildBottomDynamicGuideView", 1, "[checkPublishPermissionAndLauncherSchema] current url should not be null.");
            return;
        }
        String g16 = com.tencent.biz.qqcircle.utils.cy.g(str + "&xsj_camera_is_from_topic_edit_button=true", 4);
        View view = this.F;
        if (view != null) {
            com.tencent.biz.qqcircle.utils.z.b((Activity) view.getContext(), 2, new a(g16), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_PUBLISH_FEED), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        } else {
            a0(g16);
        }
    }

    private void L() {
        View view = this.H;
        if (view != null && this.I != null) {
            try {
                VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EXCON_COMMENT_FRAME);
                View view2 = this.H;
                EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
                VideoReport.setElementEndExposePolicy(view2, endExposurePolicy);
                VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_SYMBOL_AT);
                VideoReport.setElementEndExposePolicy(this.I, endExposurePolicy);
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[dtReportBindCommentView] error: ", th5);
            }
        }
    }

    private void M() {
        View view;
        if (this.f90601d != null && this.D != null && (view = this.F) != null) {
            try {
                VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_DYNAMIC_BTN_ACTION);
                VideoReport.setElementEndExposePolicy(this.F, EndExposurePolicy.REPORT_ALL);
                VideoReport.setElementReuseIdentifier(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_DYNAMIC_BTN_ACTION + this.f90601d.g().f398449id.get());
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put("xsj_feed_id", this.f90601d.g().f398449id.get());
                buildElementParams.put("xsj_url", this.D.e());
                QQCircleTianShu$AdItem L = com.tencent.biz.qqcircle.immersive.utils.r.L(this.f90601d.g(), 1038);
                if (L != null) {
                    buildElementParams.put("xsj_operation_activity_id", Integer.valueOf(L.iAdId.get()));
                }
                if (!TextUtils.isEmpty(this.Q)) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_ID, this.Q);
                }
                E(buildElementParams);
                VideoReport.setElementParams(this.F, buildElementParams);
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[dtReportBindViewData] error: ", th5);
            }
        }
    }

    private void N() {
        boolean z16;
        if (this.f90601d != null && this.D != null && this.F != null) {
            n0(102);
            try {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_DYNAMIC_BTN_ACTION);
                buildElementParams.put("xsj_feed_id", this.f90601d.g().f398449id.get());
                buildElementParams.put("xsj_url", this.D.e());
                if (!this.E) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COVER_IS_TRANSPARENT, Boolean.valueOf(z16));
                buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_DYNAMIC_BTN_ACTION);
                buildElementParams.put("xsj_custom_pgid", p().getDtPageId());
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                QQCircleTianShu$AdItem L = com.tencent.biz.qqcircle.immersive.utils.r.L(this.f90601d.g(), 1038);
                if (L != null) {
                    buildElementParams.put("xsj_operation_activity_id", Integer.valueOf(L.iAdId.get()));
                }
                if (this.P != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_ID, this.Q);
                }
                E(buildElementParams);
                VideoReport.reportEvent("ev_xsj_camera_action", this.F, buildElementParams);
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[dtReportCustomDynamicViewClick] error: ", th5);
            }
        }
    }

    private void O() {
        FeedCloudMeta$StActivityInfo feedCloudMeta$StActivityInfo;
        try {
            FeedCloudMeta$StFeed e06 = e0();
            if (e06 == null || (feedCloudMeta$StActivityInfo = e06.activityInfo) == null) {
                return;
            }
            String str = feedCloudMeta$StActivityInfo.activityValue.get();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String substring = str.substring(str.indexOf("#") + 1);
            this.Q = substring;
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            QLog.i("QFSFeedChildBottomDynamicGuideView", 1, "fetchDecorationDetailIfNeed ==>> decorationId:" + this.Q);
            VSNetworkHelper.getInstance().sendRequest(new QFSGetDecorationRequest(this.Q), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.feed.n
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    QFSFeedChildBottomDynamicGuideView.this.Z(baseRequest, z16, j3, str2, (FeedCloudRead$GetDecorationRsp) obj);
                }
            });
        } catch (Exception e16) {
            QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "fetchDecorationDetailIfNeed ==>> exception:", e16);
        }
    }

    private void P(QFSCommentHintTextEvent qFSCommentHintTextEvent) {
        View view = this.H;
        if (view != null && view.getVisibility() == 0 && this.f90602e != null && TextUtils.equals(qFSCommentHintTextEvent.getFeedId(), this.f90602e.f398449id.get())) {
            if (this.L != null && !TextUtils.isEmpty(qFSCommentHintTextEvent.getCommentText())) {
                this.L.setText(qFSCommentHintTextEvent.getCommentText());
            } else {
                r0(this.f90602e);
            }
        }
    }

    private boolean Q(Context context) {
        FeedCloudRead$GetDecorationRsp feedCloudRead$GetDecorationRsp = this.P;
        if (feedCloudRead$GetDecorationRsp == null) {
            return false;
        }
        if (feedCloudRead$GetDecorationRsp.jump_info.jumpType.get() == 1) {
            com.tencent.biz.qqcircle.launcher.c.g(context, this.P.jump_info.activityUrl.get());
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QFSLayerPageDecorationPopupEvent(this.P));
        }
        return true;
    }

    private void R(Context context) {
        if (this.D == null) {
            QLog.e("QFSFeedChildBottomDynamicGuideView", 2, "[enterSchemaLauncher] schema jump bean not is empty.");
            return;
        }
        if (Q(context)) {
            return;
        }
        String e16 = this.D.e();
        boolean g16 = this.D.g();
        boolean j3 = this.D.j();
        if (g16) {
            S();
            return;
        }
        if (j3) {
            U();
        } else if (Y(e16)) {
            K(e16);
        } else {
            a0(e16);
        }
    }

    private void S() {
        View view;
        I();
        FeedCloudMeta$StFeed e06 = e0();
        if (e06 != null && (view = this.f90604h) != null) {
            com.tencent.biz.qqcircle.immersive.utils.z.b(null, e06.poster, e06, QCirclePluginUtil.getQCircleInitBean(view.getContext()));
        } else {
            QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "do follow but feed is null");
        }
    }

    private void T(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.v vVar) {
        w50.a aVar = this.D;
        if (aVar != null && aVar.g()) {
            FeedCloudMeta$StUser a16 = vVar.a();
            if (a16 == null) {
                QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[handleFollowStateChangeEvent] user should not be null.");
                return;
            } else {
                D0(a16.f398463id.get(), a16.followState.get());
                return;
            }
        }
        QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[handleFollowStateChangeEvent] current not show follow button.");
    }

    private void U() {
        com.tencent.biz.qqcircle.immersive.personal.data.w wVar = this.M;
        if (wVar == null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.request.b.q(wVar);
    }

    private boolean V() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StFeed e06 = e0();
        if (e06 != null && (feedCloudMeta$StUser = e06.poster) != null && feedCloudMeta$StUser.followState.get() == 1) {
            return true;
        }
        return false;
    }

    private boolean W() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StFeed e06 = e0();
        if (e06 != null && (feedCloudMeta$StUser = e06.poster) != null && feedCloudMeta$StUser.followState.get() == 2) {
            return true;
        }
        return false;
    }

    private boolean X() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StFeed e06 = e0();
        if (e06 != null && (feedCloudMeta$StUser = e06.poster) != null && feedCloudMeta$StUser.followState.get() == 3) {
            return true;
        }
        return false;
    }

    private boolean Y(String str) {
        if (str != null && str.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$GetDecorationRsp feedCloudRead$GetDecorationRsp) {
        QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "QFSGetDecorationRequest onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if (z16 && j3 == 0 && feedCloudRead$GetDecorationRsp != null) {
            this.P = feedCloudRead$GetDecorationRsp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(String str) {
        if (fb0.a.a("QFSFeedChildBottomDynamicGuideView_launcherSchema")) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSFeedChildBottomDynamicGuideView", 1, "[launcherSchema] current url not is empty.");
            return;
        }
        if (this.F == null) {
            QLog.w("QFSFeedChildBottomDynamicGuideView", 1, "[launcherSchema] dynamic button layout.");
            return;
        }
        k0("[launcherSchema] launcher schema url: " + str);
        r30.c cVar = r30.c.f430661a;
        if (!TextUtils.isEmpty(cVar.j(this.F.getContext(), str))) {
            QLog.d(m(), 1, "[launcherSchema] open half screen web view");
            cVar.i(this.F.getContext(), str, l(), Boolean.FALSE);
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(this.F.getContext(), str);
        }
    }

    private void b0(@NonNull View view) {
        this.F = view.findViewById(R.id.f40221ds);
        this.G = (TextView) view.findViewById(R.id.f40231dt);
    }

    private boolean c0(String str) {
        HashMap<String, String> c16;
        if (TextUtils.isEmpty(str) || (c16 = com.tencent.biz.qqcircle.d.c(str)) == null) {
            return false;
        }
        if (!TextUtils.equals(c16.get(QCircleSchemeAttr.WebView.OPEN_TYPE), "half") && !TextUtils.equals(c16.get("high_priority"), "1")) {
            return false;
        }
        return true;
    }

    private String d0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return "null";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    private FeedCloudMeta$StFeed e0() {
        e30.b bVar = this.f90601d;
        if (bVar == null) {
            return null;
        }
        return bVar.g();
    }

    private void g0(boolean z16) {
        if (o() == null) {
            QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[openCommentAndInputPanel] feed ioc should not be null.");
        } else {
            o().onHandlerMessage("event_open_comment", H(z16));
        }
    }

    private void i0(e30.b bVar) {
        List<QQCircleTianShu$RspEntry> list = null;
        this.D = null;
        if (bVar != null && bVar.g() != null) {
            list = bVar.g().tianshuEntry.get();
        }
        if (list != null && list.size() > 0) {
            this.D = QFSFeedYuHengModel.b(list);
        }
    }

    private void j0() {
        if (this.J == null) {
            return;
        }
        J();
        RFWThreadManager.getUIHandler().postDelayed(this.J, 5000L);
    }

    private void k0(String str) {
        if (!QLog.isColorLevel() && !QLog.isDebugVersion()) {
            return;
        }
        QLog.d("QFSFeedChildBottomDynamicGuideView", 1, str);
    }

    @SuppressLint({"NewApi"})
    private void l0() {
        View view = this.F;
        if (view == null) {
            QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[resetLayoutStyle] mDynamicButtonLayout is null");
            return;
        }
        view.setAlpha(1.0f);
        this.F.setBackgroundColor(T);
        this.G.setTextColor(W);
        this.E = false;
    }

    private void m0(int i3) {
        String str;
        boolean z16;
        boolean z17;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        View view = this.F;
        boolean z18 = true;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view2 = this.H;
        if (view2 != null && view2.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            z18 = false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSBottomDynamicGuideEvent(str, i3, z18));
    }

    private boolean n0(int i3) {
        QQCircleTianShu$AdPlacementInfo qQCircleTianShu$AdPlacementInfo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.tianshuEntry.has()) {
            Iterator<QQCircleTianShu$RspEntry> it = this.f90602e.tianshuEntry.get().iterator();
            while (true) {
                if (it.hasNext()) {
                    QQCircleTianShu$RspEntry next = it.next();
                    if (next != null && next.key.get() == 1038) {
                        qQCircleTianShu$AdPlacementInfo = next.value;
                        break;
                    }
                } else {
                    qQCircleTianShu$AdPlacementInfo = null;
                    break;
                }
            }
            if (qQCircleTianShu$AdPlacementInfo != null && !qQCircleTianShu$AdPlacementInfo.lst.isEmpty()) {
                com.tencent.biz.qqcircle.immersive.utils.az.a(qQCircleTianShu$AdPlacementInfo.lst.get(), i3);
                return true;
            }
        }
        return false;
    }

    private void o0() {
        boolean z16;
        w50.a aVar = this.D;
        if (aVar != null) {
            aVar.o(null);
        }
        if (!V() && !X()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            J();
            t0(8);
        } else {
            j0();
        }
    }

    private void p0() {
        w50.a aVar = this.D;
        if (aVar == null) {
            QLog.i("QFSFeedChildBottomDynamicGuideView", 1, "[tryDynamicStyleDelayedChange] publish info should not be null.");
            return;
        }
        if (!aVar.i()) {
            QLog.i("QFSFeedChildBottomDynamicGuideView", 2, "[tryDynamicStyleDelayedChange] current not show button.");
            return;
        }
        if (this.D.g()) {
            o0();
        } else if (this.D.j()) {
            q0();
        } else {
            j0();
        }
    }

    private void q0() {
        if (this.M == null) {
            return;
        }
        w50.a aVar = this.D;
        if (aVar != null) {
            aVar.o(null);
        }
        if (this.M.B()) {
            J();
        } else {
            j0();
        }
    }

    private void r0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildBottomDynamicGuideView", 2, "[tryShowExternalComment]: feed is null");
            return;
        }
        View view = this.F;
        if (view != null && view.getVisibility() == 0) {
            y0(8);
            return;
        }
        PBRepeatField<Integer> pBRepeatField = feedCloudMeta$StFeed.opMask2;
        if (pBRepeatField != null && pBRepeatField.get().contains(16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.H == null) {
                View inflate = ((ViewStub) this.f90604h.findViewById(R.id.f40271dx)).inflate();
                this.H = inflate;
                inflate.setOnClickListener(this);
                View findViewById = this.H.findViewById(R.id.y2w);
                this.I = findViewById;
                findViewById.setOnClickListener(this);
                ImageView imageView = (ImageView) this.H.findViewById(R.id.ah5);
                this.K = imageView;
                imageView.setOnClickListener(this);
                QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) this.H.findViewById(R.id.f107856bj);
                this.L = qCircleAsyncTextView;
                qCircleAsyncTextView.setOnClickListener(this);
            }
            String G = QFSCommentHelper.L().G(feedCloudMeta$StFeed, null, null);
            if (!TextUtils.isEmpty(G)) {
                this.L.setText(G);
            } else if (!TextUtils.isEmpty(feedCloudMeta$StFeed.commentBoxDesc.get())) {
                this.L.setText(feedCloudMeta$StFeed.commentBoxDesc.get());
            }
            QLog.d("QFSFeedChildBottomDynamicGuideView", 2, "[tryShowExternalComment] show external comment feed_id: " + feedCloudMeta$StFeed.f398449id.get());
            y0(0);
            L();
            return;
        }
        y0(8);
    }

    private void s0() {
        if (this.D == null) {
            return;
        }
        t0(0);
        View view = this.F;
        if (view != null) {
            view.setOnClickListener(this);
        }
        l0();
        boolean g16 = this.D.g();
        boolean j3 = this.D.j();
        boolean h16 = this.D.h();
        if (g16) {
            u0(this.D);
        } else if (j3) {
            FeedCloudMeta$StFeed e06 = e0();
            if (e06 != null) {
                this.M = new com.tencent.biz.qqcircle.immersive.personal.data.w(e06.poster.f398463id.get());
                w20.a.j().observerGlobalState(this.M, this);
                this.M.K();
                if (!this.M.A()) {
                    this.M.e().urgeStatus.set(1);
                }
                x0(this.D);
            }
        } else if (h16) {
            w0(this.D.f());
            F(502, 1);
        }
        M();
    }

    private void t0(int i3) {
        I0(this.F, i3);
        m0(QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE);
    }

    private void u0(w50.a aVar) {
        if (aVar == null) {
            return;
        }
        if (W()) {
            aVar.u("\u56de\u5173");
        } else if (!V() && !X()) {
            aVar.u("\u5173\u6ce8");
        } else {
            aVar.u("\u5df2\u5173\u6ce8");
        }
        w0(aVar.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(w50.a aVar) {
        if (aVar != null && aVar.i()) {
            this.D = aVar;
        } else {
            QLog.e("QFSFeedChildBottomDynamicGuideView", 1, "[updateDynamicGuideInfoToView] bean should not be null.");
        }
    }

    private void w0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSFeedChildBottomDynamicGuideView", 2, "[updateDynamicGuideText] current text is empty, set text fail.");
            return;
        }
        k0("[updateDynamicGuideText] text: " + str);
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void x0(w50.a aVar) {
        com.tencent.biz.qqcircle.immersive.personal.data.w wVar;
        if (aVar != null && (wVar = this.M) != null) {
            if (wVar.B()) {
                aVar.u(aVar.a());
            } else {
                aVar.u(aVar.b());
            }
            w0(aVar.f());
        }
    }

    private void y0(int i3) {
        I0(this.H, i3);
        m0(QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE);
    }

    private void z0() {
        if (this.D == null) {
            QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[updateFeedBottomDynamicViewShown] mDynamicJumpBean is null");
            return;
        }
        QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[updateFeedBottomDynamicViewShown] mDynamicJumpBean isShowButton =" + this.D.i() + "\uff0cmFeed id = " + d0());
        if (this.D.i()) {
            O();
            if (this.D.h() && this.R.a()) {
                QLog.i("QFSFeedChildBottomDynamicGuideView", 1, "isIsDefaultButton, needHideBottomYuHengBanner");
            } else {
                s0();
                p0();
            }
        } else {
            t0(8);
        }
        r0(this.f90602e);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        w50.a aVar = this.D;
        if (aVar != null && aVar.i() && (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.v)) {
            T((com.tencent.biz.qqcircle.immersive.feed.event.v) hVar);
            r0(this.f90602e);
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void onChanged(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        com.tencent.biz.qqcircle.immersive.personal.data.w wVar2;
        if (this.D != null && (wVar2 = this.M) != null && wVar != null && TextUtils.equals(wVar2.L(), wVar.L())) {
            if (!wVar.A()) {
                int i3 = this.N;
                if (i3 == 0) {
                    i3 = 1;
                }
                wVar.e().urgeStatus.set(i3);
            }
            this.M = wVar;
            int i16 = wVar.e().urgeStatus.get();
            this.N = i16;
            if (i16 == 2) {
                E0();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void g() {
        super.g();
        n().removeCallbacks(this.S);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSCommentHintTextEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 103;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        if (bVar == null) {
            return;
        }
        i0(bVar);
        QLog.d("QFSFeedChildBottomDynamicGuideView", 1, "[onBindData] mFeed id = " + d0());
        QFSAsyncUtils.executeSerial(new d(bVar.g(), this), new FeedCloudMeta$StFeed[0]);
        this.R.c(bVar.g(), i3, "QFSFeedChildBottomDynamicGuideView");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void i() {
        super.i();
        this.R.d();
        G();
        H0();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBRepeatField<Integer> pBRepeatField;
        w50.a aVar = this.D;
        if ((aVar != null && aVar.i()) || ((feedCloudMeta$StFeed = this.f90602e) != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && pBRepeatField.get().contains(16))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public String m() {
        return "QFSFeedChildBottomDynamicGuideView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == null) {
            QLog.w("QFSFeedChildBottomDynamicGuideView", 1, "[onClick] view obj should not be null.");
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f40221ds) {
                R(view.getContext());
                N();
                F(502, 2);
            } else if (id5 != R.id.f40271dx && id5 != R.id.f107856bj) {
                if (id5 == R.id.y2w) {
                    if (!fb0.a.a("externalCommentAt")) {
                        g0(false);
                    }
                } else if (id5 == R.id.ah5 && !fb0.a.a("externalCommentEmotion")) {
                    g0(true);
                }
            } else {
                g0(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        b0(this.f90604h);
        z0();
        n0(101);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        t0(8);
        y0(8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSCommentHintTextEvent) {
            P((QFSCommentHintTextEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        if (this.D == null) {
            QLog.i("QFSFeedChildBottomDynamicGuideView", 1, "[onDetached] publisher info not be null.");
            return;
        }
        k0("[onDetached], pos: " + this.f90603f);
        if (this.D.i()) {
            I();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
