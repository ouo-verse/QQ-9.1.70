package com.tencent.mobileqq.tvideo.presenter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes19.dex */
public class bd extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private void h1(View view) {
        final View findViewById = view.findViewById(R.id.d_9);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bd.this.j1(findViewById, view2);
            }
        });
        VideoReport.setElementParams(findViewById, gy2.c.g());
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(findViewById, "go_back");
    }

    private void i1(View view) {
        View findViewById = view.findViewById(R.id.f100085rj);
        View findViewById2 = view.findViewById(R.id.f56852lq);
        View findViewById3 = view.findViewById(R.id.vad);
        int f16 = jy2.f.f411169a.f(90) - px2.e.i();
        l1(findViewById, f16);
        l1(findViewById2, f16);
        k1(findViewById3, f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        if (iy2.a.e()) {
            ((Activity) m0()).finish();
        } else {
            jy2.g.Q((Activity) m0(), 1);
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    private void k1(View view, int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
    }

    private void l1(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setPadding(i3 - view.getPaddingLeft(), view.getPaddingTop(), i3 - view.getPaddingRight(), view.getPaddingBottom());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(View view) {
        super.N0(view);
        h1(view);
        i1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "TVideoDetailFeedsLandscapePresenter";
    }
}
