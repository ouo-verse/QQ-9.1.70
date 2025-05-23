package com.tencent.biz.subscribe.framework;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static String a(int i3) {
        if (i3 != 0) {
            if (i3 != 200) {
                if (i3 != 201) {
                    switch (i3) {
                        case 100:
                            return "PLAYER_INFO_FIRST_CLIP_OPENED";
                        case 101:
                            return "PLAYER_INFO_PACKET_READ";
                        case 102:
                            return "PLAYER_INFO_FIRST_AUDIO_DECODER_START";
                        case 103:
                            return "PLAYER_INFO_FIRST_VIDEO_DECODER_START";
                        case 104:
                            return "PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED";
                        case 105:
                            return "PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED";
                        case 106:
                            return "PLAYER_INFO_FIRST_PACKET_READ";
                        case 107:
                            return "PLAYER_INFO_CURRENT_LOOP_START";
                        case 108:
                            return "PLAYER_INFO_CURRENT_LOOP_END";
                        case 109:
                            return "PLAYER_INFO_CLIP_EOS";
                        case 110:
                            return "PLAYER_INFO_EOS";
                        case 111:
                            return "PLAYER_INFO_SWITCH_DEFINITION";
                        case 112:
                            return "PLAYER_INFO_BUFFERING_START";
                        case 113:
                            return "PLAYER_INFO_BUFFERING_END";
                        case 114:
                            return "PLAYER_INFO_AUDIO_DECODER_TYPE";
                        case 115:
                            return "PLAYER_INFO_VIDEO_DECODER_TYPE";
                        case 116:
                            return "PLAYER_INFO_AUDIO_SW_DECODING_SLOW";
                        case 117:
                            return "PLAYER_INFO_AUDIO_HW_DECODING_SLOW";
                        case 118:
                            return "PLAYER_INFO_VIDEO_SW_DECODING_SLOW";
                        case 119:
                            return "PLAYER_INFO_VIDEO_HW_DECODING_SLOW";
                        default:
                            switch (i3) {
                                case 121:
                                    return "PLAYER_INFO_NEED_TO_ROTATE_SURFACE";
                                case 122:
                                    return "PLAYER_INFO_MEDIACODEC_VIDEO_CROP";
                                case 123:
                                    return "PLAYER_INFO_PRIVATE_HLS_TAG";
                                case 124:
                                    return "PLAYER_INFO_PLAYER_TYPE";
                                default:
                                    switch (i3) {
                                        case 203:
                                            return "PLAYER_INFO_OBJECT_PLAY_CDN_URL_CHANGED";
                                        case 204:
                                            return "PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE";
                                        case 205:
                                            return "PLAYER_INFO_PROTOCOL_UPDATE";
                                        case 206:
                                            return "PLAYER_INFO_DOWNLOAD_STATUS_UPDATE";
                                        case 207:
                                            return "TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE";
                                        case 208:
                                            return "PLAYER_INFO_OBJECT_MEDIA_CODEC_INFO";
                                        case 209:
                                            return "PLAYER_INFO_VIDEO_FRAME_CHECK_INFO";
                                        default:
                                            return String.valueOf(i3);
                                    }
                            }
                    }
                }
                return "PLAYER_INFO_ALL_DOWNLOAD_FINISH";
            }
            return "PLAYER_INFO_RETRY_PLAYER";
        }
        return "PLAYER_INFO_UNKNOW";
    }
}
