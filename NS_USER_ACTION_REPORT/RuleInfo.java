package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RuleInfo extends JceStruct {
    public long rule_id;
    public String str_ruleid;
    public long test_id;

    public RuleInfo() {
        this.test_id = 0L;
        this.rule_id = 0L;
        this.str_ruleid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.test_id = jceInputStream.read(this.test_id, 0, false);
        this.rule_id = jceInputStream.read(this.rule_id, 1, false);
        this.str_ruleid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.test_id, 0);
        jceOutputStream.write(this.rule_id, 1);
        String str = this.str_ruleid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public RuleInfo(long j3, long j16, String str) {
        this.test_id = j3;
        this.rule_id = j16;
        this.str_ruleid = str;
    }
}
