package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.g<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Integer> f31825b = com.bumptech.glide.load.d.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Bitmap.CompressFormat> f31826c = com.bumptech.glide.load.d.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final r.b f31827a;

    public c(@NonNull r.b bVar) {
        this.f31827a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, com.bumptech.glide.load.e eVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) eVar.c(f31826c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.g
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.e eVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0075 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #5 {all -> 0x00ca, blocks: (B:3:0x0023, B:15:0x004d, B:18:0x006f, B:20:0x0075, B:46:0x00c6, B:44:0x00c9, B:38:0x006a), top: B:2:0x0023 }] */
    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NonNull com.bumptech.glide.load.engine.q<Bitmap> qVar, @NonNull File file, @NonNull com.bumptech.glide.load.e eVar) {
        boolean z16;
        Bitmap bitmap = qVar.get();
        Bitmap.CompressFormat d16 = d(bitmap, eVar);
        i0.b.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), d16);
        try {
            long b16 = h0.f.b();
            int intValue = ((Integer) eVar.c(f31825b)).intValue();
            OutputStream outputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        if (this.f31827a != null) {
                            outputStream = new com.bumptech.glide.load.data.c(fileOutputStream, this.f31827a);
                        } else {
                            outputStream = fileOutputStream;
                        }
                        bitmap.compress(d16, intValue, outputStream);
                        outputStream.close();
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                        z16 = true;
                    } catch (IOException e16) {
                        e = e16;
                        outputStream = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z16 = false;
                        if (Log.isLoggable("BitmapEncoder", 2)) {
                        }
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e17) {
                e = e17;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + d16 + " of size " + h0.k.g(bitmap) + " in " + h0.f.a(b16) + ", options format: " + eVar.c(f31826c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z16;
        } finally {
            i0.b.d();
        }
    }
}
