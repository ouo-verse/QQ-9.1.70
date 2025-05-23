package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class SvcReqPushMsg extends JceStruct {
    static Map<String, byte[]> cache_mPreviews;
    static ArrayList<MsgInfo> cache_vMsgInfos = new ArrayList<>();
    static byte[] cache_vSyncCookie;
    static ArrayList<UinPairMsg> cache_vUinPairMsg;
    public long lUin;
    public Map<String, byte[]> mPreviews;
    public int svrip;
    public long uMsgTime;
    public ArrayList<MsgInfo> vMsgInfos;
    public byte[] vSyncCookie;
    public ArrayList<UinPairMsg> vUinPairMsg;
    public int wGeneralFlag;
    public int wUserActive;

    static {
        cache_vMsgInfos.add(new MsgInfo());
        cache_vSyncCookie = r1;
        byte[] bArr = {0};
        cache_vUinPairMsg = new ArrayList<>();
        cache_vUinPairMsg.add(new UinPairMsg());
        HashMap hashMap = new HashMap();
        cache_mPreviews = hashMap;
        hashMap.put("", new byte[]{0});
    }

    public SvcReqPushMsg() {
        this.lUin = 0L;
        this.uMsgTime = 0L;
        this.vMsgInfos = null;
        this.svrip = 0;
        this.vSyncCookie = null;
        this.vUinPairMsg = null;
        this.mPreviews = null;
        this.wUserActive = 0;
        this.wGeneralFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 1, true);
        this.vMsgInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vMsgInfos, 2, true);
        this.svrip = jceInputStream.read(this.svrip, 3, true);
        this.vSyncCookie = jceInputStream.read(cache_vSyncCookie, 4, false);
        this.vUinPairMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_vUinPairMsg, 5, false);
        this.mPreviews = (Map) jceInputStream.read((JceInputStream) cache_mPreviews, 6, false);
        this.wUserActive = jceInputStream.read(this.wUserActive, 7, false);
        this.wGeneralFlag = jceInputStream.read(this.wGeneralFlag, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.uMsgTime, 1);
        jceOutputStream.write((Collection) this.vMsgInfos, 2);
        jceOutputStream.write(this.svrip, 3);
        byte[] bArr = this.vSyncCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        ArrayList<UinPairMsg> arrayList = this.vUinPairMsg;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        Map<String, byte[]> map = this.mPreviews;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        jceOutputStream.write(this.wUserActive, 7);
        jceOutputStream.write(this.wGeneralFlag, 12);
    }

    public SvcReqPushMsg(long j3, long j16, ArrayList<MsgInfo> arrayList, int i3, byte[] bArr, ArrayList<UinPairMsg> arrayList2, Map<String, byte[]> map, int i16, int i17) {
        this.lUin = j3;
        this.uMsgTime = j16;
        this.vMsgInfos = arrayList;
        this.svrip = i3;
        this.vSyncCookie = bArr;
        this.vUinPairMsg = arrayList2;
        this.mPreviews = map;
        this.wUserActive = i16;
        this.wGeneralFlag = i17;
    }
}
