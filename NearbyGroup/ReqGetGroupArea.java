package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetGroupArea extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public long dwGroupStartIdx;
    public int iCount;
    public int iLat;
    public int iLon;
    public String strAreaName;

    public ReqGetGroupArea() {
        this.strAreaName = "";
        this.iLat = 0;
        this.iLon = 0;
        this.dwGroupStartIdx = 0L;
        this.iCount = 0;
    }

    public String className() {
        return "NearbyGroup.ReqGetGroupArea";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.strAreaName, "strAreaName");
        jceDisplayer.display(this.iLat, "iLat");
        jceDisplayer.display(this.iLon, "iLon");
        jceDisplayer.display(this.dwGroupStartIdx, "dwGroupStartIdx");
        jceDisplayer.display(this.iCount, FloatCacheData.ICOUNT);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.strAreaName, true);
        jceDisplayer.displaySimple(this.iLat, true);
        jceDisplayer.displaySimple(this.iLon, true);
        jceDisplayer.displaySimple(this.dwGroupStartIdx, true);
        jceDisplayer.displaySimple(this.iCount, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqGetGroupArea reqGetGroupArea = (ReqGetGroupArea) obj;
        if (!JceUtil.equals(this.strAreaName, reqGetGroupArea.strAreaName) || !JceUtil.equals(this.iLat, reqGetGroupArea.iLat) || !JceUtil.equals(this.iLon, reqGetGroupArea.iLon) || !JceUtil.equals(this.dwGroupStartIdx, reqGetGroupArea.dwGroupStartIdx) || !JceUtil.equals(this.iCount, reqGetGroupArea.iCount)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NearbyGroup.ReqGetGroupArea";
    }

    public long getDwGroupStartIdx() {
        return this.dwGroupStartIdx;
    }

    public int getICount() {
        return this.iCount;
    }

    public int getILat() {
        return this.iLat;
    }

    public int getILon() {
        return this.iLon;
    }

    public String getStrAreaName() {
        return this.strAreaName;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strAreaName = jceInputStream.readString(0, true);
        this.iLat = jceInputStream.read(this.iLat, 1, true);
        this.iLon = jceInputStream.read(this.iLon, 2, true);
        this.dwGroupStartIdx = jceInputStream.read(this.dwGroupStartIdx, 3, false);
        this.iCount = jceInputStream.read(this.iCount, 4, true);
    }

    public void setDwGroupStartIdx(long j3) {
        this.dwGroupStartIdx = j3;
    }

    public void setICount(int i3) {
        this.iCount = i3;
    }

    public void setILat(int i3) {
        this.iLat = i3;
    }

    public void setILon(int i3) {
        this.iLon = i3;
    }

    public void setStrAreaName(String str) {
        this.strAreaName = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strAreaName, 0);
        jceOutputStream.write(this.iLat, 1);
        jceOutputStream.write(this.iLon, 2);
        jceOutputStream.write(this.dwGroupStartIdx, 3);
        jceOutputStream.write(this.iCount, 4);
    }

    public ReqGetGroupArea(String str, int i3, int i16, long j3, int i17) {
        this.strAreaName = str;
        this.iLat = i3;
        this.iLon = i16;
        this.dwGroupStartIdx = j3;
        this.iCount = i17;
    }
}
