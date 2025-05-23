package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class QzmallCustomPassivePraise extends JceStruct {
    public int iItemId;
    public int iType;
    public String strCmShowActionId;
    public String strFullScreenUrl;

    public QzmallCustomPassivePraise() {
        this.iItemId = -1;
        this.strFullScreenUrl = "";
        this.iType = 0;
        this.strCmShowActionId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strFullScreenUrl = jceInputStream.readString(1, false);
        this.iType = jceInputStream.read(this.iType, 2, false);
        this.strCmShowActionId = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strFullScreenUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iType, 2);
        String str2 = this.strCmShowActionId;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public QzmallCustomPassivePraise(int i3, String str, int i16, String str2) {
        this.iItemId = i3;
        this.strFullScreenUrl = str;
        this.iType = i16;
        this.strCmShowActionId = str2;
    }
}
