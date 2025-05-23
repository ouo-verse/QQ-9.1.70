package com.tencent.mobileqq.search.guildsearch.activation.delegate;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryItemDelegate;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import hp2.aa;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00100\u0005H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/SearchHistoryItemDelegate;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "e", "a", "SearchHistoryItemSection", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchHistoryItemDelegate extends a<ListBaseData.SearchHistoryData> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/SearchHistoryItemDelegate$SearchHistoryItemSection;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/b;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", "data", "", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "r", "Lhp2/aa;", "e", "Lhp2/aa;", "viewBinding", "f", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$b;", h.F, "I", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class SearchHistoryItemSection extends b<ListBaseData.SearchHistoryData> {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private aa viewBinding;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ListBaseData.SearchHistoryData data;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int position;

        private final void s(ListBaseData.SearchHistoryData data) {
            TextView textView;
            TextView textView2;
            HashMap hashMap = new HashMap();
            hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_RES_COUNT, Integer.valueOf(data.getTotalHistoryCount()));
            aa aaVar = this.viewBinding;
            LinearLayout linearLayout = null;
            if (aaVar != null) {
                textView = aaVar.f405528d;
            } else {
                textView = null;
            }
            VideoReport.setElementId(textView, "em_sgrp_search_history_region");
            aa aaVar2 = this.viewBinding;
            if (aaVar2 != null) {
                textView2 = aaVar2.f405528d;
            } else {
                textView2 = null;
            }
            VideoReport.setElementParams(textView2, hashMap);
            aa aaVar3 = this.viewBinding;
            if (aaVar3 != null) {
                linearLayout = aaVar3.getRoot();
            }
            VideoReport.setElementExposePolicy(linearLayout, ExposurePolicy.REPORT_ALL);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        @NotNull
        public int[] getViewStubLayoutId() {
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@Nullable View containerView) {
            View view;
            LinearLayout root;
            ImageView imageView;
            boolean z16;
            if (containerView != null) {
                view = containerView.findViewById(R.id.root);
            } else {
                view = null;
            }
            if (view == null) {
                if (containerView == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.e("QQSearch.Local.Guild.SearchHistoryItemDelegate", 1, "onInitView failed for rootView got null,container null:" + z16);
                return;
            }
            aa e16 = aa.e(view);
            this.viewBinding = e16;
            if (e16 != null && (imageView = e16.f405526b) != null) {
                j.u(j.f431768a, imageView, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryItemDelegate$SearchHistoryItemSection$onInitView$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                        invoke2(view2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        ListBaseData.SearchHistoryData searchHistoryData;
                        GuildSearchActivationPart.e listControllerIoc;
                        Intrinsics.checkNotNullParameter(it, "it");
                        searchHistoryData = SearchHistoryItemDelegate.SearchHistoryItemSection.this.data;
                        if (searchHistoryData == null || (listControllerIoc = SearchHistoryItemDelegate.SearchHistoryItemSection.this.getListControllerIoc()) == null) {
                            return;
                        }
                        listControllerIoc.d(searchHistoryData);
                    }
                }, 3, null);
            }
            aa aaVar = this.viewBinding;
            if (aaVar != null && (root = aaVar.getRoot()) != null) {
                j.u(j.f431768a, root, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.guildsearch.activation.delegate.SearchHistoryItemDelegate$SearchHistoryItemSection$onInitView$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                        invoke2(view2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        ListBaseData.SearchHistoryData searchHistoryData;
                        GuildSearchActivationPart.e listControllerIoc;
                        Intrinsics.checkNotNullParameter(it, "it");
                        searchHistoryData = SearchHistoryItemDelegate.SearchHistoryItemSection.this.data;
                        if (searchHistoryData == null || (listControllerIoc = SearchHistoryItemDelegate.SearchHistoryItemSection.this.getListControllerIoc()) == null) {
                            return;
                        }
                        listControllerIoc.c(searchHistoryData);
                    }
                }, 3, null);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QQSearch.Local.Guild.SearchHistoryItemDelegate", "onInitView");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.search.guildsearch.activation.delegate.b, com.tencent.biz.richframework.part.adapter.section.Section
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onBindData(@NotNull ListBaseData.SearchHistoryData data, int position, @Nullable List<Object> payload) {
            TextView textView;
            LinearLayout linearLayout;
            LinearLayout linearLayout2;
            LinearLayout linearLayout3;
            LinearLayout linearLayout4;
            ImageView imageView;
            LinearLayout linearLayout5;
            Intrinsics.checkNotNullParameter(data, "data");
            super.onBindData(data, position, payload);
            this.data = data;
            this.position = position;
            aa aaVar = this.viewBinding;
            LinearLayout linearLayout6 = null;
            if (aaVar != null) {
                textView = aaVar.f405528d;
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setText(data.getKeyWord());
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QQSearch.Local.Guild.SearchHistoryItemDelegate", "onBindData " + data);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_rank", Integer.valueOf(position));
            hashMap.put("sgrp_word", data.getKeyWord());
            hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_RES_COUNT, Integer.valueOf(data.getTotalHistoryCount()));
            aa aaVar2 = this.viewBinding;
            if (aaVar2 != null) {
                linearLayout = aaVar2.getRoot();
            } else {
                linearLayout = null;
            }
            VideoReport.setElementId(linearLayout, "em_sgrp_search_history_word");
            aa aaVar3 = this.viewBinding;
            if (aaVar3 != null) {
                linearLayout2 = aaVar3.getRoot();
            } else {
                linearLayout2 = null;
            }
            VideoReport.setElementParams(linearLayout2, hashMap);
            aa aaVar4 = this.viewBinding;
            if (aaVar4 != null) {
                linearLayout3 = aaVar4.getRoot();
            } else {
                linearLayout3 = null;
            }
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(linearLayout3, clickPolicy);
            aa aaVar5 = this.viewBinding;
            if (aaVar5 != null) {
                linearLayout4 = aaVar5.getRoot();
            } else {
                linearLayout4 = null;
            }
            VideoReport.setElementExposePolicy(linearLayout4, ExposurePolicy.REPORT_ALL);
            aa aaVar6 = this.viewBinding;
            if (aaVar6 != null) {
                imageView = aaVar6.f405526b;
            } else {
                imageView = null;
            }
            VideoReport.setElementId(imageView, "em_sgrp_search_history_word_del");
            aa aaVar7 = this.viewBinding;
            if (aaVar7 != null) {
                linearLayout5 = aaVar7.getRoot();
            } else {
                linearLayout5 = null;
            }
            VideoReport.setElementClickPolicy(linearLayout5, clickPolicy);
            aa aaVar8 = this.viewBinding;
            if (aaVar8 != null) {
                linearLayout6 = aaVar8.getRoot();
            }
            VideoReport.setElementParams(linearLayout6, hashMap);
            if (position == 0) {
                s(data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull ListBaseData item, @NotNull List<ListBaseData> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof ListBaseData.SearchHistoryData;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.h2t;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<ListBaseData.SearchHistoryData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(SearchHistoryItemSection.class);
    }
}
