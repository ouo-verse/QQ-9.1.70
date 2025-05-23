package com.tencent.mobileqq.search.searchdetail.content.template.ai.ui;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import hp2.ad;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B)\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u001d\u00a2\u0006\u0004\b!\u0010\"J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0014\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/SearchItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/SearchItemAdapter$b;", "", IECDtReport.ACTION_IDENTIFIER, "eid", "Landroid/view/View;", "view", "", "", "extraParam", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "k0", "getItemCount", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "newItems", "setItems", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "items", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onItemClick", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "D", "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchItemAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<SearchListDetail, Unit> onItemClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchListDetail> items;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/SearchItemAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhp2/ad;", "E", "Lhp2/ad;", "l", "()Lhp2/ad;", "binding", "<init>", "(Lhp2/ad;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ad binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ad binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ad getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchItemAdapter(@NotNull List<SearchListDetail> items, @NotNull Function1<? super SearchListDetail, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.items = items;
        this.onItemClick = onItemClick;
    }

    private final void j0(String identifier, String eid, View view, Map<String, Object> extraParam) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementReuseIdentifier(view, identifier + "_" + view.hashCode());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, extraParam);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final SearchListDetail searchListDetail = this.items.get(position);
        j jVar = j.f431768a;
        LinearLayout root = holder.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "holder.binding.root");
        j.u(jVar, root, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.SearchItemAdapter$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(it, "it");
                function1 = SearchItemAdapter.this.onItemClick;
                function1.invoke(searchListDetail);
            }
        }, 3, null);
        holder.getBinding().f405544c.setText(searchListDetail.title.text);
        holder.getBinding().f405543b.setColorFilter(new PorterDuffColorFilter(holder.getBinding().f405543b.getContext().getColor(R.color.qui_common_text_link), PorterDuff.Mode.SRC_IN));
        String str = searchListDetail.icon.iconLink;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            str = "https://p.iqun.qq.com/web/task/20241212/f45e1359-6bbc-4711-b899-23e71e50f5cf-1733989919720.png";
        }
        String iconLink = str;
        o oVar = o.f284545a;
        ImageView imageView = holder.getBinding().f405543b;
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.icon");
        Intrinsics.checkNotNullExpressionValue(iconLink, "iconLink");
        o.g(oVar, "", imageView, iconLink, null, 8, null);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QQSearch.NetDetail.SearchRefListAdapter", 2, "bind icon " + searchListDetail.icon.iconLink);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("rank", Integer.valueOf(position));
        String valueOf = String.valueOf(position);
        LinearLayout root2 = holder.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "holder.binding.root");
        j0(valueOf, "em_bas_reference_article", root2, linkedHashMap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ad g16 = ad.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new b(g16);
    }

    public final void setItems(@NotNull List<SearchListDetail> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }
}
