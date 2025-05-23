package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stEnvironment extends JceStruct {
    static int cache_entrance;
    static int cache_net;
    public long client_ip;
    public String device;
    public String deviceInfo;
    public int entrance;
    public int net;
    public String operators;
    public String qua;
    public String refer;
    public int source;

    public stEnvironment() {
        this.qua = "";
        this.device = "";
        this.net = 0;
        this.operators = "";
        this.client_ip = 0L;
        this.refer = "";
        this.entrance = 0;
        this.source = 0;
        this.deviceInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qua = jceInputStream.readString(1, true);
        this.device = jceInputStream.readString(2, true);
        this.net = jceInputStream.read(this.net, 3, true);
        this.operators = jceInputStream.readString(4, true);
        this.client_ip = jceInputStream.read(this.client_ip, 5, true);
        this.refer = jceInputStream.readString(6, true);
        this.entrance = jceInputStream.read(this.entrance, 7, true);
        this.source = jceInputStream.read(this.source, 8, false);
        this.deviceInfo = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.qua, 1);
        jceOutputStream.write(this.device, 2);
        jceOutputStream.write(this.net, 3);
        jceOutputStream.write(this.operators, 4);
        jceOutputStream.write(this.client_ip, 5);
        jceOutputStream.write(this.refer, 6);
        jceOutputStream.write(this.entrance, 7);
        jceOutputStream.write(this.source, 8);
        String str = this.deviceInfo;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
    }

    public stEnvironment(String str, String str2, int i3, String str3, long j3, String str4, int i16, int i17, String str5) {
        this.qua = str;
        this.device = str2;
        this.net = i3;
        this.operators = str3;
        this.client_ip = j3;
        this.refer = str4;
        this.entrance = i16;
        this.source = i17;
        this.deviceInfo = str5;
    }
}
