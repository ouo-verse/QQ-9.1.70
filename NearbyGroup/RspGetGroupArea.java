package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspGetGroupArea extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static GroupArea cache_stGroupArea;
    public GroupArea stGroupArea;

    public RspGetGroupArea() {
        this.stGroupArea = null;
    }

    public String className() {
        return "NearbyGroup.RspGetGroupArea";
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
        new JceDisplayer(sb5, i3).display((JceStruct) this.stGroupArea, "stGroupArea");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple((JceStruct) this.stGroupArea, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.stGroupArea, ((RspGetGroupArea) obj).stGroupArea);
    }

    public String fullClassName() {
        return "NearbyGroup.RspGetGroupArea";
    }

    public GroupArea getStGroupArea() {
        return this.stGroupArea;
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
        if (cache_stGroupArea == null) {
            cache_stGroupArea = new GroupArea();
        }
        this.stGroupArea = (GroupArea) jceInputStream.read((JceStruct) cache_stGroupArea, 0, false);
    }

    public void setStGroupArea(GroupArea groupArea) {
        this.stGroupArea = groupArea;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        GroupArea groupArea = this.stGroupArea;
        if (groupArea != null) {
            jceOutputStream.write((JceStruct) groupArea, 0);
        }
    }

    public RspGetGroupArea(GroupArea groupArea) {
        this.stGroupArea = groupArea;
    }
}
