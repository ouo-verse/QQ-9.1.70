package com.tencent.mobileqq.shortvideo.util;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NativeBridge {
    private static final String TAG = "TK_Config_NativeSoLoader";
    private static boolean globalInitialized = false;
    private static boolean loadSoSuccess = false;
    public String basePath = null;

    public NativeBridge(boolean z16, String str) {
        if (z16) {
            try {
                System.loadLibrary("TKGLRenderer");
                setAssetManager(BaseApplicationImpl.getApplication().getAssets(), str + File.separator);
                loadSoSuccess = true;
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        initSoEnvirontMent(str);
    }

    private static boolean initSoEnvirontMent(String str) {
        boolean z16 = false;
        if (!e.c("TKGLRenderer")) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArNativeSoLoader", 2, "native so is not exist!");
            }
            return false;
        }
        if (!globalInitialized) {
            globalInitialized = true;
            try {
                byte d16 = e.d("TKGLRenderer");
                setAssetManager(BaseApplicationImpl.getApplication().getAssets(), str + File.separator);
                if (d16 == 0) {
                    z16 = true;
                }
                loadSoSuccess = z16;
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initSoEnvirontMent loadSoSuccess = " + loadSoSuccess);
        }
        return loadSoSuccess;
    }

    private native void nativeInitOnjBridge();

    public static void qqColorLog(int i3, String str, String str2) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && QLog.isColorLevel()) {
                    QLog.e(str, 2, str2);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w(str, 2, str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    private static native void setAssetManager(AssetManager assetManager, String str);

    public boolean filter3DInitOnjBridge() {
        if (loadSoSuccess) {
            try {
                nativeInitOnjBridge();
                return true;
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap loadBitmapFromNative(String str, int i3) {
        Throwable th5;
        Bitmap bitmap;
        FileInputStream fileInputStream;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadBitmapFromNative " + str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        InputStream inputStream = null;
        Bitmap bitmap2 = null;
        InputStream inputStream2 = null;
        try {
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            try {
                String str2 = File.separator;
                ?? startsWith = str.startsWith(str2);
                try {
                    if (startsWith == 0) {
                        try {
                            startsWith = BaseApplicationImpl.getApplication().getResources().getAssets().open("arnative" + str2 + str);
                        } catch (Exception unused) {
                            startsWith = 0;
                        }
                        try {
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "loadBitmapFromNativeAsset " + str);
                                }
                                startsWith = startsWith;
                            } catch (Throwable th7) {
                                th = th7;
                                th5 = th;
                                inputStream = startsWith;
                                if (inputStream == null) {
                                }
                            }
                        } catch (Exception unused2) {
                            try {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(this.basePath);
                                sb5.append(str);
                                String sb6 = sb5.toString();
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "loadBitmapFromNativeNoAsset " + sb6);
                                }
                                try {
                                    startsWith = new FileInputStream(sb6);
                                } catch (FileNotFoundException e16) {
                                    e16.printStackTrace();
                                    startsWith = startsWith;
                                }
                                bitmap2 = BitmapFactory.decodeStream(startsWith);
                                if (bitmap2 != null) {
                                    Matrix matrix = new Matrix();
                                    matrix.preScale(1.0f, -1.0f);
                                    bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                                }
                                if (startsWith != 0) {
                                }
                            } catch (Exception e17) {
                                e = e17;
                                InputStream inputStream3 = startsWith;
                                bitmap = null;
                                inputStream2 = inputStream3;
                                e.printStackTrace();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                bitmap2 = bitmap;
                                if (QLog.isColorLevel()) {
                                }
                                return bitmap2;
                            }
                            if (QLog.isColorLevel()) {
                            }
                            return bitmap2;
                        }
                    } else {
                        try {
                            fileInputStream = new FileInputStream(str);
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            fileInputStream = null;
                        } catch (Exception e26) {
                            e = e26;
                            bitmap = null;
                            e.printStackTrace();
                            if (inputStream2 != null) {
                            }
                            bitmap2 = bitmap;
                            if (QLog.isColorLevel()) {
                            }
                            return bitmap2;
                        }
                        try {
                            startsWith = fileInputStream;
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "loadBitmapFromNativeNoAsset " + str);
                                startsWith = fileInputStream;
                            }
                        } catch (FileNotFoundException e27) {
                            e = e27;
                            e.printStackTrace();
                            startsWith = fileInputStream;
                            bitmap2 = BitmapFactory.decodeStream(startsWith);
                            if (bitmap2 != null) {
                            }
                            if (startsWith != 0) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            return bitmap2;
                        }
                    }
                    try {
                        bitmap2 = BitmapFactory.decodeStream(startsWith);
                    } catch (OutOfMemoryError e28) {
                        e28.printStackTrace();
                    }
                    if (bitmap2 != null && i3 == 0) {
                        Matrix matrix2 = new Matrix();
                        matrix2.preScale(1.0f, -1.0f);
                        bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix2, true);
                    }
                    if (startsWith != 0) {
                        try {
                            startsWith.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                        }
                    }
                } catch (Exception e36) {
                    e = e36;
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Exception e37) {
                e = e37;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadBitmapFromNative " + str + ", " + bitmap2 + ", cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            return bitmap2;
        } catch (Throwable th9) {
            th = th9;
            th5 = th;
            if (inputStream == null) {
                try {
                    inputStream.close();
                    throw th5;
                } catch (IOException e38) {
                    e38.printStackTrace();
                    throw th5;
                }
            }
            throw th5;
        }
    }
}
