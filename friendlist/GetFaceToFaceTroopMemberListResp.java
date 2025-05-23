package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetFaceToFaceTroopMemberListResp extends JceStruct {
    static int cache_eNetworkType;
    static int cache_result;
    public long dwStatus;
    public int eNetworkType;
    public short errorCode;
    public long iTermType;
    public int result;
    public long uAbiFlag;

    public GetFaceToFaceTroopMemberListResp() {
        this.result = 0;
        this.errorCode = (short) 0;
        this.dwStatus = 0L;
        this.iTermType = 0L;
        this.uAbiFlag = 0L;
        this.eNetworkType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.errorCode = jceInputStream.read(this.errorCode, 1, true);
        this.dwStatus = jceInputStream.read(this.dwStatus, 2, false);
        this.iTermType = jceInputStream.read(this.iTermType, 3, false);
        this.uAbiFlag = jceInputStream.read(this.uAbiFlag, 4, false);
        this.eNetworkType = jceInputStream.read(this.eNetworkType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.errorCode, 1);
        jceOutputStream.write(this.dwStatus, 2);
        jceOutputStream.write(this.iTermType, 3);
        jceOutputStream.write(this.uAbiFlag, 4);
        jceOutputStream.write(this.eNetworkType, 5);
    }

    public GetFaceToFaceTroopMemberListResp(int i3, short s16, long j3, long j16, long j17, int i16) {
        this.result = i3;
        this.errorCode = s16;
        this.dwStatus = j3;
        this.iTermType = j16;
        this.uAbiFlag = j17;
        this.eNetworkType = i16;
    }
}
