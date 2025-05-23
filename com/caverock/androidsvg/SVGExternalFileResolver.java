package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.Typeface;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class SVGExternalFileResolver {
    public boolean isFormatSupported(String str) {
        return false;
    }

    public Typeface resolveFont(String str, int i3, String str2) {
        return null;
    }

    public Bitmap resolveImage(String str) {
        return null;
    }
}
