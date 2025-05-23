package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class GetGroupRedPackListRsp extends JceStruct {
    static ArrayList<RedPackGrapInfo> cache_vecRedPackList = new ArrayList<>();
    public int iRetCode = 0;
    public int iRedPackNum = 0;
    public ArrayList<RedPackGrapInfo> vecRedPackList = null;
    public long lFailureTime = 0;

    static {
        cache_vecRedPackList.add(new RedPackGrapInfo());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRetCode = jceInputStream.read(this.iRetCode, 0, false);
        this.iRedPackNum = jceInputStream.read(this.iRedPackNum, 1, false);
        this.vecRedPackList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRedPackList, 2, false);
        this.lFailureTime = jceInputStream.read(this.lFailureTime, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRetCode, 0);
        jceOutputStream.write(this.iRedPackNum, 1);
        ArrayList<RedPackGrapInfo> arrayList = this.vecRedPackList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.lFailureTime, 3);
    }
}
