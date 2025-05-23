package com.tencent.mobileqq.qqlive.data.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveCommonDef {
    static IPatchRedirector $redirector_ = null;
    public static final int LIVE_ROOM_CLOSE = 0;
    public static final int LIVE_ROOM_CONTINUE = 5;
    public static final int LIVE_ROOM_OPEN = 1;
    public static final int LIVE_ROOM_PAUSE = 2;
    public static final int LIVE_ROOM_RESUME = 3;
    public static final int LIVE_ROOM_WAITE = 4;
    public static final int RTC_ENGINE_INIT_RESULT_CODE_ERROR = -1;
    public static final int RTC_ENGINE_INIT_RESULT_CODE_SUCCESS = 0;
    public static final int RTC_ENGINE_INIT_RESULT_CODE_SYSTEM_VERSION_NOT_SUPPORT = -2;
    public static final int RTC_ENGINE_STATE_INITING = 1;
    public static final int RTC_ENGINE_STATE_INIT_FAILED = 3;
    public static final int RTC_ENGINE_STATE_INIT_SUCCESS = 2;
    public static final int RTC_ENGINE_STATE_NOT_INIT = 0;
    public static final int RTC_EXIT_ROOM_BY_DISMISS = 2;
    public static final int RTC_EXIT_ROOM_BY_SERVER = 1;
    public static final int RTC_EXIT_ROOM_BY_USER = 0;
    public static final int RTC_RESOLUTION_LEVEL_1280_720 = 3;
    public static final int RTC_RESOLUTION_LEVEL_1920_1080 = 4;
    public static final int RTC_RESOLUTION_LEVEL_480_270 = 0;
    public static final int RTC_RESOLUTION_LEVEL_640_360 = 1;
    public static final int RTC_RESOLUTION_LEVEL_960_540 = 2;
    public static final int RTC_RESOLUTION_MODE_LANDSCAPE = 0;
    public static final int RTC_RESOLUTION_MODE_PORTRAIT = 1;
    public static final int RTC_ROLE_TYPE_ANCHOR = 0;
    public static final int RTC_ROLE_TYPE_AUDIENCE = 1;
    public static final int RTC_ROOM_EVENT_CONNECTION_LOST = 1002;
    public static final int RTC_ROOM_EVENT_CONNECTION_RECOVERY = 1004;
    public static final int RTC_ROOM_EVENT_ERROR = 1000;
    public static final int RTC_ROOM_EVENT_TRY_RECONNECTION = 1003;
    public static final int RTC_ROOM_EVENT_WARNING = 1001;
    public static final int RTC_ROOM_STATE_ANCHOR_PKING = 3;
    public static final int RTC_ROOM_STATE_ANCHOR_PUSHING = 1;
    public static final int RTC_ROOM_STATE_AUDIENCE_PLAYING = 2;
    public static final int RTC_ROOM_STATE_NOT_INIT = 0;
    public static final int RTC_SCENE_AUDIO_CALL = 2;
    public static final int RTC_SCENE_LIVE = 1;
    public static final int RTC_SCENE_VIDEO_CALL = 0;
    public static final int RTC_SCENE_VOICE_CHAT_ROOM = 3;
    public static final int RTC_VIDEO_STREAM_TYPE_BIG = 0;
    public static final int RTC_VIDEO_STREAM_TYPE_SMALL = 1;
    public static final int RTC_VIDEO_STREAM_TYPE_SUB = 2;
    public static final int TRTC_MUTE_BITMAP_DEFAULT_FPS = 10;
    public static final int TRTC_MUTE_BITMAP_MAX_FPS = 20;
    public static final int TRTC_MUTE_BITMAP_MIN_FPS = 5;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public @interface AudienceRoomStatus {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCEngineInitResultCode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCEngineState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCExitRoomReason {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCResolutionLevel {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCResolutionMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCRoleType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCRoomEventID {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCRoomState {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCScene {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCVideoStreamType {
    }

    public QQLiveCommonDef() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
