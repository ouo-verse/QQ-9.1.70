package pg1;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lpg1/k;", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "b", "Lpg1/g;", "d", "Lpg1/g;", "loopAdapter", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "e", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeCallback", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class k extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private g loopAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2.OnPageChangeCallback onPageChangeCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"pg1/k$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f426161b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f426162c;

        a(ViewPager2 viewPager2, k kVar) {
            this.f426161b = viewPager2;
            this.f426162c = kVar;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                int currentItem = this.f426161b.getCurrentItem();
                g gVar = this.f426162c.loopAdapter;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loopAdapter");
                    gVar = null;
                }
                int q16 = gVar.q(currentItem);
                if (q16 != currentItem) {
                    this.f426161b.setCurrentItem(q16, false);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pg1.d
    public void a(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != 0) {
            if (adapter instanceof g) {
                this.loopAdapter = (g) adapter;
            } else {
                i iVar = new i(adapter);
                viewPager2.setAdapter(iVar);
                this.loopAdapter = iVar;
            }
            ViewPager2.OnPageChangeCallback aVar = new a(viewPager2, this);
            this.onPageChangeCallback = aVar;
            viewPager2.registerOnPageChangeCallback(aVar);
            g gVar = this.loopAdapter;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loopAdapter");
                gVar = null;
            }
            viewPager2.setCurrentItem(gVar.q(0), false);
            return;
        }
        throw new IllegalStateException("\u5fc5\u987b\u5148\u8bbe\u7f6eadapter".toString());
    }

    @Override // pg1.d
    public void b(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        g gVar = this.loopAdapter;
        if (gVar != null) {
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loopAdapter");
                gVar = null;
            }
            viewPager2.setAdapter(gVar.m());
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.onPageChangeCallback;
        if (onPageChangeCallback != null) {
            viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
            this.onPageChangeCallback = null;
        }
    }
}
