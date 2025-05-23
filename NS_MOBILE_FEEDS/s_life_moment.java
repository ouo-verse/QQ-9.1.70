package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_life_moment extends JceStruct {
    static s_single_count cache_stCount;
    static single_feed cache_stMomentFeed;
    static ArrayList<s_life_moment_info> cache_vec_lifemoment = new ArrayList<>();
    static ArrayList<s_picurl> cache_vec_picurls;
    public String action_url;
    public String button_text;
    public String left_title;
    public String right_title;
    public int show_type;
    public s_single_count stCount;
    public single_feed stMomentFeed;
    public String summary;
    public ArrayList<s_life_moment_info> vec_lifemoment;
    public ArrayList<s_picurl> vec_picurls;

    static {
        cache_vec_lifemoment.add(new s_life_moment_info());
        cache_vec_picurls = new ArrayList<>();
        cache_vec_picurls.add(new s_picurl());
        cache_stMomentFeed = new single_feed();
        cache_stCount = new s_single_count();
    }

    public s_life_moment() {
        this.show_type = 0;
        this.vec_lifemoment = null;
        this.left_title = "";
        this.right_title = "";
        this.action_url = "";
        this.summary = "";
        this.button_text = "";
        this.vec_picurls = null;
        this.stMomentFeed = null;
        this.stCount = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.show_type = jceInputStream.read(this.show_type, 0, false);
        this.vec_lifemoment = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_lifemoment, 1, false);
        this.left_title = jceInputStream.readString(2, false);
        this.right_title = jceInputStream.readString(3, false);
        this.action_url = jceInputStream.readString(4, false);
        this.summary = jceInputStream.readString(5, false);
        this.button_text = jceInputStream.readString(6, false);
        this.vec_picurls = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_picurls, 7, false);
        this.stMomentFeed = (single_feed) jceInputStream.read((JceStruct) cache_stMomentFeed, 8, false);
        this.stCount = (s_single_count) jceInputStream.read((JceStruct) cache_stCount, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.show_type, 0);
        ArrayList<s_life_moment_info> arrayList = this.vec_lifemoment;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.left_title;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.right_title;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.action_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.summary;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.button_text;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        ArrayList<s_picurl> arrayList2 = this.vec_picurls;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
        single_feed single_feedVar = this.stMomentFeed;
        if (single_feedVar != null) {
            jceOutputStream.write((JceStruct) single_feedVar, 8);
        }
        s_single_count s_single_countVar = this.stCount;
        if (s_single_countVar != null) {
            jceOutputStream.write((JceStruct) s_single_countVar, 9);
        }
    }

    public s_life_moment(int i3, ArrayList<s_life_moment_info> arrayList, String str, String str2, String str3, String str4, String str5, ArrayList<s_picurl> arrayList2, single_feed single_feedVar, s_single_count s_single_countVar) {
        this.show_type = i3;
        this.vec_lifemoment = arrayList;
        this.left_title = str;
        this.right_title = str2;
        this.action_url = str3;
        this.summary = str4;
        this.button_text = str5;
        this.vec_picurls = arrayList2;
        this.stMomentFeed = single_feedVar;
        this.stCount = s_single_countVar;
    }
}
