package com.tencent.mobileqq.search.guildsearch.activation.delegate;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.activation.delegate.e;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import hp2.ac;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00100\u0005H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/e;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends com.tencent.mobileqq.search.guildsearch.activation.delegate.a<ListBaseData.OperationHotData> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/e$a;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/b;", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$a;", "data", "", "r", "v", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "t", "Lhp2/ac;", "e", "Lhp2/ac;", "viewBinding", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/c;", "f", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/c;", "childItemListAdapter", "<init>", "()V", h.F, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends b<ListBaseData.OperationHotData> {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ac viewBinding;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private c childItemListAdapter;

        private final void r(final ListBaseData.OperationHotData data) {
            int coerceAtMost;
            ac acVar = null;
            if (TextUtils.isEmpty(data.getPicUrl())) {
                ac acVar2 = this.viewBinding;
                if (acVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    acVar = acVar2;
                }
                acVar.f405538c.setVisibility(8);
                return;
            }
            ac acVar3 = this.viewBinding;
            if (acVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar3 = null;
            }
            acVar3.f405538c.setVisibility(0);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ac acVar4 = this.viewBinding;
            if (acVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar4 = null;
            }
            obtain.mFailedDrawable = acVar4.f405540e.getContext().getDrawable(R.drawable.kbl);
            ac acVar5 = this.viewBinding;
            if (acVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar5 = null;
            }
            obtain.mLoadingDrawable = acVar5.f405540e.getContext().getDrawable(R.drawable.kbl);
            ac acVar6 = this.viewBinding;
            if (acVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar6 = null;
            }
            acVar6.f405538c.setImageDrawable(URLDrawable.getDrawable(data.getPicUrl(), obtain));
            ac acVar7 = this.viewBinding;
            if (acVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar7 = null;
            }
            acVar7.f405538c.setCorner(ViewUtils.dpToPx(4.0f));
            ac acVar8 = this.viewBinding;
            if (acVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar8 = null;
            }
            acVar8.f405538c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.guildsearch.activation.delegate.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.s(ListBaseData.OperationHotData.this, this, view);
                }
            });
            ac acVar9 = this.viewBinding;
            if (acVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar9 = null;
            }
            AccessibilityUtil.n(acVar9.f405538c, false);
            ac acVar10 = this.viewBinding;
            if (acVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                acVar = acVar10;
            }
            ViewGroup.LayoutParams layoutParams = acVar.f405538c.getLayoutParams();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) (ViewUtils.dpToPx((data.d().size() * 32) - 12) * 0.75f), (ViewUtils.getScreenWidth() / 2) - ViewUtils.dpToPx(16.0f));
            layoutParams.width = coerceAtMost;
            u(data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(ListBaseData.OperationHotData data, a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!TextUtils.isEmpty(data.getPicJumpUrl())) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                AppInterface appInterface = (AppInterface) peekAppRuntime;
                ac acVar = this$0.viewBinding;
                if (acVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    acVar = null;
                }
                SearchUtils.Q0(appInterface, acVar.f405540e.getContext(), data.getPicJumpUrl());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void u(ListBaseData.OperationHotData data) {
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_picture_url", data.getPicUrl());
            ac acVar = this.viewBinding;
            ac acVar2 = null;
            if (acVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar = null;
            }
            VideoReport.setElementId(acVar.f405538c, "em_sgrp_discover_search_hot_image");
            ac acVar3 = this.viewBinding;
            if (acVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar3 = null;
            }
            VideoReport.setElementParams(acVar3.f405538c, hashMap);
            ac acVar4 = this.viewBinding;
            if (acVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar4 = null;
            }
            VideoReport.setElementExposePolicy(acVar4.f405538c, ExposurePolicy.REPORT_ALL);
            ac acVar5 = this.viewBinding;
            if (acVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                acVar2 = acVar5;
            }
            VideoReport.setElementClickPolicy(acVar2.f405538c, ClickPolicy.REPORT_ALL);
        }

        private final void v() {
            ac acVar = this.viewBinding;
            ac acVar2 = null;
            if (acVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar = null;
            }
            VideoReport.setElementId(acVar.f405540e, "em_sgrp_hot_search_region");
            ac acVar3 = this.viewBinding;
            if (acVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                acVar2 = acVar3;
            }
            VideoReport.setElementExposePolicy(acVar2.f405540e, ExposurePolicy.REPORT_ALL);
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
            boolean z16;
            c cVar = null;
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
            ac e16 = ac.e(view);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(rootView)");
            this.viewBinding = e16;
            this.childItemListAdapter = new c();
            ac acVar = this.viewBinding;
            if (acVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar = null;
            }
            acVar.f405539d.setLayoutManager(new SafeLinearLayoutManager(view.getContext()));
            ac acVar2 = this.viewBinding;
            if (acVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar2 = null;
            }
            RecyclerView recyclerView = acVar2.f405539d;
            c cVar2 = this.childItemListAdapter;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childItemListAdapter");
            } else {
                cVar = cVar2;
            }
            recyclerView.setAdapter(cVar);
            v();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.search.guildsearch.activation.delegate.b, com.tencent.biz.richframework.part.adapter.section.Section
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void onBindData(@NotNull ListBaseData.OperationHotData data, int position, @Nullable List<Object> payload) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.onBindData(data, position, payload);
            c cVar = this.childItemListAdapter;
            c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childItemListAdapter");
                cVar = null;
            }
            cVar.l0(getListControllerIoc());
            ac acVar = this.viewBinding;
            if (acVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                acVar = null;
            }
            acVar.f405541f.setText(data.getTitle());
            r(data);
            c cVar3 = this.childItemListAdapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childItemListAdapter");
            } else {
                cVar2 = cVar3;
            }
            cVar2.k0(data.d(), !TextUtils.isEmpty(data.getPicUrl()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull ListBaseData item, @NotNull List<ListBaseData> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof ListBaseData.OperationHotData;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f168858h30;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<ListBaseData.OperationHotData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(a.class);
    }
}
