package NeighborSvc;

import NeighborComm.LocalInfoType;
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
    static GPS cache_stGps;
    static ArrayList<Cell> cache_vCells;
    static byte[] cache_vLBSKeyData;
    static ArrayList<Long> cache_vMacs;
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

    public ReqUserInfo() {
        this.stGps = null;
        this.vMacs = null;
        this.vCells = null;
        this.strAuthName = "";
        this.strAuthPassword = "";
        this.eListType = ListType.ListType_Normal.value();
        this.eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
        this.vLBSKeyData = null;
        this.vSOSOMac = null;
        this.vSOSOCells = null;
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
        this.strAuthName = jceInputStream.readString(3, true);
        this.strAuthPassword = jceInputStream.readString(4, true);
        this.eListType = jceInputStream.read(this.eListType, 5, false);
        this.eLocalInfo = jceInputStream.read(this.eLocalInfo, 6, false);
        if (cache_vLBSKeyData == null) {
            cache_vLBSKeyData = r0;
            byte[] bArr = {0};
        }
        this.vLBSKeyData = jceInputStream.read(cache_vLBSKeyData, 7, false);
        if (cache_vSOSOMac == null) {
            cache_vSOSOMac = new ArrayList<>();
            cache_vSOSOMac.add(new SOSO_Wifi());
        }
        this.vSOSOMac = (ArrayList) jceInputStream.read((JceInputStream) cache_vSOSOMac, 8, false);
        if (cache_vSOSOCells == null) {
            cache_vSOSOCells = new ArrayList<>();
            cache_vSOSOCells.add(new SOSO_Cell());
        }
        this.vSOSOCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vSOSOCells, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stGps, 0);
        jceOutputStream.write((Collection) this.vMacs, 1);
        jceOutputStream.write((Collection) this.vCells, 2);
        jceOutputStream.write(this.strAuthName, 3);
        jceOutputStream.write(this.strAuthPassword, 4);
        jceOutputStream.write(this.eListType, 5);
        jceOutputStream.write(this.eLocalInfo, 6);
        byte[] bArr = this.vLBSKeyData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 7);
        }
        ArrayList<SOSO_Wifi> arrayList = this.vSOSOMac;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
        ArrayList<SOSO_Cell> arrayList2 = this.vSOSOCells;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 9);
        }
    }

    public ReqUserInfo(GPS gps, ArrayList<Long> arrayList, ArrayList<Cell> arrayList2, String str, String str2, int i3, int i16, byte[] bArr, ArrayList<SOSO_Wifi> arrayList3, ArrayList<SOSO_Cell> arrayList4) {
        this.stGps = null;
        this.vMacs = null;
        this.vCells = null;
        this.strAuthName = "";
        this.strAuthPassword = "";
        this.eListType = ListType.ListType_Normal.value();
        LocalInfoType.LocalInfoType_Decode.value();
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
