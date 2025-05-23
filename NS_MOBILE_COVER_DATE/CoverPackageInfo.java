package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CoverPackageInfo extends JceStruct {
    static int cache_coverStyle;
    static int cache_weather;
    public String PackageUrl;
    public int coverStyle;
    public short daytime;
    public String md5;
    public String prePic;
    public int weather;

    public CoverPackageInfo() {
        this.prePic = "";
        this.PackageUrl = "";
        this.md5 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.prePic = jceInputStream.readString(0, false);
        this.PackageUrl = jceInputStream.readString(1, false);
        this.md5 = jceInputStream.readString(2, false);
        this.weather = jceInputStream.read(this.weather, 3, false);
        this.daytime = jceInputStream.read(this.daytime, 4, false);
        this.coverStyle = jceInputStream.read(this.coverStyle, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.prePic;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.PackageUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.md5;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.weather, 3);
        jceOutputStream.write(this.daytime, 4);
        jceOutputStream.write(this.coverStyle, 5);
    }

    public CoverPackageInfo(String str, String str2, String str3, int i3, short s16, int i16) {
        this.prePic = str;
        this.PackageUrl = str2;
        this.md5 = str3;
        this.weather = i3;
        this.daytime = s16;
        this.coverStyle = i16;
    }
}
