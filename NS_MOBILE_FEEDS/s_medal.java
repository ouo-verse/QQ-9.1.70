package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_medal extends JceStruct {
    static int cache_medal_state;
    static int cache_medal_type;
    public String jump_url;
    public int level;
    public int medal_id;
    public int medal_state;
    public int medal_type;
    public String pic_url;

    public s_medal() {
        this.medal_type = 0;
        this.medal_state = 0;
        this.level = 0;
        this.pic_url = "";
        this.jump_url = "";
        this.medal_id = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.medal_type = jceInputStream.read(this.medal_type, 0, false);
        this.medal_state = jceInputStream.read(this.medal_state, 1, false);
        this.level = jceInputStream.read(this.level, 2, false);
        this.pic_url = jceInputStream.readString(3, false);
        this.jump_url = jceInputStream.readString(4, false);
        this.medal_id = jceInputStream.read(this.medal_id, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.medal_type, 0);
        jceOutputStream.write(this.medal_state, 1);
        jceOutputStream.write(this.level, 2);
        String str = this.pic_url;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.jump_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.medal_id, 5);
    }

    public s_medal(int i3, int i16, int i17, String str, String str2, int i18) {
        this.medal_type = i3;
        this.medal_state = i16;
        this.level = i17;
        this.pic_url = str;
        this.jump_url = str2;
        this.medal_id = i18;
    }
}
