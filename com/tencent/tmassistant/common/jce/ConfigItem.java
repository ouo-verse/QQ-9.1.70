package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ConfigItem extends JceStruct {
    static byte[] cache_configuration;
    public byte[] configuration;
    public int type;

    static {
        cache_configuration = r0;
        byte[] bArr = {0};
    }

    public ConfigItem() {
        this.type = 0;
        this.configuration = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.configuration = jceInputStream.read(cache_configuration, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.configuration, 1);
    }

    public ConfigItem(int i3, byte[] bArr) {
        this.type = i3;
        this.configuration = bArr;
    }
}
