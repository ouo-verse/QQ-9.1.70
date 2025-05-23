package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SDKConfReq extends JceStruct {
    static ArrayList<String> cache_sUin;
    public int iConfVersion;
    public int iGetEspLastTime;
    public int iGetSdkLastTime;
    public ArrayList<String> sUin;

    public SDKConfReq() {
        this.iConfVersion = 0;
        this.iGetSdkLastTime = 0;
        this.sUin = null;
        this.iGetEspLastTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iConfVersion = jceInputStream.read(this.iConfVersion, 1, false);
        this.iGetSdkLastTime = jceInputStream.read(this.iGetSdkLastTime, 2, false);
        if (cache_sUin == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_sUin = arrayList;
            arrayList.add("");
        }
        this.sUin = (ArrayList) jceInputStream.read((JceInputStream) cache_sUin, 3, false);
        this.iGetEspLastTime = jceInputStream.read(this.iGetEspLastTime, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iConfVersion, 1);
        jceOutputStream.write(this.iGetSdkLastTime, 2);
        ArrayList<String> arrayList = this.sUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.iGetEspLastTime, 4);
    }

    public SDKConfReq(int i3, int i16, ArrayList<String> arrayList, int i17) {
        this.iConfVersion = i3;
        this.iGetSdkLastTime = i16;
        this.sUin = arrayList;
        this.iGetEspLastTime = i17;
    }
}
