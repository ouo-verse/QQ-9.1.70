package com.tencent.mobileqq.qzoneplayer.report;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {
    public static String a(int i3) {
        if (i3 == 81) {
            return "OP_PROGRESS_BAR_SEEKING_END";
        }
        if (i3 != 91) {
            switch (i3) {
                case 1:
                    return "OP_GET_SAFE_URL_OCCURRED";
                case 2:
                    return "OP_START_PLAY_VIDEO";
                case 3:
                    return "OP_SET_VIDEO_DURATION_AND_START_PLAY_POSITION";
                case 4:
                    return "OP_SET_VIDEO_RESOLUTION";
                case 5:
                    return "OP_PRE_LOAD_OCCURRED";
                case 6:
                    return "OP_V_KEY_UPDATE_OCCURRED";
                case 7:
                    return "OP_URL_REDIRECT_OCCURRED";
                default:
                    switch (i3) {
                        case 10:
                            return "OP_ADD_VIDEO_PLAY_TIME_RANGE";
                        case 11:
                            return "OP_LOOP_PLAY_VIDEO";
                        case 12:
                            return "OP_DOWNLOAD_RESULT";
                        case 13:
                            return "OP_COMPLETE_PLAY_VIDEO";
                        case 14:
                            return "OP_STOP_PLAY_VIDEO";
                        case 15:
                            return "OP_FAIL_PLAY_VIDEO";
                        case 16:
                            return "OP_FAKE_STOP_PLAY_VIDEO";
                        default:
                            switch (i3) {
                                case 18:
                                    return "OP_PROGRESS_BAR_SEEKING_BEGIN";
                                case 19:
                                    return "OP_BUFFERING_BEGIN";
                                case 20:
                                    return "OP_DOWNLOAD_SERVER_IP";
                                case 21:
                                    return "OP_DOWNLOAD_SIZE_AND_DURATION";
                                default:
                                    return "OP_UNKNOWN_" + i3;
                            }
                    }
            }
        }
        return "OP_BUFFERING_END";
    }
}
