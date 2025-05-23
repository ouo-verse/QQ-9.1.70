package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSuixintieSigFontReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    public int appid;
    public int itemid;
    public LoginInfo stLogin;
    public String strAttachInfo;
    public String strSeesionID;

    public GetSuixintieSigFontReq() {
        this.stLogin = null;
        this.appid = 0;
        this.itemid = 0;
        this.strSeesionID = "";
        this.strAttachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.itemid = jceInputStream.read(this.itemid, 2, false);
        this.strSeesionID = jceInputStream.readString(3, false);
        this.strAttachInfo = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.itemid, 2);
        String str = this.strSeesionID;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strAttachInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public GetSuixintieSigFontReq(LoginInfo loginInfo, int i3, int i16, String str, String str2) {
        this.stLogin = loginInfo;
        this.appid = i3;
        this.itemid = i16;
        this.strSeesionID = str;
        this.strAttachInfo = str2;
    }
}
