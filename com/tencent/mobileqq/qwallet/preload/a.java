package com.tencent.mobileqq.qwallet.preload;

import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.utils.j;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.MD5;
import cooperation.qwallet.plugin.IQWalletHelper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f278999a = TextUtils.isEmpty(e());

    /* renamed from: b, reason: collision with root package name */
    public static final Object f279000b = new Object();

    public static void a(String str, boolean z16, int i3) {
        ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).deleteRes(str, z16, i3);
    }

    public static String b(String str) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).getConfigFromQQ(str);
    }

    public static String c(String str) {
        return d() + str;
    }

    public static String d() {
        return ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + com.tencent.mobileqq.base.a.c() + "/" + IPreloadServiceAbs.PRELOAD_DIR_NAME_HIDE + "/";
    }

    public static String e() {
        try {
            String str = j.f279282a;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str + IPreloadServiceAbs.PRELOAD_DIR_NAME_HIDE + "/";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f(String str) {
        return g(str, 0);
    }

    public static String g(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return l(i3) + MD5.toMD5(str);
    }

    public static IPreloadServiceAbs h() {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).getInstance();
    }

    public static String i() {
        return ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + IPreloadServiceAbs.PRELOAD_DIR_NAME_HIDE + "/";
    }

    public static ResourceInfo j(String str, boolean z16, int i3) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).getResInfoByUrl(str, z16, i3);
    }

    public static String k() {
        return l(0);
    }

    public static String l(int i3) {
        if (i3 == 1) {
            return i();
        }
        String e16 = e();
        if (!TextUtils.isEmpty(e16)) {
            f278999a = false;
            return e16;
        }
        f278999a = true;
        return i();
    }

    public static IPreloadService.PathResult m(DownloadParam downloadParam) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).getResPathSync(downloadParam);
    }

    public static String n(String str) {
        return o(str, 0);
    }

    public static String o(String str, int i3) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).getResourcePathByUrl(str, i3);
    }

    public static String p(String str) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).getUnzipFolderPath(str);
    }

    public static boolean q(String str) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).isDiskEnoughToUnzip(str);
    }

    public static boolean r(ResourceInfo resourceInfo, DownloadParam downloadParam) {
        return ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).isFileValid(resourceInfo, downloadParam);
    }

    public static boolean s(String str, int i3) {
        if (i3 != 4) {
            if (str == null || str.length() <= 5 || !str.substring(str.length() - 4).equals(".zip")) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static ResultReceiver t(ResultReceiver resultReceiver) {
        if (resultReceiver == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        return resultReceiver2;
    }

    public static synchronized boolean u(String str, String str2) {
        boolean unzipAtomically;
        synchronized (a.class) {
            unzipAtomically = ((IPreloadStaticApi) QRoute.api(IPreloadStaticApi.class)).unzipAtomically(str, str2);
        }
        return unzipAtomically;
    }
}
