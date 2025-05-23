package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.JavascriptInterface;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l0 extends MutableContextWrapper {
    public l0(Context context) {
        super(context);
    }

    @JavascriptInterface
    public float getPixelRatio() {
        return getResources().getDisplayMetrics().density;
    }

    @JavascriptInterface
    public float getWidth() {
        return (float) Math.ceil(getResources().getDisplayMetrics().widthPixels / getPixelRatio());
    }
}
