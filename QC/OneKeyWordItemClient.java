package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OneKeyWordItemClient extends JceStruct {
    public String sKeyWordContent;
    public long uGroupNum;
    public long uWordExpiredFlag;
    public long uWordId;
    public long uWordStatus;

    public OneKeyWordItemClient() {
        this.uWordId = 0L;
        this.sKeyWordContent = "";
        this.uGroupNum = 0L;
        this.uWordExpiredFlag = 0L;
        this.uWordStatus = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uWordId = jceInputStream.read(this.uWordId, 0, false);
        this.sKeyWordContent = jceInputStream.readString(1, false);
        this.uGroupNum = jceInputStream.read(this.uGroupNum, 2, false);
        this.uWordExpiredFlag = jceInputStream.read(this.uWordExpiredFlag, 3, false);
        this.uWordStatus = jceInputStream.read(this.uWordStatus, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uWordId, 0);
        String str = this.sKeyWordContent;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uGroupNum, 2);
        jceOutputStream.write(this.uWordExpiredFlag, 3);
        jceOutputStream.write(this.uWordStatus, 4);
    }

    public OneKeyWordItemClient(long j3, String str, long j16, long j17, long j18) {
        this.uWordId = j3;
        this.sKeyWordContent = str;
        this.uGroupNum = j16;
        this.uWordExpiredFlag = j17;
        this.uWordStatus = j18;
    }
}
