package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter;
import com.tencent.aelight.camera.ae.camera.ui.bottom.a;
import com.tencent.aelight.camera.ae.camera.ui.bottom.d;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEBottomListScrollView extends RecyclerView {

    /* renamed from: m, reason: collision with root package name */
    private static final String f62527m = "AEBottomListScrollView";

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.bottom.a f62528d;

    /* renamed from: e, reason: collision with root package name */
    private d f62529e;

    /* renamed from: f, reason: collision with root package name */
    private c f62530f;

    /* renamed from: h, reason: collision with root package name */
    private a f62531h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f62532i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class ScrollStateListener implements a.c {
        ScrollStateListener() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.a.c
        public void a(float f16) {
            int l3;
            int n3;
            if (AEBottomListScrollView.this.f62529e == null || (l3 = AEBottomListScrollView.this.l()) == (n3 = AEBottomListScrollView.this.f62528d.n())) {
                return;
            }
            AEBottomListScrollView aEBottomListScrollView = AEBottomListScrollView.this;
            aEBottomListScrollView.q(f16, l3, n3, aEBottomListScrollView.m(l3), AEBottomListScrollView.this.m(n3));
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.a.c
        public void b() {
            AEBottomListScrollView.this.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.ScrollStateListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.a(AEBottomListScrollView.f62527m, "onCurrentViewFirstLayout--");
                    AEBottomListScrollView.this.o();
                }
            });
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.a.c
        public void c() {
            AEBottomListScrollView.this.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.ScrollStateListener.2
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.a(AEBottomListScrollView.f62527m, "onDataSetChangeChangedPosition--");
                    AEBottomListScrollView.this.o();
                }
            });
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.a.c
        public void onScrollEnd() {
            int j3;
            RecyclerView.ViewHolder m3;
            if ((AEBottomListScrollView.this.f62530f == null && AEBottomListScrollView.this.f62529e == null) || (m3 = AEBottomListScrollView.this.m((j3 = AEBottomListScrollView.this.f62528d.j()))) == null) {
                return;
            }
            AEBottomListScrollView.this.r(m3, j3);
            AEBottomListScrollView.this.p(m3, j3);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.bottom.a.c
        public void onScrollStart() {
            int j3;
            RecyclerView.ViewHolder m3;
            if (AEBottomListScrollView.this.f62529e == null || (m3 = AEBottomListScrollView.this.m((j3 = AEBottomListScrollView.this.f62528d.j()))) == null) {
                return;
            }
            AEBottomListScrollView.this.s(m3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void f(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void h();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c<T extends RecyclerView.ViewHolder> {
        void c(T t16, boolean z16);

        void g(T t16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d<T extends RecyclerView.ViewHolder> {
        void j(T t16, int i3);

        void k(float f16, int i3, int i16, T t16, T t17);

        void l(T t16, int i3);
    }

    public AEBottomListScrollView(Context context) {
        super(context);
        n(null);
    }

    private void n(AttributeSet attributeSet) {
        this.f62532i = getOverScrollMode() != 2;
        com.tencent.aelight.camera.ae.camera.ui.bottom.a aVar = new com.tencent.aelight.camera.ae.camera.ui.bottom.a(getContext(), new ScrollStateListener(), new d.b());
        this.f62528d = aVar;
        setLayoutManager(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f62530f == null) {
            return;
        }
        int j3 = this.f62528d.j();
        p(m(j3), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(RecyclerView.ViewHolder viewHolder, int i3) {
        c cVar = this.f62530f;
        if (cVar != null) {
            cVar.g(viewHolder, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(float f16, int i3, int i16, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        d dVar = this.f62529e;
        if (dVar != null) {
            dVar.k(f16, i3, i16, viewHolder, viewHolder2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(RecyclerView.ViewHolder viewHolder, int i3) {
        c cVar = this.f62530f;
        if (cVar != null) {
            cVar.c(viewHolder, true);
        }
        d dVar = this.f62529e;
        if (dVar != null) {
            dVar.l(viewHolder, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(RecyclerView.ViewHolder viewHolder, int i3) {
        d dVar = this.f62529e;
        if (dVar != null) {
            dVar.j(viewHolder, i3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        boolean fling = super.fling(i3, i16);
        if (fling) {
            this.f62528d.w(i3, i16);
        } else {
            this.f62528d.B();
        }
        return fling;
    }

    public int l() {
        return this.f62528d.j();
    }

    public RecyclerView.ViewHolder m(int i3) {
        View findViewByPosition = this.f62528d.findViewByPosition(i3);
        if (findViewByPosition != null) {
            return getChildViewHolder(findViewByPosition);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f62528d.x(null);
    }

    public void setAEEditMaterialSelectedListener(a aVar) {
        this.f62531h = aVar;
    }

    public void setItemTransformer(lf0.c cVar) {
        this.f62528d.D(cVar);
    }

    public void setItemTransitionTimeMillis(int i3) {
        this.f62528d.J(i3);
    }

    public void setLayoutCallback(b bVar) {
        com.tencent.aelight.camera.ae.camera.ui.bottom.a aVar = this.f62528d;
        if (aVar != null) {
            aVar.E(bVar);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof com.tencent.aelight.camera.ae.camera.ui.bottom.a) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException("please use special on ");
    }

    public void setOffscreenItems(int i3) {
        this.f62528d.F(i3);
    }

    public void setOnItemChangedListener(c<?> cVar) {
        this.f62530f = cVar;
    }

    public void setOrientation(com.tencent.aelight.camera.ae.camera.ui.bottom.d dVar) {
        this.f62528d.G(dVar);
    }

    public void setOverScrollEnabled(boolean z16) {
        this.f62532i = z16;
        setOverScrollMode(2);
    }

    public void setScrollStateChangeListener(d<?> dVar) {
        this.f62529e = dVar;
    }

    public void setSlideOnFling(boolean z16) {
        this.f62528d.H(z16);
    }

    public void setSlideOnFlingThreshold(int i3) {
        this.f62528d.I(i3);
    }

    public void t(int i3, AEMaterialMetaData aEMaterialMetaData) {
        AEBottomListAdapter.b bVar = (AEBottomListAdapter.b) m(this.f62528d.j());
        if (bVar != null) {
            bVar.d(4);
        }
        AEBottomListAdapter.b bVar2 = (AEBottomListAdapter.b) m(i3);
        if (bVar2 != null) {
            bVar2.c(aEMaterialMetaData);
            bVar2.d(3);
            if (aEMaterialMetaData != null && aEMaterialMetaData.usable) {
                bVar2.d(2);
            }
            if (this.f62531h != null) {
                AEMaterialMetaData aEMaterialMetaData2 = bVar2.f62489d;
                if (aEMaterialMetaData2 != null && !"0".equals(aEMaterialMetaData2.f69050id) && bVar2.f62489d.editablewatermark) {
                    this.f62531h.f(true);
                } else {
                    this.f62531h.f(false);
                }
            }
            scrollToPosition(i3);
        }
    }

    public AEBottomListScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(attributeSet);
    }

    public void setClampTransformProgressAfter(int i3) {
        if (i3 > 1) {
            this.f62528d.K(i3);
            return;
        }
        throw new IllegalArgumentException("must be >= 1");
    }

    public AEBottomListScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        n(attributeSet);
    }
}
