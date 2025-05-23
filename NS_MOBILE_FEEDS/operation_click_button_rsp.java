package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_click_button_rsp extends JceStruct {
    public int iRet;
    public String strButtonText;
    public String strJumpUrl;
    public String strToastText;

    public operation_click_button_rsp() {
        this.iRet = 0;
        this.strButtonText = "";
        this.strJumpUrl = "";
        this.strToastText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, false);
        this.strButtonText = jceInputStream.readString(1, false);
        this.strJumpUrl = jceInputStream.readString(2, false);
        this.strToastText = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        String str = this.strButtonText;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strToastText;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public operation_click_button_rsp(int i3, String str, String str2, String str3) {
        this.iRet = i3;
        this.strButtonText = str;
        this.strJumpUrl = str2;
        this.strToastText = str3;
    }
}
