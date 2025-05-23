package org.jbox2d.callbacks;

import org.jbox2d.common.Color3f;
import org.jbox2d.common.IViewportTransform;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DebugDraw {
    public static final int e_aabbBit = 4;
    public static final int e_centerOfMassBit = 16;
    public static final int e_dynamicTreeBit = 32;
    public static final int e_jointBit = 2;
    public static final int e_pairBit = 8;
    public static final int e_shapeBit = 1;
    protected int m_drawFlags = 0;
    protected final IViewportTransform viewportTransform;

    public DebugDraw(IViewportTransform iViewportTransform) {
        this.viewportTransform = iViewportTransform;
    }

    public void appendFlags(int i3) {
        this.m_drawFlags = i3 | this.m_drawFlags;
    }

    public void clearFlags(int i3) {
        this.m_drawFlags = (~i3) & this.m_drawFlags;
    }

    public abstract void drawCircle(Vec2 vec2, float f16, Color3f color3f);

    public abstract void drawPoint(Vec2 vec2, float f16, Color3f color3f);

    public void drawPolygon(Vec2[] vec2Arr, int i3, Color3f color3f) {
        int i16;
        if (i3 == 1) {
            Vec2 vec2 = vec2Arr[0];
            drawSegment(vec2, vec2, color3f);
            return;
        }
        int i17 = 0;
        while (true) {
            i16 = i3 - 1;
            if (i17 >= i16) {
                break;
            }
            Vec2 vec22 = vec2Arr[i17];
            i17++;
            drawSegment(vec22, vec2Arr[i17], color3f);
        }
        if (i3 > 2) {
            drawSegment(vec2Arr[i16], vec2Arr[0], color3f);
        }
    }

    public abstract void drawSegment(Vec2 vec2, Vec2 vec22, Color3f color3f);

    public abstract void drawSolidCircle(Vec2 vec2, float f16, Vec2 vec22, Color3f color3f);

    public abstract void drawSolidPolygon(Vec2[] vec2Arr, int i3, Color3f color3f);

    public abstract void drawString(float f16, float f17, String str, Color3f color3f);

    public void drawString(Vec2 vec2, String str, Color3f color3f) {
        drawString(vec2.f423649x, vec2.f423650y, str, color3f);
    }

    public abstract void drawTransform(Transform transform);

    public int getFlags() {
        return this.m_drawFlags;
    }

    public Vec2 getScreenToWorld(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        this.viewportTransform.getScreenToWorld(vec2, vec22);
        return vec22;
    }

    public void getScreenToWorldToOut(Vec2 vec2, Vec2 vec22) {
        this.viewportTransform.getScreenToWorld(vec2, vec22);
    }

    public IViewportTransform getViewportTranform() {
        return this.viewportTransform;
    }

    public Vec2 getWorldToScreen(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        this.viewportTransform.getWorldToScreen(vec2, vec22);
        return vec22;
    }

    public void getWorldToScreenToOut(Vec2 vec2, Vec2 vec22) {
        this.viewportTransform.getWorldToScreen(vec2, vec22);
    }

    public void setCamera(float f16, float f17, float f18) {
        this.viewportTransform.setCamera(f16, f17, f18);
    }

    public void setFlags(int i3) {
        this.m_drawFlags = i3;
    }

    public void getScreenToWorldToOut(float f16, float f17, Vec2 vec2) {
        vec2.set(f16, f17);
        this.viewportTransform.getScreenToWorld(vec2, vec2);
    }

    public void getWorldToScreenToOut(float f16, float f17, Vec2 vec2) {
        vec2.set(f16, f17);
        this.viewportTransform.getWorldToScreen(vec2, vec2);
    }

    public Vec2 getScreenToWorld(float f16, float f17) {
        Vec2 vec2 = new Vec2(f16, f17);
        this.viewportTransform.getScreenToWorld(vec2, vec2);
        return vec2;
    }

    public Vec2 getWorldToScreen(float f16, float f17) {
        Vec2 vec2 = new Vec2(f16, f17);
        this.viewportTransform.getWorldToScreen(vec2, vec2);
        return vec2;
    }
}
