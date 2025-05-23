package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ActYellowDiamond extends JceStruct {
    public int iTenYearUser;
    public String strPicZip;

    public ActYellowDiamond() {
        this.iTenYearUser = 0;
        this.strPicZip = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTenYearUser = jceInputStream.read(this.iTenYearUser, 0, false);
        this.strPicZip = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTenYearUser, 0);
        String str = this.strPicZip;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public ActYellowDiamond(int i3, String str) {
        this.iTenYearUser = i3;
        this.strPicZip = str;
    }
}
