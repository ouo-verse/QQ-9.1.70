package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BannerStyleConf extends JceStruct {
    public String strButtonText;
    public String strIconUrl;
    public String strText;

    public BannerStyleConf() {
        this.strIconUrl = "";
        this.strText = "";
        this.strButtonText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strIconUrl = jceInputStream.readString(0, false);
        this.strText = jceInputStream.readString(1, false);
        this.strButtonText = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strIconUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strText;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strButtonText;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public BannerStyleConf(String str, String str2, String str3) {
        this.strIconUrl = str;
        this.strText = str2;
        this.strButtonText = str3;
    }
}
