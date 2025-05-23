package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes21.dex */
public final class ProxyIpChannel extends JceStruct {
    static ArrayList<ProxyIpList> cache_vProxy_iplists = new ArrayList<>();
    public int iReconnect;
    public ArrayList<ProxyIpList> vProxy_iplists;

    static {
        cache_vProxy_iplists.add(new ProxyIpList());
    }

    public ProxyIpChannel() {
        this.vProxy_iplists = null;
        this.iReconnect = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vProxy_iplists = (ArrayList) jceInputStream.read((JceInputStream) cache_vProxy_iplists, 0, true);
        this.iReconnect = jceInputStream.read(this.iReconnect, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vProxy_iplists, 0);
        jceOutputStream.write(this.iReconnect, 1);
    }

    public ProxyIpChannel(ArrayList<ProxyIpList> arrayList, int i3) {
        this.vProxy_iplists = arrayList;
        this.iReconnect = i3;
    }
}
