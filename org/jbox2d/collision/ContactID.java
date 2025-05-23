package org.jbox2d.collision;

import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContactID implements Comparable<ContactID> {
    public byte indexA;
    public byte indexB;
    public byte typeA;
    public byte typeB;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Type {
        VERTEX,
        FACE
    }

    public ContactID() {
    }

    public void flip() {
        byte b16 = this.indexA;
        this.indexA = this.indexB;
        this.indexB = b16;
        byte b17 = this.typeA;
        this.typeA = this.typeB;
        this.typeB = b17;
    }

    public int getKey() {
        return (this.indexA << 24) | (this.indexB << RegisterType.UNINIT_REF) | (this.typeA << 8) | this.typeB;
    }

    public boolean isEqual(ContactID contactID) {
        if (getKey() == contactID.getKey()) {
            return true;
        }
        return false;
    }

    public void set(ContactID contactID) {
        this.indexA = contactID.indexA;
        this.indexB = contactID.indexB;
        this.typeA = contactID.typeA;
        this.typeB = contactID.typeB;
    }

    public void zero() {
        this.indexA = (byte) 0;
        this.indexB = (byte) 0;
        this.typeA = (byte) 0;
        this.typeB = (byte) 0;
    }

    public ContactID(ContactID contactID) {
        set(contactID);
    }

    @Override // java.lang.Comparable
    public int compareTo(ContactID contactID) {
        return getKey() - contactID.getKey();
    }
}
