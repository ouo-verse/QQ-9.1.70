package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMomentInfo extends JceStruct {
    public int allowSendMomentTimestamp;
    public String entranceDecs;
    public int iAdID;
    public String notAllowSendMomentFeedDecs;
    public String traceInfo;

    public stMomentInfo() {
        this.allowSendMomentTimestamp = 0;
        this.entranceDecs = "";
        this.notAllowSendMomentFeedDecs = "";
        this.iAdID = 0;
        this.traceInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.allowSendMomentTimestamp = jceInputStream.read(this.allowSendMomentTimestamp, 0, false);
        this.entranceDecs = jceInputStream.readString(1, false);
        this.notAllowSendMomentFeedDecs = jceInputStream.readString(2, false);
        this.iAdID = jceInputStream.read(this.iAdID, 3, false);
        this.traceInfo = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.allowSendMomentTimestamp, 0);
        String str = this.entranceDecs;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.notAllowSendMomentFeedDecs;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.iAdID, 3);
        String str3 = this.traceInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public stMomentInfo(int i3, String str, String str2, int i16, String str3) {
        this.allowSendMomentTimestamp = i3;
        this.entranceDecs = str;
        this.notAllowSendMomentFeedDecs = str2;
        this.iAdID = i16;
        this.traceInfo = str3;
    }
}
