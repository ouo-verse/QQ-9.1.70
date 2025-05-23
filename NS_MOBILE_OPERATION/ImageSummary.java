package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ImageSummary extends JceStruct {
    public String bubbleUrl;
    public String imageId;
    public int source_id;
    public String url;

    public ImageSummary() {
        this.imageId = "";
        this.url = "";
        this.bubbleUrl = "";
        this.source_id = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imageId = jceInputStream.readString(0, true);
        this.url = jceInputStream.readString(1, false);
        this.bubbleUrl = jceInputStream.readString(2, false);
        this.source_id = jceInputStream.read(this.source_id, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imageId, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.bubbleUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.source_id, 3);
    }

    public ImageSummary(String str, String str2, String str3, int i3) {
        this.imageId = str;
        this.url = str2;
        this.bubbleUrl = str3;
        this.source_id = i3;
    }
}
