package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SkiaImageDecoder implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap.Config f32564a;

    @Keep
    public SkiaImageDecoder() {
        this(null);
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.c
    @NonNull
    public Bitmap decode(Context context, @NonNull Uri uri) throws Exception {
        InputStream openInputStream;
        Bitmap bitmap;
        Resources resourcesForApplication;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = this.f32564a;
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

    public SkiaImageDecoder(@Nullable Bitmap.Config config) {
        Bitmap.Config h06 = SubsamplingScaleImageView.h0();
        if (config != null) {
            this.f32564a = config;
        } else if (h06 != null) {
            this.f32564a = h06;
        } else {
            this.f32564a = Bitmap.Config.RGB_565;
        }
    }
}
