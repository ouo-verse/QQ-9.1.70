package com.tencent.mobileqq.troop.appscenter.managers;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "errCode", "", "errMsg", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class NavigationManager$enableCapsuleSwitch$1 extends Lambda implements Function3<Boolean, Integer, String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1<dt2.c, Unit> $aioDialogCallback;
    final /* synthetic */ AppDetail $detail;
    final /* synthetic */ Function1<String, Unit> $errorCallback;
    final /* synthetic */ long $troopUin;
    final /* synthetic */ NavigationManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationManager$enableCapsuleSwitch$1(long j3, Activity activity, Function1<? super String, Unit> function1, Function1<? super dt2.c, Unit> function12, NavigationManager navigationManager, AppDetail appDetail) {
        super(3);
        this.$troopUin = j3;
        this.$activity = activity;
        this.$errorCallback = function1;
        this.$aioDialogCallback = function12;
        this.this$0 = navigationManager;
        this.$detail = appDetail;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), activity, function1, function12, navigationManager, appDetail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 aioDialogCallback, NavigationManager this$0, long j3, Activity activity, AppDetail detail) {
        dt2.c k3;
        Intrinsics.checkNotNullParameter(aioDialogCallback, "$aioDialogCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(detail, "$detail");
        k3 = this$0.k(String.valueOf(j3), activity, detail, true);
        aioDialogCallback.invoke(k3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
        invoke(bool.booleanValue(), num.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, int i3, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        if (z16) {
            ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).setDisableCapsule(this.$troopUin, false);
            final Activity activity = this.$activity;
            final Function1<dt2.c, Unit> function1 = this.$aioDialogCallback;
            final NavigationManager navigationManager = this.this$0;
            final long j3 = this.$troopUin;
            final AppDetail appDetail = this.$detail;
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.managers.a
                @Override // java.lang.Runnable
                public final void run() {
                    NavigationManager$enableCapsuleSwitch$1.b(Function1.this, navigationManager, j3, activity, appDetail);
                }
            });
            return;
        }
        this.$errorCallback.invoke(str == null ? "Unknown error" : str);
        QLog.e("TroopAppsCenter.NavigationManager", 1, "setCapsuleSwitchWithReq result " + i3 + " err: " + str + " troopUin:" + this.$troopUin);
    }
}
