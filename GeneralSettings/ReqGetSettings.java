package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetSettings extends JceStruct {
    static ArrayList<String> cache_Paths;
    public long Count;
    public long Offset;
    public ArrayList<String> Paths;
    public int Revision;

    public ReqGetSettings() {
        this.Revision = 0;
        this.Paths = null;
        this.Offset = 0L;
        this.Count = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Revision = jceInputStream.read(this.Revision, 0, true);
        if (cache_Paths == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_Paths = arrayList;
            arrayList.add("");
        }
        this.Paths = (ArrayList) jceInputStream.read((JceInputStream) cache_Paths, 1, true);
        this.Offset = jceInputStream.read(this.Offset, 2, false);
        this.Count = jceInputStream.read(this.Count, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Revision, 0);
        jceOutputStream.write((Collection) this.Paths, 1);
        jceOutputStream.write(this.Offset, 2);
        jceOutputStream.write(this.Count, 3);
    }

    public ReqGetSettings(int i3, ArrayList<String> arrayList, long j3, long j16) {
        this.Revision = i3;
        this.Paths = arrayList;
        this.Offset = j3;
        this.Count = j16;
    }
}
