package com.tencent.mobileqq.avatar.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static Bitmap a(Bitmap bitmap, String str, int i3) {
        boolean z16;
        int i16;
        boolean z17;
        int i17;
        Bitmap bitmap2;
        if (i3 != 3 && i3 != 4 && i3 != 2) {
            return null;
        }
        int g16 = g(str);
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int i18 = (int) (f16 * 45.0f);
        int i19 = (int) (f16 * 60.0f);
        RectF rectF = new RectF(0.0f, 0.0f, i18, i19);
        if (i3 == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 120;
        } else {
            i16 = 80;
        }
        int height = (int) ((bitmap.getHeight() * 60.0f) / i16);
        int i26 = (int) ((height * 45.0f) / 60.0f);
        if (i26 > bitmap.getWidth()) {
            i26 = bitmap.getWidth();
            z17 = true;
        } else {
            z17 = false;
        }
        int width = (int) ((bitmap.getWidth() - i26) / 2.0f);
        Rect rect = new Rect(width, 0, i26 + width, height);
        int i27 = ((int) (40.0f * f16)) / 2;
        int i28 = i27 * 2;
        RectF rectF2 = new RectF((int) (2.5f * f16), (int) (f16 * 20.0f), r2 + i28, r7 + i28);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i18, i19, Bitmap.Config.ARGB_8888);
            try {
                Bitmap c16 = c("static://Apollo_Face-figure_mask", R.drawable.ndt);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(g16);
                float f17 = i27;
                canvas.drawRoundRect(rectF2, f17, f17, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                if (z17) {
                    canvas.drawBitmap(bitmap, rect, new RectF((int) ((rectF.width() - ((int) ((rect.width() * rectF.height()) / rect.height()))) / 2.0f), rectF.top, r6 + r1, rectF.bottom), paint);
                } else {
                    canvas.drawBitmap(bitmap, rect, rectF, paint);
                }
                if (c16 != null) {
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                    canvas.drawBitmap(c16, new Rect(0, 0, c16.getWidth(), c16.getHeight()), rectF, paint);
                }
                return createBitmap;
            } catch (Throwable th5) {
                th = th5;
                bitmap2 = createBitmap;
                i17 = 3;
                Object[] objArr = new Object[i17];
                objArr[0] = "getApolloHalfFigureWithColorBgAndMask throw= ";
                objArr[1] = th.getMessage();
                objArr[2] = th;
                QLog.d("ApolloUtil", 1, objArr);
                return bitmap2;
            }
        } catch (Throwable th6) {
            th = th6;
            i17 = 3;
            bitmap2 = null;
        }
    }

    public static Bitmap b(Bitmap bitmap, String str, int i3) {
        Bitmap bitmap2 = null;
        if (i3 != 3 && i3 != 4 && i3 != 2) {
            return null;
        }
        int g16 = g(str);
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f17 = width;
            float f18 = 40;
            if (f17 < f16 * f18) {
                f16 = f17 / f18;
            }
        }
        int i16 = (int) (40 * f16);
        float f19 = i16;
        RectF rectF = new RectF(0.0f, 0.0f, f19, f19);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        try {
            bitmap2 = Bitmap.createBitmap(i16, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(g16);
            RectF rectF2 = new RectF(0.0f, 0.0f, f19, f19);
            float f26 = f19 / 2.0f;
            canvas.drawRoundRect(rectF2, f26, f26, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap, rect, rectF, paint);
            return bitmap2;
        } catch (Throwable th5) {
            QLog.d("ApolloUtil", 1, "getApolloRoundHeadWithColorBg throw= ", th5.getMessage(), th5);
            return bitmap2;
        }
    }

    private static Bitmap c(String str, int i3) {
        return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getBitmapWithCache(str, i3);
    }

    public static int d(int i3) {
        return (i3 >>> 4) & 15;
    }

    private static String e(int i3) {
        if (i3 == 0 || i3 != 1) {
            return "head";
        }
        return "body";
    }

    public static String f(int i3) {
        int h16 = h(i3);
        int d16 = d(i3);
        String i16 = i(h16);
        return e(d16) + "/" + i16 + ".png";
    }

    public static int g(String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (Exception unused) {
            j3 = 0;
        }
        return FaceConstant.Apollo.FACE_BG_COLOR_INDEXED[(int) (j3 % r4.length)];
    }

    public static int h(int i3) {
        return i3 & 15;
    }

    private static String i(int i3) {
        if (i3 == 0) {
            return "100";
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return "100";
            }
            return "640";
        }
        return "140";
    }

    public static int[] j(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[iArr.length * iArr2.length];
        int i3 = 0;
        for (int i16 : iArr) {
            for (int i17 : iArr2) {
                iArr3[i3] = k(i16, i17);
                i3++;
            }
        }
        return iArr3;
    }

    public static int k(int i3, int i16) {
        return (i3 << 4) | i16;
    }

    public static void l(AppRuntime appRuntime, int i3, String str) {
        if (i3 != 116) {
            return;
        }
        for (int i16 : FaceConstant.Apollo.FACE_SPEC_ALL) {
            try {
                File file = new File(((IQQAvatarDataService) appRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, i3, str, 200, i16));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th5) {
                QLog.d("ApolloUtil", 1, "removeFaceFileCacheApollo throw = ", th5.getMessage(), th5);
            }
        }
    }
}
