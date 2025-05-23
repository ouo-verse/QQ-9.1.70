package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class XiaoQuInfo extends JceStruct {
    public int iMemberCnt;
    public String strIntro;
    public String strLocation;
    public String strName;
    public String strURL;

    public XiaoQuInfo() {
        this.strName = "";
        this.strLocation = "";
        this.iMemberCnt = 0;
        this.strIntro = "";
        this.strURL = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strName = jceInputStream.readString(1, true);
        this.strLocation = jceInputStream.readString(2, true);
        this.iMemberCnt = jceInputStream.read(this.iMemberCnt, 3, true);
        this.strIntro = jceInputStream.readString(4, true);
        this.strURL = jceInputStream.readString(5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strName, 1);
        jceOutputStream.write(this.strLocation, 2);
        jceOutputStream.write(this.iMemberCnt, 3);
        jceOutputStream.write(this.strIntro, 4);
        jceOutputStream.write(this.strURL, 5);
    }

    public XiaoQuInfo(String str, String str2, int i3, String str3, String str4) {
        this.strName = str;
        this.strLocation = str2;
        this.iMemberCnt = i3;
        this.strIntro = str3;
        this.strURL = str4;
    }
}
