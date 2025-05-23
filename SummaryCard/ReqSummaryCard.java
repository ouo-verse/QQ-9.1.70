package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSummaryCard extends JceStruct {
    static int cache_eAddFriendSource;
    static int cache_eComeFrom;
    static UserLocaleInfo cache_stLocaleInfo;
    static ArrayList<Integer> cache_vReq0x5ebFieldId;
    static byte[] cache_vReqKandianInfo;
    static byte[] cache_vReqLastGameInfo;
    static byte[] cache_vReqStarInfo;
    static byte[] cache_vReqTemplateInfo;
    static byte[] cache_vSecureSig;
    static byte[] cache_vSeed;
    static ArrayList<byte[]> cache_vvReqServices;
    public byte bIsFriend;
    public byte bReqCommLabel;
    public byte bReqExtendCard;
    public byte bReqMedalWallInfo;
    public byte bReqNearbyGodInfo;
    public int eAddFriendSource;
    public int eComeFrom;
    public long lGetControl;
    public long lGroupCode;
    public long lGroupUin;
    public long lTinyId;
    public long lUIN;
    public UserLocaleInfo stLocaleInfo;
    public String strSearchName;
    public long uLikeSource;
    public long uQzoneFeedTimestamp;
    public long uRichCardNameVer;
    public ArrayList<Integer> vReq0x5ebFieldId;
    public byte[] vReqKandianInfo;
    public byte[] vReqLastGameInfo;
    public byte[] vReqStarInfo;
    public byte[] vReqTemplateInfo;
    public byte[] vSecureSig;
    public byte[] vSeed;
    public ArrayList<byte[]> vvReqServices;

    static {
        cache_vSeed = r1;
        byte[] bArr = {0};
        cache_vSecureSig = r1;
        byte[] bArr2 = {0};
        cache_vReqLastGameInfo = r1;
        byte[] bArr3 = {0};
        cache_vReqTemplateInfo = r1;
        byte[] bArr4 = {0};
        cache_vReqStarInfo = r1;
        byte[] bArr5 = {0};
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_vvReqServices = arrayList;
        arrayList.add(new byte[]{0});
        cache_stLocaleInfo = new UserLocaleInfo();
        cache_vReq0x5ebFieldId = new ArrayList<>();
        cache_vReq0x5ebFieldId.add(0);
        cache_vReqKandianInfo = r0;
        byte[] bArr6 = {0};
    }

    public ReqSummaryCard() {
        this.lUIN = 0L;
        this.eComeFrom = 65535;
        this.uQzoneFeedTimestamp = 0L;
        this.bIsFriend = (byte) 0;
        this.lGroupCode = 0L;
        this.lGroupUin = 0L;
        this.vSeed = null;
        this.strSearchName = "";
        this.lGetControl = 0L;
        this.eAddFriendSource = 0;
        this.vSecureSig = null;
        this.vReqLastGameInfo = null;
        this.vReqTemplateInfo = null;
        this.vReqStarInfo = null;
        this.vvReqServices = null;
        this.lTinyId = 0L;
        this.uLikeSource = 0L;
        this.stLocaleInfo = null;
        this.bReqMedalWallInfo = (byte) 0;
        this.vReq0x5ebFieldId = null;
        this.bReqNearbyGodInfo = (byte) 0;
        this.bReqCommLabel = (byte) 0;
        this.bReqExtendCard = (byte) 0;
        this.vReqKandianInfo = null;
        this.uRichCardNameVer = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.eComeFrom = jceInputStream.read(this.eComeFrom, 1, true);
        this.uQzoneFeedTimestamp = jceInputStream.read(this.uQzoneFeedTimestamp, 2, false);
        this.bIsFriend = jceInputStream.read(this.bIsFriend, 3, false);
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 4, false);
        this.lGroupUin = jceInputStream.read(this.lGroupUin, 5, false);
        this.vSeed = jceInputStream.read(cache_vSeed, 6, false);
        this.strSearchName = jceInputStream.readString(7, false);
        this.lGetControl = jceInputStream.read(this.lGetControl, 8, false);
        this.eAddFriendSource = jceInputStream.read(this.eAddFriendSource, 9, false);
        this.vSecureSig = jceInputStream.read(cache_vSecureSig, 10, false);
        this.vReqLastGameInfo = jceInputStream.read(cache_vReqLastGameInfo, 11, false);
        this.vReqTemplateInfo = jceInputStream.read(cache_vReqTemplateInfo, 12, false);
        this.vReqStarInfo = jceInputStream.read(cache_vReqStarInfo, 13, false);
        this.vvReqServices = (ArrayList) jceInputStream.read((JceInputStream) cache_vvReqServices, 14, false);
        this.lTinyId = jceInputStream.read(this.lTinyId, 15, false);
        this.uLikeSource = jceInputStream.read(this.uLikeSource, 16, false);
        this.stLocaleInfo = (UserLocaleInfo) jceInputStream.read((JceStruct) cache_stLocaleInfo, 17, false);
        this.bReqMedalWallInfo = jceInputStream.read(this.bReqMedalWallInfo, 18, false);
        this.vReq0x5ebFieldId = (ArrayList) jceInputStream.read((JceInputStream) cache_vReq0x5ebFieldId, 19, false);
        this.bReqNearbyGodInfo = jceInputStream.read(this.bReqNearbyGodInfo, 20, false);
        this.bReqCommLabel = jceInputStream.read(this.bReqCommLabel, 21, false);
        this.bReqExtendCard = jceInputStream.read(this.bReqExtendCard, 22, false);
        this.vReqKandianInfo = jceInputStream.read(cache_vReqKandianInfo, 23, false);
        this.uRichCardNameVer = jceInputStream.read(this.uRichCardNameVer, 24, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.eComeFrom, 1);
        jceOutputStream.write(this.uQzoneFeedTimestamp, 2);
        jceOutputStream.write(this.bIsFriend, 3);
        jceOutputStream.write(this.lGroupCode, 4);
        jceOutputStream.write(this.lGroupUin, 5);
        byte[] bArr = this.vSeed;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        String str = this.strSearchName;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.lGetControl, 8);
        jceOutputStream.write(this.eAddFriendSource, 9);
        byte[] bArr2 = this.vSecureSig;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 10);
        }
        byte[] bArr3 = this.vReqLastGameInfo;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 11);
        }
        byte[] bArr4 = this.vReqTemplateInfo;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 12);
        }
        byte[] bArr5 = this.vReqStarInfo;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 13);
        }
        ArrayList<byte[]> arrayList = this.vvReqServices;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 14);
        }
        jceOutputStream.write(this.lTinyId, 15);
        jceOutputStream.write(this.uLikeSource, 16);
        UserLocaleInfo userLocaleInfo = this.stLocaleInfo;
        if (userLocaleInfo != null) {
            jceOutputStream.write((JceStruct) userLocaleInfo, 17);
        }
        jceOutputStream.write(this.bReqMedalWallInfo, 18);
        ArrayList<Integer> arrayList2 = this.vReq0x5ebFieldId;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 19);
        }
        jceOutputStream.write(this.bReqNearbyGodInfo, 20);
        jceOutputStream.write(this.bReqCommLabel, 21);
        jceOutputStream.write(this.bReqExtendCard, 22);
        byte[] bArr6 = this.vReqKandianInfo;
        if (bArr6 != null) {
            jceOutputStream.write(bArr6, 23);
        }
        jceOutputStream.write(this.uRichCardNameVer, 24);
    }

    public ReqSummaryCard(long j3, int i3, long j16, byte b16, long j17, long j18, byte[] bArr, String str, long j19, int i16, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, ArrayList<byte[]> arrayList, long j26, long j27, UserLocaleInfo userLocaleInfo, byte b17, ArrayList<Integer> arrayList2, byte b18, byte b19, byte b26, byte[] bArr6, long j28) {
        this.lUIN = j3;
        this.eComeFrom = i3;
        this.uQzoneFeedTimestamp = j16;
        this.bIsFriend = b16;
        this.lGroupCode = j17;
        this.lGroupUin = j18;
        this.vSeed = bArr;
        this.strSearchName = str;
        this.lGetControl = j19;
        this.eAddFriendSource = i16;
        this.vSecureSig = bArr2;
        this.vReqLastGameInfo = bArr3;
        this.vReqTemplateInfo = bArr4;
        this.vReqStarInfo = bArr5;
        this.vvReqServices = arrayList;
        this.lTinyId = j26;
        this.uLikeSource = j27;
        this.stLocaleInfo = userLocaleInfo;
        this.bReqMedalWallInfo = b17;
        this.vReq0x5ebFieldId = arrayList2;
        this.bReqNearbyGodInfo = b18;
        this.bReqCommLabel = b19;
        this.bReqExtendCard = b26;
        this.vReqKandianInfo = bArr6;
        this.uRichCardNameVer = j28;
    }
}
