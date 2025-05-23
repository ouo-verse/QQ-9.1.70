package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes21.dex */
public final class ProxyIpList extends JceStruct {
    static ArrayList<ProxyIpInfo> cache_vIplist = new ArrayList<>();
    public int uService_type;
    public ArrayList<ProxyIpInfo> vIplist;

    static {
        cache_vIplist.add(new ProxyIpInfo());
    }

    public ProxyIpList() {
        this.uService_type = 0;
        this.vIplist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uService_type = jceInputStream.read(this.uService_type, 0, true);
        this.vIplist = (ArrayList) jceInputStream.read((JceInputStream) cache_vIplist, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uService_type, 0);
        jceOutputStream.write((Collection) this.vIplist, 1);
    }

    public ProxyIpList(int i3, ArrayList<ProxyIpInfo> arrayList) {
        this.uService_type = i3;
        this.vIplist = arrayList;
    }
}
