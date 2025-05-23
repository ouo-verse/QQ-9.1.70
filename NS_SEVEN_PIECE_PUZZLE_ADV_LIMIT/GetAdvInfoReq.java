package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAdvInfoReq extends JceStruct {
    static ArrayList<String> cache_vecAdvIdList;
    public String strUid;
    public ArrayList<String> vecAdvIdList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecAdvIdList = arrayList;
        arrayList.add("");
    }

    public GetAdvInfoReq() {
        this.vecAdvIdList = null;
        this.strUid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecAdvIdList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAdvIdList, 0, false);
        this.strUid = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.vecAdvIdList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.strUid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetAdvInfoReq(ArrayList<String> arrayList, String str) {
        this.vecAdvIdList = arrayList;
        this.strUid = str;
    }
}
