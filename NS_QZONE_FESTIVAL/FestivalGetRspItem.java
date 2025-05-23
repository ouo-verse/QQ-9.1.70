package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FestivalGetRspItem extends JceStruct {
    public long festival_mdays;
    public long festival_month;
    public String festival_name;
    public long festival_type;
    public long festival_year;
    public int result_code;

    public FestivalGetRspItem() {
        this.result_code = 0;
        this.festival_name = "";
        this.festival_type = 0L;
        this.festival_year = 0L;
        this.festival_month = 0L;
        this.festival_mdays = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result_code = jceInputStream.read(this.result_code, 0, true);
        this.festival_name = jceInputStream.readString(1, true);
        this.festival_type = jceInputStream.read(this.festival_type, 2, true);
        this.festival_year = jceInputStream.read(this.festival_year, 3, false);
        this.festival_month = jceInputStream.read(this.festival_month, 4, true);
        this.festival_mdays = jceInputStream.read(this.festival_mdays, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result_code, 0);
        jceOutputStream.write(this.festival_name, 1);
        jceOutputStream.write(this.festival_type, 2);
        jceOutputStream.write(this.festival_year, 3);
        jceOutputStream.write(this.festival_month, 4);
        jceOutputStream.write(this.festival_mdays, 5);
    }

    public FestivalGetRspItem(int i3, String str, long j3, long j16, long j17, long j18) {
        this.result_code = i3;
        this.festival_name = str;
        this.festival_type = j3;
        this.festival_year = j16;
        this.festival_month = j17;
        this.festival_mdays = j18;
    }
}
