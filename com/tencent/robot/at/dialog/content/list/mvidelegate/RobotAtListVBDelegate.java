package com.tencent.robot.at.dialog.content.list.mvidelegate;

import android.os.Bundle;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.at.dialog.content.list.mvidelegate.RobotAtListUIState;
import com.tencent.robot.slash.dialog.content.base.SlashHeightVBStateGenerator;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.d;
import com.tencent.robot.widget.list.vb.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u00020\u0007:\u0001.B\u000f\u0012\u0006\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010\"J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\"\u0010#\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\u0016\u0010,\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/robot/at/dialog/content/list/mvidelegate/RobotAtListVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "Lx64/m;", "binding", "", h.F, "state", "g", "", "Ljava/lang/Class;", "Lcom/tencent/robot/at/dialog/content/list/mvidelegate/RobotAtListUIState$SetItemCount;", "getObserverStates", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Lcom/tencent/robot/widget/list/vb/d;", "e", "()Lcom/tencent/robot/widget/list/vb/d;", "i", "(Lcom/tencent/robot/widget/list/vb/d;)V", "mHost", "Lcom/tencent/robot/widget/list/vb/f;", "mBinding", "Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "f", "Lkotlin/Lazy;", "()Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "mLayoutHeightVBStateGenerator", "I", "mCurrentItemCount", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAtListVBDelegate implements c<com.tencent.robot.widget.list.vb.a, CommonListUIState, d, f>, m {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mLayoutHeightVBStateGenerator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurrentItemCount;

    public RobotAtListVBDelegate(@NotNull d mHost) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SlashHeightVBStateGenerator>() { // from class: com.tencent.robot.at.dialog.content.list.mvidelegate.RobotAtListVBDelegate$mLayoutHeightVBStateGenerator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SlashHeightVBStateGenerator invoke() {
                return new SlashHeightVBStateGenerator(RobotAtListVBDelegate.this);
            }
        });
        this.mLayoutHeightVBStateGenerator = lazy;
    }

    private final SlashHeightVBStateGenerator f() {
        return (SlashHeightVBStateGenerator) this.mLayoutHeightVBStateGenerator.getValue();
    }

    @Override // x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        float coerceAtLeast;
        int a16 = (totalAvailableHint - k64.c.a(getMHost().D())) - accumulatedValue;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mCurrentItemCount, 3.0f);
        return Math.min(a16, (int) (coerceAtLeast * ViewUtils.f352270a.b(44)));
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        c.a.b(this);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull CommonListUIState commonListUIState) {
        c.a.a(this, commonListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public d getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommonListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotAtListUIState.SetItemCount) {
            this.mCurrentItemCount = ((RobotAtListUIState.SetItemCount) state).getItemCount();
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return f().generateVBState(stateCmd);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends CommonListUIState>> getObserverStates() {
        List<Class<? extends CommonListUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(RobotAtListUIState.SetItemCount.class);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull f binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            binding = null;
        }
        binding.getMRv().setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mHost = dVar;
    }

    @Override // x64.m
    public int m() {
        return 1;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        float coerceAtLeast;
        int a16 = (totalAvailableHint - k64.c.a(getMHost().D())) - accumulatedValue;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mCurrentItemCount, 3.0f);
        return Math.min(a16, (int) (coerceAtLeast * ViewUtils.f352270a.b(44)));
    }
}
