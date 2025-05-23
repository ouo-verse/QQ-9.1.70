package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusinessItem extends JceStruct {
    public int appid;
    public String hashid;
    public int itemid;

    public UniBusinessItem() {
        this.appid = 0;
        this.itemid = 0;
        this.hashid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.itemid = jceInputStream.read(this.itemid, 1, false);
        this.hashid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.itemid, 1);
        String str = this.hashid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public UniBusinessItem(int i3, int i16, String str) {
        this.appid = i3;
        this.itemid = i16;
        this.hashid = str;
    }
}
