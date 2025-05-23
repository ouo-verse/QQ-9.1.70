package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DayWeather extends JceStruct {
    public int WeatherId;
    public String bWeather;
    public String bWind;
    public String eWeather;
    public String eWind;
    public int highTemp;
    public int lowTemp;

    public DayWeather() {
        this.highTemp = 0;
        this.lowTemp = 0;
        this.bWeather = "";
        this.eWeather = "";
        this.bWind = "";
        this.eWind = "";
        this.WeatherId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.highTemp = jceInputStream.read(this.highTemp, 1, true);
        this.lowTemp = jceInputStream.read(this.lowTemp, 2, true);
        this.bWeather = jceInputStream.readString(3, true);
        this.eWeather = jceInputStream.readString(4, true);
        this.bWind = jceInputStream.readString(5, true);
        this.eWind = jceInputStream.readString(6, true);
        this.WeatherId = jceInputStream.read(this.WeatherId, 7, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.highTemp, 1);
        jceOutputStream.write(this.lowTemp, 2);
        jceOutputStream.write(this.bWeather, 3);
        jceOutputStream.write(this.eWeather, 4);
        jceOutputStream.write(this.bWind, 5);
        jceOutputStream.write(this.eWind, 6);
        jceOutputStream.write(this.WeatherId, 7);
    }

    public DayWeather(int i3, int i16, String str, String str2, String str3, String str4, int i17) {
        this.highTemp = i3;
        this.lowTemp = i16;
        this.bWeather = str;
        this.eWeather = str2;
        this.bWind = str3;
        this.eWind = str4;
        this.WeatherId = i17;
    }
}
