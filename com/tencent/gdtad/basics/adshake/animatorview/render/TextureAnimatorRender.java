package com.tencent.gdtad.basics.adshake.animatorview.render;

import android.graphics.Canvas;
import android.view.TextureView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TextureAnimatorRender extends BaseAnimatorRender<TextureView> {
    public TextureAnimatorRender(TextureView textureView) {
        super(textureView);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.BaseAnimatorRender
    protected Canvas lockCanvas() {
        T t16 = this.mView;
        if (t16 == 0) {
            return null;
        }
        return ((TextureView) t16).lockCanvas();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.render.BaseAnimatorRender
    protected void unlockCanvasAndPost(Canvas canvas) {
        T t16 = this.mView;
        if (t16 == 0) {
            return;
        }
        ((TextureView) t16).unlockCanvasAndPost(canvas);
    }
}
