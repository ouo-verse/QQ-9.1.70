package com.tencent.mobileqq.icgame.room.displayview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.liveroom.impl.room.live.widget.LiveTipsView;
import com.tencent.icgame.liveroom.impl.room.live.widget.RoomCoverCtrl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.room.displayview.ICGameDisplayView;
import com.tencent.mobileqq.icgame.room.player.ICGameMiniSdkLiveView;
import com.tencent.mobileqq.icgame.room.player.i;
import com.tencent.mobileqq.icgame.room.player.j;
import com.tencent.mobileqq.icgame.room.player.l;
import com.tencent.mobileqq.icgame.room.player.m;
import com.tencent.mobileqq.icgame.room.report.ReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import d42.f;
import d42.g;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u0001KB-\b\u0007\u0012\u0007\u0010\u009f\u0001\u001a\u00020>\u0012\f\b\u0002\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00a0\u0001\u0012\t\b\u0002\u0010\u00a2\u0001\u001a\u00020D\u00a2\u0006\u0006\b\u00a3\u0001\u0010\u00a4\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010 J\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%J\u0006\u0010(\u001a\u00020\u0007J\u0016\u0010*\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0004J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010+J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201J\u0006\u00104\u001a\u00020\u0007J\u0006\u00105\u001a\u00020\u0007J\u0006\u00106\u001a\u00020\u0007J\u0006\u00107\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u0004J\u0006\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0004J\b\u0010=\u001a\u00020\u0007H\u0014J\u000e\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>J\b\u0010A\u001a\u00020\u0007H\u0014J\u000e\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0004J\u0016\u0010G\u001a\u00020\u00072\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020DJ\u000e\u0010J\u001a\u00020\u00072\u0006\u0010I\u001a\u00020HR\"\u0010P\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\"\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010X\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR.\u0010`\u001a\u0004\u0018\u00010Y2\b\u0010\u001d\u001a\u0004\u0018\u00010Y8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010g\u001a\u00020a2\u0006\u0010b\u001a\u00020a8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010pR\u0016\u0010q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0016\u0010r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010s\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010uR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010LR\u0018\u0010x\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010wR\u0016\u0010y\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\"R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010zR\u0016\u0010}\u001a\u00020{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u007fR\u0017\u0010\u0083\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0015\u0010\u0082\u0001R\u0017\u0010\u0084\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\"R\u0019\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u0085\u0001R\u0019\u0010\u0088\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b:\u0010\u0087\u0001R\u0017\u0010\u0089\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\"R\u0017\u0010\u008c\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b.\u0010\u008b\u0001R\u0017\u0010\u008f\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bC\u0010\u008e\u0001R\u0018\u0010\u0091\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b/\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b0\u0010\u0093\u0001R\u0017\u0010\u0095\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010LR\u0019\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b5\u0010\u0096\u0001R\u0017\u0010\u0097\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\"R\u0019\u0010\u009a\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bG\u0010\u0099\u0001R\u001a\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u00a8\u0006\u00a5\u0001"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/ICGameDisplayView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "", "D", "E", "", "o0", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", "G", "", "roomId", "i0", "l0", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "N", "h0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/ViewGroup;", "H", "m0", "M", "n0", "value", "k0", "q0", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Z", "c0", "X", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "setLiveExtraInfo", "g0", "isEnterFloatWindow", "Y", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "liveInfo", ExifInterface.LATITUDE_SOUTH, "T", "V", "W", "Ld42/f;", "liveViewListener", "setListener", "a0", "b0", "f0", "j0", "K", "p0", BdhLogUtil.LogTag.Tag_Req, "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/content/Context;", "contextActivity", "setActivityContext", NodeProps.ON_DETACHED_FROM_WINDOW, WSPublicAccReport.SOP_NAME_FOCUS, "U", "", "width", "height", "d0", "Lg32/h;", "trigger", "setEventTrigger", "d", "J", "()Z", "setVideoLandscape", "(Z)V", "videoLandscape", "Lh22/a;", "e", "Lh22/a;", "I", "()Lh22/a;", "setQqLiveRoomService", "(Lh22/a;)V", "qqLiveRoomService", "Lp22/a;", "f", "Lp22/a;", "getSwitchRoomService", "()Lp22/a;", "setSwitchRoomService", "(Lp22/a;)V", "switchRoomService", "Lcom/tencent/mobileqq/activity/richmedia/i;", "<set-?>", h.F, "Lcom/tencent/mobileqq/activity/richmedia/i;", "getVideoSize", "()Lcom/tencent/mobileqq/activity/richmedia/i;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Landroid/app/Activity;", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/FrameLayout$LayoutParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout$LayoutParams;", "matchParentParams", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "isLivePause", "isPlaying", "isActivityPaused", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "Ljava/lang/String;", WebAccelerateHelper.KEY_PRELOAD_URL, "isPageIn", "Ld42/f;", "Lcom/tencent/mobileqq/icgame/room/player/i;", "Lcom/tencent/mobileqq/icgame/room/player/i;", "iGameLiveStatusListener", "Lb32/a;", "Lb32/a;", "audienceRoomPlayerListener", "Lb32/e;", "Lb32/e;", "liveRoomStatusListener", "isRoomStatusEnable", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "Lfu0/c;", "Lfu0/c;", "liveRoomService", "playVideoOnSwitchRoom", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG, "Lcom/tencent/icgame/liveroom/impl/room/live/widget/RoomCoverCtrl;", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/RoomCoverCtrl;", "roomCoverCtrl", "Landroid/widget/FrameLayout;", "liveContainer", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView;", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView;", "liveTipsView", "parseSeiTimeStamp", "Lg32/h;", "isSetPlayer", "Lcom/tencent/mobileqq/icgame/room/player/j;", "Lcom/tencent/mobileqq/icgame/room/player/j;", "gameLiveView", "Ljava/lang/Runnable;", "e0", "Ljava/lang/Runnable;", "loadVideoTimeOutTask", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameDisplayView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LiveInfo liveInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLivePause;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isActivityPaused;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Handler mHandler;

    /* renamed from: H, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String preloadUrl;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isPageIn;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private f liveViewListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private i iGameLiveStatusListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private b32.a audienceRoomPlayerListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b32.e liveRoomStatusListener;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isRoomStatusEnable;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private LiveRoomExtraInfo extraInfo;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private fu0.c liveRoomService;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean playVideoOnSwitchRoom;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final ImageView coverImg;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final RoomCoverCtrl roomCoverCtrl;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private FrameLayout liveContainer;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private LiveTipsView liveTipsView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long parseSeiTimeStamp;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g32.h trigger;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isSetPlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean videoLandscape;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private j gameLiveView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h22.a qqLiveRoomService;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable loadVideoTimeOutTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private p22.a switchRoomService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.activity.richmedia.i videoSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout.LayoutParams matchParentParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/ICGameDisplayView$a", "Lcom/tencent/mobileqq/icgame/room/player/i;", "", "a", "hideErrorView", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements i {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.player.i
        public void a() {
            d42.e.d(ICGameDisplayView.this.isPageIn, ICGameDisplayView.this.isActivityPaused);
            if (ICGameDisplayView.this.isPageIn && !ICGameDisplayView.this.isActivityPaused) {
                ICGameDisplayView iCGameDisplayView = ICGameDisplayView.this;
                iCGameDisplayView.h0(iCGameDisplayView.roomId);
            }
        }

        @Override // com.tencent.mobileqq.icgame.room.player.i
        public void hideErrorView() {
            ICGameDisplayView.this.liveTipsView.d();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J(\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0004H\u0016\u00a8\u0006$"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/ICGameDisplayView$b", "Lb32/a;", "Lcom/tencent/mobileqq/icgame/api/room/StreamType;", "streamType", "", "url", "Lcom/tencent/mobileqq/icgame/api/room/PlayerConfig;", "playerConfig", "", "onPreparing", "", "startTime", "endTime", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "errorCode", "msg", "onError", "onResume", "onStartBuffer", "totalSize", "cacheSize", "cacheDuration", "speed", "onUpdateDownloadInfo", "onStopBuffer", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "La32/c;", "info", "onInfo", "protocolName", "onRequestProtocolUpdate", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends b32.a {
        b() {
        }

        @Override // b32.a
        public void onError(int errorCode, @Nullable String msg2) {
            d42.e.j(ICGameDisplayView.this.roomId, errorCode, msg2);
            ICGameDisplayView.this.m0();
            ICGameDisplayView.this.L();
            ReportHelper reportHelper = ReportHelper.INSTANCE;
            long j3 = ICGameDisplayView.this.roomId;
            long currentTimeMillis = System.currentTimeMillis();
            if (msg2 == null) {
                msg2 = "";
            }
            reportHelper.saveFirstFrameEndTimeAndReport(j3, currentTimeMillis, errorCode, msg2);
        }

        @Override // b32.a
        public void onFirstFrameCome(long startTime, long endTime) {
            d42.e.l(ICGameDisplayView.this.roomId);
            ICGameDisplayView.this.isPlaying = true;
            ICGameDisplayView.this.gameLiveView.setStatus(l.f237717e);
            ICGameDisplayView.this.M();
            ICGameDisplayView.this.mHandler.removeCallbacks(ICGameDisplayView.this.loadVideoTimeOutTask);
            ICGameDisplayView.this.L();
            ReportHelper.INSTANCE.saveFirstFrameEndTimeAndReport(ICGameDisplayView.this.roomId, System.currentTimeMillis(), 0, "");
        }

        @Override // b32.a
        public void onInfo(@Nullable a32.c info) {
            super.onInfo(info);
            if (info != null && ICGameDisplayView.this.isPageIn && SystemClock.elapsedRealtime() - ICGameDisplayView.this.parseSeiTimeStamp >= 300) {
                ICGameDisplayView.this.parseSeiTimeStamp = SystemClock.elapsedRealtime();
                g32.h hVar = ICGameDisplayView.this.trigger;
                if (hVar != null) {
                    hVar.w0(new d42.h(info));
                }
            }
        }

        @Override // b32.a
        public void onPause() {
            d42.e.q(ICGameDisplayView.this.roomId);
        }

        @Override // b32.a
        public void onPlay() {
            d42.e.r(ICGameDisplayView.this.roomId);
            ICGameDisplayView.this.M();
            ICGameDisplayView.this.L();
            ICGameDisplayView.this.mHandler.removeCallbacks(ICGameDisplayView.this.loadVideoTimeOutTask);
        }

        @Override // b32.a
        public void onPreparing(@NotNull StreamType streamType, @Nullable String url, @Nullable PlayerConfig playerConfig) {
            Intrinsics.checkNotNullParameter(streamType, "streamType");
            ICGameDisplayView.this.z();
        }

        @Override // b32.a
        public void onRequestProtocolUpdate(@NotNull String protocolName) {
            Intrinsics.checkNotNullParameter(protocolName, "protocolName");
        }

        @Override // b32.a
        public void onResume() {
            d42.e.v(ICGameDisplayView.this.roomId);
            ICGameDisplayView.this.M();
            ICGameDisplayView.this.L();
        }

        @Override // b32.a
        public void onStartBuffer() {
            ICGameDisplayView.this.n0();
            ReportHelper.INSTANCE.savePlayerStartBufferInfo(ICGameDisplayView.this.roomId, System.currentTimeMillis());
        }

        @Override // b32.a
        public void onStopBuffer() {
            ICGameDisplayView.this.M();
            ICGameDisplayView.this.L();
            ReportHelper.INSTANCE.savePlayerStopBufferInfo(ICGameDisplayView.this.roomId, System.currentTimeMillis());
        }

        @Override // b32.a
        public void onUpdateDownloadInfo(long totalSize, long cacheSize, long cacheDuration, long speed) {
            ICGameDisplayView.this.liveTipsView.j(com.tencent.icgame.game.liveroom.impl.room.util.j.f115698a.a(speed));
        }

        @Override // b32.a
        public void onVideoSizeChanged(int width, int height) {
            boolean z16;
            d42.e.y(width, height);
            ICGameDisplayView.this.videoSize = new com.tencent.mobileqq.activity.richmedia.i(width, height);
            f fVar = ICGameDisplayView.this.liveViewListener;
            if (fVar != null) {
                fVar.a(width, height);
            }
            if (width > height) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (ICGameDisplayView.this.getVideoLandscape() == z16) {
                return;
            }
            ICGameDisplayView.this.setVideoLandscape(z16);
            ICGameDisplayView.this.d0(width, height);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/ICGameDisplayView$c", "Lb32/e;", "Lcom/tencent/mobileqq/qqlive/data/room/QQLiveRoomStatusInfo;", "info", "", "onRoomOpen", "onRoomClose", "onRoomPause", "onRoomResume", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements b32.e {
        c() {
        }

        @Override // b32.e
        public void onRoomClose(@NotNull QQLiveRoomStatusInfo info) {
            ILiveAudienceTPPlayerRoom G;
            Intrinsics.checkNotNullParameter(info, "info");
            if (ICGameDisplayView.this.D(info)) {
                boolean E = ICGameDisplayView.this.E();
                rt0.a.INSTANCE.k("ICGameRoomDisplayView", "onRoomClose", "statusEnable:" + E);
                if (E && (G = ICGameDisplayView.this.G()) != null) {
                    G.pause();
                }
            }
        }

        @Override // b32.e
        public void onRoomOpen(@NotNull QQLiveRoomStatusInfo info) {
            ILiveAudienceTPPlayerRoom G;
            Intrinsics.checkNotNullParameter(info, "info");
            if (ICGameDisplayView.this.D(info)) {
                boolean E = ICGameDisplayView.this.E();
                rt0.a.INSTANCE.k("ICGameRoomDisplayView", "onRoomOpen", "statusEnable:" + E);
                if (E && (G = ICGameDisplayView.this.G()) != null) {
                    G.startPlay("");
                }
            }
        }

        @Override // b32.e
        public void onRoomPause(@NotNull QQLiveRoomStatusInfo info) {
            ILiveAudienceTPPlayerRoom G;
            Intrinsics.checkNotNullParameter(info, "info");
            if (ICGameDisplayView.this.D(info)) {
                boolean E = ICGameDisplayView.this.E();
                rt0.a.INSTANCE.k("ICGameRoomDisplayView", "onRoomPause", "roomId " + ICGameDisplayView.this.roomId + " onLivePause statusEnable:" + E);
                ICGameDisplayView.this.V();
                if (E && (G = ICGameDisplayView.this.G()) != null) {
                    G.pause();
                }
            }
        }

        @Override // b32.e
        public void onRoomResume(@NotNull QQLiveRoomStatusInfo info) {
            ILiveAudienceTPPlayerRoom G;
            Intrinsics.checkNotNullParameter(info, "info");
            if (ICGameDisplayView.this.D(info)) {
                boolean E = ICGameDisplayView.this.E();
                rt0.a.INSTANCE.k("ICGameRoomDisplayView", "onRoomResume", "roomId " + ICGameDisplayView.this.roomId + " onLiveResume statusEnable:" + E);
                ICGameDisplayView.this.W();
                if (E && (G = ICGameDisplayView.this.G()) != null) {
                    G.replay();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/ICGameDisplayView$e", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView$a;", "", "onRetry", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements LiveTipsView.a {
        e() {
        }

        @Override // com.tencent.icgame.liveroom.impl.room.live.widget.LiveTipsView.a
        public void onRetry() {
            ICGameDisplayView.this.n0();
            ICGameDisplayView.this.mHandler.postDelayed(ICGameDisplayView.this.loadVideoTimeOutTask, 10000L);
            ICGameDisplayView iCGameDisplayView = ICGameDisplayView.this;
            iCGameDisplayView.h0(iCGameDisplayView.roomId);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameDisplayView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        this.gameLiveView.setVideoRotation(-90);
        this.gameLiveView.setStatusListener(this.iGameLiveStatusListener);
        this.gameLiveView.getView().setOnClickListener(new View.OnClickListener() { // from class: d42.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ICGameDisplayView.B(ICGameDisplayView.this, view);
            }
        });
        this.liveTipsView.setListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ICGameDisplayView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d42.e.e();
        g32.h hVar = this$0.trigger;
        if (hVar != null) {
            hVar.w0(new d42.a(this$0.roomId));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C() {
        ITPPlayerVideoView iTPPlayerVideoView;
        int i3;
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null) {
            iTPPlayerVideoView = G.getDisplayView();
        } else {
            iTPPlayerVideoView = null;
        }
        if (iTPPlayerVideoView != null) {
            boolean z16 = this.videoLandscape;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            rt0.a.INSTANCE.k("ICGameRoomDisplayView", "changeVideoViewXYAxis", "videoLandscape:" + z16);
            d42.e.a(i3, this.roomId);
            iTPPlayerVideoView.setXYAxis(i3);
            iTPPlayerVideoView.getCurrentDisplayView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D(QQLiveRoomStatusInfo info) {
        boolean z16;
        LiveAnchorInfo liveAnchorInfo;
        long j3 = this.roomId;
        if (j3 != info.roomID) {
            rt0.a.INSTANCE.k("ICGameRoomDisplayView", "checkRoomIdAndAnchorUidMatch", "roomId " + j3 + " receive push, roomId not match");
            return false;
        }
        LiveInfo liveInfo = this.liveInfo;
        if (liveInfo != null && (liveAnchorInfo = liveInfo.anchorInfo) != null && info.uin == liveAnchorInfo.uid) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        rt0.a.INSTANCE.k("ICGameRoomDisplayView", "checkRoomIdAndAnchorUidMatch", "roomId " + j3 + " receive push, anchorUid not match");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E() {
        if (!this.isRoomStatusEnable) {
            rt0.a.INSTANCE.k("ICGameRoomDisplayView", "checkRoomStatusEnable", "isRoomStatusEnable is false!");
            return false;
        }
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null && G.getStreamType() == StreamType.FLV) {
            rt0.a.INSTANCE.k("ICGameRoomDisplayView", "checkRoomStatusEnable", "stream is flv, enable!");
            return true;
        }
        rt0.a.INSTANCE.k("ICGameRoomDisplayView", "checkRoomStatusEnable", "stream is flv, disable!");
        return false;
    }

    private final void F(View view) {
        ViewGroup viewGroup;
        ViewGroup H = H();
        if (!uu0.b.b(H, view)) {
            view.setTag("ICGameVideo_view_tag");
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            H.addView(view, 0, this.matchParentParams);
            d42.e.b(this.roomId);
            return;
        }
        d42.e.c(this.roomId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILiveAudienceTPPlayerRoom G() {
        IAudienceRoom y16 = this.liveRoomService.y(this.roomId);
        if (y16 instanceof ILiveAudienceTPPlayerRoom) {
            return (ILiveAudienceTPPlayerRoom) y16;
        }
        return null;
    }

    private final ViewGroup H() {
        View view = this.gameLiveView.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        this.roomCoverCtrl.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        this.liveTipsView.e();
        this.liveTipsView.d();
    }

    private final void N() {
        M();
        this.liveTipsView.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(ICGameDisplayView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ICGameDisplayView this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g32.h hVar = this$0.trigger;
        if (hVar != null) {
            hVar.w0(new g(i3, i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(long roomId) {
        d42.e.C(roomId);
        if (NetworkUtil.isNetworkAvailable()) {
            d42.e.D(roomId);
            this.isPlaying = true;
            this.gameLiveView.play(String.valueOf(roomId));
            return;
        }
        d42.e.E(roomId);
        com.tencent.icgame.game.ui.widget.f.b("\u7f51\u7edc\u4e0d\u7ed9\u529b");
        p0();
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!bVar.a(context)) {
            return;
        }
        m0();
    }

    private final void i0(long roomId) {
        d42.e.F(roomId);
        this.gameLiveView.setVideoPlayer(new m());
        this.isSetPlayer = true;
    }

    private final void k0(boolean value) {
        rt0.a.INSTANCE.k("ICGameRoomDisplayView", "setRoomStatusEnable", "roomId " + this.roomId + ", isRoomStatusEnable:" + value);
        this.isRoomStatusEnable = value;
    }

    private final void l0() {
        this.roomCoverCtrl.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        this.liveTipsView.e();
        this.liveTipsView.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        this.liveTipsView.i();
        this.liveTipsView.d();
    }

    private final void o0() {
        if (this.isLivePause) {
            this.liveTipsView.g("\u4e3b\u64ad\u6682\u65f6\u79bb\u5f00\u4e00\u4f1a\uff0c\u5343\u4e07\u522b\u8d70\u5f00\u9a6c\u4e0a\u56de\u6765");
        } else {
            this.liveTipsView.c();
        }
    }

    private final void q0() {
        rt0.a.INSTANCE.k("ICGameRoomDisplayView", "updateLiveContainerBackground", "background is null!");
        ColorDrawable colorDrawable = null;
        setBackground(null);
        FrameLayout frameLayout = this.liveContainer;
        if (this.videoLandscape) {
            colorDrawable = new ColorDrawable(-16777216);
        }
        frameLayout.setBackground(colorDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ITPPlayerVideoView displayView;
        View currentDisplayView;
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null && (displayView = G.getDisplayView()) != null && (currentDisplayView = displayView.getCurrentDisplayView()) != null) {
            F(currentDisplayView);
        }
    }

    @Nullable
    /* renamed from: I, reason: from getter */
    public final h22.a getQqLiveRoomService() {
        return this.qqLiveRoomService;
    }

    /* renamed from: J, reason: from getter */
    public final boolean getVideoLandscape() {
        return this.videoLandscape;
    }

    public final boolean K() {
        ITPPlayerVideoView displayView;
        View currentDisplayView;
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null && (displayView = G.getDisplayView()) != null && (currentDisplayView = displayView.getCurrentDisplayView()) != null) {
            return uu0.b.b(H(), currentDisplayView);
        }
        return false;
    }

    public final void P() {
        this.gameLiveView.onResume();
    }

    public final void Q(boolean isEnterFloatWindow) {
        this.gameLiveView.onStop();
        rt0.a.INSTANCE.k("ICGameRoomDisplayView", "onActivityStop", "isEnterFloatWindow:" + isEnterFloatWindow);
        if (!isEnterFloatWindow) {
            f0();
        }
    }

    public final boolean R() {
        return false;
    }

    public final void S(long roomId, @Nullable LiveInfo liveInfo) {
        d42.e.h(roomId, this.playVideoOnSwitchRoom);
        this.liveInfo = liveInfo;
        ILiveRoom z16 = this.liveRoomService.z(roomId);
        if (z16 != null) {
            z16.registerRoomStatusListener(this.liveRoomStatusListener);
        }
        if (this.playVideoOnSwitchRoom) {
            return;
        }
        if (z16 instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) z16).registerRoomPlayerListener(this.audienceRoomPlayerListener);
            h0(roomId);
            z();
            o0();
            d42.e.i();
        }
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (bVar.b(context)) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            if (bVar.a(context2)) {
                QQToast.makeText(getContext(), "\u5f53\u524d\u975ewifi\u73af\u5883\uff0c\u6ce8\u610f\u6d41\u91cf\u6d88\u8017\u54e6", 0).show();
            }
        }
    }

    public final void T(long roomId) {
        d42.e.k(roomId);
        this.videoLandscape = false;
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null) {
            G.unRegisterRoomPlayerListener(this.audienceRoomPlayerListener);
        }
    }

    public final void U(boolean focus) {
        if (focus) {
            if (!this.isPlaying) {
                d42.e.m();
                h0(this.roomId);
                return;
            }
            return;
        }
        if (this.isPlaying) {
            d42.e.n();
            f0();
        }
    }

    public final void V() {
        this.isLivePause = true;
        o0();
    }

    public final void W() {
        this.isLivePause = false;
        o0();
    }

    public final void X(long roomId) {
        d42.e.o(roomId);
        this.isPageIn = true;
        if (!this.isSetPlayer) {
            this.gameLiveView.setVideoPlayer(new m());
            this.isSetPlayer = true;
        }
    }

    public final void Y(long roomId, boolean isEnterFloatWindow) {
        d42.e.p(roomId);
        rt0.a.INSTANCE.k("ICGameRoomDisplayView", "onPageOut", "isEnterFloatWindow:" + isEnterFloatWindow);
        if (!isEnterFloatWindow) {
            p0();
        }
        this.isPageIn = false;
        this.playVideoOnSwitchRoom = false;
        N();
        uu0.b.g(H(), "ICGameVideo_view_tag");
    }

    public final void Z(long roomId, @Nullable String videoUrl) {
        Intent intent;
        View currentDisplayView;
        d42.e.s(roomId, videoUrl);
        this.roomId = roomId;
        this.preloadUrl = videoUrl;
        RoomCoverCtrl roomCoverCtrl = this.roomCoverCtrl;
        roomCoverCtrl.u(roomId);
        roomCoverCtrl.p();
        i0(roomId);
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null) {
            ITPPlayerVideoView displayView = G.getDisplayView();
            if (displayView != null && (currentDisplayView = displayView.getCurrentDisplayView()) != null) {
                Intrinsics.checkNotNullExpressionValue(currentDisplayView, "currentDisplayView");
                F(currentDisplayView);
            }
            G.registerRoomPlayerListener(this.audienceRoomPlayerListener);
        }
        h22.a aVar = this.qqLiveRoomService;
        boolean z16 = false;
        if (aVar != null && (intent = aVar.getIntent()) != null && intent.getBooleanExtra("open_from_float_window", false)) {
            z16 = true;
        }
        if (!z16) {
            l0();
        }
    }

    public final void a0() {
        d42.e.u();
        this.isActivityPaused = false;
        k0(true);
    }

    public final void b0() {
        d42.e.t();
        this.isActivityPaused = true;
        k0(false);
    }

    public final void c0() {
        ILiveAudienceTPPlayerRoom G = G();
        if (G == null) {
            d42.e.x();
            return;
        }
        G.registerRoomPlayerListener(this.audienceRoomPlayerListener);
        if (!TextUtils.isEmpty(this.preloadUrl)) {
            d42.e.w(this.roomId);
            h0(this.roomId);
            z();
            o0();
            this.playVideoOnSwitchRoom = true;
        }
    }

    public final void d0(final int width, final int height) {
        q0();
        C();
        post(new Runnable() { // from class: d42.c
            @Override // java.lang.Runnable
            public final void run() {
                ICGameDisplayView.e0(ICGameDisplayView.this, width, height);
            }
        });
    }

    public final void f0() {
        d42.e.z(this.roomId, this.isPlaying, this.isPageIn);
        if (this.isPageIn && this.isPlaying) {
            this.gameLiveView.pause(String.valueOf(this.roomId));
            d42.e.A();
        }
    }

    public final void g0() {
        d42.e.B(this.roomId);
        f0();
        this.isPageIn = false;
        this.playVideoOnSwitchRoom = false;
        N();
    }

    public final void j0() {
        d42.e.G(this.roomId, this.isPlaying, this.isPageIn);
        if (this.isPageIn && this.isPlaying) {
            d42.e.H();
            z();
            this.gameLiveView.resume(String.valueOf(this.roomId));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        d42.e.f(this.roomId, this.isPlaying, this.isPageIn);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        d42.e.g(this.roomId, this.isPlaying, this.isPageIn);
        super.onDetachedFromWindow();
        this.gameLiveView.b(this.iGameLiveStatusListener);
        this.gameLiveView.setGameLiveGestureListener(null);
        this.liveContainer.removeView(this.gameLiveView.getView());
        ILiveAudienceTPPlayerRoom G = G();
        if (G != null) {
            G.unRegisterRoomPlayerListener(this.audienceRoomPlayerListener);
        }
        this.mHandler.removeCallbacks(this.loadVideoTimeOutTask);
        this.activity = null;
    }

    public final void p0() {
        d42.e.I(this.roomId, this.isPlaying, this.isPageIn);
        this.isPlaying = false;
        this.gameLiveView.stop(String.valueOf(this.roomId));
    }

    public final void setActivityContext(@NotNull Context contextActivity) {
        Intrinsics.checkNotNullParameter(contextActivity, "contextActivity");
        if (!(contextActivity instanceof Activity)) {
            return;
        }
        this.activity = (Activity) contextActivity;
    }

    public final void setEventTrigger(@NotNull g32.h trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
    }

    public final void setListener(@NotNull f liveViewListener) {
        Intrinsics.checkNotNullParameter(liveViewListener, "liveViewListener");
        this.liveViewListener = liveViewListener;
    }

    public final void setLiveExtraInfo(@NotNull LiveRoomExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.extraInfo = extraInfo;
        this.roomCoverCtrl.s(extraInfo);
    }

    public final void setQqLiveRoomService(@Nullable h22.a aVar) {
        this.qqLiveRoomService = aVar;
    }

    public final void setSwitchRoomService(@Nullable p22.a aVar) {
        au0.c roomSwitcher;
        RoomCoverCtrl roomCoverCtrl = this.roomCoverCtrl;
        boolean z16 = false;
        if (aVar != null && (roomSwitcher = aVar.getRoomSwitcher()) != null && roomSwitcher.getCurrentIndex() == 0) {
            z16 = true;
        }
        roomCoverCtrl.t(z16);
        this.switchRoomService = aVar;
    }

    public final void setVideoLandscape(boolean z16) {
        this.videoLandscape = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameDisplayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ICGameDisplayView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameDisplayView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.videoSize = new com.tencent.mobileqq.activity.richmedia.i(1080, 1920);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.matchParentParams = layoutParams;
        this.mHandler = new Handler();
        this.isRoomStatusEnable = true;
        mm4.a b16 = qx0.a.b(fu0.c.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.liveRoomService = (fu0.c) b16;
        this.loadVideoTimeOutTask = new Runnable() { // from class: d42.b
            @Override // java.lang.Runnable
            public final void run() {
                ICGameDisplayView.O(ICGameDisplayView.this);
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.faj, this);
        View findViewById = findViewById(R.id.ykl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.liveTipsView)");
        this.liveTipsView = (LiveTipsView) findViewById;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.coverImg = imageView;
        this.roomCoverCtrl = new RoomCoverCtrl(imageView);
        ICGameMiniSdkLiveView iCGameMiniSdkLiveView = new ICGameMiniSdkLiveView(context, null, 0, 6, null);
        iCGameMiniSdkLiveView.m(imageView, layoutParams);
        this.gameLiveView = iCGameMiniSdkLiveView;
        View findViewById2 = findViewById(R.id.ykd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.liveContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.liveContainer = frameLayout;
        frameLayout.addView(this.gameLiveView.getView(), layoutParams);
        this.iGameLiveStatusListener = new a();
        this.audienceRoomPlayerListener = new b();
        this.liveRoomStatusListener = new c();
        A();
    }
}
