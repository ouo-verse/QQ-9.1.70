package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class UserProfile extends JceStruct {
    static int cache_eUserIdentityType;
    static VipBaseInfo cache_stVipInfo = new VipBaseInfo();
    static byte[] cache_vC2CSign;
    static byte[] cache_vFaceID;
    static byte[] cache_vIntroContent;
    static byte[] cache_vRichSign;
    public byte bAge;
    public short bAvailableCnt;
    public short bCloseNeighborVote;
    public byte bConstellation;
    public byte bFavorited;
    public byte bFavoritedMe;
    public short bIsLastVoteCharged;
    public short bMutualFriends;
    public byte bSex;
    public byte bSingle;
    public short bTodayVotedCnt;
    public short bTollVoteCnt;
    public byte bVote;
    public short bVoteCnt;
    public long dwLikeCustomId;
    public int eUserIdentityType;
    public long lEctID;
    public int lTime;
    public int nFaceNum;
    public short shIntroType;
    public VipBaseInfo stVipInfo;
    public String strNick;
    public long uSource;
    public byte[] vC2CSign;
    public byte[] vFaceID;
    public byte[] vIntroContent;
    public byte[] vRichSign;
    public short wFace;

    static {
        cache_vIntroContent = r1;
        byte[] bArr = {0};
        cache_vFaceID = r1;
        byte[] bArr2 = {0};
        cache_vRichSign = r1;
        byte[] bArr3 = {0};
        cache_vC2CSign = r0;
        byte[] bArr4 = {0};
    }

    public UserProfile() {
        this.lEctID = 0L;
        this.lTime = -1;
        this.wFace = (short) 0;
        this.bSex = (byte) -1;
        this.bAge = (byte) -1;
        this.strNick = "";
        this.nFaceNum = 0;
        this.eUserIdentityType = 0;
        this.shIntroType = (short) 0;
        this.vIntroContent = null;
        this.vFaceID = null;
        this.bVote = (byte) -1;
        this.bSingle = (byte) -1;
        this.bFavorited = (byte) -1;
        this.bFavoritedMe = (byte) -1;
        this.vRichSign = null;
        this.bConstellation = (byte) 0;
        this.stVipInfo = null;
        this.vC2CSign = null;
        this.bVoteCnt = (short) 0;
        this.uSource = 0L;
        this.bAvailableCnt = (short) 0;
        this.bTodayVotedCnt = (short) 0;
        this.bCloseNeighborVote = (short) 0;
        this.dwLikeCustomId = 0L;
        this.bTollVoteCnt = (short) 0;
        this.bIsLastVoteCharged = (short) 0;
        this.bMutualFriends = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lEctID = jceInputStream.read(this.lEctID, 0, true);
        this.lTime = jceInputStream.read(this.lTime, 1, true);
        this.wFace = jceInputStream.read(this.wFace, 2, true);
        this.bSex = jceInputStream.read(this.bSex, 3, true);
        this.bAge = jceInputStream.read(this.bAge, 4, true);
        this.strNick = jceInputStream.readString(5, true);
        this.nFaceNum = jceInputStream.read(this.nFaceNum, 6, false);
        this.eUserIdentityType = jceInputStream.read(this.eUserIdentityType, 7, false);
        this.shIntroType = jceInputStream.read(this.shIntroType, 8, false);
        this.vIntroContent = jceInputStream.read(cache_vIntroContent, 9, false);
        this.vFaceID = jceInputStream.read(cache_vFaceID, 10, false);
        this.bVote = jceInputStream.read(this.bVote, 11, false);
        this.bSingle = jceInputStream.read(this.bSingle, 12, false);
        this.bFavorited = jceInputStream.read(this.bFavorited, 13, false);
        this.bFavoritedMe = jceInputStream.read(this.bFavoritedMe, 14, false);
        this.vRichSign = jceInputStream.read(cache_vRichSign, 15, false);
        this.bConstellation = jceInputStream.read(this.bConstellation, 16, false);
        this.stVipInfo = (VipBaseInfo) jceInputStream.read((JceStruct) cache_stVipInfo, 17, false);
        this.vC2CSign = jceInputStream.read(cache_vC2CSign, 18, false);
        this.bVoteCnt = jceInputStream.read(this.bVoteCnt, 19, false);
        this.uSource = jceInputStream.read(this.uSource, 20, false);
        this.bAvailableCnt = jceInputStream.read(this.bAvailableCnt, 21, false);
        this.bTodayVotedCnt = jceInputStream.read(this.bTodayVotedCnt, 22, false);
        this.bCloseNeighborVote = jceInputStream.read(this.bCloseNeighborVote, 23, false);
        this.dwLikeCustomId = jceInputStream.read(this.dwLikeCustomId, 24, false);
        this.bTollVoteCnt = jceInputStream.read(this.bTollVoteCnt, 25, false);
        this.bIsLastVoteCharged = jceInputStream.read(this.bIsLastVoteCharged, 26, false);
        this.bMutualFriends = jceInputStream.read(this.bMutualFriends, 27, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lEctID, 0);
        jceOutputStream.write(this.lTime, 1);
        jceOutputStream.write(this.wFace, 2);
        jceOutputStream.write(this.bSex, 3);
        jceOutputStream.write(this.bAge, 4);
        jceOutputStream.write(this.strNick, 5);
        jceOutputStream.write(this.nFaceNum, 6);
        jceOutputStream.write(this.eUserIdentityType, 7);
        jceOutputStream.write(this.shIntroType, 8);
        byte[] bArr = this.vIntroContent;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
        byte[] bArr2 = this.vFaceID;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 10);
        }
        jceOutputStream.write(this.bVote, 11);
        jceOutputStream.write(this.bSingle, 12);
        jceOutputStream.write(this.bFavorited, 13);
        jceOutputStream.write(this.bFavoritedMe, 14);
        byte[] bArr3 = this.vRichSign;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 15);
        }
        jceOutputStream.write(this.bConstellation, 16);
        VipBaseInfo vipBaseInfo = this.stVipInfo;
        if (vipBaseInfo != null) {
            jceOutputStream.write((JceStruct) vipBaseInfo, 17);
        }
        byte[] bArr4 = this.vC2CSign;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 18);
        }
        jceOutputStream.write(this.bVoteCnt, 19);
        jceOutputStream.write(this.uSource, 20);
        jceOutputStream.write(this.bAvailableCnt, 21);
        jceOutputStream.write(this.bTodayVotedCnt, 22);
        jceOutputStream.write(this.bCloseNeighborVote, 23);
        jceOutputStream.write(this.dwLikeCustomId, 24);
        jceOutputStream.write(this.bTollVoteCnt, 25);
        jceOutputStream.write(this.bIsLastVoteCharged, 26);
        jceOutputStream.write(this.bMutualFriends, 27);
    }

    public UserProfile(long j3, int i3, short s16, byte b16, byte b17, String str, int i16, int i17, short s17, byte[] bArr, byte[] bArr2, byte b18, byte b19, byte b26, byte b27, byte[] bArr3, byte b28, VipBaseInfo vipBaseInfo, byte[] bArr4, short s18, long j16, short s19, short s26, short s27, long j17, short s28, short s29, short s36) {
        this.lEctID = j3;
        this.lTime = i3;
        this.wFace = s16;
        this.bSex = b16;
        this.bAge = b17;
        this.strNick = str;
        this.nFaceNum = i16;
        this.eUserIdentityType = i17;
        this.shIntroType = s17;
        this.vIntroContent = bArr;
        this.vFaceID = bArr2;
        this.bVote = b18;
        this.bSingle = b19;
        this.bFavorited = b26;
        this.bFavoritedMe = b27;
        this.vRichSign = bArr3;
        this.bConstellation = b28;
        this.stVipInfo = vipBaseInfo;
        this.vC2CSign = bArr4;
        this.bVoteCnt = s18;
        this.uSource = j16;
        this.bAvailableCnt = s19;
        this.bTodayVotedCnt = s26;
        this.bCloseNeighborVote = s27;
        this.dwLikeCustomId = j17;
        this.bTollVoteCnt = s28;
        this.bIsLastVoteCharged = s29;
        this.bMutualFriends = s36;
    }
}
