package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetFriendListResp extends JceStruct {
    static int cache_reqtype;
    static int cache_result;
    static FriendInfo cache_stSelfInfo;
    static FriendListSubSrvRspCode cache_stSubSrvRspCode;
    static ArrayList<FriendInfo> cache_vecFriendInfo = new ArrayList<>();
    static ArrayList<GroupInfo> cache_vecGroupInfo;
    static ArrayList<GroupInfo> cache_vecMSFGroupInfo;
    static ArrayList<FriendInfo> cache_vecRobots;
    public byte cHasOtherRespFlag;
    public byte cRespType;
    public byte cShowPcIcon;
    public short errorCode;
    public short friend_count;
    public short getfriendCount;
    public byte getgroupCount;
    public byte group_count;
    public byte groupid;
    public byte groupstartIndex;
    public byte ifGetGroupInfo;
    public byte ifReflush;
    public short online_friend_count;
    public int reqtype;
    public int result;
    public long serverTime;
    public short sqqOnLine_count;
    public FriendInfo stSelfInfo;
    public FriendListSubSrvRspCode stSubSrvRspCode;
    public short startIndex;
    public short totoal_friend_count;
    public short totoal_group_count;
    public long uin;
    public ArrayList<FriendInfo> vecFriendInfo;
    public ArrayList<GroupInfo> vecGroupInfo;
    public ArrayList<GroupInfo> vecMSFGroupInfo;
    public ArrayList<FriendInfo> vecRobots;
    public short wGetExtSnsRspCode;

    static {
        cache_vecFriendInfo.add(new FriendInfo());
        cache_vecGroupInfo = new ArrayList<>();
        cache_vecGroupInfo.add(new GroupInfo());
        cache_result = 0;
        cache_vecMSFGroupInfo = new ArrayList<>();
        cache_vecMSFGroupInfo.add(new GroupInfo());
        cache_stSelfInfo = new FriendInfo();
        cache_stSubSrvRspCode = new FriendListSubSrvRspCode();
        cache_vecRobots = new ArrayList<>();
        cache_vecRobots.add(new FriendInfo());
    }

    public GetFriendListResp() {
        this.reqtype = 0;
        this.ifReflush = (byte) 0;
        this.uin = 0L;
        this.startIndex = (short) 0;
        this.getfriendCount = (short) 0;
        this.totoal_friend_count = (short) 0;
        this.friend_count = (short) 0;
        this.vecFriendInfo = null;
        this.groupid = (byte) 0;
        this.ifGetGroupInfo = (byte) 0;
        this.groupstartIndex = (byte) 0;
        this.getgroupCount = (byte) 0;
        this.totoal_group_count = (short) 0;
        this.group_count = (byte) 0;
        this.vecGroupInfo = null;
        this.result = 0;
        this.errorCode = (short) 0;
        this.online_friend_count = (short) 0;
        this.serverTime = 0L;
        this.sqqOnLine_count = (short) 0;
        this.vecMSFGroupInfo = null;
        this.cRespType = (byte) 0;
        this.cHasOtherRespFlag = (byte) 0;
        this.stSelfInfo = null;
        this.cShowPcIcon = (byte) 0;
        this.wGetExtSnsRspCode = (short) 0;
        this.stSubSrvRspCode = null;
        this.vecRobots = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqtype = jceInputStream.read(this.reqtype, 0, true);
        this.ifReflush = jceInputStream.read(this.ifReflush, 1, true);
        this.uin = jceInputStream.read(this.uin, 2, true);
        this.startIndex = jceInputStream.read(this.startIndex, 3, true);
        this.getfriendCount = jceInputStream.read(this.getfriendCount, 4, true);
        this.totoal_friend_count = jceInputStream.read(this.totoal_friend_count, 5, true);
        this.friend_count = jceInputStream.read(this.friend_count, 6, true);
        this.vecFriendInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecFriendInfo, 7, true);
        this.groupid = jceInputStream.read(this.groupid, 8, false);
        this.ifGetGroupInfo = jceInputStream.read(this.ifGetGroupInfo, 9, true);
        this.groupstartIndex = jceInputStream.read(this.groupstartIndex, 10, false);
        this.getgroupCount = jceInputStream.read(this.getgroupCount, 11, false);
        this.totoal_group_count = jceInputStream.read(this.totoal_group_count, 12, false);
        this.group_count = jceInputStream.read(this.group_count, 13, false);
        this.vecGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGroupInfo, 14, false);
        this.result = jceInputStream.read(this.result, 15, true);
        this.errorCode = jceInputStream.read(this.errorCode, 16, false);
        this.online_friend_count = jceInputStream.read(this.online_friend_count, 17, false);
        this.serverTime = jceInputStream.read(this.serverTime, 18, false);
        this.sqqOnLine_count = jceInputStream.read(this.sqqOnLine_count, 19, false);
        this.vecMSFGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecMSFGroupInfo, 20, false);
        this.cRespType = jceInputStream.read(this.cRespType, 21, false);
        this.cHasOtherRespFlag = jceInputStream.read(this.cHasOtherRespFlag, 22, false);
        this.stSelfInfo = (FriendInfo) jceInputStream.read((JceStruct) cache_stSelfInfo, 23, false);
        this.cShowPcIcon = jceInputStream.read(this.cShowPcIcon, 24, false);
        this.wGetExtSnsRspCode = jceInputStream.read(this.wGetExtSnsRspCode, 25, false);
        this.stSubSrvRspCode = (FriendListSubSrvRspCode) jceInputStream.read((JceStruct) cache_stSubSrvRspCode, 26, false);
        this.vecRobots = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRobots, 27, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqtype, 0);
        jceOutputStream.write(this.ifReflush, 1);
        jceOutputStream.write(this.uin, 2);
        jceOutputStream.write(this.startIndex, 3);
        jceOutputStream.write(this.getfriendCount, 4);
        jceOutputStream.write(this.totoal_friend_count, 5);
        jceOutputStream.write(this.friend_count, 6);
        jceOutputStream.write((Collection) this.vecFriendInfo, 7);
        jceOutputStream.write(this.groupid, 8);
        jceOutputStream.write(this.ifGetGroupInfo, 9);
        jceOutputStream.write(this.groupstartIndex, 10);
        jceOutputStream.write(this.getgroupCount, 11);
        jceOutputStream.write(this.totoal_group_count, 12);
        jceOutputStream.write(this.group_count, 13);
        ArrayList<GroupInfo> arrayList = this.vecGroupInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 14);
        }
        jceOutputStream.write(this.result, 15);
        jceOutputStream.write(this.errorCode, 16);
        jceOutputStream.write(this.online_friend_count, 17);
        jceOutputStream.write(this.serverTime, 18);
        jceOutputStream.write(this.sqqOnLine_count, 19);
        ArrayList<GroupInfo> arrayList2 = this.vecMSFGroupInfo;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 20);
        }
        jceOutputStream.write(this.cRespType, 21);
        jceOutputStream.write(this.cHasOtherRespFlag, 22);
        FriendInfo friendInfo = this.stSelfInfo;
        if (friendInfo != null) {
            jceOutputStream.write((JceStruct) friendInfo, 23);
        }
        jceOutputStream.write(this.cShowPcIcon, 24);
        jceOutputStream.write(this.wGetExtSnsRspCode, 25);
        FriendListSubSrvRspCode friendListSubSrvRspCode = this.stSubSrvRspCode;
        if (friendListSubSrvRspCode != null) {
            jceOutputStream.write((JceStruct) friendListSubSrvRspCode, 26);
        }
        ArrayList<FriendInfo> arrayList3 = this.vecRobots;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 27);
        }
    }

    public GetFriendListResp(int i3, byte b16, long j3, short s16, short s17, short s18, short s19, ArrayList<FriendInfo> arrayList, byte b17, byte b18, byte b19, byte b26, short s26, byte b27, ArrayList<GroupInfo> arrayList2, int i16, short s27, short s28, long j16, short s29, ArrayList<GroupInfo> arrayList3, byte b28, byte b29, FriendInfo friendInfo, byte b36, short s36, FriendListSubSrvRspCode friendListSubSrvRspCode, ArrayList<FriendInfo> arrayList4) {
        this.reqtype = i3;
        this.ifReflush = b16;
        this.uin = j3;
        this.startIndex = s16;
        this.getfriendCount = s17;
        this.totoal_friend_count = s18;
        this.friend_count = s19;
        this.vecFriendInfo = arrayList;
        this.groupid = b17;
        this.ifGetGroupInfo = b18;
        this.groupstartIndex = b19;
        this.getgroupCount = b26;
        this.totoal_group_count = s26;
        this.group_count = b27;
        this.vecGroupInfo = arrayList2;
        this.result = i16;
        this.errorCode = s27;
        this.online_friend_count = s28;
        this.serverTime = j16;
        this.sqqOnLine_count = s29;
        this.vecMSFGroupInfo = arrayList3;
        this.cRespType = b28;
        this.cHasOtherRespFlag = b29;
        this.stSelfInfo = friendInfo;
        this.cShowPcIcon = b36;
        this.wGetExtSnsRspCode = s36;
        this.stSubSrvRspCode = friendListSubSrvRspCode;
        this.vecRobots = arrayList4;
    }
}
