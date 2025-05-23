package com.tencent.open.agent.quickauth;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/open/agent/quickauth/ad;", "", "", "packageName", "Lcom/tencent/open/agent/quickauth/aa;", "c", "Landroid/content/Context;", "context", "b", "urlString", "Landroid/os/Bundle;", "d", "targetSignature", "", "a", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ad f340395a = new ad();

    ad() {
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[Catch: Exception -> 0x00c1, TryCatch #0 {Exception -> 0x00c1, blocks: (B:33:0x0005, B:7:0x0012, B:9:0x002c, B:10:0x0034, B:12:0x003a, B:18:0x004b, B:19:0x005b, B:21:0x006e, B:23:0x007b, B:31:0x0057), top: B:32:0x0005 }] */
    @JvmStatic
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final QuickAuthAppInfo c(@Nullable String packageName) {
        boolean z16;
        List emptyList;
        boolean z17;
        if (packageName != null) {
            try {
                if (packageName.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return null;
                    }
                    StringBuilder sb5 = new StringBuilder("https://imgcache.qq.com/wtlogin/app");
                    List<String> split = new Regex("\\.").split(packageName, 0);
                    if (!split.isEmpty()) {
                        ListIterator<String> listIterator = split.listIterator(split.size());
                        while (listIterator.hasPrevious()) {
                            if (listIterator.previous().length() == 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    Object[] array = emptyList.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    for (String str : (String[]) array) {
                        sb5.append('/');
                        sb5.append(str);
                    }
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(base).appl\u2026\n            }.toString()");
                    return new QuickAuthAppInfo(sb6 + "/icon.png", sb6 + "/ad_img.png", sb6 + "/profile.js");
                }
            } catch (Exception unused) {
                return null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final boolean a(@NotNull Context context, @NotNull String packageName, @NotNull String targetSignature) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(targetSignature, "targetSignature");
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 64);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g\u2026RES\n                    )");
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuilder sb5 = new StringBuilder();
            int length = digest.length;
            for (int i3 = 0; i3 < length; i3++) {
                String hexString = Integer.toHexString(digest[i3] & 255);
                Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(0xFF and publicKey[i].toInt())");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String upperCase = hexString.toUpperCase(US);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                if (upperCase.length() == 1) {
                    sb5.append("0");
                }
                sb5.append(upperCase);
                if (i3 != digest.length - 1) {
                    sb5.append(":");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebQuickAuthHandler", 2, "checkSignature packageName:", packageName, " targetSig:", targetSignature, " hexStr:", sb5);
            }
            return Intrinsics.areEqual(targetSignature, sb5.toString());
        } catch (Throwable th5) {
            QLog.e("WebQuickAuthHandler", 1, th5, new Object[0]);
            return false;
        }
    }

    @NotNull
    public final String b(@NotNull Context context, @NotNull String packageName) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "packageManager.getApplicationInfo(packageName, 0)");
            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            if (applicationLabel instanceof String) {
                str = (String) applicationLabel;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        } catch (PackageManager.NameNotFoundException e16) {
            QLog.e("QuickAuthUtils", 1, "getAppName exception", e16);
            return "";
        }
    }

    @NotNull
    public final Bundle d(@NotNull String urlString) {
        String args;
        List emptyList;
        int indexOf$default;
        boolean z16;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Bundle bundle = new Bundle();
        try {
            args = new URL(urlString).getQuery();
        } catch (MalformedURLException unused) {
        }
        if (TextUtils.isEmpty(args)) {
            return bundle;
        }
        Intrinsics.checkNotNullExpressionValue(args, "args");
        List<String> split = new Regex(ContainerUtils.FIELD_DELIMITER).split(args, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', 0, false, 6, (Object) null);
            if (indexOf$default > 0) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring2 = str.substring(indexOf$default + 1, str.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                bundle.putString(substring, substring2);
            }
        }
        return bundle;
    }
}
