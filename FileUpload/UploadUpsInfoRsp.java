package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadUpsInfoRsp extends JceStruct {
    static Map<Long, String> cache_sUrls = new HashMap();
    static byte[] cache_vBusiNessData;
    public int iHight;
    public int iPhotoType;
    public int iType;
    public int iWidth;
    public String sUrl;
    public Map<Long, String> sUrls;
    public byte[] vBusiNessData;

    static {
        cache_vBusiNessData = r0;
        byte[] bArr = {0};
        cache_sUrls.put(0L, "");
    }

    public UploadUpsInfoRsp() {
        this.iType = 0;
        this.vBusiNessData = null;
        this.sUrl = "";
        this.iWidth = 0;
        this.iHight = 0;
        this.iPhotoType = 0;
        this.sUrls = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, true);
        this.vBusiNessData = jceInputStream.read(cache_vBusiNessData, 1, false);
        this.sUrl = jceInputStream.readString(2, false);
        this.iWidth = jceInputStream.read(this.iWidth, 3, false);
        this.iHight = jceInputStream.read(this.iHight, 4, false);
        this.iPhotoType = jceInputStream.read(this.iPhotoType, 5, false);
        this.sUrls = (Map) jceInputStream.read((JceInputStream) cache_sUrls, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        byte[] bArr = this.vBusiNessData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        String str = this.sUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iWidth, 3);
        jceOutputStream.write(this.iHight, 4);
        jceOutputStream.write(this.iPhotoType, 5);
        Map<Long, String> map = this.sUrls;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public UploadUpsInfoRsp(int i3, byte[] bArr, String str, int i16, int i17, int i18, Map<Long, String> map) {
        this.iType = i3;
        this.vBusiNessData = bArr;
        this.sUrl = str;
        this.iWidth = i16;
        this.iHight = i17;
        this.iPhotoType = i18;
        this.sUrls = map;
    }
}
