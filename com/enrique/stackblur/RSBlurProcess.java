package com.enrique.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;

/* loaded from: classes2.dex */
class RSBlurProcess implements BlurProcess {
    private final RenderScript _rs;
    private final Context context;
    private final int mBlurResId;

    public RSBlurProcess(Context context, int i3) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.mBlurResId = i3;
        this._rs = RenderScript.create(applicationContext);
    }

    @Override // com.enrique.stackblur.BlurProcess
    public Bitmap blur(Bitmap bitmap, float f16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        ScriptC_blur scriptC_blur = new ScriptC_blur(this._rs, this.context.getResources(), this.mBlurResId);
        Allocation createFromBitmap = Allocation.createFromBitmap(this._rs, copy, Allocation.MipmapControl.MIPMAP_NONE, 1);
        scriptC_blur.set_gIn(createFromBitmap);
        scriptC_blur.set_width(width);
        scriptC_blur.set_height(height);
        scriptC_blur.set_radius((int) f16);
        int[] iArr = new int[height];
        for (int i3 = 0; i3 < height; i3++) {
            iArr[i3] = i3;
        }
        RenderScript renderScript = this._rs;
        Allocation createSized = Allocation.createSized(renderScript, Element.U32(renderScript), height, 1);
        createSized.copyFrom(iArr);
        int[] iArr2 = new int[width];
        for (int i16 = 0; i16 < width; i16++) {
            iArr2[i16] = i16;
        }
        RenderScript renderScript2 = this._rs;
        Allocation createSized2 = Allocation.createSized(renderScript2, Element.U32(renderScript2), width, 1);
        createSized2.copyFrom(iArr2);
        scriptC_blur.forEach_blur_h(createSized);
        scriptC_blur.forEach_blur_v(createSized2);
        createFromBitmap.copyTo(copy);
        return copy;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
