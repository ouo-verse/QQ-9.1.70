package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetImageClassifyRsp extends JceStruct {
    static SmartFilterRspItem cache_SingleRet = new SmartFilterRspItem();
    public SmartFilterRspItem SingleRet;

    public GetImageClassifyRsp() {
        this.SingleRet = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.SingleRet = (SmartFilterRspItem) jceInputStream.read((JceStruct) cache_SingleRet, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        SmartFilterRspItem smartFilterRspItem = this.SingleRet;
        if (smartFilterRspItem != null) {
            jceOutputStream.write((JceStruct) smartFilterRspItem, 0);
        }
    }

    public GetImageClassifyRsp(SmartFilterRspItem smartFilterRspItem) {
        this.SingleRet = smartFilterRspItem;
    }
}
