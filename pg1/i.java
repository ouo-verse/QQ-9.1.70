package pg1;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pg1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0001.B\u0015\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b+\u0010,J\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u001f\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016\u00a2\u0006\u0004\b\u001d\u0010\"R \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lpg1/i;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lpg1/g;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "position", "getItemViewType", "", "getItemId", "holder", "", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "", "onFailedToRecycleView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", PM.BASE, "Lpg1/j;", BdhLogUtil.LogTag.Tag_Conn, "Lpg1/j;", "helper", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "D", "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements g {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final j<i<VH>> helper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView.Adapter<VH> base;

    public i(@NotNull RecyclerView.Adapter<VH> base) {
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this.helper = new j<>(this);
    }

    @Override // pg1.g
    public int K() {
        return g.a.e(this);
    }

    @Override // pg1.g
    public int R(int i3) {
        return g.a.d(this, i3);
    }

    @Override // pg1.g
    public int f0() {
        return g.a.c(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.helper.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (m() instanceof h) {
            return ((h) m()).a(R(position), position / K());
        }
        long itemId = m().getItemId(R(position));
        if (hasStableIds()) {
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isColorLevel()) {
                QLog.w("Guild.component.LoopAdapter", 2, "itemId may not be unique", null);
            }
            return this.helper.f(itemId, position / K());
        }
        return itemId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return m().getItemViewType(R(position));
    }

    @Override // pg1.g
    @NotNull
    public RecyclerView.Adapter<VH> m() {
        return this.base;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        m().onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        m().onBindViewHolder(holder, R(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VH onCreateViewHolder = m().onCreateViewHolder(parent, viewType);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "base.onCreateViewHolder(parent, viewType)");
        return onCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        m().onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull VH holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return m().onFailedToRecycleView(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull VH holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        m().onViewAttachedToWindow(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull VH holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        m().onViewDetachedFromWindow(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull VH holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        m().onViewRecycled(holder);
    }

    @Override // pg1.g
    public int q(int i3) {
        return g.a.a(this, i3);
    }

    @Override // pg1.g
    public boolean y() {
        return g.a.b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VH holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        m().onBindViewHolder(holder, R(position), payloads);
    }
}
