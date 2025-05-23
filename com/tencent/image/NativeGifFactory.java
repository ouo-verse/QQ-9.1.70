package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NativeGifFactory {
    static IPatchRedirector $redirector_;
    static final String TAG;
    static boolean isX86;
    static boolean isYunOS;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String simpleName = NativeGifFactory.class.getSimpleName();
        TAG = simpleName;
        isX86 = false;
        isYunOS = false;
        String kernelVersion = getKernelVersion();
        if (TextUtils.isEmpty(kernelVersion) || kernelVersion.contains(ResourceAttributes.HostArchValues.X86) || kernelVersion.contains("X86")) {
            isX86 = true;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(simpleName, 2, "isX86:" + isX86);
        }
        String systemProperties = getSystemProperties(URLDrawable.mApplicationContext, "ro.yunos.version");
        if (!TextUtils.isEmpty(systemProperties) && systemProperties.length() > 1) {
            isYunOS = true;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(simpleName, 2, "isYunOS:" + isYunOS);
        }
    }

    public NativeGifFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.e(com.tencent.image.NativeGifFactory.TAG, 2, "readFileContent", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0071, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1 A[Catch: IOException -> 0x00ad, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ad, blocks: (B:68:0x00a9, B:59:0x00b1), top: B:67:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getKernelVersion() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        IOException e16;
        ByteArrayOutputStream byteArrayOutputStream;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e17) {
                fileInputStream2 = null;
                e16 = e17;
                byteArrayOutputStream = null;
            } catch (OutOfMemoryError unused) {
                fileInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (byteArrayOutputStream2 != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            try {
                fileInputStream2 = new FileInputStream("/proc/version");
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream2.read(bArr, 0, 4096);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = byteArrayOutputStream.toString("utf-8");
                    try {
                        byteArrayOutputStream.close();
                        fileInputStream2.close();
                    } catch (IOException e18) {
                        e = e18;
                    }
                } catch (IOException e19) {
                    e16 = e19;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.e(TAG, 2, "readFileContent", e16);
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e26) {
                            e = e26;
                        }
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return str;
                } catch (OutOfMemoryError unused2) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e27) {
                            e = e27;
                        }
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return str;
                }
            } catch (IOException e28) {
                fileInputStream2 = null;
                e16 = e28;
            } catch (OutOfMemoryError unused3) {
                fileInputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e29) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.e(TAG, 2, "readFileContent", e29);
                        }
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            return str;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0041 -> B:13:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0043 -> B:13:0x0062). Please report as a decompilation issue!!! */
    public static AbstractGifImage getNativeGifObject(File file, boolean z16) {
        NativeGifImage nativeGifImage;
        NativeGifImage nativeGifImage2;
        int i3;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame)");
        }
        NativeGifImage nativeGifImage3 = null;
        nativeGifImage3 = null;
        try {
        } catch (IOException e16) {
            e = e16;
        }
        if (isUseNewGif()) {
            NativeGifIndex8 nativeGifIndex8 = new NativeGifIndex8(file, z16);
            try {
                i3 = nativeGifIndex8.mFrameNumber;
                nativeGifImage3 = i3;
                nativeGifImage = nativeGifIndex8;
            } catch (IOException e17) {
                e = e17;
                nativeGifImage3 = nativeGifIndex8;
                nativeGifImage2 = nativeGifImage3;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "getNativeGifObject exception. msg:" + e.getMessage());
                    nativeGifImage2 = nativeGifImage3;
                }
                nativeGifImage = nativeGifImage2;
                nativeGifImage3 = nativeGifImage2;
                return nativeGifImage;
            }
            if (i3 == -1001) {
                nativeGifImage2 = new NativeGifImage(file, z16);
                nativeGifImage = nativeGifImage2;
                nativeGifImage3 = nativeGifImage2;
            }
        } else {
            nativeGifImage = new NativeGifImage(file, z16);
        }
        return nativeGifImage;
    }

    public static String getSystemProperties(Context context, String str) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException | Exception unused) {
            return "";
        }
    }

    public static boolean isUseNewGif() {
        String str = Build.MANUFACTURER;
        String model = DeviceInfoMonitor.getModel();
        boolean z16 = false;
        if ((TextUtils.isEmpty(model) || (!model.contains("m1") && !model.contains("meizu_m1") && !model.contains("N1"))) && !model.contains("HYF9300") && ((TextUtils.isEmpty(str) || (!str.contains("alps") && !str.contains("Nokia") && !str.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ASUS))) && !isX86 && !isYunOS)) {
            SharedPreferences sharedPreferences = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
            if (sharedPreferences != null) {
                z16 = sharedPreferences.getBoolean("use_new_gif_so", false);
            }
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "use_new_gif_so:" + z16);
            }
        }
        return z16;
    }

    public static AbstractGifImage getNativeGifObject(File file, boolean z16, boolean z17, int i3, int i16, float f16) {
        return getNativeGifObject(file, z16, z17, i3, i16, f16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AbstractGifImage getNativeGifObject(File file, boolean z16, boolean z17, int i3, int i16, float f16, Object obj) {
        Bundle bundle;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame, boolean isEmosmFile, int maxWidth, int maxHeight, float roundCorner)");
        }
        NativeGifImage nativeGifImage = null;
        try {
            bundle = obj instanceof Bundle ? (Bundle) obj : null;
        } catch (IOException e16) {
            e = e16;
        }
        if (f16 == 0.0f && isUseNewGif()) {
            NativeGifIndex8 nativeGifIndex8 = new NativeGifIndex8(file, z16, z17, i3, i16, f16, bundle);
            try {
            } catch (IOException e17) {
                e = e17;
                nativeGifImage = nativeGifIndex8;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "getNativeGifObject exception. msg:" + e.getMessage());
                }
                return nativeGifImage;
            }
            if (nativeGifIndex8.mFrameNumber != -1001) {
                return nativeGifIndex8;
            }
            nativeGifImage = new NativeGifImage(file, z16, z17, i3, i16, f16, bundle);
            return nativeGifImage;
        }
        return new NativeGifImage(file, z16, z17, i3, i16, f16, bundle);
    }
}
