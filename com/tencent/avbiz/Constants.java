package com.tencent.avbiz;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface Constants {
    public static final IPatchRedirector $redirector_ = null;
    public static final HashSet<String> AUDIO_PLAYER_BUSINESS;
    public static final HashSet<String> AUDIO_RTC_BUSINESS;
    public static final HashMap<String, Set<String>> PROCESS_BIZ_NAME_MAP;
    public static final HashMap<String, Long> REQUEST_DEVICE_MAP;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Action {
        public static final String ABANDON_AV_FOCUS = "abandon_av_focus";
        public static final String CHECK_AV_FOCUS = "check_av_focus";
        public static final String GET_FOCUS_BUSINESS = "get_focus_business";
        public static final String GET_IN_QUEUE_BUSINESS = "get_in_queue_business";
        public static final String NOTIFY_FOCUS_GAIN = "notify_focus_gain";
        public static final String NOTIFY_FOCUS_LOSS = "notify_focus_loss";
        public static final String REQUEST_AV_FOCUS = "request_av_focus";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Business {
        public static final IPatchRedirector $redirector_ = null;
        public static final String AV_GAME = "\u4e00\u8d77\u6d3e\u5bf9";
        public static final String DEFAULT = "\u9ed8\u8ba4";
        public static final String DEFAULT_AUDIO = "\u9ed8\u8ba4\u97f3\u9891";
        public static final String DEFAULT_CAMERA = "\u9ed8\u8ba4\u76f8\u673a";
        public static final String LISTEN_TOGETHER = "\u4e00\u8d77\u542c\u6b4c";
        public static final String MATCH_FRIEND = "\u8bed\u97f3\u8fde\u9ea6";
        public static final HashSet<String> NAME;
        public static final String PARTY_HOUSE = "\u6d3e\u5bf9\u623f\u95f4";
        public static final String PTT = "ptt";
        public static final String QQCIRCLE = "\u77ed\u89c6\u9891";
        public static final String QQCIRCLE_MUSIC = "\u77ed\u89c6\u9891\u97f3\u4e50";
        public static final String QQ_CIRCLE_WINDOW = "\u77ed\u89c6\u9891\u6d6e\u7a97";
        public static final String QQ_CIRCLE_WINK_PREVIEW = "\u53d1\u5e03\u9884\u89c8";
        public static final String QQ_FILE_PREVIEW = "QQ\u6587\u4ef6\u9884\u89c8";
        public static final String QQ_GUILD = "\u9891\u9053\u901a\u8bdd";
        public static final String QQ_GUILD_KARAOKE = "K\u6b4c\u9891\u9053";
        public static final String QQ_GUILD_LIVE_AUTHOR = "\u9891\u9053\u76f4\u64ad";
        public static final String QQ_GUILD_LIVE_VIEWER = "\u9891\u9053\u89c2\u770b\u76f4\u64ad";
        public static final String QQ_HEALTH = "\u8fd0\u52a8";
        public static final String QQ_ICGAME = "\u4e92\u52a8\u4e91\u73a9\u6cd5";
        public static final String QQ_ILIVE = "QQ\u76f4\u64ad";
        public static final String QQ_LAYER = "\u6d6e\u5c42\u64ad\u653e";
        public static final String QQ_META_ROOM = "\u4e16\u754c\u5b50\u9891\u9053";
        public static final String QQ_RTC = "\u97f3\u89c6\u9891\u901a\u8bdd";
        public static final String QQ_SMALL_HOME = "QQ\u5c0f\u7a9d";
        public static final String QQ_STUDY_ROOM = "\u81ea\u4e60\u5ba4";
        public static final String QQ_WEISHI_VIDEO = "\u5fae\u89c6\u89c6\u9891";
        public static final String QQ_ZPLAN = "\u5c0f\u7a9d\u8bed\u97f3\u901a\u8bdd";
        public static final String READINJOY = "\u770b\u70b9";
        public static final String SMART_DEVICE = "\u7269\u8054\u8bbe\u5907";
        public static final String SYSTEM_PHONE = "\u7cfb\u7edf\u901a\u8bdd";
        public static final String TIMI_GAME = "\u6e38\u620f\u7ec4\u961f";
        public static final String TIMI_YOLO = "\u6709\u4e50\u9891\u9053";
        public static final String VOICE_ASSISTANT = "voice_assistant";

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38265), (Class<?>) Business.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                NAME = new HashSet<>(Arrays.asList(DEFAULT, DEFAULT_CAMERA, DEFAULT_AUDIO, SYSTEM_PHONE, QQ_RTC, AV_GAME, "ptt", LISTEN_TOGETHER, VOICE_ASSISTANT, "QQ\u76f4\u64ad", QQ_STUDY_ROOM, READINJOY, QQ_HEALTH, SMART_DEVICE, QQCIRCLE, QQ_GUILD, QQ_META_ROOM, QQ_GUILD_LIVE_AUTHOR, QQ_GUILD_LIVE_VIEWER, TIMI_GAME, TIMI_YOLO, PARTY_HOUSE, MATCH_FRIEND, QQ_GUILD_KARAOKE, QQ_ZPLAN, "QQ\u5c0f\u7a9d", "\u4e92\u52a8\u4e91\u73a9\u6cd5", QQ_LAYER, QQ_CIRCLE_WINDOW, QQCIRCLE_MUSIC, QQ_FILE_PREVIEW, QQ_CIRCLE_WINK_PREVIEW, QQ_WEISHI_VIDEO));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Key {
        public static final String CHECK_FOCUS_RESULT = "check_focus_result";
        public static final String GET_FOCUS_BIZ_RESULT = "get_focus_biz_result";
        public static final String GET_IN_QUEUE_BIZ_RESULT = "get_in_queue_biz_result";
        public static final String MODULE_NAME = "module_name";
        public static final String PROCESS_NAME = "process_name";
        public static final String REQUEST_FOCUS_RESULT = "request_focus_result";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Priority {
        public static final IPatchRedirector $redirector_ = null;
        public static final List<HashSet<String>> AUDIO_PRIORITY_LIST;
        public static final HashSet<String> AUDIO_SET_SECOND_LEVEL;
        public static final HashSet<String> AUDIO_SET_THIRD_LEVEL;
        public static final HashSet<String> AUDIO_SET_TOP_LEVEL;
        public static final HashSet<String> AUDIO_SYSTEM_LEVEL;
        public static final List<HashSet<String>> CAMERA_PRIORITY_LIST;
        public static final HashSet<String> CAMERA_SET_TOP_LEVEL;
        public static final HashMap<Long, List<HashSet<String>>> PRIORITY_MAP;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38300), (Class<?>) Priority.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
                return;
            }
            HashSet<String> hashSet = new HashSet<>(Arrays.asList(Business.SYSTEM_PHONE));
            AUDIO_SYSTEM_LEVEL = hashSet;
            HashSet<String> hashSet2 = new HashSet<>(Arrays.asList(Business.QQ_RTC, Business.AV_GAME, Business.QQ_STUDY_ROOM, Business.SMART_DEVICE, Business.QQ_GUILD, Business.QQ_GUILD_LIVE_AUTHOR, Business.QQ_GUILD_LIVE_VIEWER, Business.TIMI_GAME, Business.TIMI_YOLO, Business.PARTY_HOUSE, Business.MATCH_FRIEND, Business.QQ_GUILD_KARAOKE, Business.QQ_META_ROOM, Business.QQ_ZPLAN, Business.MATCH_FRIEND, Business.QQ_GUILD_KARAOKE, Business.QQ_META_ROOM, "QQ\u5c0f\u7a9d", "\u4e92\u52a8\u4e91\u73a9\u6cd5", Business.QQ_LAYER, Business.QQCIRCLE, Business.QQ_CIRCLE_WINDOW, "QQ\u76f4\u64ad", Business.QQCIRCLE_MUSIC, Business.QQ_FILE_PREVIEW, Business.QQ_CIRCLE_WINK_PREVIEW, Business.QQ_WEISHI_VIDEO));
            AUDIO_SET_TOP_LEVEL = hashSet2;
            HashSet<String> hashSet3 = new HashSet<>(Arrays.asList("ptt", Business.LISTEN_TOGETHER, Business.READINJOY, Business.QQCIRCLE, Business.QQ_CIRCLE_WINDOW, "QQ\u76f4\u64ad", Business.QQCIRCLE_MUSIC, Business.QQ_LAYER, Business.QQ_FILE_PREVIEW, Business.QQ_CIRCLE_WINK_PREVIEW, Business.QQ_WEISHI_VIDEO));
            AUDIO_SET_SECOND_LEVEL = hashSet3;
            HashSet<String> hashSet4 = new HashSet<>(Arrays.asList(Business.VOICE_ASSISTANT, "QQ\u76f4\u64ad", Business.QQ_HEALTH));
            AUDIO_SET_THIRD_LEVEL = hashSet4;
            AUDIO_PRIORITY_LIST = new ArrayList(Arrays.asList(hashSet, hashSet2, hashSet3, hashSet4));
            HashSet<String> hashSet5 = new HashSet<>(Arrays.asList(Business.QQ_RTC, Business.AV_GAME, Business.QQ_STUDY_ROOM, Business.SMART_DEVICE, Business.QQCIRCLE));
            CAMERA_SET_TOP_LEVEL = hashSet5;
            CAMERA_PRIORITY_LIST = new ArrayList(Arrays.asList(hashSet5));
            PRIORITY_MAP = new HashMap<Long, List<HashSet<String>>>() { // from class: com.tencent.avbiz.Constants.Priority.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    } else {
                        put(1L, Priority.AUDIO_PRIORITY_LIST);
                        put(2L, Priority.CAMERA_PRIORITY_LIST);
                    }
                }
            };
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Process {
        public static final String MAIN_PROCESS = "com.tencent.mobileqq";
        public static final String MATCH_FRIEND_PROCESS = "com.tencent.mobileqq:qqstranger";
        public static final String QQ_GUILD_AV_PROCESS = "com.tencent.mobileqq:guild_audio";
        public static final String QQ_GUILD_LIVE_PROCESS = "com.tencent.mobileqq";
        public static final String QQ_STUDY_ROOM_PROCESS = "com.tencent.mobileqq:live";
        public static final String QQ_TOOL_PROCESS = "com.tencent.mobileqq:tool";
        public static final String QQ_ZPLAN_PROCESS = "com.tencent.mobileqq:zplan";
        public static final String VIDEO_PROCESS = "com.tencent.mobileqq:video";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface RequestType {
        public static final long TYPE_ALL = 3;
        public static final long TYPE_AUDIO = 1;
        public static final long TYPE_CAMERA = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Result {
        public static final String EMPTY_BUNDLE = "IPC\u8c03\u7528\u51fa\u9519\uff0c\u8fd4\u56de\u6570\u636e\u4e3a\u7a7a";
        public static final String FOCUS_SUCCESS = "true";
        public static final String UNKNOWN_BUSINESS = "\u672a\u77e5\u7684\u4e1a\u52a1";
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(38316), (Class<?>) Constants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        REQUEST_DEVICE_MAP = new HashMap<String, Long>() { // from class: com.tencent.avbiz.Constants.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                put(Business.SYSTEM_PHONE, 1L);
                put(Business.QQ_RTC, 3L);
                put(Business.AV_GAME, 3L);
                put("ptt", 1L);
                put(Business.LISTEN_TOGETHER, 1L);
                put(Business.VOICE_ASSISTANT, 1L);
                put("QQ\u76f4\u64ad", 1L);
                put(Business.QQ_STUDY_ROOM, 3L);
                put(Business.READINJOY, 1L);
                put(Business.QQ_HEALTH, 3L);
                put(Business.SMART_DEVICE, 3L);
                put(Business.QQCIRCLE, 1L);
                put(Business.QQ_GUILD, 1L);
                put(Business.QQ_META_ROOM, 1L);
                put(Business.QQ_GUILD_LIVE_AUTHOR, 1L);
                put(Business.QQ_GUILD_LIVE_VIEWER, 1L);
                put(Business.TIMI_GAME, 1L);
                put(Business.TIMI_YOLO, 1L);
                put(Business.PARTY_HOUSE, 1L);
                put(Business.MATCH_FRIEND, 1L);
                put(Business.QQ_GUILD_KARAOKE, 1L);
                put(Business.QQ_ZPLAN, 1L);
                put("QQ\u5c0f\u7a9d", 1L);
                put("\u4e92\u52a8\u4e91\u73a9\u6cd5", 1L);
                put(Business.QQ_LAYER, 1L);
                put(Business.QQ_CIRCLE_WINDOW, 1L);
                put(Business.QQ_FILE_PREVIEW, 1L);
                put(Business.QQ_CIRCLE_WINK_PREVIEW, 1L);
                put(Business.QQ_WEISHI_VIDEO, 1L);
            }
        };
        PROCESS_BIZ_NAME_MAP = new HashMap<String, Set<String>>() { // from class: com.tencent.avbiz.Constants.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                put(Process.VIDEO_PROCESS, new HashSet(Arrays.asList(Business.QQ_RTC)));
                put("com.tencent.mobileqq:tool", new HashSet(Arrays.asList("QQ\u76f4\u64ad", Business.QQ_HEALTH)));
                put(Process.QQ_STUDY_ROOM_PROCESS, new HashSet(Arrays.asList(Business.QQ_STUDY_ROOM)));
                put(Process.QQ_GUILD_AV_PROCESS, new HashSet(Arrays.asList(Business.QQ_GUILD)));
                put("com.tencent.mobileqq", new HashSet(Arrays.asList(Business.QQ_GUILD_LIVE_AUTHOR)));
                put("com.tencent.mobileqq", new HashSet(Arrays.asList(Business.QQ_GUILD_LIVE_VIEWER)));
                put(Process.MATCH_FRIEND_PROCESS, new HashSet(Arrays.asList(Business.MATCH_FRIEND)));
                put("com.tencent.mobileqq:zplan", new HashSet(Arrays.asList(Business.QQ_ZPLAN)));
                put("com.tencent.mobileqq:zplan", new HashSet(Arrays.asList("QQ\u5c0f\u7a9d")));
                put("com.tencent.mobileqq:tool", new HashSet(Arrays.asList("\u4e92\u52a8\u4e91\u73a9\u6cd5")));
            }
        };
        AUDIO_PLAYER_BUSINESS = new HashSet<String>() { // from class: com.tencent.avbiz.Constants.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    addAll(Priority.AUDIO_SET_SECOND_LEVEL);
                }
            }
        };
        AUDIO_RTC_BUSINESS = new HashSet<String>() { // from class: com.tencent.avbiz.Constants.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    addAll(Priority.AUDIO_SYSTEM_LEVEL);
                    addAll(Priority.AUDIO_SET_TOP_LEVEL);
                }
            }
        };
    }
}
