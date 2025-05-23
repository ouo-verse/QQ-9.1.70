package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class pj extends pk implements iu {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public int N;
    protected float S = 1.0f;
    protected float T = 1.0f;
    protected float U = 1.0f;
    protected float V = 0.0f;
    protected float W = 0.0f;
    protected float X = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    private a f149512a;

    /* renamed from: b, reason: collision with root package name */
    private b f149513b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        boolean b();

        String c();

        Bitmap d();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    public final synchronized void a(a aVar) {
        this.f149512a = aVar;
    }

    public void b(int i3) {
        this.N = i3;
        this.S = 1.0f;
        this.T = 1.0f;
        this.U = 1.0f;
        this.V = 0.0f;
        this.W = 0.0f;
    }

    private int a() {
        return this.N;
    }

    @Override // com.tencent.mapsdk.internal.iu
    public final void a(int i3, Object obj) {
        if (i3 == 1) {
            this.S = ((Number) obj).floatValue();
            return;
        }
        if (i3 == 2) {
            fw fwVar = (fw) obj;
            this.T = (float) fwVar.f148383a;
            this.U = (float) fwVar.f148384b;
        } else if (i3 != 3) {
            if (i3 != 4) {
                return;
            }
            this.X = ((Number) obj).floatValue();
        } else {
            fw fwVar2 = (fw) obj;
            this.V = (float) fwVar2.f148383a;
            this.W = (float) fwVar2.f148384b;
        }
    }
}
