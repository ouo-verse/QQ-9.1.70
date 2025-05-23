package com.tencent.mobileqq.minigame.va.downloadui;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002M\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ#\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment$launchVA$launchCallback$1", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errCode", "", "errMsg", "", "Lcom/tencent/qq/minibox/constants/MiniBoxCallback;", "invoke", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VAInstallAppLoadingFragment$launchVA$launchCallback$1 implements Function3<Boolean, Integer, String, Unit> {
    final /* synthetic */ String $pkgName;
    final /* synthetic */ MiniGameVAStartData $startData;
    final /* synthetic */ VAInstallAppLoadingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VAInstallAppLoadingFragment$launchVA$launchCallback$1(String str, VAInstallAppLoadingFragment vAInstallAppLoadingFragment, MiniGameVAStartData miniGameVAStartData) {
        this.$pkgName = str;
        this.this$0 = vAInstallAppLoadingFragment;
        this.$startData = miniGameVAStartData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(VAInstallAppLoadingFragment this$0, MiniGameVAStartData startData, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(startData, "$startData");
        this$0.reportLaunch(startData.getConfig().getMiniGameId(), z16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(VAInstallAppLoadingFragment this$0) {
        ResultReceiver callback;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        callback = this$0.getCallback();
        if (callback != null) {
            callback.send(0, new Bundle());
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
        invoke(bool.booleanValue(), num.intValue(), str);
        return Unit.INSTANCE;
    }

    public void invoke(final boolean isSuccess, final int errCode, String errMsg) {
        Runnable runnable;
        QLog.i("MiniGameVALoading", 1, "launchCallback: isSuccess=" + isSuccess + ", pkg=" + this.$pkgName + " errCode:" + errCode + " errMsg:" + errMsg);
        final VAInstallAppLoadingFragment vAInstallAppLoadingFragment = this.this$0;
        final MiniGameVAStartData miniGameVAStartData = this.$startData;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.u
            @Override // java.lang.Runnable
            public final void run() {
                VAInstallAppLoadingFragment$launchVA$launchCallback$1.invoke$lambda$0(VAInstallAppLoadingFragment.this, miniGameVAStartData, isSuccess, errCode);
            }
        }, 64, null, false);
        if (!isSuccess) {
            VAInstallAppLoadingFragment vAInstallAppLoadingFragment2 = this.this$0;
            if (errMsg == null) {
                errMsg = "launch app failed.";
            }
            vAInstallAppLoadingFragment2.onFail(errMsg);
            ((IMiniGameVALaunchApi) QRoute.api(IMiniGameVALaunchApi.class)).startYunGame(this.$pkgName);
            return;
        }
        Handler mainHandler = this.this$0.getMainHandler();
        final VAInstallAppLoadingFragment vAInstallAppLoadingFragment3 = this.this$0;
        mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.v
            @Override // java.lang.Runnable
            public final void run() {
                VAInstallAppLoadingFragment$launchVA$launchCallback$1.invoke$lambda$1(VAInstallAppLoadingFragment.this);
            }
        });
        Handler mainHandler2 = this.this$0.getMainHandler();
        runnable = this.this$0.finishRunnable;
        mainHandler2.postDelayed(runnable, 15000L);
    }
}
