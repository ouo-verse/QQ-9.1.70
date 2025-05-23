package org.jbox2d.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Rot implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 1;

    /* renamed from: c, reason: collision with root package name */
    public float f423641c;

    /* renamed from: s, reason: collision with root package name */
    public float f423642s;

    public Rot() {
        setIdentity();
    }

    public static final void mul(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f423641c;
        float f17 = rot2.f423641c;
        float f18 = rot.f423642s;
        float f19 = rot2.f423642s;
        rot3.f423642s = (f18 * f17) + (f16 * f19);
        rot3.f423641c = (f16 * f17) - (f18 * f19);
    }

    public static final void mulToOut(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f423642s;
        float f17 = vec2.f423649x;
        float f18 = rot.f423641c;
        float f19 = vec2.f423650y;
        vec22.f423649x = (f18 * f17) - (f16 * f19);
        vec22.f423650y = (f16 * f17) + (f18 * f19);
    }

    public static final void mulToOutUnsafe(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x * f16;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        vec22.f423649x = f17 - (f18 * f19);
        vec22.f423650y = (f18 * vec2.f423649x) + (f16 * f19);
    }

    public static final void mulTrans(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f423641c;
        float f17 = rot2.f423641c;
        float f18 = rot.f423642s;
        float f19 = rot2.f423642s;
        rot3.f423642s = (f16 * f19) - (f18 * f17);
        rot3.f423641c = (f16 * f17) + (f18 * f19);
    }

    public static final void mulTransUnsafe(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f423641c;
        float f17 = rot2.f423642s * f16;
        float f18 = rot.f423642s;
        float f19 = rot2.f423641c;
        rot3.f423642s = f17 - (f18 * f19);
        rot3.f423641c = (f16 * f19) + (rot.f423642s * rot2.f423642s);
    }

    public static final void mulUnsafe(Rot rot, Rot rot2, Rot rot3) {
        float f16 = rot.f423642s;
        float f17 = rot2.f423641c;
        float f18 = rot.f423641c;
        rot3.f423642s = (f16 * f17) + (rot2.f423642s * f18);
        rot3.f423641c = (f18 * f17) - (rot.f423642s * rot2.f423642s);
    }

    public float getAngle() {
        return MathUtils.atan2(this.f423642s, this.f423641c);
    }

    public float getCos() {
        return this.f423641c;
    }

    public float getSin() {
        return this.f423642s;
    }

    public void getXAxis(Vec2 vec2) {
        vec2.set(this.f423641c, this.f423642s);
    }

    public void getYAxis(Vec2 vec2) {
        vec2.set(-this.f423642s, this.f423641c);
    }

    public Rot set(float f16) {
        this.f423642s = MathUtils.sin(f16);
        this.f423641c = MathUtils.cos(f16);
        return this;
    }

    public Rot setIdentity() {
        this.f423642s = 0.0f;
        this.f423641c = 1.0f;
        return this;
    }

    public String toString() {
        return "Rot(s:" + this.f423642s + ", c:" + this.f423641c + ")";
    }

    public Rot clone() {
        Rot rot = new Rot();
        rot.f423642s = this.f423642s;
        rot.f423641c = this.f423641c;
        return rot;
    }

    public Rot(float f16) {
        set(f16);
    }

    public static final void mulTransUnsafe(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x * f16;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        vec22.f423649x = f17 + (f18 * f19);
        vec22.f423650y = ((-f18) * vec2.f423649x) + (f16 * f19);
    }

    public Rot set(Rot rot) {
        this.f423642s = rot.f423642s;
        this.f423641c = rot.f423641c;
        return this;
    }

    public static final void mulTrans(Rot rot, Vec2 vec2, Vec2 vec22) {
        float f16 = rot.f423642s;
        float f17 = vec2.f423649x;
        float f18 = rot.f423641c;
        float f19 = vec2.f423650y;
        vec22.f423649x = (f18 * f17) + (f16 * f19);
        vec22.f423650y = ((-f16) * f17) + (f18 * f19);
    }
}
