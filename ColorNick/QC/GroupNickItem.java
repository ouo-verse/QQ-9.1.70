package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupNickItem extends JceStruct {
    public int itemid;
    public String url;

    public GroupNickItem() {
        this.itemid = 0;
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.itemid = jceInputStream.read(this.itemid, 0, false);
        this.url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.itemid, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GroupNickItem(int i3, String str) {
        this.itemid = i3;
        this.url = str;
    }
}
