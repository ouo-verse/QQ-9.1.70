package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class birth_info extends JceStruct {
    public int birthDay;
    public int birthDayLunar;
    public int birthMon;
    public int birthMonLunar;

    public birth_info() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.birthMon = jceInputStream.read(this.birthMon, 0, false);
        this.birthDay = jceInputStream.read(this.birthDay, 1, false);
        this.birthMonLunar = jceInputStream.read(this.birthMonLunar, 3, false);
        this.birthDayLunar = jceInputStream.read(this.birthDayLunar, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.birthMon, 0);
        jceOutputStream.write(this.birthDay, 1);
        jceOutputStream.write(this.birthMonLunar, 3);
        jceOutputStream.write(this.birthDayLunar, 4);
    }

    public birth_info(int i3, int i16, int i17, int i18) {
        this.birthMon = i3;
        this.birthDay = i16;
        this.birthMonLunar = i17;
        this.birthDayLunar = i18;
    }
}
