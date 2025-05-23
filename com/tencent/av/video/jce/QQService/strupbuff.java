package com.tencent.av.video.jce.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class strupbuff extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, ArrayList<byte[]>> cache_logstring;
    public Map<String, ArrayList<byte[]>> logstring = null;

    public strupbuff() {
        setLogstring(null);
    }

    public String className() {
        return "com.tencent.qq.video.jce.QQService.strupbuff";
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
        new JceDisplayer(sb5, i3).display((Map) this.logstring, "logstring");
    }

    public boolean equals(Object obj) {
        return JceUtil.equals(this.logstring, ((strupbuff) obj).logstring);
    }

    public Map<String, ArrayList<byte[]>> getLogstring() {
        return this.logstring;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_logstring == null) {
            cache_logstring = new HashMap();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(new byte[]{0});
            cache_logstring.put("", arrayList);
        }
        setLogstring((Map) jceInputStream.read((JceInputStream) cache_logstring, 0, true));
    }

    public void setLogstring(Map<String, ArrayList<byte[]>> map) {
        this.logstring = map;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.logstring, 0);
    }

    public strupbuff(Map<String, ArrayList<byte[]>> map) {
        setLogstring(map);
    }
}
