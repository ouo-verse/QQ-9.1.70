package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class tPullStrategyFeedoper extends JceStruct {
    public int i_app_id;
    public int i_oper_source;
    public int i_oper_times;
    public int i_oper_type;
    public int i_pattern_id;
    public int i_platform_id;
    public int i_resource_id;
    public int i_task_id;
    public long l_user;
    public int phone_sourceid;
    public String s_app_trace_info;
    public String s_oper_aux;
    public String s_phone_qua;

    public tPullStrategyFeedoper() {
        this.s_oper_aux = "";
        this.s_phone_qua = "";
        this.s_app_trace_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.l_user = jceInputStream.read(this.l_user, 0, true);
        this.i_app_id = jceInputStream.read(this.i_app_id, 1, true);
        this.i_task_id = jceInputStream.read(this.i_task_id, 2, true);
        this.i_resource_id = jceInputStream.read(this.i_resource_id, 3, true);
        this.i_pattern_id = jceInputStream.read(this.i_pattern_id, 4, true);
        this.i_platform_id = jceInputStream.read(this.i_platform_id, 5, true);
        this.i_oper_type = jceInputStream.read(this.i_oper_type, 6, true);
        this.i_oper_times = jceInputStream.read(this.i_oper_times, 7, false);
        this.i_oper_source = jceInputStream.read(this.i_oper_source, 8, false);
        this.s_oper_aux = jceInputStream.readString(9, false);
        this.s_phone_qua = jceInputStream.readString(10, false);
        this.phone_sourceid = jceInputStream.read(this.phone_sourceid, 11, false);
        this.s_app_trace_info = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.l_user, 0);
        jceOutputStream.write(this.i_app_id, 1);
        jceOutputStream.write(this.i_task_id, 2);
        jceOutputStream.write(this.i_resource_id, 3);
        jceOutputStream.write(this.i_pattern_id, 4);
        jceOutputStream.write(this.i_platform_id, 5);
        jceOutputStream.write(this.i_oper_type, 6);
        jceOutputStream.write(this.i_oper_times, 7);
        jceOutputStream.write(this.i_oper_source, 8);
        String str = this.s_oper_aux;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        String str2 = this.s_phone_qua;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        jceOutputStream.write(this.phone_sourceid, 11);
        String str3 = this.s_app_trace_info;
        if (str3 != null) {
            jceOutputStream.write(str3, 12);
        }
    }

    public tPullStrategyFeedoper(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, String str, String str2, int i29, String str3) {
        this.l_user = j3;
        this.i_app_id = i3;
        this.i_task_id = i16;
        this.i_resource_id = i17;
        this.i_pattern_id = i18;
        this.i_platform_id = i19;
        this.i_oper_type = i26;
        this.i_oper_times = i27;
        this.i_oper_source = i28;
        this.s_oper_aux = str;
        this.s_phone_qua = str2;
        this.phone_sourceid = i29;
        this.s_app_trace_info = str3;
    }
}
