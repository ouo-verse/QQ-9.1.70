package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_diss extends JceStruct {
    static ArrayList<s_likeman> cache_dissmans = new ArrayList<>();
    public ArrayList<s_likeman> dissmans;
    public int isdissed;
    public int num;

    static {
        cache_dissmans.add(new s_likeman());
    }

    public cell_diss() {
        this.num = 0;
        this.isdissed = 0;
        this.dissmans = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.isdissed = jceInputStream.read(this.isdissed, 1, false);
        this.dissmans = (ArrayList) jceInputStream.read((JceInputStream) cache_dissmans, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        jceOutputStream.write(this.isdissed, 1);
        ArrayList<s_likeman> arrayList = this.dissmans;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public cell_diss(int i3, int i16, ArrayList<s_likeman> arrayList) {
        this.num = i3;
        this.isdissed = i16;
        this.dissmans = arrayList;
    }
}
