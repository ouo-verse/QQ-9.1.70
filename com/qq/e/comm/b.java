package com.qq.e.comm;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f38127a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f38128b = 1020200;

    /* renamed from: c, reason: collision with root package name */
    private static int f38129c = 1020201;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f38130a;

        /* renamed from: b, reason: collision with root package name */
        String f38131b;

        public a(int i3, String str) {
            this.f38130a = i3;
            this.f38131b = str;
        }

        public final String toString() {
            return "CheckConfigError{errorCode=" + this.f38130a + ", errorMsg='" + this.f38131b + "'}";
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f38127a = hashMap;
        hashMap.put("android.permission.READ_PHONE_NUMBERS", 10);
        f38127a.put("android.permission.ACCESS_COARSE_LOCATION", 11);
        if (Build.VERSION.SDK_INT >= 30) {
            f38127a.put("android.permission.REQUEST_INSTALL_PACKAGES", 12);
        }
    }

    private static Class a() {
        if (!TextUtils.isEmpty(GlobalSetting.getCustomFileProviderClassName())) {
            try {
                return Class.forName(GlobalSetting.getCustomFileProviderClassName());
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            }
        }
        try {
            int i3 = FileProvider.f26474d;
            return FileProvider.class;
        } catch (ClassNotFoundException e17) {
            e17.printStackTrace();
            try {
                int i16 = android.support.v4.content.FileProvider.f26397d;
                return android.support.v4.content.FileProvider.class;
            } catch (ClassNotFoundException e18) {
                e18.printStackTrace();
                return null;
            }
        }
    }

    private static a b(Context context) {
        Method method;
        File file;
        File file2;
        Class a16 = a();
        if (a16 == null) {
            return new a(1, "providerClass not found");
        }
        try {
            method = a16.getMethod("getUriForFile", Context.class, String.class, File.class);
        } catch (NoSuchMethodException e16) {
            e16.printStackTrace();
            method = null;
        }
        if (method == null) {
            return new a(4, "getUriForFileMethod not found");
        }
        GDTLogger.d("getUriForFileMethod is not null");
        StringBuilder sb5 = new StringBuilder();
        if (SDKStatus.getSDKVersionCode() < 20) {
            if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory() != null && Environment.getExternalStorageDirectory().exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "GDTDOWNLOAD");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                file = null;
            }
        } else {
            File externalCacheDirSafe = FileUtil.getExternalCacheDirSafe();
            File externalFilesDir = GDTADManager.getInstance().getAppContext().getApplicationContext().getExternalFilesDir("");
            File cacheDir = GDTADManager.getInstance().getAppContext().getApplicationContext().getCacheDir();
            if (externalFilesDir != null) {
                externalCacheDirSafe = externalFilesDir;
            } else if (externalCacheDirSafe == null) {
                externalCacheDirSafe = cacheDir;
            }
            File file3 = new File(externalCacheDirSafe, "com_qq_e_download");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            file = file3;
        }
        if (file == null) {
            file2 = null;
        } else {
            file2 = new File(file, RFixConstants.APK_PATH);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        sb5.append(file2);
        sb5.append("/test.apk");
        String sb6 = sb5.toString();
        String str = context.getPackageName() + ".fileprovider";
        String str2 = context.getPackageName() + ".tg_fileprovider";
        try {
            Uri uri = (Uri) method.invoke(null, context, str, new File(sb6));
            if (uri == null) {
                uri = (Uri) method.invoke(null, context, str2, new File(""));
            }
            if (uri != null) {
                return null;
            }
            return new a(5, WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN);
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return new a(5, e17.getMessage());
        } catch (InvocationTargetException e18) {
            e18.printStackTrace();
            if (e18.getTargetException() != null && (e18.getTargetException() instanceof NullPointerException) && e18.getTargetException().getMessage() != null && e18.getTargetException().getMessage().equals("Attempt to invoke virtual method 'android.content.res.XmlResourceParser android.content.pm.ProviderInfo.loadXmlMetaData(android.content.pm.PackageManager, java.lang.String)' on a null object reference")) {
                return new a(2, e18.getTargetException().getMessage());
            }
            if (e18.getTargetException() != null && (e18.getTargetException() instanceof IllegalArgumentException) && e18.getTargetException().getMessage() != null && e18.getTargetException().getMessage().contains("Failed to find configured root that contains")) {
                return new a(3, e18.getTargetException().getMessage());
            }
            if (e18.getTargetException() != null) {
                return new a(5, e18.getTargetException().getMessage());
            }
            return new a(5, "unKnow error");
        } catch (Throwable th5) {
            return new a(5, th5.getMessage());
        }
    }

    private static int c(Context context) {
        Map<String, Integer> map = f38127a;
        if (map == null) {
            return 0;
        }
        try {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry != null && context.checkCallingOrSelfPermission(entry.getKey()) == -1) {
                    return entry.getValue().intValue();
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e("Check required Permissions error", th5);
        }
        return 0;
    }

    public static void a(Context context) {
        boolean z16 = false;
        if (GDTADManager.getInstance() != null && GDTADManager.getInstance().getSM() != null && GDTADManager.getInstance().getSM().getInteger("enableSdkConfigCheck", 0) == 1) {
            z16 = true;
        }
        if (z16) {
            a b16 = b(context);
            if (b16 != null) {
                com.qq.e.comm.a.a(f38128b, b16.f38130a, b16.f38131b);
                GDTLogger.e("tgSdkConfig installConfigError errorCode =" + b16.toString());
            }
            int c16 = c(context);
            if (c16 != 0) {
                com.qq.e.comm.a.a(f38129c, c16, "");
                GDTLogger.e("tgSdkConfig permissionConfig Error errorCode =" + c16);
            }
        }
    }
}
