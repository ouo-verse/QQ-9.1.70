package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GameCoverInfo extends JceStruct {
    public int jmpType;
    public String jmpUrl;
    public String schema;
    public double xCoordLU;
    public double xCoordRD;
    public double yCoordLU;
    public double yCoordRD;

    public GameCoverInfo() {
        this.jmpUrl = "";
        this.schema = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.xCoordLU = jceInputStream.read(this.xCoordLU, 0, false);
        this.yCoordLU = jceInputStream.read(this.yCoordLU, 1, false);
        this.xCoordRD = jceInputStream.read(this.xCoordRD, 2, false);
        this.yCoordRD = jceInputStream.read(this.yCoordRD, 3, false);
        this.jmpUrl = jceInputStream.readString(4, false);
        this.schema = jceInputStream.readString(5, false);
        this.jmpType = jceInputStream.read(this.jmpType, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.xCoordLU, 0);
        jceOutputStream.write(this.yCoordLU, 1);
        jceOutputStream.write(this.xCoordRD, 2);
        jceOutputStream.write(this.yCoordRD, 3);
        String str = this.jmpUrl;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.schema;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.jmpType, 6);
    }

    public GameCoverInfo(double d16, double d17, double d18, double d19, String str, String str2, int i3) {
        this.xCoordLU = d16;
        this.yCoordLU = d17;
        this.xCoordRD = d18;
        this.yCoordRD = d19;
        this.jmpUrl = str;
        this.schema = str2;
        this.jmpType = i3;
    }
}
