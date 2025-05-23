package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {

    /* renamed from: d, reason: collision with root package name */
    public static final SparseIntArray f131338d;

    /* renamed from: a, reason: collision with root package name */
    public final OrientationEventListener f131339a;

    /* renamed from: b, reason: collision with root package name */
    public Display f131340b;

    /* renamed from: c, reason: collision with root package name */
    public int f131341c = 0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends OrientationEventListener {

        /* renamed from: a, reason: collision with root package name */
        public int f131342a;

        public a(Context context) {
            super(context);
            this.f131342a = -1;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            Display display;
            int rotation;
            if (i3 != -1 && (display = k.this.f131340b) != null && this.f131342a != (rotation = display.getRotation())) {
                this.f131342a = rotation;
                k.this.a(k.f131338d.get(rotation));
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f131338d = sparseIntArray;
        sparseIntArray.put(0, 0);
        sparseIntArray.put(1, 90);
        sparseIntArray.put(2, 180);
        sparseIntArray.put(3, 270);
    }

    public k(Context context) {
        this.f131339a = new a(context);
    }

    public void a(Display display) {
        this.f131340b = display;
        this.f131339a.enable();
        a(f131338d.get(display.getRotation()));
    }

    public int b() {
        return this.f131341c;
    }

    public abstract void b(int i3);

    public void a() {
        this.f131339a.disable();
        this.f131340b = null;
    }

    public void a(int i3) {
        this.f131341c = i3;
        b(i3);
    }
}
