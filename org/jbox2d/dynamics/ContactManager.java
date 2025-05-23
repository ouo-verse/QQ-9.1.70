package org.jbox2d.dynamics;

import org.jbox2d.callbacks.ContactFilter;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.callbacks.PairCallback;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContactManager implements PairCallback {
    public BroadPhase m_broadPhase;
    private final World pool;
    public Contact m_contactList = null;
    public int m_contactCount = 0;
    public ContactFilter m_contactFilter = new ContactFilter();
    public ContactListener m_contactListener = null;

    public ContactManager(World world, BroadPhaseStrategy broadPhaseStrategy) {
        this.m_broadPhase = new BroadPhase(broadPhaseStrategy);
        this.pool = world;
    }

    @Override // org.jbox2d.callbacks.PairCallback
    public void addPair(Object obj, Object obj2) {
        Contact popContact;
        FixtureProxy fixtureProxy = (FixtureProxy) obj;
        FixtureProxy fixtureProxy2 = (FixtureProxy) obj2;
        Fixture fixture = fixtureProxy.fixture;
        Fixture fixture2 = fixtureProxy2.fixture;
        int i3 = fixtureProxy.childIndex;
        int i16 = fixtureProxy2.childIndex;
        Body body = fixture.getBody();
        Body body2 = fixture2.getBody();
        if (body == body2) {
            return;
        }
        for (ContactEdge contactList = body2.getContactList(); contactList != null; contactList = contactList.next) {
            if (contactList.other == body) {
                Fixture fixtureA = contactList.contact.getFixtureA();
                Fixture fixtureB = contactList.contact.getFixtureB();
                int childIndexA = contactList.contact.getChildIndexA();
                int childIndexB = contactList.contact.getChildIndexB();
                if (fixtureA == fixture && childIndexA == i3 && fixtureB == fixture2 && childIndexB == i16) {
                    return;
                }
                if (fixtureA == fixture2 && childIndexA == i16 && fixtureB == fixture && childIndexB == i3) {
                    return;
                }
            }
        }
        if (!body2.shouldCollide(body)) {
            return;
        }
        ContactFilter contactFilter = this.m_contactFilter;
        if ((contactFilter != null && !contactFilter.shouldCollide(fixture, fixture2)) || (popContact = this.pool.popContact(fixture, i3, fixture2, i16)) == null) {
            return;
        }
        Fixture fixtureA2 = popContact.getFixtureA();
        Fixture fixtureB2 = popContact.getFixtureB();
        popContact.getChildIndexA();
        popContact.getChildIndexB();
        Body body3 = fixtureA2.getBody();
        Body body4 = fixtureB2.getBody();
        popContact.m_prev = null;
        Contact contact = this.m_contactList;
        popContact.m_next = contact;
        if (contact != null) {
            contact.m_prev = popContact;
        }
        this.m_contactList = popContact;
        ContactEdge contactEdge = popContact.m_nodeA;
        contactEdge.contact = popContact;
        contactEdge.other = body4;
        contactEdge.prev = null;
        ContactEdge contactEdge2 = body3.m_contactList;
        contactEdge.next = contactEdge2;
        if (contactEdge2 != null) {
            contactEdge2.prev = contactEdge;
        }
        body3.m_contactList = contactEdge;
        ContactEdge contactEdge3 = popContact.m_nodeB;
        contactEdge3.contact = popContact;
        contactEdge3.other = body3;
        contactEdge3.prev = null;
        ContactEdge contactEdge4 = body4.m_contactList;
        contactEdge3.next = contactEdge4;
        if (contactEdge4 != null) {
            contactEdge4.prev = contactEdge3;
        }
        body4.m_contactList = contactEdge3;
        if (!fixtureA2.isSensor() && !fixtureB2.isSensor()) {
            body3.setAwake(true);
            body4.setAwake(true);
        }
        this.m_contactCount++;
    }

    public void collide() {
        boolean z16;
        Contact next;
        Contact contact = this.m_contactList;
        while (contact != null) {
            Fixture fixtureA = contact.getFixtureA();
            Fixture fixtureB = contact.getFixtureB();
            int childIndexA = contact.getChildIndexA();
            int childIndexB = contact.getChildIndexB();
            Body body = fixtureA.getBody();
            Body body2 = fixtureB.getBody();
            if ((contact.m_flags & 8) == 8) {
                if (!body2.shouldCollide(body)) {
                    next = contact.getNext();
                    destroy(contact);
                } else {
                    ContactFilter contactFilter = this.m_contactFilter;
                    if (contactFilter != null && !contactFilter.shouldCollide(fixtureA, fixtureB)) {
                        next = contact.getNext();
                        destroy(contact);
                    } else {
                        contact.m_flags &= -9;
                    }
                }
                contact = next;
            }
            boolean z17 = true;
            if (body.isAwake() && body.m_type != BodyType.STATIC) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!body2.isAwake() || body2.m_type == BodyType.STATIC) {
                z17 = false;
            }
            if (!z16 && !z17) {
                contact = contact.getNext();
            } else {
                if (!this.m_broadPhase.testOverlap(fixtureA.m_proxies[childIndexA].proxyId, fixtureB.m_proxies[childIndexB].proxyId)) {
                    next = contact.getNext();
                    destroy(contact);
                    contact = next;
                } else {
                    contact.update(this.m_contactListener);
                    contact = contact.getNext();
                }
            }
        }
    }

    public void destroy(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        Body body = fixtureA.getBody();
        Body body2 = fixtureB.getBody();
        if (this.m_contactListener != null && contact.isTouching()) {
            this.m_contactListener.endContact(contact);
        }
        Contact contact2 = contact.m_prev;
        if (contact2 != null) {
            contact2.m_next = contact.m_next;
        }
        Contact contact3 = contact.m_next;
        if (contact3 != null) {
            contact3.m_prev = contact2;
        }
        if (contact == this.m_contactList) {
            this.m_contactList = contact3;
        }
        ContactEdge contactEdge = contact.m_nodeA;
        ContactEdge contactEdge2 = contactEdge.prev;
        if (contactEdge2 != null) {
            contactEdge2.next = contactEdge.next;
        }
        ContactEdge contactEdge3 = contactEdge.next;
        if (contactEdge3 != null) {
            contactEdge3.prev = contactEdge2;
        }
        if (contactEdge == body.m_contactList) {
            body.m_contactList = contactEdge3;
        }
        ContactEdge contactEdge4 = contact.m_nodeB;
        ContactEdge contactEdge5 = contactEdge4.prev;
        if (contactEdge5 != null) {
            contactEdge5.next = contactEdge4.next;
        }
        ContactEdge contactEdge6 = contactEdge4.next;
        if (contactEdge6 != null) {
            contactEdge6.prev = contactEdge5;
        }
        if (contactEdge4 == body2.m_contactList) {
            body2.m_contactList = contactEdge6;
        }
        this.pool.pushContact(contact);
        this.m_contactCount--;
    }

    public void findNewContacts() {
        this.m_broadPhase.updatePairs(this);
    }
}
