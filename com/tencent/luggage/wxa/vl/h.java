package com.tencent.luggage.wxa.vl;

import com.tencent.luggage.wxa.ol.q0;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum h {
    LEFT,
    RIGHT,
    CENTER;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f143693a;

        static {
            int[] iArr = new int[h.values().length];
            f143693a = iArr;
            try {
                iArr[h.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f143693a[h.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f143693a[h.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static h a(String str) {
        return (h) e.a((h) e.a(str, h.class), LEFT);
    }

    public void a(q0 q0Var) {
        if (q0Var == null) {
            return;
        }
        int i3 = a.f143693a[ordinal()];
        if (i3 == 1) {
            q0Var.b();
        } else if (i3 == 2) {
            q0Var.g();
        } else {
            if (i3 != 3) {
                return;
            }
            q0Var.e();
        }
    }
}
