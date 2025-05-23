package com.tencent.rfix.lib.security;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.ManifestUtils;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.PatchMD5Utils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    protected static String f365005g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f365006a;

    /* renamed from: b, reason: collision with root package name */
    private final File f365007b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, String> f365008c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f365009d;

    /* renamed from: e, reason: collision with root package name */
    private String f365010e;

    /* renamed from: f, reason: collision with root package name */
    private int f365011f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f365005g = null;
        }
    }

    public a(Context context, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) file);
            return;
        }
        this.f365009d = null;
        this.f365010e = null;
        this.f365011f = -1;
        this.f365006a = context;
        this.f365007b = file;
        this.f365008c = new HashMap<>();
        if (f365005g == null) {
            f365005g = h();
        }
    }

    private boolean b(Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            for (int length = certificateArr.length - 1; length >= 0; length--) {
                try {
                } catch (Exception e16) {
                    RFixLog.e("RFix.SecurityCheck", "checkSignaturesMD5 fail.", e16);
                }
                if (f365005g.equals(PatchMD5Utils.getMD5(certificateArr[length].getEncoded()))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private HashMap<String, String> f() {
        Throwable th5;
        JarFile jarFile;
        Exception e16;
        if (!this.f365008c.isEmpty()) {
            return this.f365008c;
        }
        if (!PatchFileUtils.isLegalFile(this.f365007b)) {
            return this.f365008c;
        }
        try {
            try {
                jarFile = new JarFile(this.f365007b);
            } catch (Exception e17) {
                jarFile = null;
                e16 = e17;
            } catch (Throwable th6) {
                th5 = th6;
                PatchFileUtils.closeQuietly(null);
                throw th5;
            }
            try {
                for (String str : PatchFileUtils.loadZipEntry(jarFile, jarFile.getJarEntry("assets/package_meta.txt")).split("\n")) {
                    if (str != null && str.length() > 0 && !str.startsWith("#")) {
                        String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                        if (split.length >= 2) {
                            this.f365008c.put(split[0].trim(), split[1].trim());
                        }
                    }
                }
            } catch (Exception e18) {
                e16 = e18;
                RFixLog.e("RFix.SecurityCheck", "getPackageProperties fail!", e16);
                PatchFileUtils.closeQuietly(jarFile);
                return this.f365008c;
            }
            PatchFileUtils.closeQuietly(jarFile);
            return this.f365008c;
        } catch (Throwable th7) {
            th5 = th7;
            PatchFileUtils.closeQuietly(null);
            throw th5;
        }
    }

    private String h() {
        String str = null;
        try {
            try {
                String md5 = PatchMD5Utils.getMD5(InstalledAppListMonitor.getPackageInfo(this.f365006a.getPackageManager(), this.f365006a.getPackageName(), 64).signatures[0].toByteArray());
                PatchFileUtils.closeQuietly(null);
                str = md5;
            } catch (Exception e16) {
                RFixLog.e("RFix.SecurityCheck", "getPackageSignaturesMD5 fail.", e16);
                PatchFileUtils.closeQuietly(null);
            }
            RFixLog.d("RFix.SecurityCheck", String.format("getPackageSignaturesMD5 signaturesMD5=%s", str));
            return str;
        } catch (Throwable th5) {
            PatchFileUtils.closeQuietly(null);
            throw th5;
        }
    }

    public boolean a() {
        String e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        String manifestPatchId = ManifestUtils.getManifestPatchId(this.f365006a);
        if (this.f365009d == null && (e16 = e(RFixConstants.PATCH_ID)) != null) {
            this.f365009d = e16.split(",");
        }
        RFixLog.d("RFix.SecurityCheck", String.format("checkPatchIdMatch patchIdInApk=%s patchIdList=%s", manifestPatchId, Arrays.toString(this.f365009d)));
        String[] strArr = this.f365009d;
        if (strArr != null && strArr.length > 0 && manifestPatchId != null) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f365009d;
                if (i3 >= strArr2.length) {
                    break;
                }
                if (TextUtils.equals(strArr2[i3], manifestPatchId)) {
                    this.f365010e = this.f365009d[i3];
                    this.f365011f = i3;
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f365010e;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f365011f;
    }

    public String e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        HashMap<String, String> f16 = f();
        if (f16 != null) {
            return f16.get(str);
        }
        return null;
    }

    public boolean g(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        String e16 = e(str);
        if (e16 != null) {
            return Boolean.parseBoolean(e16);
        }
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    public boolean i() {
        Throwable th5;
        JarFile jarFile;
        Exception e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && (r2 = iPatchRedirector.hasPatch((short) 4)) != 0) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!PatchFileUtils.isLegalFile(this.f365007b)) {
            return false;
        }
        try {
            try {
                jarFile = new JarFile(this.f365007b);
            } catch (Exception e17) {
                jarFile = null;
                e16 = e17;
            } catch (Throwable th6) {
                Object obj = 0;
                th5 = th6;
                PatchFileUtils.closeQuietly(obj);
                throw th5;
            }
            try {
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry nextElement = entries.nextElement();
                    if (nextElement != null) {
                        String name = nextElement.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith("meta.txt")) {
                            PatchFileUtils.loadZipEntry(jarFile, nextElement);
                            Certificate[] certificates = nextElement.getCertificates();
                            if (certificates == null || !b(certificates)) {
                                PatchFileUtils.closeQuietly(jarFile);
                                return false;
                            }
                        }
                    }
                }
                PatchFileUtils.closeQuietly(jarFile);
                return true;
            } catch (Exception e18) {
                e16 = e18;
                RFixLog.e("RFix.SecurityCheck", "verifyPatchSignature fail!", e16);
                PatchFileUtils.closeQuietly(jarFile);
                return false;
            }
        } catch (Throwable th7) {
            th5 = th7;
            PatchFileUtils.closeQuietly(obj);
            throw th5;
        }
    }
}
