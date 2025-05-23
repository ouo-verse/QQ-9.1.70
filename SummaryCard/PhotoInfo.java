package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PhotoInfo extends JceStruct {
    static Map<String, String> cache_mapEx;
    public int IsOnlySelf;
    public Map<String, String> mapEx;
    public String strPicUrl;
    public long uPhotoTimestamp;

    static {
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public PhotoInfo() {
        this.strPicUrl = "";
        this.uPhotoTimestamp = 0L;
        this.IsOnlySelf = 0;
        this.mapEx = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPicUrl = jceInputStream.readString(0, true);
        this.uPhotoTimestamp = jceInputStream.read(this.uPhotoTimestamp, 1, true);
        this.IsOnlySelf = jceInputStream.read(this.IsOnlySelf, 2, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPicUrl, 0);
        jceOutputStream.write(this.uPhotoTimestamp, 1);
        jceOutputStream.write(this.IsOnlySelf, 2);
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public PhotoInfo(String str, long j3, int i3, Map<String, String> map) {
        this.strPicUrl = str;
        this.uPhotoTimestamp = j3;
        this.IsOnlySelf = i3;
        this.mapEx = map;
    }
}
