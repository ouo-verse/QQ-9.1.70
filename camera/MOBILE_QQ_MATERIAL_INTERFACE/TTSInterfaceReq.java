package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TTSInterfaceReq extends JceStruct {
    static int cache_TTSTemplateType;
    static String[] cache_Texts;
    public AudioConfig AudioConfig;
    public boolean NeedAudioRawData;
    public int TTSTemplateType;
    public String[] Texts;
    public VoiceConfig VoiceConfig;
    static VoiceConfig cache_VoiceConfig = new VoiceConfig();
    static AudioConfig cache_AudioConfig = new AudioConfig();

    static {
        cache_Texts = r0;
        String[] strArr = {""};
    }

    public TTSInterfaceReq() {
        this.Texts = null;
        this.TTSTemplateType = 0;
        this.VoiceConfig = null;
        this.AudioConfig = null;
        this.NeedAudioRawData = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Texts = jceInputStream.read(cache_Texts, 0, false);
        this.TTSTemplateType = jceInputStream.read(this.TTSTemplateType, 1, false);
        this.VoiceConfig = (VoiceConfig) jceInputStream.read((JceStruct) cache_VoiceConfig, 2, false);
        this.AudioConfig = (AudioConfig) jceInputStream.read((JceStruct) cache_AudioConfig, 3, false);
        this.NeedAudioRawData = jceInputStream.read(this.NeedAudioRawData, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String[] strArr = this.Texts;
        if (strArr != null) {
            jceOutputStream.write((Object[]) strArr, 0);
        }
        jceOutputStream.write(this.TTSTemplateType, 1);
        VoiceConfig voiceConfig = this.VoiceConfig;
        if (voiceConfig != null) {
            jceOutputStream.write((JceStruct) voiceConfig, 2);
        }
        AudioConfig audioConfig = this.AudioConfig;
        if (audioConfig != null) {
            jceOutputStream.write((JceStruct) audioConfig, 3);
        }
        jceOutputStream.write(this.NeedAudioRawData, 4);
    }

    public TTSInterfaceReq(String[] strArr, int i3, VoiceConfig voiceConfig, AudioConfig audioConfig, boolean z16) {
        this.Texts = strArr;
        this.TTSTemplateType = i3;
        this.VoiceConfig = voiceConfig;
        this.AudioConfig = audioConfig;
        this.NeedAudioRawData = z16;
    }
}
