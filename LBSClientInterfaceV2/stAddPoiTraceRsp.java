package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stAddPoiTraceRsp extends JceStruct {
    public int iTotalNum;

    public stAddPoiTraceRsp() {
        this.iTotalNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTotalNum = jceInputStream.read(this.iTotalNum, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTotalNum, 0);
    }

    public stAddPoiTraceRsp(int i3) {
        this.iTotalNum = i3;
    }
}
