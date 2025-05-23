package com.tencent.mobileqq.aio.notification;

import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "", "id", "", "tag", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getTag", "()Ljava/lang/String;", "NONE", "DEBUG_LIVE", "DEBUG_TODO", "DEBUG_APPLICATION", "NET_STATE", "AIO_MONITOR", "TROOP_ANNOUNCEMENT", "AUDIO_VIDEO_CHAT", "TROOP_CLASS", "SHARE_SCREEN", "SHARE_LOCATION", "TROOP_LIVE", "LISTEN_MUSIC_TOGETHER", "FRAUD", "TROOP_OWNER_TASK", "TROOP_OWNER_MSG", "HOMEWORK_TROOP_MSG", "HOMEWORK_TROOP_IDENTIFY_GUIDE", "HOMEWORK_TROOP_CLASSINFO", "TROOP_ASSIST_TIPS", "TROOP_TODO", "TROOP_HW_NOTICE", "TROOP_HW_CLOCK_IN", "UPGRADE_BIG_TROOP", "UPGRADE_BIG_TROOP_EXPIRED", "TROOP_JOIN_GUILD", "NEARBY_ADD_FRIEND", "GAME_MSG", "ARK_TIP", "TROOP_GROUP_ALBUM", "TROOP_GAME_TEAM", "TROOP_GAME_JOIN", "TROOP_META_DREAM_TEAM", "TROOP_ASSIGN_HW_NOTIFY_BAR", "TROOP_WANGZHE_REPORT", "TROOP_TEAM_UP", "TROOP_META_DREAM_FARM", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIONotificationBusiId {
    private static final /* synthetic */ AIONotificationBusiId[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AIONotificationBusiId AIO_MONITOR;
    public static final AIONotificationBusiId ARK_TIP;
    public static final AIONotificationBusiId AUDIO_VIDEO_CHAT;
    public static final AIONotificationBusiId DEBUG_APPLICATION;
    public static final AIONotificationBusiId DEBUG_LIVE;
    public static final AIONotificationBusiId DEBUG_TODO;
    public static final AIONotificationBusiId FRAUD;
    public static final AIONotificationBusiId GAME_MSG;
    public static final AIONotificationBusiId HOMEWORK_TROOP_CLASSINFO;
    public static final AIONotificationBusiId HOMEWORK_TROOP_IDENTIFY_GUIDE;
    public static final AIONotificationBusiId HOMEWORK_TROOP_MSG;
    public static final AIONotificationBusiId LISTEN_MUSIC_TOGETHER;
    public static final AIONotificationBusiId NEARBY_ADD_FRIEND;
    public static final AIONotificationBusiId NET_STATE;
    public static final AIONotificationBusiId NONE;
    public static final AIONotificationBusiId SHARE_LOCATION;
    public static final AIONotificationBusiId SHARE_SCREEN;
    public static final AIONotificationBusiId TROOP_ANNOUNCEMENT;
    public static final AIONotificationBusiId TROOP_ASSIGN_HW_NOTIFY_BAR;
    public static final AIONotificationBusiId TROOP_ASSIST_TIPS;
    public static final AIONotificationBusiId TROOP_CLASS;
    public static final AIONotificationBusiId TROOP_GAME_JOIN;
    public static final AIONotificationBusiId TROOP_GAME_TEAM;
    public static final AIONotificationBusiId TROOP_GROUP_ALBUM;
    public static final AIONotificationBusiId TROOP_HW_CLOCK_IN;
    public static final AIONotificationBusiId TROOP_HW_NOTICE;
    public static final AIONotificationBusiId TROOP_JOIN_GUILD;
    public static final AIONotificationBusiId TROOP_LIVE;
    public static final AIONotificationBusiId TROOP_META_DREAM_FARM;
    public static final AIONotificationBusiId TROOP_META_DREAM_TEAM;
    public static final AIONotificationBusiId TROOP_OWNER_MSG;
    public static final AIONotificationBusiId TROOP_OWNER_TASK;
    public static final AIONotificationBusiId TROOP_TEAM_UP;
    public static final AIONotificationBusiId TROOP_TODO;
    public static final AIONotificationBusiId TROOP_WANGZHE_REPORT;
    public static final AIONotificationBusiId UPGRADE_BIG_TROOP;
    public static final AIONotificationBusiId UPGRADE_BIG_TROOP_EXPIRED;
    private final int id;

    @NotNull
    private final String tag;

    private static final /* synthetic */ AIONotificationBusiId[] $values() {
        return new AIONotificationBusiId[]{NONE, DEBUG_LIVE, DEBUG_TODO, DEBUG_APPLICATION, NET_STATE, AIO_MONITOR, TROOP_ANNOUNCEMENT, AUDIO_VIDEO_CHAT, TROOP_CLASS, SHARE_SCREEN, SHARE_LOCATION, TROOP_LIVE, LISTEN_MUSIC_TOGETHER, FRAUD, TROOP_OWNER_TASK, TROOP_OWNER_MSG, HOMEWORK_TROOP_MSG, HOMEWORK_TROOP_IDENTIFY_GUIDE, HOMEWORK_TROOP_CLASSINFO, TROOP_ASSIST_TIPS, TROOP_TODO, TROOP_HW_NOTICE, TROOP_HW_CLOCK_IN, UPGRADE_BIG_TROOP, UPGRADE_BIG_TROOP_EXPIRED, TROOP_JOIN_GUILD, NEARBY_ADD_FRIEND, GAME_MSG, ARK_TIP, TROOP_GROUP_ALBUM, TROOP_GAME_TEAM, TROOP_GAME_JOIN, TROOP_META_DREAM_TEAM, TROOP_ASSIGN_HW_NOTIFY_BAR, TROOP_WANGZHE_REPORT, TROOP_TEAM_UP, TROOP_META_DREAM_FARM};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        NONE = new AIONotificationBusiId("NONE", 0, 0, "none");
        DEBUG_LIVE = new AIONotificationBusiId("DEBUG_LIVE", 1, 1, "debug_live");
        DEBUG_TODO = new AIONotificationBusiId("DEBUG_TODO", 2, 2, "debug_todo");
        DEBUG_APPLICATION = new AIONotificationBusiId("DEBUG_APPLICATION", 3, 3, "debug_application");
        NET_STATE = new AIONotificationBusiId("NET_STATE", 4, 4, "net_state");
        AIO_MONITOR = new AIONotificationBusiId("AIO_MONITOR", 5, 5, "aio_monitor");
        TROOP_ANNOUNCEMENT = new AIONotificationBusiId("TROOP_ANNOUNCEMENT", 6, 30001, "troop_announcement");
        AUDIO_VIDEO_CHAT = new AIONotificationBusiId("AUDIO_VIDEO_CHAT", 7, 20001, "av_chat");
        TROOP_CLASS = new AIONotificationBusiId("TROOP_CLASS", 8, 10003, "troop_class");
        SHARE_SCREEN = new AIONotificationBusiId("SHARE_SCREEN", 9, 10004, "share_screen");
        SHARE_LOCATION = new AIONotificationBusiId("SHARE_LOCATION", 10, 10005, QQPermissionConstants.Business.SCENE.SHARE_LOCATION);
        TROOP_LIVE = new AIONotificationBusiId("TROOP_LIVE", 11, 10006, "troop_live");
        LISTEN_MUSIC_TOGETHER = new AIONotificationBusiId("LISTEN_MUSIC_TOGETHER", 12, 10007, "listen_music_together");
        FRAUD = new AIONotificationBusiId("FRAUD", 13, 10008, "fraud");
        TROOP_OWNER_TASK = new AIONotificationBusiId("TROOP_OWNER_TASK", 14, 30002, "troop_owner_task");
        TROOP_OWNER_MSG = new AIONotificationBusiId("TROOP_OWNER_MSG", 15, 30003, "troop_owner_msg");
        HOMEWORK_TROOP_MSG = new AIONotificationBusiId("HOMEWORK_TROOP_MSG", 16, 30004, "hw_troop_msg");
        HOMEWORK_TROOP_IDENTIFY_GUIDE = new AIONotificationBusiId("HOMEWORK_TROOP_IDENTIFY_GUIDE", 17, 30005, "hw_troop_id_guide");
        HOMEWORK_TROOP_CLASSINFO = new AIONotificationBusiId("HOMEWORK_TROOP_CLASSINFO", 18, 30006, "hw_troop_classinfo");
        TROOP_ASSIST_TIPS = new AIONotificationBusiId("TROOP_ASSIST_TIPS", 19, 30007, "troop_assist");
        TROOP_TODO = new AIONotificationBusiId("TROOP_TODO", 20, 20002, "troop_todo");
        TROOP_HW_NOTICE = new AIONotificationBusiId("TROOP_HW_NOTICE", 21, 20003, "troop_hw_notice");
        TROOP_HW_CLOCK_IN = new AIONotificationBusiId("TROOP_HW_CLOCK_IN", 22, 20004, "troop_hw_clock_in");
        UPGRADE_BIG_TROOP = new AIONotificationBusiId("UPGRADE_BIG_TROOP", 23, BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT, "upgrade_big_troop");
        UPGRADE_BIG_TROOP_EXPIRED = new AIONotificationBusiId("UPGRADE_BIG_TROOP_EXPIRED", 24, BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY, "upgrade_big_troop_expired");
        TROOP_JOIN_GUILD = new AIONotificationBusiId("TROOP_JOIN_GUILD", 25, BaseConstants.ERR_SVR_FRIENDSHIP_COUNT_LIMIT, "troop_join_guild");
        NEARBY_ADD_FRIEND = new AIONotificationBusiId("NEARBY_ADD_FRIEND", 26, BaseConstants.ERR_SVR_FRIENDSHIP_GROUP_COUNT_LIMIT, "nearby_add_friend");
        GAME_MSG = new AIONotificationBusiId("GAME_MSG", 27, 10009, AppConstants.Key.KEY_GAME_MSG);
        ARK_TIP = new AIONotificationBusiId("ARK_TIP", 28, BaseConstants.ERR_SVR_FRIENDSHIP_PENDENCY_LIMIT, "ark_tip");
        TROOP_GROUP_ALBUM = new AIONotificationBusiId("TROOP_GROUP_ALBUM", 29, BaseConstants.ERR_SVR_FRIENDSHIP_BLACKLIST_LIMIT, "troop_group_album");
        TROOP_GAME_TEAM = new AIONotificationBusiId("TROOP_GAME_TEAM", 30, 10010, "troop_game_team");
        TROOP_GAME_JOIN = new AIONotificationBusiId("TROOP_GAME_JOIN", 31, 10011, "troop_game_join");
        TROOP_META_DREAM_TEAM = new AIONotificationBusiId("TROOP_META_DREAM_TEAM", 32, 10012, "troop_meta_dream_team");
        TROOP_ASSIGN_HW_NOTIFY_BAR = new AIONotificationBusiId("TROOP_ASSIGN_HW_NOTIFY_BAR", 33, BaseConstants.ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT, "troop_assign_homework_notify");
        TROOP_WANGZHE_REPORT = new AIONotificationBusiId("TROOP_WANGZHE_REPORT", 34, 30015, "troop_wangzhe_report");
        TROOP_TEAM_UP = new AIONotificationBusiId("TROOP_TEAM_UP", 35, 30016, "troop_team_up");
        TROOP_META_DREAM_FARM = new AIONotificationBusiId("TROOP_META_DREAM_FARM", 36, 30017, "troop_meta_dream_farm");
        $VALUES = $values();
    }

    AIONotificationBusiId(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        } else {
            this.id = i16;
            this.tag = str2;
        }
    }

    public static AIONotificationBusiId valueOf(String str) {
        return (AIONotificationBusiId) Enum.valueOf(AIONotificationBusiId.class, str);
    }

    public static AIONotificationBusiId[] values() {
        return (AIONotificationBusiId[]) $VALUES.clone();
    }

    public final int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.id;
    }

    @NotNull
    public final String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tag;
    }
}
