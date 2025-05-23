package c74;

import android.os.Bundle;
import androidx.annotation.MainThread;
import com.tencent.input.base.mvicompat.c;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import com.tencent.robot.widget.list.vb.a;
import com.tencent.robot.widget.list.vb.d;
import com.tencent.robot.widget.list.vb.f;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import v64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006B\u000f\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010$J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH&R\"\u0010%\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010)\u00a8\u0006,"}, d2 = {"Lc74/b;", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/d;", "Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState$InitRecyclerViewAdapterUIState;", "state", "", "g", "", "Lb74/a;", "itemDataList", "Ljava/lang/Runnable;", "submitCallback", h.F, "binding", "l", "a", "Ljava/lang/Class;", "getObserverStates", "j", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "Ljava/util/concurrent/Executor;", "diffExecutor", "Lv64/e;", "k", "d", "Lcom/tencent/robot/widget/list/vb/d;", "f", "()Lcom/tencent/robot/widget/list/vb/d;", "o", "(Lcom/tencent/robot/widget/list/vb/d;)V", "mHost", "e", "Lcom/tencent/robot/widget/list/vb/f;", "mBinding", "Lv64/e;", "mAdapter", "<init>", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b implements com.tencent.input.base.mvicompat.c<com.tencent.robot.widget.list.vb.a, CommonListUIState, d, f> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e<b74.a> mAdapter;

    public b(@NotNull d mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
    }

    private final void g(CommonListUIState.InitRecyclerViewAdapterUIState state) {
        this.mAdapter = k(state.getMviContext(), getMHost().D(), state.getExecutor());
        f fVar = this.mBinding;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fVar = null;
        }
        fVar.x().setAdapter(this.mAdapter);
    }

    private final void h(List<? extends b74.a> itemDataList, final Runnable submitCallback) {
        e<b74.a> eVar = this.mAdapter;
        if (eVar != null) {
            eVar.setItems(itemDataList, new Runnable() { // from class: c74.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.i(submitCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        n(a.C9784a.f368705d);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull CommonListUIState commonListUIState) {
        c.a.a(this, commonListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: f, reason: from getter */
    public d getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends CommonListUIState>> getObserverStates() {
        List<Class<? extends CommonListUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{CommonListUIState.InitRecyclerViewAdapterUIState.class, CommonListUIState.SubmitListUIState.class});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommonListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof CommonListUIState.InitRecyclerViewAdapterUIState) {
            g((CommonListUIState.InitRecyclerViewAdapterUIState) state);
        } else if (state instanceof CommonListUIState.SubmitListUIState) {
            CommonListUIState.SubmitListUIState submitListUIState = (CommonListUIState.SubmitListUIState) state;
            h(submitListUIState.a(), submitListUIState.getSubmitCallback());
        }
    }

    @NotNull
    public abstract e<b74.a> k(@NotNull com.tencent.mvi.api.runtime.b mviContext, @NotNull com.tencent.mvi.runtime.strategy.b strategyService, @NotNull Executor diffExecutor);

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull f binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull com.tencent.robot.widget.list.vb.a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mHost = dVar;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }
}
