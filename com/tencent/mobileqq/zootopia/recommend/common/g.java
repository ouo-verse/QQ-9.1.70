package com.tencent.mobileqq.zootopia.recommend.common;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.p;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJD\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002JB\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/recommend/common/g;", "Lcom/tencent/mobileqq/mvvm/b;", "Landroid/content/Context;", "context", "Ldb4/a;", "cardFeedsVMHandler", "Lcom/tencent/mobileqq/zootopia/recommend/common/ZplanCardFeedsListView;", "cardListView", "Lcom/tencent/mobileqq/zootopia/recommend/common/c;", "listAdapter", "Lgd3/c;", "viewModel", "", "Lcom/tencent/sqshow/zootopia/data/c;", "dataList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function0;", "renderCallback", "j", "Loa4/a;", "d", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "e", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    public g(oa4.a mapResViewModel, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.mapResViewModel = mapResViewModel;
        this.sourceCurrent = sourceCurrent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g this$0, Context context, db4.a aVar, ZplanCardFeedsListView cardListView, c listAdapter, gd3.c cVar, Function0 renderCallback, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardListView, "$cardListView");
        Intrinsics.checkNotNullParameter(listAdapter, "$listAdapter");
        Intrinsics.checkNotNullParameter(renderCallback, "$renderCallback");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.m(context, aVar, cardListView, listAdapter, cVar, it);
        renderCallback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(db4.a aVar, c listAdapter, gd3.c cVar, g this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(listAdapter, "$listAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar != null) {
            aVar.I4(2);
        }
        listAdapter.fillList(cVar.Q1());
        id3.e.f407552a.e(0, this$0.sourceCurrent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ZootopiaPullRefreshLayout pullRefreshView) {
        Intrinsics.checkNotNullParameter(pullRefreshView, "$pullRefreshView");
        pullRefreshView.s(true);
    }

    private final void m(Context context, db4.a cardFeedsVMHandler, ZplanCardFeedsListView cardListView, c listAdapter, gd3.c viewModel, List<ZootopiaCardData> dataList) {
        if (cardFeedsVMHandler != null) {
            cardFeedsVMHandler.I4(dataList.isEmpty() ? 3 : 4);
        }
        List<ZootopiaCardData> Q1 = viewModel.Q1();
        if (listAdapter != null) {
            listAdapter.fillList(Q1);
        }
        final ZootopiaPullRefreshLayout d16 = cardListView.d();
        d16.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.recommend.common.f
            @Override // java.lang.Runnable
            public final void run() {
                g.n(ZootopiaPullRefreshLayout.this);
            }
        });
        if (dataList.isEmpty()) {
            id3.e.f407552a.e(1, this.sourceCurrent);
        } else {
            id3.e.f407552a.e(2, this.sourceCurrent);
        }
    }

    public final c j(LifecycleOwner owner, final Context context, final gd3.c viewModel, final ZplanCardFeedsListView cardListView, final db4.a cardFeedsVMHandler, final Function0<Unit> renderCallback) {
        MutableLiveData<ErrorMessage> P1;
        MutableLiveData<List<ZootopiaCardData>> O1;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(cardListView, "cardListView");
        Intrinsics.checkNotNullParameter(renderCallback, "renderCallback");
        RecyclerViewWithHeaderFooterFix E = cardListView.d().E();
        Intrinsics.checkNotNullExpressionValue(E, "cardListView.getPullRefreshView().recyclerView");
        p.a(E, this.sourceCurrent);
        cardListView.d().G(false);
        cardListView.setViewModel(viewModel);
        Context context2 = cardListView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "cardListView.context");
        final c cVar = new c(context2, this.mapResViewModel, owner, this.sourceCurrent, null, 16, null);
        cardListView.setAdapter(cVar);
        if (viewModel != null && (O1 = viewModel.O1()) != null) {
            O1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.recommend.common.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.k(g.this, context, cardFeedsVMHandler, cardListView, cVar, viewModel, renderCallback, (List) obj);
                }
            });
        }
        if (viewModel != null && (P1 = viewModel.P1()) != null) {
            P1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.recommend.common.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.l(db4.a.this, cVar, viewModel, this, (ErrorMessage) obj);
                }
            });
        }
        return cVar;
    }
}
