package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRandomHbIdiomReq extends JceStruct {
    static int cache_subchannel;
    public long appid;
    public int fromType;
    public long makeUin;
    public int platform;
    public String qqVersion;
    public String sKey;
    public int subchannel;

    public GetRandomHbIdiomReq() {
        this.makeUin = 0L;
        this.sKey = "";
        this.appid = 0L;
        this.fromType = 0;
        this.platform = 0;
        this.qqVersion = "";
        this.subchannel = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.makeUin = jceInputStream.read(this.makeUin, 0, false);
        this.sKey = jceInputStream.readString(1, false);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.fromType = jceInputStream.read(this.fromType, 3, false);
        this.platform = jceInputStream.read(this.platform, 4, false);
        this.qqVersion = jceInputStream.readString(5, false);
        this.subchannel = jceInputStream.read(this.subchannel, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.makeUin, 0);
        String str = this.sKey;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.fromType, 3);
        jceOutputStream.write(this.platform, 4);
        String str2 = this.qqVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.subchannel, 6);
    }

    public GetRandomHbIdiomReq(long j3, String str, long j16, int i3, int i16, String str2, int i17) {
        this.makeUin = j3;
        this.sKey = str;
        this.appid = j16;
        this.fromType = i3;
        this.platform = i16;
        this.qqVersion = str2;
        this.subchannel = i17;
    }
}
