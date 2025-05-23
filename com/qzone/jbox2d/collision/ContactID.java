package com.qzone.jbox2d.collision;

import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ContactID implements Comparable<ContactID> {

    /* renamed from: d, reason: collision with root package name */
    public byte f47955d;

    /* renamed from: e, reason: collision with root package name */
    public byte f47956e;

    /* renamed from: f, reason: collision with root package name */
    public byte f47957f;

    /* renamed from: h, reason: collision with root package name */
    public byte f47958h;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum Type {
        VERTEX,
        FACE
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(ContactID contactID) {
        return i() - contactID.i();
    }

    public void h() {
        byte b16 = this.f47955d;
        this.f47955d = this.f47956e;
        this.f47956e = b16;
        byte b17 = this.f47957f;
        this.f47957f = this.f47958h;
        this.f47958h = b17;
    }

    public int i() {
        return (this.f47955d << 24) | (this.f47956e << RegisterType.UNINIT_REF) | (this.f47957f << 8) | this.f47958h;
    }

    public boolean j(ContactID contactID) {
        return i() == contactID.i();
    }

    public void k(ContactID contactID) {
        this.f47955d = contactID.f47955d;
        this.f47956e = contactID.f47956e;
        this.f47957f = contactID.f47957f;
        this.f47958h = contactID.f47958h;
    }

    public void l() {
        this.f47955d = (byte) 0;
        this.f47956e = (byte) 0;
        this.f47957f = (byte) 0;
        this.f47958h = (byte) 0;
    }
}
