package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Funcall extends JceStruct {
    static ArrayList<Long> cache_rptUins = new ArrayList<>();
    public int funcallId;
    public int ringId;
    public ArrayList<Long> rptUins;

    static {
        cache_rptUins.add(0L);
    }

    public Funcall() {
        this.funcallId = 0;
        this.ringId = 0;
        this.rptUins = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.funcallId = jceInputStream.read(this.funcallId, 0, false);
        this.ringId = jceInputStream.read(this.ringId, 1, false);
        this.rptUins = (ArrayList) jceInputStream.read((JceInputStream) cache_rptUins, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.funcallId, 0);
        jceOutputStream.write(this.ringId, 1);
        ArrayList<Long> arrayList = this.rptUins;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public Funcall(int i3, int i16, ArrayList<Long> arrayList) {
        this.funcallId = i3;
        this.ringId = i16;
        this.rptUins = arrayList;
    }
}
