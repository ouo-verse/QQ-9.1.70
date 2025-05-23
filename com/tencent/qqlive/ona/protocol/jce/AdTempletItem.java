package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdTempletItem extends JceStruct {
    static byte[] cache_data;
    static DebugInfo cache_debugInfo = new DebugInfo();
    static int cache_viewType;
    public byte[] data;
    public DebugInfo debugInfo;
    public int index;
    public int viewType;

    static {
        cache_data = r0;
        byte[] bArr = {0};
    }

    public AdTempletItem() {
        this.viewType = 0;
        this.data = null;
        this.debugInfo = null;
        this.index = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.viewType = jceInputStream.read(this.viewType, 0, true);
        this.data = jceInputStream.read(cache_data, 1, false);
        this.debugInfo = (DebugInfo) jceInputStream.read((JceStruct) cache_debugInfo, 2, false);
        this.index = jceInputStream.read(this.index, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.viewType, 0);
        byte[] bArr = this.data;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        DebugInfo debugInfo = this.debugInfo;
        if (debugInfo != null) {
            jceOutputStream.write((JceStruct) debugInfo, 2);
        }
        jceOutputStream.write(this.index, 3);
    }

    public AdTempletItem(int i3, byte[] bArr, DebugInfo debugInfo, int i16) {
        this.viewType = i3;
        this.data = bArr;
        this.debugInfo = debugInfo;
        this.index = i16;
    }
}
