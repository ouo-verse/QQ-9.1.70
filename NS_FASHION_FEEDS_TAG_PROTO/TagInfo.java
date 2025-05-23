package NS_FASHION_FEEDS_TAG_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TagInfo extends JceStruct {
    public int iCode;
    public int iTagSource;
    public int iTagType;
    public String strContent1;
    public String strContent2;
    public String strContent3;
    public String strIcon;
    public String strShowContent;
    public String strShowInfo;
    public String strTagId;
    public String strThumbContent;
    public String strUrl;

    public TagInfo() {
        this.iTagType = 0;
        this.strContent1 = "";
        this.strIcon = "";
        this.strShowInfo = "";
        this.strUrl = "";
        this.strContent2 = "";
        this.strContent3 = "";
        this.iTagSource = 0;
        this.strTagId = "";
        this.iCode = 0;
        this.strShowContent = "";
        this.strThumbContent = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTagType = jceInputStream.read(this.iTagType, 0, false);
        this.strContent1 = jceInputStream.readString(1, false);
        this.strIcon = jceInputStream.readString(2, false);
        this.strShowInfo = jceInputStream.readString(3, false);
        this.strUrl = jceInputStream.readString(4, false);
        this.strContent2 = jceInputStream.readString(5, false);
        this.strContent3 = jceInputStream.readString(6, false);
        this.iTagSource = jceInputStream.read(this.iTagSource, 7, false);
        this.strTagId = jceInputStream.readString(8, false);
        this.iCode = jceInputStream.read(this.iCode, 9, false);
        this.strShowContent = jceInputStream.readString(10, false);
        this.strThumbContent = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTagType, 0);
        String str = this.strContent1;
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
        String str5 = this.strContent2;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.strContent3;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        jceOutputStream.write(this.iTagSource, 7);
        String str7 = this.strTagId;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        jceOutputStream.write(this.iCode, 9);
        String str8 = this.strShowContent;
        if (str8 != null) {
            jceOutputStream.write(str8, 10);
        }
        String str9 = this.strThumbContent;
        if (str9 != null) {
            jceOutputStream.write(str9, 11);
        }
    }

    public TagInfo(int i3, String str, String str2, String str3, String str4, String str5, String str6, int i16, String str7, int i17, String str8, String str9) {
        this.iTagType = i3;
        this.strContent1 = str;
        this.strIcon = str2;
        this.strShowInfo = str3;
        this.strUrl = str4;
        this.strContent2 = str5;
        this.strContent3 = str6;
        this.iTagSource = i16;
        this.strTagId = str7;
        this.iCode = i17;
        this.strShowContent = str8;
        this.strThumbContent = str9;
    }
}
