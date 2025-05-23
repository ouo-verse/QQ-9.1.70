package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface ew extends fp {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum a {
        LEFT(0),
        RIGHT(1),
        BOTTOM(2),
        TOP(3);


        /* renamed from: e, reason: collision with root package name */
        public int f148329e;

        a(int i3) {
            this.f148329e = i3;
        }

        public static final a a(int i3) {
            if (i3 < 0 || i3 >= values().length) {
                i3 = 0;
            }
            return values()[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        LEFT_BOTTOM(0),
        CENTER_BOTTOM(4),
        RIGHT_BOTTOM(1),
        LEFT_TOP(3),
        CENTER_TOP(5),
        RIGHT_TOP(2);


        /* renamed from: g, reason: collision with root package name */
        public final int f148337g;

        b(int i3) {
            this.f148337g = i3;
        }

        public static b a(int i3) {
            if (i3 < 0 || i3 >= values().length) {
                i3 = 0;
            }
            b bVar = LEFT_BOTTOM;
            for (b bVar2 : values()) {
                if (bVar2.f148337g == i3) {
                    return bVar2;
                }
            }
            return bVar;
        }
    }

    Rect a();

    void a(b bVar);

    boolean a(ViewGroup viewGroup, Bundle bundle);

    void c();

    b d();
}
