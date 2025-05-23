package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_follow_guide extends JceStruct {
    static ArrayList<s_user> cache_followed_list = new ArrayList<>();
    public int action_type;
    public String action_url;
    public String attach_info;
    public String button_text;
    public long count;
    public int feed_type;
    public ArrayList<s_user> followed_list;
    public String icon_url;
    public String summary;
    public String title;

    static {
        cache_followed_list.add(new s_user());
    }

    public cell_follow_guide() {
        this.followed_list = null;
        this.count = 0L;
        this.title = "";
        this.summary = "";
        this.icon_url = "";
        this.action_type = 0;
        this.action_url = "";
        this.feed_type = 0;
        this.button_text = "";
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.followed_list = (ArrayList) jceInputStream.read((JceInputStream) cache_followed_list, 0, false);
        this.count = jceInputStream.read(this.count, 1, false);
        this.title = jceInputStream.readString(2, false);
        this.summary = jceInputStream.readString(3, false);
        this.icon_url = jceInputStream.readString(4, false);
        this.action_type = jceInputStream.read(this.action_type, 5, false);
        this.action_url = jceInputStream.readString(6, false);
        this.feed_type = jceInputStream.read(this.feed_type, 7, false);
        this.button_text = jceInputStream.readString(8, false);
        this.attach_info = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_user> arrayList = this.followed_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.count, 1);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.icon_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.action_type, 5);
        String str4 = this.action_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.feed_type, 7);
        String str5 = this.button_text;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        String str6 = this.attach_info;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
    }

    public cell_follow_guide(ArrayList<s_user> arrayList, long j3, String str, String str2, String str3, int i3, String str4, int i16, String str5, String str6) {
        this.followed_list = arrayList;
        this.count = j3;
        this.title = str;
        this.summary = str2;
        this.icon_url = str3;
        this.action_type = i3;
        this.action_url = str4;
        this.feed_type = i16;
        this.button_text = str5;
        this.attach_info = str6;
    }
}
