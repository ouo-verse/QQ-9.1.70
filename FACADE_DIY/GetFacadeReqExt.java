package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetFacadeReqExt extends JceStruct {
    public String cachedChecksum;

    public GetFacadeReqExt() {
        this.cachedChecksum = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cachedChecksum = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cachedChecksum;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public GetFacadeReqExt(String str) {
        this.cachedChecksum = str;
    }
}
