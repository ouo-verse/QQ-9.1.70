package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestQueryLastLoginState extends JceStruct {
    public String MobileUniqueNo;
    public long nextFlag;
    public long timeStamp;

    public RequestQueryLastLoginState() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.MobileUniqueNo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        this.MobileUniqueNo = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        String str = this.MobileUniqueNo;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public RequestQueryLastLoginState(long j3, long j16, String str) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.MobileUniqueNo = str;
    }
}
