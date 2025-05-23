package com.tencent.mobileqq.vas.theme;

import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeSwitchCallback implements IThemeSwitchCallback {
    @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
    public boolean beforeSwitch(ThemeLocator themeLocator) {
        return false;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
    public boolean postSwitch(int i3) {
        return false;
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
    public void beginSwitch() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
    public void onProgress(long j3, long j16) {
    }
}
