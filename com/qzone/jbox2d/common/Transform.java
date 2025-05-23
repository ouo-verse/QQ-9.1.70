package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Transform implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: d, reason: collision with root package name */
    private static Vec2 f48116d = new Vec2();
    private static final long serialVersionUID = 1;

    /* renamed from: p, reason: collision with root package name */
    public final Vec2 f48117p;

    /* renamed from: q, reason: collision with root package name */
    public final Rot f48118q;

    public Transform() {
        this.f48117p = new Vec2();
        this.f48118q = new Rot();
    }

    public static Vec2 mul(Transform transform, Vec2 vec2) {
        Rot rot = transform.f48118q;
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        Vec2 vec22 = transform.f48117p;
        return new Vec2(((f16 * f17) - (f18 * f19)) + vec22.f48119x, (f18 * f17) + (f16 * f19) + vec22.f48120y);
    }

    public static void mulToOut(Transform transform, Vec2 vec2, Vec2 vec22) {
        Rot rot = transform.f48118q;
        float f16 = rot.f48111s;
        float f17 = vec2.f48119x;
        float f18 = rot.f48110c;
        float f19 = vec2.f48120y;
        Vec2 vec23 = transform.f48117p;
        float f26 = (f16 * f17) + (f18 * f19) + vec23.f48120y;
        vec22.f48119x = ((f18 * f17) - (f16 * f19)) + vec23.f48119x;
        vec22.f48120y = f26;
    }

    public static void mulToOutUnsafe(Transform transform, Vec2 vec2, Vec2 vec22) {
        Rot rot = transform.f48118q;
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x * f16;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        Vec2 vec23 = transform.f48117p;
        vec22.f48119x = (f17 - (f18 * f19)) + vec23.f48119x;
        vec22.f48120y = (f18 * vec2.f48119x) + (f16 * f19) + vec23.f48120y;
    }

    public static Vec2 mulTrans(Transform transform, Vec2 vec2) {
        float f16 = vec2.f48119x;
        Vec2 vec22 = transform.f48117p;
        float f17 = f16 - vec22.f48119x;
        float f18 = vec2.f48120y - vec22.f48120y;
        Rot rot = transform.f48118q;
        float f19 = rot.f48110c;
        float f26 = rot.f48111s;
        return new Vec2((f19 * f17) + (f26 * f18), ((-f26) * f17) + (f19 * f18));
    }

    public static void mulTransToOut(Transform transform, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        Vec2 vec23 = transform.f48117p;
        float f17 = f16 - vec23.f48119x;
        float f18 = vec2.f48120y - vec23.f48120y;
        Rot rot = transform.f48118q;
        float f19 = rot.f48111s;
        float f26 = rot.f48110c;
        vec22.f48119x = (f26 * f17) + (f19 * f18);
        vec22.f48120y = ((-f19) * f17) + (f26 * f18);
    }

    public static void mulTransToOutUnsafe(Transform transform, Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f48119x;
        Vec2 vec23 = transform.f48117p;
        float f17 = f16 - vec23.f48119x;
        float f18 = vec2.f48120y - vec23.f48120y;
        Rot rot = transform.f48118q;
        float f19 = rot.f48110c;
        float f26 = rot.f48111s;
        vec22.f48119x = (f19 * f17) + (f26 * f18);
        vec22.f48120y = ((-f26) * f17) + (f19 * f18);
    }

    public final Transform set(Transform transform) {
        this.f48117p.set(transform.f48117p);
        this.f48118q.set(transform.f48118q);
        return this;
    }

    public final void setIdentity() {
        this.f48117p.setZero();
        this.f48118q.setIdentity();
    }

    public final String toString() {
        return ("XForm:\nPosition: " + this.f48117p + "\n") + "R: \n" + this.f48118q + "\n";
    }

    public static Transform mul(Transform transform, Transform transform2) {
        Transform transform3 = new Transform();
        Rot.mulUnsafe(transform.f48118q, transform2.f48118q, transform3.f48118q);
        Rot.mulToOutUnsafe(transform.f48118q, transform2.f48117p, transform3.f48117p);
        transform3.f48117p.addLocal(transform.f48117p);
        return transform3;
    }

    public static void mulToOutUnsafe(Transform transform, Transform transform2, Transform transform3) {
        Rot.mulUnsafe(transform.f48118q, transform2.f48118q, transform3.f48118q);
        Rot.mulToOutUnsafe(transform.f48118q, transform2.f48117p, transform3.f48117p);
        transform3.f48117p.addLocal(transform.f48117p);
    }

    public final void set(Vec2 vec2, float f16) {
        this.f48117p.set(vec2);
        this.f48118q.set(f16);
    }

    public Transform(Transform transform) {
        this.f48117p = transform.f48117p.m79clone();
        this.f48118q = transform.f48118q.m78clone();
    }

    public static void mulToOut(Transform transform, Transform transform2, Transform transform3) {
        Rot.mul(transform.f48118q, transform2.f48118q, transform3.f48118q);
        Rot.mulToOut(transform.f48118q, transform2.f48117p, transform3.f48117p);
        transform3.f48117p.addLocal(transform.f48117p);
    }

    public static Transform mulTrans(Transform transform, Transform transform2) {
        Transform transform3 = new Transform();
        Rot.mulTransUnsafe(transform.f48118q, transform2.f48118q, transform3.f48118q);
        f48116d.set(transform2.f48117p).subLocal(transform.f48117p);
        Rot.mulTransUnsafe(transform.f48118q, f48116d, transform3.f48117p);
        return transform3;
    }

    public static void mulTransToOutUnsafe(Transform transform, Transform transform2, Transform transform3) {
        Rot.mulTransUnsafe(transform.f48118q, transform2.f48118q, transform3.f48118q);
        f48116d.set(transform2.f48117p).subLocal(transform.f48117p);
        Rot.mulTransUnsafe(transform.f48118q, f48116d, transform3.f48117p);
    }

    public static void mulTransToOut(Transform transform, Transform transform2, Transform transform3) {
        Rot.mulTrans(transform.f48118q, transform2.f48118q, transform3.f48118q);
        f48116d.set(transform2.f48117p).subLocal(transform.f48117p);
        Rot.mulTrans(transform.f48118q, f48116d, transform3.f48117p);
    }

    public Transform(Vec2 vec2, Rot rot) {
        this.f48117p = vec2.m79clone();
        this.f48118q = rot.m78clone();
    }
}
