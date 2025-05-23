package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ThreeDayWeather extends JceStruct {
    static DayWeather cache_aftertom;
    static DayWeather cache_today;
    static DayWeather cache_tomorrow;
    public DayWeather aftertom;
    public String currtime;
    public int currtmpe;
    public String day;
    public String festa;
    public DayWeather today;
    public DayWeather tomorrow;
    public String year;

    public ThreeDayWeather() {
        this.today = null;
        this.tomorrow = null;
        this.aftertom = null;
        this.currtmpe = 0;
        this.year = "";
        this.day = "";
        this.festa = "";
        this.currtime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_today == null) {
            cache_today = new DayWeather();
        }
        this.today = (DayWeather) jceInputStream.read((JceStruct) cache_today, 1, true);
        if (cache_tomorrow == null) {
            cache_tomorrow = new DayWeather();
        }
        this.tomorrow = (DayWeather) jceInputStream.read((JceStruct) cache_tomorrow, 2, true);
        if (cache_aftertom == null) {
            cache_aftertom = new DayWeather();
        }
        this.aftertom = (DayWeather) jceInputStream.read((JceStruct) cache_aftertom, 3, true);
        this.currtmpe = jceInputStream.read(this.currtmpe, 4, false);
        this.year = jceInputStream.readString(5, false);
        this.day = jceInputStream.readString(6, false);
        this.festa = jceInputStream.readString(7, false);
        this.currtime = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.today, 1);
        jceOutputStream.write((JceStruct) this.tomorrow, 2);
        jceOutputStream.write((JceStruct) this.aftertom, 3);
        jceOutputStream.write(this.currtmpe, 4);
        String str = this.year;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.day;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.festa;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.currtime;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
    }

    public ThreeDayWeather(DayWeather dayWeather, DayWeather dayWeather2, DayWeather dayWeather3, int i3, String str, String str2, String str3, String str4) {
        this.today = dayWeather;
        this.tomorrow = dayWeather2;
        this.aftertom = dayWeather3;
        this.currtmpe = i3;
        this.year = str;
        this.day = str2;
        this.festa = str3;
        this.currtime = str4;
    }
}
