package com.tencent.superplayer.api;

import android.util.SparseIntArray;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;

/* loaded from: classes26.dex */
public class SuperPlayerMsg {
    public static final int PLAYER_INFO_ALL_CACHE_SIZE_FINISH = 266;
    public static final int PLAYER_INFO_ALL_DOWNLOAD_FINISH = 201;
    public static final int PLAYER_INFO_ASYNC_CALL_SELECT_PROGRAM = 125;
    public static final int PLAYER_INFO_ASYNC_CALL_SWITCH_DEFINITION = 3;
    public static final int PLAYER_INFO_AUDIO_DECODER_TYPE = 114;
    public static final int PLAYER_INFO_AUDIO_HW_DECODING_SLOW = 117;
    public static final int PLAYER_INFO_AUDIO_SW_DECODING_SLOW = 116;
    public static final int PLAYER_INFO_AUTO_DEINIT = 253;
    public static final int PLAYER_INFO_AUTO_RECOVER = 254;
    public static final int PLAYER_INFO_BUFFERING_END = 113;
    public static final int PLAYER_INFO_BUFFERING_START = 112;
    public static final int PLAYER_INFO_CLIP_EOS = 109;
    public static final int PLAYER_INFO_CURRENT_LOOP_END = 108;
    public static final int PLAYER_INFO_CURRENT_LOOP_START = 107;
    public static final int PLAYER_INFO_DOWNLOAD_STATUS_UPDATE = 206;
    public static final int PLAYER_INFO_DROP_FRAME = 252;
    public static final int PLAYER_INFO_EOS = 110;
    public static final int PLAYER_INFO_FIRST_AUDIO_DECODER_START = 102;
    public static final int PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED = 104;
    public static final int PLAYER_INFO_FIRST_CLIP_OPENED = 100;
    public static final int PLAYER_INFO_FIRST_PACKET_READ = 106;
    public static final int PLAYER_INFO_FIRST_VIDEO_DECODER_START = 103;
    public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED = 105;
    public static final int PLAYER_INFO_MEDIACODEC_VIDEO_CROP = 122;
    public static final int PLAYER_INFO_NEED_TO_ROTATE_SURFACE = 121;
    public static final int PLAYER_INFO_NEW_DROP_FRAME = 255;
    public static final int PLAYER_INFO_OBJECT_MEDIA_CODEC_EXPECTION = 210;
    public static final int PLAYER_INFO_OBJECT_MEDIA_CODEC_INFO = 208;
    public static final int PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE = 204;
    public static final int PLAYER_INFO_OBJECT_PLAY_CDN_URL_CHANGED = 203;
    public static final int PLAYER_INFO_OBJECT_VIDEO_SEI = 126;
    public static final int PLAYER_INFO_ON_MEDIAINFO_READY = 127;
    public static final int PLAYER_INFO_PACKET_READ = 101;
    public static final int PLAYER_INFO_PCDN_DOWNLOAD_FAILED = 251;
    public static final int PLAYER_INFO_PLAYER_TYPE = 124;
    public static final int PLAYER_INFO_PRIVATE_HLS_TAG = 123;
    public static final int PLAYER_INFO_PROTOCOL_UPDATE = 205;
    public static final int PLAYER_INFO_RETRY_PLAYER = 200;
    public static final int PLAYER_INFO_SWITCH_DEFINITION = 111;
    public static final int PLAYER_INFO_UNKNOW = 0;
    public static final int PLAYER_INFO_VIDEO_DECODER_TYPE = 115;
    public static final int PLAYER_INFO_VIDEO_FRAME_CHECK_INFO = 209;
    public static final int PLAYER_INFO_VIDEO_HW_DECODING_SLOW = 119;
    public static final int PLAYER_INFO_VIDEO_SW_DECODING_SLOW = 118;
    public static final int TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE = 207;
    public static final int TP_PLAYER_INFO_STRING_DOWNLOAD_QUIC_STATUS_UPDATE = 250;
    private static final SparseIntArray sTPOnInfoIDMap;
    private static final SparseIntArray sTPTransPortMsgMap;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sTPOnInfoIDMap = sparseIntArray;
        sparseIntArray.put(-1, 0);
        sparseIntArray.put(3, 3);
        sparseIntArray.put(101, 100);
        sparseIntArray.put(103, 102);
        sparseIntArray.put(104, 103);
        sparseIntArray.put(105, 104);
        sparseIntArray.put(106, 105);
        sparseIntArray.put(107, 106);
        sparseIntArray.put(150, 107);
        sparseIntArray.put(151, 108);
        sparseIntArray.put(153, 109);
        sparseIntArray.put(200, 112);
        sparseIntArray.put(201, 113);
        sparseIntArray.put(203, 114);
        sparseIntArray.put(204, 115);
        sparseIntArray.put(501, 123);
        sparseIntArray.put(500, 122);
        sparseIntArray.put(50002, 124);
        sparseIntArray.put(80000, 201);
        sparseIntArray.put(80001, 207);
        sparseIntArray.put(600, 208);
        sparseIntArray.put(601, 210);
        sparseIntArray.put(503, 126);
        sparseIntArray.put(255, 252);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sTPTransPortMsgMap = sparseIntArray2;
        sparseIntArray2.put(13, 203);
        sparseIntArray2.put(14, 204);
        sparseIntArray2.put(15, 206);
        sparseIntArray2.put(16, 205);
    }

    public static int convert(int i3, TPOnInfoParam tPOnInfoParam) {
        if (80100 == i3 && tPOnInfoParam != null && (tPOnInfoParam.getObjParam() instanceof TPDataTransportMessageInfo)) {
            return sTPTransPortMsgMap.get((int) tPOnInfoParam.getLongParam1());
        }
        return sTPOnInfoIDMap.get(i3, 0);
    }
}
