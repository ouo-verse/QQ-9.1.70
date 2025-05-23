package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetFollowedDramasRsp extends JceStruct {
    static ArrayList<stDrama> cache_dramas = new ArrayList<>();
    public String attachInfo;
    public ArrayList<stDrama> dramas;
    public boolean isFinished;
    public String title;

    static {
        cache_dramas.add(new stDrama());
    }

    public stGetFollowedDramasRsp() {
        this.attachInfo = "";
        this.isFinished = true;
        this.dramas = null;
        this.title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.isFinished = jceInputStream.read(this.isFinished, 1, false);
        this.dramas = (ArrayList) jceInputStream.read((JceInputStream) cache_dramas, 2, false);
        this.title = jceInputStream.readString(3, false);
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
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public stGetFollowedDramasRsp(String str, boolean z16, ArrayList<stDrama> arrayList, String str2) {
        this.attachInfo = str;
        this.isFinished = z16;
        this.dramas = arrayList;
        this.title = str2;
    }
}
