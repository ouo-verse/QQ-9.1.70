package org.jbox2d.serialization;

import java.util.Map;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.Joint;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface JbSerializer {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface ObjectSigner {
        Long getTag(Shape shape);

        Long getTag(Body body);

        Long getTag(Fixture fixture);

        Long getTag(World world);

        Long getTag(Joint joint);
    }

    SerializationResult serialize(Shape shape) throws UnsupportedObjectException;

    SerializationResult serialize(Body body) throws UnsupportedObjectException;

    SerializationResult serialize(Fixture fixture) throws UnsupportedObjectException;

    SerializationResult serialize(World world) throws UnsupportedObjectException;

    SerializationResult serialize(Joint joint, Map<Body, Integer> map, Map<Joint, Integer> map2);

    void setObjectSigner(ObjectSigner objectSigner);

    void setUnsupportedListener(UnsupportedListener unsupportedListener);
}
