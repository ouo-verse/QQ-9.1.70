package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class UinPairMsg extends JceStruct {
    static ArrayList<SvcGetMsgInfo> cache_vMsgInfos;
    public long lPeerUin;
    public long uLastReadTime;
    public long uMsgCompleted;
    public ArrayList<SvcGetMsgInfo> vMsgInfos;

    public UinPairMsg() {
        this.uLastReadTime = 0L;
        this.lPeerUin = 0L;
        this.uMsgCompleted = 0L;
        this.vMsgInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uLastReadTime = jceInputStream.read(this.uLastReadTime, 1, false);
        this.lPeerUin = jceInputStream.read(this.lPeerUin, 2, false);
        this.uMsgCompleted = jceInputStream.read(this.uMsgCompleted, 3, false);
        if (cache_vMsgInfos == null) {
            cache_vMsgInfos = new ArrayList<>();
            cache_vMsgInfos.add(new SvcGetMsgInfo());
        }
        this.vMsgInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vMsgInfos, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uLastReadTime, 1);
        jceOutputStream.write(this.lPeerUin, 2);
        jceOutputStream.write(this.uMsgCompleted, 3);
        ArrayList<SvcGetMsgInfo> arrayList = this.vMsgInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public UinPairMsg(long j3, long j16, long j17, ArrayList<SvcGetMsgInfo> arrayList) {
        this.uLastReadTime = j3;
        this.lPeerUin = j16;
        this.uMsgCompleted = j17;
        this.vMsgInfos = arrayList;
    }
}
