package com.tencent.mobileqq.guild.home.schedule.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.home.helper.g;
import com.tencent.mobileqq.guild.home.helper.i;
import com.tencent.mobileqq.guild.home.schedule.view.GuildScheduleCardView;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleUser;
import com.tencent.mobileqq.qqguildsdk.data.genc.di;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEditScheduleReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProModifyScheduleInviteReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.Cdo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 m2\u00020\u0001:\u0002noB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\bd\u0010eB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u00a2\u0006\u0004\bd\u0010hB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\u0006\u0010i\u001a\u00020\u0002\u00a2\u0006\u0004\bd\u0010jB+\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\u0006\u0010i\u001a\u00020\u0002\u0012\u0006\u0010k\u001a\u00020\u0002\u00a2\u0006\u0004\bd\u0010lJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\f\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002J\f\u0010\u0010\u001a\u00020\u000e*\u00020\rH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0014\u0010\"\u001a\u00020\u0004*\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u001c\u0010&\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$0#H\u0002J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'J4\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\r2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$0#J\b\u0010.\u001a\u00020\u0004H\u0014J\b\u0010/\u001a\u00020\u0004H\u0014R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00102R\u0016\u0010;\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u00105R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010=R\u0016\u0010?\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u00105R\u0016\u0010@\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010=R\u0016\u0010B\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u0016\u0010D\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u00105R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010NR\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010^\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView;", "Landroid/widget/FrameLayout;", "", "scene", "", "B", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "y", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;", "", "p", "t", "", "startTimeMs", "endTimeMs", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$b;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "v", "u", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "k", "Lcom/tencent/mobileqq/guild/home/helper/i;", "l", "Landroid/widget/TextView;", "isExpire", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/HashMap;", "", "extraReportParams", HippyTKDListViewAdapter.X, "Landroid/view/View$OnClickListener;", "onClickCallback", "setOnClickCallback", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", GameCenterUtil.CONF_KEY_SCHEDULE_INFO, "i", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "timeIcon", "e", "Landroid/widget/TextView;", "scheduleTime", "f", "scheduleTitle", h.F, "channelIcon", "channelName", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "selfAvatar", "selfSubscribeText", "subscribeAvatar1", "E", "subscribeAvatar2", UserInfo.SEX_FEMALE, "subscribeUserText", "Landroid/view/View;", "G", "Landroid/view/View;", "contentLeading", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "H", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "addressContainer", "J", "subscribeContainer", "Landroid/widget/RelativeLayout;", "K", "Landroid/widget/RelativeLayout;", "cardView", "L", "M", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "N", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;", "P", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/home/helper/i;", "switchChangeListener", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View$OnClickListener;", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildScheduleCardView extends FrameLayout {

    /* renamed from: S */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    private TextView selfSubscribeText;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildUserAvatarView subscribeAvatar1;

    /* renamed from: E, reason: from kotlin metadata */
    private GuildUserAvatarView subscribeAvatar2;

    /* renamed from: F */
    private TextView subscribeUserText;

    /* renamed from: G, reason: from kotlin metadata */
    private View contentLeading;

    /* renamed from: H, reason: from kotlin metadata */
    private QUIButton button;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout addressContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout subscribeContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private RelativeLayout cardView;

    /* renamed from: L, reason: from kotlin metadata */
    private int scene;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private JumpGuildParam jumpGuildParam;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private GuildScheduleInfo com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsObserver;

    /* renamed from: Q */
    @NotNull
    private final i switchChangeListener;

    /* renamed from: R */
    @Nullable
    private View.OnClickListener onClickCallback;

    /* renamed from: d, reason: from kotlin metadata */
    private ImageView timeIcon;

    /* renamed from: e, reason: from kotlin metadata */
    private TextView scheduleTime;

    /* renamed from: f, reason: from kotlin metadata */
    private TextView scheduleTitle;

    /* renamed from: h */
    private ImageView channelIcon;

    /* renamed from: i, reason: from kotlin metadata */
    private TextView channelName;

    /* renamed from: m */
    private GuildUserAvatarView selfAvatar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$a;", "", "", "FEED_LIST_SCENE", "I", "HOME_DIALOG_SCENE", "SCHEDULE_LIST_SCENE", "", "TAG", "Ljava/lang/String;", "UNKNOWN_SCENE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.view.GuildScheduleCardView$a */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB7\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$b;", "", "other", "", h.F, "", "toString", "", "hashCode", "equals", "a", "I", "g", "()I", "year", "b", "e", "month", "c", "day", "d", "f", "weekDay", WidgetCacheWeatherData.HOUR, "minute", "<init>", "(IIIIII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.view.GuildScheduleCardView$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class DateDetails {

        /* renamed from: g, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: h */
        @NotNull
        private static final List<String> f225254h;

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int year;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int month;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final int day;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final int weekDay;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private final int hour;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private final int minute;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$b$a;", "", "", "timestamp", "Lcom/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$b;", "b", "", "", "WEEK_DAY", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.view.GuildScheduleCardView$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final List<String> a() {
                return DateDetails.f225254h;
            }

            @NotNull
            public final DateDetails b(long timestamp) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
                calendar.setTimeInMillis(timestamp);
                return new DateDetails(calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(11), calendar.get(12));
            }

            Companion() {
            }
        }

        static {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u65e5", "\u4e00", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d"});
            f225254h = listOf;
        }

        public DateDetails(int i3, int i16, int i17, int i18, int i19, int i26) {
            this.year = i3;
            this.month = i16;
            this.day = i17;
            this.weekDay = i18;
            this.hour = i19;
            this.minute = i26;
        }

        /* renamed from: b, reason: from getter */
        public final int getDay() {
            return this.day;
        }

        /* renamed from: c, reason: from getter */
        public final int getHour() {
            return this.hour;
        }

        /* renamed from: d, reason: from getter */
        public final int getMinute() {
            return this.minute;
        }

        /* renamed from: e, reason: from getter */
        public final int getMonth() {
            return this.month;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DateDetails)) {
                return false;
            }
            DateDetails dateDetails = (DateDetails) other;
            if (this.year == dateDetails.year && this.month == dateDetails.month && this.day == dateDetails.day && this.weekDay == dateDetails.weekDay && this.hour == dateDetails.hour && this.minute == dateDetails.minute) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getWeekDay() {
            return this.weekDay;
        }

        /* renamed from: g, reason: from getter */
        public final int getYear() {
            return this.year;
        }

        public final boolean h(@NotNull DateDetails other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (this.year == other.year && this.month == other.month && this.day == other.day) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.year * 31) + this.month) * 31) + this.day) * 31) + this.weekDay) * 31) + this.hour) * 31) + this.minute;
        }

        @NotNull
        public String toString() {
            return "DateDetails(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", weekDay=" + this.weekDay + ", hour=" + this.hour + ", minute=" + this.minute + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J$\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProEditScheduleReq;", "scheduleReq", "", "onEditScheduleNew", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProModifyScheduleInviteReq;", "req", "onModifyScheduleInviteStatusNew", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        public static final void e(GuildScheduleCardView this$0, c this$1, int i3, String str, GuildScheduleInfo guildScheduleInfo, int i16, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!this$0.isAttachedToWindow()) {
                return;
            }
            if (i3 == 0 && guildScheduleInfo != null) {
                GuildScheduleCardView.j(this$0, this$0.scene, this$0.jumpGuildParam, guildScheduleInfo, null, 8, null);
                return;
            }
            Logger.f235387a.d().w("Guild.sch.GuildScheduleCardView", 1, "getScheduleDetail " + System.identityHashCode(this$1) + " " + i3 + " " + str);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onEditScheduleNew(int result, @Nullable String errMsg, @Nullable GProEditScheduleReq scheduleReq) {
            GProScheduleInfo gProScheduleInfo;
            if (GuildScheduleCardView.this.isAttachedToWindow() && result == 0) {
                boolean z16 = false;
                if (scheduleReq != null && (gProScheduleInfo = scheduleReq.scheduleInfo) != null && gProScheduleInfo.scheduleId == GuildScheduleCardView.this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId()) {
                    z16 = true;
                }
                if (z16 && scheduleReq.editType == 2) {
                    GuildScheduleInfo schedule = ((IGPSService) ch.R0(IGPSService.class)).convert2GuildScheduleInfo(scheduleReq.scheduleInfo);
                    GuildScheduleCardView guildScheduleCardView = GuildScheduleCardView.this;
                    int i3 = guildScheduleCardView.scene;
                    JumpGuildParam jumpGuildParam = GuildScheduleCardView.this.jumpGuildParam;
                    Intrinsics.checkNotNullExpressionValue(schedule, "schedule");
                    GuildScheduleCardView.j(guildScheduleCardView, i3, jumpGuildParam, schedule, null, 8, null);
                    Logger.f235387a.d().d("Guild.sch.GuildScheduleCardView", 1, "onEditScheduleNew " + System.identityHashCode(this) + " " + schedule);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onModifyScheduleInviteStatusNew(int result, @Nullable String errMsg, @Nullable GProModifyScheduleInviteReq req) {
            super.onModifyScheduleInviteStatusNew(result, errMsg, req);
            if (GuildScheduleCardView.this.isAttachedToWindow() && result == 0) {
                boolean z16 = false;
                if (req != null && req.scheduleId == GuildScheduleCardView.this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId()) {
                    z16 = true;
                }
                if (z16) {
                    IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                    String valueOf = String.valueOf(req.guildId);
                    String valueOf2 = String.valueOf(req.channelId);
                    String valueOf3 = String.valueOf(req.scheduleId);
                    final GuildScheduleCardView guildScheduleCardView = GuildScheduleCardView.this;
                    iGPSService.getScheduleDetail(valueOf, valueOf2, valueOf3, new vh2.ch() { // from class: zo1.e
                        @Override // vh2.ch
                        public final void a(int i3, String str, GuildScheduleInfo guildScheduleInfo, int i16, boolean z17) {
                            GuildScheduleCardView.c.e(GuildScheduleCardView.this, this, i3, str, guildScheduleInfo, i16, z17);
                        }
                    });
                    Logger.f235387a.d().d("Guild.sch.GuildScheduleCardView", 1, "onModifyScheduleInviteStatusNew " + System.identityHashCode(this) + " " + req.scheduleId + " " + req.inviteStatus);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/view/GuildScheduleCardView$d", "Lcom/tencent/mobileqq/guild/home/helper/i;", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements i {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.home.helper.i
        public void a(boolean r16) {
            if (GuildScheduleCardView.this.isAttachedToWindow()) {
                GuildScheduleCardView.this.y();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildScheduleCardView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(TextView textView, boolean z16) {
        if (z16) {
            s.b(textView, R.color.qui_common_text_secondary_light);
            textView.setTypeface(Typeface.DEFAULT);
        } else {
            s.b(textView, R.color.qui_common_text_primary);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    private final void B(int scene) {
        this.scene = scene;
        RelativeLayout relativeLayout = null;
        if (scene == 0) {
            RelativeLayout relativeLayout2 = this.cardView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
                relativeLayout2 = null;
            }
            relativeLayout2.setBackground(null);
            RelativeLayout relativeLayout3 = this.cardView;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
                relativeLayout3 = null;
            }
            relativeLayout3.setPadding((int) cw.b(16), (int) cw.b(8), (int) cw.b(16), 0);
            if (!p(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
                return;
            }
            View findViewById = findViewById(R.id.amr);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(6, R.id.f80094aj);
            layoutParams2.addRule(8, R.id.f904252f);
            layoutParams2.addRule(11, -1);
            layoutParams2.width = -2;
            layoutParams2.topMargin = (int) cw.b(0);
            findViewById.setLayoutParams(layoutParams2);
            QUIButton qUIButton = this.button;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton = null;
            }
            QUIButton qUIButton2 = this.button;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton2 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = qUIButton2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.width = -2;
            qUIButton.setLayoutParams(layoutParams4);
            TextView textView = this.scheduleTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleTitle");
                textView = null;
            }
            TextView textView2 = this.scheduleTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleTitle");
                textView2 = null;
            }
            ViewGroup.LayoutParams layoutParams5 = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.addRule(0, R.id.amr);
            layoutParams6.setMarginEnd((int) cw.b(12));
            textView.setLayoutParams(layoutParams6);
            LinearLayout linearLayout = this.addressContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressContainer");
                linearLayout = null;
            }
            LinearLayout linearLayout2 = this.addressContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addressContainer");
                linearLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams7 = linearLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
            layoutParams8.addRule(16, R.id.amr);
            linearLayout.setLayoutParams(layoutParams8);
            LinearLayout linearLayout3 = this.subscribeContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeContainer");
                linearLayout3 = null;
            }
            LinearLayout linearLayout4 = this.subscribeContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeContainer");
                linearLayout4 = null;
            }
            ViewGroup.LayoutParams layoutParams9 = linearLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
            layoutParams10.addRule(0, R.id.amr);
            linearLayout3.setLayoutParams(layoutParams10);
        }
        if (2 == scene) {
            RelativeLayout relativeLayout4 = this.cardView;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
                relativeLayout4 = null;
            }
            relativeLayout4.setBackgroundResource(R.drawable.guild_fill_light_primary_corners_8);
        }
        if (scene == 1) {
            View buttonContainer = findViewById(R.id.amr);
            Intrinsics.checkNotNullExpressionValue(buttonContainer, "buttonContainer");
            buttonContainer.setVisibility(8);
            RelativeLayout relativeLayout5 = this.cardView;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
                relativeLayout5 = null;
            }
            relativeLayout5.setPadding((int) cw.b(12), (int) cw.b(16), (int) cw.b(12), (int) cw.b(24));
            RelativeLayout relativeLayout6 = this.cardView;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
            } else {
                relativeLayout = relativeLayout6;
            }
            relativeLayout.setBackgroundResource(R.drawable.guild_home_feed_schedule_bg);
        }
    }

    private final void C() {
        Object orNull;
        Object orNull2;
        GuildUserAvatarView guildUserAvatarView = null;
        TextView textView = null;
        GuildUserAvatarView guildUserAvatarView2 = null;
        if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getInviteStatus() == 1) {
            GuildUserAvatarView guildUserAvatarView3 = this.selfAvatar;
            if (guildUserAvatarView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selfAvatar");
                guildUserAvatarView3 = null;
            }
            guildUserAvatarView3.setAvatarTinyId(this.jumpGuildParam.guildId, ch.f());
            GuildUserAvatarView guildUserAvatarView4 = this.selfAvatar;
            if (guildUserAvatarView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selfAvatar");
                guildUserAvatarView4 = null;
            }
            guildUserAvatarView4.setVisibility(0);
            TextView textView2 = this.selfSubscribeText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selfSubscribeText");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            GuildUserAvatarView guildUserAvatarView5 = this.selfAvatar;
            if (guildUserAvatarView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selfAvatar");
                guildUserAvatarView5 = null;
            }
            guildUserAvatarView5.setVisibility(8);
            TextView textView3 = this.selfSubscribeText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selfSubscribeText");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        TextView textView4 = this.selfSubscribeText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfSubscribeText");
            textView4 = null;
        }
        textView4.setTypeface(Typeface.DEFAULT_BOLD);
        if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getAcceptedNums() == 0) {
            GuildUserAvatarView guildUserAvatarView6 = this.subscribeAvatar1;
            if (guildUserAvatarView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar1");
                guildUserAvatarView6 = null;
            }
            guildUserAvatarView6.setVisibility(8);
            GuildUserAvatarView guildUserAvatarView7 = this.subscribeAvatar2;
            if (guildUserAvatarView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar2");
                guildUserAvatarView7 = null;
            }
            guildUserAvatarView7.setVisibility(8);
            TextView textView5 = this.subscribeUserText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeUserText");
                textView5 = null;
            }
            textView5.setVisibility(8);
            TextView textView6 = this.selfSubscribeText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selfSubscribeText");
            } else {
                textView = textView6;
            }
            textView.setText("\u6211\u5df2\u9884\u7ea6");
            return;
        }
        TextView textView7 = this.selfSubscribeText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfSubscribeText");
            textView7 = null;
        }
        textView7.setText("\u6211\u5df2\u9884\u7ea6 \u2022 ");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getAcceptedNums()));
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 17);
        if (t(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            spannableStringBuilder.append((CharSequence) "\u4eba\u53c2\u52a0");
        } else {
            spannableStringBuilder.append((CharSequence) "\u4eba\u9884\u7ea6");
        }
        TextView textView8 = this.subscribeUserText;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscribeUserText");
            textView8 = null;
        }
        textView8.setText(spannableStringBuilder);
        TextView textView9 = this.subscribeUserText;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscribeUserText");
            textView9 = null;
        }
        textView9.setVisibility(0);
        ArrayList<GuildScheduleUser> acceptedUser = this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getAcceptedUser();
        Intrinsics.checkNotNullExpressionValue(acceptedUser, "scheduleInfo.acceptedUser");
        ArrayList arrayList = new ArrayList();
        for (Object obj : acceptedUser) {
            if (!Intrinsics.areEqual(String.valueOf(((GuildScheduleUser) obj).getTinyId()), ch.f())) {
                arrayList.add(obj);
            }
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
        GuildScheduleUser guildScheduleUser = (GuildScheduleUser) orNull;
        if (guildScheduleUser == null) {
            GuildUserAvatarView guildUserAvatarView8 = this.subscribeAvatar1;
            if (guildUserAvatarView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar1");
                guildUserAvatarView8 = null;
            }
            guildUserAvatarView8.setVisibility(8);
        } else {
            GuildUserAvatarView guildUserAvatarView9 = this.subscribeAvatar1;
            if (guildUserAvatarView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar1");
                guildUserAvatarView9 = null;
            }
            guildUserAvatarView9.setVisibility(0);
            GuildUserAvatarView guildUserAvatarView10 = this.subscribeAvatar1;
            if (guildUserAvatarView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar1");
                guildUserAvatarView10 = null;
            }
            guildUserAvatarView10.setAvatarTinyId(this.jumpGuildParam.guildId, String.valueOf(guildScheduleUser.getTinyId()));
        }
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList, 1);
        GuildScheduleUser guildScheduleUser2 = (GuildScheduleUser) orNull2;
        if (guildScheduleUser2 == null) {
            GuildUserAvatarView guildUserAvatarView11 = this.subscribeAvatar2;
            if (guildUserAvatarView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar2");
            } else {
                guildUserAvatarView2 = guildUserAvatarView11;
            }
            guildUserAvatarView2.setVisibility(8);
            return;
        }
        GuildUserAvatarView guildUserAvatarView12 = this.subscribeAvatar2;
        if (guildUserAvatarView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar2");
            guildUserAvatarView12 = null;
        }
        guildUserAvatarView12.setVisibility(0);
        GuildUserAvatarView guildUserAvatarView13 = this.subscribeAvatar2;
        if (guildUserAvatarView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscribeAvatar2");
        } else {
            guildUserAvatarView = guildUserAvatarView13;
        }
        guildUserAvatarView.setAvatarTinyId(this.jumpGuildParam.guildId, String.valueOf(guildScheduleUser2.getTinyId()));
    }

    private final void D() {
        final String n3;
        boolean z16;
        if (this.scene == 0) {
            n3 = ty1.c.b(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getStartTimeMs(), this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getEndTimeMs(), this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getDateMs());
        } else {
            n3 = n(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getStartTimeMs(), this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getEndTimeMs());
        }
        View view = null;
        if (p(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            post(new Runnable() { // from class: zo1.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildScheduleCardView.E(GuildScheduleCardView.this, n3);
                }
            });
        } else {
            TextView textView = this.scheduleTime;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scheduleTime");
                textView = null;
            }
            textView.setText(n3);
        }
        TextView textView2 = this.scheduleTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleTitle");
            textView2 = null;
        }
        textView2.setText(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getTitle());
        if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getEndTimeMs() < NetConnInfoCenter.getServerTimeMillis()) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView3 = this.scheduleTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleTime");
            textView3 = null;
        }
        A(textView3, z16);
        TextView textView4 = this.scheduleTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleTitle");
            textView4 = null;
        }
        A(textView4, z16);
        if (p(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            ImageView imageView = this.timeIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeIcon");
                imageView = null;
            }
            imageView.setImageResource(R.drawable.guild_blue_dot_8dp);
            View view2 = this.contentLeading;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLeading");
            } else {
                view = view2;
            }
            view.setBackgroundResource(R.drawable.qui_common_brand_standard_bg);
            return;
        }
        if (z16) {
            ImageView imageView2 = this.timeIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeIcon");
                imageView2 = null;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView2.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_schedule_time_icon, Integer.valueOf(R.color.qui_common_text_secondary_light)));
        } else {
            ImageView imageView3 = this.timeIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeIcon");
                imageView3 = null;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            imageView3.setImageDrawable(GuildUIUtils.w(context2, R.drawable.guild_schedule_time_icon, Integer.valueOf(R.color.qui_common_text_primary)));
        }
        View view3 = this.contentLeading;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLeading");
        } else {
            view = view3;
        }
        view.setBackgroundResource(R.drawable.qui_common_fill_standard_second_bg);
    }

    public static final void E(GuildScheduleCardView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.scheduleTime;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleTime");
            textView = null;
        }
        int measuredWidth = textView.getMeasuredWidth();
        String str2 = str + "  \u6d3b\u52a8\u4e2d";
        TextView textView3 = this$0.scheduleTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleTime");
            textView3 = null;
        }
        if (textView3.getPaint().measureText(str2) > measuredWidth) {
            str2 = str + "\n\u6d3b\u52a8\u4e2d";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this$0.getResources().getColor(R.color.qui_common_brand_standard)), spannableStringBuilder.length() - 3, spannableStringBuilder.length(), 17);
        TextView textView4 = this$0.scheduleTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleTime");
        } else {
            textView2 = textView4;
        }
        textView2.setText(spannableStringBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(GuildScheduleCardView guildScheduleCardView, int i3, JumpGuildParam jumpGuildParam, GuildScheduleInfo guildScheduleInfo, HashMap hashMap, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            hashMap = new HashMap();
        }
        guildScheduleCardView.i(i3, jumpGuildParam, guildScheduleInfo, hashMap);
    }

    private final GPServiceObserver k() {
        return new c();
    }

    private final i l() {
        return new d();
    }

    private final String m(DateDetails dateDetails) {
        DateDetails.Companion companion = DateDetails.INSTANCE;
        DateDetails b16 = companion.b(NetConnInfoCenter.getServerTimeMillis());
        if (b16.h(dateDetails)) {
            return "\u4eca\u5929";
        }
        StringBuilder sb5 = new StringBuilder();
        if (b16.getYear() != dateDetails.getYear()) {
            sb5.append(dateDetails.getYear());
            sb5.append("\u5e74");
        }
        sb5.append(dateDetails.getMonth() + 1);
        sb5.append("\u6708");
        sb5.append(dateDetails.getDay());
        sb5.append("\u65e5");
        sb5.append(" \u5468");
        sb5.append(companion.a().get(dateDetails.getWeekDay() - 1));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    private final String n(long j3, long j16) {
        String padStart;
        String padStart2;
        String padStart3;
        String padStart4;
        DateDetails.Companion companion = DateDetails.INSTANCE;
        DateDetails b16 = companion.b(j3);
        DateDetails b17 = companion.b(j16);
        StringBuilder sb5 = new StringBuilder();
        if (b16.h(b17)) {
            sb5.append(m(b16));
            sb5.append(" ");
            sb5.append(b16.getHour());
            sb5.append(":");
            padStart3 = StringsKt__StringsKt.padStart(String.valueOf(b16.getMinute()), 2, '0');
            sb5.append(padStart3);
            sb5.append("-");
            sb5.append(b17.getHour());
            sb5.append(":");
            padStart4 = StringsKt__StringsKt.padStart(String.valueOf(b17.getMinute()), 2, '0');
            sb5.append(padStart4);
        } else {
            sb5.append(m(b16));
            sb5.append(" ");
            sb5.append(b16.getHour());
            sb5.append(":");
            padStart = StringsKt__StringsKt.padStart(String.valueOf(b16.getMinute()), 2, '0');
            sb5.append(padStart);
            sb5.append(" - ");
            sb5.append(m(b17));
            sb5.append(" ");
            sb5.append(b17.getHour());
            sb5.append(":");
            padStart2 = StringsKt__StringsKt.padStart(String.valueOf(b17.getMinute()), 2, '0');
            sb5.append(padStart2);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    private final void o() {
        if (ch.j0(this.jumpGuildParam.guildId)) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(getContext(), this.jumpGuildParam);
            return;
        }
        if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getStartTimeMs() > NetConnInfoCenter.getServerTimeMillis()) {
            if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getInviteStatus() != 1) {
                v();
                return;
            } else {
                u();
                return;
            }
        }
        if (!g.f224866a.f()) {
            u();
            return;
        }
        GuildScheduleInfo guildScheduleInfo = this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String;
        if (guildScheduleInfo.otherJumpAddress.addressType == 1) {
            Context context = getContext();
            GuildShareUrlParam guildShareUrlParam = new GuildShareUrlParam(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.otherJumpAddress.address);
            guildShareUrlParam.a().putInt("businessType", 16);
            GuildJumpUtil.m(context, guildShareUrlParam);
            return;
        }
        if (!GuildMainFrameUtils.q(String.valueOf(guildScheduleInfo.getChannelInfo().getChannelId()))) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getChannelInfo().getGuildId()), String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getChannelInfo().getChannelId()));
            jumpGuildParam.setJoinInfoParam(this.jumpGuildParam.getJoinInfoParam());
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            GuildJumpUtil.n(context2, jumpGuildParam);
            return;
        }
        u();
    }

    private final boolean p(GuildScheduleInfo guildScheduleInfo) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long startTimeMs = guildScheduleInfo.getStartTimeMs();
        if (serverTimeMillis > guildScheduleInfo.getEndTimeMs() || startTimeMs > serverTimeMillis) {
            return false;
        }
        return true;
    }

    private final void q(Context context) {
        View inflate = View.inflate(context, R.layout.f6z, this);
        View findViewById = inflate.findViewById(R.id.f97275jy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.time_icon)");
        this.timeIcon = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f80064ag);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.schedule_time)");
        this.scheduleTime = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f80094aj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.schedule_title)");
        this.scheduleTitle = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.trz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.channel_icon)");
        this.channelIcon = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.ato);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.channel_name)");
        this.channelName = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f82874i2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.self_avatar)");
        this.selfAvatar = (GuildUserAvatarView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f83004ie);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.self_subscribe_text)");
        this.selfSubscribeText = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f904052d);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.subscribe_avatar1)");
        this.subscribeAvatar1 = (GuildUserAvatarView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f904152e);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.subscribe_avatar2)");
        this.subscribeAvatar2 = (GuildUserAvatarView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f905352q);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.subscribe_user_text)");
        this.subscribeUserText = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.u8_);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.content_leading)");
        this.contentLeading = findViewById11;
        View findViewById12 = inflate.findViewById(R.id.f79824_t);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.id.schedule_button)");
        this.button = (QUIButton) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.f79844_v);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.\u2026.schedule_card_root_view)");
        this.cardView = (RelativeLayout) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.sdv);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.id.address_container)");
        this.addressContainer = (LinearLayout) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.f904252f);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "rootView.findViewById(R.id.subscribe_container)");
        this.subscribeContainer = (LinearLayout) findViewById15;
        setOnClickListener(new View.OnClickListener() { // from class: zo1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildScheduleCardView.s(GuildScheduleCardView.this, view);
            }
        });
        QUIButton qUIButton = this.button;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: zo1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildScheduleCardView.r(GuildScheduleCardView.this, view);
            }
        });
    }

    public static final void r(GuildScheduleCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void s(GuildScheduleCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.u();
            View.OnClickListener onClickListener = this$0.onClickCallback;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean t(GuildScheduleInfo guildScheduleInfo) {
        if (NetConnInfoCenter.getServerTimeMillis() > guildScheduleInfo.getEndTimeMs()) {
            return true;
        }
        return false;
    }

    private final void u() {
        GuildScheduleDetailFragment.bi(getContext(), String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId()), this.jumpGuildParam);
    }

    private final void v() {
        di diVar = new di();
        diVar.j(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId());
        String str = this.jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        diVar.h(MiscKt.l(str));
        String channelId = this.jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        diVar.g(MiscKt.l(channelId));
        diVar.i(1);
        diVar.f(11);
        ((IGPSService) ch.R0(IGPSService.class)).modifyScheduleInviteStatusV2(diVar, new Cdo() { // from class: zo1.c
            @Override // wh2.Cdo
            public final void onModifyInviteStatus(int i3, String str2) {
                GuildScheduleCardView.w(GuildScheduleCardView.this, i3, str2);
            }
        });
    }

    public static final void w(GuildScheduleCardView this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.sch.GuildScheduleCardView", 1, "modifyScheduleInviteStatusV2 result:" + i3 + " errMsg:" + str);
        if (!this$0.isAttachedToWindow()) {
            return;
        }
        if (i3 != 0) {
            SecurityTipHelperKt.F(this$0.getContext(), i3, str, null, "", null, 32, null);
        } else {
            QQToastUtil.showQQToast(2, "\u5df2\u9884\u7ea6\uff0c\u65e5\u7a0b\u5f00\u59cb\u65f6\u5c06\u901a\u77e5\u4f60");
        }
    }

    private final void x(HashMap<String, Object> hashMap) {
        int i3;
        HashMap hashMapOf;
        if (this.scene == 0) {
            VideoReport.setElementId(this, "em_sgrp_event_card");
        } else {
            VideoReport.setElementId(this, "em_sgrp_single_event_card");
        }
        VideoReport.setElementReuseIdentifier(this, String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId()));
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis < this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getStartTimeMs()) {
            i3 = 1;
        } else if (serverTimeMillis < this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getEndTimeMs()) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        Pair[] pairArr = new Pair[4];
        int i16 = 0;
        pairArr[0] = TuplesKt.to("sgrp_sub_channel_id", this.jumpGuildParam.getChannelId());
        pairArr[1] = TuplesKt.to("sgrp_schedular_id", Long.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId()));
        if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getInviteStatus() == 1) {
            i16 = 1;
        }
        pairArr[2] = TuplesKt.to("sgrp_acceptance_status", Integer.valueOf(i16));
        pairArr[3] = TuplesKt.to("sgrp_event_status", Integer.valueOf(i3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        hashMapOf.putAll(hashMap);
        VideoReport.setElementParams(this, hashMapOf);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(this, clickPolicy);
        QUIButton qUIButton = null;
        if (this.scene == 0) {
            QUIButton qUIButton2 = this.button;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton2 = null;
            }
            VideoReport.setElementId(qUIButton2, "em_sgrp_event_card_btn");
        } else {
            QUIButton qUIButton3 = this.button;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton3 = null;
            }
            VideoReport.setElementId(qUIButton3, "em_sgrp_single_event_card_btn");
        }
        QUIButton qUIButton4 = this.button;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton4 = null;
        }
        VideoReport.setElementReuseIdentifier(qUIButton4, String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getScheduleId()));
        HashMap hashMap2 = new HashMap();
        if (p(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            hashMap2.put("sgrp_btn_type", 2);
        } else if (this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getInviteStatus() == 1) {
            hashMap2.put("sgrp_btn_type", 3);
        } else {
            hashMap2.put("sgrp_btn_type", 1);
        }
        QUIButton qUIButton5 = this.button;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton5 = null;
        }
        VideoReport.setElementParams(qUIButton5, hashMap2);
        QUIButton qUIButton6 = this.button;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
        } else {
            qUIButton = qUIButton6;
        }
        VideoReport.setElementClickPolicy(qUIButton, clickPolicy);
    }

    public final void y() {
        int i3;
        TextView textView = null;
        TextView textView2 = null;
        ImageView imageView = null;
        ImageView imageView2 = null;
        if (!g.f224866a.f()) {
            ImageView imageView3 = this.channelIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            TextView textView3 = this.channelName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelName");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(8);
            return;
        }
        ImageView imageView4 = this.channelIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        TextView textView4 = this.channelName;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelName");
            textView4 = null;
        }
        textView4.setVisibility(0);
        ImageView imageView5 = this.channelIcon;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            imageView5 = null;
        }
        imageView5.setImageResource(0);
        TextView textView5 = this.channelName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelName");
            textView5 = null;
        }
        textView5.setText("");
        if (t(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            i3 = R.color.qui_common_text_secondary_light;
        } else {
            i3 = R.color.qui_common_text_secondary;
        }
        TextView textView6 = this.channelName;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelName");
            textView6 = null;
        }
        TextView textView7 = this.channelName;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelName");
            textView7 = null;
        }
        textView6.setTextColor(ContextCompat.getColorStateList(textView7.getContext(), i3));
        if (!GuildMainFrameUtils.q(String.valueOf(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getChannelInfo().getChannelId()))) {
            TextView textView8 = this.channelName;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelName");
                textView8 = null;
            }
            textView8.setText(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getChannelInfo().getChannelName());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            yo1.c cVar = yo1.c.f450725a;
            GuildScheduleChannelInfo channelInfo = this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.getChannelInfo();
            Intrinsics.checkNotNullExpressionValue(channelInfo, "scheduleInfo.channelInfo");
            Drawable w3 = GuildUIUtils.w(context, cVar.c(channelInfo), Integer.valueOf(i3));
            ImageView imageView6 = this.channelIcon;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            } else {
                imageView = imageView6;
            }
            imageView.setImageDrawable(w3);
            return;
        }
        int i16 = this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.otherJumpAddress.addressType;
        if (i16 == 1) {
            TextView textView9 = this.channelName;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelName");
                textView9 = null;
            }
            textView9.setText("\u5e16\u5b50\uff1a" + this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.otherJumpAddress.feedAbstract);
            ImageView imageView7 = this.channelIcon;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            } else {
                imageView2 = imageView7;
            }
            imageView2.setVisibility(8);
            return;
        }
        if (i16 == 2) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Drawable w16 = GuildUIUtils.w(context2, R.drawable.guild_schedule_position, Integer.valueOf(i3));
            ImageView imageView8 = this.channelIcon;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
                imageView8 = null;
            }
            imageView8.setImageDrawable(w16);
            TextView textView10 = this.channelName;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelName");
            } else {
                textView = textView10;
            }
            textView.setText(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String.otherJumpAddress.address);
        }
    }

    private final void z() {
        int i3 = 8;
        QUIButton qUIButton = null;
        if (this.scene == 2) {
            QUIButton qUIButton2 = this.button;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
            } else {
                qUIButton = qUIButton2;
            }
            qUIButton.setVisibility(8);
            return;
        }
        QUIButton qUIButton3 = this.button;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton3 = null;
        }
        if (p(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            i3 = 0;
        }
        qUIButton3.setVisibility(i3);
        if (p(this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String)) {
            QUIButton qUIButton4 = this.button;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton4 = null;
            }
            qUIButton4.setText("\u7acb\u5373\u53c2\u52a0");
            QUIButton qUIButton5 = this.button;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton5 = null;
            }
            qUIButton5.setType(0);
            if (this.scene == 0) {
                QUIButton qUIButton6 = this.button;
                if (qUIButton6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("button");
                    qUIButton6 = null;
                }
                qUIButton6.getLayoutParams().width = -2;
                QUIButton qUIButton7 = this.button;
                if (qUIButton7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("button");
                } else {
                    qUIButton = qUIButton7;
                }
                qUIButton.setPadding((int) cw.b(12), 0, (int) cw.b(12), 0);
            }
        }
    }

    public final void i(int scene, @NotNull JumpGuildParam jumpGuildParam, @NotNull GuildScheduleInfo r46, @NotNull HashMap<String, Object> extraReportParams) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Intrinsics.checkNotNullParameter(r46, "scheduleInfo");
        Intrinsics.checkNotNullParameter(extraReportParams, "extraReportParams");
        this.jumpGuildParam = jumpGuildParam;
        this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String = r46;
        B(scene);
        D();
        y();
        C();
        z();
        x(extraReportParams);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.sch.GuildScheduleCardView", 2, "bindData scheduleInfo:" + r46 + " \n jumpGuildParam:" + jumpGuildParam + " ");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.sch.GuildScheduleCardView", "onAttachedToWindow " + System.identityHashCode(this));
        }
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.gpsObserver);
        g.f224866a.c(this.switchChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.sch.GuildScheduleCardView", "onDetachedFromWindow " + System.identityHashCode(this));
        }
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.gpsObserver);
        g.f224866a.g(this.switchChangeListener);
    }

    public final void setOnClickCallback(@NotNull View.OnClickListener onClickCallback) {
        Intrinsics.checkNotNullParameter(onClickCallback, "onClickCallback");
        this.onClickCallback = onClickCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildScheduleCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildScheduleCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduleCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scene = -1;
        this.jumpGuildParam = new JumpGuildParam("", "");
        this.com.tencent.gamecenter.wadl.util.GameCenterUtil.CONF_KEY_SCHEDULE_INFO java.lang.String = new GuildScheduleInfo();
        this.gpsObserver = k();
        this.switchChangeListener = l();
        q(context);
    }
}
