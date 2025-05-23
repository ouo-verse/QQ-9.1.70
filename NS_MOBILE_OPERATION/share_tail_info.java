package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class share_tail_info extends JceStruct {
    public String strButtonText;
    public String strButtonURL;
    public String strIconUrl;
    public String strTailSummary;
    public String strTailTitle;

    public share_tail_info() {
        this.strTailTitle = "";
        this.strTailSummary = "";
        this.strButtonText = "";
        this.strButtonURL = "";
        this.strIconUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strTailTitle = jceInputStream.readString(0, false);
        this.strTailSummary = jceInputStream.readString(1, false);
        this.strButtonText = jceInputStream.readString(2, false);
        this.strButtonURL = jceInputStream.readString(3, false);
        this.strIconUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strTailTitle;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strTailSummary;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strButtonText;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.strButtonURL;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.strIconUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }

    public share_tail_info(String str, String str2, String str3, String str4, String str5) {
        this.strTailTitle = str;
        this.strTailSummary = str2;
        this.strButtonText = str3;
        this.strButtonURL = str4;
        this.strIconUrl = str5;
    }
}
