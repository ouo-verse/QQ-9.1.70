package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AudioInfo extends JceStruct {
    public String playkey;
    public int time;

    public AudioInfo() {
        this.playkey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.playkey = jceInputStream.readString(0, false);
        this.time = jceInputStream.read(this.time, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.playkey;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.time, 1);
    }

    public AudioInfo(String str, int i3) {
        this.playkey = str;
        this.time = i3;
    }
}
