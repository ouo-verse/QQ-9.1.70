package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stQQGroupDetailRsp extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f25123msg;
    public String schema;
    public String signature;
    public int status;

    public stQQGroupDetailRsp() {
        this.status = 0;
        this.f25123msg = "";
        this.signature = "";
        this.schema = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.status = jceInputStream.read(this.status, 0, false);
        this.f25123msg = jceInputStream.readString(1, false);
        this.signature = jceInputStream.readString(2, false);
        this.schema = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.status, 0);
        String str = this.f25123msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.signature;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.schema;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stQQGroupDetailRsp(int i3, String str, String str2, String str3) {
        this.status = i3;
        this.f25123msg = str;
        this.signature = str2;
        this.schema = str3;
    }
}
