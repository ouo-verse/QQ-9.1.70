package com.tencent.mobileqq.upgrade.download;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J/\u0010\u000f\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/a;", "", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "a", "", "apkPath", "Landroid/content/pm/PackageInfo;", "apkPackageInfo", "b", "", "Landroid/content/pm/Signature;", ICustomDataEditor.STRING_PARAM_1, ICustomDataEditor.STRING_PARAM_2, "e", "([Landroid/content/pm/Signature;[Landroid/content/pm/Signature;)Z", "c", "archiveFilePath", "", WadlProxyConsts.FLAGS, "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f306276a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63095);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f306276a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@Nullable DownloadInfo info) {
        if (info == null) {
            QLog.e("UpgradeController_ApkChecker", 1, "checkJacking: cannot get download info");
            return true;
        }
        String apkFilePath = info.L;
        if (TextUtils.isEmpty(apkFilePath)) {
            QLog.e("UpgradeConfigManager", 1, "checkJacking: cannot get path to apk");
            return true;
        }
        a aVar = f306276a;
        Intrinsics.checkNotNullExpressionValue(apkFilePath, "apkFilePath");
        PackageInfo d16 = aVar.d(apkFilePath, 64);
        if (d16 == null) {
            return true;
        }
        if (!Intrinsics.areEqual(d16.packageName, MobileQQ.PACKAGE_NAME)) {
            QLog.d("UpgradeController_ApkChecker", 1, "checkJacking: package name is wrong");
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        String encodeFile = PluginStatic.encodeFile(apkFilePath);
        String string = peekAppRuntime.getPreferences().getString(AppConstants.Preferences.UPGRADE_CHECK_MD5, "");
        if (!Intrinsics.areEqual(encodeFile, string)) {
            QLog.d("UpgradeController_ApkChecker", 1, "checkJacking: failed, md5 is different. apkMd5File=" + encodeFile + " apkMd5Record=" + string);
            return true;
        }
        if (!aVar.b(apkFilePath, d16)) {
            QLog.d("UpgradeController_ApkChecker", 1, "checkJacking: failed, signature is wrong.");
            return true;
        }
        if (!aVar.c(apkFilePath)) {
            QLog.d("UpgradeController_ApkChecker", 1, "checkJacking: success, it is safe");
            return true;
        }
        return false;
    }

    private final boolean b(String apkPath, PackageInfo apkPackageInfo) {
        boolean z16;
        Signature[] signatureArr;
        boolean z17;
        PackageManager packageManager = BaseApplication.context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
        Signature[] signatureArr2 = apkPackageInfo.signatures;
        if (signatureArr2 != null) {
            Intrinsics.checkNotNullExpressionValue(signatureArr2, "apkPackageInfo.signatures");
            if (signatureArr2.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                try {
                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, MobileQQ.PACKAGE_NAME, 64);
                    Intrinsics.checkNotNullExpressionValue(packageInfo, "pm.getPackageInfo(Mobile\u2026geManager.GET_SIGNATURES)");
                    if (Intrinsics.areEqual(packageInfo.packageName, MobileQQ.PACKAGE_NAME) && (signatureArr = packageInfo.signatures) != null) {
                        Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
                        if (signatureArr.length == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            boolean e16 = e(packageInfo.signatures, apkPackageInfo.signatures);
                            if (QLog.isColorLevel()) {
                                QLog.d("UpgradeController_ApkChecker", 2, "target apk signature is same with mobileqq, result:" + e16);
                            }
                            return e16;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("UpgradeController_ApkChecker", 2, "WTF? cannot get signature from local mobileqq");
                    }
                    return false;
                } catch (PackageManager.NameNotFoundException e17) {
                    QLog.e("UpgradeController_ApkChecker", 1, "checkSignature fail", e17);
                    return false;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_ApkChecker", 2, "cannot get signature from apk, path:" + apkPath);
        }
        return false;
    }

    private final boolean c(String apkPath) {
        FileInputStream fileInputStream;
        Throwable th5;
        byte[] bArr;
        File file = new File(apkPath);
        if (!file.exists()) {
            return true;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[2];
                    fileInputStream.read(bArr);
                } catch (Throwable th6) {
                    th5 = th6;
                    try {
                        QLog.e("UpgradeController_ApkChecker", 1, "", th5);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return true;
                    } catch (Throwable th7) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e16) {
                                QLog.e("UpgradeController_ApkChecker", 1, "checkValid fail", e16);
                            }
                        }
                        throw th7;
                    }
                }
            } catch (Throwable th8) {
                fileInputStream = null;
                th5 = th8;
            }
        } catch (IOException e17) {
            QLog.e("UpgradeController_ApkChecker", 1, "checkValid fail", e17);
        }
        if (bArr[0] == 80) {
            if (bArr[1] == 75) {
                fileInputStream.close();
                return true;
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException e18) {
            QLog.e("UpgradeController_ApkChecker", 1, "checkValid fail", e18);
        }
        return false;
    }

    private final boolean e(Signature[] s16, Signature[] s26) {
        if (s16 != null && s26 != null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            Collections.addAll(hashSet, Arrays.copyOf(s16, s16.length));
            Collections.addAll(hashSet2, Arrays.copyOf(s26, s26.length));
            return Intrinsics.areEqual(hashSet, hashSet2);
        }
        return false;
    }

    @Nullable
    public final PackageInfo d(@NotNull String archiveFilePath, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PackageInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) archiveFilePath, flags);
        }
        Intrinsics.checkNotNullParameter(archiveFilePath, "archiveFilePath");
        try {
            return BaseApplication.context.getPackageManager().getPackageArchiveInfo(archiveFilePath, flags);
        } catch (Throwable th5) {
            QLog.e("UpgradeController_ApkChecker", 1, "getPackageInfo fail", th5);
            return null;
        }
    }
}
