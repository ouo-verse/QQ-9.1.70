package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class interest_list extends JceStruct {
    static ArrayList<Long> cache_uinlist = new ArrayList<>();
    static ArrayList<s_user> cache_users;
    public int allcount;
    public ArrayList<Long> uinlist;
    public ArrayList<s_user> users;

    static {
        cache_uinlist.add(0L);
        cache_users = new ArrayList<>();
        cache_users.add(new s_user());
    }

    public interest_list() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uinlist = (ArrayList) jceInputStream.read((JceInputStream) cache_uinlist, 0, false);
        this.allcount = jceInputStream.read(this.allcount, 1, false);
        this.users = (ArrayList) jceInputStream.read((JceInputStream) cache_users, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Long> arrayList = this.uinlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.allcount, 1);
        ArrayList<s_user> arrayList2 = this.users;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public interest_list(ArrayList<Long> arrayList, int i3, ArrayList<s_user> arrayList2) {
        this.uinlist = arrayList;
        this.allcount = i3;
        this.users = arrayList2;
    }
}
