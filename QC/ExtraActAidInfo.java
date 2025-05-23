package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ExtraActAidInfo extends JceStruct {
    public String androidAid;
    public String errMsg;
    public String iosAid;
    public String month;
    public String payType;

    public ExtraActAidInfo() {
        this.androidAid = "";
        this.iosAid = "";
        this.payType = "";
        this.month = "";
        this.errMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.androidAid = jceInputStream.readString(1, false);
        this.iosAid = jceInputStream.readString(2, false);
        this.payType = jceInputStream.readString(3, false);
        this.month = jceInputStream.readString(4, false);
        this.errMsg = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.androidAid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.iosAid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.payType;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.month;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.errMsg;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }

    public ExtraActAidInfo(String str, String str2, String str3, String str4, String str5) {
        this.androidAid = str;
        this.iosAid = str2;
        this.payType = str3;
        this.month = str4;
        this.errMsg = str5;
    }
}
