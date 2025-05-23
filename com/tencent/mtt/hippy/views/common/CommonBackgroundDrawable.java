package com.tencent.mtt.hippy.views.common;

import com.tencent.mtt.hippy.dom.flex.c;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CommonBackgroundDrawable extends BackgroundDrawable {
    @Override // com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable
    public void setBorderRadius(float f16, int i3) {
        if (!c.a(f16)) {
            super.setBorderRadius(PixelUtil.dp2px(f16), i3);
        }
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable
    public void setBorderWidth(float f16, int i3) {
        if (!c.a(f16)) {
            super.setBorderWidth(PixelUtil.dp2px(f16), i3);
        }
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.BaseDrawable
    public void setShadowOffsetX(float f16) {
        if (!c.a(f16)) {
            super.setShadowOffsetX(PixelUtil.dp2px(f16));
        }
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.BaseDrawable
    public void setShadowOffsetY(float f16) {
        if (!c.a(f16)) {
            super.setShadowOffsetY(PixelUtil.dp2px(f16));
        }
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.BaseDrawable
    public void setShadowRadius(float f16) {
        if (!c.a(f16)) {
            super.setShadowRadius(PixelUtil.dp2px(f16));
        }
    }
}
