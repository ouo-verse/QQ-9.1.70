package com.tencent.mobileqq.msf.core.c0;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class h extends JceStruct {

    /* renamed from: b, reason: collision with root package name */
    static ArrayList<i> f247781b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<i> f247782a;

    public h() {
        this.f247782a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f247781b == null) {
            f247781b = new ArrayList<>();
            f247781b.add(new i());
        }
        this.f247782a = (ArrayList) jceInputStream.read((JceInputStream) f247781b, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.f247782a, 1);
    }

    public h(ArrayList<i> arrayList) {
        this.f247782a = arrayList;
    }
}
