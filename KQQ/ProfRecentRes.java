package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfRecentRes extends JceStruct {
    static ArrayList<FriendUinInfo> cache_vFriendInfo;
    public byte cMask;
    public byte cResult;
    public long uServerTime;
    public ArrayList<FriendUinInfo> vFriendInfo;
    public short wFriendNum;

    public ProfRecentRes() {
        this.cResult = (byte) 0;
        this.uServerTime = 0L;
        this.cMask = (byte) 0;
        this.wFriendNum = (short) 0;
        this.vFriendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cResult = jceInputStream.read(this.cResult, 1, true);
        this.uServerTime = jceInputStream.read(this.uServerTime, 2, true);
        this.cMask = jceInputStream.read(this.cMask, 3, true);
        this.wFriendNum = jceInputStream.read(this.wFriendNum, 4, true);
        if (cache_vFriendInfo == null) {
            cache_vFriendInfo = new ArrayList<>();
            cache_vFriendInfo.add(new FriendUinInfo());
        }
        this.vFriendInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vFriendInfo, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cResult, 1);
        jceOutputStream.write(this.uServerTime, 2);
        jceOutputStream.write(this.cMask, 3);
        jceOutputStream.write(this.wFriendNum, 4);
        jceOutputStream.write((Collection) this.vFriendInfo, 5);
    }

    public ProfRecentRes(byte b16, long j3, byte b17, short s16, ArrayList<FriendUinInfo> arrayList) {
        this.cResult = b16;
        this.uServerTime = j3;
        this.cMask = b17;
        this.wFriendNum = s16;
        this.vFriendInfo = arrayList;
    }
}
