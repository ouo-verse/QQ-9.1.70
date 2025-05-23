package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_festival_rsp extends JceStruct {
    static ArrayList<String> cache_play_url_list;
    public String attach_info;
    public long end_time;
    public long interval;
    public int play_flag;
    public long play_time;
    public ArrayList<String> play_url_list;
    public long start_time;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_play_url_list = arrayList;
        arrayList.add("");
    }

    public mobile_festival_rsp() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.play_flag = jceInputStream.read(this.play_flag, 0, false);
        this.play_url_list = (ArrayList) jceInputStream.read((JceInputStream) cache_play_url_list, 1, false);
        this.play_time = jceInputStream.read(this.play_time, 2, false);
        this.interval = jceInputStream.read(this.interval, 3, false);
        this.start_time = jceInputStream.read(this.start_time, 4, false);
        this.end_time = jceInputStream.read(this.end_time, 5, false);
        this.attach_info = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.play_flag, 0);
        ArrayList<String> arrayList = this.play_url_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.play_time, 2);
        jceOutputStream.write(this.interval, 3);
        jceOutputStream.write(this.start_time, 4);
        jceOutputStream.write(this.end_time, 5);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public mobile_festival_rsp(int i3, ArrayList<String> arrayList, long j3, long j16, long j17, long j18, String str) {
        this.play_flag = i3;
        this.play_url_list = arrayList;
        this.play_time = j3;
        this.interval = j16;
        this.start_time = j17;
        this.end_time = j18;
        this.attach_info = str;
    }
}
