package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TimeStamp extends JceStruct {
    public byte day;
    public byte hour;
    public byte month;
    public int year;

    public TimeStamp() {
        this.year = 0;
        this.month = (byte) 0;
        this.day = (byte) 0;
        this.hour = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.year = jceInputStream.read(this.year, 1, true);
        this.month = jceInputStream.read(this.month, 2, true);
        this.day = jceInputStream.read(this.day, 3, true);
        this.hour = jceInputStream.read(this.hour, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.year, 1);
        jceOutputStream.write(this.month, 2);
        jceOutputStream.write(this.day, 3);
        jceOutputStream.write(this.hour, 4);
    }

    public TimeStamp(int i3, byte b16, byte b17, byte b18) {
        this.year = i3;
        this.month = b16;
        this.day = b17;
        this.hour = b18;
    }
}
