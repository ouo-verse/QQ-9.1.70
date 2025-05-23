package DCClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDataCollectionReq extends JceStruct {
    static ArrayList<stDataPackage> cache_dataPackages;
    public ArrayList<stDataPackage> dataPackages;

    public stDataCollectionReq() {
        this.dataPackages = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_dataPackages == null) {
            cache_dataPackages = new ArrayList<>();
            cache_dataPackages.add(new stDataPackage());
        }
        this.dataPackages = (ArrayList) jceInputStream.read((JceInputStream) cache_dataPackages, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.dataPackages, 0);
    }

    public stDataCollectionReq(ArrayList<stDataPackage> arrayList) {
        this.dataPackages = arrayList;
    }
}
