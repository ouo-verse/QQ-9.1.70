package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetVoterList extends JceStruct {
    static UserCntlData cache_stUserData;
    static ArrayList<UserProfile> cache_vTodayFavoriteInfos;
    public long RespTime;
    public int iMaxFriendFavoriteCount;
    public int iMaxStrangerFavoriteCount;
    public int iTodayVoteCount;
    public int iTodayVoteRank;
    public int iTotalVoteCount;
    public RespHead stHeader;
    public UserCntlData stUserData;
    public ArrayList<UserProfile> vTodayFavoriteInfos;
    public ArrayList<UserProfile> vVoterInfos;
    static RespHead cache_stHeader = new RespHead();
    static ArrayList<UserProfile> cache_vVoterInfos = new ArrayList<>();

    static {
        cache_vVoterInfos.add(new UserProfile());
        cache_stUserData = new UserCntlData();
        cache_vTodayFavoriteInfos = new ArrayList<>();
        cache_vTodayFavoriteInfos.add(new UserProfile());
    }

    public RespGetVoterList() {
        this.stHeader = null;
        this.RespTime = 0L;
        this.vVoterInfos = null;
        this.stUserData = null;
        this.vTodayFavoriteInfos = null;
        this.iMaxFriendFavoriteCount = 50;
        this.iMaxStrangerFavoriteCount = 50;
        this.iTodayVoteCount = 0;
        this.iTodayVoteRank = -1;
        this.iTotalVoteCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.RespTime = jceInputStream.read(this.RespTime, 1, true);
        this.vVoterInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vVoterInfos, 2, false);
        this.stUserData = (UserCntlData) jceInputStream.read((JceStruct) cache_stUserData, 3, false);
        this.vTodayFavoriteInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vTodayFavoriteInfos, 4, false);
        this.iMaxFriendFavoriteCount = jceInputStream.read(this.iMaxFriendFavoriteCount, 5, false);
        this.iMaxStrangerFavoriteCount = jceInputStream.read(this.iMaxStrangerFavoriteCount, 6, false);
        this.iTodayVoteCount = jceInputStream.read(this.iTodayVoteCount, 7, false);
        this.iTodayVoteRank = jceInputStream.read(this.iTodayVoteRank, 8, false);
        this.iTotalVoteCount = jceInputStream.read(this.iTotalVoteCount, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.RespTime, 1);
        ArrayList<UserProfile> arrayList = this.vVoterInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        UserCntlData userCntlData = this.stUserData;
        if (userCntlData != null) {
            jceOutputStream.write((JceStruct) userCntlData, 3);
        }
        ArrayList<UserProfile> arrayList2 = this.vTodayFavoriteInfos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        jceOutputStream.write(this.iMaxFriendFavoriteCount, 5);
        jceOutputStream.write(this.iMaxStrangerFavoriteCount, 6);
        jceOutputStream.write(this.iTodayVoteCount, 7);
        jceOutputStream.write(this.iTodayVoteRank, 8);
        jceOutputStream.write(this.iTotalVoteCount, 9);
    }

    public RespGetVoterList(RespHead respHead, long j3, ArrayList<UserProfile> arrayList, UserCntlData userCntlData, ArrayList<UserProfile> arrayList2, int i3, int i16, int i17, int i18, int i19) {
        this.stHeader = respHead;
        this.RespTime = j3;
        this.vVoterInfos = arrayList;
        this.stUserData = userCntlData;
        this.vTodayFavoriteInfos = arrayList2;
        this.iMaxFriendFavoriteCount = i3;
        this.iMaxStrangerFavoriteCount = i16;
        this.iTodayVoteCount = i17;
        this.iTodayVoteRank = i18;
        this.iTotalVoteCount = i19;
    }
}
