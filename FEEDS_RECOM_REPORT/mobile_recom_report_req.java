package FEEDS_RECOM_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_recom_report_req extends JceStruct {
    static int cache_op_module;
    static int cache_op_type;
    static ArrayList<String> cache_vec_record_cookie;
    public String cookie;
    public short feeds_type;
    public int op_module;
    public int op_type;
    public int position_index;
    public long uin;
    public ArrayList<String> vec_record_cookie;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vec_record_cookie = arrayList;
        arrayList.add("");
    }

    public mobile_recom_report_req() {
        this.cookie = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.op_module = jceInputStream.read(this.op_module, 1, false);
        this.feeds_type = jceInputStream.read(this.feeds_type, 2, false);
        this.position_index = jceInputStream.read(this.position_index, 3, false);
        this.op_type = jceInputStream.read(this.op_type, 4, false);
        this.cookie = jceInputStream.readString(5, false);
        this.vec_record_cookie = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_record_cookie, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.op_module, 1);
        jceOutputStream.write(this.feeds_type, 2);
        jceOutputStream.write(this.position_index, 3);
        jceOutputStream.write(this.op_type, 4);
        String str = this.cookie;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        ArrayList<String> arrayList = this.vec_record_cookie;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
    }

    public mobile_recom_report_req(long j3, int i3, short s16, int i16, int i17, String str, ArrayList<String> arrayList) {
        this.uin = j3;
        this.op_module = i3;
        this.feeds_type = s16;
        this.position_index = i16;
        this.op_type = i17;
        this.cookie = str;
        this.vec_record_cookie = arrayList;
    }
}
