package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetMiniAppReq extends JceStruct {
    public static final int ACTION_GET_SHARE_PIC_UPLOAD_URL = 6;
    public static final int ACTION_GET_SYSTEM_LOG_UPLOAD_URL = 4;
    public static final int ACTION_GET_USER_LOG_UPLOAD_URL = 5;
    public static final int ACTION_NORMAL_GET_INFO = 0;
    public static final int ACTION_QQ_SCAN_CODE = 1;
    public static final int ACTION_WX_SCAN_CODE = 2;
    public int action;
    public String extra_keys;
    public String mini_appid;
    public int mini_version;
    public String platform;
    public String qq_version;
    public String uin;

    public GetMiniAppReq() {
        this.mini_appid = "";
        this.uin = "";
        this.mini_version = 0;
        this.platform = "";
        this.qq_version = "";
        this.action = 0;
        this.extra_keys = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mini_appid = jceInputStream.readString(0, false);
        this.uin = jceInputStream.readString(1, false);
        this.mini_version = jceInputStream.read(this.mini_version, 2, false);
        this.platform = jceInputStream.readString(3, false);
        this.qq_version = jceInputStream.readString(4, false);
        this.action = jceInputStream.read(this.action, 5, false);
        this.extra_keys = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "GetMiniAppReq{mini_appid='" + this.mini_appid + "', uin='" + this.uin + "', mini_version=" + this.mini_version + ", platform='" + this.platform + "', qq_version='" + this.qq_version + "', action=" + this.action + ", extra_keys='" + this.extra_keys + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.mini_appid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.uin;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.mini_version, 2);
        String str3 = this.platform;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.qq_version;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.action, 5);
        String str5 = this.extra_keys;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
    }

    public GetMiniAppReq(String str, int i3, int i16, String str2, String str3, String str4, String str5) {
        this.mini_appid = str;
        this.uin = str3;
        this.mini_version = i3;
        this.platform = str4;
        this.qq_version = str5;
        this.action = i16;
        this.extra_keys = str2;
    }
}
