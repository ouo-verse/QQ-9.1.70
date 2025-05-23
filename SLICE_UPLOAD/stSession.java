package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSession extends JceStruct {
    public int dumpBussinessID;
    public long process_ip;
    public short process_port;
    public String sid;

    public stSession() {
        this.sid = "";
        this.process_ip = 0L;
        this.process_port = (short) 0;
        this.dumpBussinessID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sid = jceInputStream.readString(1, true);
        this.process_ip = jceInputStream.read(this.process_ip, 2, true);
        this.process_port = jceInputStream.read(this.process_port, 3, true);
        this.dumpBussinessID = jceInputStream.read(this.dumpBussinessID, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sid, 1);
        jceOutputStream.write(this.process_ip, 2);
        jceOutputStream.write(this.process_port, 3);
        jceOutputStream.write(this.dumpBussinessID, 4);
    }

    public stSession(String str, long j3, short s16, int i3) {
        this.sid = str;
        this.process_ip = j3;
        this.process_port = s16;
        this.dumpBussinessID = i3;
    }
}
