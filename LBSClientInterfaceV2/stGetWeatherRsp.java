package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetWeatherRsp extends JceStruct {
    static stWeatherInfo cache_stWeather;
    public stWeatherInfo stWeather;

    public stGetWeatherRsp() {
        this.stWeather = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stWeather == null) {
            cache_stWeather = new stWeatherInfo();
        }
        this.stWeather = (stWeatherInfo) jceInputStream.read((JceStruct) cache_stWeather, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stWeather, 0);
    }

    public stGetWeatherRsp(stWeatherInfo stweatherinfo) {
        this.stWeather = stweatherinfo;
    }
}
