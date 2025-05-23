package com.tencent.luggage.wxa.yq;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.q0;
import com.tencent.luggage.wxa.ar.s0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.v;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebClassLoaderWrapper;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.XWebDecompressor;
import com.tencent.xweb.XWebDownloader;
import com.tencent.xweb.XWebEmbedSetting;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class q implements com.tencent.luggage.wxa.zq.c {

    /* renamed from: a, reason: collision with root package name */
    public static int f146118a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f146119a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f146120b = -11;

        /* renamed from: c, reason: collision with root package name */
        public int f146121c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f146122d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f146123e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f146124f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f146125g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f146126h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f146127i = 0;
    }

    public void a() {
        if (!XWebEmbedSetting.getForbidDownloadCode()) {
            b(new f(XWalkEnvironment.LOCAL_TEST_ZIP_NAME, false, 100000000, com.tencent.luggage.wxa.ar.b.b(), 0));
        } else {
            x0.d("XWebRuntimeInstaller", "updateRuntimeFromLocal, turn off dynamic code");
        }
    }

    public a b(m mVar) {
        int i3;
        Map map;
        int i16;
        j0 curSchedulerConfig = mVar.getCurSchedulerConfig();
        x0.a("XWebRuntimeInstaller", "updateFromProvider, target version:" + curSchedulerConfig.f121684l);
        a aVar = new a();
        aVar.f146119a = curSchedulerConfig.f121684l;
        if (!curSchedulerConfig.f121691s) {
            x0.a("XWebRuntimeInstaller", "updateFromProvider, force download");
            aVar.f146120b = -6;
            return aVar;
        }
        if (curSchedulerConfig.f121688p >= 2) {
            x0.a("XWebRuntimeInstaller", "updateFromProvider, exceed max count");
            aVar.f146120b = -7;
            return aVar;
        }
        ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
        if (contentResolver == null) {
            x0.a("XWebRuntimeInstaller", "updateFromProvider, content resolver is null");
            aVar.f146120b = -8;
            return aVar;
        }
        f a16 = mVar.a(curSchedulerConfig);
        String[] strArr = XWebCoreContentProvider.XWALK_CORE_PROVIDER_LIST;
        int length = strArr.length;
        boolean z16 = false;
        int i17 = 0;
        while (i17 < length) {
            String str = strArr[i17];
            if (a(contentResolver, str)) {
                x0.a("XWebRuntimeInstaller", "updateFromProvider, find provider:" + str);
                ArrayList a17 = a(a16);
                Map map2 = null;
                int i18 = 0;
                while (true) {
                    if (i18 >= a17.size()) {
                        i3 = -1;
                        map = map2;
                        break;
                    }
                    int intValue = ((Integer) a17.get(i18)).intValue();
                    map = a(contentResolver, str, intValue);
                    if (map == null) {
                        x0.a("XWebRuntimeInstaller", "updateFromProvider, read fileList failed, version:" + intValue);
                        aVar.f146121c = aVar.f146121c + 1;
                    } else {
                        if (map.size() != 0) {
                            i3 = intValue;
                            break;
                        }
                        x0.a("XWebRuntimeInstaller", "updateFromProvider, no matched version, version:" + intValue);
                    }
                    i18++;
                    map2 = map;
                }
                if (i3 < 0) {
                    aVar.f146122d++;
                    i16 = i17;
                } else {
                    x0.a("XWebRuntimeInstaller", "updateFromProvider, find share available version:" + i3);
                    i16 = i17;
                    if (a(contentResolver, str, i3, map, aVar)) {
                        a(aVar, a(i3, a16.f146077l, i3 + "_install_from_share_mode").intValue());
                        if (aVar.f146120b == 0) {
                            return aVar;
                        }
                    }
                }
                z16 = true;
            } else {
                i16 = i17;
            }
            i17 = i16 + 1;
        }
        if (!z16) {
            x0.a("XWebRuntimeInstaller", "updateFromProvider failed, no provider");
            aVar.f146120b = -9;
            return aVar;
        }
        if (XWalkEnvironment.hasAvailableVersion() && curSchedulerConfig.f121688p + 1 < 2) {
            x0.a("XWebRuntimeInstaller", "updateFromProvider failed, can try again");
            aVar.f146120b = -10;
        } else {
            x0.a("XWebRuntimeInstaller", "updateFromProvider failed, do not try again");
            aVar.f146120b = -11;
        }
        return aVar;
    }

    public boolean c(f fVar) {
        if (XWebDownloader.isDownloading()) {
            x0.a("XWebRuntimeInstaller", "updateRuntime, in downloading process");
            s.d();
            return false;
        }
        if (fVar != null && fVar.a()) {
            x0.a("XWebRuntimeInstaller", "updateRuntime, start download runtime");
            XWebDownloader.startDownload(new p(fVar, this), fVar);
            return true;
        }
        x0.a("XWebRuntimeInstaller", "updateRuntime, updateConfig is invalid");
        n0.i();
        s.d();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    public boolean a(Context context, boolean z16) {
        ?? r06;
        InputStream inputStream;
        x0.d("XWebRuntimeInstaller", "tryLoadLocalAssetRuntime, isReplaceOld:" + z16);
        if (z16 && XWalkEnvironment.getAvailableVersion() == 100000000) {
            q0.a(100000000);
        }
        if (XWalkEnvironment.getAvailableVersion() == -1 || z16) {
            InputStream inputStream2 = null;
            try {
                inputStream = context.getAssets().open(XWalkEnvironment.LOCAL_TEST_ZIP_NAME);
                try {
                    try {
                        File file = new File(u0.i(100000000));
                        if (file.exists()) {
                            file.delete();
                        }
                        r06 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1048576];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read != -1) {
                                    r06.write(bArr, 0, read);
                                } else {
                                    r06.flush();
                                    a();
                                    XWalkEnvironment.reset();
                                    XWalkEnvironment.init(context);
                                    w.a(inputStream);
                                    w.a((Closeable) r06);
                                    return true;
                                }
                            }
                        } catch (IOException e16) {
                            e = e16;
                            inputStream2 = r06;
                            x0.a("XWebRuntimeInstaller", "tryLoadLocalAssetRuntime, error", e);
                            w.a(inputStream);
                            w.a(inputStream2);
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            w.a(inputStream);
                            w.a((Closeable) r06);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r06 = inputStream2;
                        inputStream2 = inputStream;
                        inputStream = inputStream2;
                        w.a(inputStream);
                        w.a((Closeable) r06);
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (IOException e18) {
                e = e18;
                inputStream = null;
            } catch (Throwable th7) {
                th = th7;
                r06 = 0;
                inputStream = inputStream2;
                w.a(inputStream);
                w.a((Closeable) r06);
                throw th;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.zq.c
    public void c(com.tencent.luggage.wxa.zq.e eVar) {
        x0.d("XWebRuntimeInstaller", "Core(" + eVar + ") install start.");
        s.i();
    }

    public boolean a(m mVar) {
        if (XWebCoreContentProvider.isSelfProvider()) {
            return false;
        }
        x0.d("XWebRuntimeInstaller", "updateRuntimeFromProvider, not self provider");
        if (t.d()) {
            x0.d("XWebRuntimeInstaller", "updateRuntimeFromProvider, start updating process");
            a b16 = b(mVar);
            a(b16);
            int i3 = b16.f146120b;
            if (i3 == 0) {
                t.a();
                mVar.saveSchedulerConfig(null);
                s.h();
                return true;
            }
            if (i3 == -10) {
                t.a();
                mVar.onUpdateFailed(b16.f146120b);
                s.a(b16.f146120b);
                return true;
            }
            t.a();
            return false;
        }
        x0.d("XWebRuntimeInstaller", "updateRuntimeFromProvider, start updating process failed");
        return false;
    }

    public static Integer b(f fVar) {
        String b16 = fVar.b();
        x0.d("XWebRuntimeInstaller", "tryInstallRuntime, packageFile:" + b16 + ", extractDir:" + u0.j(fVar.f146073h));
        if (fVar.f146067b && !y.a(b16, fVar.f146068c)) {
            x0.a("XWebRuntimeInstaller", "downloaded zip md5 check failed");
            return -2;
        }
        if (fVar.f146069d) {
            if (!o.a(b16, fVar.f146070e, fVar.f146073h, fVar.f146078m)) {
                x0.a("XWebRuntimeInstaller", "patch update mode, do patch error");
                return -3;
            }
            if (fVar.f146067b) {
                int i3 = fVar.f146073h;
                if (!v.a(i3, u0.m(i3))) {
                    x0.a("XWebRuntimeInstaller", "patch update mode, md5 not match");
                    n0.a(36L, 1);
                    return -4;
                }
            }
            x0.a("XWebRuntimeInstaller", "do patch update success");
        } else {
            if (!XWebDecompressor.decompressDownloadZip(b16, u0.j(fVar.f146073h))) {
                x0.a("XWebRuntimeInstaller", "full update mode, decompress full zip error");
                n0.a(32L, 1);
                return -5;
            }
            File file = new File(u0.a(fVar.f146073h, "base.apk"));
            w.a(file.getAbsolutePath(), u0.e(fVar.f146073h));
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (fVar.f146067b) {
                int i16 = fVar.f146073h;
                if (!v.a(i16, u0.h(i16))) {
                    x0.a("XWebRuntimeInstaller", "full update mode, md5 not match");
                    n0.a(33L, 1);
                    return -4;
                }
            }
            x0.a("XWebRuntimeInstaller", "do full update success");
        }
        return a(fVar.f146073h, fVar.f146077l, fVar.f146074i);
    }

    public void a(a aVar) {
        try {
            String packageName = XWalkEnvironment.getPackageName();
            String str = aVar.f146120b + "," + packageName + "," + aVar.f146119a + "," + aVar.f146121c + "," + aVar.f146122d + "," + aVar.f146123e + "," + aVar.f146124f + "," + aVar.f146125g + "," + aVar.f146126h + "," + aVar.f146127i + "," + XWebSdk.getXWebSdkVersion() + "," + XWebSdk.getAvailableVersion();
            ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
            if (contentResolver != null) {
                Uri buildUri = XWebCoreContentProvider.buildUri("com.tencent.mm", packageName, 3, 0, "");
                ContentValues contentValues = new ContentValues();
                contentValues.put(String.valueOf(15626), str);
                contentResolver.insert(buildUri, contentValues);
            }
        } catch (Throwable th5) {
            x0.d("XWebRuntimeInstaller", "reportForUpdateRuntimeFromProvider, report error:" + th5);
        }
    }

    public final void a(a aVar, int i3) {
        if (i3 == 0) {
            aVar.f146120b = 0;
            return;
        }
        if (i3 == -5) {
            aVar.f146125g++;
        } else if (i3 == -12) {
            aVar.f146127i++;
        } else if (i3 == -101) {
            aVar.f146126h++;
        }
    }

    public final ArrayList a(f fVar) {
        String[] split;
        String cmd = CommandCfg.getInstance().getCmd("SHARE_CORE_LIST", "tools");
        x0.d("XWebRuntimeInstaller", "getSharedCoreVersionList, SHARE_CORE_LIST: " + cmd);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(fVar.f146073h));
        if (!TextUtils.isEmpty(cmd) && !XWalkEnvironment.hasInstalledAvailableVersion() && (split = cmd.split(";")) != null) {
            for (String str : split) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        if (fVar.f146073h != parseInt) {
                            arrayList.add(Integer.valueOf(parseInt));
                        }
                    } catch (Throwable th5) {
                        x0.a("XWebRuntimeInstaller", "getSharedCoreVersionList failed, error", th5);
                    }
                }
            }
        }
        return arrayList;
    }

    public final boolean a(ContentResolver contentResolver, String str) {
        if (contentResolver != null && str != null && !str.isEmpty()) {
            try {
                w.a(contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.buildUri(str, XWalkEnvironment.getPackageName(), 1, 0, ""), ""));
                return true;
            } catch (Throwable unused) {
                w.a((Closeable) null);
                return false;
            }
        }
        x0.a("XWebRuntimeInstaller", "isProviderExist, provider package is null");
        return false;
    }

    @Override // com.tencent.luggage.wxa.zq.c
    public void b(com.tencent.luggage.wxa.zq.e eVar) {
        x0.d("XWebRuntimeInstaller", "Core(" + eVar + ") install completed.");
        s.h();
    }

    public final Map a(ContentResolver contentResolver, String str, int i3) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th5;
        BufferedReader bufferedReader;
        PrintWriter printWriter;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        try {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.buildUri(str, XWalkEnvironment.getPackageName(), 2, i3, XWalkPlugin.FILELIST_CONFIG_NAME), "");
            try {
                if (assetFileDescriptor == null) {
                    x0.a("XWebRuntimeInstaller", "tryGetFileList, no filelist.config");
                    w.a((Closeable) null);
                    w.a((Closeable) null);
                    w.a(assetFileDescriptor);
                    return hashMap;
                }
                File file = new File(u0.a(i3, XWalkPlugin.FILELIST_CONFIG_NAME));
                if (file.exists()) {
                    file.delete();
                }
                printWriter = new PrintWriter(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetFileDescriptor.createInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                printWriter.println(readLine);
                                if (!readLine.isEmpty()) {
                                    String[] split = readLine.split(":");
                                    if (split.length == 2 && (str2 = split[0]) != null && !str2.isEmpty() && (str3 = split[1]) != null && !str3.isEmpty()) {
                                        hashMap.put(split[0], split[1]);
                                    }
                                }
                            } else {
                                printWriter.flush();
                                return hashMap;
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            try {
                                x0.a("XWebRuntimeInstaller", "tryGetFileList error", th5);
                                return null;
                            } finally {
                                w.a(printWriter);
                                w.a(bufferedReader);
                                w.a(assetFileDescriptor);
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    bufferedReader = null;
                }
            } catch (Throwable th8) {
                th = th8;
                th5 = th;
                bufferedReader = null;
                printWriter = null;
                x0.a("XWebRuntimeInstaller", "tryGetFileList error", th5);
                return null;
            }
        } catch (Throwable th9) {
            th = th9;
            assetFileDescriptor = null;
        }
    }

    public final boolean a(ContentResolver contentResolver, String str, int i3, Map map, a aVar) {
        File file;
        try {
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.buildUri(str, XWalkEnvironment.getPackageName(), 2, i3, str2), "");
                if (openAssetFileDescriptor == null) {
                    x0.a("XWebRuntimeInstaller", "tryCopyVersionFiles, file not exist, fileName:" + str2);
                    aVar.f146123e = aVar.f146123e + 1;
                    return false;
                }
                if ("base.apk".equals(str2)) {
                    file = new File(u0.e(i3));
                } else {
                    file = new File(u0.a(i3, str2));
                }
                if (!w.a(openAssetFileDescriptor, file)) {
                    x0.a("XWebRuntimeInstaller", "tryCopyVersionFiles, copy file error, fileName:" + str2);
                    aVar.f146123e = aVar.f146123e + 1;
                    return false;
                }
                if (!y.a(file.getAbsolutePath(), str3)) {
                    x0.a("XWebRuntimeInstaller", "tryCopyVersionFiles, md5 error, fileName:" + str2);
                    aVar.f146124f = aVar.f146124f + 1;
                    if (file.exists()) {
                        file.delete();
                    }
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            x0.a("XWebRuntimeInstaller", "tryCopyVersionFiles error", th5);
            aVar.f146123e++;
            return false;
        }
    }

    public void a(boolean z16) {
        com.tencent.luggage.wxa.zq.f.a(com.tencent.luggage.wxa.zq.e.kEmbed).a(false, z16 ? this : null);
    }

    public static Integer a(f fVar, int i3) {
        com.tencent.luggage.wxa.wq.h hVar = new com.tencent.luggage.wxa.wq.h();
        hVar.b(fVar);
        hVar.b(i3);
        hVar.b();
        int intValue = b(fVar).intValue();
        hVar.a(intValue);
        return Integer.valueOf(intValue);
    }

    public static Integer a(int i3, String str, String str2) {
        x0.d("XWebRuntimeInstaller", "tryInstallRuntimeInternal, version:" + i3 + ", abi:" + str + ", versionDetail:" + str2);
        String j3 = u0.j(i3);
        String[] a16 = v.a(i3);
        if (a16 == null) {
            x0.a("XWebRuntimeInstaller", "reslist.config not exist");
            return -5;
        }
        if (!XWebDecompressor.extractResource(u0.e(i3), j3, a16)) {
            x0.a("XWebRuntimeInstaller", "extractResource failed");
            return -5;
        }
        if (v.b(i3, new File(u0.g(i3)))) {
            x0.a("XWebRuntimeInstaller", "checkAllResFileMd5 success");
            if (com.tencent.luggage.wxa.ar.b.b().equalsIgnoreCase(str) && !XWebClassLoaderWrapper.generateOptDex(i3)) {
                n0.a(251L, 1);
                x0.a("XWebRuntimeInstaller", "generate dex opt failed");
            }
            int installedNewstVersionForPredownAbi = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
            boolean a17 = s0.a(i3, str2, str);
            n0.Y();
            x.b("CHECK_FILES_MD5_TIME_KEY");
            if (com.tencent.luggage.wxa.ar.b.b().equalsIgnoreCase(str)) {
                x.a("CLEAR_OLD_APK", 86400000L);
            } else if (installedNewstVersionForPredownAbi > 0 && !CommandCfg.getInstance().getCmdAsBoolean("NOT_CLEAR_PREVE_VER_IMEDEATLY", "tools", false)) {
                x0.a("XWebRuntimeInstaller", "new runtime installed, clear pre version = " + installedNewstVersionForPredownAbi);
                q0.a(installedNewstVersionForPredownAbi);
                n0.a(577L, 65L, 1L);
            }
            if (!a17) {
                x0.a("XWebRuntimeInstaller", "tryInstallRuntimeInternal, set runtime version failed");
                return -101;
            }
            x0.a("XWebRuntimeInstaller", "tryInstallRuntimeInternal success");
            return 0;
        }
        if (f146118a < 1) {
            x0.a("XWebRuntimeInstaller", "checkAllResFileMd5 failed, retry install new runtime");
            f146118a++;
            return a(i3, str, str2);
        }
        x0.a("XWebRuntimeInstaller", "checkAllResFileMd5 failed, can not retry install new runtime");
        return -12;
    }

    @Override // com.tencent.luggage.wxa.zq.c
    public void a(com.tencent.luggage.wxa.zq.e eVar) {
        x0.d("XWebRuntimeInstaller", "Core(" + eVar + ") install cancel.");
        s.g();
    }
}
