package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static ArrayList<d> f336452e;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<d> f336453a;

    /* renamed from: b, reason: collision with root package name */
    public String f336454b;

    /* renamed from: c, reason: collision with root package name */
    public String f336455c;

    /* renamed from: d, reason: collision with root package name */
    public int f336456d;

    public a() {
        this.f336453a = null;
        this.f336454b = "";
        this.f336455c = "";
        this.f336456d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336452e == null) {
            f336452e = new ArrayList<>();
            f336452e.add(new d());
        }
        this.f336453a = (ArrayList) jceInputStream.read((JceInputStream) f336452e, 1, false);
        this.f336454b = jceInputStream.readString(2, false);
        this.f336455c = jceInputStream.readString(3, false);
        this.f336456d = jceInputStream.read(this.f336456d, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<d> arrayList = this.f336453a;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.f336454b;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.f336455c;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.f336456d, 4);
    }

    public a(ArrayList<d> arrayList, String str, String str2, int i3) {
        this.f336453a = arrayList;
        this.f336454b = str;
        this.f336455c = str2;
        this.f336456d = i3;
    }
}
