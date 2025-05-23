package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Transform implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Vec2 pool = new Vec2();
    private static final long serialVersionUID = 1;

    /* renamed from: p, reason: collision with root package name */
    public final Vec2 f423647p;

    /* renamed from: q, reason: collision with root package name */
    public final Rot f423648q;

    public Transform() {
        this.f423647p = new Vec2();
        this.f423648q = new Rot();
    }

    public static final Vec2 mul(Transform transform, Vec2 vec2) {
        Rot rot = transform.f423648q;
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        Vec2 vec22 = transform.f423647p;
        return new Vec2(((f16 * f17) - (f18 * f19)) + vec22.f423649x, (f18 * f17) + (f16 * f19) + vec22.f423650y);
    }

    public static final void mulToOut(Transform transform, Vec2 vec2, Vec2 vec22) {
        Rot rot = transform.f423648q;
        float f16 = rot.f423642s;
        float f17 = vec2.f423649x;
        float f18 = rot.f423641c;
        float f19 = vec2.f423650y;
        Vec2 vec23 = transform.f423647p;
        float f26 = (f16 * f17) + (f18 * f19) + vec23.f423650y;
        vec22.f423649x = ((f18 * f17) - (f16 * f19)) + vec23.f423649x;
        vec22.f423650y = f26;
    }

    public static final void mulToOutUnsafe(Transform transform, Vec2 vec2, Vec2 vec22) {
        Rot rot = transform.f423648q;
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x * f16;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        Vec2 vec23 = transform.f423647p;
        vec22.f423649x = (f17 - (f18 * f19)) + vec23.f423649x;
        vec22.f423650y = (f18 * vec2.f423649x) + (f16 * f19) + vec23.f423650y;
    }

    public static final Vec2 mulTrans(Transform transform, Vec2 vec2) {
        float f16 = vec2.f423649x;
        Vec2 vec22 = transform.f423647p;
        float f17 = f16 - vec22.f423649x;
        float f18 = vec2.f423650y - vec22.f423650y;
        Rot rot = transform.f423648q;
        float f19 = rot.f423641c;
        float f26 = rot.f423642s;
        return new Vec2((f19 * f17) + (f26 * f18), ((-f26) * f17) + (f19 * f18));
    }

    public static final void mulTransToOut(Transform transform, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        Vec2 vec23 = transform.f423647p;
        float f17 = f16 - vec23.f423649x;
        float f18 = vec2.f423650y - vec23.f423650y;
        Rot rot = transform.f423648q;
        float f19 = rot.f423642s;
        float f26 = rot.f423641c;
        vec22.f423649x = (f26 * f17) + (f19 * f18);
        vec22.f423650y = ((-f19) * f17) + (f26 * f18);
    }

    public static final void mulTransToOutUnsafe(Transform transform, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        Vec2 vec23 = transform.f423647p;
        float f17 = f16 - vec23.f423649x;
        float f18 = vec2.f423650y - vec23.f423650y;
        Rot rot = transform.f423648q;
        float f19 = rot.f423641c;
        float f26 = rot.f423642s;
        vec22.f423649x = (f19 * f17) + (f26 * f18);
        vec22.f423650y = ((-f26) * f17) + (f19 * f18);
    }

    public final Transform set(Transform transform) {
        this.f423647p.set(transform.f423647p);
        this.f423648q.set(transform.f423648q);
        return this;
    }

    public final void setIdentity() {
        this.f423647p.setZero();
        this.f423648q.setIdentity();
    }

    public final String toString() {
        return ("XForm:\nPosition: " + this.f423647p + "\n") + "R: \n" + this.f423648q + "\n";
    }

    public static final Transform mul(Transform transform, Transform transform2) {
        Transform transform3 = new Transform();
        Rot.mulUnsafe(transform.f423648q, transform2.f423648q, transform3.f423648q);
        Rot.mulToOutUnsafe(transform.f423648q, transform2.f423647p, transform3.f423647p);
        transform3.f423647p.addLocal(transform.f423647p);
        return transform3;
    }

    public static final void mulToOutUnsafe(Transform transform, Transform transform2, Transform transform3) {
        Rot.mulUnsafe(transform.f423648q, transform2.f423648q, transform3.f423648q);
        Rot.mulToOutUnsafe(transform.f423648q, transform2.f423647p, transform3.f423647p);
        transform3.f423647p.addLocal(transform.f423647p);
    }

    public final void set(Vec2 vec2, float f16) {
        this.f423647p.set(vec2);
        this.f423648q.set(f16);
    }

    public Transform(Transform transform) {
        this.f423647p = transform.f423647p.clone();
        this.f423648q = transform.f423648q.clone();
    }

    public static final void mulToOut(Transform transform, Transform transform2, Transform transform3) {
        Rot.mul(transform.f423648q, transform2.f423648q, transform3.f423648q);
        Rot.mulToOut(transform.f423648q, transform2.f423647p, transform3.f423647p);
        transform3.f423647p.addLocal(transform.f423647p);
    }

    public static final Transform mulTrans(Transform transform, Transform transform2) {
        Transform transform3 = new Transform();
        Rot.mulTransUnsafe(transform.f423648q, transform2.f423648q, transform3.f423648q);
        pool.set(transform2.f423647p).subLocal(transform.f423647p);
        Rot.mulTransUnsafe(transform.f423648q, pool, transform3.f423647p);
        return transform3;
    }

    public static final void mulTransToOutUnsafe(Transform transform, Transform transform2, Transform transform3) {
        Rot.mulTransUnsafe(transform.f423648q, transform2.f423648q, transform3.f423648q);
        pool.set(transform2.f423647p).subLocal(transform.f423647p);
        Rot.mulTransUnsafe(transform.f423648q, pool, transform3.f423647p);
    }

    public static final void mulTransToOut(Transform transform, Transform transform2, Transform transform3) {
        Rot.mulTrans(transform.f423648q, transform2.f423648q, transform3.f423648q);
        pool.set(transform2.f423647p).subLocal(transform.f423647p);
        Rot.mulTrans(transform.f423648q, pool, transform3.f423647p);
    }

    public Transform(Vec2 vec2, Rot rot) {
        this.f423647p = vec2.clone();
        this.f423648q = rot.clone();
    }
}
