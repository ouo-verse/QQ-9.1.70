package com.tencent.mobileqq.util.privacy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001a \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001ak\u0010\r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022:\u0010\f\u001a6\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t\u00a2\u0006\u0004\b\r\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001a \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001a \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001ak\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022:\u0010\f\u001a6\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t\u00a2\u0006\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Landroid/content/Context;", "context", "", PushClientConstants.TAG_PKG_NAME, "business", "", "f", "a", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "c", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "arrayStr", "b", "g", "e", "pkgNameArray", "d", "QQCommon_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PackageInstallMonitorKt {
    @NotNull
    public static final String a(@NotNull Context context, @Nullable String str, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        String str2 = (String) c(context, str, business, new Function2<Context, String, String>() { // from class: com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt$checkAppInstalled$result$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final String invoke(@NotNull Context ctx, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                return PackageUtil.checkAppInstalled(ctx, str3);
            }
        });
        if (str2 == null) {
            return "0";
        }
        return str2;
    }

    @NotNull
    public static final String b(@NotNull Context context, @Nullable String str, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        String str2 = (String) d(context, str, business, new Function2<Context, String, String>() { // from class: com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt$checkAppInstalledBatch$result$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final String invoke(@NotNull Context ctx, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                return PackageUtil.checkAppInstalledBatch(ctx, str3);
            }
        });
        if (str2 == null) {
            return "0";
        }
        return str2;
    }

    @Nullable
    public static final <T> T c(@NotNull Context context, @Nullable String str, @NotNull String business, @NotNull Function2<? super Context, ? super String, ? extends T> result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(business)) {
            JSONArray a16 = PackageInstallWhiteListConfigProcessor.INSTANCE.a(business);
            if (a16 != null && a16.length() > 0) {
                int length = a16.length();
                for (int i3 = 0; i3 < length; i3++) {
                    if (TextUtils.equals(a16.get(i3).toString(), str)) {
                        QLog.d("PackageInstallMonitor", 1, "doWhiteListCheck whiteList contains " + str);
                        return result.invoke(context, str);
                    }
                }
                QLog.d("PackageInstallMonitor", 1, "doWhiteListCheck cur package not in config");
                return null;
            }
            QLog.d("PackageInstallMonitor", 1, "doWhiteListCheck get manage config fail");
            return null;
        }
        QLog.d("PackageInstallMonitor", 1, "doWhiteListCheck pkgName: " + str + ", business: " + business);
        return null;
    }

    @Nullable
    public static final <T> T d(@NotNull Context context, @Nullable String str, @NotNull String business, @NotNull Function2<? super Context, ? super String, ? extends T> result) {
        String[] strArr;
        boolean z16;
        String str2;
        List<String> split;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(business)) {
            JSONArray a16 = PackageInstallWhiteListConfigProcessor.INSTANCE.a(business);
            if (a16 != null && a16.length() > 0) {
                if (str != null && (split = new Regex("\\|").split(str, 0)) != null) {
                    Object[] array = split.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    strArr = (String[]) array;
                } else {
                    strArr = null;
                }
                if (strArr != null) {
                    StringBuilder sb5 = new StringBuilder();
                    int length = strArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        int length2 = a16.length();
                        int i16 = 0;
                        while (true) {
                            if (i16 < length2) {
                                if (TextUtils.equals(a16.get(i16).toString(), strArr[i3])) {
                                    QLog.d("PackageInstallMonitor", 1, "doWhiteListCheckBatch whiteList contains " + strArr[i3]);
                                    z16 = true;
                                    break;
                                }
                                i16++;
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (i3 > 0) {
                            sb5.append("|");
                        }
                        if (z16) {
                            str2 = strArr[i3];
                        } else {
                            str2 = "unauthorized";
                        }
                        sb5.append(str2);
                    }
                    return result.invoke(context, sb5.toString());
                }
                QLog.d("PackageInstallMonitor", 1, "doWhiteListCheckBatch invalid pkgArray: " + str);
                return null;
            }
            QLog.d("PackageInstallMonitor", 1, "doWhiteListCheckBatch get manage config fail");
            return null;
        }
        QLog.d("PackageInstallMonitor", 1, "doWhiteListCheckBatch pkgNameArray: " + str + ", business: " + business);
        return null;
    }

    @NotNull
    public static final String e(@NotNull Context context, @Nullable String str, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        String str2 = (String) d(context, str, business, new Function2<Context, String, String>() { // from class: com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt$getAppVersionCodeBatch$result$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final String invoke(@NotNull Context ctx, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                return PackageUtil.getAppsVerionCodeBatch(ctx, str3);
            }
        });
        if (str2 == null) {
            return "0";
        }
        return str2;
    }

    public static final boolean f(@NotNull Context context, @Nullable String str, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        Boolean bool = (Boolean) c(context, str, business, new Function2<Context, String, Boolean>() { // from class: com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt$isAppInstalled$result$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Boolean invoke(@NotNull Context ctx, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                return Boolean.valueOf(PackageUtil.isAppInstalled(ctx, str2));
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @NotNull
    public static final String g(@NotNull Context context, @Nullable String str, @NotNull String business) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(business, "business");
        String str2 = (String) d(context, str, business, new Function2<Context, String, String>() { // from class: com.tencent.mobileqq.util.privacy.PackageInstallMonitorKt$isAppInstalledBatch$result$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final String invoke(@NotNull Context ctx, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                return PackageUtil.isAppInstalledBatch(ctx, str3);
            }
        });
        if (str2 == null) {
            return "0";
        }
        return str2;
    }
}
