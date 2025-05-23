package com.tencent.mobileqq.icgame.room.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.ui.widget.CommonButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.room.player.ICGameLiveView;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010k\u001a\u00020j\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l\u0012\b\b\u0002\u0010n\u001a\u00020\u0013\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020-H\u0016R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010=\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010FR\u0016\u0010I\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010?R\u0018\u0010L\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010[R\"\u0010b\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b]\u00105\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u00105R\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020f0e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010h\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/player/ICGameLiveView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/icgame/room/player/j;", "Landroidx/lifecycle/LifecycleOwner;", "", "v", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "", "eventId", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/icgame/room/player/k;", "player", "setVideoPlayer", "Lfv0/f;", "liveGestureListener", "setGameLiveGestureListener", "", "status", "setStatus", "Lcom/tencent/mobileqq/icgame/room/player/i;", "liveStatusListener", "setStatusListener", "b", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "getView", "url", "play", "", "holderByPlayer", "setPlayerShouldHoldTouchEvent", "pause", "resume", "stop", "degree", "setVideoRotation", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "onResume", DKHippyEvent.EVENT_STOP, "view", "Landroid/widget/FrameLayout$LayoutParams;", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleRegistry;", "d", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "e", "I", "curLivePlayStatus", "f", "Lcom/tencent/mobileqq/icgame/room/player/i;", "t", "()Lcom/tencent/mobileqq/icgame/room/player/i;", "setGameLiveStatusListener", "(Lcom/tencent/mobileqq/icgame/room/player/i;)V", "gameLiveStatusListener", tl.h.F, "Z", "shouldHoldTouchEvent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPlayerInited", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "netInfoHandler", BdhLogUtil.LogTag.Tag_Conn, "isStopped", "D", "Ljava/lang/String;", "curUrl", "Lcom/tencent/icgame/game/ui/widget/CommonButton;", "E", "Lcom/tencent/icgame/game/ui/widget/CommonButton;", "tipBtn", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "outerViewContainer", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "confirmContainer", "H", "confirmTipContainer", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "J", ReportConstant.COSTREPORT_PREFIX, "()I", "y", "(I)V", "curGestureStatus", "K", "touchSlop", "Lkotlin/Lazy;", "Landroid/view/GestureDetector;", "L", "Lkotlin/Lazy;", "gestureDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class ICGameLiveView extends FrameLayout implements j, LifecycleOwner {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isStopped;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String curUrl;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final CommonButton tipBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout outerViewContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout confirmContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout confirmTipContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: J, reason: from kotlin metadata */
    private int curGestureStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private Lazy<? extends GestureDetector> gestureDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleRegistry lifecycleRegistry;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curLivePlayStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i gameLiveStatusListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean shouldHoldTouchEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isPlayerInited;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final INetInfoHandler netInfoHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/player/ICGameLiveView$a", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "p0", "", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements INetInfoHandler {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ICGameLiveView this$0, i it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0.mAegisLog.i("ICGameIvGameLiveView", "onNetMobile2Wifi run, isStopped:" + this$0.isStopped);
            if (!this$0.isStopped) {
                it.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ICGameLiveView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(ICGameLiveView this$0, i it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0.mAegisLog.i("ICGameIvGameLiveView", "onNetNone2Wifi run, isStopped:" + this$0.isStopped);
            if (!this$0.isStopped) {
                it.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ICGameLiveView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.mAegisLog.i("ICGameIvGameLiveView", "onNetNone2Mobile run");
            this$0.q();
            if (this$0.isStopped) {
                this$0.pause(this$0.curUrl);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            ICGameLiveView.this.mAegisLog.i("ICGameIvGameLiveView", "onNetMobile2None");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String p06) {
            ICGameLiveView.this.mAegisLog.i("ICGameIvGameLiveView", "onNetMobile2Wifi: " + p06 + " isStopped:" + ICGameLiveView.this.isStopped);
            final i gameLiveStatusListener = ICGameLiveView.this.getGameLiveStatusListener();
            if (gameLiveStatusListener != null) {
                final ICGameLiveView iCGameLiveView = ICGameLiveView.this;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.player.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ICGameLiveView.a.e(ICGameLiveView.this, gameLiveStatusListener);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String p06) {
            ICGameLiveView.this.mAegisLog.i("ICGameIvGameLiveView", "onNetNone2Mobile: " + p06);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ICGameLiveView iCGameLiveView = ICGameLiveView.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.player.g
                @Override // java.lang.Runnable
                public final void run() {
                    ICGameLiveView.a.f(ICGameLiveView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String p06) {
            ICGameLiveView.this.mAegisLog.i("ICGameIvGameLiveView", "onNetNone2Wifi: " + p06 + " isStopped:" + ICGameLiveView.this.isStopped);
            final i gameLiveStatusListener = ICGameLiveView.this.getGameLiveStatusListener();
            if (gameLiveStatusListener != null) {
                final ICGameLiveView iCGameLiveView = ICGameLiveView.this;
                iCGameLiveView.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.player.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ICGameLiveView.a.g(ICGameLiveView.this, gameLiveStatusListener);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String p06) {
            ICGameLiveView.this.mAegisLog.i("ICGameIvGameLiveView", "onNetWifi2Mobile: " + p06);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ICGameLiveView iCGameLiveView = ICGameLiveView.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.player.f
                @Override // java.lang.Runnable
                public final void run() {
                    ICGameLiveView.a.h(ICGameLiveView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            ICGameLiveView.this.mAegisLog.i("ICGameIvGameLiveView", "onNetWifi2None");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameLiveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        if (this.confirmContainer.getVisibility() != 0) {
            x("dt_imp");
        }
        this.confirmContainer.setVisibility(0);
    }

    public static final /* synthetic */ fv0.f i(ICGameLiveView iCGameLiveView) {
        iCGameLiveView.getClass();
        return null;
    }

    private final void o() {
        this.tipBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.player.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ICGameLiveView.p(ICGameLiveView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ICGameLiveView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gv0.b.f403419a.c();
        i iVar = this$0.gameLiveStatusListener;
        if (iVar != null) {
            iVar.a();
        }
        QQToast.makeText(this$0.getContext(), "\u5f53\u524d\u975ewifi\u73af\u5883\uff0c\u6ce8\u610f\u6d41\u91cf\u6d88\u8017\u54e6", 0).show();
        this$0.x("dt_clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        i iVar;
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!bVar.a(context)) {
            this.mAegisLog.i("ICGameIvGameLiveView", "don't play in 4G");
            pause(this.curUrl);
            a(this.curUrl);
            i iVar2 = this.gameLiveStatusListener;
            if (iVar2 != null) {
                iVar2.hideErrorView();
            }
            this.mAegisLog.i("ICGameIvGameLiveView", "prepareWithCurrentUrl and hideErrorView");
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.player.d
                @Override // java.lang.Runnable
                public final void run() {
                    ICGameLiveView.r(ICGameLiveView.this);
                }
            }, 300L);
            return;
        }
        this.mAegisLog.i("ICGameIvGameLiveView", "play in 4G isStopped:" + this.isStopped);
        u();
        if (!this.isStopped && (iVar = this.gameLiveStatusListener) != null) {
            iVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ICGameLiveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    private final void u() {
        this.confirmContainer.setVisibility(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void v() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.icgame.room.player.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w3;
                w3 = ICGameLiveView.w(ICGameLiveView.this, view, motionEvent);
                return w3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(ICGameLiveView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.shouldHoldTouchEvent) {
            return this$0.gestureDetector.getValue().onTouchEvent(motionEvent);
        }
        return false;
    }

    private final void x(String eventId) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "em_icgame_notwifi_continue");
        hashMap.put("dt_pgid", "pg_icgame_audience");
        hashMap.putAll(xw0.b.f448881a.e());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(eventId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ICGameLiveView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAegisLog.i("ICGameIvGameLiveView", "setStatus oldStatus: " + this$0.curLivePlayStatus + " new status " + i3);
        this$0.curLivePlayStatus = i3;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void b(@Nullable i liveStatusListener) {
        if (Intrinsics.areEqual(this.gameLiveStatusListener, liveStatusListener)) {
            this.gameLiveStatusListener = null;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public void m(@NotNull View view, @NotNull FrameLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(params, "params");
        this.outerViewContainer.addView(view, params);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setVideoRotation(-90);
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        com.tencent.timi.game.utils.m.a().c(this.netInfoHandler);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        com.tencent.timi.game.utils.m.a().d(this.netInfoHandler);
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void onResume() {
        this.mAegisLog.i("ICGameIvGameLiveView", "onResume");
        this.isStopped = false;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void onStop() {
        this.mAegisLog.i("ICGameIvGameLiveView", DKHippyEvent.EVENT_STOP);
        this.isStopped = true;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void pause(@Nullable String url) {
        setStatus(l.f237715c);
        this.mAegisLog.i("ICGameIvGameLiveView", "pause call ");
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void play(@Nullable String url) {
        this.mAegisLog.i("ICGameIvGameLiveView", "play call ");
        this.curUrl = url;
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!bVar.a(context)) {
            if (this.curLivePlayStatus == l.f237717e) {
                stop(url);
            }
            A();
        } else {
            u();
            setStatus(l.f237714b);
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void resume(@Nullable String url) {
        setStatus(l.f237717e);
        this.mAegisLog.i("ICGameIvGameLiveView", "resume call ");
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!bVar.a(context)) {
            stop(url);
            A();
            return;
        }
        u();
        i iVar = this.gameLiveStatusListener;
        if (iVar != null) {
            iVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s, reason: from getter */
    public final int getCurGestureStatus() {
        return this.curGestureStatus;
    }

    public void setPlayerShouldHoldTouchEvent(boolean holderByPlayer) {
        this.shouldHoldTouchEvent = holderByPlayer;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void setStatus(final int status) {
        if (status != this.curLivePlayStatus) {
            post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.player.a
                @Override // java.lang.Runnable
                public final void run() {
                    ICGameLiveView.z(ICGameLiveView.this, status);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void setStatusListener(@Nullable i liveStatusListener) {
        this.gameLiveStatusListener = liveStatusListener;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void setVideoPlayer(@NotNull k player) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void stop(@Nullable String url) {
        setStatus(l.f237716d);
        this.mAegisLog.i("ICGameIvGameLiveView", "stop call ");
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    protected final i getGameLiveStatusListener() {
        return this.gameLiveStatusListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y(int i3) {
        this.curGestureStatus = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameLiveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ICGameLiveView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameLiveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy<? extends GestureDetector> lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.lifecycleRegistry = new LifecycleRegistry(this);
        this.curLivePlayStatus = l.f237713a;
        this.shouldHoldTouchEvent = true;
        this.isPlayerInited = new AtomicBoolean(false);
        this.curUrl = "";
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.icgame.room.player.ICGameLiveView$gestureDetector$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/icgame/room/player/ICGameLiveView$gestureDetector$1$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "onSingleTapUp", "onSingleTapConfirmed", "onContextClick", "onDoubleTap", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a extends GestureDetector.SimpleOnGestureListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ICGameLiveView f237701d;

                a(ICGameLiveView iCGameLiveView) {
                    this.f237701d = iCGameLiveView;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
                public boolean onContextClick(@NotNull MotionEvent e16) {
                    Intrinsics.checkNotNullParameter(e16, "e");
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(@NotNull MotionEvent e16) {
                    Intrinsics.checkNotNullParameter(e16, "e");
                    ICGameLiveView.i(this.f237701d);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(@NotNull MotionEvent e16) {
                    Intrinsics.checkNotNullParameter(e16, "e");
                    ICGameLiveView.i(this.f237701d);
                    this.f237701d.y(0);
                    return true;
                }

                /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:
                
                    if (r4 > r1) goto L9;
                 */
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
                    int i3;
                    int i16;
                    Intrinsics.checkNotNullParameter(e16, "e1");
                    Intrinsics.checkNotNullParameter(e26, "e2");
                    if (this.f237701d.getCurGestureStatus() == 0) {
                        float abs = Math.abs(distanceX);
                        i3 = this.f237701d.touchSlop;
                        if (abs <= i3) {
                            float abs2 = Math.abs(distanceY);
                            i16 = this.f237701d.touchSlop;
                        }
                        if (Math.abs(distanceY) > Math.abs(distanceX) && e16.getX() >= this.f237701d.getWidth() / 2) {
                            this.f237701d.y(1);
                        }
                    }
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
                    Intrinsics.checkNotNullParameter(e16, "e");
                    ICGameLiveView.i(this.f237701d);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(@NotNull MotionEvent e16) {
                    Intrinsics.checkNotNullParameter(e16, "e");
                    ICGameLiveView.i(this.f237701d);
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                return new GestureDetector(ICGameLiveView.this.getContext(), new a(ICGameLiveView.this));
            }
        });
        this.gestureDetector = lazy;
        LayoutInflater.from(getContext()).inflate(R.layout.fbz, this);
        View findViewById = findViewById(R.id.f97635kx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tipBtn)");
        this.tipBtn = (CommonButton) findViewById;
        View findViewById2 = findViewById(R.id.f164880u43);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.confirmContainer)");
        this.confirmContainer = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.u46);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.confirmTipContainer)");
        this.confirmTipContainer = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f217601w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.outer_view_container)");
        this.outerViewContainer = (FrameLayout) findViewById4;
        o();
        this.netInfoHandler = new a();
        v();
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void setGameLiveGestureListener(@Nullable fv0.f liveGestureListener) {
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void setVideoRotation(int degree) {
    }
}
