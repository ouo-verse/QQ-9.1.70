package org.jbox2d.dynamics;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BodyDef {
    public Object userData = null;
    public Vec2 position = new Vec2();
    public float angle = 0.0f;
    public Vec2 linearVelocity = new Vec2();
    public float angularVelocity = 0.0f;
    public float linearDamping = 0.0f;
    public float angularDamping = 0.0f;
    public boolean allowSleep = true;
    public boolean awake = true;
    public boolean fixedRotation = false;
    public boolean bullet = false;
    public BodyType type = BodyType.STATIC;
    public boolean active = true;
    public float gravityScale = 1.0f;
}
