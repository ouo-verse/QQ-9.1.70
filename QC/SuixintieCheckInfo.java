package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SuixintieCheckInfo extends JceStruct {
    static ArrayList<SuixintieCheckItem> cache_vSuixintieCheckList = new ArrayList<>();
    public ArrayList<SuixintieCheckItem> vSuixintieCheckList;

    static {
        cache_vSuixintieCheckList.add(new SuixintieCheckItem());
    }

    public SuixintieCheckInfo() {
        this.vSuixintieCheckList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vSuixintieCheckList = (ArrayList) jceInputStream.read((JceInputStream) cache_vSuixintieCheckList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<SuixintieCheckItem> arrayList = this.vSuixintieCheckList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public SuixintieCheckInfo(ArrayList<SuixintieCheckItem> arrayList) {
        this.vSuixintieCheckList = arrayList;
    }
}
