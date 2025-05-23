package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_FEEDS.FunnySpace;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_MUSIC.MusicInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_main_page_rsp extends JceStruct {
    static FunnySpace cache_StuFunnySpace;
    static ArrayList<QueryADBannerUnit> cache_adv_banner;
    static ArrayList<s_app_acc> cache_all_acc;
    static ArrayList<MusicInfo> cache_all_music_list;
    static byte[] cache_bgvoice_buf;
    static s_brandspace_h5 cache_brandspace_h5;
    static s_campus_qz cache_campus_qz;
    static s_flower cache_flower;
    static s_friend_ship cache_friend_ship;
    static s_game cache_game;
    static s_limit_page_card cache_limit_page_card;
    static Map<Integer, s_mainPageTabItem> cache_map_entrys;
    static s_msgb_festival cache_msgb_festival;
    static s_mainPageTabItem cache_myFriendEntryItem;
    static ArrayList<s_navigation_item> cache_navigation_order;
    static ArrayList<byte[]> cache_photos_buf;
    static s_gamebar_pk_banner cache_pk_banner;
    static s_read_space cache_readspace;
    static ArrayList<single_feed> cache_recent_photos;
    static Map<Integer, s_red_comm> cache_redinfo;
    static s_qzone_reward_data cache_reward_data;
    static s_sq_mainpage_switch cache_sq_mainpage_switch;
    static byte[] cache_stShangchengInfo;
    static s_tab_list cache_tab_lst;
    static s_tab_list cache_tab_lst_mq;
    static s_tab_list cache_tab_top_lst;
    static s_urge_publish_info cache_urge_publish;
    static ArrayList<s_space_event> cache_vec_event;
    public FunnySpace StuFunnySpace;
    public ArrayList<QueryADBannerUnit> adv_banner;
    public ArrayList<s_app_acc> all_acc;
    public ArrayList<MusicInfo> all_music_list;
    public int all_music_nums;
    public s_appinfo appinfo;
    public String attach_info;
    public byte[] bgvoice_buf;
    public s_birthday birthday;
    public s_brandspace_h5 brandspace_h5;
    public s_campus_qz campus_qz;
    public s_count count;
    public s_flower flower;
    public s_friend_ship friend_ship;
    public s_friendreq friendreq;
    public s_game game;
    public s_gift gift;
    public byte green_diamond_flag;
    public s_limit_page_card limit_page_card;
    public byte loop_playback_flag;
    public s_main_page mainpage;
    public Map<Integer, s_mainPageTabItem> map_entrys;
    public s_mayknow mayknow;
    public s_msgb_festival msgb_festival;
    public boolean music_can_play;
    public s_mainPageTabItem myFriendEntryItem;
    public ArrayList<s_navigation_item> navigation_order;
    public int no_update;
    public boolean open_msg_board;
    public s_part_error part_error;
    public s_rec_photo_list photos;
    public ArrayList<byte[]> photos_buf;
    public s_gamebar_pk_banner pk_banner;
    public byte play_mode_flag;
    public s_profile profile;
    public String qzmall_cover_url;
    public s_read_space readspace;
    public ArrayList<single_feed> recent_photos;
    public Map<Integer, s_red_comm> redinfo;
    public s_qzone_reward_data reward_data;
    public String share_bg_url;
    public s_special special;
    public s_sq_mainpage_switch sq_mainpage_switch;
    public byte[] stShangchengInfo;
    public s_tab_list tab_lst;
    public s_tab_list tab_lst_mq;
    public s_tab_list tab_top_lst;
    public long uWanBaNew;
    public s_urge_publish_info urge_publish;
    public ArrayList<s_space_event> vec_event;
    public s_visit visit;
    public s_visit visit_no_right;
    public byte wifi_auto_play;
    static s_main_page cache_mainpage = new s_main_page();
    static s_profile cache_profile = new s_profile();
    static s_count cache_count = new s_count();
    static s_visit cache_visit = new s_visit();
    static s_birthday cache_birthday = new s_birthday();
    static s_gift cache_gift = new s_gift();
    static s_friendreq cache_friendreq = new s_friendreq();
    static s_special cache_special = new s_special();
    static s_mayknow cache_mayknow = new s_mayknow();
    static s_part_error cache_part_error = new s_part_error();
    static s_appinfo cache_appinfo = new s_appinfo();
    static s_rec_photo_list cache_photos = new s_rec_photo_list();
    static s_visit cache_visit_no_right = new s_visit();

    static {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_photos_buf = arrayList;
        arrayList.add(new byte[]{0});
        cache_recent_photos = new ArrayList<>();
        cache_recent_photos.add(new single_feed());
        cache_readspace = new s_read_space();
        cache_flower = new s_flower();
        cache_game = new s_game();
        cache_redinfo = new HashMap();
        cache_redinfo.put(0, new s_red_comm());
        cache_friend_ship = new s_friend_ship();
        cache_all_music_list = new ArrayList<>();
        cache_all_music_list.add(new MusicInfo());
        cache_all_acc = new ArrayList<>();
        cache_all_acc.add(new s_app_acc());
        cache_adv_banner = new ArrayList<>();
        cache_adv_banner.add(new QueryADBannerUnit());
        cache_msgb_festival = new s_msgb_festival();
        cache_brandspace_h5 = new s_brandspace_h5();
        cache_campus_qz = new s_campus_qz();
        cache_bgvoice_buf = r0;
        byte[] bArr = {0};
        cache_tab_lst = new s_tab_list();
        cache_sq_mainpage_switch = new s_sq_mainpage_switch();
        cache_pk_banner = new s_gamebar_pk_banner();
        cache_limit_page_card = new s_limit_page_card();
        cache_reward_data = new s_qzone_reward_data();
        cache_myFriendEntryItem = new s_mainPageTabItem();
        cache_StuFunnySpace = new FunnySpace();
        cache_map_entrys = new HashMap();
        cache_map_entrys.put(0, new s_mainPageTabItem());
        cache_stShangchengInfo = r0;
        byte[] bArr2 = {0};
        cache_tab_lst_mq = new s_tab_list();
        cache_navigation_order = new ArrayList<>();
        cache_navigation_order.add(new s_navigation_item());
        cache_tab_top_lst = new s_tab_list();
        cache_urge_publish = new s_urge_publish_info();
        cache_vec_event = new ArrayList<>();
        cache_vec_event.add(new s_space_event());
    }

    public mobile_main_page_rsp() {
        this.mainpage = null;
        this.profile = null;
        this.count = null;
        this.visit = null;
        this.birthday = null;
        this.gift = null;
        this.friendreq = null;
        this.special = null;
        this.mayknow = null;
        this.part_error = null;
        this.appinfo = null;
        this.photos = null;
        this.visit_no_right = null;
        this.photos_buf = null;
        this.recent_photos = null;
        this.readspace = null;
        this.attach_info = "";
        this.no_update = 0;
        this.flower = null;
        this.game = null;
        this.redinfo = null;
        this.uWanBaNew = 0L;
        this.friend_ship = null;
        this.green_diamond_flag = (byte) 0;
        this.music_can_play = true;
        this.all_music_nums = 0;
        this.all_music_list = null;
        this.all_acc = null;
        this.wifi_auto_play = (byte) 0;
        this.play_mode_flag = (byte) 0;
        this.adv_banner = null;
        this.msgb_festival = null;
        this.brandspace_h5 = null;
        this.campus_qz = null;
        this.bgvoice_buf = null;
        this.loop_playback_flag = (byte) 0;
        this.tab_lst = null;
        this.share_bg_url = "";
        this.qzmall_cover_url = "";
        this.open_msg_board = true;
        this.sq_mainpage_switch = null;
        this.pk_banner = null;
        this.limit_page_card = null;
        this.reward_data = null;
        this.myFriendEntryItem = null;
        this.StuFunnySpace = null;
        this.map_entrys = null;
        this.stShangchengInfo = null;
        this.tab_lst_mq = null;
        this.navigation_order = null;
        this.vec_event = null;
        this.tab_top_lst = null;
        this.urge_publish = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mainpage = (s_main_page) jceInputStream.read((JceStruct) cache_mainpage, 0, false);
        this.profile = (s_profile) jceInputStream.read((JceStruct) cache_profile, 1, false);
        this.count = (s_count) jceInputStream.read((JceStruct) cache_count, 2, false);
        this.visit = (s_visit) jceInputStream.read((JceStruct) cache_visit, 3, false);
        this.birthday = (s_birthday) jceInputStream.read((JceStruct) cache_birthday, 4, false);
        this.gift = (s_gift) jceInputStream.read((JceStruct) cache_gift, 5, false);
        this.friendreq = (s_friendreq) jceInputStream.read((JceStruct) cache_friendreq, 6, false);
        this.special = (s_special) jceInputStream.read((JceStruct) cache_special, 7, false);
        this.mayknow = (s_mayknow) jceInputStream.read((JceStruct) cache_mayknow, 8, false);
        this.part_error = (s_part_error) jceInputStream.read((JceStruct) cache_part_error, 9, false);
        this.appinfo = (s_appinfo) jceInputStream.read((JceStruct) cache_appinfo, 10, false);
        this.photos = (s_rec_photo_list) jceInputStream.read((JceStruct) cache_photos, 11, false);
        this.visit_no_right = (s_visit) jceInputStream.read((JceStruct) cache_visit_no_right, 12, false);
        this.photos_buf = (ArrayList) jceInputStream.read((JceInputStream) cache_photos_buf, 13, false);
        this.recent_photos = (ArrayList) jceInputStream.read((JceInputStream) cache_recent_photos, 14, false);
        this.readspace = (s_read_space) jceInputStream.read((JceStruct) cache_readspace, 15, false);
        this.attach_info = jceInputStream.readString(16, false);
        this.no_update = jceInputStream.read(this.no_update, 17, false);
        this.flower = (s_flower) jceInputStream.read((JceStruct) cache_flower, 18, false);
        this.game = (s_game) jceInputStream.read((JceStruct) cache_game, 19, false);
        this.redinfo = (Map) jceInputStream.read((JceInputStream) cache_redinfo, 20, false);
        this.uWanBaNew = jceInputStream.read(this.uWanBaNew, 21, false);
        this.friend_ship = (s_friend_ship) jceInputStream.read((JceStruct) cache_friend_ship, 22, false);
        this.green_diamond_flag = jceInputStream.read(this.green_diamond_flag, 23, false);
        this.music_can_play = jceInputStream.read(this.music_can_play, 24, false);
        this.all_music_nums = jceInputStream.read(this.all_music_nums, 25, false);
        this.all_music_list = (ArrayList) jceInputStream.read((JceInputStream) cache_all_music_list, 26, false);
        this.all_acc = (ArrayList) jceInputStream.read((JceInputStream) cache_all_acc, 27, false);
        this.wifi_auto_play = jceInputStream.read(this.wifi_auto_play, 28, false);
        this.play_mode_flag = jceInputStream.read(this.play_mode_flag, 29, false);
        this.adv_banner = (ArrayList) jceInputStream.read((JceInputStream) cache_adv_banner, 30, false);
        this.msgb_festival = (s_msgb_festival) jceInputStream.read((JceStruct) cache_msgb_festival, 31, false);
        this.brandspace_h5 = (s_brandspace_h5) jceInputStream.read((JceStruct) cache_brandspace_h5, 32, false);
        this.campus_qz = (s_campus_qz) jceInputStream.read((JceStruct) cache_campus_qz, 33, false);
        this.bgvoice_buf = jceInputStream.read(cache_bgvoice_buf, 34, false);
        this.loop_playback_flag = jceInputStream.read(this.loop_playback_flag, 35, false);
        this.tab_lst = (s_tab_list) jceInputStream.read((JceStruct) cache_tab_lst, 36, false);
        this.share_bg_url = jceInputStream.readString(37, false);
        this.qzmall_cover_url = jceInputStream.readString(38, false);
        this.open_msg_board = jceInputStream.read(this.open_msg_board, 39, false);
        this.sq_mainpage_switch = (s_sq_mainpage_switch) jceInputStream.read((JceStruct) cache_sq_mainpage_switch, 40, false);
        this.pk_banner = (s_gamebar_pk_banner) jceInputStream.read((JceStruct) cache_pk_banner, 41, false);
        this.limit_page_card = (s_limit_page_card) jceInputStream.read((JceStruct) cache_limit_page_card, 42, false);
        this.reward_data = (s_qzone_reward_data) jceInputStream.read((JceStruct) cache_reward_data, 43, false);
        this.myFriendEntryItem = (s_mainPageTabItem) jceInputStream.read((JceStruct) cache_myFriendEntryItem, 44, false);
        this.StuFunnySpace = (FunnySpace) jceInputStream.read((JceStruct) cache_StuFunnySpace, 45, false);
        this.map_entrys = (Map) jceInputStream.read((JceInputStream) cache_map_entrys, 46, false);
        this.stShangchengInfo = jceInputStream.read(cache_stShangchengInfo, 47, false);
        this.tab_lst_mq = (s_tab_list) jceInputStream.read((JceStruct) cache_tab_lst_mq, 48, false);
        this.navigation_order = (ArrayList) jceInputStream.read((JceInputStream) cache_navigation_order, 49, false);
        this.vec_event = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_event, 50, false);
        this.tab_top_lst = (s_tab_list) jceInputStream.read((JceStruct) cache_tab_top_lst, 51, false);
        this.urge_publish = (s_urge_publish_info) jceInputStream.read((JceStruct) cache_urge_publish, 52, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_main_page s_main_pageVar = this.mainpage;
        if (s_main_pageVar != null) {
            jceOutputStream.write((JceStruct) s_main_pageVar, 0);
        }
        s_profile s_profileVar = this.profile;
        if (s_profileVar != null) {
            jceOutputStream.write((JceStruct) s_profileVar, 1);
        }
        s_count s_countVar = this.count;
        if (s_countVar != null) {
            jceOutputStream.write((JceStruct) s_countVar, 2);
        }
        s_visit s_visitVar = this.visit;
        if (s_visitVar != null) {
            jceOutputStream.write((JceStruct) s_visitVar, 3);
        }
        s_birthday s_birthdayVar = this.birthday;
        if (s_birthdayVar != null) {
            jceOutputStream.write((JceStruct) s_birthdayVar, 4);
        }
        s_gift s_giftVar = this.gift;
        if (s_giftVar != null) {
            jceOutputStream.write((JceStruct) s_giftVar, 5);
        }
        s_friendreq s_friendreqVar = this.friendreq;
        if (s_friendreqVar != null) {
            jceOutputStream.write((JceStruct) s_friendreqVar, 6);
        }
        s_special s_specialVar = this.special;
        if (s_specialVar != null) {
            jceOutputStream.write((JceStruct) s_specialVar, 7);
        }
        s_mayknow s_mayknowVar = this.mayknow;
        if (s_mayknowVar != null) {
            jceOutputStream.write((JceStruct) s_mayknowVar, 8);
        }
        s_part_error s_part_errorVar = this.part_error;
        if (s_part_errorVar != null) {
            jceOutputStream.write((JceStruct) s_part_errorVar, 9);
        }
        s_appinfo s_appinfoVar = this.appinfo;
        if (s_appinfoVar != null) {
            jceOutputStream.write((JceStruct) s_appinfoVar, 10);
        }
        s_rec_photo_list s_rec_photo_listVar = this.photos;
        if (s_rec_photo_listVar != null) {
            jceOutputStream.write((JceStruct) s_rec_photo_listVar, 11);
        }
        s_visit s_visitVar2 = this.visit_no_right;
        if (s_visitVar2 != null) {
            jceOutputStream.write((JceStruct) s_visitVar2, 12);
        }
        ArrayList<byte[]> arrayList = this.photos_buf;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 13);
        }
        ArrayList<single_feed> arrayList2 = this.recent_photos;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 14);
        }
        s_read_space s_read_spaceVar = this.readspace;
        if (s_read_spaceVar != null) {
            jceOutputStream.write((JceStruct) s_read_spaceVar, 15);
        }
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 16);
        }
        jceOutputStream.write(this.no_update, 17);
        s_flower s_flowerVar = this.flower;
        if (s_flowerVar != null) {
            jceOutputStream.write((JceStruct) s_flowerVar, 18);
        }
        s_game s_gameVar = this.game;
        if (s_gameVar != null) {
            jceOutputStream.write((JceStruct) s_gameVar, 19);
        }
        Map<Integer, s_red_comm> map = this.redinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 20);
        }
        jceOutputStream.write(this.uWanBaNew, 21);
        s_friend_ship s_friend_shipVar = this.friend_ship;
        if (s_friend_shipVar != null) {
            jceOutputStream.write((JceStruct) s_friend_shipVar, 22);
        }
        jceOutputStream.write(this.green_diamond_flag, 23);
        jceOutputStream.write(this.music_can_play, 24);
        jceOutputStream.write(this.all_music_nums, 25);
        ArrayList<MusicInfo> arrayList3 = this.all_music_list;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 26);
        }
        ArrayList<s_app_acc> arrayList4 = this.all_acc;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 27);
        }
        jceOutputStream.write(this.wifi_auto_play, 28);
        jceOutputStream.write(this.play_mode_flag, 29);
        ArrayList<QueryADBannerUnit> arrayList5 = this.adv_banner;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 30);
        }
        s_msgb_festival s_msgb_festivalVar = this.msgb_festival;
        if (s_msgb_festivalVar != null) {
            jceOutputStream.write((JceStruct) s_msgb_festivalVar, 31);
        }
        s_brandspace_h5 s_brandspace_h5Var = this.brandspace_h5;
        if (s_brandspace_h5Var != null) {
            jceOutputStream.write((JceStruct) s_brandspace_h5Var, 32);
        }
        s_campus_qz s_campus_qzVar = this.campus_qz;
        if (s_campus_qzVar != null) {
            jceOutputStream.write((JceStruct) s_campus_qzVar, 33);
        }
        byte[] bArr = this.bgvoice_buf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 34);
        }
        jceOutputStream.write(this.loop_playback_flag, 35);
        s_tab_list s_tab_listVar = this.tab_lst;
        if (s_tab_listVar != null) {
            jceOutputStream.write((JceStruct) s_tab_listVar, 36);
        }
        String str2 = this.share_bg_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 37);
        }
        String str3 = this.qzmall_cover_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 38);
        }
        jceOutputStream.write(this.open_msg_board, 39);
        s_sq_mainpage_switch s_sq_mainpage_switchVar = this.sq_mainpage_switch;
        if (s_sq_mainpage_switchVar != null) {
            jceOutputStream.write((JceStruct) s_sq_mainpage_switchVar, 40);
        }
        s_gamebar_pk_banner s_gamebar_pk_bannerVar = this.pk_banner;
        if (s_gamebar_pk_bannerVar != null) {
            jceOutputStream.write((JceStruct) s_gamebar_pk_bannerVar, 41);
        }
        s_limit_page_card s_limit_page_cardVar = this.limit_page_card;
        if (s_limit_page_cardVar != null) {
            jceOutputStream.write((JceStruct) s_limit_page_cardVar, 42);
        }
        s_qzone_reward_data s_qzone_reward_dataVar = this.reward_data;
        if (s_qzone_reward_dataVar != null) {
            jceOutputStream.write((JceStruct) s_qzone_reward_dataVar, 43);
        }
        s_mainPageTabItem s_mainpagetabitem = this.myFriendEntryItem;
        if (s_mainpagetabitem != null) {
            jceOutputStream.write((JceStruct) s_mainpagetabitem, 44);
        }
        FunnySpace funnySpace = this.StuFunnySpace;
        if (funnySpace != null) {
            jceOutputStream.write((JceStruct) funnySpace, 45);
        }
        Map<Integer, s_mainPageTabItem> map2 = this.map_entrys;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 46);
        }
        byte[] bArr2 = this.stShangchengInfo;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 47);
        }
        s_tab_list s_tab_listVar2 = this.tab_lst_mq;
        if (s_tab_listVar2 != null) {
            jceOutputStream.write((JceStruct) s_tab_listVar2, 48);
        }
        ArrayList<s_navigation_item> arrayList6 = this.navigation_order;
        if (arrayList6 != null) {
            jceOutputStream.write((Collection) arrayList6, 49);
        }
        ArrayList<s_space_event> arrayList7 = this.vec_event;
        if (arrayList7 != null) {
            jceOutputStream.write((Collection) arrayList7, 50);
        }
        s_tab_list s_tab_listVar3 = this.tab_top_lst;
        if (s_tab_listVar3 != null) {
            jceOutputStream.write((JceStruct) s_tab_listVar3, 51);
        }
        s_urge_publish_info s_urge_publish_infoVar = this.urge_publish;
        if (s_urge_publish_infoVar != null) {
            jceOutputStream.write((JceStruct) s_urge_publish_infoVar, 52);
        }
    }

    public mobile_main_page_rsp(s_main_page s_main_pageVar, s_profile s_profileVar, s_count s_countVar, s_visit s_visitVar, s_birthday s_birthdayVar, s_gift s_giftVar, s_friendreq s_friendreqVar, s_special s_specialVar, s_mayknow s_mayknowVar, s_part_error s_part_errorVar, s_appinfo s_appinfoVar, s_rec_photo_list s_rec_photo_listVar, s_visit s_visitVar2, ArrayList<byte[]> arrayList, ArrayList<single_feed> arrayList2, s_read_space s_read_spaceVar, String str, int i3, s_flower s_flowerVar, s_game s_gameVar, Map<Integer, s_red_comm> map, long j3, s_friend_ship s_friend_shipVar, byte b16, boolean z16, int i16, ArrayList<MusicInfo> arrayList3, ArrayList<s_app_acc> arrayList4, byte b17, byte b18, ArrayList<QueryADBannerUnit> arrayList5, s_msgb_festival s_msgb_festivalVar, s_brandspace_h5 s_brandspace_h5Var, s_campus_qz s_campus_qzVar, byte[] bArr, byte b19, s_tab_list s_tab_listVar, String str2, String str3, boolean z17, s_sq_mainpage_switch s_sq_mainpage_switchVar, s_gamebar_pk_banner s_gamebar_pk_bannerVar, s_limit_page_card s_limit_page_cardVar, s_qzone_reward_data s_qzone_reward_dataVar, s_mainPageTabItem s_mainpagetabitem, FunnySpace funnySpace, Map<Integer, s_mainPageTabItem> map2, byte[] bArr2, s_tab_list s_tab_listVar2, ArrayList<s_navigation_item> arrayList6, ArrayList<s_space_event> arrayList7, s_tab_list s_tab_listVar3) {
        this.mainpage = s_main_pageVar;
        this.profile = s_profileVar;
        this.count = s_countVar;
        this.visit = s_visitVar;
        this.birthday = s_birthdayVar;
        this.gift = s_giftVar;
        this.friendreq = s_friendreqVar;
        this.special = s_specialVar;
        this.mayknow = s_mayknowVar;
        this.part_error = s_part_errorVar;
        this.appinfo = s_appinfoVar;
        this.photos = s_rec_photo_listVar;
        this.visit_no_right = s_visitVar2;
        this.photos_buf = arrayList;
        this.recent_photos = arrayList2;
        this.readspace = s_read_spaceVar;
        this.attach_info = str;
        this.no_update = i3;
        this.flower = s_flowerVar;
        this.game = s_gameVar;
        this.redinfo = map;
        this.uWanBaNew = j3;
        this.friend_ship = s_friend_shipVar;
        this.green_diamond_flag = b16;
        this.music_can_play = z16;
        this.all_music_nums = i16;
        this.all_music_list = arrayList3;
        this.all_acc = arrayList4;
        this.wifi_auto_play = b17;
        this.play_mode_flag = b18;
        this.adv_banner = arrayList5;
        this.msgb_festival = s_msgb_festivalVar;
        this.brandspace_h5 = s_brandspace_h5Var;
        this.campus_qz = s_campus_qzVar;
        this.bgvoice_buf = bArr;
        this.loop_playback_flag = b19;
        this.tab_lst = s_tab_listVar;
        this.share_bg_url = str2;
        this.qzmall_cover_url = str3;
        this.open_msg_board = z17;
        this.sq_mainpage_switch = s_sq_mainpage_switchVar;
        this.pk_banner = s_gamebar_pk_bannerVar;
        this.limit_page_card = s_limit_page_cardVar;
        this.reward_data = s_qzone_reward_dataVar;
        this.myFriendEntryItem = s_mainpagetabitem;
        this.StuFunnySpace = funnySpace;
        this.map_entrys = map2;
        this.stShangchengInfo = bArr2;
        this.tab_lst_mq = s_tab_listVar2;
        this.navigation_order = arrayList6;
        this.vec_event = arrayList7;
        this.tab_top_lst = s_tab_listVar3;
        this.urge_publish = null;
    }
}
