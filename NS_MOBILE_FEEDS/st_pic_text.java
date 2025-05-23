package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_pic_text extends JceStruct {
    static s_picdata cache_picinfo = new s_picdata();
    static ArrayList<s_user> cache_userlist = new ArrayList<>();
    public int actiontype;
    public String actionurl;
    public String desc_after_click;
    public String desc_before_click;
    public s_picdata picinfo;
    public String playurl;
    public String postfix;
    public String strHeader;
    public String summary;
    public String title;
    public ArrayList<s_user> userlist;

    static {
        cache_userlist.add(new s_user());
    }

    public st_pic_text() {
        this.picinfo = null;
        this.userlist = null;
        this.summary = "";
        this.title = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.postfix = "";
        this.playurl = "";
        this.strHeader = "";
        this.desc_before_click = "";
        this.desc_after_click = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picinfo = (s_picdata) jceInputStream.read((JceStruct) cache_picinfo, 0, false);
        this.userlist = (ArrayList) jceInputStream.read((JceInputStream) cache_userlist, 1, false);
        this.summary = jceInputStream.readString(2, false);
        this.title = jceInputStream.readString(3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.actionurl = jceInputStream.readString(5, false);
        this.postfix = jceInputStream.readString(6, false);
        this.playurl = jceInputStream.readString(7, false);
        this.strHeader = jceInputStream.readString(8, false);
        this.desc_before_click = jceInputStream.readString(9, false);
        this.desc_after_click = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_picdata s_picdataVar = this.picinfo;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 0);
        }
        ArrayList<s_user> arrayList = this.userlist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.summary;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.actiontype, 4);
        String str3 = this.actionurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.postfix;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.playurl;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.strHeader;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        String str7 = this.desc_before_click;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
        String str8 = this.desc_after_click;
        if (str8 != null) {
            jceOutputStream.write(str8, 10);
        }
    }

    public st_pic_text(s_picdata s_picdataVar, ArrayList<s_user> arrayList, String str, String str2, int i3, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.picinfo = s_picdataVar;
        this.userlist = arrayList;
        this.summary = str;
        this.title = str2;
        this.actiontype = i3;
        this.actionurl = str3;
        this.postfix = str4;
        this.playurl = str5;
        this.strHeader = str6;
        this.desc_before_click = str7;
        this.desc_after_click = str8;
    }
}
