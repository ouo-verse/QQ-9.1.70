package com.tencent.mobileqq.guild.media.game.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import bt1.RoomAuthParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.IGuildClientAuthApi;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard;
import com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.util.NumberUtil;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs1.GuildAuthGameBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0084\u0001B!\b\u0007\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"0!H\u0002J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'J\b\u0010*\u001a\u00020\u0004H\u0007J\b\u0010+\u001a\u00020\u0004H\u0007J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0010\u00102\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u000201H\u0016R\u0018\u00105\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010E\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010AR\u0016\u0010G\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010AR\u0016\u0010I\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00107R\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010KR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010KR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010OR\u0016\u0010R\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010T\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00107R\u0016\u0010U\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010AR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010WR\u0016\u0010Y\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010OR\u0016\u0010[\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010OR\u0016\u0010]\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010WR\u0016\u0010_\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010OR\u0016\u0010`\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010OR\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010e\u001a\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010k\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010\u001eR\u0016\u0010l\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001eR\u0016\u0010m\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010o\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010\u001eR\u0016\u0010q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010pR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010SR\u0016\u0010t\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010SR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010SR\u0016\u0010w\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010pR\u0016\u0010z\u001a\u00020x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010QR\u001e\u0010}\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010|\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "u", "c0", "e0", "i0", "", "selfId", "", "isQuit", "f0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Req, "w", "v", "L", "K", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycle", "M", "U", UserInfo.SEX_FEMALE, "G", "H", BdhLogUtil.LogTag.Tag_Conn, "W", "isEnd", "Z", "isJoin", "a0", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lbt1/h;", "vm", ExifInterface.LATITUDE_SOUTH, "Landroid/content/res/Configuration;", "newConfig", "T", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, HippyTKDListViewAdapter.X, "j0", "y", "d0", "Landroid/view/View;", NodeProps.ON_CLICK, "d", "Lbt1/h;", "mRoomViewModel", "e", "Landroid/view/View;", "mRootView", "f", "mRootLayout", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", tl.h.F, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mCaptainAvatar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTeamName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mGradeName", "mGameMode", "D", "mRoomState", "E", "mBtnLayout", "Landroid/widget/Button;", "Landroid/widget/Button;", "mEnterOrJoinGameBtn", "mQuitTeamBtn", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mAppIcon", "I", "mCloseBtn", "J", "mCaptainLayout", "mGradeNameCaptain", "Lcom/tencent/widget/RoundRectImageView;", "Lcom/tencent/widget/RoundRectImageView;", "mTeamCardBg", "mTeamCardBorder", "N", "mInGameAnim", "P", "mTeamCardAddOne", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mArrowAnim", "mUserMedal", "Ljava/util/Timer;", "Ljava/util/Timer;", "mTimer", "Lcom/tencent/mobileqq/guild/media/core/l;", "Lkotlin/Lazy;", "B", "()Lcom/tencent/mobileqq/guild/media/core/l;", "mDataHub", "mInTeam", "V", "mIsCaptain", "mGameStarted", "mNeedChangeHeight", "b0", "mIsReport", "Ljava/lang/String;", "mCaptainName", "", "mMaxMember", "mCurMember", "mGameStartTime", "g0", "mBgUrl", "", "h0", "sceneType", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "lifecycleOwner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGameTeamCard extends FrameLayout implements View.OnClickListener, LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TextView mGameMode;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TextView mRoomState;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View mBtnLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Button mEnterOrJoinGameBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Button mQuitTeamBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ImageView mAppIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private ImageView mCloseBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private View mCaptainLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private TextView mGradeNameCaptain;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private RoundRectImageView mTeamCardBg;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private ImageView mTeamCardBorder;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ImageView mInGameAnim;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private RoundRectImageView mTeamCardAddOne;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private ImageView mArrowAnim;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private ImageView mUserMedal;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Timer mTimer;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDataHub;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mInTeam;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mIsCaptain;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mGameStarted;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedChangeHeight;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsReport;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCaptainName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private bt1.h mRoomViewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private long mMaxMember;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mRootView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long mCurMember;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mRootLayout;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private long mGameStartTime;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mBgUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildUserAvatarView mCaptainAvatar;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int sceneType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mTeamName;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<LifecycleOwner> lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mGradeName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard$b", "Llf4/a;", "", "onSuccess", "b", "onUserCancel", "a", "onFailed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements lf4.a {
        b() {
        }

        @Override // lf4.a
        public void a() {
            QLog.i("QMGame.GuildGameTeamCard", 1, "launchGame onJumpForbidden");
            bt1.h hVar = GuildGameTeamCard.this.mRoomViewModel;
            if (hVar != null) {
                hVar.v2();
            }
        }

        @Override // lf4.a
        public void b() {
            QLog.i("QMGame.GuildGameTeamCard", 1, "launchGame onAppNotInstalled");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            QQToast.makeText(context, context.getString(R.string.f140010ct), 0).show();
            bt1.h hVar = GuildGameTeamCard.this.mRoomViewModel;
            if (hVar != null) {
                hVar.v2();
            }
        }

        @Override // lf4.a
        public void onFailed() {
            QLog.i("QMGame.GuildGameTeamCard", 1, "launchGame onFailed");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            QQToast.makeText(context, context.getString(R.string.f140020cu), 0).show();
            bt1.h hVar = GuildGameTeamCard.this.mRoomViewModel;
            if (hVar != null) {
                hVar.v2();
            }
        }

        @Override // lf4.a
        public void onSuccess() {
            QLog.i("QMGame.GuildGameTeamCard", 1, "launchGame onSuccess");
        }

        @Override // lf4.a
        public void onUserCancel() {
            QLog.i("QMGame.GuildGameTeamCard", 1, "launchGame onUserCancel");
            bt1.h hVar = GuildGameTeamCard.this.mRoomViewModel;
            if (hVar != null) {
                hVar.v2();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GuildPicStateListener {
        c() {
            super(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(GuildGameTeamCard this$0, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.mTeamCardBg.setImageBitmap(bitmap);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            final Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final GuildGameTeamCard guildGameTeamCard = GuildGameTeamCard.this;
                    uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.game.widget.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildGameTeamCard.c.e(GuildGameTeamCard.this, resultBitMap);
                        }
                    });
                    return;
                }
                GuildGameTeamCard.this.mTeamCardBg.setImageBitmap(resultBitMap);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGameTeamCard(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Map<String, Object> A() {
        String str;
        String str2;
        Map<String, Object> mapOf;
        String i26;
        Map<String, Object> emptyMap;
        if (this.sceneType == 1) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        Pair[] pairArr = new Pair[5];
        bt1.h hVar = this.mRoomViewModel;
        if (hVar == null || (str = hVar.p2()) == null) {
            str = "0";
        }
        pairArr[0] = TuplesKt.to("sgrp_game_team_id", str);
        bt1.h hVar2 = this.mRoomViewModel;
        String str3 = "";
        if (hVar2 == null || (str2 = hVar2.o2()) == null) {
            str2 = "";
        }
        pairArr[1] = TuplesKt.to("sgrp_user_segment", str2);
        bt1.h hVar3 = this.mRoomViewModel;
        if (hVar3 != null && (i26 = hVar3.i2()) != null) {
            str3 = i26;
        }
        pairArr[2] = TuplesKt.to("sgrp_game_mode", str3);
        pairArr[3] = TuplesKt.to("sgrp_team_users_number", Long.valueOf(this.mCurMember));
        pairArr[4] = TuplesKt.to("sgrp_segment_requirement", this.mGradeName.getText());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final com.tencent.mobileqq.guild.media.core.l B() {
        return (com.tencent.mobileqq.guild.media.core.l) this.mDataHub.getValue();
    }

    private final void C() {
        if (this.mGameStarted) {
            QQToast.makeText(getContext(), getContext().getString(R.string.f140000cs), 0).show();
        } else {
            DialogUtil.createCustomDialog(getContext(), 230, null, getContext().getString(R.string.f139980cq), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildGameTeamCard.D(GuildGameTeamCard.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildGameTeamCard.E(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GuildGameTeamCard this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bt1.h hVar = this$0.mRoomViewModel;
        if (hVar != null) {
            hVar.y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void F() {
        QLog.i("QMGame.GuildGameTeamCard", 1, "handleEnterGame");
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getGameRoomHandler().a(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().C.getUserInfoInGame().getSchema(), QBaseActivity.sTopActivity, new b());
    }

    private final void G() {
        RoomAuthParams roomAuthParams = new RoomAuthParams(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()), com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c()), 101, true, 1);
        bt1.h hVar = this.mRoomViewModel;
        if (hVar != null) {
            hVar.T1(roomAuthParams);
        }
    }

    private final void H() {
        QLog.i("QMGame.GuildGameTeamCard", 1, "handleQuitTeam");
        DialogUtil.createCustomDialog(getContext(), 230, null, getContext().getString(R.string.f139990cr), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildGameTeamCard.I(GuildGameTeamCard.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildGameTeamCard.J(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(GuildGameTeamCard this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bt1.h hVar = this$0.mRoomViewModel;
        if (hVar != null) {
            hVar.v2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void K() {
        String str;
        QLog.i("QMGame.GuildGameTeamCard", 1, "inGameAnimation");
        this.mInGameAnim.setVisibility(0);
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        if (this.mNeedChangeHeight) {
            str = "https://downv6.qq.com/innovate/guild/media_game/guild_game_top_in_game_fold.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/media_game/guild_game_top_in_game.png";
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(GuildMediaUtils.f227771a.n() ? 1 : 0);
        Unit unit = Unit.INSTANCE;
        this.mInGameAnim.setImageDrawable(iVasApngFactory.getDynamicDrawable(str, apngOptions));
    }

    private final void L() {
        String str;
        QLog.i("QMGame.GuildGameTeamCard", 1, "inTeamAnimation");
        this.mInGameAnim.setVisibility(8);
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        if (this.mNeedChangeHeight) {
            str = "https://downv6.qq.com/innovate/guild/media_game/guild_game_top_bg_border_fold.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/media_game/guild_game_top_bg_border.png";
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(GuildMediaUtils.f227771a.n() ? 1 : 0);
        Unit unit = Unit.INSTANCE;
        this.mTeamCardBorder.setImageDrawable(iVasApngFactory.getDynamicDrawable(str, apngOptions));
    }

    private final void M(LifecycleOwner lifeCycle) {
        bt1.h hVar = this.mRoomViewModel;
        if (hVar == null) {
            QLog.d("QMGame.GuildGameTeamCard", 1, "initObservers mRoomViewModel is null");
            return;
        }
        Intrinsics.checkNotNull(hVar);
        MutableLiveData<GuildAuthGameBean> c26 = hVar.c2();
        final Function1<GuildAuthGameBean, Unit> function1 = new Function1<GuildAuthGameBean, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard$initObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildAuthGameBean guildAuthGameBean) {
                invoke2(guildAuthGameBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildAuthGameBean guildAuthGameBean) {
                if (guildAuthGameBean == null) {
                    return;
                }
                int state = guildAuthGameBean.getState();
                if (state != 1) {
                    if (state == 5) {
                        GuildGameTeamCard.this.U();
                        return;
                    } else {
                        QQToast.makeText(GuildGameTeamCard.this.getContext(), guildAuthGameBean.getTipsContent(), 0).show();
                        return;
                    }
                }
                if (Intrinsics.areEqual(bw.P(), "AUTH_PERMANENT")) {
                    bt1.h hVar2 = GuildGameTeamCard.this.mRoomViewModel;
                    if (hVar2 != null) {
                        hVar2.t2();
                        return;
                    }
                    return;
                }
                GuildTeamAuthDialog guildTeamAuthDialog = new GuildTeamAuthDialog(new a(GuildGameTeamCard.this), 1);
                FragmentManager supportFragmentManager = QBaseActivity.sTopActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "sTopActivity.supportFragmentManager");
                com.tencent.mobileqq.guild.base.extension.d.a(guildTeamAuthDialog, supportFragmentManager, "QMGame.GuildGameTeamCard");
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard$initObservers$1$a", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "", "e", "b", "d", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements GuildTeamAuthDialog.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildGameTeamCard f228841a;

                a(GuildGameTeamCard guildGameTeamCard) {
                    this.f228841a = guildGameTeamCard;
                }

                @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
                public void b() {
                    QLog.i("QMGame.GuildGameTeamCard", 1, "onClickPermanentConfirm");
                    bw.w1("AUTH_PERMANENT");
                    bt1.h hVar = this.f228841a.mRoomViewModel;
                    if (hVar != null) {
                        hVar.t2();
                    }
                }

                @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
                public void d() {
                    QLog.i("QMGame.GuildGameTeamCard", 1, "onClickCancel");
                }

                @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
                public void e() {
                    QLog.i("QMGame.GuildGameTeamCard", 1, "onClickOnceConfirm");
                    bt1.h hVar = this.f228841a.mRoomViewModel;
                    if (hVar != null) {
                        hVar.t2();
                    }
                }

                @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
                public void a() {
                }

                @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
                public void c() {
                }
            }
        };
        c26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameTeamCard.N(Function1.this, obj);
            }
        });
        bt1.h hVar2 = this.mRoomViewModel;
        Intrinsics.checkNotNull(hVar2);
        MutableLiveData<Pair<Boolean, String>> k26 = hVar2.k2();
        final Function1<Pair<? extends Boolean, ? extends String>, Unit> function12 = new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard$initObservers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, String> pair) {
                if (pair == null || pair.getFirst().booleanValue()) {
                    return;
                }
                QQToast.makeText(GuildGameTeamCard.this.getContext(), pair.getSecond(), 0).show();
            }
        };
        k26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameTeamCard.O(Function1.this, obj);
            }
        });
        bt1.h hVar3 = this.mRoomViewModel;
        Intrinsics.checkNotNull(hVar3);
        MutableLiveData<Boolean> d26 = hVar3.d2();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard$initObservers$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                View view;
                TextView textView;
                View view2;
                TextView textView2;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    view2 = GuildGameTeamCard.this.mCaptainLayout;
                    view2.setVisibility(0);
                    textView2 = GuildGameTeamCard.this.mGradeName;
                    textView2.setVisibility(8);
                    return;
                }
                view = GuildGameTeamCard.this.mCaptainLayout;
                view.setVisibility(8);
                textView = GuildGameTeamCard.this.mGradeName;
                textView.setVisibility(0);
            }
        };
        d26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameTeamCard.P(Function1.this, obj);
            }
        });
        bt1.h hVar4 = this.mRoomViewModel;
        Intrinsics.checkNotNull(hVar4);
        MutableLiveData<Pair<Boolean, String>> m26 = hVar4.m2();
        final Function1<Pair<? extends Boolean, ? extends String>, Unit> function14 = new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard$initObservers$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Boolean, String> pair) {
                if (pair == null) {
                    return;
                }
                if (!pair.getFirst().booleanValue()) {
                    QQToast.makeText(GuildGameTeamCard.this.getContext(), pair.getSecond(), 0).show();
                }
                GuildGameTeamCard.this.f0("", true);
            }
        };
        m26.observe(lifeCycle, new Observer() { // from class: com.tencent.mobileqq.guild.media.game.widget.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildGameTeamCard.Q(Function1.this, obj);
            }
        });
        lifeCycle.getLifecycle().addObserver(this);
        this.lifecycleOwner = new WeakReference<>(lifeCycle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R() {
        QLog.i("QMGame.GuildGameTeamCard", 1, "joinTeamAnimation");
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadingDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.guild_game_join_team, null));
        apngOptions.setLoop(GuildMediaUtils.f227771a.n() ? 1 : 0);
        a0(true);
        this.mEnterOrJoinGameBtn.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://downv6.qq.com/innovate/guild/media_game/guild_game_join_btn.png", new ApngOptions(), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        ((IGuildClientAuthApi) QRoute.api(IGuildClientAuthApi.class)).openClientAuthorizationDialog(QBaseActivity.sTopActivity, new GuildClientParams().e0(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c())).f(com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c())).l("100001").l0(7).e());
    }

    private final void W() {
        Map mapOf;
        View view = this.mRootView;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        bt1.h hVar = this.mRoomViewModel;
        Intrinsics.checkNotNull(hVar);
        bt1.h hVar2 = this.mRoomViewModel;
        Intrinsics.checkNotNull(hVar2);
        bt1.h hVar3 = this.mRoomViewModel;
        Intrinsics.checkNotNull(hVar3);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_avchannel_gameplay_id", hVar.h2()), TuplesKt.to("sgrp_team_state", Integer.valueOf(hVar2.q2())), TuplesKt.to("sgrp_room_users_number", Integer.valueOf(hVar3.j2())));
        ch.T0(view, "em_sgrp_honorofkings_game", clickPolicy, exposurePolicy, mapOf);
        ch.X0(this.mQuitTeamBtn, "em_sgrp_honorofkings_game_quit_btn", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.r
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map X;
                X = GuildGameTeamCard.X(GuildGameTeamCard.this, str);
                return X;
            }
        });
        ch.X0(this.mCloseBtn, "em_sgrp_honorofkings_game_close_btn", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.s
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Y;
                Y = GuildGameTeamCard.Y(GuildGameTeamCard.this, str);
                return Y;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map X(GuildGameTeamCard this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Y(GuildGameTeamCard this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.A();
    }

    private final void Z(boolean isEnd) {
        if (this.sceneType == 1) {
            return;
        }
        VideoReport.setElementId(this.mRoomState, "em_sgrp_honorofkings_game_ongoing");
        if (isEnd) {
            VideoReport.reportEvent("imp_end", this.mRoomState, null);
            this.mIsReport = false;
        } else if (!isEnd) {
            this.mIsReport = true;
            VideoReport.reportEvent("imp", this.mRoomState, A());
        }
    }

    private final void a0(boolean isJoin) {
        String str;
        if (this.sceneType == 1) {
            return;
        }
        Button button = this.mEnterOrJoinGameBtn;
        if (isJoin) {
            str = "em_sgrp_honorofkings_game_join_btn";
        } else {
            str = "em_sgrp_honorofkings_game_entry_btn";
        }
        ch.X0(button, str, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.j
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str2) {
                Map b06;
                b06 = GuildGameTeamCard.b0(GuildGameTeamCard.this, str2);
                return b06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map b0(GuildGameTeamCard this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.A();
    }

    private final void c0() {
        String c16 = com.tencent.mobileqq.guild.media.core.m.c(com.tencent.mobileqq.guild.media.core.j.c());
        if (StringUtil.isEmpty(c16)) {
            c16 = this.mBgUrl;
        }
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(c16), new c());
    }

    private final void e0() {
        IGProVoiceSmobaGameRoomStateInfo roomInfo = B().n().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo);
        ArrayList<String> gradeNames = roomInfo.getGameInfo().getGradeNames();
        if (gradeNames.size() == 0) {
            this.mGradeName.setText(getResources().getString(R.string.f170902ma));
        } else if (gradeNames.size() == 2) {
            TextView textView = this.mGradeName;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f13830097, gradeNames.get(0), gradeNames.get(1));
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   \u2026List[1]\n                )");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
        this.mGradeNameCaptain.setText(this.mGradeName.getText());
        TextView textView2 = this.mGameMode;
        IGProVoiceSmobaGameRoomStateInfo roomInfo2 = B().n().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo2);
        textView2.setText(roomInfo2.getGameInfo().getGameMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(String selfId, boolean isQuit) {
        boolean contains;
        if (isQuit) {
            contains = false;
        } else {
            contains = B().n().b().contains(Long.valueOf(NumberUtil.stringToLong(selfId)));
        }
        this.mInTeam = contains;
        QLog.i("QMGame.GuildGameTeamCard", 1, "isCaptain: " + this.mIsCaptain + " mInTeam: " + contains + " mGameStarted: " + this.mGameStarted);
        boolean z16 = this.mGameStarted;
        int i3 = 8;
        if (z16) {
            this.mQuitTeamBtn.setVisibility(8);
            Button button = this.mEnterOrJoinGameBtn;
            if (this.mInTeam) {
                i3 = 0;
            }
            button.setVisibility(i3);
            this.mEnterOrJoinGameBtn.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.guild_game_enter_game, null));
            a0(false);
            K();
            return;
        }
        if (!z16) {
            if (this.mInTeam) {
                this.mQuitTeamBtn.setVisibility(0);
                this.mEnterOrJoinGameBtn.setVisibility(0);
                z();
            } else {
                this.mQuitTeamBtn.setVisibility(8);
                this.mEnterOrJoinGameBtn.setVisibility(0);
                R();
            }
        }
    }

    static /* synthetic */ void g0(GuildGameTeamCard guildGameTeamCard, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildGameTeamCard.f0(str, z16);
    }

    private final void i0() {
        long currentNum;
        boolean z16;
        IGProVoiceSmobaGameRoomStateInfo roomInfo = B().n().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo);
        this.mMaxMember = roomInfo.getGameInfo().getMaxNum();
        if (B().n().getNewCurMember() != 0) {
            currentNum = B().n().getNewCurMember();
        } else {
            IGProVoiceSmobaGameRoomStateInfo roomInfo2 = B().n().getRoomInfo();
            Intrinsics.checkNotNull(roomInfo2);
            currentNum = roomInfo2.getCurrentNum();
        }
        this.mCurMember = currentNum;
        IGProVoiceSmobaGameRoomStateInfo roomInfo3 = B().n().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo3);
        if (roomInfo3.getRoomState() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mGameStarted = z16;
        if (!z16) {
            TextView textView = this.mRoomState;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f159911tl, Long.valueOf(this.mCurMember), Long.valueOf(this.mMaxMember));
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026, mCurMember, mMaxMember)");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            if (this.mIsReport) {
                Z(true);
            }
            y();
        }
        IGProVoiceSmobaGameRoomStateInfo roomInfo4 = B().n().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo4);
        long gameStartTime = roomInfo4.getGameStartTime();
        this.mGameStartTime = gameStartTime;
        if (gameStartTime == 0 && this.mGameStarted) {
            TextView textView2 = this.mRoomState;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getResources().getString(R.string.f1376007a, 1);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.game_started, 1)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView2.setText(format2);
            return;
        }
        if (this.mGameStarted) {
            Z(false);
            if (this.mTimer != null) {
                return;
            }
            QLog.i("QMGame.GuildGameTeamCard", 1, "mTimer start gamestart");
            BaseTimer baseTimer = new BaseTimer();
            this.mTimer = baseTimer;
            baseTimer.schedule(new GuildGameTeamCard$updateTime$1(this), 0L, 30000L);
        }
    }

    private final void u() {
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        if (QQGuildUIUtil.A(getContext())) {
            i3 = (int) (i3 * com.tencent.mobileqq.pad.e.g());
        }
        ViewGroup.LayoutParams layoutParams = this.mRootLayout.getLayoutParams();
        QLog.i("QMGame.GuildGameTeamCard", 1, "height: " + layoutParams.height);
        if (i3 >= 1500) {
            QLog.i("QMGame.GuildGameTeamCard", 1, "change size");
            this.mNeedChangeHeight = true;
            layoutParams.height = (i3 - 60) / 3;
            this.mBgUrl = "https://downv6.qq.com/innovate/guild/media_game/background_fold.png";
        } else {
            this.mBgUrl = "https://downv6.qq.com/innovate/guild/media_game/background.png";
            layoutParams.height = ViewUtils.dpToPx(187.0f);
        }
        this.mRootLayout.setLayoutParams(layoutParams);
    }

    private final void v() {
        String str;
        QLog.i("QMGame.GuildGameTeamCard", 1, "addOneAnimation");
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        if (this.mNeedChangeHeight) {
            str = "https://downv6.qq.com/innovate/guild/media_game/guild_game_add_one_fold.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/media_game/guild_game_add_one.png";
        }
        this.mTeamCardAddOne.setImageDrawable(iVasApngFactory.getDynamicDrawable(str, apngOptions));
    }

    private final void w() {
        QLog.i("QMGame.GuildGameTeamCard", 1, "arrowAnimation");
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(GuildMediaUtils.f227771a.n() ? 1 : 0);
        Unit unit = Unit.INSTANCE;
        this.mArrowAnim.setImageDrawable(iVasApngFactory.getDynamicDrawable("https://downv6.qq.com/innovate/guild/media_game/guild_game_small_arrow.png", apngOptions, ""));
    }

    private final void z() {
        QLog.i("QMGame.GuildGameTeamCard", 1, "enterGameAnimation");
        ApngOptions apngOptions = new ApngOptions();
        GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
        apngOptions.setLoop(guildMediaUtils.n() ? 1 : 0);
        apngOptions.setLoadingDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.guild_game_enter_game, null));
        apngOptions.setLoop(guildMediaUtils.n() ? 1 : 0);
        a0(false);
        this.mEnterOrJoinGameBtn.setBackground(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://downv6.qq.com/innovate/guild/media_game/guild_game_enter_anim.png", apngOptions, ""));
    }

    public final void S(@NotNull bt1.h vm5, @NotNull LifecycleOwner lifeCycle) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        this.mRoomViewModel = vm5;
        com.tencent.mobileqq.guild.u.q("https://downv6.qq.com/innovate/guild/avatar_icon/guild_live_wz_icon.png", this.mAppIcon, true);
        ys1.c.e(this.mTeamCardBg);
        this.mCloseBtn.setOnClickListener(this);
        this.mEnterOrJoinGameBtn.setOnClickListener(this);
        this.mQuitTeamBtn.setOnClickListener(this);
        L();
        w();
        u();
        c0();
        M(lifeCycle);
        W();
    }

    public final void T(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.d("QMGame.GuildGameTeamCard", 1, "onViewConfigurationChanged " + newConfig.orientation);
        u();
        c0();
    }

    public final void d0(@NotNull String selfId) {
        String valueOf;
        String str;
        eu euVar;
        Intrinsics.checkNotNullParameter(selfId, "selfId");
        if (B().n().getNewCaptainId() == 0) {
            IGProVoiceSmobaGameRoomStateInfo roomInfo = B().n().getRoomInfo();
            Intrinsics.checkNotNull(roomInfo);
            valueOf = String.valueOf(roomInfo.getCaptainTinyId());
        } else {
            valueOf = String.valueOf(B().n().getNewCaptainId());
        }
        this.mIsCaptain = Intrinsics.areEqual(valueOf, selfId);
        String H = ch.H(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.guild.media.core.m.d(B()), valueOf);
        Intrinsics.checkNotNullExpressionValue(H, "getDisplayName(\n        \u2026  captainID\n            )");
        this.mCaptainName = H;
        this.mTeamName.setText(H);
        this.mCaptainAvatar.setAvatarTinyId(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()), valueOf);
        com.tencent.mobileqq.guild.media.core.data.p g16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().g(valueOf);
        if (g16 != null && (euVar = g16.L) != null) {
            str = euVar.getUrl();
        } else {
            str = null;
        }
        if (!StringUtil.isEmpty(str)) {
            com.tencent.mobileqq.guild.u.p(str, this.mUserMedal);
            this.mUserMedal.setVisibility(0);
        } else {
            this.mUserMedal.setVisibility(8);
        }
    }

    public final void j0() {
        String selfId = B().getSelfUserInfo().f228093a;
        QLog.i("QMGame.GuildGameTeamCard", 1, "updateUI, selfID: " + selfId);
        Intrinsics.checkNotNullExpressionValue(selfId, "selfId");
        d0(selfId);
        e0();
        i0();
        g0(this, selfId, false, 2, null);
        if (B().n().getUserActionType() == 10) {
            v();
            B().n().k(0);
        }
        if (this.sceneType == 1) {
            this.mCloseBtn.setVisibility(8);
            this.mBtnLayout.setVisibility(8);
            this.mCaptainLayout.setVisibility(8);
            this.mEnterOrJoinGameBtn.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.mobileqq.guild.util.o.d("QMGame.GuildGameTeamCard", 1000L)) {
            int id5 = v3.getId();
            if (id5 == R.id.wgl) {
                if (this.mInTeam) {
                    F();
                } else {
                    G();
                }
            } else if (id5 == R.id.wgi) {
                H();
            } else if (id5 == R.id.wgk) {
                C();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void onDestroy() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        y();
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        if (weakReference != null && (lifecycleOwner = weakReference.get()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        APNGDrawable aPNGDrawable;
        APNGDrawable aPNGDrawable2;
        Drawable background = this.mEnterOrJoinGameBtn.getBackground();
        APNGDrawable aPNGDrawable3 = null;
        if (background instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) background;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.pauseApng();
        }
        Drawable drawable = this.mArrowAnim.getDrawable();
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable2 = (APNGDrawable) drawable;
        } else {
            aPNGDrawable2 = null;
        }
        if (aPNGDrawable2 != null) {
            aPNGDrawable2.pauseApng();
        }
        Drawable drawable2 = this.mInGameAnim.getDrawable();
        if (drawable2 instanceof APNGDrawable) {
            aPNGDrawable3 = (APNGDrawable) drawable2;
        }
        if (aPNGDrawable3 != null) {
            aPNGDrawable3.pauseApng();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        APNGDrawable aPNGDrawable;
        APNGDrawable aPNGDrawable2;
        Drawable background = this.mEnterOrJoinGameBtn.getBackground();
        APNGDrawable aPNGDrawable3 = null;
        if (background instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) background;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.resumeApng();
        }
        Drawable drawable = this.mArrowAnim.getDrawable();
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable2 = (APNGDrawable) drawable;
        } else {
            aPNGDrawable2 = null;
        }
        if (aPNGDrawable2 != null) {
            aPNGDrawable2.resumeApng();
        }
        Drawable drawable2 = this.mInGameAnim.getDrawable();
        if (drawable2 instanceof APNGDrawable) {
            aPNGDrawable3 = (APNGDrawable) drawable2;
        }
        if (aPNGDrawable3 != null) {
            aPNGDrawable3.resumeApng();
        }
    }

    public final void x() {
        this.sceneType = 1;
    }

    public final void y() {
        QLog.i("QMGame.GuildGameTeamCard", 1, "mTimer cancel");
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
    }

    public /* synthetic */ GuildGameTeamCard(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGameTeamCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.esr, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ild_game_team_card, this)");
        this.mRootView = inflate;
        View findViewById = findViewById(R.id.wh9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_game_root_view)");
        this.mRootLayout = findViewById;
        View findViewById2 = findViewById(R.id.wh_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_game_team_captain)");
        this.mCaptainAvatar = (GuildUserAvatarView) findViewById2;
        View findViewById3 = findViewById(R.id.whh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_game_team_name)");
        this.mTeamName = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.whi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_game_team_rank)");
        this.mGradeName = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.whg);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_game_team_mode)");
        this.mGameMode = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.whk);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.guild_game_team_status)");
        this.mRoomState = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.wgh);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.guild_game_btn_layout)");
        this.mBtnLayout = findViewById7;
        View findViewById8 = findViewById(R.id.wgl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.guild_game_confirm_btn)");
        this.mEnterOrJoinGameBtn = (Button) findViewById8;
        View findViewById9 = findViewById(R.id.wgi);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.guild_game_cancel_btn)");
        this.mQuitTeamBtn = (Button) findViewById9;
        View findViewById10 = findViewById(R.id.wgq);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.guild_game_icon)");
        this.mAppIcon = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.wgk);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.guild_game_close_btn)");
        this.mCloseBtn = (ImageView) findViewById11;
        View findViewById12 = findViewById(R.id.wgj);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.guild_game_captain_view)");
        this.mCaptainLayout = findViewById12;
        View findViewById13 = findViewById(R.id.whj);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.guild_game_team_rank_captain)");
        this.mGradeNameCaptain = (TextView) findViewById13;
        View findViewById14 = findViewById(R.id.whd);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.guild_game_team_card_bg)");
        this.mTeamCardBg = (RoundRectImageView) findViewById14;
        View findViewById15 = findViewById(R.id.whe);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.guild_\u2026me_team_card_border_anim)");
        this.mTeamCardBorder = (ImageView) findViewById15;
        View findViewById16 = findViewById(R.id.whf);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.guild_\u2026e_team_card_in_game_anim)");
        this.mInGameAnim = (ImageView) findViewById16;
        View findViewById17 = findViewById(R.id.whb);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(R.id.guild_\u2026e_team_card_add_one_anim)");
        this.mTeamCardAddOne = (RoundRectImageView) findViewById17;
        View findViewById18 = findViewById(R.id.whc);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.guild_game_team_card_arrow_anim)");
        this.mArrowAnim = (ImageView) findViewById18;
        View findViewById19 = findViewById(R.id.whl);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(R.id.guild_game_user_medal)");
        this.mUserMedal = (ImageView) findViewById19;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.media.core.l>() { // from class: com.tencent.mobileqq.guild.media.game.widget.GuildGameTeamCard$mDataHub$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.media.core.l invoke() {
                return com.tencent.mobileqq.guild.media.core.j.c();
            }
        });
        this.mDataHub = lazy;
        this.mCaptainName = "";
        this.mBgUrl = "https://downv6.qq.com/innovate/guild/media_game/background.png";
        this.sceneType = -1;
    }
}
