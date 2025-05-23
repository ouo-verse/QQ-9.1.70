package com.tencent.ecommerce.richtext.ui.dom.style;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FlexNode {
    public static final Object K = new Object();
    FlexNode C;
    private ArrayList<FlexNode> D;
    private FlexNode E;
    protected String F;

    /* renamed from: i, reason: collision with root package name */
    FlexNode f105339i;

    /* renamed from: m, reason: collision with root package name */
    FlexNode f105340m;

    /* renamed from: d, reason: collision with root package name */
    public final h f105335d = new h();

    /* renamed from: e, reason: collision with root package name */
    public final k f105336e = new k();

    /* renamed from: f, reason: collision with root package name */
    public final i f105337f = new i();

    /* renamed from: h, reason: collision with root package name */
    public int f105338h = 0;
    private a G = null;
    private AtomicReference<LayoutState> H = new AtomicReference<>(LayoutState.DIRTY);
    private boolean I = true;
    private boolean J = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum LayoutState {
        DIRTY,
        HAS_NEW_LAYOUT,
        UP_TO_DATE
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(FlexNode flexNode, float f16, n nVar);
    }

    private void R(StringBuilder sb5, int i3) {
        StringBuilder sb6 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb6.append("__");
        }
        sb5.append(sb6.toString());
        sb5.append(this.F);
        sb5.append(this.f105335d.toString());
        sb5.append(this.f105336e.toString());
        if (h() == 0) {
            return;
        }
        sb5.append(", children: [\n");
        for (int i17 = 0; i17 < h(); i17++) {
            if (f(i17) != null) {
                f(i17).R(sb5, i3 + 1);
            }
            sb5.append("\n");
        }
        sb5.append(((Object) sb6) + "]");
    }

    public void A(FlexDirection flexDirection) {
        k kVar = this.f105336e;
        if (kVar.f105389b != flexDirection) {
            kVar.f105389b = flexDirection;
            c();
        }
    }

    public void B(FlexJustifyContent flexJustifyContent) {
        k kVar = this.f105336e;
        if (kVar.f105390c != flexJustifyContent) {
            kVar.f105390c = flexJustifyContent;
            c();
        }
    }

    public void C(int i3, float f16) {
        if (this.f105336e.f105397j.e(i3, f16)) {
            c();
        }
    }

    public void D(float f16) {
        if (!T(this.f105336e.f105406s, f16)) {
            this.f105336e.f105406s = f16;
            c();
        }
    }

    public void E(float f16) {
        if (!T(this.f105336e.f105405r, f16)) {
            this.f105336e.f105405r = f16;
            c();
        }
    }

    public void F(a aVar) {
        if (this.G != aVar) {
            this.G = aVar;
            c();
        }
    }

    public void G(float f16) {
        if (!T(this.f105336e.f105404q, f16)) {
            k kVar = this.f105336e;
            kVar.f105404q = f16;
            kVar.f105402o[1] = f16;
            c();
        }
    }

    public void H(float f16) {
        if (!T(this.f105336e.f105403p, f16)) {
            this.f105336e.f105403p = f16;
            c();
        }
    }

    public void I(int i3, float f16) {
        if (this.f105336e.f105398k.e(i3, f16)) {
            c();
        }
    }

    public void J(float f16) {
        if (!T(this.f105336e.f105400m[3], f16)) {
            this.f105336e.f105400m[3] = f16;
            c();
        }
    }

    public void K(float f16) {
        if (!T(this.f105336e.f105400m[0], f16)) {
            this.f105336e.f105400m[0] = f16;
            c();
        }
    }

    public void L(float f16) {
        if (!T(this.f105336e.f105400m[2], f16)) {
            this.f105336e.f105400m[2] = f16;
            c();
        }
    }

    public void M(float f16) {
        if (!T(this.f105336e.f105400m[1], f16)) {
            this.f105336e.f105400m[1] = f16;
            c();
        }
    }

    public void N(FlexPositionType flexPositionType) {
        k kVar = this.f105336e;
        if (kVar.f105394g != flexPositionType) {
            kVar.f105394g = flexPositionType;
            c();
        }
    }

    public void O(float f16) {
        if (!T(this.f105336e.f105401n[1], f16)) {
            this.f105336e.f105401n[1] = f16;
            c();
        }
    }

    public void P(float f16) {
        if (!T(this.f105336e.f105401n[0], f16)) {
            this.f105336e.f105401n[0] = f16;
            c();
        }
    }

    public void Q(FlexWrap flexWrap) {
        k kVar = this.f105336e;
        if (kVar.f105395h != flexWrap) {
            kVar.f105395h = flexWrap;
            c();
        }
    }

    public boolean S(h hVar) {
        boolean z16 = !this.f105337f.equals(hVar);
        this.J = z16;
        if (z16) {
            this.f105337f.a(hVar);
        }
        return this.J;
    }

    protected boolean T(float f16, float f17) {
        return l.a(f16, f17);
    }

    public void a(FlexNode flexNode, int i3) {
        if (flexNode.E == null) {
            if (this.D == null) {
                this.D = new ArrayList<>(4);
            }
            this.D.add(i3, flexNode);
            flexNode.E = this;
            c();
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    public void b(j jVar) {
        synchronized (K) {
            this.f105335d.b();
            m.h(jVar, this, Float.NaN, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        LayoutState layoutState = this.H.get();
        LayoutState layoutState2 = LayoutState.DIRTY;
        if (layoutState == layoutState2) {
            return;
        }
        if (this.H.get() == LayoutState.HAS_NEW_LAYOUT && o()) {
            t();
        }
        this.H.getAndSet(layoutState2);
        FlexNode flexNode = this.E;
        if (flexNode != null && !flexNode.p()) {
            this.E.c();
        }
    }

    public FlexAlign d() {
        return this.f105336e.f105393f;
    }

    @NonNull
    public o e() {
        return this.f105336e.f105399l;
    }

    public FlexNode f(int i3) {
        ArrayList<FlexNode> arrayList = this.D;
        if (arrayList != null && arrayList.size() > i3) {
            return this.D.get(i3);
        }
        return null;
    }

    public int h() {
        ArrayList<FlexNode> arrayList = this.D;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public float i() {
        return com.tencent.ecommerce.richtext.utils.e.l(this.f105335d.f105382b[1]);
    }

    public float j() {
        return com.tencent.ecommerce.richtext.utils.e.l(this.f105335d.f105382b[0]);
    }

    public float k() {
        return this.f105335d.f105381a[0];
    }

    public float l() {
        return this.f105335d.f105381a[1];
    }

    @NonNull
    public o m() {
        return this.f105336e.f105398k;
    }

    public FlexNode n() {
        return this.E;
    }

    public boolean o() {
        if (this.H.get() == LayoutState.HAS_NEW_LAYOUT) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.H.get() == LayoutState.DIRTY) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.G != null) {
            return true;
        }
        return false;
    }

    public boolean r() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.H.getAndSet(LayoutState.HAS_NEW_LAYOUT);
    }

    public void t() {
        if (!o()) {
            return;
        }
        this.H.getAndSet(LayoutState.UP_TO_DATE);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        R(sb5, 0);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n u(n nVar, float f16) {
        if (q()) {
            nVar.f105418b = Float.NaN;
            nVar.f105417a = Float.NaN;
            a aVar = this.G;
            if (aVar != null) {
                aVar.a(this, f16, nVar);
            }
            return nVar;
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public FlexNode v(int i3) {
        FlexNode remove = this.D.remove(i3);
        remove.E = null;
        c();
        return remove;
    }

    public void w(FlexAlign flexAlign) {
        k kVar = this.f105336e;
        if (kVar.f105393f != flexAlign) {
            kVar.f105393f = flexAlign;
            c();
        }
    }

    public void x(FlexAlign flexAlign) {
        k kVar = this.f105336e;
        if (kVar.f105392e != flexAlign) {
            kVar.f105392e = flexAlign;
            c();
        }
    }

    public void y(int i3, float f16) {
        if (this.f105336e.f105399l.e(i3, f16)) {
            c();
        }
    }

    public void z(float f16) {
        if (!T(this.f105336e.f105396i, f16)) {
            this.f105336e.f105396i = f16;
            c();
        }
    }
}
