package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetEntrance extends JceStruct {
    static ArrayList<EntranceContent> cache_entrance_list = new ArrayList<>();
    static ArrayList<String> cache_xml_list;
    public ArrayList<EntranceContent> entrance_list;
    public long interval;
    public ArrayList<String> xml_list;

    static {
        cache_entrance_list.add(new EntranceContent());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_xml_list = arrayList;
        arrayList.add("");
    }

    public RespGetEntrance() {
        this.entrance_list = null;
        this.interval = 300L;
        this.xml_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.entrance_list = (ArrayList) jceInputStream.read((JceInputStream) cache_entrance_list, 0, false);
        this.interval = jceInputStream.read(this.interval, 1, false);
        this.xml_list = (ArrayList) jceInputStream.read((JceInputStream) cache_xml_list, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<EntranceContent> arrayList = this.entrance_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.interval, 1);
        ArrayList<String> arrayList2 = this.xml_list;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public RespGetEntrance(ArrayList<EntranceContent> arrayList, long j3, ArrayList<String> arrayList2) {
        this.entrance_list = arrayList;
        this.interval = j3;
        this.xml_list = arrayList2;
    }
}
