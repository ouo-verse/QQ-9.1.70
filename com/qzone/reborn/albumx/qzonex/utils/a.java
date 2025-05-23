package com.qzone.reborn.albumx.qzonex.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J,\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0017J\u0014\u0010\u001a\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0017R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/a;", "", "", com.tencent.luggage.wxa.c8.c.G, "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", tl.h.F, "curPos", "Lcb/b;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/qzone/reborn/base/h;", "listAdapter", "Lsa/e;", "loadMoreAdapter", DomainData.DOMAIN_NAME, "o", "l", "Landroidx/lifecycle/MutableLiveData;", "mutableData", "p", "j", "a", "Z", "isItemDecorationSetup", "b", "Lcom/qzone/reborn/base/h;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "Lsa/e;", "f", "I", "headMarginLeftRight", "Lcom/tencent/biz/richframework/part/block/base/SafeGridLayoutManager;", "g", "Lcom/tencent/biz/richframework/part/block/base/SafeGridLayoutManager;", "gridLayoutManager", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static float f53386i = ef.d.a(Double.valueOf(8.5d));

    /* renamed from: j, reason: collision with root package name */
    private static int f53387j = ef.d.b(3);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isItemDecorationSetup;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.h<cb.b> listAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private sa.e loadMoreAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int headMarginLeftRight = ef.d.b(0);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private SafeGridLayoutManager gridLayoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/albumx/qzonex/utils/a$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            return (a.this.k(position) || a.this.l(position)) ? 3 : 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/qzone/reborn/albumx/qzonex/utils/a$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<cb.b> f53397e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MutableLiveData<cb.b> f53398f;

        c(Ref.ObjectRef<cb.b> objectRef, MutableLiveData<cb.b> mutableLiveData) {
            this.f53397e = objectRef;
            this.f53398f = mutableLiveData;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Object, cb.b] */
        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.Object, cb.b] */
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            SafeGridLayoutManager safeGridLayoutManager = a.this.gridLayoutManager;
            com.qzone.reborn.base.h hVar = null;
            if (safeGridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                safeGridLayoutManager = null;
            }
            int findFirstVisibleItemPosition = safeGridLayoutManager.findFirstVisibleItemPosition();
            SafeGridLayoutManager safeGridLayoutManager2 = a.this.gridLayoutManager;
            if (safeGridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                safeGridLayoutManager2 = null;
            }
            safeGridLayoutManager2.findFirstCompletelyVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1) {
                return;
            }
            if (a.this.k(findFirstVisibleItemPosition)) {
                com.qzone.reborn.base.h hVar2 = a.this.listAdapter;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                } else {
                    hVar = hVar2;
                }
                ?? r26 = (cb.b) hVar.getItems().get(findFirstVisibleItemPosition);
                if (Intrinsics.areEqual(this.f53397e.element, (Object) r26)) {
                    return;
                }
                this.f53398f.postValue(r26);
                this.f53397e.element = r26;
                return;
            }
            ?? i3 = a.this.i(findFirstVisibleItemPosition);
            if (i3 == 0 || Intrinsics.areEqual((Object) i3, this.f53397e.element)) {
                return;
            }
            this.f53397e.element = i3;
            this.f53398f.postValue(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/albumx/qzonex/utils/a$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            com.qzone.reborn.base.h hVar = a.this.listAdapter;
            com.qzone.reborn.base.h hVar2 = null;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                hVar = null;
            }
            if (childAdapterPosition >= hVar.getNUM_BACKGOURND_ICON()) {
                return;
            }
            if (!a.this.k(childAdapterPosition)) {
                if (a.this.m(childAdapterPosition)) {
                    com.qzone.reborn.base.h hVar3 = a.this.listAdapter;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                    } else {
                        hVar2 = hVar3;
                    }
                    cb.b bVar = (cb.b) hVar2.getItems().get(childAdapterPosition);
                    int mediaPos = bVar.getMediaPos();
                    outRect.top = 0;
                    int i3 = (int) (a.f53387j / 2);
                    int i16 = mediaPos % 3;
                    if (i16 == 0) {
                        outRect.left = 0;
                        outRect.right = i3;
                    } else if (i16 == 1) {
                        outRect.left = i3;
                        outRect.right = i3;
                    } else {
                        outRect.left = i3;
                        outRect.right = 0;
                    }
                    int curTimeMediaSize = bVar.getCurTimeMediaSize();
                    int i17 = curTimeMediaSize % 3;
                    if (i17 == 0) {
                        i17 = 3;
                    }
                    int i18 = curTimeMediaSize - i17;
                    if (mediaPos < i18) {
                        outRect.bottom = a.f53387j;
                        return;
                    } else {
                        if (mediaPos >= i18) {
                            outRect.bottom = ef.d.b(24);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            outRect.set(a.this.headMarginLeftRight, 0, a.this.headMarginLeftRight, ef.d.b(12));
        }
    }

    private final void h() {
        RecyclerView recyclerView = this.recyclerView;
        SafeGridLayoutManager safeGridLayoutManager = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        SafeGridLayoutManager safeGridLayoutManager2 = new SafeGridLayoutManager(recyclerView.getContext(), 3);
        this.gridLayoutManager = safeGridLayoutManager2;
        safeGridLayoutManager2.setSpanSizeLookup(new b());
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        SafeGridLayoutManager safeGridLayoutManager3 = this.gridLayoutManager;
        if (safeGridLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        } else {
            safeGridLayoutManager = safeGridLayoutManager3;
        }
        recyclerView2.setLayoutManager(safeGridLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cb.b i(int curPos) {
        com.qzone.reborn.base.h<cb.b> hVar = this.listAdapter;
        com.qzone.reborn.base.h<cb.b> hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            hVar = null;
        }
        if (hVar.getItems().size() == 0) {
            return null;
        }
        while (-1 < curPos) {
            com.qzone.reborn.base.h<cb.b> hVar3 = this.listAdapter;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                hVar3 = null;
            }
            if (hVar3.getItems().get(curPos).getItemType() == 1) {
                com.qzone.reborn.base.h<cb.b> hVar4 = this.listAdapter;
                if (hVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                } else {
                    hVar2 = hVar4;
                }
                return hVar2.getItems().get(curPos);
            }
            curPos--;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(int pos) {
        com.qzone.reborn.base.h<cb.b> hVar = this.listAdapter;
        com.qzone.reborn.base.h<cb.b> hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            hVar = null;
        }
        if (pos >= hVar.getNUM_BACKGOURND_ICON() || pos < 0) {
            return false;
        }
        com.qzone.reborn.base.h<cb.b> hVar3 = this.listAdapter;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        } else {
            hVar2 = hVar3;
        }
        return hVar2.getItems().get(pos).getItemType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(int pos) {
        com.qzone.reborn.base.h<cb.b> hVar = this.listAdapter;
        com.qzone.reborn.base.h<cb.b> hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            hVar = null;
        }
        if (pos >= hVar.getNUM_BACKGOURND_ICON()) {
            return false;
        }
        com.qzone.reborn.base.h<cb.b> hVar3 = this.listAdapter;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        } else {
            hVar2 = hVar3;
        }
        cb.b bVar = hVar2.getItems().get(pos);
        return bVar.getItemType() == 2 || bVar.getItemType() == 3;
    }

    public final void j(MutableLiveData<cb.b> mutableData) {
        Intrinsics.checkNotNullParameter(mutableData, "mutableData");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(new c(objectRef, mutableData));
    }

    public final boolean l(int pos) {
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter = null;
        }
        return pos == rFWConcatAdapter.getNUM_BACKGOURND_ICON() - 1;
    }

    public final void n(RecyclerView recyclerView, RFWConcatAdapter concatAdapter, com.qzone.reborn.base.h<cb.b> listAdapter, sa.e loadMoreAdapter) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(concatAdapter, "concatAdapter");
        Intrinsics.checkNotNullParameter(listAdapter, "listAdapter");
        Intrinsics.checkNotNullParameter(loadMoreAdapter, "loadMoreAdapter");
        this.recyclerView = recyclerView;
        this.concatAdapter = concatAdapter;
        this.listAdapter = listAdapter;
        this.loadMoreAdapter = loadMoreAdapter;
        int m3 = com.qzone.reborn.configx.g.f53821a.d().m();
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(1, m3);
        recyclerView.setRecycledViewPool(recycledViewPool);
        loadMoreAdapter.setLoadMoreStrategy(new aa.a());
        h();
    }

    public final void o() {
        if (this.isItemDecorationSetup) {
            return;
        }
        this.isItemDecorationSetup = true;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.addItemDecoration(new d());
    }

    public final void p(MutableLiveData<cb.b> mutableData) {
        Intrinsics.checkNotNullParameter(mutableData, "mutableData");
        SafeGridLayoutManager safeGridLayoutManager = this.gridLayoutManager;
        com.qzone.reborn.base.h<cb.b> hVar = null;
        if (safeGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            safeGridLayoutManager = null;
        }
        int findFirstVisibleItemPosition = safeGridLayoutManager.findFirstVisibleItemPosition();
        if (k(findFirstVisibleItemPosition) && findFirstVisibleItemPosition == 0) {
            com.qzone.reborn.base.h<cb.b> hVar2 = this.listAdapter;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            } else {
                hVar = hVar2;
            }
            mutableData.postValue(hVar.getItems().get(findFirstVisibleItemPosition));
        }
    }
}
