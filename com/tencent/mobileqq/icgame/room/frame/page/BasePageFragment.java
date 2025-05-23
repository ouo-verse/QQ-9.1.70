package com.tencent.mobileqq.icgame.room.frame.page;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.BaseGameLiveAudienceView;
import com.tencent.icgame.game.api.live.BaseLiveAudienceView;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowManager;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.base.room.AudienceLivePageView;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.icgame.framework.page.Page;
import com.tencent.mobileqq.icgame.room.frame.page.OrientationAutoChangeMgr;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.timi.game.utils.v;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0002lp\b&\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0001~B\u0007\u00a2\u0006\u0004\b{\u0010|J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0005H\u0016J&\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020)H\u0016J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016J\b\u00103\u001a\u00020\u0003H\u0016J\b\u00104\u001a\u00020\u0003H\u0016J\u0010\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u000205H\u0016J\u0010\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0005H\u0016J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020:H\u0016J\n\u0010=\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020AH\u0014J\b\u0010E\u001a\u00020DH&J\u0016\u0010I\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020)R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\"\u0010\u0011\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010UR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010UR\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010v\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010y\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/page/BasePageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/a;", "", "Eh", "", "isPageClosed", "Kh", "Gh", "Jh", "Fh", "xh", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "Ih", "", RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, OcrConfig.CHINESE, "shouldExitRoom", "Hh", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "yh", "Nh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "isVisibleToUser", "setUserVisibleHint", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "switchInfo", "da", "getPageInfo", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;", "operationListener", "v1", "onBackPressed", "eb", "a0", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MiniChatConstants.MINI_APP_LANDSCAPE, "onOrientationChange", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;", "viewPager", "Hd", "n0", "isForceUpdate", "Ud", "B4", "Lcom/tencent/icgame/game/api/live/BaseLiveAudienceView;", "roomView", "Lh", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Bh", "Landroid/content/Intent;", "intent", "info", "Ph", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/icgame/game/api/live/BaseLiveAudienceView;", "D", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;", "pageOperationListener", "E", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "pageInfo", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;", "G", "Z", "Ch", "()Z", "Oh", "(Z)V", "H", "landscape", "Lcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr;", "I", "Lcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr;", "orientationAutoChangeMgr", "J", "forceUpdate", "Lcom/tencent/mobileqq/icgame/room/frame/page/c;", "K", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/icgame/room/frame/page/c;", "switcher", "Landroid/os/Handler;", "L", "Landroid/os/Handler;", "preloadHandler", "com/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$e", "M", "Lcom/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$e;", "pageListener", "com/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$d", "N", "Lcom/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$d;", "liveViewListener", "P", "Landroidx/lifecycle/LifecycleEventObserver;", "activityLifeCycleObserver", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "preloadRunnable", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class BasePageFragment extends ReportAndroidXFragment implements com.tencent.mobileqq.icgame.base.room.multipage.api.a {

    /* renamed from: C, reason: from kotlin metadata */
    private BaseLiveAudienceView roomView;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.icgame.base.room.multipage.api.e pageOperationListener;

    /* renamed from: E, reason: from kotlin metadata */
    private SwitchPageInfo pageInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.icgame.base.room.multipage.api.d viewPager;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean shouldExitRoom;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean landscape;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private OrientationAutoChangeMgr orientationAutoChangeMgr;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean forceUpdate;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy switcher;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Handler preloadHandler;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final e pageListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final d liveViewListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LifecycleEventObserver activityLifeCycleObserver;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Runnable preloadRunnable;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f237584a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f237584a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$c", "Lcom/tencent/mobileqq/icgame/room/frame/page/OrientationAutoChangeMgr$b;", "", "orientation", "", DomainData.DOMAIN_NAME, "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements OrientationAutoChangeMgr.b {
        c() {
        }

        @Override // com.tencent.mobileqq.icgame.room.frame.page.OrientationAutoChangeMgr.b
        public void n(int orientation) {
            BasePageFragment.this.zh(orientation);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$d", "Lcom/tencent/icgame/game/api/live/BaseGameLiveAudienceView$a;", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "", "c", "", MiniChatConstants.MINI_APP_LANDSCAPE, "a", "shouldExitRoom", "b", "d", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements BaseGameLiveAudienceView.a {
        d() {
        }

        @Override // com.tencent.icgame.game.api.live.BaseGameLiveAudienceView.a
        public void a(boolean isLandscape) {
            if (isLandscape) {
                BasePageFragment.this.zh(0);
            } else {
                BasePageFragment.this.zh(1);
            }
        }

        @Override // com.tencent.icgame.game.api.live.BaseGameLiveAudienceView.a
        public void b(boolean shouldExitRoom) {
            BaseLiveAudienceView baseLiveAudienceView = BasePageFragment.this.roomView;
            if (baseLiveAudienceView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomView");
                baseLiveAudienceView = null;
            }
            baseLiveAudienceView.setClosePage(true);
            BasePageFragment.this.Oh(shouldExitRoom);
            BasePageFragment.this.requireActivity().finish();
            BasePageFragment.this.Hh(shouldExitRoom);
        }

        @Override // com.tencent.icgame.game.api.live.BaseGameLiveAudienceView.a
        public void c(@NotNull Size videoSize) {
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
            QLog.i("ICGameBasePageFragment", 1, "videoSize:" + videoSize);
            OrientationAutoChangeMgr orientationAutoChangeMgr = BasePageFragment.this.orientationAutoChangeMgr;
            if (orientationAutoChangeMgr != null) {
                if (videoSize.getWidth() <= videoSize.getHeight()) {
                    orientationAutoChangeMgr.i();
                } else if (orientationAutoChangeMgr.f()) {
                    orientationAutoChangeMgr.h();
                } else {
                    orientationAutoChangeMgr.i();
                }
            }
        }

        @Override // com.tencent.icgame.game.api.live.BaseGameLiveAudienceView.a
        public boolean d() {
            return BasePageFragment.this.getShouldExitRoom();
        }
    }

    public BasePageFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.icgame.room.frame.page.c>() { // from class: com.tencent.mobileqq.icgame.room.frame.page.BasePageFragment$switcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return new c(BasePageFragment.this);
            }
        });
        this.switcher = lazy;
        this.preloadHandler = new Handler(Looper.getMainLooper());
        this.pageListener = new e();
        this.liveViewListener = new d();
        this.activityLifeCycleObserver = new LifecycleEventObserver() { // from class: com.tencent.mobileqq.icgame.room.frame.page.BasePageFragment$activityLifeCycleObserver$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                BasePageFragment.this.yh(this, source, event);
            }
        };
        this.preloadRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.room.frame.page.a
            @Override // java.lang.Runnable
            public final void run() {
                BasePageFragment.Mh(BasePageFragment.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(BasePageFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(i3);
        } else {
            tt0.c.a().e("ICGameBasePageFragment", 1, "onSwitchScreen->attachedActivity is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.icgame.room.frame.page.c Dh() {
        return (com.tencent.mobileqq.icgame.room.frame.page.c) this.switcher.getValue();
    }

    private final void Eh() {
        requireActivity().getLifecycle().addObserver(this.activityLifeCycleObserver);
    }

    private final void Fh() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        SwitchPageInfo switchPageInfo = this.pageInfo;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        this.orientationAutoChangeMgr = new OrientationAutoChangeMgr(requireContext, switchPageInfo.getRoomid(), new c());
    }

    private final void Gh() {
        xh();
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        SwitchPageInfo switchPageInfo = null;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.setParentFragment(this);
        BaseLiveAudienceView baseLiveAudienceView2 = this.roomView;
        if (baseLiveAudienceView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView2 = null;
        }
        baseLiveAudienceView2.setRoomSwitcher(Dh());
        BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
        if (baseLiveAudienceView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView3 = null;
        }
        baseLiveAudienceView3.setActivityContext(getContext());
        BaseLiveAudienceView baseLiveAudienceView4 = this.roomView;
        if (baseLiveAudienceView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView4 = null;
        }
        baseLiveAudienceView4.setResumeIntent(requireActivity().getIntent());
        BaseLiveAudienceView baseLiveAudienceView5 = this.roomView;
        if (baseLiveAudienceView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView5 = null;
        }
        baseLiveAudienceView5.setLiveViewListener(this.liveViewListener);
        BaseLiveAudienceView baseLiveAudienceView6 = this.roomView;
        if (baseLiveAudienceView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView6 = null;
        }
        SwitchPageInfo switchPageInfo2 = this.pageInfo;
        if (switchPageInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo2 = null;
        }
        long roomid = switchPageInfo2.getRoomid();
        SwitchPageInfo switchPageInfo3 = this.pageInfo;
        if (switchPageInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo = switchPageInfo3;
        }
        baseLiveAudienceView6.n(roomid, switchPageInfo.getVideoUrl(), Ih());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(boolean shouldExitRoom) {
        SwitchPageInfo switchPageInfo = this.pageInfo;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        Bundle extraData = switchPageInfo.getExtraData();
        if (extraData != null) {
            String jumpSource = extraData.getString("source", "0");
            if (shouldExitRoom) {
                Intrinsics.checkNotNullExpressionValue(jumpSource, "jumpSource");
                if (!q32.b.b(jumpSource)) {
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    q32.b.c(requireActivity);
                }
            }
        }
    }

    private final LiveRoomExtraInfo Ih() {
        LiveRoomExtraInfo liveRoomExtraInfo = new LiveRoomExtraInfo();
        SwitchPageInfo switchPageInfo = this.pageInfo;
        SwitchPageInfo switchPageInfo2 = null;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        liveRoomExtraInfo.f114880d = switchPageInfo.getRoomid();
        SwitchPageInfo switchPageInfo3 = this.pageInfo;
        if (switchPageInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo3 = null;
        }
        liveRoomExtraInfo.f114881e = switchPageInfo3.getPageIndex();
        SwitchPageInfo switchPageInfo4 = this.pageInfo;
        if (switchPageInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo4 = null;
        }
        Bundle extraData = switchPageInfo4.getExtraData();
        if (extraData != null) {
            liveRoomExtraInfo.f114883h = extraData.getInt("ext_enter_room_game_id", 0);
            liveRoomExtraInfo.f114884i = extraData.getInt("ext_enter_room_game_tag_id", 0);
            liveRoomExtraInfo.f114882f = extraData.getInt("ext_enter_room_room_type", 0);
            liveRoomExtraInfo.f114885m = extraData.getLong("ext_enter_room_video_source_app_id");
            liveRoomExtraInfo.C = extraData.getString("source");
            liveRoomExtraInfo.D = extraData.getString("trace_info");
            liveRoomExtraInfo.I = extraData.getString("source");
            liveRoomExtraInfo.G = extraData.getString("mqqschema", "");
        }
        SwitchPageInfo switchPageInfo5 = this.pageInfo;
        if (switchPageInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo2 = switchPageInfo5;
        }
        liveRoomExtraInfo.E = switchPageInfo2.getExtraData();
        QLog.i("ICGameBasePageFragment", 1, "makeExtraInfo, info " + liveRoomExtraInfo);
        return liveRoomExtraInfo;
    }

    private final void Jh() {
        LiveRoomExtraInfo Ih = Ih();
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).recordLiveRoomExtraData(Ih);
        Fh();
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        SwitchPageInfo switchPageInfo = null;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.setParentFragment(this);
        BaseLiveAudienceView baseLiveAudienceView2 = this.roomView;
        if (baseLiveAudienceView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView2 = null;
        }
        Context requireContext = requireContext();
        SwitchPageInfo switchPageInfo2 = this.pageInfo;
        if (switchPageInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo = switchPageInfo2;
        }
        baseLiveAudienceView2.l(requireContext, switchPageInfo.getRoomid(), Ih);
    }

    private final void Kh(boolean isPageClosed) {
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        SwitchPageInfo switchPageInfo = null;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        SwitchPageInfo switchPageInfo2 = this.pageInfo;
        if (switchPageInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo = switchPageInfo2;
        }
        baseLiveAudienceView.m(switchPageInfo.getRoomid(), isPageClosed, this.shouldExitRoom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(BasePageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SwitchPageInfo switchPageInfo = this$0.pageInfo;
        SwitchPageInfo switchPageInfo2 = null;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        Log.i("openNewPage", "startPreload roomid = " + switchPageInfo.getRoomid());
        com.tencent.mobileqq.icgame.base.room.multipage.api.e eVar = this$0.pageOperationListener;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageOperationListener");
            eVar = null;
        }
        SwitchPageInfo switchPageInfo3 = this$0.pageInfo;
        if (switchPageInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo2 = switchPageInfo3;
        }
        eVar.a(switchPageInfo2.getPageIndex());
    }

    private final void Nh() {
        try {
            requireActivity().getLifecycle().removeObserver(this.activityLifeCycleObserver);
        } catch (IllegalStateException e16) {
            QLog.w("ICGameBasePageFragment", 1, "removeActivityLifeCycleObserver e:" + e16);
        }
    }

    private final void xh() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        AudienceLivePageView audienceLivePageView = new AudienceLivePageView(requireContext, Bh());
        this.roomView = audienceLivePageView;
        Lh(audienceLivePageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh(LifecycleEventObserver lifecycleEventObserver, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (this.roomView != null) {
            BaseLiveAudienceView baseLiveAudienceView = null;
            switch (b.f237584a[event.ordinal()]) {
                case 1:
                    BaseLiveAudienceView baseLiveAudienceView2 = this.roomView;
                    if (baseLiveAudienceView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomView");
                    } else {
                        baseLiveAudienceView = baseLiveAudienceView2;
                    }
                    baseLiveAudienceView.o();
                    return;
                case 2:
                    BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
                    if (baseLiveAudienceView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomView");
                    } else {
                        baseLiveAudienceView = baseLiveAudienceView3;
                    }
                    baseLiveAudienceView.s();
                    return;
                case 3:
                    BaseLiveAudienceView baseLiveAudienceView4 = this.roomView;
                    if (baseLiveAudienceView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomView");
                    } else {
                        baseLiveAudienceView = baseLiveAudienceView4;
                    }
                    baseLiveAudienceView.r();
                    return;
                case 4:
                    BaseLiveAudienceView baseLiveAudienceView5 = this.roomView;
                    if (baseLiveAudienceView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomView");
                    } else {
                        baseLiveAudienceView = baseLiveAudienceView5;
                    }
                    baseLiveAudienceView.q();
                    return;
                case 5:
                    BaseLiveAudienceView baseLiveAudienceView6 = this.roomView;
                    if (baseLiveAudienceView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomView");
                    } else {
                        baseLiveAudienceView = baseLiveAudienceView6;
                    }
                    baseLiveAudienceView.t();
                    return;
                case 6:
                    lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
                    BaseLiveAudienceView baseLiveAudienceView7 = this.roomView;
                    if (baseLiveAudienceView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roomView");
                    } else {
                        baseLiveAudienceView = baseLiveAudienceView7;
                    }
                    baseLiveAudienceView.p();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(final int screenOrientation) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.frame.page.b
            @Override // java.lang.Runnable
            public final void run() {
                BasePageFragment.Ah(BasePageFragment.this, screenOrientation);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    /* renamed from: B4, reason: from getter */
    public boolean getForceUpdate() {
        return this.forceUpdate;
    }

    @NotNull
    public abstract Page Bh();

    /* renamed from: Ch, reason: from getter */
    protected final boolean getShouldExitRoom() {
        return this.shouldExitRoom;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void Hd(@NotNull com.tencent.mobileqq.icgame.base.room.multipage.api.d viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.viewPager = viewPager;
        viewPager.b(this.pageListener);
    }

    protected void Lh(@NotNull BaseLiveAudienceView roomView) {
        Intrinsics.checkNotNullParameter(roomView, "roomView");
    }

    protected final void Oh(boolean z16) {
        this.shouldExitRoom = z16;
    }

    @NotNull
    public final Intent Ph(@NotNull Intent intent, @NotNull SwitchPageInfo info) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(info, "info");
        intent.putExtra("roomid", info.getRoomid());
        intent.putExtra("video_url", info.getVideoUrl());
        intent.putExtra("biz_ext_data", info.getExtraData());
        intent.putExtra("switch_room_info", info.getExtraData());
        return intent;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void Ud(boolean isForceUpdate) {
        this.forceUpdate = isForceUpdate;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void a0() {
        SwitchPageInfo switchPageInfo = this.pageInfo;
        SwitchPageInfo switchPageInfo2 = null;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        long roomid = switchPageInfo.getRoomid();
        SwitchPageInfo switchPageInfo3 = this.pageInfo;
        if (switchPageInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo3 = null;
        }
        QLog.i("ICGameBasePageFragment", 1, "onPageSelected roomid = " + roomid + " index = " + switchPageInfo3.getPageIndex());
        if (this.roomView == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            QLog.i("ICGameBasePageFragment", 1, "onPageSelected setResumeIntent");
            BaseLiveAudienceView baseLiveAudienceView = this.roomView;
            if (baseLiveAudienceView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomView");
                baseLiveAudienceView = null;
            }
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "it.intent");
            SwitchPageInfo switchPageInfo4 = this.pageInfo;
            if (switchPageInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
                switchPageInfo4 = null;
            }
            baseLiveAudienceView.setResumeIntent(Ph(intent, switchPageInfo4));
        }
        BaseLiveAudienceView baseLiveAudienceView2 = this.roomView;
        if (baseLiveAudienceView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView2 = null;
        }
        baseLiveAudienceView2.u();
        BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
        if (baseLiveAudienceView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView3 = null;
        }
        baseLiveAudienceView3.setParentFragment(this);
        com.tencent.mobileqq.icgame.base.room.multipage.api.e eVar = this.pageOperationListener;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageOperationListener");
            eVar = null;
        }
        SwitchPageInfo switchPageInfo5 = this.pageInfo;
        if (switchPageInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo2 = switchPageInfo5;
        }
        eVar.a(switchPageInfo2.getPageIndex());
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void da(@NotNull SwitchPageInfo switchInfo) {
        Intrinsics.checkNotNullParameter(switchInfo, "switchInfo");
        this.pageInfo = switchInfo;
        SwitchPageInfo switchPageInfo = null;
        if (switchInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchInfo = null;
        }
        Bundle extraData = switchInfo.getExtraData();
        if (extraData != null) {
            SwitchPageInfo switchPageInfo2 = this.pageInfo;
            if (switchPageInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
                switchPageInfo2 = null;
            }
            extraData.putLong("roomid", switchPageInfo2.getRoomid());
            SwitchPageInfo switchPageInfo3 = this.pageInfo;
            if (switchPageInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
                switchPageInfo3 = null;
            }
            extraData.putString("video_url", switchPageInfo3.getVideoUrl());
            SwitchPageInfo switchPageInfo4 = this.pageInfo;
            if (switchPageInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            } else {
                switchPageInfo = switchPageInfo4;
            }
            extraData.putInt("room_index", switchPageInfo.getPageIndex());
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void eb() {
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("ICGameBasePageFragment", "onPageSwitchedOut roomView not initialized");
            return;
        }
        BaseLiveAudienceView baseLiveAudienceView2 = null;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        if (baseLiveAudienceView instanceof AudienceLivePageView) {
            BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
            if (baseLiveAudienceView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomView");
            } else {
                baseLiveAudienceView2 = baseLiveAudienceView3;
            }
            ((AudienceLivePageView) baseLiveAudienceView2).Y();
        }
        OrientationAutoChangeMgr orientationAutoChangeMgr = this.orientationAutoChangeMgr;
        if (orientationAutoChangeMgr != null) {
            orientationAutoChangeMgr.i();
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    @NotNull
    public SwitchPageInfo getPageInfo() {
        SwitchPageInfo switchPageInfo = this.pageInfo;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            return null;
        }
        return switchPageInfo;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    @Nullable
    /* renamed from: n0, reason: from getter */
    public com.tencent.mobileqq.icgame.base.room.multipage.api.d getViewPager() {
        return this.viewPager;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public boolean onBackPressed() {
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        BaseLiveAudienceView baseLiveAudienceView2 = null;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        this.shouldExitRoom = baseLiveAudienceView.v();
        BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
        if (baseLiveAudienceView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
        } else {
            baseLiveAudienceView2 = baseLiveAudienceView3;
        }
        return baseLiveAudienceView2.i();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i("ICGameBasePageFragment", 1, "onConfigurationChanged");
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            return;
        }
        BaseLiveAudienceView baseLiveAudienceView2 = null;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        if (baseLiveAudienceView instanceof AudienceLivePageView) {
            BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
            if (baseLiveAudienceView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomView");
            } else {
                baseLiveAudienceView2 = baseLiveAudienceView3;
            }
            ((AudienceLivePageView) baseLiveAudienceView2).X(newConfig);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.pageInfo == null) {
            requireActivity().finish();
            return;
        }
        Eh();
        Gh();
        SwitchPageInfo switchPageInfo = this.pageInfo;
        SwitchPageInfo switchPageInfo2 = null;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        if (switchPageInfo.getPageIndex() == 0) {
            com.tencent.mobileqq.icgame.base.room.multipage.api.d dVar = this.viewPager;
            boolean z16 = false;
            if (dVar != null) {
                SwitchPageInfo switchPageInfo3 = this.pageInfo;
                if (switchPageInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
                    switchPageInfo3 = null;
                }
                if (switchPageInfo3.getPageIndex() == dVar.getCurrentItem()) {
                    z16 = true;
                }
            }
            if (z16) {
                setUserVisibleHint(true);
                this.preloadHandler.postDelayed(this.preloadRunnable, 2000L);
            }
        }
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.c(this);
        String name = getClass().getName();
        SwitchPageInfo switchPageInfo4 = this.pageInfo;
        if (switchPageInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        } else {
            switchPageInfo2 = switchPageInfo4;
        }
        QLog.i("ICGameBasePageFragment", 1, "fragment onCreate finish:" + name + " roomId:" + switchPageInfo2.getRoomid());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("ICGameBasePageFragment", 1, "onCreateView");
        com.tencent.mobileqq.icgame.base.room.multipage.api.d dVar = this.viewPager;
        if (dVar != null) {
            dVar.b(this.pageListener);
        }
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        BaseLiveAudienceView baseLiveAudienceView2 = null;
        if (baseLiveAudienceView == null) {
            QLog.e("ICGameBasePageFragment", 1, "roomView does not Initialized.");
        } else {
            if (baseLiveAudienceView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomView");
                baseLiveAudienceView = null;
            }
            baseLiveAudienceView2 = baseLiveAudienceView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, baseLiveAudienceView2);
        return baseLiveAudienceView2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SwitchPageInfo switchPageInfo = this.pageInfo;
        if (switchPageInfo == null) {
            requireActivity().finish();
            return;
        }
        BaseLiveAudienceView baseLiveAudienceView = null;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        Log.i("openNewPage", "removeCallbacks roomid2 = " + switchPageInfo.getRoomid());
        this.preloadHandler.removeCallbacks(this.preloadRunnable);
        SwitchPageInfo switchPageInfo2 = this.pageInfo;
        if (switchPageInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo2 = null;
        }
        int pageIndex = switchPageInfo2.getPageIndex();
        SwitchPageInfo switchPageInfo3 = this.pageInfo;
        if (switchPageInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo3 = null;
        }
        QLog.i("ICGameBasePageFragment", 1, "onDestroy index = " + pageIndex + " roomid = " + switchPageInfo3.getRoomid());
        Kh(true);
        OrientationAutoChangeMgr orientationAutoChangeMgr = this.orientationAutoChangeMgr;
        if (orientationAutoChangeMgr != null) {
            orientationAutoChangeMgr.i();
        }
        BaseLiveAudienceView baseLiveAudienceView2 = this.roomView;
        if (baseLiveAudienceView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView2 = null;
        }
        baseLiveAudienceView2.d(this);
        BaseLiveAudienceView baseLiveAudienceView3 = this.roomView;
        if (baseLiveAudienceView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
        } else {
            baseLiveAudienceView = baseLiveAudienceView3;
        }
        baseLiveAudienceView.j();
        Nh();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.mobileqq.icgame.base.room.multipage.api.d dVar = this.viewPager;
        if (dVar != null) {
            dVar.a(this.pageListener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void onOrientationChange(boolean isLandscape) {
        QLog.i("ICGameBasePageFragment", 1, "onOrientationChange isLandscape = " + isLandscape);
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            return;
        }
        this.landscape = isLandscape;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.k(this.landscape);
        if (isLandscape) {
            v.c(requireActivity().getWindow().getDecorView());
        } else {
            v.a(requireActivity().getWindow().getDecorView());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.e(this);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QQLiveFloatWindowManager.f115256a.p();
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QQLiveFloatWindowManager.f115256a.p();
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.g(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        BaseLiveAudienceView baseLiveAudienceView = this.roomView;
        if (baseLiveAudienceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomView");
            baseLiveAudienceView = null;
        }
        baseLiveAudienceView.h(this);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Long l3;
        super.setUserVisibleHint(isVisibleToUser);
        if (this.roomView == null) {
            return;
        }
        SwitchPageInfo switchPageInfo = this.pageInfo;
        SwitchPageInfo switchPageInfo2 = null;
        if (switchPageInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            switchPageInfo = null;
        }
        QLog.i("ICGameBasePageFragment", 1, "isVisibleToUser=" + isVisibleToUser + ", roomId=" + switchPageInfo.getRoomid());
        if (isVisibleToUser) {
            BaseRoomInfo q16 = ((fu0.c) qx0.a.b(fu0.c.class)).q(0L);
            if (q16 != null) {
                l3 = Long.valueOf(q16.getRoomId());
            } else {
                l3 = null;
            }
            SwitchPageInfo switchPageInfo3 = this.pageInfo;
            if (switchPageInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
            } else {
                switchPageInfo2 = switchPageInfo3;
            }
            long roomid = switchPageInfo2.getRoomid();
            if ((l3 == null || l3.longValue() != roomid) && l3 != null) {
                QQLiveFloatWindowManager.f115256a.k(l3.longValue());
            }
            Jh();
            return;
        }
        Kh(false);
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.a
    public void v1(@NotNull com.tencent.mobileqq.icgame.base.room.multipage.api.e operationListener) {
        Intrinsics.checkNotNullParameter(operationListener, "operationListener");
        this.pageOperationListener = operationListener;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/frame/page/BasePageFragment$e", "Lcom/tencent/mobileqq/icgame/base/room/multipage/controller/a;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "y0", "t1", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements com.tencent.mobileqq.icgame.base.room.multipage.controller.a {
        e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            BasePageFragment.this.Dh().a(positionOffsetPixels);
        }

        @Override // com.tencent.mobileqq.icgame.base.room.multipage.controller.a
        public void t1() {
        }

        @Override // com.tencent.mobileqq.icgame.base.room.multipage.controller.a
        public void y0() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
        }
    }
}
