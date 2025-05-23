package LBS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LBSInfo extends JceStruct {
    static Attr cache_stAttr;
    static GPS cache_stGps;
    static ArrayList<Cell> cache_vCells;
    static ArrayList<Wifi> cache_vWifis;
    public Attr stAttr;
    public GPS stGps;
    public ArrayList<Cell> vCells;
    public ArrayList<Wifi> vWifis;

    public LBSInfo() {
        this.stGps = null;
        this.vWifis = null;
        this.vCells = null;
        this.stAttr = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stGps == null) {
            cache_stGps = new GPS();
        }
        this.stGps = (GPS) jceInputStream.read((JceStruct) cache_stGps, 0, false);
        if (cache_vWifis == null) {
            cache_vWifis = new ArrayList<>();
            cache_vWifis.add(new Wifi());
        }
        this.vWifis = (ArrayList) jceInputStream.read((JceInputStream) cache_vWifis, 1, false);
        if (cache_vCells == null) {
            cache_vCells = new ArrayList<>();
            cache_vCells.add(new Cell());
        }
        this.vCells = (ArrayList) jceInputStream.read((JceInputStream) cache_vCells, 2, false);
        if (cache_stAttr == null) {
            cache_stAttr = new Attr();
        }
        this.stAttr = (Attr) jceInputStream.read((JceStruct) cache_stAttr, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("LBSInfo[\n");
        GPS gps = this.stGps;
        if (gps != null) {
            sb5.append(gps.toString());
        }
        Attr attr = this.stAttr;
        if (attr != null) {
            sb5.append(attr.toString());
        }
        ArrayList<Cell> arrayList = this.vCells;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Cell> it = this.vCells.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
            }
        }
        ArrayList<Wifi> arrayList2 = this.vWifis;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<Wifi> it5 = this.vWifis.iterator();
            while (it5.hasNext()) {
                sb5.append(it5.next().toString());
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        GPS gps = this.stGps;
        if (gps != null) {
            jceOutputStream.write((JceStruct) gps, 0);
        }
        ArrayList<Wifi> arrayList = this.vWifis;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<Cell> arrayList2 = this.vCells;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
        Attr attr = this.stAttr;
        if (attr != null) {
            jceOutputStream.write((JceStruct) attr, 3);
        }
    }

    public LBSInfo(GPS gps, ArrayList<Wifi> arrayList, ArrayList<Cell> arrayList2, Attr attr) {
        this.stGps = gps;
        this.vWifis = arrayList;
        this.vCells = arrayList2;
        this.stAttr = attr;
    }
}
