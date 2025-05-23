package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ConchTask extends JceStruct {
    static ArrayList<Conch> cache_conchList = new ArrayList<>();
    public long taskId = 0;
    public long taskSeqno = 0;
    public ArrayList<Conch> conchList = null;

    static {
        cache_conchList.add(new Conch());
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ConchTask();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.taskId = jceInputStream.read(this.taskId, 0, false);
        this.taskSeqno = jceInputStream.read(this.taskSeqno, 1, false);
        this.conchList = (ArrayList) jceInputStream.read((JceInputStream) cache_conchList, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        long j3 = this.taskId;
        if (j3 != 0) {
            jceOutputStream.write(j3, 0);
        }
        long j16 = this.taskSeqno;
        if (j16 != 0) {
            jceOutputStream.write(j16, 1);
        }
        ArrayList<Conch> arrayList = this.conchList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }
}
