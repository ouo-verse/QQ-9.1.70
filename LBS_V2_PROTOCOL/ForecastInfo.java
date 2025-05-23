package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ForecastInfo extends JceStruct {
    public int iDayWeather;
    public int iNightWeather;
    public int iTempMax;
    public int iTempMin;
    public int iTimestamp;
    public String strDayWeather;

    public ForecastInfo() {
        this.strDayWeather = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTimestamp = jceInputStream.read(this.iTimestamp, 0, true);
        this.iDayWeather = jceInputStream.read(this.iDayWeather, 1, true);
        this.iNightWeather = jceInputStream.read(this.iNightWeather, 2, true);
        this.iTempMax = jceInputStream.read(this.iTempMax, 3, true);
        this.iTempMin = jceInputStream.read(this.iTempMin, 4, true);
        this.strDayWeather = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTimestamp, 0);
        jceOutputStream.write(this.iDayWeather, 1);
        jceOutputStream.write(this.iNightWeather, 2);
        jceOutputStream.write(this.iTempMax, 3);
        jceOutputStream.write(this.iTempMin, 4);
        String str = this.strDayWeather;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public ForecastInfo(int i3, int i16, int i17, int i18, int i19, String str) {
        this.iTimestamp = i3;
        this.iDayWeather = i16;
        this.iNightWeather = i17;
        this.iTempMax = i18;
        this.iTempMin = i19;
        this.strDayWeather = str;
    }
}
