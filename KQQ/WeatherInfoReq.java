package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WeatherInfoReq extends JceStruct {
    public String city;
    public int iAppId;
    public String strSessionKey;

    public WeatherInfoReq() {
        this.iAppId = 0;
        this.strSessionKey = "";
        this.city = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 1, true);
        this.strSessionKey = jceInputStream.readString(2, true);
        this.city = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 1);
        jceOutputStream.write(this.strSessionKey, 2);
        jceOutputStream.write(this.city, 3);
    }

    public WeatherInfoReq(int i3, String str, String str2) {
        this.iAppId = i3;
        this.strSessionKey = str;
        this.city = str2;
    }
}
