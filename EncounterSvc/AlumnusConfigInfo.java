package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AlumnusConfigInfo extends JceStruct {
    static byte[] cache_alumnus_pic_md5;
    static byte[] cache_alumnus_pic_url;
    public byte alumnus_entrance_open;
    public byte[] alumnus_pic_md5;
    public byte[] alumnus_pic_url;

    static {
        cache_alumnus_pic_url = r1;
        byte[] bArr = {0};
        cache_alumnus_pic_md5 = r0;
        byte[] bArr2 = {0};
    }

    public AlumnusConfigInfo() {
        this.alumnus_entrance_open = (byte) 0;
        this.alumnus_pic_url = null;
        this.alumnus_pic_md5 = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.alumnus_entrance_open = jceInputStream.read(this.alumnus_entrance_open, 0, false);
        this.alumnus_pic_url = jceInputStream.read(cache_alumnus_pic_url, 1, false);
        this.alumnus_pic_md5 = jceInputStream.read(cache_alumnus_pic_md5, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.alumnus_entrance_open, 0);
        byte[] bArr = this.alumnus_pic_url;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        byte[] bArr2 = this.alumnus_pic_md5;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 2);
        }
    }

    public AlumnusConfigInfo(byte b16, byte[] bArr, byte[] bArr2) {
        this.alumnus_entrance_open = b16;
        this.alumnus_pic_url = bArr;
        this.alumnus_pic_md5 = bArr2;
    }
}
