package com.tencent.robot.slash.dialog.content.base;

import android.os.Bundle;
import com.tencent.mvi.api.ability.c;
import com.tencent.mvi.api.ability.d;
import com.tencent.robot.slash.dialog.content.base.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "Lcom/tencent/mvi/api/ability/c;", "Lcom/tencent/robot/slash/dialog/content/base/b$b;", "stateCmd", "Landroid/os/Bundle;", "b", "Lcom/tencent/robot/slash/dialog/content/base/b$d;", "d", "c", "Lcom/tencent/mvi/api/ability/d;", "generateVBState", "Lx64/m;", "Lx64/m;", "mLayoutHeightProvider", "e", "Lkotlin/Lazy;", "a", "()Landroid/os/Bundle;", "mReusableBundle", "<init>", "(Lx64/m;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SlashHeightVBStateGenerator implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m mLayoutHeightProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mReusableBundle;

    public SlashHeightVBStateGenerator(@NotNull m mLayoutHeightProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mLayoutHeightProvider, "mLayoutHeightProvider");
        this.mLayoutHeightProvider = mLayoutHeightProvider;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Bundle>() { // from class: com.tencent.robot.slash.dialog.content.base.SlashHeightVBStateGenerator$mReusableBundle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bundle invoke() {
                return new Bundle();
            }
        });
        this.mReusableBundle = lazy;
    }

    private final Bundle a() {
        return (Bundle) this.mReusableBundle.getValue();
    }

    private final Bundle b(b.FetchHeight stateCmd) {
        Bundle a16 = a();
        a16.putInt("half_mode_height", this.mLayoutHeightProvider.w0(stateCmd.getIsHalfMode(), stateCmd.getAccumulatedValue(), stateCmd.getTotalAvailableHint()));
        return a16;
    }

    private final Bundle c() {
        Bundle a16 = a();
        a16.putInt("layout_sequence", this.mLayoutHeightProvider.m());
        return a16;
    }

    private final Bundle d(b.FetchVisualHeight stateCmd) {
        Bundle a16 = a();
        a16.putInt("half_mode_visual_height", this.mLayoutHeightProvider.Q(stateCmd.getIsHalfMode(), stateCmd.getAccumulatedValue(), stateCmd.getTotalAvailableHint()));
        return a16;
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof b.FetchHeight) {
            return b((b.FetchHeight) stateCmd);
        }
        if (stateCmd instanceof b.FetchVisualHeight) {
            return d((b.FetchVisualHeight) stateCmd);
        }
        if (stateCmd instanceof b.c) {
            return c();
        }
        return Bundle.EMPTY;
    }
}
