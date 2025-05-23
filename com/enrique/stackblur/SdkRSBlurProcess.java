package com.enrique.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

/* loaded from: classes2.dex */
class SdkRSBlurProcess implements BlurProcess {
    private final RenderScript _rs;
    private final Context context;

    public SdkRSBlurProcess(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this._rs = RenderScript.create(applicationContext);
    }

    @Override // com.enrique.stackblur.BlurProcess
    public Bitmap blur(Bitmap bitmap, float f16) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Allocation createFromBitmap = Allocation.createFromBitmap(this._rs, copy, Allocation.MipmapControl.MIPMAP_NONE, 1);
        RenderScript renderScript = this._rs;
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        create.setInput(createFromBitmap);
        create.setRadius(f16);
        Allocation createTyped = Allocation.createTyped(this._rs, createFromBitmap.getType());
        create.forEach(createTyped);
        createTyped.copyTo(copy);
        return copy;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
