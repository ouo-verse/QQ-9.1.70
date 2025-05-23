package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.view.TimUserGameInfoViewImpl;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass$UserOnlineRouteInfoList;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0094\u0001\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0016\u0012\b\u0010\u00a9\u0001\u001a\u00030\u00a8\u0001\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001B!\b\u0016\u0012\b\u0010\u00a9\u0001\u001a\u00030\u00a8\u0001\u0012\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00ac\u0001\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ae\u0001B*\b\u0016\u0012\b\u0010\u00a9\u0001\u001a\u00030\u00a8\u0001\u0012\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00ac\u0001\u0012\u0007\u0010\u00af\u0001\u001a\u00020\u0011\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00b0\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0004J\b\u0010\u001f\u001a\u00020\u0011H\u0004J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0015J\u0017\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0014\u00a2\u0006\u0004\b#\u0010$J\b\u0010%\u001a\u00020\u0007H\u0004J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J\b\u0010'\u001a\u00020\u0007H\u0004J\b\u0010(\u001a\u00020\u0007H\u0004J\b\u0010)\u001a\u00020\u0007H\u0014J$\u0010,\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010-\u001a\u00020\u0005H\u0014J\b\u0010.\u001a\u00020\u0005H\u0014R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010 R\u0016\u0010D\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010 R\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010FR$\u0010M\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010Y\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010`\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R0\u0010h\u001a\u0010\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020b\u0018\u00010a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010ZR\"\u0010p\u001a\u00020k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010l\u001a\u0004\b9\u0010m\"\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010wR\u0018\u0010\u0088\u0001\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010wR \u0010\u008e\u0001\u001a\u00030\u0089\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010\u0093\u0001\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u009f\u0001\u001a\u00030\u0098\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\u00a3\u0001\u001a\u00030\u00a0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a5\u0001\u001a\u00030\u00a0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a7\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u009a\u0001\u00a8\u0006\u00b1\u0001"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Lcom/tencent/timi/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Lcom/tencent/timi/game/component/chat/message/o;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$UserOnlineRouteInfoList;", "userOnlineRouteInfoList", "", "M", "", HippyTKDListViewAdapter.X, "Lcom/tencent/timi/game/component/chat/message/n;", "listener", "setMessageListener", "Landroid/view/View;", "view", "setContentView", "Landroid/widget/FrameLayout$LayoutParams;", "lp", "", "layoutResID", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", DownloadInfo.spKey_Config, "setImConfig", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "setYoloRoomInfo", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", UserInfo.SEX_FEMALE, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "G", "l", "I", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "p", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "L", "K", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqUserId", "preMsg", "a", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/drawable/GradientDrawable;", "f", "Landroid/graphics/drawable/GradientDrawable;", "selfBubbleBg", tl.h.F, "otherBubbleBg", "Landroid/graphics/drawable/Drawable;", "i", "Landroid/graphics/drawable/Drawable;", "sendingDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "errorDrawable", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/tim/api/message/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/timi/game/tim/api/message/a;", "setMsg", "(Lcom/tencent/timi/game/tim/api/message/a;)V", "D", "lastPointerRawX", "E", "lastPointerRawY", "Lcom/tencent/timi/game/component/chat/message/ac;", "Lcom/tencent/timi/game/component/chat/message/ac;", "messageViewOperator", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", DomainData.DOMAIN_NAME, "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "setIImConfig", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;)V", "iImConfig", "H", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "v", "()Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "setRoomInfo", "(Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;)V", "Lcom/tencent/timi/game/component/chat/message/n;", "o", "()Lcom/tencent/timi/game/component/chat/message/n;", "setIMessageListener", "(Lcom/tencent/timi/game/component/chat/message/n;)V", "iMessageListener", "J", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "w", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setSelfQQUserId", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;)V", "selfQQUserId", "", "", "Ljava/util/Map;", "u", "()Ljava/util/Map;", "setReportParam", "(Ljava/util/Map;)V", "reportParam", "", "routeInfoRoomId", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "setBaseContentContainer", "(Landroid/widget/FrameLayout;)V", "baseContentContainer", "Landroid/widget/ImageView;", "N", "Landroid/widget/ImageView;", "sendState", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "baseStatusDescTv", "Lcom/tencent/timi/game/userinfo/impl/view/TimiAvatarRoundImageViewImpl;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/timi/game/userinfo/impl/view/TimiAvatarRoundImageViewImpl;", "baseAvatarView", "Lcom/tencent/timi/game/userinfo/impl/view/TimiAvatarTextViewImpl;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/timi/game/userinfo/impl/view/TimiAvatarTextViewImpl;", "baseNickView", "Lcom/tencent/timi/game/userinfo/impl/view/TimUserGameInfoViewImpl;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/timi/game/userinfo/impl/view/TimUserGameInfoViewImpl;", "baseGameRoleView", "T", "baseTimeView", "U", "revokeView", "Landroid/view/View$OnTouchListener;", "V", "Landroid/view/View$OnTouchListener;", "t", "()Landroid/view/View$OnTouchListener;", "positionOnTouchListener", "W", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/graphics/drawable/GradientDrawable;", "onlineStatusDrawable", "com/tencent/timi/game/component/chat/message/BaseMessageView$b", "a0", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView$b;", "teamUpdateListener", "Landroid/view/View$OnLongClickListener;", "b0", "Landroid/view/View$OnLongClickListener;", "r", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListner", "(Landroid/view/View$OnLongClickListener;)V", "onLongClickListner", "Landroid/view/View$OnClickListener;", "c0", "Landroid/view/View$OnClickListener;", "onResendClick", "d0", "onAvatarClickListener", "e0", "onAvatarLongClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BaseMessageView extends TouchPositionGetableRelativeLayout implements o {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.tim.api.message.a msg;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastPointerRawX;

    /* renamed from: E, reason: from kotlin metadata */
    private int lastPointerRawY;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ac messageViewOperator;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private MessageLayout.a iImConfig;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private n iMessageListener;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId selfQQUserId;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Map<String, String> reportParam;

    /* renamed from: L, reason: from kotlin metadata */
    private long routeInfoRoomId;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private FrameLayout baseContentContainer;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ImageView sendState;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private TextView baseStatusDescTv;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private TimiAvatarRoundImageViewImpl baseAvatarView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private TimiAvatarTextViewImpl baseNickView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private TimUserGameInfoViewImpl baseGameRoleView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private TextView baseTimeView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private TextView revokeView;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final View.OnTouchListener positionOnTouchListener;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineStatusDrawable;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b teamUpdateListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View.OnLongClickListener onLongClickListner;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onResendClick;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onAvatarClickListener;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLongClickListener onAvatarLongClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GradientDrawable selfBubbleBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GradientDrawable otherBubbleBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable sendingDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable errorDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/BaseMessageView$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<IUserInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376425b;

        a(com.tencent.timi.game.tim.api.message.a aVar) {
            this.f376425b = aVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            String str;
            TextView textView = BaseMessageView.this.revokeView;
            if (result != null) {
                str = result.i(this.f376425b.c());
            } else {
                str = null;
            }
            textView.setText("\"" + str + "\" \u64a4\u56de\u4e86\u4e00\u6761\u6d88\u606f");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            BaseMessageView.this.revokeView.setText("\"--\" \u64a4\u56de\u4e86\u4e00\u6761\u6d88\u606f");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMessageView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new ac();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean H;
                H = BaseMessageView.H(BaseMessageView.this, view, motionEvent);
                return H;
            }
        };
        this.positionOnTouchListener = onTouchListener;
        lazy = LazyKt__LazyJVMKt.lazy(BaseMessageView$onlineStatusDrawable$2.INSTANCE);
        this.onlineStatusDrawable = lazy;
        this.teamUpdateListener = new b();
        setClipChildren(false);
        setClipToPadding(false);
        int b16 = fh4.b.b(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.selfBubbleBg = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#FD942F"));
        float f16 = b16;
        this.selfBubbleBg.setCornerRadii(new float[]{0.0f, 0.0f, f16, f16, f16, f16, f16, f16});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.otherBubbleBg = gradientDrawable2;
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        this.otherBubbleBg.setCornerRadii(new float[]{0.0f, 0.0f, f16, f16, f16, f16, f16, f16});
        Drawable drawable = getResources().getDrawable(R.drawable.f160545jt);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(co\u2026drawable.common_loading3)");
        this.sendingDrawable = drawable;
        Drawable drawable2 = getResources().getDrawable(R.drawable.f160226dl);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(co\u2026R.drawable.aio_send_fail)");
        this.errorDrawable = drawable2;
        View.inflate(getContext(), R.layout.htk, this);
        View findViewById = findViewById(R.id.t4v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.baseContentContainer)");
        this.baseContentContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.f83054ij);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.sendState)");
        this.sendState = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.t4y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.baseStatusDescTv)");
        this.baseStatusDescTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.t4u);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.baseAvatarView)");
        this.baseAvatarView = (TimiAvatarRoundImageViewImpl) findViewById4;
        View findViewById5 = findViewById(R.id.t4x);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.baseNickView)");
        this.baseNickView = (TimiAvatarTextViewImpl) findViewById5;
        View findViewById6 = findViewById(R.id.t4w);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.baseGameRoleView)");
        this.baseGameRoleView = (TimUserGameInfoViewImpl) findViewById6;
        View findViewById7 = findViewById(R.id.t4z);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.baseTimeView)");
        this.baseTimeView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById8;
        this.baseContentContainer.setOnTouchListener(onTouchListener);
        this.sendState.setOnTouchListener(onTouchListener);
        fh4.g.f(this.baseStatusDescTv, fh4.b.b(10), Color.parseColor("#00CC8F"));
        this.baseStatusDescTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.i(BaseMessageView.this, view);
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean D;
                D = BaseMessageView.D(BaseMessageView.this, view);
                return D;
            }
        };
        this.onResendClick = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.E(BaseMessageView.this, view);
            }
        };
        this.onAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.B(view);
            }
        };
        this.onAvatarLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean C;
                C = BaseMessageView.C(BaseMessageView.this, view);
                return C;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(BaseMessageView this$0, View view) {
        boolean z16;
        Object I0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object b16 = vf4.a.b();
        com.tencent.timi.game.utils.l.i("BaseMsgView ", "userLongClick " + b16);
        CommonOuterClass$QQUserId uid = this$0.baseNickView.j();
        if (!(b16 instanceof com.tencent.timi.game.component.chat.at.d)) {
            Object obj = null;
            if (b16 instanceof QPublicFragmentActivity) {
                QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) b16;
                if (qPublicFragmentActivity.getFragment() instanceof com.tencent.timi.game.component.chat.at.d) {
                    Object fragment = qPublicFragmentActivity.getFragment();
                    if (fragment instanceof com.tencent.timi.game.component.chat.at.d) {
                        obj = (com.tencent.timi.game.component.chat.at.d) fragment;
                    }
                }
            }
            b16 = obj;
            if (b16 == null && (I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0()) != null && (I0 instanceof com.tencent.timi.game.component.chat.at.d)) {
                b16 = I0;
            }
        }
        if (b16 != null && !this$0.x()) {
            String g16 = this$0.baseNickView.g();
            if (g16 != null && g16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                SpecialMsgUtil specialMsgUtil = SpecialMsgUtil.f376345a;
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                SpecialMsgUtil.i(specialMsgUtil, uid, g16, (com.tencent.timi.game.component.chat.at.d) b16, null, null, 0L, 56, null);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(BaseMessageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.messageViewOperator.g(this$0.getContext(), this$0.msg, this$0.p(), this$0.lastPointerRawX, this$0.lastPointerRawY);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(BaseMessageView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.messageViewOperator.h(this$0.getContext(), this$0.msg, this$0.lastPointerRawX, this$0.lastPointerRawY);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(BaseMessageView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastPointerRawX = (int) motionEvent.getRawX();
        this$0.lastPointerRawY = (int) motionEvent.getRawY();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(com.tencent.timi.game.tim.api.message.a msg2, BaseMessageView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.f("base_avatar_click_" + msg2.id(), 300L)) {
            this$0.F(msg2);
            this$0.onAvatarClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(PremadesTeamServerOuterClass$UserOnlineRouteInfoList userOnlineRouteInfoList) {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        CommonOuterClass$OnlineRouteInfo commonOuterClass$OnlineRouteInfo;
        CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList;
        PBRepeatMessageField<CommonOuterClass$OnlineRouteInfo> pBRepeatMessageField;
        List<CommonOuterClass$OnlineRouteInfo> list;
        Object obj;
        String str = null;
        if (this.msg != null && (yoloRoomOuterClass$YoloRoomInfo = this.roomInfo) != null) {
            Intrinsics.checkNotNull(yoloRoomOuterClass$YoloRoomInfo);
            if (yoloRoomOuterClass$YoloRoomInfo.room_type.get() == 5) {
                if (userOnlineRouteInfoList != null && (commonOuterClass$OnlineRouteInfoList = userOnlineRouteInfoList.list) != null && (pBRepeatMessageField = commonOuterClass$OnlineRouteInfoList.route_list) != null && (list = pBRepeatMessageField.get()) != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            boolean z16 = true;
                            if (((CommonOuterClass$OnlineRouteInfo) obj).route_status.get() != 1) {
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
                    commonOuterClass$OnlineRouteInfo = (CommonOuterClass$OnlineRouteInfo) obj;
                } else {
                    commonOuterClass$OnlineRouteInfo = null;
                }
                if (commonOuterClass$OnlineRouteInfo == null) {
                    this.baseStatusDescTv.setVisibility(4);
                    this.baseAvatarView.setBackgroundDrawable(null);
                    return;
                }
                long j3 = commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_id.get();
                this.baseAvatarView.setBackgroundDrawable(s());
                this.baseStatusDescTv.setVisibility(0);
                if (this.routeInfoRoomId != j3) {
                    this.routeInfoRoomId = j3;
                    mm4.a b16 = mm4.b.b(ug4.b.class);
                    Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
                    ug4.b bVar = (ug4.b) b16;
                    TextView textView = this.baseStatusDescTv;
                    com.tencent.timi.game.tim.api.message.a aVar = this.msg;
                    if (aVar != null) {
                        str = aVar.id();
                    }
                    ConcurrentHashMap<String, String> L = YoloRoomUtil.L(this.roomInfo);
                    L.put("yes_team_id", String.valueOf(j3));
                    Unit unit = Unit.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u2026                        }");
                    b.a.a(bVar, textView, false, str, "em_yes_chat_teaming", L, 2, null);
                    return;
                }
                return;
            }
        }
        this.baseStatusDescTv.setVisibility(4);
        this.baseAvatarView.setBackgroundDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BaseMessageView this$0, View view) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList;
        PBRepeatMessageField<CommonOuterClass$OnlineRouteInfo> pBRepeatMessageField;
        List<CommonOuterClass$OnlineRouteInfo> list;
        Object obj;
        long j3;
        ExpandHallLaunchParam expandHallLaunchParam;
        int i3;
        List<Integer> emptyList;
        gh4.d m06;
        PBUInt64Field pBUInt64Field;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.utils.l.i("BaseMsgView ", "baseStatusDescTv click");
        TeamInfoAutoUpdateService h16 = TeamInfoAutoUpdateService.h();
        com.tencent.timi.game.tim.api.message.a aVar = this$0.msg;
        fm4.c cVar = null;
        if (aVar != null) {
            commonOuterClass$QQUserId = aVar.c();
        } else {
            commonOuterClass$QQUserId = null;
        }
        PremadesTeamServerOuterClass$UserOnlineRouteInfoList i16 = h16.i(commonOuterClass$QQUserId);
        if (i16 != null && (commonOuterClass$OnlineRouteInfoList = i16.list) != null && (pBRepeatMessageField = commonOuterClass$OnlineRouteInfoList.route_list) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((CommonOuterClass$OnlineRouteInfo) obj).route_status.get() == 1) {
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
            CommonOuterClass$OnlineRouteInfo commonOuterClass$OnlineRouteInfo = (CommonOuterClass$OnlineRouteInfo) obj;
            if (commonOuterClass$OnlineRouteInfo != null) {
                YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
                if (j06 != null && (pBUInt64Field = j06.room_id) != null) {
                    j3 = pBUInt64Field.get();
                } else {
                    j3 = 0;
                }
                gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
                if (I0 != null) {
                    expandHallLaunchParam = I0.O();
                } else {
                    expandHallLaunchParam = null;
                }
                gh4.e I02 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
                if (I02 != null && (m06 = I02.m0()) != null) {
                    cVar = m06.i();
                }
                com.tencent.timi.game.utils.l.i("BaseMsgView ", "joinYoloRoom " + commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_id.get());
                com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
                dVar.f379324a = commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_id.get();
                if (expandHallLaunchParam != null) {
                    i3 = com.tencent.timi.game.utils.b.h(expandHallLaunchParam.f376301d);
                } else {
                    i3 = 1;
                }
                dVar.f379325b = i3;
                dVar.f379326c = 1;
                dVar.f379328e = commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_type.get();
                dVar.f379329f = cVar;
                dVar.f379327d = ((fm4.g) mm4.b.b(fm4.g.class)).h2(commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_type.get());
                dVar.f379330g = j3;
                dVar.f379331h = 0L;
                com.tencent.timi.game.room.impl.util.c cVar2 = new com.tencent.timi.game.room.impl.util.c();
                cVar2.f379322a = 0;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cVar2.f379323b = emptyList;
                ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, vf4.a.b(), dVar, cVar2, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final GradientDrawable s() {
        return (GradientDrawable) this.onlineStatusDrawable.getValue();
    }

    private final boolean x() {
        com.tencent.timi.game.tim.api.message.a aVar = this.msg;
        if (aVar != null) {
            return ((bo4.d) mm4.b.b(bo4.d.class)).W0(aVar.c(), l());
        }
        return false;
    }

    protected final boolean A() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        n nVar = this.iMessageListener;
        if (nVar != null) {
            nVar.a(msg2.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G(@NotNull CommonOuterClass$QQUserId uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        n nVar = this.iMessageListener;
        if (nVar != null) {
            nVar.a(uid);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void I(@NotNull final com.tencent.timi.game.tim.api.message.a msg2) {
        int i3;
        boolean z16;
        Drawable drawable;
        boolean z17;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        boolean K = K(msg2);
        boolean z18 = false;
        if (y()) {
            this.baseAvatarView.setVisibility(0);
            this.baseAvatarView.setUserId(msg2.c(), l());
            this.baseAvatarView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMessageView.J(com.tencent.timi.game.tim.api.message.a.this, this, view);
                }
            });
            this.baseAvatarView.setOnLongClickListener(this.onAvatarLongClickListener);
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.roomInfo;
            if (yoloRoomOuterClass$YoloRoomInfo != null) {
                ConcurrentHashMap<String, String> L = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
                L.put("yes_to_uid", nn4.a.a(msg2.c().uid.get()));
                L.put("yes_to_yes_uid", nn4.a.a(msg2.c().yes_uid.get()));
                this.reportParam = L;
                mm4.a b16 = mm4.b.b(ug4.b.class);
                Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
                TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl = this.baseAvatarView;
                String id5 = msg2.id();
                Map<String, String> map = this.reportParam;
                Intrinsics.checkNotNull(map);
                b.a.c((ug4.b) b16, timiAvatarRoundImageViewImpl, false, id5, "em_yes_chat_user_head", map, 2, null);
            }
        } else {
            this.baseAvatarView.setVisibility(8);
        }
        if (K) {
            fh4.g.o(this.baseNickView, true);
            fh4.g.o(this.baseGameRoleView, true);
            this.baseNickView.setUserId(msg2.c(), l());
            this.baseGameRoleView.setUserId(msg2.c(), l());
        } else {
            fh4.g.o(this.baseNickView, false);
            fh4.g.o(this.baseGameRoleView, false);
        }
        ViewGroup.LayoutParams layoutParams = this.baseAvatarView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(11, 0);
        layoutParams2.addRule(9, 1);
        layoutParams2.rightMargin = fh4.b.a(5.5f);
        layoutParams2.leftMargin = fh4.b.a(13.5f);
        TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl2 = this.baseAvatarView;
        Intrinsics.checkNotNull(timiAvatarRoundImageViewImpl2);
        timiAvatarRoundImageViewImpl2.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = this.baseContentContainer;
        Intrinsics.checkNotNull(frameLayout);
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.addRule(0, 0);
        if (y()) {
            i3 = R.id.t4u;
        } else {
            i3 = 0;
        }
        layoutParams4.addRule(1, i3);
        FrameLayout frameLayout2 = this.baseContentContainer;
        Intrinsics.checkNotNull(frameLayout2);
        frameLayout2.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.sendState.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams6.addRule(0, 0);
        layoutParams6.addRule(1, R.id.t4v);
        layoutParams6.rightMargin = 0;
        layoutParams6.leftMargin = fh4.b.b(10);
        ImageView imageView = this.sendState;
        Intrinsics.checkNotNull(imageView);
        imageView.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = this.baseNickView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        layoutParams8.addRule(7, 0);
        layoutParams8.addRule(5, R.id.t4v);
        this.baseNickView.setLayoutParams(layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = this.baseGameRoleView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
        layoutParams10.addRule(1, R.id.t4x);
        layoutParams10.addRule(0, 0);
        layoutParams10.leftMargin = fh4.b.b(4);
        layoutParams10.rightMargin = fh4.b.b(20);
        layoutParams10.width = -2;
        this.baseGameRoleView.setLayoutParams(layoutParams10);
        LongClickOperOption[] p16 = p();
        if (p16 != null) {
            if (p16.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                FrameLayout frameLayout3 = this.baseContentContainer;
                Intrinsics.checkNotNull(frameLayout3);
                frameLayout3.setOnLongClickListener(this.onLongClickListner);
            }
        }
        if (L() && msg2.h() == MsgStatus.SENDING) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (msg2.h() == MsgStatus.FAILED) {
            z18 = true;
        }
        if (z16) {
            drawable = this.sendingDrawable;
        } else if (z18) {
            drawable = this.errorDrawable;
        } else {
            drawable = null;
        }
        if (drawable != null) {
            this.sendState.setImageDrawable(drawable);
            if (z16) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(500L);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                rotateAnimation.setRepeatCount(Integer.MAX_VALUE);
                rotateAnimation.setRepeatMode(-1);
                ImageView imageView2 = this.sendState;
                Intrinsics.checkNotNull(imageView2);
                imageView2.startAnimation(rotateAnimation);
            } else if (z18) {
                ImageView imageView3 = this.sendState;
                Intrinsics.checkNotNull(imageView3);
                imageView3.clearAnimation();
                ImageView imageView4 = this.sendState;
                Intrinsics.checkNotNull(imageView4);
                imageView4.setOnClickListener(this.onResendClick);
            }
        } else {
            ImageView imageView5 = this.sendState;
            Intrinsics.checkNotNull(imageView5);
            imageView5.clearAnimation();
            ImageView imageView6 = this.sendState;
            Intrinsics.checkNotNull(imageView6);
            imageView6.setImageDrawable(null);
        }
        M(TeamInfoAutoUpdateService.h().i(msg2.c()));
    }

    protected final boolean K(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return true;
    }

    protected final boolean L() {
        return true;
    }

    @Override // com.tencent.timi.game.component.chat.message.o
    public void a(@Nullable CommonOuterClass$QQUserId qqUserId, @NotNull com.tencent.timi.game.tim.api.message.a msg2, @Nullable com.tencent.timi.game.tim.api.message.a preMsg) {
        GradientDrawable gradientDrawable;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2;
        this.selfQQUserId = qqUserId;
        MessageLayout.a aVar = this.iImConfig;
        if (aVar != null) {
            this.baseTimeView.setTextColor(aVar.c());
            this.revokeView.setTextColor(aVar.c());
            this.baseNickView.setTextColor(aVar.h(msg2));
            this.baseGameRoleView.setRoleTextColor(aVar.g(msg2));
            if (z()) {
                if (msg2.b()) {
                    this.selfBubbleBg.setColor(aVar.d(msg2));
                } else {
                    this.otherBubbleBg.setColor(aVar.d(msg2));
                }
                FrameLayout frameLayout = this.baseContentContainer;
                if (msg2.b()) {
                    gradientDrawable = this.selfBubbleBg;
                } else {
                    gradientDrawable = this.otherBubbleBg;
                }
                frameLayout.setBackgroundDrawable(gradientDrawable);
            } else {
                this.baseContentContainer.setBackgroundDrawable(null);
            }
        }
        if (A() && (preMsg == null || Math.abs(msg2.time() - preMsg.time()) > 180000)) {
            fh4.g.o(this.baseTimeView, true);
            this.baseTimeView.setText(yn4.d.b(msg2.time()));
        } else {
            fh4.g.o(this.baseTimeView, false);
        }
        if (msg2.h() == MsgStatus.REVOKE) {
            fh4.g.o(this.baseContentContainer, false);
            fh4.g.o(this.baseStatusDescTv, false);
            fh4.g.o(this.baseAvatarView, false);
            fh4.g.o(this.sendState, false);
            fh4.g.o(this.baseNickView, false);
            fh4.g.o(this.baseGameRoleView, false);
            fh4.g.o(this.revokeView, true);
            if (msg2.b()) {
                this.revokeView.setText("\u4f60\u64a4\u56de\u4e86\u4e00\u6761\u6d88\u606f");
                return;
            }
            bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = msg2.c().get();
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "msg.sender().get()");
            dVar.I3(commonOuterClass$QQUserId, new a(msg2));
            return;
        }
        fh4.g.o(this.revokeView, false);
        fh4.g.o(this.baseContentContainer, true);
        fh4.g.o(this.baseAvatarView, true);
        fh4.g.o(this.sendState, true);
        fh4.g.o(this.baseNickView, true);
        fh4.g.o(this.baseGameRoleView, true);
        I(msg2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int l() {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.roomInfo;
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            return ((fm4.g) mm4.b.b(fm4.g.class)).K0(yoloRoomOuterClass$YoloRoomInfo.room_id.get()).o1();
        }
        return 0;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final FrameLayout getBaseContentContainer() {
        return this.baseContentContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: n, reason: from getter */
    public final MessageLayout.a getIImConfig() {
        return this.iImConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: o, reason: from getter */
    public final n getIMessageListener() {
        return this.iMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TeamInfoAutoUpdateService.h().l("base_chat_" + this.teamUpdateListener.hashCode(), this.teamUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.routeInfoRoomId = 0L;
        this.messageViewOperator.f();
        TeamInfoAutoUpdateService.h().o("base_chat_" + this.teamUpdateListener.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public LongClickOperOption[] p() {
        return new LongClickOperOption[]{LongClickOperOption.DELETE};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: q, reason: from getter */
    public final com.tencent.timi.game.tim.api.message.a getMsg() {
        return this.msg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: r, reason: from getter */
    public final View.OnLongClickListener getOnLongClickListner() {
        return this.onLongClickListner;
    }

    public final void setBaseContentContainer(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.baseContentContainer = frameLayout;
    }

    public void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.baseContentContainer.addView(view);
    }

    public final void setImConfig(@Nullable MessageLayout.a config) {
        this.iImConfig = config;
    }

    public final void setMessageListener(@Nullable n listener) {
        this.iMessageListener = listener;
    }

    public final void setYoloRoomInfo(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: t, reason: from getter */
    public final View.OnTouchListener getPositionOnTouchListener() {
        return this.positionOnTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Map<String, String> u() {
        return this.reportParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: v, reason: from getter */
    public final YoloRoomOuterClass$YoloRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: w, reason: from getter */
    public final CommonOuterClass$QQUserId getSelfQQUserId() {
        return this.selfQQUserId;
    }

    protected final boolean y() {
        return true;
    }

    protected boolean z() {
        return false;
    }

    public final void setContentView(@NotNull View view, @NotNull FrameLayout.LayoutParams lp5) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lp5, "lp");
        this.baseContentContainer.addView(view, lp5);
    }

    public void setContentView(@LayoutRes int layoutResID) {
        View.inflate(getContext(), layoutResID, this.baseContentContainer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new ac();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean H;
                H = BaseMessageView.H(BaseMessageView.this, view, motionEvent);
                return H;
            }
        };
        this.positionOnTouchListener = onTouchListener;
        lazy = LazyKt__LazyJVMKt.lazy(BaseMessageView$onlineStatusDrawable$2.INSTANCE);
        this.onlineStatusDrawable = lazy;
        this.teamUpdateListener = new b();
        setClipChildren(false);
        setClipToPadding(false);
        int b16 = fh4.b.b(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.selfBubbleBg = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#FD942F"));
        float f16 = b16;
        this.selfBubbleBg.setCornerRadii(new float[]{0.0f, 0.0f, f16, f16, f16, f16, f16, f16});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.otherBubbleBg = gradientDrawable2;
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        this.otherBubbleBg.setCornerRadii(new float[]{0.0f, 0.0f, f16, f16, f16, f16, f16, f16});
        Drawable drawable = getResources().getDrawable(R.drawable.f160545jt);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(co\u2026drawable.common_loading3)");
        this.sendingDrawable = drawable;
        Drawable drawable2 = getResources().getDrawable(R.drawable.f160226dl);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(co\u2026R.drawable.aio_send_fail)");
        this.errorDrawable = drawable2;
        View.inflate(getContext(), R.layout.htk, this);
        View findViewById = findViewById(R.id.t4v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.baseContentContainer)");
        this.baseContentContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.f83054ij);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.sendState)");
        this.sendState = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.t4y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.baseStatusDescTv)");
        this.baseStatusDescTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.t4u);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.baseAvatarView)");
        this.baseAvatarView = (TimiAvatarRoundImageViewImpl) findViewById4;
        View findViewById5 = findViewById(R.id.t4x);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.baseNickView)");
        this.baseNickView = (TimiAvatarTextViewImpl) findViewById5;
        View findViewById6 = findViewById(R.id.t4w);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.baseGameRoleView)");
        this.baseGameRoleView = (TimUserGameInfoViewImpl) findViewById6;
        View findViewById7 = findViewById(R.id.t4z);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.baseTimeView)");
        this.baseTimeView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById8;
        this.baseContentContainer.setOnTouchListener(onTouchListener);
        this.sendState.setOnTouchListener(onTouchListener);
        fh4.g.f(this.baseStatusDescTv, fh4.b.b(10), Color.parseColor("#00CC8F"));
        this.baseStatusDescTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.i(BaseMessageView.this, view);
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean D;
                D = BaseMessageView.D(BaseMessageView.this, view);
                return D;
            }
        };
        this.onResendClick = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.E(BaseMessageView.this, view);
            }
        };
        this.onAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.B(view);
            }
        };
        this.onAvatarLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean C;
                C = BaseMessageView.C(BaseMessageView.this, view);
                return C;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new ac();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean H;
                H = BaseMessageView.H(BaseMessageView.this, view, motionEvent);
                return H;
            }
        };
        this.positionOnTouchListener = onTouchListener;
        lazy = LazyKt__LazyJVMKt.lazy(BaseMessageView$onlineStatusDrawable$2.INSTANCE);
        this.onlineStatusDrawable = lazy;
        this.teamUpdateListener = new b();
        setClipChildren(false);
        setClipToPadding(false);
        int b16 = fh4.b.b(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.selfBubbleBg = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#FD942F"));
        float f16 = b16;
        this.selfBubbleBg.setCornerRadii(new float[]{0.0f, 0.0f, f16, f16, f16, f16, f16, f16});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.otherBubbleBg = gradientDrawable2;
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        this.otherBubbleBg.setCornerRadii(new float[]{0.0f, 0.0f, f16, f16, f16, f16, f16, f16});
        Drawable drawable = getResources().getDrawable(R.drawable.f160545jt);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(co\u2026drawable.common_loading3)");
        this.sendingDrawable = drawable;
        Drawable drawable2 = getResources().getDrawable(R.drawable.f160226dl);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(co\u2026R.drawable.aio_send_fail)");
        this.errorDrawable = drawable2;
        View.inflate(getContext(), R.layout.htk, this);
        View findViewById = findViewById(R.id.t4v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.baseContentContainer)");
        this.baseContentContainer = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.f83054ij);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.sendState)");
        this.sendState = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.t4y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.baseStatusDescTv)");
        this.baseStatusDescTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.t4u);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.baseAvatarView)");
        this.baseAvatarView = (TimiAvatarRoundImageViewImpl) findViewById4;
        View findViewById5 = findViewById(R.id.t4x);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.baseNickView)");
        this.baseNickView = (TimiAvatarTextViewImpl) findViewById5;
        View findViewById6 = findViewById(R.id.t4w);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.baseGameRoleView)");
        this.baseGameRoleView = (TimUserGameInfoViewImpl) findViewById6;
        View findViewById7 = findViewById(R.id.t4z);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.baseTimeView)");
        this.baseTimeView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById8;
        this.baseContentContainer.setOnTouchListener(onTouchListener);
        this.sendState.setOnTouchListener(onTouchListener);
        fh4.g.f(this.baseStatusDescTv, fh4.b.b(10), Color.parseColor("#00CC8F"));
        this.baseStatusDescTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.i(BaseMessageView.this, view);
            }
        });
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean D;
                D = BaseMessageView.D(BaseMessageView.this, view);
                return D;
            }
        };
        this.onResendClick = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.E(BaseMessageView.this, view);
            }
        };
        this.onAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.B(view);
            }
        };
        this.onAvatarLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.timi.game.component.chat.message.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean C;
                C = BaseMessageView.C(BaseMessageView.this, view);
                return C;
            }
        };
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016JB\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/component/chat/message/BaseMessageView$b", "Lcom/tencent/timi/game/teamlist/service/TeamInfoAutoUpdateService$b;", "", "", "b", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "d", "", "requestScene", "Ltrpc/yes/common/PremadesTeamServerOuterClass$ShareYoloRoomMsg;", "shareYoloRoomMsgList", "Ltrpc/yes/common/PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;", "teamList", "reqTeamIds", "", "a", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements TeamInfoAutoUpdateService.b {
        b() {
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        @NotNull
        public List<Long> b() {
            return new ArrayList();
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        public void c() {
            MsgStatus msgStatus;
            com.tencent.timi.game.tim.api.message.a msg2 = BaseMessageView.this.getMsg();
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = null;
            if (msg2 != null) {
                msgStatus = msg2.h();
            } else {
                msgStatus = null;
            }
            if (msgStatus == MsgStatus.REVOKE) {
                return;
            }
            TeamInfoAutoUpdateService h16 = TeamInfoAutoUpdateService.h();
            com.tencent.timi.game.tim.api.message.a msg3 = BaseMessageView.this.getMsg();
            if (msg3 != null) {
                commonOuterClass$QQUserId = msg3.c();
            }
            BaseMessageView.this.M(h16.i(commonOuterClass$QQUserId));
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        @NotNull
        public List<CommonOuterClass$QQUserId> d() {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId;
            boolean z16;
            List<CommonOuterClass$QQUserId> mutableListOf;
            PBInt32Field pBInt32Field;
            com.tencent.timi.game.tim.api.message.a msg2 = BaseMessageView.this.getMsg();
            if (msg2 != null) {
                commonOuterClass$QQUserId = msg2.c();
            } else {
                commonOuterClass$QQUserId = null;
            }
            if (commonOuterClass$QQUserId != null) {
                YoloRoomOuterClass$YoloRoomInfo roomInfo = BaseMessageView.this.getRoomInfo();
                if (roomInfo != null && (pBInt32Field = roomInfo.room_type) != null && pBInt32Field.get() == 5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(commonOuterClass$QQUserId);
                    return mutableListOf;
                }
            }
            return new ArrayList();
        }

        @Override // com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.b
        public void a(@Nullable String requestScene, @Nullable List<PremadesTeamServerOuterClass$ShareYoloRoomMsg> shareYoloRoomMsgList, @Nullable List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> teamList, @Nullable List<Long> reqTeamIds) {
        }
    }
}
