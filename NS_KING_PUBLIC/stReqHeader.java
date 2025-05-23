package NS_KING_PUBLIC;

import android.support.annotation.Nullable;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stReqHeader extends JceStruct {
    static stAuth cache_authInfo = new stAuth();
    static Map<String, String> cache_mapExt;
    private static final long serialVersionUID = 0;
    public int appid;
    public int appversion;

    @Nullable
    public stAuth authInfo;

    @Nullable
    public String device_info;

    @Nullable
    public String h265key;
    public int iAppVersion;
    public int iChid;

    @Nullable
    public Map<String, String> mapExt;

    @Nullable
    public String person_id;

    @Nullable
    public String platform;

    @Nullable
    public String strQua;

    @Nullable
    public String user_ip;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public stReqHeader() {
        this.authInfo = null;
        this.iChid = 0;
        this.person_id = "";
        this.platform = "";
        this.appversion = 0;
        this.user_ip = "";
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.authInfo = (stAuth) jceInputStream.read((JceStruct) cache_authInfo, 0, false);
        this.iChid = jceInputStream.read(this.iChid, 1, false);
        this.person_id = jceInputStream.readString(2, false);
        this.platform = jceInputStream.readString(3, false);
        this.appversion = jceInputStream.read(this.appversion, 4, false);
        this.user_ip = jceInputStream.readString(5, false);
        this.strQua = jceInputStream.readString(6, false);
        this.device_info = jceInputStream.readString(7, false);
        this.h265key = jceInputStream.readString(8, false);
        this.appid = jceInputStream.read(this.appid, 9, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 10, false);
        this.iAppVersion = jceInputStream.read(this.iAppVersion, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stAuth stauth = this.authInfo;
        if (stauth != null) {
            jceOutputStream.write((JceStruct) stauth, 0);
        }
        jceOutputStream.write(this.iChid, 1);
        String str = this.person_id;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.platform;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.appversion, 4);
        String str3 = this.user_ip;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.strQua;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.device_info;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.h265key;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        jceOutputStream.write(this.appid, 9);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
        jceOutputStream.write(this.iAppVersion, 11);
    }

    public stReqHeader(stAuth stauth) {
        this.iChid = 0;
        this.person_id = "";
        this.platform = "";
        this.appversion = 0;
        this.user_ip = "";
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
    }

    public stReqHeader(stAuth stauth, int i3) {
        this.person_id = "";
        this.platform = "";
        this.appversion = 0;
        this.user_ip = "";
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
    }

    public stReqHeader(stAuth stauth, int i3, String str) {
        this.platform = "";
        this.appversion = 0;
        this.user_ip = "";
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2) {
        this.appversion = 0;
        this.user_ip = "";
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16) {
        this.user_ip = "";
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3) {
        this.strQua = "";
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3, String str4) {
        this.device_info = "";
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
        this.strQua = str4;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3, String str4, String str5) {
        this.h265key = "";
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
        this.strQua = str4;
        this.device_info = str5;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3, String str4, String str5, String str6) {
        this.appid = 0;
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
        this.strQua = str4;
        this.device_info = str5;
        this.h265key = str6;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3, String str4, String str5, String str6, int i17) {
        this.mapExt = null;
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
        this.strQua = str4;
        this.device_info = str5;
        this.h265key = str6;
        this.appid = i17;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3, String str4, String str5, String str6, int i17, Map<String, String> map) {
        this.iAppVersion = 0;
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
        this.strQua = str4;
        this.device_info = str5;
        this.h265key = str6;
        this.appid = i17;
        this.mapExt = map;
    }

    public stReqHeader(stAuth stauth, int i3, String str, String str2, int i16, String str3, String str4, String str5, String str6, int i17, Map<String, String> map, int i18) {
        this.authInfo = stauth;
        this.iChid = i3;
        this.person_id = str;
        this.platform = str2;
        this.appversion = i16;
        this.user_ip = str3;
        this.strQua = str4;
        this.device_info = str5;
        this.h265key = str6;
        this.appid = i17;
        this.mapExt = map;
        this.iAppVersion = i18;
    }
}
