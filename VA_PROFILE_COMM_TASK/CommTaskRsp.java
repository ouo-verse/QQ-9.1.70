package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommTaskRsp extends JceStruct {
    static byte[] cache_vTaskData;
    public long iRetCode;
    public String sRetMsg;
    public byte[] vTaskData;

    static {
        cache_vTaskData = r0;
        byte[] bArr = {0};
    }

    public CommTaskRsp() {
        this.iRetCode = 0L;
        this.sRetMsg = "";
        this.vTaskData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRetCode = jceInputStream.read(this.iRetCode, 0, false);
        this.sRetMsg = jceInputStream.readString(1, false);
        this.vTaskData = jceInputStream.read(cache_vTaskData, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRetCode, 0);
        String str = this.sRetMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        byte[] bArr = this.vTaskData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public CommTaskRsp(long j3, String str, byte[] bArr) {
        this.iRetCode = j3;
        this.sRetMsg = str;
        this.vTaskData = bArr;
    }
}
