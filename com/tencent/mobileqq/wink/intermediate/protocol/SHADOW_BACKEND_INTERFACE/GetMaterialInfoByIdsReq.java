package com.tencent.mobileqq.wink.intermediate.protocol.SHADOW_BACKEND_INTERFACE;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class GetMaterialInfoByIdsReq extends JceStruct {
    static ArrayList<String> cache_MaierialIds;
    static ArrayList<MetaSdkInfo> cache_SdkInfos = new ArrayList<>();
    public String GroupId;
    public ArrayList<String> MaierialIds;
    public ArrayList<MetaSdkInfo> SdkInfos;
    public String ServiceId;

    static {
        cache_SdkInfos.add(new MetaSdkInfo());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_MaierialIds = arrayList;
        arrayList.add("");
    }

    public GetMaterialInfoByIdsReq() {
        this.GroupId = "";
        this.ServiceId = "";
        this.SdkInfos = null;
        this.MaierialIds = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.GroupId = jceInputStream.readString(0, true);
        this.ServiceId = jceInputStream.readString(1, true);
        this.SdkInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_SdkInfos, 2, true);
        this.MaierialIds = (ArrayList) jceInputStream.read((JceInputStream) cache_MaierialIds, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.GroupId, 0);
        jceOutputStream.write(this.ServiceId, 1);
        jceOutputStream.write((Collection) this.SdkInfos, 2);
        jceOutputStream.write((Collection) this.MaierialIds, 3);
    }

    public GetMaterialInfoByIdsReq(String str, String str2, ArrayList<MetaSdkInfo> arrayList, ArrayList<String> arrayList2) {
        this.GroupId = str;
        this.ServiceId = str2;
        this.SdkInfos = arrayList;
        this.MaierialIds = arrayList2;
    }
}
