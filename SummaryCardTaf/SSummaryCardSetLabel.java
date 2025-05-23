package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardSetLabel extends JceStruct {
    static int cache_cmd;
    static ArrayList<Long> cache_labels;
    public int cmd;
    public ArrayList<Long> labels;
    public long platform;
    public long uin;
    public String version;

    public SSummaryCardSetLabel() {
        this.cmd = 4;
        this.uin = 0L;
        this.version = "5.2.0";
        this.platform = 0L;
        this.labels = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.version = jceInputStream.readString(2, false);
        this.platform = jceInputStream.read(this.platform, 3, false);
        if (cache_labels == null) {
            cache_labels = new ArrayList<>();
            cache_labels.add(0L);
        }
        this.labels = (ArrayList) jceInputStream.read((JceInputStream) cache_labels, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmd, 0);
        jceOutputStream.write(this.uin, 1);
        String str = this.version;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.platform, 3);
        jceOutputStream.write((Collection) this.labels, 4);
    }

    public SSummaryCardSetLabel(int i3, long j3, String str, long j16, ArrayList<Long> arrayList) {
        this.cmd = i3;
        this.uin = j3;
        this.version = str;
        this.platform = j16;
        this.labels = arrayList;
    }
}
