package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_set_cover_rsp extends JceStruct {
    static Map<String, String> cache_MulRelsotionUrl;
    public Map<String, String> MulRelsotionUrl;
    public long coverScene;
    public int ret;
    public long syncflag;

    public mobile_sub_set_cover_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        if (cache_MulRelsotionUrl == null) {
            HashMap hashMap = new HashMap();
            cache_MulRelsotionUrl = hashMap;
            hashMap.put("", "");
        }
        this.MulRelsotionUrl = (Map) jceInputStream.read((JceInputStream) cache_MulRelsotionUrl, 1, false);
        this.syncflag = jceInputStream.read(this.syncflag, 2, false);
        this.coverScene = jceInputStream.read(this.coverScene, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        Map<String, String> map = this.MulRelsotionUrl;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        jceOutputStream.write(this.syncflag, 2);
        jceOutputStream.write(this.coverScene, 3);
    }

    public mobile_sub_set_cover_rsp(int i3, Map<String, String> map, long j3, long j16) {
        this.ret = i3;
        this.MulRelsotionUrl = map;
        this.syncflag = j3;
        this.coverScene = j16;
    }
}
