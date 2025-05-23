package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CGetChiefReq extends JceStruct {
    static Map<String, String> cache_mParams;
    static LoginInfo cache_stLogin = new LoginInfo();
    public int appid;
    public long lUid;
    public int locationtype;
    public Map<String, String> mParams;
    public LoginInfo stLogin;

    static {
        HashMap hashMap = new HashMap();
        cache_mParams = hashMap;
        hashMap.put("", "");
    }

    public CGetChiefReq() {
        this.stLogin = null;
        this.appid = 0;
        this.locationtype = 0;
        this.lUid = 0L;
        this.mParams = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.locationtype = jceInputStream.read(this.locationtype, 2, false);
        this.lUid = jceInputStream.read(this.lUid, 3, false);
        this.mParams = (Map) jceInputStream.read((JceInputStream) cache_mParams, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.locationtype, 2);
        jceOutputStream.write(this.lUid, 3);
        Map<String, String> map = this.mParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public CGetChiefReq(LoginInfo loginInfo, int i3, int i16, long j3, Map<String, String> map) {
        this.stLogin = loginInfo;
        this.appid = i3;
        this.locationtype = i16;
        this.lUid = j3;
        this.mParams = map;
    }
}
