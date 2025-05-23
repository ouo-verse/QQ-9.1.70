package g64;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.c;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectUIState;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.f;
import g64.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import v64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001$\u0018\u0000 \f2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\rB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010\u001cJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000f0\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\"\u0010\u001d\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%\u00a8\u0006("}, d2 = {"Lg64/c;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "Lcom/tencent/robot/slash/dialog/content/list/vbdelegate/coupling/SlashListCouplingEffectUIState$ScrollToPosition;", "state", "", "g", "binding", "i", "a", "", "Ljava/lang/Class;", "getObserverStates", h.F, "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/robot/widget/list/vb/d;", "f", "()Lcom/tencent/robot/widget/list/vb/d;", "l", "(Lcom/tencent/robot/widget/list/vb/d;)V", "mHost", "e", "Lcom/tencent/robot/widget/list/vb/f;", "mBinding", "Lg64/b$a;", "Lg64/b$a;", "mTempMviIntent", "g64/c$b", "Lg64/c$b;", "mScrollListener", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.input.base.mvicompat.c<com.tencent.robot.widget.list.vb.a, CommonListUIState, com.tencent.robot.widget.list.vb.d, f> {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f401469i = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.widget.list.vb.d mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b.a mTempMviIntent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mScrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lg64/c$a;", "", "", "SCROLL_TO_POSITION_OFFSET", "I", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"g64/c$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            LinearLayoutManager linearLayoutManager;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            c cVar = c.this;
            b.a aVar = cVar.mTempMviIntent;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            aVar.c(linearLayoutManager);
            aVar.d(recyclerView.getScrollState());
            cVar.k(aVar);
        }
    }

    public c(@NotNull com.tencent.robot.widget.list.vb.d mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        this.mTempMviIntent = new b.a(null, 0);
        this.mScrollListener = new b();
    }

    private final void g(SlashListCouplingEffectUIState.ScrollToPosition state) {
        int position = state.getPosition();
        f fVar = this.mBinding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fVar = null;
        }
        RecyclerView.LayoutManager layoutManager = fVar.getRecyclerView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (position == 0) {
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
        } else {
            linearLayoutManager.scrollToPositionWithOffset(Math.min(position + 1, linearLayoutManager.getItemCount()), 0);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        f fVar = this.mBinding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fVar = null;
        }
        fVar.getRecyclerView().addOnScrollListener(this.mScrollListener);
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
    /* renamed from: f, reason: from getter */
    public com.tencent.robot.widget.list.vb.d getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        e<?> eVar;
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof g64.a) {
            g64.a aVar = (g64.a) stateCmd;
            f fVar = this.mBinding;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fVar = null;
            }
            RecyclerView.Adapter adapter = fVar.getRecyclerView().getAdapter();
            if (adapter instanceof e) {
                eVar = (e) adapter;
            } else {
                eVar = null;
            }
            aVar.b(eVar);
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends CommonListUIState>> getObserverStates() {
        List<Class<? extends CommonListUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(SlashListCouplingEffectUIState.ScrollToPosition.class);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommonListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SlashListCouplingEffectUIState.ScrollToPosition) {
            g((SlashListCouplingEffectUIState.ScrollToPosition) state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull f binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void k(@NotNull com.tencent.robot.widget.list.vb.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.robot.widget.list.vb.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mHost = dVar;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        f fVar = this.mBinding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fVar = null;
        }
        fVar.getRecyclerView().removeOnScrollListener(this.mScrollListener);
    }
}
