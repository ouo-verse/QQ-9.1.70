package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileUploadReq extends JceStruct {
    static int cache_check_type;
    static byte[] cache_data;
    static int cache_data_type;
    static Map<String, String> cache_extend_info;
    public String appid;
    public int check_type;
    public String checksum;
    public byte[] data;
    public int data_type;
    public Map<String, String> extend_info;
    public long offset;
    public long send_time;
    public String session;
    public String uin;

    static {
        cache_data = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public FileUploadReq() {
        this.uin = "";
        this.appid = "";
        this.session = "";
        this.offset = 0L;
        this.data = null;
        this.checksum = "";
        this.check_type = 0;
        this.send_time = 0L;
        this.data_type = 0;
        this.extend_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, true);
        this.appid = jceInputStream.readString(1, true);
        this.session = jceInputStream.readString(2, true);
        this.offset = jceInputStream.read(this.offset, 3, true);
        this.data = jceInputStream.read(cache_data, 4, true);
        this.checksum = jceInputStream.readString(5, false);
        this.check_type = jceInputStream.read(this.check_type, 6, false);
        this.send_time = jceInputStream.read(this.send_time, 7, false);
        this.data_type = jceInputStream.read(this.data_type, 8, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.appid, 1);
        jceOutputStream.write(this.session, 2);
        jceOutputStream.write(this.offset, 3);
        jceOutputStream.write(this.data, 4);
        String str = this.checksum;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.check_type, 6);
        jceOutputStream.write(this.send_time, 7);
        jceOutputStream.write(this.data_type, 8);
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
    }

    public FileUploadReq(String str, String str2, String str3, long j3, byte[] bArr, String str4, int i3, long j16, int i16, Map<String, String> map) {
        this.uin = str;
        this.appid = str2;
        this.session = str3;
        this.offset = j3;
        this.data = bArr;
        this.checksum = str4;
        this.check_type = i3;
        this.send_time = j16;
        this.data_type = i16;
        this.extend_info = map;
    }
}
