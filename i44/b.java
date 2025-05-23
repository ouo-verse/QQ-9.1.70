package i44;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureInfo;
import hn2.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Li44/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Li44/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "", "j0", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureInfo;", "list", "", "isFolded", "n0", "Li44/b$c;", "listener", "m0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mCmdList", BdhLogUtil.LogTag.Tag_Conn, "Li44/b$c;", "mCmdClickListener", "<init>", "()V", "D", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c mCmdClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RobotFeatureInfo> mCmdList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Li44/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureInfo;", "data", "", "l", "Lhn2/m;", "E", "Lhn2/m;", "binding", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureInfo;", "itemData", "<init>", "(Lhn2/m;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final m binding;

        /* renamed from: F, reason: from kotlin metadata */
        private RobotFeatureInfo itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull m binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void l(@NotNull RobotFeatureInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.itemData = data;
            this.binding.f405391c.setText(data.name);
            this.binding.f405390b.setText(data.desc);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Li44/b$c;", "", "Landroid/view/View;", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureInfo;", "cmd", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface c {
        void a(@NotNull View v3, @NotNull RobotFeatureInfo cmd);
    }

    public b() {
        List<RobotFeatureInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mCmdList = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.mCmdClickListener;
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar.a(it, this$0.mCmdList.get(i3));
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCmdList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(this.mCmdList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: i44.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.k0(b.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        m g16 = m.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(g16);
    }

    public final void m0(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mCmdClickListener = listener;
    }

    public final void n0(@NotNull List<RobotFeatureInfo> list, boolean isFolded) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (isFolded && list.size() > 4) {
            list = list.subList(0, 4);
        }
        this.mCmdList = list;
        notifyDataSetChanged();
    }
}
