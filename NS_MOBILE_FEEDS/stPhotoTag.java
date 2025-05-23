package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPhotoTag extends JceStruct {
    static int cache_direction;
    static int cache_type;
    public String content;
    public int direction;
    public String poiTagStreet;
    public String tag_id;
    public int type;
    public long x_scale;
    public long y_scale;

    public stPhotoTag() {
        this.type = 0;
        this.content = "";
        this.tag_id = "";
        this.direction = 0;
        this.poiTagStreet = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.content = jceInputStream.readString(1, true);
        this.tag_id = jceInputStream.readString(2, true);
        this.x_scale = jceInputStream.read(this.x_scale, 3, false);
        this.y_scale = jceInputStream.read(this.y_scale, 4, false);
        this.direction = jceInputStream.read(this.direction, 5, false);
        this.poiTagStreet = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.content, 1);
        jceOutputStream.write(this.tag_id, 2);
        jceOutputStream.write(this.x_scale, 3);
        jceOutputStream.write(this.y_scale, 4);
        jceOutputStream.write(this.direction, 5);
        String str = this.poiTagStreet;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public stPhotoTag(int i3, String str, String str2, long j3, long j16, int i16, String str3) {
        this.type = i3;
        this.content = str;
        this.tag_id = str2;
        this.x_scale = j3;
        this.y_scale = j16;
        this.direction = i16;
        this.poiTagStreet = str3;
    }
}
