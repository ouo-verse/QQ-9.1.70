package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShowRule extends JceStruct {
    static ArrayList<ShowRangeTime> cache_rangTimes = new ArrayList<>();
    public ArrayList<ShowRangeTime> rangTimes;
    public int showCount;
    public int showType;

    static {
        cache_rangTimes.add(new ShowRangeTime());
    }

    public ShowRule() {
        this.showType = 0;
        this.showCount = 0;
        this.rangTimes = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.showType = jceInputStream.read(this.showType, 0, false);
        this.showCount = jceInputStream.read(this.showCount, 1, false);
        this.rangTimes = (ArrayList) jceInputStream.read((JceInputStream) cache_rangTimes, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "ShowRule{showType=" + this.showType + ", showCount=" + this.showCount + ", rangTimes=" + this.rangTimes + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.showType, 0);
        jceOutputStream.write(this.showCount, 1);
        ArrayList<ShowRangeTime> arrayList = this.rangTimes;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public ShowRule(int i3, int i16, ArrayList<ShowRangeTime> arrayList) {
        this.showType = i3;
        this.showCount = i16;
        this.rangTimes = arrayList;
    }
}
