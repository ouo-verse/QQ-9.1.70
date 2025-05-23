package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Constants {
    public static final byte AUDIO_INPUT_CONTROL = 5;
    public static final int BINARY_PERF_STATS = -126;
    public static final byte CHANNEL_DATATYPE_CLIENT_CONFIG = 2;
    public static final byte CHANNEL_DATATYPE_CONNECTION_NOTIFICATION = 3;
    public static final byte CHANNEL_DATATYPE_NETWORK_BANDWIDTH = 109;
    public static final byte CHANNEL_DATATYPE_PONG = 5;
    public static final int CONNECTION_STATE_NOTIFICATION = 107;
    public static final byte GPS_INPUT_CONTROL = 6;
    public static final byte INPUT_METHOD = 10;
    public static final int INVALID_KEY_CODE = -1;
    public static final int INVALID_KEY_ID = -1;
    public static final byte NOTIFICATION_BACKGROUND_PUSH_STREAM = 110;
    public static final byte PACKET_LOSS_EFFECT_STATIS = 125;
    public static final byte PASS_THROUGH = 8;
    public static final byte PHOTO_DOWNLOAD = 7;
    public static final byte PHOTO_OPEN_TOKEN0 = 9;
    public static final byte PHOTO_OPEN_TOKEN1 = 9;
    public static final byte PRIVILEGE_NOTIFICATION = 11;
    public static final byte SDK_SEND_CHANNEL_DATA_COMMON_TYPE = Byte.MAX_VALUE;
    public static final byte SDK_SEND_CHANNEL_DATA_COMMON_TYPE_CMD_SEI = 4;
    public static final byte SDK_SEND_CHANNEL_DATA_COMMON_TYPE_CMD_SESSION_INFO = 3;
    public static final byte SDK_SEND_CHANNEL_DATA_PING_TYPE = Byte.MIN_VALUE;
    public static final byte SDK_SEND_CHANNEL_DATA_TYPE = 108;
    public static final byte SEND_CHANNEL_LATENCY = 91;
    public static final byte SEND_CHANNEL_PING_TYPE = 4;
    public static final byte TV_SCENES_MONITOR = 12;
    public static final byte VIRTUAL_GAMEPAD_PARAMS_RESP = 98;
    public static final byte VIRTUAL_GAMEPAD_SDK_DATA = 96;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface CanvasSource {
        public static final int CANVAS_SOURCE_CLIENT = 2;
        public static final int CANVAS_SOURCE_NONE = 0;
        public static final int CANVAS_SOURCE_SDK = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface GamePadConfigValueType {
        public static final int CONFIG_KEY_TRACK = 2;
        public static final int CONFIG_MONITOR_ENABLE = 1;
        public static final int CONFIG_NONE = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface GameType {
        public static final int GAME_TYPE_GAMEPAD = 4;
        public static final int GAME_TYPE_GAMEPAD_TOUCHSCREEN_MIXED = 16;
        public static final int GAME_TYPE_NONE = 1;
        public static final int GAME_TYPE_TOUCHSCREEN = 2;
        public static final int GAME_TYPE_TVCONTROLLER = 8;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface GameTypeBit {
        public static final int GAME_TYPE_BIT_GAMEPAD = 2;
        public static final int GAME_TYPE_BIT_GAMEPAD_MIXED = 4;
        public static final int GAME_TYPE_BIT_NONE = 0;
        public static final int GAME_TYPE_BIT_TOUCHSCREEN = 1;
        public static final int GAME_TYPE_BIT_TVCONTROLLER = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InputDeviceState {
        public static final int INPUTDEVICE_ADDED = 1;
        public static final int INPUTDEVICE_CHANGED = 3;
        public static final int INPUTDEVICE_REMOVED = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InputDeviceType {
        public static final int INPUT_DEVICE_ALL = 1;
        public static final int INPUT_DEVICE_ALL_GAMEPAD = 5;
        public static final int INPUT_DEVICE_GAMEPAD = 2;
        public static final int INPUT_DEVICE_MFGAMEPAD = 4;
        public static final int INPUT_DEVICE_NONE = 0;
        public static final int INPUT_DEVICE_TV_CONTROLLER = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InputNotifyEventClass {
        public static final int NONE = 0;
        public static final int USB_HID_GAMEPAD = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InputNotifyEventType {
        public static final int NONE = 0;
        public static final int USB_HID_ERROR = 2;
        public static final int USB_HID_EVENT = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InputNotifyEventValue {
        public static final int NONE = 0;
        public static final int USB_HID_ERROR_IO = 101;
        public static final int USB_HID_ERROR_READ_EXCEPTION = 100;
        public static final int USB_HID_EVENT_CLOSED = 3;
        public static final int USB_HID_EVENT_CONNECTED = 2;
        public static final int USB_HID_EVENT_OPENED = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyMapConfingItemType {
        public static final int TYPE_DPAD = 3;
        public static final int TYPE_JOYSTICK_L = 1;
        public static final int TYPE_JOYSTICK_R = 2;
        public static final int TYPE_KEY_BUTTON = 4;
        public static final int TYPE_KEY_DRAG_BUTTON = 7;
        public static final int TYPE_KEY_JOY_MOVE = 9;
        public static final int TYPE_KEY_RESERVED1 = 11;
        public static final int TYPE_KEY_RESERVED2 = 12;
        public static final int TYPE_KEY_RESERVED3 = 13;
        public static final int TYPE_KEY_RESERVED4 = 14;
        public static final int TYPE_KEY_VIEW_PORT = 8;
        public static final int TYPE_LOL_JOY_KEY_R = 10;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_PUBG_JOYSTICK_L = 6;
        public static final int TYPE_SGAME_JOYSTICK_R = 5;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyMapConfingType {
        public static final int CONFIG_CHOOSE_WINDOW = 4;
        public static final int CONFIG_JOYSTICK = 1;
        public static final int CONFIG_JOY_KEY_CANCEL = 6;
        public static final int CONFIG_KEY_BUTTON = 2;
        public static final int CONFIG_KEY_MOVE = 5;
        public static final int CONFIG_NONE = 0;
        public static final int CONFIG_TOUCH_BUTTON = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyMapMode {
        public static final int KEYMAP_MODE_EDITKEY = 2;
        public static final int KEYMAP_MODE_GAMEPAD_SWITCH = 7;
        public static final int KEYMAP_MODE_KEYMAP = 1;
        public static final int KEYMAP_MODE_MENU = 4;
        public static final int KEYMAP_MODE_MOUSE = 3;
        public static final int KEYMAP_MODE_NATIVE = 5;
        public static final int KEYMAP_MODE_NONE = 0;
        public static final int KEYMAP_MODE_TOUCHPAD = 6;
        public static final int KEYMAP_MODE_TV_KEYMAP = 11;
        public static final int KEYMAP_MODE_TV_KEY_COMBINATION = 12;
        public static final int KEYMAP_MODE_TV_MOUSE = 8;
        public static final int KEYMAP_MODE_TV_SWITCH = 10;
        public static final int KEYMAP_MODE_VGAMEPAD = 9;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyMapResourceType {
        public static final int KEY_MAP_RESOURCE_GAMEPAD = 1;
        public static final int KEY_MAP_RESOURCE_MFGAMEPAD = 2;
        public static final int KEY_MAP_RESOURCE_NONE = 0;
        public static final int KEY_MAP_RESOURCE_TVCONTROLLER = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyMapSource {
        public static final int KEYMAP_SOURCE_CLIENT = 5;
        public static final int KEYMAP_SOURCE_CONFIG_LOADED = 2;
        public static final int KEYMAP_SOURCE_FIRST_FRAME = 1;
        public static final int KEYMAP_SOURCE_FUNCTION_MENU = 11;
        public static final int KEYMAP_SOURCE_GAMEPAD_SWITCH = 3;
        public static final int KEYMAP_SOURCE_KEY_COMBIN = 12;
        public static final int KEYMAP_SOURCE_MFGAMEPAD_ADDED = 10;
        public static final int KEYMAP_SOURCE_NONE = 0;
        public static final int KEYMAP_SOURCE_SCENE_0 = 6;
        public static final int KEYMAP_SOURCE_SCENE_1 = 7;
        public static final int KEYMAP_SOURCE_SCENE_2 = 8;
        public static final int KEYMAP_SOURCE_TV_CONTROLLER_SWITCH = 4;
        public static final int KEYMAP_SOURCE_VGAMEPAD_CONNECTED = 9;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface KeyMapType {
        public static final int KEY_MAP_TYPE_GAMEPAD = 1;
        public static final int KEY_MAP_TYPE_NONE = 0;
        public static final int KEY_MAP_TYPE_TOUCHSCREEN = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface MapType {
        public static final int MAP_TYPE_CHOOSE_WINDOW = 5;
        public static final int MAP_TYPE_CONTROLLER_TO_GAMEPAD = 4;
        public static final int MAP_TYPE_GAMEPAD = 1;
        public static final int MAP_TYPE_KEY_COMBINATION = 6;
        public static final int MAP_TYPE_MULTIFUNCTION_GAMEPAD = 3;
        public static final int MAP_TYPE_NONE = 0;
        public static final int MAP_TYPE_TVCONTROLLER = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface VirtualGamepadMsgStatus {
        public static final int VGAMEPAD_MESSAGE_STATUS_EXCEPTION = 3;
        public static final int VGAMEPAD_MESSAGE_STATUS_INVALID_LENGTH = 2;
        public static final int VGAMEPAD_MESSAGE_STATUS_NONE = 0;
        public static final int VGAMEPAD_MESSAGE_STATUS_SUCCESS = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface VirtualGamepadMsgType {
        public static final int MSG_VIRTUAL_GAMEPAD_BACKGROUND = 5;
        public static final int MSG_VIRTUAL_GAMEPAD_CONNECTED = 2;
        public static final int MSG_VIRTUAL_GAMEPAD_DISCONNECTED = 4;
        public static final int MSG_VIRTUAL_GAMEPAD_EXIT = 7;
        public static final int MSG_VIRTUAL_GAMEPAD_FOREGROUND = 6;
        public static final int MSG_VIRTUAL_GAMEPAD_NONE = 0;
        public static final int MSG_VIRTUAL_GAMEPAD_PARAMS = 1;
        public static final int MSG_VIRTUAL_GAMEPAD_PAY_BL = 8;
        public static final int MSG_VIRTUAL_GAMEPAD_QUALITY = 3;
    }
}
