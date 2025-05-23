package com.tencent.qqnt.aio.gallery.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.SeekBar;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.delegate.inner.IVideoControlSection;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.video.ILayerVideoListener;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.MediaInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J*\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010 \u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001fR\u0014\u0010-\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010\"\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/section/e;", "Lcom/tencent/qqnt/aio/gallery/section/a;", "Lcom/tencent/richframework/gallery/video/ILayerVideoListener;", "", "event", "", "t", "r", ReportConstant.COSTREPORT_PREFIX, "u", "Landroid/view/View;", "containerView", "onInitView", "p", "onVideoPrepared", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBufferEnd", "onBufferStart", "onFirstFrameRendered", "", "firstInit", "onInitSuccess", "onCompletion", "onRelease", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onVideoPlayError", "d", "Ljava/lang/String;", "TAG", "e", "Z", "isVideoPrepared", "f", "I", "Lcom/tencent/qqnt/aio/video/a;", h.F, "Lcom/tencent/qqnt/aio/video/a;", "videoPlayReport", "i", "playId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "logOpen", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e extends a implements ILayerVideoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoPrepared;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.video.a videoPlayReport;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String playId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean logOpen;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "NTAIOLayerVideoReportSection";
            this.playId = "";
        }
    }

    private final void r() {
        this.isVideoPrepared = false;
        this.errorCode = 0;
    }

    private final void s() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.k();
        }
        com.tencent.qqnt.aio.video.a aVar2 = this.videoPlayReport;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.videoPlayReport = null;
    }

    private final void t(String event) {
        if (this.logOpen) {
            if (TextUtils.isEmpty(this.playId)) {
                this.playId = String.valueOf(System.currentTimeMillis());
            }
            QLog.i(this.TAG, 1, event + " playId:" + this.playId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        String str;
        String str2;
        String str3;
        VideoElement videoElement;
        if (((RFWLayerItemMediaInfo) this.mData).getExtraData() instanceof AIOMsgItem) {
            Object extraData = ((RFWLayerItemMediaInfo) this.mData).getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) extraData;
            final HashMap hashMap = new HashMap();
            hashMap.put("nt_platform", "Android");
            hashMap.put("nt_app", "MobileQQ");
            String b16 = com.tencent.qqnt.aio.gallery.a.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getReportVersionName()");
            hashMap.put("nt_app_version", b16);
            hashMap.put("nt_module", "nt_rich");
            if (aIOMsgItem.p0() == 2) {
                str = "GroupVideo";
            } else if (aIOMsgItem.p0() == 1) {
                str = "C2CVideo";
            } else {
                str = "Unkonw";
            }
            hashMap.put("nt_rich_biz_type", str);
            hashMap.put("nt_rich_transfer_type", "PlayOnline");
            hashMap.put("nt_rich_down_thumb_type", "Ori");
            MsgElement i3 = MsgExtKt.i(aIOMsgItem.getMsgRecord(), 5);
            boolean z16 = false;
            if (i3 != null && (videoElement = i3.videoElement) != null && videoElement.busiType == 0) {
                z16 = true;
            }
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put("nt_rich_is_long_video", str2);
            hashMap.put("nt_rich_err_code", String.valueOf(this.errorCode));
            int netWorkType = NetworkUtil.getNetWorkType();
            if (netWorkType != 1) {
                if (netWorkType != 2) {
                    if (netWorkType != 3) {
                        if (netWorkType != 4) {
                            if (netWorkType != 6) {
                                str3 = "Unreach";
                            } else {
                                str3 = "5G";
                            }
                        } else {
                            str3 = "4G";
                        }
                    } else {
                        str3 = "3G";
                    }
                } else {
                    str3 = "2G";
                }
            } else {
                str3 = "WiFi";
            }
            hashMap.put("nt_rich_net_status", str3);
            hashMap.put("nt_rich_scene", "Browser");
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.section.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.v(hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(HashMap params) {
        Intrinsics.checkNotNullParameter(params, "$params");
        cq.N("nt_rich", params, "nt_rich_video_transfer_cnt_total", 1.0d, false);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onBufferEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.richframework.video.a.a(this);
        t("onBufferEnd");
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("buffering_end");
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onBufferStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.richframework.video.a.b(this);
        t("onBufferStart");
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("buffering_start");
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onCompletion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            com.tencent.richframework.video.a.c(this);
            s();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onDownloadAllFinish() {
        com.tencent.richframework.video.a.d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onFirstFrameRendered() {
        MediaInfo mediaInfo;
        String str;
        IPlayer player;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.richframework.video.a.e(this);
        t("onFirstFrameRendered");
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("first_frame_rendered");
        }
        if (((RFWLayerItemMediaInfo) this.mData).getExtraData() instanceof AIOMsgItem) {
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            IVideoPlayerProvider videoControlProvider = RFWLayerIOCUtil.getVideoControlProvider(rootView);
            String str2 = null;
            if (videoControlProvider != null && (player = videoControlProvider.getPlayer()) != null) {
                mediaInfo = player.getMediaInfo();
            } else {
                mediaInfo = null;
            }
            com.tencent.qqnt.aio.video.a aVar2 = this.videoPlayReport;
            if (aVar2 != null) {
                Object extraData = ((RFWLayerItemMediaInfo) this.mData).getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                AIOMsgItem aIOMsgItem = (AIOMsgItem) extraData;
                RFWLayerVideoInfo layerVideoInfo = ((RFWLayerItemMediaInfo) this.mData).getLayerVideoInfo();
                if (layerVideoInfo == null || (str = layerVideoInfo.getLocalPath()) == null) {
                    str = "";
                }
                if (mediaInfo != null) {
                    str2 = mediaInfo.getVideoCodec();
                }
                aVar2.j(aIOMsgItem, str, str2, "1", "1");
            }
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onInitSuccess(boolean firstInit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, firstInit);
            return;
        }
        com.tencent.richframework.video.a.f(this, firstInit);
        t("onInitSuccess");
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("create_player");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.gallery.section.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView);
            return;
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        super.onInitView(containerView);
        IVideoControlSection videoControlSection = RFWLayerIOCUtil.getVideoControlSection(containerView);
        if (videoControlSection != null) {
            videoControlSection.addVideoListener(this);
        }
        r();
        com.tencent.qqnt.aio.video.a aVar = new com.tencent.qqnt.aio.video.a();
        this.videoPlayReport = aVar;
        aVar.i("create_player");
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public /* synthetic */ void onProgress(String str, int i3, int i16) {
        com.tencent.richframework.gallery.video.a.a(this, str, i3, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onRelease() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.richframework.video.a.g(this);
        t("onRelease");
        if (this.isVideoPrepared && ((RFWLayerItemMediaInfo) this.mData).isVideo()) {
            RFWLayerVideoInfo layerVideoInfo = ((RFWLayerItemMediaInfo) this.mData).getLayerVideoInfo();
            if (layerVideoInfo != null) {
                str = layerVideoInfo.getLocalPath();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                u();
            }
        }
        s();
        r();
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        com.tencent.richframework.gallery.video.a.b(this, seekBar, i3, z16);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onSeekComplete() {
        com.tencent.richframework.video.a.h(this);
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public /* synthetic */ void onStartTrackingTouch(SeekBar seekBar) {
        com.tencent.richframework.gallery.video.a.c(this, seekBar);
    }

    @Override // com.tencent.richframework.gallery.video.ILayerVideoListener
    public /* synthetic */ void onStopTrackingTouch(SeekBar seekBar) {
        com.tencent.richframework.gallery.video.a.d(this, seekBar);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onTimerCallback() {
        com.tencent.richframework.video.a.i(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoLoopEnd() {
        com.tencent.richframework.video.a.j(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoLoopStart() {
        com.tencent.richframework.video.a.k(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoPassivePause(int i3, int i16, long j3, long j16) {
        com.tencent.richframework.video.a.l(this, i3, i16, j3, j16);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPlayError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
            return;
        }
        com.tencent.richframework.video.a.m(this, module, errorType, errorCode, extraInfo);
        t("onVideoPlayError");
        this.errorCode = errorCode;
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("error");
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.richframework.video.a.n(this);
        t("onVideoPrepared");
        this.isVideoPrepared = true;
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.section.a
    @NotNull
    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "pg_bas_video_viewing";
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void updateDownloadState(long j3, long j16, long j17) {
        com.tencent.richframework.video.a.o(this, j3, j16, j17);
    }
}
