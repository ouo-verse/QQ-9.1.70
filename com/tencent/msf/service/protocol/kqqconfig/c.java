package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static ArrayList<String> f336480f;

    /* renamed from: a, reason: collision with root package name */
    public int f336481a;

    /* renamed from: b, reason: collision with root package name */
    public int f336482b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f336483c;

    /* renamed from: d, reason: collision with root package name */
    public int f336484d;

    /* renamed from: e, reason: collision with root package name */
    public int f336485e;

    public c() {
        this.f336481a = 0;
        this.f336482b = 0;
        this.f336483c = null;
        this.f336484d = 0;
        this.f336485e = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336481a = jceInputStream.read(this.f336481a, 1, false);
        this.f336482b = jceInputStream.read(this.f336482b, 2, false);
        if (f336480f == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f336480f = arrayList;
            arrayList.add("");
        }
        this.f336483c = (ArrayList) jceInputStream.read((JceInputStream) f336480f, 3, false);
        this.f336484d = jceInputStream.read(this.f336484d, 4, false);
        this.f336485e = jceInputStream.read(this.f336485e, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336481a, 1);
        jceOutputStream.write(this.f336482b, 2);
        ArrayList<String> arrayList = this.f336483c;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.f336484d, 4);
        jceOutputStream.write(this.f336485e, 5);
    }

    public c(int i3, int i16, ArrayList<String> arrayList, int i17, int i18) {
        this.f336481a = i3;
        this.f336482b = i16;
        this.f336483c = arrayList;
        this.f336484d = i17;
        this.f336485e = i18;
    }
}
