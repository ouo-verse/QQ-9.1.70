package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RecyclerViewWithHeaderFooter extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private final List<View> f236129f;

    /* renamed from: h, reason: collision with root package name */
    private final List<View> f236130h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        private final c f236131a;

        /* renamed from: b, reason: collision with root package name */
        private final GridLayoutManager f236132b;

        /* renamed from: c, reason: collision with root package name */
        private GridLayoutManager.SpanSizeLookup f236133c;

        public a(c cVar, GridLayoutManager gridLayoutManager) {
            this.f236131a = cVar;
            this.f236132b = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            boolean z16;
            if (!this.f236131a.isHeaderPosition(i3) && !this.f236131a.isFooterPosition(i3)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return this.f236132b.getSpanCount();
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f236133c;
            if (spanSizeLookup == null) {
                return 1;
            }
            return spanSizeLookup.getSpanSize(i3 - this.f236131a.getHeaderCount());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c<T extends RecyclerView.Adapter> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<View> C;
        private final List<View> D;

        /* renamed from: m, reason: collision with root package name */
        private final T f236134m;

        /* compiled from: P */
        /* loaded from: classes14.dex */
        public static class b extends RecyclerView.ViewHolder {
            public b(@NonNull View view) {
                super(view);
            }
        }

        public c(T t16) {
            this(t16, null);
        }

        private void m0(View view) {
            if (AppSetting.isPublicVersion() && !AppSetting.isGrayVersion()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RecyclerView.LayoutParams) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                try {
                    Field declaredField = RecyclerView.LayoutParams.class.getDeclaredField("mViewHolder");
                    declaredField.setAccessible(true);
                    QLog.d("RecyclerViewWithHeaderFooter", 1, "headerView's ViewHolder" + declaredField.get(layoutParams2));
                } catch (IllegalAccessException | NoSuchFieldException e16) {
                    QLog.e("RecyclerViewWithHeaderFooter", 1, "printViewHolder exception", e16);
                }
            }
        }

        public int getHeaderCount() {
            return this.C.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.C.size() + this.f236134m.getItemCount() + this.D.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            if (i3 < this.C.size()) {
                return this.C.get(i3).hashCode();
            }
            if (i3 < this.C.size() + this.f236134m.getItemCount()) {
                return this.f236134m.getItemId(i3 - this.C.size());
            }
            return this.D.get((i3 - this.C.size()) - this.f236134m.getItemCount()).hashCode();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (i3 < this.C.size()) {
                return i3 - 1000;
            }
            if (i3 < this.C.size() + this.f236134m.getItemCount()) {
                return this.f236134m.getItemViewType(i3 - this.C.size());
            }
            return ((i3 - 2000) - this.C.size()) - this.f236134m.getItemCount();
        }

        public boolean isFooterPosition(int i3) {
            if (i3 >= getItemCount() - this.D.size()) {
                return true;
            }
            return false;
        }

        public boolean isHeaderPosition(int i3) {
            if (i3 < this.C.size()) {
                return true;
            }
            return false;
        }

        public void k0(@NonNull View view) {
            this.D.add(view);
        }

        public void l0(@NonNull View view) {
            this.C.add(view);
        }

        public boolean n0(int i3) {
            if (i3 >= -2000 && i3 < this.D.size() - 2000) {
                return true;
            }
            return false;
        }

        public boolean o0(int i3) {
            if (i3 >= -1000 && i3 < this.C.size() - 1000) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list) {
            if (i3 >= this.C.size() && i3 < this.C.size() + this.f236134m.getItemCount()) {
                this.f236134m.onBindViewHolder(viewHolder, i3 - this.C.size(), list);
            } else {
                super.onBindViewHolder(viewHolder, i3, list);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (o0(i3)) {
                View view = this.C.get(Math.abs(i3 + 1000));
                m0(view);
                return new b(view);
            }
            if (n0(i3)) {
                View view2 = this.D.get(Math.abs(i3 + 2000));
                m0(view2);
                return new b(view2);
            }
            return this.f236134m.onCreateViewHolder(viewGroup, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            T t16 = this.f236134m;
            if (t16 != null && !(viewHolder instanceof b)) {
                t16.onViewAttachedToWindow(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
            T t16 = this.f236134m;
            if (t16 != null && !(viewHolder instanceof b)) {
                t16.onViewDetachedFromWindow(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            super.onViewRecycled(viewHolder);
            T t16 = this.f236134m;
            if (t16 != null && !(viewHolder instanceof b)) {
                t16.onViewRecycled(viewHolder);
            }
        }

        public c(T t16, @Nullable WeakReference<RecyclerView> weakReference) {
            this.C = new ArrayList();
            this.D = new ArrayList();
            this.f236134m = t16;
            t16.registerAdapterDataObserver(new a(weakReference));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            if (i3 >= this.C.size() && i3 < this.C.size() + this.f236134m.getItemCount()) {
                this.f236134m.onBindViewHolder(viewHolder, i3 - this.C.size());
                return;
            }
            StaggeredGridLayoutManager.LayoutParams layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams() : null;
            if (layoutParams == null) {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                viewHolder.itemView.setLayoutParams(layoutParams);
            }
            layoutParams.setFullSpan(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes14.dex */
        public class a extends RecyclerView.AdapterDataObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f236135d;

            a(WeakReference weakReference) {
                this.f236135d = weakReference;
            }

            private boolean g() {
                WeakReference weakReference = this.f236135d;
                if (weakReference != null && weakReference.get() != null && ((RecyclerView) this.f236135d.get()).isComputingLayout()) {
                    QLog.i("RecyclerViewWithHeaderFooter", 1, "notifyDatasetChanged hit isComputingLayout");
                    return true;
                }
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void h() {
                c.this.notifyDataSetChanged();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void i(int i3, int i16) {
                c cVar = c.this;
                cVar.notifyItemRangeChanged(i3 + cVar.C.size(), i16);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void j(int i3, int i16, Object obj) {
                c cVar = c.this;
                cVar.notifyItemRangeChanged(i3 + cVar.C.size(), i16, obj);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void k(int i3, int i16) {
                c cVar = c.this;
                cVar.notifyItemRangeInserted(i3 + cVar.C.size(), i16);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void l(int i3, int i16) {
                c cVar = c.this;
                cVar.notifyItemMoved(i3 + cVar.C.size(), i16 + c.this.C.size());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void m(int i3, int i16) {
                c cVar = c.this;
                cVar.notifyItemRangeRemoved(i3 + cVar.C.size(), i16);
            }

            private void n(Runnable runnable) {
                WeakReference weakReference = this.f236135d;
                if (weakReference != null && weakReference.get() != null) {
                    ((RecyclerView) this.f236135d.get()).post(runnable);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                try {
                    if (g()) {
                        n(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.aa
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewWithHeaderFooter.c.a.this.h();
                            }
                        });
                    } else {
                        c.this.notifyDataSetChanged();
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.guild.util.s.f("RecyclerViewWithHeaderFooter", "Exception adapter: " + c.this.f236134m, e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(final int i3, final int i16) {
                try {
                    if (g()) {
                        n(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.ad
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewWithHeaderFooter.c.a.this.i(i3, i16);
                            }
                        });
                    } else {
                        c cVar = c.this;
                        cVar.notifyItemRangeChanged(i3 + cVar.C.size(), i16);
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.guild.util.s.f("RecyclerViewWithHeaderFooter", "Exception adapter: " + c.this.f236134m, e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(final int i3, final int i16) {
                try {
                    if (g()) {
                        n(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.z
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewWithHeaderFooter.c.a.this.k(i3, i16);
                            }
                        });
                    } else {
                        c cVar = c.this;
                        cVar.notifyItemRangeInserted(i3 + cVar.C.size(), i16);
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.guild.util.s.f("RecyclerViewWithHeaderFooter", "Exception adapter: " + c.this.f236134m, e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(final int i3, final int i16, int i17) {
                try {
                    if (g()) {
                        n(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.ab
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewWithHeaderFooter.c.a.this.l(i3, i16);
                            }
                        });
                    } else {
                        c cVar = c.this;
                        cVar.notifyItemMoved(i3 + cVar.C.size(), i16 + c.this.C.size());
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.guild.util.s.f("RecyclerViewWithHeaderFooter", "Exception adapter: " + c.this.f236134m, e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(final int i3, final int i16) {
                try {
                    if (g()) {
                        n(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.ac
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewWithHeaderFooter.c.a.this.m(i3, i16);
                            }
                        });
                    } else {
                        c cVar = c.this;
                        cVar.notifyItemRangeRemoved(i3 + cVar.C.size(), i16);
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.guild.util.s.f("RecyclerViewWithHeaderFooter", "Exception adapter: " + c.this.f236134m, e16);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(final int i3, final int i16, final Object obj) {
                try {
                    if (g()) {
                        n(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.ae
                            @Override // java.lang.Runnable
                            public final void run() {
                                RecyclerViewWithHeaderFooter.c.a.this.j(i3, i16, obj);
                            }
                        });
                    } else {
                        c cVar = c.this;
                        cVar.notifyItemRangeChanged(i3 + cVar.C.size(), i16, obj);
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.guild.util.s.f("RecyclerViewWithHeaderFooter", "Exception adapter: " + c.this.f236134m, e16);
                }
            }
        }
    }

    public RecyclerViewWithHeaderFooter(Context context) {
        super(context);
        this.f236129f = new ArrayList();
        this.f236130h = new ArrayList();
    }

    public void C(View view) {
        this.f236130h.add(view);
    }

    public void D(View view) {
        this.f236129f.add(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (this.f236129f.size() > 0 || this.f236130h.size() > 0) {
            c cVar = new c(adapter);
            Iterator<View> it = this.f236129f.iterator();
            while (it.hasNext()) {
                cVar.l0(it.next());
            }
            Iterator<View> it5 = this.f236130h.iterator();
            while (it5.hasNext()) {
                cVar.k0(it5.next());
            }
            cVar.setHasStableIds(adapter.hasStableIds());
            if (getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                gridLayoutManager.setSpanSizeLookup(new a(cVar, gridLayoutManager));
            }
            adapter = cVar;
        }
        super.setAdapter(adapter);
    }

    public RecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236129f = new ArrayList();
        this.f236130h = new ArrayList();
    }

    public RecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236129f = new ArrayList();
        this.f236130h = new ArrayList();
    }

    public void setOnSizeChangeListener(b bVar) {
    }
}
