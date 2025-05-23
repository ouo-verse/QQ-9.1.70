package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$QAdPlayerViewStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import hx2.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kt3.b;
import kt3.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0007\u00a2\u0006\u0004\bi\u0010jJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u0012\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\"\u0010+\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001fH\u0016J\"\u0010,\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001fH\u0016J\u0012\u0010-\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J*\u00102\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010'H\u0016J\u0006\u00103\u001a\u00020\u0013J\u0006\u00104\u001a\u00020\u0013J\b\u00105\u001a\u00020\bH\u0002J\u0018\u00109\u001a\b\u0012\u0004\u0012\u000208072\b\u00106\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010:\u001a\u00020\bH\u0002J\b\u0010;\u001a\u00020\bH\u0002J\b\u0010<\u001a\u00020\bH\u0002J\b\u0010=\u001a\u00020\bH\u0002J\b\u0010>\u001a\u00020\bH\u0002J\u0010\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001fH\u0002J\u0010\u0010A\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\bH\u0002J\u0018\u0010C\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001fH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\u0010\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u001fH\u0002J\b\u0010G\u001a\u00020\bH\u0002R\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010XR\u0016\u0010[\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010VR\u0016\u0010^\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010`R\u0016\u0010f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010`R\u0018\u0010h\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010g\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/player/QAdRewardPlayer;", "Lcom/tencent/ams/xsad/rewarded/player/RewardedAdPlayer;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/player/a;", "Lkt3/b$b;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewGroup", "", "b", "Lcom/tencent/ams/xsad/rewarded/player/RewardedAdPlayer$b;", "videoParams", "c", "Lcom/tencent/ams/xsad/rewarded/player/RewardedAdPlayer$a;", "listener", "d", "start", "pause", "stop", "", "isMute", "setOutputMute", "autoPlay", "setAutoPlay", "", "positionMs", "seekTo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "loopPlay", "a", "isPlaying", "", "getDuration", "getCurrentPosition", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onActivityPause", "onActivityResume", "", "surfaceOrHolder", "width", "height", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onViewChanged", "onViewDestroyed", "what", "arg1", "arg2", "obj", "onEvent", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "VideoParams", "", "Lcom/tencent/qqlive/playerinterface/QAdVideoItem;", ReportConstant.COSTREPORT_PREFIX, "p", "y", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "o", "errorCode", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "w", "v", "reason", "u", "t", "Lkt3/b;", "Lkt3/b;", "mQAdMediaPlayer", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/player/RewardAdPlayerLayout;", "e", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/player/RewardAdPlayerLayout;", "mQAdPlayerLayout", "f", "Ljava/util/List;", "mVideoVideoList", h.F, "Landroid/content/Context;", "mContext", "i", "I", "mPlayerViewStatus", "Lcom/tencent/ams/xsad/rewarded/player/RewardedAdPlayer$a;", "mPlayListener", BdhLogUtil.LogTag.Tag_Conn, "mCurrentStatus", "D", "J", "mLastPlayPosition", "E", "Z", UserInfo.SEX_FEMALE, "isAppOnBackground", "G", "mAutoPlay", "H", "mLoopPlay", "Landroid/view/ViewGroup;", "mParentView", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class QAdRewardPlayer implements RewardedAdPlayer, a, b.InterfaceC10678b {

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurrentStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private long mLastPlayPosition;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMute;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isAppOnBackground;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mLoopPlay;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup mParentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile b mQAdMediaPlayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile RewardAdPlayerLayout mQAdPlayerLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<QAdVideoItem> mVideoVideoList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RewardedAdPlayer.a mPlayListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPlayerViewStatus = QAdRewardDefine$QAdPlayerViewStatus.INSTANCE.c();

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mAutoPlay = true;

    private final synchronized void j() {
        n.e("[RewardAd]QAdRewardPlayer", "doOpenPlayer, mPlayerViewStatus = " + this.mPlayerViewStatus);
        if (c.f406571a.h(this.mVideoVideoList) && q()) {
            this.mCurrentStatus = 3;
            b bVar = this.mQAdMediaPlayer;
            if (bVar != null) {
                bVar.d(this.mVideoVideoList, this.mLastPlayPosition);
            }
            b bVar2 = this.mQAdMediaPlayer;
            if (bVar2 != null) {
                bVar2.setLoopPlay(this.mLoopPlay);
            }
            b bVar3 = this.mQAdMediaPlayer;
            if (bVar3 != null) {
                bVar3.setOutputMute(this.isMute);
            }
        }
    }

    private final void k() {
        n.e("[RewardAd]QAdRewardPlayer", "handleAdPlayerComplete");
        t();
    }

    private final void l(int errorCode) {
        n.e("[RewardAd]QAdRewardPlayer", "handleAdPlayerErrorFail, errorCode = " + errorCode);
        u(errorCode);
    }

    private final void m(int errorCode) {
        n.e("[RewardAd]QAdRewardPlayer", "handleAdPlayerErrorStuck, errorCode = " + errorCode);
        u(errorCode);
    }

    private final void n() {
        n.e("[RewardAd]QAdRewardPlayer", "handleAdPlayerLoopEnd");
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer$handleAdPlayerLoopEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                RewardedAdPlayer.a aVar;
                RewardedAdPlayer.a aVar2;
                aVar = QAdRewardPlayer.this.mPlayListener;
                if (aVar != null) {
                    aVar.a();
                }
                aVar2 = QAdRewardPlayer.this.mPlayListener;
                if (aVar2 != null) {
                    aVar2.onPlayStart();
                }
            }
        });
    }

    private final synchronized void o() {
        n.e("[RewardAd]QAdRewardPlayer", "handlePlayerPrepared");
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer$handlePlayerPrepared$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                QAdRewardPlayer.this.mCurrentStatus = 4;
                z16 = QAdRewardPlayer.this.mAutoPlay;
                if (z16) {
                    QAdRewardPlayer.this.start();
                }
            }
        });
    }

    private final void p() {
        boolean z16;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("audio");
        if (systemService != null) {
            int streamVolume = SystemMethodProxy.getStreamVolume((AudioManager) systemService, 3);
            n.e("[RewardAd]QAdRewardPlayer", "current volume: " + streamVolume);
            if (streamVolume <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            setOutputMute(z16);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    private final List<QAdVideoItem> s(RewardedAdPlayer.b VideoParams) {
        Map<String, Object> map;
        String str;
        long j3;
        String str2;
        String str3;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        if (VideoParams != null) {
            map = VideoParams.f71842b;
        } else {
            map = null;
        }
        if (map != null) {
            QAdVideoItem qAdVideoItem = new QAdVideoItem();
            qAdVideoItem.r(VideoParams.f71841a);
            Object obj2 = map.get("vid");
            if (obj2 != null) {
                str = obj2.toString();
            } else {
                str = null;
            }
            qAdVideoItem.s(str);
            Object obj3 = map.get("duration");
            if (!(obj3 instanceof Long)) {
                obj3 = null;
            }
            Long l3 = (Long) obj3;
            long j16 = 0;
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            qAdVideoItem.k(j3);
            Object obj4 = map.get(QAdRewardDefine$VideoParams.CACHE_PATH);
            if (obj4 != null) {
                str2 = obj4.toString();
            } else {
                str2 = null;
            }
            qAdVideoItem.g(str2);
            Object obj5 = map.get("fileSize");
            if (!(obj5 instanceof Long)) {
                obj5 = null;
            }
            Long l16 = (Long) obj5;
            if (l16 != null) {
                j16 = l16.longValue();
            }
            qAdVideoItem.n((int) j16);
            Object obj6 = map.get("definition");
            if (obj6 != null) {
                str3 = obj6.toString();
            } else {
                str3 = null;
            }
            qAdVideoItem.j(str3);
            Object obj7 = map.get(QAdRewardDefine$VideoParams.ISCACHE);
            if (obj7 instanceof Boolean) {
                obj = obj7;
            }
            Boolean bool = (Boolean) obj;
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            qAdVideoItem.h(z16);
            n.e("[RewardAd]QAdRewardPlayer", "makeVideoItemList, videoItem = " + qAdVideoItem);
            arrayList.add(qAdVideoItem);
        }
        return arrayList;
    }

    private final void t() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer$publishComplete$1
            @Override // java.lang.Runnable
            public final void run() {
                RewardedAdPlayer.a aVar;
                QAdRewardPlayer.this.mCurrentStatus = 7;
                aVar = QAdRewardPlayer.this.mPlayListener;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    private final void u(final int reason) {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer$publishError$1
            @Override // java.lang.Runnable
            public final void run() {
                RewardedAdPlayer.a aVar;
                aVar = QAdRewardPlayer.this.mPlayListener;
                if (aVar != null) {
                    aVar.l1(reason);
                }
            }
        });
    }

    private final void v() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer$publishStart$1
            @Override // java.lang.Runnable
            public final void run() {
                RewardedAdPlayer.a aVar;
                aVar = QAdRewardPlayer.this.mPlayListener;
                if (aVar != null) {
                    aVar.onPlayStart();
                }
            }
        });
    }

    private final void w(int width, int height) {
        RewardAdPlayerLayout rewardAdPlayerLayout = this.mQAdPlayerLayout;
        if (rewardAdPlayerLayout != null) {
            rewardAdPlayerLayout.setVideoWidthAndHeight(width, height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        long j3;
        b bVar;
        b bVar2 = this.mQAdMediaPlayer;
        if (bVar2 != null) {
            j3 = bVar2.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        this.mLastPlayPosition = j3;
        b bVar3 = this.mQAdMediaPlayer;
        if (bVar3 != null && bVar3.isPlaying() && (bVar = this.mQAdMediaPlayer) != null) {
            bVar.pause();
        }
        b bVar4 = this.mQAdMediaPlayer;
        if (bVar4 != null) {
            bVar4.a(null);
        }
        this.mCurrentStatus = 7;
        b bVar5 = this.mQAdMediaPlayer;
        if (bVar5 != null) {
            bVar5.g(null);
        }
        b bVar6 = this.mQAdMediaPlayer;
        if (bVar6 != null) {
            bVar6.stop();
        }
        b bVar7 = this.mQAdMediaPlayer;
        if (bVar7 != null) {
            bVar7.release();
        }
        this.mQAdMediaPlayer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        this.mPlayerViewStatus = QAdRewardDefine$QAdPlayerViewStatus.INSTANCE.c();
        RewardAdPlayerLayout rewardAdPlayerLayout = this.mQAdPlayerLayout;
        if (rewardAdPlayerLayout != null) {
            rewardAdPlayerLayout.setPlayerCallback(null);
        }
        RewardAdPlayerLayout rewardAdPlayerLayout2 = this.mQAdPlayerLayout;
        if (rewardAdPlayerLayout2 != null) {
            rewardAdPlayerLayout2.removeAllViews();
        }
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup != null) {
            viewGroup.removeView(this.mQAdPlayerLayout);
        }
        this.mQAdPlayerLayout = null;
        this.mParentView = null;
        this.mContext = null;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void a(boolean loopPlay) {
        n.e("[RewardAd]QAdRewardPlayer", "setLooper:" + loopPlay);
        this.mLoopPlay = loopPlay;
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            bVar.setLoopPlay(loopPlay);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void b(@NotNull Context context, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.mParentView = viewGroup;
        this.mContext = context;
        this.mQAdPlayerLayout = new RewardAdPlayerLayout(context);
        RewardAdPlayerLayout rewardAdPlayerLayout = this.mQAdPlayerLayout;
        Intrinsics.checkNotNull(rewardAdPlayerLayout);
        b b16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b.b(context, rewardAdPlayerLayout.b());
        if (b16 != null) {
            this.mQAdMediaPlayer = new i(b16);
        }
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            bVar.g(this);
        }
        RewardAdPlayerLayout rewardAdPlayerLayout2 = this.mQAdPlayerLayout;
        if (rewardAdPlayerLayout2 != null) {
            rewardAdPlayerLayout2.setPlayerCallback(this);
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b.a(viewGroup, this.mQAdPlayerLayout);
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void c(@Nullable RewardedAdPlayer.b videoParams) {
        this.mVideoVideoList = s(videoParams);
        p();
        j();
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void d(@Nullable RewardedAdPlayer.a listener) {
        this.mPlayListener = listener;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public int getCurrentPosition() {
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            return (int) bVar.getCurrentPositionMs();
        }
        return 0;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public int getDuration() {
        long j3;
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            j3 = bVar.f();
        } else {
            j3 = 0;
        }
        return (int) j3;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public boolean isPlaying() {
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            return bVar.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void onActivityPause() {
        this.isAppOnBackground = true;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void onActivityResume() {
        this.isAppOnBackground = false;
    }

    @Override // kt3.b.InterfaceC10678b
    public void onEvent(int what, int arg1, int arg2, @Nullable Object obj) {
        if (what != 0) {
            if (what != 1) {
                if (what != 2) {
                    if (what != 3) {
                        if (what != 5) {
                            if (what == 7) {
                                n();
                                return;
                            }
                            return;
                        }
                        w(arg1, arg2);
                        return;
                    }
                    l(arg1);
                    return;
                }
                m(arg1);
                return;
            }
            o();
            return;
        }
        k();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a
    public void onViewCreated(@Nullable Object surfaceOrHolder, int width, int height) {
        RewardAdPlayerLayout rewardAdPlayerLayout;
        b bVar;
        n.e("[RewardAd]QAdRewardPlayer", "onViewCreated, status = " + this.mCurrentStatus + ", view status = " + this.mPlayerViewStatus);
        int i3 = this.mPlayerViewStatus;
        QAdRewardDefine$QAdPlayerViewStatus.Companion companion = QAdRewardDefine$QAdPlayerViewStatus.INSTANCE;
        if (i3 == companion.a() && (rewardAdPlayerLayout = this.mQAdPlayerLayout) != null && (bVar = this.mQAdMediaPlayer) != null) {
            bVar.a(rewardAdPlayerLayout.b());
        }
        if (this.mVideoVideoList != null && this.mCurrentStatus != 7) {
            this.mPlayerViewStatus = companion.b();
            j();
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a
    public void onViewDestroyed(@Nullable Object surfaceOrHolder) {
        long j3;
        b bVar;
        n.e("[RewardAd]QAdRewardPlayer", "onViewDestroyed");
        this.mPlayerViewStatus = QAdRewardDefine$QAdPlayerViewStatus.INSTANCE.a();
        b bVar2 = this.mQAdMediaPlayer;
        if (bVar2 != null) {
            j3 = bVar2.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        this.mLastPlayPosition = j3;
        b bVar3 = this.mQAdMediaPlayer;
        if (bVar3 != null && bVar3.isPlaying() && (bVar = this.mQAdMediaPlayer) != null) {
            bVar.pause();
        }
        b bVar4 = this.mQAdMediaPlayer;
        if (bVar4 != null) {
            bVar4.stop();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public synchronized void pause() {
        n.e("[RewardAd]QAdRewardPlayer", "pause, mCurrentStatus = " + this.mCurrentStatus + ", mPlayerViewStatus = " + this.mPlayerViewStatus);
        if (r()) {
            this.mCurrentStatus = 6;
            b bVar = this.mQAdMediaPlayer;
            if (bVar != null) {
                bVar.pause();
            }
        }
    }

    public final synchronized boolean q() {
        boolean z16;
        if (this.mPlayerViewStatus == QAdRewardDefine$QAdPlayerViewStatus.INSTANCE.b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public final synchronized boolean r() {
        boolean z16;
        int i3 = this.mCurrentStatus;
        if (i3 != 0 && i3 != 3 && i3 != 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void seekTo(long positionMs) {
        n.e("[RewardAd]QAdRewardPlayer", "seekTo:" + positionMs);
        if (this.mCurrentStatus == 7) {
            z();
        }
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            bVar.c(positionMs);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void setAutoPlay(boolean autoPlay) {
        this.mAutoPlay = autoPlay;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void setOutputMute(boolean isMute) {
        this.isMute = isMute;
        b bVar = this.mQAdMediaPlayer;
        if (bVar != null) {
            bVar.setOutputMute(isMute);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public synchronized void start() {
        n.e("[RewardAd]QAdRewardPlayer", "start, mCurrentStatus = " + this.mCurrentStatus + ", mPlayerViewStatus = " + this.mPlayerViewStatus + ", isAppOnBackground = " + this.isAppOnBackground);
        if (r() && q() && !this.isAppOnBackground) {
            this.mCurrentStatus = 5;
            RewardAdPlayerLayout rewardAdPlayerLayout = this.mQAdPlayerLayout;
            if (rewardAdPlayerLayout != null) {
                rewardAdPlayerLayout.d();
            }
            b bVar = this.mQAdMediaPlayer;
            if (bVar != null) {
                bVar.start();
            }
            this.mLastPlayPosition = 0L;
            v();
        } else {
            this.mAutoPlay = true;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public synchronized void stop() {
        n.e("[RewardAd]QAdRewardPlayer", "stop");
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.QAdRewardPlayer$stop$1
            @Override // java.lang.Runnable
            public final void run() {
                QAdRewardPlayer.this.x();
                QAdRewardPlayer.this.y();
            }
        });
    }

    public final void z() {
        b bVar;
        b bVar2 = this.mQAdMediaPlayer;
        if (bVar2 != null) {
            bVar2.stop();
        }
        RewardAdPlayerLayout rewardAdPlayerLayout = this.mQAdPlayerLayout;
        if (rewardAdPlayerLayout != null && (bVar = this.mQAdMediaPlayer) != null) {
            bVar.a(rewardAdPlayerLayout.b());
        }
        j();
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void onConfigurationChanged(@Nullable Configuration configuration) {
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a
    public void onViewChanged(@Nullable Object surfaceOrHolder, int width, int height) {
    }
}
