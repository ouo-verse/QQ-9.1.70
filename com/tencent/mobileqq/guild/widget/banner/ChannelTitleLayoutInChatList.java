package com.tencent.mobileqq.guild.widget.banner;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.header.business.onlinemember.GuildOnlineMemberController;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.t;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.theme.SkinnableView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ab;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002WXB)\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\u0006\u0010O\u001a\u00020\u0019\u0012\u0006\u0010P\u001a\u00020\u0019\u00a2\u0006\u0004\bQ\u0010RB\u0011\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u00a2\u0006\u0004\bQ\u0010SB\u001b\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bQ\u0010TB#\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u0012\u0006\u0010O\u001a\u00020\u0019\u00a2\u0006\u0004\bQ\u0010UJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J0\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0014J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0014J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u0017\u00100\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010.\u001a\u0004\b'\u0010/R\u0014\u00103\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/ChannelTitleLayoutInChatList;", "Landroid/widget/FrameLayout;", "Lcom/tencent/theme/SkinnableView;", "Lcom/tencent/mobileqq/guild/util/t;", "", "g", "d", "Lcom/tencent/mobileqq/guild/widget/banner/ChannelTitleLayoutInChatList$b;", "uiState", "l", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfos", tl.h.F, "validMedalInfos", "j", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController;", "f", "Landroid/view/View$OnClickListener;", "listener", "setChildOnClickListener", "onThemeChanged", "k", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "requestLayout", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "e", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "titleView", "Lcom/tencent/mobileqq/guild/widget/GuildBannerTitleLayout;", "Lcom/tencent/mobileqq/guild/widget/GuildBannerTitleLayout;", "titleNameLayout", "Lvp1/ab;", "Lvp1/ab;", "()Lvp1/ab;", "binding", "i", "Landroid/widget/FrameLayout;", "moreBtnLayout", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "moreRedLayout", BdhLogUtil.LogTag.Tag_Conn, "shareLayout", "D", "Lcom/tencent/mobileqq/guild/widget/banner/ChannelTitleLayoutInChatList$b;", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "E", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/header/business/onlinemember/GuildOnlineMemberController;", "onlineMemberController", "", "G", "Ljava/lang/String;", "guildName", "Landroid/view/View$OnLayoutChangeListener;", "H", "Landroid/view/View$OnLayoutChangeListener;", "titleNameOnLayoutChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "I", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ChannelTitleLayoutInChatList extends FrameLayout implements SkinnableView, t {
    private static final int J = ViewUtils.dip2px(18.0f);
    private static final int K = ViewUtils.dip2px(14.0f);
    private static final int L = ViewUtils.dip2px(12.0f);
    private static final int M = ViewUtils.dip2px(6.0f);
    private static final int N = ViewUtils.dip2px(16.0f);
    private static final int P = ViewUtils.dip2px(20.0f);
    private static final int Q = ViewUtils.dip2px(23.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout shareLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b uiState;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildFacadeType guildFacadeType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GuildOnlineMemberController onlineMemberController;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String guildName;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View.OnLayoutChangeListener titleNameOnLayoutChangeListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildChannelNameTextView titleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildBannerTitleLayout titleNameLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab binding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout moreBtnLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View moreRedLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/ChannelTitleLayoutInChatList$b;", "", "Ln12/a;", "guildInfoProvider", "Ln12/a;", "a", "()Ln12/a;", "", "title", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfos", "Ljava/util/List;", "b", "()Ljava/util/List;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class b {
        @NotNull
        public final n12.a a() {
            throw null;
        }

        @Nullable
        public final List<IGProMedalInfo> b() {
            throw null;
        }

        @NotNull
        public final String c() {
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelTitleLayoutInChatList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        GuildFacadeType guildFacadeType = GuildFacadeType.ChatList;
        this.guildFacadeType = guildFacadeType;
        GuildOnlineMemberController guildOnlineMemberController = new GuildOnlineMemberController(GuildOnlineMemberController.PositionType.CHAT_TAB_HEADER, guildFacadeType);
        this.onlineMemberController = guildOnlineMemberController;
        this.guildName = "\u672a\u77e5\u9891\u9053";
        ab g16 = ab.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        LinearLayout linearLayout = g16.f442148i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.root");
        this.rootView = linearLayout;
        GuildChannelNameTextView guildChannelNameTextView = g16.f442152m;
        Intrinsics.checkNotNullExpressionValue(guildChannelNameTextView, "binding.titleTv");
        this.titleView = guildChannelNameTextView;
        GuildBannerTitleLayout guildBannerTitleLayout = g16.f442141b;
        Intrinsics.checkNotNullExpressionValue(guildBannerTitleLayout, "binding.guildBannerTitleLayout");
        this.titleNameLayout = guildBannerTitleLayout;
        FrameLayout frameLayout = g16.f442142c;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.infoBtn");
        this.moreBtnLayout = frameLayout;
        ImageView imageView = g16.f442145f;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.manageRedDot");
        this.moreRedLayout = imageView;
        FrameLayout frameLayout2 = g16.f442150k;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.shareLayout");
        this.shareLayout = frameLayout2;
        d();
        guildOnlineMemberController.d(this, guildFacadeType);
        g();
    }

    private final void d() {
        if (QQTheme.isVasTheme()) {
            int a16 = kotlin.g.a(Color.parseColor("#FFFFFF"), 10);
            this.binding.f442143d.setBackgroundColor(a16);
            this.binding.f442149j.setBackgroundColor(a16);
        } else {
            this.binding.f442143d.setBackgroundResource(R.drawable.guild_fill_light_tertiary_bg);
            this.binding.f442149j.setBackgroundResource(R.drawable.guild_fill_light_tertiary_bg);
        }
    }

    private final void g() {
        VideoReport.setElementId(this.moreBtnLayout, "em_sgrp_setting");
        VideoReport.setElementClickPolicy(this.moreBtnLayout, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.shareLayout, "em_sgrp_cover_share");
        VideoReport.setElementClickPolicy(this.shareLayout, ClickPolicy.REPORT_ALL);
    }

    private final void h(List<? extends IGProMedalInfo> medalInfos) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("TitleBarAboveBannerLayout", "updateMedalView -> medalInfos = " + medalInfos);
        }
        Iterator<View> it = ViewGroupKt.iterator(this.titleNameLayout);
        while (it.hasNext()) {
            if (it.next() instanceof ImageView) {
                it.remove();
            }
        }
        final List<? extends IGProMedalInfo> t16 = GuildMedalUtils.t(medalInfos, 0, 2, null);
        if (t16.isEmpty()) {
            return;
        }
        Iterator<? extends IGProMedalInfo> it5 = t16.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            IGProMedalInfo next = it5.next();
            if (next.getOfficialMedalInfoExt().getIsOffical()) {
                GuildBannerTitleLayout guildBannerTitleLayout = this.titleNameLayout;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildMedalUtils.h(guildBannerTitleLayout, next, context, null, 8, null);
                break;
            }
        }
        j(t16);
        View.OnLayoutChangeListener onLayoutChangeListener = this.titleNameOnLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            this.titleNameLayout.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        View.OnLayoutChangeListener onLayoutChangeListener2 = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.widget.banner.b
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                ChannelTitleLayoutInChatList.i(ChannelTitleLayoutInChatList.this, t16, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
        this.titleNameLayout.addOnLayoutChangeListener(onLayoutChangeListener2);
        this.titleNameOnLayoutChangeListener = onLayoutChangeListener2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ChannelTitleLayoutInChatList this$0, List validMedalInfos, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(validMedalInfos, "$validMedalInfos");
        if (i17 - i3 != i27 - i19) {
            this$0.j(validMedalInfos);
        }
    }

    private final void j(List<? extends IGProMedalInfo> validMedalInfos) {
        String str;
        n12.a a16;
        int i3;
        int i16 = 0;
        for (IGProMedalInfo iGProMedalInfo : validMedalInfos) {
            int i17 = i16 + QQGuildUIUtil.f235396d;
            if (iGProMedalInfo.getOfficialMedalInfoExt().getIsOffical()) {
                i3 = QQGuildUIUtil.f235395c;
            } else {
                i3 = QQGuildUIUtil.f235394b;
            }
            i16 = i17 + i3;
        }
        CharSequence ellipsize = TextUtils.ellipsize(this.guildName, this.titleView.getPaint(), this.titleNameLayout.getWidth() - i16, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(ellipsize, "null cannot be cast to non-null type kotlin.String");
        this.titleView.setTitleTextWithNetwork((String) ellipsize);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            b bVar = this.uiState;
            if (bVar != null && (a16 = bVar.a()) != null) {
                str = a16.getGuildId();
            } else {
                str = null;
            }
            d16.d("TitleBarAboveBannerLayout", 2, "updateMedalView guildId" + str + " medalInfos:" + validMedalInfos + ", titleNameLayout.width: " + this.titleNameLayout.getWidth());
        }
    }

    private final void l(b uiState) {
        if (QQGuildUIUtil.q() >= 428) {
            this.titleView.setTextSize(0, Q);
        } else {
            this.titleView.setTextSize(0, P);
        }
        String c16 = uiState.c();
        this.guildName = c16;
        this.titleView.setText(c16);
        h(uiState.b());
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ab getBinding() {
        return this.binding;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final GuildOnlineMemberController getOnlineMemberController() {
        return this.onlineMemberController;
    }

    public final void k() {
        b bVar = this.uiState;
        if (bVar == null) {
            return;
        }
        l(bVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("TitleBarAboveBannerLayout", "onLayout: changed[" + changed + "] left[" + left + "] top[" + top + "] right[" + right + "] bottom[" + bottom + "]");
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("TitleBarAboveBannerLayout", "onMeasure: measuredWidth[" + getMeasuredWidth() + "] measuredHeight[" + getMeasuredHeight() + "]");
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        d();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("TitleBarAboveBannerLayout", "requestLayout");
        }
    }

    public final void setChildOnClickListener(@Nullable View.OnClickListener listener) {
        this.moreBtnLayout.setOnClickListener(listener);
        this.shareLayout.setOnClickListener(listener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelTitleLayoutInChatList(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelTitleLayoutInChatList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelTitleLayoutInChatList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
