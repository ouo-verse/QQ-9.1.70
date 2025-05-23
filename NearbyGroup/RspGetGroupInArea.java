package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspGetGroupInArea extends JceStruct {
    static GroupArea cache_stGroupArea;
    public GroupArea stGroupArea;

    public RspGetGroupInArea() {
        this.stGroupArea = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGroupArea == null) {
            cache_stGroupArea = new GroupArea();
        }
        this.stGroupArea = (GroupArea) jceInputStream.read((JceStruct) cache_stGroupArea, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        GroupArea groupArea = this.stGroupArea;
        if (groupArea != null) {
            jceOutputStream.write((JceStruct) groupArea, 0);
        }
    }

    public RspGetGroupInArea(GroupArea groupArea) {
        this.stGroupArea = groupArea;
    }
}
