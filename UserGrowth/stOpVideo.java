package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stOpVideo extends JceStruct {
    static stSchema cache_jump = new stSchema();
    public String h5_url;
    public String img_url;
    public stSchema jump;
    public String schema;
    public String text;
    public int videoType;

    public stOpVideo() {
        this.videoType = 0;
        this.h5_url = "";
        this.schema = "";
        this.jump = null;
        this.text = "";
        this.img_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.videoType = jceInputStream.read(this.videoType, 0, false);
        this.h5_url = jceInputStream.readString(1, false);
        this.schema = jceInputStream.readString(2, false);
        this.jump = (stSchema) jceInputStream.read((JceStruct) cache_jump, 3, false);
        this.text = jceInputStream.readString(4, false);
        this.img_url = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.videoType, 0);
        String str = this.h5_url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.schema;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        stSchema stschema = this.jump;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 3);
        }
        String str3 = this.text;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.img_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
    }

    public stOpVideo(int i3, String str, String str2, stSchema stschema, String str3, String str4) {
        this.videoType = i3;
        this.h5_url = str;
        this.schema = str2;
        this.jump = stschema;
        this.text = str3;
        this.img_url = str4;
    }
}
