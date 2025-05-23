package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;

/* loaded from: classes23.dex */
public class TVKTPDebugTrackingInfoMapper {
    private static final SparseArray<ITVKReportEventListener.ReportEvent> sTPDetailInfoToTVKReportEventMap;

    static {
        SparseArray<ITVKReportEventListener.ReportEvent> sparseArray = new SparseArray<>();
        sTPDetailInfoToTVKReportEventMap = sparseArray;
        sparseArray.put(1, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYER_SCHEDULING_THREAD_PREPARE_START);
        sparseArray.put(2, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_DEMUX_THREAD_PREPARE_START);
        sparseArray.put(3, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_DEMUXER_FILE_OPEN_START);
        sparseArray.put(4, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_DEMUXER_FILE_OPEN_END);
        sparseArray.put(5, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_DEMUX_THREAD_ON_PREPARED);
        sparseArray.put(6, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYER_SCHEDULING_THREAD_ON_PREPARED);
        sparseArray.put(7, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_FIRST_VIDEO_DECODER_CREATE_START);
        sparseArray.put(8, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_FIRST_AUDIO_DECODER_CREATE_START);
        sparseArray.put(9, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_FIRST_VIDEO_FRAME_RENDERED);
        sparseArray.put(10, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_FIRST_AUDIO_FRAME_RENDERED);
        sparseArray.put(1000, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TP_API_SET_DATA_SOURCE_START);
        sparseArray.put(1001, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TP_API_SET_DATA_SOURCE_END);
        sparseArray.put(1003, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TP_API_PREPARE_START);
        sparseArray.put(1004, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TP_API_ON_PREPARED);
        sparseArray.put(1005, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TP_API_ON_FIRST_VIDEO_FRAME_RENDERED);
        sparseArray.put(1006, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TP_API_ON_FIRST_AUDIO_FRAME_RENDERED);
    }

    @Nullable
    public static ITVKReportEventListener.ReportEvent getReportEvent(int i3) {
        return sTPDetailInfoToTVKReportEventMap.get(i3);
    }
}
