package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ApkFileInfo extends JceStruct {
    public static Map<String, Long> cache_fileCRC32;
    public long apkId = 0;
    public String manifestMd5 = "";
    public String packageName = "";
    public Map<String, Long> fileCRC32 = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.apkId = jceInputStream.read(this.apkId, 0, true);
        this.manifestMd5 = jceInputStream.readString(1, true);
        this.packageName = jceInputStream.readString(2, true);
        if (cache_fileCRC32 == null) {
            cache_fileCRC32 = new HashMap();
            cache_fileCRC32.put("", 0L);
        }
        this.fileCRC32 = (Map) jceInputStream.read((JceInputStream) cache_fileCRC32, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.apkId, 0);
        jceOutputStream.write(this.manifestMd5, 1);
        jceOutputStream.write(this.packageName, 2);
        jceOutputStream.write((Map) this.fileCRC32, 3);
    }
}
