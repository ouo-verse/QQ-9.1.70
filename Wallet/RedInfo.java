package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RedInfo extends JceStruct {
    public int isShow;
    public String path;
    public long taskId;

    public RedInfo() {
        this.path = "";
        this.taskId = 0L;
        this.isShow = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.path = jceInputStream.readString(0, false);
        this.taskId = jceInputStream.read(this.taskId, 1, false);
        this.isShow = jceInputStream.read(this.isShow, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.path;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.taskId, 1);
        jceOutputStream.write(this.isShow, 2);
    }

    public RedInfo(String str, long j3, int i3) {
        this.path = str;
        this.taskId = j3;
        this.isShow = i3;
    }
}
