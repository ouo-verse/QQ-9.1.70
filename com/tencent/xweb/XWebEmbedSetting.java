package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.x0;
import java.io.File;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebEmbedSetting {

    /* renamed from: a, reason: collision with root package name */
    public static String f385038a = null;

    /* renamed from: b, reason: collision with root package name */
    public static List f385039b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f385040c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f385041d;

    public static synchronized String getEmbedInstallLibDir() {
        synchronized (XWebEmbedSetting.class) {
            if (!TextUtils.isEmpty(f385038a)) {
                return f385038a;
            }
            return XWalkEnvironment.getApplicationContext().getApplicationInfo().nativeLibraryDir;
        }
    }

    public static synchronized boolean getForbidDownloadCode() {
        boolean z16;
        synchronized (XWebEmbedSetting.class) {
            if (!f385041d) {
                if (!XWalkEnvironment.getBuildConfigNeedTurnOffDynamicCode()) {
                    z16 = false;
                }
            }
            z16 = true;
        }
        return z16;
    }

    public static synchronized boolean getIsEmbedDirReady() {
        boolean z16;
        synchronized (XWebEmbedSetting.class) {
            z16 = f385040c;
        }
        return z16;
    }

    public static synchronized List<File> getSoLibDirs() {
        List<File> list;
        synchronized (XWebEmbedSetting.class) {
            list = f385039b;
        }
        return list;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void setEmbedInstallLibDir(String str) {
        synchronized (XWebEmbedSetting.class) {
            x0.d("XWebEmbedSetting", "setEmbedInstallLibDir:" + str);
            f385038a = str;
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void setForbidDownloadCode(boolean z16) {
        synchronized (XWebEmbedSetting.class) {
            x0.d("XWebEmbedSetting", "setForbidDownloadCode:" + z16);
            f385041d = z16;
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void setIsEmbedDirReady(boolean z16) {
        synchronized (XWebEmbedSetting.class) {
            x0.d("XWebEmbedSetting", "setIsEmbedDirReady:" + z16);
            f385040c = z16;
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void setSoLibDirs(List<File> list) {
        synchronized (XWebEmbedSetting.class) {
            f385039b = list;
        }
    }
}
