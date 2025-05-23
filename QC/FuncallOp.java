package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FuncallOp extends JceStruct {
    public String fuzz_image_url;
    public String image_url;
    public String media_url;
    public String small_image_url;
    public String thumb_nail_url;

    public FuncallOp() {
        this.media_url = "";
        this.image_url = "";
        this.small_image_url = "";
        this.thumb_nail_url = "";
        this.fuzz_image_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.media_url = jceInputStream.readString(0, false);
        this.image_url = jceInputStream.readString(1, false);
        this.small_image_url = jceInputStream.readString(2, false);
        this.thumb_nail_url = jceInputStream.readString(3, false);
        this.fuzz_image_url = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.media_url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.image_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.small_image_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.thumb_nail_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.fuzz_image_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }

    public FuncallOp(String str, String str2, String str3, String str4, String str5) {
        this.media_url = str;
        this.image_url = str2;
        this.small_image_url = str3;
        this.thumb_nail_url = str4;
        this.fuzz_image_url = str5;
    }
}
