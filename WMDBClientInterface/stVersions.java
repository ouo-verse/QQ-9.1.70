package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stVersions extends JceStruct {
    public int adVersion;
    public int androidPushVersion;
    public int flashSceenVersion;
    public int opVersion;
    public int watermarkVersion;
    public int watermarkVersionAdv;
    public int watermarkVersionInt;
    public int wmResourceVersion;

    public stVersions() {
        this.watermarkVersion = 0;
        this.wmResourceVersion = 0;
        this.flashSceenVersion = 0;
        this.androidPushVersion = 0;
        this.adVersion = 0;
        this.opVersion = 0;
        this.watermarkVersionInt = 0;
        this.watermarkVersionAdv = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.watermarkVersion = jceInputStream.read(this.watermarkVersion, 0, true);
        this.wmResourceVersion = jceInputStream.read(this.wmResourceVersion, 1, true);
        this.flashSceenVersion = jceInputStream.read(this.flashSceenVersion, 2, true);
        this.androidPushVersion = jceInputStream.read(this.androidPushVersion, 3, true);
        this.adVersion = jceInputStream.read(this.adVersion, 4, true);
        this.opVersion = jceInputStream.read(this.opVersion, 5, true);
        this.watermarkVersionInt = jceInputStream.read(this.watermarkVersionInt, 6, false);
        this.watermarkVersionAdv = jceInputStream.read(this.watermarkVersionAdv, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.watermarkVersion, 0);
        jceOutputStream.write(this.wmResourceVersion, 1);
        jceOutputStream.write(this.flashSceenVersion, 2);
        jceOutputStream.write(this.androidPushVersion, 3);
        jceOutputStream.write(this.adVersion, 4);
        jceOutputStream.write(this.opVersion, 5);
        jceOutputStream.write(this.watermarkVersionInt, 6);
        jceOutputStream.write(this.watermarkVersionAdv, 7);
    }

    public stVersions(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.watermarkVersion = i3;
        this.wmResourceVersion = i16;
        this.flashSceenVersion = i17;
        this.androidPushVersion = i18;
        this.adVersion = i19;
        this.opVersion = i26;
        this.watermarkVersionInt = i27;
        this.watermarkVersionAdv = i28;
    }
}
