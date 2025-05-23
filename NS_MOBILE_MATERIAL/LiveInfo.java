package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LiveInfo extends JceStruct {
    public int iRecording;
    public long iRelativeTime;
    public String strAuthorUin;
    public String strRoomId;

    public LiveInfo() {
        this.strAuthorUin = "";
        this.strRoomId = "";
        this.iRecording = 0;
        this.iRelativeTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strAuthorUin = jceInputStream.readString(0, false);
        this.strRoomId = jceInputStream.readString(1, false);
        this.iRecording = jceInputStream.read(this.iRecording, 2, false);
        this.iRelativeTime = jceInputStream.read(this.iRelativeTime, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strAuthorUin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strRoomId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.iRecording, 2);
        jceOutputStream.write(this.iRelativeTime, 3);
    }

    public LiveInfo(String str, String str2, int i3, long j3) {
        this.strAuthorUin = str;
        this.strRoomId = str2;
        this.iRecording = i3;
        this.iRelativeTime = j3;
    }
}
