package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ThemeItem extends JceStruct {
    static ArrayList<String> cache_vecPreUrls;
    public String strDescription;
    public String strH5;
    public String strMd5;
    public String strPackageUrl;
    public String strSubThumbUrl;
    public String strThemeId;
    public String strThemeName;
    public String strThumbUrl;
    public String strVer;
    public long uIsFree;
    public long uIsNew;
    public long uIsVip;
    public long uSize;
    public ArrayList<String> vecPreUrls;

    public ThemeItem() {
        this.strThemeId = "";
        this.strThemeName = "";
        this.strMd5 = "";
        this.strVer = "";
        this.strPackageUrl = "";
        this.strThumbUrl = "";
        this.strSubThumbUrl = "";
        this.strH5 = "";
        this.strDescription = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strThemeId = jceInputStream.readString(0, false);
        this.strThemeName = jceInputStream.readString(1, false);
        this.strMd5 = jceInputStream.readString(2, false);
        this.strVer = jceInputStream.readString(3, false);
        this.uIsVip = jceInputStream.read(this.uIsVip, 4, false);
        this.uIsFree = jceInputStream.read(this.uIsFree, 5, false);
        this.uSize = jceInputStream.read(this.uSize, 6, false);
        if (cache_vecPreUrls == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vecPreUrls = arrayList;
            arrayList.add("");
        }
        this.vecPreUrls = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPreUrls, 7, false);
        this.strPackageUrl = jceInputStream.readString(8, false);
        this.strThumbUrl = jceInputStream.readString(9, false);
        this.strSubThumbUrl = jceInputStream.readString(10, false);
        this.uIsNew = jceInputStream.read(this.uIsNew, 11, false);
        this.strH5 = jceInputStream.readString(12, false);
        this.strDescription = jceInputStream.readString(13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strThemeId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strThemeName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strMd5;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.strVer;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.uIsVip, 4);
        jceOutputStream.write(this.uIsFree, 5);
        jceOutputStream.write(this.uSize, 6);
        ArrayList<String> arrayList = this.vecPreUrls;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
        String str5 = this.strPackageUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        String str6 = this.strThumbUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        String str7 = this.strSubThumbUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
        jceOutputStream.write(this.uIsNew, 11);
        String str8 = this.strH5;
        if (str8 != null) {
            jceOutputStream.write(str8, 12);
        }
        String str9 = this.strDescription;
        if (str9 != null) {
            jceOutputStream.write(str9, 13);
        }
    }

    public ThemeItem(String str, String str2, String str3, String str4, long j3, long j16, long j17, ArrayList<String> arrayList, String str5, String str6, String str7, long j18, String str8, String str9) {
        this.strThemeId = str;
        this.strThemeName = str2;
        this.strMd5 = str3;
        this.strVer = str4;
        this.uIsVip = j3;
        this.uIsFree = j16;
        this.uSize = j17;
        this.vecPreUrls = arrayList;
        this.strPackageUrl = str5;
        this.strThumbUrl = str6;
        this.strSubThumbUrl = str7;
        this.uIsNew = j18;
        this.strH5 = str8;
        this.strDescription = str9;
    }
}
