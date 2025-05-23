package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BypassInterceptConfig extends JceStruct {
    static ArrayList<String> cache_pkgList;
    public ArrayList<String> pkgList;
    public int status;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_pkgList = arrayList;
        arrayList.add("");
    }

    public BypassInterceptConfig() {
        this.status = 0;
        this.pkgList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, true);
        this.pkgList = (ArrayList) jceInputStream.read((JceInputStream) cache_pkgList, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        jceOutputStream.write((Collection) this.pkgList, 1);
    }

    public BypassInterceptConfig(int i3, ArrayList<String> arrayList) {
        this.status = i3;
        this.pkgList = arrayList;
    }
}
