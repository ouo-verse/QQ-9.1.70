package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestSendFile extends JceStruct {
    static stFileInfo cache_stFile;
    public byte cFileType;
    public byte cKeyType;
    public long lToAppId;
    public long lToInstanceId;
    public long lToUin;
    public stFileInfo stFile;

    public SvcRequestSendFile() {
        this.cKeyType = (byte) 0;
        this.stFile = null;
        this.lToUin = 0L;
        this.lToAppId = 0L;
        this.lToInstanceId = 0L;
        this.cFileType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cKeyType = jceInputStream.read(this.cKeyType, 0, true);
        if (cache_stFile == null) {
            cache_stFile = new stFileInfo();
        }
        this.stFile = (stFileInfo) jceInputStream.read((JceStruct) cache_stFile, 1, true);
        this.lToUin = jceInputStream.read(this.lToUin, 2, true);
        this.lToAppId = jceInputStream.read(this.lToAppId, 3, true);
        this.lToInstanceId = jceInputStream.read(this.lToInstanceId, 4, true);
        this.cFileType = jceInputStream.read(this.cFileType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cKeyType, 0);
        jceOutputStream.write((JceStruct) this.stFile, 1);
        jceOutputStream.write(this.lToUin, 2);
        jceOutputStream.write(this.lToAppId, 3);
        jceOutputStream.write(this.lToInstanceId, 4);
        jceOutputStream.write(this.cFileType, 5);
    }

    public SvcRequestSendFile(byte b16, stFileInfo stfileinfo, long j3, long j16, long j17, byte b17) {
        this.cKeyType = b16;
        this.stFile = stfileinfo;
        this.lToUin = j3;
        this.lToAppId = j16;
        this.lToInstanceId = j17;
        this.cFileType = b17;
    }
}
