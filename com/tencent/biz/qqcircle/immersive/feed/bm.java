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
public class bm extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private ViewStub I;
    private View J;
    private ViewStub K;
    private View L;

    private View g1(ViewStub viewStub, View view) {
        if (viewStub == null) {
            return null;
        }
        if (view != null) {
            return view;
        }
        try {
            return viewStub.inflate();
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildShadePresenter", 1, "[loadTopShadeView] error: ", th5);
            return null;
        }
    }

    private void h1(View view, boolean z16) {
        int i3;
        if (view == null) {
            QLog.e("QFSFeedChildShadePresenter", 1, "[setViewVisible] view should not be null.");
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
    }

    private void i1(boolean z16) {
        this.J = g1(this.I, this.J);
        this.L = g1(this.K, this.L);
        h1(this.J, z16);
        h1(this.L, z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (ViewStub) view.findViewById(R.id.f41481h7);
        this.K = (ViewStub) view.findViewById(R.id.f40061dc);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        i1(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        i1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildShadePresenter";
    }
}
