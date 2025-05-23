package com.tencent.mobileqq.ark.temp.api.impl;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DisplayConfigImpl implements IDisplayConfig {
    @Override // com.tencent.mobileqq.ark.temp.api.IDisplayConfig
    public float getDisplayDensity() {
        return f.c();
    }

    @Override // com.tencent.mobileqq.ark.temp.api.IDisplayConfig
    public DisplayMetrics getDisplayMetrics() {
        return f.f199489i;
    }
}
