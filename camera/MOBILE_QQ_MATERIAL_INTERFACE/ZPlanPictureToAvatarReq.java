package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ZPlanPictureToAvatarReq extends JceStruct {
    static byte[] cache_Rawdata;
    public String Gender;
    public String ModelVer;
    public byte[] Rawdata;

    static {
        cache_Rawdata = r0;
        byte[] bArr = {0};
    }

    public ZPlanPictureToAvatarReq() {
        this.Rawdata = null;
        this.Gender = "";
        this.ModelVer = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Rawdata = jceInputStream.read(cache_Rawdata, 0, false);
        this.Gender = jceInputStream.readString(1, false);
        this.ModelVer = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.Rawdata;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        String str = this.Gender;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.ModelVer;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public ZPlanPictureToAvatarReq(byte[] bArr, String str, String str2) {
        this.Rawdata = bArr;
        this.Gender = str;
        this.ModelVer = str2;
    }
}
