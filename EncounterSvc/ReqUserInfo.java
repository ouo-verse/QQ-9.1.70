package EncounterSvc;

import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqUserInfo extends JceStruct {
    static int cache_eListType;
    static int cache_eLocalInfo;
    static ArrayList<Cell> cache_vCells;
    static byte[] cache_vLBSKeyData;
    static ArrayList<SOSO_Cell> cache_vSOSOCells;
    static ArrayList<SOSO_Wifi> cache_vSOSOMac;
    public int eListType;
    public int eLocalInfo;
    public GPS stGps;
    public String strAuthName;
    public String strAuthPassword;
    public ArrayList<Cell> vCells;
    public byte[] vLBSKeyData;
    public ArrayList<Long> vMacs;
    public ArrayList<SOSO_Cell> vSOSOCells;
    public ArrayList<SOSO_Wifi> vSOSOMac;
    static GPS cache_stGps = new GPS();
    static ArrayList<Long> cache_vMacs = new ArrayList<>();

    static {
        cache_vMacs.add(0L);
        cache_vCells = new ArrayList<>();
        cache_vCells.add(new Cell());
        cache_eListType = 0;
        cache_eLocalInfo = 0;
        cache_vLBSKeyData = r1;
        byte[] bArr = {0};
        cache_vSOSOMac = new ArrayList<>();
        cache_vSOSOMac.add(new SOSO_Wifi());
        cache_vSOSOCells = new ArrayList<>();
        cache_vSOSOCells.add(new SOSO_Cell());
    }

    public ReqUserInfo() {
        this.stGps = null;
        this.vMacs = null;
        this.vCells = null;
        this.strAuthName = "";
        this.strAuthPassword = "";
        this.eListType = 1;
        this.eLocalInfo = 0;
        this.vLBSKeyData = null;
        this.vSOSOMac = null;
        this.vSOSOCells = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stGps = (GPS) jceInputStream.read((JceStruct) cache_stGps, 0, false);
        this.vMacs = (ArrayList) jceInputStream.read((JceInputStream) cache_vMacs, 1, false);
        this.vCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vCells, 2, false);
        this.strAuthName = jceInputStream.readString(3, false);
        this.strAuthPassword = jceInputStream.readString(4, false);
        this.eListType = jceInputStream.read(this.eListType, 5, false);
        this.eLocalInfo = jceInputStream.read(this.eLocalInfo, 6, false);
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 7, false);
        this.vSOSOMac = (ArrayList) jceInputStream.read((JceInputStream) cache_vSOSOMac, 8, false);
        this.vSOSOCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vSOSOCells, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        GPS gps = this.stGps;
        if (gps != null) {
            jceOutputStream.write((JceStruct) gps, 0);
        }
        ArrayList<Long> arrayList = this.vMacs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<Cell> arrayList2 = this.vCells;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
        String str = this.strAuthName;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strAuthPassword;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.eListType, 5);
        jceOutputStream.write(this.eLocalInfo, 6);
        byte[] bArr = this.vLBSKeyData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 7);
        }
        ArrayList<SOSO_Wifi> arrayList3 = this.vSOSOMac;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 8);
        }
        ArrayList<SOSO_Cell> arrayList4 = this.vSOSOCells;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 9);
        }
    }

    public ReqUserInfo(GPS gps, ArrayList<Long> arrayList, ArrayList<Cell> arrayList2, String str, String str2, int i3, int i16, byte[] bArr, ArrayList<SOSO_Wifi> arrayList3, ArrayList<SOSO_Cell> arrayList4) {
        this.stGps = gps;
        this.vMacs = arrayList;
        this.vCells = arrayList2;
        this.strAuthName = str;
        this.strAuthPassword = str2;
        this.eListType = i3;
        this.eLocalInfo = i16;
        this.vLBSKeyData = bArr;
        this.vSOSOMac = arrayList3;
        this.vSOSOCells = arrayList4;
    }
}
