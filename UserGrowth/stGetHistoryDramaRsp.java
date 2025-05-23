package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetHistoryDramaRsp extends JceStruct {
    static ArrayList<stDrama> cache_dramas = new ArrayList<>();
    public String attachInfo;
    public ArrayList<stDrama> dramas;
    public boolean isFinished;
    public int total;

    static {
        cache_dramas.add(new stDrama());
    }

    public stGetHistoryDramaRsp() {
        this.attachInfo = "";
        this.isFinished = true;
        this.dramas = null;
        this.total = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.isFinished = jceInputStream.read(this.isFinished, 1, false);
        this.dramas = (ArrayList) jceInputStream.read((JceInputStream) cache_dramas, 2, false);
        this.total = jceInputStream.read(this.total, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.isFinished, 1);
        ArrayList<stDrama> arrayList = this.dramas;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.total, 3);
    }

    public stGetHistoryDramaRsp(String str, boolean z16, ArrayList<stDrama> arrayList, int i3) {
        this.attachInfo = str;
        this.isFinished = z16;
        this.dramas = arrayList;
        this.total = i3;
    }
}
