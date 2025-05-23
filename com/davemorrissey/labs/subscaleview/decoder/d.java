package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface d {
    @NonNull
    Bitmap decodeRegion(@NonNull Rect rect, int i3);

    @NonNull
    Point init(Context context, @NonNull Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
