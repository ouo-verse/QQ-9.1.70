package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AccessReq extends JceStruct {
    static byte[] cache_body;
    public byte[] body;
    public int gray;
    public String imei;
    public String manufacture;
    public String mode;
    public int platform;
    public String qimei;
    public String rom;

    static {
        cache_body = r0;
        byte[] bArr = {0};
    }

    public AccessReq() {
        this.imei = "";
        this.mode = "";
        this.manufacture = "";
        this.rom = "";
        this.gray = 0;
        this.body = null;
        this.qimei = "";
        this.platform = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, false);
        this.mode = jceInputStream.readString(1, false);
        this.manufacture = jceInputStream.readString(2, false);
        this.rom = jceInputStream.readString(3, false);
        this.gray = jceInputStream.read(this.gray, 4, false);
        this.body = jceInputStream.read(cache_body, 5, false);
        this.qimei = jceInputStream.readString(6, false);
        this.platform = jceInputStream.read(this.platform, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imei;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.mode;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.manufacture;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.rom;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.gray, 4);
        byte[] bArr = this.body;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        String str5 = this.qimei;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.platform, 7);
    }

    public AccessReq(String str, String str2, String str3, String str4, int i3, byte[] bArr, int i16) {
        this.qimei = "";
        this.imei = str;
        this.mode = str2;
        this.manufacture = str3;
        this.rom = str4;
        this.gray = i3;
        this.body = bArr;
        this.platform = i16;
    }
}
