package NeighborSvc;

import NeighborComm.NewListType;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetNeighbors extends JceStruct {
    static int cache_eNewListType;
    static byte[] cache_nearbyGroupReq;
    static ReqUserInfo cache_stCheckInInfo;
    static ReqHeader cache_stHeader;
    static UserData cache_stUserData;
    static byte[] cache_strA2;
    public int eNewListType;
    public int iListSize;
    public int iSimpleSort;
    public byte[] nearbyGroupReq;
    public ReqUserInfo stCheckInInfo;
    public ReqHeader stHeader;
    public UserData stUserData;
    public byte[] strA2;

    public ReqGetNeighbors() {
        this.stHeader = null;
        this.stCheckInInfo = null;
        this.stUserData = null;
        this.iListSize = -1;
        this.eNewListType = NewListType.NewListType_Nomal.value();
        this.strA2 = null;
        this.iSimpleSort = 0;
        this.nearbyGroupReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stCheckInInfo == null) {
            cache_stCheckInInfo = new ReqUserInfo();
        }
        this.stCheckInInfo = (ReqUserInfo) jceInputStream.read((JceStruct) cache_stCheckInInfo, 1, false);
        if (cache_stUserData == null) {
            cache_stUserData = new UserData();
        }
        this.stUserData = (UserData) jceInputStream.read((JceStruct) cache_stUserData, 2, false);
        this.iListSize = jceInputStream.read(this.iListSize, 3, false);
        this.eNewListType = jceInputStream.read(this.eNewListType, 4, false);
        if (cache_strA2 == null) {
            cache_strA2 = r0;
            byte[] bArr = {0};
        }
        this.strA2 = jceInputStream.read(cache_strA2, 5, false);
        this.iSimpleSort = jceInputStream.read(this.iSimpleSort, 6, false);
        if (cache_nearbyGroupReq == null) {
            cache_nearbyGroupReq = r0;
            byte[] bArr2 = {0};
        }
        this.nearbyGroupReq = jceInputStream.read(cache_nearbyGroupReq, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        ReqUserInfo reqUserInfo = this.stCheckInInfo;
        if (reqUserInfo != null) {
            jceOutputStream.write((JceStruct) reqUserInfo, 1);
        }
        UserData userData = this.stUserData;
        if (userData != null) {
            jceOutputStream.write((JceStruct) userData, 2);
        }
        jceOutputStream.write(this.iListSize, 3);
        jceOutputStream.write(this.eNewListType, 4);
        byte[] bArr = this.strA2;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        jceOutputStream.write(this.iSimpleSort, 6);
        byte[] bArr2 = this.nearbyGroupReq;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 7);
        }
    }

    public ReqGetNeighbors(ReqHeader reqHeader, ReqUserInfo reqUserInfo, UserData userData, int i3, int i16, byte[] bArr, int i17, byte[] bArr2) {
        this.stHeader = null;
        this.stCheckInInfo = null;
        this.stUserData = null;
        this.iListSize = -1;
        NewListType.NewListType_Nomal.value();
        this.stHeader = reqHeader;
        this.stCheckInInfo = reqUserInfo;
        this.stUserData = userData;
        this.iListSize = i3;
        this.eNewListType = i16;
        this.strA2 = bArr;
        this.iSimpleSort = i17;
        this.nearbyGroupReq = bArr2;
    }
}
