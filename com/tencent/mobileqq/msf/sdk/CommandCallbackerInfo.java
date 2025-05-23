package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CommandCallbackerInfo extends JceStruct {
    static ArrayList<String> cache_cmds;
    public ArrayList<String> cmds;
    public String uin;

    public CommandCallbackerInfo() {
        this.uin = "";
        this.cmds = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(1, true);
        if (cache_cmds == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_cmds = arrayList;
            arrayList.add("");
        }
        this.cmds = (ArrayList) jceInputStream.read((JceInputStream) cache_cmds, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write((Collection) this.cmds, 2);
    }

    public CommandCallbackerInfo(String str, ArrayList<String> arrayList) {
        this.uin = str;
        this.cmds = arrayList;
    }
}
