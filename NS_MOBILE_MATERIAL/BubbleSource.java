package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BubbleSource extends JceStruct {
    public String strAndUrl1;
    public String strAndUrl2;
    public String strIosUrl1;
    public String strIosUrl2;
    public String strTextColor1;
    public String strTextColor2;

    public BubbleSource() {
        this.strTextColor1 = "";
        this.strTextColor2 = "";
        this.strAndUrl1 = "";
        this.strAndUrl2 = "";
        this.strIosUrl1 = "";
        this.strIosUrl2 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strTextColor1 = jceInputStream.readString(0, false);
        this.strTextColor2 = jceInputStream.readString(1, false);
        this.strAndUrl1 = jceInputStream.readString(2, false);
        this.strAndUrl2 = jceInputStream.readString(3, false);
        this.strIosUrl1 = jceInputStream.readString(4, false);
        this.strIosUrl2 = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strTextColor1;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strTextColor2;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strAndUrl1;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.strAndUrl2;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.strIosUrl1;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.strIosUrl2;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
    }

    public BubbleSource(String str, String str2, String str3, String str4, String str5, String str6) {
        this.strTextColor1 = str;
        this.strTextColor2 = str2;
        this.strAndUrl1 = str3;
        this.strAndUrl2 = str4;
        this.strIosUrl1 = str5;
        this.strIosUrl2 = str6;
    }
}
