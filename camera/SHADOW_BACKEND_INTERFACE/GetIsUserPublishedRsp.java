package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetIsUserPublishedRsp extends JceStruct {
    public boolean IsPublished;

    public GetIsUserPublishedRsp() {
        this.IsPublished = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.IsPublished = jceInputStream.read(this.IsPublished, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.IsPublished, 0);
    }

    public GetIsUserPublishedRsp(boolean z16) {
        this.IsPublished = z16;
    }
}
