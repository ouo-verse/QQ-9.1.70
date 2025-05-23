package g74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import e74.ItemData;
import g74.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0014\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\b\u0012\u0004\u0012\u00020\u0013`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001f\u00a8\u0006)"}, d2 = {"Lg74/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lg74/b$b;", "", "selectedIndex", "", "m0", "index", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "viewHolder", "position", "p0", "getItemCount", "", "Le74/b;", "list", "o0", "Lg74/b$a;", "listener", "r0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "typeList", BdhLogUtil.LogTag.Tag_Conn, "Lg74/b$a;", "onSelectedListener", "D", "I", "E", "innerOnSelectedListener", "<init>", "()V", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends RecyclerView.Adapter<C10362b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a onSelectedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ItemData> typeList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private int selectedIndex = -1;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final a innerOnSelectedListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lg74/b$a;", "", "Landroid/view/View;", "view", "", "position", "Le74/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@NotNull View view, int position, @NotNull ItemData item);

        void b(@NotNull View view, int position, @NotNull ItemData item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lg74/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "selected", "", "o", "Le74/b;", "data", "", "position", "Lg74/b$a;", "onSelectedListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "typeTextView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g74.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10362b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView typeTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10362b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.typeTextView = (TextView) itemView.findViewById(R.id.f113826ro);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(C10362b this$0, a aVar, int i3, ItemData data, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.typeTextView.setSelected(!r0.isSelected());
            this$0.o(this$0.typeTextView.isSelected());
            if (this$0.itemView.isSelected()) {
                if (aVar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    aVar.b(it, i3, data);
                }
            } else if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.a(it, i3, data);
            }
            EventCollector.getInstance().onViewClicked(it);
        }

        private final void o(boolean selected) {
            int color;
            TextView textView = this.typeTextView;
            if (selected) {
                color = textView.getResources().getColor(R.color.qui_common_text_allwhite_primary, null);
            } else {
                color = textView.getResources().getColor(R.color.qui_common_text_primary, null);
            }
            textView.setTextColor(color);
        }

        public final void m(@NotNull final ItemData data, final int position, boolean selected, @Nullable final a onSelectedListener) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.typeTextView.setText(data.getName());
            this.typeTextView.setSelected(selected);
            o(selected);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: g74.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C10362b.n(b.C10362b.this, onSelectedListener, position, data, view);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"g74/b$c", "Lg74/b$a;", "Landroid/view/View;", "view", "", "position", "Le74/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements a {
        c() {
        }

        @Override // g74.b.a
        public void a(@NotNull View view, int position, @NotNull ItemData item) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            a aVar = b.this.onSelectedListener;
            if (aVar != null) {
                aVar.a(view, position, item);
            }
        }

        @Override // g74.b.a
        public void b(@NotNull View view, int position, @NotNull ItemData item) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            int i3 = b.this.selectedIndex;
            b.this.selectedIndex = position;
            b.this.m0(i3);
            a aVar = b.this.onSelectedListener;
            if (aVar != null) {
                aVar.b(view, position, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(int selectedIndex) {
        if (n0(selectedIndex)) {
            notifyItemChanged(selectedIndex);
        }
    }

    private final boolean n0(int index) {
        if (index < 0 || index >= getItemCount()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.typeList.size();
    }

    public final void o0(@NotNull List<ItemData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.selectedIndex = -1;
        this.typeList.clear();
        this.typeList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C10362b viewHolder, int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ItemData itemData = this.typeList.get(position);
        Intrinsics.checkNotNullExpressionValue(itemData, "typeList[position]");
        ItemData itemData2 = itemData;
        if (position == this.selectedIndex) {
            z16 = true;
        } else {
            z16 = false;
        }
        viewHolder.m(itemData2, position, z16, this.innerOnSelectedListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public C10362b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hpf, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026item_view, parent, false)");
        return new C10362b(inflate);
    }

    public final void r0(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSelectedListener = listener;
    }
}
