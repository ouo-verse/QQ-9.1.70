package com.tencent.timi.game.liveroom.impl.room.floating;

import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule;
import com.tencent.timi.game.liveroom.impl.room.floating.TGLiveAudienceFloatingView;
import com.tencent.timi.game.liveroom.impl.room.playtogether.LiveTeamStatusInfo;
import com.tencent.timi.game.utils.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.ac;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import uh4.c;
import uh4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001Y\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002n#B'\b\u0007\u0012\u0006\u0010g\u001a\u00020f\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\b\b\u0002\u0010j\u001a\u00020\u0010\u00a2\u0006\u0004\bk\u0010lJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010*R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010.R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00100R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\b\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010G\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0016\u0010M\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\u001dR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010VR\u0016\u0010X\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010SR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010ZR\"\u0010b\u001a\u00020\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010d\u00a8\u0006o"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView;", "Landroid/widget/FrameLayout;", "Luh4/d;", "", "mute", "hide", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "J", "show", "O", "Landroid/view/View;", "view", "", "roundCorners", "M", "", "width", "height", BdhLogUtil.LogTag.Tag_Req, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "viewGroup", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/api/room/ILiveAudienceTPPlayerRoom;", "G", "B", "", "data", "I", "onShow", "onHide", "b", "e", "onBackground", "d", "getView", "Luh4/c;", "f", "", "roomId", "K", "Landroid/content/Intent;", "resumeIntent", "N", "Ljg4/b;", "Ljg4/b;", "liveRoomService", "Landroid/content/Intent;", "H", "()J", "setRoomId", "(J)V", "Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", tl.h.F, "Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "getAudienceRoom", "()Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "setAudienceRoom", "(Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;)V", "audienceRoom", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "i", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "getRoomStatusListener", "()Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "setRoomStatusListener", "(Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;)V", "roomStatusListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isGameLive", "()Z", "setGameLive", "(Z)V", "curWidth", "D", "curHeight", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "E", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "netInfoHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "loadVideoTimeOutTask", "Lnr2/ac;", "Lnr2/ac;", "binding", "backgroundHeartBeat", "com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$g", "Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$g;", "timiCmdListener", "Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "getSurfaceCallback", "()Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "setSurfaceCallback", "(Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;)V", "surfaceCallback", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "roomPlayerListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveAudienceFloatingView extends FrameLayout implements uh4.d {

    /* renamed from: C, reason: from kotlin metadata */
    private int curWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int curHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private INetInfoHandler netInfoHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Runnable loadVideoTimeOutTask;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ac binding;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Runnable backgroundHeartBeat;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final g timiCmdListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ITPPlayerVideoView.IVideoSurfaceCallback surfaceCallback;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final AudienceRoomPlayerListener roomPlayerListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private jg4.b liveRoomService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent resumeIntent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IAudienceRoom audienceRoom;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveRoomStatusListener roomStatusListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isGameLive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$b", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/LiveRoomStatusListener;", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "", "onRoomOpen", "onRoomClose", "onRoomPause", "onRoomResume", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements LiveRoomStatusListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomClose(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            TGLiveFloatManager.f377649d.f(TGLiveAudienceFloatingView.this.getRoomId());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomOpen(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomPause(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomResume(@NotNull QQLiveRoomStatusInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    /* compiled from: P */
    @RequiresApi(api = 21)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$d;", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "", "a", UserInfo.SEX_FEMALE, "mRadius", "<init>", "(F)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final float mRadius;

        public d(float f16) {
            this.mRadius = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.mRadius);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$e", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/AudienceRoomPlayerListener;", "", "startTime", "endTime", "", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "onPlayCompleted", "errorCode", "", "msg", "onError", "onResume", "onStartBuffer", "onStopBuffer", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends AudienceRoomPlayerListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f420779g.setVisibility(4);
            this$0.binding.f420777e.setVisibility(0);
            this$0.O(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f420779g.setVisibility(4);
            this$0.binding.f420777e.setVisibility(4);
            this$0.O(false);
            this$0.removeCallbacks(this$0.loadVideoTimeOutTask);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f420779g.setVisibility(4);
            this$0.binding.f420777e.setVisibility(4);
            this$0.O(false);
            this$0.removeCallbacks(this$0.loadVideoTimeOutTask);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f420779g.setVisibility(4);
            this$0.binding.f420777e.setVisibility(4);
            this$0.O(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f420779g.setVisibility(0);
            this$0.binding.f420777e.setVisibility(4);
            this$0.O(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f420779g.setVisibility(4);
            this$0.binding.f420777e.setVisibility(4);
            this$0.O(false);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onError(int errorCode, @Nullable String msg2) {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onError:" + errorCode + " ,msg:" + msg2);
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.m
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.e.g(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onFirstFrameCome(long startTime, long endTime) {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onFirstFrameCome");
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.n
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.e.h(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPause() {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onPause");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPlay() {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onPlay");
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.r
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.e.i(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPlayCompleted() {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onPlayCompleted");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onResume() {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onResume");
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.q
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.e.j(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onStartBuffer() {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onStartBuffer");
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.p
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.e.k(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onStopBuffer() {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "AudienceRoomPlayerListener onStopBuffer");
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.o
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.e.l(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onVideoSizeChanged(int width, int height) {
            QLog.i("TGLiveFloatManager", 1, "onVideoSizeChanged width:" + width + " , height:" + height);
            TGLiveAudienceFloatingView.this.B(width, height);
            TGLiveAudienceFloatingView.this.R(width, height);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$f", "Lcom/tencent/mobileqq/qqlive/api/room/ITPPlayerVideoView$IVideoSurfaceCallback;", "", "surfaceOrHolder", "", "onSurfaceCreated", "onSurfaceDestroy", "onSurfaceChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements ITPPlayerVideoView.IVideoSurfaceCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoSurfaceCallback
        public void onSurfaceChanged(@Nullable Object surfaceOrHolder) {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "IVideoSurfaceCallback onSurfaceChanged:" + surfaceOrHolder);
        }

        @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoSurfaceCallback
        public void onSurfaceCreated(@Nullable Object surfaceOrHolder) {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "IVideoSurfaceCallback onSurfaceCreated:" + surfaceOrHolder);
            TGLiveAudienceFloatingView.this.C();
        }

        @Override // com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoSurfaceCallback
        public void onSurfaceDestroy(@Nullable Object surfaceOrHolder) {
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "IVideoSurfaceCallback onSurfaceDestroy:" + surfaceOrHolder);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveAudienceFloatingView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int width, int height) {
        ITPPlayerVideoView displayView;
        int i3;
        IAudienceRoom y16 = this.liveRoomService.y(this.roomId);
        if ((y16 instanceof ILiveAudienceTPPlayerRoom) && (displayView = ((ILiveAudienceTPPlayerRoom) y16).getDisplayView()) != null) {
            if (width > height) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            QLog.i("TGLiveFloatManager", 1, "setXYAxis " + i3 + ", " + this.roomId);
            displayView.setXYAxis(i3);
            displayView.getCurrentDisplayView().requestLayout();
            jg4.d O0 = this.liveRoomService.O0(this.roomId);
            if (O0 != null) {
                O0.f409906b = i3;
                this.liveRoomService.H2(O0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.i
            @Override // java.lang.Runnable
            public final void run() {
                TGLiveAudienceFloatingView.D(TGLiveAudienceFloatingView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final TGLiveAudienceFloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ji4.a aVar = ji4.a.f409945a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!aVar.a(context)) {
            w.d(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.j
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.E(TGLiveAudienceFloatingView.this);
                }
            }, 300L);
            return;
        }
        this$0.O(false);
        ILiveAudienceTPPlayerRoom G = this$0.G();
        if (G != null) {
            G.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TGLiveAudienceFloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ILiveAudienceTPPlayerRoom G = this$0.G();
        if (G != null) {
            G.pause();
        }
        this$0.O(true);
    }

    private final boolean F(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (Intrinsics.areEqual(viewGroup.getChildAt(i3), view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILiveAudienceTPPlayerRoom G() {
        ILiveRoom z16 = ((jg4.b) mm4.b.b(jg4.b.class)).z(0L);
        if (z16 instanceof ILiveAudienceTPPlayerRoom) {
            return (ILiveAudienceTPPlayerRoom) z16;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(byte[] data) {
        MessageOuterClass$TimMsgBody a16 = zk4.a.f452717a.a(data);
        if (a16 == null) {
            return;
        }
        com.tencent.timi.game.utils.l.h("TGLiveFloatManager", 1, "handleCmdMsg type:" + a16.msg_type.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        removeCallbacks(this.backgroundHeartBeat);
        postDelayed(this.backgroundHeartBeat, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(TGLiveAudienceFloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.binding.f420777e.setVisibility(0);
        this$0.binding.f420779g.setVisibility(8);
        this$0.O(false);
    }

    private final void M(View view, float roundCorners) {
        view.setOutlineProvider(new d(roundCorners));
        view.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(final boolean show) {
        w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.h
            @Override // java.lang.Runnable
            public final void run() {
                TGLiveAudienceFloatingView.P(show, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(boolean z16, TGLiveAudienceFloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.binding.f420777e.setVisibility(8);
            this$0.binding.f420781i.setVisibility(0);
        } else {
            this$0.binding.f420781i.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(boolean mute, boolean hide) {
        if (hide) {
            setVisibility(4);
            uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), com.tencent.timi.game.utils.b.a(1), com.tencent.timi.game.utils.b.a(1));
        } else {
            setVisibility(0);
            uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), this.curWidth, this.curHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(int width, int height) {
        int i3;
        int i16;
        QLog.i("TGLiveFloatManager", 1, "updateFloatingViewSize, width " + width + ", height " + height);
        ITPPlayerVideoView G = this.liveRoomService.G();
        if (G != null && G.getCurrentDisplayView() != null) {
            G.getCurrentDisplayView().setKeepScreenOn(true);
            if (width != 0 && height != 0) {
                if (width > height) {
                    i3 = ViewUtils.dpToPx(99.0f);
                } else {
                    i3 = ViewUtils.dpToPx(176.0f);
                }
                i16 = ((int) ((i3 * width) / height)) - com.tencent.timi.game.utils.b.a(1);
            } else {
                i3 = 0;
                i16 = 0;
            }
            this.curWidth = i16;
            this.curHeight = i3;
            QLog.i("TGLiveFloatManager", 1, "updateFloatingViewSize, curWidth " + i16 + ", curHeight " + i3);
            uh4.a.INSTANCE.a().i(String.valueOf(this.roomId), i16, i3);
            return;
        }
        QLog.w("TGLiveFloatManager", 1, "updateFloatingViewSize, displayView == null !!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TGLiveAudienceFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TGLiveFloatManager.f377649d.f(this$0.roomId);
        SimpleEventBus.getInstance().dispatchEvent(new AudienceFloatCloseEvent(this$0.roomId));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(TGLiveAudienceFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = this$0.resumeIntent;
        if (intent != null) {
            intent.putExtra("open_from_float_window", true);
            intent.addFlags(67108864);
            TGLiveFloatManager.f377649d.o();
            BaseApplication.context.startActivity(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TGLiveAudienceFloatingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ILiveAudienceTPPlayerRoom G = this$0.G();
        if (G != null) {
            G.play();
        }
        this$0.binding.f420777e.setVisibility(8);
        this$0.binding.f420779g.setVisibility(0);
        this$0.postDelayed(this$0.loadVideoTimeOutTask, 10000L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TGLiveAudienceFloatingView this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        ILiveAudienceTPPlayerRoom G = this$0.G();
        if (G != null) {
            G.play();
        }
        ji4.a.f409945a.b();
        QQToast.makeText(context, "\u5f53\u524d\u975ewifi\u73af\u5883\uff0c\u6ce8\u610f\u6d41\u91cf\u6d88\u8017\u54e6", 0).show();
        this$0.O(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* renamed from: H, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public uh4.d K(long roomId) {
        this.roomId = roomId;
        return this;
    }

    @NotNull
    public final uh4.d N(@Nullable Intent resumeIntent) {
        this.resumeIntent = resumeIntent;
        return this;
    }

    @Override // uh4.d
    @NotNull
    /* renamed from: a */
    public uh4.b getFloatingAnimateInfo() {
        return d.a.a(this);
    }

    @Override // uh4.d
    public void b() {
        com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "floating onAttachFloat");
        TGLiveClientQIPCModule.INSTANCE.c().registerModule();
        ITPPlayerVideoView G = this.liveRoomService.G();
        if (G != null) {
            G.addSurfaceCallback(this.surfaceCallback);
        }
        ILiveAudienceTPPlayerRoom G2 = G();
        if (G2 != null) {
            G2.registerRoomPlayerListener(this.roomPlayerListener);
            Unit unit = Unit.INSTANCE;
            com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "registerRoomPlayerListener");
        }
        IAudienceRoom N = this.liveRoomService.N(this.roomId);
        this.audienceRoom = N;
        if (N != null) {
            N.registerRoomStatusListener(this.roomStatusListener);
        }
        ITPPlayerVideoView G3 = this.liveRoomService.G();
        if (G3 != null) {
            G3.getDisplayViewRect();
        }
        Object parent = getParent();
        if (parent != null && (parent instanceof View)) {
            M((View) parent, com.tencent.timi.game.utils.b.c(9));
        }
        this.liveRoomService.Y1(false).a(this.timiCmdListener);
    }

    @Override // uh4.d
    public void e() {
        com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "floating onDetachFloat");
        com.tencent.timi.game.utils.m.a().d(this.netInfoHandler);
        ITPPlayerVideoView G = this.liveRoomService.G();
        if (G != null) {
            G.removeSurfaceCallback(this.surfaceCallback);
        }
        ILiveAudienceTPPlayerRoom G2 = G();
        if (G2 != null) {
            G2.unRegisterRoomPlayerListener(this.roomPlayerListener);
        }
        IAudienceRoom iAudienceRoom = this.audienceRoom;
        if (iAudienceRoom != null) {
            iAudienceRoom.unRegisterRoomStatusListener(this.roomStatusListener);
        }
        removeCallbacks(this.loadVideoTimeOutTask);
        removeCallbacks(this.backgroundHeartBeat);
        this.liveRoomService.Y1(false).b(this.timiCmdListener);
    }

    @Override // uh4.d
    @NotNull
    public uh4.c f() {
        return new c.a().e(com.tencent.timi.game.utils.b.a(176), com.tencent.timi.game.utils.b.a(99)).c(com.tencent.timi.game.utils.b.a(12)).a();
    }

    @Override // uh4.d
    public void onHide() {
        QQLiveCurRoomInfo curRoomInfo;
        View currentDisplayView;
        com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "floating onHide");
        ITPPlayerVideoView G = this.liveRoomService.G();
        if (G != null && (currentDisplayView = G.getCurrentDisplayView()) != null) {
            currentDisplayView.setClipToOutline(false);
        }
        ITPPlayerVideoView G2 = this.liveRoomService.G();
        if (G2 != null) {
            G2.removeSurfaceCallback(this.surfaceCallback);
        }
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null && (curRoomInfo = f16.getCurRoomInfo()) != null) {
            Intrinsics.checkNotNullExpressionValue(curRoomInfo, "curRoomInfo");
            curRoomInfo.isFloatWindow = false;
            f16.recordCurRoomInfo(curRoomInfo);
        }
        com.tencent.timi.game.utils.m.a().d(this.netInfoHandler);
        removeCallbacks(this.loadVideoTimeOutTask);
        removeCallbacks(this.backgroundHeartBeat);
    }

    @Override // uh4.d
    public void onShow() {
        com.tencent.mobileqq.activity.richmedia.i iVar;
        View view;
        QQLiveCurRoomInfo curRoomInfo;
        com.tencent.timi.game.utils.l.i("TGLiveFloatManager", "floating onShow");
        TGLiveClientQIPCModule.INSTANCE.c().registerModule();
        ITPPlayerVideoView G = this.liveRoomService.G();
        if (G != null) {
            G.addSurfaceCallback(this.surfaceCallback);
        }
        ILiveAudienceTPPlayerRoom G2 = G();
        ViewGroup viewGroup = null;
        if (G2 != null) {
            iVar = G2.getVideoSize();
        } else {
            iVar = null;
        }
        if (iVar == null || iVar.b() == 0 || iVar.a() == 0) {
            QLog.w("TGLiveFloatManager", 1, "floating view onShow, but we cannot get video size...useDefault...");
            if (this.isGameLive) {
                iVar = new com.tencent.mobileqq.activity.richmedia.i(176, 99);
            } else {
                iVar = new com.tencent.mobileqq.activity.richmedia.i(99, 176);
            }
        }
        R(iVar.b(), iVar.a());
        ITPPlayerVideoView G3 = this.liveRoomService.G();
        if (G3 != null) {
            view = G3.getCurrentDisplayView();
        } else {
            view = null;
        }
        if (view != null) {
            if (!F(this.binding.f420784l, view)) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                this.binding.f420784l.addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            C();
        }
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null && (curRoomInfo = f16.getCurRoomInfo()) != null) {
            Intrinsics.checkNotNullExpressionValue(curRoomInfo, "curRoomInfo");
            curRoomInfo.isFloatWindow = true;
            f16.recordCurRoomInfo(curRoomInfo);
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            this.binding.f420777e.setVisibility(0);
        }
        com.tencent.timi.game.utils.m.a().c(this.netInfoHandler);
        J();
    }

    public final void setAudienceRoom(@Nullable IAudienceRoom iAudienceRoom) {
        this.audienceRoom = iAudienceRoom;
    }

    public final void setGameLive(boolean z16) {
        this.isGameLive = z16;
    }

    @Override // uh4.d
    public void setLaunchParam(@Nullable Object obj) {
        d.a.b(this, obj);
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public final void setRoomStatusListener(@Nullable LiveRoomStatusListener liveRoomStatusListener) {
        this.roomStatusListener = liveRoomStatusListener;
    }

    public final void setSurfaceCallback(@NotNull ITPPlayerVideoView.IVideoSurfaceCallback iVideoSurfaceCallback) {
        Intrinsics.checkNotNullParameter(iVideoSurfaceCallback, "<set-?>");
        this.surfaceCallback = iVideoSurfaceCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveAudienceFloatingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TGLiveAudienceFloatingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGLiveAudienceFloatingView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.liveRoomService = (jg4.b) b16;
        this.curWidth = com.tencent.timi.game.utils.b.a(176);
        this.curHeight = com.tencent.timi.game.utils.b.a(99);
        this.loadVideoTimeOutTask = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.c
            @Override // java.lang.Runnable
            public final void run() {
                TGLiveAudienceFloatingView.L(TGLiveAudienceFloatingView.this);
            }
        };
        ac f16 = ac.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.backgroundHeartBeat = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.TGLiveAudienceFloatingView$backgroundHeartBeat$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$backgroundHeartBeat$1$a", "Lcom/tencent/timi/game/liveroom/impl/ipc/TGLiveServerQIPCModule$b;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/LiveTeamStatusInfo;", "", "info", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes26.dex */
            public static final class a implements TGLiveServerQIPCModule.b<LiveTeamStatusInfo, Object> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ TGLiveAudienceFloatingView f377644a;

                a(TGLiveAudienceFloatingView tGLiveAudienceFloatingView) {
                    this.f377644a = tGLiveAudienceFloatingView;
                }

                @Override // com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule.b
                @Nullable
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Object a(@Nullable LiveTeamStatusInfo info) {
                    boolean z16;
                    boolean z17 = false;
                    if (info != null) {
                        TGLiveAudienceFloatingView tGLiveAudienceFloatingView = this.f377644a;
                        if (info.teamPlayStatus == 3 && !BaseGesturePWDUtil.isAppOnForeground(BaseApplication.context)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (TextUtils.equals(info.liveRoomId, String.valueOf(tGLiveAudienceFloatingView.getRoomId())) && info.isVolumeOpen) {
                            z17 = true;
                        }
                    } else {
                        z16 = false;
                    }
                    this.f377644a.Q(z17, z16);
                    this.f377644a.J();
                    return null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                TGLiveServerQIPCModule.INSTANCE.b().p(new a(TGLiveAudienceFloatingView.this));
            }
        };
        this.timiCmdListener = new g();
        setFocusable(true);
        f16.f420775c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGLiveAudienceFloatingView.n(TGLiveAudienceFloatingView.this, view);
            }
        });
        f16.f420774b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGLiveAudienceFloatingView.o(TGLiveAudienceFloatingView.this, view);
            }
        });
        f16.f420780h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGLiveAudienceFloatingView.p(TGLiveAudienceFloatingView.this, view);
            }
        });
        f16.f420782j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGLiveAudienceFloatingView.q(TGLiveAudienceFloatingView.this, context, view);
            }
        });
        f16.f420779g.setVisibility(4);
        this.netInfoHandler = new a();
        this.roomStatusListener = new b();
        this.surfaceCallback = new f();
        this.roomPlayerListener = new e();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$a", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "p0", "", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements INetInfoHandler {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ILiveAudienceTPPlayerRoom G = this$0.G();
            if (G != null) {
                G.play();
            }
            this$0.O(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TGLiveAudienceFloatingView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ILiveAudienceTPPlayerRoom G = this$0.G();
            if (G != null) {
                G.play();
            }
            this$0.O(false);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String p06) {
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.a(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.l
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.a.c(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String p06) {
            TGLiveAudienceFloatingView.this.C();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String p06) {
            final TGLiveAudienceFloatingView tGLiveAudienceFloatingView = TGLiveAudienceFloatingView.this;
            w.a(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.k
                @Override // java.lang.Runnable
                public final void run() {
                    TGLiveAudienceFloatingView.a.d(TGLiveAudienceFloatingView.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String p06) {
            TGLiveAudienceFloatingView.this.C();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }
    }

    @Override // uh4.d
    public void d() {
    }

    @Override // uh4.d
    @NotNull
    public View getView() {
        return this;
    }

    @Override // uh4.d
    public void onBackground() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveAudienceFloatingView$g", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements IQQCmdPushCallback {
        g() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            TGLiveAudienceFloatingView.this.I(data);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}
