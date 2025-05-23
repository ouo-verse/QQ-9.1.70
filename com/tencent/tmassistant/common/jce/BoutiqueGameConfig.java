package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BoutiqueGameConfig extends JceStruct {
    static ArrayList<String> cache_pkgList;
    public ArrayList<String> pkgList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_pkgList = arrayList;
        arrayList.add("");
    }

    public BoutiqueGameConfig() {
        this.pkgList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pkgList = (ArrayList) jceInputStream.read((JceInputStream) cache_pkgList, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.pkgList, 0);
    }

    public BoutiqueGameConfig(ArrayList<String> arrayList) {
        this.pkgList = arrayList;
    }
}
