package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class showdrying_taginfo extends JceStruct {
    public int iTagType;
    public String strContent;
    public String strIcon;
    public String strShowInfo;
    public String strUrl;

    public showdrying_taginfo() {
        this.iTagType = 0;
        this.strContent = "";
        this.strIcon = "";
        this.strShowInfo = "";
        this.strUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTagType = jceInputStream.read(this.iTagType, 0, false);
        this.strContent = jceInputStream.readString(1, false);
        this.strIcon = jceInputStream.readString(2, false);
        this.strShowInfo = jceInputStream.readString(3, false);
        this.strUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTagType, 0);
        String str = this.strContent;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strIcon;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strShowInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.strUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public showdrying_taginfo(int i3, String str, String str2, String str3, String str4) {
        this.iTagType = i3;
        this.strContent = str;
        this.strIcon = str2;
        this.strShowInfo = str3;
        this.strUrl = str4;
    }
}
