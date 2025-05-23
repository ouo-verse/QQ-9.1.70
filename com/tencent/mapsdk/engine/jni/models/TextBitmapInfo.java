package com.tencent.mapsdk.engine.jni.models;

import android.support.annotation.Keep;
import com.tencent.mapsdk.internal.mt;
import java.util.Arrays;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class TextBitmapInfo {
    public boolean bold;
    public float density;
    public int height;
    byte[] mData = new byte[4];
    public int pitch;
    public int width;

    public void fill(byte[] bArr) {
        boolean z16 = false;
        Arrays.fill(this.mData, (byte) 0);
        System.arraycopy(bArr, 0, this.mData, 0, 4);
        this.density = Float.intBitsToFloat(mt.a(this.mData));
        System.arraycopy(bArr, 4, this.mData, 0, 4);
        this.width = mt.a(this.mData);
        System.arraycopy(bArr, 8, this.mData, 0, 4);
        this.height = mt.a(this.mData);
        System.arraycopy(bArr, 12, this.mData, 0, 4);
        this.pitch = mt.a(this.mData);
        System.arraycopy(bArr, 16, this.mData, 0, 1);
        if (this.mData[0] > 0) {
            z16 = true;
        }
        this.bold = z16;
    }
}
