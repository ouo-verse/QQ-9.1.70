package NS_CLIENT_SHOW_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public class QzmallCommentBadge extends JceStruct {
    public int bigClubLevel;
    public int itemid;
    public String jumpUrl;

    public QzmallCommentBadge() {
        this.itemid = 0;
        this.bigClubLevel = 0;
        this.jumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.itemid = jceInputStream.read(this.itemid, 0, false);
        this.bigClubLevel = jceInputStream.read(this.bigClubLevel, 1, false);
        this.jumpUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.itemid, 0);
        jceOutputStream.write(this.bigClubLevel, 1);
        String str = this.jumpUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public QzmallCommentBadge(int i3, int i16, String str) {
        this.itemid = i3;
        this.bigClubLevel = i16;
        this.jumpUrl = str;
    }
}
