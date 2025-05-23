package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_userlogo_timestamp_req extends JceStruct {
    static ArrayList<Long> cache_others;
    public int field_flag;
    public long last_timestamp;
    public ArrayList<Long> others;
    public long pay_info_timestamp;
    public long skin_timestamp;
    public long skin_uin;
    public long uin;

    public mobile_userlogo_timestamp_req() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        if (cache_others == null) {
            cache_others = new ArrayList<>();
            cache_others.add(0L);
        }
        this.others = (ArrayList) jceInputStream.read((JceInputStream) cache_others, 1, false);
        this.last_timestamp = jceInputStream.read(this.last_timestamp, 2, false);
        this.field_flag = jceInputStream.read(this.field_flag, 3, false);
        this.skin_uin = jceInputStream.read(this.skin_uin, 4, false);
        this.skin_timestamp = jceInputStream.read(this.skin_timestamp, 5, false);
        this.pay_info_timestamp = jceInputStream.read(this.pay_info_timestamp, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        ArrayList<Long> arrayList = this.others;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.last_timestamp, 2);
        jceOutputStream.write(this.field_flag, 3);
        jceOutputStream.write(this.skin_uin, 4);
        jceOutputStream.write(this.skin_timestamp, 5);
        jceOutputStream.write(this.pay_info_timestamp, 6);
    }

    public mobile_userlogo_timestamp_req(long j3, ArrayList<Long> arrayList, long j16, int i3, long j17, long j18, long j19) {
        this.uin = j3;
        this.others = arrayList;
        this.last_timestamp = j16;
        this.field_flag = i3;
        this.skin_uin = j17;
        this.skin_timestamp = j18;
        this.pay_info_timestamp = j19;
    }
}
