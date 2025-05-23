package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AlarmInfo extends JceStruct {
    public String issueContent;
    public int issueTime;
    public float lat;
    public float lon;
    public int relieveTime;
    public String signalLevel;
    public int signalLevelInt;
    public String signalType;
    public int signalTypeInt;
    public long stationId;
    public String stationName;

    public AlarmInfo() {
        this.stationId = 0L;
        this.stationName = "";
        this.signalType = "";
        this.signalLevel = "";
        this.issueTime = 0;
        this.relieveTime = 0;
        this.issueContent = "";
        this.lon = 0.0f;
        this.lat = 0.0f;
        this.signalTypeInt = 0;
        this.signalLevelInt = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stationId = jceInputStream.read(this.stationId, 0, true);
        this.stationName = jceInputStream.readString(1, true);
        this.signalType = jceInputStream.readString(2, true);
        this.signalLevel = jceInputStream.readString(3, true);
        this.issueTime = jceInputStream.read(this.issueTime, 4, true);
        this.relieveTime = jceInputStream.read(this.relieveTime, 5, true);
        this.issueContent = jceInputStream.readString(6, true);
        this.lon = jceInputStream.read(this.lon, 7, true);
        this.lat = jceInputStream.read(this.lat, 8, true);
        this.signalTypeInt = jceInputStream.read(this.signalTypeInt, 9, false);
        this.signalLevelInt = jceInputStream.read(this.signalLevelInt, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.stationId, 0);
        jceOutputStream.write(this.stationName, 1);
        jceOutputStream.write(this.signalType, 2);
        jceOutputStream.write(this.signalLevel, 3);
        jceOutputStream.write(this.issueTime, 4);
        jceOutputStream.write(this.relieveTime, 5);
        jceOutputStream.write(this.issueContent, 6);
        jceOutputStream.write(this.lon, 7);
        jceOutputStream.write(this.lat, 8);
        jceOutputStream.write(this.signalTypeInt, 9);
        jceOutputStream.write(this.signalLevelInt, 10);
    }

    public AlarmInfo(long j3, String str, String str2, String str3, int i3, int i16, String str4, float f16, float f17, int i17, int i18) {
        this.stationId = j3;
        this.stationName = str;
        this.signalType = str2;
        this.signalLevel = str3;
        this.issueTime = i3;
        this.relieveTime = i16;
        this.issueContent = str4;
        this.lon = f16;
        this.lat = f17;
        this.signalTypeInt = i17;
        this.signalLevelInt = i18;
    }
}
