package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetServerListReq extends JceStruct {
    static ArrayList<String> cache_vUin;
    public byte bLinkType;
    public int iLastTime;
    public int netType;
    public String sImsi;
    public ArrayList<String> vUin;

    public GetServerListReq() {
        this.vUin = null;
        this.iLastTime = 0;
        this.bLinkType = (byte) 1;
        this.sImsi = "46000";
        this.netType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vUin == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vUin = arrayList;
            arrayList.add("");
        }
        this.vUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vUin, 1, true);
        this.iLastTime = jceInputStream.read(this.iLastTime, 2, true);
        this.bLinkType = jceInputStream.read(this.bLinkType, 3, false);
        this.sImsi = jceInputStream.readString(4, false);
        this.netType = jceInputStream.read(this.netType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vUin, 1);
        jceOutputStream.write(this.iLastTime, 2);
        jceOutputStream.write(this.bLinkType, 3);
        String str = this.sImsi;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.netType, 5);
    }

    public GetServerListReq(ArrayList<String> arrayList, int i3, byte b16, String str, int i16) {
        this.vUin = arrayList;
        this.iLastTime = i3;
        this.bLinkType = b16;
        this.sImsi = str;
        this.netType = i16;
    }
}
