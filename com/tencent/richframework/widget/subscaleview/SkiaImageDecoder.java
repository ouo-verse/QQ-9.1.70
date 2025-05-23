package com.tencent.richframework.widget.subscaleview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SkiaImageDecoder implements ImageDecoder {
    private static final boolean ENABLE_RFW_REGION_SAMPLE = RFWConfig.getConfigValue("ENABLE_RFW_REGION_SAMPLE", true);
    private static final float ENABLE_RFW_REGION_SAMPLE_SCALE = RFWConfig.getConfigValue("ENABLE_RFW_REGION_SAMPLE", 0.8f);
    private final Bitmap.Config bitmapConfig;

    @Keep
    public SkiaImageDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeInner(Context context, @NonNull Uri uri, int i3, int i16, @NonNull Consumer<Bitmap> consumer) throws Exception {
        InputStream openInputStream;
        Bitmap bitmap;
        Resources resourcesForApplication;
        String uri2 = uri.toString();
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i3 > 0 && i16 > 0 && ENABLE_RFW_REGION_SAMPLE) {
            decodeBitmapSize(uri, options);
            int i17 = options.outWidth;
            int i18 = options.outHeight;
            float f16 = ENABLE_RFW_REGION_SAMPLE_SCALE;
            options.inSampleSize = RFWImageUtil.calculateInSampleSize(i17, i18, (int) (i3 * f16), (int) (i16 * f16));
        }
        int i19 = 0;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = this.bitmapConfig;
        if (uri2.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i19 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    i19 = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e16) {
                    RFWLog.e("SkiaImageDecoder", RFWLog.USR, e16);
                }
            }
            bitmap = BitmapFactory.decodeResource(context.getResources(), i19, options);
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
                        } catch (Exception e17) {
                            RFWLog.e("SkiaImageDecoder", RFWLog.USR, e17);
                        }
                    }
                    bitmap = decodeStream;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e18) {
                            RFWLog.e("SkiaImageDecoder", RFWLog.USR, e18);
                        }
                    }
                    throw th;
                }
            }
        }
        if (bitmap != null) {
            consumer.accept(bitmap);
            return;
        }
        throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    }

    @Override // com.tencent.richframework.widget.subscaleview.ImageDecoder
    public void decode(final Context context, @NonNull final Uri uri, final int i3, final int i16, @NonNull final Consumer<Bitmap> consumer) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.richframework.widget.subscaleview.SkiaImageDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SkiaImageDecoder.this.decodeInner(context, uri, i3, i16, consumer);
                } catch (Exception e16) {
                    consumer.accept(null);
                    RFWLog.e("SkiaImageDecoder", RFWLog.USR, e16);
                }
            }
        });
    }

    public void decodeBitmapSize(Uri uri, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        String uri2 = uri.toString();
        try {
            if (uri2.startsWith("file://")) {
                BitmapFactory.decodeFile(uri2.substring(7), options);
                return;
            }
            InputStream openInputStream = RFWApplication.getApplication().getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                if (openInputStream != null) {
                    openInputStream.close();
                }
            } finally {
            }
        } catch (Throwable th5) {
            RFWLog.e("SkiaImageDecoder", RFWLog.USR, th5);
        }
    }

    public SkiaImageDecoder(@Nullable Bitmap.Config config) {
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }
}
