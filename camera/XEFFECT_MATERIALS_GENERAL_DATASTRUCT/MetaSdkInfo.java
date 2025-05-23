package camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MetaSdkInfo extends JceStruct {
    public int sdk;
    public String sdkVersion;

    public MetaSdkInfo() {
        this.sdk = 0;
        this.sdkVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sdk = jceInputStream.read(this.sdk, 0, false);
        this.sdkVersion = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sdk, 0);
        String str = this.sdkVersion;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public MetaSdkInfo(int i3, String str) {
        this.sdk = i3;
        this.sdkVersion = str;
    }
}
