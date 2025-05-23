package com.tencent.icgame.game.live.impl.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.game.live.impl.danmuku.EsportsDanmakuView;
import com.tencent.icgame.game.live.impl.danmuku.f;
import com.tencent.icgame.game.live.impl.video.GameLiveView;
import com.tencent.icgame.game.ui.widget.CommonButton;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.m;
import com.tencent.xweb.FileReaderHelper;
import fv0.d;
import fv0.e;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0081\u0001B'\b\u0007\u0012\u0006\u0010z\u001a\u00020y\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{\u0012\b\b\u0002\u0010}\u001a\u00020\b\u00a2\u0006\u0004\b~\u0010\u007fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0003J\b\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u0006H\u0002R\"\u00106\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010,\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00108R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010<R\u0014\u0010>\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010,R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010,R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010,R\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010CR\u0016\u0010F\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010CR\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010Y\u001a\u00020T8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010_\u001a\u00020Z8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001a\u0010b\u001a\u00020Z8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b`\u0010\\\u001a\u0004\ba\u0010^R\u001a\u0010g\u001a\u00020\u00018\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR$\u0010h\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010n\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010x\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/icgame/game/live/impl/video/GameLiveView;", "Landroid/widget/FrameLayout;", "Lfv0/e;", "Landroidx/lifecycle/LifecycleOwner;", "Lfv0/g;", "player", "", "setVideoPlayer", "", "status", "setStatus", "Lfv0/d;", "liveStatusListener", "setStatusListener", "", FileReaderHelper.TXT_EXT, "g", "i", "", "show", "f", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "holderByPlayer", "setPlayerShouldHoldTouchEvent", "url", "E", "degree", "setVideoRotation", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setLiveVolume", "Lfv0/b;", "gameLiveEventListener", "setGameLiveEventListener", "Lfv0/f;", "liveGestureListener", "setGameLiveGestureListener", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "d", "e", h.F, BdhLogUtil.LogTag.Tag_Conn, "B", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "eventId", UserInfo.SEX_FEMALE, "v", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "()I", "G", "(I)V", "curGestureStatus", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "gestureDetector", "touchSlop", "Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "maxVolume", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curVolume", "curLivePlayStatus", "D", "Z", "shouldHoldTouchEvent", "isMiniWindow", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPlayerInited", "Lcom/tencent/icgame/game/live/impl/danmuku/f;", "H", "Lcom/tencent/icgame/game/live/impl/danmuku/f;", "danmakuView", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "netInfoHandler", "J", "Ljava/lang/String;", "curUrl", "Lcom/tencent/icgame/game/ui/widget/CommonButton;", "K", "Lcom/tencent/icgame/game/ui/widget/CommonButton;", "getTipBtn", "()Lcom/tencent/icgame/game/ui/widget/CommonButton;", "tipBtn", "Landroid/widget/LinearLayout;", "L", "Landroid/widget/LinearLayout;", "getConfirmContainer", "()Landroid/widget/LinearLayout;", "confirmContainer", "M", "getConfirmTipContainer", "confirmTipContainer", "N", "Landroid/widget/FrameLayout;", "getOuter_view_container", "()Landroid/widget/FrameLayout;", "outer_view_container", "gameLiveStatusListener", "Lfv0/d;", "y", "()Lfv0/d;", "setGameLiveStatusListener", "(Lfv0/d;)V", "eventListener", "Lfv0/b;", "getEventListener", "()Lfv0/b;", "setEventListener", "(Lfv0/b;)V", "Lfv0/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lfv0/f;", "setLiveGestureListener", "(Lfv0/f;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "P", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class GameLiveView extends FrameLayout implements e, LifecycleOwner {

    /* renamed from: C, reason: from kotlin metadata */
    private int curLivePlayStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean shouldHoldTouchEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMiniWindow;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isStopped;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isPlayerInited;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private f danmakuView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private INetInfoHandler netInfoHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String curUrl;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final CommonButton tipBtn;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout confirmContainer;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout confirmTipContainer;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout outer_view_container;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curGestureStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GestureDetector gestureDetector;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleRegistry lifecycleRegistry;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int maxVolume;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curVolume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/icgame/game/live/impl/video/GameLiveView$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "onSingleTapUp", "onSingleTapConfirmed", "onContextClick", "onDoubleTap", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
        public boolean onContextClick(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            GameLiveView.this.z();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            GameLiveView.this.z();
            GameLiveView.this.G(0);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            int curGestureStatus = GameLiveView.this.getCurGestureStatus();
            if (curGestureStatus != 0) {
                if (curGestureStatus == 1) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, (int) ((distanceY / (GameLiveView.this.getHeight() / (GameLiveView.this.maxVolume * 2))) + GameLiveView.this.curVolume));
                    RangesKt___RangesKt.coerceAtMost(100, coerceAtLeast);
                    GameLiveView.this.z();
                }
            } else if ((Math.abs(distanceX) > GameLiveView.this.touchSlop || Math.abs(distanceY) > GameLiveView.this.touchSlop) && Math.abs(distanceY) > Math.abs(distanceX) && e16.getX() >= GameLiveView.this.getWidth() / 2) {
                GameLiveView.this.G(1);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            GameLiveView.this.z();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            GameLiveView.this.z();
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/live/impl/video/GameLiveView$b", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "p0", "", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements INetInfoHandler {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(GameLiveView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(GameLiveView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(GameLiveView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(GameLiveView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.v();
            if (this$0.isStopped) {
                this$0.E(this$0.curUrl);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            g.h("ICGameGameLiveView", "onNetMobile2None");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String p06) {
            g.h("ICGameGameLiveView", "onNetMobile2Wifi: " + p06);
            final GameLiveView gameLiveView = GameLiveView.this;
            gameLiveView.post(new Runnable() { // from class: kv0.f
                @Override // java.lang.Runnable
                public final void run() {
                    GameLiveView.b.e(GameLiveView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String p06) {
            g.h("ICGameGameLiveView", "onNetNone2Mobile: " + p06);
            final GameLiveView gameLiveView = GameLiveView.this;
            gameLiveView.post(new Runnable() { // from class: kv0.h
                @Override // java.lang.Runnable
                public final void run() {
                    GameLiveView.b.f(GameLiveView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String p06) {
            g.h("ICGameGameLiveView", "onNetNone2Wifi: " + p06);
            final GameLiveView gameLiveView = GameLiveView.this;
            gameLiveView.post(new Runnable() { // from class: kv0.g
                @Override // java.lang.Runnable
                public final void run() {
                    GameLiveView.b.g(GameLiveView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String p06) {
            g.h("ICGameGameLiveView", "onNetWifi2Mobile: " + p06);
            final GameLiveView gameLiveView = GameLiveView.this;
            gameLiveView.post(new Runnable() { // from class: kv0.i
                @Override // java.lang.Runnable
                public final void run() {
                    GameLiveView.b.h(GameLiveView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            g.h("ICGameGameLiveView", "onNetWifi2None");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameLiveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        this.confirmContainer.setVisibility(8);
    }

    private final void B() {
        if (this.isMiniWindow || this.danmakuView != null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EsportsDanmakuView esportsDanmakuView = new EsportsDanmakuView(context, null, 0, 6, null);
        esportsDanmakuView.l();
        addView(esportsDanmakuView, 0);
        this.danmakuView = esportsDanmakuView;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void C() {
        setOnTouchListener(new View.OnTouchListener() { // from class: kv0.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = GameLiveView.D(GameLiveView.this, view, motionEvent);
                return D;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(GameLiveView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.shouldHoldTouchEvent) {
            return this$0.gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    private final void F(String eventId) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "em_icgame_notwifi_continue");
        hashMap.put("dt_pgid", "pg_icgame_audience");
        hashMap.putAll(xw0.b.f448881a.e());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(eventId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(GameLiveView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g.h("ICGameGameLiveView", "setStatus oldStatus: " + this$0.curLivePlayStatus + " new status " + i3);
        this$0.curLivePlayStatus = i3;
    }

    private final void I() {
        if (this.confirmContainer.getVisibility() != 0) {
            F("dt_imp");
        }
        this.confirmContainer.setVisibility(0);
    }

    private final void s() {
        this.tipBtn.setOnClickListener(new View.OnClickListener() { // from class: kv0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameLiveView.t(GameLiveView.this, view);
            }
        });
        this.confirmContainer.setOnClickListener(new View.OnClickListener() { // from class: kv0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameLiveView.u(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GameLiveView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gv0.b.f403419a.c();
        this$0.getClass();
        QQToast.makeText(this$0.getContext(), "\u5f53\u524d\u975ewifi\u73af\u5883\uff0c\u6ce8\u610f\u6d41\u91cf\u6d88\u8017\u54e6", 0).show();
        this$0.F("dt_clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!bVar.a(context)) {
            g.h("ICGameGameLiveView", "don't play in 4G");
            E(this.curUrl);
            a(this.curUrl);
            g.h("ICGameGameLiveView", "prepareWithCurrentUrl and hideErrorView");
            postDelayed(new Runnable() { // from class: kv0.e
                @Override // java.lang.Runnable
                public final void run() {
                    GameLiveView.w(GameLiveView.this);
                }
            }, 300L);
            return;
        }
        g.h("ICGameGameLiveView", "play in 4G");
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GameLiveView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
    }

    public void E(@Nullable String url) {
        setStatus(fv0.h.f400840b);
        g.h("ICGameGameLiveView", "pause call ");
    }

    protected final void G(int i3) {
        this.curGestureStatus = i3;
    }

    @Override // fv0.a
    public void d() {
        f fVar = this.danmakuView;
        if (fVar != null) {
            fVar.onStart();
        }
    }

    @Override // fv0.a
    public void e() {
        f fVar = this.danmakuView;
        if (fVar != null) {
            fVar.onStop();
        }
    }

    @Override // fv0.a
    public void f(boolean show) {
        g.h("ICGameGameLiveView", "showDanmaku call " + show);
        if (show) {
            f fVar = this.danmakuView;
            if (fVar != null) {
                fVar.start();
                return;
            }
            return;
        }
        f fVar2 = this.danmakuView;
        if (fVar2 != null) {
            fVar2.stop();
        }
    }

    @Override // fv0.a
    public void g(@NotNull String txt) {
        f fVar;
        Intrinsics.checkNotNullParameter(txt, "txt");
        g.a("ICGameGameLiveView", "push self normal danmaku: " + txt);
        if (!TextUtils.equals("\u6536\u85cf\u4e86\u4e3b\u64ad", txt) && (fVar = this.danmakuView) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            f.a.b(fVar, context, txt, getResources().getColor(R.color.f158017al3), 0, 8, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // fv0.a
    public void h() {
        f fVar = this.danmakuView;
        if (fVar != null) {
            fVar.onDestroy();
        }
    }

    @Override // fv0.a
    public void i(@NotNull String txt) {
        f fVar;
        Intrinsics.checkNotNullParameter(txt, "txt");
        g.a("ICGameGameLiveView", "push normal danmaku: " + txt);
        if (!TextUtils.equals("\u6536\u85cf\u4e86\u4e3b\u64ad", txt) && (fVar = this.danmakuView) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            f.a.a(fVar, context, txt, getResources().getColor(R.color.f158017al3), 0, 8, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setVideoRotation(-90);
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        m.a().c(this.netInfoHandler);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        View view;
        super.onDetachedFromWindow();
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        f fVar = this.danmakuView;
        if (fVar != null && (view = fVar.getView()) != null) {
            removeView(view);
        }
        this.danmakuView = null;
        m.a().d(this.netInfoHandler);
    }

    public void setLiveVolume(int volume) {
        this.curVolume = volume;
    }

    public void setPlayerShouldHoldTouchEvent(boolean holderByPlayer) {
        this.shouldHoldTouchEvent = holderByPlayer;
    }

    public void setStatus(final int status) {
        if (status != this.curLivePlayStatus) {
            post(new Runnable() { // from class: kv0.b
                @Override // java.lang.Runnable
                public final void run() {
                    GameLiveView.H(GameLiveView.this, status);
                }
            });
        }
    }

    public void setVideoPlayer(@NotNull fv0.g player) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    /* renamed from: x, reason: from getter */
    protected final int getCurGestureStatus() {
        return this.curGestureStatus;
    }

    @Nullable
    protected final d y() {
        return null;
    }

    @Nullable
    public final fv0.f z() {
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameLiveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GameLiveView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameLiveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lifecycleRegistry = new LifecycleRegistry(this);
        this.maxVolume = 100;
        this.curVolume = 50;
        this.curLivePlayStatus = fv0.h.f400839a;
        this.shouldHoldTouchEvent = true;
        this.isPlayerInited = new AtomicBoolean(false);
        this.curUrl = "";
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
        this.outer_view_container = (FrameLayout) findViewById4;
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.gestureDetector = new GestureDetector(getContext(), new a());
        this.netInfoHandler = new b();
        s();
        C();
        B();
    }

    public final void setEventListener(@Nullable fv0.b bVar) {
    }

    public void setGameLiveEventListener(@Nullable fv0.b gameLiveEventListener) {
    }

    public void setGameLiveGestureListener(@Nullable fv0.f liveGestureListener) {
    }

    public final void setLiveGestureListener(@Nullable fv0.f fVar) {
    }

    public void setStatusListener(@Nullable d liveStatusListener) {
    }

    public void setVideoRotation(int degree) {
    }
}
