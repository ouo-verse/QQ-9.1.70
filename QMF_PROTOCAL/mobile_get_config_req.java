package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_config_req extends JceStruct {
    public int appid;
    public String cookies;
    public int scene;

    public mobile_get_config_req() {
        this.cookies = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.cookies = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.scene, 1);
        String str = this.cookies;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public mobile_get_config_req(int i3, int i16, String str) {
        this.appid = i3;
        this.scene = i16;
        this.cookies = str;
    }
}
