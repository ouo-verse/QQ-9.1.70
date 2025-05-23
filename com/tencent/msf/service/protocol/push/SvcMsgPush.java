package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes21.dex */
public final class SvcMsgPush extends JceStruct {
    static ArrayList<SvcMsgInfo> cache_vecMsgInfos;
    public byte cMore;
    public int iUnread;
    public ArrayList<SvcMsgInfo> vecMsgInfos;

    public SvcMsgPush() {
        this.cMore = (byte) 0;
        this.iUnread = 0;
        this.vecMsgInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cMore = jceInputStream.read(this.cMore, 0, true);
        this.iUnread = jceInputStream.read(this.iUnread, 1, true);
        if (cache_vecMsgInfos == null) {
            cache_vecMsgInfos = new ArrayList<>();
            cache_vecMsgInfos.add(new SvcMsgInfo());
        }
        this.vecMsgInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vecMsgInfos, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cMore, 0);
        jceOutputStream.write(this.iUnread, 1);
        jceOutputStream.write((Collection) this.vecMsgInfos, 2);
    }

    public SvcMsgPush(byte b16, int i3, ArrayList<SvcMsgInfo> arrayList) {
        this.cMore = b16;
        this.iUnread = i3;
        this.vecMsgInfos = arrayList;
    }
}
