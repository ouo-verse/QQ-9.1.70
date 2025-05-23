package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRecommandTextByEmotionRsp extends JceStruct {
    static ArrayList<String> cache_RecTexts;
    public int Code;
    public String Emo;
    public ArrayList<String> RecTexts;
    public String UiNumConfig;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_RecTexts = arrayList;
        arrayList.add("");
    }

    public GetRecommandTextByEmotionRsp() {
        this.Code = 0;
        this.Emo = "";
        this.RecTexts = null;
        this.UiNumConfig = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Emo = jceInputStream.readString(1, false);
        this.RecTexts = (ArrayList) jceInputStream.read((JceInputStream) cache_RecTexts, 2, false);
        this.UiNumConfig = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Emo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<String> arrayList = this.RecTexts;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.UiNumConfig;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public GetRecommandTextByEmotionRsp(int i3, String str, ArrayList<String> arrayList, String str2) {
        this.Code = i3;
        this.Emo = str;
        this.RecTexts = arrayList;
        this.UiNumConfig = str2;
    }
}
