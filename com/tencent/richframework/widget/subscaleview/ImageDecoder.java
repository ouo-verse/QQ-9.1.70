package com.tencent.richframework.widget.subscaleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ImageDecoder {
    void decode(Context context, @NonNull Uri uri, int i3, int i16, Consumer<Bitmap> consumer) throws Exception;
}
