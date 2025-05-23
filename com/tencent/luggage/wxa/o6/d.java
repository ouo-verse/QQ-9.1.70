package com.tencent.luggage.wxa.o6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {
    Bitmap decodeRegion(Rect rect, int i3);

    Point init(Context context, Uri uri);

    boolean isReady();

    void recycle();
}
