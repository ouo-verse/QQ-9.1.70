package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_life_moment_info extends JceStruct {
    public s_picurl moment_feed_night_pic;
    public s_picurl moment_feed_pic;
    public String moment_id;
    public String moment_name;
    public s_picurl moment_pic;
    public int type;
    static s_picurl cache_moment_pic = new s_picurl();
    static s_picurl cache_moment_feed_pic = new s_picurl();
    static s_picurl cache_moment_feed_night_pic = new s_picurl();

    public s_life_moment_info() {
        this.type = 0;
        this.moment_name = "";
        this.moment_pic = null;
        this.moment_feed_pic = null;
        this.moment_feed_night_pic = null;
        this.moment_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.moment_name = jceInputStream.readString(1, false);
        this.moment_pic = (s_picurl) jceInputStream.read((JceStruct) cache_moment_pic, 2, false);
        this.moment_feed_pic = (s_picurl) jceInputStream.read((JceStruct) cache_moment_feed_pic, 3, false);
        this.moment_feed_night_pic = (s_picurl) jceInputStream.read((JceStruct) cache_moment_feed_night_pic, 4, false);
        this.moment_id = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.moment_name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        s_picurl s_picurlVar = this.moment_pic;
        if (s_picurlVar != null) {
            jceOutputStream.write((JceStruct) s_picurlVar, 2);
        }
        s_picurl s_picurlVar2 = this.moment_feed_pic;
        if (s_picurlVar2 != null) {
            jceOutputStream.write((JceStruct) s_picurlVar2, 3);
        }
        s_picurl s_picurlVar3 = this.moment_feed_night_pic;
        if (s_picurlVar3 != null) {
            jceOutputStream.write((JceStruct) s_picurlVar3, 4);
        }
        String str2 = this.moment_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public s_life_moment_info(int i3, String str, s_picurl s_picurlVar, s_picurl s_picurlVar2, s_picurl s_picurlVar3, String str2) {
        this.type = i3;
        this.moment_name = str;
        this.moment_pic = s_picurlVar;
        this.moment_feed_pic = s_picurlVar2;
        this.moment_feed_night_pic = s_picurlVar3;
        this.moment_id = str2;
    }
}
