package com.tencent.mobileqq.colornote.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import ha1.a;
import mqq.app.AppRuntime;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IColorNoteController extends QRouteApi {
    void addHistoryNote();

    void addToRecentNote();

    void attachToActivity(Activity activity);

    boolean canAddColorNote();

    void deleteColorNote();

    boolean detectCacheFull(AppRuntime appRuntime, int i3);

    void disableAutoRecentNote();

    void disablePostTable();

    void disableSwipe();

    void disableToast();

    void dispatchRecentViewSwitchChanged(boolean z16);

    void doSetPropertiesFromWebView(String str);

    void enablePostTable();

    void enableSwipe();

    void exitAnimation();

    IColorNoteSwipeLayout getSwipePostTableLayout();

    boolean hasShareEntr();

    void init(Context context, boolean z16, boolean z17);

    void init(Context context, boolean z16, boolean z17, IColorNoteSwipeLayout iColorNoteSwipeLayout, boolean z18, boolean z19, int i3);

    void init(Context context, boolean z16, boolean z17, IColorNoteSwipeLayout iColorNoteSwipeLayout, boolean z18, boolean z19, boolean z26, int i3);

    void init(Context context, boolean z16, boolean z17, boolean z18, boolean z19, int i3);

    void insertColorNote();

    boolean isColorNoteExist();

    boolean isColorNoteExist(ColorNote colorNote);

    boolean isFirstCloseRecentNote();

    boolean isSwipeBackExit();

    void onCannotAdd();

    void onDestroy();

    ColorNote onGetColorNote(int i3, String str, String str2, String str3, String str4, byte[] bArr);

    void onPause();

    void onResume();

    void refreshPostTable(Activity activity);

    void registerBroadcast();

    void setCustomNightMode(Context context, boolean z16);

    void setFirstCloseRecentNote(AppRuntime appRuntime);

    void setLeftSwipeScope(int i3);

    void setOnColorNoteAnimFinishListener(a aVar);

    void setOnColorNoteCurdListener(g gVar);

    void setOnPageSwipeListener(com.tencent.mobileqq.colornote.swipe.a aVar);

    void setRecentlyViewedSwitch(AppRuntime appRuntime, boolean z16);

    void setServiceInfo(f fVar);

    void setServiceSyncListener(o oVar);

    void setShareEntr(boolean z16);

    void setSmallScreenShouldShow(boolean z16, int i3);

    boolean shouldDisplayColorNote();

    void updateColorNote(ColorNote colorNote);
}
