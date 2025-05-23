package com.tencent.mobileqq.app.activitymodule;

/* loaded from: classes11.dex */
public interface ISystemBarPropertyProvider extends IActivityPropertyProvider {
    boolean actNeedImmersive();

    boolean hasTitleBar();

    boolean isAttachedToWindow();

    boolean isClearCoverLayer();

    boolean isInMultiWindow();

    boolean isNeedInterruptDoMultiWindow();

    boolean needStatusTrans();

    void notifyMultiWindowModeStatusVisibilityChange(int i3);

    void setStatusBarVisibilityNeedGone(boolean z16);
}
