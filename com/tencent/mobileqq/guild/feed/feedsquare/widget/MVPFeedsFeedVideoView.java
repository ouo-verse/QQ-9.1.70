package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.video.RFWPlayer;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.MVPFeedsFeedVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideoUrl;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.video.IPlayerStateCallback;
import com.tencent.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00013B1\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0003\u0010/\u001a\u00020\u0015\u0012\b\b\u0003\u00100\u001a\u00020\u0015\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\u0006H\u0014J\b\u0010\u001b\u001a\u00020\u0006H\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "stVideo", "Lcom/tencent/mobileqq/guild/feed/video/GuildExchangeUrlManger$b;", "cb", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", DomainData.DOMAIN_NAME, "r", "u", "", "newPlayer", "Lcom/tencent/biz/richframework/video/RFWPlayer;", "k", "t", ReportConstant.COSTREPORT_PREFIX, "", "playLevel", "setPlayLevel", "startOffset", "setStVideo", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a;", "viewState", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/u;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/u;", "playerStateDispatcher", "f", "Lcom/tencent/biz/richframework/video/RFWPlayer;", "rfwPlayer", "", tl.h.F, "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MVPFeedsFeedVideoView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private State viewState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u playerStateDispatcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWPlayer rfwPlayer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$b", "Lcom/tencent/richframework/video/IPlayerStateCallback;", "", "firstInit", "", "onInitSuccess", "onVideoPrepared", "onTimerCallback", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IPlayerStateCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String str, int i3) {
            GuildFeedVideoPlayParamManager.f223979d.h(str, i3);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onBufferEnd() {
            com.tencent.richframework.video.a.a(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onBufferStart() {
            com.tencent.richframework.video.a.b(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onCompletion() {
            com.tencent.richframework.video.a.c(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onDownloadAllFinish() {
            com.tencent.richframework.video.a.d(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onFirstFrameRendered() {
            com.tencent.richframework.video.a.e(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onInitSuccess(boolean firstInit) {
            Logger logger = Logger.f235387a;
            logger.d().i(MVPFeedsFeedVideoView.this.TAG, 1, "onInitSuccess");
            MVPFeedsFeedVideoView.this.o();
            MVPFeedsFeedVideoView.this.n();
            MVPFeedsFeedVideoView.this.j();
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onRelease() {
            com.tencent.richframework.video.a.g(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void onSeekComplete() {
            com.tencent.richframework.video.a.h(this);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onTimerCallback() {
            ISuperPlayer iSuperPlayer;
            RFWPlayer rFWPlayer = MVPFeedsFeedVideoView.this.rfwPlayer;
            if (rFWPlayer != null) {
                iSuperPlayer = rFWPlayer.getRealPlayer();
            } else {
                iSuperPlayer = null;
            }
            if (iSuperPlayer == null) {
                return;
            }
            final String uniqueKey = MVPFeedsFeedVideoView.this.viewState.getUniqueKey();
            final int currentPositionMs = (int) iSuperPlayer.getCurrentPositionMs();
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.t
                @Override // java.lang.Runnable
                public final void run() {
                    MVPFeedsFeedVideoView.b.b(uniqueKey, currentPositionMs);
                }
            });
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
        public /* synthetic */ void onVideoPlayError(int i3, int i16, int i17, String str) {
            com.tencent.richframework.video.a.m(this, i3, i16, i17, str);
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public void onVideoPrepared() {
            MVPFeedsFeedVideoView.this.n();
            MVPFeedsFeedVideoView.this.o();
            MVPFeedsFeedVideoView.this.q();
            MVPFeedsFeedVideoView.this.r();
        }

        @Override // com.tencent.richframework.video.IPlayerStateCallback
        public /* synthetic */ void updateDownloadState(long j3, long j16, long j17) {
            com.tencent.richframework.video.a.o(this, j3, j16, j17);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$c", "Lcom/tencent/mobileqq/guild/feed/video/GuildExchangeUrlManger$b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "video", "", "isOriginalVideo", "", "b", "", "errorCode", "", "msg", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements GuildExchangeUrlManger.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void a(long errorCode, @Nullable String msg2) {
            MVPFeedsFeedVideoView mVPFeedsFeedVideoView = MVPFeedsFeedVideoView.this;
            mVPFeedsFeedVideoView.viewState = State.c(mVPFeedsFeedVideoView.viewState, 1, null, 0, false, false, false, 0, 126, null);
            Logger logger = Logger.f235387a;
            String str = MVPFeedsFeedVideoView.this.TAG;
            logger.d().i(str, 1, "onChangeError errorCode=" + errorCode + ", msg=" + msg2);
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void b(@Nullable GProStVideo video, boolean isOriginalVideo) {
            if (MVPFeedsFeedVideoView.this.viewState.getVideoData() != video) {
                Logger logger = Logger.f235387a;
                String str = MVPFeedsFeedVideoView.this.TAG;
                Logger.b bVar = new Logger.b();
                bVar.a().add("onChangeSuccess state.data !== video");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(str, 1, (String) it.next(), null);
                }
                return;
            }
            Logger logger2 = Logger.f235387a;
            logger2.d().i(MVPFeedsFeedVideoView.this.TAG, 1, "onChangeSuccess");
            MVPFeedsFeedVideoView mVPFeedsFeedVideoView = MVPFeedsFeedVideoView.this;
            mVPFeedsFeedVideoView.viewState = State.c(mVPFeedsFeedVideoView.viewState, 0, null, 0, false, false, false, 0, 126, null);
            MVPFeedsFeedVideoView.l(MVPFeedsFeedVideoView.this, false, 1, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MVPFeedsFeedVideoView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        View videoView;
        RFWPlayer rFWPlayer = this.rfwPlayer;
        if (rFWPlayer == null || (videoView = rFWPlayer.getVideoView()) == null) {
            return;
        }
        View childAt = getChildAt(0);
        if (!(childAt instanceof ISPlayerVideoView)) {
            childAt = null;
        }
        if (childAt != null) {
            removeView(childAt);
        }
        if (videoView.getParent() == null) {
            addView(videoView, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private final RFWPlayer k(boolean newPlayer) {
        u();
        RFWPlayer rFWPlayer = new RFWPlayer();
        this.rfwPlayer = rFWPlayer;
        GProStVideo videoData = this.viewState.getVideoData();
        if (videoData == null) {
            Logger logger = Logger.f235387a;
            String str = this.TAG;
            Logger.b bVar = new Logger.b();
            bVar.a().add("ensureRFWPlayer gProStVideo is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str, 1, (String) it.next(), null);
            }
            return rFWPlayer;
        }
        rFWPlayer.cleanSoPlayTimeRangList();
        rFWPlayer.init(this.playerStateDispatcher.b(), null, 122);
        rFWPlayer.setVideoPath(videoData.fileId, videoData.playUrl, GuildFeedVideoPlayParamManager.f223979d.d(this.viewState.getUniqueKey()));
        Logger logger2 = Logger.f235387a;
        String str2 = this.TAG;
        logger2.d().i(str2, 1, "ensureRFWPlayerAndSetVideoInfo newPlayer=" + newPlayer);
        return rFWPlayer;
    }

    static /* synthetic */ RFWPlayer l(MVPFeedsFeedVideoView mVPFeedsFeedVideoView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return mVPFeedsFeedVideoView.k(z16);
    }

    private final void m(GProStVideo stVideo, GuildExchangeUrlManger.b cb5) {
        String str;
        Object obj;
        boolean z16;
        ArrayList<GProStVideoUrl> arrayList = stVideo.vecVideoUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "stVideo.vecVideoUrlList");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((GProStVideoUrl) obj).levelType == this.viewState.getPlayLevel()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProStVideoUrl gProStVideoUrl = (GProStVideoUrl) obj;
        if (gProStVideoUrl != null) {
            str = gProStVideoUrl.playUrl;
        }
        if (!GuildExchangeUrlManger.f().d(str)) {
            stVideo.playUrl = str;
            cb5.b(stVideo, true);
            Logger.f235387a.d().i(this.TAG, 1, "exchangedUrl use levelUrl no need change");
            return;
        }
        GuildExchangeUrlManger.f().e(getContext().hashCode(), stVideo, cb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        RFWPlayer rFWPlayer = this.rfwPlayer;
        if (rFWPlayer != null) {
            rFWPlayer.setLoopback(this.viewState.getLoop());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        RFWPlayer rFWPlayer = this.rfwPlayer;
        if (rFWPlayer != null) {
            rFWPlayer.setOutputMute(this.viewState.getMute());
        }
    }

    private final void p() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDebugVersion()) {
            logger.d().d(str, 1, "innerPause " + this.viewState);
        }
        RFWVideoTimerManager.g().unRegisterTimerListener(this.playerStateDispatcher.b());
        RFWPlayer rFWPlayer = this.rfwPlayer;
        if (rFWPlayer != null) {
            rFWPlayer.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Logger logger = Logger.f235387a;
        String str = this.TAG;
        if (QLog.isDebugVersion()) {
            logger.d().d(str, 1, "innerPlay " + this.viewState);
        }
        if (this.viewState.getStatus() == 0 && this.viewState.getPlay() && this.viewState.getVideoData() != null) {
            RFWPlayer rFWPlayer = this.rfwPlayer;
            if (rFWPlayer == null) {
                l(this, false, 1, null);
                return;
            }
            if (rFWPlayer.isReady() && !rFWPlayer.isPlaying()) {
                logger.d().i(this.TAG, 1, "start");
                RFWVideoTimerManager.g().unRegisterTimerListener(this.playerStateDispatcher.b());
                RFWVideoTimerManager.g().registerTimerListener(this.playerStateDispatcher.b());
                rFWPlayer.start();
                rFWPlayer.seek(GuildFeedVideoPlayParamManager.f223979d.d(this.viewState.getUniqueKey()));
                return;
            }
            String str2 = this.TAG;
            Logger.b bVar = new Logger.b();
            bVar.a().add("start rfwPlayer is not ready or is playing");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str2, 1, (String) it.next(), null);
            }
            return;
        }
        String str3 = this.TAG;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("innerPlay state is not success");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e(str3, 1, (String) it5.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        ISuperPlayer realPlayer;
        RFWPlayer rFWPlayer = this.rfwPlayer;
        if (rFWPlayer != null && (realPlayer = rFWPlayer.getRealPlayer()) != null) {
            realPlayer.setXYaxis(this.viewState.getXyAxis());
        }
    }

    public static /* synthetic */ void setStVideo$default(MVPFeedsFeedVideoView mVPFeedsFeedVideoView, GProStVideo gProStVideo, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        mVPFeedsFeedVideoView.setStVideo(gProStVideo, i3);
    }

    private final void u() {
        RFWPlayer rFWPlayer = this.rfwPlayer;
        if (rFWPlayer != null) {
            rFWPlayer.release();
        }
        RFWVideoTimerManager.g().unRegisterTimerListener(this.playerStateDispatcher.b());
        this.rfwPlayer = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public final void s() {
        this.viewState = State.c(this.viewState, 0, null, 0, false, false, false, 0, 119, null);
        p();
    }

    public final void setPlayLevel(int playLevel) {
        this.viewState = State.c(this.viewState, 0, null, playLevel, false, false, false, 0, 123, null);
    }

    public final void setStVideo(@Nullable GProStVideo stVideo, int startOffset) {
        if (!Intrinsics.areEqual(stVideo, this.viewState.getVideoData())) {
            this.viewState = State.c(this.viewState, -2, stVideo, 0, false, false, false, 0, 124, null);
            if (stVideo == null) {
                u();
            } else {
                m(stVideo, new c());
            }
        }
    }

    public final void t() {
        this.viewState = State.c(this.viewState, 0, null, 0, true, false, false, 0, 119, null);
        q();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MVPFeedsFeedVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MVPFeedsFeedVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MVPFeedsFeedVideoView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MVPFeedsFeedVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewState = State.INSTANCE.a();
        u uVar = new u();
        uVar.a(new b());
        this.playerStateDispatcher = uVar;
        this.TAG = "MVPFeedsFeedVideoView " + hashCode();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\u0012BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&JQ\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001b\u0010\u001eR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b \u0010\u0015R\u0019\u0010$\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a;", "", "", "status", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "videoData", "playLevel", "", "play", "mute", "loop", "xyAxis", "b", "", "toString", "hashCode", "other", "equals", "a", "I", tl.h.F, "()I", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "j", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "c", "g", "d", "Z", "f", "()Z", "e", "k", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "uniqueKey", "<init>", "(ILcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;IZZZI)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.widget.MVPFeedsFeedVideoView$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class State {

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private static final State f219490j = new State(-2, null, 0, false, false, false, 0, 124, null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int status;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProStVideo videoData;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int playLevel;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean play;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean mute;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean loop;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int xyAxis;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String uniqueKey;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a$a;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a;", PatternUtils.NO_MATCH, "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a;", "a", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView$a;", "", "LEVEL_480", "I", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.widget.MVPFeedsFeedVideoView$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final State a() {
                return State.f219490j;
            }

            Companion() {
            }
        }

        public State(int i3, @Nullable GProStVideo gProStVideo, int i16, boolean z16, boolean z17, boolean z18, int i17) {
            this.status = i3;
            this.videoData = gProStVideo;
            this.playLevel = i16;
            this.play = z16;
            this.mute = z17;
            this.loop = z18;
            this.xyAxis = i17;
            this.uniqueKey = com.tencent.mobileqq.guild.feed.video.e.f223991a.b(gProStVideo);
        }

        public static /* synthetic */ State c(State state, int i3, GProStVideo gProStVideo, int i16, boolean z16, boolean z17, boolean z18, int i17, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = state.status;
            }
            if ((i18 & 2) != 0) {
                gProStVideo = state.videoData;
            }
            GProStVideo gProStVideo2 = gProStVideo;
            if ((i18 & 4) != 0) {
                i16 = state.playLevel;
            }
            int i19 = i16;
            if ((i18 & 8) != 0) {
                z16 = state.play;
            }
            boolean z19 = z16;
            if ((i18 & 16) != 0) {
                z17 = state.mute;
            }
            boolean z26 = z17;
            if ((i18 & 32) != 0) {
                z18 = state.loop;
            }
            boolean z27 = z18;
            if ((i18 & 64) != 0) {
                i17 = state.xyAxis;
            }
            return state.b(i3, gProStVideo2, i19, z19, z26, z27, i17);
        }

        @NotNull
        public final State b(int status, @Nullable GProStVideo videoData, int playLevel, boolean play, boolean mute, boolean loop, int xyAxis) {
            return new State(status, videoData, playLevel, play, mute, loop, xyAxis);
        }

        /* renamed from: d, reason: from getter */
        public final boolean getLoop() {
            return this.loop;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getMute() {
            return this.mute;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            if (this.status == state.status && Intrinsics.areEqual(this.videoData, state.videoData) && this.playLevel == state.playLevel && this.play == state.play && this.mute == state.mute && this.loop == state.loop && this.xyAxis == state.xyAxis) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getPlay() {
            return this.play;
        }

        /* renamed from: g, reason: from getter */
        public final int getPlayLevel() {
            return this.playLevel;
        }

        /* renamed from: h, reason: from getter */
        public final int getStatus() {
            return this.status;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int i3 = this.status * 31;
            GProStVideo gProStVideo = this.videoData;
            if (gProStVideo == null) {
                hashCode = 0;
            } else {
                hashCode = gProStVideo.hashCode();
            }
            int i16 = (((i3 + hashCode) * 31) + this.playLevel) * 31;
            boolean z16 = this.play;
            int i17 = 1;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            int i19 = (i16 + i18) * 31;
            boolean z17 = this.mute;
            int i26 = z17;
            if (z17 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z18 = this.loop;
            if (!z18) {
                i17 = z18 ? 1 : 0;
            }
            return ((i27 + i17) * 31) + this.xyAxis;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final String getUniqueKey() {
            return this.uniqueKey;
        }

        @Nullable
        /* renamed from: j, reason: from getter */
        public final GProStVideo getVideoData() {
            return this.videoData;
        }

        /* renamed from: k, reason: from getter */
        public final int getXyAxis() {
            return this.xyAxis;
        }

        @NotNull
        public String toString() {
            return "State(status=" + this.status + ", videoData=" + this.videoData + ", playLevel=" + this.playLevel + ", play=" + this.play + ", mute=" + this.mute + ", loop=" + this.loop + ", xyAxis=" + this.xyAxis + ")";
        }

        public /* synthetic */ State(int i3, GProStVideo gProStVideo, int i16, boolean z16, boolean z17, boolean z18, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, gProStVideo, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? true : z16, (i18 & 16) != 0 ? true : z17, (i18 & 32) != 0 ? true : z18, (i18 & 64) != 0 ? 2 : i17);
        }
    }
}
