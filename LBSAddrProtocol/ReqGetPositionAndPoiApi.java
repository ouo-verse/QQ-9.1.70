package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ReqGetPositionAndPoiApi extends JceStruct {
    static byte[] cache_vLBSKeyData;
    static ArrayList<Integer> cache_vTypes;
    public int iBeginPos;
    public int iRadius;
    public int iReqNum;
    public int iSortMethod;
    public byte[] vLBSKeyData;
    public ArrayList<Integer> vTypes;

    public ReqGetPositionAndPoiApi() {
        this.vLBSKeyData = null;
        this.vTypes = null;
        this.iRadius = 100;
        this.iBeginPos = 0;
        this.iReqNum = 10;
        this.iSortMethod = 2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r0;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 0, true);
        if (cache_vTypes == null) {
            cache_vTypes = new ArrayList<>();
            cache_vTypes.add(0);
        }
        this.vTypes = (ArrayList) jceInputStream.read((JceInputStream) cache_vTypes, 1, true);
        this.iRadius = jceInputStream.read(this.iRadius, 2, true);
        this.iBeginPos = jceInputStream.read(this.iBeginPos, 3, true);
        this.iReqNum = jceInputStream.read(this.iReqNum, 4, true);
        this.iSortMethod = jceInputStream.read(this.iSortMethod, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vLBSKeyData, 0);
        jceOutputStream.write((Collection) this.vTypes, 1);
        jceOutputStream.write(this.iRadius, 2);
        jceOutputStream.write(this.iBeginPos, 3);
        jceOutputStream.write(this.iReqNum, 4);
        jceOutputStream.write(this.iSortMethod, 5);
    }

    public ReqGetPositionAndPoiApi(byte[] bArr, ArrayList<Integer> arrayList, int i3, int i16, int i17, int i18) {
        this.vLBSKeyData = bArr;
        this.vTypes = arrayList;
        this.iRadius = i3;
        this.iBeginPos = i16;
        this.iReqNum = i17;
        this.iSortMethod = i18;
    }
}
