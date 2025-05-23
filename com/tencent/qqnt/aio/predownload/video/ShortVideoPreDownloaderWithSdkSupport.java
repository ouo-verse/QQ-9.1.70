package com.tencent.qqnt.aio.predownload.video;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.video.o;
import com.tencent.mobileqq.aio.utils.ap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00104\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00107\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloaderWithSdkSupport;", "Lcom/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloader;", "Lcom/tencent/qqnt/aio/predownload/video/req/a;", "videoDownloadReq", "", "result", "", "errMsg", AppConstants.Key.KEY_QZONE_VIDEO_URL, "videoCodecFormat", "", "M", "P", "", "list", "L", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "businessType", "videoType", "errorCode", "N", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "J", HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/superplayer/api/ISPlayerDownloader;", "p", "Lcom/tencent/superplayer/api/ISPlayerDownloader;", "getMFullDownloader", "()Lcom/tencent/superplayer/api/ISPlayerDownloader;", "setMFullDownloader", "(Lcom/tencent/superplayer/api/ISPlayerDownloader;)V", "mFullDownloader", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "K", "()Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "setMPreDownloader", "(Lcom/tencent/superplayer/api/ISPlayerPreDownloader;)V", "mPreDownloader", "", "r", "getMVideoPreDownloadDurationInMillis", "()J", "setMVideoPreDownloadDurationInMillis", "(J)V", "mVideoPreDownloadDurationInMillis", "t", "()Lcom/tencent/qqnt/aio/predownload/video/req/a;", "shortVideoDownloadRequest", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "logTag", "<init>", "()V", ReportConstant.COSTREPORT_PREFIX, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ShortVideoPreDownloaderWithSdkSupport extends ShortVideoPreDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISPlayerDownloader mFullDownloader;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISPlayerPreDownloader mPreDownloader;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long mVideoPreDownloadDurationInMillis;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloaderWithSdkSupport$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloaderWithSdkSupport$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloaderWithSdkSupport$b", "Lcom/tencent/mobileqq/qqnt/videoplay/player/sdk/d;", "", "isSuccess", "", "onSDKInited", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mobileqq.qqnt.videoplay.player.sdk.d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.predownload.video.req.a f351833b;

        b(com.tencent.qqnt.aio.predownload.video.req.a aVar) {
            this.f351833b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortVideoPreDownloaderWithSdkSupport.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.player.sdk.d
        public void onSDKInited(boolean isSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ShortVideoPreDownloaderWithSdkSupport.this.P(this.f351833b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, isSuccess);
            }
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J8\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J*\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0019\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\"\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010$\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006%"}, d2 = {"com/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloaderWithSdkSupport$c", "Lcom/tencent/superplayer/api/ISPlayerDownloader$Listener;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "playableDurationMS", "downloadSpeedKBs", "", "currentDownloadSizeByte", "totalFileSizeByte", "", "extraInfo", "", "onDownloadProgressUpdate", "onDownloadFinish", "moduleID", "errorCode", "extInfo", "onDownloadError", "url", "onDownloadCdnUrlUpdate", "cdnIp", TPReportKeys.Common.COMMON_UIP, "errorCodeStr", "onDownloadCdnUrlInfoUpdate", "", "info", "onDownloadCdnUrlExpired", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "onDownloadStatusUpdate", "p0", "p1", "Lcom/tencent/thumbplayer/core/datatransport/aidl/TPDataTransportMessageInfo;", "p2", "onCommonMessageCallback", AudienceReportConst.PROTOCOL, "protocolVer", "onDownloadProtocolUpdate", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements ISPlayerDownloader.Listener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.predownload.video.req.a f351834a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortVideoPreDownloaderWithSdkSupport f351835b;

        c(com.tencent.qqnt.aio.predownload.video.req.a aVar, ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport) {
            this.f351834a = aVar;
            this.f351835b = shortVideoPreDownloaderWithSdkSupport;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) shortVideoPreDownloaderWithSdkSupport);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onCommonMessageCallback(int p06, int p16, @Nullable TPDataTransportMessageInfo p26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Integer.valueOf(p06), Integer.valueOf(p16), p26);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlExpired(int taskId, @Nullable Map<String, String> info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, taskId, (Object) info);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlInfoUpdate(int taskId, @Nullable String url, @Nullable String cdnIp, @Nullable String uip, @Nullable String errorCodeStr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(taskId), url, cdnIp, uip, errorCodeStr);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlUpdate(int taskId, @Nullable String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, taskId, (Object) url);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadError(int taskId, int moduleID, int errorCode, @NotNull String extInfo) {
            ShortVideoMsgItem shortVideoMsgItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(taskId), Integer.valueOf(moduleID), Integer.valueOf(errorCode), extInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(extInfo, "extInfo");
            if (QLog.isColorLevel()) {
                QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 2, "[startFullDownloadVideo] msgId=" + this.f351834a.l() + " ", "onDownloadError, preLoadId=" + this.f351834a.o() + ", moduleID=" + moduleID + ", errorCode=" + errorCode + ", extInfo=" + extInfo);
            }
            lv3.a h16 = this.f351834a.h();
            if (h16 != null) {
                h16.onComplete(errorCode);
            }
            ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport = this.f351835b;
            com.tencent.qqnt.aio.predownload.video.req.a t16 = shortVideoPreDownloaderWithSdkSupport.t();
            if (t16 != null) {
                shortVideoMsgItem = t16.m();
            } else {
                shortVideoMsgItem = null;
            }
            shortVideoPreDownloaderWithSdkSupport.N(shortVideoPreDownloaderWithSdkSupport.J(shortVideoMsgItem), 1, String.valueOf(errorCode));
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadFinish(int taskId) {
            ShortVideoMsgItem shortVideoMsgItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, taskId);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 2, "[startFullDownloadVideo] msgId=" + this.f351834a.l() + ", ", "onDownloadFinish, preLoadId=" + this.f351834a.o() + ", uniseq = " + this.f351834a.l());
            }
            lv3.a h16 = this.f351834a.h();
            if (h16 != null) {
                h16.onComplete(0);
            }
            ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport = this.f351835b;
            com.tencent.qqnt.aio.predownload.video.req.a t16 = shortVideoPreDownloaderWithSdkSupport.t();
            if (t16 != null) {
                shortVideoMsgItem = t16.m();
            } else {
                shortVideoMsgItem = null;
            }
            shortVideoPreDownloaderWithSdkSupport.N(shortVideoPreDownloaderWithSdkSupport.J(shortVideoMsgItem), 1, "0");
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadProgressUpdate(int taskId, int playableDurationMS, int downloadSpeedKBs, long currentDownloadSizeByte, long totalFileSizeByte, @Nullable String extraInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(taskId), Integer.valueOf(playableDurationMS), Integer.valueOf(downloadSpeedKBs), Long.valueOf(currentDownloadSizeByte), Long.valueOf(totalFileSizeByte), extraInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 2, "[startFullDownloadVideo] msgId=" + this.f351834a.l() + ", ", "onDownloadProgressUpdate, preLoadId=" + this.f351834a.o() + ", currentDownloadSizeByte=" + currentDownloadSizeByte + ", totalFileSizeByte=" + totalFileSizeByte);
            }
            if (this.f351834a.h() != null && this.f351834a.m() != null) {
                if (currentDownloadSizeByte > this.f351834a.j()) {
                    this.f351834a.q(currentDownloadSizeByte);
                } else {
                    currentDownloadSizeByte = this.f351834a.j();
                }
                long j3 = this.f351834a.m().E2().fileSize;
                if (j3 > 0 && currentDownloadSizeByte <= j3) {
                    int i3 = (int) (((currentDownloadSizeByte * 1.0d) / j3) * 100);
                    if (QLog.isColorLevel()) {
                        QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 2, "[startFullDownloadVideo] msgId=" + this.f351834a.l() + ", ", "onDownloadProgressUpdate, preLoadId=" + this.f351834a.o() + ", progress=" + i3);
                    }
                    lv3.a h16 = this.f351834a.h();
                    if (h16 != null) {
                        h16.onProgress(i3);
                    }
                }
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadProtocolUpdate(int taskId, @Nullable String protocol2, @Nullable String protocolVer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Integer.valueOf(taskId), protocol2, protocolVer);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadStatusUpdate(int taskId, int statusCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(taskId), Integer.valueOf(statusCode));
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J:\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/qqnt/aio/predownload/video/ShortVideoPreDownloaderWithSdkSupport$d", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "onPrepareSuccess", "moduleId", "errorCode", "", "extInfo", "onPrepareError", "playableDurationMS", "downloadSpeedKBs", "", "currentDownloadSizeByte", "totalFileSizeByte", "extraInfo", "onPrepareDownloadProgressUpdate", "what", "arg1", "arg2", "", "extra", "onInfo", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements ISPlayerPreDownloader.Listener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.predownload.video.req.a f351837b;

        d(com.tencent.qqnt.aio.predownload.video.req.a aVar) {
            this.f351837b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortVideoPreDownloaderWithSdkSupport.this, (Object) aVar);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onInfo(int what, long arg1, long arg2, @Nullable Object extra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(what), Long.valueOf(arg1), Long.valueOf(arg2), extra);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreDownloaderWithSdkSupport.this.n(), 2, "[startPreDownloadVideo] msgId=" + this.f351837b.l(), " onInfo what=" + what + " arg1=" + arg1 + " arg2=" + arg2);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareDownloadProgressUpdate(int taskId, int playableDurationMS, int downloadSpeedKBs, long currentDownloadSizeByte, long totalFileSizeByte, @Nullable String extraInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(taskId), Integer.valueOf(playableDurationMS), Integer.valueOf(downloadSpeedKBs), Long.valueOf(currentDownloadSizeByte), Long.valueOf(totalFileSizeByte), extraInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreDownloaderWithSdkSupport.this.n(), 2, "[startPreDownloadVideo] msgId=" + this.f351837b.l() + " onPrepareDownloadProgressUpdate taskId=" + taskId + ",", "playableDurationMS=" + playableDurationMS + ", currentDownloadSizeByte=" + currentDownloadSizeByte + ", totalFileSizeByte=" + totalFileSizeByte);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareError(int taskId, int moduleId, int errorCode, @Nullable String extInfo) {
            ShortVideoMsgItem shortVideoMsgItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(taskId), Integer.valueOf(moduleId), Integer.valueOf(errorCode), extInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreDownloaderWithSdkSupport.this.n(), 2, "[startPreDownloadVideo] msgId=" + this.f351837b.l(), " onPrepareError taskId=" + taskId);
            }
            ISPlayerPreDownloader K = ShortVideoPreDownloaderWithSdkSupport.this.K();
            if (K != null) {
                K.stopPreDownload(taskId);
            }
            ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport = ShortVideoPreDownloaderWithSdkSupport.this;
            com.tencent.qqnt.aio.predownload.video.req.a aVar = this.f351837b;
            if (aVar != null) {
                shortVideoMsgItem = aVar.m();
            } else {
                shortVideoMsgItem = null;
            }
            shortVideoPreDownloaderWithSdkSupport.N(shortVideoPreDownloaderWithSdkSupport.J(shortVideoMsgItem), 0, String.valueOf(errorCode));
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareSuccess(int taskId) {
            ShortVideoMsgItem shortVideoMsgItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, taskId);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ShortVideoPreDownloaderWithSdkSupport.this.n(), 2, "[startPreDownloadVideo] msgId=" + this.f351837b.l(), " onPrepareSuccess taskId=" + taskId);
            }
            ShortVideoPreDownloaderWithSdkSupport shortVideoPreDownloaderWithSdkSupport = ShortVideoPreDownloaderWithSdkSupport.this;
            com.tencent.qqnt.aio.predownload.video.req.a aVar = this.f351837b;
            if (aVar != null) {
                shortVideoMsgItem = aVar.m();
            } else {
                shortVideoMsgItem = null;
            }
            shortVideoPreDownloaderWithSdkSupport.N(shortVideoPreDownloaderWithSdkSupport.J(shortVideoMsgItem), 0, "0");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65604);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ShortVideoPreDownloaderWithSdkSupport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mVideoPreDownloadDurationInMillis = 2000L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J(ShortVideoMsgItem msgItem) {
        Integer num;
        if (msgItem != null) {
            num = Integer.valueOf(msgItem.p0());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            return "GroupVideo";
        }
        if (num != null && num.intValue() == 1) {
            return "C2CVideo";
        }
        return "Unkonw";
    }

    private final com.tencent.qqnt.aio.predownload.video.req.a L(List<com.tencent.qqnt.aio.predownload.video.req.a> list) {
        int size = list.size();
        if (size <= 0) {
            return null;
        }
        int i3 = size - 1;
        com.tencent.qqnt.aio.predownload.video.req.a aVar = list.get(i3);
        list.remove(i3);
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[getRequestBySDKStatus] msgId=" + aVar.l());
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq, int result, String errMsg, String videoUrl, int videoCodecFormat) {
        if (result == 0 && videoUrl != null) {
            videoDownloadReq.m().z2().a().e(true);
            o oVar = o.f192253a;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            oVar.c(peekAppRuntime, videoDownloadReq.m(), videoCodecFormat);
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[handleGetPlayUrl] msgId=" + videoDownloadReq.l() + " videoUrl=" + videoUrl + " \", target videoCodecFormat=" + videoCodecFormat + ", after handle formatInfo=" + videoDownloadReq.m().z2().a());
            }
            videoDownloadReq.r(new String[]{videoUrl});
            com.tencent.mobileqq.qqnt.videoplay.player.sdk.b bVar = com.tencent.mobileqq.qqnt.videoplay.player.sdk.b.f274236a;
            if (!bVar.i() && !VideoPlaySDKManager.getInstance().isSDKReady()) {
                if (QLog.isColorLevel()) {
                    QLog.d(n(), 2, "[handleGetPlayUrl] msgId=" + videoDownloadReq.l() + " video sdk not init, try to init.");
                }
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                bVar.e(context, new b(videoDownloadReq));
                return;
            }
            P(videoDownloadReq);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[handleGetPlayUrl] msgId=" + videoDownloadReq.l() + " failed to get url, err=" + result + "," + errMsg + ". try to use nt downloader.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(String businessType, int videoType, String errorCode) {
        String str;
        String str2;
        final HashMap hashMap = new HashMap();
        hashMap.put("nt_platform", "Android");
        hashMap.put("nt_app", "MobileQQ");
        String reportVersionName = com.tencent.qqnt.util.b.f362976b.getReportVersionName();
        Intrinsics.checkNotNullExpressionValue(reportVersionName, "AppSettingUtil.reportVersionName");
        hashMap.put("nt_app_version", reportVersionName);
        hashMap.put("nt_module", "nt_rich");
        hashMap.put("nt_rich_biz_type", businessType);
        hashMap.put("nt_rich_transfer_type", "Preload");
        hashMap.put("nt_rich_down_thumb_type", "Ori");
        if (videoType == 0) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("nt_rich_is_long_video", str);
        hashMap.put("nt_rich_err_code", errorCode);
        int a16 = ap.f194113a.a();
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3) {
                    if (a16 != 4) {
                        if (a16 != 6) {
                            str2 = "Unreach";
                        } else {
                            str2 = "5G";
                        }
                    } else {
                        str2 = "4G";
                    }
                } else {
                    str2 = "3G";
                }
            } else {
                str2 = "2G";
            }
        } else {
            str2 = "WiFi";
        }
        hashMap.put("nt_rich_net_status", str2);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.video.g
            @Override // java.lang.Runnable
            public final void run() {
                ShortVideoPreDownloaderWithSdkSupport.O(hashMap);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(HashMap params) {
        Intrinsics.checkNotNullParameter(params, "$params");
        cq.N("nt_rich", params, "nt_rich_video_transfer_cnt_total", 1.0d, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        if (videoDownloadReq.p()) {
            Q(videoDownloadReq);
        } else {
            R(videoDownloadReq);
        }
        u(videoDownloadReq);
    }

    private final void Q(com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        boolean z16;
        String I2 = videoDownloadReq.m().I2();
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[startFullDownloadVideo] msgId=" + videoDownloadReq.l() + " path=" + I2);
        }
        if (videoDownloadReq.k() != null) {
            String[] k3 = videoDownloadReq.k();
            Intrinsics.checkNotNull(k3);
            if (k3.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                StringBuilder sb5 = new StringBuilder();
                String[] k16 = videoDownloadReq.k();
                Intrinsics.checkNotNull(k16);
                for (String str : k16) {
                    sb5.append(str);
                    sb5.append(";");
                }
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(sb6, 101, videoDownloadReq.m().J2(), I2);
                Intrinsics.checkNotNullExpressionValue(createVideoInfoForUrl, "createVideoInfoForUrl(\n \u2026oPlayId(), path\n        )");
                ISPlayerDownloader createDownloader = SuperPlayerFactory.createDownloader(BaseApplication.getContext(), 101);
                this.mFullDownloader = createDownloader;
                Intrinsics.checkNotNull(createDownloader);
                int startOfflineDownload = createDownloader.startOfflineDownload(createVideoInfoForUrl, new c(videoDownloadReq, this));
                if (startOfflineDownload > 0) {
                    videoDownloadReq.u(startOfflineDownload);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("NT_ShortVideoPreDownloaderWithSdkSupport", 2, " downFullVideo error preLoadId = " + startOfflineDownload);
                        return;
                    }
                    return;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("NT_ShortVideoPreDownloaderWithSdkSupport", 2, "[startFullDownloadVideo] msgId=" + videoDownloadReq.l() + " mVideoUrls is null");
        }
    }

    private final void R(com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        String I2 = videoDownloadReq.m().I2();
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(videoDownloadReq.k(), 101, videoDownloadReq.m().J2() + videoDownloadReq.m().z2().a().b(), I2);
        Intrinsics.checkNotNullExpressionValue(createVideoInfoForUrl, "createVideoInfoForUrl(\n \u2026           path\n        )");
        long F2 = videoDownloadReq.m().F2();
        long j3 = this.mVideoPreDownloadDurationInMillis;
        if (QLog.isColorLevel()) {
            QLog.d(n(), 2, "[startPreDownloadVideo] msgId=" + videoDownloadReq.l() + " videoId=" + videoDownloadReq.m().J2() + " path=" + I2, ", videoDurationMs=" + F2 + ", preloadDurationMs=" + j3);
        }
        if (this.mPreDownloader == null) {
            QLog.i(n(), 1, "[startPreDownloadVideo] msgId=" + videoDownloadReq.l() + " path=" + I2);
            this.mPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplication.context, 101);
        }
        ISPlayerPreDownloader iSPlayerPreDownloader = this.mPreDownloader;
        if (iSPlayerPreDownloader != null) {
            iSPlayerPreDownloader.setOnPreDownloadListener(new d(videoDownloadReq));
        }
        ISPlayerPreDownloader iSPlayerPreDownloader2 = this.mPreDownloader;
        if (iSPlayerPreDownloader2 != null) {
            iSPlayerPreDownloader2.startPreDownload(createVideoInfoForUrl, F2, j3);
        }
    }

    @Nullable
    public final ISPlayerPreDownloader K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ISPlayerPreDownloader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mPreDownloader;
    }

    @Override // com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloader
    @NotNull
    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "NT_ShortVideoPreDownloaderWithSdkSupport";
    }

    @Override // com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloader, kv3.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        ISPlayerPreDownloader iSPlayerPreDownloader = this.mPreDownloader;
        if (iSPlayerPreDownloader != null) {
            iSPlayerPreDownloader.stopAllPreDownload();
            iSPlayerPreDownloader.destory();
            this.mPreDownloader = null;
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloader
    @Nullable
    public com.tencent.qqnt.aio.predownload.video.req.a t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.aio.predownload.video.req.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        synchronized (o()) {
            com.tencent.qqnt.aio.predownload.video.req.a L = L(o());
            if (L != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(n(), 2, "[getShortVideoDownloadRequest] msgId=" + L.l() + " get a short video request from AIORequests");
                }
                return L;
            }
            Unit unit = Unit.INSTANCE;
            synchronized (p()) {
                com.tencent.qqnt.aio.predownload.video.req.a L2 = L(p());
                if (L2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(n(), 2, "[getShortVideoDownloadRequest] msgId=" + L2.l() + " get a short video request from C2CRequests");
                    }
                    return L2;
                }
                synchronized (q()) {
                    com.tencent.qqnt.aio.predownload.video.req.a L3 = L(q());
                    if (L3 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(n(), 2, "[getShortVideoDownloadRequest] msgId=" + L3.l() + " get a short video request from DiscussionRequests");
                        }
                        return L3;
                    }
                    synchronized (r()) {
                        com.tencent.qqnt.aio.predownload.video.req.a L4 = L(r());
                        if (L4 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(n(), 2, "[getShortVideoDownloadRequest] msgId=" + L4.l() + " get a short video request from GroupRequests");
                            }
                            return L4;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(n(), 2, "[getShortVideoDownloadRequest] cannot get any request");
                            return null;
                        }
                        return null;
                    }
                }
            }
        }
    }

    @Override // com.tencent.qqnt.aio.predownload.video.ShortVideoPreDownloader
    public void x(@NotNull com.tencent.qqnt.aio.predownload.video.req.a videoDownloadReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) videoDownloadReq);
            return;
        }
        Intrinsics.checkNotNullParameter(videoDownloadReq, "videoDownloadReq");
        if (!TextUtils.isEmpty(videoDownloadReq.m().x2())) {
            if (QLog.isColorLevel()) {
                QLog.d(n(), 2, "[launchShortVideoDownloadRequest] msgId=" + videoDownloadReq.l() + " launchRequest by cached url, url=" + videoDownloadReq.m().x2() + ", cacheVideoCodecForamt=" + videoDownloadReq.m().w2());
            }
            M(videoDownloadReq, 0, "", videoDownloadReq.m().x2(), videoDownloadReq.m().w2());
            return;
        }
        videoDownloadReq.m().V2(false, 0, new ShortVideoPreDownloaderWithSdkSupport$launchShortVideoDownloadRequest$1(this, videoDownloadReq));
    }
}
