package EncounterSvc;

import NeighborComm.EctFragmentation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetEncounterV2 extends JceStruct {
    static byte[] cache_NearRankingsResp;
    static byte[] cache_NewUserAreaResp;
    static RecommEncounterInfo cache_RecommEncounters;
    static ArrayList<NeighborAd> cache_ad_list;
    static AlumnusConfigInfo cache_alumnus_conf;
    static ArrayList<EntranceContent> cache_entrance_list;
    static byte[] cache_nearbyGroupResp;
    static byte[] cache_nearbyPublicAcctResp;
    static ArrayList<NeighborBanner> cache_neighbor_banners;
    static SelfInfo cache_self_info;
    static EctFragmentation cache_stEctFmt;
    static PengYouInfo cache_stPYInfo;
    static UserDetailLocalInfo cache_stUDLinfo;
    static UserData cache_stUserData = new UserData();
    static ArrayList<RespEncounterInfo> cache_vEncounterInfos = new ArrayList<>();
    public byte[] NearRankingsResp;
    public byte[] NewUserAreaResp;
    public byte RankingFlag;
    public RecommEncounterInfo RecommEncounters;
    public long RespTime;
    public ArrayList<NeighborAd> ad_list;
    public AlumnusConfigInfo alumnus_conf;
    public byte can_add_sub_interest;
    public ArrayList<EntranceContent> entrance_list;
    public int iEncounterNumber;
    public int iSessionTotalNumber;
    public byte[] nearbyGroupResp;
    public byte[] nearbyPublicAcctResp;
    public ArrayList<NeighborBanner> neighbor_banners;
    public SelfInfo self_info;
    public EctFragmentation stEctFmt;
    public PengYouInfo stPYInfo;
    public UserDetailLocalInfo stUDLinfo;
    public UserData stUserData;
    public String strSecurityDetailUrl;
    public String strSecurityTips;
    public byte system_pic;
    public byte useInterestTag;
    public ArrayList<RespEncounterInfo> vEncounterInfos;
    public byte watch_color;

    static {
        cache_vEncounterInfos.add(new RespEncounterInfo());
        cache_stUDLinfo = new UserDetailLocalInfo();
        cache_stPYInfo = new PengYouInfo();
        cache_stEctFmt = new EctFragmentation();
        cache_nearbyGroupResp = r1;
        byte[] bArr = {0};
        cache_nearbyPublicAcctResp = r1;
        byte[] bArr2 = {0};
        cache_entrance_list = new ArrayList<>();
        cache_entrance_list.add(new EntranceContent());
        cache_neighbor_banners = new ArrayList<>();
        cache_neighbor_banners.add(new NeighborBanner());
        cache_ad_list = new ArrayList<>();
        cache_ad_list.add(new NeighborAd());
        cache_self_info = new SelfInfo();
        cache_NearRankingsResp = r1;
        byte[] bArr3 = {0};
        cache_NewUserAreaResp = r0;
        byte[] bArr4 = {0};
        cache_alumnus_conf = new AlumnusConfigInfo();
        cache_RecommEncounters = new RecommEncounterInfo();
    }

    public RespGetEncounterV2() {
        this.RespTime = 0L;
        this.stUserData = null;
        this.vEncounterInfos = null;
        this.stUDLinfo = null;
        this.stPYInfo = null;
        this.stEctFmt = null;
        this.iSessionTotalNumber = 0;
        this.iEncounterNumber = 0;
        this.nearbyGroupResp = null;
        this.nearbyPublicAcctResp = null;
        this.strSecurityTips = "";
        this.strSecurityDetailUrl = "";
        this.entrance_list = null;
        this.neighbor_banners = null;
        this.system_pic = (byte) 0;
        this.watch_color = (byte) 0;
        this.useInterestTag = (byte) 0;
        this.ad_list = null;
        this.self_info = null;
        this.NearRankingsResp = null;
        this.NewUserAreaResp = null;
        this.alumnus_conf = null;
        this.can_add_sub_interest = (byte) 0;
        this.RecommEncounters = null;
        this.RankingFlag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.RespTime = jceInputStream.read(this.RespTime, 0, true);
        this.stUserData = (UserData) jceInputStream.read((JceStruct) cache_stUserData, 1, true);
        this.vEncounterInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vEncounterInfos, 2, false);
        this.stUDLinfo = (UserDetailLocalInfo) jceInputStream.read((JceStruct) cache_stUDLinfo, 3, false);
        this.stPYInfo = (PengYouInfo) jceInputStream.read((JceStruct) cache_stPYInfo, 4, false);
        this.stEctFmt = (EctFragmentation) jceInputStream.read((JceStruct) cache_stEctFmt, 5, false);
        this.iSessionTotalNumber = jceInputStream.read(this.iSessionTotalNumber, 6, false);
        this.iEncounterNumber = jceInputStream.read(this.iEncounterNumber, 7, false);
        this.nearbyGroupResp = jceInputStream.read(cache_nearbyGroupResp, 8, false);
        this.nearbyPublicAcctResp = jceInputStream.read(cache_nearbyPublicAcctResp, 9, false);
        this.strSecurityTips = jceInputStream.readString(10, false);
        this.strSecurityDetailUrl = jceInputStream.readString(11, false);
        this.entrance_list = (ArrayList) jceInputStream.read((JceInputStream) cache_entrance_list, 12, false);
        this.neighbor_banners = (ArrayList) jceInputStream.read((JceInputStream) cache_neighbor_banners, 13, false);
        this.system_pic = jceInputStream.read(this.system_pic, 14, false);
        this.watch_color = jceInputStream.read(this.watch_color, 15, false);
        this.useInterestTag = jceInputStream.read(this.useInterestTag, 16, false);
        this.ad_list = (ArrayList) jceInputStream.read((JceInputStream) cache_ad_list, 17, false);
        this.self_info = (SelfInfo) jceInputStream.read((JceStruct) cache_self_info, 18, false);
        this.NearRankingsResp = jceInputStream.read(cache_NearRankingsResp, 19, false);
        this.NewUserAreaResp = jceInputStream.read(cache_NewUserAreaResp, 20, false);
        this.alumnus_conf = (AlumnusConfigInfo) jceInputStream.read((JceStruct) cache_alumnus_conf, 21, false);
        this.can_add_sub_interest = jceInputStream.read(this.can_add_sub_interest, 22, false);
        this.RecommEncounters = (RecommEncounterInfo) jceInputStream.read((JceStruct) cache_RecommEncounters, 23, false);
        this.RankingFlag = jceInputStream.read(this.RankingFlag, 24, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.RespTime, 0);
        jceOutputStream.write((JceStruct) this.stUserData, 1);
        ArrayList<RespEncounterInfo> arrayList = this.vEncounterInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        UserDetailLocalInfo userDetailLocalInfo = this.stUDLinfo;
        if (userDetailLocalInfo != null) {
            jceOutputStream.write((JceStruct) userDetailLocalInfo, 3);
        }
        PengYouInfo pengYouInfo = this.stPYInfo;
        if (pengYouInfo != null) {
            jceOutputStream.write((JceStruct) pengYouInfo, 4);
        }
        EctFragmentation ectFragmentation = this.stEctFmt;
        if (ectFragmentation != null) {
            jceOutputStream.write((JceStruct) ectFragmentation, 5);
        }
        jceOutputStream.write(this.iSessionTotalNumber, 6);
        jceOutputStream.write(this.iEncounterNumber, 7);
        byte[] bArr = this.nearbyGroupResp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
        byte[] bArr2 = this.nearbyPublicAcctResp;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 9);
        }
        String str = this.strSecurityTips;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        String str2 = this.strSecurityDetailUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        ArrayList<EntranceContent> arrayList2 = this.entrance_list;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 12);
        }
        ArrayList<NeighborBanner> arrayList3 = this.neighbor_banners;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 13);
        }
        jceOutputStream.write(this.system_pic, 14);
        jceOutputStream.write(this.watch_color, 15);
        jceOutputStream.write(this.useInterestTag, 16);
        ArrayList<NeighborAd> arrayList4 = this.ad_list;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 17);
        }
        SelfInfo selfInfo = this.self_info;
        if (selfInfo != null) {
            jceOutputStream.write((JceStruct) selfInfo, 18);
        }
        byte[] bArr3 = this.NearRankingsResp;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 19);
        }
        byte[] bArr4 = this.NewUserAreaResp;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 20);
        }
        AlumnusConfigInfo alumnusConfigInfo = this.alumnus_conf;
        if (alumnusConfigInfo != null) {
            jceOutputStream.write((JceStruct) alumnusConfigInfo, 21);
        }
        jceOutputStream.write(this.can_add_sub_interest, 22);
        RecommEncounterInfo recommEncounterInfo = this.RecommEncounters;
        if (recommEncounterInfo != null) {
            jceOutputStream.write((JceStruct) recommEncounterInfo, 23);
        }
        jceOutputStream.write(this.RankingFlag, 24);
    }

    public RespGetEncounterV2(long j3, UserData userData, ArrayList<RespEncounterInfo> arrayList, UserDetailLocalInfo userDetailLocalInfo, PengYouInfo pengYouInfo, EctFragmentation ectFragmentation, int i3, int i16, byte[] bArr, byte[] bArr2, String str, String str2, ArrayList<EntranceContent> arrayList2, ArrayList<NeighborBanner> arrayList3, byte b16, byte b17, byte b18, ArrayList<NeighborAd> arrayList4, SelfInfo selfInfo, byte[] bArr3, byte[] bArr4, AlumnusConfigInfo alumnusConfigInfo, byte b19, RecommEncounterInfo recommEncounterInfo, byte b26) {
        this.RespTime = j3;
        this.stUserData = userData;
        this.vEncounterInfos = arrayList;
        this.stUDLinfo = userDetailLocalInfo;
        this.stPYInfo = pengYouInfo;
        this.stEctFmt = ectFragmentation;
        this.iSessionTotalNumber = i3;
        this.iEncounterNumber = i16;
        this.nearbyGroupResp = bArr;
        this.nearbyPublicAcctResp = bArr2;
        this.strSecurityTips = str;
        this.strSecurityDetailUrl = str2;
        this.entrance_list = arrayList2;
        this.neighbor_banners = arrayList3;
        this.system_pic = b16;
        this.watch_color = b17;
        this.useInterestTag = b18;
        this.ad_list = arrayList4;
        this.self_info = selfInfo;
        this.NearRankingsResp = bArr3;
        this.NewUserAreaResp = bArr4;
        this.alumnus_conf = alumnusConfigInfo;
        this.can_add_sub_interest = b19;
        this.RecommEncounters = recommEncounterInfo;
        this.RankingFlag = b26;
    }
}
