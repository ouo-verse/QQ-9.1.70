package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Date extends JceStruct {
    public short _day;
    public short _mon;
    public short _year;

    public Date() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this._year = jceInputStream.read(this._year, 0, true);
        this._mon = jceInputStream.read(this._mon, 1, true);
        this._day = jceInputStream.read(this._day, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this._year, 0);
        jceOutputStream.write(this._mon, 1);
        jceOutputStream.write(this._day, 2);
    }

    public Date(short s16, short s17, short s18) {
        this._year = s16;
        this._mon = s17;
        this._day = s18;
    }
}
