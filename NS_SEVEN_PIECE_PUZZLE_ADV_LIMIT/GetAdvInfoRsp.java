package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAdvInfoRsp extends JceStruct {
    static ArrayList<AdvExposureInfo> cache_vecAdvExposureInfo = new ArrayList<>();
    public int Code;
    public String Msg;
    public ArrayList<AdvExposureInfo> vecAdvExposureInfo;

    static {
        cache_vecAdvExposureInfo.add(new AdvExposureInfo());
    }

    public GetAdvInfoRsp() {
        this.Code = 0;
        this.Msg = "";
        this.vecAdvExposureInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Msg = jceInputStream.readString(1, false);
        this.vecAdvExposureInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAdvExposureInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<AdvExposureInfo> arrayList = this.vecAdvExposureInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public GetAdvInfoRsp(int i3, String str, ArrayList<AdvExposureInfo> arrayList) {
        this.Code = i3;
        this.Msg = str;
        this.vecAdvExposureInfo = arrayList;
    }
}
