package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cs extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ViewStub I;
    private View J;
    private ViewStub K;
    private View L;
    private boolean M = false;

    private void g1(boolean z16) {
        if (z16) {
            k1(false);
        } else {
            k1(true);
        }
        this.M = z16;
    }

    private View h1(ViewStub viewStub, View view) {
        if (viewStub == null) {
            return null;
        }
        if (view != null) {
            return view;
        }
        try {
            return viewStub.inflate();
        } catch (Throwable th5) {
            QLog.e("VFS-QFSFullScreenShadePresenter", 1, "[loadTopShadeView] error: ", th5);
            return null;
        }
    }

    private void j1(View view, boolean z16) {
        int i3;
        if (view == null) {
            QLog.e("VFS-QFSFullScreenShadePresenter", 1, "[setViewVisible] view should not be null.");
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
        QLog.d("VFS-QFSFullScreenShadePresenter", 1, "[setViewVisible] view: " + view + " | isVisible: " + z16);
    }

    private void k1(boolean z16) {
        this.J = h1(this.I, this.J);
        this.L = h1(this.K, this.L);
        j1(this.J, z16);
        j1(this.L, z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.j) {
            g1(((com.tencent.biz.qqcircle.immersive.feed.event.j) hVar).b());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        this.I = (ViewStub) view.findViewById(R.id.f42751km);
        this.K = (ViewStub) view.findViewById(R.id.f42401jo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        k1(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        k1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "VFS-QFSFullScreenShadePresenter";
    }
}
