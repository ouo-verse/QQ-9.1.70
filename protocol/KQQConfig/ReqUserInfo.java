package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReqUserInfo extends JceStruct {
    static GPS cache_stGps;
    static ArrayList<Cell> cache_vCells;
    static byte[] cache_vLBSKeyData;
    static ArrayList<Long> cache_vMacs;
    public byte cType;
    public GPS stGps;
    public String strAuthName;
    public String strAuthPassword;
    public ArrayList<Cell> vCells;
    public byte[] vLBSKeyData;
    public ArrayList<Long> vMacs;

    public ReqUserInfo() {
        this.stGps = null;
        this.vMacs = null;
        this.vCells = new ArrayList<>();
        this.strAuthName = "";
        this.strAuthPassword = "";
        this.cType = (byte) 0;
        this.vLBSKeyData = null;
    }

    public String className() {
        return "KQQConfig.ReqUserInfo";
    }

    public String fullClassName() {
        return "protocol.KQQConfig.ReqUserInfo";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new GPS();
        }
        this.stGps = (GPS) jceInputStream.read((JceStruct) cache_stGps, 0, true);
        if (cache_vMacs == null) {
            cache_vMacs = new ArrayList<>();
            cache_vMacs.add(0L);
        }
        this.vMacs = (ArrayList) jceInputStream.read((JceInputStream) cache_vMacs, 1, true);
        if (cache_vCells == null) {
            cache_vCells = new ArrayList<>();
            cache_vCells.add(new Cell());
        }
        this.vCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vCells, 2, true);
        this.strAuthName = jceInputStream.readString(3, false);
        this.strAuthPassword = jceInputStream.readString(4, false);
        this.cType = jceInputStream.read(this.cType, 5, false);
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r0;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write((Collection) this.vMacs, 1);
        jceOutputStream.write((Collection) this.vCells, 2);
        String str = this.strAuthName;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strAuthPassword;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.cType, 5);
        byte[] bArr = this.vLBSKeyData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
    }

    public ReqUserInfo(GPS gps, ArrayList<Long> arrayList, ArrayList<Cell> arrayList2, String str, String str2, byte b16, byte[] bArr) {
        this.stGps = null;
        this.vMacs = null;
        new ArrayList();
        this.stGps = gps;
        this.vMacs = arrayList;
        this.vCells = arrayList2;
        this.strAuthName = str;
        this.strAuthPassword = str2;
        this.cType = b16;
        this.vLBSKeyData = bArr;
    }
}
