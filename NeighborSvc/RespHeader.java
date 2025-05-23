package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespHeader extends JceStruct {
    static int cache_eReplyCode;
    public int eReplyCode;
    public long lMID;
    public short shVersion;
    public String strResult;

    public RespHeader() {
        this.shVersion = (short) 0;
        this.lMID = 0L;
        this.eReplyCode = 0;
        this.strResult = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.lMID = jceInputStream.read(this.lMID, 1, true);
        this.eReplyCode = jceInputStream.read(this.eReplyCode, 2, true);
        this.strResult = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.lMID, 1);
        jceOutputStream.write(this.eReplyCode, 2);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public RespHeader(short s16, long j3, int i3, String str) {
        this.shVersion = s16;
        this.lMID = j3;
        this.eReplyCode = i3;
        this.strResult = str;
    }
}
