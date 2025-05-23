package com.tencent.robot.write.view;

import a44.RequireData;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.write.view.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002,-B\u0013\b\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018R\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR,\u0010$\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130 j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/robot/write/view/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/robot/write/view/c$b;", "", "selectedIndex", "", "m0", "index", "", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "s0", "viewHolder", "position", "r0", "getItemCount", "", "Lcom/tencent/robot/write/view/b;", "list", "p0", "q0", "n0", "Lcom/tencent/robot/write/view/a;", "listener", "t0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isDrawRequire", BdhLogUtil.LogTag.Tag_Conn, "I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "sourceDataList", "E", "Lcom/tencent/robot/write/view/a;", "onSelectedListener", UserInfo.SEX_FEMALE, "innerOnSelectedListener", "<init>", "(Z)V", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.robot.write.view.a onSelectedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isDrawRequire;

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedIndex = -1;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<SelectData<?>> sourceDataList = new ArrayList<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.robot.write.view.a innerOnSelectedListener = new C9790c();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/write/view/c$a;", "Lcom/tencent/robot/write/view/c$b;", "Lcom/tencent/robot/write/view/b;", "data", "", "selected", "", "position", "Lcom/tencent/robot/write/view/a;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "G", "Landroid/widget/ImageView;", "iconView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends b {

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView iconView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.iconView = (ImageView) itemView.findViewById(R.id.f165861dq1);
        }

        @Override // com.tencent.robot.write.view.c.b
        public void m(@NotNull SelectData<?> data, boolean selected, int position, @NotNull com.tencent.robot.write.view.a listener) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(listener, "listener");
            super.m(data, selected, position, listener);
            Object b16 = data.b();
            if (b16 instanceof RequireData) {
                String url = ((RequireData) b16).getUrl();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = new ColorDrawable(0);
                this.iconView.setImageDrawable(URLDrawable.getDrawable(url, obtain));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/write/view/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/write/view/b;", "data", "", "selected", "", "position", "Lcom/tencent/robot/write/view/a;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "nameView", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "selectedView", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView nameView;

        /* renamed from: F, reason: from kotlin metadata */
        private final View selectedView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.nameView = (TextView) itemView.findViewById(R.id.dqd);
            this.selectedView = itemView.findViewById(R.id.xxj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, com.tencent.robot.write.view.a listener, SelectData data, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(data, "$data");
            boolean z16 = !this$0.itemView.isSelected();
            this$0.itemView.setSelected(z16);
            if (z16) {
                this$0.selectedView.setVisibility(0);
                listener.a(data, i3);
            } else {
                this$0.selectedView.setVisibility(4);
                listener.b(data, i3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void m(@NotNull final SelectData<?> data, boolean selected, final int position, @NotNull final com.tencent.robot.write.view.a listener) {
            int i3;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.nameView.setText(data.getName());
            View view = this.selectedView;
            if (selected) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
            this.itemView.setSelected(selected);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.write.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b.n(c.b.this, listener, data, position, view2);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/write/view/c$c", "Lcom/tencent/robot/write/view/a;", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.write.view.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9790c implements com.tencent.robot.write.view.a {
        C9790c() {
        }

        @Override // com.tencent.robot.write.view.a
        public void a(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            int i3 = c.this.selectedIndex;
            c.this.selectedIndex = position;
            c.this.m0(i3);
            com.tencent.robot.write.view.a aVar = c.this.onSelectedListener;
            if (aVar != null) {
                aVar.a(selectedData, position);
            }
        }

        @Override // com.tencent.robot.write.view.a
        public void b(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            c.this.selectedIndex = -1;
            com.tencent.robot.write.view.a aVar = c.this.onSelectedListener;
            if (aVar != null) {
                aVar.b(selectedData, position);
            }
        }
    }

    @JvmOverloads
    public c(boolean z16) {
        this.isDrawRequire = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(int selectedIndex) {
        if (o0(selectedIndex)) {
            notifyItemChanged(selectedIndex);
        }
    }

    private final boolean o0(int index) {
        if (index < 0 || index >= getNUM_BACKGOURND_ICON()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.sourceDataList.size();
    }

    @Nullable
    public final SelectData<?> n0() {
        if (o0(this.selectedIndex)) {
            return this.sourceDataList.get(this.selectedIndex);
        }
        return null;
    }

    public final void p0(@NotNull List<? extends SelectData<?>> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.selectedIndex = -1;
        this.sourceDataList.clear();
        this.sourceDataList.addAll(list);
        notifyDataSetChanged();
    }

    public final void q0(int index) {
        if (this.selectedIndex != index) {
            if (o0(index) || index == -1) {
                boolean o06 = o0(this.selectedIndex);
                if (o06) {
                    notifyItemChanged(this.selectedIndex);
                    new com.tencent.videocut.utils.dsl.b();
                } else {
                    new com.tencent.videocut.utils.dsl.a(o06);
                }
                this.selectedIndex = index;
                boolean o07 = o0(index);
                if (o07) {
                    notifyItemChanged(this.selectedIndex);
                    new com.tencent.videocut.utils.dsl.b();
                } else {
                    new com.tencent.videocut.utils.dsl.a(o07);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b viewHolder, int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        SelectData<?> selectData = this.sourceDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(selectData, "sourceDataList[position]");
        SelectData<?> selectData2 = selectData;
        if (this.selectedIndex == position) {
            z16 = true;
        } else {
            z16 = false;
        }
        viewHolder.m(selectData2, z16, position, this.innerOnSelectedListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.isDrawRequire) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ho5, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026lect_item, parent, false)");
            return new a(inflate);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169075hp2, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf\u2026item_view, parent, false)");
        return new b(inflate2);
    }

    public final void t0(@NotNull com.tencent.robot.write.view.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSelectedListener = listener;
    }
}
