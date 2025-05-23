package com.tencent.mobileqq.zplan.cc.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("assets://") || new File(str).exists();
    }

    public static Bitmap b(Context context, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("assets://")) {
            return c(context, f(str), i3);
        }
        if (a(str)) {
            return d(str, i3);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r3 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r3 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap c(Context context, String str, int i3) {
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                InputStream open = context.getAssets().open(str);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i3;
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(open, null, options);
                    } catch (Exception e16) {
                        Log.e("ZPlanCamera", e16.toString());
                    } catch (OutOfMemoryError unused) {
                        options.inSampleSize <<= 1;
                        try {
                            open.reset();
                            bitmap = BitmapFactory.decodeStream(open, null, options);
                        } catch (IOException | OutOfMemoryError e17) {
                            Log.e("ZPlanCamera", e17.toString());
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException unused2) {
                                return bitmap;
                            }
                        }
                        return bitmap;
                    }
                } catch (Throwable th5) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                Log.e("ZPlanCamera", e18.toString());
            }
        }
        return null;
    }

    public static Bitmap d(String str, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            options.inSampleSize <<= 1;
            try {
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e16) {
                Log.e("ZPlanCamera", e16.toString());
                return null;
            }
        }
    }

    public static int e(String str) {
        int i3;
        if (!h.f332563a.a(str)) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                i3 = 180;
            } else if (attributeInt == 6) {
                i3 = 90;
            } else {
                if (attributeInt != 8) {
                    return 0;
                }
                i3 = 270;
            }
            return i3;
        } catch (IOException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static String f(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("assets://")) ? str.substring(9) : str;
    }

    public static Bitmap k(Bitmap bitmap, float f16, boolean z16) {
        if (!g(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f16, -f16);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap && z16) {
                h(bitmap);
            }
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap i(Bitmap bitmap, int i3) {
        return j(bitmap, i3, true);
    }

    public static boolean g(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static boolean h(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        bitmap.recycle();
        return true;
    }

    public static Bitmap j(Bitmap bitmap, int i3, boolean z16) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            if (z16) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }
}
