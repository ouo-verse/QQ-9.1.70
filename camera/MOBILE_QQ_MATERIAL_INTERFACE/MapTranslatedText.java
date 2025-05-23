package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MapTranslatedText extends JceStruct {
    static Text[] cache_TranslatedText = new Text[1];
    public String Language;
    public Text[] TranslatedText;

    static {
        cache_TranslatedText[0] = new Text();
    }

    public MapTranslatedText() {
        this.Language = "";
        this.TranslatedText = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Language = jceInputStream.readString(0, false);
        this.TranslatedText = (Text[]) jceInputStream.read((JceStruct[]) cache_TranslatedText, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.Language;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Text[] textArr = this.TranslatedText;
        if (textArr != null) {
            jceOutputStream.write((Object[]) textArr, 1);
        }
    }

    public MapTranslatedText(String str, Text[] textArr) {
        this.Language = str;
        this.TranslatedText = textArr;
    }
}
