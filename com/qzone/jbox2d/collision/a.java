package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Vec2 f47986a = new Vec2();

    /* renamed from: b, reason: collision with root package name */
    public final Vec2 f47987b = new Vec2();

    public static final boolean c(a aVar, a aVar2) {
        Vec2 vec2 = aVar2.f47986a;
        float f16 = vec2.f48119x;
        Vec2 vec22 = aVar.f47987b;
        if (f16 - vec22.f48119x <= 0.0f && vec2.f48120y - vec22.f48120y <= 0.0f) {
            Vec2 vec23 = aVar.f47986a;
            float f17 = vec23.f48119x;
            Vec2 vec24 = aVar2.f47987b;
            if (f17 - vec24.f48119x <= 0.0f && vec23.f48120y - vec24.f48120y <= 0.0f) {
                return true;
            }
        }
        return false;
    }

    public final void a(a aVar, a aVar2) {
        Vec2 vec2 = this.f47986a;
        Vec2 vec22 = aVar.f47986a;
        float f16 = vec22.f48119x;
        Vec2 vec23 = aVar2.f47986a;
        float f17 = vec23.f48119x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec2.f48119x = f16;
        float f18 = vec22.f48120y;
        float f19 = vec23.f48120y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec2.f48120y = f18;
        Vec2 vec24 = this.f47987b;
        Vec2 vec25 = aVar.f47987b;
        float f26 = vec25.f48119x;
        Vec2 vec26 = aVar2.f47987b;
        float f27 = vec26.f48119x;
        if (f26 <= f27) {
            f26 = f27;
        }
        vec24.f48119x = f26;
        float f28 = vec25.f48120y;
        float f29 = vec26.f48120y;
        if (f28 <= f29) {
            f28 = f29;
        }
        vec24.f48120y = f28;
    }

    public final float b() {
        Vec2 vec2 = this.f47987b;
        float f16 = vec2.f48119x;
        Vec2 vec22 = this.f47986a;
        return (((f16 - vec22.f48119x) + vec2.f48120y) - vec22.f48120y) * 2.0f;
    }

    public final String toString() {
        return "AABB[" + this.f47986a + " . " + this.f47987b + "]";
    }
}
