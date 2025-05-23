package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetAutoInfoReq extends JceStruct {
    static int cache_sourceID;
    static int cache_sourceSubID;
    public byte cType;
    public long dwFriendUin;
    public int sourceID;
    public int sourceSubID;
    public long uin;

    public GetAutoInfoReq() {
        this.uin = 0L;
        this.dwFriendUin = 0L;
        this.cType = (byte) 1;
        this.sourceID = BuddySource.DEFAULT;
        this.sourceSubID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.dwFriendUin = jceInputStream.read(this.dwFriendUin, 1, true);
        this.cType = jceInputStream.read(this.cType, 2, true);
        this.sourceID = jceInputStream.read(this.sourceID, 3, false);
        this.sourceSubID = jceInputStream.read(this.sourceSubID, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.dwFriendUin, 1);
        jceOutputStream.write(this.cType, 2);
        jceOutputStream.write(this.sourceID, 3);
        jceOutputStream.write(this.sourceSubID, 4);
    }

    public GetAutoInfoReq(long j3, long j16, byte b16, int i3, int i16) {
        this.uin = j3;
        this.dwFriendUin = j16;
        this.cType = b16;
        this.sourceID = i3;
        this.sourceSubID = i16;
    }
}
