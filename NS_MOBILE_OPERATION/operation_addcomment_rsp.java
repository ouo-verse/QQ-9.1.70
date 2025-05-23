package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_addcomment_rsp extends JceStruct {
    static Map<String, String> cache_extend_info;
    public String commentLikekey;
    public String commentid;
    public Map<String, String> extend_info;

    /* renamed from: msg, reason: collision with root package name */
    public String f25009msg;
    public int ret;
    public String verifyurl;

    static {
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public operation_addcomment_rsp() {
        this.ret = 0;
        this.f25009msg = "";
        this.verifyurl = "";
        this.commentid = "";
        this.commentLikekey = "";
        this.extend_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25009msg = jceInputStream.readString(1, false);
        this.verifyurl = jceInputStream.readString(2, false);
        this.commentid = jceInputStream.readString(3, false);
        this.commentLikekey = jceInputStream.readString(4, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25009msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.verifyurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.commentid;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.commentLikekey;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
    }

    public operation_addcomment_rsp(int i3, String str, String str2, String str3, String str4, Map<String, String> map) {
        this.ret = i3;
        this.f25009msg = str;
        this.verifyurl = str2;
        this.commentid = str3;
        this.commentLikekey = str4;
        this.extend_info = map;
    }
}
