package com.tencent.robot.slash.dialog.content.base;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.ability.d;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w64.e;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\f\b\u0002\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u00020\bB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lw64/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "Lx64/m;", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "d", "Lkotlin/Lazy;", "b1", "()Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "mVBStateGenerator", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class SlashDialogVB<I extends ol3.b, S extends MviUIState, C extends e<?>> extends BaseVB<I, S, C> implements m {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mVBStateGenerator;

    public SlashDialogVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SlashHeightVBStateGenerator>(this) { // from class: com.tencent.robot.slash.dialog.content.base.SlashDialogVB$mVBStateGenerator$2
            final /* synthetic */ SlashDialogVB<I, S, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SlashHeightVBStateGenerator invoke() {
                return new SlashHeightVBStateGenerator(this.this$0);
            }
        });
        this.mVBStateGenerator = lazy;
    }

    private final SlashHeightVBStateGenerator b1() {
        return (SlashHeightVBStateGenerator) this.mVBStateGenerator.getValue();
    }

    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return w0(isHalfMode, accumulatedValue, totalAvailableHint);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return b1().generateVBState(stateCmd);
    }

    public int m() {
        return m.a.a(this);
    }

    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return 0;
    }
}
