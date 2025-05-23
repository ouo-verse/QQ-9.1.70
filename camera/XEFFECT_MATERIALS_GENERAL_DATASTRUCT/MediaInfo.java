package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class MediaInfo extends JceStruct {
    static byte[] cache_Rawdata;
    public int MediaType;
    public byte[] RawData;
    public String URL;

    static {
        cache_Rawdata = r0;
        byte[] bArr = {0};
    }

    public MediaInfo() {
        this.URL = "";
        this.RawData = null;
        this.MediaType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.URL = jceInputStream.readString(0, false);
        this.RawData = jceInputStream.read(cache_Rawdata, 1, false);
        this.MediaType = jceInputStream.read(this.MediaType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.URL;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        byte[] bArr = this.RawData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.MediaType, 2);
    }

    public MediaInfo(String str, byte[] bArr, int i3) {
        this.URL = str;
        this.RawData = bArr;
        this.MediaType = i3;
    }
}
