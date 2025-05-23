package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_like_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_bypass_param;
    static Map<String, byte[]> cache_bypass_param_binary;
    static Map<Integer, String> cache_extern_param;
    public int action;
    public int appid;
    public Map<Integer, String> busi_param;
    public Map<String, String> bypass_param;
    public Map<String, byte[]> bypass_param_binary;
    public String curkey;
    public Map<Integer, String> extern_param;
    public long hostuin;
    public long uin;
    public String unikey;

    static {
        cache_busi_param.put(0, "");
        cache_extern_param = new HashMap();
        cache_extern_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_bypass_param = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_bypass_param_binary = hashMap2;
        hashMap2.put("", new byte[]{0});
    }

    public operation_like_req() {
        this.uin = 0L;
        this.curkey = "";
        this.unikey = "";
        this.action = 0;
        this.appid = 0;
        this.busi_param = null;
        this.hostuin = 0L;
        this.extern_param = null;
        this.bypass_param = null;
        this.bypass_param_binary = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.curkey = jceInputStream.readString(1, false);
        this.unikey = jceInputStream.readString(2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.appid = jceInputStream.read(this.appid, 4, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 5, false);
        this.hostuin = jceInputStream.read(this.hostuin, 6, false);
        this.extern_param = (Map) jceInputStream.read((JceInputStream) cache_extern_param, 7, false);
        this.bypass_param = (Map) jceInputStream.read((JceInputStream) cache_bypass_param, 8, false);
        this.bypass_param_binary = (Map) jceInputStream.read((JceInputStream) cache_bypass_param_binary, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.curkey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.unikey;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.action, 3);
        jceOutputStream.write(this.appid, 4);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.hostuin, 6);
        Map<Integer, String> map2 = this.extern_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 7);
        }
        Map<String, String> map3 = this.bypass_param;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 8);
        }
        Map<String, byte[]> map4 = this.bypass_param_binary;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 9);
        }
    }

    public operation_like_req(long j3, String str, String str2, int i3, int i16, Map<Integer, String> map, long j16, Map<Integer, String> map2, Map<String, String> map3, Map<String, byte[]> map4) {
        this.uin = j3;
        this.curkey = str;
        this.unikey = str2;
        this.action = i3;
        this.appid = i16;
        this.busi_param = map;
        this.hostuin = j16;
        this.extern_param = map2;
        this.bypass_param = map3;
        this.bypass_param_binary = map4;
    }
}
