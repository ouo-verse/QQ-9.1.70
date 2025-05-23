package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NeighborBanner extends JceStruct {
    static byte[] cache_description;
    static byte[] cache_pic_url;
    static byte[] cache_skip_url;
    public byte[] description;
    public byte[] pic_url;
    public int postion;
    public byte[] skip_url;

    static {
        cache_description = r1;
        byte[] bArr = {0};
        cache_pic_url = r1;
        byte[] bArr2 = {0};
        cache_skip_url = r0;
        byte[] bArr3 = {0};
    }

    public NeighborBanner() {
        this.description = null;
        this.pic_url = null;
        this.skip_url = null;
        this.postion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.description = jceInputStream.read(cache_description, 0, true);
        this.pic_url = jceInputStream.read(cache_pic_url, 1, true);
        this.skip_url = jceInputStream.read(cache_skip_url, 2, true);
        this.postion = jceInputStream.read(this.postion, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.description, 0);
        jceOutputStream.write(this.pic_url, 1);
        jceOutputStream.write(this.skip_url, 2);
        jceOutputStream.write(this.postion, 3);
    }

    public NeighborBanner(byte[] bArr, byte[] bArr2, byte[] bArr3, int i3) {
        this.description = bArr;
        this.pic_url = bArr2;
        this.skip_url = bArr3;
        this.postion = i3;
    }
}
