package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ArrowInfo extends JceStruct {
    static LocationInfo cache_stLocationInfo = new LocationInfo();
    public LocationInfo stLocationInfo;
    public String strUrl;

    public ArrowInfo() {
        this.stLocationInfo = null;
        this.strUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLocationInfo = (LocationInfo) jceInputStream.read((JceStruct) cache_stLocationInfo, 0, false);
        this.strUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LocationInfo locationInfo = this.stLocationInfo;
        if (locationInfo != null) {
            jceOutputStream.write((JceStruct) locationInfo, 0);
        }
        String str = this.strUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public ArrowInfo(LocationInfo locationInfo, String str) {
        this.stLocationInfo = locationInfo;
        this.strUrl = str;
    }
}
