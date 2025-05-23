package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.album.ui.widget.QzoneSwipPullRefreshListView;
import com.qzone.widget.internal.ExtendFeedsLoadingLayout;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import cooperation.qzone.util.QZLog;

/* loaded from: classes37.dex */
public class QZoneXPullToRefreshListView extends QzoneSwipPullRefreshListView {
    public QZoneXPullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q0(context, context.obtainStyledAttributes(attributeSet, tg2.a.K3));
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    protected ep.a e0(Context context, TypedArray typedArray) {
        return new ExtendFeedsLoadingLayout(context, PullToRefreshBase.Mode.PULL_FROM_START, PullToRefreshBase.Orientation.VERTICAL, typedArray);
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void l0() {
        super.l0();
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView, com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
        if (QZLog.isColorLevel()) {
            QZLog.d("SwipListView", 2, "onNotCompleteVisable");
        }
        super.onNotCompleteVisable(i3, view, listView);
        ep.a g06 = g0();
        if (g06 != null) {
            g06.reset();
        }
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView, com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        super.onViewCompleteVisable(i3, view, listView);
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView, com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        ep.a g06 = g0();
        if (g06 != null) {
            g06.b();
        }
        super.onViewCompleteVisableAndReleased(i3, view, listView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void q0(Context context, TypedArray typedArray) {
        super.q0(context, typedArray);
        setOverScrollHeight(0);
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void r0(String str, String str2) {
        ep.a g06 = g0();
        if (g06 != null) {
            g06.c(1, str);
        }
        super.r0(str, str2);
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void s0(String str) {
        ep.a g06 = g0();
        if (g06 != null) {
            g06.c(0, str);
        }
        super.s0(str);
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView, cooperation.qzone.api.FeedListView
    public void scrollToTop() {
        super.scrollToTop();
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void setCoverMode(boolean z16) {
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void setCoverMode(boolean z16, int i3) {
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void setRefreshing(boolean z16) {
        scrollTo(0, -5);
        OverScrollViewListener overScrollViewListener = this.mOverScrollViewListener;
        if (overScrollViewListener != null) {
            overScrollViewListener.onViewCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
        }
        springBackOverScrollHeaderView(-getOverScrollHeight());
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView
    public void setListViewBGFeedNormal() {
    }
}
