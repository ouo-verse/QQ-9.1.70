package org.jbox2d.callbacks;

import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ContactListener {
    void beginContact(Contact contact);

    void endContact(Contact contact);

    void postSolve(Contact contact, ContactImpulse contactImpulse);

    void preSolve(Contact contact, Manifold manifold);
}
