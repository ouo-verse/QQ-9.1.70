package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupInfo extends JceStruct implements Cloneable {
    static ArrayList<GroupLabel> cache_labels = new ArrayList<>();
    public boolean bAlive;
    public boolean bIsNew;
    public long dwCertType;
    public long dwExtFlag;
    public long dwGroupActiveGrade;
    public long dwGroupFlagExt;
    public int iDistance;
    public int iFaceId;
    public int iLat;
    public int iLon;
    public int iMemberCnt;
    public int iOnlineMemberCnt;
    public long lCode;
    public long lCreator;
    public long lUin;
    public ArrayList<GroupLabel> labels;
    public String strIntro;
    public String strJoinAuth;
    public String strJoinSig;
    public String strLocation;
    public String strName;

    static {
        cache_labels.add(new GroupLabel());
    }

    public GroupInfo() {
        this.lCode = 0L;
        this.strName = "";
        this.strLocation = "";
        this.iMemberCnt = 0;
        this.strIntro = "";
        this.iFaceId = 0;
        this.bAlive = true;
        this.iDistance = 0;
        this.iOnlineMemberCnt = 0;
        this.dwGroupFlagExt = 0L;
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.lUin = 0L;
        this.dwCertType = 0L;
        this.dwGroupActiveGrade = 0L;
        this.bIsNew = false;
        this.lCreator = 0L;
        this.dwExtFlag = 0L;
        this.labels = null;
        this.strJoinAuth = "";
        this.strJoinSig = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lCode = jceInputStream.read(this.lCode, 0, true);
        this.strName = jceInputStream.readString(1, true);
        this.strLocation = jceInputStream.readString(2, true);
        this.iMemberCnt = jceInputStream.read(this.iMemberCnt, 3, true);
        this.strIntro = jceInputStream.readString(4, true);
        this.iFaceId = jceInputStream.read(this.iFaceId, 5, true);
        this.bAlive = jceInputStream.read(this.bAlive, 6, true);
        this.iDistance = jceInputStream.read(this.iDistance, 7, false);
        this.iOnlineMemberCnt = jceInputStream.read(this.iOnlineMemberCnt, 8, false);
        this.dwGroupFlagExt = jceInputStream.read(this.dwGroupFlagExt, 9, false);
        this.iLat = jceInputStream.read(this.iLat, 10, false);
        this.iLon = jceInputStream.read(this.iLon, 11, false);
        this.lUin = jceInputStream.read(this.lUin, 12, false);
        this.dwCertType = jceInputStream.read(this.dwCertType, 13, false);
        this.dwGroupActiveGrade = jceInputStream.read(this.dwGroupActiveGrade, 14, false);
        this.bIsNew = jceInputStream.read(this.bIsNew, 15, false);
        this.lCreator = jceInputStream.read(this.lCreator, 16, false);
        this.dwExtFlag = jceInputStream.read(this.dwExtFlag, 17, false);
        this.labels = (ArrayList) jceInputStream.read((JceInputStream) cache_labels, 18, false);
        this.strJoinAuth = jceInputStream.readString(19, false);
        this.strJoinSig = jceInputStream.readString(20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lCode, 0);
        jceOutputStream.write(this.strName, 1);
        jceOutputStream.write(this.strLocation, 2);
        jceOutputStream.write(this.iMemberCnt, 3);
        jceOutputStream.write(this.strIntro, 4);
        jceOutputStream.write(this.iFaceId, 5);
        jceOutputStream.write(this.bAlive, 6);
        jceOutputStream.write(this.iDistance, 7);
        jceOutputStream.write(this.iOnlineMemberCnt, 8);
        jceOutputStream.write(this.dwGroupFlagExt, 9);
        jceOutputStream.write(this.iLat, 10);
        jceOutputStream.write(this.iLon, 11);
        jceOutputStream.write(this.lUin, 12);
        jceOutputStream.write(this.dwCertType, 13);
        jceOutputStream.write(this.dwGroupActiveGrade, 14);
        jceOutputStream.write(this.bIsNew, 15);
        jceOutputStream.write(this.lCreator, 16);
        jceOutputStream.write(this.dwExtFlag, 17);
        ArrayList<GroupLabel> arrayList = this.labels;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 18);
        }
        String str = this.strJoinAuth;
        if (str != null) {
            jceOutputStream.write(str, 19);
        }
        String str2 = this.strJoinSig;
        if (str2 != null) {
            jceOutputStream.write(str2, 20);
        }
    }

    public GroupInfo(long j3, String str, String str2, int i3, String str3, int i16, boolean z16, int i17, int i18, long j16, int i19, int i26, long j17, long j18, long j19, boolean z17, long j26, long j27, ArrayList<GroupLabel> arrayList, String str4, String str5) {
        this.lCode = j3;
        this.strName = str;
        this.strLocation = str2;
        this.iMemberCnt = i3;
        this.strIntro = str3;
        this.iFaceId = i16;
        this.bAlive = z16;
        this.iDistance = i17;
        this.iOnlineMemberCnt = i18;
        this.dwGroupFlagExt = j16;
        this.iLat = i19;
        this.iLon = i26;
        this.lUin = j17;
        this.dwCertType = j18;
        this.dwGroupActiveGrade = j19;
        this.bIsNew = z17;
        this.lCreator = j26;
        this.dwExtFlag = j27;
        this.labels = arrayList;
        this.strJoinAuth = str4;
        this.strJoinSig = str5;
    }
}
