package com.tencent.mobileqq.vas.api.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasAppIconStateManager;
import com.tencent.mobileqq.vas.api.IVasAppIconSwitchManager;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\u001c\u001a\u00020\f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/AppIconSwitchManager;", "Lcom/tencent/mobileqq/vas/api/IVasAppIconSwitchManager;", "", "id", "", "isFromJsb", "", "r", "changeToId", "w", "Landroid/content/Context;", "context", "", PushClientConstants.TAG_CLASS_NAME, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "uin", "checkAndSwitchIcon", "changeIconForJsb", "Landroid/content/ComponentName;", "componentName", "v", "u", "d", "Ljava/lang/String;", "getManagerName", "()Ljava/lang/String;", "managerName", "Lcom/tencent/mobileqq/vas/api/IVasAppIconStateManager;", "e", "Lcom/tencent/mobileqq/vas/api/IVasAppIconStateManager;", "stateManager", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AppIconSwitchManager implements IVasAppIconSwitchManager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String managerName = "AppIconSwitchManager";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IVasAppIconStateManager stateManager;

    public AppIconSwitchManager() {
        QRouteApi api = QRoute.api(IVasAppIconStateManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasAppIconStateManager::class.java)");
        this.stateManager = (IVasAppIconStateManager) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AppIconSwitchManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stateManager.setNowIconId(0);
        this$0.w(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AppIconSwitchManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stateManager.setNowIconId(0);
        this$0.w(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AppIconSwitchManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stateManager.setNowIconId(0);
        this$0.w(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AppIconSwitchManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stateManager.setNowIconId(0);
        this$0.w(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AppIconSwitchManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VasLogReporter.INSTANCE.getAppIcon().reportHighest("\u6253\u5f00\u6d4b\u8bd5\u5f00\u5173");
        this$0.w(18);
        this$0.stateManager.setUseAppIcon(true);
        this$0.stateManager.setNowIconId(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Context context, String className) {
        VasLogReporter.Companion companion = VasLogReporter.INSTANCE;
        VasLogReportProxy.LEVEL level = VasLogReportProxy.LEVEL.HIGHEST;
        companion.getAppIcon().report("disableComponent " + className, level);
        ComponentName componentName = new ComponentName(context, className);
        if (u(context, componentName)) {
            companion.getAppIcon().report(className + " \u91cd\u590d\u7981\u7528", level);
            return;
        }
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        } catch (Exception e16) {
            QLog.e("AppIcon", 1, e16, new Object[0]);
        }
        if (u(context, componentName)) {
            VasLogReporter.INSTANCE.getAppIcon().report(className + " \u5df2\u7ecf\u7981\u7528", VasLogReportProxy.LEVEL.HIGHEST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(int id5, boolean isFromJsb) {
        if (this.stateManager.getNowIconId() == id5 && this.stateManager.getPrepareIconId() == id5) {
            VasLogReporter.INSTANCE.getAppIcon().reportLow("\u56fe\u6807\u4e0e\u9884\u671f\u4e00\u81f4\uff0c\u76f4\u63a5\u8fd4\u56de");
            return;
        }
        if (this.stateManager.getAliasActivityName(id5) == null) {
            VasLogReporter.INSTANCE.getAppIcon().report("\u65e0\u6cd5\u5207\u6362\u975e\u6cd5\u56fe\u6807\u5230id[" + id5 + "]", VasLogReportProxy.LEVEL.HIGHEST);
            return;
        }
        VasLogReporter.INSTANCE.getAppIcon().report("\u5207\u6362\u56fe\u6807\u5230id[" + id5 + "]", VasLogReportProxy.LEVEL.HIGHEST);
        this.stateManager.setPrepareIconId(id5);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.AppIconSwitchManager$doSwitch$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IVasAppIconStateManager iVasAppIconStateManager;
                IVasAppIconStateManager iVasAppIconStateManager2;
                IVasAppIconStateManager iVasAppIconStateManager3;
                IVasAppIconStateManager iVasAppIconStateManager4;
                IVasAppIconStateManager iVasAppIconStateManager5;
                IVasAppIconStateManager iVasAppIconStateManager6;
                int t16;
                iVasAppIconStateManager = AppIconSwitchManager.this.stateManager;
                int prepareIconId = iVasAppIconStateManager.getPrepareIconId();
                iVasAppIconStateManager2 = AppIconSwitchManager.this.stateManager;
                int nowIconId = iVasAppIconStateManager2.getNowIconId();
                if (nowIconId != prepareIconId) {
                    iVasAppIconStateManager3 = AppIconSwitchManager.this.stateManager;
                    if (iVasAppIconStateManager3.isTestMode()) {
                        return;
                    }
                    long j3 = prepareIconId;
                    VasCommonReporter.getAppIcon().setValue1("changeToId").setNum1(j3).report(false);
                    iVasAppIconStateManager4 = AppIconSwitchManager.this.stateManager;
                    String aliasActivityName = iVasAppIconStateManager4.getAliasActivityName(prepareIconId);
                    if (aliasActivityName != null) {
                        AppIconSwitchManager appIconSwitchManager = AppIconSwitchManager.this;
                        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                        appIconSwitchManager.s(sMobileQQ, aliasActivityName);
                    }
                    iVasAppIconStateManager5 = AppIconSwitchManager.this.stateManager;
                    String aliasActivityName2 = iVasAppIconStateManager5.getAliasActivityName(nowIconId);
                    if (aliasActivityName2 != null) {
                        AppIconSwitchManager appIconSwitchManager2 = AppIconSwitchManager.this;
                        MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
                        Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
                        appIconSwitchManager2.q(sMobileQQ2, aliasActivityName2);
                    }
                    iVasAppIconStateManager6 = AppIconSwitchManager.this.stateManager;
                    iVasAppIconStateManager6.setNowIconId(prepareIconId);
                    AppIconSwitchManager appIconSwitchManager3 = AppIconSwitchManager.this;
                    MobileQQ sMobileQQ3 = MobileQQ.sMobileQQ;
                    Intrinsics.checkNotNullExpressionValue(sMobileQQ3, "sMobileQQ");
                    t16 = appIconSwitchManager3.t(sMobileQQ3);
                    if (t16 > 1) {
                        VasCommonReporter.getAppIcon().setValue1("overNum").setNum1(j3).report(false);
                        VasLogReporter.INSTANCE.getAppIcon().report("\u5f53\u524dlauncher\u6570\u91cf\u8d85\u51fa\u9884\u671f\uff0c\u6267\u884c\u6821\u51c6", VasLogReportProxy.LEVEL.HIGHEST);
                        AppIconSwitchManager.this.w(prepareIconId);
                        return;
                    }
                    return;
                }
                VasLogReporter.INSTANCE.getAppIcon().report("\u56fe\u6807\u4e0e\u9884\u671f\u4e00\u81f4\uff0c\u52ff\u9700\u5207\u6362", VasLogReportProxy.LEVEL.HIGHEST);
            }
        };
        t tVar = new t();
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        tVar.c(sMobileQQ, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Context context, String className) {
        VasLogReporter.Companion companion = VasLogReporter.INSTANCE;
        VasLogReportProxy.LEVEL level = VasLogReportProxy.LEVEL.HIGHEST;
        companion.getAppIcon().report("enableComponent " + className, level);
        ComponentName componentName = new ComponentName(context, className);
        if (v(context, componentName)) {
            companion.getAppIcon().report(className + " \u91cd\u590d\u542f\u7528", level);
            return;
        }
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Exception e16) {
            QLog.e("AppIcon", 1, e16, new Object[0]);
        }
        if (v(context, componentName)) {
            VasLogReporter.INSTANCE.getAppIcon().report(className + " \u5df2\u7ecf\u542f\u7528", VasLogReportProxy.LEVEL.HIGHEST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        Intent intent2 = intent.setPackage(context.getPackageName());
        Intrinsics.checkNotNullExpressionValue(intent2, "with(Intent(Intent.ACTIO\u2026xt.packageName)\n        }");
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent2, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q\u2026tentActivities(intent, 0)");
        if (queryIntentActivities.isEmpty()) {
            return 0;
        }
        return queryIntentActivities.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int changeToId) {
        for (Pair<Integer, String> pair : this.stateManager.getAllAlias()) {
            if (changeToId != pair.getFirst().intValue()) {
                MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                q(sMobileQQ, pair.getSecond());
            } else {
                MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
                s(sMobileQQ2, pair.getSecond());
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconSwitchManager
    public void changeIconForJsb(@Nullable String uin, int id5) {
        boolean z16;
        if (uin == null) {
            VasLogReporter.INSTANCE.getVipData().reportLow("uin none");
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return;
        }
        int t16 = t(mobileQQ);
        if (t16 != 1) {
            VasCommonReporter.getAppIcon().setValue1("invalidNum").setNum1(t16).report(false);
            VasLogReporter.INSTANCE.getAppIcon().report("\u5f53\u524dlauncher\u6570\u91cf\u4e0d\u6b63\u786e\uff0c\u6267\u884c\u6821\u51c6", VasLogReportProxy.LEVEL.HIGHEST);
            this.stateManager.setUseAppIcon(false);
            this.stateManager.setPrepareIconId(0);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    AppIconSwitchManager.l(AppIconSwitchManager.this);
                }
            });
        } else {
            try {
                z16 = v(mobileQQ, new ComponentName(mobileQQ, this.stateManager.getSplashActivityName()));
            } catch (Exception unused) {
                z16 = true;
            }
            if (!z16) {
                VasCommonReporter.getAppIcon().setValue1("invalidActivityName").report(false);
                VasLogReporter.INSTANCE.getAppIcon().report("\u5f53\u524d\u6fc0\u6d3b\u7684activity\u4e0d\u6b63\u786e\uff0c\u6267\u884c\u6821\u51c6", VasLogReportProxy.LEVEL.HIGHEST);
                this.stateManager.setUseAppIcon(false);
                this.stateManager.setPrepareIconId(0);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppIconSwitchManager.m(AppIconSwitchManager.this);
                    }
                });
            }
        }
        if (!this.stateManager.isUseAppIcon()) {
            VasLogReporter.INSTANCE.getAppIcon().reportLow("no use");
        } else {
            r(id5, true);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAppIconSwitchManager
    public void checkAndSwitchIcon(@Nullable final String uin, final boolean isFromJsb) {
        if (uin == null) {
            VasLogReporter.INSTANCE.getVipData().reportLow("uin none");
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return;
        }
        int t16 = t(mobileQQ);
        boolean z16 = true;
        if (t16 != 1) {
            VasCommonReporter.getAppIcon().setValue1("invalidNum").setNum1(t16).report(false);
            VasLogReporter.INSTANCE.getAppIcon().report("\u5f53\u524dlauncher\u6570\u91cf\u4e0d\u6b63\u786e\uff0c\u6267\u884c\u6821\u51c6", VasLogReportProxy.LEVEL.HIGHEST);
            this.stateManager.setUseAppIcon(false);
            this.stateManager.setPrepareIconId(0);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    AppIconSwitchManager.n(AppIconSwitchManager.this);
                }
            });
        } else if (VasToggle.BUG_103313061.isEnable(true)) {
            try {
                if (this.stateManager.getNowIconId() != 0 || VasToggle.BUG_104286245.isEnable(true)) {
                    z16 = v(mobileQQ, new ComponentName(mobileQQ, this.stateManager.getSplashActivityName()));
                }
            } catch (Exception unused) {
            }
            if (!z16) {
                VasCommonReporter.getAppIcon().setValue1("invalidActivityName").report(false);
                VasLogReporter.INSTANCE.getAppIcon().report("\u5f53\u524d\u6fc0\u6d3b\u7684activity\u4e0d\u6b63\u786e\uff0c\u6267\u884c\u6821\u51c6", VasLogReportProxy.LEVEL.HIGHEST);
                this.stateManager.setUseAppIcon(false);
                this.stateManager.setPrepareIconId(0);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppIconSwitchManager.o(AppIconSwitchManager.this);
                    }
                });
            }
        }
        if (this.stateManager.isTestMode()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    AppIconSwitchManager.p(AppIconSwitchManager.this);
                }
            });
        } else {
            VasLogReporter.INSTANCE.getAppIcon().reportLow("request data");
            IVipDataUtils.INSTANCE.a().requestAndUpdateData(uin, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.AppIconSwitchManager$checkAndSwitchIcon$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IVasAppIconStateManager iVasAppIconStateManager;
                    IVasAppIconStateManager iVasAppIconStateManager2;
                    iVasAppIconStateManager = AppIconSwitchManager.this.stateManager;
                    if (!iVasAppIconStateManager.isTestMode()) {
                        iVasAppIconStateManager2 = AppIconSwitchManager.this.stateManager;
                        if (!iVasAppIconStateManager2.isUseAppIcon()) {
                            VasLogReporter.INSTANCE.getAppIcon().reportLow("no use");
                            return;
                        } else {
                            AppIconSwitchManager.this.r(IVipDataUtils.INSTANCE.a().getVipDataForFriends(uin).getAppIconId(), isFromJsb);
                            return;
                        }
                    }
                    VasLogReporter.INSTANCE.getAppIcon().reportLow("in test mode");
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return this.managerName;
    }

    public final boolean u(@NotNull Context context, @NotNull ComponentName componentName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        if (2 == context.getPackageManager().getComponentEnabledSetting(componentName)) {
            return true;
        }
        return false;
    }

    public final boolean v(@NotNull Context context, @NotNull ComponentName componentName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        if (1 == context.getPackageManager().getComponentEnabledSetting(componentName)) {
            return true;
        }
        return false;
    }
}
