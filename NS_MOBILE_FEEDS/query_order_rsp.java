package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class query_order_rsp extends JceStruct {
    public int iProduct;
    public int iResult;
    public int iStatus;

    public query_order_rsp() {
        this.iResult = 0;
        this.iProduct = 0;
        this.iStatus = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iResult = jceInputStream.read(this.iResult, 0, false);
        this.iProduct = jceInputStream.read(this.iProduct, 1, false);
        this.iStatus = jceInputStream.read(this.iStatus, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iResult, 0);
        jceOutputStream.write(this.iProduct, 1);
        jceOutputStream.write(this.iStatus, 2);
    }

    public query_order_rsp(int i3, int i16, int i17) {
        this.iResult = i3;
        this.iProduct = i16;
        this.iStatus = i17;
    }
}
