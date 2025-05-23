package com.tencent.mobileqq.app.guard.guardinterface;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IGuardInterface {
    void onApplicationBackground();

    void onApplicationForeground();

    void onBackgroundTimeTick(long j3);

    void onBackgroundUnguardTimeTick(long j3);

    void onLiteTimeTick(long j3);

    void onScreensStateChanged(boolean z16);
}
