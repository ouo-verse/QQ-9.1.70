package com.tencent.mobileqq.util.impl;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.util.IUIServiceProxy;

/* loaded from: classes20.dex */
public class UIServiceProxyImpl implements IUIServiceProxy {
    static {
        initFeature();
    }

    @Override // com.tencent.mobileqq.util.IUIServiceProxy
    public DisplayMetrics getSystemDisplayMetric() {
        return FontSettingManager.systemMetrics;
    }

    @Override // com.tencent.mobileqq.util.IUIServiceProxy
    public boolean isLargeFont() {
        return FontSettingManager.isFontSizeLarge();
    }

    @Override // com.tencent.mobileqq.util.IUIServiceProxy
    public boolean useQUIToken() {
        return true;
    }

    @QAutoInitMethod
    public static void initFeature() {
    }
}
