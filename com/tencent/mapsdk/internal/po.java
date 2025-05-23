package com.tencent.mapsdk.internal;

import android.graphics.Color;
import android.graphics.Rect;
import com.tencent.mapsdk.internal.aq;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class po<D extends aq> extends aw<D> implements ex {
    protected IndoorInfo b_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f149552d;

    /* renamed from: n, reason: collision with root package name */
    public final bb f149562n;

    /* renamed from: o, reason: collision with root package name */
    volatile boolean f149563o;

    /* renamed from: p, reason: collision with root package name */
    private Object f149564p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f149565q;

    /* renamed from: r, reason: collision with root package name */
    private Selectable.OnSelectedListener f149566r;

    /* renamed from: s, reason: collision with root package name */
    private float f149567s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f149568t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f149569u;

    /* renamed from: b, reason: collision with root package name */
    private boolean f149551b = false;

    /* renamed from: e, reason: collision with root package name */
    protected float f149553e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    protected int f149554f = Color.argb(17, 0, 163, 255);

    /* renamed from: g, reason: collision with root package name */
    protected int f149555g = Color.argb(255, 0, 163, 255);

    /* renamed from: h, reason: collision with root package name */
    protected float f149556h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f149557i = true;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f149558j = false;

    /* renamed from: k, reason: collision with root package name */
    protected AtomicInteger f149559k = new AtomicInteger(0);

    /* renamed from: l, reason: collision with root package name */
    protected int f149560l = 2;

    /* renamed from: m, reason: collision with root package name */
    public int f149561m = -1;

    /* renamed from: v, reason: collision with root package name */
    private final long f149570v = System.nanoTime();

    public po(bb bbVar) {
        this.f149562n = bbVar;
    }

    private bb d() {
        return this.f149562n;
    }

    private void e() {
        this.f149563o = true;
    }

    private Selectable.OnSelectedListener f() {
        return this.f149566r;
    }

    public int a() {
        return this.f149561m;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Rect getBound(fa faVar) {
        return new Rect();
    }

    public int getFillColor() {
        return this.f149554f;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    public List<Boundable<fa>> getGroupBounds() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        return this.c_;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getLevel() {
        return this.f149560l;
    }

    public float getRotation() {
        return this.f149567s;
    }

    public int getStrokeColor() {
        return this.f149555g;
    }

    public float getStrokeWidth() {
        return this.f149553e;
    }

    public Object getTag() {
        return this.f149564p;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getZIndex() {
        return (int) this.f149556h;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean handleOnTap() {
        return false;
    }

    public boolean isClickable() {
        return this.f149552d;
    }

    public boolean isDraggable() {
        return this.f149568t;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public boolean isRemoved() {
        return this.f149569u;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public boolean isSelected() {
        return this.f149565q;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public boolean isVisible() {
        if (this.b_ != null) {
            if (this.f149557i && this.f149551b) {
                return true;
            }
            return false;
        }
        return this.f149557i;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.mapsdk.internal.fb
    public final long o() {
        return this.f149570v;
    }

    @Override // com.tencent.mapsdk.internal.ex
    public boolean q() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void remove() {
        this.f149566r = null;
        this.f149562n.d(getId());
        h_();
        this.f149569u = true;
    }

    @Override // com.tencent.mapsdk.internal.ez
    public final IndoorInfo s() {
        return this.b_;
    }

    public void setClickable(boolean z16) {
        this.f149552d = z16;
    }

    public void setDraggable(boolean z16) {
        this.f149568t = z16;
    }

    public void setFillColor(int i3) {
        this.f149554f = i3;
        w();
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i3) {
        this.f149560l = i3;
        w();
    }

    public void setRotation(float f16) {
        this.f149567s = f16;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelected(boolean z16) {
        this.f149565q = z16;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelectedListener(Selectable.OnSelectedListener onSelectedListener) {
        this.f149566r = onSelectedListener;
    }

    public void setStrokeColor(int i3) {
        this.f149555g = i3;
        w();
    }

    public void setStrokeWidth(float f16) {
        this.f149553e = f16;
        w();
    }

    public void setTag(Object obj) {
        this.f149564p = obj;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z16) {
        this.f149557i = z16;
        w();
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(int i3) {
        setZIndex(i3);
    }

    @Override // com.tencent.mapsdk.internal.ez
    public final boolean t() {
        return this.f149551b;
    }

    @Override // com.tencent.mapsdk.internal.ez
    public void u() {
        if (this.b_ != null) {
            this.f149551b = false;
            setVisible(false);
        }
        p();
    }

    public final boolean v() {
        if (this.f149559k.get() > 0) {
            this.f149558j = true;
            this.f149559k.set(0);
        }
        return this.f149558j;
    }

    public void w() {
        if (this.f149563o) {
            return;
        }
        this.f149559k.incrementAndGet();
        this.f149558j = true;
    }

    public final void x() {
        this.f149563o = false;
        w();
    }

    public final String y() {
        return this.c_;
    }

    private void a(int i3) {
        this.f149561m = i3;
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(float f16) {
        this.f149556h = f16;
        w();
    }

    @Override // com.tencent.mapsdk.internal.ez
    public final void a(IndoorInfo indoorInfo) {
        this.b_ = indoorInfo;
    }

    @Override // com.tencent.mapsdk.internal.ez
    public void a(IndoorBuilding indoorBuilding) {
        IndoorInfo indoorInfo = this.b_;
        if (indoorInfo != null) {
            boolean equals = indoorInfo.toString().equals(indoorBuilding.toString());
            this.f149551b = equals;
            setVisible(equals);
        }
        p();
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.mapsdk.internal.ev
    public final void a(GL10 gl10) {
        bb bbVar;
        boolean v3 = v();
        j_();
        if (v3 && (bbVar = this.f149562n) != null) {
            bbVar.G();
        }
        this.f149558j = false;
    }

    private static void g() {
    }

    private static void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h_() {
    }

    public void j_() {
    }

    public void p() {
    }

    @Override // com.tencent.mapsdk.internal.ex
    public final void r() {
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
    }
}
