package com.tencent.mobileqq.guild.homev2.parts;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0018\u0010$\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0013R\u0018\u0010,\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0017R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001dR\u0018\u00104\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0013R\u0018\u00106\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001dR\u0018\u00108\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001dR\u0018\u0010:\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001dR\u0018\u0010<\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u0013R\u0018\u0010>\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u001dR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/GuildHomeV2VisitorInvisiblePart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "", VasPerfReportUtils.WHILE_UPDATE_ITEM, "initData", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "ua", "ra", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "sa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "e", "Landroid/view/View;", TtmlNode.TAG_LAYOUT, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "welcomeIcon", tl.h.F, "welcomeTitle", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "inviterTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "welcomeTitleTv", BdhLogUtil.LogTag.Tag_Conn, "welcomeTips", "D", "welcomeTipsTv", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "E", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "contentViewWrapper", UserInfo.SEX_FEMALE, "contentView", "G", "guildCoverIv", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "guildMetalContainer", "I", "guildNameTv", "J", "spacingView", "K", "memberNumTv", "L", "feedNumTv", "M", "guildDescTv", "N", "guildJoinBtn", "P", "tvGuildStrNumber", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "guildNumber", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2VisitorInvisiblePart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View welcomeTips;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView welcomeTipsTv;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ShadowFrameLayout contentViewWrapper;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView guildCoverIv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout guildMetalContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView guildNameTv;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View spacingView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView memberNumTv;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView feedNumTv;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView guildDescTv;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View guildJoinBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView tvGuildStrNumber;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String guildNumber = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View layout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView welcomeIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View welcomeTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView inviterTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView welcomeTitleTv;

    private final void initData() {
        LiveData asLiveData$default = FlowLiveDataConversions.asLiveData$default(C9().P1(), (CoroutineContext) null, 0L, 3, (Object) null);
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final GuildHomeV2VisitorInvisiblePart$initData$1 guildHomeV2VisitorInvisiblePart$initData$1 = new GuildHomeV2VisitorInvisiblePart$initData$1(this);
        asLiveData$default.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2VisitorInvisiblePart.ta(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        Map mapOf;
        View view = this.guildJoinBtn;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_visitor_type", 0));
        ch.U0(view, "em_sgrp_bottom_join_channel", mapOf);
    }

    private final List<IGProMedalInfo> sa(IGProGuildInfo guildInfo) {
        boolean z16;
        boolean z17;
        List<IGProMedalInfo> emptyList;
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        if (medalInfoList != null && !medalInfoList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList arrayList = new ArrayList();
        for (Object obj : medalInfoList) {
            long expireTime = ((IGProMedalInfo) obj).getExpireTime();
            if (1 <= expireTime && expireTime < serverTime) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                arrayList.add(obj);
            }
        }
        return medalInfoList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(IGProGuildInfo guildInfo) {
        LinearLayout linearLayout = this.guildMetalContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            for (IGProMedalInfo iGProMedalInfo : sa(guildInfo)) {
                if (iGProMedalInfo.getOfficialMedalInfoExt().getIsOffical()) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    GuildMedalUtils.i(linearLayout, iGProMedalInfo, context);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView() {
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        int i17;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i18;
        int i19;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int i26;
        int i27;
        int i28;
        ViewGroup.MarginLayoutParams marginLayoutParams4;
        int i29;
        int i36;
        ViewGroup.MarginLayoutParams marginLayoutParams5;
        int i37;
        int i38;
        ViewGroup.MarginLayoutParams marginLayoutParams6;
        int i39;
        int i46;
        ViewGroup.MarginLayoutParams marginLayoutParams7;
        int i47;
        int i48;
        int i49 = x.f(getContext()).f185860a;
        int i56 = x.f(getContext()).f185861b;
        if (i49 > ViewUtils.dip2px(428.0f)) {
            ShadowFrameLayout shadowFrameLayout = this.contentViewWrapper;
            if (shadowFrameLayout != null) {
                ViewGroup.LayoutParams layoutParams = shadowFrameLayout.getLayoutParams();
                layoutParams.width = ViewUtils.dip2px(356.0f);
                shadowFrameLayout.setLayoutParams(layoutParams);
            }
            View view = this.guildJoinBtn;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = ViewUtils.dip2px(348.0f);
                view.setLayoutParams(layoutParams2);
            }
        } else {
            ShadowFrameLayout shadowFrameLayout2 = this.contentViewWrapper;
            if (shadowFrameLayout2 != null) {
                ViewGroup.LayoutParams layoutParams3 = shadowFrameLayout2.getLayoutParams();
                layoutParams3.width = -1;
                shadowFrameLayout2.setLayoutParams(layoutParams3);
            }
            View view2 = this.guildJoinBtn;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams4 = view2.getLayoutParams();
                layoutParams4.width = -1;
                view2.setLayoutParams(layoutParams4);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams8 = null;
        int i57 = -2;
        if (i56 < ViewUtils.dip2px(820.0f)) {
            View view3 = this.welcomeTitle;
            if (view3 != null) {
                int dip2px = ViewUtils.dip2px(96.0f);
                ViewGroup.LayoutParams layoutParams5 = view3.getLayoutParams();
                if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams5;
                } else {
                    marginLayoutParams7 = null;
                }
                if (marginLayoutParams7 == null) {
                    ViewGroup.LayoutParams layoutParams6 = view3.getLayoutParams();
                    if (layoutParams6 != null) {
                        i47 = layoutParams6.width;
                    } else {
                        i47 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams7 = view3.getLayoutParams();
                    if (layoutParams7 != null) {
                        i48 = layoutParams7.height;
                    } else {
                        i48 = -2;
                    }
                    marginLayoutParams7 = new ViewGroup.MarginLayoutParams(i47, i48);
                }
                marginLayoutParams7.topMargin = dip2px;
                view3.setLayoutParams(marginLayoutParams7);
            }
            View view4 = this.welcomeTips;
            if (view4 != null) {
                int dip2px2 = ViewUtils.dip2px(4.0f);
                ViewGroup.LayoutParams layoutParams8 = view4.getLayoutParams();
                if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams8;
                } else {
                    marginLayoutParams6 = null;
                }
                if (marginLayoutParams6 == null) {
                    ViewGroup.LayoutParams layoutParams9 = view4.getLayoutParams();
                    if (layoutParams9 != null) {
                        i39 = layoutParams9.width;
                    } else {
                        i39 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams10 = view4.getLayoutParams();
                    if (layoutParams10 != null) {
                        i46 = layoutParams10.height;
                    } else {
                        i46 = -2;
                    }
                    marginLayoutParams6 = new ViewGroup.MarginLayoutParams(i39, i46);
                }
                marginLayoutParams6.topMargin = dip2px2;
                view4.setLayoutParams(marginLayoutParams6);
            }
            ShadowFrameLayout shadowFrameLayout3 = this.contentViewWrapper;
            if (shadowFrameLayout3 != null) {
                int dip2px3 = ViewUtils.dip2px(16.0f);
                ViewGroup.LayoutParams layoutParams11 = shadowFrameLayout3.getLayoutParams();
                if (layoutParams11 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams11;
                } else {
                    marginLayoutParams5 = null;
                }
                if (marginLayoutParams5 == null) {
                    ViewGroup.LayoutParams layoutParams12 = shadowFrameLayout3.getLayoutParams();
                    if (layoutParams12 != null) {
                        i37 = layoutParams12.width;
                    } else {
                        i37 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams13 = shadowFrameLayout3.getLayoutParams();
                    if (layoutParams13 != null) {
                        i38 = layoutParams13.height;
                    } else {
                        i38 = -2;
                    }
                    marginLayoutParams5 = new ViewGroup.MarginLayoutParams(i37, i38);
                }
                marginLayoutParams5.topMargin = dip2px3;
                shadowFrameLayout3.setLayoutParams(marginLayoutParams5);
            }
            View view5 = this.contentView;
            if (view5 != null) {
                ViewExtKt.f(view5, ViewUtils.dip2px(36.0f));
            }
            View view6 = this.contentView;
            if (view6 != null) {
                ViewExtKt.c(view6, ViewUtils.dip2px(36.0f));
            }
            ImageView imageView = this.guildCoverIv;
            if (imageView != null) {
                kotlin.h.g(imageView, ViewUtils.dip2px(80.0f), ViewUtils.dip2px(80.0f));
            }
            View view7 = this.spacingView;
            if (view7 != null) {
                kotlin.h.f(view7, ViewUtils.dip2px(24.0f));
            }
            TextView textView = this.guildDescTv;
            if (textView != null) {
                int dip2px4 = ViewUtils.dip2px(12.0f);
                ViewGroup.LayoutParams layoutParams14 = textView.getLayoutParams();
                if (layoutParams14 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams14;
                } else {
                    marginLayoutParams4 = null;
                }
                if (marginLayoutParams4 == null) {
                    ViewGroup.LayoutParams layoutParams15 = textView.getLayoutParams();
                    if (layoutParams15 != null) {
                        i29 = layoutParams15.width;
                    } else {
                        i29 = -2;
                    }
                    ViewGroup.LayoutParams layoutParams16 = textView.getLayoutParams();
                    if (layoutParams16 != null) {
                        i36 = layoutParams16.height;
                    } else {
                        i36 = -2;
                    }
                    marginLayoutParams4 = new ViewGroup.MarginLayoutParams(i29, i36);
                }
                marginLayoutParams4.topMargin = dip2px4;
                textView.setLayoutParams(marginLayoutParams4);
            }
            if (i56 < ViewUtils.dip2px(663.0f)) {
                TextView textView2 = this.guildDescTv;
                if (textView2 != null) {
                    int dip2px5 = ViewUtils.dip2px(0.0f);
                    ViewGroup.LayoutParams layoutParams17 = textView2.getLayoutParams();
                    if (layoutParams17 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams17;
                    }
                    if (marginLayoutParams8 == null) {
                        ViewGroup.LayoutParams layoutParams18 = textView2.getLayoutParams();
                        if (layoutParams18 != null) {
                            i28 = layoutParams18.width;
                        } else {
                            i28 = -2;
                        }
                        ViewGroup.LayoutParams layoutParams19 = textView2.getLayoutParams();
                        if (layoutParams19 != null) {
                            i57 = layoutParams19.height;
                        }
                        marginLayoutParams8 = new ViewGroup.MarginLayoutParams(i28, i57);
                    }
                    marginLayoutParams8.topMargin = dip2px5;
                    textView2.setLayoutParams(marginLayoutParams8);
                }
                TextView textView3 = this.guildDescTv;
                if (textView3 != null) {
                    textView3.setMaxLines(0);
                    return;
                }
                return;
            }
            if (i56 < ViewUtils.dip2px(687.0f)) {
                TextView textView4 = this.guildDescTv;
                if (textView4 != null) {
                    textView4.setMaxLines(1);
                    return;
                }
                return;
            }
            if (i56 < ViewUtils.dip2px(711.0f)) {
                TextView textView5 = this.guildDescTv;
                if (textView5 != null) {
                    textView5.setMaxLines(2);
                    return;
                }
                return;
            }
            TextView textView6 = this.guildDescTv;
            if (textView6 != null) {
                textView6.setMaxLines(3);
                return;
            }
            return;
        }
        View view8 = this.welcomeTitle;
        if (view8 != null) {
            int dip2px6 = ViewUtils.dip2px(148.0f);
            ViewGroup.LayoutParams layoutParams20 = view8.getLayoutParams();
            if (layoutParams20 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams20;
            } else {
                marginLayoutParams3 = null;
            }
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams21 = view8.getLayoutParams();
                if (layoutParams21 != null) {
                    i26 = layoutParams21.width;
                } else {
                    i26 = -2;
                }
                ViewGroup.LayoutParams layoutParams22 = view8.getLayoutParams();
                if (layoutParams22 != null) {
                    i27 = layoutParams22.height;
                } else {
                    i27 = -2;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i26, i27);
            }
            marginLayoutParams3.topMargin = dip2px6;
            view8.setLayoutParams(marginLayoutParams3);
        }
        View view9 = this.welcomeTips;
        if (view9 != null) {
            int dip2px7 = ViewUtils.dip2px(8.0f);
            ViewGroup.LayoutParams layoutParams23 = view9.getLayoutParams();
            if (layoutParams23 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams23;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams24 = view9.getLayoutParams();
                if (layoutParams24 != null) {
                    i18 = layoutParams24.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams25 = view9.getLayoutParams();
                if (layoutParams25 != null) {
                    i19 = layoutParams25.height;
                } else {
                    i19 = -2;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            marginLayoutParams2.topMargin = dip2px7;
            view9.setLayoutParams(marginLayoutParams2);
        }
        ShadowFrameLayout shadowFrameLayout4 = this.contentViewWrapper;
        if (shadowFrameLayout4 != null) {
            int dip2px8 = ViewUtils.dip2px(24.0f);
            ViewGroup.LayoutParams layoutParams26 = shadowFrameLayout4.getLayoutParams();
            if (layoutParams26 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams26;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams27 = shadowFrameLayout4.getLayoutParams();
                if (layoutParams27 != null) {
                    i16 = layoutParams27.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams28 = shadowFrameLayout4.getLayoutParams();
                if (layoutParams28 != null) {
                    i17 = layoutParams28.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            marginLayoutParams.topMargin = dip2px8;
            shadowFrameLayout4.setLayoutParams(marginLayoutParams);
        }
        View view10 = this.contentView;
        if (view10 != null) {
            ViewExtKt.f(view10, ViewUtils.dip2px(54.0f));
        }
        View view11 = this.contentView;
        if (view11 != null) {
            ViewExtKt.c(view11, ViewUtils.dip2px(54.0f));
        }
        ImageView imageView2 = this.guildCoverIv;
        if (imageView2 != null) {
            kotlin.h.g(imageView2, ViewUtils.dip2px(108.0f), ViewUtils.dip2px(108.0f));
        }
        View view12 = this.spacingView;
        if (view12 != null) {
            kotlin.h.f(view12, ViewUtils.dip2px(28.0f));
        }
        TextView textView7 = this.guildDescTv;
        if (textView7 != null) {
            int dip2px9 = ViewUtils.dip2px(16.0f);
            ViewGroup.LayoutParams layoutParams29 = textView7.getLayoutParams();
            if (layoutParams29 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams29;
            }
            if (marginLayoutParams8 == null) {
                ViewGroup.LayoutParams layoutParams30 = textView7.getLayoutParams();
                if (layoutParams30 != null) {
                    i3 = layoutParams30.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams31 = textView7.getLayoutParams();
                if (layoutParams31 != null) {
                    i57 = layoutParams31.height;
                }
                marginLayoutParams8 = new ViewGroup.MarginLayoutParams(i3, i57);
            }
            marginLayoutParams8.topMargin = dip2px9;
            textView7.setLayoutParams(marginLayoutParams8);
        }
        TextView textView8 = this.guildDescTv;
        if (textView8 != null) {
            textView8.setMaxLines(3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateView();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initData();
    }
}
