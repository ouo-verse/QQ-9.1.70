package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_recomed_list extends JceStruct {
    static ArrayList<s_likeman> cache_likemans = new ArrayList<>();
    public int isrecomed;
    public ArrayList<s_likeman> likemans;
    public int num;

    static {
        cache_likemans.add(new s_likeman());
    }

    public cell_recomed_list() {
        this.num = 0;
        this.isrecomed = 0;
        this.likemans = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.isrecomed = jceInputStream.read(this.isrecomed, 1, false);
        this.likemans = (ArrayList) jceInputStream.read((JceInputStream) cache_likemans, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        jceOutputStream.write(this.isrecomed, 1);
        ArrayList<s_likeman> arrayList = this.likemans;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public cell_recomed_list(int i3, int i16, ArrayList<s_likeman> arrayList) {
        this.num = i3;
        this.isrecomed = i16;
        this.likemans = arrayList;
    }
}
