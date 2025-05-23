package com.tencent.mobileqq.zplan.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002JR\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\bJf\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/l;", "", "", "inputPath", "outputPath", "", "b", "color", "", "width", "height", "Landroid/graphics/Bitmap;", "pattern", HippyTKDListViewAdapter.X, "y", "w", tl.h.F, "c", "rotationType", "source", "d", "fileDirPath", "name", "pictureBitmap", "", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f335829a = new l();

    l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String fileDirPath, String name, Bitmap pictureBitmap) {
        Intrinsics.checkNotNullParameter(fileDirPath, "$fileDirPath");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(pictureBitmap, "$pictureBitmap");
        File file = new File(fileDirPath + "/images/");
        file.mkdirs();
        File file2 = new File(file, "Image-" + name + ".jpg");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            pictureBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ImageUtil", 2, "saveBitmapToFile error: " + QLog.getStackTraceString(e16));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String inputPath, String outputPath) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(inputPath, "inputPath");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(outputPath);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(inputPath);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                if (decodeFile != null) {
                    try {
                        decodeFile.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream2);
                    } catch (Exception e16) {
                        bitmap = decodeFile;
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        try {
                            QLog.e("ImageUtil", 1, "compressPNG exception, " + inputPath, e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (bitmap == null) {
                                return false;
                            }
                            bitmap.recycle();
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (bitmap == null) {
                                bitmap.recycle();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bitmap = decodeFile;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        if (bitmap == null) {
                        }
                    }
                }
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (Exception unused3) {
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                return true;
            } catch (Exception e17) {
                bitmap = decodeFile;
                e = e17;
            } catch (Throwable th7) {
                th = th7;
                bitmap = decodeFile;
            }
        } catch (Exception e18) {
            e = e18;
            bitmap = null;
        } catch (Throwable th8) {
            th = th8;
            bitmap = null;
        }
    }

    public final Bitmap c(String color, int width, int height, Bitmap pattern, int x16, int y16, int w3, int h16) {
        Intrinsics.checkNotNullParameter(color, "color");
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmap);
        if (color.length() > 0) {
            canvas.drawColor(Color.parseColor(color));
        }
        if (pattern != null) {
            canvas.drawBitmap(pattern, (Rect) null, new Rect(x16, y16, w3 + x16, h16 + y16), (Paint) null);
        }
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public final void f(final String fileDirPath, final String name, final Bitmap pictureBitmap) {
        Intrinsics.checkNotNullParameter(fileDirPath, "fileDirPath");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pictureBitmap, "pictureBitmap");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.k
            @Override // java.lang.Runnable
            public final void run() {
                l.g(fileDirPath, name, pictureBitmap);
            }
        }, 64, null, false);
    }

    public final Bitmap d(String color, int width, int height, Bitmap pattern, int x16, int y16, int w3, int h16, int rotationType, Bitmap source) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Intrinsics.checkNotNullParameter(color, "color");
        if (source == null) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.eraseColor(0);
        } else {
            bitmap = source;
        }
        Canvas canvas = new Canvas(bitmap);
        if (source == null) {
            if (color.length() > 0) {
                canvas.drawColor(Color.parseColor(color));
            }
        }
        if (pattern != null) {
            Rect rect = new Rect(x16, y16, x16 + w3, y16 + h16);
            if (rotationType != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(rotationType * (-90.0f));
                bitmap2 = Bitmap.createBitmap(pattern, 0, 0, pattern.getWidth(), pattern.getHeight(), matrix, true);
            } else {
                bitmap2 = pattern;
            }
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (Rect) null, rect, (Paint) null);
            }
        }
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }
}
