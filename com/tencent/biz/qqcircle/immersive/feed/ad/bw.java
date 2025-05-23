package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bw extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private View I;
    private bt J;
    private GdtAd K = new GdtAd();

    /* JADX WARN: Multi-variable type inference failed */
    private boolean i1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAdFullClickTipsPresenter", 1, "onBindData is null: " + i3);
            return true;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.B0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == this.f85018i) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        int i3;
        if (com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.g(this.K, anVar.e(), anVar.f()) != null) {
            eq eqVar = eq.f85700a;
            GdtAd gdtAd = this.K;
            T t16 = this.f85017h;
            if (t16 != 0) {
                i3 = ((FeedCloudMeta$StFeed) t16).status.get();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            if (!eqVar.a(gdtAd, i3)) {
                if (!l1()) {
                    com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("fullclick", "2");
                    q1(true);
                    return;
                }
                return;
            }
        }
        q1(false);
    }

    private void k1(View view) {
        if (view != null) {
            this.J = new bt((FrameLayout) view.findViewById(R.id.vgp));
        }
    }

    private boolean l1() {
        View view = this.I;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(boolean z16) {
        bt btVar = this.J;
        if (btVar != null) {
            if (z16) {
                btVar.d();
            } else {
                btVar.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(int i3) {
        View view = this.I;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    private void p1(final boolean z16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bu
            @Override // java.lang.Runnable
            public final void run() {
                bw.this.m1(z16);
            }
        });
    }

    private void q1(boolean z16) {
        if (z16) {
            r1(0);
        } else {
            r1(8);
        }
    }

    private void r1(final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bv
            @Override // java.lang.Runnable
            public final void run() {
                bw.this.n1(i3);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            j1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        }
        if ((hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) || (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.f)) {
            q1(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        QLog.d("QFSFeedChildAdFullClickTipsPresenter", 1, "onAttachedToWindow  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QLog.d("QFSFeedChildAdFullClickTipsPresenter", 1, "[onDetachedFromWindow] mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View inflate = ((ViewStub) view.findViewById(R.id.f380318v)).inflate();
        this.I = inflate;
        inflate.setVisibility(8);
        k1(view);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [feedcloud.FeedCloudMeta$StFeed, T] */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (i1(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        ?? c16 = u.c(this.E);
        this.f85017h = c16;
        if (c16.type.get() != 3) {
            return;
        }
        this.K = new GdtAd(u.e(this.E));
        bt btVar = this.J;
        if (btVar != null) {
            btVar.c();
        }
        if (this.K.getMultiClickAreaInfo().size() > 0) {
            com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("fullclick", "1");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        QLog.d("QFSFeedChildAdFullClickTipsPresenter", 1, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        bt btVar = this.J;
        if (btVar != null) {
            btVar.b();
            p1(true);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        QLog.d("QFSFeedChildAdFullClickTipsPresenter", 1, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        q1(false);
        if (this.J != null) {
            p1(false);
            this.J.c();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdFullClickTipsPresenter";
    }
}
