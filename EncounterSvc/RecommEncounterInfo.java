package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RecommEncounterInfo extends JceStruct {
    static ArrayList<RespEncounterInfo> cache_vEncounterInfos = new ArrayList<>();
    public String icon_url;
    public int postion;
    public int show_num;
    public String title;
    public ArrayList<RespEncounterInfo> vEncounterInfos;

    static {
        cache_vEncounterInfos.add(new RespEncounterInfo());
    }

    public RecommEncounterInfo() {
        this.icon_url = "";
        this.title = "";
        this.postion = 0;
        this.show_num = 0;
        this.vEncounterInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.icon_url = jceInputStream.readString(0, true);
        this.title = jceInputStream.readString(1, true);
        this.postion = jceInputStream.read(this.postion, 2, true);
        this.show_num = jceInputStream.read(this.show_num, 3, true);
        this.vEncounterInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vEncounterInfos, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.icon_url, 0);
        jceOutputStream.write(this.title, 1);
        jceOutputStream.write(this.postion, 2);
        jceOutputStream.write(this.show_num, 3);
        ArrayList<RespEncounterInfo> arrayList = this.vEncounterInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public RecommEncounterInfo(String str, String str2, int i3, int i16, ArrayList<RespEncounterInfo> arrayList) {
        this.icon_url = str;
        this.title = str2;
        this.postion = i3;
        this.show_num = i16;
        this.vEncounterInfos = arrayList;
    }
}
