package com.tencent.avcore.jni.audiodevice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TraeConstants {
    static IPatchRedirector $redirector_ = null;
    public static final int AV_AUDIO_SCENE_VOICE_CHAT = 0;
    public static final int AV_AUDIO_SCENE_VOICE_CHAT_GAME_MODE = 5;
    public static final int AV_AUDIO_SCENE_VOICE_CHAT_GAME_MODE_ONLY_PLAY = 6;
    public static final int CALL_PREPROCESS = -1030;
    public static final String DEVICE_BLUETOOTH_HEADSET = "DEVICE_BLUETOOTH_HEADSET";
    public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
    public static final String DEVICE_NONE = "DEVICE_NONE";
    public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
    public static final String DEVICE_WIRED_HEADSET = "DEVICE_WIRED_HEADSET";
    public static final String EXTRA_CONNECT_DEVICE_NAME = "EXTRA_CONNECT_DEVICE_NAME";
    public static final String EXTRA_DATA_ACTIVE_MODE = "EXTRA_DATA_ACTIVE_MODE";
    public static final String EXTRA_DATA_BLUETOOTH_NAME = "EXTRA_DATA_BLUETOOTH_NAME";
    public static final String EXTRA_DATA_CHANGEABLE_STATE = "EXTRA_DATA_CHANGEABLE_STATE";
    public static final String EXTRA_DATA_CONNECTED_DEVICE = "EXTRA_DATA_CONNECTED_DEVICE";
    public static final String EXTRA_DATA_CONNECTED_DEVICE_NAME = "EXTRA_DATA_CONNECTED_DEVICE_NAME";
    public static final String EXTRA_DATA_PREV_CONNECTED_DEVICE = "EXTRA_DATA_PREV_CONNECTED_DEVICE";
    public static final String EXTRA_DATA_SERVICE_STATE = "EXTRA_DATA_SERVICE_STATE";
    public static final String EXTRA_DATA_STREAM_TYPE = "EXTRA_DATA_STREAM_TYPE";
    public static final String EXTRA_DATA_VISIBLE_DEVICE_LIST = "EXTRA_DATA_VISIBLE_DEVICE_LIST";
    public static final String EXTRA_RES_ERROR_CODE = "EXTRA_RES_ERROR_CODE";
    public static final String KEY_OPERATION = "KEY_OPERATION";
    public static final String KEY_SESSION_ID = "KEY_SESSION_ID";
    public static final String OPERATION_CONNECT_DEVICE = "OPERATION_CONNECT_DEVICE";
    public static final String OPERATION_GET_CONNECTED_DEVICE = "OPERATION_GET_CONNECTED_DEVICE";
    public static final String OPERATION_GET_DEVICE_LIST = "OPERATION_GET_DEVICE_LIST";
    public static final String OPERATION_GET_STREAM_TYPE = "OPERATION_GET_STREAM_TYPE";
    public static final String OPERATION_VOICE_CALL_PRE_PROCESS = "OPERATION_VOICE_CALL_PRE_PROCESS";
    public static final String PARAM_ACTIVE_MODE = "PARAM_SET_ACTIVE_MODE";
    public static final String PARAM_AUDIO_SCENE = "PARAM_AUDIO_SCENE";
    public static final String PARAM_CONNECT_DEVICE_WHEN_START_SERVICE = "PARAM_CONNECT_DEVICE_WHEN_START_SERVICE";
    public static final String PARAM_DEVICE_CONFIG = "PARAM_DEVICE_CONFIG";
    public static final String PARAM_DEVICE_NAME = "PARAM_DEVICE_NAME";
    public static final String PARAM_FORCE_SWITCH_DEVICE = "PARAM_FORCE_SWITCH_DEVICE";
    public static final String PARAM_IS_ALLOWED_USE_BLUETOOTH = "PARAM_IS_ALLOWED_USE_BLUETOOTH";
    public static final String PARAM_MODE_POLICY = "PARAM_MODE_POLICY";
    public static final String PARAM_RING_DATA_SOURCE = "PARAM_RING_DATA_SOURCE";
    public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
    public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
    public static final String PARAM_RING_LOOP_COUNT = "PARAM_RING_LOOP_COUNT";
    public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
    public static final String PARAM_RING_RESOURCE_ID = "PARAM_RING_RESOURCE_ID";
    public static final String PARAM_RING_URI = "PARAM_RING_URI";
    public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
    public static final String PARAM_STREAM_TYPE = "PARAM_STREAM_TYPE";
    public static final int RES_ERROR_CODE_DEVICE_BT_CONNECTED_TIMEOUT = 7;
    public static final int RES_ERROR_CODE_DEVICE_NOT_VISIBLE = 5;
    public static final int RES_ERROR_CODE_DEVICE_UNCHANGEABLE = 6;
    public static final int RES_ERROR_CODE_DEVICE_UNKNOWN = 4;
    public static final int RES_ERROR_CODE_NONE = 0;
    public static final int RES_ERROR_CODE_SERVICE_OFF = 1;
    public static final int RES_ERROR_CODE_VOICE_CALL_EXIST = 2;
    public static final int RES_ERROR_CODE_VOICE_CALL_POST_INTERRUPT = 3;
    public static final String VIDEO_CALL_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
    public static final String VIDEO_CALL_CONFIG_WITHOUT_BLUETOOTH = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_WIRED_HEADSET;";
    public static final String VOICE_CALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
    public static final String VOICE_CALL_CONFIG_WITHOUT_BLUETOOTH = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_WIRED_HEADSET;";

    public TraeConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
