package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspGetNearbyGroup extends JceStruct {
    static int cache_eReplyCode;
    static RspActivity cache_stRspAct;
    static RspHotGrp cache_stRspHotGrp;
    static RspTopic cache_stRspTopic;
    static ArrayList<Activity> cache_vActivity;
    static byte[] cache_vContext;
    static ArrayList<GroupArea> cache_vGroupArea;
    static ArrayList<GroupInfo> cache_vGroupInfo;
    static ArrayList<XiaoQuInfo> cache_vXiaoQuInfo;
    public short dwFlag;
    public int eReplyCode;
    public int iCompletedFlag;
    public int iLat;
    public int iLon;
    public int iRadius;
    public short shSortType;
    public RspActivity stRspAct;
    public RspHotGrp stRspHotGrp;
    public RspTopic stRspTopic;
    public String strCity;
    public String strCityCode;
    public ArrayList<Activity> vActivity;
    public byte[] vContext;
    public ArrayList<GroupArea> vGroupArea;
    public ArrayList<GroupInfo> vGroupInfo;
    public ArrayList<XiaoQuInfo> vXiaoQuInfo;

    public RspGetNearbyGroup() {
        this.eReplyCode = 0;
        this.vContext = null;
        this.iCompletedFlag = 0;
        this.iRadius = 0;
        this.vGroupInfo = null;
        this.vXiaoQuInfo = null;
        this.vActivity = null;
        this.vGroupArea = null;
        this.shSortType = (short) 0;
        this.iLat = 0;
        this.iLon = 0;
        this.stRspHotGrp = null;
        this.stRspAct = null;
        this.stRspTopic = null;
        this.strCity = "";
        this.strCityCode = "";
        this.dwFlag = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eReplyCode = jceInputStream.read(this.eReplyCode, 0, true);
        if (cache_vContext == null) {
            cache_vContext = r0;
            byte[] bArr = {0};
        }
        this.vContext = jceInputStream.read(cache_vContext, 1, false);
        this.iCompletedFlag = jceInputStream.read(this.iCompletedFlag, 2, true);
        this.iRadius = jceInputStream.read(this.iRadius, 3, false);
        if (cache_vGroupInfo == null) {
            cache_vGroupInfo = new ArrayList<>();
            cache_vGroupInfo.add(new GroupInfo());
        }
        this.vGroupInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupInfo, 4, false);
        if (cache_vXiaoQuInfo == null) {
            cache_vXiaoQuInfo = new ArrayList<>();
            cache_vXiaoQuInfo.add(new XiaoQuInfo());
        }
        this.vXiaoQuInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vXiaoQuInfo, 5, false);
        if (cache_vActivity == null) {
            cache_vActivity = new ArrayList<>();
            cache_vActivity.add(new Activity());
        }
        this.vActivity = (ArrayList) jceInputStream.read((JceInputStream) cache_vActivity, 6, false);
        if (cache_vGroupArea == null) {
            cache_vGroupArea = new ArrayList<>();
            cache_vGroupArea.add(new GroupArea());
        }
        this.vGroupArea = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupArea, 7, false);
        this.shSortType = jceInputStream.read(this.shSortType, 8, false);
        this.iLat = jceInputStream.read(this.iLat, 9, false);
        this.iLon = jceInputStream.read(this.iLon, 10, false);
        if (cache_stRspHotGrp == null) {
            cache_stRspHotGrp = new RspHotGrp();
        }
        this.stRspHotGrp = (RspHotGrp) jceInputStream.read((JceStruct) cache_stRspHotGrp, 11, false);
        if (cache_stRspAct == null) {
            cache_stRspAct = new RspActivity();
        }
        this.stRspAct = (RspActivity) jceInputStream.read((JceStruct) cache_stRspAct, 12, false);
        if (cache_stRspTopic == null) {
            cache_stRspTopic = new RspTopic();
        }
        this.stRspTopic = (RspTopic) jceInputStream.read((JceStruct) cache_stRspTopic, 13, false);
        this.strCity = jceInputStream.readString(14, false);
        this.strCityCode = jceInputStream.readString(15, false);
        this.dwFlag = jceInputStream.read(this.dwFlag, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eReplyCode, 0);
        byte[] bArr = this.vContext;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.iCompletedFlag, 2);
        jceOutputStream.write(this.iRadius, 3);
        ArrayList<GroupInfo> arrayList = this.vGroupInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<XiaoQuInfo> arrayList2 = this.vXiaoQuInfo;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        ArrayList<Activity> arrayList3 = this.vActivity;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 6);
        }
        ArrayList<GroupArea> arrayList4 = this.vGroupArea;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 7);
        }
        jceOutputStream.write(this.shSortType, 8);
        jceOutputStream.write(this.iLat, 9);
        jceOutputStream.write(this.iLon, 10);
        RspHotGrp rspHotGrp = this.stRspHotGrp;
        if (rspHotGrp != null) {
            jceOutputStream.write((JceStruct) rspHotGrp, 11);
        }
        RspActivity rspActivity = this.stRspAct;
        if (rspActivity != null) {
            jceOutputStream.write((JceStruct) rspActivity, 12);
        }
        RspTopic rspTopic = this.stRspTopic;
        if (rspTopic != null) {
            jceOutputStream.write((JceStruct) rspTopic, 13);
        }
        String str = this.strCity;
        if (str != null) {
            jceOutputStream.write(str, 14);
        }
        String str2 = this.strCityCode;
        if (str2 != null) {
            jceOutputStream.write(str2, 15);
        }
        jceOutputStream.write(this.dwFlag, 16);
    }

    public RspGetNearbyGroup(int i3, byte[] bArr, int i16, int i17, ArrayList<GroupInfo> arrayList, ArrayList<XiaoQuInfo> arrayList2, ArrayList<Activity> arrayList3, ArrayList<GroupArea> arrayList4, short s16, int i18, int i19, RspHotGrp rspHotGrp, RspActivity rspActivity, RspTopic rspTopic, String str, String str2, short s17) {
        this.eReplyCode = i3;
        this.vContext = bArr;
        this.iCompletedFlag = i16;
        this.iRadius = i17;
        this.vGroupInfo = arrayList;
        this.vXiaoQuInfo = arrayList2;
        this.vActivity = arrayList3;
        this.vGroupArea = arrayList4;
        this.shSortType = s16;
        this.iLat = i18;
        this.iLon = i19;
        this.stRspHotGrp = rspHotGrp;
        this.stRspAct = rspActivity;
        this.stRspTopic = rspTopic;
        this.strCity = str;
        this.strCityCode = str2;
        this.dwFlag = s17;
    }
}
