package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes25.dex */
public final class SvcMsgPush extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<SvcMsgInfo> cache_vecMsgInfos;
    public byte cMore;
    public int iUnread;
    public ArrayList<SvcMsgInfo> vecMsgInfos;

    public SvcMsgPush() {
        this.cMore = (byte) 0;
        this.iUnread = 0;
        this.vecMsgInfos = null;
    }

    public String className() {
        return "com.tencent.sc.qzonepush.QQService.SvcMsgPush";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.cMore, "cMore");
        jceDisplayer.display(this.iUnread, "iUnread");
        jceDisplayer.display((Collection) this.vecMsgInfos, "vecMsgInfos");
    }

    public boolean equals(Object obj) {
        SvcMsgPush svcMsgPush = (SvcMsgPush) obj;
        if (JceUtil.equals(this.cMore, svcMsgPush.cMore) && JceUtil.equals(this.iUnread, svcMsgPush.iUnread) && JceUtil.equals(this.vecMsgInfos, svcMsgPush.vecMsgInfos)) {
            return true;
        }
        return false;
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
