package com.tencent.mobileqq.zplan.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ad;", "", "", "f", "", "d", "", QzoneIPCModule.RESULT_CODE, "", "i", tl.h.F, "j", "e", "b", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    public static final ad f335757a = new ad();

    ad() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        f335757a.j();
    }

    private final String d() {
        boolean contains$default;
        boolean contains$default2;
        String[] strArr = Build.SUPPORTED_ABIS;
        String abi = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        Intrinsics.checkNotNull(abi);
        if (!TextUtils.isEmpty(abi)) {
            Intrinsics.checkNotNullExpressionValue(abi, "abi");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) abi, (CharSequence) "arm64-v8a", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) abi, (CharSequence) "armeabi-v7a", false, 2, (Object) null);
                if (contains$default2) {
                    return "armeabi-v7a";
                }
                return "armeabi";
            }
            return "arm64-v8a";
        }
        return "armeabi";
    }

    private final boolean f() {
        if (cu.e()) {
            if (cu.b() < 51200) {
                return true;
            }
        } else if (cu.c() < 51200) {
            return true;
        }
        return false;
    }

    private final void i(int resultCode) {
        HashMap hashMapOf;
        mb4.c cVar = mb4.c.f416532a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, String.valueOf(resultCode)));
        mb4.c.c(cVar, "e_zplan_ue_so_unzip_result", hashMapOf, false, 4, null);
    }

    public final void b() {
        if (!g()) {
            QLog.i("UESoLoader", 1, "checkAndUnZipFileOnSubThread switch off");
        } else if (h()) {
            QLog.i("UESoLoader", 1, "checkAndUnZipFileOnSubThread ue so exist");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ad.c();
                }
            }, 64, null, true);
        }
    }

    public final void e() {
        File file = new File(BaseApplication.getContext().getCacheDir().getAbsolutePath(), "/zplan/UESoLoader/lib/" + d() + "/");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mobileqq.app.compact.b.b(BaseApplication.context.getClassLoader(), file);
            QLog.i("UESoLoader", 1, "installUE4So cost:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_engine_so_switch", false);
    }

    public final boolean h() {
        String str = BaseApplication.getContext().getApplicationInfo().nativeLibraryDir;
        boolean z16 = new File(str, "libUE4.so").exists() && new File(str, "libUE4Bundle-Splittables.so").exists();
        QLog.i("UESoLoader", 1, "soDir:" + str + " exist:" + z16);
        if (!z16) {
            mb4.c.c(mb4.c.f416532a, "e_zplan_ue_so_not_exist", new HashMap(), false, 4, null);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j() {
        boolean z16;
        Object obj;
        boolean z17;
        boolean contains$default;
        File file;
        boolean z18;
        boolean contains$default2;
        if (f()) {
            QLog.i("UESoLoader", 1, "unzipApkAndGetSoPath storage full");
            i(1);
            return false;
        }
        String packageResourcePath = BaseApplication.getContext().getPackageResourcePath();
        String str = BaseApplication.getContext().getCacheDir().getAbsolutePath() + "/zplan/UESoLoader/";
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = BaseApplication.getContext().getCacheDir().getAbsolutePath() + "/zplan/UESoLoader/lib/" + d() + "/";
        String str3 = str2 + "libUE4.so";
        String str4 = str2 + "libUE4Bundle-Splittables.so";
        Object obj2 = null;
        if (new File(str3).exists()) {
            z16 = true;
        } else {
            try {
                ArrayList<File> unZipSelectedFile = ZipUtils.unZipSelectedFile(new File(packageResourcePath), str, "libUE4.so");
                Intrinsics.checkNotNullExpressionValue(unZipSelectedFile, "unZipSelectedFile(File(a\u2026ipPath, UE4_SO_FILE_NAME)");
                Iterator<T> it = unZipSelectedFile.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    String name = ((File) next).getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "libUE4.so", false, 2, (Object) null);
                    if (contains$default) {
                        obj = next;
                        break;
                    }
                }
                File file2 = (File) obj;
                if (file2 != null) {
                    if (file2.exists()) {
                        z17 = true;
                        z16 = z17;
                    }
                }
                z17 = false;
                z16 = z17;
            } catch (ZipException e16) {
                i(2);
                e16.printStackTrace();
                z16 = false;
                if (!new File(str4).exists()) {
                }
                QLog.i("UESoLoader", 1, "ueSoPath = " + str3 + " ueBundleSoPath = " + str4);
                if (z16) {
                }
                return z16;
            } catch (IOException e17) {
                i(3);
                e17.printStackTrace();
                z16 = false;
                if (!new File(str4).exists()) {
                }
                QLog.i("UESoLoader", 1, "ueSoPath = " + str3 + " ueBundleSoPath = " + str4);
                if (z16) {
                }
                return z16;
            }
        }
        if (!new File(str4).exists()) {
            try {
                ArrayList<File> unZipSelectedFile2 = ZipUtils.unZipSelectedFile(new File(packageResourcePath), str, "libUE4Bundle-Splittables.so");
                Intrinsics.checkNotNullExpressionValue(unZipSelectedFile2, "unZipSelectedFile(File(a\u2026 UE4_BUNDLE_SO_FILE_NAME)");
                Iterator<T> it5 = unZipSelectedFile2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next2 = it5.next();
                    String name2 = ((File) next2).getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name2, (CharSequence) "libUE4Bundle-Splittables.so", false, 2, (Object) null);
                    if (contains$default2) {
                        obj2 = next2;
                        break;
                    }
                }
                file = (File) obj2;
            } catch (ZipException e18) {
                i(4);
                e18.printStackTrace();
                z16 = false;
                QLog.i("UESoLoader", 1, "unzipApkAndGetSoPath cost:" + (System.currentTimeMillis() - currentTimeMillis));
                QLog.i("UESoLoader", 1, "ueSoPath = " + str3 + " ueBundleSoPath = " + str4);
                if (z16) {
                }
                return z16;
            } catch (IOException e19) {
                i(5);
                e19.printStackTrace();
                z16 = false;
                QLog.i("UESoLoader", 1, "unzipApkAndGetSoPath cost:" + (System.currentTimeMillis() - currentTimeMillis));
                QLog.i("UESoLoader", 1, "ueSoPath = " + str3 + " ueBundleSoPath = " + str4);
                if (z16) {
                }
                return z16;
            }
            if (file != null) {
                if (file.exists()) {
                    z18 = true;
                    z16 = z18;
                    QLog.i("UESoLoader", 1, "unzipApkAndGetSoPath cost:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
            z18 = false;
            z16 = z18;
            QLog.i("UESoLoader", 1, "unzipApkAndGetSoPath cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        QLog.i("UESoLoader", 1, "ueSoPath = " + str3 + " ueBundleSoPath = " + str4);
        if (z16) {
            i(0);
        }
        return z16;
    }
}
