package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupVoiceInfo extends JceStruct {
    static byte[] cache_fileMd5;
    public long fileId;
    public byte[] fileMd5;
    public long groupCode;

    static {
        cache_fileMd5 = r0;
        byte[] bArr = {0};
    }

    public GroupVoiceInfo() {
        this.groupCode = 0L;
        this.fileId = 0L;
        this.fileMd5 = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.groupCode = jceInputStream.read(this.groupCode, 0, false);
        this.fileId = jceInputStream.read(this.fileId, 1, false);
        this.fileMd5 = jceInputStream.read(cache_fileMd5, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.groupCode, 0);
        jceOutputStream.write(this.fileId, 1);
        byte[] bArr = this.fileMd5;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public GroupVoiceInfo(long j3, long j16, byte[] bArr) {
        this.groupCode = j3;
        this.fileId = j16;
        this.fileMd5 = bArr;
    }
}
