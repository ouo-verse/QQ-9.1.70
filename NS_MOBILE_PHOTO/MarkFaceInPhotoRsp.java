package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class MarkFaceInPhotoRsp extends JceStruct {
    static stFaceItem cache_faceitem = new stFaceItem();
    public stFaceItem faceitem;

    /* renamed from: msg, reason: collision with root package name */
    public String f25030msg;
    public int ret;

    public MarkFaceInPhotoRsp() {
        this.ret = 0;
        this.f25030msg = "";
        this.faceitem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25030msg = jceInputStream.readString(1, false);
        this.faceitem = (stFaceItem) jceInputStream.read((JceStruct) cache_faceitem, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25030msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        stFaceItem stfaceitem = this.faceitem;
        if (stfaceitem != null) {
            jceOutputStream.write((JceStruct) stfaceitem, 2);
        }
    }

    public MarkFaceInPhotoRsp(int i3, String str, stFaceItem stfaceitem) {
        this.ret = i3;
        this.f25030msg = str;
        this.faceitem = stfaceitem;
    }
}
