package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_join_list extends JceStruct {
    static ArrayList<s_user> cache_users = new ArrayList<>();
    public int actionType;
    public String actionUrl;
    public String desc;
    public int isjoined;
    public int num;
    public ArrayList<s_user> users;

    static {
        cache_users.add(new s_user());
    }

    public s_join_list() {
        this.num = 0;
        this.isjoined = 0;
        this.users = null;
        this.desc = "";
        this.actionUrl = "";
        this.actionType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.isjoined = jceInputStream.read(this.isjoined, 1, false);
        this.users = (ArrayList) jceInputStream.read((JceInputStream) cache_users, 2, false);
        this.desc = jceInputStream.readString(3, false);
        this.actionUrl = jceInputStream.readString(4, false);
        this.actionType = jceInputStream.read(this.actionType, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        jceOutputStream.write(this.isjoined, 1);
        ArrayList<s_user> arrayList = this.users;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.actionUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.actionType, 5);
    }

    public s_join_list(int i3, int i16, ArrayList<s_user> arrayList, String str, String str2, int i17) {
        this.num = i3;
        this.isjoined = i16;
        this.users = arrayList;
        this.desc = str;
        this.actionUrl = str2;
        this.actionType = i17;
    }
}
