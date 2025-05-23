package com.tencent.mobileqq.troop.appscenter.managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutRepository;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi;
import com.tencent.mobileqq.troop.trooptodo.n;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AppCommonAction;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b%\u0010&J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002Jj\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\n2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\nH\u0002JJ\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0014H\u0002JJ\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\nH\u0002J*\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002Jh\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\n2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\nJ \u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/managers/NavigationManager;", "", "", "troopUin", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "detail", "", "i", "Lkotlin/Function1;", "Ldt2/c;", "dialogCallback", "Lkotlin/Function2;", "Lkotlin/Function0;", "enableDialogCallback", "errorCallback", "g", "aioDialogCallback", h.F, "", "", "j", "c", "isOpenCapsuleSwitch", "k", "Lcom/tencent/common/app/AppInterface;", "d", "f", "Landroid/content/Context;", "context", "e", "l", "Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager;", "a", "Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager;", "networkManager", "<init>", "()V", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class NavigationManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NetworkManager networkManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/managers/NavigationManager$a;", "", "", "GOTO_TROOP_SEARCH_PAGE_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.managers.NavigationManager$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25698);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NavigationManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.networkManager = new NetworkManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Activity activity, long troopUin, AppDetail detail, Function1<? super dt2.c, Unit> aioDialogCallback, Function1<? super String, Unit> errorCallback) {
        if (!TroopShortcutSettingCache.INSTANCE.a().f(troopUin)) {
            this.networkManager.m(troopUin, 1L, new NavigationManager$enableCapsuleSwitch$1(troopUin, activity, errorCallback, aioDialogCallback, this, detail));
        } else {
            QLog.e("TroopAppsCenter.NavigationManager", 1, "should never call [enableCapsuleSwitch] when useNewSwitch == true");
        }
    }

    private final AppInterface d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    private final void g(final String troopUin, final Activity activity, final AppDetail detail, final Function1<? super dt2.c, Unit> dialogCallback, Function2<? super String, ? super Function0<Unit>, Unit> enableDialogCallback, final Function1<? super String, Unit> errorCallback) {
        if (j(Long.parseLong(troopUin))) {
            enableDialogCallback.invoke("\u8bf7\u5f00\u542f\u804a\u5929\u5feb\u6377\u680f\u540e\u4f7f\u7528", new Function0<Unit>(activity, troopUin, detail, dialogCallback, errorCallback) { // from class: com.tencent.mobileqq.troop.appscenter.managers.NavigationManager$handleCapsuleApp$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ AppDetail $detail;
                final /* synthetic */ Function1<dt2.c, Unit> $dialogCallback;
                final /* synthetic */ Function1<String, Unit> $errorCallback;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$activity = activity;
                    this.$troopUin = troopUin;
                    this.$detail = detail;
                    this.$dialogCallback = dialogCallback;
                    this.$errorCallback = errorCallback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, NavigationManager.this, activity, troopUin, detail, dialogCallback, errorCallback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        NavigationManager.this.c(this.$activity, Long.parseLong(this.$troopUin), this.$detail, this.$dialogCallback, this.$errorCallback);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            dialogCallback.invoke(k(troopUin, activity, detail, false));
        }
    }

    private final void h(String troopUin, Activity activity, AppDetail detail, Function1<? super dt2.c, Unit> aioDialogCallback, final Function1<? super String, Unit> errorCallback) {
        if (detail.action.needJumpAio) {
            aioDialogCallback.invoke(k(troopUin, activity, detail, false));
            return;
        }
        com.tencent.mobileqq.troop.shortcut.action.a aVar = new com.tencent.mobileqq.troop.shortcut.action.a();
        aVar.e(activity);
        TroopShortcutRepository troopShortcutRepository = new TroopShortcutRepository(Long.parseLong(troopUin));
        AppCommonAction appCommonAction = detail.action;
        Intrinsics.checkNotNullExpressionValue(appCommonAction, "detail.action");
        String str = detail.appId;
        Intrinsics.checkNotNullExpressionValue(str, "detail.appId");
        TroopShortcutAction o16 = troopShortcutRepository.o(appCommonAction, str);
        if (o16 != null) {
            aVar.c(o16, new Function1<String, Unit>(errorCallback) { // from class: com.tencent.mobileqq.troop.appscenter.managers.NavigationManager$handleCommonAppTypes$1$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<String, Unit> $errorCallback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$errorCallback = errorCallback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) errorCallback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String errMsg) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) errMsg);
                    } else {
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                        this.$errorCallback.invoke(errMsg);
                    }
                }
            });
        }
        aVar.b();
    }

    private final void i(String troopUin, Activity activity, AppDetail detail) {
        IRobotProfileCardApi iRobotProfileCardApi = (IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class);
        String str = detail.action.associatedId;
        Intrinsics.checkNotNullExpressionValue(str, "detail.action.associatedId");
        iRobotProfileCardApi.openRobotProfileCard(new OpenRobotProfileCardArgs(activity, str, troopUin, 0, 12, null, 32, null));
    }

    private final boolean j(long troopUin) {
        return ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).getDisableCapsule(troopUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final dt2.c k(String troopUin, Activity activity, AppDetail detail, boolean isOpenCapsuleSwitch) {
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).createAndShowCapsuleDialog(activity, troopUin, detail, Boolean.valueOf(isOpenCapsuleSwitch));
    }

    public final void e(long troopUin, @Nullable Context context, @NotNull Activity activity) {
        long j3;
        boolean z16;
        String replace$default;
        String replace$default2;
        String replace$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(troopUin), context, activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!n.d(d(), troopUin)) {
            return;
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(String.valueOf(troopUin));
        if (troopInfoFromCache != null) {
            j3 = troopInfoFromCache.dwGroupClassExt;
        } else {
            j3 = 0;
        }
        if (troopInfoFromCache != null && troopInfoFromCache.isTroopOwner(d().getCurrentUin())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 1;
        } else {
            if (troopInfoFromCache == null || !troopInfoFromCache.isTroopAdmin(d().getCurrentUin())) {
                z17 = false;
            }
            if (!z17) {
                i3 = 0;
            }
        }
        replace$default = StringsKt__StringsJVMKt.replace$default("https://qun.qq.com/slidepanel/search?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$", "$GCODE$", String.valueOf(troopUin), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GID$", String.valueOf(i3), false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$GTYPE$", String.valueOf(j3), false, 4, (Object) null);
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", replace$default3);
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        activity.startActivityForResult(intent, 20007);
    }

    public final void f(@NotNull String troopUin, @NotNull Activity activity, @NotNull AppDetail detail, @NotNull Function1<? super dt2.c, Unit> aioDialogCallback, @NotNull Function2<? super String, ? super Function0<Unit>, Unit> enableDialogCallback, @NotNull Function1<? super String, Unit> errorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, activity, detail, aioDialogCallback, enableDialogCallback, errorCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(aioDialogCallback, "aioDialogCallback");
        Intrinsics.checkNotNullParameter(enableDialogCallback, "enableDialogCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        int i3 = detail.type;
        if (i3 != 3) {
            if (i3 != 4) {
                h(troopUin, activity, detail, aioDialogCallback, errorCallback);
                return;
            } else {
                g(troopUin, activity, detail, aioDialogCallback, enableDialogCallback, errorCallback);
                return;
            }
        }
        i(troopUin, activity, detail);
    }

    public final void l(@NotNull String troopUin, @NotNull Context context, @NotNull AppDetail detail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, context, detail);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intent intent = new Intent();
        intent.putExtra("troop_uin", troopUin);
        QPublicFragmentActivity.start(context, intent, ((ITroopManagerFragmentApi) QRoute.api(ITroopManagerFragmentApi.class)).getTroopBindGuildListFragmentClass());
    }
}
