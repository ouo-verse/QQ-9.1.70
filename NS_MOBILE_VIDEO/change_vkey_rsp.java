package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class change_vkey_rsp extends JceStruct {
    static Map<String, UrlRsp> cache_video_urls;

    /* renamed from: msg, reason: collision with root package name */
    public String f25056msg;
    public int ret;
    public Map<String, UrlRsp> video_urls;

    public change_vkey_rsp() {
        this.f25056msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25056msg = jceInputStream.readString(1, false);
        if (cache_video_urls == null) {
            cache_video_urls = new HashMap();
            cache_video_urls.put("", new UrlRsp());
        }
        this.video_urls = (Map) jceInputStream.read((JceInputStream) cache_video_urls, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25056msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, UrlRsp> map = this.video_urls;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public change_vkey_rsp(int i3, String str, Map<String, UrlRsp> map) {
        this.ret = i3;
        this.f25056msg = str;
        this.video_urls = map;
    }
}
