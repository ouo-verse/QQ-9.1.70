package com.tencent.qqsharpP;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f363551a;

    /* renamed from: b, reason: collision with root package name */
    public static String f363552b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f363551a = false;
            f363552b = "1.9.0";
        }
    }

    public static String a(File file) {
        return file.getAbsolutePath() + ".shp";
    }

    public static boolean b(Context context) {
        boolean c16 = c();
        if (!f363551a && c16) {
            f363551a = e();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSharpPUtil", 2, "isSharpPAvaliable: " + f363551a);
        }
        if (f363551a && c16) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        String[] split;
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
        if (!TextUtils.isEmpty(featureValue) && (split = featureValue.split("\\|")) != null && split.length >= 2 && !"0".equals(split[1])) {
            return true;
        }
        return false;
    }

    public static LoadExtResult d(String str, OnLoadListener onLoadListener) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        LoadExtResult g16 = g(str, onLoadListener);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadAndDownloadSo. soName = ");
        sb5.append(str);
        sb5.append(", result = ");
        sb5.append(g16);
        sb5.append(", time len = ");
        sb5.append(currentTimeMillis2);
        sb5.append(", so path = ");
        if (g16 != null) {
            str2 = g16.getSoLoadPath(str);
        } else {
            str2 = "null";
        }
        sb5.append(str2);
        QLog.i("QQSharpPUtil", 1, sb5.toString());
        return g16;
    }

    public static boolean e() {
        return f(null);
    }

    public static boolean f(OnLoadListener onLoadListener) {
        String str;
        ISoLoaderService iSoLoaderService = (ISoLoaderService) QRoute.api(ISoLoaderService.class);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SUPPORT_PRE_SHARP_P_SO_VERSION", false)) {
            str = "1.8.0";
        } else {
            str = "1.9.0";
        }
        f363552b = str;
        QLog.d("QQSharpPUtil", 1, "sharpP so version is " + f363552b);
        if (!f363552b.equals(iSoLoaderService.getSoVer(SoLoadConstants.SONAME_SHARPDEC))) {
            if (onLoadListener != null) {
                onLoadListener.onLoadResult(5, null);
            }
            return false;
        }
        LoadExtResult d16 = d(SoLoadConstants.SONAME_SHARPDEC, onLoadListener);
        if (d16 == null || !d16.isSucc()) {
            return false;
        }
        return true;
    }

    public static LoadExtResult g(String str, OnLoadListener onLoadListener) {
        ISoLoaderService iSoLoaderService = (ISoLoaderService) QRoute.api(ISoLoaderService.class);
        if (onLoadListener != null) {
            iSoLoaderService.load(str, onLoadListener);
            return null;
        }
        return iSoLoaderService.loadSync(str, null);
    }

    public static File h(File file) {
        File file2 = new File(file.getAbsolutePath() + ".shp");
        if (file.exists()) {
            file.renameTo(file2);
        }
        return file2;
    }
}
