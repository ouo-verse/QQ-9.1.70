package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EntranceContent extends JceStruct {
    static byte[] cache_content_buff;
    public byte[] content_buff;
    public int type;

    static {
        cache_content_buff = r0;
        byte[] bArr = {0};
    }

    public EntranceContent() {
        this.type = 0;
        this.content_buff = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.content_buff = jceInputStream.read(cache_content_buff, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.content_buff, 1);
    }

    public EntranceContent(int i3, byte[] bArr) {
        this.type = i3;
        this.content_buff = bArr;
    }
}
