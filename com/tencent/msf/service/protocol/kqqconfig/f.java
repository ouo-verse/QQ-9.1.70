package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.e.comm.managers.plugin.PM;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class f extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static ArrayList<String> f336501e = null;

    /* renamed from: f, reason: collision with root package name */
    static ArrayList<String> f336502f = null;

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f336503g = true;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<String> f336504a;

    /* renamed from: b, reason: collision with root package name */
    public int f336505b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f336506c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336507d;

    public f() {
        this.f336504a = null;
        this.f336505b = 0;
        this.f336506c = null;
        this.f336507d = (byte) 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f336503g) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display((Collection) this.f336504a, "signatures");
        jceDisplayer.display(this.f336505b, "lcid");
        jceDisplayer.display((Collection) this.f336506c, "uins");
        jceDisplayer.display(this.f336507d, PM.BASE);
    }

    public boolean equals(Object obj) {
        f fVar = (f) obj;
        if (JceUtil.equals(this.f336504a, fVar.f336504a) && JceUtil.equals(this.f336505b, fVar.f336505b) && JceUtil.equals(this.f336506c, fVar.f336506c) && JceUtil.equals(this.f336507d, fVar.f336507d)) {
            return true;
        }
        return false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336501e == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f336501e = arrayList;
            arrayList.add("");
        }
        this.f336504a = (ArrayList) jceInputStream.read((JceInputStream) f336501e, 1, true);
        this.f336505b = jceInputStream.read(this.f336505b, 2, true);
        if (f336502f == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            f336502f = arrayList2;
            arrayList2.add("");
        }
        this.f336506c = (ArrayList) jceInputStream.read((JceInputStream) f336502f, 3, true);
        this.f336507d = jceInputStream.read(this.f336507d, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.f336504a, 1);
        jceOutputStream.write(this.f336505b, 2);
        jceOutputStream.write((Collection) this.f336506c, 3);
        jceOutputStream.write(this.f336507d, 4);
    }

    public f(ArrayList<String> arrayList, int i3, ArrayList<String> arrayList2, byte b16) {
        this.f336504a = arrayList;
        this.f336505b = i3;
        this.f336506c = arrayList2;
        this.f336507d = b16;
    }
}
