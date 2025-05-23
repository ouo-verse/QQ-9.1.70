package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDoCollectRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoCollectRsp;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cp extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private LottieAnimationView I;
    private boolean J = false;
    private boolean K;
    private e30.b L;
    private com.tencent.biz.qqcircle.immersive.personal.data.w M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoCollectRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSDoCollectRequest f86073a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f86074b;

        b(QFSDoCollectRequest qFSDoCollectRequest, boolean z16) {
            this.f86073a = qFSDoCollectRequest;
            this.f86074b = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoCollectRsp feedCloudWrite$StDoCollectRsp) {
            cp.this.K = false;
            QLog.i(cp.this.getTAG(), 1, "traceId:" + this.f86073a.getTraceId() + " isSuccess:" + z16 + " errorCode:" + j3 + " msg:" + str);
            if (z16 && j3 == 0) {
                if (this.f86074b) {
                    ((FeedCloudMeta$StFeed) cp.this.f85017h).opMask2.get().add(25);
                    if (((FeedCloudMeta$StFeed) cp.this.f85017h).collection.count.has()) {
                        T t16 = cp.this.f85017h;
                        ((FeedCloudMeta$StFeed) t16).collection.count.set(((FeedCloudMeta$StFeed) t16).collection.count.get() + 1);
                    }
                    QCircleToast.h(R.string.f188753xj, 0);
                } else {
                    ((FeedCloudMeta$StFeed) cp.this.f85017h).opMask2.get().remove((Object) 25);
                    if (((FeedCloudMeta$StFeed) cp.this.f85017h).collection.count.has()) {
                        T t17 = cp.this.f85017h;
                        ((FeedCloudMeta$StFeed) t17).collection.count.set(((FeedCloudMeta$StFeed) t17).collection.count.get() - 1);
                    }
                }
                cp.this.A1(false);
                QFSCollectedFeedEvent qFSCollectedFeedEvent = new QFSCollectedFeedEvent(((FeedCloudMeta$StFeed) cp.this.f85017h).f398449id.get(), this.f86074b);
                qFSCollectedFeedEvent.setFeed((FeedCloudMeta$StFeed) cp.this.f85017h);
                qFSCollectedFeedEvent.setHasCollectBox(feedCloudWrite$StDoCollectRsp.hasFavorites.get());
                qFSCollectedFeedEvent.setShowGoWatchBanner(false);
                SimpleEventBus.getInstance().dispatchEvent(qFSCollectedFeedEvent);
                cp.this.M = new com.tencent.biz.qqcircle.immersive.personal.data.w(QCircleCommonUtil.getCurrentAccount());
                cp.this.M.K();
                cp.this.M.N(this.f86074b);
                cp.this.M.R();
                cp cpVar = cp.this;
                cpVar.L = new e30.b((FeedCloudMeta$StFeed) cpVar.f85017h);
                w20.a.j().initOrUpdateGlobalState((w20.a) cp.this.L, true);
                cp.this.s1();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473);
            }
            QCircleToast.o(str, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void A1(boolean z16) {
        int q16;
        T t16 = this.f85017h;
        if (t16 != 0 && this.I != null) {
            boolean contains = ((FeedCloudMeta$StFeed) t16).opMask2.get().contains(25);
            this.J = contains;
            if (z16) {
                LottieAnimationView lottieAnimationView = this.I;
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
                QLog.d(getTAG(), 1, "[updateFeedCollect] isCollected: " + this.J);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void s1() {
        String str;
        String str2;
        VideoReport.setElementId(this.I, "em_xsj_collect_button");
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_eid", "em_xsj_collect_button");
        T t16 = this.f85017h;
        String str3 = "";
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        hashMap.put("xsj_feed_id", str);
        T t17 = this.f85017h;
        if (t17 != 0) {
            str3 = ((FeedCloudMeta$StFeed) t17).poster.f398463id.get();
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str3);
        if (this.J) {
            str2 = QCircleDaTongConstant.ElementParamValue.COLLECT;
        } else {
            str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
        }
        hashMap.put("xsj_action_type", str2);
        i0(this.I, QCircleDaTongConstant.EventId.EV_XSJ_COLLECT, hashMap);
    }

    private void t1() {
        View view = this.C;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.f42431jr);
        this.I = (LottieAnimationView) this.C.findViewById(R.id.f42421jq);
        findViewById.setVisibility(0);
        this.I.addAnimatorListener(new a());
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.cn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                cp.this.u1(view2);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.co
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                cp.this.v1(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        x1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.I.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x1() {
        String str;
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSFullScreenCollectPresenter", 1, "[onCollectClick] forbid collect feed because of sencebeat");
            return;
        }
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed((FeedCloudMeta$StFeed) this.f85017h, 6)) {
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
        if (this.K) {
            QLog.d(getTAG(), 1, "[onCollectClick] isRequesting...");
            QCircleToast.h(R.string.f189283yz, 0);
            return;
        }
        boolean z16 = !this.J;
        QLog.d(getTAG(), 1, "[sendRequest] request collect state: ", Boolean.valueOf(z16));
        LottieAnimationView lottieAnimationView = this.I;
        if (z16) {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_icon_animation_interact_collection_lo.json";
        } else {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_icon_animation_interact_cancel_collection_lo.json";
        }
        lottieAnimationView.setAnimationFromUrl(str);
        this.I.playAnimation();
        z1(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        if (this.I == null) {
            return;
        }
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(4.0f);
        this.I.setPadding(a16, a16, a16, a16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z1(boolean z16) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return;
        }
        this.K = true;
        QFSDoCollectRequest a16 = new QFSDoCollectRequest.a((FeedCloudMeta$StFeed) t16).f(!z16 ? 1 : 0).a();
        VSNetworkHelper.getInstance().sendRequest(a16, new b(a16, z16));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        t1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.K = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        y1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenCollectPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        A1(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            int q16;
            cp.this.y1();
            QLog.d("QFSFullScreenCollectPresenter", 1, "[onAnimationCancel] animation cancel, isCollected: " + cp.this.J);
            LottieAnimationView lottieAnimationView = cp.this.I;
            if (cp.this.J) {
                q16 = com.tencent.biz.qqcircle.k.b();
            } else {
                q16 = com.tencent.biz.qqcircle.k.q();
            }
            lottieAnimationView.setImageResource(q16);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int q16;
            cp.this.y1();
            QLog.d("QFSFullScreenCollectPresenter", 1, "[onAnimationEnd] animation end, isCollected: " + cp.this.J);
            LottieAnimationView lottieAnimationView = cp.this.I;
            if (cp.this.J) {
                q16 = com.tencent.biz.qqcircle.k.b();
            } else {
                q16 = com.tencent.biz.qqcircle.k.q();
            }
            lottieAnimationView.setImageResource(q16);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QFSFullScreenCollectPresenter", 1, "[onAnimationStart] animation start");
            cp.this.I.setPadding(0, 0, 0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
