package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetCollectionReq extends JceStruct {
    public String attachInfo;
    public String cid;
    public String feedId;
    public int pageOrder;
    public int scene;

    public stGetCollectionReq() {
        this.attachInfo = "";
        this.cid = "";
        this.scene = 0;
        this.feedId = "";
        this.pageOrder = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.cid = jceInputStream.readString(1, false);
        this.scene = jceInputStream.read(this.scene, 2, false);
        this.feedId = jceInputStream.readString(3, false);
        this.pageOrder = jceInputStream.read(this.pageOrder, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.cid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.scene, 2);
        String str3 = this.feedId;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.pageOrder, 4);
    }

    public stGetCollectionReq(String str, String str2, int i3, String str3, int i16) {
        this.attachInfo = str;
        this.cid = str2;
        this.scene = i3;
        this.feedId = str3;
        this.pageOrder = i16;
    }
}
