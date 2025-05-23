package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_visit extends JceStruct {
    static ArrayList<s_user> cache_datalist;
    public ArrayList<s_user> datalist;
    public long lasttime;
    public int nvnum;
    public int todaynum;
    public int totalnum;
    public int visitornum;

    public s_visit() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nvnum = jceInputStream.read(this.nvnum, 0, false);
        this.todaynum = jceInputStream.read(this.todaynum, 1, false);
        this.totalnum = jceInputStream.read(this.totalnum, 2, false);
        if (cache_datalist == null) {
            cache_datalist = new ArrayList<>();
            cache_datalist.add(new s_user());
        }
        this.datalist = (ArrayList) jceInputStream.read((JceInputStream) cache_datalist, 3, false);
        this.lasttime = jceInputStream.read(this.lasttime, 4, false);
        this.visitornum = jceInputStream.read(this.visitornum, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nvnum, 0);
        jceOutputStream.write(this.todaynum, 1);
        jceOutputStream.write(this.totalnum, 2);
        ArrayList<s_user> arrayList = this.datalist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.lasttime, 4);
        jceOutputStream.write(this.visitornum, 5);
    }

    public s_visit(int i3, int i16, int i17, ArrayList<s_user> arrayList, long j3, int i18) {
        this.nvnum = i3;
        this.todaynum = i16;
        this.totalnum = i17;
        this.datalist = arrayList;
        this.lasttime = j3;
        this.visitornum = i18;
    }
}
