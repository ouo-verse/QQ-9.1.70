package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_video_adapter_rsp extends JceStruct {
    public int iType;
    public String strData;
    public String strOrgUrl;

    public mobile_video_adapter_rsp() {
        this.strData = "";
        this.strOrgUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, false);
        this.strData = jceInputStream.readString(1, false);
        this.strOrgUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        String str = this.strData;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strOrgUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public mobile_video_adapter_rsp(int i3, String str, String str2) {
        this.iType = i3;
        this.strData = str;
        this.strOrgUrl = str2;
    }
}
