package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPlayShowCatMatTreeReq extends JceStruct {
    public String ETag;
    public String MqVersion;

    public GetPlayShowCatMatTreeReq() {
        this.ETag = "";
        this.MqVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ETag = jceInputStream.readString(0, false);
        this.MqVersion = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ETag;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.MqVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public GetPlayShowCatMatTreeReq(String str, String str2) {
        this.ETag = str;
        this.MqVersion = str2;
    }
}
