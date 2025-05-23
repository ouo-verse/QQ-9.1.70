package com.tencent.ads.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpCookie;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SerializableCookie implements Serializable {
    private static final long serialVersionUID = 6374381828722046732L;

    /* renamed from: a, reason: collision with root package name */
    private final transient HttpCookie f61682a;

    /* renamed from: b, reason: collision with root package name */
    private transient HttpCookie f61683b;

    /* renamed from: c, reason: collision with root package name */
    private Date f61684c;

    public SerializableCookie(HttpCookie httpCookie, Date date) {
        this.f61682a = httpCookie;
        this.f61684c = date;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        HttpCookie httpCookie = new HttpCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.f61683b = httpCookie;
        httpCookie.setComment((String) objectInputStream.readObject());
        this.f61683b.setDomain((String) objectInputStream.readObject());
        this.f61683b.setPath((String) objectInputStream.readObject());
        this.f61683b.setVersion(objectInputStream.readInt());
        this.f61683b.setSecure(objectInputStream.readBoolean());
        this.f61684c = (Date) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.f61682a.getName());
        objectOutputStream.writeObject(this.f61682a.getValue());
        objectOutputStream.writeObject(this.f61682a.getComment());
        objectOutputStream.writeObject(this.f61682a.getDomain());
        objectOutputStream.writeObject(this.f61682a.getPath());
        objectOutputStream.writeInt(this.f61682a.getVersion());
        objectOutputStream.writeBoolean(this.f61682a.getSecure());
        objectOutputStream.writeObject(this.f61684c);
    }

    public final HttpCookie a() {
        HttpCookie httpCookie = this.f61682a;
        HttpCookie httpCookie2 = this.f61683b;
        return httpCookie2 != null ? httpCookie2 : httpCookie;
    }

    public final Date b() {
        return this.f61684c;
    }
}
