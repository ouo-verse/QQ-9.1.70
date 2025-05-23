package com.tencent.mtt.hippy.adapter.font;

import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultFontScaleAdapter implements HippyFontScaleAdapter {
    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    @Nullable
    public String getCustomDefaultFontFamily() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    @Nullable
    public String getCustomFontFilePath(String str, int i3) {
        LogUtils.d("DefaultFontScaleAdapter", "getCustomFontFilePath fontFamilyName=" + str + ", style=" + i3);
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public float getFontScale() {
        return 1.0f;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public CharSequence getEmoticonText(CharSequence charSequence, int i3) {
        return charSequence;
    }
}
