package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static ArrayList<String> f336474f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<String> f336475a;

    /* renamed from: b, reason: collision with root package name */
    public int f336476b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336477c;

    /* renamed from: d, reason: collision with root package name */
    public String f336478d;

    /* renamed from: e, reason: collision with root package name */
    public int f336479e;

    public b() {
        this.f336475a = null;
        this.f336476b = 0;
        this.f336477c = (byte) 1;
        this.f336478d = "46000";
        this.f336479e = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336474f == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f336474f = arrayList;
            arrayList.add("");
        }
        this.f336475a = (ArrayList) jceInputStream.read((JceInputStream) f336474f, 1, true);
        this.f336476b = jceInputStream.read(this.f336476b, 2, true);
        this.f336477c = jceInputStream.read(this.f336477c, 3, false);
        this.f336478d = jceInputStream.readString(4, false);
        this.f336479e = jceInputStream.read(this.f336479e, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.f336475a, 1);
        jceOutputStream.write(this.f336476b, 2);
        jceOutputStream.write(this.f336477c, 3);
        String str = this.f336478d;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.f336479e, 5);
    }

    public b(ArrayList<String> arrayList, int i3, byte b16, String str, int i16) {
        this.f336475a = arrayList;
        this.f336476b = i3;
        this.f336477c = b16;
        this.f336478d = str;
        this.f336479e = i16;
    }
}
