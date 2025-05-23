package NeighborSvc;

import NeighborComm.EctFragmentation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetNeighbors extends JceStruct {
    static byte[] cache_nearbyGroupResp;
    static EctFragmentation cache_stEctFmt;
    static RespHeader cache_stHeader;
    static UserDetailLocalInfo cache_stUDLinfo;
    static UserData cache_stUserData;
    static ArrayList<GroupInfo> cache_vGroupList;
    static ArrayList<RespNeighborInfo> cache_vNeighborInfos;
    public long RespTime;
    public int iSessionTotalNumber;
    public byte[] nearbyGroupResp;
    public EctFragmentation stEctFmt;
    public RespHeader stHeader;
    public UserDetailLocalInfo stUDLinfo;
    public UserData stUserData;
    public ArrayList<GroupInfo> vGroupList;
    public ArrayList<RespNeighborInfo> vNeighborInfos;

    public RespGetNeighbors() {
        this.stHeader = null;
        this.RespTime = 0L;
        this.vNeighborInfos = null;
        this.vGroupList = null;
        this.stUserData = null;
        this.stUDLinfo = null;
        this.stEctFmt = null;
        this.iSessionTotalNumber = 0;
        this.nearbyGroupResp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHeader();
        }
        this.stHeader = (RespHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.RespTime = jceInputStream.read(this.RespTime, 1, true);
        if (cache_vNeighborInfos == null) {
            cache_vNeighborInfos = new ArrayList<>();
            cache_vNeighborInfos.add(new RespNeighborInfo());
        }
        this.vNeighborInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vNeighborInfos, 2, false);
        if (cache_vGroupList == null) {
            cache_vGroupList = new ArrayList<>();
            cache_vGroupList.add(new GroupInfo());
        }
        this.vGroupList = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupList, 3, false);
        if (cache_stUserData == null) {
            cache_stUserData = new UserData();
        }
        this.stUserData = (UserData) jceInputStream.read((JceStruct) cache_stUserData, 4, false);
        if (cache_stUDLinfo == null) {
            cache_stUDLinfo = new UserDetailLocalInfo();
        }
        this.stUDLinfo = (UserDetailLocalInfo) jceInputStream.read((JceStruct) cache_stUDLinfo, 5, false);
        if (cache_stEctFmt == null) {
            cache_stEctFmt = new EctFragmentation();
        }
        this.stEctFmt = (EctFragmentation) jceInputStream.read((JceStruct) cache_stEctFmt, 6, false);
        this.iSessionTotalNumber = jceInputStream.read(this.iSessionTotalNumber, 7, false);
        if (cache_nearbyGroupResp == null) {
            cache_nearbyGroupResp = r0;
            byte[] bArr = {0};
        }
        this.nearbyGroupResp = jceInputStream.read(cache_nearbyGroupResp, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.RespTime, 1);
        ArrayList<RespNeighborInfo> arrayList = this.vNeighborInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<GroupInfo> arrayList2 = this.vGroupList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        UserData userData = this.stUserData;
        if (userData != null) {
            jceOutputStream.write((JceStruct) userData, 4);
        }
        UserDetailLocalInfo userDetailLocalInfo = this.stUDLinfo;
        if (userDetailLocalInfo != null) {
            jceOutputStream.write((JceStruct) userDetailLocalInfo, 5);
        }
        EctFragmentation ectFragmentation = this.stEctFmt;
        if (ectFragmentation != null) {
            jceOutputStream.write((JceStruct) ectFragmentation, 6);
        }
        jceOutputStream.write(this.iSessionTotalNumber, 7);
        byte[] bArr = this.nearbyGroupResp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
    }

    public RespGetNeighbors(RespHeader respHeader, long j3, ArrayList<RespNeighborInfo> arrayList, ArrayList<GroupInfo> arrayList2, UserData userData, UserDetailLocalInfo userDetailLocalInfo, EctFragmentation ectFragmentation, int i3, byte[] bArr) {
        this.stHeader = respHeader;
        this.RespTime = j3;
        this.vNeighborInfos = arrayList;
        this.vGroupList = arrayList2;
        this.stUserData = userData;
        this.stUDLinfo = userDetailLocalInfo;
        this.stEctFmt = ectFragmentation;
        this.iSessionTotalNumber = i3;
        this.nearbyGroupResp = bArr;
    }
}
