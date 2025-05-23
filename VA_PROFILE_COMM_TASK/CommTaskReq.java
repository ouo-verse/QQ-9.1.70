package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommTaskReq extends JceStruct {
    static CommHeader cache_stHeader = new CommHeader();
    static byte[] cache_vTaskData;
    public CommHeader stHeader;
    public byte[] vTaskData;

    static {
        cache_vTaskData = r0;
        byte[] bArr = {0};
    }

    public CommTaskReq() {
        this.stHeader = null;
        this.vTaskData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stHeader = (CommHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, false);
        this.vTaskData = jceInputStream.read(cache_vTaskData, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommHeader commHeader = this.stHeader;
        if (commHeader != null) {
            jceOutputStream.write((JceStruct) commHeader, 0);
        }
        byte[] bArr = this.vTaskData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public CommTaskReq(CommHeader commHeader, byte[] bArr) {
        this.stHeader = commHeader;
        this.vTaskData = bArr;
    }
}
