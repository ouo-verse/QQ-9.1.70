package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRedDotReq extends JceStruct {
    static ArrayList<Integer> cache_exposedType = new ArrayList<>();
    static int cache_reddotAction;
    public ArrayList<Integer> exposedType;
    public int reddotAction;
    public int reddotType;

    static {
        cache_exposedType.add(0);
    }

    public stRedDotReq() {
        this.reddotType = 0;
        this.reddotAction = 0;
        this.exposedType = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reddotType = jceInputStream.read(this.reddotType, 0, false);
        this.reddotAction = jceInputStream.read(this.reddotAction, 1, false);
        this.exposedType = (ArrayList) jceInputStream.read((JceInputStream) cache_exposedType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reddotType, 0);
        jceOutputStream.write(this.reddotAction, 1);
        ArrayList<Integer> arrayList = this.exposedType;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public stRedDotReq(int i3, int i16, ArrayList<Integer> arrayList) {
        this.reddotType = i3;
        this.reddotAction = i16;
        this.exposedType = arrayList;
    }
}
