package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetImageClassifyReq extends JceStruct {
    static SmartFilterReqItem cache_SinglePic = new SmartFilterReqItem();
    public SmartFilterReqItem SinglePic;

    public GetImageClassifyReq() {
        this.SinglePic = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.SinglePic = (SmartFilterReqItem) jceInputStream.read((JceStruct) cache_SinglePic, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        SmartFilterReqItem smartFilterReqItem = this.SinglePic;
        if (smartFilterReqItem != null) {
            jceOutputStream.write((JceStruct) smartFilterReqItem, 0);
        }
    }

    public GetImageClassifyReq(SmartFilterReqItem smartFilterReqItem) {
        this.SinglePic = smartFilterReqItem;
    }
}
