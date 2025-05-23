package com.tencent.mtt.hippy.adapter.font;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyFontScaleAdapter {
    @Nullable
    String getCustomDefaultFontFamily();

    @Nullable
    String getCustomFontFilePath(String str, int i3);

    CharSequence getEmoticonText(CharSequence charSequence, int i3);

    float getFontScale();
}
