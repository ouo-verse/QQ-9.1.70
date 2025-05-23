package com.tencent.robot.slash.dialog.content.list.vbdelegate.heightmeasure;

import android.os.Bundle;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.api.help.b;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.slash.dialog.content.base.SlashHeightVBStateGenerator;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.SlashListUIState;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.heightmeasure.SlashListHeightProvideUIState;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.CommonListVB;
import com.tencent.robot.widget.list.vb.d;
import com.tencent.robot.widget.list.vb.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import x64.m;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u00020\u0007:\u00012B\u000f\u0012\u0006\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u0010&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\u0013H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001e\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/heightmeasure/SlashListHeightProvideVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "Lx64/m;", "Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/SlashListUIState$DisplayModeState;", "state", "", h.F, "", "g", NodeProps.MAX_HEIGHT, "l", "binding", "j", "i", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "", "isHalfMode", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Lcom/tencent/robot/widget/list/vb/d;", "e", "()Lcom/tencent/robot/widget/list/vb/d;", "k", "(Lcom/tencent/robot/widget/list/vb/d;)V", "mHost", "Lcom/tencent/robot/widget/list/vb/f;", "mBinding", "Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "f", "Lkotlin/Lazy;", "()Lcom/tencent/robot/slash/dialog/content/base/SlashHeightVBStateGenerator;", "mStateGenerator", "I", "mItemCount", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SlashListHeightProvideVBDelegate implements c<com.tencent.robot.widget.list.vb.a, CommonListUIState, d, f>, m {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f368476i = new a(null);

    /* renamed from: m, reason: collision with root package name */
    @Deprecated
    private static final int f368477m = ViewUtils.f352270a.b(44);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mStateGenerator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mItemCount;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/heightmeasure/SlashListHeightProvideVBDelegate$a;", "", "", "ITEM_HEIGHT", "I", "MIN_ITEM_COUNT", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public SlashListHeightProvideVBDelegate(@NotNull d mHost) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SlashHeightVBStateGenerator>() { // from class: com.tencent.robot.slash.dialog.content.list.vbdelegate.heightmeasure.SlashListHeightProvideVBDelegate$mStateGenerator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SlashHeightVBStateGenerator invoke() {
                return new SlashHeightVBStateGenerator(SlashListHeightProvideVBDelegate.this);
            }
        });
        this.mStateGenerator = lazy;
    }

    private final SlashHeightVBStateGenerator f() {
        return (SlashHeightVBStateGenerator) this.mStateGenerator.getValue();
    }

    private final int g() {
        return k64.c.a(getMHost().D());
    }

    private final void h(SlashListUIState.DisplayModeState state) {
        f fVar = null;
        if (state.getMode() == 1) {
            f fVar2 = this.mBinding;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fVar = fVar2;
            }
            fVar.getMRv().setId(-1);
            return;
        }
        f fVar3 = this.mBinding;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fVar = fVar3;
        }
        fVar.getMRv().setId(CommonListVB.INSTANCE.c());
    }

    private final int l(int maxHeight) {
        int i3 = f368477m;
        return Math.max(i3 * 2, Math.min(maxHeight, this.mItemCount * i3));
    }

    @Override // x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return w0(isHalfMode, accumulatedValue, totalAvailableHint);
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
    public void d(@NotNull b bVar) {
        c.a.e(this, bVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public d getMHost() {
        return this.mHost;
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
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{SlashListUIState.DisplayModeState.class, SlashListHeightProvideUIState.SetItemCount.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommonListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SlashListUIState.DisplayModeState) {
            h((SlashListUIState.DisplayModeState) state);
        } else if (state instanceof SlashListHeightProvideUIState.SetItemCount) {
            this.mItemCount = ((SlashListHeightProvideUIState.SetItemCount) state).getItemCount();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull f binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
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
        int g16 = (totalAvailableHint - accumulatedValue) - g();
        if (isHalfMode) {
            return l(g16);
        }
        return g16;
    }
}
