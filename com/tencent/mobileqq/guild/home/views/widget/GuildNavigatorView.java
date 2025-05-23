package com.tencent.mobileqq.guild.home.views.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableKt;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.home.views.widget.GuildNavigatorView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ps1.a;
import tl.h;
import vp1.ci;
import vp1.cj;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\u00020\u0001:\u0001QB\u0013\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u00a2\u0006\u0004\bG\u0010HB\u001d\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u00a2\u0006\u0004\bG\u0010KB%\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010L\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010MB-\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010L\u001a\u00020\u0002\u0012\u0006\u0010N\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010OJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00107\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u0016\u0010:\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00100R\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00100R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010>R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;", "Landroid/widget/GridLayout;", "", "navigationBarColor", "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "", "radius", "w", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "fromAni", "J", "expandView", "y", "childView", "index", BdhLogUtil.LogTag.Tag_Conn, "totalSize", "Landroid/animation/Animator;", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationInfo;", "navigationInfo", "u", "listSize", "v", "itemIndex", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "", "", "r", "I", "H", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getUpdateExpandStatus", "()Lkotlin/jvm/functions/Function0;", "setUpdateExpandStatus", "(Lkotlin/jvm/functions/Function0;)V", "updateExpandStatus", "e", "Z", "getNeedPlaceholder", "()Z", "setNeedPlaceholder", "(Z)V", "needPlaceholder", "f", "isNeedHandleItemClick", "setNeedHandleItemClick", h.F, "preExpandStatus", "i", "preEmpty", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "guildHomeHeaderNavigationBar", "getNavigatorIconInItemSize", "()I", "setNavigatorIconInItemSize", "(I)V", "navigatorIconInItemSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNavigatorView extends GridLayout {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int E = QQGuildUIUtil.f(56.0f);
    private static final int F = QQGuildUIUtil.f(20.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private int navigatorIconInItemSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> updateExpandStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needPlaceholder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedHandleItemClick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean preExpandStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean preEmpty;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<GuildHomeHeaderNavigationBar> guildHomeHeaderNavigationBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView$a;", "", "", "NAVIGATOR_ONE_ROW_HEIGHT", "I", "a", "()I", "", "DT_IDENTIFIER_ACTION_BTN_PREFIX", "Ljava/lang/String;", "DT_IDENTIFIER_NORMAL_BTN_PREFIX", "DT_OTHER_BAR_CLOSE", "DT_OTHER_BAR_EXPAND", "NAVIGATOR_EXPAND_NUM", "NAVIGATOR_ONE_ROW_SIZE", "NAVIGATOR_UNEXPAND_NUM", "TAG", "", "THREE_ROW_ANIMATOR_DURATION", "J", "THREE_ROW_ANIM_DELAY_TIME", "TWO_ROW_ANIMATOR_DURATION", "TWO_ROW_ANIM_DELAY_TIME", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.widget.GuildNavigatorView$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildNavigatorView.E;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "", "isReverse", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildHomeHeaderNavigationBar f225712d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildNavigatorView f225713e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f225714f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f225715h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f225716i;

        b(GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar, GuildNavigatorView guildNavigatorView, View view, View view2, View view3) {
            this.f225712d = guildHomeHeaderNavigationBar;
            this.f225713e = guildNavigatorView;
            this.f225714f = view;
            this.f225715h = view2;
            this.f225716i = view3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            if (this.f225712d.getIsExpand()) {
                GuildNavigatorView.D(this.f225713e, this.f225714f, this.f225712d, 4, false, 8, null);
            } else {
                GuildNavigatorView.z(this.f225713e, this.f225714f, this.f225712d, false, 4, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            if (this.f225712d.getIsExpand()) {
                this.f225713e.C(this.f225714f, this.f225712d, 4, true);
            } else {
                this.f225713e.y(this.f225714f, this.f225712d, true);
            }
            this.f225715h.setVisibility(0);
            this.f225716i.setVisibility(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f225717a;

        c(float f16) {
            this.f225717a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null) {
                float f16 = this.f225717a;
                if (outline != null) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(f16));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnCancel$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeHeaderNavigationBar f225721e;

        public e(GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar) {
            this.f225721e = guildHomeHeaderNavigationBar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            GuildNavigatorView.K(GuildNavigatorView.this, this.f225721e, false, 2, null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeHeaderNavigationBar f225723e;

        public f(GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar) {
            this.f225723e = guildHomeHeaderNavigationBar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            GuildNavigatorView.K(GuildNavigatorView.this, this.f225723e, false, 2, null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    public GuildNavigatorView(@Nullable Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(GuildNavigatorView this$0, View view) {
        Function0<Unit> function0;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard") && (function0 = this$0.updateExpandStatus) != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View expandView, GuildHomeHeaderNavigationBar item, Map dtMap) {
        Intrinsics.checkNotNullParameter(expandView, "$expandView");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(dtMap, "$dtMap");
        VideoReport.setElementReuseIdentifier(expandView, "action_" + item.getIsExpand() + "_" + item.getGuildId());
        ch.W0(expandView, "em_sgrp_navigation_bar", dtMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final View childView, final GuildHomeHeaderNavigationBar item, final int index, boolean fromAni) {
        final IGProNavigationInfo iGProNavigationInfo = item.k().get(index);
        View findViewById = childView.findViewById(R.id.f107006_9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "childView.findViewById(R.id.tv_config_name)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = childView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "childView.findViewById(R.id.iv_avatar)");
        ImageView imageView = (ImageView) findViewById2;
        View findViewById3 = childView.findViewById(R.id.uy8);
        View findViewById4 = childView.findViewById(R.id.uya);
        imageView.setVisibility(0);
        textView.setVisibility(0);
        if (!fromAni) {
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            if (findViewById4 != null) {
                findViewById4.setVisibility(8);
            }
        }
        textView.setText(iGProNavigationInfo.getTitle());
        textView.setContentDescription(iGProNavigationInfo.getTitle());
        textView.setTextColor(item.getTintColors().getNavigationBarColor());
        final WeakReference weakReference = new WeakReference(imageView);
        final WeakReference weakReference2 = new WeakReference(item);
        v.f(iGProNavigationInfo.getIconUrl(), imageView.getWidth(), imageView.getHeight(), new GuildLevelRoleView.a() { // from class: kp1.d
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                GuildNavigatorView.G(WeakReference.this, this, weakReference, bitmap);
            }
        });
        childView.setOnClickListener(new View.OnClickListener() { // from class: kp1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNavigatorView.E(GuildNavigatorView.this, iGProNavigationInfo, childView, index, view);
            }
        });
        childView.post(new Runnable() { // from class: kp1.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildNavigatorView.F(index, item, childView, this, iGProNavigationInfo);
            }
        });
    }

    static /* synthetic */ void D(GuildNavigatorView guildNavigatorView, View view, GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        guildNavigatorView.C(view, guildHomeHeaderNavigationBar, i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(GuildNavigatorView this$0, IGProNavigationInfo navigationInfo, View childView, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navigationInfo, "$navigationInfo");
        Intrinsics.checkNotNullParameter(childView, "$childView");
        if (!o.c("fastClickGuard")) {
            this$0.u(navigationInfo, childView, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(int i3, GuildHomeHeaderNavigationBar item, View childView, GuildNavigatorView this$0, IGProNavigationInfo navigationInfo) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(childView, "$childView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navigationInfo, "$navigationInfo");
        VideoReport.setElementReuseIdentifier(childView, "normal_" + i3 + "_" + item.getGuildId());
        VideoReport.setElementParams(childView, this$0.r(navigationInfo, i3));
        VideoReport.setElementEndExposePolicy(childView, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(childView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(childView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(childView, ExposurePolicy.REPORT_ALL);
        if (item.getIsNeedReportImpEvent()) {
            VideoReport.setElementId(childView, "em_sgrp_navigation_bar");
        } else {
            VideoReport.setElementIdNotBizReady(childView, "em_sgrp_navigation_bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(WeakReference weakItem, GuildNavigatorView this$0, WeakReference weakIvAvatar, Bitmap bitmap) {
        GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar;
        Intrinsics.checkNotNullParameter(weakItem, "$weakItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weakIvAvatar, "$weakIvAvatar");
        if (weakItem.get() != 0) {
            T t16 = weakItem.get();
            WeakReference<GuildHomeHeaderNavigationBar> weakReference = this$0.guildHomeHeaderNavigationBar;
            Resources resources = null;
            if (weakReference != null) {
                guildHomeHeaderNavigationBar = weakReference.get();
            } else {
                guildHomeHeaderNavigationBar = null;
            }
            if (Intrinsics.areEqual(t16, guildHomeHeaderNavigationBar) && weakIvAvatar.get() != 0) {
                ImageView imageView = (ImageView) weakIvAvatar.get();
                if (imageView != null) {
                    resources = imageView.getResources();
                }
                SkinnableBitmapDrawable skinnableBitmapDrawable = new SkinnableBitmapDrawable(resources, bitmap);
                skinnableBitmapDrawable.mutate2();
                GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar2 = (GuildHomeHeaderNavigationBar) weakItem.get();
                if (guildHomeHeaderNavigationBar2 != null) {
                    skinnableBitmapDrawable.setColorFilter(new PorterDuffColorFilter(guildHomeHeaderNavigationBar2.getTintColors().getNavigationBarColor(), PorterDuff.Mode.SRC_IN));
                }
                ImageView imageView2 = (ImageView) weakIvAvatar.get();
                if (imageView2 != null) {
                    imageView2.setImageDrawable(skinnableBitmapDrawable);
                }
            }
        }
    }

    private final void J(GuildHomeHeaderNavigationBar item, boolean fromAni) {
        int i3;
        List take;
        setVisibility(0);
        if (!item.getIsExpand()) {
            if (item.k().size() == 5) {
                i3 = 5;
            } else {
                i3 = 4;
            }
        } else {
            i3 = 14;
        }
        take = CollectionsKt___CollectionsKt.take(item.k(), i3);
        v(take.size(), item.getTintColors().getNavigationBarColor());
        int size = take.size();
        for (int i16 = 0; i16 < size; i16++) {
            if (i16 != 4 || !fromAni) {
                View childView = getChildAt(i16);
                Intrinsics.checkNotNullExpressionValue(childView, "childView");
                D(this, childView, item, i16, false, 8, null);
            }
        }
        if (item.k().size() > 5) {
            View l3 = l(take.size());
            z(this, l3, item, false, 4, null);
            addView(l3);
        }
        VideoReport.traversePage(this);
    }

    static /* synthetic */ void K(GuildNavigatorView guildNavigatorView, GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildNavigatorView.J(guildHomeHeaderNavigationBar, z16);
    }

    private final View l(int itemIndex) {
        ci g16 = ci.g(LayoutInflater.from(getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = 0;
        layoutParams.height = ViewUtils.dip2px(56.0f);
        layoutParams.setGravity(7);
        layoutParams.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
        layoutParams.rowSpec = GridLayout.spec(Integer.MIN_VALUE);
        if (itemIndex >= 5) {
            layoutParams.topMargin = F;
        }
        g16.getRoot().setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = g16.f442711d.getLayoutParams();
        int i3 = this.navigatorIconInItemSize;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        g16.f442711d.setLayoutParams(layoutParams2);
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    private final View m(int navigationBarColor) {
        vp1.ch g16 = vp1.ch.g(LayoutInflater.from(getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        int a16 = g.a(navigationBarColor, 4);
        View view = g16.f442706b;
        Intrinsics.checkNotNullExpressionValue(view, "binding.ivEmptyPlaceholder");
        w(view, 6.15f);
        View view2 = g16.f442707c;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.tvEmptyPlaceholder");
        w(view2, 3.0f);
        g16.f442706b.setBackground(new ColorDrawable(a16));
        g16.f442707c.setBackground(new ColorDrawable(a16));
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = 0;
        layoutParams.height = ViewUtils.dip2px(56.0f);
        layoutParams.setGravity(7);
        layoutParams.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
        layoutParams.rowSpec = GridLayout.spec(Integer.MIN_VALUE);
        g16.getRoot().setLayoutParams(layoutParams);
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final View n(int navigationBarColor) {
        cj g16 = cj.g(LayoutInflater.from(getContext()), null, false);
        g16.f442715c.setColorFilter(new PorterDuffColorFilter(navigationBarColor, PorterDuff.Mode.SRC_IN));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026ff.Mode.SRC_IN)\n        }");
        g16.getRoot().setLayoutParams(new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(-1, -2)));
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, java.lang.Object] */
    private final Animator o(GuildHomeHeaderNavigationBar item) {
        final ImageView imageView;
        final TextView textView;
        long j3;
        long j16;
        View childAt = getChildAt(4);
        if (childAt == null) {
            return new AnimatorSet();
        }
        View findViewById = childAt.findViewById(R.id.f107006_9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "buttonView.findViewById(R.id.tv_config_name)");
        final TextView textView2 = (TextView) findViewById;
        View findViewById2 = childAt.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "buttonView.findViewById(R.id.iv_avatar)");
        final ImageView imageView2 = (ImageView) findViewById2;
        ?? findViewById3 = childAt.findViewById(R.id.uy8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "buttonView.findViewById(R.id.expand_button)");
        ?? findViewById4 = childAt.findViewById(R.id.uya);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "buttonView.findViewById(R.id.expand_text)");
        if (item.getIsExpand()) {
            textView = textView2;
            imageView = imageView2;
            imageView2 = findViewById3;
            textView2 = findViewById4;
        } else {
            imageView = findViewById3;
            textView = findViewById4;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (item.k().size() > 10) {
            j3 = 150;
        } else {
            j3 = 112;
        }
        ofFloat.setDuration(j3);
        ofFloat2.setDuration(j3);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: kp1.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildNavigatorView.p(imageView2, textView2, valueAnimator);
            }
        });
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: kp1.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildNavigatorView.q(imageView, textView, valueAnimator);
            }
        });
        ofFloat2.addListener(new b(item, this, childAt, imageView, textView));
        AnimatorSet animatorSet = new AnimatorSet();
        if (item.k().size() > 10) {
            j16 = 50;
        } else {
            j16 = 37;
        }
        ofFloat2.setStartDelay(j16);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View preImageView, View preTextView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(preImageView, "$preImageView");
        Intrinsics.checkNotNullParameter(preTextView, "$preTextView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        preImageView.setAlpha(floatValue);
        preTextView.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View afterImageView, View afterTextView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(afterImageView, "$afterImageView");
        Intrinsics.checkNotNullParameter(afterTextView, "$afterTextView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        afterImageView.setAlpha(floatValue);
        afterTextView.setAlpha(floatValue);
    }

    private final Map<String, Object> r(IGProNavigationInfo navigationInfo, int index) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_navigation_bar_type", navigationInfo.getTitle()), TuplesKt.to("sgrp_navigation_url", navigationInfo.getJumpUrl()), TuplesKt.to("sgrp_rank", Integer.valueOf(index)));
        return mapOf;
    }

    private final Animator s(int totalSize) {
        int i3;
        int i16;
        int i17;
        int i18 = getLayoutParams().height;
        if (totalSize <= 5) {
            i17 = E;
        } else {
            if (totalSize <= 10) {
                i3 = E * 2;
                i16 = F;
            } else {
                i3 = E * 3;
                i16 = F * 2;
            }
            i17 = i3 + i16;
        }
        QLog.i("Guild.NewHome.GuildNavigatorView", 1, "playAnimIfNeed child: " + totalSize + " " + i18 + " " + i17 + " ");
        ValueAnimator animator = ValueAnimator.ofInt(i18, i17);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: kp1.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildNavigatorView.t(GuildNavigatorView.this, valueAnimator);
            }
        });
        if (totalSize < 10) {
            he0.b.l(animator, R.anim.f154977uk);
        } else {
            he0.b.l(animator, R.anim.f154978ul);
        }
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildNavigatorView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.getLayoutParams().height = ((Integer) animatedValue).intValue();
        this$0.requestLayout();
    }

    private final void u(IGProNavigationInfo navigationInfo, View childView, int index) {
        QLog.i("Guild.NewHome.GuildNavigatorView", 1, "onClickItem: click, navigationInfo: " + navigationInfo);
        if (!this.isNeedHandleItemClick) {
            return;
        }
        Context context = childView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "childView.context");
        int jumpUrlType = navigationInfo.getJumpUrlType();
        String jumpUrl = navigationInfo.getJumpUrl();
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "navigationInfo.jumpUrl");
        a.a(context, jumpUrlType, jumpUrl);
        ChannelSettingUtils.i(childView, "em_sgrp_navigation_bar", r(navigationInfo, index));
    }

    private final void v(int listSize, int navigationBarColor) {
        int i3;
        int childCount = getChildCount();
        if (listSize == childCount) {
            return;
        }
        if (listSize == 1) {
            removeAllViews();
            addView(n(navigationBarColor));
            return;
        }
        if (childCount > listSize) {
            int i16 = listSize + 1;
            if (i16 <= childCount) {
                int i17 = childCount;
                while (true) {
                    int i18 = i17 - 1;
                    removeViewAt(i18);
                    QLog.i("Guild.NewHome.GuildNavigatorView", 1, "rootView removeViewAt:" + i18 + " " + childCount);
                    if (i17 != i16) {
                        i17--;
                    } else {
                        return;
                    }
                }
            }
        } else {
            if (childCount == 1) {
                removeAllViews();
                i3 = 0;
            } else {
                i3 = childCount;
            }
            while (i3 < listSize) {
                addView(l(i3), i3);
                QLog.i("Guild.NewHome.GuildNavigatorView", 1, "rootView addView:" + i3 + " " + childCount);
                i3++;
            }
        }
    }

    private final void w(View view, float f16) {
        view.setOutlineProvider(new c(f16));
        view.setClipToOutline(true);
    }

    private final void x(int navigationBarColor) {
        this.preEmpty = true;
        removeAllViews();
        for (int i3 = 0; i3 < 4; i3++) {
            addView(m(navigationBarColor));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(final View expandView, final GuildHomeHeaderNavigationBar item, boolean fromAni) {
        final Map mapOf;
        View findViewById = expandView.findViewById(R.id.f107006_9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "expandView.findViewById(R.id.tv_config_name)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = expandView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "expandView.findViewById(R.id.iv_avatar)");
        ImageView imageView = (ImageView) findViewById2;
        View findViewById3 = expandView.findViewById(R.id.uy8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "expandView.findViewById(R.id.expand_button)");
        ImageView imageView2 = (ImageView) findViewById3;
        View findViewById4 = expandView.findViewById(R.id.uya);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "expandView.findViewById(R.id.expand_text)");
        TextView textView2 = (TextView) findViewById4;
        if (!fromAni) {
            imageView.setVisibility(8);
            textView.setVisibility(8);
        }
        imageView2.setVisibility(0);
        textView2.setVisibility(0);
        textView2.setTextColor(item.getTintColors().getNavigationBarColor());
        if (item.getIsExpand()) {
            textView2.setText("\u6536\u8d77");
            Resources resources = imageView2.getResources();
            Drawable drawable = imageView2.getResources().getDrawable(R.drawable.guild_navigator_close);
            Intrinsics.checkNotNullExpressionValue(drawable, "expandButton.resources.g\u2026le.guild_navigator_close)");
            SkinnableBitmapDrawable skinnableBitmapDrawable = new SkinnableBitmapDrawable(resources, DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null));
            skinnableBitmapDrawable.mutate2();
            skinnableBitmapDrawable.setColorFilter(new PorterDuffColorFilter(item.getTintColors().getNavigationBarColor(), PorterDuff.Mode.SRC_IN));
            imageView2.setImageDrawable(skinnableBitmapDrawable);
        } else {
            textView2.setText("\u5c55\u5f00");
            Resources resources2 = imageView2.getResources();
            Drawable drawable2 = imageView2.getResources().getDrawable(R.drawable.guild_navigator_expand);
            Intrinsics.checkNotNullExpressionValue(drawable2, "expandButton.resources.g\u2026e.guild_navigator_expand)");
            SkinnableBitmapDrawable skinnableBitmapDrawable2 = new SkinnableBitmapDrawable(resources2, DrawableKt.toBitmap$default(drawable2, 0, 0, null, 7, null));
            skinnableBitmapDrawable2.mutate2();
            skinnableBitmapDrawable2.setColorFilter(new PorterDuffColorFilter(item.getTintColors().getNavigationBarColor(), PorterDuff.Mode.SRC_IN));
            imageView2.setImageDrawable(skinnableBitmapDrawable2);
        }
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("sgrp_navigation_bar_type", textView2.getText());
        int i3 = 1;
        pairArr[1] = TuplesKt.to("sgrp_navigation_url", "");
        pairArr[2] = TuplesKt.to("sgrp_rank", Integer.valueOf(getChildCount()));
        if (item.getIsExpand()) {
            i3 = 2;
        }
        pairArr[3] = TuplesKt.to("sgrp_other_bar", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        expandView.setOnClickListener(new View.OnClickListener() { // from class: kp1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNavigatorView.A(GuildNavigatorView.this, view);
            }
        });
        imageView2.post(new Runnable() { // from class: kp1.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildNavigatorView.B(expandView, item, mapOf);
            }
        });
    }

    static /* synthetic */ void z(GuildNavigatorView guildNavigatorView, View view, GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        guildNavigatorView.y(view, guildHomeHeaderNavigationBar, z16);
    }

    public final void H(@NotNull GuildHomeHeaderNavigationBar item) {
        int i3;
        Intrinsics.checkNotNullParameter(item, "item");
        this.guildHomeHeaderNavigationBar = new WeakReference<>(item);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildNavigatorView", "updateNavigationInfo " + item.getIsExpand() + " size:" + item.k().size());
        }
        if (item.k().isEmpty()) {
            if (this.needPlaceholder) {
                setVisibility(0);
                x(item.getTintColors().getNavigationBarColor());
                return;
            } else {
                setVisibility(8);
                return;
            }
        }
        if (this.preEmpty) {
            removeAllViews();
        }
        this.preEmpty = false;
        if (this.preExpandStatus == item.getIsExpand()) {
            K(this, item, false, 2, null);
            return;
        }
        this.preExpandStatus = item.getIsExpand();
        if (item.getIsExpand()) {
            J(item, true);
        }
        if (item.getIsExpand()) {
            i3 = item.k().size() + 1;
        } else {
            i3 = 5;
        }
        Animator s16 = s(i3);
        s16.addListener(new d(item));
        Animator o16 = o(item);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(s16, o16);
        animatorSet.start();
    }

    public final void I(@NotNull GuildHomeHeaderNavigationBar item) {
        int i3;
        Intrinsics.checkNotNullParameter(item, "item");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildNavigatorView", "updateNavigationInfo " + item.getIsExpand() + " size:" + item.k().size());
        }
        this.guildHomeHeaderNavigationBar = new WeakReference<>(item);
        if (item.k().isEmpty()) {
            if (this.needPlaceholder) {
                setVisibility(0);
                x(item.getTintColors().getNavigationBarColor());
                return;
            } else {
                setVisibility(8);
                return;
            }
        }
        if (this.preEmpty) {
            removeAllViews();
        }
        this.preEmpty = false;
        this.preExpandStatus = item.getIsExpand();
        if (item.getIsExpand()) {
            i3 = item.k().size() + 1;
        } else {
            i3 = 5;
        }
        Animator s16 = s(i3);
        s16.addListener(new f(item));
        s16.addListener(new e(item));
        s16.start();
    }

    public final void setNavigatorIconInItemSize(int i3) {
        this.navigatorIconInItemSize = i3;
    }

    public final void setNeedHandleItemClick(boolean z16) {
        this.isNeedHandleItemClick = z16;
    }

    public final void setNeedPlaceholder(boolean z16) {
        this.needPlaceholder = z16;
    }

    public final void setUpdateExpandStatus(@Nullable Function0<Unit> function0) {
        this.updateExpandStatus = function0;
    }

    public GuildNavigatorView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildNavigatorView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildNavigatorView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.isNeedHandleItemClick = true;
        this.navigatorIconInItemSize = ViewUtils.dip2px(24.0f);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeHeaderNavigationBar f225719e;

        d(GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar) {
            this.f225719e = guildHomeHeaderNavigationBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            GuildNavigatorView.K(GuildNavigatorView.this, this.f225719e, false, 2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildNavigatorView.K(GuildNavigatorView.this, this.f225719e, false, 2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
