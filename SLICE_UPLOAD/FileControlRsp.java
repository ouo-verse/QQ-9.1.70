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
public final class FileControlRsp extends JceStruct {
    static byte[] cache_biz_rsp;
    static Map<Integer, DumpBussinessRsp> cache_dumpRsp;
    public byte[] biz_rsp;
    public Map<Integer, DumpBussinessRsp> dumpRsp;
    public long offset;
    public ArrayList<stOffset> offset_list;
    public String redirect_ip;
    public stResult result;
    public String session;
    public long slice_size;
    public int thread_num;
    static stResult cache_result = new stResult();
    static ArrayList<stOffset> cache_offset_list = new ArrayList<>();

    static {
        cache_biz_rsp = r0;
        byte[] bArr = {0};
        cache_offset_list.add(new stOffset());
        cache_dumpRsp = new HashMap();
        cache_dumpRsp.put(0, new DumpBussinessRsp());
    }

    public FileControlRsp() {
        this.result = null;
        this.session = "";
        this.offset = 0L;
        this.slice_size = 0L;
        this.biz_rsp = null;
        this.offset_list = null;
        this.redirect_ip = "";
        this.thread_num = 1;
        this.dumpRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = (stResult) jceInputStream.read((JceStruct) cache_result, 1, true);
        this.session = jceInputStream.readString(2, false);
        this.offset = jceInputStream.read(this.offset, 3, false);
        this.slice_size = jceInputStream.read(this.slice_size, 4, false);
        this.biz_rsp = jceInputStream.read(cache_biz_rsp, 5, false);
        this.offset_list = (ArrayList) jceInputStream.read((JceInputStream) cache_offset_list, 6, false);
        this.redirect_ip = jceInputStream.readString(7, false);
        this.thread_num = jceInputStream.read(this.thread_num, 8, false);
        this.dumpRsp = (Map) jceInputStream.read((JceInputStream) cache_dumpRsp, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.result, 1);
        String str = this.session;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.offset, 3);
        jceOutputStream.write(this.slice_size, 4);
        byte[] bArr = this.biz_rsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        ArrayList<stOffset> arrayList = this.offset_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        String str2 = this.redirect_ip;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        jceOutputStream.write(this.thread_num, 8);
        Map<Integer, DumpBussinessRsp> map = this.dumpRsp;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
    }

    public FileControlRsp(stResult stresult, String str, long j3, long j16, byte[] bArr, ArrayList<stOffset> arrayList, String str2, int i3, Map<Integer, DumpBussinessRsp> map) {
        this.result = stresult;
        this.session = str;
        this.offset = j3;
        this.slice_size = j16;
        this.biz_rsp = bArr;
        this.offset_list = arrayList;
        this.redirect_ip = str2;
        this.thread_num = i3;
        this.dumpRsp = map;
    }
}
