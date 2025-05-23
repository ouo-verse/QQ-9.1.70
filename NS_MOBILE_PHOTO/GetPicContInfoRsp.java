package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class GetPicContInfoRsp extends JceStruct {
    static Map<String, PicContInfo> cache_pic_info = new HashMap();
    public Map<String, PicContInfo> pic_info;

    static {
        cache_pic_info.put("", new PicContInfo());
    }

    public GetPicContInfoRsp() {
        this.pic_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pic_info = (Map) jceInputStream.read((JceInputStream) cache_pic_info, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, PicContInfo> map = this.pic_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public GetPicContInfoRsp(Map<String, PicContInfo> map) {
        this.pic_info = map;
    }
}
