package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileCommitReq extends JceStruct {
    static byte[] cache_biz_req;
    static int cache_check_type;
    static Map<Integer, DumpBussinessReq> cache_dumpReq = new HashMap();
    static ArrayList<String> cache_slice_checksums;
    public String appid;
    public byte[] biz_req;
    public int check_type;
    public String checksum;
    public Map<Integer, DumpBussinessReq> dumpReq;
    public long file_len;
    public String session;
    public ArrayList<String> slice_checksums;
    public String uin;

    static {
        cache_biz_req = r0;
        byte[] bArr = {0};
        cache_dumpReq.put(0, new DumpBussinessReq());
        cache_check_type = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        cache_slice_checksums = arrayList;
        arrayList.add("");
    }

    public FileCommitReq() {
        this.uin = "";
        this.session = "";
        this.biz_req = null;
        this.appid = "";
        this.dumpReq = null;
        this.checksum = "";
        this.check_type = 0;
        this.file_len = 0L;
        this.slice_checksums = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.readString(0, true);
        this.session = jceInputStream.readString(1, true);
        this.biz_req = jceInputStream.read(cache_biz_req, 2, false);
        this.appid = jceInputStream.readString(3, false);
        this.dumpReq = (Map) jceInputStream.read((JceInputStream) cache_dumpReq, 4, false);
        this.checksum = jceInputStream.readString(5, false);
        this.check_type = jceInputStream.read(this.check_type, 6, false);
        this.file_len = jceInputStream.read(this.file_len, 7, false);
        this.slice_checksums = (ArrayList) jceInputStream.read((JceInputStream) cache_slice_checksums, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.session, 1);
        byte[] bArr = this.biz_req;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        String str = this.appid;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<Integer, DumpBussinessReq> map = this.dumpReq;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        String str2 = this.checksum;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.check_type, 6);
        jceOutputStream.write(this.file_len, 7);
        ArrayList<String> arrayList = this.slice_checksums;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
    }

    public FileCommitReq(String str, String str2, byte[] bArr, String str3, Map<Integer, DumpBussinessReq> map, String str4, int i3, long j3, ArrayList<String> arrayList) {
        this.uin = str;
        this.session = str2;
        this.biz_req = bArr;
        this.appid = str3;
        this.dumpReq = map;
        this.checksum = str4;
        this.check_type = i3;
        this.file_len = j3;
        this.slice_checksums = arrayList;
    }
}
