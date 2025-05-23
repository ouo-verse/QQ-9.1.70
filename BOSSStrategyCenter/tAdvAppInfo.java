package BOSSStrategyCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tAdvAppInfo extends JceStruct {
    public int app_id;
    public String app_key;
    public int i_debug_adv_id;
    public int i_need_adv_cnt;

    public tAdvAppInfo() {
        this.app_key = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.app_id = jceInputStream.read(this.app_id, 0, true);
        this.app_key = jceInputStream.readString(1, true);
        this.i_need_adv_cnt = jceInputStream.read(this.i_need_adv_cnt, 2, false);
        this.i_debug_adv_id = jceInputStream.read(this.i_debug_adv_id, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.app_id, 0);
        jceOutputStream.write(this.app_key, 1);
        jceOutputStream.write(this.i_need_adv_cnt, 2);
        jceOutputStream.write(this.i_debug_adv_id, 3);
    }

    public tAdvAppInfo(int i3, String str, int i16, int i17) {
        this.app_id = i3;
        this.app_key = str;
        this.i_need_adv_cnt = i16;
        this.i_debug_adv_id = i17;
    }
}
