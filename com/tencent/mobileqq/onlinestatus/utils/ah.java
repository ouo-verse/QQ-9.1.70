package com.tencent.mobileqq.onlinestatus.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.utils.BaseImageUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    public static final Drawable f256341a = new ColorDrawable(0);

    /* renamed from: b, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f256342b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f256343c = new b();

    /* renamed from: d, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f256344d = new c();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    int i3 = iArr[0];
                    if (i3 == 0 && (i3 = downloadParams.reqWidth) == 0) {
                        i3 = bitmap.getWidth();
                    }
                    int i16 = iArr[1];
                    if (i16 == 0) {
                        int i17 = downloadParams.reqHeight;
                        if (i17 == 0) {
                            i17 = bitmap.getHeight();
                        }
                        i16 = i17;
                    }
                    return BaseImageUtil.getHalfRoundedBitmap(bitmap, iArr[2], i3, i16);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements DownloadParams.DecodeHandler {
        b() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    return BaseImageUtil.getHalfRoundedBitmap(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements DownloadParams.DecodeHandler {
        c() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    int i3 = iArr[0];
                    if (i3 == 0 && (i3 = downloadParams.reqWidth) == 0) {
                        i3 = bitmap.getWidth();
                    }
                    int i16 = iArr[1];
                    if (i16 == 0) {
                        int i17 = downloadParams.reqHeight;
                        if (i17 == 0) {
                            i17 = bitmap.getHeight();
                        }
                        i16 = i17;
                    }
                    return BaseImageUtil.getRoundedCornerBitmap2(bitmap, iArr[2], i3, i16);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    public static final int[] a(int i3, int i16, int i17) {
        return new int[]{i3, i16, i17};
    }
}
