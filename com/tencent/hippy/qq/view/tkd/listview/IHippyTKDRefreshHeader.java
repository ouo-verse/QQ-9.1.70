package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;
import android.view.View;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IHippyTKDRefreshHeader {
    boolean checkRefreshState(int i3);

    void completeRefresh(int i3);

    void completeRefresh(int i3, String str, int i16, int i17, int i18, int i19, String str2, boolean z16, long j3, Promise promise, int i26);

    boolean isRefreshHeaderShowing();

    boolean isRefreshing();

    void onCancelTouch();

    void onDraw(Canvas canvas);

    boolean onScrolled();

    void onSwitchSkin();

    boolean onUpAction(boolean z16);

    void restoreRefresh();

    void setCustomHippyRefreshView(View view);

    void setCustomRefreshBallColor(int i3, int i16, int i17);

    void setRefreshPromptInfo(String str, int i3, int i16, String str2, int i17, int i18, int i19);

    void setRefreshWithTargetType(int i3);

    void startRefresh(boolean z16);

    void startRefreshOnlyWithAimation(boolean z16);

    void startRefreshWithType(boolean z16);

    void stopRefresh();
}
