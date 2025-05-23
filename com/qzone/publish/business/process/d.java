package com.qzone.publish.business.process;

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

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends com.qzone.publish.business.process.base.b implements x73.a {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(ShuoshuoVideoInfo shuoshuoVideoInfo, a.InterfaceC0438a<ShuoshuoVideoInfo> interfaceC0438a) {
        super(shuoshuoVideoInfo, interfaceC0438a);
    }

    private void r(String str, WinkExportParams winkExportParams) {
        WinkExportTask winkExportTask = new WinkExportTask();
        winkExportTask.f322847d = str;
        winkExportTask.f322851i = 9;
        winkExportTask.f322848e = "QZONE";
        winkExportTask.f322849f = winkExportParams;
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).addTask(winkExportTask, this);
    }

    private boolean t(LocalMediaInfo localMediaInfo, com.qzone.publish.business.process.base.c cVar, String str, WinkExportParams winkExportParams) {
        int min = Math.min(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
        if (min != cVar.getMVideoResolution()) {
            QZLog.d(this.f51048d, 1, "needReExport, minWidth: " + min + ", resolution: " + cVar.getMVideoResolution());
            return true;
        }
        WinkExportParams exportVideoParams = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).getExportVideoParams(str);
        if (winkExportParams.equals(exportVideoParams)) {
            return false;
        }
        QZLog.d(this.f51048d, 1, "needReExport, newExportParams: " + winkExportParams + ", lastExportParams: " + exportVideoParams);
        return true;
    }

    private WinkExportParams u(com.qzone.publish.business.process.base.c cVar, String str) {
        WinkExportParams winkExportParams = new WinkExportParams("QZONE", str, null, f.i(cVar.getMVideoResolution()), cVar.c(), cVar.getFrameRate());
        winkExportParams.k(cVar.b());
        winkExportParams.n(cVar.getIFrameInterval());
        winkExportParams.G = 0;
        winkExportParams.J = cVar.getMOutVideoPath();
        return winkExportParams;
    }

    @Override // com.qzone.publish.business.process.base.a
    public void h() {
        QZLog.d(this.f51048d, 1, "cancel missionID:" + ((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID);
        ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).cancelTask(((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.process.base.a
    public void i() {
        super.i();
    }

    @Override // com.qzone.publish.business.process.base.a
    public QZoneProcessType k() {
        return QZoneProcessType.PROCESS_TYPE_QCIRCLE_EXPORT;
    }

    @Override // com.qzone.publish.business.process.base.a
    public boolean m(Object obj) {
        if (!(obj instanceof ShuoshuoVideoInfo)) {
            return false;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) obj;
        if (!TextUtils.equals(((ShuoshuoVideoInfo) this.f51049e).mProcessMissionID, shuoshuoVideoInfo.mProcessMissionID)) {
            QZLog.d(this.f51048d, 1, "[isSameTask] mProcessMissionID is not equals, mOriginObj val:" + ((ShuoshuoVideoInfo) this.f51049e).mProcessMissionID);
            return false;
        }
        T t16 = this.f51049e;
        if (((ShuoshuoVideoInfo) t16).mIsUploadOrigin != shuoshuoVideoInfo.mIsUploadOrigin) {
            QZLog.d(this.f51048d, 1, "[isSameTask] mIsUploadOrigin is not equals, mOriginObj val:" + ((ShuoshuoVideoInfo) this.f51049e).mIsUploadOrigin);
            return false;
        }
        if (((ShuoshuoVideoInfo) t16).mIsOriginalVideo != shuoshuoVideoInfo.mIsOriginalVideo) {
            QZLog.d(this.f51048d, 1, "[isSameTask] mIsOriginalVideo is not equals, mOriginObj val:" + ((ShuoshuoVideoInfo) this.f51049e).mIsOriginalVideo);
            return false;
        }
        if (zm.e.f452772a.a((ShuoshuoVideoInfo) t16, shuoshuoVideoInfo)) {
            return true;
        }
        QZLog.d(this.f51048d, 1, "[isSameTask] not same PublishParamsType");
        return false;
    }

    @Override // x73.a
    public void onCompleted(String str, ExportCompletedParam exportCompletedParam) {
        if (TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID, str)) {
            QZLog.d(this.f51048d, 1, "onAETavSessionExportCompleted :" + str);
            ((ShuoshuoVideoInfo) this.f51050f).mVideoPath = exportCompletedParam.f322835e.path;
            f();
        }
    }

    @Override // x73.a
    public void onExportError(String str, ExportErrorParam exportErrorParam) {
        try {
            if (TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID, str)) {
                QZLog.d(this.f51048d, 1, "onWinkVideoExportError :" + str);
                c((int) exportErrorParam.f322838e.transformedCode(), exportErrorParam.f322838e.getMessage());
            }
        } catch (Exception e16) {
            QZLog.d(this.f51048d, 1, "onWinkVideoExportError :" + str + " " + e16);
        }
    }

    @Override // x73.a
    public void onExportStart(String str, ExportStartParam exportStartParam) {
        if (TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID, str)) {
            QZLog.d(this.f51048d, 1, "onWinkVideoExportStart missionID:" + str);
            e();
        }
    }

    @Override // x73.a
    public void onExportWaiting(String str, ExportWaitingParam exportWaitingParam) {
        if (TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID, str)) {
            QZLog.d(this.f51048d, 1, "onExportWaiting :" + str);
            g();
        }
    }

    @Override // x73.a
    public void onExporting(String str, ExportingParam exportingParam) {
        if (TextUtils.equals(((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID, str)) {
            QZLog.d(this.f51048d, 4, "onAETavSessionExporting progress:" + exportingParam.f322842e + ",missionID:" + str);
            d(exportingParam.f322842e * 100.0f);
        }
    }

    @Override // com.qzone.publish.business.process.base.a
    protected boolean p() {
        return false;
    }

    @Override // com.qzone.publish.business.process.base.b
    protected void q(com.qzone.publish.business.process.base.c cVar) {
        String str = ((ShuoshuoVideoInfo) this.f51050f).mProcessMissionID;
        if (TextUtils.isEmpty(str)) {
            f();
            return;
        }
        cVar.a(((ShuoshuoVideoInfo) this.f51050f).mVideoPath);
        LocalMediaInfo exportVideoInfo = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).getExportVideoInfo(str);
        WinkExportParams u16 = u(cVar, str);
        if (exportVideoInfo == null) {
            QZLog.d(this.f51048d, 1, "startWidthParam, LocalMediaInfo is null, retry exportTask processMissionID: " + str);
            r(str, u16);
            return;
        }
        if (t(exportVideoInfo, cVar, str, u16)) {
            QZLog.d(this.f51048d, 1, "startWidthParam, needReExport ");
            r(str, u16);
        } else {
            QZLog.d(this.f51048d, 1, "startWidthParam, has already exported ");
            ((ShuoshuoVideoInfo) this.f51050f).mVideoPath = exportVideoInfo.path;
            f();
        }
    }

    public String s() {
        return ((ShuoshuoVideoInfo) this.f51049e).mProcessMissionID;
    }
}
