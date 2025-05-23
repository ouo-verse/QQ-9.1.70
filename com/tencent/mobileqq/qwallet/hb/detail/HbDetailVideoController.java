package com.tencent.mobileqq.qwallet.hb.detail;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010-\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\b\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbDetailVideoController;", "", "", "f", "", DownloadInfo.spKey_Config, "", "p", "", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "urlOrPath", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "i", DomainData.DOMAIN_NAME, "mute", "o", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "b", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", tl.h.F, "()Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "c", "Z", "isVideoPrepared", "d", "canAutoPlayVideo", "e", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "isPlayCompleteReported", "Lcom/tencent/mobileqq/base/f;", "g", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/base/f;", "superPlayer", "skinId", "uniqueSkinId", "<init>", "(Landroid/content/Context;ILjava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbDetailVideoController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISPlayerVideoView videoView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoPrepared;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean canAutoPlayVideo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDownloaded;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayCompleteReported;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy superPlayer;

    public HbDetailVideoController(@NotNull Context context, int i3, @NotNull String uniqueSkinId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uniqueSkinId, "uniqueSkinId");
        this.context = context;
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
        Intrinsics.checkNotNullExpressionValue(createPlayerVideoView, "createPlayerVideoView(context)");
        this.videoView = createPlayerVideoView;
        this.isDownloaded = true;
        lazy = LazyKt__LazyJVMKt.lazy(new HbDetailVideoController$superPlayer$2(this, i3, uniqueSkinId));
        this.superPlayer = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        if (this.isVideoPrepared && this.isDownloaded && this.canAutoPlayVideo) {
            return true;
        }
        return false;
    }

    private final com.tencent.mobileqq.base.f g() {
        return (com.tencent.mobileqq.base.f) this.superPlayer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(HbDetailVideoController this$0, int i3, IPreloadService.PathResult pathResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            String str = pathResult.filePath;
            Intrinsics.checkNotNullExpressionValue(str, "pathRes.filePath");
            this$0.k(str);
        }
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final ISPlayerVideoView getVideoView() {
        return this.videoView;
    }

    public final boolean i() {
        return g().e();
    }

    public final boolean j() {
        return g().f();
    }

    public final void k(@NotNull String urlOrPath) {
        Intrinsics.checkNotNullParameter(urlOrPath, "urlOrPath");
        this.isDownloaded = true;
        QLog.i("HbDetailVideoController", 2, "openMediaPlayer url or path is " + urlOrPath);
        g().h(MobileQQ.sMobileQQ, SuperPlayerFactory.createVideoInfoForUrl(urlOrPath, 101, (String) null, (String) null), 0L);
        if (f()) {
            m();
        }
    }

    public final void l() {
        this.canAutoPlayVideo = false;
        g().i();
    }

    public final void m() {
        this.canAutoPlayVideo = true;
        if (f()) {
            g().q();
        }
    }

    public final void n() {
        g().j();
    }

    public final void o(boolean mute) {
        QLog.d("HbDetailVideoController", 1, "setMute: " + mute);
        g().o(mute);
    }

    public final void p(int config) {
        g().p(config);
    }

    public final void q(@NotNull String url) {
        IPreloadServiceProxy iPreloadServiceProxy;
        List<String> listOf;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_HB_DETAIL_VIDEO_MUST_LOADED)) {
            k(url);
            return;
        }
        this.isDownloaded = false;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iPreloadServiceProxy = (IPreloadServiceProxy) peekAppRuntime.getRuntimeService(IPreloadServiceProxy.class, "tool")) != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(url);
            iPreloadServiceProxy.downloadUrls(listOf, new IPreloadService.c() { // from class: com.tencent.mobileqq.qwallet.hb.detail.y
                @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
                public final void onResult(int i3, IPreloadService.PathResult pathResult) {
                    HbDetailVideoController.r(HbDetailVideoController.this, i3, pathResult);
                }
            });
        }
    }
}
