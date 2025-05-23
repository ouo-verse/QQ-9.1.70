package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_present extends JceStruct {
    static ArrayList<s_presentman> cache_presentmans = new ArrayList<>();
    public long num;
    public ArrayList<s_presentman> presentmans;

    static {
        cache_presentmans.add(new s_presentman());
    }

    public cell_present() {
        this.num = 0L;
        this.presentmans = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.presentmans = (ArrayList) jceInputStream.read((JceInputStream) cache_presentmans, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        ArrayList<s_presentman> arrayList = this.presentmans;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public cell_present(long j3, ArrayList<s_presentman> arrayList) {
        this.num = j3;
        this.presentmans = arrayList;
    }
}
