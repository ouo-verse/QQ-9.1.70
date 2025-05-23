package com.tencent.hippykotlin.demo.pages.foundation.extension;

import com.tencent.kuikly.core.module.FontModule;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FontModuleExtKt {
    public static final float qqFontScale() {
        return FontModule.INSTANCE.a(17.0f, Boolean.TRUE) / 17.0f;
    }

    public static final float qqFontScaleAddSize(float f16) {
        return FontModule.INSTANCE.a(f16, Boolean.TRUE) - f16;
    }

    public static final float qqTextViewLineHeightScale() {
        return FontModule.INSTANCE.a(17.0f, Boolean.TRUE) / 17.0f;
    }
}
