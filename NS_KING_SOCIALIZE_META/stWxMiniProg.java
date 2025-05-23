package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stWxMiniProg extends JceStruct {
    public String appThumbUrl;
    public String appid;
    public String hdImageDataURL;
    public int miniProgramType;
    public String path;
    public String userName;
    public int videoCoverHeight;
    public int videoCoverWidth;
    public String videoSource;
    public String videoUserName;
    public String webpageUrl;
    public int withShareTicket;

    public stWxMiniProg() {
        this.webpageUrl = "";
        this.userName = "";
        this.path = "";
        this.hdImageDataURL = "";
        this.withShareTicket = 0;
        this.miniProgramType = 0;
        this.appid = "";
        this.videoUserName = "";
        this.videoSource = "";
        this.videoCoverWidth = 0;
        this.videoCoverHeight = 0;
        this.appThumbUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.webpageUrl = jceInputStream.readString(0, false);
        this.userName = jceInputStream.readString(1, false);
        this.path = jceInputStream.readString(2, false);
        this.hdImageDataURL = jceInputStream.readString(3, false);
        this.withShareTicket = jceInputStream.read(this.withShareTicket, 4, false);
        this.miniProgramType = jceInputStream.read(this.miniProgramType, 5, false);
        this.appid = jceInputStream.readString(6, false);
        this.videoUserName = jceInputStream.readString(7, false);
        this.videoSource = jceInputStream.readString(8, false);
        this.videoCoverWidth = jceInputStream.read(this.videoCoverWidth, 9, false);
        this.videoCoverHeight = jceInputStream.read(this.videoCoverHeight, 10, false);
        this.appThumbUrl = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.webpageUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.userName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.path;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.hdImageDataURL;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.withShareTicket, 4);
        jceOutputStream.write(this.miniProgramType, 5);
        String str5 = this.appid;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.videoUserName;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.videoSource;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        jceOutputStream.write(this.videoCoverWidth, 9);
        jceOutputStream.write(this.videoCoverHeight, 10);
        String str8 = this.appThumbUrl;
        if (str8 != null) {
            jceOutputStream.write(str8, 11);
        }
    }

    public stWxMiniProg(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, int i17, int i18, String str8) {
        this.webpageUrl = str;
        this.userName = str2;
        this.path = str3;
        this.hdImageDataURL = str4;
        this.withShareTicket = i3;
        this.miniProgramType = i16;
        this.appid = str5;
        this.videoUserName = str6;
        this.videoSource = str7;
        this.videoCoverWidth = i17;
        this.videoCoverHeight = i18;
        this.appThumbUrl = str8;
    }
}
