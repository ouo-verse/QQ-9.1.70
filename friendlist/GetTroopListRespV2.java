package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetTroopListRespV2 extends JceStruct {
    static int cache_result;
    static byte[] cache_vecCookies;
    static ArrayList<stFavoriteGroup> cache_vecFavGroup;
    static ArrayList<Long> cache_vecGroupInfoExt;
    static ArrayList<stTroopNum> cache_vecTroopList = new ArrayList<>();
    static ArrayList<stTroopNum> cache_vecTroopListDel;
    static ArrayList<stTroopNum> cache_vecTroopListExt;
    static ArrayList<stGroupRankInfo> cache_vecTroopRank;
    public short errorCode;
    public int result;
    public short troopcount;
    public long uin;
    public byte[] vecCookies;
    public ArrayList<stFavoriteGroup> vecFavGroup;
    public ArrayList<Long> vecGroupInfoExt;
    public ArrayList<stTroopNum> vecTroopList;
    public ArrayList<stTroopNum> vecTroopListDel;
    public ArrayList<stTroopNum> vecTroopListExt;
    public ArrayList<stGroupRankInfo> vecTroopRank;

    static {
        cache_vecCookies = r0;
        byte[] bArr = {0};
        cache_vecTroopList.add(new stTroopNum());
        cache_vecTroopListDel = new ArrayList<>();
        cache_vecTroopListDel.add(new stTroopNum());
        cache_vecTroopRank = new ArrayList<>();
        cache_vecTroopRank.add(new stGroupRankInfo());
        cache_vecFavGroup = new ArrayList<>();
        cache_vecFavGroup.add(new stFavoriteGroup());
        cache_vecTroopListExt = new ArrayList<>();
        cache_vecTroopListExt.add(new stTroopNum());
        cache_vecGroupInfoExt = new ArrayList<>();
        cache_vecGroupInfoExt.add(0L);
    }

    public GetTroopListRespV2() {
        this.uin = 0L;
        this.troopcount = (short) 0;
        this.result = 0;
        this.errorCode = (short) 0;
        this.vecCookies = null;
        this.vecTroopList = null;
        this.vecTroopListDel = null;
        this.vecTroopRank = null;
        this.vecFavGroup = null;
        this.vecTroopListExt = null;
        this.vecGroupInfoExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.troopcount = jceInputStream.read(this.troopcount, 1, true);
        this.result = jceInputStream.read(this.result, 2, true);
        this.errorCode = jceInputStream.read(this.errorCode, 3, false);
        this.vecCookies = jceInputStream.read(cache_vecCookies, 4, false);
        this.vecTroopList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTroopList, 5, false);
        this.vecTroopListDel = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTroopListDel, 6, false);
        this.vecTroopRank = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTroopRank, 7, false);
        this.vecFavGroup = (ArrayList) jceInputStream.read((JceInputStream) cache_vecFavGroup, 8, false);
        this.vecTroopListExt = (ArrayList) jceInputStream.read((JceInputStream) cache_vecTroopListExt, 9, false);
        this.vecGroupInfoExt = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGroupInfoExt, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.troopcount, 1);
        jceOutputStream.write(this.result, 2);
        jceOutputStream.write(this.errorCode, 3);
        byte[] bArr = this.vecCookies;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        ArrayList<stTroopNum> arrayList = this.vecTroopList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        ArrayList<stTroopNum> arrayList2 = this.vecTroopListDel;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 6);
        }
        ArrayList<stGroupRankInfo> arrayList3 = this.vecTroopRank;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 7);
        }
        ArrayList<stFavoriteGroup> arrayList4 = this.vecFavGroup;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 8);
        }
        ArrayList<stTroopNum> arrayList5 = this.vecTroopListExt;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 9);
        }
        ArrayList<Long> arrayList6 = this.vecGroupInfoExt;
        if (arrayList6 != null) {
            jceOutputStream.write((Collection) arrayList6, 10);
        }
    }

    public GetTroopListRespV2(long j3, short s16, int i3, short s17, byte[] bArr, ArrayList<stTroopNum> arrayList, ArrayList<stTroopNum> arrayList2, ArrayList<stGroupRankInfo> arrayList3, ArrayList<stFavoriteGroup> arrayList4, ArrayList<stTroopNum> arrayList5, ArrayList<Long> arrayList6) {
        this.uin = j3;
        this.troopcount = s16;
        this.result = i3;
        this.errorCode = s17;
        this.vecCookies = bArr;
        this.vecTroopList = arrayList;
        this.vecTroopListDel = arrayList2;
        this.vecTroopRank = arrayList3;
        this.vecFavGroup = arrayList4;
        this.vecTroopListExt = arrayList5;
        this.vecGroupInfoExt = arrayList6;
    }
}
