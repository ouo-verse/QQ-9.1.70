package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_special_care extends JceStruct {
    public int comment_count;
    public String desc_after_click;
    public String desc_before_click;
    public s_picurl icon_after_click;
    public s_picurl icon_before_click;
    public int intimacy;
    public int like_count;
    public int rankpercent;
    public String relation_content;
    public s_user userinfo;
    public int visit_count;
    static s_user cache_userinfo = new s_user();
    static s_picurl cache_icon_before_click = new s_picurl();
    static s_picurl cache_icon_after_click = new s_picurl();

    public cell_special_care() {
        this.userinfo = null;
        this.intimacy = 0;
        this.rankpercent = 0;
        this.icon_before_click = null;
        this.icon_after_click = null;
        this.desc_before_click = "";
        this.desc_after_click = "";
        this.visit_count = 0;
        this.like_count = 0;
        this.comment_count = 0;
        this.relation_content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.userinfo = (s_user) jceInputStream.read((JceStruct) cache_userinfo, 0, false);
        this.intimacy = jceInputStream.read(this.intimacy, 1, false);
        this.rankpercent = jceInputStream.read(this.rankpercent, 2, false);
        this.icon_before_click = (s_picurl) jceInputStream.read((JceStruct) cache_icon_before_click, 3, false);
        this.icon_after_click = (s_picurl) jceInputStream.read((JceStruct) cache_icon_after_click, 4, false);
        this.desc_before_click = jceInputStream.readString(5, false);
        this.desc_after_click = jceInputStream.readString(6, false);
        this.visit_count = jceInputStream.read(this.visit_count, 7, false);
        this.like_count = jceInputStream.read(this.like_count, 8, false);
        this.comment_count = jceInputStream.read(this.comment_count, 9, false);
        this.relation_content = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.userinfo;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        jceOutputStream.write(this.intimacy, 1);
        jceOutputStream.write(this.rankpercent, 2);
        s_picurl s_picurlVar = this.icon_before_click;
        if (s_picurlVar != null) {
            jceOutputStream.write((JceStruct) s_picurlVar, 3);
        }
        s_picurl s_picurlVar2 = this.icon_after_click;
        if (s_picurlVar2 != null) {
            jceOutputStream.write((JceStruct) s_picurlVar2, 4);
        }
        String str = this.desc_before_click;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.desc_after_click;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.visit_count, 7);
        jceOutputStream.write(this.like_count, 8);
        jceOutputStream.write(this.comment_count, 9);
        String str3 = this.relation_content;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
    }

    public cell_special_care(s_user s_userVar, int i3, int i16, s_picurl s_picurlVar, s_picurl s_picurlVar2, String str, String str2, int i17, int i18, int i19, String str3) {
        this.userinfo = s_userVar;
        this.intimacy = i3;
        this.rankpercent = i16;
        this.icon_before_click = s_picurlVar;
        this.icon_after_click = s_picurlVar2;
        this.desc_before_click = str;
        this.desc_after_click = str2;
        this.visit_count = i17;
        this.like_count = i18;
        this.comment_count = i19;
        this.relation_content = str3;
    }
}
