package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TranslateTextRsp extends JceStruct {
    static MapTranslatedText[] cache_TranslatedText = new MapTranslatedText[1];
    public int Code;
    public String Msg;
    public MapTranslatedText[] TranslatedText;

    static {
        cache_TranslatedText[0] = new MapTranslatedText();
    }

    public TranslateTextRsp() {
        this.Code = 0;
        this.Msg = "";
        this.TranslatedText = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Msg = jceInputStream.readString(1, false);
        this.TranslatedText = (MapTranslatedText[]) jceInputStream.read((JceStruct[]) cache_TranslatedText, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        MapTranslatedText[] mapTranslatedTextArr = this.TranslatedText;
        if (mapTranslatedTextArr != null) {
            jceOutputStream.write((Object[]) mapTranslatedTextArr, 2);
        }
    }

    public TranslateTextRsp(int i3, String str, MapTranslatedText[] mapTranslatedTextArr) {
        this.Code = i3;
        this.Msg = str;
        this.TranslatedText = mapTranslatedTextArr;
    }
}
