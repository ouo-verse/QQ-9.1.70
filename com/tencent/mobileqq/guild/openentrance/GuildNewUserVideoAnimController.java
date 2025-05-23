package com.tencent.mobileqq.guild.openentrance;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.discover.b;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.j;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u0001:\u0001MB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\bJ\u0010KJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J,\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010(R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0006098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R&\u0010G\u001a\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010>\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/openentrance/GuildNewUserVideoAnimController;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "", "w", "r", "from", "", "isIllegalState", "k", "j", "", "curPosMs", "videoDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "animDuration", "v", "Lcom/tencent/mobileqq/guild/openentrance/b;", "value", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCurrentLoopEnd", "onError", "onFirstFrameCome", "o", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "d", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "playerTag", "e", "Landroid/widget/FrameLayout;", "videoAnimContainer", "Lmqq/util/WeakReference;", "f", "Lmqq/util/WeakReference;", "activityRef", "Landroid/view/View;", h.F, "videoViewRef", "Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", "i", "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", "videoPlayer", "Lcom/tencent/mobileqq/guild/openentrance/b;", "videoAnimCallback", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler;", "uiHandler", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "animStartCheckRunnable", "E", "Z", "isVideoFinish", UserInfo.SEX_FEMALE, "hasRunVideoAlphaAnim", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/openentrance/a;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "listenerSet", "H", "isPlaying", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNewUserVideoAnimController implements j {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Handler uiHandler;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> animStartCheckRunnable;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isVideoFinish;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasRunVideoAlphaAnim;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ArrayList<a> listenerSet;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildLivePlayerTag playerTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout videoAnimContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<QBaseActivity> activityRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> videoViewRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoPlayer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.openentrance.b videoAnimCallback;

    public GuildNewUserVideoAnimController(@NotNull GuildLivePlayerTag playerTag) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        this.playerTag = playerTag;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.live.livemanager.player.h>() { // from class: com.tencent.mobileqq.guild.openentrance.GuildNewUserVideoAnimController$videoPlayer$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.live.livemanager.player.h invoke() {
                return new com.tencent.mobileqq.guild.live.livemanager.player.h();
            }
        });
        this.videoPlayer = lazy;
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.animStartCheckRunnable = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.openentrance.GuildNewUserVideoAnimController$animStartCheckRunnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildNewUserVideoAnimController.this.j();
            }
        };
        this.listenerSet = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildNewUserVideoAnim", "[checkToStartVideoAlphaAnim] isVideoFinish:" + this.isVideoFinish);
        }
        if (this.isVideoFinish) {
            v(0L);
            return;
        }
        long o16 = p().o(this.playerTag);
        long p16 = p().p(this.playerTag);
        if (o16 >= p16 - 200) {
            v(p16 - o16);
        } else {
            m(o16, p16);
        }
    }

    private final void k(String from, boolean isIllegalState) {
        ViewParent viewParent;
        ViewGroup viewGroup;
        QBaseActivity qBaseActivity;
        Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[closeVideoAnim] from:" + from + ", isIllegalState:" + isIllegalState);
        this.isVideoFinish = true;
        this.isPlaying = false;
        GuildDiscoverABTestHelper.f216488d.G(false);
        FrameLayout frameLayout = this.videoAnimContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.videoAnimContainer;
        if (frameLayout2 != null) {
            viewParent = frameLayout2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this.videoAnimContainer);
        }
        p().e();
        this.videoViewRef = null;
        this.videoAnimContainer = null;
        IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
        WeakReference<QBaseActivity> weakReference = this.activityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        iGuildTempApi.setTabWidgetVisible(qBaseActivity, true);
        this.uiHandler.removeCallbacksAndMessages(null);
        com.tencent.mobileqq.guild.openentrance.b bVar = this.videoAnimCallback;
        if (bVar != null) {
            bVar.c(isIllegalState, this.hasRunVideoAlphaAnim);
        }
    }

    static /* synthetic */ void l(GuildNewUserVideoAnimController guildNewUserVideoAnimController, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildNewUserVideoAnimController.k(str, z16);
    }

    private final void m(long curPosMs, long videoDuration) {
        long coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((videoDuration - 200) - curPosMs) / 2, 1L);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildNewUserVideoAnim", "[delayToCheckAgain] curPosMs:" + curPosMs + ", nextCheckDuration:" + coerceAtLeast + ", videoDuration:" + videoDuration);
        }
        Handler handler = this.uiHandler;
        final Function0<Unit> function0 = this.animStartCheckRunnable;
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.openentrance.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildNewUserVideoAnimController.n(Function0.this);
            }
        }, coerceAtLeast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final com.tencent.mobileqq.guild.live.livemanager.player.h p() {
        return (com.tencent.mobileqq.guild.live.livemanager.player.h) this.videoPlayer.getValue();
    }

    private final void r(String url) {
        boolean z16;
        Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[playVideoAnim] ");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            url = "https://grouppro.gtimg.cn/growthtask/8973userguide_animation.mp4";
        }
        View c16 = p().c(url, this.playerTag, 2, true, true);
        if (c16 == null) {
            o("videoView is empty");
            return;
        }
        ViewParent parent = c16.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(c16);
        }
        this.videoViewRef = new WeakReference<>(c16);
        p().a(true, this.playerTag);
        p().d(this.playerTag, this);
        FrameLayout frameLayout = this.videoAnimContainer;
        if (frameLayout != null) {
            frameLayout.addView(c16, 0, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GuildNewUserVideoAnimController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o("click");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(long animDuration) {
        View findViewById;
        View view;
        Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[startVideoAlphaAnim] animDuration:" + animDuration + ", isVideoFinish:" + this.isVideoFinish + ", hasRunVideoAlphaAnim:" + this.hasRunVideoAlphaAnim);
        if (this.hasRunVideoAlphaAnim) {
            return;
        }
        this.hasRunVideoAlphaAnim = true;
        com.tencent.mobileqq.guild.openentrance.b bVar = this.videoAnimCallback;
        if (bVar != null) {
            bVar.f();
        }
        WeakReference<View> weakReference = this.videoViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            ObjectAnimator ofObject = ObjectAnimator.ofObject(view, com.tencent.luggage.wxa.c8.c.f123400v, new FloatEvaluator(), Float.valueOf(1.0f), Float.valueOf(0.0f));
            ofObject.setDuration(animDuration);
            ofObject.start();
        }
        FrameLayout frameLayout = this.videoAnimContainer;
        if (frameLayout != null && (findViewById = frameLayout.findViewById(R.id.wsa)) != null) {
            ObjectAnimator ofObject2 = ObjectAnimator.ofObject(findViewById, com.tencent.luggage.wxa.c8.c.f123400v, new FloatEvaluator(), Float.valueOf(1.0f), Float.valueOf(0.0f));
            ofObject2.setDuration(animDuration);
            ofObject2.addListener(new b());
            ofObject2.start();
        }
    }

    private final void w(QBaseActivity activity, final String url) {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[tryPlayVideoAnim] sdk ready");
            r(url);
        } else {
            Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[tryPlayVideoAnim] init video player sdk ");
            QQVideoPlaySDKManager.initSDKAsync(activity, new SDKInitListener() { // from class: com.tencent.mobileqq.guild.openentrance.e
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    GuildNewUserVideoAnimController.x(GuildNewUserVideoAnimController.this, url, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final GuildNewUserVideoAnimController this$0, final String str, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[tryPlayVideoAnim] it:" + z16);
        if (z16) {
            FrameLayout frameLayout = this$0.videoAnimContainer;
            if (frameLayout != null) {
                frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.guild.openentrance.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildNewUserVideoAnimController.y(GuildNewUserVideoAnimController.this, str);
                    }
                });
                return;
            }
            return;
        }
        this$0.o("sdk init fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GuildNewUserVideoAnimController this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r(str);
    }

    public final void o(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Log.i("GuildNewUserVideoAnim", "finishOnIllegalState: from:" + from);
        com.tencent.mobileqq.guild.openentrance.b bVar = this.videoAnimCallback;
        if (bVar != null) {
            bVar.e(from);
        }
        k(from, true);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onCurrentLoopEnd() {
        j.a.a(this);
        l(this, "onCurrentLoopEnd", false, 2, null);
        com.tencent.mobileqq.guild.openentrance.b bVar = this.videoAnimCallback;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onError() {
        j.a.b(this);
        o("onError");
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onFirstFrameCome() {
        View view;
        Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "[onFirstFrameCome] ");
        FrameLayout frameLayout = this.videoAnimContainer;
        if (frameLayout != null) {
            view = frameLayout.findViewById(R.id.wsb);
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        com.tencent.mobileqq.guild.openentrance.b bVar = this.videoAnimCallback;
        if (bVar != null) {
            bVar.onFirstFrameCome();
        }
        j();
        Iterator<T> it = this.listenerSet.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onVideoSizeChanged(int i3, int i16) {
        j.a.c(this, i3, i16);
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void s(@Nullable com.tencent.mobileqq.guild.openentrance.b value) {
        this.videoAnimCallback = value;
    }

    public final void t(@Nullable FrameLayout parent, @NotNull QBaseActivity activity, @NotNull String from, @Nullable String url) {
        boolean z16;
        View view;
        View findViewById;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(from, "from");
        Logger.a d16 = Logger.f235387a.d();
        if (parent == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.i("GuildNewUserVideoAnim", 1, "[showVideoAnim] parent is null = " + z16 + ", from:" + from);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setTabWidgetVisible(activity, false);
        if (parent == null) {
            o("parent is null");
            return;
        }
        this.activityRef = new WeakReference<>(activity);
        this.videoAnimContainer = parent;
        parent.setVisibility(0);
        FrameLayout frameLayout = this.videoAnimContainer;
        if (frameLayout != null && (findViewById = frameLayout.findViewById(R.id.wsa)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.openentrance.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildNewUserVideoAnimController.u(GuildNewUserVideoAnimController.this, view2);
                }
            });
        }
        FrameLayout frameLayout2 = this.videoAnimContainer;
        ImageView imageView = null;
        if (frameLayout2 != null) {
            view = frameLayout2.findViewById(R.id.wsa);
        } else {
            view = null;
        }
        if (view != null) {
            view.setAlpha(1.0f);
        }
        FrameLayout frameLayout3 = this.videoAnimContainer;
        if (frameLayout3 != null) {
            imageView = (ImageView) frameLayout3.findViewById(R.id.wsb);
        }
        ImageView imageView2 = imageView;
        if (imageView2 != null) {
            b.Companion.e(com.tencent.mobileqq.guild.discover.b.INSTANCE, imageView2, "https://downv6.qq.com/innovate/guild/discover/animation_cover.png", 0, 0, null, null, 44, null);
        }
        w(activity, url);
        this.isPlaying = true;
        GuildDiscoverABTestHelper.f216488d.G(true);
        com.tencent.mobileqq.guild.openentrance.b bVar = this.videoAnimCallback;
        if (bVar != null) {
            bVar.onVideoPlayStart();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/openentrance/GuildNewUserVideoAnimController$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            GuildNewUserVideoAnimController.this.isPlaying = false;
            GuildDiscoverABTestHelper.f216488d.G(false);
            Iterator it = GuildNewUserVideoAnimController.this.listenerSet.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onAnimEnd();
            }
            Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "onAnimationCancel isPlaying = false");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildNewUserVideoAnimController.this.isPlaying = false;
            GuildDiscoverABTestHelper.f216488d.G(false);
            Iterator it = GuildNewUserVideoAnimController.this.listenerSet.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onAnimEnd();
            }
            Logger.f235387a.d().i("GuildNewUserVideoAnim", 1, "onAnimationEnd isPlaying = false");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
