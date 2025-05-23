package com.tencent.rmonitor.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/rmonitor/common/util/b;", "", "Landroid/content/Context;", "context", "", "e", "f", "d", "", "productVersion", "g", "rdmUuid", h.F, "c", "b", "", "a", "Ljava/lang/String;", "appVersion", "Z", "userSetAppVersion", "buildNo", "manifestVersionName", "manifestVersionCode", "hasParsePackageInfo", "appVersionFromMeta", "buildNoFromMeta", "i", "hasParseMetadata", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean userSetAppVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean hasParsePackageInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean hasParseMetadata;

    /* renamed from: j, reason: collision with root package name */
    public static final b f365535j = new b();

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

    b() {
    }

    private final void d() {
        boolean z16;
        if (userSetAppVersion) {
            Logger.f365497g.i("RMonitor_AppVersionHelper", "checkAppVersion for userSetVersion is true");
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
                    Logger.f365497g.i("RMonitor_AppVersionHelper", "checkAppVersion, old:" + appVersion + ", new: " + str2);
                    appVersion = str2;
                    return;
                }
                return;
            }
        }
        Logger.f365497g.i("RMonitor_AppVersionHelper", "checkAppVersion for versionName is null or empty");
    }

    private final void e(Context context) {
        if (context == null) {
            Logger.f365497g.i("RMonitor_AppVersionHelper", "parseAppVersionFromPackageInfo for context is null");
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
            Logger.f365497g.c("RMonitor_AppVersionHelper", th5);
        }
        Logger.f365497g.i("RMonitor_AppVersionHelper", "parseAppVersionFromPackageInfo, manifestVersionName: " + manifestVersionName + ", manifestVersionCode: " + manifestVersionCode);
    }

    private final void f(Context context) {
        String str;
        String obj;
        if (context == null) {
            Logger.f365497g.i("RMonitor_AppVersionHelper", "parseMetaData fail for context is null");
            return;
        }
        if (hasParseMetadata) {
            return;
        }
        hasParseMetadata = true;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkExpressionValueIsNotNull(applicationInfo, "manager.getApplicationIn\u2026ageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                Object obj2 = bundle.get("BUGLY_APP_VERSION");
                Object obj3 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
                String str2 = "";
                if (obj2 == null || (str = obj2.toString()) == null) {
                    str = "";
                }
                appVersionFromMeta = str;
                if (obj3 != null && (obj = obj3.toString()) != null) {
                    str2 = obj;
                }
                buildNoFromMeta = str2;
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_AppVersionHelper", th5);
        }
        Logger.f365497g.i("RMonitor_AppVersionHelper", "parseMetaData, appVersionFromMeta: " + appVersionFromMeta + ", buildNoFromMeta: " + buildNoFromMeta);
    }

    public final boolean a(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return false;
            }
            if ((applicationInfo.flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @NotNull
    public final String b(@Nullable Context context) {
        if (TextUtils.isEmpty(appVersion)) {
            e(context);
            if (!TextUtils.isEmpty(manifestVersionName)) {
                appVersion = manifestVersionName;
            }
            f(context);
            if (!TextUtils.isEmpty(appVersionFromMeta)) {
                appVersion = appVersionFromMeta;
            }
        }
        d();
        return appVersion;
    }

    @NotNull
    public final String c(@Nullable Context context) {
        if (TextUtils.isEmpty(buildNo)) {
            f(context);
            if (!TextUtils.isEmpty(buildNoFromMeta)) {
                buildNo = buildNoFromMeta;
            }
        }
        return buildNo;
    }

    public final void g(@NotNull String productVersion) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(productVersion, "productVersion");
        Logger.f365497g.i("RMonitor_AppVersionHelper", "setProductVersion, old:" + appVersion + ", new: " + productVersion);
        if (productVersion.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            appVersion = "";
            BaseInfo.userMeta.appVersion = "";
            userSetAppVersion = false;
            hasParseMetadata = false;
            hasParsePackageInfo = false;
            return;
        }
        appVersion = productVersion;
        BaseInfo.userMeta.appVersion = productVersion;
        userSetAppVersion = true;
    }

    public final void h(@NotNull String rdmUuid) {
        Intrinsics.checkParameterIsNotNull(rdmUuid, "rdmUuid");
        boolean z16 = true;
        Logger.f365497g.i("RMonitor_AppVersionHelper", "setRdmUuid, old:" + buildNo + ", new: " + rdmUuid);
        if (rdmUuid.length() != 0) {
            z16 = false;
        }
        if (z16) {
            buildNo = "";
            BaseInfo.userMeta.buildNumber = "";
            hasParseMetadata = false;
        } else {
            buildNo = rdmUuid;
            BaseInfo.userMeta.buildNumber = rdmUuid;
        }
    }
}
