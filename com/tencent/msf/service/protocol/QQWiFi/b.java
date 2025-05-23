package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static ArrayList<WiFiService> f336457e;

    /* renamed from: a, reason: collision with root package name */
    public int f336458a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<WiFiService> f336459b;

    /* renamed from: c, reason: collision with root package name */
    public int f336460c;

    /* renamed from: d, reason: collision with root package name */
    public int f336461d;

    public b() {
        this.f336458a = 0;
        this.f336459b = null;
        this.f336460c = 0;
        this.f336461d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336458a = jceInputStream.read(this.f336458a, 0, true);
        if (f336457e == null) {
            f336457e = new ArrayList<>();
            f336457e.add(new WiFiService());
        }
        this.f336459b = (ArrayList) jceInputStream.read((JceInputStream) f336457e, 1, false);
        this.f336460c = jceInputStream.read(this.f336460c, 2, false);
        this.f336461d = jceInputStream.read(this.f336461d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336458a, 0);
        ArrayList<WiFiService> arrayList = this.f336459b;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.f336460c, 2);
        jceOutputStream.write(this.f336461d, 3);
    }

    public b(int i3, ArrayList<WiFiService> arrayList, int i16, int i17) {
        this.f336458a = i3;
        this.f336459b = arrayList;
        this.f336460c = i16;
        this.f336461d = i17;
    }
}
