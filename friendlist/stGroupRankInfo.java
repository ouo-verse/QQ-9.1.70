package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stGroupRankInfo extends JceStruct {
    static ArrayList<stLevelRankPair> cache_vecRankMap = new ArrayList<>();
    static ArrayList<stLevelRankPair> cache_vecRankMapNew;
    public byte cGroupRankSysFlag;
    public byte cGroupRankUserFlag;
    public byte cGroupRankUserFlagNew;
    public long dwGroupCode;
    public long dwGroupRankSeq;
    public long dwOfficeMode;
    public String strAdminName;
    public String strOwnerName;
    public ArrayList<stLevelRankPair> vecRankMap;
    public ArrayList<stLevelRankPair> vecRankMapNew;

    static {
        cache_vecRankMap.add(new stLevelRankPair());
        cache_vecRankMapNew = new ArrayList<>();
        cache_vecRankMapNew.add(new stLevelRankPair());
    }

    public stGroupRankInfo() {
        this.dwGroupCode = 0L;
        this.cGroupRankSysFlag = (byte) 0;
        this.cGroupRankUserFlag = (byte) 0;
        this.vecRankMap = null;
        this.dwGroupRankSeq = 0L;
        this.strOwnerName = "";
        this.strAdminName = "";
        this.dwOfficeMode = 0L;
        this.cGroupRankUserFlagNew = (byte) 0;
        this.vecRankMapNew = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 0, true);
        this.cGroupRankSysFlag = jceInputStream.read(this.cGroupRankSysFlag, 1, false);
        this.cGroupRankUserFlag = jceInputStream.read(this.cGroupRankUserFlag, 2, false);
        this.vecRankMap = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRankMap, 3, false);
        this.dwGroupRankSeq = jceInputStream.read(this.dwGroupRankSeq, 4, false);
        this.strOwnerName = jceInputStream.readString(5, false);
        this.strAdminName = jceInputStream.readString(6, false);
        this.dwOfficeMode = jceInputStream.read(this.dwOfficeMode, 7, false);
        this.cGroupRankUserFlagNew = jceInputStream.read(this.cGroupRankUserFlagNew, 8, false);
        this.vecRankMapNew = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRankMapNew, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupCode, 0);
        jceOutputStream.write(this.cGroupRankSysFlag, 1);
        jceOutputStream.write(this.cGroupRankUserFlag, 2);
        ArrayList<stLevelRankPair> arrayList = this.vecRankMap;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.dwGroupRankSeq, 4);
        String str = this.strOwnerName;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.strAdminName;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.dwOfficeMode, 7);
        jceOutputStream.write(this.cGroupRankUserFlagNew, 8);
        ArrayList<stLevelRankPair> arrayList2 = this.vecRankMapNew;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 9);
        }
    }

    public stGroupRankInfo(long j3, byte b16, byte b17, ArrayList<stLevelRankPair> arrayList, long j16, String str, String str2, long j17, byte b18, ArrayList<stLevelRankPair> arrayList2) {
        this.dwGroupCode = j3;
        this.cGroupRankSysFlag = b16;
        this.cGroupRankUserFlag = b17;
        this.vecRankMap = arrayList;
        this.dwGroupRankSeq = j16;
        this.strOwnerName = str;
        this.strAdminName = str2;
        this.dwOfficeMode = j17;
        this.cGroupRankUserFlagNew = b18;
        this.vecRankMapNew = arrayList2;
    }
}
