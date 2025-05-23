package pg1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lpg1/l;", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "b", "", "d", "I", "margin", "pg1/l$a", "e", "Lpg1/l$a;", "itemDecoration", "<init>", "(I)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int margin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a itemDecoration = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"pg1/l$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
        
            if (r3.getOrientation() == 1) goto L12;
         */
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            ViewPager2 viewPager2;
            boolean z16;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            ViewParent parent2 = parent.getParent();
            if (parent2 instanceof ViewPager2) {
                viewPager2 = (ViewPager2) parent2;
            } else {
                viewPager2 = null;
            }
            if (viewPager2 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                outRect.set(0, l.this.margin / 2, 0, l.this.margin / 2);
            } else {
                outRect.set(l.this.margin / 2, 0, l.this.margin / 2, 0);
            }
        }
    }

    public l(int i3) {
        this.margin = i3;
    }

    @Override // pg1.d
    public void a(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (viewPager2.getOrientation() == 0) {
            int i3 = marginLayoutParams.leftMargin;
            int i16 = this.margin;
            marginLayoutParams.leftMargin = i3 - (i16 / 2);
            marginLayoutParams.rightMargin -= i16 / 2;
        } else {
            int i17 = marginLayoutParams.topMargin;
            int i18 = this.margin;
            marginLayoutParams.topMargin = i17 - (i18 / 2);
            marginLayoutParams.bottomMargin -= i18 / 2;
        }
        viewPager2.setLayoutParams(marginLayoutParams);
        viewPager2.addItemDecoration(this.itemDecoration);
    }

    @Override // pg1.d
    public void b(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        viewPager2.removeItemDecoration(this.itemDecoration);
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (viewPager2.getOrientation() == 0) {
            int i3 = marginLayoutParams.leftMargin;
            int i16 = this.margin;
            marginLayoutParams.leftMargin = i3 + (i16 / 2);
            marginLayoutParams.rightMargin += i16 / 2;
        } else {
            int i17 = marginLayoutParams.topMargin;
            int i18 = this.margin;
            marginLayoutParams.topMargin = i17 + (i18 / 2);
            marginLayoutParams.bottomMargin += i18 / 2;
        }
        viewPager2.setLayoutParams(marginLayoutParams);
    }
}
