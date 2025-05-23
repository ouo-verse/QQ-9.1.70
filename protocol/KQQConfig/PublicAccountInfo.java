package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes29.dex */
public final class PublicAccountInfo extends JceStruct {
    public String strContent;
    public String strLinkURL;
    public String strNeighborContent;
    public String strPicURL;
    public String strTitle;

    public PublicAccountInfo() {
        this.strPicURL = "";
        this.strLinkURL = "";
        this.strTitle = "";
        this.strContent = "";
        this.strNeighborContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPicURL = jceInputStream.readString(1, false);
        this.strLinkURL = jceInputStream.readString(2, false);
        this.strTitle = jceInputStream.readString(3, false);
        this.strContent = jceInputStream.readString(4, false);
        this.strNeighborContent = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strPicURL;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strLinkURL;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.strContent;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.strNeighborContent;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }

    public PublicAccountInfo(String str, String str2, String str3, String str4, String str5) {
        this.strPicURL = str;
        this.strLinkURL = str2;
        this.strTitle = str3;
        this.strContent = str4;
        this.strNeighborContent = str5;
    }
}
