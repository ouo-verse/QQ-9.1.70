package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_pic extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static ArrayList<s_user> cache_facemans;
    static s_user cache_friendinfo;
    static ArrayList<s_picdata> cache_picdata = new ArrayList<>();
    static ArrayList<wx_user_info> cache_sharer_wx_info;
    static int cache_sort_type;
    public int actiontype;
    public String actionurl;
    public int activealbum;
    public int albshowmask;
    public String albumanswer;
    public String albumid;
    public String albumname;
    public int albumnum;
    public String albumquestion;
    public int albumrights;
    public int albumtype;
    public int allow_access;
    public int allow_share;
    public int animation_type;
    public int anonymity;
    public boolean balbum;
    public Map<Integer, String> busi_param;
    public String desc;
    public int extend_actiontype;
    public String extend_actionurl;
    public int faceman_num;
    public ArrayList<s_user> facemans;
    public s_user friendinfo;
    public String icon_url;
    public int individualalbum;
    public boolean isSubscribe;
    public boolean is_contain_video_and_pic;
    public boolean is_share;
    public boolean is_share_owner;
    public boolean is_topped_album;
    public boolean is_video_pic_mix;
    public int lastupdatetime;
    public int like_cnt;
    public int newestupload;
    public String news;
    public ArrayList<s_picdata> picdata;
    public String qunid;
    public String share_new_reason;
    public int sharer_count;
    public ArrayList<wx_user_info> sharer_wx_info;
    public int sort_type;
    public String store_appid;
    public long uin;
    public int unread_count;
    public int uploadnum;
    public int view_cnt;

    static {
        cache_picdata.add(new s_picdata());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_friendinfo = new s_user();
        cache_facemans = new ArrayList<>();
        cache_facemans.add(new s_user());
        cache_sort_type = 0;
        cache_sharer_wx_info = new ArrayList<>();
        cache_sharer_wx_info.add(new wx_user_info());
    }

    public cell_pic() {
        this.picdata = null;
        this.albumname = "";
        this.albumid = "";
        this.albumnum = 0;
        this.uploadnum = 0;
        this.albumrights = 0;
        this.albumquestion = "";
        this.albumanswer = "";
        this.desc = "";
        this.uin = 0L;
        this.balbum = true;
        this.lastupdatetime = 0;
        this.busi_param = null;
        this.qunid = "";
        this.allow_access = 0;
        this.anonymity = 0;
        this.albumtype = 0;
        this.actiontype = 18;
        this.actionurl = "";
        this.isSubscribe = true;
        this.friendinfo = null;
        this.news = "";
        this.unread_count = 0;
        this.facemans = null;
        this.faceman_num = 0;
        this.store_appid = "";
        this.extend_actiontype = 0;
        this.extend_actionurl = "";
        this.albshowmask = 0;
        this.allow_share = 0;
        this.individualalbum = 0;
        this.activealbum = 0;
        this.newestupload = 0;
        this.is_share = false;
        this.is_video_pic_mix = false;
        this.is_contain_video_and_pic = false;
        this.is_share_owner = true;
        this.animation_type = 0;
        this.sort_type = 0;
        this.is_topped_album = false;
        this.view_cnt = 0;
        this.like_cnt = 0;
        this.icon_url = "";
        this.sharer_count = 0;
        this.sharer_wx_info = null;
        this.share_new_reason = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picdata = (ArrayList) jceInputStream.read((JceInputStream) cache_picdata, 0, false);
        this.albumname = jceInputStream.readString(1, false);
        this.albumid = jceInputStream.readString(2, false);
        this.albumnum = jceInputStream.read(this.albumnum, 3, false);
        this.uploadnum = jceInputStream.read(this.uploadnum, 4, false);
        this.albumrights = jceInputStream.read(this.albumrights, 5, false);
        this.albumquestion = jceInputStream.readString(6, false);
        this.albumanswer = jceInputStream.readString(7, false);
        this.desc = jceInputStream.readString(8, false);
        this.uin = jceInputStream.read(this.uin, 9, false);
        this.balbum = jceInputStream.read(this.balbum, 10, false);
        this.lastupdatetime = jceInputStream.read(this.lastupdatetime, 11, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 12, false);
        this.qunid = jceInputStream.readString(13, false);
        this.allow_access = jceInputStream.read(this.allow_access, 14, false);
        this.anonymity = jceInputStream.read(this.anonymity, 15, false);
        this.albumtype = jceInputStream.read(this.albumtype, 16, false);
        this.actiontype = jceInputStream.read(this.actiontype, 17, false);
        this.actionurl = jceInputStream.readString(18, false);
        this.isSubscribe = jceInputStream.read(this.isSubscribe, 19, false);
        this.friendinfo = (s_user) jceInputStream.read((JceStruct) cache_friendinfo, 20, false);
        this.news = jceInputStream.readString(21, false);
        this.unread_count = jceInputStream.read(this.unread_count, 22, false);
        this.facemans = (ArrayList) jceInputStream.read((JceInputStream) cache_facemans, 23, false);
        this.faceman_num = jceInputStream.read(this.faceman_num, 24, false);
        this.store_appid = jceInputStream.readString(25, false);
        this.extend_actiontype = jceInputStream.read(this.extend_actiontype, 26, false);
        this.extend_actionurl = jceInputStream.readString(27, false);
        this.albshowmask = jceInputStream.read(this.albshowmask, 28, false);
        this.allow_share = jceInputStream.read(this.allow_share, 29, false);
        this.individualalbum = jceInputStream.read(this.individualalbum, 30, false);
        this.activealbum = jceInputStream.read(this.activealbum, 31, false);
        this.newestupload = jceInputStream.read(this.newestupload, 32, false);
        this.is_share = jceInputStream.read(this.is_share, 33, false);
        this.is_video_pic_mix = jceInputStream.read(this.is_video_pic_mix, 34, false);
        this.is_contain_video_and_pic = jceInputStream.read(this.is_contain_video_and_pic, 35, false);
        this.is_share_owner = jceInputStream.read(this.is_share_owner, 36, false);
        this.animation_type = jceInputStream.read(this.animation_type, 37, false);
        this.sort_type = jceInputStream.read(this.sort_type, 38, false);
        this.is_topped_album = jceInputStream.read(this.is_topped_album, 39, false);
        this.view_cnt = jceInputStream.read(this.view_cnt, 40, false);
        this.like_cnt = jceInputStream.read(this.like_cnt, 41, false);
        this.icon_url = jceInputStream.readString(42, false);
        this.sharer_count = jceInputStream.read(this.sharer_count, 43, false);
        this.sharer_wx_info = (ArrayList) jceInputStream.read((JceInputStream) cache_sharer_wx_info, 44, false);
        this.share_new_reason = jceInputStream.readString(45, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<s_picdata> arrayList = this.picdata;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.albumname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.albumid;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.albumnum, 3);
        jceOutputStream.write(this.uploadnum, 4);
        jceOutputStream.write(this.albumrights, 5);
        String str3 = this.albumquestion;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.albumanswer;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.desc;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.uin, 9);
        jceOutputStream.write(this.balbum, 10);
        jceOutputStream.write(this.lastupdatetime, 11);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
        String str6 = this.qunid;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        jceOutputStream.write(this.allow_access, 14);
        jceOutputStream.write(this.anonymity, 15);
        jceOutputStream.write(this.albumtype, 16);
        jceOutputStream.write(this.actiontype, 17);
        String str7 = this.actionurl;
        if (str7 != null) {
            jceOutputStream.write(str7, 18);
        }
        jceOutputStream.write(this.isSubscribe, 19);
        s_user s_userVar = this.friendinfo;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 20);
        }
        String str8 = this.news;
        if (str8 != null) {
            jceOutputStream.write(str8, 21);
        }
        jceOutputStream.write(this.unread_count, 22);
        ArrayList<s_user> arrayList2 = this.facemans;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 23);
        }
        jceOutputStream.write(this.faceman_num, 24);
        String str9 = this.store_appid;
        if (str9 != null) {
            jceOutputStream.write(str9, 25);
        }
        jceOutputStream.write(this.extend_actiontype, 26);
        String str10 = this.extend_actionurl;
        if (str10 != null) {
            jceOutputStream.write(str10, 27);
        }
        jceOutputStream.write(this.albshowmask, 28);
        jceOutputStream.write(this.allow_share, 29);
        jceOutputStream.write(this.individualalbum, 30);
        jceOutputStream.write(this.activealbum, 31);
        jceOutputStream.write(this.newestupload, 32);
        jceOutputStream.write(this.is_share, 33);
        jceOutputStream.write(this.is_video_pic_mix, 34);
        jceOutputStream.write(this.is_contain_video_and_pic, 35);
        jceOutputStream.write(this.is_share_owner, 36);
        jceOutputStream.write(this.animation_type, 37);
        jceOutputStream.write(this.sort_type, 38);
        jceOutputStream.write(this.is_topped_album, 39);
        jceOutputStream.write(this.view_cnt, 40);
        jceOutputStream.write(this.like_cnt, 41);
        String str11 = this.icon_url;
        if (str11 != null) {
            jceOutputStream.write(str11, 42);
        }
        jceOutputStream.write(this.sharer_count, 43);
        ArrayList<wx_user_info> arrayList3 = this.sharer_wx_info;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 44);
        }
        String str12 = this.share_new_reason;
        if (str12 != null) {
            jceOutputStream.write(str12, 45);
        }
    }

    public cell_pic(ArrayList<s_picdata> arrayList, String str, String str2, int i3, int i16, int i17, String str3, String str4, String str5, long j3, boolean z16, int i18, Map<Integer, String> map, String str6, int i19, int i26, int i27, int i28, String str7, boolean z17, s_user s_userVar, String str8, int i29, ArrayList<s_user> arrayList2, int i36, String str9, int i37, String str10, int i38, int i39, int i46, int i47, int i48, boolean z18, boolean z19, boolean z26, boolean z27, int i49, int i56, boolean z28, int i57, int i58, String str11, int i59, ArrayList<wx_user_info> arrayList3, String str12) {
        this.picdata = arrayList;
        this.albumname = str;
        this.albumid = str2;
        this.albumnum = i3;
        this.uploadnum = i16;
        this.albumrights = i17;
        this.albumquestion = str3;
        this.albumanswer = str4;
        this.desc = str5;
        this.uin = j3;
        this.balbum = z16;
        this.lastupdatetime = i18;
        this.busi_param = map;
        this.qunid = str6;
        this.allow_access = i19;
        this.anonymity = i26;
        this.albumtype = i27;
        this.actiontype = i28;
        this.actionurl = str7;
        this.isSubscribe = z17;
        this.friendinfo = s_userVar;
        this.news = str8;
        this.unread_count = i29;
        this.facemans = arrayList2;
        this.faceman_num = i36;
        this.store_appid = str9;
        this.extend_actiontype = i37;
        this.extend_actionurl = str10;
        this.albshowmask = i38;
        this.allow_share = i39;
        this.individualalbum = i46;
        this.activealbum = i47;
        this.newestupload = i48;
        this.is_share = z18;
        this.is_video_pic_mix = z19;
        this.is_contain_video_and_pic = z26;
        this.is_share_owner = z27;
        this.animation_type = i49;
        this.sort_type = i56;
        this.is_topped_album = z28;
        this.view_cnt = i57;
        this.like_cnt = i58;
        this.icon_url = str11;
        this.sharer_count = i59;
        this.sharer_wx_info = arrayList3;
        this.share_new_reason = str12;
    }
}
