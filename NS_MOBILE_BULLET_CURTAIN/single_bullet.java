package NS_MOBILE_BULLET_CURTAIN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class single_bullet extends JceStruct {
    static Map<Integer, String> cache_background = new HashMap();
    public Map<Integer, String> background;
    public String content;
    public String jump_keyword;
    public String jump_schema;
    public int jump_type;
    public String nickname;
    public long uin;

    static {
        cache_background.put(0, "");
    }

    public single_bullet() {
        this.nickname = "";
        this.content = "";
        this.jump_keyword = "";
        this.jump_schema = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.nickname = jceInputStream.readString(1, false);
        this.content = jceInputStream.readString(2, false);
        this.background = (Map) jceInputStream.read((JceInputStream) cache_background, 3, false);
        this.jump_type = jceInputStream.read(this.jump_type, 4, false);
        this.jump_keyword = jceInputStream.readString(5, false);
        this.jump_schema = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nickname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        Map<Integer, String> map = this.background;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.jump_type, 4);
        String str3 = this.jump_keyword;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.jump_schema;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public single_bullet(long j3, String str, String str2, Map<Integer, String> map, int i3, String str3, String str4) {
        this.uin = j3;
        this.nickname = str;
        this.content = str2;
        this.background = map;
        this.jump_type = i3;
        this.jump_keyword = str3;
        this.jump_schema = str4;
    }
}
