package n82;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Ln82/a;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "holder", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "", "f", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b {
    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        return 6;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        return 5;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(RecyclerView.ViewHolder holder, com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (holder instanceof d) {
            ((d) holder).m(model);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public RecyclerView.ViewHolder g(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c51.c g16 = c51.c.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new d(root, this);
    }
}
