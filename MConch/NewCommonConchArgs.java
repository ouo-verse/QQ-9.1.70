package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NewCommonConchArgs extends JceStruct {
    static ArrayList<String> cache_newParam;
    public ArrayList<String> newParam = null;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_newParam = arrayList;
        arrayList.add("");
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new NewCommonConchArgs();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.newParam = (ArrayList) jceInputStream.read((JceInputStream) cache_newParam, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.newParam;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }
}
