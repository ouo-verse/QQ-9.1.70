package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetNearbyGroupArea extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int iLat;
    public int iLon;
    public int iRadius;

    public ReqGetNearbyGroupArea() {
        this.iLat = 0;
        this.iLon = 0;
        this.iRadius = 0;
    }

    public String className() {
        return "NearbyGroup.ReqGetNearbyGroupArea";
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
        jceDisplayer.display(this.iLat, "iLat");
        jceDisplayer.display(this.iLon, "iLon");
        jceDisplayer.display(this.iRadius, "iRadius");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.iLat, true);
        jceDisplayer.displaySimple(this.iLon, true);
        jceDisplayer.displaySimple(this.iRadius, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqGetNearbyGroupArea reqGetNearbyGroupArea = (ReqGetNearbyGroupArea) obj;
        if (!JceUtil.equals(this.iLat, reqGetNearbyGroupArea.iLat) || !JceUtil.equals(this.iLon, reqGetNearbyGroupArea.iLon) || !JceUtil.equals(this.iRadius, reqGetNearbyGroupArea.iRadius)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NearbyGroup.ReqGetNearbyGroupArea";
    }

    public int getILat() {
        return this.iLat;
    }

    public int getILon() {
        return this.iLon;
    }

    public int getIRadius() {
        return this.iRadius;
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
        this.iLat = jceInputStream.read(this.iLat, 0, true);
        this.iLon = jceInputStream.read(this.iLon, 1, true);
        this.iRadius = jceInputStream.read(this.iRadius, 2, true);
    }

    public void setILat(int i3) {
        this.iLat = i3;
    }

    public void setILon(int i3) {
        this.iLon = i3;
    }

    public void setIRadius(int i3) {
        this.iRadius = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iLat, 0);
        jceOutputStream.write(this.iLon, 1);
        jceOutputStream.write(this.iRadius, 2);
    }

    public ReqGetNearbyGroupArea(int i3, int i16, int i17) {
        this.iLat = i3;
        this.iLon = i16;
        this.iRadius = i17;
    }
}
