package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadUppInfoV2Rsp extends JceStruct {
    static Map<Long, stPhotoSepcInfo> cache_mapSpecInfo = new HashMap();
    public Map<Long, stPhotoSepcInfo> mapSpecInfo;
    public String sPhotoId;
    public String sUrl;

    static {
        cache_mapSpecInfo.put(0L, new stPhotoSepcInfo());
    }

    public UploadUppInfoV2Rsp() {
        this.sUrl = "";
        this.sPhotoId = "";
        this.mapSpecInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUrl = jceInputStream.readString(0, true);
        this.sPhotoId = jceInputStream.readString(1, true);
        this.mapSpecInfo = (Map) jceInputStream.read((JceInputStream) cache_mapSpecInfo, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUrl, 0);
        jceOutputStream.write(this.sPhotoId, 1);
        jceOutputStream.write((Map) this.mapSpecInfo, 2);
    }

    public UploadUppInfoV2Rsp(String str, String str2, Map<Long, stPhotoSepcInfo> map) {
        this.sUrl = str;
        this.sPhotoId = str2;
        this.mapSpecInfo = map;
    }
}
