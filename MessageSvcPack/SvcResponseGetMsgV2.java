package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcResponseGetMsgV2 extends JceStruct {
    static int cache_cSyncFlag;
    static ArrayList<AccostMsg> cache_vAccostMsg;
    static byte[] cache_vCookies;
    static ArrayList<SvcGetMsgInfo> cache_vMsgInfos;
    static byte[] cache_vSyncCookie;
    static ArrayList<UinPairMsg> cache_vUinPairMsg;
    public byte cMoreMsg;
    public byte cReplyCode;
    public int cSyncFlag;
    public int iAccostTotalUnread;
    public long lUin;
    public short shSumMsg;
    public String strResult;
    public int uMsgTime;
    public ArrayList<AccostMsg> vAccostMsg;
    public byte[] vCookies;
    public ArrayList<SvcGetMsgInfo> vMsgInfos;
    public byte[] vSyncCookie;
    public ArrayList<UinPairMsg> vUinPairMsg;

    public SvcResponseGetMsgV2() {
        this.lUin = 0L;
        this.cReplyCode = (byte) 0;
        this.strResult = "";
        this.uMsgTime = 0;
        this.cMoreMsg = (byte) 0;
        this.shSumMsg = (short) 0;
        this.vMsgInfos = null;
        this.vAccostMsg = null;
        this.vCookies = null;
        this.iAccostTotalUnread = 0;
        this.vSyncCookie = null;
        this.cSyncFlag = 0;
        this.vUinPairMsg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cReplyCode = jceInputStream.read(this.cReplyCode, 1, true);
        this.strResult = jceInputStream.readString(2, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 3, true);
        this.cMoreMsg = jceInputStream.read(this.cMoreMsg, 4, true);
        this.shSumMsg = jceInputStream.read(this.shSumMsg, 5, true);
        if (cache_vMsgInfos == null) {
            cache_vMsgInfos = new ArrayList<>();
            cache_vMsgInfos.add(new SvcGetMsgInfo());
        }
        this.vMsgInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vMsgInfos, 6, true);
        if (cache_vAccostMsg == null) {
            cache_vAccostMsg = new ArrayList<>();
            cache_vAccostMsg.add(new AccostMsg());
        }
        this.vAccostMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_vAccostMsg, 7, true);
        if (cache_vCookies == null) {
            cache_vCookies = r0;
            byte[] bArr = {0};
        }
        this.vCookies = jceInputStream.read(cache_vCookies, 8, false);
        this.iAccostTotalUnread = jceInputStream.read(this.iAccostTotalUnread, 9, false);
        if (cache_vSyncCookie == null) {
            cache_vSyncCookie = r0;
            byte[] bArr2 = {0};
        }
        this.vSyncCookie = jceInputStream.read(cache_vSyncCookie, 10, false);
        this.cSyncFlag = jceInputStream.read(this.cSyncFlag, 11, false);
        if (cache_vUinPairMsg == null) {
            cache_vUinPairMsg = new ArrayList<>();
            cache_vUinPairMsg.add(new UinPairMsg());
        }
        this.vUinPairMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_vUinPairMsg, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cReplyCode, 1);
        jceOutputStream.write(this.strResult, 2);
        jceOutputStream.write(this.uMsgTime, 3);
        jceOutputStream.write(this.cMoreMsg, 4);
        jceOutputStream.write(this.shSumMsg, 5);
        jceOutputStream.write((Collection) this.vMsgInfos, 6);
        jceOutputStream.write((Collection) this.vAccostMsg, 7);
        byte[] bArr = this.vCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
        jceOutputStream.write(this.iAccostTotalUnread, 9);
        byte[] bArr2 = this.vSyncCookie;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 10);
        }
        jceOutputStream.write(this.cSyncFlag, 11);
        ArrayList<UinPairMsg> arrayList = this.vUinPairMsg;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 12);
        }
    }

    public SvcResponseGetMsgV2(long j3, byte b16, String str, int i3, byte b17, short s16, ArrayList<SvcGetMsgInfo> arrayList, ArrayList<AccostMsg> arrayList2, byte[] bArr, int i16, byte[] bArr2, int i17, ArrayList<UinPairMsg> arrayList3) {
        this.lUin = j3;
        this.cReplyCode = b16;
        this.strResult = str;
        this.uMsgTime = i3;
        this.cMoreMsg = b17;
        this.shSumMsg = s16;
        this.vMsgInfos = arrayList;
        this.vAccostMsg = arrayList2;
        this.vCookies = bArr;
        this.iAccostTotalUnread = i16;
        this.vSyncCookie = bArr2;
        this.cSyncFlag = i17;
        this.vUinPairMsg = arrayList3;
    }
}
