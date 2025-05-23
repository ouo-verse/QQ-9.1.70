package com.tencent.luggage.widget.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.o6.c;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SkiaImageDecoder implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap.Config f120377a;

    @Keep
    public SkiaImageDecoder() {
        this(null);
    }

    @Override // com.tencent.luggage.wxa.o6.c
    public Bitmap decode(Context context, Uri uri) {
        InputStream openInputStream;
        Bitmap bitmap;
        Resources resourcesForApplication;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = this.f120377a;
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            int i3 = 0;
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i3 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    i3 = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            bitmap = BitmapFactory.decodeResource(context.getResources(), i3, options);
        } else {
            InputStream inputStream = null;
            if (uri2.startsWith("file:///android_asset/")) {
                bitmap = BitmapFactory.decodeStream(context.getAssets().open(uri2.substring(22)), null, options);
            } else if (uri2.startsWith("file://")) {
                bitmap = BitmapFactory.decodeFile(uri2.substring(7), options);
            } else {
                try {
                    openInputStream = context.getContentResolver().openInputStream(uri);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    bitmap = decodeStream;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    }

    public SkiaImageDecoder(Bitmap.Config config) {
        Bitmap.Config preferredBitmapConfig = com.tencent.luggage.wxa.n6.c.getPreferredBitmapConfig();
        if (config != null) {
            this.f120377a = config;
        } else if (preferredBitmapConfig != null) {
            this.f120377a = preferredBitmapConfig;
        } else {
            this.f120377a = Bitmap.Config.RGB_565;
        }
    }
}
