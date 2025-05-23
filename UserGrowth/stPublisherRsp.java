package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPublisherRsp extends JceStruct {
    static stPublisherGuide cache_guide = new stPublisherGuide();
    public boolean enable;
    public stPublisherGuide guide;
    public String h5Url;
    public String miniAppSchema;
    public boolean newUser;
    public String newsUserText;
    public int noInstallAction;
    public int showGuide;
    public String weishiSchema;

    public stPublisherRsp() {
        this.enable = false;
        this.newUser = false;
        this.newsUserText = "";
        this.weishiSchema = "";
        this.noInstallAction = 0;
        this.guide = null;
        this.miniAppSchema = "";
        this.h5Url = "";
        this.showGuide = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enable = jceInputStream.read(this.enable, 0, false);
        this.newUser = jceInputStream.read(this.newUser, 1, false);
        this.newsUserText = jceInputStream.readString(2, false);
        this.weishiSchema = jceInputStream.readString(3, false);
        this.noInstallAction = jceInputStream.read(this.noInstallAction, 4, false);
        this.guide = (stPublisherGuide) jceInputStream.read((JceStruct) cache_guide, 5, false);
        this.miniAppSchema = jceInputStream.readString(6, false);
        this.h5Url = jceInputStream.readString(7, false);
        this.showGuide = jceInputStream.read(this.showGuide, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enable, 0);
        jceOutputStream.write(this.newUser, 1);
        String str = this.newsUserText;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.weishiSchema;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.noInstallAction, 4);
        stPublisherGuide stpublisherguide = this.guide;
        if (stpublisherguide != null) {
            jceOutputStream.write((JceStruct) stpublisherguide, 5);
        }
        String str3 = this.miniAppSchema;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.h5Url;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.showGuide, 8);
    }

    public stPublisherRsp(boolean z16, boolean z17, String str, String str2, int i3, stPublisherGuide stpublisherguide, String str3, String str4, int i16) {
        this.enable = z16;
        this.newUser = z17;
        this.newsUserText = str;
        this.weishiSchema = str2;
        this.noInstallAction = i3;
        this.guide = stpublisherguide;
        this.miniAppSchema = str3;
        this.h5Url = str4;
        this.showGuide = i16;
    }
}
