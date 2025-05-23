package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PhotoSearchBoxChosenItemElem extends JceStruct {
    static int cache_type;
    public String categoryid;
    public int type;

    public PhotoSearchBoxChosenItemElem() {
        this.type = 0;
        this.categoryid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.categoryid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public PhotoSearchBoxChosenItemElem(int i3, String str) {
        this.type = i3;
        this.categoryid = str;
    }
}
