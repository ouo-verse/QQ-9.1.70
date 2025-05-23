package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_get_my_item_req extends JceStruct {
    public int iAppid;
    public long lUin;

    public material_get_my_item_req() {
        this.lUin = 0L;
        this.iAppid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.iAppid = jceInputStream.read(this.iAppid, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iAppid, 1);
    }

    public material_get_my_item_req(long j3, int i3) {
        this.lUin = j3;
        this.iAppid = i3;
    }
}
