package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupNickEmoji extends JceStruct {
    public int itemid;

    public GroupNickEmoji() {
        this.itemid = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.itemid = jceInputStream.read(this.itemid, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.itemid, 0);
    }

    public GroupNickEmoji(int i3) {
        this.itemid = i3;
    }
}
