package com.tencent.biz.richframework.util;

import android.app.Application;
import android.content.pm.PackageManager;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/richframework/util/RFWAppUtil;", "", "", "appName$delegate", "Lkotlin/Lazy;", "getAppName", "()Ljava/lang/String;", "appName", "", "versionCode$delegate", "getVersionCode", "()I", "versionCode", "targetVersion$delegate", "getTargetVersion", "targetVersion", "ANDROID_ID$delegate", "getANDROID_ID", "ANDROID_ID", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWAppUtil {

    @NotNull
    public static final RFWAppUtil INSTANCE = new RFWAppUtil();

    /* renamed from: appName$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy appName = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.biz.richframework.util.RFWAppUtil$appName$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str;
            try {
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                PackageManager packageManager = application.getPackageManager();
                Application application2 = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
                int i3 = InstalledAppListMonitor.getPackageInfo(packageManager, application2.getPackageName(), 0).applicationInfo.labelRes;
                Application application3 = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application3, "RFWApplication.getApplication()");
                str = application3.getResources().getString(i3);
            } catch (PackageManager.NameNotFoundException unused) {
                RFWLog.e("RFWAppUtil", RFWLog.USR, "[getAppName] package not found.");
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n            val pa\u2026\n            \"\"\n        }");
            return str;
        }
    });

    /* renamed from: versionCode$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy versionCode = LazyKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.richframework.util.RFWAppUtil$versionCode$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            try {
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                PackageManager packageManager = application.getPackageManager();
                Application application2 = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
                return InstalledAppListMonitor.getPackageInfo(packageManager, application2.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                RFWLog.e("RFWAppUtil", RFWLog.USR, "[getAppName] package not found.");
                return 0;
            }
        }
    });

    /* renamed from: targetVersion$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy targetVersion = LazyKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.richframework.util.RFWAppUtil$targetVersion$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Application application = RFWApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
            return application.getApplicationInfo().targetSdkVersion;
        }
    });

    /* renamed from: ANDROID_ID$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy ANDROID_ID = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.biz.richframework.util.RFWAppUtil$ANDROID_ID$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Application application = RFWApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
            return DeviceInfoMonitor.getString(application.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        }
    });

    RFWAppUtil() {
    }

    @NotNull
    public final String getANDROID_ID() {
        return (String) ANDROID_ID.getValue();
    }

    @NotNull
    public final String getAppName() {
        return (String) appName.getValue();
    }

    public final int getTargetVersion() {
        return ((Number) targetVersion.getValue()).intValue();
    }

    public final int getVersionCode() {
        return ((Number) versionCode.getValue()).intValue();
    }
}
