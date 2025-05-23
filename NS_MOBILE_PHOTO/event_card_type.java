package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_card_type extends JceStruct {
    static Map<String, String> cache_element;
    static int cache_type;
    public int coverHeight;
    public String coverUrl;
    public int coverWidth;
    public Map<String, String> element;
    public String h5Url;
    public int headHeight;
    public String headUrl;
    public int headWidth;
    public int rank;
    public String subtitle;
    public String summery;
    public int type;

    static {
        HashMap hashMap = new HashMap();
        cache_element = hashMap;
        hashMap.put("", "");
    }

    public event_card_type() {
        this.type = 0;
        this.summery = "";
        this.element = null;
        this.subtitle = "";
        this.coverUrl = "";
        this.headUrl = "";
        this.h5Url = "";
        this.coverWidth = 0;
        this.coverHeight = 0;
        this.headWidth = 0;
        this.headHeight = 0;
        this.rank = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.summery = jceInputStream.readString(1, false);
        this.element = (Map) jceInputStream.read((JceInputStream) cache_element, 2, false);
        this.subtitle = jceInputStream.readString(3, false);
        this.coverUrl = jceInputStream.readString(4, false);
        this.headUrl = jceInputStream.readString(5, false);
        this.h5Url = jceInputStream.readString(6, false);
        this.coverWidth = jceInputStream.read(this.coverWidth, 7, false);
        this.coverHeight = jceInputStream.read(this.coverHeight, 8, false);
        this.headWidth = jceInputStream.read(this.headWidth, 9, false);
        this.headHeight = jceInputStream.read(this.headHeight, 10, false);
        this.rank = jceInputStream.read(this.rank, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.summery;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.element;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        String str2 = this.subtitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.coverUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.headUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.h5Url;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        jceOutputStream.write(this.coverWidth, 7);
        jceOutputStream.write(this.coverHeight, 8);
        jceOutputStream.write(this.headWidth, 9);
        jceOutputStream.write(this.headHeight, 10);
        jceOutputStream.write(this.rank, 11);
    }

    public event_card_type(int i3, String str, Map<String, String> map, String str2, String str3, String str4, String str5, int i16, int i17, int i18, int i19, int i26) {
        this.type = i3;
        this.summery = str;
        this.element = map;
        this.subtitle = str2;
        this.coverUrl = str3;
        this.headUrl = str4;
        this.h5Url = str5;
        this.coverWidth = i16;
        this.coverHeight = i17;
        this.headWidth = i18;
        this.headHeight = i19;
        this.rank = i26;
    }
}
