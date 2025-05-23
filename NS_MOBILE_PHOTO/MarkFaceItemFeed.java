package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MarkFaceItemFeed extends JceStruct {
    static stFaceItem cache_faceinfo = new stFaceItem();
    static int cache_op;
    public String albumid;
    public stFaceItem faceinfo;

    /* renamed from: op, reason: collision with root package name */
    public int f25031op;
    public String photoid;

    public MarkFaceItemFeed() {
        this.f25031op = 0;
        this.faceinfo = null;
        this.albumid = "";
        this.photoid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25031op = jceInputStream.read(this.f25031op, 0, false);
        this.faceinfo = (stFaceItem) jceInputStream.read((JceStruct) cache_faceinfo, 1, false);
        this.albumid = jceInputStream.readString(2, false);
        this.photoid = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25031op, 0);
        stFaceItem stfaceitem = this.faceinfo;
        if (stfaceitem != null) {
            jceOutputStream.write((JceStruct) stfaceitem, 1);
        }
        String str = this.albumid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.photoid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public MarkFaceItemFeed(int i3, stFaceItem stfaceitem, String str, String str2) {
        this.f25031op = i3;
        this.faceinfo = stfaceitem;
        this.albumid = str;
        this.photoid = str2;
    }
}
