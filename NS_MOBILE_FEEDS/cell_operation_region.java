package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_operation_region extends JceStruct {
    static ArrayList<stRegionData> cache_vcRegion = new ArrayList<>();
    public String gestureLineColor;
    public int gestureRadius;
    public int gestureStartTime;
    public int interactiveType;
    public ArrayList<stRegionData> vcRegion;

    static {
        cache_vcRegion.add(new stRegionData());
    }

    public cell_operation_region() {
        this.vcRegion = null;
        this.interactiveType = 0;
        this.gestureRadius = 0;
        this.gestureStartTime = 0;
        this.gestureLineColor = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vcRegion = (ArrayList) jceInputStream.read((JceInputStream) cache_vcRegion, 0, false);
        this.interactiveType = jceInputStream.read(this.interactiveType, 1, false);
        this.gestureRadius = jceInputStream.read(this.gestureRadius, 2, false);
        this.gestureStartTime = jceInputStream.read(this.gestureStartTime, 3, false);
        this.gestureLineColor = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<stRegionData> arrayList = this.vcRegion;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.interactiveType, 1);
        jceOutputStream.write(this.gestureRadius, 2);
        jceOutputStream.write(this.gestureStartTime, 3);
        String str = this.gestureLineColor;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public cell_operation_region(ArrayList<stRegionData> arrayList, int i3, int i16, int i17, String str) {
        this.vcRegion = arrayList;
        this.interactiveType = i3;
        this.gestureRadius = i16;
        this.gestureStartTime = i17;
        this.gestureLineColor = str;
    }
}
