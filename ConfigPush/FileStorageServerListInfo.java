package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FileStorageServerListInfo extends JceStruct {
    public int iPort;
    public String sIP;

    public FileStorageServerListInfo() {
        this.sIP = "";
        this.iPort = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sIP = jceInputStream.readString(1, true);
        this.iPort = jceInputStream.read(this.iPort, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sIP, 1);
        jceOutputStream.write(this.iPort, 2);
    }

    public FileStorageServerListInfo(String str, int i3) {
        this.sIP = str;
        this.iPort = i3;
    }
}
