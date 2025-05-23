package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSongInfo extends JceStruct {
    public int copyright;
    public int iIsOnly;
    public int iPlayTime;
    public int iPlayable;
    public int iSize;
    public int iSizeHq;
    public int iSizeSq;
    public int iSizeStandard;
    public int iSource;
    public int iTryBegin;
    public int iTryEnd;
    public int iTrySize;
    public String strGenre;
    public String strH5Url;
    public String strLanguage;
    public String strMid;
    public String strName;
    public String strPlayUrl;
    public String strPlayUrlHq;
    public String strPlayUrlSq;
    public String strPlayUrlStandard;
    public long uiId;

    public stSongInfo() {
        this.uiId = 0L;
        this.strMid = "";
        this.strName = "";
        this.strGenre = "";
        this.iIsOnly = 0;
        this.strLanguage = "";
        this.iPlayable = 0;
        this.iTrySize = 0;
        this.iTryBegin = 0;
        this.iTryEnd = 0;
        this.iPlayTime = 0;
        this.strH5Url = "";
        this.strPlayUrl = "";
        this.strPlayUrlStandard = "";
        this.strPlayUrlHq = "";
        this.strPlayUrlSq = "";
        this.iSize = 0;
        this.iSizeStandard = 0;
        this.iSizeHq = 0;
        this.iSizeSq = 0;
        this.copyright = 0;
        this.iSource = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiId = jceInputStream.read(this.uiId, 0, false);
        this.strMid = jceInputStream.readString(1, false);
        this.strName = jceInputStream.readString(2, false);
        this.strGenre = jceInputStream.readString(3, false);
        this.iIsOnly = jceInputStream.read(this.iIsOnly, 4, false);
        this.strLanguage = jceInputStream.readString(5, false);
        this.iPlayable = jceInputStream.read(this.iPlayable, 6, false);
        this.iTrySize = jceInputStream.read(this.iTrySize, 7, false);
        this.iTryBegin = jceInputStream.read(this.iTryBegin, 8, false);
        this.iTryEnd = jceInputStream.read(this.iTryEnd, 9, false);
        this.iPlayTime = jceInputStream.read(this.iPlayTime, 10, false);
        this.strH5Url = jceInputStream.readString(11, false);
        this.strPlayUrl = jceInputStream.readString(12, false);
        this.strPlayUrlStandard = jceInputStream.readString(13, false);
        this.strPlayUrlHq = jceInputStream.readString(14, false);
        this.strPlayUrlSq = jceInputStream.readString(15, false);
        this.iSize = jceInputStream.read(this.iSize, 16, false);
        this.iSizeStandard = jceInputStream.read(this.iSizeStandard, 17, false);
        this.iSizeHq = jceInputStream.read(this.iSizeHq, 18, false);
        this.iSizeSq = jceInputStream.read(this.iSizeSq, 19, false);
        this.copyright = jceInputStream.read(this.copyright, 20, false);
        this.iSource = jceInputStream.read(this.iSource, 21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiId, 0);
        String str = this.strMid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strGenre;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.iIsOnly, 4);
        String str4 = this.strLanguage;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.iPlayable, 6);
        jceOutputStream.write(this.iTrySize, 7);
        jceOutputStream.write(this.iTryBegin, 8);
        jceOutputStream.write(this.iTryEnd, 9);
        jceOutputStream.write(this.iPlayTime, 10);
        String str5 = this.strH5Url;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        String str6 = this.strPlayUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        String str7 = this.strPlayUrlStandard;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        String str8 = this.strPlayUrlHq;
        if (str8 != null) {
            jceOutputStream.write(str8, 14);
        }
        String str9 = this.strPlayUrlSq;
        if (str9 != null) {
            jceOutputStream.write(str9, 15);
        }
        jceOutputStream.write(this.iSize, 16);
        jceOutputStream.write(this.iSizeStandard, 17);
        jceOutputStream.write(this.iSizeHq, 18);
        jceOutputStream.write(this.iSizeSq, 19);
        jceOutputStream.write(this.copyright, 20);
        jceOutputStream.write(this.iSource, 21);
    }

    public stSongInfo(long j3, String str, String str2, String str3, int i3, String str4, int i16, int i17, int i18, int i19, int i26, String str5, String str6, String str7, String str8, String str9, int i27, int i28, int i29, int i36, int i37, int i38) {
        this.uiId = j3;
        this.strMid = str;
        this.strName = str2;
        this.strGenre = str3;
        this.iIsOnly = i3;
        this.strLanguage = str4;
        this.iPlayable = i16;
        this.iTrySize = i17;
        this.iTryBegin = i18;
        this.iTryEnd = i19;
        this.iPlayTime = i26;
        this.strH5Url = str5;
        this.strPlayUrl = str6;
        this.strPlayUrlStandard = str7;
        this.strPlayUrlHq = str8;
        this.strPlayUrlSq = str9;
        this.iSize = i27;
        this.iSizeStandard = i28;
        this.iSizeHq = i29;
        this.iSizeSq = i36;
        this.copyright = i37;
        this.iSource = i38;
    }
}
