package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSTurnPageEvent;
import com.tencent.biz.qqcircle.immersive.feed.live.od.a;
import com.tencent.biz.qqcircle.immersive.views.qqliveod.QFSMeleeGameView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import weprotocols.WEProtocolsVaslive$DatingRoomInfo;
import weprotocols.WEProtocolsVaslive$SeatUserList;
import weprotocols.WEProtocolsVaslive$UserBasic;

/* loaded from: classes4.dex */
public class QFSFeedChildODViewPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private static final int[] Y = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    private IAegisLogApi I;
    private com.tencent.biz.qqcircle.immersive.feed.live.od.a J;
    private ImageView K;
    private FrameLayout L;
    private FrameLayout M;
    private TextView N;
    private com.tencent.biz.qqcircle.immersive.feed.live.b P;
    private com.tencent.biz.qqcircle.immersive.feed.live.e Q;
    private com.tencent.biz.qqcircle.immersive.feed.live.a R;
    private FeedCloudMeta$StFeed S;
    private WEProtocolsVaslive$DatingRoomInfo T;
    private FeedCloudMeta$RoomInfoData U;
    private final View.OnClickListener V = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.as
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QFSFeedChildODViewPresenter.this.p1(view);
        }
    };

    @VisibleForTesting
    Runnable W = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildODViewPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            QFSFeedChildODViewPresenter.this.I.i("QFSFeedChildODPresenter", 1, "execute turn page runnable");
            QCircleToast.i(QCircleToast.f91646f, R.string.f1914144q, 0);
            SimpleEventBus.getInstance().dispatchEvent(new QFSTurnPageEvent(1));
        }
    };
    Runnable X = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildODViewPresenter.2
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedChildODViewPresenter.this.S != null) {
                QFSFeedChildODViewPresenter.this.I.i("QFSFeedChildODPresenter", 1, "execute delete runnable");
                QCircleFeedEvent qCircleFeedEvent = new QCircleFeedEvent(3);
                qCircleFeedEvent.mTargetId = QFSFeedChildODViewPresenter.this.S.f398449id.get();
                SimpleEventBus.getInstance().dispatchEvent(qCircleFeedEvent);
            }
        }
    };

    private void A1() {
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar == null) {
            this.I.w("QFSFeedChildODPresenter", "odGameView is null!!");
            return;
        }
        aVar.show();
        int[] iArr = Y;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        for (a.C0883a c0883a : k1()) {
            this.J.setSeatInfo(c0883a.f86332a, c0883a);
            int i3 = c0883a.f86332a;
            if (i3 >= 0 && i3 < length) {
                iArr2[i3] = -1;
            }
        }
        for (int i16 = 0; i16 < length; i16++) {
            if (iArr2[i16] != -1) {
                this.J.setSeatInfo(i16, null);
            }
        }
        w1();
    }

    private void B1() {
        com.tencent.biz.qqcircle.immersive.utils.ah.g(m0(), false, this.S, 17);
    }

    private void C1() {
        if (com.tencent.biz.qqcircle.immersive.feed.live.w.f(this.S, this.T)) {
            D1();
            RFWThreadManager.getUIHandler().postDelayed(this.X, 500L);
        }
    }

    private void D1() {
        this.I.i("QFSFeedChildODPresenter", 1, "start turnPage");
        RFWThreadManager.getUIHandler().removeCallbacks(this.W);
        RFWThreadManager.getUIHandler().postDelayed(this.W, 500L);
    }

    private void j1() {
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar == null || !(aVar instanceof QFSMeleeGameView) || ((QFSMeleeGameView) aVar).isRelease()) {
            Object obj = this.J;
            if (obj != null) {
                ((ViewGroup) this.f85016f).removeView((View) obj);
            }
            QFSMeleeGameView qFSMeleeGameView = new QFSMeleeGameView(m0());
            this.J = qFSMeleeGameView;
            ((ViewGroup) this.f85016f).addView(qFSMeleeGameView);
        }
        this.f85016f.setOnClickListener(this.V);
        n40.a.b(m0(), this.f85016f);
        this.f85016f.setLayoutParams(n40.a.a(m0(), (FrameLayout.LayoutParams) this.f85016f.getLayoutParams()));
    }

    private List<a.C0883a> k1() {
        ArrayList arrayList = new ArrayList();
        for (WEProtocolsVaslive$SeatUserList wEProtocolsVaslive$SeatUserList : this.T.seatUsers.get()) {
            WEProtocolsVaslive$UserBasic wEProtocolsVaslive$UserBasic = wEProtocolsVaslive$SeatUserList.userBasic;
            if (wEProtocolsVaslive$UserBasic != null && wEProtocolsVaslive$UserBasic.get() != null) {
                arrayList.add(new a.C0883a.C0884a().e(wEProtocolsVaslive$SeatUserList.uid.get()).b(wEProtocolsVaslive$SeatUserList.userBasic.logo.url.get()).c(wEProtocolsVaslive$SeatUserList.userBasic.nick.get()).d(wEProtocolsVaslive$SeatUserList.seatNo.get()).a());
            } else {
                this.I.w("QFSFeedChildODPresenter", "\u6570\u636e\u9519\u8bef,\u6ca1\u6709userBasic\u4fe1\u606f");
            }
        }
        return arrayList;
    }

    private void l1() {
        ViewGroup.LayoutParams layoutParams = this.f85016f.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = DisplayUtil.dip2px(m0(), 160.0f);
        }
        this.f85016f.setLayoutParams(layoutParams);
    }

    private void m1() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.W);
        RFWThreadManager.getUIHandler().removeCallbacks(this.X);
    }

    private void n1(View view) {
        if (view != null) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_xsj_livefeeds_liveicon");
            expEntity.reportExpExposure();
            this.P = new com.tencent.biz.qqcircle.immersive.feed.live.b(view, this.I, expEntity);
            ExpEntityInfo expEntity2 = ABTestController.getInstance().getExpEntity("exp_xsj_livefeeds_clickbutton");
            expEntity2.reportExpExposure();
            this.Q = new com.tencent.biz.qqcircle.immersive.feed.live.e(this.L, this.M, this.I, expEntity2);
            this.R = new com.tencent.biz.qqcircle.immersive.feed.live.a(view.findViewById(R.id.yln), view.findViewById(R.id.ylm));
        }
    }

    private boolean o1() {
        WEProtocolsVaslive$DatingRoomInfo wEProtocolsVaslive$DatingRoomInfo = this.T;
        if (wEProtocolsVaslive$DatingRoomInfo != null && wEProtocolsVaslive$DatingRoomInfo.gameID.get() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void r1() {
        if (this.R != null) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("qqlive_experiment_darklayer_0323");
            expEntity.reportExpExposure();
            boolean isExperiment = expEntity.isExperiment("qqlive_experiment_darklayer_0323_B");
            QLog.d("QFSFeedChildODPresenter", 1, "mask abtest, isNewStyle = " + isExperiment);
            this.R.a(isExperiment);
        }
    }

    private void s1() {
        com.tencent.biz.qqcircle.immersive.feed.live.b bVar = this.P;
        if (bVar != null) {
            bVar.d();
        }
    }

    private void t1() {
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData = this.U;
        if (feedCloudMeta$RoomInfoData != null) {
            v1(feedCloudMeta$RoomInfoData.coverUrl.get());
        }
        if (com.tencent.biz.qqcircle.immersive.feed.live.w.f(this.S, this.T)) {
            z1();
            y1(false);
        } else {
            m1();
            x1();
            y1(true);
            A1();
        }
    }

    private void u1() {
        com.tencent.biz.qqcircle.immersive.feed.live.e eVar;
        if (!com.tencent.biz.qqcircle.immersive.feed.live.w.f(this.S, this.T) && (eVar = this.Q) != null) {
            eVar.n();
        }
    }

    private void v1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = this.K.getDrawable();
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        this.K.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.K.setImageDrawable(drawable);
    }

    private void w1() {
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar != null && !aVar.isRelease()) {
            this.J.L(0, true);
        }
    }

    private void x1() {
        this.N.setVisibility(8);
    }

    private void y1(boolean z16) {
        if (z16) {
            this.Q.r();
            this.P.g();
        } else {
            this.Q.s();
            this.P.h();
        }
    }

    private void z1() {
        this.M.setVisibility(8);
        this.L.setVisibility(8);
        this.N.setVisibility(0);
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar != null) {
            aVar.hide();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f85016f = view.findViewById(R.id.f40791fb);
        this.K = (ImageView) view.findViewById(R.id.f40701f3);
        this.L = (FrameLayout) view.findViewById(R.id.uxz);
        this.M = (FrameLayout) view.findViewById(R.id.txz);
        this.N = (TextView) view.findViewById(R.id.ylp);
        view.setOnClickListener(this.V);
        v1("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEKnV8lddPLBM2J308rfxHfnqibW5iagl9FbvMMgtH5TgF6w/");
        l1();
        n1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar != null) {
            aVar.release();
            this.J = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        this.I.i("QFSFeedChildODPresenter", "onFeedSelected od presenter !");
        u1();
        s1();
        r1();
        m1();
        C1();
        w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        com.tencent.biz.qqcircle.immersive.feed.live.od.a aVar = this.J;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        this.I.i("QFSFeedChildODPresenter", "onResumed od presenter !");
        w1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.S = feedCloudMeta$StFeed;
        this.U = com.tencent.biz.qqcircle.immersive.feed.live.w.h(feedCloudMeta$StFeed);
        this.T = com.tencent.biz.qqcircle.immersive.feed.live.w.c(this.E);
        if (o1()) {
            j1();
        }
        t1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildODPresenter";
    }
}
