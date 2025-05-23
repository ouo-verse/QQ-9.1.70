package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetSubjectMsgDetailRsp extends JceStruct {
    static ArrayList<stNotifyMsg> cache_readMsg;
    static stMsgRedDotCount cache_totalCount = new stMsgRedDotCount();
    static ArrayList<stNotifyMsg> cache_unreadMsg = new ArrayList<>();
    public String attachInfo;
    public boolean isFinished;
    public ArrayList<stNotifyMsg> readMsg;
    public int subjectID;
    public stMsgRedDotCount totalCount;
    public ArrayList<stNotifyMsg> unreadMsg;

    static {
        cache_unreadMsg.add(new stNotifyMsg());
        cache_readMsg = new ArrayList<>();
        cache_readMsg.add(new stNotifyMsg());
    }

    public stGetSubjectMsgDetailRsp() {
        this.attachInfo = "";
        this.isFinished = true;
        this.subjectID = 0;
        this.totalCount = null;
        this.unreadMsg = null;
        this.readMsg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.isFinished = jceInputStream.read(this.isFinished, 1, false);
        this.subjectID = jceInputStream.read(this.subjectID, 2, false);
        this.totalCount = (stMsgRedDotCount) jceInputStream.read((JceStruct) cache_totalCount, 3, false);
        this.unreadMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_unreadMsg, 4, false);
        this.readMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_readMsg, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.isFinished, 1);
        jceOutputStream.write(this.subjectID, 2);
        stMsgRedDotCount stmsgreddotcount = this.totalCount;
        if (stmsgreddotcount != null) {
            jceOutputStream.write((JceStruct) stmsgreddotcount, 3);
        }
        ArrayList<stNotifyMsg> arrayList = this.unreadMsg;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<stNotifyMsg> arrayList2 = this.readMsg;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
    }

    public stGetSubjectMsgDetailRsp(String str, boolean z16, int i3, stMsgRedDotCount stmsgreddotcount, ArrayList<stNotifyMsg> arrayList, ArrayList<stNotifyMsg> arrayList2) {
        this.attachInfo = str;
        this.isFinished = z16;
        this.subjectID = i3;
        this.totalCount = stmsgreddotcount;
        this.unreadMsg = arrayList;
        this.readMsg = arrayList2;
    }
}
