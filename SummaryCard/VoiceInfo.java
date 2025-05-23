package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VoiceInfo extends JceStruct {
    static byte[] cache_vVoiceId;
    public byte bRead;
    public short shDuration;
    public String strUrl;
    public byte[] vVoiceId;

    public VoiceInfo() {
        this.vVoiceId = null;
        this.shDuration = (short) 0;
        this.bRead = (byte) 2;
        this.strUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vVoiceId == null) {
            cache_vVoiceId = r0;
            byte[] bArr = {0};
        }
        this.vVoiceId = jceInputStream.read(cache_vVoiceId, 0, false);
        this.shDuration = jceInputStream.read(this.shDuration, 1, false);
        this.bRead = jceInputStream.read(this.bRead, 2, false);
        this.strUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vVoiceId;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.shDuration, 1);
        jceOutputStream.write(this.bRead, 2);
        String str = this.strUrl;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public VoiceInfo(byte[] bArr, short s16, byte b16, String str) {
        this.vVoiceId = bArr;
        this.shDuration = s16;
        this.bRead = b16;
        this.strUrl = str;
    }
}
