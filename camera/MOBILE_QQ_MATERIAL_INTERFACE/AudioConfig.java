package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AudioConfig extends JceStruct {
    static int cache_AudioEncoding;
    public int AudioEncoding;
    public double Pitch;
    public double SpeakingRate;
    public double Volume;

    public AudioConfig() {
        this.AudioEncoding = 0;
        this.SpeakingRate = 0.0d;
        this.Pitch = 0.0d;
        this.Volume = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.AudioEncoding = jceInputStream.read(this.AudioEncoding, 0, false);
        this.SpeakingRate = jceInputStream.read(this.SpeakingRate, 1, false);
        this.Pitch = jceInputStream.read(this.Pitch, 2, false);
        this.Volume = jceInputStream.read(this.Volume, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.AudioEncoding, 0);
        jceOutputStream.write(this.SpeakingRate, 1);
        jceOutputStream.write(this.Pitch, 2);
        jceOutputStream.write(this.Volume, 3);
    }

    public AudioConfig(int i3, double d16, double d17, double d18) {
        this.AudioEncoding = i3;
        this.SpeakingRate = d16;
        this.Pitch = d17;
        this.Volume = d18;
    }
}
