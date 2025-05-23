package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class ix implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<a> f148825a = null;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void a(ix ixVar);

        void b();

        void b(ix ixVar);
    }

    private ArrayList<a> i() {
        return this.f148825a;
    }

    private void j() {
        ArrayList<a> arrayList = this.f148825a;
        if (arrayList != null) {
            arrayList.clear();
            this.f148825a = null;
        }
    }

    public void a() {
    }

    public abstract void a(long j3);

    public abstract void a(Interpolator interpolator);

    public abstract ix b(long j3);

    public void b() {
    }

    public abstract long d();

    public abstract long e();

    public abstract boolean f();

    public boolean g() {
        return f();
    }

    @Override // 
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ix clone() {
        try {
            ix ixVar = (ix) super.clone();
            ArrayList<a> arrayList = this.f148825a;
            if (arrayList != null) {
                ixVar.f148825a = new ArrayList<>();
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ixVar.f148825a.add(arrayList.get(i3));
                }
            }
            return ixVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public final void a(a aVar) {
        if (this.f148825a == null) {
            this.f148825a = new ArrayList<>();
        }
        this.f148825a.add(aVar);
    }

    public final void b(a aVar) {
        ArrayList<a> arrayList = this.f148825a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
        if (this.f148825a.size() == 0) {
            this.f148825a = null;
        }
    }

    public void c() {
    }
}
