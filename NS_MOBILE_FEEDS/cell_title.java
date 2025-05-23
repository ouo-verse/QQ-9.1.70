package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_title extends JceStruct {
    static ArrayList<s_user> cache_talk_user_list;
    static s_user cache_user;
    static ArrayList<s_user> cache_userlist = new ArrayList<>();
    public int actiontype;
    public int relation;
    public String relation_type;
    public int status;
    public ArrayList<s_user> talk_user_list;
    public String title;
    public String titleurl;
    public s_user user;
    public int useractiontype;
    public ArrayList<s_user> userlist;
    public int usernum;

    static {
        cache_userlist.add(new s_user());
        cache_user = new s_user();
        cache_talk_user_list = new ArrayList<>();
        cache_talk_user_list.add(new s_user());
    }

    public cell_title() {
        this.title = "";
        this.titleurl = "";
        this.useractiontype = 5;
        this.relation_type = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.titleurl = jceInputStream.readString(1, false);
        this.userlist = (ArrayList) jceInputStream.read((JceInputStream) cache_userlist, 2, false);
        this.usernum = jceInputStream.read(this.usernum, 3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 5, false);
        this.useractiontype = jceInputStream.read(this.useractiontype, 6, false);
        this.relation_type = jceInputStream.readString(7, false);
        this.status = jceInputStream.read(this.status, 8, false);
        this.talk_user_list = (ArrayList) jceInputStream.read((JceInputStream) cache_talk_user_list, 9, false);
        this.relation = jceInputStream.read(this.relation, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.titleurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        ArrayList<s_user> arrayList = this.userlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.usernum, 3);
        jceOutputStream.write(this.actiontype, 4);
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 5);
        }
        jceOutputStream.write(this.useractiontype, 6);
        String str3 = this.relation_type;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.status, 8);
        ArrayList<s_user> arrayList2 = this.talk_user_list;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 9);
        }
        jceOutputStream.write(this.relation, 10);
    }

    public cell_title(String str, String str2, ArrayList<s_user> arrayList, int i3, int i16, s_user s_userVar, int i17, String str3, int i18, ArrayList<s_user> arrayList2, int i19, String str4) {
        this.title = str;
        this.titleurl = str2;
        this.userlist = arrayList;
        this.usernum = i3;
        this.actiontype = i16;
        this.user = s_userVar;
        this.useractiontype = i17;
        this.relation_type = str3;
        this.status = i18;
        this.talk_user_list = arrayList2;
        this.relation = i19;
    }
}
