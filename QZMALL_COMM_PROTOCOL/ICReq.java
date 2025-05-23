package QZMALL_COMM_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ICReq extends JceStruct {
    public String device_info;
    public String qua;
    public int scence;
    public long uObjUin;
    public long uUin;

    public ICReq() {
        this.device_info = "";
        this.qua = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uUin = jceInputStream.read(this.uUin, 0, false);
        this.uObjUin = jceInputStream.read(this.uObjUin, 1, false);
        this.scence = jceInputStream.read(this.scence, 2, false);
        this.device_info = jceInputStream.readString(3, false);
        this.qua = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uUin, 0);
        jceOutputStream.write(this.uObjUin, 1);
        jceOutputStream.write(this.scence, 2);
        String str = this.device_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.qua;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public ICReq(long j3, long j16, int i3, String str, String str2) {
        this.uUin = j3;
        this.uObjUin = j16;
        this.scence = i3;
        this.device_info = str;
        this.qua = str2;
    }
}
