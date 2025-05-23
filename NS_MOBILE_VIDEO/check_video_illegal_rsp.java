package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class check_video_illegal_rsp extends JceStruct {
    static Map<String, UrlRsp> cache_video_urls = new HashMap();
    public String illegal_msg;

    /* renamed from: msg, reason: collision with root package name */
    public String f25057msg;
    public int ret;
    public Map<String, UrlRsp> video_urls;

    static {
        cache_video_urls.put("", new UrlRsp());
    }

    public check_video_illegal_rsp() {
        this.f25057msg = "";
        this.illegal_msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25057msg = jceInputStream.readString(1, false);
        this.video_urls = (Map) jceInputStream.read((JceInputStream) cache_video_urls, 2, false);
        this.illegal_msg = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25057msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, UrlRsp> map = this.video_urls;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        String str2 = this.illegal_msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public check_video_illegal_rsp(int i3, String str, Map<String, UrlRsp> map, String str2) {
        this.ret = i3;
        this.f25057msg = str;
        this.video_urls = map;
        this.illegal_msg = str2;
    }
}
