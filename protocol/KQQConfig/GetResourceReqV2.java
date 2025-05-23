package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetResourceReqV2 extends JceStruct {
    static ArrayList<GetResourceReqInfoV2> cache_vecResReqInfo = new ArrayList<>();
    public byte cReqVer;
    public int iAppid;
    public int iPluginType;
    public String strModel;
    public ArrayList<GetResourceReqInfoV2> vecResReqInfo;

    static {
        cache_vecResReqInfo.add(new GetResourceReqInfoV2());
    }

    public GetResourceReqV2() {
        this.vecResReqInfo = null;
        this.iPluginType = 64;
        this.strModel = "";
        this.iAppid = 0;
        this.cReqVer = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecResReqInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResReqInfo, 1, true);
        this.iPluginType = jceInputStream.read(this.iPluginType, 2, false);
        this.strModel = jceInputStream.readString(3, false);
        this.iAppid = jceInputStream.read(this.iAppid, 4, false);
        this.cReqVer = jceInputStream.read(this.cReqVer, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecResReqInfo, 1);
        jceOutputStream.write(this.iPluginType, 2);
        String str = this.strModel;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.iAppid, 4);
        jceOutputStream.write(this.cReqVer, 5);
    }

    public GetResourceReqV2(ArrayList<GetResourceReqInfoV2> arrayList, int i3, String str, int i16, byte b16) {
        this.vecResReqInfo = arrayList;
        this.iPluginType = i3;
        this.strModel = str;
        this.iAppid = i16;
        this.cReqVer = b16;
    }
}
