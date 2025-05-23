package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_visitor extends JceStruct {
    static ArrayList<s_user> cache_visitors = new ArrayList<>();
    public byte mod;
    public String myfriend_info;
    public int view_count;
    public int view_count_byfriends;
    public int visitor_count;
    public ArrayList<s_user> visitors;

    static {
        cache_visitors.add(new s_user());
    }

    public cell_visitor() {
        this.myfriend_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.view_count = jceInputStream.read(this.view_count, 0, false);
        this.visitor_count = jceInputStream.read(this.visitor_count, 1, false);
        this.visitors = (ArrayList) jceInputStream.read((JceInputStream) cache_visitors, 2, false);
        this.mod = jceInputStream.read(this.mod, 3, false);
        this.view_count_byfriends = jceInputStream.read(this.view_count_byfriends, 4, false);
        this.myfriend_info = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.view_count, 0);
        jceOutputStream.write(this.visitor_count, 1);
        ArrayList<s_user> arrayList = this.visitors;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.mod, 3);
        jceOutputStream.write(this.view_count_byfriends, 4);
        String str = this.myfriend_info;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
    }

    public cell_visitor(int i3, int i16, ArrayList<s_user> arrayList, byte b16, int i17, String str) {
        this.view_count = i3;
        this.visitor_count = i16;
        this.visitors = arrayList;
        this.mod = b16;
        this.view_count_byfriends = i17;
        this.myfriend_info = str;
    }
}
