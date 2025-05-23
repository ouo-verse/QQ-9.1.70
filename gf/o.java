package gf;

import android.app.Activity;
import android.view.View;
import com.qzone.common.event.Event;
import com.qzone.widget.QZonePullToRefreshListView;
import cooperation.qzone.QZoneTopGestureLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface o {
    Activity getActivity();

    View getFeedListView(View view);

    com.tencent.mobileqq.leba.feed.c getNavigatorController();

    QZoneTopGestureLayout getTopGestureLayout(View view);

    uh.a getZPlanTitleHost();

    boolean handleEventUIThread(Event event);

    boolean isFeedViewListOnTop();

    void onRefresh();

    void scrollToTop();

    void setDispatchTouchEventListener(QZonePullToRefreshListView.a aVar);

    void setNestedScrollingEnabled(boolean z16);

    void setQZoneRefreshIndicatorInterface(com.qzone.feed.ui.activity.f fVar);

    void setSupportPullDown(boolean z16);

    void setupCorner(int i3);

    boolean shouldScrollTopWhenRefreshComplete();

    void stopAllAudio();
}
