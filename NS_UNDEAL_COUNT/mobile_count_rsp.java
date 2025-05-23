package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_count_rsp extends JceStruct {
    static Map<Long, s_comm_data> cache_mapBuf;
    static Map<Long, Long> cache_mapLastGetTime;
    static master_info cache_masterinfo;
    static single_count cache_stFlower;
    static single_count cache_stGameBarInfo;
    static single_count cache_stHappyRoom;
    static master_info cache_stMasterInfo;
    static medal_info cache_stMedalInfo;
    static single_count cache_stPersionalInfo;
    static single_count cache_stQzoneVipInfo;
    static single_count cache_stReadSpace;
    static single_count cache_stSecretInfo;
    static single_count cache_stSecretPavInfo;
    static single_count cache_stSubscribeAlbum;
    static single_count cache_stVisitReqInfo;
    static single_count cache_stZebraAppInfo;
    static ArrayList<operat_data> cache_vecOperateInfo;
    static ArrayList<feed_host_info> cache_vecUpdatePassiveList;
    public long busiFlag;
    public int iNextTimeout;
    public Map<Long, s_comm_data> mapBuf;
    public Map<Long, Long> mapLastGetTime;
    public master_info masterinfo;
    public single_count stActiveCount;
    public single_count stAppCount;
    public ban_info stBanInfo;
    public birth_info stBirthInfo;
    public single_count stFlower;
    public single_count stFriendReqCount;
    public single_count stFriendsBirthdayCount;
    public single_count stGameBarInfo;
    public single_count stHappyRoom;
    public single_count stMainPageCount;
    public master_info stMasterInfo;
    public medal_info stMedalInfo;
    public single_count stPassiveCount;
    public single_count stPersionalInfo;
    public single_count stQzoneVipInfo;
    public single_count stReadSpace;
    public single_count stSecretInfo;
    public single_count stSecretPavInfo;
    public single_count stSubscribeAlbum;
    public single_count stVisitReqInfo;
    public single_count stVisitorCount;
    public yellow_info stYellowInfo;
    public single_count stZebraAppInfo;
    public String strDeviceName;
    public String strNick;
    public long uRspMask;
    public ArrayList<operat_data> vecOperateInfo;
    public ArrayList<feed_host_info> vecUpdateFeedFriendsList;
    public ArrayList<feed_host_info> vecUpdatePassiveList;
    static single_count cache_stPassiveCount = new single_count();
    static single_count cache_stActiveCount = new single_count();
    static single_count cache_stVisitorCount = new single_count();
    static single_count cache_stFriendReqCount = new single_count();
    static ban_info cache_stBanInfo = new ban_info();
    static birth_info cache_stBirthInfo = new birth_info();
    static single_count cache_stAppCount = new single_count();
    static single_count cache_stFriendsBirthdayCount = new single_count();
    static single_count cache_stMainPageCount = new single_count();
    static yellow_info cache_stYellowInfo = new yellow_info();
    static ArrayList<feed_host_info> cache_vecUpdateFeedFriendsList = new ArrayList<>();

    static {
        cache_vecUpdateFeedFriendsList.add(new feed_host_info());
        cache_vecUpdatePassiveList = new ArrayList<>();
        cache_vecUpdatePassiveList.add(new feed_host_info());
        cache_stReadSpace = new single_count();
        cache_stFlower = new single_count();
        cache_stSubscribeAlbum = new single_count();
        cache_mapBuf = new HashMap();
        cache_mapBuf.put(0L, new s_comm_data());
        cache_stGameBarInfo = new single_count();
        cache_stPersionalInfo = new single_count();
        cache_stQzoneVipInfo = new single_count();
        cache_stVisitReqInfo = new single_count();
        cache_stSecretInfo = new single_count();
        cache_stHappyRoom = new single_count();
        cache_stMasterInfo = new master_info();
        cache_vecOperateInfo = new ArrayList<>();
        cache_vecOperateInfo.add(new operat_data());
        cache_stZebraAppInfo = new single_count();
        cache_stSecretPavInfo = new single_count();
        cache_mapLastGetTime = new HashMap();
        cache_mapLastGetTime.put(0L, 0L);
        cache_stMedalInfo = new medal_info();
        cache_masterinfo = new master_info();
    }

    public mobile_count_rsp() {
        this.strNick = "";
        this.strDeviceName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stPassiveCount = (single_count) jceInputStream.read((JceStruct) cache_stPassiveCount, 0, false);
        this.stActiveCount = (single_count) jceInputStream.read((JceStruct) cache_stActiveCount, 1, false);
        this.stVisitorCount = (single_count) jceInputStream.read((JceStruct) cache_stVisitorCount, 2, false);
        this.stFriendReqCount = (single_count) jceInputStream.read((JceStruct) cache_stFriendReqCount, 3, false);
        this.uRspMask = jceInputStream.read(this.uRspMask, 4, false);
        this.stBanInfo = (ban_info) jceInputStream.read((JceStruct) cache_stBanInfo, 5, false);
        this.stBirthInfo = (birth_info) jceInputStream.read((JceStruct) cache_stBirthInfo, 6, false);
        this.strNick = jceInputStream.readString(7, false);
        this.stAppCount = (single_count) jceInputStream.read((JceStruct) cache_stAppCount, 8, false);
        this.iNextTimeout = jceInputStream.read(this.iNextTimeout, 9, false);
        this.stFriendsBirthdayCount = (single_count) jceInputStream.read((JceStruct) cache_stFriendsBirthdayCount, 10, false);
        this.stMainPageCount = (single_count) jceInputStream.read((JceStruct) cache_stMainPageCount, 11, false);
        this.stYellowInfo = (yellow_info) jceInputStream.read((JceStruct) cache_stYellowInfo, 12, false);
        this.vecUpdateFeedFriendsList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUpdateFeedFriendsList, 13, false);
        this.strDeviceName = jceInputStream.readString(14, false);
        this.vecUpdatePassiveList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUpdatePassiveList, 15, false);
        this.stReadSpace = (single_count) jceInputStream.read((JceStruct) cache_stReadSpace, 16, false);
        this.stFlower = (single_count) jceInputStream.read((JceStruct) cache_stFlower, 17, false);
        this.stSubscribeAlbum = (single_count) jceInputStream.read((JceStruct) cache_stSubscribeAlbum, 18, false);
        this.mapBuf = (Map) jceInputStream.read((JceInputStream) cache_mapBuf, 19, false);
        this.stGameBarInfo = (single_count) jceInputStream.read((JceStruct) cache_stGameBarInfo, 20, false);
        this.stPersionalInfo = (single_count) jceInputStream.read((JceStruct) cache_stPersionalInfo, 21, false);
        this.stQzoneVipInfo = (single_count) jceInputStream.read((JceStruct) cache_stQzoneVipInfo, 22, false);
        this.stVisitReqInfo = (single_count) jceInputStream.read((JceStruct) cache_stVisitReqInfo, 23, false);
        this.stSecretInfo = (single_count) jceInputStream.read((JceStruct) cache_stSecretInfo, 24, false);
        this.stHappyRoom = (single_count) jceInputStream.read((JceStruct) cache_stHappyRoom, 25, false);
        this.stMasterInfo = (master_info) jceInputStream.read((JceStruct) cache_stMasterInfo, 26, false);
        this.vecOperateInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecOperateInfo, 27, false);
        this.stZebraAppInfo = (single_count) jceInputStream.read((JceStruct) cache_stZebraAppInfo, 28, false);
        this.stSecretPavInfo = (single_count) jceInputStream.read((JceStruct) cache_stSecretPavInfo, 29, false);
        this.mapLastGetTime = (Map) jceInputStream.read((JceInputStream) cache_mapLastGetTime, 30, false);
        this.stMedalInfo = (medal_info) jceInputStream.read((JceStruct) cache_stMedalInfo, 31, false);
        this.busiFlag = jceInputStream.read(this.busiFlag, 32, false);
        this.masterinfo = (master_info) jceInputStream.read((JceStruct) cache_masterinfo, 33, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        single_count single_countVar = this.stPassiveCount;
        if (single_countVar != null) {
            jceOutputStream.write((JceStruct) single_countVar, 0);
        }
        single_count single_countVar2 = this.stActiveCount;
        if (single_countVar2 != null) {
            jceOutputStream.write((JceStruct) single_countVar2, 1);
        }
        single_count single_countVar3 = this.stVisitorCount;
        if (single_countVar3 != null) {
            jceOutputStream.write((JceStruct) single_countVar3, 2);
        }
        single_count single_countVar4 = this.stFriendReqCount;
        if (single_countVar4 != null) {
            jceOutputStream.write((JceStruct) single_countVar4, 3);
        }
        jceOutputStream.write(this.uRspMask, 4);
        ban_info ban_infoVar = this.stBanInfo;
        if (ban_infoVar != null) {
            jceOutputStream.write((JceStruct) ban_infoVar, 5);
        }
        birth_info birth_infoVar = this.stBirthInfo;
        if (birth_infoVar != null) {
            jceOutputStream.write((JceStruct) birth_infoVar, 6);
        }
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        single_count single_countVar5 = this.stAppCount;
        if (single_countVar5 != null) {
            jceOutputStream.write((JceStruct) single_countVar5, 8);
        }
        jceOutputStream.write(this.iNextTimeout, 9);
        single_count single_countVar6 = this.stFriendsBirthdayCount;
        if (single_countVar6 != null) {
            jceOutputStream.write((JceStruct) single_countVar6, 10);
        }
        single_count single_countVar7 = this.stMainPageCount;
        if (single_countVar7 != null) {
            jceOutputStream.write((JceStruct) single_countVar7, 11);
        }
        yellow_info yellow_infoVar = this.stYellowInfo;
        if (yellow_infoVar != null) {
            jceOutputStream.write((JceStruct) yellow_infoVar, 12);
        }
        ArrayList<feed_host_info> arrayList = this.vecUpdateFeedFriendsList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 13);
        }
        String str2 = this.strDeviceName;
        if (str2 != null) {
            jceOutputStream.write(str2, 14);
        }
        ArrayList<feed_host_info> arrayList2 = this.vecUpdatePassiveList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 15);
        }
        single_count single_countVar8 = this.stReadSpace;
        if (single_countVar8 != null) {
            jceOutputStream.write((JceStruct) single_countVar8, 16);
        }
        single_count single_countVar9 = this.stFlower;
        if (single_countVar9 != null) {
            jceOutputStream.write((JceStruct) single_countVar9, 17);
        }
        single_count single_countVar10 = this.stSubscribeAlbum;
        if (single_countVar10 != null) {
            jceOutputStream.write((JceStruct) single_countVar10, 18);
        }
        Map<Long, s_comm_data> map = this.mapBuf;
        if (map != null) {
            jceOutputStream.write((Map) map, 19);
        }
        single_count single_countVar11 = this.stGameBarInfo;
        if (single_countVar11 != null) {
            jceOutputStream.write((JceStruct) single_countVar11, 20);
        }
        single_count single_countVar12 = this.stPersionalInfo;
        if (single_countVar12 != null) {
            jceOutputStream.write((JceStruct) single_countVar12, 21);
        }
        single_count single_countVar13 = this.stQzoneVipInfo;
        if (single_countVar13 != null) {
            jceOutputStream.write((JceStruct) single_countVar13, 22);
        }
        single_count single_countVar14 = this.stVisitReqInfo;
        if (single_countVar14 != null) {
            jceOutputStream.write((JceStruct) single_countVar14, 23);
        }
        single_count single_countVar15 = this.stSecretInfo;
        if (single_countVar15 != null) {
            jceOutputStream.write((JceStruct) single_countVar15, 24);
        }
        single_count single_countVar16 = this.stHappyRoom;
        if (single_countVar16 != null) {
            jceOutputStream.write((JceStruct) single_countVar16, 25);
        }
        master_info master_infoVar = this.stMasterInfo;
        if (master_infoVar != null) {
            jceOutputStream.write((JceStruct) master_infoVar, 26);
        }
        ArrayList<operat_data> arrayList3 = this.vecOperateInfo;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 27);
        }
        single_count single_countVar17 = this.stZebraAppInfo;
        if (single_countVar17 != null) {
            jceOutputStream.write((JceStruct) single_countVar17, 28);
        }
        single_count single_countVar18 = this.stSecretPavInfo;
        if (single_countVar18 != null) {
            jceOutputStream.write((JceStruct) single_countVar18, 29);
        }
        Map<Long, Long> map2 = this.mapLastGetTime;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 30);
        }
        medal_info medal_infoVar = this.stMedalInfo;
        if (medal_infoVar != null) {
            jceOutputStream.write((JceStruct) medal_infoVar, 31);
        }
        jceOutputStream.write(this.busiFlag, 32);
        master_info master_infoVar2 = this.masterinfo;
        if (master_infoVar2 != null) {
            jceOutputStream.write((JceStruct) master_infoVar2, 33);
        }
    }

    public mobile_count_rsp(single_count single_countVar, single_count single_countVar2, single_count single_countVar3, single_count single_countVar4, long j3, ban_info ban_infoVar, birth_info birth_infoVar, String str, single_count single_countVar5, int i3, single_count single_countVar6, single_count single_countVar7, yellow_info yellow_infoVar, ArrayList<feed_host_info> arrayList, String str2, ArrayList<feed_host_info> arrayList2, single_count single_countVar8, single_count single_countVar9, single_count single_countVar10, Map<Long, s_comm_data> map, single_count single_countVar11, single_count single_countVar12, single_count single_countVar13, single_count single_countVar14, single_count single_countVar15, single_count single_countVar16, master_info master_infoVar, ArrayList<operat_data> arrayList3, single_count single_countVar17, single_count single_countVar18, Map<Long, Long> map2, medal_info medal_infoVar, long j16, master_info master_infoVar2) {
        this.stPassiveCount = single_countVar;
        this.stActiveCount = single_countVar2;
        this.stVisitorCount = single_countVar3;
        this.stFriendReqCount = single_countVar4;
        this.uRspMask = j3;
        this.stBanInfo = ban_infoVar;
        this.stBirthInfo = birth_infoVar;
        this.strNick = str;
        this.stAppCount = single_countVar5;
        this.iNextTimeout = i3;
        this.stFriendsBirthdayCount = single_countVar6;
        this.stMainPageCount = single_countVar7;
        this.stYellowInfo = yellow_infoVar;
        this.vecUpdateFeedFriendsList = arrayList;
        this.strDeviceName = str2;
        this.vecUpdatePassiveList = arrayList2;
        this.stReadSpace = single_countVar8;
        this.stFlower = single_countVar9;
        this.stSubscribeAlbum = single_countVar10;
        this.mapBuf = map;
        this.stGameBarInfo = single_countVar11;
        this.stPersionalInfo = single_countVar12;
        this.stQzoneVipInfo = single_countVar13;
        this.stVisitReqInfo = single_countVar14;
        this.stSecretInfo = single_countVar15;
        this.stHappyRoom = single_countVar16;
        this.stMasterInfo = master_infoVar;
        this.vecOperateInfo = arrayList3;
        this.stZebraAppInfo = single_countVar17;
        this.stSecretPavInfo = single_countVar18;
        this.mapLastGetTime = map2;
        this.stMedalInfo = medal_infoVar;
        this.busiFlag = j16;
        this.masterinfo = master_infoVar2;
    }
}
