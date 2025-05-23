package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_audio extends JceStruct {
    public String audiokey;
    public int audiotime;
    public String errormessge;
    public int isplay;

    public s_audio() {
        this.audiokey = "";
        this.errormessge = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.audiokey = jceInputStream.readString(0, false);
        this.audiotime = jceInputStream.read(this.audiotime, 1, false);
        this.errormessge = jceInputStream.readString(2, false);
        this.isplay = jceInputStream.read(this.isplay, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.audiokey;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.audiotime, 1);
        String str2 = this.errormessge;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.isplay, 3);
    }

    public s_audio(String str, int i3, String str2, int i16) {
        this.audiokey = str;
        this.audiotime = i3;
        this.errormessge = str2;
        this.isplay = i16;
    }
}
