package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReturnToPraise extends JceStruct {
    public int iItemId;
    public String strLeftHandUrl;
    public String strRightHandUrl;
    public String strText;

    public ReturnToPraise() {
        this.strRightHandUrl = "";
        this.strLeftHandUrl = "";
        this.strText = "";
        this.iItemId = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strRightHandUrl = jceInputStream.readString(0, false);
        this.strLeftHandUrl = jceInputStream.readString(1, false);
        this.strText = jceInputStream.readString(2, false);
        this.iItemId = jceInputStream.read(this.iItemId, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strRightHandUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strLeftHandUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strText;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.iItemId, 3);
    }

    public ReturnToPraise(String str, String str2, String str3, int i3) {
        this.strRightHandUrl = str;
        this.strLeftHandUrl = str2;
        this.strText = str3;
        this.iItemId = i3;
    }
}
