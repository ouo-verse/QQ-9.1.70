package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetRecommender extends JceStruct {
    static int cache_eReasonType;
    static ArrayList<RespEncounterInfo> cache_vEncounterInfos;
    public int eReasonType;
    public int iExpiretime;
    public int iInnerInterval;
    public int iOuterInterval;
    public String strBrief;
    public String strTitle;
    public long uRecommendTime;
    public ArrayList<RespEncounterInfo> vEncounterInfos;

    public RespGetRecommender() {
        this.iOuterInterval = 86400;
        this.iInnerInterval = 180;
        this.iExpiretime = 172800;
        this.vEncounterInfos = null;
        this.eReasonType = 0;
        this.strBrief = "";
        this.strTitle = "";
        this.uRecommendTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iOuterInterval = jceInputStream.read(this.iOuterInterval, 0, false);
        this.iInnerInterval = jceInputStream.read(this.iInnerInterval, 1, false);
        this.iExpiretime = jceInputStream.read(this.iExpiretime, 2, false);
        if (cache_vEncounterInfos == null) {
            cache_vEncounterInfos = new ArrayList<>();
            cache_vEncounterInfos.add(new RespEncounterInfo());
        }
        this.vEncounterInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vEncounterInfos, 3, false);
        this.eReasonType = jceInputStream.read(this.eReasonType, 4, false);
        this.strBrief = jceInputStream.readString(5, false);
        this.strTitle = jceInputStream.readString(6, false);
        this.uRecommendTime = jceInputStream.read(this.uRecommendTime, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iOuterInterval, 0);
        jceOutputStream.write(this.iInnerInterval, 1);
        jceOutputStream.write(this.iExpiretime, 2);
        ArrayList<RespEncounterInfo> arrayList = this.vEncounterInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.eReasonType, 4);
        String str = this.strBrief;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.strTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.uRecommendTime, 7);
    }

    public RespGetRecommender(int i3, int i16, int i17, ArrayList<RespEncounterInfo> arrayList, int i18, String str, String str2, long j3) {
        this.iOuterInterval = i3;
        this.iInnerInterval = i16;
        this.iExpiretime = i17;
        this.vEncounterInfos = arrayList;
        this.eReasonType = i18;
        this.strBrief = str;
        this.strTitle = str2;
        this.uRecommendTime = j3;
    }
}
