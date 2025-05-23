package com.tencent.biz.subscribe.part.block;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.part.block.base.b;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.BaseFragment;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class MultiViewBlock<E> extends com.tencent.biz.subscribe.part.block.base.a<E> implements a.e, Application.ActivityLifecycleCallbacks {
    private com.tencent.biz.subscribe.part.block.a C;
    private int E;
    private int F;
    protected boolean G;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f96141h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f96142i;

    /* renamed from: m, reason: collision with root package name */
    private a f96143m;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f96140f = new Handler(Looper.getMainLooper());
    private final b D = new b();
    private String H = String.valueOf(hashCode());
    private final RecyclerView.AdapterDataObserver I = new RecyclerView.AdapterDataObserver() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            MultiViewBlock.this.f96140f.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((Integer) VSConfigManager.c().e("KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL", 1)).intValue() == 1) {
                        MultiViewBlock.this.A().notifyItemRangeChanged(MultiViewBlock.this.E(0), MultiViewBlock.this.getItemCount());
                    } else {
                        MultiViewBlock.this.A().notifyDataSetChanged();
                    }
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(final int i3, final int i16) {
            MultiViewBlock.this.f96140f.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1.2
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.A().notifyItemRangeChanged(MultiViewBlock.this.E(i3), i16);
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(final int i3, final int i16) {
            MultiViewBlock.this.f96140f.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1.4
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.A().notifyItemRangeInserted(MultiViewBlock.this.E(i3), i16);
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(final int i3, final int i16, int i17) {
            MultiViewBlock.this.f96140f.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1.6
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.A().notifyItemMoved(MultiViewBlock.this.E(i3), MultiViewBlock.this.E(i16));
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(final int i3, final int i16) {
            MultiViewBlock.this.f96140f.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1.5
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.A().notifyItemRangeRemoved(MultiViewBlock.this.E(i3), i16);
                    MultiViewBlock.this.A().notifyItemRangeChanged(MultiViewBlock.this.E(i3), MultiViewBlock.this.A().getItemCount() - MultiViewBlock.this.E(i3));
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(final int i3, final int i16, final Object obj) {
            MultiViewBlock.this.f96140f.post(new Runnable() { // from class: com.tencent.biz.subscribe.part.block.MultiViewBlock.1.3
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.A().notifyItemRangeChanged(MultiViewBlock.this.E(i3), i16, obj);
                }
            });
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a<T> {
        void a(b bVar, T t16);
    }

    public MultiViewBlock(Bundle bundle) {
        this.f96141h = bundle;
        setHasStableIds(true);
    }

    private void w(b bVar) {
        a aVar = this.f96143m;
        if (aVar != null) {
            aVar.a(bVar, this);
        } else {
            U(bVar);
        }
    }

    public com.tencent.biz.subscribe.part.block.a A() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout B(@Nullable View view) {
        FrameLayout frameLayout = new FrameLayout(C());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (view != null) {
            frameLayout.addView(view);
        }
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context C() {
        return y();
    }

    public ExtraTypeInfo D() {
        if (z() != null) {
            return z().d();
        }
        return null;
    }

    public int E(int i3) {
        return this.E + i3;
    }

    public Bundle F() {
        return this.f96141h;
    }

    public b H() {
        return this.D;
    }

    public int I(int i3) {
        return i3 - this.E;
    }

    public BaseFragment J() {
        if (z() != null) {
            return z().e();
        }
        return null;
    }

    public NestScrollRecyclerView K() {
        if (z() != null) {
            return z().g();
        }
        return null;
    }

    public int L() {
        return this.E;
    }

    public a.d M(String str) {
        com.tencent.biz.subscribe.part.block.a aVar = this.C;
        if (aVar != null) {
            return aVar.c0(str);
        }
        return null;
    }

    public int N(int i3) {
        return 1;
    }

    public String O() {
        return this.H;
    }

    public abstract int P();

    public boolean R() {
        return true;
    }

    public boolean S() {
        if (A() == null || r().size() <= 0 || A().r().get(A().r().size() - 1) != this) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean T() {
        return false;
    }

    public abstract void U(b bVar);

    public void V(b bVar) {
        a aVar = this.f96143m;
        if (aVar != null) {
            aVar.a(bVar, this);
        } else {
            w(bVar);
        }
    }

    public void W(boolean z16) {
        if (z() != null && A() != null) {
            H().l(4);
            z().setRefreshing(false);
            if (S()) {
                A().I(z16, H().e());
            }
        }
    }

    public boolean X() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        if (!this.f96142i) {
            a0(F());
            this.D.l(1);
            w(this.D);
            this.f96142i = true;
        }
    }

    public abstract void a0(Bundle bundle);

    public void b0() {
        this.D.l(2);
        this.D.k(null);
        a aVar = this.f96143m;
        if (aVar != null) {
            aVar.a(this.D, this);
        } else {
            w(this.D);
        }
    }

    public void c0(com.tencent.biz.subscribe.part.block.a aVar) {
        this.C = aVar;
    }

    public void d0(int i3) {
        this.E = i3;
    }

    public void e0(a aVar) {
        this.f96143m = aVar;
    }

    public void f0(String str, a.d dVar) {
        com.tencent.biz.subscribe.part.block.a aVar = this.C;
        if (aVar != null) {
            aVar.o0(str, dVar);
        }
    }

    public void g0(int i3) {
        this.F = i3;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public abstract int getItemCount();

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (!hasObservers()) {
            registerAdapterDataObserver(this.I);
        }
        this.G = false;
    }

    @Override // com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.G = true;
        if (hasObservers()) {
            unregisterAdapterDataObserver(this.I);
        }
        this.f96140f.removeCallbacksAndMessages(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (T()) {
            Z();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.base.a
    public Handler s() {
        return this.f96140f;
    }

    public void x(View view) {
        if (z() != null) {
            z().addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity y() {
        if (z() != null && z().e() != null) {
            return z().e().getBaseActivity();
        }
        return null;
    }

    public BlockContainer z() {
        if (A() != null) {
            return A().a0();
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(MultiViewBlock multiViewBlock, int i3) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void r2(String str, a.d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(Canvas canvas, RecyclerView recyclerView, View view, RecyclerView.State state) {
    }
}
