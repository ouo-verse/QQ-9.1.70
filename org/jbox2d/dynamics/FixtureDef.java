package org.jbox2d.dynamics;

import org.jbox2d.collision.shapes.Shape;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FixtureDef {
    public Shape shape = null;
    public Object userData = null;
    public float friction = 0.2f;
    public float restitution = 0.0f;
    public float density = 0.0f;
    public Filter filter = new Filter();
    public boolean isSensor = false;
}
