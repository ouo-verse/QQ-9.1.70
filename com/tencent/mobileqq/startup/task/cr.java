package com.tencent.mobileqq.startup.task;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cr;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "msg", "", "c", "", "b", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "d", "a", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class cr extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cr$a;", "", "", "LOCAL_PHONE_TIPS", "Ljava/lang/String;", "TAG", "UNITED_CONFIG_DOWNGRADE", "UNITED_CONFIG_WT_UPGRADE", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.cr$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45330);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public cr() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        int i3;
        boolean startsWith$default;
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        String packageName = BaseApplication.context.getPackageName();
        if (runningAppProcesses != null) {
            List<ActivityManager.RunningAppProcessInfo> list = runningAppProcesses;
            if ((list instanceof Collection) && list.isEmpty()) {
                i3 = 0;
            } else {
                Iterator<T> it = list.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    String str = ((ActivityManager.RunningAppProcessInfo) it.next()).processName;
                    Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, packageName, false, 2, null);
                    if (startsWith$default && (i3 = i3 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            Iterator<T> it5 = list.iterator();
            boolean z16 = false;
            while (it5.hasNext()) {
                if (TextUtils.equals(packageName, ((ActivityManager.RunningAppProcessInfo) it5.next()).processName)) {
                    z16 = true;
                }
            }
            if (i3 == 1 && z16) {
                return true;
            }
        }
        return false;
    }

    private final void c(final String msg2) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), MobileQQ.FILE_COMMON)");
        if (from.decodeBool("local_phone_tips", false)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.startup.task.cq
                @Override // java.lang.Runnable
                public final void run() {
                    cr.d(msg2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(MobileQQ.sMobileQQ, msg2, 1).show();
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), MobileQQ.FILE_COMMON)");
        boolean decodeBool = from.decodeBool("login_hard_use_wt" + AppSetting.f99551k, false);
        boolean decodeBool2 = from.decodeBool(MobileQQ.NT_LOGIN_SWITCH_KEY, false);
        if (decodeBool) {
            QLog.d("WTUpgradeTask", 1, "login_hard_use_wt");
            c("\u540e\u53f0\u5bb9\u707e\u5f00\u5173\u5f00\u542f, \u5f3a\u5236\u4f7f\u7528WT\u6d41\u7a0b");
            if (decodeBool2) {
                from.encodeBool(MobileQQ.NT_LOGIN_SWITCH_KEY, false);
                ((ILoginService) QRoute.api(ILoginService.class)).deleteAllLoginTicket();
                return;
            }
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("wt_login_upgrade", false);
        String str = "\u4f7f\u7528NT\u6d41\u7a0b";
        if (decodeBool2 == isSwitchOn) {
            QLog.d("WTUpgradeTask", 1, "is Login by NT: " + isSwitchOn);
            if (!decodeBool2) {
                str = "\u4f7f\u7528WT\u6d41\u7a0b";
            }
            c(str);
            return;
        }
        if (isSwitchOn) {
            if (b()) {
                QLog.d("WTUpgradeTask", 1, "isOnlyMainProcessRunning");
                from.encodeBool(MobileQQ.NT_LOGIN_SWITCH_KEY, true);
                c("\u4f7f\u7528NT\u6d41\u7a0b");
                return;
            } else {
                QLog.e("WTUpgradeTask", 1, "not only main process");
                c("\u5176\u4ed6\u8fdb\u7a0b\u5b58\u5728, \u65e0\u6cd5\u5f00\u542fNT\u767b\u5f55");
                return;
            }
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("nt_login_downgrade", false)) {
            from.encodeBool(MobileQQ.NT_LOGIN_SWITCH_KEY, false);
            ((ILoginService) QRoute.api(ILoginService.class)).deleteAllLoginTicket();
            QLog.d("WTUpgradeTask", 1, "close nt, use wt login");
            c("\u5f3a\u5236\u4f7f\u7528WT\u6d41\u7a0b");
            return;
        }
        QLog.d("WTUpgradeTask", 1, "canNTLoginDowngrade is false, can not downgrade");
        c("\u964d\u7ea7\u5f00\u5173\u672a\u5f00\uff0c\u7981\u6b62\u964d\u7ea7");
    }
}
