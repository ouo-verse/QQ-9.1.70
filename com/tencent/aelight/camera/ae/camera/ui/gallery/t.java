package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.ae.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static final String f62773a = g.a.C0559a.f65247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f62774a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f62775b;

        a(Runnable runnable, Runnable runnable2) {
            this.f62774a = runnable;
            this.f62775b = runnable2;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f62774a.run();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            this.f62775b.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f62776d = 0;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int i3;
            float min;
            int i16 = this.f62776d;
            if (i16 != 0) {
                rect.set(0, 0, i16, 0);
                return;
            }
            com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
            int a16 = eVar.a(12.0f);
            int a17 = eVar.a(9.0f);
            eVar.a(15.0f);
            int a18 = eVar.a(48.0f);
            int i17 = a18 + a16;
            int measuredWidth = recyclerView.getMeasuredWidth() - eVar.a(6.0f);
            int i18 = measuredWidth % i17;
            int i19 = measuredWidth / i17;
            float f16 = (a16 - a17) * i19;
            if (i18 < 0 || i18 > a18) {
                i3 = (int) (((int) (((double) (i18 - a18)) - (((double) a16) * 0.5d))) > 0 ? a16 - (f16 / i19) : a16 + (f16 / i19));
            } else {
                int i26 = (int) (i18 - (a18 * 0.5d));
                if (i26 > 0) {
                    min = a16 + (Math.min(i26, f16) / i19);
                } else {
                    min = a16 - (Math.min(-i26, f16) / i19);
                }
                i3 = (int) min;
            }
            this.f62776d = i3 - a16;
            rect.set(0, 0, i3, 0);
        }
    }

    public static RecyclerView.ItemDecoration a() {
        return new b();
    }

    private static void d() {
        try {
            File[] listFiles = new File(f62773a).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith("temp_store_file_")) {
                        if (System.currentTimeMillis() - Long.parseLong(name.substring(16, name.length() - 4)) >= 3600000) {
                            file.delete();
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static int e(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(R.dimen.bb9, typedValue, true);
        return (int) (com.tencent.videocut.utils.o.f384257a.f(context) * typedValue.getFloat());
    }

    public static void g(Activity activity, Runnable runnable, Runnable runnable2) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_CAMERA, QQPermissionConstants.Business.SCENE.OPEN_AIO_MINI_PHOTO_SELECTOR));
            if (qQPermission == null) {
                runnable2.run();
                return;
            }
            boolean z16 = qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0;
            boolean z17 = qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0;
            if (z16 && z17) {
                runnable.run();
                return;
            } else {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}, 2, new a(runnable, runnable2));
                return;
            }
        }
        runnable2.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(int i3, int i16, String str, Runnable runnable, Consumer<String> consumer) {
        Bitmap c16;
        FileOutputStream fileOutputStream;
        IOException e16;
        boolean z16;
        if (i3 <= 0 || i16 <= 0 || (c16 = c(str, i16, i3)) == null) {
            return;
        }
        ms.a.a("MaterialCustomUtils", "decode image success");
        int exifOrientation = BaseImageUtil.getExifOrientation(str);
        if (exifOrientation != 0) {
            ms.a.a("MaterialCustomUtils", "decode image, need rotate, degree = " + exifOrientation);
            Matrix matrix = new Matrix();
            int width = c16.getWidth();
            int height = c16.getHeight();
            matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
            c16 = Bitmap.createBitmap(c16, 0, 0, width, height, matrix, true);
        }
        if (f(c16.getWidth(), c16.getHeight(), i16, i3)) {
            ms.a.a("MaterialCustomUtils", "decode image, need add bg");
            Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(Color.parseColor("#000000"));
            c16 = com.tencent.biz.qqstory.utils.b.l(createBitmap, c16);
        }
        String str2 = f62773a + "/temp_store_file_" + System.currentTimeMillis() + ".png";
        FileOutputStream fileOutputStream2 = null;
        try {
            d();
            fileOutputStream = new FileOutputStream(str2);
        } catch (IOException e17) {
            fileOutputStream = null;
            e16 = e17;
        } catch (Throwable th5) {
            th = th5;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                c16.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                ms.a.a("MaterialCustomUtils", "compress custom material success, path = " + str2);
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                z16 = true;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e18) {
            e16 = e18;
            ms.a.e("MaterialCustomUtils", e16);
            if (runnable != null) {
                runnable.run();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            }
            z16 = false;
            if (z16) {
                return;
            } else {
                return;
            }
        }
        if (z16 || consumer == null) {
            return;
        }
        consumer.accept(str2);
    }

    private static Bitmap c(String str, int i3, int i16) {
        int i17;
        int i18;
        boolean z16;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i19 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i26 = options.outWidth;
        int i27 = options.outHeight;
        if (i26 > 0 && i27 > 0) {
            ms.a.a("MaterialCustomUtils", "start decode image of path: " + str + ", width = " + i26 + ", height = " + i27 + ", targetWidth = " + i3 + ", targetHeight = " + i16);
            float f16 = ((float) i26) / ((float) i27);
            if (f16 > 2.0f) {
                i17 = i27 * 2;
                z16 = true;
                i18 = i27;
            } else if (f16 < 0.5f) {
                z16 = true;
                i18 = i26 * 2;
                i17 = i26;
            } else {
                i17 = i26;
                i18 = i27;
                z16 = false;
            }
            if (i17 > i3 || i18 > i16) {
                int i28 = i17 / 2;
                int i29 = i18 / 2;
                while (true) {
                    float f17 = i19;
                    if (i28 / f17 <= i3 * 0.65f || i29 / f17 <= i16 * 0.65f) {
                        break;
                    }
                    i19 *= 2;
                }
            }
            ms.a.a("MaterialCustomUtils", "decode image: inSampleSize = " + i19);
            options.inJustDecodeBounds = false;
            options.inSampleSize = i19;
            if (z16) {
                try {
                    return BitmapRegionDecoder.newInstance((InputStream) new FileInputStream(new File(str)), false).decodeRegion(new Rect((i26 - i17) / 2, (i27 - i18) / 2, (i26 + i17) / 2, (i27 + i18) / 2), options);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            return BitmapFactory.decodeFile(str, options);
        }
        ms.a.c("MaterialCustomUtils", "decode image of path: " + str + ", failed");
        return null;
    }

    private static boolean f(int i3, int i16, int i17, int i18) {
        float f16 = i3;
        float f17 = i16;
        float min = Math.min(i17 / f16, i18 / f17);
        return ((int) (f16 * min)) < i17 || ((int) (f17 * min)) < i18;
    }
}
