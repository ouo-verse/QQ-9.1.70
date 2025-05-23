package com.tencent.mobileqq.minigame.va.downloadui;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VAInstallAppLoadingFragment$onResume$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ MiniGameVAStartData $data;
    final /* synthetic */ VAInstallAppLoadingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VAInstallAppLoadingFragment$onResume$1$1(VAInstallAppLoadingFragment vAInstallAppLoadingFragment, MiniGameVAStartData miniGameVAStartData) {
        super(1);
        this.this$0 = vAInstallAppLoadingFragment;
        this.$data = miniGameVAStartData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(VAInstallAppLoadingFragment this$0, MiniGameVAStartData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.startVAApp(data);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
        invoke(l3.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j3) {
        QLog.i("MiniGameVALoading", 1, "checkIfNeedStopBeforeStart: cost=" + j3);
        if (j3 >= 100) {
            this.this$0.startVAApp(this.$data);
            return;
        }
        final VAInstallAppLoadingFragment vAInstallAppLoadingFragment = this.this$0;
        final MiniGameVAStartData miniGameVAStartData = this.$data;
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.w
            @Override // java.lang.Runnable
            public final void run() {
                VAInstallAppLoadingFragment$onResume$1$1.invoke$lambda$0(VAInstallAppLoadingFragment.this, miniGameVAStartData);
            }
        }, 64, null, false, 100 - j3);
    }
}
