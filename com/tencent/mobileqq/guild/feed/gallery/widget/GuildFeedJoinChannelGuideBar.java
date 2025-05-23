package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProOnlineMember;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import vh2.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0002MNB\u0011\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IB\u001b\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bH\u0010LJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bJ\"\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 J\u000e\u0010#\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ\u001f\u0010-\u001a\u00020\t2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0)\u00a2\u0006\u0002\b+R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "forceShowBar", "J", "", "guildName", "", "H", "", PhotoCategorySummaryInfo.AVATAR_URL, "G", "backgroundUrl", ReportConstant.COSTREPORT_PREFIX, "hide", "I", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "r", "guildId", "v", "u", "Landroid/view/View;", "clickedView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "guildID", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "K", "Landroid/graphics/drawable/GradientDrawable;", "drawable", "setBgDrawable", "B", "Landroid/view/View$OnClickListener;", "clickListener", "p", "w", "y", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar$a;", "Lkotlin/ExtensionFunctionType;", "configCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Ljava/lang/String;", "mGuildId", "e", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "f", "Landroid/view/View$OnClickListener;", "joinBtnClickListener", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", tl.h.F, "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "guildIconStateListener", "i", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar$a;", "styleConfig", "Lx12/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lx12/c;", "binding", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "onlineMemberObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedJoinChannelGuideBar extends FrameLayout {
    private static final int E = QQGuildUIUtil.f(18.0f);
    private static final int F = com.tencent.guild.aio.util.c.b(6);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineMemberObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JumpGuildParam.JoinInfoParam joinInfoParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener joinBtnClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildPicStateListener guildIconStateListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a styleConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private x12.c binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b2\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b:\u0010;R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010(\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\"\u00101\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b0\u0010\u0010R\"\u00103\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b2\u0010\u0010R\"\u00105\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00107\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b6\u0010\u0010R\"\u00109\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b)\u0010\u000e\"\u0004\b8\u0010\u0010\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar$a;", "", "", "a", "Z", "k", "()Z", "setShowGuildIconTail", "(Z)V", "showGuildIconTail", "", "b", "I", "p", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(I)V", "titleSizeSp", "c", "o", "y", "titleColorRes", "d", "setAvatarTopMargin", "avatarTopMargin", "e", "setAvatarSize", "avatarSize", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "avatarTitleMargin", "g", "i", "v", "joinBtnWidth", tl.h.F, "u", "joinBtnHeight", "l", "setSubTitleBottomMargin", "subTitleBottomMargin", "j", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "subTitleSizeSp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "subTitleColorRes", "setHorizontalPadding", "horizontalPadding", "r", "btnTextColorRes", ReportConstant.COSTREPORT_PREFIX, "btnTextSizeSp", "t", "btnTextViewBgRes", "setRightArrowColorRes", "rightArrowColorRes", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean showGuildIconTail;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int avatarTopMargin;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int subTitleBottomMargin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int titleSizeSp = 13;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int titleColorRes = R.color.f156886eg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int avatarSize = com.tencent.guild.aio.util.c.b(28);

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int avatarTitleMargin = com.tencent.guild.aio.util.c.b(10);

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int joinBtnWidth = com.tencent.guild.aio.util.c.b(74);

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int joinBtnHeight = com.tencent.guild.aio.util.c.b(29);

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int subTitleSizeSp = 10;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int subTitleColorRes = R.color.f156886eg;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int horizontalPadding = com.tencent.guild.aio.util.c.b(8);

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private int btnTextColorRes = R.color.f156886eg;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private int btnTextSizeSp = 13;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int btnTextViewBgRes = R.drawable.guild_feed_detail_banner_bg_1f1f1f_trans80;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private int rightArrowColorRes = R.color.qui_common_text_allwhite_primary;

        /* renamed from: a, reason: from getter */
        public final int getAvatarSize() {
            return this.avatarSize;
        }

        /* renamed from: b, reason: from getter */
        public final int getAvatarTitleMargin() {
            return this.avatarTitleMargin;
        }

        /* renamed from: c, reason: from getter */
        public final int getAvatarTopMargin() {
            return this.avatarTopMargin;
        }

        /* renamed from: d, reason: from getter */
        public final int getBtnTextColorRes() {
            return this.btnTextColorRes;
        }

        /* renamed from: e, reason: from getter */
        public final int getBtnTextSizeSp() {
            return this.btnTextSizeSp;
        }

        /* renamed from: f, reason: from getter */
        public final int getBtnTextViewBgRes() {
            return this.btnTextViewBgRes;
        }

        /* renamed from: g, reason: from getter */
        public final int getHorizontalPadding() {
            return this.horizontalPadding;
        }

        /* renamed from: h, reason: from getter */
        public final int getJoinBtnHeight() {
            return this.joinBtnHeight;
        }

        /* renamed from: i, reason: from getter */
        public final int getJoinBtnWidth() {
            return this.joinBtnWidth;
        }

        /* renamed from: j, reason: from getter */
        public final int getRightArrowColorRes() {
            return this.rightArrowColorRes;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getShowGuildIconTail() {
            return this.showGuildIconTail;
        }

        /* renamed from: l, reason: from getter */
        public final int getSubTitleBottomMargin() {
            return this.subTitleBottomMargin;
        }

        /* renamed from: m, reason: from getter */
        public final int getSubTitleColorRes() {
            return this.subTitleColorRes;
        }

        /* renamed from: n, reason: from getter */
        public final int getSubTitleSizeSp() {
            return this.subTitleSizeSp;
        }

        /* renamed from: o, reason: from getter */
        public final int getTitleColorRes() {
            return this.titleColorRes;
        }

        /* renamed from: p, reason: from getter */
        public final int getTitleSizeSp() {
            return this.titleSizeSp;
        }

        public final void q(int i3) {
            this.avatarTitleMargin = i3;
        }

        public final void r(int i3) {
            this.btnTextColorRes = i3;
        }

        public final void s(int i3) {
            this.btnTextSizeSp = i3;
        }

        public final void t(int i3) {
            this.btnTextViewBgRes = i3;
        }

        public final void u(int i3) {
            this.joinBtnHeight = i3;
        }

        public final void v(int i3) {
            this.joinBtnWidth = i3;
        }

        public final void w(int i3) {
            this.subTitleColorRes = i3;
        }

        public final void x(int i3) {
            this.subTitleSizeSp = i3;
        }

        public final void y(int i3) {
            this.titleColorRes = i3;
        }

        public final void z(int i3) {
            this.titleSizeSp = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0014J\u0018\u0010\u0012\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "", "guildId", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "black", "onBeKickFromGuild", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProOnlineMember;", "onlineMembers", "onGuildOnlineMemberUpdated", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@NotNull IGProGuildInfo info, int sourceType) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (TextUtils.equals(info.getGuildID(), GuildFeedJoinChannelGuideBar.this.mGuildId)) {
                GuildFeedJoinChannelGuideBar.this.B(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@NotNull String guildId, int black) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildFeedJoinChannelGuideBar.this.v(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildFeedJoinChannelGuideBar.this.u(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildFeedJoinChannelGuideBar.this.u(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildOnlineMemberUpdated(@Nullable List<? extends IGProOnlineMember> onlineMembers) {
            ArrayList arrayList;
            int collectionSizeOrDefault;
            super.onGuildOnlineMemberUpdated(onlineMembers);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                Logger.a d16 = logger.d();
                if (onlineMembers != null) {
                    List<? extends IGProOnlineMember> list = onlineMembers;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((IGProOnlineMember) it.next()).getGuildId());
                    }
                } else {
                    arrayList = null;
                }
                d16.d("GuildFeedJoinChannelGuideBar", 1, "onGuildOnlineMemberUpdated gIdList:" + arrayList);
            }
            if (onlineMembers != null) {
                GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = GuildFeedJoinChannelGuideBar.this;
                Iterator<T> it5 = onlineMembers.iterator();
                while (it5.hasNext()) {
                    if (Intrinsics.areEqual(((IGProOnlineMember) it5.next()).getGuildId(), guildFeedJoinChannelGuideBar.mGuildId)) {
                        guildFeedJoinChannelGuideBar.D();
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            GuildFeedJoinChannelGuideBar.this.v(guildId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedJoinChannelGuideBar(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGuildId = "";
        this.styleConfig = new a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar$onlineMemberObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver r16;
                r16 = GuildFeedJoinChannelGuideBar.this.r();
                return r16;
            }
        });
        this.onlineMemberObserver = lazy;
        x12.c g16 = x12.c.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        x12.c cVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        final QUIButton qUIButton = g16.f446892f;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.guildJoinBtn");
        final long j3 = 200;
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar$special$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                qUIButton.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.z(it);
                final View view = qUIButton;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar$special$$inlined$setSingleClickListener$1.1
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
        x12.c cVar2 = this.binding;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar2;
        }
        QUIButton qUIButton2 = cVar.f446892f;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "binding.guildJoinBtn");
        yl1.b.d(bVar, qUIButton2, "em_sgrp_join_channel_btn", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(GuildFeedJoinChannelGuideBar this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "onJoinGuild result=" + i3 + " errMsg=" + str + " security=" + iGProSecurityResult);
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            this$0.B(true);
        } else {
            this$0.B(false);
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.getContext(), i3, str, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(GuildFeedJoinChannelGuideBar this$0, int i3, String str, IGProGuildInfo iGProGuildInfo, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedJoinChannelGuideBar.E(GuildFeedJoinChannelGuideBar.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final GuildFeedJoinChannelGuideBar this$0) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGProGuildInfo guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(this$0.mGuildId);
        Integer num2 = null;
        if (guildInfo != null) {
            num = Integer.valueOf(guildInfo.getUserNum());
        } else {
            num = null;
        }
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "refreshOnlineMemberData userNum:" + num);
        if (guildInfo != null) {
            num2 = Integer.valueOf(guildInfo.getUserNum());
        }
        if (num2 != null && guildInfo.getUserNum() > 0) {
            String string = this$0.getResources().getString(R.string.f15157182);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.guild_number_count)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            final String format = String.format(string, Arrays.copyOf(new Object[]{ProfileUtils.formatPraiseNum(guildInfo.getUserNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.n
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedJoinChannelGuideBar.F(GuildFeedJoinChannelGuideBar.this, format);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GuildFeedJoinChannelGuideBar this$0, String numberTip) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(numberTip, "$numberTip");
        x12.c cVar = this$0.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f446896j.setText(numberTip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(String avatarUrl) {
        boolean z16;
        if (avatarUrl != null && avatarUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        x12.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        GuildRoundBoardImageView guildRoundBoardImageView = cVar.f446888b;
        guildRoundBoardImageView.setCornerRadiusAndMode(F, 1);
        u.l(guildRoundBoardImageView, avatarUrl, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(CharSequence guildName) {
        boolean z16;
        if (guildName != null && guildName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        x12.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f446893g.setText(guildName);
    }

    private final void I(boolean hide) {
        int i3;
        x12.c cVar = this.binding;
        x12.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        QUIButton qUIButton = cVar.f446892f;
        int i16 = 8;
        if (hide) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        qUIButton.setVisibility(i3);
        x12.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar3;
        }
        ImageView imageView = cVar2.f446895i;
        if (hide) {
            i16 = 0;
        }
        imageView.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J(IGProGuildInfo guildInfo, boolean forceShowBar) {
        String str;
        if (guildInfo.isGroupGuild()) {
            return true;
        }
        if (guildInfo.isMember()) {
            if (!forceShowBar) {
                return true;
            }
        } else {
            JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
            if (joinInfoParam != null) {
                str = joinInfoParam.getJoinSignature();
            } else {
                str = null;
            }
            if (str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver r() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String backgroundUrl) {
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(backgroundUrl).setPredecode(true).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), this.guildIconStateListener);
    }

    private final GPServiceObserver t() {
        return (GPServiceObserver) this.onlineMemberObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String guildId) {
        if (TextUtils.equals(guildId, this.mGuildId)) {
            QLog.i("GuildFeedJoinChannelGuideBar", 1, "exit guild " + guildId);
            I(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String guildId) {
        if (TextUtils.equals(guildId, this.mGuildId)) {
            QLog.i("GuildFeedJoinChannelGuideBar", 1, "exit guild " + guildId);
            B(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(View clickedView) {
        String str;
        String str2;
        String str3;
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "onJoinGuild guildID=" + this.mGuildId);
        JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam != null && joinInfoParam.getMainSource() != null) {
            String str4 = this.mGuildId;
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
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str4, null, str, str2, str3);
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.c(false);
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(getContext(), jumpGuildParam, jumpParam, "GuildFeedJoinChannelGuideBar", new bv() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.k
                @Override // vh2.bv
                public final void a(int i3, String str5, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    GuildFeedJoinChannelGuideBar.A(GuildFeedJoinChannelGuideBar.this, i3, str5, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
            View.OnClickListener onClickListener = this.joinBtnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(clickedView);
            }
        }
    }

    public final void B(boolean hide) {
        I(hide);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).fetchGuestGuild(this.mGuildId, false, new s() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.l
            @Override // vh2.s
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo, List list) {
                GuildFeedJoinChannelGuideBar.C(GuildFeedJoinChannelGuideBar.this, i3, str, iGProGuildInfo, list);
            }
        });
    }

    public final void K(@NotNull String guildID, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, boolean forceShowBar) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "update guildID=" + guildID + " joinGuildSigStr=" + joinInfoParam);
        this.mGuildId = guildID;
        this.joinInfoParam = joinInfoParam;
        setVisibility(8);
        if (MiscKt.f(this.mGuildId)) {
            QLog.i("GuildFeedJoinChannelGuideBar", 1, "guildID empty");
        } else {
            GuildMainFrameUtils.k(this.mGuildId, new GuildFeedJoinChannelGuideBar$update$1(this, forceShowBar));
        }
    }

    public final void p(@NotNull View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.joinBtnClickListener = clickListener;
    }

    public final void q(@NotNull Function1<? super a, Unit> configCallback) {
        int i3;
        ConstraintLayout.LayoutParams layoutParams;
        ConstraintLayout.LayoutParams layoutParams2;
        ConstraintLayout.LayoutParams layoutParams3;
        boolean z16;
        Intrinsics.checkNotNullParameter(configCallback, "configCallback");
        configCallback.invoke(this.styleConfig);
        x12.c cVar = this.binding;
        x12.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        ViewGroup.LayoutParams layoutParams4 = cVar.f446888b.getLayoutParams();
        layoutParams4.height = this.styleConfig.getAvatarSize();
        layoutParams4.width = this.styleConfig.getAvatarSize();
        x12.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f446888b.setLayoutParams(layoutParams4);
        x12.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar4 = null;
        }
        ImageView imageView = cVar4.f446889c;
        if (this.styleConfig.getShowGuildIconTail()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        x12.c cVar5 = this.binding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar5 = null;
        }
        ViewGroup.LayoutParams layoutParams5 = cVar5.f446891e.getLayoutParams();
        if (layoutParams5 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams5;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setMarginStart(this.styleConfig.getAvatarTitleMargin());
        }
        x12.c cVar6 = this.binding;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar6 = null;
        }
        ViewGroup.LayoutParams layoutParams6 = cVar6.f446893g.getLayoutParams();
        if (layoutParams6 instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams6;
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = this.styleConfig.getAvatarTopMargin();
        }
        x12.c cVar7 = this.binding;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar7 = null;
        }
        cVar7.f446893g.setTextSize(this.styleConfig.getTitleSizeSp());
        x12.c cVar8 = this.binding;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar8 = null;
        }
        cVar8.f446893g.setTextColor(getResources().getColor(this.styleConfig.getTitleColorRes()));
        x12.c cVar9 = this.binding;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar9 = null;
        }
        ViewGroup.LayoutParams layoutParams7 = cVar9.f446896j.getLayoutParams();
        if (layoutParams7 instanceof ConstraintLayout.LayoutParams) {
            layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams7;
        } else {
            layoutParams3 = null;
        }
        if (layoutParams3 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = this.styleConfig.getSubTitleBottomMargin();
        }
        x12.c cVar10 = this.binding;
        if (cVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar10 = null;
        }
        cVar10.f446896j.setTextSize(this.styleConfig.getSubTitleSizeSp());
        x12.c cVar11 = this.binding;
        if (cVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar11 = null;
        }
        cVar11.f446896j.setTextColor(getResources().getColor(this.styleConfig.getSubTitleColorRes()));
        Integer valueOf = Integer.valueOf(this.styleConfig.getBtnTextViewBgRes());
        if (valueOf.intValue() != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            x12.c cVar12 = this.binding;
            if (cVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar12 = null;
            }
            cVar12.f446892f.setBackgroundResource(intValue);
        }
        x12.c cVar13 = this.binding;
        if (cVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar13 = null;
        }
        cVar13.f446892f.setTextColor(getResources().getColor(this.styleConfig.getBtnTextColorRes()));
        x12.c cVar14 = this.binding;
        if (cVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar14 = null;
        }
        cVar14.f446892f.setTextSize(this.styleConfig.getBtnTextSizeSp());
        x12.c cVar15 = this.binding;
        if (cVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar15 = null;
        }
        QUIButton qUIButton = cVar15.f446892f;
        ViewGroup.LayoutParams layoutParams8 = qUIButton.getLayoutParams();
        if (layoutParams8 != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams8, "layoutParams");
            layoutParams8.width = this.styleConfig.getJoinBtnWidth();
            layoutParams8.height = this.styleConfig.getJoinBtnHeight();
            qUIButton.setLayoutParams(layoutParams8);
        }
        x12.c cVar16 = this.binding;
        if (cVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar16;
        }
        cVar2.f446895i.setColorFilter(getResources().getColor(this.styleConfig.getRightArrowColorRes()));
        setPadding(this.styleConfig.getHorizontalPadding(), 0, this.styleConfig.getHorizontalPadding(), 0);
    }

    public final void setBgDrawable(@NotNull GradientDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setBackground(drawable);
    }

    public final void w() {
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "onAddObserver hashCode=" + hashCode());
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGProGlobalService) S0).addObserver(t());
    }

    public final void x(@NotNull String guildID) {
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        boolean z16 = true;
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "onCreate guildID=" + guildID);
        String str = this.mGuildId;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            this.mGuildId = guildID;
        }
    }

    public final void y() {
        QLog.i("GuildFeedJoinChannelGuideBar", 1, "onDeleteObserver hashCode=" + hashCode());
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGProGlobalService) S0).deleteObserver(t());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedJoinChannelGuideBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGuildId = "";
        this.styleConfig = new a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar$onlineMemberObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver r16;
                r16 = GuildFeedJoinChannelGuideBar.this.r();
                return r16;
            }
        });
        this.onlineMemberObserver = lazy;
        x12.c g16 = x12.c.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        x12.c cVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        final QUIButton qUIButton = g16.f446892f;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.guildJoinBtn");
        final long j3 = 200;
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar$special$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                qUIButton.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.z(it);
                final View view = qUIButton;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar$special$$inlined$setSingleClickListener$2.1
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
        x12.c cVar2 = this.binding;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar2;
        }
        QUIButton qUIButton2 = cVar.f446892f;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "binding.guildJoinBtn");
        yl1.b.d(bVar, qUIButton2, "em_sgrp_join_channel_btn", null, 4, null);
    }
}
