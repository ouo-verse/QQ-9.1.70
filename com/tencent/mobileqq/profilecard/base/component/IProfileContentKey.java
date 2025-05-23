package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes16.dex */
public interface IProfileContentKey {
    public static final IPatchRedirector $redirector_ = null;
    public static final List<String[]> COMPONENT_ADD_LIST_NORMAL;
    public static final HashMap<String, Integer> COMPONENT_ADD_MAP_ELEGANT;
    public static final String[] KEY_MAP_BLACKLIST;
    public static final String[] KEY_MAP_HAS_BOTTOM_MARGIN_ELEGANT;
    public static final String[] KEY_MAP_HAS_TOP_DIVIDER;
    public static final String[] KEY_MAP_HAS_TOP_DIVIDER_ELEGANT;
    public static final String[] KEY_MAP_QIDIAN_PRIVATE_TROOP;
    public static final List<String[]> KEY_MAP_WEIGHT;
    public static final String MAP_KEY_ACCOUNT_INFO_V2 = "map_key_account_info_v2";
    public static final String MAP_KEY_ACCOUNT_INFO_VAS = "map_key_account_info_vas";
    public static final String MAP_KEY_ACCOUNT_LEVEL = "map_key_account_level";
    public static final String MAP_KEY_ADD_PROFILE = "map_key_add_profile";
    public static final String MAP_KEY_ANONYMOUS = "map_key_anonymous";
    public static final String MAP_KEY_ANONYMOUS_EMPTY = "map_key_anonymous_empty";
    public static final String MAP_KEY_CONTAINER_DIVIDER = "map_key_container_divider";
    public static final String MAP_KEY_DIAMOND = "map_key_diamond";
    public static final String MAP_KEY_DIVIDER = "map_key_divider";
    public static final String MAP_KEY_DIY_BASE_INFO = "map_key_base_info";
    public static final String MAP_KEY_DRESSUP = "map_key_dressup";
    public static final String MAP_KEY_ELEGANT_ACCOUNT_LEVEL = "map_key_elegant_account_level";
    public static final String MAP_KEY_EXTEND_FRIEND = "map_key_extend_friend";
    public static final String MAP_KEY_FANS_INFO = "map_key_fans_info";
    public static final String MAP_KEY_FAVOR = "map_key_favor";
    public static final String MAP_KEY_GAME_INFO = "map_key_game_info";
    public static final String MAP_KEY_GUIDE = "map_key_guide";
    public static final String MAP_KEY_INTIMATE = "map_key_intimate";
    public static final String MAP_KEY_IN_STEP = "map_key_in_step";
    public static final String MAP_KEY_LIFE_ACHIEVEMENT = "map_key_life_achievement";
    public static final String MAP_KEY_META_FARM = "map_key_meta_farm";
    public static final String MAP_KEY_MINE_WEISHI = "map_key_mine_weishi";
    public static final String MAP_KEY_MINI_PLAYING = "map_key_mini_playing";
    public static final String MAP_KEY_MUSIC_BOX = "map_key_music_box";
    public static final String MAP_KEY_MUSIC_DATA = "map_key_music_data";
    public static final String MAP_KEY_PERSONALITY_LABEL = "map_key_personality_label";
    public static final String MAP_KEY_PERSONAL_SIG = "map_key_personal_sign";
    public static final String MAP_KEY_PHONE = "map_key_phone";
    public static final String MAP_KEY_PHOTO_WALL = "map_key_photo_wall";
    public static final String MAP_KEY_PRESENT = "map_key_present";
    public static final String MAP_KEY_PYMK_REASON_DATA = "map_key_pymk_reason_data";
    public static final String MAP_KEY_QQCARD = "map_key_qqcard";
    public static final String MAP_KEY_QQCIRCLE = "map_key_qqcircle";
    public static final String MAP_KEY_QZONE = "map_key_qzone";
    public static final String MAP_KEY_STICKY_NOTE = "map_key_sticky_note";
    public static final String MAP_KEY_STICKY_NOTE_EMPTY = "map_key_sticky_note_empty";
    public static final String MAP_KEY_TAB_LIST = "map_key_tab_list";
    public static final String MAP_KEY_TAG_LABEL = "map_key_tag_label";
    public static final String MAP_KEY_TROOP_GAME_INFO = "map_key_troop_game_info";
    public static final String MAP_KEY_TROOP_MEM_INFO = "map_key_troop_mem_info";
    public static final String MAP_KEY_YUAN_MENG = "map_key_yuan_meng";

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33469), (Class<?>) IProfileContentKey.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        COMPONENT_ADD_LIST_NORMAL = new ArrayList<String[]>() { // from class: com.tencent.mobileqq.profilecard.base.component.IProfileContentKey.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    add(new String[]{IProfileContentKey.MAP_KEY_GUIDE, IProfileContentKey.MAP_KEY_ACCOUNT_INFO_VAS, IProfileContentKey.MAP_KEY_ACCOUNT_INFO_V2, IProfileContentKey.MAP_KEY_TAG_LABEL, IProfileContentKey.MAP_KEY_PERSONAL_SIG, IProfileContentKey.MAP_KEY_PHONE, IProfileContentKey.MAP_KEY_PYMK_REASON_DATA, IProfileContentKey.MAP_KEY_TROOP_MEM_INFO, IProfileContentKey.MAP_KEY_ACCOUNT_LEVEL, IProfileContentKey.MAP_KEY_DIAMOND, IProfileContentKey.MAP_KEY_DIY_BASE_INFO, IProfileContentKey.MAP_KEY_IN_STEP, IProfileContentKey.MAP_KEY_INTIMATE, IProfileContentKey.MAP_KEY_QQCIRCLE, IProfileContentKey.MAP_KEY_QZONE, IProfileContentKey.MAP_KEY_META_FARM, IProfileContentKey.MAP_KEY_TROOP_GAME_INFO, IProfileContentKey.MAP_KEY_YUAN_MENG, IProfileContentKey.MAP_KEY_GAME_INFO, IProfileContentKey.MAP_KEY_FANS_INFO, IProfileContentKey.MAP_KEY_PRESENT, IProfileContentKey.MAP_KEY_QQCARD, IProfileContentKey.MAP_KEY_DRESSUP, IProfileContentKey.MAP_KEY_MUSIC_BOX, IProfileContentKey.MAP_KEY_ANONYMOUS_EMPTY, IProfileContentKey.MAP_KEY_STICKY_NOTE_EMPTY, IProfileContentKey.MAP_KEY_ADD_PROFILE, IProfileContentKey.MAP_KEY_MINE_WEISHI, IProfileContentKey.MAP_KEY_PHOTO_WALL, IProfileContentKey.MAP_KEY_PERSONALITY_LABEL, IProfileContentKey.MAP_KEY_ANONYMOUS, IProfileContentKey.MAP_KEY_LIFE_ACHIEVEMENT, IProfileContentKey.MAP_KEY_EXTEND_FRIEND, IProfileContentKey.MAP_KEY_FAVOR, IProfileContentKey.MAP_KEY_MUSIC_DATA, IProfileContentKey.MAP_KEY_MINI_PLAYING, IProfileContentKey.MAP_KEY_STICKY_NOTE});
                }
            }
        };
        COMPONENT_ADD_MAP_ELEGANT = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.profilecard.base.component.IProfileContentKey.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                put(IProfileContentKey.MAP_KEY_ELEGANT_ACCOUNT_LEVEL, 0);
                put(IProfileContentKey.MAP_KEY_ACCOUNT_INFO_VAS, 0);
                put(IProfileContentKey.MAP_KEY_ACCOUNT_INFO_V2, 0);
                put(IProfileContentKey.MAP_KEY_PERSONAL_SIG, 0);
                put(IProfileContentKey.MAP_KEY_PYMK_REASON_DATA, 0);
                put(IProfileContentKey.MAP_KEY_TROOP_MEM_INFO, 0);
                put(IProfileContentKey.MAP_KEY_ACCOUNT_LEVEL, 0);
                put(IProfileContentKey.MAP_KEY_PHONE, 0);
                put(IProfileContentKey.MAP_KEY_DIAMOND, 0);
                put(IProfileContentKey.MAP_KEY_DIY_BASE_INFO, 0);
                put(IProfileContentKey.MAP_KEY_PERSONALITY_LABEL, 0);
                put(IProfileContentKey.MAP_KEY_INTIMATE, 0);
                put(IProfileContentKey.MAP_KEY_ADD_PROFILE, 1);
                put(IProfileContentKey.MAP_KEY_IN_STEP, 1);
                put(IProfileContentKey.MAP_KEY_QZONE, 2);
                put(IProfileContentKey.MAP_KEY_QQCIRCLE, 2);
                put(IProfileContentKey.MAP_KEY_TROOP_GAME_INFO, 2);
                put(IProfileContentKey.MAP_KEY_YUAN_MENG, 2);
                put(IProfileContentKey.MAP_KEY_GAME_INFO, 2);
                put(IProfileContentKey.MAP_KEY_FANS_INFO, 2);
                put(IProfileContentKey.MAP_KEY_PRESENT, 2);
                put(IProfileContentKey.MAP_KEY_QQCARD, 2);
                put(IProfileContentKey.MAP_KEY_DRESSUP, 2);
                put(IProfileContentKey.MAP_KEY_MUSIC_BOX, 2);
                put(IProfileContentKey.MAP_KEY_ANONYMOUS_EMPTY, 2);
                put(IProfileContentKey.MAP_KEY_STICKY_NOTE_EMPTY, 2);
                put(IProfileContentKey.MAP_KEY_MINE_WEISHI, 2);
                put(IProfileContentKey.MAP_KEY_FAVOR, 2);
                put(IProfileContentKey.MAP_KEY_PHOTO_WALL, 2);
                put(IProfileContentKey.MAP_KEY_ANONYMOUS, 2);
                put(IProfileContentKey.MAP_KEY_LIFE_ACHIEVEMENT, 2);
                put(IProfileContentKey.MAP_KEY_EXTEND_FRIEND, 2);
                put(IProfileContentKey.MAP_KEY_MINI_PLAYING, 2);
                put(IProfileContentKey.MAP_KEY_STICKY_NOTE, 2);
                put(IProfileContentKey.MAP_KEY_MUSIC_DATA, 2);
                put(IProfileContentKey.MAP_KEY_META_FARM, 2);
            }
        };
        KEY_MAP_WEIGHT = new ArrayList<String[]>() { // from class: com.tencent.mobileqq.profilecard.base.component.IProfileContentKey.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    add(new String[]{IProfileContentKey.MAP_KEY_ACCOUNT_INFO_V2, IProfileContentKey.MAP_KEY_ACCOUNT_LEVEL, IProfileContentKey.MAP_KEY_DIAMOND, IProfileContentKey.MAP_KEY_PERSONAL_SIG, IProfileContentKey.MAP_KEY_PYMK_REASON_DATA, IProfileContentKey.MAP_KEY_TROOP_MEM_INFO, IProfileContentKey.MAP_KEY_INTIMATE, IProfileContentKey.MAP_KEY_ADD_PROFILE, IProfileContentKey.MAP_KEY_IN_STEP, IProfileContentKey.MAP_KEY_QQCIRCLE, IProfileContentKey.MAP_KEY_QZONE, IProfileContentKey.MAP_KEY_META_FARM, IProfileContentKey.MAP_KEY_PHOTO_WALL, IProfileContentKey.MAP_KEY_PRESENT, IProfileContentKey.MAP_KEY_QQCARD, IProfileContentKey.MAP_KEY_DRESSUP, IProfileContentKey.MAP_KEY_ANONYMOUS, IProfileContentKey.MAP_KEY_TROOP_GAME_INFO, IProfileContentKey.MAP_KEY_YUAN_MENG, IProfileContentKey.MAP_KEY_GAME_INFO, IProfileContentKey.MAP_KEY_MINI_PLAYING, IProfileContentKey.MAP_KEY_FAVOR, IProfileContentKey.MAP_KEY_MUSIC_DATA, IProfileContentKey.MAP_KEY_STICKY_NOTE, IProfileContentKey.MAP_KEY_PHONE});
                }
            }
        };
        KEY_MAP_HAS_TOP_DIVIDER = new String[]{MAP_KEY_TROOP_MEM_INFO, MAP_KEY_PYMK_REASON_DATA, MAP_KEY_ACCOUNT_LEVEL, MAP_KEY_PERSONAL_SIG, MAP_KEY_DIAMOND, MAP_KEY_IN_STEP, MAP_KEY_QQCIRCLE, MAP_KEY_QZONE, MAP_KEY_PRESENT, MAP_KEY_QQCARD, MAP_KEY_DRESSUP, MAP_KEY_MUSIC_BOX, MAP_KEY_MINE_WEISHI, MAP_KEY_PHOTO_WALL, MAP_KEY_STICKY_NOTE, MAP_KEY_ANONYMOUS_EMPTY, MAP_KEY_STICKY_NOTE_EMPTY, MAP_KEY_ADD_PROFILE, MAP_KEY_MUSIC_DATA};
        KEY_MAP_HAS_TOP_DIVIDER_ELEGANT = new String[]{MAP_KEY_PERSONALITY_LABEL, MAP_KEY_INTIMATE};
        KEY_MAP_HAS_BOTTOM_MARGIN_ELEGANT = new String[]{MAP_KEY_ELEGANT_ACCOUNT_LEVEL, MAP_KEY_ACCOUNT_INFO_VAS, MAP_KEY_ACCOUNT_INFO_V2, MAP_KEY_PERSONAL_SIG, MAP_KEY_PYMK_REASON_DATA, MAP_KEY_TROOP_MEM_INFO, MAP_KEY_ACCOUNT_LEVEL, MAP_KEY_DIAMOND, MAP_KEY_DIY_BASE_INFO};
        KEY_MAP_QIDIAN_PRIVATE_TROOP = new String[]{MAP_KEY_DIAMOND, MAP_KEY_TROOP_MEM_INFO};
        KEY_MAP_BLACKLIST = new String[]{MAP_KEY_ACCOUNT_INFO_VAS, MAP_KEY_ACCOUNT_INFO_V2, MAP_KEY_ACCOUNT_LEVEL, MAP_KEY_DIAMOND, MAP_KEY_PERSONAL_SIG, MAP_KEY_TROOP_MEM_INFO, MAP_KEY_PYMK_REASON_DATA, MAP_KEY_DIY_BASE_INFO, MAP_KEY_PHONE, MAP_KEY_QQCIRCLE, MAP_KEY_QZONE, MAP_KEY_GUIDE, MAP_KEY_ELEGANT_ACCOUNT_LEVEL, MAP_KEY_ADD_PROFILE};
    }
}
