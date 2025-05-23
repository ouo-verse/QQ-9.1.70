package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TimeLine extends JceStruct {
    static Map<String, TimeEvent> cache_festivals = new HashMap();
    public long begin_time;
    public long end_time;
    public Map<String, TimeEvent> festivals;
    public int show_day;
    public int show_month;
    public int show_time;
    public int show_week;
    public int show_year;
    public int total;

    static {
        cache_festivals.put("", new TimeEvent());
    }

    public TimeLine() {
        this.begin_time = 0L;
        this.end_time = 0L;
        this.total = 0;
        this.show_time = 0;
        this.show_year = 0;
        this.show_month = 0;
        this.show_week = 0;
        this.show_day = 0;
        this.festivals = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.begin_time = jceInputStream.read(this.begin_time, 0, true);
        this.end_time = jceInputStream.read(this.end_time, 1, true);
        this.total = jceInputStream.read(this.total, 2, true);
        this.show_time = jceInputStream.read(this.show_time, 3, true);
        this.show_year = jceInputStream.read(this.show_year, 4, true);
        this.show_month = jceInputStream.read(this.show_month, 5, true);
        this.show_week = jceInputStream.read(this.show_week, 6, false);
        this.show_day = jceInputStream.read(this.show_day, 7, false);
        this.festivals = (Map) jceInputStream.read((JceInputStream) cache_festivals, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.begin_time, 0);
        jceOutputStream.write(this.end_time, 1);
        jceOutputStream.write(this.total, 2);
        jceOutputStream.write(this.show_time, 3);
        jceOutputStream.write(this.show_year, 4);
        jceOutputStream.write(this.show_month, 5);
        jceOutputStream.write(this.show_week, 6);
        jceOutputStream.write(this.show_day, 7);
        Map<String, TimeEvent> map = this.festivals;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
    }

    public TimeLine(long j3, long j16, int i3, int i16, int i17, int i18, int i19, int i26, Map<String, TimeEvent> map) {
        this.begin_time = j3;
        this.end_time = j16;
        this.total = i3;
        this.show_time = i16;
        this.show_year = i17;
        this.show_month = i18;
        this.show_week = i19;
        this.show_day = i26;
        this.festivals = map;
    }
}
