package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class GetAppUpdateResponse extends JceStruct {
    public static Map<Integer, ArrayList<AppUpdateInfo>> cache_appUpdateInfoGroup;
    public static ArrayList<AppUpdateInfo> cache_appUpdateInfoList;
    public int ret = 0;
    public ArrayList<AppUpdateInfo> appUpdateInfoList = null;
    public Map<Integer, ArrayList<AppUpdateInfo>> appUpdateInfoGroup = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (cache_appUpdateInfoList == null) {
            cache_appUpdateInfoList = new ArrayList<>();
            cache_appUpdateInfoList.add(new AppUpdateInfo());
        }
        this.appUpdateInfoList = (ArrayList) jceInputStream.read((JceInputStream) cache_appUpdateInfoList, 1, true);
        if (cache_appUpdateInfoGroup == null) {
            cache_appUpdateInfoGroup = new HashMap();
            ArrayList<AppUpdateInfo> arrayList = new ArrayList<>();
            arrayList.add(new AppUpdateInfo());
            cache_appUpdateInfoGroup.put(0, arrayList);
        }
        this.appUpdateInfoGroup = (Map) jceInputStream.read((JceInputStream) cache_appUpdateInfoGroup, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((Collection) this.appUpdateInfoList, 1);
        Map<Integer, ArrayList<AppUpdateInfo>> map = this.appUpdateInfoGroup;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }
}
