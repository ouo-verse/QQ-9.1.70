package com.github.henryye.nativeiv.comm;

import androidx.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
class CommNativeBitmapStruct extends NativeBitmapStruct {

    @Keep
    private int nConfig = -1;

    @Keep
    private boolean premultiplyAlpha;

    public CommNativeBitmapStruct convertToCommonStruct() {
        this.glType = com.tencent.luggage.wxa.g.a.b(this.nConfig);
        this.glFormat = com.tencent.luggage.wxa.g.a.a(this.nConfig);
        return this;
    }
}
