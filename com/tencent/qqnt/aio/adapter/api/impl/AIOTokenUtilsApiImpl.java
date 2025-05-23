package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010\"\u001a\u00020\u001d2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\r\u0010\u0007R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000RN\u0010\u0013\u001aB\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000b0\u000b \u0015* \u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00160\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTokenUtilsApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTokenUtilsApi;", "Landroid/content/BroadcastReceiver;", "()V", "enableFix", "", "getEnableFix", "()Z", "enableFix$delegate", "Lkotlin/Lazy;", "enableFixKey", "", "enableReport", "getEnableReport", "enableReport$delegate", "enableReportKey", "hasReport", "Ljava/util/concurrent/atomic/AtomicBoolean;", "reportEvt", "tokenMap", "", "kotlin.jvm.PlatformType", "", "getRealTokenColor", "", "tokenName", "resourceId", "getRealTokenColorNoCache", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "reportToBugly", "params", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOTokenUtilsApiImpl extends BroadcastReceiver implements IAIOTokenUtilsApi {
    static IPatchRedirector $redirector_;

    /* renamed from: enableFix$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy enableFix;

    @NotNull
    private final String enableFixKey;

    /* renamed from: enableReport$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy enableReport;

    @NotNull
    private final String enableReportKey;

    @NotNull
    private final AtomicBoolean hasReport;

    @NotNull
    private final String reportEvt;
    private Map<String, String> tokenMap;

    public AIOTokenUtilsApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.enableFixKey = "aio_bubble_enable_fix";
        this.enableReportKey = "aio_bubble_enable_report";
        this.reportEvt = "aio_bubble_color_err";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOTokenUtilsApiImpl$enableFix$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTokenUtilsApiImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
                str = AIOTokenUtilsApiImpl.this.enableFixKey;
                boolean isSwitchOn = iUnitedConfigManager.isSwitchOn(str, false);
                QLog.d("AIOTokenUtilsApiImpl", 1, "enableFix: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        this.enableFix = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOTokenUtilsApiImpl$enableReport$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTokenUtilsApiImpl.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
                str = AIOTokenUtilsApiImpl.this.enableReportKey;
                boolean isSwitchOn = iUnitedConfigManager.isSwitchOn(str, true);
                QLog.d("AIOTokenUtilsApiImpl", 1, "enableReport: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        this.enableReport = lazy2;
        this.tokenMap = QUIUtil.getCurrentTokenMap();
        this.hasReport = new AtomicBoolean(false);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            mobileQQ.registerReceiver(this, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        }
        QLog.d("AIOTokenUtilsApiImpl", 1, "init, echo map: " + ((Object) this.tokenMap.get("bubble_host_top")));
    }

    private final boolean getEnableFix() {
        return ((Boolean) this.enableFix.getValue()).booleanValue();
    }

    private final boolean getEnableReport() {
        return ((Boolean) this.enableReport.getValue()).booleanValue();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi
    public boolean enableFix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return getEnableFix();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi
    public boolean enableReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!getEnableReport() || !this.hasReport.compareAndSet(false, true)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi
    public int getRealTokenColor(@NotNull String tokenName, int resourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) tokenName, resourceId)).intValue();
        }
        Intrinsics.checkNotNullParameter(tokenName, "tokenName");
        try {
            return Color.parseColor(this.tokenMap.get(tokenName));
        } catch (Throwable unused) {
            QLog.d("AIOTokenUtilsApiImpl", 1, "get color failed: " + tokenName);
            return MobileQQ.sMobileQQ.getResources().getColor(resourceId);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi
    public int getRealTokenColorNoCache(@NotNull String tokenName, int resourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tokenName, resourceId)).intValue();
        }
        Intrinsics.checkNotNullParameter(tokenName, "tokenName");
        try {
            return Color.parseColor(QUIUtil.getCurrentTokenMap().get(tokenName));
        } catch (Throwable unused) {
            QLog.d("AIOTokenUtilsApiImpl", 1, "[getRealTokenColorNoCache] get color failed: " + tokenName);
            return MobileQQ.sMobileQQ.getResources().getColor(resourceId);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intrinsics.checkNotNull(intent);
        if (intent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
            return;
        }
        Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
        this.tokenMap = currentTokenMap;
        QLog.d("AIOTokenUtilsApiImpl", 1, "theme change, update map: " + ((Object) currentTokenMap.get("bubble_host_top")));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi
    public void reportToBugly(@NotNull Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        HashMap hashMap = new HashMap(params);
        hashMap.put("uin", peekAppRuntime.getCurrentUin());
        QLog.d("AIOTokenUtilsApiImpl", 1, "report: " + hashMap);
        QQBeaconReport.report(peekAppRuntime.getCurrentUin(), this.reportEvt, hashMap);
    }
}
