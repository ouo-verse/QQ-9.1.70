package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomTrack extends JceStruct {
    static ArrayList<CustomTrackAction> cache_Actions = new ArrayList<>();
    public ArrayList<CustomTrackAction> Actions;

    static {
        cache_Actions.add(new CustomTrackAction());
    }

    public CustomTrack() {
        this.Actions = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Actions = (ArrayList) jceInputStream.read((JceInputStream) cache_Actions, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<CustomTrackAction> arrayList = this.Actions;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public CustomTrack(ArrayList<CustomTrackAction> arrayList) {
        this.Actions = arrayList;
    }
}
