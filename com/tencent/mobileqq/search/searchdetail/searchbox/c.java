package com.tencent.mobileqq.search.searchdetail.searchbox;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.searchbox.c;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rp2.KeyWordChangeEvent;
import rp2.a;
import rp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B)\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0#\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u0018\u00a2\u0006\u0004\b%\u0010&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "position", "", "keyword", "", "dtBindViewReport", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "type", "onCreateViewHolder", "Lrp2/c$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o0", "getItemCount", "getItemViewType", "holder", com.tencent.luggage.wxa.c8.c.G, "onBindViewHolder", "Lkotlin/Function1;", "Lrp2/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "l0", "()Lkotlin/jvm/functions/Function1;", "eventListener", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "_data", "", "data", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "D", "a", "b", "c", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<c.SearchHistoryKeywordData> _data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<rp2.a, Unit> eventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/searchbox/c;Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View rootView;
        final /* synthetic */ c F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull c cVar, View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.F = cVar;
            this.rootView = rootView;
            VideoReport.setElementId(rootView, "em_bas_clear_history");
            VideoReport.setElementExposePolicy(rootView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(rootView, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(rootView, ClickPolicy.REPORT_ALL);
        }

        public final void l() {
            if (this.F._data.size() == 0) {
                this.rootView.setVisibility(8);
            } else {
                this.rootView.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/c$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "eleID", IECDtReport.ACTION_IDENTIFIER, "", "p", "Lrp2/c$a;", "newData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "Landroid/view/View;", "o", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "textView", "G", "closeBtn", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/searchbox/c;Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.searchbox.c$c, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public final class C8545c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View rootView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final View closeBtn;
        final /* synthetic */ c H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8545c(@NotNull c cVar, View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.H = cVar;
            this.rootView = rootView;
            View findViewById = rootView.findViewById(R.id.f107036_b);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_context)");
            TextView textView = (TextView) findViewById;
            this.textView = textView;
            View findViewById2 = rootView.findViewById(R.id.dum);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_close)");
            this.closeBtn = findViewById2;
            Drawable o16 = ie0.a.f().o(rootView.getContext(), R.drawable.qui_time, R.color.qui_common_icon_secondary, 1000);
            o16.setBounds(new Rect(0, 0, ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f)));
            textView.setCompoundDrawables(o16, null, null, null);
        }

        private final void p(View view, String eleID, String identifier) {
            VideoReport.setElementId(view, eleID);
            VideoReport.setElementReuseIdentifier(view, identifier);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(c this$0, c.SearchHistoryKeywordData newData, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.HistoryRecordAdapter")) {
                QLog.d("QQSearch.NetDetail.HistoryRecordAdapter", 1, "close clicked");
                this$0.l0().invoke(new a.b(newData));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(c this$0, c.SearchHistoryKeywordData newData, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.HistoryRecordAdapter")) {
                this$0.l0().invoke(new a.C11153a(new KeyWordChangeEvent(newData.getKeyWord(), 3, null, null, 12, null)));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }

        public final void q(@NotNull final c.SearchHistoryKeywordData newData) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            this.textView.setText(newData.getKeyWord());
            View view = this.closeBtn;
            final c cVar = this.H;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.C8545c.r(c.this, newData, view2);
                }
            });
            View view2 = this.rootView;
            final c cVar2 = this.H;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    c.C8545c.s(c.this, newData, view3);
                }
            });
            p(this.closeBtn, "em_bas_history_deletion", "deletion_" + newData.getKeyWord().hashCode());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull List<c.SearchHistoryKeywordData> data, @NotNull Function1<? super rp2.a, Unit> eventListener) {
        List<c.SearchHistoryKeywordData> mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.eventListener = eventListener;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) data);
        this._data = mutableList;
    }

    private final void dtBindViewReport(View view, int position, String keyword) {
        VideoReport.setElementId(view, "em_bas_search_history_box");
        VideoReport.setElementReuseIdentifier(view, keyword);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("serial_number", Integer.valueOf(position + 1));
        linkedHashMap.put("search_query_text", keyword);
        VideoReport.setElementParams(view, linkedHashMap);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.HistoryRecordAdapter")) {
            this$0.eventListener.invoke(new a.c());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.HistoryRecordAdapter")) {
            this$0.eventListener.invoke(new a.c());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this._data.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position >= this._data.size()) {
            return 10010;
        }
        return 0;
    }

    @NotNull
    public final Function1<rp2.a, Unit> l0() {
        return this.eventListener;
    }

    public final boolean o0(@NotNull c.SearchHistoryKeywordData item) {
        boolean z16;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<c.SearchHistoryKeywordData> it = this._data.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (item.getId() == it.next().getId()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        this._data.remove(i3);
        notifyItemRemoved(i3);
        if (this._data.size() != 0) {
            return false;
        }
        notifyItemChanged(0);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof C8545c) {
            C8545c c8545c = (C8545c) holder;
            c8545c.q(this._data.get(pos));
            dtBindViewReport(c8545c.getRootView(), pos, this._data.get(pos).getKeyWord());
        } else if (holder instanceof b) {
            ((b) holder).l();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (type == 10010) {
            View view = com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent).inflate(R.layout.h2u, parent, false);
            view.findViewById(R.id.f1067669l).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.m0(c.this, view2);
                }
            });
            view.findViewById(R.id.f165964y84).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.n0(c.this, view2);
                }
            });
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new b(this, view);
        }
        View itemView = com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent).inflate(R.layout.h2x, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new C8545c(this, itemView);
    }
}
