package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stBusinessAdInfo extends JceStruct {
    public String adId;
    public int adType;
    public String advertiserId;
    public String creativeId;

    public stBusinessAdInfo() {
        this.adType = 0;
        this.adId = "";
        this.creativeId = "";
        this.advertiserId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.adType = jceInputStream.read(this.adType, 0, false);
        this.adId = jceInputStream.readString(1, false);
        this.creativeId = jceInputStream.readString(2, false);
        this.advertiserId = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stBusinessAdInfo{adType=" + this.adType + ", adId='" + this.adId + "', creativeId='" + this.creativeId + "', advertiserId='" + this.advertiserId + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.adType, 0);
        String str = this.adId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.creativeId;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.advertiserId;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stBusinessAdInfo(int i3, String str, String str2, String str3) {
        this.adType = i3;
        this.adId = str;
        this.creativeId = str2;
        this.advertiserId = str3;
    }
}
