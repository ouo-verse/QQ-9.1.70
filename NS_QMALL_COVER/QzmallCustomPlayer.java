package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class QzmallCustomPlayer extends JceStruct {
    public int iItemId;
    public long lTextColor;
    public String strPlayerDecoUrl;

    public QzmallCustomPlayer() {
        this.iItemId = -1;
        this.strPlayerDecoUrl = "";
        this.lTextColor = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strPlayerDecoUrl = jceInputStream.readString(1, false);
        this.lTextColor = jceInputStream.read(this.lTextColor, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strPlayerDecoUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.lTextColor, 2);
    }

    public QzmallCustomPlayer(int i3, String str, long j3) {
        this.iItemId = i3;
        this.strPlayerDecoUrl = str;
        this.lTextColor = j3;
    }
}
