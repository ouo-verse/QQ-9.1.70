package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RealSyncRes extends JceStruct {
    static ArrayList<InfoItem> cache_vecResPkg;
    public byte result;
    public ArrayList<InfoItem> vecResPkg;

    public RealSyncRes() {
        this.result = (byte) 0;
        this.vecResPkg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        if (cache_vecResPkg == null) {
            cache_vecResPkg = new ArrayList<>();
            cache_vecResPkg.add(new InfoItem());
        }
        this.vecResPkg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResPkg, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write((Collection) this.vecResPkg, 1);
    }

    public RealSyncRes(byte b16, ArrayList<InfoItem> arrayList) {
        this.result = b16;
        this.vecResPkg = arrayList;
    }
}
