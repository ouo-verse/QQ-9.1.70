package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stAD extends JceStruct {
    public int appid;
    public String content;
    public String coverUrl;
    public boolean isUpdated;
    public int mode;
    public int onOff;
    public String packageUrl;
    public int packageVersion;
    public int positionId;
    public String title;
    public int version;
    public String wmId;
    public String wmPackageUrl;

    public stAD() {
        this.appid = 0;
        this.positionId = 0;
        this.mode = 0;
        this.isUpdated = true;
        this.onOff = 0;
        this.coverUrl = "";
        this.title = "";
        this.content = "";
        this.wmId = "";
        this.wmPackageUrl = "";
        this.packageUrl = "";
        this.packageVersion = 0;
        this.version = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, true);
        this.positionId = jceInputStream.read(this.positionId, 1, true);
        this.mode = jceInputStream.read(this.mode, 2, true);
        this.isUpdated = jceInputStream.read(this.isUpdated, 3, true);
        this.onOff = jceInputStream.read(this.onOff, 4, true);
        this.coverUrl = jceInputStream.readString(5, true);
        this.title = jceInputStream.readString(6, true);
        this.content = jceInputStream.readString(7, true);
        this.wmId = jceInputStream.readString(8, false);
        this.wmPackageUrl = jceInputStream.readString(9, false);
        this.packageUrl = jceInputStream.readString(10, false);
        this.packageVersion = jceInputStream.read(this.packageVersion, 11, false);
        this.version = jceInputStream.read(this.version, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.positionId, 1);
        jceOutputStream.write(this.mode, 2);
        jceOutputStream.write(this.isUpdated, 3);
        jceOutputStream.write(this.onOff, 4);
        jceOutputStream.write(this.coverUrl, 5);
        jceOutputStream.write(this.title, 6);
        jceOutputStream.write(this.content, 7);
        String str = this.wmId;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        String str2 = this.wmPackageUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        String str3 = this.packageUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        jceOutputStream.write(this.packageVersion, 11);
        jceOutputStream.write(this.version, 12);
    }

    public stAD(int i3, int i16, int i17, boolean z16, int i18, String str, String str2, String str3, String str4, String str5, String str6, int i19, int i26) {
        this.appid = i3;
        this.positionId = i16;
        this.mode = i17;
        this.isUpdated = z16;
        this.onOff = i18;
        this.coverUrl = str;
        this.title = str2;
        this.content = str3;
        this.wmId = str4;
        this.wmPackageUrl = str5;
        this.packageUrl = str6;
        this.packageVersion = i19;
        this.version = i26;
    }
}
