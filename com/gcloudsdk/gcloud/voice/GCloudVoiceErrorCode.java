package com.gcloudsdk.gcloud.voice;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudVoiceErrorCode {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class BluetoothState {
        public static final int SCO_CONNECTED = 1;
        public static final int SCO_CONNECTING = 1;
        public static final int SCO_DIS_CONNECTED = 0;
        public static final int SCO_ERROR = -1;
        public static final int SCO_STATED = 10;
        public static final int SCO_STOPED = 20;
        public static final int UNINITIALIZED = -100;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DeviceState {
        public static final int AUDIO_DEVICE_BLUETOOTH_CONNECCTED = 2;
        public static final int AUDIO_DEVICE_CONNECCTED = 3;
        public static final int AUDIO_DEVICE_UNCONNECTED = 0;
        public static final int AUDIO_DEVICE_WIREDHEADSET_CONNECCTED = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class GCloudVoiceCompleteCode {
        public static final int GV_ON_BUSINESS_NOT_FOUND = 4100;
        public static final int GV_ON_DATA_ERROR = 24578;
        public static final int GV_ON_DOWNLOAD_RECORD_DONE = 12295;
        public static final int GV_ON_DOWNLOAD_RECORD_ERROR = 12296;
        public static final int GV_ON_FAIL = 4101;
        public static final int GV_ON_INTERNAL_ERR = 4099;
        public static final int GV_ON_JOINROOM_RETRY_FAIL = 8197;
        public static final int GV_ON_JOINROOM_SUCC = 8193;
        public static final int GV_ON_JOINROOM_SVR_ERR = 8195;
        public static final int GV_ON_JOINROOM_TIMEOUT = 8194;
        public static final int GV_ON_JOINROOM_UNKNOWN = 8196;
        public static final int GV_ON_KEY_DELECTED = 24581;
        public static final int GV_ON_MAGICVOICE_FILE_FAIL = 53254;
        public static final int GV_ON_MAGICVOICE_FILE_SUCC = 53253;
        public static final int GV_ON_MAGICVOICE_SERVER_ERR = 53250;
        public static final int GV_ON_MAGICVOICE_SUCC = 53249;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_SUCC = 12289;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_SVR_ERR = 12291;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_TIMEOUT = 12290;
        public static final int GV_ON_MESSAGE_KEY_APPLIED_UNKNOWN = 12292;
        public static final int GV_ON_NET_ERR = 4097;
        public static final int GV_ON_NOT_PUNISHED = 24580;
        public static final int GV_ON_OK = 4096;
        public static final int GV_ON_PLAYFILE_DONE = 12297;
        public static final int GV_ON_PUNISHED = 24579;
        public static final int GV_ON_QUITROOM_SUCC = 8198;
        public static final int GV_ON_RECVMAGICVOICE_SERVER_ERR = 53252;
        public static final int GV_ON_RECVMAGICVOICE_SUCC = 53251;
        public static final int GV_ON_REPORT_SUCC = 24577;
        public static final int GV_ON_REPORT_SUCC_SELF = 24582;
        public static final int GV_ON_ROLE_MAX_AHCHOR = 8208;
        public static final int GV_ON_ROLE_NO_CHANGE = 8209;
        public static final int GV_ON_ROLE_SUCC = 8200;
        public static final int GV_ON_ROLE_SVR_ERROR = 8210;
        public static final int GV_ON_ROLE_TIMEOUT = 8201;
        public static final int GV_ON_ROOM_MEMBER_INROOM = 32769;
        public static final int GV_ON_ROOM_MEMBER_MICCLOSE = 32772;
        public static final int GV_ON_ROOM_MEMBER_MICOPEN = 32771;
        public static final int GV_ON_ROOM_MEMBER_OUTROOM = 32770;
        public static final int GV_ON_ROOM_OFFLINE = 8199;
        public static final int GV_ON_RSTT_APIERR = 20483;
        public static final int GV_ON_RSTT_RETRY = 20484;
        public static final int GV_ON_RSTT_SUCC = 20481;
        public static final int GV_ON_RSTT_TIMEOUT = 20482;
        public static final int GV_ON_SAVEDATA_SUCC = 28673;
        public static final int GV_ON_SHOULD_ONE_ROOM_ONE_SCENES = 4102;
        public static final int GV_ON_STT_APIERR = 16387;
        public static final int GV_ON_STT_SUCC = 16385;
        public static final int GV_ON_STT_TIMEOUT = 16386;
        public static final int GV_ON_ST_ALREADY_EXIST = 40965;
        public static final int GV_ON_ST_HTTP_ERROR = 40962;
        public static final int GV_ON_ST_INVALID_JSON = 40964;
        public static final int GV_ON_ST_RC_FAILED = 40966;
        public static final int GV_ON_ST_SERVER_ERROR = 40963;
        public static final int GV_ON_ST_SUCC = 40961;
        public static final int GV_ON_TRANSLATE_SERVER_ERR = 49154;
        public static final int GV_ON_TRANSLATE_SUCC = 49153;
        public static final int GV_ON_UNKNOWN = 4098;
        public static final int GV_ON_UPLOAD_RECORD_DONE = 12293;
        public static final int GV_ON_UPLOAD_RECORD_ERROR = 12294;
        public static final int GV_ON_UPLOAD_REPORT_INFO_ERROR = 36865;
        public static final int GV_ON_UPLOAD_REPORT_INFO_TIMEOUT = 36866;
        public static final int GV_ON_WX_ROOM_ERR = 45060;
        public static final int GV_ON_WX_ROOM_SUCC = 45059;
        public static final int GV_ON_WX_UPLOAD_ERR = 45058;
        public static final int GV_ON_WX_UPLOAD_SUCC = 45057;
        public static final int GV_ON_WX_USER_ERR = 45062;
        public static final int GV_ON_WX_USER_SUCC = 45061;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class GCloudVoiceErrno {
        public static final int GCLOUD_VOICE_ALREADY_IN_THE_ROOM = 8200;
        public static final int GCLOUD_VOICE_AUTHING = 12298;
        public static final int GCLOUD_VOICE_AUTHKEY_ERR = 12289;
        public static final int GCLOUD_VOICE_BADSERVER = 24577;
        public static final int GCLOUD_VOICE_CHANGE_ROLE = 32769;
        public static final int GCLOUD_VOICE_CHANGING_ROLE = 32770;
        public static final int GCLOUD_VOICE_COORDINATE = 36865;
        public static final int GCLOUD_VOICE_COORDINATE_ROOMNAME_ERROR = 36867;
        public static final int GCLOUD_VOICE_CREATE_ROOM_ERR = 8197;
        public static final int GCLOUD_VOICE_DOWNLOAD_ERR = 12295;
        public static final int GCLOUD_VOICE_ENGINE_ERR = 4106;
        public static final int GCLOUD_VOICE_HTTP_BUSY = 12294;
        public static final int GCLOUD_VOICE_INIT_ERR = 4099;
        public static final int GCLOUD_VOICE_INTERNAL_TVE_ERR = 20481;
        public static final int GCLOUD_VOICE_INTERNAL_USED = 20483;
        public static final int GCLOUD_VOICE_INTERNAL_VISIT_ERR = 20482;
        public static final int GCLOUD_VOICE_JOIN_ERR = 8194;
        public static final int GCLOUD_VOICE_LIMIT = 12299;
        public static final int GCLOUD_VOICE_MODE_STATE_ERR = 4102;
        public static final int GCLOUD_VOICE_NEED_AUTHKEY = 12292;
        public static final int GCLOUD_VOICE_NEED_INIT = 4105;
        public static final int GCLOUD_VOICE_NEED_SETAPPINFO = 4098;
        public static final int GCLOUD_VOICE_NOT_IN_ROOM = 32771;
        public static final int GCLOUD_VOICE_NO_ROOM = 8198;
        public static final int GCLOUD_VOICE_OPENFILE_ERR = 4104;
        public static final int GCLOUD_VOICE_OPENMIC_NOTANCHOR_ERR = 8196;
        public static final int GCLOUD_VOICE_PARAM_INVALID = 4103;
        public static final int GCLOUD_VOICE_PARAM_NULL = 4097;
        public static final int GCLOUD_VOICE_PATH_ACCESS_ERR = 12290;
        public static final int GCLOUD_VOICE_PERMISSION_MIC_ERR = 12291;
        public static final int GCLOUD_VOICE_POLL_BUFF_ERR = 4101;
        public static final int GCLOUD_VOICE_POLL_MSG_NO = 4108;
        public static final int GCLOUD_VOICE_POLL_MSG_PARSE_ERR = 4107;
        public static final int GCLOUD_VOICE_QUIT_ROOM_ERR = 8199;
        public static final int GCLOUD_VOICE_REALTIME_STATE_ERR = 8193;
        public static final int GCLOUD_VOICE_RECORDING_ERR = 4100;
        public static final int GCLOUD_VOICE_ROOMNAME_ERR = 8195;
        public static final int GCLOUD_VOICE_SMALL_ROOMNAME = 36866;
        public static final int GCLOUD_VOICE_SPEAKER_ERR = 12296;
        public static final int GCLOUD_VOICE_STTING = 28673;
        public static final int GCLOUD_VOICE_SUCC = 0;
        public static final int GCLOUD_VOICE_TVE_PLAYSOUND_ERR = 12297;
        public static final int GCLOUD_VOICE_UPLOAD_ERR = 12293;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class GCloudVoiceEvent {
        public static final int EVENT_AUDIO_INTERRUPT_BEGIN = 50;
        public static final int EVENT_AUDIO_INTERRUPT_END = 51;
        public static final int EVENT_AUDIO_RECORDER_EXCEPTION = 52;
        public static final int EVENT_AUDIO_RENDER_EXCEPTION = 53;
        public static final int EVENT_BLUETOOTH_HEADSET_CONNECTED = 21;
        public static final int EVENT_BLUETOOTH_HEADSET_DISCONNECTED = 20;
        public static final int EVENT_HEADSET_CONNECTED = 11;
        public static final int EVENT_HEADSET_DISCONNECTED = 10;
        public static final int EVENT_MIC_STATE_NO_OPEN = 32;
        public static final int EVENT_MIC_STATE_OCCUPANCY = 33;
        public static final int EVENT_MIC_STATE_OPEN_ERR = 31;
        public static final int EVENT_MIC_STATE_OPEN_SUCC = 30;
        public static final int EVENT_NO_DEVICE_CONNECTED = 0;
        public static final int EVENT_PHONE_CALL_HANG_UP = 55;
        public static final int EVENT_PHONE_CALL_PICK_UP = 54;
        public static final int EVENT_SPEAKER_STATE_NO_OPEN = 42;
        public static final int EVENT_SPEAKER_STATE_OPEN_ERR = 41;
        public static final int EVENT_SPEAKER_STATE_OPEN_SUCC = 40;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Language {
        public static final int Chinese = 0;
        public static final int English = 2;
        public static final int Japanese = 3;
        public static final int Korean = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MemberRole {
        public static final int Anchor = 1;
        public static final int Audience = 2;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Mode {
        public static final int HighQuality = 4;
        public static final int Messages = 1;
        public static final int RSTS = 5;
        public static final int RSTT = 3;
        public static final int RealTime = 0;
        public static final int Translation = 2;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class RealTimeTranslateType {
        public static final int RT_TRANSLATE_SPEECH = 2;
        public static final int RT_TRANSLATE_SPEECH_AND_TEXT = 3;
        public static final int RT_TRANSLATE_TEXT = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SpeechLanguageType {
        public static final int SPEECH_LANGUAGE_AF = 16;
        public static final int SPEECH_LANGUAGE_AM = 18;
        public static final int SPEECH_LANGUAGE_AR = 19;
        public static final int SPEECH_LANGUAGE_AZ = 21;
        public static final int SPEECH_LANGUAGE_BG = 25;
        public static final int SPEECH_LANGUAGE_BN = 23;
        public static final int SPEECH_LANGUAGE_BS = 24;
        public static final int SPEECH_LANGUAGE_CA = 27;
        public static final int SPEECH_LANGUAGE_CS = 29;
        public static final int SPEECH_LANGUAGE_DA = 30;
        public static final int SPEECH_LANGUAGE_DE = 4;
        public static final int SPEECH_LANGUAGE_EL = 37;
        public static final int SPEECH_LANGUAGE_EN = 1;
        public static final int SPEECH_LANGUAGE_ES = 6;
        public static final int SPEECH_LANGUAGE_ET = 32;
        public static final int SPEECH_LANGUAGE_EU = 22;
        public static final int SPEECH_LANGUAGE_FA = 56;
        public static final int SPEECH_LANGUAGE_FI = 34;
        public static final int SPEECH_LANGUAGE_FIL = 33;
        public static final int SPEECH_LANGUAGE_FR = 5;
        public static final int SPEECH_LANGUAGE_GL = 35;
        public static final int SPEECH_LANGUAGE_GU = 38;
        public static final int SPEECH_LANGUAGE_HI = 40;
        public static final int SPEECH_LANGUAGE_HR = 28;
        public static final int SPEECH_LANGUAGE_HU = 41;
        public static final int SPEECH_LANGUAGE_HY = 20;
        public static final int SPEECH_LANGUAGE_ID = 12;
        public static final int SPEECH_LANGUAGE_IS = 42;
        public static final int SPEECH_LANGUAGE_IT = 7;
        public static final int SPEECH_LANGUAGE_IW = 39;
        public static final int SPEECH_LANGUAGE_JA = 2;
        public static final int SPEECH_LANGUAGE_JV = 43;
        public static final int SPEECH_LANGUAGE_KA = 36;
        public static final int SPEECH_LANGUAGE_KK = 45;
        public static final int SPEECH_LANGUAGE_KM = 46;
        public static final int SPEECH_LANGUAGE_KN = 44;
        public static final int SPEECH_LANGUAGE_KO = 3;
        public static final int SPEECH_LANGUAGE_LO = 47;
        public static final int SPEECH_LANGUAGE_LT = 49;
        public static final int SPEECH_LANGUAGE_LV = 48;
        public static final int SPEECH_LANGUAGE_MK = 50;
        public static final int SPEECH_LANGUAGE_ML = 51;
        public static final int SPEECH_LANGUAGE_MN = 53;
        public static final int SPEECH_LANGUAGE_MR = 52;
        public static final int SPEECH_LANGUAGE_MS = 13;
        public static final int SPEECH_LANGUAGE_MY = 26;
        public static final int SPEECH_LANGUAGE_NE = 54;
        public static final int SPEECH_LANGUAGE_NL = 31;
        public static final int SPEECH_LANGUAGE_NO = 55;
        public static final int SPEECH_LANGUAGE_PA = 58;
        public static final int SPEECH_LANGUAGE_PL = 57;
        public static final int SPEECH_LANGUAGE_PT = 10;
        public static final int SPEECH_LANGUAGE_RO = 59;
        public static final int SPEECH_LANGUAGE_RU = 9;
        public static final int SPEECH_LANGUAGE_SI = 61;
        public static final int SPEECH_LANGUAGE_SK = 62;
        public static final int SPEECH_LANGUAGE_SL = 63;
        public static final int SPEECH_LANGUAGE_SQ = 17;
        public static final int SPEECH_LANGUAGE_SR = 60;
        public static final int SPEECH_LANGUAGE_SU = 64;
        public static final int SPEECH_LANGUAGE_SV = 66;
        public static final int SPEECH_LANGUAGE_SW = 65;
        public static final int SPEECH_LANGUAGE_TA = 67;
        public static final int SPEECH_LANGUAGE_TE = 68;
        public static final int SPEECH_LANGUAGE_TH = 14;
        public static final int SPEECH_LANGUAGE_TR = 8;
        public static final int SPEECH_LANGUAGE_UK = 69;
        public static final int SPEECH_LANGUAGE_UR = 70;
        public static final int SPEECH_LANGUAGE_UZ = 71;
        public static final int SPEECH_LANGUAGE_VI = 11;
        public static final int SPEECH_LANGUAGE_ZH = 0;
        public static final int SPEECH_LANGUAGE_ZH_TW = 15;
        public static final int SPEECH_LANGUAGE_ZU = 72;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SpeechTranslateType {
        public static final int SPEECH_TRANSLATE_STST = 0;
        public static final int SPEECH_TRANSLATE_STTS = 2;
        public static final int SPEECH_TRANSLATE_STTT = 1;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class VoiceEffectsMode {
        public static final int GVSE_DRUNK = 6;
        public static final int GVSE_FEMALE_TO_MALE = 5;
        public static final int GVSE_HELL = 2;
        public static final int GVSE_MALE_TO_FEMALE = 4;
        public static final int GVSE_NO_EFFECT = 9;
        public static final int GVSE_PAPI_JIANG = 7;
        public static final int GVSE_REVB_CHURCH = 0;
        public static final int GVSE_REVB_THEATER = 1;
        public static final int GVSE_ROBOT_1 = 3;
        public static final int GVSE_SQUIRREL = 8;
    }
}
