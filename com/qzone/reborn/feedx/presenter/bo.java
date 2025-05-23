package com.qzone.reborn.feedx.presenter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.event.QZoneFeedxLayerScrollToQFSEvent;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneFeedxSingleVideoWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.biz.qqcircle.immersive.events.RFWTransitionAnimEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.event.QZoneVideoRetryPlayEvent;
import java.util.ArrayList;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bo extends vg.a implements gf.r, RFWTransitionHelper.TransAnimCreator, SimpleEventReceiver {
    private QZoneFeedxSingleVideoWidgetView F;
    private int G;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f55578d;

        a(View view) {
            this.f55578d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (((vg.a) bo.this).f441565h != null && ((vg.a) bo.this).f441565h.getVideoInfo() != null) {
                if (view instanceof QZoneMixBaseWidgetView) {
                    ((QZoneMixBaseWidgetView) view).p0().setTag(R.id.f100755tc, Integer.valueOf(bo.this.G));
                }
                long Q0 = ((vg.a) bo.this).f441565h.getVideoInfo() != null ? bo.this.F.Q0(((vg.a) bo.this).f441565h.getVideoInfo()) : 0L;
                bo.this.Z();
                bo.this.W(this.f55578d, Q0);
            } else {
                QLog.e("QZoneFeedVideoPresenter", 1, "mVideoItemWidgetView  onClick , params error");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void R() {
        final BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            return;
        }
        final String a16 = ef.b.a(businessFeedData);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.presenter.bn
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                bo.this.X(a16, businessFeedData, (gf.e) obj);
            }
        }).run();
    }

    private ImageView S() {
        QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
        if (qZoneFeedxSingleVideoWidgetView == null) {
            return null;
        }
        return qZoneFeedxSingleVideoWidgetView.p0();
    }

    private void U(RFWTransitionAnimEvent rFWTransitionAnimEvent) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            return;
        }
        if ((businessFeedData.isQQVideoFeeds() || businessFeedData.isQCircleShareCardFeed()) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_qqvideo_enable_exit_anim_frame", true)) {
            ImageView S = S();
            QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
            if (S == null || qZoneFeedxSingleVideoWidgetView == null) {
                return;
            }
            if (TextUtils.equals(rFWTransitionAnimEvent.getClickViewHashCode(), S.hashCode() + "")) {
                QLog.d("QZoneFeedVideoPresenter", 1, "handleTransitionAnimEvent event:" + rFWTransitionAnimEvent);
                if (rFWTransitionAnimEvent.isAnimStart()) {
                    ImageView O0 = qZoneFeedxSingleVideoWidgetView.O0();
                    Drawable animCoverDrawable = rFWTransitionAnimEvent.getAnimCoverDrawable();
                    if (O0 != null && animCoverDrawable != null) {
                        O0.setImageDrawable(animCoverDrawable);
                        O0.setVisibility(0);
                    }
                    qZoneFeedxSingleVideoWidgetView.f1();
                    return;
                }
                final ImageView O02 = qZoneFeedxSingleVideoWidgetView.O0();
                if (O02 != null) {
                    RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.bm
                        @Override // java.lang.Runnable
                        public final void run() {
                            bo.Y(O02);
                        }
                    }, 50L);
                }
            }
        }
    }

    private void V(QZoneVideoRetryPlayEvent qZoneVideoRetryPlayEvent) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && businessFeedData.isQQVideoFeeds()) {
            QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
            if (qZoneFeedxSingleVideoWidgetView == null) {
                QLog.e("QZoneFeedVideoPresenter", 1, "handleVideoRetryPlay videoItemWidgetView is null");
                return;
            }
            if (TextUtils.equals(businessFeedData.getOperationInfo().qzoneFeedid, qZoneVideoRetryPlayEvent.getQQVideoBusinessFeedID())) {
                ImageView S = S();
                QLog.d("QZoneFeedVideoPresenter", 1, "handleVideoRetryPlay feedId:" + qZoneVideoRetryPlayEvent.getQQVideoBusinessFeedID() + ",coverView:" + S);
                businessFeedData.qqVideoFeedStatus = 2;
                if (S != null) {
                    if (TextUtils.equals(qZoneVideoRetryPlayEvent.getClickViewHashCode(), S.hashCode() + "")) {
                        QLog.d("QZoneFeedVideoPresenter", 1, "handleVideoRetryPlay do real retry");
                        qZoneFeedxSingleVideoWidgetView.performClick();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(View view, long j3) {
        gf.i iVar = (gf.i) j(gf.i.class);
        if (iVar == null) {
            RFWLog.e("QZoneFeedVideoPresenter", RFWLog.USR, "launcher ioc is null");
        } else {
            iVar.l2(this.f441565h, this.f441566i, S(), view.getContext(), j3, this.f441567m, this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(String str, BusinessFeedData businessFeedData, gf.e eVar) {
        eVar.k5(this.F, "em_qz_video_content_block", str, businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        SimpleEventBus.getInstance().registerReceiver(this);
        if (v()) {
            DataPreCalculateTool.makeUpForwardFeedInfo(this.f441565h, this.f441566i);
        }
    }

    private void a0(boolean z16) {
        QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
        if (qZoneFeedxSingleVideoWidgetView == null || qZoneFeedxSingleVideoWidgetView.V0() == null) {
            return;
        }
        this.F.V0().setVisibility(z16 ? 0 : 4);
        this.F.setPlayIconVisible(z16);
    }

    @Override // gf.r
    public void a() {
        QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
        if (qZoneFeedxSingleVideoWidgetView != null) {
            qZoneFeedxSingleVideoWidgetView.a();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        QLog.d("QZoneFeedVideoPresenter", 1, "getVideoItemView   | feedPos = " + this.f441567m + " | view = " + this.F);
        return this.F;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String str) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && businessFeedData.getVideoInfo() != null) {
            VideoInfo videoInfo = this.f441565h.getVideoInfo();
            QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
            if (qZoneFeedxSingleVideoWidgetView != null && qZoneFeedxSingleVideoWidgetView.p0() != null) {
                return RFWLayerLaunchUtil.getTransAnimBean(uuid, this.F.p0(), tk.b.a(videoInfo, this.f441565h), true);
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxLayerScrollToQFSEvent.class);
        arrayList.add(QZoneVideoRetryPlayEvent.class);
        arrayList.add(RFWTransitionAnimEvent.class);
        return arrayList;
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedVideoPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxLayerScrollToQFSEvent) {
            T((QZoneFeedxLayerScrollToQFSEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QZoneVideoRetryPlayEvent) {
            V((QZoneVideoRetryPlayEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof RFWTransitionAnimEvent) {
            U((RFWTransitionAnimEvent) simpleBaseEvent);
        }
    }

    @Override // gf.r
    public void pause() {
        QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
        if (qZoneFeedxSingleVideoWidgetView != null) {
            qZoneFeedxSingleVideoWidgetView.pause();
        }
    }

    @Override // gf.r
    public void play() {
        QZoneFeedxSingleVideoWidgetView qZoneFeedxSingleVideoWidgetView = this.F;
        if (qZoneFeedxSingleVideoWidgetView != null) {
            qZoneFeedxSingleVideoWidgetView.play();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.noi;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String str, boolean z16) {
        a0(z16);
    }

    @Override // vg.a
    protected boolean x() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(ImageView imageView) {
        imageView.setVisibility(8);
        imageView.setImageDrawable(null);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getVideoInfo() != null) {
            this.F.setFeedData(businessFeedData);
            this.F.setFeedPosition(this.f441567m);
            this.F.H0(businessFeedData.getVideoInfo());
            R();
            return;
        }
        QLog.e("QZoneFeedVideoPresenter", 1, "onBindData  params error");
    }

    private void T(QZoneFeedxLayerScrollToQFSEvent qZoneFeedxLayerScrollToQFSEvent) {
        BusinessFeedData businessFeedData;
        if (qZoneFeedxLayerScrollToQFSEvent != null && qZoneFeedxLayerScrollToQFSEvent.isScrollToQFS) {
            BusinessFeedData businessFeedData2 = this.f441565h;
            if ((businessFeedData2 != null && !TextUtils.equals(businessFeedData2.getVideoInfo().videoId, qZoneFeedxLayerScrollToQFSEvent.videoId)) || (businessFeedData = this.f441565h) == null || businessFeedData.getVideoInfo() == null) {
                return;
            }
            a0(true);
        }
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneFeedxSingleVideoWidgetView) view.findViewById(R.id.f162966nl1);
        this.G = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        this.F.setOnClickListener(new a(view));
    }
}
