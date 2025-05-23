package fh0;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.skeleton.SkeletonScreen;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements SkeletonScreen {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView f398668a;

    /* renamed from: b, reason: collision with root package name */
    private final RecyclerView.Adapter f398669b;

    /* renamed from: c, reason: collision with root package name */
    private final d f398670c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f398671d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f398672e;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView.Adapter f398673a;

        /* renamed from: b, reason: collision with root package name */
        private final RecyclerView f398674b;

        /* renamed from: f, reason: collision with root package name */
        private int[] f398678f;

        /* renamed from: g, reason: collision with root package name */
        private int f398679g;

        /* renamed from: c, reason: collision with root package name */
        private boolean f398675c = true;

        /* renamed from: d, reason: collision with root package name */
        private int f398676d = 10;

        /* renamed from: e, reason: collision with root package name */
        private int f398677e = R.layout.crp;

        /* renamed from: h, reason: collision with root package name */
        private int f398680h = 1000;

        /* renamed from: i, reason: collision with root package name */
        private int f398681i = 20;

        /* renamed from: j, reason: collision with root package name */
        private boolean f398682j = true;

        public b(RecyclerView recyclerView) {
            this.f398674b = recyclerView;
            this.f398679g = ContextCompat.getColor(recyclerView.getContext(), R.color.f7103c);
        }

        public b k(RecyclerView.Adapter adapter) {
            this.f398673a = adapter;
            return this;
        }

        public b l(int i3) {
            this.f398681i = i3;
            return this;
        }

        public b m(int i3) {
            this.f398679g = ContextCompat.getColor(this.f398674b.getContext(), i3);
            return this;
        }

        public b n(int i3) {
            this.f398676d = i3;
            return this;
        }

        public b o(boolean z16) {
            this.f398682j = z16;
            return this;
        }

        public b p(int i3) {
            this.f398677e = i3;
            return this;
        }

        public b q(boolean z16) {
            this.f398675c = z16;
            return this;
        }

        public a r() {
            a aVar = new a(this);
            aVar.show();
            return aVar;
        }
    }

    @Override // com.tencent.ecommerce.base.ui.skeleton.SkeletonScreen
    public void hide() {
        if (this.f398672e) {
            this.f398672e = false;
            this.f398668a.setAdapter(this.f398669b);
        }
    }

    @Override // com.tencent.ecommerce.base.ui.skeleton.SkeletonScreen
    public void show() {
        if (this.f398672e) {
            return;
        }
        this.f398672e = true;
        this.f398668a.setAdapter(this.f398670c);
        if (this.f398668a.isComputingLayout() || !this.f398671d) {
            return;
        }
        this.f398668a.setLayoutFrozen(true);
    }

    a(b bVar) {
        this.f398672e = false;
        this.f398668a = bVar.f398674b;
        this.f398669b = bVar.f398673a;
        d dVar = new d();
        this.f398670c = dVar;
        dVar.l0(bVar.f398676d);
        dVar.m0(bVar.f398677e);
        dVar.k0(bVar.f398678f);
        dVar.q0(bVar.f398675c);
        dVar.o0(bVar.f398679g);
        dVar.n0(bVar.f398681i);
        dVar.p0(bVar.f398680h);
        this.f398671d = bVar.f398682j;
    }
}
