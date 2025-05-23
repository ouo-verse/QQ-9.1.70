package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetHorseRaceMaterialsReq extends JceStruct {
    public String Uin;

    public GetHorseRaceMaterialsReq() {
        this.Uin = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Uin = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.Uin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public GetHorseRaceMaterialsReq(String str) {
        this.Uin = str;
    }
}
