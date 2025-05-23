package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespSetCard extends JceStruct {
    static int cache_eSubCmd;
    static RespHead cache_stHeader;
    static byte[] cache_vRespSetTemplate;
    public int eSubCmd;
    public RespHead stHeader;
    public byte[] vRespSetTemplate;

    public RespSetCard() {
        this.stHeader = null;
        this.eSubCmd = CARDSETTYPE.TYPE_SET_DEFAUT.value();
        this.vRespSetTemplate = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.eSubCmd = jceInputStream.read(this.eSubCmd, 1, true);
        if (cache_vRespSetTemplate == null) {
            cache_vRespSetTemplate = r0;
            byte[] bArr = {0};
        }
        this.vRespSetTemplate = jceInputStream.read(cache_vRespSetTemplate, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.eSubCmd, 1);
        byte[] bArr = this.vRespSetTemplate;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public RespSetCard(RespHead respHead, int i3, byte[] bArr) {
        this.stHeader = null;
        CARDSETTYPE.TYPE_SET_DEFAUT.value();
        this.stHeader = respHead;
        this.eSubCmd = i3;
        this.vRespSetTemplate = bArr;
    }
}
