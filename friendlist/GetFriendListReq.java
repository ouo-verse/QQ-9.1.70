package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetFriendListReq extends JceStruct {
    static int cache_eAppType;
    static int cache_reqtype;
    static ArrayList<Long> cache_uinList = new ArrayList<>();
    static byte[] cache_vec0xd50Req;
    static byte[] cache_vec0xd6bReq;
    static ArrayList<Long> cache_vecSnsTypelist;
    public int eAppType;
    public short getfriendCount;
    public byte getgroupCount;
    public byte groupid;
    public byte groupstartIndex;
    public byte ifGetBothFlag;
    public byte ifGetDOVId;
    public byte ifGetGroupInfo;
    public byte ifGetMSFGroup;
    public byte ifReflush;
    public byte ifShowTermType;
    public int reqtype;
    public short startIndex;
    public long uin;
    public ArrayList<Long> uinList;
    public byte[] vec0xd50Req;
    public byte[] vec0xd6bReq;
    public ArrayList<Long> vecSnsTypelist;
    public long version;

    static {
        cache_uinList.add(0L);
        cache_eAppType = 0;
        cache_vec0xd50Req = r3;
        byte[] bArr = {0};
        cache_vec0xd6bReq = r2;
        byte[] bArr2 = {0};
        cache_vecSnsTypelist = new ArrayList<>();
        cache_vecSnsTypelist.add(0L);
    }

    public GetFriendListReq() {
        this.reqtype = 0;
        this.ifReflush = (byte) 0;
        this.uin = 0L;
        this.startIndex = (short) 0;
        this.getfriendCount = (short) 0;
        this.groupid = (byte) 0;
        this.ifGetGroupInfo = (byte) 0;
        this.groupstartIndex = (byte) 0;
        this.getgroupCount = (byte) 0;
        this.ifGetMSFGroup = (byte) 0;
        this.ifShowTermType = (byte) 0;
        this.version = 0L;
        this.uinList = null;
        this.eAppType = 0;
        this.ifGetDOVId = (byte) 0;
        this.ifGetBothFlag = (byte) 0;
        this.vec0xd50Req = null;
        this.vec0xd6bReq = null;
        this.vecSnsTypelist = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqtype = jceInputStream.read(this.reqtype, 0, true);
        this.ifReflush = jceInputStream.read(this.ifReflush, 1, true);
        this.uin = jceInputStream.read(this.uin, 2, true);
        this.startIndex = jceInputStream.read(this.startIndex, 3, true);
        this.getfriendCount = jceInputStream.read(this.getfriendCount, 4, true);
        this.groupid = jceInputStream.read(this.groupid, 5, false);
        this.ifGetGroupInfo = jceInputStream.read(this.ifGetGroupInfo, 6, true);
        this.groupstartIndex = jceInputStream.read(this.groupstartIndex, 7, false);
        this.getgroupCount = jceInputStream.read(this.getgroupCount, 8, false);
        this.ifGetMSFGroup = jceInputStream.read(this.ifGetMSFGroup, 9, false);
        this.ifShowTermType = jceInputStream.read(this.ifShowTermType, 10, false);
        this.version = jceInputStream.read(this.version, 11, false);
        this.uinList = (ArrayList) jceInputStream.read((JceInputStream) cache_uinList, 12, false);
        this.eAppType = jceInputStream.read(this.eAppType, 13, false);
        this.ifGetDOVId = jceInputStream.read(this.ifGetDOVId, 14, false);
        this.ifGetBothFlag = jceInputStream.read(this.ifGetBothFlag, 15, false);
        this.vec0xd50Req = jceInputStream.read(cache_vec0xd50Req, 16, false);
        this.vec0xd6bReq = jceInputStream.read(cache_vec0xd6bReq, 17, false);
        this.vecSnsTypelist = (ArrayList) jceInputStream.read((JceInputStream) cache_vecSnsTypelist, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqtype, 0);
        jceOutputStream.write(this.ifReflush, 1);
        jceOutputStream.write(this.uin, 2);
        jceOutputStream.write(this.startIndex, 3);
        jceOutputStream.write(this.getfriendCount, 4);
        jceOutputStream.write(this.groupid, 5);
        jceOutputStream.write(this.ifGetGroupInfo, 6);
        jceOutputStream.write(this.groupstartIndex, 7);
        jceOutputStream.write(this.getgroupCount, 8);
        jceOutputStream.write(this.ifGetMSFGroup, 9);
        jceOutputStream.write(this.ifShowTermType, 10);
        jceOutputStream.write(this.version, 11);
        ArrayList<Long> arrayList = this.uinList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 12);
        }
        jceOutputStream.write(this.eAppType, 13);
        jceOutputStream.write(this.ifGetDOVId, 14);
        jceOutputStream.write(this.ifGetBothFlag, 15);
        byte[] bArr = this.vec0xd50Req;
        if (bArr != null) {
            jceOutputStream.write(bArr, 16);
        }
        byte[] bArr2 = this.vec0xd6bReq;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 17);
        }
        ArrayList<Long> arrayList2 = this.vecSnsTypelist;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 18);
        }
    }

    public GetFriendListReq(int i3, byte b16, long j3, short s16, short s17, byte b17, byte b18, byte b19, byte b26, byte b27, byte b28, long j16, ArrayList<Long> arrayList, int i16, byte b29, byte b36, byte[] bArr, byte[] bArr2, ArrayList<Long> arrayList2) {
        this.reqtype = i3;
        this.ifReflush = b16;
        this.uin = j3;
        this.startIndex = s16;
        this.getfriendCount = s17;
        this.groupid = b17;
        this.ifGetGroupInfo = b18;
        this.groupstartIndex = b19;
        this.getgroupCount = b26;
        this.ifGetMSFGroup = b27;
        this.ifShowTermType = b28;
        this.version = j16;
        this.uinList = arrayList;
        this.eAppType = i16;
        this.ifGetDOVId = b29;
        this.ifGetBothFlag = b36;
        this.vec0xd50Req = bArr;
        this.vec0xd6bReq = bArr2;
        this.vecSnsTypelist = arrayList2;
    }
}
