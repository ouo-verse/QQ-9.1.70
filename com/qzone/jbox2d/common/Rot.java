package com.qzone.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Rot implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: c, reason: collision with root package name */
    public float f48110c;

    /* renamed from: s, reason: collision with root package name */
    public float f48111s;

    public Rot() {
        setIdentity();
    }

    public static final void mul(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f48110c;
        float f17 = rot2.f48110c;
        float f18 = rot.f48111s;
        float f19 = rot2.f48111s;
        rot3.f48111s = (f18 * f17) + (f16 * f19);
        rot3.f48110c = (f16 * f17) - (f18 * f19);
    }

    public static final void mulToOut(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f48111s;
        float f17 = vec2.f48119x;
        float f18 = rot.f48110c;
        float f19 = vec2.f48120y;
        vec22.f48119x = (f18 * f17) - (f16 * f19);
        vec22.f48120y = (f16 * f17) + (f18 * f19);
    }

    public static final void mulToOutUnsafe(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x * f16;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        vec22.f48119x = f17 - (f18 * f19);
        vec22.f48120y = (f18 * vec2.f48119x) + (f16 * f19);
    }

    public static final void mulTrans(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f48110c;
        float f17 = rot2.f48110c;
        float f18 = rot.f48111s;
        float f19 = rot2.f48111s;
        rot3.f48111s = (f16 * f19) - (f18 * f17);
        rot3.f48110c = (f16 * f17) + (f18 * f19);
    }

    public static final void mulTransUnsafe(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f48110c;
        float f17 = rot2.f48111s * f16;
        float f18 = rot.f48111s;
        float f19 = rot2.f48110c;
        rot3.f48111s = f17 - (f18 * f19);
        rot3.f48110c = (f16 * f19) + (rot.f48111s * rot2.f48111s);
    }

    public static final void mulUnsafe(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f48111s;
        float f17 = rot2.f48110c;
        float f18 = rot.f48110c;
        rot3.f48111s = (f16 * f17) + (rot2.f48111s * f18);
        rot3.f48110c = (f18 * f17) - (rot.f48111s * rot2.f48111s);
    }

    public float getAngle() {
        return b.b(this.f48111s, this.f48110c);
    }

    public float getCos() {
        return this.f48110c;
    }

    public float getSin() {
        return this.f48111s;
    }

    public void getXAxis(Vec2 vec2) {
        vec2.set(this.f48110c, this.f48111s);
    }

    public void getYAxis(Vec2 vec2) {
        vec2.set(-this.f48111s, this.f48110c);
    }

    public Rot set(float f16) {
        this.f48111s = b.n(f16);
        this.f48110c = b.d(f16);
        return this;
    }

    public String toString() {
        return "Rot(s:" + this.f48111s + ", c:" + this.f48110c + ")";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Rot m78clone() {
        Rot rot = new Rot();
        rot.f48111s = this.f48111s;
        rot.f48110c = this.f48110c;
        return rot;
    }

    public Rot setIdentity() {
        this.f48111s = 0.0f;
        this.f48110c = 1.0f;
        return this;
    }

    public Rot(float f16) {
        set(f16);
    }

    public static final void mulTransUnsafe(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f48110c;
        float f17 = vec2.f48119x * f16;
        float f18 = rot.f48111s;
        float f19 = vec2.f48120y;
        vec22.f48119x = f17 + (f18 * f19);
        vec22.f48120y = ((-f18) * vec2.f48119x) + (f16 * f19);
    }

    public Rot set(Rot rot) {
        this.f48111s = rot.f48111s;
        this.f48110c = rot.f48110c;
        return this;
    }

    public static final void mulTrans(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f48111s;
        float f17 = vec2.f48119x;
        float f18 = rot.f48110c;
        float f19 = vec2.f48120y;
        vec22.f48119x = (f18 * f17) + (f16 * f19);
        vec22.f48120y = ((-f16) * f17) + (f18 * f19);
    }
}
