package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ActionInfo extends JceStruct {
    static int cache_action_attr;
    static int cache_action_id;
    public int action_attr;
    public int action_id;
    public long action_value;
    public long oper_time;

    public ActionInfo() {
        this.oper_time = 0L;
        this.action_id = 0;
        this.action_value = 0L;
        this.action_attr = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.oper_time = jceInputStream.read(this.oper_time, 0, true);
        this.action_id = jceInputStream.read(this.action_id, 1, true);
        this.action_value = jceInputStream.read(this.action_value, 2, false);
        this.action_attr = jceInputStream.read(this.action_attr, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.oper_time, 0);
        jceOutputStream.write(this.action_id, 1);
        jceOutputStream.write(this.action_value, 2);
        jceOutputStream.write(this.action_attr, 3);
    }

    public ActionInfo(long j3, int i3, long j16, int i16) {
        this.oper_time = j3;
        this.action_id = i3;
        this.action_value = j16;
        this.action_attr = i16;
    }
}
