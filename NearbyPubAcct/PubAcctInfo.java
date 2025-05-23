package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PubAcctInfo extends JceStruct {
    public int cert_level;
    public int iDistance;
    public long lUin;
    public String strIntro;
    public String strLocation;
    public String strName;

    public PubAcctInfo() {
        this.lUin = 0L;
        this.strName = "";
        this.strLocation = "";
        this.strIntro = "";
        this.cert_level = 0;
        this.iDistance = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.strName = jceInputStream.readString(1, true);
        this.strLocation = jceInputStream.readString(2, true);
        this.strIntro = jceInputStream.readString(3, true);
        this.cert_level = jceInputStream.read(this.cert_level, 4, true);
        this.iDistance = jceInputStream.read(this.iDistance, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.strName, 1);
        jceOutputStream.write(this.strLocation, 2);
        jceOutputStream.write(this.strIntro, 3);
        jceOutputStream.write(this.cert_level, 4);
        jceOutputStream.write(this.iDistance, 5);
    }

    public PubAcctInfo(long j3, String str, String str2, String str3, int i3, int i16) {
        this.lUin = j3;
        this.strName = str;
        this.strLocation = str2;
        this.strIntro = str3;
        this.cert_level = i3;
        this.iDistance = i16;
    }
}
