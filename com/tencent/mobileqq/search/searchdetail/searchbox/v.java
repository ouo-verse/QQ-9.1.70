package com.tencent.mobileqq.search.searchdetail.searchbox;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.sugreport.NetSearchSugWXReport;
import com.tencent.mobileqq.search.searchdetail.searchbox.v;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Collection;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B9\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\"\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u0016\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R#\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/v;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "type", "onCreateViewHolder", "getItemCount", "holder", com.tencent.luggage.wxa.c8.c.G, "", "onBindViewHolder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "j0", "()Ljava/lang/String;", "keyWord", BdhLogUtil.LogTag.Tag_Conn, "k0", "pageSessionId", "Lkotlin/Function1;", "Lrp2/a;", "D", "Lkotlin/jvm/functions/Function1;", "i0", "()Lkotlin/jvm/functions/Function1;", "eventListener", "", "Lrp2/c$b;", "E", "Ljava/util/List;", "_data", "", "data", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", UserInfo.SEX_FEMALE, "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class v extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String pageSessionId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<rp2.a, Unit> eventListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<c.SearchSuggestKeywordData> _data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyWord;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/v$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "text", "keyword", "Landroid/text/SpannableString;", DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "", "position", "Lrp2/c$b;", "newData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, com.tencent.luggage.wxa.c8.c.G, "o", "E", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "textView", "G", "closeBtn", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/searchbox/v;Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View rootView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final View closeBtn;
        final /* synthetic */ v H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull v vVar, View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.H = vVar;
            this.rootView = rootView;
            View findViewById = rootView.findViewById(R.id.f107036_b);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_context)");
            TextView textView = (TextView) findViewById;
            this.textView = textView;
            Drawable o16 = ie0.a.f().o(rootView.getContext(), R.drawable.qui_search, R.color.qui_common_icon_secondary, 1000);
            o16.setBounds(new Rect(0, 0, ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f)));
            textView.setCompoundDrawables(o16, null, null, null);
            View findViewById2 = rootView.findViewById(R.id.dum);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_close)");
            this.closeBtn = findViewById2;
            findViewById2.setVisibility(8);
        }

        private final void m(View view, int position, c.SearchSuggestKeywordData newData) {
            VideoReport.setElementId(view, "em_bas_associative_word");
            VideoReport.setElementReuseIdentifier(view, String.valueOf(newData.getSugWord().hashCode()));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(newData.k());
            linkedHashMap.put("trans_info", newData.d("trans_info"));
            linkedHashMap.put("serial_number", Integer.valueOf(position + 1));
            linkedHashMap.put("search_query_text", newData.getQueryKeyword());
            VideoReport.setElementParams(view, linkedHashMap);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }

        private final SpannableString n(String text, String keyword) {
            return com.tencent.mobileqq.search.searchdetail.util.b.f284738a.a(text, keyword);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(v this$0, c.SearchSuggestKeywordData newData, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            if (!FastClickUtils.isFastDoubleClick("SuggestWordsAdapter")) {
                this$0.i0().invoke(new a.C11153a(new KeyWordChangeEvent(newData.getSugWord(), 2, newData.e(), newData.i())));
                NetSearchSugWXReport netSearchSugWXReport = NetSearchSugWXReport.f284428a;
                if (netSearchSugWXReport.f(newData.getSugWordType(), newData.h())) {
                    netSearchSugWXReport.g(NetSearchSugWXReport.ReqBusinessType.NET_SERACH, NetSearchSugWXReport.SugReportActionType.CLICK, this$0.getPageSessionId(), i3, newData.getQueryKeyword(), newData.getSugWord(), newData.h());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void o(@NotNull final c.SearchSuggestKeywordData newData, final int pos) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            if (QLog.isDebugVersion()) {
                this.textView.setText(n(newData.getSugWord() + "(" + NetSearchSugWXReport.f284428a.e(newData.h()) + ")", this.H.getKeyWord()));
            } else {
                this.textView.setText(n(newData.getSugWord(), this.H.getKeyWord()));
            }
            View view = this.rootView;
            final v vVar = this.H;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    v.b.p(v.this, newData, pos, view2);
                }
            });
            this.rootView.setTag(R.id.f1194776y, newData);
            this.rootView.setTag(R.id.f11953774, Integer.valueOf(newData.getSugWordType()));
            m(this.rootView, newData.getId(), newData);
            if (!newData.getHasReportWXImpl()) {
                NetSearchSugWXReport netSearchSugWXReport = NetSearchSugWXReport.f284428a;
                if (netSearchSugWXReport.f(newData.getSugWordType(), newData.h())) {
                    netSearchSugWXReport.g(NetSearchSugWXReport.ReqBusinessType.NET_SERACH, NetSearchSugWXReport.SugReportActionType.IMPL, this.H.getPageSessionId(), pos, newData.getQueryKeyword(), newData.getSugWord(), newData.h());
                    newData.j(true);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull List<c.SearchSuggestKeywordData> data, @NotNull String keyWord, @NotNull String pageSessionId, @NotNull Function1<? super rp2.a, Unit> eventListener) {
        List<c.SearchSuggestKeywordData> mutableList;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(pageSessionId, "pageSessionId");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.keyWord = keyWord;
        this.pageSessionId = pageSessionId;
        this.eventListener = eventListener;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) data);
        this._data = mutableList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this._data.size();
    }

    @NotNull
    public final Function1<rp2.a, Unit> i0() {
        return this.eventListener;
    }

    @NotNull
    /* renamed from: j0, reason: from getter */
    public final String getKeyWord() {
        return this.keyWord;
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final String getPageSessionId() {
        return this.pageSessionId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            ((b) holder).o(this._data.get(pos), pos);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent).inflate(R.layout.h2x, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(this, itemView);
    }
}
