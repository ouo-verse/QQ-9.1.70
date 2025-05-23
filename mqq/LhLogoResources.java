package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LhLogoResources extends JceStruct {
    public String apngUrl;
    public String backUrl;
    public String lightColor;
    public String logoUrl;
    public String normalColor;

    public LhLogoResources() {
        this.backUrl = "";
        this.apngUrl = "";
        this.logoUrl = "";
        this.normalColor = "";
        this.lightColor = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.backUrl = jceInputStream.readString(0, false);
        this.apngUrl = jceInputStream.readString(1, false);
        this.logoUrl = jceInputStream.readString(2, false);
        this.normalColor = jceInputStream.readString(3, false);
        this.lightColor = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.backUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.apngUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.logoUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.normalColor;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.lightColor;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }

    public LhLogoResources(String str, String str2, String str3, String str4, String str5) {
        this.backUrl = str;
        this.apngUrl = str2;
        this.logoUrl = str3;
        this.normalColor = str4;
        this.lightColor = str5;
    }
}
