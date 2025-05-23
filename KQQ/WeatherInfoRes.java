package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WeatherInfoRes extends JceStruct {
    static ThreeDayWeather cache_weatherInfo;
    public String city;
    public byte citytype;
    public String province;
    public byte result;
    public ThreeDayWeather weatherInfo;

    public WeatherInfoRes() {
        this.result = (byte) 0;
        this.city = "";
        this.weatherInfo = null;
        this.citytype = (byte) 0;
        this.province = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 1, true);
        this.city = jceInputStream.readString(2, true);
        if (cache_weatherInfo == null) {
            cache_weatherInfo = new ThreeDayWeather();
        }
        this.weatherInfo = (ThreeDayWeather) jceInputStream.read((JceStruct) cache_weatherInfo, 3, true);
        this.citytype = jceInputStream.read(this.citytype, 4, false);
        this.province = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write(this.city, 2);
        jceOutputStream.write((JceStruct) this.weatherInfo, 3);
        jceOutputStream.write(this.citytype, 4);
        String str = this.province;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public WeatherInfoRes(byte b16, String str, ThreeDayWeather threeDayWeather, byte b17, String str2) {
        this.result = b16;
        this.city = str;
        this.weatherInfo = threeDayWeather;
        this.citytype = b17;
        this.province = str2;
    }
}
