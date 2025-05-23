package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class downloadConfig extends JceStruct {
    public boolean appStoreSwitch;
    public String downloadUrl;
    public boolean enableRock;
    public String packageName;
    public boolean preload;
    public String preloadDownloadUrl;
    public String qqDownloadUrl;
    public int vendorId;
    public int versionCode;

    public downloadConfig() {
        this.preload = false;
        this.appStoreSwitch = false;
        this.packageName = "";
        this.downloadUrl = "";
        this.vendorId = 0;
        this.versionCode = 0;
        this.preloadDownloadUrl = "";
        this.enableRock = false;
        this.qqDownloadUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.preload = jceInputStream.read(this.preload, 0, false);
        this.appStoreSwitch = jceInputStream.read(this.appStoreSwitch, 1, false);
        this.packageName = jceInputStream.readString(2, false);
        this.downloadUrl = jceInputStream.readString(3, false);
        this.vendorId = jceInputStream.read(this.vendorId, 4, false);
        this.versionCode = jceInputStream.read(this.versionCode, 5, false);
        this.preloadDownloadUrl = jceInputStream.readString(6, false);
        this.enableRock = jceInputStream.read(this.enableRock, 7, false);
        this.qqDownloadUrl = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "downloadConfig {preload=" + this.preload + ", appStoreSwitch=" + this.appStoreSwitch + ", packageName='" + this.packageName + "', downloadUrl='" + this.downloadUrl + "', vendorId=" + this.vendorId + ", versionCode=" + this.versionCode + ", preloadDownloadUrl='" + this.preloadDownloadUrl + "', enableRock=" + this.enableRock + ", qqDownloadUrl=" + this.qqDownloadUrl + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.preload, 0);
        jceOutputStream.write(this.appStoreSwitch, 1);
        String str = this.packageName;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.downloadUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.vendorId, 4);
        jceOutputStream.write(this.versionCode, 5);
        String str3 = this.preloadDownloadUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.enableRock, 7);
        String str4 = this.qqDownloadUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
    }

    public downloadConfig(boolean z16, boolean z17, String str, String str2, int i3, int i16, String str3, boolean z18, String str4) {
        this.preload = z16;
        this.appStoreSwitch = z17;
        this.packageName = str;
        this.downloadUrl = str2;
        this.vendorId = i3;
        this.versionCode = i16;
        this.preloadDownloadUrl = str3;
        this.enableRock = z18;
        this.qqDownloadUrl = str4;
    }
}
