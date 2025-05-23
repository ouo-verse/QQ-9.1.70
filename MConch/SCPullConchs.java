package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SCPullConchs extends JceStruct {
    static ArrayList<ConchTask> cache_conchTaskList = new ArrayList<>();
    public int result = 0;
    public ArrayList<ConchTask> conchTaskList = null;

    static {
        cache_conchTaskList.add(new ConchTask());
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new SCPullConchs();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, false);
        this.conchTaskList = (ArrayList) jceInputStream.read((JceInputStream) cache_conchTaskList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        int i3 = this.result;
        if (i3 != 0) {
            jceOutputStream.write(i3, 0);
        }
        ArrayList<ConchTask> arrayList = this.conchTaskList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }
}
