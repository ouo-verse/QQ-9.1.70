package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FestivalGetRsp extends JceStruct {
    static ArrayList<FestivalGetRspItem> cache__vec_festivals = new ArrayList<>();
    public ArrayList<FestivalGetRspItem> _vec_festivals;

    static {
        cache__vec_festivals.add(new FestivalGetRspItem());
    }

    public FestivalGetRsp() {
        this._vec_festivals = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this._vec_festivals = (ArrayList) jceInputStream.read((JceInputStream) cache__vec_festivals, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<FestivalGetRspItem> arrayList = this._vec_festivals;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public FestivalGetRsp(ArrayList<FestivalGetRspItem> arrayList) {
        this._vec_festivals = arrayList;
    }
}
