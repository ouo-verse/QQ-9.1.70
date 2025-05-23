package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NumberInfo extends JceStruct {
    static LocationInfo cache_stLocationInfo = new LocationInfo();
    public LocationInfo stLocationInfo;
    public String strFontColor;
    public String strNumber;
    public long uiFontSize;

    public NumberInfo() {
        this.stLocationInfo = null;
        this.strFontColor = "";
        this.uiFontSize = 0L;
        this.strNumber = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLocationInfo = (LocationInfo) jceInputStream.read((JceStruct) cache_stLocationInfo, 0, false);
        this.strFontColor = jceInputStream.readString(1, false);
        this.uiFontSize = jceInputStream.read(this.uiFontSize, 2, false);
        this.strNumber = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LocationInfo locationInfo = this.stLocationInfo;
        if (locationInfo != null) {
            jceOutputStream.write((JceStruct) locationInfo, 0);
        }
        String str = this.strFontColor;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uiFontSize, 2);
        String str2 = this.strNumber;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public NumberInfo(LocationInfo locationInfo, String str, long j3, String str2) {
        this.stLocationInfo = locationInfo;
        this.strFontColor = str;
        this.uiFontSize = j3;
        this.strNumber = str2;
    }
}
