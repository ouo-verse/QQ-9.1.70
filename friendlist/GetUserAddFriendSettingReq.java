package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetUserAddFriendSettingReq extends JceStruct {
    static byte[] cache_name;
    static byte[] cache_name1;
    static int cache_sourceID;
    static int cache_sourceSubID;
    public byte[] name;
    public byte[] name1;
    public long queryuin;
    public int sourceID;
    public int sourceSubID;
    public long uin;
    public long version;

    public GetUserAddFriendSettingReq() {
        this.uin = 0L;
        this.queryuin = 0L;
        this.sourceID = BuddySource.DEFAULT;
        this.sourceSubID = 0;
        this.name = null;
        this.version = 0L;
        this.name1 = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.queryuin = jceInputStream.read(this.queryuin, 1, true);
        this.sourceID = jceInputStream.read(this.sourceID, 2, false);
        this.sourceSubID = jceInputStream.read(this.sourceSubID, 3, false);
        if (cache_name == null) {
            cache_name = r0;
            byte[] bArr = {0};
        }
        this.name = jceInputStream.read(cache_name, 4, false);
        this.version = jceInputStream.read(this.version, 5, false);
        if (cache_name1 == null) {
            cache_name1 = r0;
            byte[] bArr2 = {0};
        }
        this.name1 = jceInputStream.read(cache_name1, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.queryuin, 1);
        jceOutputStream.write(this.sourceID, 2);
        jceOutputStream.write(this.sourceSubID, 3);
        byte[] bArr = this.name;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        jceOutputStream.write(this.version, 5);
        byte[] bArr2 = this.name1;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
    }

    public GetUserAddFriendSettingReq(long j3, long j16, int i3, int i16, byte[] bArr, long j17, byte[] bArr2) {
        this.uin = j3;
        this.queryuin = j16;
        this.sourceID = i3;
        this.sourceSubID = i16;
        this.name = bArr;
        this.version = j17;
        this.name1 = bArr2;
    }
}
