package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PhotoCell extends JceStruct {
    public String coverUrl;
    public int type;

    public PhotoCell() {
        this.type = 0;
        this.coverUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.coverUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        String str = this.coverUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public PhotoCell(int i3, String str) {
        this.type = i3;
        this.coverUrl = str;
    }
}
