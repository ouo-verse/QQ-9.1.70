package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PushInfo extends JceStruct {
    static ArrayList<SingleMsg> cache_vecMsg = new ArrayList<>();
    public String Mark;
    public long opUin;
    public long uin;
    public ArrayList<SingleMsg> vecMsg;

    static {
        cache_vecMsg.add(new SingleMsg());
    }

    public PushInfo() {
        this.Mark = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.vecMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecMsg, 1, false);
        this.opUin = jceInputStream.read(this.opUin, 2, false);
        this.Mark = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        ArrayList<SingleMsg> arrayList = this.vecMsg;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.opUin, 2);
        String str = this.Mark;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public PushInfo(long j3, ArrayList<SingleMsg> arrayList, long j16, String str) {
        this.uin = j3;
        this.vecMsg = arrayList;
        this.opUin = j16;
        this.Mark = str;
    }
}
