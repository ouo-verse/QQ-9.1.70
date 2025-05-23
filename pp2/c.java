package pp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001f !\"B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lpp2/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "getItemViewType", "Lpp2/c$d;", "listener", "n0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "items", BdhLogUtil.LogTag.Tag_Conn, "Lpp2/c$d;", "itemClickListener", "<init>", "()V", "D", "a", "b", "c", "d", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d itemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SearchMiniAppConditonFilter> items = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lpp2/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lpp2/c$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pp2.c$c, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C11034c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11034c(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View view2 = this.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.TextView");
            this.textView = (TextView) view2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lpp2/c$d;", "", "", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "filter", "", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface d {
        void a(int position, @NotNull SearchMiniAppConditonFilter filter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(c this$0, int i3, SearchMiniAppConditonFilter filter, RecyclerView.ViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(filter, "$filter");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Logger.f235387a.d().i("QQSearch.NetDetail.HorizontalAdapter", 1, "onBindViewHolder onItemClick filter:" + filter);
        d dVar = this$0.itemClickListener;
        if (dVar != null) {
            dVar.a(i3 - 1, filter);
        }
        HashMap hashMap = new HashMap();
        String str = filter.title;
        Intrinsics.checkNotNullExpressionValue(str, "filter.title");
        hashMap.put("filter_type", str);
        hashMap.put("screen_serial_number", Integer.valueOf(i3 - 1));
        com.tencent.mobileqq.search.report.a.f283716a.d("dt_clck", ((C11034c) holder).getTextView(), "em_bas_small_game_screening_box", hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map l0(SearchMiniAppConditonFilter filter, int i3, String str) {
        Intrinsics.checkNotNullParameter(filter, "$filter");
        HashMap hashMap = new HashMap();
        String str2 = filter.title;
        Intrinsics.checkNotNullExpressionValue(str2, "filter.title");
        hashMap.put("filter_type", str2);
        hashMap.put("screen_serial_number", Integer.valueOf(i3 - 1));
        return hashMap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.items.size() + 1 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position != 0 && position != this.items.size() + 1) {
            return 1;
        }
        return 0;
    }

    public final void m0(@NotNull List<SearchMiniAppConditonFilter> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.items.clear();
        this.items.addAll(tags);
        notifyDataSetChanged();
    }

    public final void n0(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof C11034c) {
            final SearchMiniAppConditonFilter searchMiniAppConditonFilter = this.items.get(position - 1);
            C11034c c11034c = (C11034c) holder;
            c11034c.getTextView().setText(searchMiniAppConditonFilter.title);
            c11034c.getTextView().setOnClickListener(new View.OnClickListener() { // from class: pp2.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.k0(c.this, position, searchMiniAppConditonFilter, holder, view);
                }
            });
            if (searchMiniAppConditonFilter.selected == 1) {
                c11034c.getTextView().setBackgroundResource(R.drawable.jog);
                c11034c.getTextView().setTextColor(c11034c.getTextView().getResources().getColor(R.color.qui_common_text_link));
            } else {
                c11034c.getTextView().setBackgroundResource(R.drawable.joh);
                c11034c.getTextView().setTextColor(c11034c.getTextView().getResources().getColor(R.color.qui_common_text_primary));
            }
            com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
            String str = searchMiniAppConditonFilter.reportId;
            Intrinsics.checkNotNullExpressionValue(str, "filter.reportId");
            com.tencent.mobileqq.search.report.a.b(aVar, str, "em_bas_small_game_screening_box", c11034c.getTextView(), null, null, ClickPolicy.REPORT_NONE, null, new IDynamicParams() { // from class: pp2.b
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str2) {
                    Map l06;
                    l06 = c.l0(SearchMiniAppConditonFilter.this, position, str2);
                    return l06;
                }
            }, 88, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.foc, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ader_view, parent, false)");
            return new b(inflate);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.fod, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf\u2026_tag_view, parent, false)");
        return new C11034c(inflate2);
    }
}
