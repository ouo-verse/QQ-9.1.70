package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CGetMoreReq extends JceStruct {
    static Map<String, String> cache_mParams;
    static LoginInfo cache_stLogin = new LoginInfo();
    public int appid;
    public long lUid;
    public int listindex;
    public int locationtype;
    public Map<String, String> mParams;
    public int pagesize;
    public LoginInfo stLogin;

    static {
        HashMap hashMap = new HashMap();
        cache_mParams = hashMap;
        hashMap.put("", "");
    }

    public CGetMoreReq() {
        this.stLogin = null;
        this.appid = 0;
        this.locationtype = 0;
        this.lUid = 0L;
        this.listindex = 0;
        this.pagesize = 0;
        this.mParams = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.appid = jceInputStream.read(this.appid, 1, false);
        this.locationtype = jceInputStream.read(this.locationtype, 2, false);
        this.lUid = jceInputStream.read(this.lUid, 3, false);
        this.listindex = jceInputStream.read(this.listindex, 4, false);
        this.pagesize = jceInputStream.read(this.pagesize, 5, false);
        this.mParams = (Map) jceInputStream.read((JceInputStream) cache_mParams, 6, false);
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
        jceOutputStream.write(this.listindex, 4);
        jceOutputStream.write(this.pagesize, 5);
        Map<String, String> map = this.mParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public CGetMoreReq(LoginInfo loginInfo, int i3, int i16, long j3, int i17, int i18, Map<String, String> map) {
        this.stLogin = loginInfo;
        this.appid = i3;
        this.locationtype = i16;
        this.lUid = j3;
        this.listindex = i17;
        this.pagesize = i18;
        this.mParams = map;
    }
}
