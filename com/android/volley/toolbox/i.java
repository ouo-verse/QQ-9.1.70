package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.h;

/* compiled from: P */
/* loaded from: classes.dex */
public class i extends Request<Bitmap> {
    private static final Object C = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Object f31422d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    @GuardedBy("mLock")
    private h.b<Bitmap> f31423e;

    /* renamed from: f, reason: collision with root package name */
    private final Bitmap.Config f31424f;

    /* renamed from: h, reason: collision with root package name */
    private final int f31425h;

    /* renamed from: i, reason: collision with root package name */
    private final int f31426i;

    /* renamed from: m, reason: collision with root package name */
    private final ImageView.ScaleType f31427m;

    public i(String str, h.b<Bitmap> bVar, int i3, int i16, ImageView.ScaleType scaleType, Bitmap.Config config, @Nullable h.a aVar) {
        super(0, str, aVar);
        this.f31422d = new Object();
        setRetryPolicy(new com.android.volley.d(1000, 2, 2.0f));
        this.f31423e = bVar;
        this.f31424f = config;
        this.f31425h = i3;
        this.f31426i = i16;
        this.f31427m = scaleType;
    }

    private com.android.volley.h<Bitmap> d(com.android.volley.g gVar) {
        Bitmap decodeByteArray;
        byte[] bArr = gVar.f31332b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f31425h == 0 && this.f31426i == 0) {
            options.inPreferredConfig = this.f31424f;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i16 = options.outHeight;
            int f16 = f(this.f31425h, this.f31426i, i3, i16, this.f31427m);
            int f17 = f(this.f31426i, this.f31425h, i16, i3, this.f31427m);
            options.inJustDecodeBounds = false;
            options.inSampleSize = e(i3, i16, f16, f17);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > f16 || decodeByteArray.getHeight() > f17)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, f16, f17, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray == null) {
            return com.android.volley.h.a(new ParseError(gVar));
        }
        return com.android.volley.h.c(decodeByteArray, e.e(gVar));
    }

    @VisibleForTesting
    static int e(int i3, int i16, int i17, int i18) {
        double min = Math.min(i3 / i17, i16 / i18);
        float f16 = 1.0f;
        while (true) {
            float f17 = 2.0f * f16;
            if (f17 <= min) {
                f16 = f17;
            } else {
                return (int) f16;
            }
        }
    }

    private static int f(int i3, int i16, int i17, int i18, ImageView.ScaleType scaleType) {
        if (i3 == 0 && i16 == 0) {
            return i17;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            if (i3 == 0) {
                return i17;
            }
            return i3;
        }
        if (i3 == 0) {
            return (int) (i17 * (i16 / i18));
        }
        if (i16 == 0) {
            return i3;
        }
        double d16 = i18 / i17;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d17 = i16;
            if (i3 * d16 < d17) {
                return (int) (d17 / d16);
            }
            return i3;
        }
        double d18 = i16;
        if (i3 * d16 > d18) {
            return (int) (d18 / d16);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(Bitmap bitmap) {
        h.b<Bitmap> bVar;
        synchronized (this.f31422d) {
            bVar = this.f31423e;
        }
        if (bVar != null) {
            bVar.onResponse(bitmap);
        }
    }

    @Override // com.android.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f31422d) {
            this.f31423e = null;
        }
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public com.android.volley.h<Bitmap> parseNetworkResponse(com.android.volley.g gVar) {
        com.android.volley.h<Bitmap> d16;
        synchronized (C) {
            try {
                try {
                    d16 = d(gVar);
                } catch (OutOfMemoryError e16) {
                    com.android.volley.k.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(gVar.f31332b.length), getUrl());
                    return com.android.volley.h.a(new ParseError(e16));
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return d16;
    }
}
