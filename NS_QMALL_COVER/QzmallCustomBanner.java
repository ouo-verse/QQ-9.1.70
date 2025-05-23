package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallCustomBanner extends JceStruct {
    static BannerStyleConf cache_stBannerStyle = new BannerStyleConf();
    public int iBannerConfType;
    public int iBannerType;
    public BannerStyleConf stBannerStyle;
    public String strBannerUrl;
    public String strJumpUrl;
    public String strQbossTraceinfo;

    public QzmallCustomBanner() {
        this.iBannerType = 0;
        this.strBannerUrl = "";
        this.strJumpUrl = "";
        this.iBannerConfType = 0;
        this.stBannerStyle = null;
        this.strQbossTraceinfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iBannerType = jceInputStream.read(this.iBannerType, 0, false);
        this.strBannerUrl = jceInputStream.readString(1, false);
        this.strJumpUrl = jceInputStream.readString(2, false);
        this.iBannerConfType = jceInputStream.read(this.iBannerConfType, 3, false);
        this.stBannerStyle = (BannerStyleConf) jceInputStream.read((JceStruct) cache_stBannerStyle, 4, false);
        this.strQbossTraceinfo = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iBannerType, 0);
        String str = this.strBannerUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.iBannerConfType, 3);
        BannerStyleConf bannerStyleConf = this.stBannerStyle;
        if (bannerStyleConf != null) {
            jceOutputStream.write((JceStruct) bannerStyleConf, 4);
        }
        String str3 = this.strQbossTraceinfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public QzmallCustomBanner(int i3, String str, String str2, int i16, BannerStyleConf bannerStyleConf, String str3) {
        this.iBannerType = i3;
        this.strBannerUrl = str;
        this.strJumpUrl = str2;
        this.iBannerConfType = i16;
        this.stBannerStyle = bannerStyleConf;
        this.strQbossTraceinfo = str3;
    }
}
