package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StrangerSkin extends JceStruct {
    public int iItemId;
    public String strImageUrl;
    public String strJumpUrl;
    public String strTextColor1;
    public String strTextColor2;

    public StrangerSkin() {
        this.strImageUrl = "";
        this.strTextColor1 = "";
        this.strTextColor2 = "";
        this.iItemId = -1;
        this.strJumpUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strImageUrl = jceInputStream.readString(0, false);
        this.strTextColor1 = jceInputStream.readString(1, false);
        this.strTextColor2 = jceInputStream.readString(2, false);
        this.iItemId = jceInputStream.read(this.iItemId, 3, false);
        this.strJumpUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strImageUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strTextColor1;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strTextColor2;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.iItemId, 3);
        String str4 = this.strJumpUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public StrangerSkin(String str, String str2, String str3, int i3, String str4) {
        this.strImageUrl = str;
        this.strTextColor1 = str2;
        this.strTextColor2 = str3;
        this.iItemId = i3;
        this.strJumpUrl = str4;
    }
}
