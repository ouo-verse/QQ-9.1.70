package com.tencent.mobileqq.zootopia.portal.home.model;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaListMapListView;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.state.report.SquareReportConst;
import fi3.bd;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaMapListData;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/model/m;", "Lcom/tencent/mobileqq/mvvm/b;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel;", "viewModel", "Lfi3/bd;", "binding", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/portal/home/model/d;", "l", "Loa4/a;", "d", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "e", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lid3/d;", "f", "Lid3/d;", "dtReportHelper", "<init>", "(Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", tl.h.F, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final id3.d dtReportHelper;

    public m(oa4.a mapResViewModel, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.mapResViewModel = mapResViewModel;
        this.sourceCurrent = sourceCurrent;
        this.dtReportHelper = new id3.d(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(bd binding, d adapter, final ZootopiaListMapListView view, m this$0, Context context, ZootopiaMapListData it) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (binding.f399070j.getVisibility() == 0) {
            binding.f399070j.setVisibility(8);
        }
        if (binding.f399063c.getVisibility() == 0) {
            binding.f399063c.setVisibility(8);
        }
        if (!(!it.a().isEmpty()) && it.getSameStyleData() == null) {
            binding.f399062b.setVisibility(0);
            id3.e.f407552a.e(1, this$0.sourceCurrent);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        adapter.A(it);
        view.e().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.l
            @Override // java.lang.Runnable
            public final void run() {
                m.n(ZootopiaListMapListView.this);
            }
        });
        view.setVisibility(0);
        id3.d dVar = this$0.dtReportHelper;
        LinearLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ag.f373258a.d(this$0.sourceCurrent)));
        dVar.j(context, root, "pg_zplan_playground_gallery", mutableMapOf);
        id3.d dVar2 = this$0.dtReportHelper;
        ImageView imageView = binding.f399067g;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.zplanHomeDownload");
        id3.d.h(dVar2, imageView, "em_zplan_playground_gallery_download", new LinkedHashMap(), false, false, null, 56, null);
        id3.e.f407552a.e(2, this$0.sourceCurrent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ZootopiaListMapListView view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.e().s(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d adapter, ZootopiaListMapListView view, ZootopiaListViewModel viewModel, ZootopiaMapListData it) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        if ((!it.a().isEmpty()) || it.getSameStyleData() != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            adapter.s(it);
            view.e().F(true, !viewModel.getIsEnd());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d adapter, zb3.c it) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        adapter.E(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(bd binding, ZootopiaListMapListView view, m this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        binding.f399070j.setVisibility(8);
        view.setVisibility(8);
        binding.f399063c.setVisibility(0);
        id3.e.f407552a.e(0, this$0.sourceCurrent);
    }

    public final d l(LifecycleOwner owner, final ZootopiaListViewModel viewModel, final bd binding, final Context context) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(context, "context");
        final ZootopiaListMapListView zootopiaListMapListView = binding.f399071k;
        Intrinsics.checkNotNullExpressionValue(zootopiaListMapListView, "binding.zplanListView");
        final d dVar = new d(zootopiaListMapListView, this.mapResViewModel, owner, this.sourceCurrent, null, 16, null);
        zootopiaListMapListView.setAdapter(dVar);
        viewModel.X1().removeObservers(owner);
        viewModel.W1().observe(owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.m(bd.this, dVar, zootopiaListMapListView, this, context, (ZootopiaMapListData) obj);
            }
        });
        viewModel.U1().observe(owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.o(d.this, zootopiaListMapListView, viewModel, (ZootopiaMapListData) obj);
            }
        });
        viewModel.Z1().observe(owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.p(d.this, (zb3.c) obj);
            }
        });
        viewModel.T1().observe(owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.model.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.q(bd.this, zootopiaListMapListView, this, (ErrorMessage) obj);
            }
        });
        return dVar;
    }
}
