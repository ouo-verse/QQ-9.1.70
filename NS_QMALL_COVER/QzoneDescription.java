package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzoneDescription extends JceStruct {
    static int cache_iType;
    public int iHeight;
    public int iType;
    public int iWidth;
    public String strJumpUrl;
    public String strUrl;

    public QzoneDescription() {
        this.strUrl = "";
        this.strJumpUrl = "";
        this.iType = 0;
        this.iHeight = 0;
        this.iWidth = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strUrl = jceInputStream.readString(0, false);
        this.strJumpUrl = jceInputStream.readString(1, false);
        this.iType = jceInputStream.read(this.iType, 2, false);
        this.iHeight = jceInputStream.read(this.iHeight, 3, false);
        this.iWidth = jceInputStream.read(this.iWidth, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.iType, 2);
        jceOutputStream.write(this.iHeight, 3);
        jceOutputStream.write(this.iWidth, 4);
    }

    public QzoneDescription(String str, String str2, int i3, int i16, int i17) {
        this.strUrl = str;
        this.strJumpUrl = str2;
        this.iType = i3;
        this.iHeight = i16;
        this.iWidth = i17;
    }
}
