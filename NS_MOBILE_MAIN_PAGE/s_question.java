package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_question extends JceStruct {
    public String qustion1;
    public String qustion2;
    public String qustion3;
    public String result1;
    public String result2;
    public String result3;

    public s_question() {
        this.qustion1 = "";
        this.qustion2 = "";
        this.qustion3 = "";
        this.result1 = "";
        this.result2 = "";
        this.result3 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qustion1 = jceInputStream.readString(0, false);
        this.qustion2 = jceInputStream.readString(1, false);
        this.qustion3 = jceInputStream.readString(2, false);
        this.result1 = jceInputStream.readString(3, false);
        this.result2 = jceInputStream.readString(4, false);
        this.result3 = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.qustion1;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.qustion2;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.qustion3;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.result1;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.result2;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.result3;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
    }

    public s_question(String str, String str2, String str3, String str4, String str5, String str6) {
        this.qustion1 = str;
        this.qustion2 = str2;
        this.qustion3 = str3;
        this.result1 = str4;
        this.result2 = str5;
        this.result3 = str6;
    }
}
