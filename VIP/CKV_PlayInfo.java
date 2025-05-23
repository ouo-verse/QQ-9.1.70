package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CKV_PlayInfo extends JceStruct {
    public long iLstPlayTime;
    public String sSongId;

    public CKV_PlayInfo() {
        this.sSongId = "";
        this.iLstPlayTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sSongId = jceInputStream.readString(0, false);
        this.iLstPlayTime = jceInputStream.read(this.iLstPlayTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sSongId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iLstPlayTime, 1);
    }

    public CKV_PlayInfo(String str, long j3) {
        this.sSongId = str;
        this.iLstPlayTime = j3;
    }
}
