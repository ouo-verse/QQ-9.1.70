package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CityInfoRes extends JceStruct {
    public String city;
    public String province;
    public byte result;

    public CityInfoRes() {
        this.result = (byte) 0;
        this.city = "";
        this.province = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 1, true);
        this.city = jceInputStream.readString(2, true);
        this.province = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write(this.city, 2);
        String str = this.province;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public CityInfoRes(byte b16, String str, String str2) {
        this.result = b16;
        this.city = str;
        this.province = str2;
    }
}
