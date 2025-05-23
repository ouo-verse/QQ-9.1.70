package com.tencent.richframework.widget.subscaleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ImageRegionDecoder {
    @NonNull
    Bitmap decodeRegion(@NonNull Rect rect, int i3);

    @NonNull
    Point init(Context context, @NonNull Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
