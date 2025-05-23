package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VipMedalInfo extends JceStruct {
    public boolean is_close;
    public int is_remind;
    public int tips_times;
    public int type;
    public String value;

    public VipMedalInfo() {
        this.type = 0;
        this.value = "";
        this.is_remind = 0;
        this.tips_times = 0;
        this.is_close = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.value = jceInputStream.readString(1, true);
        this.is_remind = jceInputStream.read(this.is_remind, 2, false);
        this.tips_times = jceInputStream.read(this.tips_times, 3, false);
        this.is_close = jceInputStream.read(this.is_close, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.value, 1);
        jceOutputStream.write(this.is_remind, 2);
        jceOutputStream.write(this.tips_times, 3);
        jceOutputStream.write(this.is_close, 4);
    }

    public VipMedalInfo(int i3, String str, int i16, int i17, boolean z16) {
        this.type = i3;
        this.value = str;
        this.is_remind = i16;
        this.tips_times = i17;
        this.is_close = z16;
    }
}
