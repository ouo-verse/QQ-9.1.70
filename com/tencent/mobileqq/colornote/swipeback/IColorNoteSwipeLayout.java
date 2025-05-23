package com.tencent.mobileqq.colornote.swipeback;

import android.app.Activity;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.swipe.SwipeBackLayout;
import com.tencent.mobileqq.colornote.swipe.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import ia1.c;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IColorNoteSwipeLayout extends QRouteApi {
    void attachToActivity(Activity activity);

    void bringButtonToFront(Activity activity);

    void disablePostTable();

    void disableSwipe();

    void enablePostTable();

    void enableSwipe();

    boolean getIsSwipeAdd();

    boolean getIsSwipeBacked();

    int getScrollX();

    void noticeRecentColorNote();

    void onDestroy();

    void onPause();

    void onResume();

    void setBackgroundResource(int i3);

    void setLeftScope(int i3);

    void setOnColorNoteCurdListener(g gVar);

    void setOnPageSwipeListener(a aVar);

    void setOnSwipeListener(SwipeBackLayout.b bVar);

    void setReadyToSlide(boolean z16);

    void setServiceInfo(f fVar);

    void setTranslucentConvertor(c cVar);
}
