package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class QueryLoginInfoRequest extends JceStruct {
    public String addtion;

    public QueryLoginInfoRequest() {
        this.addtion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.addtion = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.addtion;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public QueryLoginInfoRequest(String str) {
        this.addtion = str;
    }
}
