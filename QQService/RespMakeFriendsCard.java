package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespMakeFriendsCard extends JceStruct {
    static RespHead cache_stHeader;
    static MakeFriendsCard cache_stMakeFriendsCard;
    static ArrayList<FaceInfo> cache_vFaceInfo;
    static ArrayList<Visitor> cache_vVisitors;
    static ArrayList<Visitor> cache_vVoter;
    public byte bShareLBS;
    public byte cSqqLevel;
    public int iVoteIncrement;
    public long lCardShowNum;
    public int lListVoterTime;
    public RespHead stHeader;
    public MakeFriendsCard stMakeFriendsCard;
    public ArrayList<FaceInfo> vFaceInfo;
    public ArrayList<Visitor> vVisitors;
    public ArrayList<Visitor> vVoter;

    public RespMakeFriendsCard() {
        this.stHeader = null;
        this.stMakeFriendsCard = null;
        this.lCardShowNum = 0L;
        this.vFaceInfo = null;
        this.iVoteIncrement = 0;
        this.vVisitors = null;
        this.vVoter = null;
        this.lListVoterTime = 0;
        this.bShareLBS = (byte) 0;
        this.cSqqLevel = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stMakeFriendsCard == null) {
            cache_stMakeFriendsCard = new MakeFriendsCard();
        }
        this.stMakeFriendsCard = (MakeFriendsCard) jceInputStream.read((JceStruct) cache_stMakeFriendsCard, 1, true);
        this.lCardShowNum = jceInputStream.read(this.lCardShowNum, 2, true);
        if (cache_vFaceInfo == null) {
            cache_vFaceInfo = new ArrayList<>();
            cache_vFaceInfo.add(new FaceInfo());
        }
        this.vFaceInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vFaceInfo, 3, false);
        this.iVoteIncrement = jceInputStream.read(this.iVoteIncrement, 4, false);
        if (cache_vVisitors == null) {
            cache_vVisitors = new ArrayList<>();
            cache_vVisitors.add(new Visitor());
        }
        this.vVisitors = (ArrayList) jceInputStream.read((JceInputStream) cache_vVisitors, 5, false);
        if (cache_vVoter == null) {
            cache_vVoter = new ArrayList<>();
            cache_vVoter.add(new Visitor());
        }
        this.vVoter = (ArrayList) jceInputStream.read((JceInputStream) cache_vVoter, 6, false);
        this.lListVoterTime = jceInputStream.read(this.lListVoterTime, 7, false);
        this.bShareLBS = jceInputStream.read(this.bShareLBS, 8, false);
        this.cSqqLevel = jceInputStream.read(this.cSqqLevel, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stMakeFriendsCard, 1);
        jceOutputStream.write(this.lCardShowNum, 2);
        ArrayList<FaceInfo> arrayList = this.vFaceInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.iVoteIncrement, 4);
        ArrayList<Visitor> arrayList2 = this.vVisitors;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        ArrayList<Visitor> arrayList3 = this.vVoter;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 6);
        }
        jceOutputStream.write(this.lListVoterTime, 7);
        jceOutputStream.write(this.bShareLBS, 8);
        jceOutputStream.write(this.cSqqLevel, 9);
    }

    public RespMakeFriendsCard(RespHead respHead, MakeFriendsCard makeFriendsCard, long j3, ArrayList<FaceInfo> arrayList, int i3, ArrayList<Visitor> arrayList2, ArrayList<Visitor> arrayList3, int i16, byte b16, byte b17) {
        this.stHeader = respHead;
        this.stMakeFriendsCard = makeFriendsCard;
        this.lCardShowNum = j3;
        this.vFaceInfo = arrayList;
        this.iVoteIncrement = i3;
        this.vVisitors = arrayList2;
        this.vVoter = arrayList3;
        this.lListVoterTime = i16;
        this.bShareLBS = b16;
        this.cSqqLevel = b17;
    }
}
