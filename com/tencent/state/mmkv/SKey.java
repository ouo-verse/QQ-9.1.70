package com.tencent.state.mmkv;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/mmkv/SKey;", "", "()V", "Calendar", "ChatLand", "Common", "DetailMe", "Filament", "Flower", "FriendPick", "Guide", "Interaction", "Library", "Location", "Migrate", "Privacy", "PublicChat", "QuickPublishEntry", "SettingTips", "Temple", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class SKey {
    public static final SKey INSTANCE = new SKey();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Calendar;", "", "()V", "ENABLE_SHOW_LIBRARY_CALENDAR_GUIDE", "", "HAS_SHOW_LIBRARY_CALENDAR", "HAS_SHOW_LIBRARY_CALENDAR_GUIDE", "KEY_CALENDAR_RED_DOT_HAS_SHOWN", "SQUARE_LIBRARY_CALENDAR_GUIDE_KEY_PREFIX", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Calendar {
        public static final String ENABLE_SHOW_LIBRARY_CALENDAR_GUIDE = "vas_library_calendar_guide_enable_show";
        public static final String HAS_SHOW_LIBRARY_CALENDAR = "vas_library_calendar_has_show";
        public static final String HAS_SHOW_LIBRARY_CALENDAR_GUIDE = "vas_library_calendar_guide_has_show";
        public static final Calendar INSTANCE = new Calendar();
        public static final String KEY_CALENDAR_RED_DOT_HAS_SHOWN = "key_calendar_red_dot_has_shown";
        public static final String SQUARE_LIBRARY_CALENDAR_GUIDE_KEY_PREFIX = "vas_library_calendar_guide_key_prefix_";

        Calendar() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/mmkv/SKey$ChatLand;", "", "()V", "HAS_SHOW_CHAT_LAND_WELCOME_TIPS", "", "HAS_SHOW_PAIR_INVITE_TIPS", "HAS_SHOW_PAIR_PARING_TIPS", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class ChatLand {
        public static final String HAS_SHOW_CHAT_LAND_WELCOME_TIPS = "vas_chat_land_welcome_tips";
        public static final String HAS_SHOW_PAIR_INVITE_TIPS = "vas_chat_land_pair_invite_tips";
        public static final String HAS_SHOW_PAIR_PARING_TIPS = "vas_chat_land_pair_paring_tips";
        public static final ChatLand INSTANCE = new ChatLand();

        ChatLand() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Common;", "", "()V", "HAS_SHOW_KEEP_SCENE_TIME_TIPS_DIALOG", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Common {
        public static final String HAS_SHOW_KEEP_SCENE_TIME_TIPS_DIALOG = "vas_pray_keep_scene_time_tips_dialog";
        public static final Common INSTANCE = new Common();

        Common() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/mmkv/SKey$DetailMe;", "", "()V", "DIALOG_KEY_MUSIC_STATUS", "", "HAS_CLICK_DETAIL_ME_DRESS_GUIDE", "HAS_CLICK_PUBLISH_BTN", "HAS_SHOW_DETAIL_ME_DRESS_RED_DOT", "KEY_ONLINE_STATUS_MULTI_ACTION_ITEM_REDDOT", "KEY_PUBLISH_WITHOUT_TIP", "KEY_SHOW_BATTERY_STATUS_DIALOG", "KEY_SHOW_SETTING_TIPS", "KEY_TITLE_RED_POINT_SP", "VAS_SOCIAL_STATUS_DRAFT_SP_KEY", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DetailMe {
        public static final String DIALOG_KEY_MUSIC_STATUS = "vas_social_status_music_tips";
        public static final String HAS_CLICK_DETAIL_ME_DRESS_GUIDE = "click_detail_me_dress";
        public static final String HAS_CLICK_PUBLISH_BTN = "has_click_publish_btn";
        public static final String HAS_SHOW_DETAIL_ME_DRESS_RED_DOT = "has_show_detail_me_dress_reddot";
        public static final DetailMe INSTANCE = new DetailMe();
        public static final String KEY_ONLINE_STATUS_MULTI_ACTION_ITEM_REDDOT = "OnlineStatusMultiActionItemReddot";
        public static final String KEY_PUBLISH_WITHOUT_TIP = "key_publish_without_tip";
        public static final String KEY_SHOW_BATTERY_STATUS_DIALOG = "vas_status_square_show_battery_dialog";
        public static final String KEY_SHOW_SETTING_TIPS = "show_setting_tips";
        public static final String KEY_TITLE_RED_POINT_SP = "red_point";
        public static final String VAS_SOCIAL_STATUS_DRAFT_SP_KEY = "vas_social_status_draft_sp_key";

        DetailMe() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Filament;", "", "()V", "LAST_USE_FILAMENT_IN_DETAIL_PAGE_PID", "", "LAST_USE_FILAMENT_QQ_VERSION", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Filament {
        public static final Filament INSTANCE = new Filament();
        public static final String LAST_USE_FILAMENT_IN_DETAIL_PAGE_PID = "vas_last_use_filament_in_detail_page_pid";
        public static final String LAST_USE_FILAMENT_QQ_VERSION = "vas_last_use_filament_qq_version";

        Filament() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Flower;", "", "()V", "PRE_MEDAL_UPGRADE_ANIMATION_LEVEL", "Lkotlin/Function1;", "", "getPRE_MEDAL_UPGRADE_ANIMATION_LEVEL", "()Lkotlin/jvm/functions/Function1;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Flower {
        public static final Flower INSTANCE = new Flower();
        private static final Function1<String, String> PRE_MEDAL_UPGRADE_ANIMATION_LEVEL = new Function1<String, String>() { // from class: com.tencent.state.mmkv.SKey$Flower$PRE_MEDAL_UPGRADE_ANIMATION_LEVEL$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String uin) {
                Intrinsics.checkNotNullParameter(uin, "uin");
                return "pre_medal_upgrade_animation_level_" + uin;
            }
        };

        Flower() {
        }

        public final Function1<String, String> getPRE_MEDAL_UPGRADE_ANIMATION_LEVEL() {
            return PRE_MEDAL_UPGRADE_ANIMATION_LEVEL;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/mmkv/SKey$FriendPick;", "", "()V", "KEY_HAD_SHOW_FRIEND_PICK_TIPS", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class FriendPick {
        public static final FriendPick INSTANCE = new FriendPick();
        public static final String KEY_HAD_SHOW_FRIEND_PICK_TIPS = "key_had_show_friend_pick_tips";

        FriendPick() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Guide;", "", "()V", "HAS_CHECKED_CREATE_ROLE_GUIDE", "", "HAS_SHOW_LIB_OFF_NOTICE", "SHOW_CREATE_ROLE_GUIDE_COUNT", "SHOW_PUBLISH_STATUS_GUIDE_COUNT", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Guide {
        public static final String HAS_CHECKED_CREATE_ROLE_GUIDE = "novice_guide_has_checked_create_role_guide";
        public static final String HAS_SHOW_LIB_OFF_NOTICE = "has_show_lib_off_notice";
        public static final Guide INSTANCE = new Guide();
        public static final String SHOW_CREATE_ROLE_GUIDE_COUNT = "novice_guide_show_create_role_count";
        public static final String SHOW_PUBLISH_STATUS_GUIDE_COUNT = "novice_guide_show_publish_status_count";

        Guide() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Interaction;", "", "()V", "INTERACTION_GUIDE_TIME", "", "INTERACTION_OPTION_SELECT_SEQUENCE_KEY_PREFIX", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Interaction {
        public static final Interaction INSTANCE = new Interaction();
        public static final String INTERACTION_GUIDE_TIME = "interaction_guide_time";
        public static final String INTERACTION_OPTION_SELECT_SEQUENCE_KEY_PREFIX = "InteractionSelectOrder_SEQUENCE_";

        Interaction() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Library;", "", "()V", "CAN_SHOW_LIBRARY_SWITCH_TABLE_TIPS", "", "HAS_SHOW_GROUP_START_FOCUS_TIPS", "HAS_SHOW_LIBRARY_CALENDAR_TIPS", "HAS_SHOW_LIBRARY_CALLBACK_TIPS", "HAS_SHOW_LIBRARY_WELCOME_TIPS", "HAS_SHOW_SHARE_GROUP_TIPS", "HAS_SHOW_SINGLE_START_FOCUS_TIPS", "KEY_Q_BOOK_AVAILABLE", "KEY_STRANGER_DIALOG_SHOW_TIME", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Library {
        public static final String CAN_SHOW_LIBRARY_SWITCH_TABLE_TIPS = "vas_library_can_show_switch_table_tips";
        public static final String HAS_SHOW_GROUP_START_FOCUS_TIPS = "vas_start_group_focus_tips";
        public static final String HAS_SHOW_LIBRARY_CALENDAR_TIPS = "vas_library_calendar_tips";
        public static final String HAS_SHOW_LIBRARY_CALLBACK_TIPS = "vas_library_callback_tips";
        public static final String HAS_SHOW_LIBRARY_WELCOME_TIPS = "vas_library_welcome_tips";
        public static final String HAS_SHOW_SHARE_GROUP_TIPS = "vas_share_group_tips";
        public static final String HAS_SHOW_SINGLE_START_FOCUS_TIPS = "vas_start_single_focus_tips";
        public static final Library INSTANCE = new Library();
        public static final String KEY_Q_BOOK_AVAILABLE = "key_q_book_availableu";
        public static final String KEY_STRANGER_DIALOG_SHOW_TIME = "key_stranger_dialog_show_time";

        Library() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Location;", "", "()V", "LOCATION_GUIDE_FLAG", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Location {
        public static final Location INSTANCE = new Location();
        public static final String LOCATION_GUIDE_FLAG = "location_guide_flag";

        Location() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Migrate;", "", "()V", "HAS_MIGRATE_VAS_FILE", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Migrate {
        public static final String HAS_MIGRATE_VAS_FILE = "has_migrate_from_vas_file";
        public static final Migrate INSTANCE = new Migrate();

        Migrate() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Privacy;", "", "()V", "KEY_STRANGER_INVISIBLE", "", "QZONE_PRIVACY_DIALOG_SHOW_TIME", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Privacy {
        public static final Privacy INSTANCE = new Privacy();
        public static final String KEY_STRANGER_INVISIBLE = "key_stranger_invisible";
        public static final String QZONE_PRIVACY_DIALOG_SHOW_TIME = "qzone_privacy_dialog_show_time";

        Privacy() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/mmkv/SKey$PublicChat;", "", "()V", "HAS_SHOW_CALL_MATE_TIPS", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class PublicChat {
        public static final String HAS_SHOW_CALL_MATE_TIPS = "vas_public_chat_call_mate_tips";
        public static final PublicChat INSTANCE = new PublicChat();

        PublicChat() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/mmkv/SKey$QuickPublishEntry;", "", "()V", "LAST_CLICK_TIME", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class QuickPublishEntry {
        public static final QuickPublishEntry INSTANCE = new QuickPublishEntry();
        public static final String LAST_CLICK_TIME = "vas_square_quick_publish_entry_last_click_time";

        QuickPublishEntry() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/mmkv/SKey$SettingTips;", "", "()V", "CLOSE_TO_ME_KEY", "", "FIXED_KEY", "IS_FIRST_GOTO_SQUARE_KEY", "KEY_HAS_ADD_TROOP", "KEY_LAST_SHOW_ADD_TROOP_DIALOG_TIME", "KEY_SHOW_ADD_TROOP_DIALOG_COUNT", "TROOP_CLOSE_TO_ME_KEY", "TROOP_HIDE_KEY", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class SettingTips {
        public static final String CLOSE_TO_ME_KEY = "isCloseToMe";
        public static final String FIXED_KEY = "isFixFriend";
        public static final SettingTips INSTANCE = new SettingTips();
        public static final String IS_FIRST_GOTO_SQUARE_KEY = "firstGoToSquare";
        public static final String KEY_HAS_ADD_TROOP = "hasAddTroop";
        public static final String KEY_LAST_SHOW_ADD_TROOP_DIALOG_TIME = "lastTroopShowTime";
        public static final String KEY_SHOW_ADD_TROOP_DIALOG_COUNT = "showTroopDialog";
        public static final String TROOP_CLOSE_TO_ME_KEY = "isCloseToMeTroop";
        public static final String TROOP_HIDE_KEY = "isHideTroop";

        SettingTips() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/mmkv/SKey$Temple;", "", "()V", "DISABLE_SWITCH_SEAT_CONFIRM", "", "HAS_SHOW_START_PRAY_TIPS_DIALOG", "HAS_SHOW_TEMPLE_WELCOME_TIPS", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Temple {
        public static final String DISABLE_SWITCH_SEAT_CONFIRM = "vas_pray_disable_switch_seat_confirm";
        public static final String HAS_SHOW_START_PRAY_TIPS_DIALOG = "vas_pray_tips_dialog";
        public static final String HAS_SHOW_TEMPLE_WELCOME_TIPS = "vas_temple_welcome_tips";
        public static final Temple INSTANCE = new Temple();

        Temple() {
        }
    }

    SKey() {
    }
}
