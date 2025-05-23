package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CategoryOpRsp extends JceStruct {
    static Map<String, String> cache_oldkey_2_newkey;

    /* renamed from: msg, reason: collision with root package name */
    public String f25025msg;
    public Map<String, String> oldkey_2_newkey;
    public int ret;

    static {
        HashMap hashMap = new HashMap();
        cache_oldkey_2_newkey = hashMap;
        hashMap.put("", "");
    }

    public CategoryOpRsp() {
        this.ret = 0;
        this.f25025msg = "";
        this.oldkey_2_newkey = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25025msg = jceInputStream.readString(1, false);
        this.oldkey_2_newkey = (Map) jceInputStream.read((JceInputStream) cache_oldkey_2_newkey, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25025msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.oldkey_2_newkey;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public CategoryOpRsp(int i3, String str, Map<String, String> map) {
        this.ret = i3;
        this.f25025msg = str;
        this.oldkey_2_newkey = map;
    }
}
