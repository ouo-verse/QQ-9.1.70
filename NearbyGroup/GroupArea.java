package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupArea extends JceStruct {
    static ArrayList<GroupInfo> cache_vGroupInfo;
    public long dwDistance;
    public long dwGroupStartIdx;
    public long dwGroupTotalCnt;
    public int iLat;
    public int iLon;
    public String strAreaName;
    public String strStreet;
    public ArrayList<GroupInfo> vGroupInfo;

    public GroupArea() {
        this.strAreaName = "";
        this.iLat = 0;
        this.iLon = 0;
        this.dwGroupStartIdx = 0L;
        this.vGroupInfo = null;
        this.dwGroupTotalCnt = 0L;
        this.dwDistance = 0L;
        this.strStreet = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strAreaName = jceInputStream.readString(0, true);
        this.iLat = jceInputStream.read(this.iLat, 1, true);
        this.iLon = jceInputStream.read(this.iLon, 2, true);
        this.dwGroupStartIdx = jceInputStream.read(this.dwGroupStartIdx, 3, false);
        if (cache_vGroupInfo == null) {
            cache_vGroupInfo = new ArrayList<>();
            cache_vGroupInfo.add(new GroupInfo());
        }
        this.vGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupInfo, 4, false);
        this.dwGroupTotalCnt = jceInputStream.read(this.dwGroupTotalCnt, 5, true);
        this.dwDistance = jceInputStream.read(this.dwDistance, 6, false);
        this.strStreet = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strAreaName, 0);
        jceOutputStream.write(this.iLat, 1);
        jceOutputStream.write(this.iLon, 2);
        jceOutputStream.write(this.dwGroupStartIdx, 3);
        ArrayList<GroupInfo> arrayList = this.vGroupInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.dwGroupTotalCnt, 5);
        jceOutputStream.write(this.dwDistance, 6);
        String str = this.strStreet;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
    }

    public GroupArea(String str, int i3, int i16, long j3, ArrayList<GroupInfo> arrayList, long j16, long j17, String str2) {
        this.strAreaName = str;
        this.iLat = i3;
        this.iLon = i16;
        this.dwGroupStartIdx = j3;
        this.vGroupInfo = arrayList;
        this.dwGroupTotalCnt = j16;
        this.dwDistance = j17;
        this.strStreet = str2;
    }
}
