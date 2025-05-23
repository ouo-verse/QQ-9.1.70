package NS_QZONE_GASHAPON;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_user_gashapon_rsp extends JceStruct {
    public int iFrameRate;
    public String strH5Url;
    public String strPicUrl;
    public String strTextUrl;
    public long uiGashaponCount;

    public get_user_gashapon_rsp() {
        this.strPicUrl = "";
        this.strTextUrl = "";
        this.strH5Url = "";
        this.uiGashaponCount = 0L;
        this.iFrameRate = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPicUrl = jceInputStream.readString(0, false);
        this.strTextUrl = jceInputStream.readString(1, false);
        this.strH5Url = jceInputStream.readString(2, false);
        this.uiGashaponCount = jceInputStream.read(this.uiGashaponCount, 3, false);
        this.iFrameRate = jceInputStream.read(this.iFrameRate, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strPicUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strTextUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strH5Url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.uiGashaponCount, 3);
        jceOutputStream.write(this.iFrameRate, 4);
    }

    public get_user_gashapon_rsp(String str, String str2, String str3, long j3, int i3) {
        this.strPicUrl = str;
        this.strTextUrl = str2;
        this.strH5Url = str3;
        this.uiGashaponCount = j3;
        this.iFrameRate = i3;
    }
}
