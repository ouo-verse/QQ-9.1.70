package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo;

/* loaded from: classes23.dex */
public class TVKTPReporter {
    public static final int TP_REPORT_VALUE_LIVE_PLAY = 1;
    private static final double TP_REPORT_VALUE_SAMPLING_RATE = 0.2d;
    public static final int TP_REPORT_VALUE_SCENES_VIDEO = 0;
    public static final int TP_REPORT_VALUE_VOD_PLAY = 0;

    @Nullable
    private ParcelFileDescriptor mFileDescriptor;

    @Nullable
    private TVKPlayerVideoInfo mPlayerVideoInfo;

    @Nullable
    private ITPBusinessReportManager mReportManager;

    public TVKTPReporter(@Nullable ITPBusinessReportManager iTPBusinessReportManager) {
        this.mReportManager = iTPBusinessReportManager;
    }

    private TPDefaultReportInfo createDefaultReportInfo() {
        TPDefaultReportInfo tPDefaultReportInfo = new TPDefaultReportInfo() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKTPReporter.1
            @Override // com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo
            public int getPlayType() {
                if (TVKTPReporter.this.mPlayerVideoInfo != null && TVKTPReporter.this.mPlayerVideoInfo.isLivePlay()) {
                    return 1;
                }
                return 0;
            }
        };
        tPDefaultReportInfo.platform = TVKVersion.getPlatformInteger();
        tPDefaultReportInfo.guid = TVKCommParams.getStaGuid();
        tPDefaultReportInfo.scenesId = 0;
        return tPDefaultReportInfo;
    }

    public void onOpenMediaPlayer() {
        ITPBusinessReportManager iTPBusinessReportManager = this.mReportManager;
        if (iTPBusinessReportManager != null) {
            iTPBusinessReportManager.setReportInfoGetter(createDefaultReportInfo());
            this.mReportManager.setReportSamplingRate(TP_REPORT_VALUE_SAMPLING_RATE);
        }
    }

    public void reset() {
        this.mPlayerVideoInfo = null;
        this.mFileDescriptor = null;
    }

    public void setFileDescriptor(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.mFileDescriptor = parcelFileDescriptor;
    }

    public void setPlayerVideoInfo(@Nullable TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayerVideoInfo = tVKPlayerVideoInfo;
    }
}
