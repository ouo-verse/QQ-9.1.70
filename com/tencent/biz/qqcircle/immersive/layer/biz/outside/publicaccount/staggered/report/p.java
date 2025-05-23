package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J4\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016JL\u0010\u0016\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/p;", "Lcom/tencent/biz/qqcircle/scrollers/a;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "adapter", "Lcom/tencent/biz/qqcircle/scrollers/b;", "helper", "", "e", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", ReportConstant.COSTREPORT_PREFIX, "t", "onResume", "o", "p", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/q;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "reportSupportList", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class p extends com.tencent.biz.qqcircle.scrollers.a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<q> reportSupportList;

    public p(@NotNull QCircleInitBean initBean) {
        ArrayList<q> arrayListOf;
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new o(initBean), new c());
        this.reportSupportList = arrayListOf;
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void e(@Nullable Context context, @Nullable RecyclerView recyclerView, @Nullable BaseListViewAdapter<?> adapter, @Nullable com.tencent.biz.qqcircle.scrollers.b helper) {
        super.e(context, recyclerView, adapter, helper);
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(context, recyclerView, adapter, helper);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void o() {
        super.o();
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).d();
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onDestroy() {
        super.onDestroy();
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).c();
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onResume() {
        super.onResume();
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).f();
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onStop() {
        super.onStop();
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).h();
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void p() {
        super.p();
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).e();
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void r(@Nullable RecyclerView recyclerView, int newState, @Nullable RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Iterator<T> it = this.reportSupportList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).g(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, isScrollUp);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void s(@Nullable RecyclerView.ViewHolder holder) {
        super.s(holder);
        if (holder == null) {
            return;
        }
        for (q qVar : this.reportSupportList) {
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            qVar.i(view);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void t(@Nullable RecyclerView.ViewHolder holder) {
        super.t(holder);
        if (holder == null) {
            return;
        }
        for (q qVar : this.reportSupportList) {
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            qVar.j(view);
        }
    }
}
