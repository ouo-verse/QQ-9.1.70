package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.base.activity.SearchMoreActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.SpecialCareSearchFragment;
import com.tencent.mobileqq.search.business.net.view.a;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.am;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import lo2.SearchSuggestItem;
import lo2.ad;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/mobileqq/search/business/net/view/a$a;", "Llo2/ao;", "holder", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "v", "", "invoke", "(Lcom/tencent/mobileqq/search/business/net/view/a$a;Llo2/ao;Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchTemplateSearchSuggestView$searchSuggestItemAdapter$1 extends Lambda implements Function3<a.C8529a<SearchSuggestItem>, SearchSuggestItem, View, Unit> {
    final /* synthetic */ Class<? extends BaseSearchFragment<?>> $FTSEntitySearchFragment;
    final /* synthetic */ ad $model;
    final /* synthetic */ NetSearchTemplateSearchSuggestView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateSearchSuggestView$searchSuggestItemAdapter$1(NetSearchTemplateSearchSuggestView netSearchTemplateSearchSuggestView, ad adVar, Class<? extends BaseSearchFragment<?>> cls) {
        super(3);
        this.this$0 = netSearchTemplateSearchSuggestView;
        this.$model = adVar;
        this.$FTSEntitySearchFragment = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SearchSuggestItem item, ad model, NetSearchTemplateSearchSuggestView this$0, Class FTSEntitySearchFragment, View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(FTSEntitySearchFragment, "$FTSEntitySearchFragment");
        Context context5 = null;
        if (item.getType() == 2) {
            Bundle bundle = new Bundle();
            bundle.putString("keyword", model.N);
            bundle.putBoolean(BaseSearchFragment.KEY_NEED_SHOW_HEADER, false);
            bundle.putInt("key_fit_type", 2);
            bundle.putInt("key_situation", 1);
            bundle.putInt("dtReferPage", 2);
            bundle.putString("trace_id", model.getTraceId());
            SearchMoreActivity.Companion companion = SearchMoreActivity.INSTANCE;
            context3 = this$0.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context3 = null;
            }
            context4 = this$0.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context5 = context4;
            }
            companion.a(context3, FTSEntitySearchFragment, context5.getResources().getString(R.string.f214065rw), bundle);
        } else if (item.getType() == 3) {
            SpecialCareSearchFragment.Companion companion2 = SpecialCareSearchFragment.INSTANCE;
            context2 = this$0.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context5 = context2;
            }
            companion2.a(context5, 2, model.getTraceId());
        } else if (!TextUtils.isEmpty(item.getUrl())) {
            context = this$0.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            SearchUtils.Q0(null, context, SearchUtils.g(item.getUrl()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(a.C8529a<SearchSuggestItem> c8529a, SearchSuggestItem searchSuggestItem, View view) {
        invoke2(c8529a, searchSuggestItem, view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull a.C8529a<SearchSuggestItem> holder, @NotNull final SearchSuggestItem item, @NotNull View v3) {
        Context context;
        Spannable s16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(v3, "v");
        TextView textView = (TextView) v3.findViewById(R.id.l4s);
        context = this.this$0.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        Drawable drawable = context.getResources().getDrawable(R.drawable.k_h);
        int type = item.getType();
        String str = type != 2 ? type != 3 ? "24" : "39" : "38";
        textView.setBackground(drawable);
        NetSearchTemplateSearchSuggestView netSearchTemplateSearchSuggestView = this.this$0;
        String title = item.getTitle();
        String str2 = this.$model.N;
        Intrinsics.checkNotNullExpressionValue(str2, "model.keyword");
        s16 = netSearchTemplateSearchSuggestView.s(title, str2);
        textView.setText(s16);
        final ad adVar = this.$model;
        final NetSearchTemplateSearchSuggestView netSearchTemplateSearchSuggestView2 = this.this$0;
        final Class<? extends BaseSearchFragment<?>> cls = this.$FTSEntitySearchFragment;
        v3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.business.net.view.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchTemplateSearchSuggestView$searchSuggestItemAdapter$1.b(SearchSuggestItem.this, adVar, netSearchTemplateSearchSuggestView2, cls, view);
            }
        });
        String title2 = item.getTitle();
        ad adVar2 = this.$model;
        Intrinsics.checkNotNull(adVar2, "null cannot be cast to non-null type com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem");
        am.r(v3, title2, str, adVar2.z(), holder.getAdapterPosition(), this.$model.e(), String.valueOf(this.$model.hashCode()), this.$model.getRecallReason());
        VideoReport.setElementParam(v3, "is_manual_operation", 0);
    }
}
