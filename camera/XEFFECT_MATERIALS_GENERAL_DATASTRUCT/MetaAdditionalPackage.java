package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class MetaAdditionalPackage extends JceStruct {
    public String highPackageMd5;
    public String highPackageUrl;
    public String lowPackageMd5;
    public String lowPackageUrl;
    public String midPackageMd5;
    public String midPackageUrl;
    public String superLowPackageMd5;
    public String superLowPackageUrl;

    public MetaAdditionalPackage() {
        this.lowPackageUrl = "";
        this.lowPackageMd5 = "";
        this.superLowPackageUrl = "";
        this.superLowPackageMd5 = "";
        this.midPackageUrl = "";
        this.midPackageMd5 = "";
        this.highPackageUrl = "";
        this.highPackageMd5 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lowPackageUrl = jceInputStream.readString(0, false);
        this.lowPackageMd5 = jceInputStream.readString(1, false);
        this.superLowPackageUrl = jceInputStream.readString(2, false);
        this.superLowPackageMd5 = jceInputStream.readString(3, false);
        this.midPackageUrl = jceInputStream.readString(4, false);
        this.midPackageMd5 = jceInputStream.readString(5, false);
        this.highPackageUrl = jceInputStream.readString(6, false);
        this.highPackageMd5 = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.lowPackageUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.lowPackageMd5;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.superLowPackageUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.superLowPackageMd5;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.midPackageUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.midPackageMd5;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.highPackageUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.highPackageMd5;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
    }

    public MetaAdditionalPackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.lowPackageUrl = str;
        this.lowPackageMd5 = str2;
        this.superLowPackageUrl = str3;
        this.superLowPackageMd5 = str4;
        this.midPackageUrl = str5;
        this.midPackageMd5 = str6;
        this.highPackageUrl = str7;
        this.highPackageMd5 = str8;
    }
}
