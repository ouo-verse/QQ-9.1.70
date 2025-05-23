package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ReqSearchNearPoiListApi extends JceStruct {
    static byte[] cache_vLBSKeyData;
    static ArrayList<Integer> cache_vTypes;
    public int iBeginPos;
    public int iRadius;
    public int iReqNum;
    public String strKeyword;
    public byte[] vLBSKeyData;
    public ArrayList<Integer> vTypes;

    public ReqSearchNearPoiListApi() {
        this.vLBSKeyData = null;
        this.strKeyword = "";
        this.vTypes = null;
        this.iRadius = 100;
        this.iBeginPos = 0;
        this.iReqNum = 10;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r0;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 0, true);
        this.strKeyword = jceInputStream.readString(1, true);
        if (cache_vTypes == null) {
            cache_vTypes = new ArrayList<>();
            cache_vTypes.add(0);
        }
        this.vTypes = (ArrayList) jceInputStream.read((JceInputStream) cache_vTypes, 2, true);
        this.iRadius = jceInputStream.read(this.iRadius, 3, true);
        this.iBeginPos = jceInputStream.read(this.iBeginPos, 4, true);
        this.iReqNum = jceInputStream.read(this.iReqNum, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vLBSKeyData, 0);
        jceOutputStream.write(this.strKeyword, 1);
        jceOutputStream.write((Collection) this.vTypes, 2);
        jceOutputStream.write(this.iRadius, 3);
        jceOutputStream.write(this.iBeginPos, 4);
        jceOutputStream.write(this.iReqNum, 5);
    }

    public ReqSearchNearPoiListApi(byte[] bArr, String str, ArrayList<Integer> arrayList, int i3, int i16, int i17) {
        this.vLBSKeyData = bArr;
        this.strKeyword = str;
        this.vTypes = arrayList;
        this.iRadius = i3;
        this.iBeginPos = i16;
        this.iReqNum = i17;
    }
}
