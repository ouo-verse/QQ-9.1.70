package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDoCollectRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoCollectRsp;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bk extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b> {
    private static final boolean Q;
    private static boolean R;
    private static String S;
    private FeedCloudMeta$StFeed I;
    protected LottieAnimationView J;
    private TextView K;
    private boolean L = false;
    private boolean M = false;
    private boolean N;
    private e30.b P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoCollectRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSDoCollectRequest f86031a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f86032b;

        b(QFSDoCollectRequest qFSDoCollectRequest, boolean z16) {
            this.f86031a = qFSDoCollectRequest;
            this.f86032b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoCollectRsp feedCloudWrite$StDoCollectRsp) {
            bk.this.N = false;
            QLog.i(bk.this.getTAG(), 1, "traceId:" + this.f86031a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " msg:" + str);
            if (z16 && j3 == 0) {
                if (this.f86032b) {
                    bk.this.I.opMask2.get().add(25);
                    if (bk.this.I.collection.count.has()) {
                        bk.this.I.collection.count.set(bk.this.I.collection.count.get() + 1);
                    }
                } else {
                    bk.this.I.opMask2.get().remove((Object) 25);
                    if (bk.this.I.collection.count.has()) {
                        bk.this.I.collection.count.set(bk.this.I.collection.count.get() - 1);
                    }
                }
                bk bkVar = bk.this;
                bkVar.z1(bkVar.I, false);
                QFSCollectedFeedEvent qFSCollectedFeedEvent = new QFSCollectedFeedEvent(bk.this.I.f398449id.get(), this.f86032b);
                qFSCollectedFeedEvent.setFeed(bk.this.I);
                qFSCollectedFeedEvent.setHasCollectBox(feedCloudWrite$StDoCollectRsp.hasFavorites.get());
                SimpleEventBus.getInstance().dispatchEvent(qFSCollectedFeedEvent);
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(QCircleCommonUtil.getCurrentAccount());
                wVar.K();
                wVar.N(this.f86032b);
                wVar.R();
                w20.a.j().initOrUpdateGlobalState((w20.a) new e30.b(bk.this.I), true);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473);
            }
            QCircleToast.o(str, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<bk> f86034a;

        c(bk bkVar) {
            this.f86034a = new WeakReference<>(bkVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            bk bkVar = this.f86034a.get();
            if (bkVar == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_feed_id", ((FeedCloudMeta$StFeed) bkVar.f85017h).f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, ((FeedCloudMeta$StFeed) bkVar.f85017h).poster.f398463id.get());
            if (bkVar.J.isSelected()) {
                str2 = QCircleDaTongConstant.ElementParamValue.COLLECT;
            } else {
                str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
            }
            buildElementParams.put("xsj_action_type", str2);
            return buildElementParams;
        }
    }

    static {
        boolean z16;
        if (DisplayUtil.getInstantScreenHeight(RFWApplication.getApplication()) >= DisplayUtil.dip2px(RFWApplication.getApplication(), 696.0f)) {
            z16 = true;
        } else {
            z16 = false;
        }
        Q = z16;
    }

    private void A1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StFeed2 = this.I) != null) {
            feedCloudMeta$StFeed2.collection.count.set(feedCloudMeta$StFeed.collection.count.get());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n1() {
        VideoReport.setElementId(this.J, "em_xsj_collect_button");
        VideoReport.setElementReuseIdentifier(this.J, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        VideoReport.setElementExposePolicy(this.J, ExposurePolicy.REPORT_ALL);
        VideoReport.setEventDynamicParams(this.J, new c(this));
    }

    public static boolean o1() {
        boolean z16;
        boolean z17;
        p1();
        if (PadUtil.a(RFWApplication.getApplication()) == DeviceType.PHONE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (R && Q && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QFSFeedChildRightCollectPresenter", 1, "[enableRightCollect] result = ", Boolean.valueOf(z17), ", sEnableRightCollect =", Boolean.valueOf(R), ", isBigScreenHeightDevice =", Boolean.valueOf(Q), ", isPhone =", Boolean.valueOf(z16));
        return z17;
    }

    private static void p1() {
        String q16 = com.tencent.biz.qqcircle.immersive.utils.r.q();
        if (!TextUtils.equals(S, q16) || TextUtils.isEmpty(S)) {
            R = uq3.c.g0();
            S = q16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s1() {
        uq3.k.a().j("qfs_has_show_colloect_tips", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        LottieAnimationView lottieAnimationView = this.J;
        if (lottieAnimationView == null) {
            return;
        }
        int dimensionPixelSize = lottieAnimationView.getResources().getDimensionPixelSize(R.dimen.d1q);
        this.J.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    private void x1(boolean z16) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.N = true;
        QFSDoCollectRequest a16 = new QFSDoCollectRequest.a(feedCloudMeta$StFeed).f(!z16 ? 1 : 0).a();
        VSNetworkHelper.getInstance().sendRequest(a16, new b(a16, z16));
    }

    private void y1(int i3) {
        if (!uq3.k.a().c("qfs_has_show_colloect_tips", false) && i3 >= 2) {
            mc0.a.d(m0(), com.tencent.biz.qqcircle.utils.h.a(R.string.f19046426)).setPosition(2).setAlignment(0).setAnchor(this.J).setDismissInterval(4000L).addStatusCallback(new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.bj
                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onClick(View view) {
                    a04.d.a(this, view);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onDismiss() {
                    a04.d.b(this);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public final void onShow() {
                    bk.s1();
                }
            });
            return;
        }
        QLog.d("QFSFeedChildRightCollectPresenter", 2, "[showTips] pos = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        int q16;
        int i3;
        if (this.K == null) {
            QLog.d(getTAG(), 1, "[updateFeedLike] video collect text should not be null.");
            return;
        }
        if (this.J == null) {
            QLog.d(getTAG(), 1, "[updateFeedLike] mCollectImg should not be null.");
            return;
        }
        int i16 = feedCloudMeta$StFeed.collection.count.get();
        if (i16 > 0 && feedCloudMeta$StFeed.collection.count.has()) {
            TextView textView = this.K;
            long j3 = i16;
            if (this.M) {
                i3 = 12;
            } else {
                i3 = 11;
            }
            textView.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(j3, i3));
            this.J.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f187783ux) + ((Object) this.K.getText()));
        } else {
            this.K.setText(R.string.f19305496);
            this.J.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f19305496));
        }
        boolean contains = feedCloudMeta$StFeed.opMask2.get().contains(25);
        this.L = contains;
        if (z16) {
            LottieAnimationView lottieAnimationView = this.J;
            if (contains) {
                q16 = com.tencent.biz.qqcircle.k.b();
            } else {
                q16 = com.tencent.biz.qqcircle.k.q();
            }
            lottieAnimationView.setImageResource(q16);
            LottieCompositionFactory.fromUrl(m0(), "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_icon_animation_interact_collection_lo.json");
            LottieCompositionFactory.fromUrl(m0(), "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_icon_animation_interact_cancel_collection_lo.json");
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 1, "[updateFeedCollect] is isCollected: ", Boolean.valueOf(this.L));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return o1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        q1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isFullVideo()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.M = z16;
        y1(rFWFeedSelectInfo.getPosition());
        this.N = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isFullVideo()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.M = z16;
        w1();
    }

    public void q1(@NonNull View view) {
        View findViewById = view.findViewById(R.id.f41331gs);
        findViewById.setVisibility(0);
        this.J = (LottieAnimationView) findViewById.findViewById(R.id.f40071dd);
        this.K = (TextView) findViewById.findViewById(R.id.f40081de);
        this.J.addAnimatorListener(new a());
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bk.this.r1(view2);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d(getTAG(), 1, "[onBindData] data should not be null.");
            return;
        }
        z1(feedCloudMeta$StFeed, true);
        this.I = feedCloudMeta$StFeed;
        this.P = new e30.b(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.P, this);
        n1();
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (this.J != null && bVar != null && bVar.g() != null && (feedCloudMeta$StFeed = this.I) != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), bVar.g().f398449id.get())) {
            z1(bVar.g(), !this.J.isAnimating());
            A1(bVar.g());
        }
    }

    public void v1() {
        String str;
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSFeedChildRightCollectPresenter", 1, "[onCollectClick] forbid collect feed because of sencebeat");
            return;
        }
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(this.I, 6)) {
            QLog.d(getTAG(), 1, "onCollectClick: guild feed forbid interact");
            return;
        }
        if (fb0.a.a(getTAG())) {
            QLog.d(getTAG(), 1, "[onCollectClick] return: fastDoubleClick");
            return;
        }
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.h(R.string.ci8, 0);
            return;
        }
        if (this.N) {
            QLog.d(getTAG(), 1, "[onCollectClick] isRequesting...");
            QCircleToast.h(R.string.f189283yz, 0);
            return;
        }
        boolean z16 = !this.L;
        QLog.d(getTAG(), 1, "[sendRequest] request collect state: ", Boolean.valueOf(z16));
        LottieAnimationView lottieAnimationView = this.J;
        if (z16) {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_icon_animation_interact_collection_lo.json";
        } else {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_icon_animation_interact_cancel_collection_lo.json";
        }
        lottieAnimationView.setAnimationFromUrl(str);
        this.J.playAnimation();
        x1(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildRightCollectPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int q16;
            bk.this.w1();
            bk bkVar = bk.this;
            LottieAnimationView lottieAnimationView = bkVar.J;
            if (bkVar.L) {
                q16 = com.tencent.biz.qqcircle.k.b();
            } else {
                q16 = com.tencent.biz.qqcircle.k.q();
            }
            lottieAnimationView.setImageResource(q16);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            bk.this.J.setPadding(0, 0, 0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
