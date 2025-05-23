package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetSameStateList extends JceStruct {
    static int cache_eFetchSex;
    static int cache_eSelfSex;
    static BusiReqHead cache_oHead;
    static LBSInfo cache_oLbsInfo;
    static stRishState cache_oSelfRishState;
    static byte[] cache_vCookie;
    public int eFetchSex;
    public int eSelfSex;
    public int iPageSize;
    public long lFriendUin;
    public BusiReqHead oHead;
    public LBSInfo oLbsInfo;
    public stRishState oSelfRishState;
    public byte[] vCookie;

    public ReqGetSameStateList() {
        this.oHead = null;
        this.vCookie = null;
        this.oSelfRishState = null;
        this.iPageSize = -1;
        this.oLbsInfo = null;
        this.eSelfSex = 2;
        this.eFetchSex = -1;
        this.lFriendUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_oHead == null) {
            cache_oHead = new BusiReqHead();
        }
        this.oHead = (BusiReqHead) jceInputStream.read((JceStruct) cache_oHead, 0, true);
        if (cache_vCookie == null) {
            cache_vCookie = r0;
            byte[] bArr = {0};
        }
        this.vCookie = jceInputStream.read(cache_vCookie, 1, true);
        if (cache_oSelfRishState == null) {
            cache_oSelfRishState = new stRishState();
        }
        this.oSelfRishState = (stRishState) jceInputStream.read((JceStruct) cache_oSelfRishState, 2, true);
        this.iPageSize = jceInputStream.read(this.iPageSize, 3, false);
        if (cache_oLbsInfo == null) {
            cache_oLbsInfo = new LBSInfo();
        }
        this.oLbsInfo = (LBSInfo) jceInputStream.read((JceStruct) cache_oLbsInfo, 4, false);
        this.eSelfSex = jceInputStream.read(this.eSelfSex, 5, false);
        this.eFetchSex = jceInputStream.read(this.eFetchSex, 6, false);
        this.lFriendUin = jceInputStream.read(this.lFriendUin, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.oHead, 0);
        jceOutputStream.write(this.vCookie, 1);
        jceOutputStream.write((JceStruct) this.oSelfRishState, 2);
        jceOutputStream.write(this.iPageSize, 3);
        LBSInfo lBSInfo = this.oLbsInfo;
        if (lBSInfo != null) {
            jceOutputStream.write((JceStruct) lBSInfo, 4);
        }
        jceOutputStream.write(this.eSelfSex, 5);
        jceOutputStream.write(this.eFetchSex, 6);
        jceOutputStream.write(this.lFriendUin, 7);
    }

    public ReqGetSameStateList(BusiReqHead busiReqHead, byte[] bArr, stRishState strishstate, int i3, LBSInfo lBSInfo, int i16, int i17, long j3) {
        this.oHead = busiReqHead;
        this.vCookie = bArr;
        this.oSelfRishState = strishstate;
        this.iPageSize = i3;
        this.oLbsInfo = lBSInfo;
        this.eSelfSex = i16;
        this.eFetchSex = i17;
        this.lFriendUin = j3;
    }
}
