package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShareTraceList extends JceStruct {
    static ArrayList<Long> cache_vecClose;
    static ArrayList<Long> cache_vecOpen;
    public byte cType;
    public ArrayList<Long> vecClose;
    public ArrayList<Long> vecOpen;

    public ShareTraceList() {
        this.cType = (byte) 0;
        this.vecOpen = null;
        this.vecClose = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cType = jceInputStream.read(this.cType, 0, true);
        if (cache_vecOpen == null) {
            cache_vecOpen = new ArrayList<>();
            cache_vecOpen.add(0L);
        }
        this.vecOpen = (ArrayList) jceInputStream.read((JceInputStream) cache_vecOpen, 1, false);
        if (cache_vecClose == null) {
            cache_vecClose = new ArrayList<>();
            cache_vecClose.add(0L);
        }
        this.vecClose = (ArrayList) jceInputStream.read((JceInputStream) cache_vecClose, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cType, 0);
        ArrayList<Long> arrayList = this.vecOpen;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<Long> arrayList2 = this.vecClose;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public ShareTraceList(byte b16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.cType = b16;
        this.vecOpen = arrayList;
        this.vecClose = arrayList2;
    }
}
