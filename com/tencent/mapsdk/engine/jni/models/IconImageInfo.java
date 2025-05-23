package com.tencent.mapsdk.engine.jni.models;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class IconImageInfo {
    public float anchorPointX1;
    public float anchorPointY1;
    public Bitmap bitmap;
    public float scale;

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer("IconImageInfo{");
        stringBuffer.append("bitmap=");
        if (this.bitmap != null) {
            str = this.bitmap.getWidth() + ":" + this.bitmap.getHeight();
        } else {
            str = null;
        }
        stringBuffer.append(str);
        stringBuffer.append(", scale=");
        stringBuffer.append(this.scale);
        stringBuffer.append(", anchorPointX1=");
        stringBuffer.append(this.anchorPointX1);
        stringBuffer.append(", anchorPointY1=");
        stringBuffer.append(this.anchorPointY1);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
