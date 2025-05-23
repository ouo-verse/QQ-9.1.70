package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection;
import com.tencent.mobileqq.guild.discoveryv2.content.view.GradientImageView;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u0015*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0002\u008d\u0001B\t\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J4\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0016\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J(\u0010$\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0002J \u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010)\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0006H\u0002J \u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\bH\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0002J\b\u00104\u001a\u000203H\u0014J\u0010\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0014J/\u0010:\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u000108H\u0014\u00a2\u0006\u0004\b:\u0010;J\b\u0010<\u001a\u00020\u000bH\u0016J \u0010@\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0016J\b\u0010A\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u000205H\u0016J\u0010\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u000205H\u0016J\u0010\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u000bH\u0016R\"\u0010M\u001a\u0002058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010U\u001a\u00020N8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010\\\u001a\u00020\u001d8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010d\u001a\u00020]8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010l\u001a\u00020e8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010t\u001a\u00020m8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010x\u001a\u0002058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bu\u0010H\u001a\u0004\bv\u0010J\"\u0004\bw\u0010LR\u0018\u0010z\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010WR\u0018\u0010|\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010HR\u0018\u0010}\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010PR\u0018\u0010\u007f\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010PR\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010PR\u0019\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010WR\u0019\u0010\u0082\u0001\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010PR\u0019\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010WR\u0019\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010WR\u0019\u0010\u0085\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010_R\u0018\u0010\u0087\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b`\u0010\u0086\u0001R\u0017\u0010\u008a\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bX\u0010\u0089\u0001\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGuildData;", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "Lcom/tencent/guild/aio/util/ex/c;", "data", "", "position", "", "U", "W", "", "hasDesc", "", "imageUrl", "l0", "guildId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "N", ExifInterface.LATITUDE_SOUTH, "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", HippyControllerProps.ARRAY, "Y", "guildName", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalList", "Landroid/widget/TextView;", "tvName", "J", "fixedGuildName", "Landroid/text/style/ImageSpan;", "iconSpan", "iconWidth", "t0", "text", "imageWidth", "H", "textView", "a0", "Landroid/content/Context;", "context", "joinSig", "b0", "g0", "e0", "j0", "input", "k0", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "payload", "i0", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGuildData;ILjava/util/List;)V", "Z", "label", "isAllSimpleLabel", "isSecondly", "K", "onThemeChanged", "v", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "attached", "onAttachedChanged", "f", "Landroid/view/View;", "getMContainerView", "()Landroid/view/View;", "r0", "(Landroid/view/View;)V", "mContainerView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "O", "()Landroid/widget/ImageView;", "o0", "(Landroid/widget/ImageView;)V", "mAvatar", "i", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "()Landroid/widget/TextView;", "s0", "(Landroid/widget/TextView;)V", "mName", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "q0", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "mButton", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/GradientImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/GradientImageView;", "P", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/view/GradientImageView;", "p0", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/view/GradientImageView;)V", "mBg", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "M", "()Landroid/widget/LinearLayout;", "n0", "(Landroid/widget/LinearLayout;)V", "descContainer", "E", "L", "m0", "baseGuildContent", UserInfo.SEX_FEMALE, "desc", "G", "giftGuildContent", "giftLeftIcon", "I", "giftCenterIcon", "giftRightIcon", "giftNum", "giftGuildAvatar", "giftGuildName", "giftGuildTag", "giftGuildJumpButton", "Ljava/lang/String;", "mGuildId", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mServiceObserver", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class RecommendGuildSection<T extends RecommendGuildData> extends av<T> implements com.tencent.guild.aio.util.ex.c {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int T = QQGuildUIUtil.f(14.0f);
    private static final int U = QQGuildUIUtil.f(20.0f);

    @NotNull
    private static final ColorStateList V;

    @NotNull
    private static final ColorStateList W;

    @NotNull
    private static final ColorStateList X;

    /* renamed from: C, reason: from kotlin metadata */
    protected GradientImageView mBg;

    /* renamed from: D, reason: from kotlin metadata */
    protected LinearLayout descContainer;

    /* renamed from: E, reason: from kotlin metadata */
    protected View baseGuildContent;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView desc;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View giftGuildContent;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView giftLeftIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView giftCenterIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ImageView giftRightIcon;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView giftNum;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView giftGuildAvatar;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView giftGuildName;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView giftGuildTag;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private QUIButton giftGuildJumpButton;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String mGuildId = "";

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mServiceObserver = new b(this);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected View mContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected ImageView mAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected TextView mName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected QUIButton mButton;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildSection$a;", "", "Landroid/content/res/ColorStateList;", "TEXT_COLOR_NICK", "Landroid/content/res/ColorStateList;", "a", "()Landroid/content/res/ColorStateList;", "", "FETCH_GIFT", "Ljava/lang/String;", "GOTO_GUILD", "GOTO_GUILD_FETCH_GIFT", "JOIN_GUILD", "JUMP_TAG", "", "NORMAL_NAME_MARGIN", "I", "NO_DESC_NAME_MARGIN", "TAG", "TEXT_COLOR_BUTTON", "", "strokeWidth", UserInfo.SEX_FEMALE, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorStateList a() {
            return RecommendGuildSection.V;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\bH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildSection$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "onDeleteGuild", "onDestoryGuild", "", "black", "onBeKickFromGuild", "onAddGuildNotInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "sourceType", "onAddGuildWithInfo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecommendGuildSection<T> f217214d;

        b(RecommendGuildSection<T> recommendGuildSection) {
            this.f217214d = recommendGuildSection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(RecommendGuildSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q().setText("\u53bb\u9891\u9053");
            QUIButton qUIButton = this$0.giftGuildJumpButton;
            if (qUIButton != null) {
                qUIButton.setText("\u9886\u53d6\u793c\u5305");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(RecommendGuildSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q().setText("\u53bb\u9891\u9053");
            QUIButton qUIButton = this$0.giftGuildJumpButton;
            if (qUIButton != null) {
                qUIButton.setText("\u9886\u53d6\u793c\u5305");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(RecommendGuildSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q().setText("\u52a0\u5165\u5e76\u9886\u53d6");
            QUIButton qUIButton = this$0.giftGuildJumpButton;
            if (qUIButton != null) {
                qUIButton.setText("\u52a0\u5165\u5e76\u9886\u53d6");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(RecommendGuildSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q().setText("\u52a0\u5165");
            QUIButton qUIButton = this$0.giftGuildJumpButton;
            if (qUIButton != null) {
                qUIButton.setText("\u52a0\u5165\u5e76\u9886\u53d6");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(RecommendGuildSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q().setText("\u52a0\u5165");
            QUIButton qUIButton = this$0.giftGuildJumpButton;
            if (qUIButton != null) {
                qUIButton.setText("\u52a0\u5165\u5e76\u9886\u53d6");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(RecommendGuildSection this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q().setText("\u52a0\u5165");
            QUIButton qUIButton = this$0.giftGuildJumpButton;
            if (qUIButton != null) {
                qUIButton.setText("\u52a0\u5165\u5e76\u9886\u53d6");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAddGuildNotInfo(@Nullable String guildId) {
            QLog.d("RecommendGuildSection", 4, "GPServiceObserver onAddGuildNotInfo guildId=" + guildId);
            if (Intrinsics.areEqual(((RecommendGuildSection) this.f217214d).mGuildId, guildId)) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final RecommendGuildSection<T> recommendGuildSection = this.f217214d;
                rFWThreadManager.postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendGuildSection.b.l(RecommendGuildSection.this);
                    }
                }, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            String str2 = null;
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            QLog.d("RecommendGuildSection", 4, "GPServiceObserver onAddGuildWithInfo guildId=" + str);
            String str3 = ((RecommendGuildSection) this.f217214d).mGuildId;
            if (info != null) {
                str2 = info.getGuildID();
            }
            if (Intrinsics.areEqual(str3, str2)) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final RecommendGuildSection<T> recommendGuildSection = this.f217214d;
                rFWThreadManager.postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ac
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendGuildSection.b.m(RecommendGuildSection.this);
                    }
                }, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            QLog.d("RecommendGuildSection", 4, "GPServiceObserver onDestoryGuild guildId=" + guildId);
            if (Intrinsics.areEqual(((RecommendGuildSection) this.f217214d).mGuildId, guildId)) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final RecommendGuildSection<T> recommendGuildSection = this.f217214d;
                rFWThreadManager.postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendGuildSection.b.n(RecommendGuildSection.this);
                    }
                }, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onDeleteGuild(guildId);
            QLog.d("RecommendGuildSection", 4, "GPServiceObserver onDeleteGuild guildId=" + guildId);
            if (Intrinsics.areEqual(((RecommendGuildSection) this.f217214d).mGuildId, guildId)) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final RecommendGuildSection<T> recommendGuildSection = this.f217214d;
                rFWThreadManager.postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendGuildSection.b.o(RecommendGuildSection.this);
                    }
                }, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onDestoryGuild(guildId);
            QLog.d("RecommendGuildSection", 4, "GPServiceObserver onDestoryGuild guildId=" + guildId);
            if (Intrinsics.areEqual(((RecommendGuildSection) this.f217214d).mGuildId, guildId)) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final RecommendGuildSection<T> recommendGuildSection = this.f217214d;
                rFWThreadManager.postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendGuildSection.b.q(RecommendGuildSection.this);
                    }
                }, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onRemoveGuild(guildId);
            QLog.d("RecommendGuildSection", 4, "GPServiceObserver onRemoveGuild guildId=" + guildId);
            if (Intrinsics.areEqual(((RecommendGuildSection) this.f217214d).mGuildId, guildId)) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final RecommendGuildSection<T> recommendGuildSection = this.f217214d;
                rFWThreadManager.postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecommendGuildSection.b.r(RecommendGuildSection.this);
                    }
                }, 0L);
            }
        }
    }

    static {
        ColorStateList colorStateList = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_common_text_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "sMobileQQ.resources.getC\u2026.qui_common_text_primary)");
        V = colorStateList;
        ColorStateList colorStateList2 = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_common_text_secondary);
        Intrinsics.checkNotNullExpressionValue(colorStateList2, "sMobileQQ.resources.getC\u2026ui_common_text_secondary)");
        W = colorStateList2;
        ColorStateList colorStateList3 = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_button_text_secondary_default);
        Intrinsics.checkNotNullExpressionValue(colorStateList3, "sMobileQQ.resources.getC\u2026n_text_secondary_default)");
        X = colorStateList3;
    }

    private final void H(final String text, final int imageWidth, final TextView tvName) {
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(tvName, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection$adjustGuildNameMultiLine$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean a06;
                TextView textView;
                int i3;
                TextView textView2;
                int i16;
                a06 = this.a0(tvName, text + " ", imageWidth);
                if (this.L().getVisibility() == 0) {
                    textView2 = this.desc;
                    if (textView2 != null) {
                        if (a06) {
                            i16 = 2;
                        } else {
                            i16 = 3;
                        }
                        textView2.setMaxLines(i16);
                        return;
                    }
                    return;
                }
                textView = this.giftGuildTag;
                if (textView != null) {
                    if (a06) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    textView.setVisibility(i3);
                }
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[EDGE_INSN: B:11:0x003c->B:12:0x003c BREAK  A[LOOP:0: B:3:0x001a->B:23:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:0: B:3:0x001a->B:23:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void J(String guildName, List<? extends IGProMedalInfo> medalList, final TextView tvName) {
        CharSequence trim;
        Unit unit;
        int i3;
        Object obj;
        boolean z16;
        if (tvName != null) {
            String a16 = com.tencent.mobileqq.guild.util.az.a(guildName);
            Intrinsics.checkNotNullExpressionValue(a16, "changeEnterToSpace(guildName)");
            trim = StringsKt__StringsKt.trim((CharSequence) a16);
            final String obj2 = trim.toString();
            Iterator<T> it = medalList.iterator();
            while (true) {
                unit = null;
                i3 = 0;
                if (it.hasNext()) {
                    obj = it.next();
                    IGProOfficialMedalInfoExt officialMedalInfoExt = ((IGProMedalInfo) obj).getOfficialMedalInfoExt();
                    if (officialMedalInfoExt != null) {
                        z16 = true;
                        if (officialMedalInfoExt.getIsOffical()) {
                            if (!z16) {
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
            if (iGProMedalInfo != null) {
                i3 = com.tencent.mobileqq.guild.util.an.INSTANCE.c();
            }
            H(obj2, i3, tvName);
            tvName.setEllipsize(TextUtils.TruncateAt.END);
            if (iGProMedalInfo != null) {
                an.Companion.f(com.tencent.mobileqq.guild.util.an.INSTANCE, new WeakReference(tvName), new Function2<URLDrawable, Integer, Unit>(this) { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection$bindNameAndMedal$1$2$1
                    final /* synthetic */ RecommendGuildSection<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                        invoke(uRLDrawable, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull URLDrawable urlDrawable, int i16) {
                        Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                        this.this$0.t0(tvName, obj2, new ImageSpan(urlDrawable, 2), i16);
                    }
                }, 0, 4, null);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                tvName.setText(obj2);
            }
        }
    }

    private final HashMap<String, Object> N(RecommendGuildData data, int position) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_rank", Integer.valueOf(position));
        hashMap.put("sgrp_channel_id", String.valueOf(data.getGuildId()));
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId());
        hashMap.put("sgrp_btn_type", Integer.valueOf(S()));
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.i iVar = new com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.i();
        iVar.b(data);
        hashMap.put("sgrp_status", Integer.valueOf(iVar.getSgrpStatus()));
        hashMap.put("sgrp_recall_tag", iVar.getSgrpRecallTag());
        hashMap.put("sgrp_explicit_tag", iVar.getSgrpExplicitTag());
        hashMap.put("sgrp_game_gift_tag", iVar.getSgrpGameGiftTag());
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int S() {
        String obj;
        CharSequence charSequence;
        if (Z()) {
            QUIButton qUIButton = this.giftGuildJumpButton;
            if (qUIButton != null) {
                charSequence = qUIButton.getText();
            } else {
                charSequence = null;
            }
            obj = String.valueOf(charSequence);
        } else {
            obj = Q().getText().toString();
        }
        switch (obj.hashCode()) {
            case -1295294431:
                if (obj.equals("\u52a0\u5165\u5e76\u9886\u53d6")) {
                    return 3;
                }
                return 0;
            case 676549:
                if (obj.equals("\u52a0\u5165")) {
                    return 1;
                }
                break;
            case 21846749:
                if (obj.equals("\u53bb\u9891\u9053")) {
                    return 2;
                }
                break;
            case 1184827737:
                if (obj.equals("\u9886\u53d6\u793c\u5305")) {
                    return 4;
                }
                break;
        }
    }

    private final boolean T(String guildId) {
        IGPSService d16 = com.tencent.mobileqq.guild.util.at.d();
        if (d16 == null || !d16.isGuildMember(guildId)) {
            return false;
        }
        return true;
    }

    private final void U(final RecommendGuildData data, final int position) {
        String str;
        boolean z16;
        R().setTextColor(V);
        TextView textView = this.desc;
        if (textView != null) {
            textView.setTextColor(W);
        }
        P().setImageUrl(data.getCover());
        this.mGuildId = String.valueOf(data.getGuildId());
        QUIButton Q = Q();
        if (T(this.mGuildId)) {
            str = "\u53bb\u9891\u9053";
        } else {
            str = "\u52a0\u5165";
        }
        Q.setText(str);
        boolean z17 = true;
        Q().setType(1);
        Q().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendGuildSection.V(RecommendGuildSection.this, data, position, view);
            }
        });
        TextView textView2 = this.desc;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        String guildProfile = data.getGuildProfile();
        Intrinsics.checkNotNullExpressionValue(guildProfile, "data.guildProfile");
        if (guildProfile.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView3 = this.desc;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            ci1.a.i(this.desc, com.tencent.biz.qui.quicommon.e.a(21.0f));
            String guildProfile2 = data.getGuildProfile();
            Intrinsics.checkNotNullExpressionValue(guildProfile2, "data.guildProfile");
            String k06 = k0(guildProfile2);
            ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(data.getGuildProfile(), 16);
            TextView textView4 = this.desc;
            if (textView4 != null) {
                textView4.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(k06, 16));
            }
        }
        String guildProfile3 = data.getGuildProfile();
        Intrinsics.checkNotNullExpressionValue(guildProfile3, "data.guildProfile");
        if (guildProfile3.length() <= 0) {
            z17 = false;
        }
        String guildAvatar = data.getGuildAvatar();
        Intrinsics.checkNotNullExpressionValue(guildAvatar, "data.guildAvatar");
        l0(z17, guildAvatar);
        String guildName = data.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "data.guildName");
        ArrayList<IGProMedalInfo> medals = data.getMedals();
        Intrinsics.checkNotNullExpressionValue(medals, "data.medals");
        J(guildName, medals, R());
        ArrayList<IGProGuildLabel> tagList = data.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList, "data.tagList");
        Y(tagList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(RecommendGuildSection this$0, RecommendGuildData data, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Context context = this$0.getRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            String str = this$0.mGuildId;
            byte[] joinSig = data.getJoinSig();
            Intrinsics.checkNotNullExpressionValue(joinSig, "data.joinSig");
            this$0.b0(context, str, new String(joinSig, Charsets.UTF_8));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_join_channel_btn", "clck", this$0.N(data, i3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"SetTextI18n"})
    private final void W(final RecommendGuildData data, final int position) {
        String str;
        R().setTextColor(V);
        TextView textView = this.desc;
        if (textView != null) {
            textView.setTextColor(W);
        }
        IGProGameGiftInfo giftInfo = data.getGiftInfo();
        this.mGuildId = String.valueOf(data.getGuildId());
        if (giftInfo.getGiftIconList().size() >= 3) {
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, this.giftLeftIcon, data.getGiftInfo().getGiftIconList().get(1), 0, 0, false, 28, null);
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, this.giftRightIcon, data.getGiftInfo().getGiftIconList().get(2), 0, 0, false, 28, null);
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, this.giftCenterIcon, data.getGiftInfo().getGiftIconList().get(0), 0, 0, false, 28, null);
        } else {
            Intrinsics.checkNotNullExpressionValue(giftInfo.getGiftIconList(), "giftInfo.giftIconList");
            if (!r3.isEmpty()) {
                com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, this.giftLeftIcon, data.getGiftInfo().getGiftIconList().get(0), 0, 0, false, 28, null);
            }
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, this.giftGuildAvatar, data.getGuildAvatar(), 0, 0, false, 28, null);
        TextView textView2 = this.giftNum;
        if (textView2 != null) {
            textView2.setText(giftInfo.getGiftNum() + "\u4e2a\u793c\u5305\u5f85\u9886\u53d6");
        }
        String guildName = data.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "data.guildName");
        ArrayList<IGProMedalInfo> medals = data.getMedals();
        Intrinsics.checkNotNullExpressionValue(medals, "data.medals");
        J(guildName, medals, this.giftGuildName);
        ci1.a.i(this.giftGuildName, com.tencent.biz.qui.quicommon.e.a(20.0f));
        ci1.a.i(this.giftGuildTag, com.tencent.biz.qui.quicommon.e.a(18.0f));
        ArrayList<IGProGuildLabel> tagList = data.getTagList();
        Intrinsics.checkNotNullExpressionValue(tagList, "data.tagList");
        final SpannableStringBuilder i3 = ci1.b.i(tagList);
        TextView textView3 = this.giftGuildTag;
        if (textView3 != null) {
            textView3.setText(i3);
        }
        final TextView textView4 = this.giftGuildName;
        if (textView4 != null) {
            Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(textView4, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection$initGiftStyle$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView5;
                    TextView textView6;
                    boolean a06;
                    TextView textView7;
                    if (data.getTagList().size() > 0) {
                        RecommendGuildSection recommendGuildSection = this;
                        textView6 = recommendGuildSection.giftGuildName;
                        String spannableStringBuilder = i3.toString();
                        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "spString.toString()");
                        a06 = recommendGuildSection.a0(textView6, spannableStringBuilder, 0);
                        if (a06) {
                            byte[] labelName = data.getTagList().get(0).getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName, "data.tagList[0].labelName");
                            String str2 = new String(labelName, Charsets.UTF_8);
                            textView7 = this.giftGuildTag;
                            if (textView7 != null) {
                                textView7.setText(ci1.b.g(str2));
                                return;
                            }
                            return;
                        }
                    }
                    textView5 = this.giftGuildTag;
                    if (textView5 != null) {
                        textView5.setText(i3);
                    }
                }
            }), "OneShotPreDrawListener.add(this) { action(this) }");
        }
        QUIButton qUIButton = this.giftGuildJumpButton;
        if (qUIButton != null) {
            if (T(this.mGuildId)) {
                str = "\u9886\u53d6\u793c\u5305";
            } else {
                str = "\u52a0\u5165\u5e76\u9886\u53d6";
            }
            qUIButton.setText(str);
        }
        QUIButton qUIButton2 = this.giftGuildJumpButton;
        if (qUIButton2 != null) {
            qUIButton2.setType(1);
        }
        QUIButton qUIButton3 = this.giftGuildJumpButton;
        if (qUIButton3 != null) {
            qUIButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendGuildSection.X(RecommendGuildSection.this, data, position, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(RecommendGuildSection this$0, RecommendGuildData data, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Context context = this$0.getRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            String str = this$0.mGuildId;
            byte[] joinSig = data.getJoinSig();
            Intrinsics.checkNotNullExpressionValue(joinSig, "data.joinSig");
            this$0.b0(context, str, new String(joinSig, Charsets.UTF_8));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_join_channel_btn", "clck", this$0.N(data, i3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y(List<? extends IGProGuildLabel> array) {
        if (array.isEmpty()) {
            return;
        }
        M().removeAllViews();
        IGProGuildLabel iGProGuildLabel = array.get(0);
        boolean l3 = ci1.b.l(array);
        K(iGProGuildLabel, l3, false);
        if (array.size() > 1) {
            K(array.get(1), l3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(TextView textView, String text, int imageWidth) {
        boolean z16;
        if (textView == null) {
            return false;
        }
        float measureText = textView.getPaint().measureText(text);
        int width = textView.getWidth() - imageWidth;
        int i3 = ((int) (measureText / width)) + 1;
        if (i3 > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(text);
        sb5.append(" isMultiLine=");
        sb5.append(z16);
        sb5.append(", textWidth=");
        sb5.append(measureText);
        sb5.append(", availableWidth=");
        sb5.append(width);
        sb5.append(", lineCount=");
        sb5.append(i3 - 1);
        QLog.d("RecommendGuildSection", 4, sb5.toString());
        if (i3 <= 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b0(final Context context, String guildId, String joinSig) {
        QLog.d("RecommendGuildSection", 1, "guildId: " + guildId + " joinSig: " + joinSig);
        if (T(guildId)) {
            if (Z()) {
                e0();
                return;
            } else {
                g0();
                return;
            }
        }
        JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
        jumpParam.d(true);
        jumpParam.a(11);
        Pair<String, String> b16 = r().b(((RecommendGuildData) this.mData).getItemType());
        String component1 = b16.component1();
        String component2 = b16.component2();
        if (Z() && Intrinsics.areEqual("discover", component1)) {
            component2 = "discover_single_recommend_game2";
        }
        final JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, "", joinSig, component1, component2);
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(context, jumpGuildParam, jumpParam, "Guild.jump.RecommendGuildSection", new bv() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.x
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                RecommendGuildSection.c0(RecommendGuildSection.this, jumpGuildParam, context, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final RecommendGuildSection this$0, JumpGuildParam mJumpGuildParam, Context context, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mJumpGuildParam, "$mJumpGuildParam");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.y
                @Override // java.lang.Runnable
                public final void run() {
                    RecommendGuildSection.d0(RecommendGuildSection.this);
                }
            }, 0L);
            if (this$0.Z()) {
                this$0.e0();
                return;
            }
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            GuildJumpUtil.n(context2, mJumpGuildParam);
            return;
        }
        QLog.e("RecommendGuildSection", 1, "joinGuild errMsg: " + str);
        com.tencent.mobileqq.guild.channel.joinchannel.h.c(context, i3, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(RecommendGuildSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q().setText("\u53bb\u9891\u9053");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e0() {
        String str;
        IGProGameGiftInfo giftInfo = ((RecommendGuildData) this.mData).getGiftInfo();
        if (giftInfo != null) {
            str = giftInfo.getJumpUrl();
        } else {
            str = null;
        }
        Context context = getRootView().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        GuildJumpUtil.w((Activity) context, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0() {
        Pair<String, String> b16 = r().b(((RecommendGuildData) this.mData).getItemType());
        String component1 = b16.component1();
        String component2 = b16.component2();
        String valueOf = String.valueOf(((RecommendGuildData) this.mData).getGuildId());
        byte[] joinSig = ((RecommendGuildData) this.mData).getJoinSig();
        Intrinsics.checkNotNullExpressionValue(joinSig, "mData.joinSig");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(valueOf, "", new String(joinSig, Charsets.UTF_8), component1, component2);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j0() {
        if (!Z()) {
            ArrayList<IGProGuildLabel> tagList = ((RecommendGuildData) this.mData).getTagList();
            Intrinsics.checkNotNullExpressionValue(tagList, "mData.tagList");
            Y(tagList);
            return;
        }
        ColorStateList colorStateList = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_common_text_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "sMobileQQ.resources.getC\u2026.qui_common_text_primary)");
        TextView textView = this.giftGuildName;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.giftGuildTag;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    private final String k0(String input) {
        return new Regex("\\s+").replace(new Regex("\\n|\\r").replace(input, ""), " ");
    }

    private final void l0(boolean hasDesc, String imageUrl) {
        int i3;
        TextView R = R();
        ViewGroup.LayoutParams layoutParams = R.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (hasDesc) {
                i3 = T;
            } else {
                i3 = U;
            }
            layoutParams2.topMargin = i3;
            R.setLayoutParams(layoutParams2);
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, O(), imageUrl, 0, 0, true, 12, null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(final TextView tvName, final String fixedGuildName, final ImageSpan iconSpan, final int iconWidth) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fixedGuildName);
        spannableStringBuilder.append((CharSequence) "  ");
        spannableStringBuilder.setSpan(iconSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        tvName.setText(spannableStringBuilder);
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(tvName, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection$updateNameWithOfficialMedal$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                int maxLines = tvName.getMaxLines() - 1;
                if (tvName.getLayout() != null && tvName.getLayout().getEllipsisCount(maxLines) != 0) {
                    Layout layout = tvName.getLayout();
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    spannableStringBuilder2.append((CharSequence) "  ");
                    spannableStringBuilder2.setSpan(iconSpan, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
                    int offsetForHorizontal = layout.getOffsetForHorizontal(tvName.getMaxLines() - 1, layout.getWidth() - (layout.getPaint().measureText(spannableStringBuilder2, 0, spannableStringBuilder2.length()) + iconWidth));
                    BreakIterator characterInstance = BreakIterator.getCharacterInstance();
                    characterInstance.setText(fixedGuildName);
                    if (offsetForHorizontal >= 0 && offsetForHorizontal <= fixedGuildName.length()) {
                        if (!characterInstance.isBoundary(offsetForHorizontal)) {
                            offsetForHorizontal = characterInstance.preceding(offsetForHorizontal);
                        }
                        TextView textView = tvName;
                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
                        String substring = fixedGuildName.substring(0, offsetForHorizontal);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        spannableStringBuilder3.append((CharSequence) substring);
                        spannableStringBuilder3.append((CharSequence) spannableStringBuilder2);
                        textView.setText(spannableStringBuilder3);
                        tvName.setEllipsize(null);
                        return;
                    }
                    QLog.d("RecommendGuildSection", 1, "bindNameAndMedal beyond boundary offset = " + offsetForHorizontal);
                }
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public void K(@NotNull IGProGuildLabel label, boolean isAllSimpleLabel, boolean isSecondly) {
        int i3;
        Intrinsics.checkNotNullParameter(label, "label");
        byte[] labelName = label.getLabelName();
        Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
        String str = new String(labelName, Charsets.UTF_8);
        Context context = getRootView().getContext();
        int labelType = label.getLabelType();
        if (isSecondly) {
            i3 = com.tencent.biz.qui.quicommon.e.a(6.0f);
        } else {
            i3 = 0;
        }
        if (labelType != 2) {
            if (labelType != 12 && labelType != 15) {
                if (labelType != 17 && labelType != 19 && labelType != 27) {
                    switch (labelType) {
                        case 29:
                        case 30:
                        case 31:
                            break;
                        case 32:
                            LinearLayout M = M();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            M.addView(ci1.b.e(context, R.drawable.guild_screen_share_icon, str, i3));
                            return;
                        default:
                            LinearLayout M2 = M();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            M2.addView(ci1.b.f(context, str, i3));
                            return;
                    }
                }
            }
            String h16 = ci1.b.h(labelType);
            LinearLayout M3 = M();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            M3.addView(ci1.b.a(context, h16, str, i3));
            return;
        }
        if (!isAllSimpleLabel) {
            LinearLayout M4 = M();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            M4.addView(ci1.b.f(context, str, i3));
        } else {
            LinearLayout M5 = M();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            M5.addView(ci1.b.d(context, str, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View L() {
        View view = this.baseGuildContent;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseGuildContent");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final LinearLayout M() {
        LinearLayout linearLayout = this.descContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("descContainer");
        return null;
    }

    @NotNull
    protected final ImageView O() {
        ImageView imageView = this.mAvatar;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
        return null;
    }

    @NotNull
    protected final GradientImageView P() {
        GradientImageView gradientImageView = this.mBg;
        if (gradientImageView != null) {
            return gradientImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBg");
        return null;
    }

    @NotNull
    protected final QUIButton Q() {
        QUIButton qUIButton = this.mButton;
        if (qUIButton != null) {
            return qUIButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mButton");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView R() {
        TextView textView = this.mName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mName");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean Z() {
        IGProGameGiftInfo giftInfo;
        ArrayList<String> giftIconList;
        RecommendGuildData recommendGuildData = (RecommendGuildData) this.mData;
        if (recommendGuildData == null || (giftInfo = recommendGuildData.getGiftInfo()) == null || (giftIconList = giftInfo.getGiftIconList()) == null || !(!giftIconList.isEmpty())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull T data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Z()) {
            L().setVisibility(8);
            P().setVisibility(8);
            View view = this.giftGuildContent;
            if (view != null) {
                view.setVisibility(0);
            }
            W(data, position);
            return;
        }
        L().setVisibility(0);
        P().setVisibility(0);
        View view2 = this.giftGuildContent;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        U(data, position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.baseGuildContent = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n0(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.descContainer = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o0(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mAvatar = imageView;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        QLog.d("RecommendGuildSection", 4, "onAttachedChanged attached=" + attached);
        if (attached) {
            ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.mServiceObserver);
        } else {
            ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.mServiceObserver);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            if (Z()) {
                e0();
            } else {
                g0();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        r0(containerView);
        View findViewById = containerView.findViewById(R.id.f165470w60);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_v2_recommend_contact_bg)");
        p0((GradientImageView) findViewById);
        View findViewById2 = containerView.findViewById(R.id.w5z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026recommend_contact_avatar)");
        o0((ImageView) findViewById2);
        View findViewById3 = containerView.findViewById(R.id.f165473w63);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u20262_recommend_contact_nick)");
        s0((TextView) findViewById3);
        R().setTextColor(V);
        View findViewById4 = containerView.findViewById(R.id.f165472w62);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u20262_recommend_contact_join)");
        q0((QUIButton) findViewById4);
        View findViewById5 = containerView.findViewById(R.id.w6t);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026recommend_tags_container)");
        n0((LinearLayout) findViewById5);
        View findViewById6 = containerView.findViewById(R.id.w5y);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026mmend_base_guild_content)");
        m0(findViewById6);
        TextView textView = (TextView) containerView.findViewById(R.id.wve);
        this.desc = textView;
        if (textView != null) {
            textView.setTextColor(W);
        }
        this.giftGuildContent = containerView.findViewById(R.id.w69);
        this.giftLeftIcon = (ImageView) containerView.findViewById(R.id.w6a);
        this.giftRightIcon = (ImageView) containerView.findViewById(R.id.w6c);
        this.giftCenterIcon = (ImageView) containerView.findViewById(R.id.w68);
        this.giftNum = (TextView) containerView.findViewById(R.id.w6b);
        this.giftGuildAvatar = (ImageView) containerView.findViewById(R.id.w6g);
        this.giftGuildName = (TextView) containerView.findViewById(R.id.w6i);
        this.giftGuildTag = (TextView) containerView.findViewById(R.id.w6j);
        this.giftGuildJumpButton = (QUIButton) containerView.findViewById(R.id.w6h);
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewExtKt.b(rootView, this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        j0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(@NotNull GradientImageView gradientImageView) {
        Intrinsics.checkNotNullParameter(gradientImageView, "<set-?>");
        this.mBg = gradientImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q0(@NotNull QUIButton qUIButton) {
        Intrinsics.checkNotNullParameter(qUIButton, "<set-?>");
        this.mButton = qUIButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mContainerView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s0(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mName = textView;
    }
}
