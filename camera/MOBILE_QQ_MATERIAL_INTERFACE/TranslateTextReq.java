package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TranslateTextReq extends JceStruct {
    static Text[] cache_SouceLanguageText = new Text[1];
    static String[] cache_TargetLanguages;
    public Text[] SouceLanguageText;
    public String SourceLanguage;
    public String[] TargetLanguages;

    static {
        cache_SouceLanguageText[0] = new Text();
        cache_TargetLanguages = r0;
        String[] strArr = {""};
    }

    public TranslateTextReq() {
        this.SouceLanguageText = null;
        this.SourceLanguage = "";
        this.TargetLanguages = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.SouceLanguageText = (Text[]) jceInputStream.read((JceStruct[]) cache_SouceLanguageText, 0, false);
        this.SourceLanguage = jceInputStream.readString(1, false);
        this.TargetLanguages = jceInputStream.read(cache_TargetLanguages, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Text[] textArr = this.SouceLanguageText;
        if (textArr != null) {
            jceOutputStream.write((Object[]) textArr, 0);
        }
        String str = this.SourceLanguage;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String[] strArr = this.TargetLanguages;
        if (strArr != null) {
            jceOutputStream.write((Object[]) strArr, 2);
        }
    }

    public TranslateTextReq(Text[] textArr, String str, String[] strArr) {
        this.SouceLanguageText = textArr;
        this.SourceLanguage = str;
        this.TargetLanguages = strArr;
    }
}
