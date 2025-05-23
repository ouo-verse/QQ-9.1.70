package PasserbySvc;

import NeighborComm.Cell;
import NeighborComm.GPS;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqUserInfo extends JceStruct {
    static int cache_ePosType;
    static GPS cache_stGps;
    static ArrayList<Cell> cache_vCells;
    static byte[] cache_vLBSKeyData;
    static ArrayList<Long> cache_vMacs;
    public int ePosType;
    public GPS stGps;
    public String strAuthName;
    public String strAuthPassword;
    public ArrayList<Cell> vCells;
    public byte[] vLBSKeyData;
    public ArrayList<Long> vMacs;

    public ReqUserInfo() {
        this.strAuthName = "";
        this.strAuthPassword = "";
        this.ePosType = 0;
        this.stGps = null;
        this.vMacs = null;
        this.vCells = null;
        this.vLBSKeyData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strAuthName = jceInputStream.readString(0, true);
        this.strAuthPassword = jceInputStream.readString(1, true);
        this.ePosType = jceInputStream.read(this.ePosType, 2, true);
        if (cache_stGps == null) {
            cache_stGps = new GPS();
        }
        this.stGps = (GPS) jceInputStream.read((JceStruct) cache_stGps, 3, false);
        if (cache_vMacs == null) {
            cache_vMacs = new ArrayList<>();
            cache_vMacs.add(0L);
        }
        this.vMacs = (ArrayList) jceInputStream.read((JceInputStream) cache_vMacs, 4, false);
        if (cache_vCells == null) {
            cache_vCells = new ArrayList<>();
            cache_vCells.add(new Cell());
        }
        this.vCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vCells, 5, false);
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r1;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strAuthName, 0);
        jceOutputStream.write(this.strAuthPassword, 1);
        jceOutputStream.write(this.ePosType, 2);
        GPS gps = this.stGps;
        if (gps != null) {
            jceOutputStream.write((JceStruct) gps, 3);
        }
        ArrayList<Long> arrayList = this.vMacs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<Cell> arrayList2 = this.vCells;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        byte[] bArr = this.vLBSKeyData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
    }

    public ReqUserInfo(String str, String str2, int i3, GPS gps, ArrayList<Long> arrayList, ArrayList<Cell> arrayList2, byte[] bArr) {
        this.strAuthName = str;
        this.strAuthPassword = str2;
        this.ePosType = i3;
        this.stGps = gps;
        this.vMacs = arrayList;
        this.vCells = arrayList2;
        this.vLBSKeyData = bArr;
    }
}
