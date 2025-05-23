package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TTSInterfaceRsp extends JceStruct {
    static AudioInfo[] cache_AudioInfos = new AudioInfo[1];
    public AudioInfo[] AudioInfos;
    public int Code;

    static {
        cache_AudioInfos[0] = new AudioInfo();
    }

    public TTSInterfaceRsp() {
        this.Code = 0;
        this.AudioInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.AudioInfos = (AudioInfo[]) jceInputStream.read((JceStruct[]) cache_AudioInfos, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        AudioInfo[] audioInfoArr = this.AudioInfos;
        if (audioInfoArr != null) {
            jceOutputStream.write((Object[]) audioInfoArr, 1);
        }
    }

    public TTSInterfaceRsp(int i3, AudioInfo[] audioInfoArr) {
        this.Code = i3;
        this.AudioInfos = audioInfoArr;
    }
}
