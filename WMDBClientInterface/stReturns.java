package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stReturns extends JceStruct {
    public int retAD;
    public int retAndroidPush;
    public int retFlashScreen;
    public int retOperation;
    public int retWMResource;
    public int retWatermark;
    public int retWatermarkAdv;
    public int retWatermarkInt;

    public stReturns() {
        this.retWatermark = 0;
        this.retWMResource = 0;
        this.retFlashScreen = 0;
        this.retAndroidPush = 0;
        this.retAD = 0;
        this.retOperation = 0;
        this.retWatermarkInt = 0;
        this.retWatermarkAdv = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retWatermark = jceInputStream.read(this.retWatermark, 0, true);
        this.retWMResource = jceInputStream.read(this.retWMResource, 1, true);
        this.retFlashScreen = jceInputStream.read(this.retFlashScreen, 2, true);
        this.retAndroidPush = jceInputStream.read(this.retAndroidPush, 3, true);
        this.retAD = jceInputStream.read(this.retAD, 4, true);
        this.retOperation = jceInputStream.read(this.retOperation, 5, true);
        this.retWatermarkInt = jceInputStream.read(this.retWatermarkInt, 6, false);
        this.retWatermarkAdv = jceInputStream.read(this.retWatermarkAdv, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retWatermark, 0);
        jceOutputStream.write(this.retWMResource, 1);
        jceOutputStream.write(this.retFlashScreen, 2);
        jceOutputStream.write(this.retAndroidPush, 3);
        jceOutputStream.write(this.retAD, 4);
        jceOutputStream.write(this.retOperation, 5);
        jceOutputStream.write(this.retWatermarkInt, 6);
        jceOutputStream.write(this.retWatermarkAdv, 7);
    }

    public stReturns(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.retWatermark = i3;
        this.retWMResource = i16;
        this.retFlashScreen = i17;
        this.retAndroidPush = i18;
        this.retAD = i19;
        this.retOperation = i26;
        this.retWatermarkInt = i27;
        this.retWatermarkAdv = i28;
    }
}
