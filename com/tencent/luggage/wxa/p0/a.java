package com.tencent.luggage.wxa.p0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f137099a;

    /* renamed from: b, reason: collision with root package name */
    public long f137100b;

    /* renamed from: c, reason: collision with root package name */
    public String f137101c;

    /* renamed from: d, reason: collision with root package name */
    public String f137102d;

    /* renamed from: e, reason: collision with root package name */
    public String f137103e;

    /* renamed from: f, reason: collision with root package name */
    public String f137104f;

    /* renamed from: g, reason: collision with root package name */
    public String f137105g;

    /* renamed from: h, reason: collision with root package name */
    public String f137106h;

    /* renamed from: i, reason: collision with root package name */
    public String f137107i;

    public a() {
    }

    public void a(String str) {
        this.f137099a = str;
    }

    public a(byte[] bArr) {
        try {
            a aVar = (a) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            this.f137099a = aVar.f137099a;
            this.f137100b = aVar.f137100b;
            this.f137101c = aVar.f137101c;
            this.f137102d = aVar.f137102d;
            this.f137103e = aVar.f137103e;
            this.f137104f = aVar.f137104f;
            this.f137105g = aVar.f137105g;
            this.f137106h = aVar.f137106h;
            this.f137107i = aVar.f137107i;
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (ClassNotFoundException e17) {
            e17.printStackTrace();
        }
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
