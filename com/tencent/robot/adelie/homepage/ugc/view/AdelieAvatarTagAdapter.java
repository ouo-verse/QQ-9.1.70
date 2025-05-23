package com.tencent.robot.adelie.homepage.ugc.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarTagAdapter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u000b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004/012B;\u0012\u001e\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u001a0\u0019\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u001e\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007R,\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00063"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "", "p0", "", "n0", "o0", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "getItemCount", "expanded", "r0", "s0", "m0", "currentStr", "q0", "", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "categories", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onTagClick", "D", "Z", "isExpanded", "E", "I", "initialTagCount", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "selectedTags", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "G", "a", "b", "c", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarTagAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<String, Boolean> onTagClick;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: E, reason: from kotlin metadata */
    private final int initialTagCount;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<String> selectedTags;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, List<String>>> categories;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "category", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "categoryTextView", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView categoryTextView;
        final /* synthetic */ AdelieAvatarTagAdapter F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AdelieAvatarTagAdapter adelieAvatarTagAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = adelieAvatarTagAdapter;
            View findViewById = itemView.findViewById(R.id.tp5);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.category_text_view)");
            TextView textView = (TextView) findViewById;
            this.categoryTextView = textView;
            textView.setTextColor(itemView.getContext().getColor(R.color.qui_common_text_secondary_light));
        }

        public final void l(@NotNull String category) {
            Intrinsics.checkNotNullParameter(category, "category");
            this.categoryTextView.setText(category);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class c extends RecyclerView.ViewHolder {
        final /* synthetic */ AdelieAvatarTagAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull final AdelieAvatarTagAdapter adelieAvatarTagAdapter, final View itemView) {
            super(itemView);
            Map mapOf;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = adelieAvatarTagAdapter;
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, itemView, WinkDaTongReportConstant.ElementId.EM_BAS_MORE, null, null, null, null, null, 124, null);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_smart_image_creation"));
            VideoReport.reportEvent("imp", itemView, mapOf);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieAvatarTagAdapter.c.m(itemView, adelieAvatarTagAdapter, view);
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) itemView.findViewById(R.id.jjc);
            if (relativeLayout != null) {
                q qVar = q.f366599a;
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                relativeLayout.setBackground(qVar.b(context));
            }
            ((TextView) itemView.findViewById(R.id.f0q)).setTextColor(itemView.getContext().getColor(R.color.qui_common_text_secondary_light));
            ((ImageView) itemView.findViewById(R.id.f06)).setImageDrawable(itemView.getContext().getDrawable(R.drawable.qui_chevron_down_icon_secondary));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(View itemView, AdelieAvatarTagAdapter this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            VideoReport.reportEvent("clck", itemView, null);
            this$0.isExpanded = !this$0.isExpanded;
            this$0.r0(this$0.isExpanded);
            this$0.notifyDataSetChanged();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "tag", "Lkotlin/Function1;", "", "onTagClick", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarTagAdapter;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class d extends RecyclerView.ViewHolder {
        final /* synthetic */ AdelieAvatarTagAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull AdelieAvatarTagAdapter adelieAvatarTagAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = adelieAvatarTagAdapter;
            Button button = (Button) itemView.findViewById(R.id.jjc);
            q qVar = q.f366599a;
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            button.setTextColor(qVar.c(context));
            Context context2 = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            button.setBackground(qVar.b(context2));
            ie0.a.f().m(itemView.getContext(), R.drawable.m0b, c24.a.a(29), 1001);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(Function1 onTagClick, String tag, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(onTagClick, "$onTagClick");
            Intrinsics.checkNotNullParameter(tag, "$tag");
            onTagClick.invoke(tag);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final String tag, @NotNull final Function1<? super String, Boolean> onTagClick) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(onTagClick, "onTagClick");
            Button button = (Button) this.itemView.findViewById(R.id.jjc);
            button.setText(tag);
            if (this.E.selectedTags.contains(tag)) {
                button.setSelected(true);
                this.itemView.setOnClickListener(null);
            } else {
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdelieAvatarTagAdapter.d.n(Function1.this, tag, view);
                    }
                });
                button.setSelected(this.E.selectedTags.contains(tag));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdelieAvatarTagAdapter(@NotNull List<? extends Pair<String, ? extends List<String>>> categories, @NotNull Function1<? super String, Boolean> onTagClick) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(onTagClick, "onTagClick");
        this.categories = categories;
        this.onTagClick = onTagClick;
        this.initialTagCount = 8;
        this.selectedTags = new LinkedHashSet();
    }

    private final String n0(int position) {
        int i3 = 0;
        for (Pair<String, List<String>> pair : this.categories) {
            String component1 = pair.component1();
            List<String> component2 = pair.component2();
            if (position == i3) {
                return component1;
            }
            i3 += component2.size() + 1;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    private final String o0(int position) {
        int i3 = this.isExpanded;
        Iterator<Pair<String, List<String>>> it = this.categories.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            for (String str : it.next().component2()) {
                if (!this.isExpanded) {
                    Iterator<T> it5 = this.categories.iterator();
                    int i17 = 0;
                    while (it5.hasNext()) {
                        i17 += ((List) ((Pair) it5.next()).getSecond()).size();
                    }
                    if (i16 == Math.min(i17, this.initialTagCount)) {
                        break;
                    }
                }
                if (i16 + i3 == position) {
                    return str;
                }
                i16++;
            }
            if (this.isExpanded) {
                i3++;
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    private final boolean p0(int position) {
        if (!this.isExpanded) {
            return false;
        }
        Iterator<Pair<String, List<String>>> it = this.categories.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            List<String> component2 = it.next().component2();
            if (position == i3) {
                return true;
            }
            i3 += component2.size() + 1;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3 = 0;
        if (this.isExpanded) {
            Iterator<T> it = this.categories.iterator();
            while (it.hasNext()) {
                i3 += ((List) ((Pair) it.next()).getSecond()).size();
            }
            return i3 + this.categories.size();
        }
        Iterator<T> it5 = this.categories.iterator();
        while (it5.hasNext()) {
            i3 += ((List) ((Pair) it5.next()).getSecond()).size();
        }
        return Math.min(i3, this.initialTagCount) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == getNUM_BACKGOURND_ICON() - 1 && !this.isExpanded) {
            return 2;
        }
        if (!p0(position)) {
            return 1;
        }
        return 0;
    }

    public final void m0() {
        this.selectedTags.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = holder.getItemViewType();
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                ((d) holder).m(o0(position), new Function1<String, Boolean>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarTagAdapter$onBindViewHolder$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull String tagName) {
                        Function1 function1;
                        Intrinsics.checkNotNullParameter(tagName, "tagName");
                        function1 = AdelieAvatarTagAdapter.this.onTagClick;
                        boolean booleanValue = ((Boolean) function1.invoke(tagName)).booleanValue();
                        if (booleanValue) {
                            AdelieAvatarTagAdapter.this.notifyItemChanged(position);
                        }
                        return Boolean.valueOf(booleanValue);
                    }
                });
                return;
            }
            return;
        }
        ((a) holder).l(n0(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dt8, parent, false);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return new c(this, view);
            }
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dt7, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new d(this, view2);
        }
        View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.dsz, parent, false);
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        return new a(this, view3);
    }

    public final void q0(@NotNull String currentStr) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(currentStr, "currentStr");
        this.selectedTags.clear();
        Iterator<Pair<String, List<String>>> it = this.categories.iterator();
        while (it.hasNext()) {
            for (String str : it.next().component2()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) currentStr, (CharSequence) str, false, 2, (Object) null);
                if (contains$default) {
                    this.selectedTags.add(str);
                }
            }
        }
    }

    public final void r0(boolean expanded) {
        this.isExpanded = expanded;
    }

    @NotNull
    public final String s0() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.selectedTags, ",", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }
}
