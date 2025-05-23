package com.qzone.publish.business.process;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.process.base.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportErrorParam;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportWaitingParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends com.qzone.publish.business.process.base.b implements x73.a {
    private String C;
    private final boolean D;

    public c(ShuoshuoVideoInfo shuoshuoVideoInfo, a.InterfaceC0438a<ShuoshuoVideoInfo> interfaceC0438a, boolean z16) {
        super(shuoshuoVideoInfo, interfaceC0438a);
        this.D = z16;
    }

    private LocalMediaInfo r(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = shuoshuoVideoInfo.mVideoPath;
        localMediaInfo.fileSize = shuoshuoVideoInfo.mSize;
        localMediaInfo.mDuration = shuoshuoVideoInfo.mDuration;
        localMediaInfo.mTotalDuration = shuoshuoVideoInfo.mTotalDuration;
        localMediaInfo.thumbnailPath = shuoshuoVideoInfo.mCoverUrl;
        localMediaInfo.mediaWidth = shuoshuoVideoInfo.mVideoWidth;
        localMediaInfo.mediaHeight = shuoshuoVideoInfo.mVideoHeight;
        localMediaInfo.mMimeType = "video/mp4";
        return localMediaInfo;
    }

    @Override // com.qzone.publish.business.process.base.a
    public void h() {
        if (TextUtils.isEmpty(this.C)) {
            return;
        }
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).cancelTask(this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.process.base.a
    public void i() {
        super.i();
    }

    @Override // com.qzone.publish.business.process.base.a
    public QZoneProcessType k() {
        return QZoneProcessType.PROCESS_TYPE_QCIRCLE_COMPRESS;
    }

    @Override // com.qzone.publish.business.process.base.a
    public boolean m(Object obj) {
        return false;
    }

    @Override // x73.a
    public void onCompleted(String str, ExportCompletedParam exportCompletedParam) {
        LocalMediaInfo localMediaInfo;
        if (TextUtils.equals(this.C, str)) {
            if (exportCompletedParam != null && (localMediaInfo = exportCompletedParam.f322835e) != null) {
                ((ShuoshuoVideoInfo) this.f51050f).mVideoPath = localMediaInfo.path;
            }
            QZLog.d(this.f51048d, 1, "onWinkVideoExportCompleted :" + str + ",path" + ((ShuoshuoVideoInfo) this.f51050f).mVideoPath);
            f();
        }
    }

    @Override // x73.a
    public void onExportError(String str, ExportErrorParam exportErrorParam) {
        try {
            if (TextUtils.equals(this.C, str)) {
                QZLog.d(this.f51048d, 1, "onWinkVideoExportError :" + str);
                c((int) exportErrorParam.f322838e.transformedCode(), exportErrorParam.f322838e.getMessage());
            }
        } catch (Exception e16) {
            QZLog.d(this.f51048d, 1, "onWinkVideoExportError :" + str + " " + e16);
        }
    }

    @Override // x73.a
    public void onExportStart(String str, ExportStartParam exportStartParam) {
        if (TextUtils.equals(this.C, str)) {
            QZLog.d(this.f51048d, 1, "onWinkVideoExportStart missionID:" + str);
            e();
        }
    }

    @Override // x73.a
    public void onExportWaiting(String str, ExportWaitingParam exportWaitingParam) {
        if (TextUtils.equals(this.C, str)) {
            QZLog.d(this.f51048d, 1, "onExportWaiting :" + str);
            g();
        }
    }

    @Override // x73.a
    public void onExporting(String str, ExportingParam exportingParam) {
        if (!TextUtils.equals(this.C, str) || exportingParam == null) {
            return;
        }
        d(exportingParam.f322842e * 100.0f);
    }

    @Override // com.qzone.publish.business.process.base.a
    protected boolean p() {
        return this.D;
    }

    @Override // com.qzone.publish.business.process.base.b
    protected void q(com.qzone.publish.business.process.base.c cVar) {
        String str = ((ShuoshuoVideoInfo) this.f51050f).mVideoPath;
        if (!new File(str).exists()) {
            c(-200, g.a(-200));
            return;
        }
        WinkExportTask winkExportTask = new WinkExportTask();
        winkExportTask.f322847d = "QZONE_" + UUID.randomUUID().toString();
        winkExportTask.f322851i = 9;
        winkExportTask.f322848e = "QZONE";
        WinkExportParams winkExportParams = new WinkExportParams(winkExportTask.f322848e, winkExportTask.f322847d, null, f.i(cVar.getMVideoResolution()), cVar.c(), s(str, cVar.getFrameRate()));
        winkExportTask.f322849f = winkExportParams;
        winkExportParams.k(cVar.b());
        winkExportTask.f322849f.n(cVar.getIFrameInterval());
        winkExportTask.f322849f.l(cVar.getEnableOriginVideo());
        winkExportTask.f322849f.p(r((ShuoshuoVideoInfo) this.f51050f));
        winkExportTask.f322849f.G = 1;
        String str2 = winkExportTask.f322847d;
        this.C = str2;
        ((ShuoshuoVideoInfo) this.f51049e).setEditDraftMissionId(str2);
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTask(winkExportTask, this);
        QZLog.d(this.f51048d, 1, "mObj:" + this.f51050f + "\uff0cmTaskId\uff1a" + this.C);
    }

    public int s(String str, int i3) {
        int i16;
        MediaExtractor mediaExtractor = new MediaExtractor();
        int i17 = 0;
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            i16 = 0;
            while (i17 < trackCount) {
                try {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i17);
                    if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                        i16 = trackFormat.getInteger("frame-rate");
                    }
                    i17++;
                } catch (Throwable th5) {
                    th = th5;
                    i17 = i16;
                    try {
                        QZLog.e("QZoneQCircleVideoCompressProcess", "getVideoFrameRate", th);
                        mediaExtractor.release();
                        i16 = i17;
                        return i16 > 0 ? i3 : i16;
                    } finally {
                        mediaExtractor.release();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        if (i16 > 0 || i16 >= i3) {
            return i3;
        }
    }

    public c(ShuoshuoVideoInfo shuoshuoVideoInfo, a.InterfaceC0438a<ShuoshuoVideoInfo> interfaceC0438a) {
        this(shuoshuoVideoInfo, interfaceC0438a, true);
    }
}
