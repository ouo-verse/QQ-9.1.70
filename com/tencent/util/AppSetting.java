package com.tencent.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007J\b\u0010\n\u001a\u00020\u0005H\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007J\b\u0010\u0013\u001a\u00020\u000eH\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\u000eH\u0007J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\b\u0010\u001c\u001a\u00020\u000eH\u0007R\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/util/AppSetting;", "", "", "initQAutoInject", "ensureInject", "", "isDebugVersion", "isGrayVersion", "isPublicVersion", "isGooglePlayVersion", "isUiTest", "isCpu64Bit", "isEnable", "setEnableRegBcsInSubThread", "", "getBranchName", "getSubVersion", "getRevision", "getVersion", "getBuildNum", "getAboutSubVersionLog", "getReportVersionName", "getAppSubVersionName", "", "getAppId", "Landroid/content/Context;", "context", "getVersionCode", "getChannel", "TAG", "Ljava/lang/String;", "Lcom/tencent/mobileqq/inject/b;", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Lcom/tencent/mobileqq/inject/b;", "getDefaultValue", "()Lcom/tencent/mobileqq/inject/b;", "sAppSetting", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class AppSetting {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final AppSetting INSTANCE;

    @NotNull
    private static final String TAG = "AppSetting";

    @NotNull
    private static final com.tencent.mobileqq.inject.b defaultValue;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQPerf/Inject_AppSetting.yml", version = 1)
    @NotNull
    private static com.tencent.mobileqq.inject.b sAppSetting;
    private static ArrayList sAppSetting_AutoGenClazzList_QAutoInjectTransform;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u000eH\u0016\u00a8\u0006$"}, d2 = {"com/tencent/util/AppSetting$a", "Lcom/tencent/mobileqq/inject/b;", "", "isDebugVersion", "isGrayVersion", "isPublicVersion", "isGooglePlayVersion", "isUiTest", "c", "enableTalkBack", "j", "isEnable", "", "k", "", "getBranchName", "getSubVersion", "e", "getVersion", "f", "i", "getReportVersionName", "g", "d", "", "getAppId", "Landroid/content/Context;", "context", "b", tl.h.F, "isSplitViewMode", "isAllowLandscape", "getQUA", "getQimei36", "a", "getChannel", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class a implements com.tencent.mobileqq.inject.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.inject.b
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return "InjectFailedVersionCode";
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return "InjectFailedQuaMainVersion";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "InjectFailedRevision";
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean enableTalkBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "InjectFailedBuildNum";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return "InjectFailedAppSubVersionName";
        }

        @Override // com.tencent.mobileqq.inject.b
        public int getAppId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getBranchName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "InjectFailedBranchName";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getChannel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (String) iPatchRedirector.redirect((short) 30, (Object) this);
            }
            return "";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getQUA() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (String) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return "";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getQimei36() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (String) iPatchRedirector.redirect((short) 27, (Object) this);
            }
            return "InjectFailedQimei36";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getReportVersionName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return "InjectFailedReportVersionName";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getSubVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "InjectFailedSubVersion";
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String getVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "InjectFailedVersion";
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean h(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) context)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        @NotNull
        public String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return "InjectFailedSubVersionLog";
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isAllowLandscape(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isDebugVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isGooglePlayVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isGrayVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isPublicVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isSplitViewMode(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean isUiTest() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.inject.b
        public void k(boolean isEnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, isEnable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sAppSetting_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        INSTANCE = new AppSetting();
        a aVar = new a();
        defaultValue = aVar;
        sAppSetting = aVar;
    }

    AppSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ensureInject() {
        if (Intrinsics.areEqual(sAppSetting, defaultValue)) {
            initQAutoInject();
        }
    }

    @JvmStatic
    @NotNull
    public static final String getAboutSubVersionLog() {
        INSTANCE.ensureInject();
        String i3 = sAppSetting.i();
        Intrinsics.checkNotNullExpressionValue(i3, "sAppSetting.aboutSubVersionLog");
        return i3;
    }

    @JvmStatic
    public static final int getAppId() {
        INSTANCE.ensureInject();
        return sAppSetting.getAppId();
    }

    @JvmStatic
    @NotNull
    public static final String getAppSubVersionName() {
        INSTANCE.ensureInject();
        String g16 = sAppSetting.g();
        Intrinsics.checkNotNullExpressionValue(g16, "sAppSetting.appSubVersionName");
        return g16;
    }

    @JvmStatic
    @NotNull
    public static final String getBranchName() {
        INSTANCE.ensureInject();
        String branchName = sAppSetting.getBranchName();
        Intrinsics.checkNotNullExpressionValue(branchName, "sAppSetting.branchName");
        return branchName;
    }

    @JvmStatic
    @NotNull
    public static final String getBuildNum() {
        INSTANCE.ensureInject();
        String f16 = sAppSetting.f();
        Intrinsics.checkNotNullExpressionValue(f16, "sAppSetting.buildNum");
        return f16;
    }

    @JvmStatic
    @NotNull
    public static final String getChannel() {
        INSTANCE.ensureInject();
        String channel = sAppSetting.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "sAppSetting.getChannel()");
        return channel;
    }

    @JvmStatic
    @NotNull
    public static final String getReportVersionName() {
        INSTANCE.ensureInject();
        String reportVersionName = sAppSetting.getReportVersionName();
        Intrinsics.checkNotNullExpressionValue(reportVersionName, "sAppSetting.reportVersionName");
        return reportVersionName;
    }

    @JvmStatic
    @NotNull
    public static final String getRevision() {
        INSTANCE.ensureInject();
        String e16 = sAppSetting.e();
        Intrinsics.checkNotNullExpressionValue(e16, "sAppSetting.revision");
        return e16;
    }

    @JvmStatic
    @NotNull
    public static final String getSubVersion() {
        INSTANCE.ensureInject();
        String subVersion = sAppSetting.getSubVersion();
        Intrinsics.checkNotNullExpressionValue(subVersion, "sAppSetting.subVersion");
        return subVersion;
    }

    @JvmStatic
    @NotNull
    public static final String getVersion() {
        INSTANCE.ensureInject();
        String version = sAppSetting.getVersion();
        Intrinsics.checkNotNullExpressionValue(version, "sAppSetting.version");
        return version;
    }

    @JvmStatic
    @NotNull
    public static final String getVersionCode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.ensureInject();
        String b16 = sAppSetting.b(context);
        Intrinsics.checkNotNullExpressionValue(b16, "sAppSetting.getVersionCode(context)");
        return b16;
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void initQAutoInject() {
        sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(sAppSetting_AutoGenClazzList_QAutoInjectTransform);
        QLog.d(TAG, 2, "QQPerf AppSetting Inject is init.");
    }

    @JvmStatic
    public static final boolean isCpu64Bit() {
        INSTANCE.ensureInject();
        return sAppSetting.c();
    }

    @JvmStatic
    public static final boolean isDebugVersion() {
        INSTANCE.ensureInject();
        return sAppSetting.isDebugVersion();
    }

    @JvmStatic
    public static final boolean isGooglePlayVersion() {
        INSTANCE.ensureInject();
        return sAppSetting.isGooglePlayVersion();
    }

    @JvmStatic
    public static final boolean isGrayVersion() {
        INSTANCE.ensureInject();
        return sAppSetting.isGrayVersion();
    }

    @JvmStatic
    public static final boolean isPublicVersion() {
        INSTANCE.ensureInject();
        return sAppSetting.isPublicVersion();
    }

    @JvmStatic
    public static final boolean isUiTest() {
        INSTANCE.ensureInject();
        return sAppSetting.isUiTest();
    }

    @JvmStatic
    public static final void setEnableRegBcsInSubThread(boolean isEnable) {
        INSTANCE.ensureInject();
        sAppSetting.k(isEnable);
    }

    @NotNull
    public final com.tencent.mobileqq.inject.b getDefaultValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.inject.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return defaultValue;
    }
}
