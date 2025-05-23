package com.tencent.mobileqq.search.guildsearch.activation.delegate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryTipsItemDelegate;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00100\u0005H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/SearchHistoryTipsItemDelegate;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "SearchHistoryTipSection", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchHistoryTipsItemDelegate extends a<ListBaseData.ShowAllHistoryData> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/SearchHistoryTipsItemDelegate$SearchHistoryTipSection;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/b;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "r", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "textView", "f", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$c;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class SearchHistoryTipSection extends b<ListBaseData.ShowAllHistoryData> {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView textView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ListBaseData.ShowAllHistoryData data;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        @NotNull
        public int[] getViewStubLayoutId() {
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@Nullable View containerView) {
            TextView textView;
            if (containerView != null) {
                textView = (TextView) containerView.findViewById(R.id.jfb);
            } else {
                textView = null;
            }
            TextView textView2 = textView;
            this.textView = textView2;
            if (textView2 != null) {
                j.u(j.f431768a, textView2, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryTipsItemDelegate$SearchHistoryTipSection$onInitView$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        ListBaseData.ShowAllHistoryData showAllHistoryData;
                        GuildSearchActivationPart.e listControllerIoc;
                        Intrinsics.checkNotNullParameter(it, "it");
                        showAllHistoryData = SearchHistoryTipsItemDelegate.SearchHistoryTipSection.this.data;
                        if (showAllHistoryData == null || (listControllerIoc = SearchHistoryTipsItemDelegate.SearchHistoryTipSection.this.getListControllerIoc()) == null) {
                            return;
                        }
                        listControllerIoc.a(showAllHistoryData);
                    }
                }, 3, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.search.guildsearch.activation.delegate.b, com.tencent.biz.richframework.part.adapter.section.Section
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onBindData(@NotNull ListBaseData.ShowAllHistoryData data, int position, @Nullable List<Object> payload) {
            int i3;
            Intrinsics.checkNotNullParameter(data, "data");
            super.onBindData(data, position, payload);
            this.data = data;
            TextView textView = this.textView;
            if (textView != null) {
                textView.setText(data.getText());
            }
            HashMap hashMap = new HashMap();
            if (data.getDataType() == 3) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            hashMap.put("sgrp_type", Integer.valueOf(i3));
            hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_RES_COUNT, Integer.valueOf(data.getTotalHistoryCount()));
            VideoReport.setElementId(this.textView, "em_sgrp_clear_history");
            VideoReport.setElementParams(this.textView, hashMap);
            VideoReport.setElementClickPolicy(this.textView, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(this.textView, ExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull ListBaseData item, @NotNull List<ListBaseData> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof ListBaseData.ShowAllHistoryData;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.h2v;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<ListBaseData.ShowAllHistoryData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(SearchHistoryTipSection.class);
    }
}
