package com.tencent.mobileqq.webview.injector;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.theme.SkinEngine;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class m implements com.tencent.mobileqq.webview.swift.injector.r {
    @Override // com.tencent.mobileqq.webview.swift.injector.r
    public Drawable a(int i3) {
        return SkinEngine.getInstances().getDefaultThemeDrawable(i3);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.r
    public boolean b() {
        return ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), true, null);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.r
    public String getCurrentThemeId() {
        return ThemeUtil.getCurrentThemeId();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.r
    public boolean isDefaultTheme() {
        return "1000".equals(ThemeUtil.getCurrentThemeId());
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.r
    public boolean isNightMode() {
        return ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
    }
}
