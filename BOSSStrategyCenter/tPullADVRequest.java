package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class tPullADVRequest extends JceStruct {
    static Map<String, String> cache_ext_user_info;
    static ArrayList<tAdvAppInfo> cache_vec_req_app = new ArrayList<>();
    public Map<String, String> ext_user_info;
    public int i_need_expose_time;
    public int i_req_flag;
    public String idfa;
    public String ip_from_pc_user;
    public long l_user;
    public int pull_as_expose_oper;
    public int request_from;
    public String s_phone_qua;
    public String s_req_source;
    public ArrayList<tAdvAppInfo> vec_req_app;

    static {
        cache_vec_req_app.add(new tAdvAppInfo());
        HashMap hashMap = new HashMap();
        cache_ext_user_info = hashMap;
        hashMap.put("", "");
    }

    public tPullADVRequest() {
        this.l_user = 0L;
        this.vec_req_app = null;
        this.s_req_source = "";
        this.s_phone_qua = "";
        this.pull_as_expose_oper = 0;
        this.ip_from_pc_user = "";
        this.request_from = 0;
        this.ext_user_info = null;
        this.i_need_expose_time = 0;
        this.i_req_flag = 0;
        this.idfa = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.l_user = jceInputStream.read(this.l_user, 0, true);
        this.vec_req_app = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_req_app, 1, true);
        this.s_req_source = jceInputStream.readString(2, false);
        this.s_phone_qua = jceInputStream.readString(3, false);
        this.pull_as_expose_oper = jceInputStream.read(this.pull_as_expose_oper, 4, false);
        this.ip_from_pc_user = jceInputStream.readString(5, false);
        this.request_from = jceInputStream.read(this.request_from, 6, false);
        this.ext_user_info = (Map) jceInputStream.read((JceInputStream) cache_ext_user_info, 7, false);
        this.i_need_expose_time = jceInputStream.read(this.i_need_expose_time, 8, false);
        this.i_req_flag = jceInputStream.read(this.i_req_flag, 9, false);
        this.idfa = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.l_user, 0);
        jceOutputStream.write((Collection) this.vec_req_app, 1);
        String str = this.s_req_source;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.s_phone_qua;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.pull_as_expose_oper, 4);
        String str3 = this.ip_from_pc_user;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.request_from, 6);
        Map<String, String> map = this.ext_user_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        jceOutputStream.write(this.i_need_expose_time, 8);
        jceOutputStream.write(this.i_req_flag, 9);
        String str4 = this.idfa;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
    }

    public tPullADVRequest(long j3, ArrayList<tAdvAppInfo> arrayList, String str, String str2, int i3, String str3, int i16, Map<String, String> map, int i17, int i18, String str4) {
        this.l_user = j3;
        this.vec_req_app = arrayList;
        this.s_req_source = str;
        this.s_phone_qua = str2;
        this.pull_as_expose_oper = i3;
        this.ip_from_pc_user = str3;
        this.request_from = i16;
        this.ext_user_info = map;
        this.i_need_expose_time = i17;
        this.i_req_flag = i18;
        this.idfa = str4;
    }
}
