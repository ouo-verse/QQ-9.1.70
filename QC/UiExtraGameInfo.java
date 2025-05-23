package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UiExtraGameInfo extends JceStruct {
    public long gameappid;
    public String gameappname;
    public String gamepkgname;
    public String gamevia;
    public String loginurl;

    public UiExtraGameInfo() {
        this.gameappid = 0L;
        this.loginurl = "";
        this.gamevia = "";
        this.gamepkgname = "";
        this.gameappname = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.gameappid = jceInputStream.read(this.gameappid, 0, false);
        this.loginurl = jceInputStream.readString(1, false);
        this.gamevia = jceInputStream.readString(2, false);
        this.gamepkgname = jceInputStream.readString(3, false);
        this.gameappname = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.gameappid, 0);
        String str = this.loginurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.gamevia;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.gamepkgname;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.gameappname;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public UiExtraGameInfo(long j3, String str, String str2, String str3, String str4) {
        this.gameappid = j3;
        this.loginurl = str;
        this.gamevia = str2;
        this.gamepkgname = str3;
        this.gameappname = str4;
    }
}
