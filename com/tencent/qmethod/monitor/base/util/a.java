package com.tencent.qmethod.monitor.base.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/a;", "", "Landroid/content/Context;", "context", "", "d", "e", "c", "", "b", "a", "Ljava/lang/String;", "appVersion", "", "Z", "userSetAppVersion", "buildNo", "manifestVersionName", "manifestVersionCode", "f", "hasParsePackageInfo", "g", "appVersionFromMeta", tl.h.F, "buildNoFromMeta", "i", "hasParseMetadata", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean userSetAppVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean hasParsePackageInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean hasParseMetadata;

    /* renamed from: j, reason: collision with root package name */
    public static final a f343531j = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String appVersion = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String buildNo = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String manifestVersionName = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String manifestVersionCode = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String appVersionFromMeta = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String buildNoFromMeta = "";

    a() {
    }

    private final void c() {
        boolean z16;
        if (userSetAppVersion) {
            o.e("AppVersionHelper", "checkAppVersion for userSetVersion is true");
            return;
        }
        String str = appVersion;
        if (str != null) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                char[] charArray = str.toCharArray();
                Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
                int i3 = 0;
                for (char c16 : charArray) {
                    if (c16 == '.') {
                        i3++;
                    }
                }
                if (i3 < 3) {
                    String str2 = str + '.' + manifestVersionCode;
                    o.e("AppVersionHelper", "checkAppVersion, old:" + appVersion + ", new: " + str2);
                    appVersion = str2;
                    return;
                }
                return;
            }
        }
        o.e("AppVersionHelper", "checkAppVersion for versionName is null or empty");
    }

    private final void d(Context context) {
        if (context == null) {
            o.e("AppVersionHelper", "parseAppVersionFromPackageInfo for context is null");
            return;
        }
        if (hasParsePackageInfo) {
            return;
        }
        hasParsePackageInfo = true;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = "";
                }
                manifestVersionName = str;
                manifestVersionCode = String.valueOf(packageInfo.versionCode);
            }
        } catch (Throwable th5) {
            o.d("AppVersionHelper", "parseAppVersionFromPackageInfo", th5);
        }
        o.e("AppVersionHelper", "parseAppVersionFromPackageInfo, manifestVersionName: " + manifestVersionName + ", manifestVersionCode: " + manifestVersionCode);
    }

    private final void e(Context context) {
        CharSequence reversed;
        String str;
        String obj;
        if (context == null) {
            o.e("AppVersionHelper", "parseMetaData fail for context is null");
            return;
        }
        if (hasParseMetadata) {
            return;
        }
        hasParseMetadata = true;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkExpressionValueIsNotNull(applicationInfo, "manager.getApplicationIn\u2026T_META_DATA\n            )");
            Object obj2 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            Bundle bundle = applicationInfo.metaData;
            reversed = StringsKt___StringsKt.reversed((CharSequence) "=QWa1VnLtRmcuQnblNmblRnLt92Y");
            byte[] decode = Base64.decode(reversed.toString(), 2);
            Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(\"=QWa1VnLt\u2026versed(), Base64.NO_WRAP)");
            Object obj3 = bundle.get(new String(decode, Charsets.UTF_8));
            String str2 = "";
            if (obj2 == null || (str = obj2.toString()) == null) {
                str = "";
            }
            appVersionFromMeta = str;
            if (obj3 != null && (obj = obj3.toString()) != null) {
                str2 = obj;
            }
            buildNoFromMeta = str2;
        } catch (Throwable th5) {
            o.d("AppVersionHelper", "parseMetaData", th5);
        }
        o.e("AppVersionHelper", "parseMetaData, appVersionFromMeta: " + appVersionFromMeta + ", buildNoFromMeta: " + buildNoFromMeta);
    }

    @NotNull
    public final String a(@Nullable Context context) {
        if (TextUtils.isEmpty(appVersion)) {
            d(context);
            if (!TextUtils.isEmpty(manifestVersionName)) {
                appVersion = manifestVersionName;
            }
            e(context);
            if (!TextUtils.isEmpty(appVersionFromMeta)) {
                appVersion = appVersionFromMeta;
            }
        }
        c();
        if (TextUtils.isEmpty(appVersion)) {
            return "unknown";
        }
        return appVersion;
    }

    @NotNull
    public final String b(@Nullable Context context) {
        if (TextUtils.isEmpty(buildNo)) {
            e(context);
            if (!TextUtils.isEmpty(buildNoFromMeta)) {
                buildNo = buildNoFromMeta;
            }
        }
        return buildNo;
    }
}
