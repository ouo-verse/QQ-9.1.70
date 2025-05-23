package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_lbs_event extends JceStruct {
    static s_gps cache_gpsinfo;
    static ArrayList<s_user> cache_usersinfo = new ArrayList<>();
    public int actiontype;
    public String actionurl;
    public String desc;
    public long event_id;
    public s_gps gpsinfo;
    public ArrayList<s_user> usersinfo;

    static {
        cache_usersinfo.add(new s_user());
        cache_gpsinfo = new s_gps();
    }

    public cell_lbs_event() {
        this.actiontype = 0;
        this.actionurl = "";
        this.usersinfo = null;
        this.gpsinfo = null;
        this.event_id = 0L;
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.actiontype = jceInputStream.read(this.actiontype, 0, false);
        this.actionurl = jceInputStream.readString(1, false);
        this.usersinfo = (ArrayList) jceInputStream.read((JceInputStream) cache_usersinfo, 2, false);
        this.gpsinfo = (s_gps) jceInputStream.read((JceStruct) cache_gpsinfo, 3, false);
        this.event_id = jceInputStream.read(this.event_id, 4, false);
        this.desc = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.actiontype, 0);
        String str = this.actionurl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<s_user> arrayList = this.usersinfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        s_gps s_gpsVar = this.gpsinfo;
        if (s_gpsVar != null) {
            jceOutputStream.write((JceStruct) s_gpsVar, 3);
        }
        jceOutputStream.write(this.event_id, 4);
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public cell_lbs_event(int i3, String str, ArrayList<s_user> arrayList, s_gps s_gpsVar, long j3, String str2) {
        this.actiontype = i3;
        this.actionurl = str;
        this.usersinfo = arrayList;
        this.gpsinfo = s_gpsVar;
        this.event_id = j3;
        this.desc = str2;
    }
}
