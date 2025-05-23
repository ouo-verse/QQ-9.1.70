package ac4;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0002!\"B!\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lac4/a;", "Lcom/tencent/mobileqq/widget/qus/e;", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "Landroid/view/View;", "createContentView", "", "showMode", "defaultHeight", NodeProps.MAX_HEIGHT, "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "panelRecyclerView", "Lac4/a$b;", "f", "Lac4/a$b;", "getViewListener", "()Lac4/a$b;", "viewListener", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Lac4/a$b;)V", h.F, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView panelRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b viewListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lac4/a$b;", "", "Landroid/view/View;", "createContentView", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public interface b {
        View createContentView();
    }

    public a(Context context, RecyclerView recyclerView, b viewListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewListener, "viewListener");
        this.context = context;
        this.panelRecyclerView = recyclerView;
        this.viewListener = viewListener;
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public boolean canScrollDown(float x16, float y16) {
        RecyclerView recyclerView = this.panelRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0) {
            return true;
        }
        View childAt = this.panelRecyclerView.getChildAt(0);
        return childAt == null || childAt.getTop() != 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public boolean canScrollUp(float x16, float y16) {
        RecyclerView recyclerView = this.panelRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int childCount = this.panelRecyclerView.getChildCount() - 1;
        if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() != childCount) {
            return true;
        }
        View childAt = this.panelRecyclerView.getChildAt(childCount);
        return childAt == null || childAt.getBottom() != this.panelRecyclerView.getHeight();
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    /* renamed from: createContentView */
    public View getF57179d() {
        return this.viewListener.createContentView();
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public int defaultHeight() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public int maxHeight() {
        return (int) ((ScreenUtils.getScreenHeight(this.context) + ImmersiveUtils.getStatusBarHeight(this.context)) * 0.7782f);
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public int showMode() {
        return 1;
    }
}
