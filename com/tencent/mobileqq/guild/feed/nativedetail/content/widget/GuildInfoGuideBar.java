package com.tencent.mobileqq.guild.feed.nativedetail.content.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.widget.CommentEllipsizeLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetGuildLabelInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.r;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okio.internal._Utf8Kt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001qB\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\bl\u0010mB\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010o\u001a\u0004\u0018\u00010n\u00a2\u0006\u0004\bl\u0010pJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017J$\u0010 \u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0012\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010(\u001a\u00020\tH\u0002J\u0016\u0010+\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u001aH\u0003J\u001e\u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\u001aH\u0002J\u0010\u00103\u001a\u0002022\u0006\u00101\u001a\u00020\u0014H\u0002J\u0018\u00106\u001a\u0002052\u0006\u0010-\u001a\u00020,2\u0006\u00104\u001a\u00020\u0014H\u0002J\u0012\u00108\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u0014H\u0002J(\u0010>\u001a\u00020=2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0002J\u0010\u0010@\u001a\u00020\t2\u0006\u0010?\u001a\u00020=H\u0002J\b\u0010B\u001a\u00020AH\u0002J\u0012\u0010D\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010E\u001a\u00020\tH\u0002J\u0010\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0014H\u0002J(\u0010K\u001a\u00020\t2\u0006\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0006H\u0002J,\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020N0M2\u0006\u0010L\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0006H\u0002J\u0010\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020/H\u0002R\u0016\u0010U\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010C\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\\R\u001b\u0010k\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010h\u001a\u0004\bi\u0010j\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/GuildInfoGuideBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "", "busType", "experimentID", "", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;Ljava/lang/Integer;Ljava/lang/Integer;)V", "type", "setJoinButtonType", "Landroid/view/View$OnClickListener;", "listener", "setGuildInfoOnClickListener", "Landroid/graphics/drawable/GradientDrawable;", "drawable", "setBgDrawable", "", "color", "setBottomDesTextColor", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "stateListener", "setGuildIconStateListener", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feedList", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/d;", "itemClickListener", "traceId", "l", "B", HippyTKDListViewAdapter.X, "K", "I", "", "guildName", UserInfo.SEX_FEMALE, "y", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "labelList", "G", "Landroid/content/Context;", "context", HippyControllerProps.ARRAY, "Landroid/widget/TextView;", "r", "input", "Landroid/text/SpannableString;", ReportConstant.COSTREPORT_PREFIX, "content", "Lcom/tencent/biz/qui/quitagview/QUITagView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, PhotoCategorySummaryInfo.AVATAR_URL, "E", NodeProps.MARGIN_LEFT, NodeProps.MARGIN_TOP, NodeProps.MARGIN_RIGHT, NodeProps.MARGIN_BOTTOM, "Landroid/view/View;", "t", "clickedView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "p", "guildId", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "label", "H", "cardView", "feed", "rank", "o", "stFeed", "", "", "v", "textView", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d", "Z", "isMember", "", "e", "J", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", h.F, "Ljava/lang/Integer;", "businessType", "i", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "guildIconStateListener", "Landroid/view/View$OnClickListener;", "guildInfoOnClickListener", "Lx12/d;", "D", "Lx12/d;", "binding", "Lkotlin/Lazy;", "u", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "onlineMemberObserver", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInfoGuideBar extends FrameLayout {
    private static final int H = com.tencent.guild.aio.util.c.b(10);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener guildInfoOnClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private x12.d binding;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer experimentID;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineMemberObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isMember;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer businessType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JumpGuildParam.JoinInfoParam joinInfoParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildPicStateListener guildIconStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/widget/GuildInfoGuideBar$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "", "guildId", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "black", "onBeKickFromGuild", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@NotNull IGProGuildInfo info, int sourceType) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (TextUtils.equals(info.getGuildID(), String.valueOf(GuildInfoGuideBar.this.guildId))) {
                GuildInfoGuideBar.this.isMember = true;
                GuildInfoGuideBar.this.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@NotNull String guildId, int black) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildInfoGuideBar.this.w(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildInfoGuideBar.this.w(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildInfoGuideBar.this.w(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            GuildInfoGuideBar.this.w(guildId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInfoGuideBar(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.businessType = 0;
        x12.d g16 = x12.d.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        this.experimentID = 0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$onlineMemberObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver p16;
                p16 = GuildInfoGuideBar.this.p();
                return p16;
            }
        });
        this.onlineMemberObserver = lazy;
        final QUIButton qUIButton = this.binding.f446905h;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.guildJumpBtn");
        final long j3 = 200;
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                View.OnClickListener onClickListener;
                x12.d dVar;
                EventCollector.getInstance().onViewClickedBefore(it);
                qUIButton.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                onClickListener = this.guildInfoOnClickListener;
                if (onClickListener != null) {
                    dVar = this.binding;
                    onClickListener.onClick(dVar.f446902e);
                }
                final View view = qUIButton;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final QUIButton qUIButton2 = this.binding.f446904g;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "binding.guildJoinBtn");
        qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                qUIButton2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.C(it);
                final View view = qUIButton2;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final RelativeLayout relativeLayout = this.binding.f446902e;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.container");
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                View.OnClickListener onClickListener;
                x12.d dVar;
                EventCollector.getInstance().onViewClickedBefore(it);
                relativeLayout.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                onClickListener = this.guildInfoOnClickListener;
                if (onClickListener != null) {
                    dVar = this.binding;
                    onClickListener.onClick(dVar.f446902e);
                }
                final View view = relativeLayout;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        yl1.b bVar = yl1.b.f450589a;
        yl1.b.b(bVar, this, "em_sgrp_guide_join_channel", null, 4, null);
        QUIButton qUIButton3 = this.binding.f446904g;
        Intrinsics.checkNotNullExpressionValue(qUIButton3, "binding.guildJoinBtn");
        yl1.b.d(bVar, qUIButton3, "em_sgrp_join_channel_btn", null, 4, null);
    }

    private final boolean A(TextView textView) {
        int lineCount;
        Layout layout = textView.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(View clickedView) {
        String str;
        String str2;
        String str3;
        QLog.i("GuildInfoGuideBar", 1, "onJoinGuild guildID=" + this.guildId + ", jp = " + this.joinInfoParam);
        JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam != null && joinInfoParam.getMainSource() != null) {
            String valueOf = String.valueOf(this.guildId);
            JumpGuildParam.JoinInfoParam joinInfoParam2 = this.joinInfoParam;
            if (joinInfoParam2 != null) {
                str = joinInfoParam2.getJoinSignature();
            } else {
                str = null;
            }
            JumpGuildParam.JoinInfoParam joinInfoParam3 = this.joinInfoParam;
            if (joinInfoParam3 != null) {
                str2 = joinInfoParam3.getMainSource();
            } else {
                str2 = null;
            }
            JumpGuildParam.JoinInfoParam joinInfoParam4 = this.joinInfoParam;
            if (joinInfoParam4 != null) {
                str3 = joinInfoParam4.getSubSource();
            } else {
                str3 = null;
            }
            JumpGuildParam jumpGuildParam = new JumpGuildParam(valueOf, null, str, str2, str3);
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.c(false);
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(getContext(), jumpGuildParam, jumpParam, "GuildInfoGuideBar", new bv() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.a
                @Override // vh2.bv
                public final void a(int i3, String str4, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    GuildInfoGuideBar.D(GuildInfoGuideBar.this, i3, str4, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GuildInfoGuideBar this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildInfoGuideBar", 1, "onJoinGuild result=" + i3 + " errMsg=" + str + " security=" + iGProSecurityResult);
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            this$0.isMember = true;
        } else {
            this$0.isMember = false;
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.getContext(), i3, str, iGProSecurityResult);
        }
        this$0.K();
    }

    private final void E(String avatarUrl) {
        boolean z16;
        if (avatarUrl != null && avatarUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        GuildRoundBoardImageView guildRoundBoardImageView = this.binding.f446903f;
        guildRoundBoardImageView.setCornerRadiusAndMode(H, 1);
        u.l(guildRoundBoardImageView, avatarUrl, this.guildIconStateListener);
    }

    private final void F(CharSequence guildName) {
        boolean z16;
        if (guildName != null && guildName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.binding.f446906i.setText(guildName);
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    private final void G(List<? extends IGProGuildLabel> labelList) {
        QLog.d("GuildInfoGuideBar", 1, "labelSize=" + labelList.size());
        this.binding.f446907j.removeAllViews();
        Iterator<? extends IGProGuildLabel> it = labelList.iterator();
        String str = "";
        while (it.hasNext()) {
            byte[] labelName = it.next().getLabelName();
            Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
            String commonToUtf8String$default = _Utf8Kt.commonToUtf8String$default(labelName, 0, 0, 3, null);
            Integer num = this.experimentID;
            if (num == null || num.intValue() != 1) {
                CommentEllipsizeLayout commentEllipsizeLayout = this.binding.f446907j;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                commentEllipsizeLayout.addView(q(context, commonToUtf8String$default));
            }
            str = str + "," + commonToUtf8String$default;
        }
        Integer num2 = this.experimentID;
        if (num2 != null && num2.intValue() == 1) {
            CommentEllipsizeLayout commentEllipsizeLayout2 = this.binding.f446907j;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            commentEllipsizeLayout2.addView(r(context2, labelList));
        }
        H(str);
    }

    private final void H(String label) {
        Map map;
        RelativeLayout relativeLayout = this.binding.f446902e;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_explicit_tag", label);
        Unit unit = Unit.INSTANCE;
        map = MapsKt__MapsKt.toMap(linkedHashMap);
        com.tencent.mobileqq.guild.feed.report.d.d(relativeLayout, "em_sgrp_info_region", clickPolicy, exposurePolicy, endExposurePolicy, map);
    }

    @SuppressLint({"ResourceType"})
    private final void I(IGProGuildInfo guildInfo) {
        CharSequence trim;
        String a16 = az.a(guildInfo.getGuildName());
        Intrinsics.checkNotNullExpressionValue(a16, "changeEnterToSpace(guildInfo.guildName)");
        trim = StringsKt__StringsKt.trim((CharSequence) a16);
        final String obj = trim.toString();
        F(obj);
        final List t16 = GuildMedalUtils.t(guildInfo.getMedalInfoList(), 0, 2, null);
        boolean z16 = true;
        if (!t16.isEmpty()) {
            this.binding.f446906i.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildInfoGuideBar.J(t16, this, obj);
                }
            });
        }
        if (!guildInfo.isMember()) {
            String profile = guildInfo.getProfile();
            if (profile != null && profile.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                this.binding.f446899b.setVisibility(0);
                this.binding.f446900c.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(guildInfo.getProfile(), 14));
                return;
            }
        }
        this.binding.f446899b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(List validMediaList, GuildInfoGuideBar this$0, String guildName) {
        Object obj;
        List listOf;
        Intrinsics.checkNotNullParameter(validMediaList, "$validMediaList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildName, "$guildName");
        Iterator it = validMediaList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProMedalInfo) obj).getOfficialMedalInfoExt().getIsOffical()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
        if (iGProMedalInfo != null) {
            GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(iGProMedalInfo);
            TextView textView = this$0.binding.f446906i;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildName");
            GuildMedalUtils.w(guildMedalUtils, guildName, listOf, textView, null, 0, null, 56, null);
        }
        TextView textView2 = this$0.binding.f446906i;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.guildName");
        if (this$0.A(textView2)) {
            this$0.binding.f446907j.setVisibility(8);
        } else {
            this$0.binding.f446907j.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        if (this.isMember) {
            this.binding.f446904g.setVisibility(8);
            this.binding.f446905h.setVisibility(0);
        } else {
            this.binding.f446904g.setVisibility(0);
            this.binding.f446905h.setVisibility(8);
        }
    }

    private final void m() {
        Map emptyMap;
        Map emptyMap2;
        QUIButton qUIButton = this.binding.f446904g;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        emptyMap = MapsKt__MapsKt.emptyMap();
        com.tencent.mobileqq.guild.feed.report.d.d(qUIButton, "em_sgrp_info_region_join", clickPolicy, exposurePolicy, endExposurePolicy, emptyMap);
        QUIButton qUIButton2 = this.binding.f446905h;
        emptyMap2 = MapsKt__MapsKt.emptyMap();
        com.tencent.mobileqq.guild.feed.report.d.d(qUIButton2, "em_sgrp_info_region_to_channel", clickPolicy, exposurePolicy, endExposurePolicy, emptyMap2);
    }

    private final void o(View cardView, GProStFeed feed, String traceId, int rank) {
        Map map;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        map = MapsKt__MapsKt.toMap(v(feed, traceId, rank));
        com.tencent.mobileqq.guild.feed.report.d.d(cardView, "em_sgrp_recommend_forum_card", clickPolicy, exposurePolicy, endExposurePolicy, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver p() {
        return new b();
    }

    private final QUITagView q(Context context, String content) {
        QUITagView qUITagView = new QUITagView(context, null, 2, null);
        qUITagView.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, content));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMarginEnd(ViewUtils.dip2px(6.0f));
        qUITagView.setLayoutParams(layoutParams);
        return qUITagView;
    }

    private final TextView r(Context context, List<? extends IGProGuildLabel> array) {
        TextView textView = new TextView(context);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int size = array.size();
        for (int i3 = 0; i3 < size; i3++) {
            byte[] labelName = array.get(i3).getLabelName();
            Intrinsics.checkNotNullExpressionValue(labelName, "array[i].labelName");
            spannableStringBuilder.append((CharSequence) s(_Utf8Kt.commonToUtf8String$default(labelName, 0, 0, 3, null)));
            if (i3 < array.size() - 1) {
                spannableStringBuilder.append((CharSequence) "\u00b7");
            }
        }
        textView.setText(spannableStringBuilder);
        textView.setTextSize(11.0f);
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
        return textView;
    }

    private final SpannableString s(String input) {
        SpannableString spannableString = new SpannableString(input);
        for (MatchResult matchResult : Regex.findAll$default(new Regex("\\d+"), input, 0, 2, null)) {
            spannableString.setSpan(new StyleSpan(1), matchResult.getRange().getFirst(), matchResult.getRange().getLast() + 1, 0);
        }
        return spannableString;
    }

    private final View t(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        View view = new View(getContext());
        view.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        layoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private final GPServiceObserver u() {
        return (GPServiceObserver) this.onlineMemberObserver.getValue();
    }

    private final Map<String, Object> v(GProStFeed stFeed, String traceId, int rank) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_content_id", Long.valueOf(stFeed.meta.content.ContentID));
        String str = stFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.idd");
        linkedHashMap.put("sgrp_feed_id", str);
        linkedHashMap.put("sgrp_forum_like_num", Integer.valueOf(stFeed.totalPrefer.preferCountWithoutLike));
        linkedHashMap.put("sgrp_forum_view_num", Integer.valueOf(stFeed.visitorInfo.viewCount));
        linkedHashMap.put("sgrp_forum_trace_id", traceId);
        linkedHashMap.put("sgrp_rank", Integer.valueOf(rank));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String guildId) {
        if (TextUtils.equals(guildId, String.valueOf(this.guildId))) {
            this.isMember = false;
            K();
        }
    }

    private final void x() {
        Integer num = this.experimentID;
        if (num != null && num.intValue() == 1) {
            setJoinButtonType(1);
            setBottomDesTextColor("#A6A6A6");
            this.binding.f446911n.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.binding.f446900c.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            this.binding.f446906i.setTextSize(18.0f);
            this.binding.f446906i.setTypeface(Typeface.defaultFromStyle(1));
            GradientDrawable gradientDrawable = new GradientDrawable();
            ie0.a f16 = ie0.a.f();
            gradientDrawable.setColor(f16.g(getContext(), R.color.qui_button_bg_secondary_default, 1000));
            gradientDrawable.setStroke(ViewUtils.dip2px(0.5f), f16.g(getContext(), R.color.qui_button_border_secondary_default, 1000));
            gradientDrawable.setCornerRadius(ViewUtils.dip2px(4.0f));
            this.binding.f446904g.setBackground(gradientDrawable);
            this.binding.f446904g.setBackground(gradientDrawable);
        }
    }

    private final void y() {
        ArrayList<Long> arrayListOf;
        AppInterface appInterface;
        r rVar = new r();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(this.guildId));
        rVar.c(arrayListOf);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.batchGetGuildLabelInfo(rVar, new wh2.e() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.c
                @Override // wh2.e
                public final void a(int i3, String str, IGProBatchGetGuildLabelInfoRsp iGProBatchGetGuildLabelInfoRsp) {
                    GuildInfoGuideBar.z(GuildInfoGuideBar.this, i3, str, iGProBatchGetGuildLabelInfoRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(GuildInfoGuideBar this$0, int i3, String str, IGProBatchGetGuildLabelInfoRsp iGProBatchGetGuildLabelInfoRsp) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GuildInfoGuideBar", 1, "batchGetGuildLabelInfo, result=" + i3 + ", errMsg=" + str);
        ArrayList<IGProGuildLabelInfo> list = iGProBatchGetGuildLabelInfoRsp.getList();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.list");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProGuildLabelInfo) obj).getGuildId() == this$0.guildId) {
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
        IGProGuildLabelInfo iGProGuildLabelInfo = (IGProGuildLabelInfo) obj;
        if (iGProGuildLabelInfo == null) {
            QLog.d("GuildInfoGuideBar", 1, "guildInfo is null");
            return;
        }
        ArrayList<IGProGuildLabel> labels = iGProGuildLabelInfo.getLabels();
        Intrinsics.checkNotNullExpressionValue(labels, "guildInfo.labels");
        this$0.G(labels);
    }

    public final void B() {
        QLog.i("GuildInfoGuideBar", 1, "onClean");
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGProGlobalService) S0).deleteObserver(u());
    }

    public final void l(@NotNull List<GProStFeed> feedList, @NotNull d itemClickListener, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (feedList.isEmpty()) {
            this.binding.f446909l.setVisibility(8);
            return;
        }
        this.binding.f446909l.removeAllViews();
        this.binding.f446909l.setVisibility(0);
        int dip2px = ViewUtils.dip2px(79.0f);
        int dip2px2 = ViewUtils.dip2px(12.0f);
        int dip2px3 = ViewUtils.dip2px(12.0f);
        int dip2px4 = ViewUtils.dip2px(18.0f);
        this.binding.f446909l.addView(t(0, dip2px4, 0, dip2px4));
        for (GProStFeed gProStFeed : feedList) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RecommendFeedItemView recommendFeedItemView = new RecommendFeedItemView(context);
            recommendFeedItemView.b(gProStFeed, itemClickListener, this.joinInfoParam);
            this.binding.f446909l.addView(recommendFeedItemView);
            if (feedList.indexOf(gProStFeed) != feedList.size() - 1) {
                this.binding.f446909l.addView(t(0, dip2px2, dip2px, dip2px3));
            }
            o(recommendFeedItemView, gProStFeed, traceId, feedList.indexOf(gProStFeed));
        }
    }

    public final void n(@NotNull IGProGuildInfo guildInfo, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @Nullable Integer busType, @Nullable Integer experimentID) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        this.guildInfo = guildInfo;
        String guildID = guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
        this.guildId = Long.parseLong(guildID);
        this.joinInfoParam = joinInfoParam;
        this.businessType = busType;
        this.isMember = guildInfo.isMember();
        this.experimentID = experimentID;
        E(guildInfo.getAvatarUrl(0));
        I(guildInfo);
        y();
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGProGlobalService) S0).addObserver(u());
        K();
        x();
        m();
    }

    public final void setBgDrawable(@NotNull GradientDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setBackground(drawable);
    }

    public final void setBottomDesTextColor(@NotNull String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.binding.f446900c.setTextColor(Color.parseColor(color));
    }

    public final void setGuildIconStateListener(@NotNull GuildPicStateListener stateListener) {
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        this.guildIconStateListener = stateListener;
    }

    public final void setGuildInfoOnClickListener(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.guildInfoOnClickListener = listener;
    }

    public final void setJoinButtonType(int type) {
        this.binding.f446905h.setType(type);
        this.binding.f446904g.setType(type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInfoGuideBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.businessType = 0;
        x12.d g16 = x12.d.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        this.experimentID = 0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$onlineMemberObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver p16;
                p16 = GuildInfoGuideBar.this.p();
                return p16;
            }
        });
        this.onlineMemberObserver = lazy;
        final QUIButton qUIButton = this.binding.f446905h;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.guildJumpBtn");
        final long j3 = 200;
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                View.OnClickListener onClickListener;
                x12.d dVar;
                EventCollector.getInstance().onViewClickedBefore(it);
                qUIButton.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                onClickListener = this.guildInfoOnClickListener;
                if (onClickListener != null) {
                    dVar = this.binding;
                    onClickListener.onClick(dVar.f446902e);
                }
                final View view = qUIButton;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final QUIButton qUIButton2 = this.binding.f446904g;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "binding.guildJoinBtn");
        qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                qUIButton2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.C(it);
                final View view = qUIButton2;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final RelativeLayout relativeLayout = this.binding.f446902e;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.container");
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                View.OnClickListener onClickListener;
                x12.d dVar;
                EventCollector.getInstance().onViewClickedBefore(it);
                relativeLayout.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                onClickListener = this.guildInfoOnClickListener;
                if (onClickListener != null) {
                    dVar = this.binding;
                    onClickListener.onClick(dVar.f446902e);
                }
                final View view = relativeLayout;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.GuildInfoGuideBar$special$$inlined$setSingleClickListener$6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        yl1.b bVar = yl1.b.f450589a;
        yl1.b.b(bVar, this, "em_sgrp_guide_join_channel", null, 4, null);
        QUIButton qUIButton3 = this.binding.f446904g;
        Intrinsics.checkNotNullExpressionValue(qUIButton3, "binding.guildJoinBtn");
        yl1.b.d(bVar, qUIButton3, "em_sgrp_join_channel_btn", null, 4, null);
    }
}
