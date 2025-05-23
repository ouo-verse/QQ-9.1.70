package com.tencent.widget;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002\u00a8\u0006\u0006"}, d2 = {"runOnSubThread", "", "block", "Lkotlin/Function0;", "runOnUI", "", "qqonlinestatus-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BatteryDrawableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnSubThread(final Function0<Unit> function0) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                BatteryDrawableKt.runOnSubThread$lambda$0(Function0.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnSubThread$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean runOnUI(final Function0<Unit> function0) {
        return ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                BatteryDrawableKt.runOnUI$lambda$1(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUI$lambda$1(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
