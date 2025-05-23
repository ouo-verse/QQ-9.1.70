package com.tencent.biz.subscribe.part.block;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends PullLoadMoreAdapter<MultiViewBlock> implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d0, reason: collision with root package name */
    private static boolean f96162d0 = false;
    private BlockContainer T;
    private RecyclerView.ViewHolder V;
    private BlockPart Z;
    private SparseIntArray U = new SparseIntArray();
    private final ConcurrentHashMap<String, d> W = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<e> X = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<String, MultiViewBlock> Y = new ConcurrentHashMap<>();

    /* renamed from: a0, reason: collision with root package name */
    private int f96163a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private int f96164b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f96165c0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.part.block.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0968a extends GridLayoutManager.SpanSizeLookup {
        C0968a() {
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            int z16 = a.this.z(i3);
            MultiViewBlock Y = a.this.Y(z16);
            if (Y != null) {
                return Y.N(Y.I(z16));
            }
            return ((GridLayoutManager) ((PullLoadMoreAdapter) a.this).R).getSpanCount();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a aVar = a.this;
            aVar.e0(aVar.E());
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void r2(String str, d dVar);
    }

    public a(BlockContainer blockContainer) {
        this.T = blockContainer;
        setHasStableIds(true);
    }

    private boolean W() {
        int i3 = this.f96163a0;
        if (i3 != 0 && i3 >= this.f96164b0) {
            return true;
        }
        return false;
    }

    private void X(RecyclerView.ViewHolder viewHolder, MultiViewBlock multiViewBlock, ViewGroup.LayoutParams layoutParams) {
        if (viewHolder != null && multiViewBlock != null && multiViewBlock.N(viewHolder.getLayoutPosition() - multiViewBlock.L()) == 1) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(boolean z16) {
        if (this.f96195d.size() == 0) {
            QLog.i("CMADebugTAG", 1, "isNeedTryToLoadMore mDataList.size() == 0" + hashCode());
            return;
        }
        ArrayList<E> arrayList = this.f96195d;
        MultiViewBlock multiViewBlock = (MultiViewBlock) arrayList.get(arrayList.size() - 1);
        if (multiViewBlock == null) {
            QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore adapter == null" + hashCode());
            return;
        }
        if (multiViewBlock.H().h()) {
            QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore is loading:" + hashCode());
            return;
        }
        if (this.f96164b0 == 0) {
            QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore maxCount 0 hashCode:" + hashCode());
            return;
        }
        int a16 = xe0.a.a(this.P);
        if (a16 == -1) {
            QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore not renderReady hashCode:" + hashCode());
            return;
        }
        if (a16 < multiViewBlock.getItemCount() - 1) {
            QLog.i("CMADebugTAG", 2, "isNeedTryToLoadMore enough to scroll hashCode:" + hashCode());
            return;
        }
        if (W()) {
            return;
        }
        if (this.P != null && !z16) {
            this.f96163a0++;
            O();
            QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", Integer.valueOf(hashCode())));
        } else {
            this.f96163a0 = 0;
            QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", Integer.valueOf(hashCode())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(MultiViewBlock multiViewBlock, int i3) {
        Iterator it = this.f96195d.iterator();
        while (it.hasNext()) {
            ((MultiViewBlock) it.next()).Q(multiViewBlock, i3);
        }
    }

    private void g0(String str, d dVar) {
        if (this.X.size() > 0) {
            Iterator<e> it = this.X.iterator();
            while (it.hasNext()) {
                it.next().r2(str, dVar);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter
    protected void G(RecyclerView.ViewHolder viewHolder, int i3) {
        int size = this.f96195d.size();
        for (int i16 = 0; i16 < size; i16++) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) this.f96195d.get(i16);
            int itemCount = multiViewBlock.getItemCount();
            if (i3 < itemCount) {
                multiViewBlock.onBindViewHolder(viewHolder, i3);
                return;
            }
            i3 = Math.max(i3 - itemCount, 0);
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter
    public void O() {
        MultiViewBlock multiViewBlock = (MultiViewBlock) this.f96195d.get(r0.size() - 1);
        if (!a0().k() || multiViewBlock.H().h()) {
            return;
        }
        if (multiViewBlock.H().e()) {
            multiViewBlock.H().l(4);
        } else if (this.f96195d.size() > 0) {
            J();
            multiViewBlock.H().l(3);
            multiViewBlock.V(multiViewBlock.H());
        }
    }

    public int V(ArrayList<MultiViewBlock> arrayList) {
        int i3;
        try {
            int size = arrayList.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                if (ArrayUtils.isOutOfArrayIndex(i17, arrayList)) {
                    return i16;
                }
                MultiViewBlock multiViewBlock = arrayList.get(i17);
                if (multiViewBlock != null) {
                    if (D()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    multiViewBlock.d0(i3 + i16);
                    i16 += multiViewBlock.getItemCount();
                    if (f96162d0) {
                        Log.d("CMADebugTAG|" + multiViewBlock.getClass().getSimpleName(), "size:" + multiViewBlock.getItemCount());
                    }
                }
            }
            return i16;
        } catch (Exception unused) {
            return 0;
        }
    }

    public MultiViewBlock Y(int i3) {
        if (i3 < b0()) {
            int size = this.f96195d.size();
            for (int i16 = 0; i16 < size; i16++) {
                MultiViewBlock multiViewBlock = (MultiViewBlock) this.f96195d.get(i16);
                int itemCount = multiViewBlock.getItemCount();
                if (i3 < itemCount) {
                    return multiViewBlock;
                }
                i3 = Math.max(i3 - itemCount, 0);
            }
            return null;
        }
        return null;
    }

    public MultiViewBlock Z(String str) {
        return this.Y.get(str);
    }

    public BlockContainer a0() {
        return this.T;
    }

    public int b0() {
        return V(this.f96195d);
    }

    public d c0(String str) {
        return this.W.get(str);
    }

    public GridLayoutManager.SpanSizeLookup d0() {
        return new C0968a();
    }

    public void destroy() {
        this.T = null;
        this.W.clear();
        this.Y.clear();
        this.Z = null;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return b0() + y();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (D() && i3 == 0) {
            return -10000;
        }
        int z16 = z(i3);
        if (z16 < b0()) {
            int size = this.f96195d.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                MultiViewBlock multiViewBlock = (MultiViewBlock) this.f96195d.get(i17);
                int itemCount = multiViewBlock.getItemCount();
                if (z16 < itemCount) {
                    int itemViewType = multiViewBlock.getItemViewType(z16);
                    if (f96162d0) {
                        Log.d("CMADebugTAG|" + multiViewBlock.getClass().getSimpleName(), "getItemViewType ViewType:" + itemViewType);
                    }
                    if (itemViewType >= 0) {
                        itemViewType += i16;
                    }
                    multiViewBlock.g0(i16);
                    this.U.put(itemViewType, i17);
                    return itemViewType;
                }
                z16 = Math.max(z16 - itemCount, 0);
                if (multiViewBlock.P() != 0) {
                    i16 += multiViewBlock.P();
                } else {
                    throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
                }
            }
            return -1;
        }
        return -99999;
    }

    public boolean i0() {
        Iterator it = this.f96195d.iterator();
        while (it.hasNext()) {
            if (((MultiViewBlock) it.next()).X()) {
                return true;
            }
        }
        return false;
    }

    public void j0() {
        Iterator it = this.f96195d.iterator();
        while (it.hasNext()) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) it.next();
            if (!multiViewBlock.T()) {
                multiViewBlock.Z();
            }
        }
    }

    public void k0(MultiViewBlock multiViewBlock) {
        l0(multiViewBlock, -1);
    }

    public void l0(MultiViewBlock multiViewBlock, int i3) {
        if (multiViewBlock != null && !this.f96195d.contains(multiViewBlock)) {
            if (i3 == -1) {
                i3 = this.f96195d.size();
            }
            if (multiViewBlock.O() != null) {
                this.Y.put(multiViewBlock.O(), multiViewBlock);
            }
            this.f96195d.add(i3, multiViewBlock);
            multiViewBlock.c0(this);
            multiViewBlock.onAttachedToRecyclerView(a0().g());
            f0(multiViewBlock, 1);
            m0(multiViewBlock);
        }
    }

    public void m0(e eVar) {
        this.X.add(eVar);
        for (String str : this.W.keySet()) {
            eVar.r2(str, this.W.get(str));
        }
    }

    public void n0(BlockPart blockPart) {
        this.Z = blockPart;
    }

    public void o0(String str, d dVar) {
        if (dVar == null) {
            QLog.w(getClass().getSimpleName(), 1, "setShareData null");
        } else {
            this.W.put(str, dVar);
            g0(str, dVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        for (int i3 = 0; i3 < this.f96195d.size(); i3++) {
            ((MultiViewBlock) this.f96195d.get(i3)).onActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        for (int i3 = 0; i3 < this.f96195d.size(); i3++) {
            ((MultiViewBlock) this.f96195d.get(i3)).onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        for (int i3 = 0; i3 < this.f96195d.size(); i3++) {
            ((MultiViewBlock) this.f96195d.get(i3)).onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        for (int i3 = 0; i3 < this.f96195d.size(); i3++) {
            ((MultiViewBlock) this.f96195d.get(i3)).onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        for (int i3 = 0; i3 < this.f96195d.size(); i3++) {
            ((MultiViewBlock) this.f96195d.get(i3)).onActivityStopped(activity);
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        int size = this.f96195d.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((MultiViewBlock) this.f96195d.get(i3)).onDetachedFromRecyclerView(recyclerView);
        }
        recyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f96165c0);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter, com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.c
    public void onRefresh() {
        super.onRefresh();
        if (this.f96195d.size() > 0) {
            a0().setRefreshing(true);
        }
        for (int i3 = 0; i3 < this.f96195d.size(); i3++) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) this.f96195d.get(i3);
            if (multiViewBlock.R()) {
                multiViewBlock.b0();
            }
        }
        this.f96163a0 = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        boolean z16 = layoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
        if (z16 && ((viewHolder instanceof PullLoadMoreAdapter.b) || (viewHolder instanceof PullLoadMoreAdapter.c))) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            return;
        }
        int z17 = z(viewHolder.getAdapterPosition());
        if (z17 < 0) {
            return;
        }
        int size = this.f96195d.size();
        for (int i3 = 0; i3 < size; i3++) {
            MultiViewBlock multiViewBlock = (MultiViewBlock) this.f96195d.get(i3);
            int itemCount = multiViewBlock.getItemCount();
            if (z17 < itemCount) {
                if (z16) {
                    X(viewHolder, multiViewBlock, layoutParams);
                }
                multiViewBlock.onViewAttachedToWindow(viewHolder);
                return;
            }
            z17 = Math.max(z17 - itemCount, 0);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        int z16 = z(viewHolder.getAdapterPosition());
        if (z16 < 0) {
            return;
        }
        int size = this.f96195d.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.biz.subscribe.part.block.base.a aVar = (com.tencent.biz.subscribe.part.block.base.a) this.f96195d.get(i3);
            int itemCount = aVar.getItemCount();
            if (z16 < itemCount) {
                aVar.onViewDetachedFromWindow(viewHolder);
                return;
            }
            z16 = Math.max(z16 - itemCount, 0);
        }
    }

    public void p0(int i3) {
        this.f96164b0 = i3;
        RecyclerView recyclerView = this.P;
        if (recyclerView != null) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.f96165c0);
        }
    }

    public void q0(e eVar) {
        this.X.remove(eVar);
    }

    @Override // com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter
    protected RecyclerView.ViewHolder v(ViewGroup viewGroup, int i3) {
        if (this.f96195d.size() == 0) {
            if (this.V == null) {
                this.V = new c(new View(viewGroup.getContext()));
            }
            return this.V;
        }
        if (i3 == -99999) {
            return super.onCreateViewHolder(viewGroup, i3);
        }
        int i16 = this.U.get(i3);
        if (i16 != 0) {
            int i17 = 0;
            for (int i18 = 0; i18 < i16; i18++) {
                i17 += ((MultiViewBlock) this.f96195d.get(i18)).P();
            }
            i3 -= i17;
        }
        if (f96162d0) {
            Log.d("CMADebugTAG|" + ((MultiViewBlock) this.f96195d.get(i16)).getClass().getSimpleName(), "createItemViewHolder ViewType:" + i3);
        }
        return ((MultiViewBlock) this.f96195d.get(i16)).onCreateViewHolder(viewGroup, i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public Object f96169a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f96170b;

        public d(Object obj) {
            this.f96169a = obj;
        }

        public d(Object obj, boolean z16) {
            this.f96169a = obj;
            this.f96170b = z16;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
