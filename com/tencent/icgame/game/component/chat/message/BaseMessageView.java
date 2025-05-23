package com.tencent.icgame.game.component.chat.message;

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
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.component.chat.message.MessageLayout;
import com.tencent.icgame.game.tim.api.message.MsgStatus;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.view.TimUserGameInfoViewImpl;
import com.tencent.icgame.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import com.tencent.icgame.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.IResultListener;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0016\u0012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001B!\b\u0016\u0012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001\u0012\n\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009f\u0001\u00a2\u0006\u0006\b\u009d\u0001\u0010\u00a1\u0001B*\b\u0016\u0012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001\u0012\n\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009f\u0001\u0012\u0007\u0010\u00a2\u0001\u001a\u00020\u000e\u00a2\u0006\u0006\b\u009d\u0001\u0010\u00a3\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0004J\b\u0010\u0019\u001a\u00020\u000eH\u0004J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0015J\u0017\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0003H\u0004J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0004J\b\u0010!\u001a\u00020\u0003H\u0004J\b\u0010\"\u001a\u00020\u0003H\u0004J$\u0010&\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010'\u001a\u00020\u0007H\u0014J\b\u0010(\u001a\u00020\u0007H\u0014R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00100R\u0016\u00103\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u00104\u001a\u0004\b2\u00105\"\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\u0016\u0010;\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010L\u001a\u0004\u0018\u00010#8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR0\u0010T\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020N\u0018\u00010M8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u0014\u0010c\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010^R\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u001a\u0010y\u001a\u00020t8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R)\u0010\u0086\u0001\u001a\u00020\u007f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0017\u0010\u008e\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u0081\u0001R+\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001\u00a8\u0006\u00a4\u0001"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/BaseMessageView;", "Lcom/tencent/icgame/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Lcom/tencent/icgame/game/component/chat/message/j;", "", "r", "Lcom/tencent/icgame/game/component/chat/message/i;", "listener", "", "setMessageListener", "Landroid/view/View;", "view", "setContentView", "Landroid/widget/FrameLayout$LayoutParams;", "lp", "", "layoutResID", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;", DownloadInfo.spKey_Config, "setImConfig", "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "setYoloRoomInfo", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "y", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lcom/tencent/icgame/game/component/chat/message/LongClickOperOption;", "l", "()[Lcom/tencent/icgame/game/component/chat/message/LongClickOperOption;", "D", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "t", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "preMsg", "a", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/drawable/GradientDrawable;", "f", "Landroid/graphics/drawable/GradientDrawable;", "selfBubbleBg", tl.h.F, "otherBubbleBg", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "sendingDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "errorDrawable", "Lcom/tencent/icgame/game/tim/api/message/a;", "()Lcom/tencent/icgame/game/tim/api/message/a;", "setMsg", "(Lcom/tencent/icgame/game/tim/api/message/a;)V", "I", "lastPointerRawX", "E", "lastPointerRawY", "Lcom/tencent/icgame/game/component/chat/message/p;", UserInfo.SEX_FEMALE, "Lcom/tencent/icgame/game/component/chat/message/p;", "messageViewOperator", "G", "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "p", "()Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "setRoomInfo", "(Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;)V", "H", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "setSelfQQUserId", "(Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;)V", "selfQQUserId", "", "", "Ljava/util/Map;", "getReportParam", "()Ljava/util/Map;", "setReportParam", "(Ljava/util/Map;)V", "reportParam", "", "J", "routeInfoRoomId", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "sendState", "Landroid/widget/TextView;", "L", "Landroid/widget/TextView;", "revokeView", "M", "baseTimeView", "N", "baseStatusDescTv", "Landroid/widget/FrameLayout;", "P", "Landroid/widget/FrameLayout;", "baseContentContainer", "Lcom/tencent/icgame/game/userinfo/impl/view/TimiAvatarTextViewImpl;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/icgame/game/userinfo/impl/view/TimiAvatarTextViewImpl;", "baseNickView", "Lcom/tencent/icgame/game/userinfo/impl/view/TimUserGameInfoViewImpl;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/icgame/game/userinfo/impl/view/TimUserGameInfoViewImpl;", "baseGameRoleView", "Lcom/tencent/icgame/game/userinfo/impl/view/TimiAvatarRoundImageViewImpl;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/icgame/game/userinfo/impl/view/TimiAvatarRoundImageViewImpl;", "baseAvatarView", "Landroid/view/View$OnTouchListener;", "T", "Landroid/view/View$OnTouchListener;", "o", "()Landroid/view/View$OnTouchListener;", "positionOnTouchListener", "U", "Lkotlin/Lazy;", "getOnlineStatusDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "onlineStatusDrawable", "Landroid/view/View$OnLongClickListener;", "V", "Landroid/view/View$OnLongClickListener;", DomainData.DOMAIN_NAME, "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListner", "(Landroid/view/View$OnLongClickListener;)V", "onLongClickListner", "Landroid/view/View$OnClickListener;", "W", "Landroid/view/View$OnClickListener;", "onResendClick", "a0", "onAvatarClickListener", "b0", "onAvatarLongClickListener", "iImConfig", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;", "j", "()Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;", "setIImConfig", "(Lcom/tencent/icgame/game/component/chat/message/MessageLayout$a;)V", "iMessageListener", "Lcom/tencent/icgame/game/component/chat/message/i;", "k", "()Lcom/tencent/icgame/game/component/chat/message/i;", "setIMessageListener", "(Lcom/tencent/icgame/game/component/chat/message/i;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class BaseMessageView extends TouchPositionGetableRelativeLayout implements j {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.icgame.game.tim.api.message.a msg;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastPointerRawX;

    /* renamed from: E, reason: from kotlin metadata */
    private int lastPointerRawY;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private p messageViewOperator;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId selfQQUserId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Map<String, String> reportParam;

    /* renamed from: J, reason: from kotlin metadata */
    private long routeInfoRoomId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ImageView sendState;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView revokeView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final TextView baseTimeView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextView baseStatusDescTv;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout baseContentContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TimiAvatarTextViewImpl baseNickView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final TimUserGameInfoViewImpl baseGameRoleView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final TimiAvatarRoundImageViewImpl baseAvatarView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final View.OnTouchListener positionOnTouchListener;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineStatusDrawable;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private View.OnLongClickListener onLongClickListner;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener onResendClick;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onAvatarClickListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/component/chat/message/BaseMessageView$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements IResultListener<IUserInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.icgame.game.tim.api.message.a f114923b;

        a(com.tencent.icgame.game.tim.api.message.a aVar) {
            this.f114923b = aVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            String str;
            TextView textView = BaseMessageView.this.revokeView;
            if (result != null) {
                str = result.h(this.f114923b.c());
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
        this.messageViewOperator = new p();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z16;
                z16 = BaseMessageView.z(BaseMessageView.this, view, motionEvent);
                return z16;
            }
        };
        this.positionOnTouchListener = onTouchListener;
        lazy = LazyKt__LazyJVMKt.lazy(BaseMessageView$onlineStatusDrawable$2.INSTANCE);
        this.onlineStatusDrawable = lazy;
        setClipChildren(false);
        setClipToPadding(false);
        int b16 = uu0.a.b(8);
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
        View.inflate(getContext(), R.layout.fbd, this);
        View findViewById = findViewById(R.id.f83054ij);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sendState)");
        ImageView imageView = (ImageView) findViewById;
        this.sendState = imageView;
        View findViewById2 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t4z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.baseTimeView)");
        this.baseTimeView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.t4y);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.baseStatusDescTv)");
        TextView textView = (TextView) findViewById4;
        this.baseStatusDescTv = textView;
        View findViewById5 = findViewById(R.id.t4v);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.baseContentContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById5;
        this.baseContentContainer = frameLayout;
        View findViewById6 = findViewById(R.id.t4u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.baseAvatarView)");
        this.baseAvatarView = (TimiAvatarRoundImageViewImpl) findViewById6;
        View findViewById7 = findViewById(R.id.t4x);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.baseNickView)");
        this.baseNickView = (TimiAvatarTextViewImpl) findViewById7;
        View findViewById8 = findViewById(R.id.t4w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.baseGameRoleView)");
        this.baseGameRoleView = (TimUserGameInfoViewImpl) findViewById8;
        frameLayout.setOnTouchListener(onTouchListener);
        imageView.setOnTouchListener(onTouchListener);
        uu0.b.d(textView, uu0.a.b(10), Color.parseColor("#00CC8F"));
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean w3;
                w3 = BaseMessageView.w(BaseMessageView.this, view);
                return w3;
            }
        };
        this.onResendClick = new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.x(BaseMessageView.this, view);
            }
        };
        this.onAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.u(view);
            }
        };
        this.onAvatarLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean v3;
                v3 = BaseMessageView.v(BaseMessageView.this, view);
                return v3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(com.tencent.icgame.game.tim.api.message.a msg2, BaseMessageView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.f("base_avatar_click_" + msg2.id(), 300L)) {
            this$0.y(msg2);
            this$0.onAvatarClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean r() {
        com.tencent.icgame.game.tim.api.message.a aVar = this.msg;
        if (aVar != null) {
            return ((ey0.d) qx0.a.b(ey0.d.class)).c3(aVar.c(), i());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(BaseMessageView this$0, View view) {
        du0.d dVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object b16 = bu0.a.b();
        com.tencent.icgame.game.utils.g.h("BaseMsgView ", "userLongClick " + b16);
        CommonOuterClass$QQUserId uid = this$0.baseNickView.i();
        if (!(b16 instanceof du0.d)) {
            du0.d dVar2 = null;
            if (b16 instanceof QPublicFragmentActivity) {
                QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) b16;
                if (qPublicFragmentActivity.getFragment() instanceof du0.d) {
                    ActivityResultCaller fragment = qPublicFragmentActivity.getFragment();
                    if (fragment instanceof du0.d) {
                        dVar2 = (du0.d) fragment;
                    }
                }
            }
            dVar = dVar2;
        } else {
            dVar = (du0.d) b16;
        }
        if (dVar != null && !this$0.r()) {
            String g16 = this$0.baseNickView.g();
            if (g16 != null && g16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                du0.e eVar = du0.e.f394864a;
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                du0.e.e(eVar, uid, g16, dVar, null, null, 0L, 56, null);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(BaseMessageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.messageViewOperator.g(this$0.getContext(), this$0.msg, this$0.l(), this$0.lastPointerRawX, this$0.lastPointerRawY);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(BaseMessageView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.messageViewOperator.h(this$0.getContext(), this$0.msg, this$0.lastPointerRawX, this$0.lastPointerRawY);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(BaseMessageView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastPointerRawX = (int) motionEvent.getRawX();
        this$0.lastPointerRawY = (int) motionEvent.getRawY();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void A(@NotNull final com.tencent.icgame.game.tim.api.message.a msg2) {
        int i3;
        boolean z16;
        Drawable drawable;
        boolean z17;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        boolean C = C(msg2);
        boolean z18 = false;
        if (s()) {
            this.baseAvatarView.setVisibility(0);
            this.baseAvatarView.setUserId(msg2.c(), i());
            this.baseAvatarView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMessageView.B(com.tencent.icgame.game.tim.api.message.a.this, this, view);
                }
            });
            this.baseAvatarView.setOnLongClickListener(this.onAvatarLongClickListener);
            if (this.roomInfo != null) {
                mm4.a b16 = qx0.a.b(ru0.b.class);
                Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
                TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl = this.baseAvatarView;
                String id5 = msg2.id();
                Map<String, String> map = this.reportParam;
                Intrinsics.checkNotNull(map);
                b.a.a((ru0.b) b16, timiAvatarRoundImageViewImpl, false, id5, "em_yes_chat_user_head", map, 2, null);
            }
        } else {
            this.baseAvatarView.setVisibility(8);
        }
        if (C) {
            uu0.b.i(this.baseNickView, true);
            uu0.b.i(this.baseGameRoleView, true);
            this.baseNickView.setUserId(msg2.c(), i());
            this.baseGameRoleView.setUserId(msg2.c(), i());
        } else {
            uu0.b.i(this.baseNickView, false);
            uu0.b.i(this.baseGameRoleView, false);
        }
        ViewGroup.LayoutParams layoutParams = this.baseAvatarView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(11, 0);
        layoutParams2.addRule(9, 1);
        layoutParams2.rightMargin = uu0.a.a(5.5f);
        layoutParams2.leftMargin = uu0.a.a(13.5f);
        TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl2 = this.baseAvatarView;
        Intrinsics.checkNotNull(timiAvatarRoundImageViewImpl2);
        timiAvatarRoundImageViewImpl2.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = this.baseContentContainer;
        Intrinsics.checkNotNull(frameLayout);
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.addRule(0, 0);
        if (s()) {
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
        layoutParams6.leftMargin = uu0.a.b(10);
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
        layoutParams10.leftMargin = uu0.a.b(4);
        layoutParams10.rightMargin = uu0.a.b(20);
        layoutParams10.width = -2;
        this.baseGameRoleView.setLayoutParams(layoutParams10);
        LongClickOperOption[] l3 = l();
        if (l3 != null) {
            if (l3.length == 0) {
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
        if (D() && msg2.h() == MsgStatus.SENDING) {
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
                return;
            }
            if (z18) {
                ImageView imageView3 = this.sendState;
                Intrinsics.checkNotNull(imageView3);
                imageView3.clearAnimation();
                ImageView imageView4 = this.sendState;
                Intrinsics.checkNotNull(imageView4);
                imageView4.setOnClickListener(this.onResendClick);
                return;
            }
            return;
        }
        ImageView imageView5 = this.sendState;
        Intrinsics.checkNotNull(imageView5);
        imageView5.clearAnimation();
        ImageView imageView6 = this.sendState;
        Intrinsics.checkNotNull(imageView6);
        imageView6.setImageDrawable(null);
    }

    protected final boolean C(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return true;
    }

    protected final boolean D() {
        return true;
    }

    @Override // com.tencent.icgame.game.component.chat.message.j
    public void a(@Nullable CommonOuterClass$QQUserId qqUserId, @NotNull com.tencent.icgame.game.tim.api.message.a msg2, @Nullable com.tencent.icgame.game.tim.api.message.a preMsg) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msg = msg2;
        this.selfQQUserId = qqUserId;
        if (t() && (preMsg == null || Math.abs(msg2.time() - preMsg.time()) > 180000)) {
            uu0.b.i(this.baseTimeView, true);
            this.baseTimeView.setText(cy0.c.b(msg2.time()));
        } else {
            uu0.b.i(this.baseTimeView, false);
        }
        if (msg2.h() == MsgStatus.REVOKE) {
            uu0.b.i(this.baseContentContainer, false);
            uu0.b.i(this.baseStatusDescTv, false);
            uu0.b.i(this.baseAvatarView, false);
            uu0.b.i(this.sendState, false);
            uu0.b.i(this.baseNickView, false);
            uu0.b.i(this.baseGameRoleView, false);
            uu0.b.i(this.revokeView, true);
            if (msg2.b()) {
                this.revokeView.setText("\u4f60\u64a4\u56de\u4e86\u4e00\u6761\u6d88\u606f");
                return;
            }
            ey0.d dVar = (ey0.d) qx0.a.b(ey0.d.class);
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = msg2.c().get();
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "msg.sender().get()");
            dVar.i0(commonOuterClass$QQUserId, new a(msg2));
            return;
        }
        uu0.b.i(this.revokeView, false);
        uu0.b.i(this.baseContentContainer, true);
        uu0.b.i(this.baseAvatarView, true);
        uu0.b.i(this.sendState, true);
        uu0.b.i(this.baseNickView, true);
        uu0.b.i(this.baseGameRoleView, true);
        A(msg2);
    }

    protected final int i() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageLayout.a j() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final i k() {
        return null;
    }

    @Nullable
    protected LongClickOperOption[] l() {
        return new LongClickOperOption[]{LongClickOperOption.DELETE};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: m, reason: from getter */
    public final com.tencent.icgame.game.tim.api.message.a getMsg() {
        return this.msg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: n, reason: from getter */
    public final View.OnLongClickListener getOnLongClickListner() {
        return this.onLongClickListner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: o, reason: from getter */
    public final View.OnTouchListener getPositionOnTouchListener() {
        return this.positionOnTouchListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.routeInfoRoomId = 0L;
        this.messageViewOperator.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: p, reason: from getter */
    public final YoloRoomOuterClass$YoloRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: q, reason: from getter */
    public final CommonOuterClass$QQUserId getSelfQQUserId() {
        return this.selfQQUserId;
    }

    protected final boolean s() {
        return true;
    }

    public void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.baseContentContainer.addView(view);
    }

    public final void setYoloRoomInfo(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }

    protected final boolean t() {
        return true;
    }

    protected final void y(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    public final void setContentView(@NotNull View view, @NotNull FrameLayout.LayoutParams lp5) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lp5, "lp");
        this.baseContentContainer.addView(view, lp5);
    }

    public void setContentView(@LayoutRes int layoutResID) {
        View.inflate(getContext(), layoutResID, this.baseContentContainer);
    }

    public final void setImConfig(@Nullable MessageLayout.a config) {
    }

    public final void setMessageListener(@Nullable i listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new p();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z16;
                z16 = BaseMessageView.z(BaseMessageView.this, view, motionEvent);
                return z16;
            }
        };
        this.positionOnTouchListener = onTouchListener;
        lazy = LazyKt__LazyJVMKt.lazy(BaseMessageView$onlineStatusDrawable$2.INSTANCE);
        this.onlineStatusDrawable = lazy;
        setClipChildren(false);
        setClipToPadding(false);
        int b16 = uu0.a.b(8);
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
        View.inflate(getContext(), R.layout.fbd, this);
        View findViewById = findViewById(R.id.f83054ij);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sendState)");
        ImageView imageView = (ImageView) findViewById;
        this.sendState = imageView;
        View findViewById2 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t4z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.baseTimeView)");
        this.baseTimeView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.t4y);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.baseStatusDescTv)");
        TextView textView = (TextView) findViewById4;
        this.baseStatusDescTv = textView;
        View findViewById5 = findViewById(R.id.t4v);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.baseContentContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById5;
        this.baseContentContainer = frameLayout;
        View findViewById6 = findViewById(R.id.t4u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.baseAvatarView)");
        this.baseAvatarView = (TimiAvatarRoundImageViewImpl) findViewById6;
        View findViewById7 = findViewById(R.id.t4x);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.baseNickView)");
        this.baseNickView = (TimiAvatarTextViewImpl) findViewById7;
        View findViewById8 = findViewById(R.id.t4w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.baseGameRoleView)");
        this.baseGameRoleView = (TimUserGameInfoViewImpl) findViewById8;
        frameLayout.setOnTouchListener(onTouchListener);
        imageView.setOnTouchListener(onTouchListener);
        uu0.b.d(textView, uu0.a.b(10), Color.parseColor("#00CC8F"));
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean w3;
                w3 = BaseMessageView.w(BaseMessageView.this, view);
                return w3;
            }
        };
        this.onResendClick = new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.x(BaseMessageView.this, view);
            }
        };
        this.onAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.u(view);
            }
        };
        this.onAvatarLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean v3;
                v3 = BaseMessageView.v(BaseMessageView.this, view);
                return v3;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.messageViewOperator = new p();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z16;
                z16 = BaseMessageView.z(BaseMessageView.this, view, motionEvent);
                return z16;
            }
        };
        this.positionOnTouchListener = onTouchListener;
        lazy = LazyKt__LazyJVMKt.lazy(BaseMessageView$onlineStatusDrawable$2.INSTANCE);
        this.onlineStatusDrawable = lazy;
        setClipChildren(false);
        setClipToPadding(false);
        int b16 = uu0.a.b(8);
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
        View.inflate(getContext(), R.layout.fbd, this);
        View findViewById = findViewById(R.id.f83054ij);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sendState)");
        ImageView imageView = (ImageView) findViewById;
        this.sendState = imageView;
        View findViewById2 = findViewById(R.id.f73773ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.revokeView)");
        this.revokeView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t4z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.baseTimeView)");
        this.baseTimeView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.t4y);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.baseStatusDescTv)");
        TextView textView = (TextView) findViewById4;
        this.baseStatusDescTv = textView;
        View findViewById5 = findViewById(R.id.t4v);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.baseContentContainer)");
        FrameLayout frameLayout = (FrameLayout) findViewById5;
        this.baseContentContainer = frameLayout;
        View findViewById6 = findViewById(R.id.t4u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.baseAvatarView)");
        this.baseAvatarView = (TimiAvatarRoundImageViewImpl) findViewById6;
        View findViewById7 = findViewById(R.id.t4x);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.baseNickView)");
        this.baseNickView = (TimiAvatarTextViewImpl) findViewById7;
        View findViewById8 = findViewById(R.id.t4w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.baseGameRoleView)");
        this.baseGameRoleView = (TimUserGameInfoViewImpl) findViewById8;
        frameLayout.setOnTouchListener(onTouchListener);
        imageView.setOnTouchListener(onTouchListener);
        uu0.b.d(textView, uu0.a.b(10), Color.parseColor("#00CC8F"));
        this.onLongClickListner = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean w3;
                w3 = BaseMessageView.w(BaseMessageView.this, view);
                return w3;
            }
        };
        this.onResendClick = new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.x(BaseMessageView.this, view);
            }
        };
        this.onAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMessageView.u(view);
            }
        };
        this.onAvatarLongClickListener = new View.OnLongClickListener() { // from class: com.tencent.icgame.game.component.chat.message.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean v3;
                v3 = BaseMessageView.v(BaseMessageView.this, view);
                return v3;
            }
        };
    }
}
