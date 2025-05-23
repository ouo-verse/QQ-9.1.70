package org.jbox2d.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.Joint;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface JbDeserializer {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface ObjectListener {
        void processBody(Body body, Long l3);

        void processFixture(Fixture fixture, Long l3);

        void processJoint(Joint joint, Long l3);

        void processShape(Shape shape, Long l3);

        void processWorld(World world, Long l3);
    }

    Body deserializeBody(World world, InputStream inputStream) throws IOException, UnsupportedObjectException;

    Fixture deserializeFixture(Body body, InputStream inputStream) throws IOException, UnsupportedObjectException;

    Joint deserializeJoint(World world, InputStream inputStream, Map<Integer, Body> map, Map<Integer, Joint> map2) throws IOException, UnsupportedObjectException;

    Shape deserializeShape(InputStream inputStream) throws IOException, UnsupportedObjectException;

    World deserializeWorld(InputStream inputStream) throws IOException, UnsupportedObjectException;

    void setObjectListener(ObjectListener objectListener);

    void setUnsupportedListener(UnsupportedListener unsupportedListener);
}
