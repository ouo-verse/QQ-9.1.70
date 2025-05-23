package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAlbumCommShareKeyRsp extends JceStruct {
    static Map<String, String> cache_outs;

    /* renamed from: msg, reason: collision with root package name */
    public String f25026msg;
    public Map<String, String> outs;
    public int ret;

    static {
        HashMap hashMap = new HashMap();
        cache_outs = hashMap;
        hashMap.put("", "");
    }

    public GetAlbumCommShareKeyRsp() {
        this.ret = 0;
        this.f25026msg = "";
        this.outs = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25026msg = jceInputStream.readString(1, false);
        this.outs = (Map) jceInputStream.read((JceInputStream) cache_outs, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25026msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.outs;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public GetAlbumCommShareKeyRsp(int i3, String str, Map<String, String> map) {
        this.ret = i3;
        this.f25026msg = str;
        this.outs = map;
    }
}
