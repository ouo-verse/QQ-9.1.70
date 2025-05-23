package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PositionInfoForLBS extends JceStruct {
    static GPS cache_stGps;
    static ArrayList<Cell> cache_vCells;
    static byte[] cache_vLBSKeyData;
    static ArrayList<Long> cache_vMacs;
    public byte bPositionInfoType;
    public GPS stGps;
    public ArrayList<Cell> vCells;
    public byte[] vLBSKeyData;
    public ArrayList<Long> vMacs;

    public PositionInfoForLBS() {
        this.bPositionInfoType = (byte) 0;
        this.stGps = null;
        this.vMacs = null;
        this.vCells = null;
        this.vLBSKeyData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bPositionInfoType = jceInputStream.read(this.bPositionInfoType, 1, true);
        if (cache_stGps == null) {
            cache_stGps = new GPS();
        }
        this.stGps = (GPS) jceInputStream.read((JceStruct) cache_stGps, 2, false);
        if (cache_vMacs == null) {
            cache_vMacs = new ArrayList<>();
            cache_vMacs.add(0L);
        }
        this.vMacs = (ArrayList) jceInputStream.read((JceInputStream) cache_vMacs, 3, false);
        if (cache_vCells == null) {
            cache_vCells = new ArrayList<>();
            cache_vCells.add(new Cell());
        }
        this.vCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vCells, 4, false);
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r0;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bPositionInfoType, 1);
        GPS gps = this.stGps;
        if (gps != null) {
            jceOutputStream.write((JceStruct) gps, 2);
        }
        ArrayList<Long> arrayList = this.vMacs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<Cell> arrayList2 = this.vCells;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        byte[] bArr = this.vLBSKeyData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
    }

    public PositionInfoForLBS(byte b16, GPS gps, ArrayList<Long> arrayList, ArrayList<Cell> arrayList2, byte[] bArr) {
        this.bPositionInfoType = b16;
        this.stGps = gps;
        this.vMacs = arrayList;
        this.vCells = arrayList2;
        this.vLBSKeyData = bArr;
    }
}
