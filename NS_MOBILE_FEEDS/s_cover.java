package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_cover extends JceStruct {
    public String cover_id;
    public String cover_music_h5url;
    public int cover_ts;
    public int cover_type;

    public s_cover() {
        this.cover_id = "";
        this.cover_music_h5url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cover_id = jceInputStream.readString(0, false);
        this.cover_ts = jceInputStream.read(this.cover_ts, 1, false);
        this.cover_type = jceInputStream.read(this.cover_type, 2, false);
        this.cover_music_h5url = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cover_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.cover_ts, 1);
        jceOutputStream.write(this.cover_type, 2);
        String str2 = this.cover_music_h5url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public s_cover(String str, int i3, int i16, String str2) {
        this.cover_id = str;
        this.cover_ts = i3;
        this.cover_type = i16;
        this.cover_music_h5url = str2;
    }
}
