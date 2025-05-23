package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileControlReq extends JceStruct {
    static byte[] cache_biz_req;
    static Map<String, String> cache_extend_info;
    public String appid;
    public int asy_upload;
    public byte[] biz_req;
    public int check_type;
    public String checksum;
    public Map<Integer, DumpBussinessReq> dumpReq;
    public stEnvironment env;
    public Map<String, String> extend_info;
    public long file_len;
    public int model;
    public boolean need_ip_redirect;
    public String session;
    public long slice_size;
    public AuthToken token;
    public String uin;
    static AuthToken cache_token = new AuthToken();
    static int cache_check_type = 0;
    static stEnvironment cache_env = new stEnvironment();
    static int cache_model = 0;
    static Map<Integer, DumpBussinessReq> cache_dumpReq = new HashMap();

    static {
        cache_biz_req = r1;
        byte[] bArr = {0};
        cache_dumpReq.put(0, new DumpBussinessReq());
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public FileControlReq() {
        this.uin = "";
        this.token = null;
        this.appid = "";
        this.checksum = "";
        this.check_type = 0;
        this.file_len = 0L;
        this.env = null;
        this.model = 0;
        this.biz_req = null;
        this.session = "";
        this.need_ip_redirect = false;
        this.asy_upload = 0;
        this.dumpReq = null;
        this.slice_size = 0L;
        this.extend_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, true);
        this.token = (AuthToken) jceInputStream.read((JceStruct) cache_token, 1, true);
        this.appid = jceInputStream.readString(2, true);
        this.checksum = jceInputStream.readString(3, true);
        this.check_type = jceInputStream.read(this.check_type, 4, true);
        this.file_len = jceInputStream.read(this.file_len, 5, true);
        this.env = (stEnvironment) jceInputStream.read((JceStruct) cache_env, 6, false);
        this.model = jceInputStream.read(this.model, 7, false);
        this.biz_req = jceInputStream.read(cache_biz_req, 8, false);
        this.session = jceInputStream.readString(9, false);
        this.need_ip_redirect = jceInputStream.read(this.need_ip_redirect, 10, false);
        this.asy_upload = jceInputStream.read(this.asy_upload, 11, false);
        this.dumpReq = (Map) jceInputStream.read((JceInputStream) cache_dumpReq, 12, false);
        this.slice_size = jceInputStream.read(this.slice_size, 13, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((JceStruct) this.token, 1);
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.checksum, 3);
        jceOutputStream.write(this.check_type, 4);
        jceOutputStream.write(this.file_len, 5);
        stEnvironment stenvironment = this.env;
        if (stenvironment != null) {
            jceOutputStream.write((JceStruct) stenvironment, 6);
        }
        jceOutputStream.write(this.model, 7);
        byte[] bArr = this.biz_req;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
        String str = this.session;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.need_ip_redirect, 10);
        jceOutputStream.write(this.asy_upload, 11);
        Map<Integer, DumpBussinessReq> map = this.dumpReq;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
        jceOutputStream.write(this.slice_size, 13);
        Map<String, String> map2 = this.extend_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 14);
        }
    }

    public FileControlReq(String str, AuthToken authToken, String str2, String str3, int i3, long j3, stEnvironment stenvironment, int i16, byte[] bArr, String str4, boolean z16, int i17, Map<Integer, DumpBussinessReq> map, long j16, Map<String, String> map2) {
        this.uin = str;
        this.token = authToken;
        this.appid = str2;
        this.checksum = str3;
        this.check_type = i3;
        this.file_len = j3;
        this.env = stenvironment;
        this.model = i16;
        this.biz_req = bArr;
        this.session = str4;
        this.need_ip_redirect = z16;
        this.asy_upload = i17;
        this.dumpReq = map;
        this.slice_size = j16;
        this.extend_info = map2;
    }
}
