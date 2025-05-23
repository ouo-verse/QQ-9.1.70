package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaUgcVideoSeg extends JceStruct {
    static stMetaLoudNorm cache_meta_loudnorm = new stMetaLoudNorm();
    public int duration;
    public String file_id;
    public int file_size;
    public int h265_hvc1;
    public int height;
    public String loudnorm;
    public int max_db;
    public String md5;
    public stMetaLoudNorm meta_loudnorm;
    public int orientation;
    public int play_index;
    public String sha1;
    public double voice_ratio;
    public int width;

    public stMetaUgcVideoSeg() {
        this.file_id = "";
        this.file_size = 0;
        this.sha1 = "";
        this.play_index = 0;
        this.duration = 0;
        this.width = 0;
        this.height = 0;
        this.md5 = "";
        this.orientation = 0;
        this.h265_hvc1 = 0;
        this.max_db = 0;
        this.voice_ratio = 0.0d;
        this.loudnorm = "";
        this.meta_loudnorm = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.file_id = jceInputStream.readString(0, false);
        this.file_size = jceInputStream.read(this.file_size, 1, false);
        this.sha1 = jceInputStream.readString(2, false);
        this.play_index = jceInputStream.read(this.play_index, 3, false);
        this.duration = jceInputStream.read(this.duration, 4, false);
        this.width = jceInputStream.read(this.width, 5, false);
        this.height = jceInputStream.read(this.height, 6, false);
        this.md5 = jceInputStream.readString(7, false);
        this.orientation = jceInputStream.read(this.orientation, 8, false);
        this.h265_hvc1 = jceInputStream.read(this.h265_hvc1, 9, false);
        this.max_db = jceInputStream.read(this.max_db, 10, false);
        this.voice_ratio = jceInputStream.read(this.voice_ratio, 11, false);
        this.loudnorm = jceInputStream.readString(12, false);
        this.meta_loudnorm = (stMetaLoudNorm) jceInputStream.read((JceStruct) cache_meta_loudnorm, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.file_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.file_size, 1);
        String str2 = this.sha1;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.play_index, 3);
        jceOutputStream.write(this.duration, 4);
        jceOutputStream.write(this.width, 5);
        jceOutputStream.write(this.height, 6);
        String str3 = this.md5;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.orientation, 8);
        jceOutputStream.write(this.h265_hvc1, 9);
        jceOutputStream.write(this.max_db, 10);
        jceOutputStream.write(this.voice_ratio, 11);
        String str4 = this.loudnorm;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        stMetaLoudNorm stmetaloudnorm = this.meta_loudnorm;
        if (stmetaloudnorm != null) {
            jceOutputStream.write((JceStruct) stmetaloudnorm, 13);
        }
    }

    public stMetaUgcVideoSeg(String str, int i3, String str2, int i16, int i17, int i18, int i19, String str3, int i26, int i27, int i28, double d16, String str4, stMetaLoudNorm stmetaloudnorm) {
        this.file_id = str;
        this.file_size = i3;
        this.sha1 = str2;
        this.play_index = i16;
        this.duration = i17;
        this.width = i18;
        this.height = i19;
        this.md5 = str3;
        this.orientation = i26;
        this.h265_hvc1 = i27;
        this.max_db = i28;
        this.voice_ratio = d16;
        this.loudnorm = str4;
        this.meta_loudnorm = stmetaloudnorm;
    }
}
