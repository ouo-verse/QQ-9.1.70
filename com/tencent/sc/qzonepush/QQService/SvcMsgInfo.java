package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class SvcMsgInfo extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, byte[]> cache_msgByteInfos;
    static Map<String, String> cache_msgInfos;
    public int iMsgType;
    public long lFromUin;
    public Map<String, byte[]> msgByteInfos;
    public Map<String, String> msgInfos;
    public String strOther;
    public int tTimeStamp;

    public SvcMsgInfo() {
        this.lFromUin = 0L;
        this.tTimeStamp = 0;
        this.iMsgType = 0;
        this.strOther = "";
        this.msgInfos = null;
        this.msgByteInfos = null;
    }

    public String className() {
        return "QQService.SvcMsgInfo";
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
        jceDisplayer.display(this.lFromUin, "lFromUin");
        jceDisplayer.display(this.tTimeStamp, "tTimeStamp");
        jceDisplayer.display(this.iMsgType, "iMsgType");
        jceDisplayer.display(this.strOther, "strOther");
        jceDisplayer.display((Map) this.msgInfos, "msgInfos");
        jceDisplayer.display((Map) this.msgByteInfos, "msgByteInfos");
    }

    public boolean equals(Object obj) {
        SvcMsgInfo svcMsgInfo = (SvcMsgInfo) obj;
        if (JceUtil.equals(this.lFromUin, svcMsgInfo.lFromUin) && JceUtil.equals(this.tTimeStamp, svcMsgInfo.tTimeStamp) && JceUtil.equals(this.iMsgType, svcMsgInfo.iMsgType) && JceUtil.equals(this.strOther, svcMsgInfo.strOther) && JceUtil.equals(this.msgInfos, svcMsgInfo.msgInfos) && JceUtil.equals(this.msgByteInfos, svcMsgInfo.msgByteInfos)) {
            return true;
        }
        return false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUin = jceInputStream.read(this.lFromUin, 0, true);
        this.tTimeStamp = jceInputStream.read(this.tTimeStamp, 1, true);
        this.iMsgType = jceInputStream.read(this.iMsgType, 2, true);
        this.strOther = jceInputStream.readString(3, true);
        if (cache_msgInfos == null) {
            HashMap hashMap = new HashMap();
            cache_msgInfos = hashMap;
            hashMap.put("", "");
        }
        this.msgInfos = (Map) jceInputStream.read((JceInputStream) cache_msgInfos, 4, false);
        if (cache_msgByteInfos == null) {
            HashMap hashMap2 = new HashMap();
            cache_msgByteInfos = hashMap2;
            hashMap2.put("", new byte[]{0});
        }
        this.msgByteInfos = (Map) jceInputStream.read((JceInputStream) cache_msgByteInfos, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUin, 0);
        jceOutputStream.write(this.tTimeStamp, 1);
        jceOutputStream.write(this.iMsgType, 2);
        jceOutputStream.write(this.strOther, 3);
        Map<String, String> map = this.msgInfos;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        Map<String, byte[]> map2 = this.msgByteInfos;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
    }

    public SvcMsgInfo(long j3, int i3, int i16, String str, Map<String, String> map, Map<String, byte[]> map2) {
        this.lFromUin = j3;
        this.tTimeStamp = i3;
        this.iMsgType = i16;
        this.strOther = str;
        this.msgInfos = map;
        this.msgByteInfos = map2;
    }
}
