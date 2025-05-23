package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UgcRightInfo extends JceStruct {
    static ArrayList<Long> cache_allow_uins = new ArrayList<>();
    public ArrayList<Long> allow_uins;
    public int ugc_right;

    static {
        cache_allow_uins.add(0L);
    }

    public UgcRightInfo() {
        this.ugc_right = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ugc_right = jceInputStream.read(this.ugc_right, 0, false);
        this.allow_uins = (ArrayList) jceInputStream.read((JceInputStream) cache_allow_uins, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ugc_right, 0);
        ArrayList<Long> arrayList = this.allow_uins;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public UgcRightInfo(int i3, ArrayList<Long> arrayList) {
        this.ugc_right = i3;
        this.allow_uins = arrayList;
    }
}
