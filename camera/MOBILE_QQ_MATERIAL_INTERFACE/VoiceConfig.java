package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VoiceConfig extends JceStruct {
    public String LanguageCode;
    public String SpeakerType;

    public VoiceConfig() {
        this.LanguageCode = "";
        this.SpeakerType = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.LanguageCode = jceInputStream.readString(0, false);
        this.SpeakerType = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.LanguageCode;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.SpeakerType;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public VoiceConfig(String str, String str2) {
        this.LanguageCode = str;
        this.SpeakerType = str2;
    }
}
