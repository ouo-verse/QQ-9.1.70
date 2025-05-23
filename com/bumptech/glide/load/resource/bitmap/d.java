package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class d extends v.j<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    private final r.d f31828b = new r.e();

    @Override // v.j
    protected com.bumptech.glide.load.engine.q<Bitmap> c(ImageDecoder.Source source, int i3, int i16, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + HippyTKDListViewAdapter.X + decodeBitmap.getHeight() + "] for [" + i3 + HippyTKDListViewAdapter.X + i16 + "]");
        }
        return new e(decodeBitmap, this.f31828b);
    }
}
