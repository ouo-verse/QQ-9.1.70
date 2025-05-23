package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stMsgContentPersonInfo extends JceStruct {
    public String PID;
    public int beFollow;
    public int isFriend;
    public int metaPersonMedal;

    public stMsgContentPersonInfo() {
        this.PID = "";
        this.beFollow = 0;
        this.metaPersonMedal = 0;
        this.isFriend = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.PID = jceInputStream.readString(0, false);
        this.beFollow = jceInputStream.read(this.beFollow, 1, false);
        this.metaPersonMedal = jceInputStream.read(this.metaPersonMedal, 2, false);
        this.isFriend = jceInputStream.read(this.isFriend, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.PID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.beFollow, 1);
        jceOutputStream.write(this.metaPersonMedal, 2);
        jceOutputStream.write(this.isFriend, 3);
    }

    public stMsgContentPersonInfo(String str, int i3, int i16, int i17) {
        this.PID = str;
        this.beFollow = i3;
        this.metaPersonMedal = i16;
        this.isFriend = i17;
    }
}
