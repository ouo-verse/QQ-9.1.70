package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class GetAppUpdateRequest extends JceStruct {
    public static ArrayList<AppInfoForUpdate> cache_appInfoForUpdateList;
    public ArrayList<AppInfoForUpdate> appInfoForUpdateList = null;
    public byte flag = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_appInfoForUpdateList == null) {
            cache_appInfoForUpdateList = new ArrayList<>();
            cache_appInfoForUpdateList.add(new AppInfoForUpdate());
        }
        this.appInfoForUpdateList = (ArrayList) jceInputStream.read((JceInputStream) cache_appInfoForUpdateList, 0, true);
        this.flag = jceInputStream.read(this.flag, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.appInfoForUpdateList, 0);
        jceOutputStream.write(this.flag, 1);
    }
}
