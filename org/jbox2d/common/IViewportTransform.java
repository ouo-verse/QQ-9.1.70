package org.jbox2d.common;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface IViewportTransform {
    Vec2 getCenter();

    Vec2 getExtents();

    void getScreenToWorld(Vec2 vec2, Vec2 vec22);

    void getScreenVectorToWorld(Vec2 vec2, Vec2 vec22);

    void getWorldToScreen(Vec2 vec2, Vec2 vec22);

    void getWorldVectorToScreen(Vec2 vec2, Vec2 vec22);

    boolean isYFlip();

    void setCamera(float f16, float f17, float f18);

    void setCenter(float f16, float f17);

    void setCenter(Vec2 vec2);

    void setExtents(float f16, float f17);

    void setExtents(Vec2 vec2);

    void setYFlip(boolean z16);
}
