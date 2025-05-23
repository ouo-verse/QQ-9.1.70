package com.tencent.thumbplayer.core.datatransport.api;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.resourceloader.ITPDataTransportResourceLoaderListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes26.dex */
public interface ITPDataTransportTaskMgr {

    /* loaded from: classes26.dex */
    public interface TaskListener {
        public static final int MESSAGE_CDN_URL_EXPIRED = 1;
        public static final int MESSAGE_DEINIT = 19;
        public static final int MESSAGE_DOWNLOAD_PROTOCOL_UPDATE = 16;
        public static final int MESSAGE_FLV_PRELOAD_STATUS = 5;
        public static final int MESSAGE_HTTP_HEADER = 3;
        public static final int MESSAGE_LOW_DEFN_START_SWITCH_UP = 24;
        public static final int MESSAGE_M3U8_REFRESH = 9;
        public static final int MESSAGE_MULTI_NETWORK_CGI_FAIL = 23;
        public static final int MESSAGE_MULTI_NETWORK_CGI_SUCC = 22;
        public static final int MESSAGE_MULTI_NETWORK_LOW_SPEED = 10;
        public static final int MESSAGE_MULTI_NETWORK_STATUS = 11;
        public static final int MESSAGE_NOTIFY_M3U8_CONTENT = 4;
        public static final int MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION = 2;
        public static final int MESSAGE_NO_MORE_DATA = 17;
        public static final int MESSAGE_ON_DOWNLOAD_STATUS_UPDATE = 15;
        public static final int MESSAGE_QUIC_DOWNLOAD_STATUS = 6;
        public static final int MESSAGE_QUIC_REPORT_QUALITY = 7;
        public static final int MESSAGE_READ_INVALID = 12;
        public static final int MESSAGE_REINIT = 18;
        public static final int MESSAGE_REPLAY_CDN = 25;
        public static final int MESSAGE_REQUEST_CDN_URL_COMPLETE = 14;
        public static final int MESSAGE_SIMULATE_LIVE_END_OF_CURRENT_CLIP = 26;
        public static final int MESSAGE_START_REQUEST_CDN_URL = 13;
        public static final int MESSAGE_TAB_TEST_ID = 8;
        public static final int MESSAGE_UPDATE_NEXT_CLIP = 21;
        public static final int MESSAGE_VERIFY_TOKEN_FAILED = 20;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes26.dex */
        public @interface CommonInfoCallbackMessage {
        }

        long getCurrentPlayOffset(int i3);

        long getCurrentPosition(int i3);

        long getPlayerBufferLength(int i3);

        long getRemainTimeBeforePlayMs(int i3);

        void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo);

        void onDownloadError(int i3, int i16, int i17, String str);

        void onDownloadFinished(int i3);

        void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str);
    }

    int createMultiTask(List<TPDataTransportTaskParam> list, TaskListener taskListener);

    int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, TaskListener taskListener);

    ArrayList<String> getMultiProxyUrlList(int i3, int i16);

    String getProxyUrl(int i3, int i16);

    String getTaskAccessibleNativeInfo(int i3, int i16);

    String getTaskErrorCode(int i3);

    void pauseTask(int i3);

    void resumeTask(int i3);

    void setTaskOptionalConfigParam(int i3, String str, String str2);

    void setTaskResourceLoaderListener(int i3, ITPDataTransportResourceLoaderListener iTPDataTransportResourceLoaderListener);

    void stopTask(int i3);

    void updateRunningTaskParam(int i3, ArrayList<TPDataTransportTaskParam> arrayList);
}
