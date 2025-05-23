package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tMobileQbossFeedBackInfo extends JceStruct {
    public int iOperSource;
    public int iOperTimes;
    public int iOperType;
    public String idfa;
    public String sQBosstrace;
    public String sQua;
    public String sUserID;
    public long uiUin;

    public tMobileQbossFeedBackInfo() {
        this.uiUin = 0L;
        this.sQBosstrace = "";
        this.iOperType = 0;
        this.iOperSource = 0;
        this.sQua = "";
        this.sUserID = "";
        this.idfa = "";
        this.iOperTimes = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiUin = jceInputStream.read(this.uiUin, 0, true);
        this.sQBosstrace = jceInputStream.readString(1, true);
        this.iOperType = jceInputStream.read(this.iOperType, 2, true);
        this.iOperSource = jceInputStream.read(this.iOperSource, 3, false);
        this.sQua = jceInputStream.readString(4, false);
        this.sUserID = jceInputStream.readString(5, false);
        this.idfa = jceInputStream.readString(6, false);
        this.iOperTimes = jceInputStream.read(this.iOperTimes, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiUin, 0);
        jceOutputStream.write(this.sQBosstrace, 1);
        jceOutputStream.write(this.iOperType, 2);
        jceOutputStream.write(this.iOperSource, 3);
        String str = this.sQua;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.sUserID;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.idfa;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.iOperTimes, 7);
    }

    public tMobileQbossFeedBackInfo(long j3, String str, int i3, int i16, String str2, String str3, String str4, int i17) {
        this.uiUin = j3;
        this.sQBosstrace = str;
        this.iOperType = i3;
        this.iOperSource = i16;
        this.sQua = str2;
        this.sUserID = str3;
        this.idfa = str4;
        this.iOperTimes = i17;
    }
}
