package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspGetNearbyGroupArea extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<GroupArea> cache_vGroupArea;
    public ArrayList<GroupArea> vGroupArea;

    public RspGetNearbyGroupArea() {
        this.vGroupArea = null;
    }

    public String className() {
        return "NearbyGroup.RspGetNearbyGroupArea";
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
        new JceDisplayer(sb5, i3).display((Collection) this.vGroupArea, "vGroupArea");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple((Collection) this.vGroupArea, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.vGroupArea, ((RspGetNearbyGroupArea) obj).vGroupArea);
    }

    public String fullClassName() {
        return "NearbyGroup.RspGetNearbyGroupArea";
    }

    public ArrayList<GroupArea> getVGroupArea() {
        return this.vGroupArea;
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
        if (cache_vGroupArea == null) {
            cache_vGroupArea = new ArrayList<>();
            cache_vGroupArea.add(new GroupArea());
        }
        this.vGroupArea = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupArea, 0, false);
    }

    public void setVGroupArea(ArrayList<GroupArea> arrayList) {
        this.vGroupArea = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<GroupArea> arrayList = this.vGroupArea;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public RspGetNearbyGroupArea(ArrayList<GroupArea> arrayList) {
        this.vGroupArea = arrayList;
    }
}
