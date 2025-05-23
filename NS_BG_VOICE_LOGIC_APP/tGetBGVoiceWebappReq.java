package NS_BG_VOICE_LOGIC_APP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tGetBGVoiceWebappReq extends JceStruct {
    public long lLoginUin;
    public String strQUA;

    public tGetBGVoiceWebappReq() {
        this.lLoginUin = 0L;
        this.strQUA = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lLoginUin = jceInputStream.read(this.lLoginUin, 0, false);
        this.strQUA = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lLoginUin, 0);
        String str = this.strQUA;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public tGetBGVoiceWebappReq(long j3, String str) {
        this.lLoginUin = j3;
        this.strQUA = str;
    }
}
