package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_interest extends JceStruct {
    static ArrayList<s_user> cache_users = new ArrayList<>();
    public String desc;
    public int is_interested;
    public int num;
    public ArrayList<s_user> users;

    static {
        cache_users.add(new s_user());
    }

    public cell_interest() {
        this.desc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.users = (ArrayList) jceInputStream.read((JceInputStream) cache_users, 1, false);
        this.desc = jceInputStream.readString(2, false);
        this.is_interested = jceInputStream.read(this.is_interested, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        ArrayList<s_user> arrayList = this.users;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.is_interested, 3);
    }

    public cell_interest(int i3, ArrayList<s_user> arrayList, String str, int i16) {
        this.num = i3;
        this.users = arrayList;
        this.desc = str;
        this.is_interested = i16;
    }
}
