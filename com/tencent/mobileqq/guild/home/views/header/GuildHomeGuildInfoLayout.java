package com.tencent.mobileqq.guild.home.views.header;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.home.views.header.GuildHomeGuildInfoLayout;
import com.tencent.mobileqq.guild.mainframe.view.GuildChannelNameTextView;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildBannerTitleLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cp1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pr1.VisitorColorPicker;
import tl.h;
import vp1.bj;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 U2\u00020\u0001:\u0001VB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010N\u001a\u00020\u0006\u0012\u0006\u0010O\u001a\u00020\u0006\u00a2\u0006\u0004\bP\u0010QB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bP\u0010RB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bP\u0010SB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010N\u001a\u00020\u0006\u00a2\u0006\u0004\bP\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\bJ(\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0014J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00100R$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/GuildHomeGuildInfoLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "c", "", "height", "", "from", "j", "d", "p", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "b", "o", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfos", "l", DomainData.DOMAIN_NAME, h.F, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "f", "userNum", "e", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverBelow", "source", "k", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "mGuildInfo", "i", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "visitorColors", "g", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "guildIcon", "Landroid/view/View;", "Landroid/view/View;", "guildIconBackground", "Landroid/widget/Space;", "Landroid/widget/Space;", "getWindowAnchor", "()Landroid/widget/Space;", "setWindowAnchor", "(Landroid/widget/Space;)V", "windowAnchor", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildChannelNameTextView;", "titleView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "guildMemberNum", "Lcom/tencent/mobileqq/guild/widget/GuildBannerTitleLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/widget/GuildBannerTitleLayout;", "titleNameLayout", "D", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "E", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "G", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeGuildInfoLayout extends FrameLayout {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private GuildBannerTitleLayout titleNameLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private GuildFacadeType guildFacadeType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildHomeCoverBelowList coverBelow;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GuildHomeCoverColors visitorColors;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView guildIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View guildIconBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Space windowAnchor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildChannelNameTextView titleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView guildMemberNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/GuildHomeGuildInfoLayout$a;", "", "", "a", "()I", "HEAD_IMAGE_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.header.GuildHomeGuildInfoLayout$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return cx.a(60.0f);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeGuildInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.guildFacadeType = GuildFacadeType.Standalone;
    }

    private final int b(IGProGuildInfo guildInfo) {
        Integer num;
        String str;
        if (guildInfo != null) {
            num = Integer.valueOf(guildInfo.getCoverFontColorId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            str = "#222222";
        } else if (QQTheme.isNowThemeIsNight()) {
            str = "#E8E9EA";
        } else {
            str = "#FFFFFF";
        }
        return Color.parseColor(str);
    }

    private final void c(Context context) {
        bj g16 = bj.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        ConstraintLayout constraintLayout = g16.f442495c;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "guildHomeHeaderTitleBarBinding.container");
        this.container = constraintLayout;
        this.guildIcon = g16.f442496d;
        this.guildIconBackground = g16.f442497e;
        GuildChannelNameTextView guildChannelNameTextView = g16.f442499g;
        Intrinsics.checkNotNullExpressionValue(guildChannelNameTextView, "guildHomeHeaderTitleBarBinding.titleText");
        this.titleView = guildChannelNameTextView;
        GuildBannerTitleLayout guildBannerTitleLayout = g16.f442494b;
        Intrinsics.checkNotNullExpressionValue(guildBannerTitleLayout, "guildHomeHeaderTitleBarBinding.bannerTitleLayout");
        this.titleNameLayout = guildBannerTitleLayout;
        TextView textView = g16.f442498f;
        Intrinsics.checkNotNullExpressionValue(textView, "guildHomeHeaderTitleBarBinding.memberNum");
        this.guildMemberNum = textView;
        d();
    }

    private final void d() {
        Map mapOf;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_cover", 1));
        ch.T0(this, "em_sgrp_cover", clickPolicy, exposurePolicy, mapOf);
    }

    private final void h(IGProGuildInfo guildInfo) {
        ImageView imageView = this.guildIcon;
        if (imageView != null) {
            String avatarUrl = guildInfo.getAvatarUrl(100);
            Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_100)");
            v.l(avatarUrl, imageView, null, 4, null);
        }
    }

    private final void j(int height, String from) {
        Integer num;
        Logger.a d16 = Logger.f235387a.d();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            num = Integer.valueOf(layoutParams.height);
        } else {
            num = null;
        }
        d16.d("Guild.NewHome.GuildHomeGuildInfoLayout", 1, "headTitleInList updateHeight height:" + num + "->" + height + " from:" + from);
        if (getLayoutParams() == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, height));
        } else {
            getLayoutParams().height = height;
            getLayoutParams().width = -1;
        }
        invalidate();
    }

    private final void l(List<? extends IGProMedalInfo> medalInfos) {
        final ArrayList arrayList;
        boolean z16;
        GuildBannerTitleLayout guildBannerTitleLayout = this.titleNameLayout;
        GuildBannerTitleLayout guildBannerTitleLayout2 = null;
        if (guildBannerTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleNameLayout");
            guildBannerTitleLayout = null;
        }
        Iterator<View> it = ViewGroupKt.iterator(guildBannerTitleLayout);
        while (it.hasNext()) {
            if (it.next() instanceof ImageView) {
                it.remove();
            }
        }
        boolean z17 = false;
        if (medalInfos != null) {
            arrayList = new ArrayList();
            for (Object obj : medalInfos) {
                IGProMedalInfo iGProMedalInfo = (IGProMedalInfo) obj;
                if (iGProMedalInfo.getExpireTime() != 0 && iGProMedalInfo.getExpireTime() <= NetConnInfoCenter.getServerTime()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z17 = true;
        }
        if (z17) {
            return;
        }
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            IGProMedalInfo iGProMedalInfo2 = (IGProMedalInfo) it5.next();
            if (iGProMedalInfo2.getOfficialMedalInfoExt().getIsOffical()) {
                GuildBannerTitleLayout guildBannerTitleLayout3 = this.titleNameLayout;
                if (guildBannerTitleLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleNameLayout");
                    guildBannerTitleLayout3 = null;
                }
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildMedalUtils.e(guildBannerTitleLayout3, iGProMedalInfo2, context);
            }
        }
        GuildBannerTitleLayout guildBannerTitleLayout4 = this.titleNameLayout;
        if (guildBannerTitleLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleNameLayout");
        } else {
            guildBannerTitleLayout2 = guildBannerTitleLayout4;
        }
        guildBannerTitleLayout2.post(new Runnable() { // from class: gp1.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeGuildInfoLayout.m(arrayList, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(List list, GuildHomeGuildInfoLayout this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (((IGProMedalInfo) it.next()).getOfficialMedalInfoExt().getIsOffical()) {
                i3 = QQGuildUIUtil.f235395c;
            } else {
                i3 = QQGuildUIUtil.f235394b;
            }
            i16 = i16 + i3 + QQGuildUIUtil.f235396d;
        }
        GuildChannelNameTextView guildChannelNameTextView = this$0.titleView;
        if (guildChannelNameTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            guildChannelNameTextView = null;
        }
        CharSequence text = guildChannelNameTextView.getText();
        GuildChannelNameTextView guildChannelNameTextView2 = this$0.titleView;
        if (guildChannelNameTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            guildChannelNameTextView2 = null;
        }
        TextPaint paint = guildChannelNameTextView2.getPaint();
        GuildBannerTitleLayout guildBannerTitleLayout = this$0.titleNameLayout;
        if (guildBannerTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleNameLayout");
            guildBannerTitleLayout = null;
        }
        CharSequence ellipsize = TextUtils.ellipsize(text, paint, guildBannerTitleLayout.getMeasuredWidth() - i16, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(ellipsize, "null cannot be cast to non-null type kotlin.String");
        String str = (String) ellipsize;
        GuildChannelNameTextView guildChannelNameTextView3 = this$0.titleView;
        if (guildChannelNameTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            guildChannelNameTextView3 = null;
        }
        GuildChannelNameTextView.setTitleText$default(guildChannelNameTextView3, str, false, 2, null);
    }

    private final void n() {
        float f16;
        int a16;
        GuildChannelNameTextView guildChannelNameTextView = null;
        boolean z16 = false;
        if (this.visitorColors != null) {
            GuildChannelNameTextView guildChannelNameTextView2 = this.titleView;
            if (guildChannelNameTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
                guildChannelNameTextView2 = null;
            }
            GuildHomeCoverColors guildHomeCoverColors = this.visitorColors;
            if (guildHomeCoverColors != null) {
                a16 = guildHomeCoverColors.getGuildNameColor();
            } else {
                a16 = VisitorColorPicker.INSTANCE.a();
            }
            guildChannelNameTextView2.setTextColor(a16);
        } else {
            if (b(this.guildInfo) == 0) {
                z16 = true;
            }
            GuildChannelNameTextView guildChannelNameTextView3 = this.titleView;
            if (guildChannelNameTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
                guildChannelNameTextView3 = null;
            }
            guildChannelNameTextView3.setTextColor(b(this.guildInfo));
        }
        if (z16) {
            f16 = 4.0f;
        } else {
            f16 = 0.0f;
        }
        GuildChannelNameTextView guildChannelNameTextView4 = this.titleView;
        if (guildChannelNameTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            guildChannelNameTextView = guildChannelNameTextView4;
        }
        guildChannelNameTextView.setShadowLayer(f16, 0.0f, 0.0f, getResources().getColor(R.color.b9i));
    }

    private final void o(IGProGuildInfo guildInfo) {
        n();
        GuildChannelNameTextView guildChannelNameTextView = this.titleView;
        if (guildChannelNameTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            guildChannelNameTextView = null;
        }
        guildChannelNameTextView.setText(guildInfo.getGuildName());
        l(guildInfo.getMedalInfoList());
    }

    private final int p() {
        Space space = this.windowAnchor;
        if (space != null) {
            return space.getTop();
        }
        return 0;
    }

    public final void e(int userNum) {
        if (userNum > 0) {
            TextView textView = null;
            CharSequence b16 = c.b(c.f391536a, userNum, null, 2, null);
            TextView textView2 = this.guildMemberNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildMemberNum");
            } else {
                textView = textView2;
            }
            textView.setText(b16);
        }
    }

    public final void f(@NotNull GuildFacadeType guildFacadeType) {
        Intrinsics.checkNotNullParameter(guildFacadeType, "guildFacadeType");
        this.guildFacadeType = guildFacadeType;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        c(context);
    }

    public final void g(@NotNull GuildHomeCoverColors visitorColors) {
        Intrinsics.checkNotNullParameter(visitorColors, "visitorColors");
        if (Intrinsics.areEqual(visitorColors, this.visitorColors)) {
            QLog.i("Guild.NewHome.GuildHomeGuildInfoLayout", 1, "tintColor equal");
            return;
        }
        this.visitorColors = visitorColors;
        n();
        TextView textView = this.guildMemberNum;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildMemberNum");
            textView = null;
        }
        textView.setTextColor(visitorColors.getOnlineMemberColor());
    }

    public final void i(@NotNull IGProGuildInfo mGuildInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        if (this.coverBelow == null) {
            if (this.guildFacadeType != GuildFacadeType.GameCenter) {
                i3 = GuildHomeCoverBelowList.INSTANCE.a() - p();
            } else {
                i3 = -2;
            }
            j(i3, "init guild info");
        }
        this.guildInfo = mGuildInfo;
        o(mGuildInfo);
        h(mGuildInfo);
        e(mGuildInfo.getUserNum());
    }

    public final void k(@NotNull GuildHomeCoverBelowList coverBelow, @NotNull String source) {
        Intrinsics.checkNotNullParameter(coverBelow, "coverBelow");
        Intrinsics.checkNotNullParameter(source, "source");
        this.coverBelow = coverBelow;
        if (this.guildFacadeType == GuildFacadeType.GameCenter) {
            Logger.f235387a.d().d("Guild.NewHome.GuildHomeGuildInfoLayout", 1, "headTitleInList updateHeight ignore in GameCenter ");
        } else {
            j(GuildHomeCoverBelowList.INSTANCE.a() - p(), source);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        GuildHomeCoverBelowList guildHomeCoverBelowList = this.coverBelow;
        if (guildHomeCoverBelowList != null) {
            if (w3 != oldw || h16 != oldh) {
                Intrinsics.checkNotNull(guildHomeCoverBelowList);
                k(guildHomeCoverBelowList, MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED);
            }
        }
    }

    public final void setWindowAnchor(@Nullable Space space) {
        this.windowAnchor = space;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildHomeGuildInfoLayout(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildHomeGuildInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildHomeGuildInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
