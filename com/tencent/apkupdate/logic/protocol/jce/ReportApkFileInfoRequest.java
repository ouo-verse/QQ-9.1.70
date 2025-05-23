package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReportApkFileInfoRequest extends JceStruct {
    public static ArrayList<ApkFileInfo> cache_apkFileInfoList;
    public ArrayList<ApkFileInfo> apkFileInfoList = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_apkFileInfoList == null) {
            cache_apkFileInfoList = new ArrayList<>();
            cache_apkFileInfoList.add(new ApkFileInfo());
        }
        this.apkFileInfoList = (ArrayList) jceInputStream.read((JceInputStream) cache_apkFileInfoList, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.apkFileInfoList, 0);
    }
}
