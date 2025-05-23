package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AudioInfo extends JceStruct {
    static byte[] cache_RawData;
    public int DataLen;
    public String MD5;
    public byte[] RawData;
    public String URL;

    static {
        cache_RawData = r0;
        byte[] bArr = {0};
    }

    public AudioInfo() {
        this.RawData = null;
        this.URL = "";
        this.MD5 = "";
        this.DataLen = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.RawData = jceInputStream.read(cache_RawData, 0, false);
        this.URL = jceInputStream.readString(1, false);
        this.MD5 = jceInputStream.readString(2, false);
        this.DataLen = jceInputStream.read(this.DataLen, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.RawData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        String str = this.URL;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.MD5;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.DataLen, 3);
    }

    public AudioInfo(byte[] bArr, String str, String str2, int i3) {
        this.RawData = bArr;
        this.URL = str;
        this.MD5 = str2;
        this.DataLen = i3;
    }
}
