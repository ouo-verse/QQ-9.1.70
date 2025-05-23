package pg1;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pg1.g;

/* JADX WARN: Incorrect field signature: TAdapter; */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000*\u0010\b\u0000\u0010\u0003*\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0004B\u000f\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005R\u0014\u0010\u000f\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lpg1/j;", "Lpg1/g;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Adapter", "", "", "d", "g", "e", "", "baseItemId", "paddingIndex", "f", "a", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "loopAdapter", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j<Adapter extends RecyclerView.Adapter<?> & g> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView.Adapter loopAdapter;

    /* JADX WARN: Incorrect types in method signature: (TAdapter;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull RecyclerView.Adapter loopAdapter) {
        Intrinsics.checkNotNullParameter(loopAdapter, "loopAdapter");
        this.loopAdapter = loopAdapter;
        RecyclerView.Adapter<?> m3 = ((g) loopAdapter).m();
        if (m3 != loopAdapter && m3.hasStableIds()) {
            loopAdapter.setHasStableIds(true);
        }
        m3.registerAdapterDataObserver(new a(this, m3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d() {
        return ((g) this.loopAdapter).f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g() {
        return ((g) this.loopAdapter).K();
    }

    public final int e() {
        return g() * d();
    }

    public final long f(long baseItemId, int paddingIndex) {
        return baseItemId | (paddingIndex << 60);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"pg1/j$a", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeChanged", "", "payload", "onItemRangeInserted", "onItemRangeRemoved", "fromPosition", "toPosition", "onItemRangeMoved", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.AdapterDataObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j<Adapter> f426157d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.Adapter<?> f426158e;

        a(j<Adapter> jVar, RecyclerView.Adapter<?> adapter) {
            this.f426157d = jVar;
            this.f426158e = adapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        @SuppressLint({"NotifyDataSetChanged"})
        public void onChanged() {
            if (this.f426158e != ((j) this.f426157d).loopAdapter) {
                ((j) this.f426157d).loopAdapter.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            int coerceAtMost;
            RecyclerView.Adapter<?> adapter = this.f426158e;
            j<Adapter> jVar = this.f426157d;
            int d16 = jVar.d();
            RecyclerView.Adapter<?> adapter2 = this.f426158e;
            j<Adapter> jVar2 = this.f426157d;
            for (int i3 = 0; i3 < d16; i3++) {
                if (adapter2 != ((j) jVar2).loopAdapter) {
                    if (adapter == ((j) jVar).loopAdapter && positionStart >= jVar.g()) {
                    }
                    int g16 = (jVar.g() * i3) + positionStart;
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(itemCount, jVar.g() - positionStart);
                    onItemRangeChanged(g16, coerceAtMost, null);
                } else if (positionStart < jVar2.g()) {
                    if (i3 > 0) {
                        if (adapter == ((j) jVar).loopAdapter && positionStart >= jVar.g()) {
                        }
                        int g162 = (jVar.g() * i3) + positionStart;
                        coerceAtMost = RangesKt___RangesKt.coerceAtMost(itemCount, jVar.g() - positionStart);
                        onItemRangeChanged(g162, coerceAtMost, null);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            int coerceAtMost;
            j<Adapter> jVar = this.f426157d;
            int d16 = jVar.d();
            RecyclerView.Adapter<?> adapter = this.f426158e;
            j<Adapter> jVar2 = this.f426157d;
            for (int i3 = 0; i3 < d16; i3++) {
                if (adapter != ((j) jVar2).loopAdapter || (positionStart < jVar2.g() && i3 > 0)) {
                    RecyclerView.Adapter adapter2 = ((j) jVar).loopAdapter;
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(jVar.g(), jVar.g() - positionStart);
                    adapter2.notifyItemRangeInserted((coerceAtMost * i3) + positionStart, itemCount);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            int coerceAtMost;
            int coerceAtMost2;
            j<Adapter> jVar = this.f426157d;
            int d16 = jVar.d();
            RecyclerView.Adapter<?> adapter = this.f426158e;
            j<Adapter> jVar2 = this.f426157d;
            for (int i3 = 0; i3 < d16; i3++) {
                if (adapter != ((j) jVar2).loopAdapter) {
                    coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(itemCount, jVar.g() - fromPosition);
                    for (int i16 = 0; i16 < coerceAtMost2; i16++) {
                        ((j) jVar).loopAdapter.notifyItemMoved((jVar.g() * i3) + fromPosition + i16, (jVar.g() * i3) + toPosition + i16);
                    }
                } else if (fromPosition < jVar2.g() && i3 > 0) {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(itemCount, jVar.g() - fromPosition);
                    for (int i17 = 0; i17 < coerceAtMost; i17++) {
                        ((j) jVar).loopAdapter.notifyItemMoved((jVar.g() * i3) + fromPosition + i17, (jVar.g() * i3) + toPosition + i17);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            int coerceAtMost;
            j<Adapter> jVar = this.f426157d;
            int d16 = jVar.d();
            RecyclerView.Adapter<?> adapter = this.f426158e;
            j<Adapter> jVar2 = this.f426157d;
            for (int i3 = 0; i3 < d16; i3++) {
                if (adapter != ((j) jVar2).loopAdapter || (positionStart < jVar2.g() && i3 > 0)) {
                    RecyclerView.Adapter adapter2 = ((j) jVar).loopAdapter;
                    int g16 = (jVar.g() * i3) + positionStart;
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(itemCount, jVar.g() - positionStart);
                    adapter2.notifyItemRangeRemoved(g16, coerceAtMost);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
            int coerceAtMost;
            j<Adapter> jVar = this.f426157d;
            int d16 = jVar.d();
            RecyclerView.Adapter<?> adapter = this.f426158e;
            j<Adapter> jVar2 = this.f426157d;
            for (int i3 = 0; i3 < d16; i3++) {
                if (adapter != ((j) jVar2).loopAdapter || (positionStart < jVar2.g() && i3 > 0)) {
                    RecyclerView.Adapter adapter2 = ((j) jVar).loopAdapter;
                    int g16 = (jVar.g() * i3) + positionStart;
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(itemCount, jVar.g() - positionStart);
                    adapter2.notifyItemRangeChanged(g16, coerceAtMost, payload);
                }
            }
        }
    }
}
