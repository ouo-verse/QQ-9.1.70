package com.tencent.mobileqq.rfix;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixListener;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.lib.event.ConfigEvent;
import com.tencent.rfix.lib.event.DownloadEvent;
import com.tencent.rfix.lib.event.InstallEvent;
import com.tencent.rfix.lib.lite.RFixInitializer;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R6\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a`\u001c8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u001d\u0012\u0004\b\u001e\u0010\u0015R$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0019j\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/rfix/a;", "", "Lcom/tencent/rfix/loader/entity/RFixLoadResult;", "result", "", "processName", "", "j", "", "f", "i", "c", "d", h.F, "Lcom/tencent/rfix/lib/RFix;", "e", "observe", "g", "b", "Lcom/tencent/rfix/loader/entity/RFixLoadResult;", "getLoadResult$annotations", "()V", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "Z", "initialized", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/rfix/lib/RFixListener;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getListenerClasses$annotations", "listenerClasses", "listeners", "Lcom/tencent/rfix/lib/event/InstallEvent;", "Lcom/tencent/rfix/lib/event/InstallEvent;", "installEvent", "<init>", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f281292a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static RFixLoadResult loadResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean initialized;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/QQFeatureSwitch-kit/Inject_RFixListeners.xml", version = 1)
    @NotNull
    private static final ArrayList<Class<RFixListener>> listenerClasses;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<RFixListener> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static InstallEvent installEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/rfix/a$a", "Lcom/tencent/rfix/lib/RFixListener;", "", "success", "", QzoneIPCModule.RESULT_CODE, "Lcom/tencent/rfix/lib/event/ConfigEvent;", "event", "", "onConfig", "Lcom/tencent/rfix/lib/event/DownloadEvent;", "onDownload", "Lcom/tencent/rfix/lib/event/InstallEvent;", "onInstall", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.rfix.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8514a implements RFixListener {
        static IPatchRedirector $redirector_;

        C8514a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.rfix.lib.RFixListener
        public void onConfig(boolean success, int resultCode, @Nullable ConfigEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(success), Integer.valueOf(resultCode), event);
                return;
            }
            Iterator it = a.listeners.iterator();
            while (it.hasNext()) {
                ((RFixListener) it.next()).onConfig(success, resultCode, event);
            }
        }

        @Override // com.tencent.rfix.lib.RFixListener
        public void onDownload(boolean success, int resultCode, @Nullable DownloadEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(success), Integer.valueOf(resultCode), event);
                return;
            }
            Iterator it = a.listeners.iterator();
            while (it.hasNext()) {
                ((RFixListener) it.next()).onDownload(success, resultCode, event);
            }
        }

        @Override // com.tencent.rfix.lib.RFixListener
        public void onInstall(boolean success, int resultCode, @Nullable InstallEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(success), Integer.valueOf(resultCode), event);
                return;
            }
            if (success) {
                a.installEvent = event;
            }
            Iterator it = a.listeners.iterator();
            while (it.hasNext()) {
                ((RFixListener) it.next()).onInstall(success, resultCode, event);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f281292a = new a();
        listenerClasses = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final String c() {
        InstallEvent installEvent2 = installEvent;
        if (installEvent2 == null) {
            return null;
        }
        return installEvent2.patchResult.patchVersion;
    }

    @JvmStatic
    @Nullable
    public static final String d(@NotNull String processName) {
        boolean z16;
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(processName, "processName");
        if (processName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) processName, ':', 0, false, 6, (Object) null);
            if (lastIndexOf$default < 0) {
                lastIndexOf$default = processName.length() - 1;
            }
            CharSequence subSequence = processName.subSequence(lastIndexOf$default, processName.length());
            MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
            return from.decodeString("rfix_version_proc_" + ((Object) subSequence), "");
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final RFix e() {
        if (!initialized) {
            a aVar = f281292a;
            boolean z16 = true;
            if (MobileQQ.sProcessId != 1) {
                z16 = false;
            }
            aVar.g(z16);
        }
        RFix rFix = RFix.getInstance();
        Intrinsics.checkNotNullExpressionValue(rFix, "getInstance()");
        return rFix;
    }

    @JvmStatic
    public static final boolean f() {
        if (loadResult != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean h() {
        InstallEvent installEvent2 = installEvent;
        if (installEvent2 != null) {
            return installEvent2.patchResult.effectImmediate;
        }
        return false;
    }

    @JvmStatic
    public static final boolean i() {
        RFixLoadResult rFixLoadResult = loadResult;
        if (rFixLoadResult != null) {
            return rFixLoadResult.isLoaderSuccess();
        }
        return false;
    }

    @JvmStatic
    public static final void j(@NotNull RFixLoadResult result, @NotNull String processName) {
        boolean z16;
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(processName, "processName");
        loadResult = result;
        QLog.d("RFixHolder", 1, "saveLoadResult");
        if (processName.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && result.isLoaderSuccess()) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) processName, ':', 0, false, 6, (Object) null);
            if (lastIndexOf$default < 0) {
                lastIndexOf$default = processName.length() - 1;
            }
            CharSequence subSequence = processName.subSequence(lastIndexOf$default, processName.length());
            QLog.d("RFixHolder", 1, "rfix load result: " + result.result + ", for process: " + ((Object) subSequence));
            MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
            from.encodeString("rfix_version_proc_" + ((Object) subSequence), result.patchInfo.version);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(boolean observe) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, observe);
            return;
        }
        synchronized (this) {
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            String str = "";
            if (firstSimpleAccount != null) {
                str = firstSimpleAccount.getUin();
                Intrinsics.checkNotNullExpressionValue(str, "simpleAccount.uin");
            }
            if (initialized) {
                RFixParams params = RFix.getInstance().getParams();
                if (!Intrinsics.areEqual(str, params.getUserId())) {
                    params.setUserId(str);
                    QLog.d("RFixHolder", 1, "switch uid");
                }
                return;
            }
            String str2 = "";
            try {
                str2 = String.valueOf(InstalledAppListMonitor.getPackageInfo(MobileQQ.sMobileQQ.getPackageManager(), MobileQQ.sMobileQQ.getPackageName(), 0).versionCode);
            } catch (Throwable th5) {
                QLog.e("RFixHolder", 1, th5, new Object[0]);
            }
            QLog.d("RFixHolder", 1, "init");
            RFixParams customProperty = new RFixParams(ShiplyImpl.APP_ID, ShiplyImpl.APP_KEY).setAutoRequestEnable(false).setInitMMKVInternal(false).setMainVerifyEnable(false).setDeviceId(o.c()).setDeviceManufacturer(Build.MANUFACTURER).setUserId(str).setCustomProperty("appid", AppSetting.f() + "").setCustomProperty("versionCode", AppSetting.f99551k).setCustomProperty("commitId", AppSetting.f99543c).setCustomProperty("versionCode", str2);
            if (PrivacyPolicyHelper.isUserAllow()) {
                customProperty.setDeviceModel(DeviceInfoMonitor.getModel());
            }
            if (loadResult == null) {
                QLog.e("RFixHolder", 1, "load result is null");
                return;
            }
            if (observe) {
                Iterator<T> it = listenerClasses.iterator();
                while (it.hasNext()) {
                    try {
                        listeners.add(((Class) it.next()).getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Throwable th6) {
                        QLog.e("RFixHolder", 1, th6, new Object[0]);
                    }
                }
                Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
                RFixInitializer.initialize((Application) applicationContext, loadResult, customProperty, new C8514a());
            } else {
                Context applicationContext2 = MobileQQ.sMobileQQ.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
                RFixInitializer.initialize((Application) applicationContext2, loadResult, customProperty);
            }
            initialized = RFix.isInitialized();
            Unit unit = Unit.INSTANCE;
        }
    }
}
