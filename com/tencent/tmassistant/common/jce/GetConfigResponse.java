package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetConfigResponse extends JceStruct {
    static ArrayList<ConfigItem> cache_settingList = new ArrayList<>();
    public int ret;
    public ArrayList<ConfigItem> settingList;

    static {
        cache_settingList.add(new ConfigItem());
    }

    public GetConfigResponse() {
        this.ret = 0;
        this.settingList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.settingList = (ArrayList) jceInputStream.read((JceInputStream) cache_settingList, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((Collection) this.settingList, 1);
    }

    public GetConfigResponse(int i3, ArrayList<ConfigItem> arrayList) {
        this.ret = i3;
        this.settingList = arrayList;
    }
}
