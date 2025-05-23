package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MarkFaceItemMood extends JceStruct {
    static stFaceItem cache_faceinfo = new stFaceItem();
    static int cache_op;
    public stFaceItem faceinfo;

    /* renamed from: op, reason: collision with root package name */
    public int f25032op;
    public String photo_url;
    public String shuoshuo_id;

    public MarkFaceItemMood() {
        this.f25032op = 0;
        this.faceinfo = null;
        this.shuoshuo_id = "";
        this.photo_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25032op = jceInputStream.read(this.f25032op, 0, false);
        this.faceinfo = (stFaceItem) jceInputStream.read((JceStruct) cache_faceinfo, 1, false);
        this.shuoshuo_id = jceInputStream.readString(2, false);
        this.photo_url = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25032op, 0);
        stFaceItem stfaceitem = this.faceinfo;
        if (stfaceitem != null) {
            jceOutputStream.write((JceStruct) stfaceitem, 1);
        }
        String str = this.shuoshuo_id;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.photo_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public MarkFaceItemMood(int i3, stFaceItem stfaceitem, String str, String str2) {
        this.f25032op = i3;
        this.faceinfo = stfaceitem;
        this.shuoshuo_id = str;
        this.photo_url = str2;
    }
}
