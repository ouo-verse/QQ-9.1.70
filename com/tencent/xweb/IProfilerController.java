package com.tencent.xweb;

/* loaded from: classes27.dex */
public interface IProfilerController {
    void forceEnableFrameCostProfile(boolean z16);

    void forceFlushCategory(String str);

    void initProfile();

    void setAllKindsFpsProfileEnable(boolean z16);

    void setProfileConfig(String str, int i3, int i16, boolean z16);

    boolean setProfileResultCallback(String str, IProfileResultCallback iProfileResultCallback);
}
