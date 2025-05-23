package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GameLogoUrl extends JceStruct {
    public String sAppid;
    public String sGameName;
    public String sLogoMd5;
    public String sLogoName;

    public GameLogoUrl() {
        this.sLogoMd5 = "";
        this.sLogoName = "";
        this.sAppid = "";
        this.sGameName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sLogoMd5 = jceInputStream.readString(0, true);
        this.sLogoName = jceInputStream.readString(1, true);
        this.sAppid = jceInputStream.readString(2, false);
        this.sGameName = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sLogoMd5, 0);
        jceOutputStream.write(this.sLogoName, 1);
        String str = this.sAppid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.sGameName;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public GameLogoUrl(String str, String str2, String str3, String str4) {
        this.sLogoMd5 = str;
        this.sLogoName = str2;
        this.sAppid = str3;
        this.sGameName = str4;
    }
}
