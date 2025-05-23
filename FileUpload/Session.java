package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Session extends JceStruct {
    public String process_ip;
    public int process_port;
    public String proxy_ip;
    public int proxy_port;

    public Session() {
        this.process_ip = "";
        this.process_port = 0;
        this.proxy_ip = "";
        this.proxy_port = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.process_ip = jceInputStream.readString(0, true);
        this.process_port = jceInputStream.read(this.process_port, 1, false);
        this.proxy_ip = jceInputStream.readString(2, false);
        this.proxy_port = jceInputStream.read(this.proxy_port, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.process_ip, 0);
        jceOutputStream.write(this.process_port, 1);
        String str = this.proxy_ip;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.proxy_port, 3);
    }

    public Session(String str, int i3, String str2, int i16) {
        this.process_ip = str;
        this.process_port = i3;
        this.proxy_ip = str2;
        this.proxy_port = i16;
    }
}
