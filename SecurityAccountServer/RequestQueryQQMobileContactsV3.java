package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RequestQueryQQMobileContactsV3 extends JceStruct {
    static int cache_bindState;
    static int cache_queryFlag;
    static byte[] cache_sessionSid;
    public boolean Compressd;
    public long MaxsignTimeStamp;
    public String MobileUniqueNo;
    public boolean OmitOffline;
    public int bindState;
    public long nextFlag;
    public int queryFlag;
    public long queryFrom;
    public byte[] sessionSid;
    public long timeStamp;

    static {
        cache_sessionSid = r0;
        byte[] bArr = {0};
    }

    public RequestQueryQQMobileContactsV3() {
        this.nextFlag = 0L;
        this.timeStamp = 0L;
        this.sessionSid = null;
        this.queryFlag = 0;
        this.Compressd = false;
        this.MaxsignTimeStamp = 0L;
        this.MobileUniqueNo = "";
        this.OmitOffline = false;
        this.queryFrom = 0L;
        this.bindState = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nextFlag = jceInputStream.read(this.nextFlag, 0, true);
        this.timeStamp = jceInputStream.read(this.timeStamp, 1, true);
        this.sessionSid = jceInputStream.read(cache_sessionSid, 2, true);
        this.queryFlag = jceInputStream.read(this.queryFlag, 3, true);
        this.Compressd = jceInputStream.read(this.Compressd, 4, false);
        this.MaxsignTimeStamp = jceInputStream.read(this.MaxsignTimeStamp, 5, false);
        this.MobileUniqueNo = jceInputStream.readString(6, false);
        this.OmitOffline = jceInputStream.read(this.OmitOffline, 7, false);
        this.queryFrom = jceInputStream.read(this.queryFrom, 8, false);
        this.bindState = jceInputStream.read(this.bindState, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nextFlag, 0);
        jceOutputStream.write(this.timeStamp, 1);
        jceOutputStream.write(this.sessionSid, 2);
        jceOutputStream.write(this.queryFlag, 3);
        jceOutputStream.write(this.Compressd, 4);
        jceOutputStream.write(this.MaxsignTimeStamp, 5);
        String str = this.MobileUniqueNo;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.OmitOffline, 7);
        jceOutputStream.write(this.queryFrom, 8);
        jceOutputStream.write(this.bindState, 9);
    }

    public RequestQueryQQMobileContactsV3(long j3, long j16, byte[] bArr, int i3, boolean z16, long j17, String str, boolean z17, long j18, int i16) {
        this.nextFlag = j3;
        this.timeStamp = j16;
        this.sessionSid = bArr;
        this.queryFlag = i3;
        this.Compressd = z16;
        this.MaxsignTimeStamp = j17;
        this.MobileUniqueNo = str;
        this.OmitOffline = z17;
        this.queryFrom = j18;
        this.bindState = i16;
    }
}
