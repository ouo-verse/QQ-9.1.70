package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRoamToastRsp extends JceStruct {
    public String sToast;
    public String sToastKey;
    public String sUrl;

    public GetRoamToastRsp() {
        this.sToast = "";
        this.sToastKey = "";
        this.sUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sToast = jceInputStream.readString(0, false);
        this.sToastKey = jceInputStream.readString(1, false);
        this.sUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sToast;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sToastKey;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public GetRoamToastRsp(String str, String str2, String str3) {
        this.sToast = str;
        this.sToastKey = str2;
        this.sUrl = str3;
    }
}
