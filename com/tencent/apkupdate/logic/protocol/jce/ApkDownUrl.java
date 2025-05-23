package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ApkDownUrl extends JceStruct {
    public static ArrayList<String> cache_urlList;
    public byte type = 0;
    public ArrayList<String> urlList = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        if (cache_urlList == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_urlList = arrayList;
            arrayList.add("");
        }
        this.urlList = (ArrayList) jceInputStream.read((JceInputStream) cache_urlList, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write((Collection) this.urlList, 1);
    }
}
