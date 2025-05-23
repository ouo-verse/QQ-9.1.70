package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ZPlanPictureToAvatarRsp extends JceStruct {
    static ZPlanPtaResult cache_ZPlan = new ZPlanPtaResult();
    public int Code;
    public ZPlanPtaResult ZPlan;

    public ZPlanPictureToAvatarRsp() {
        this.ZPlan = null;
        this.Code = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ZPlan = (ZPlanPtaResult) jceInputStream.read((JceStruct) cache_ZPlan, 0, false);
        this.Code = jceInputStream.read(this.Code, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ZPlanPtaResult zPlanPtaResult = this.ZPlan;
        if (zPlanPtaResult != null) {
            jceOutputStream.write((JceStruct) zPlanPtaResult, 0);
        }
        jceOutputStream.write(this.Code, 1);
    }

    public ZPlanPictureToAvatarRsp(ZPlanPtaResult zPlanPtaResult, int i3) {
        this.ZPlan = zPlanPtaResult;
        this.Code = i3;
    }
}
