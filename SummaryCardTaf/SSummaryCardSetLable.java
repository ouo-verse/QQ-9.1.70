package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardSetLable extends JceStruct {
    static int cache_cmd;
    static ArrayList<Long> cache_lables;
    public int cmd;
    public ArrayList<Long> lables;
    public long platform;
    public long uin;
    public String version;

    public SSummaryCardSetLable() {
        this.cmd = 4;
        this.uin = 0L;
        this.version = "5.2.0";
        this.platform = 0L;
        this.lables = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmd = jceInputStream.read(this.cmd, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
        this.version = jceInputStream.readString(2, false);
        this.platform = jceInputStream.read(this.platform, 3, false);
        if (cache_lables == null) {
            cache_lables = new ArrayList<>();
            cache_lables.add(0L);
        }
        this.lables = (ArrayList) jceInputStream.read((JceInputStream) cache_lables, 4, true);
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
        jceOutputStream.write((Collection) this.lables, 4);
    }

    public SSummaryCardSetLable(int i3, long j3, String str, long j16, ArrayList<Long> arrayList) {
        this.cmd = i3;
        this.uin = j3;
        this.version = str;
        this.platform = j16;
        this.lables = arrayList;
    }
}
