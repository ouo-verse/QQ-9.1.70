package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stUpdateItemResult extends JceStruct {
    static stFaceItem cache_faceitem;
    public stFaceItem faceitem;

    /* renamed from: msg, reason: collision with root package name */
    public String f25044msg;
    public int ret;

    public stUpdateItemResult() {
        this.f25044msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_faceitem == null) {
            cache_faceitem = new stFaceItem();
        }
        this.faceitem = (stFaceItem) jceInputStream.read((JceStruct) cache_faceitem, 0, true);
        this.ret = jceInputStream.read(this.ret, 1, true);
        this.f25044msg = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.faceitem, 0);
        jceOutputStream.write(this.ret, 1);
        jceOutputStream.write(this.f25044msg, 2);
    }

    public stUpdateItemResult(stFaceItem stfaceitem, int i3, String str) {
        this.faceitem = stfaceitem;
        this.ret = i3;
        this.f25044msg = str;
    }
}
