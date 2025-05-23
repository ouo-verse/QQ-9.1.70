package com.tencent.timi.game.liveroom.impl.room.userlevel;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.timi.game.liveroom.impl.room.userlevel.GiftPanelUserPayLevelView;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserPayLevelData;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 [2\u00020\u0001:\u0004\\]^_B1\b\u0007\u0012\b\u0010T\u001a\u0004\u0018\u00010S\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010X\u001a\u00020W\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J0\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0002J\b\u0010!\u001a\u00020\u0002H\u0015R\u0014\u0010$\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0018\u00102\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0018\u00105\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R\u001c\u0010?\u001a\b\u0018\u00010<R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010C\u001a\b\u0018\u00010@R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010G\u001a\b\u0018\u00010DR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010JR\u0016\u0010M\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010=R\u0018\u0010P\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010#\u00a8\u0006`"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "", "level", "goldCount", "nextLevelGoldDiff", "addGoldCount", "", "iconUrl", "K0", "R0", "curGoldCount", "", "refreshGoldPercent", "refreshAddPercent", "N0", "O0", "", "percent", "Landroid/view/View;", "view", "L0", "Landroid/view/View$OnClickListener;", "clickListener", "setUserLevelRightClickListener", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "userPayLevelData", "setUserPayLevelData", "setAddGoldCount", "M0", "release", NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Z", "isLandscapeStyle", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "userLevelShowIconIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "userLevelShowTv", tl.h.F, "userLevelNoneTv", "i", "userLevelUpgradeTipsTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "userLevelRightTv", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "giftUserLevelProcessBg", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/CornerImageView;", "D", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/CornerImageView;", "giftUserLevelProgressGoldIncrease", "E", "giftUserLevelProgressRealValue", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$b;", "increaseAnim", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$SetGiftGoldProgressRunnable;", "G", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$SetGiftGoldProgressRunnable;", "setGiftGoldProgressRunnable", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$SetRealValueProgressRunnable;", "H", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$SetRealValueProgressRunnable;", "setRealValueProgressRunnable", "I", "Lcom/tencent/timi/game/liveroom/impl/room/userlevel/bean/a;", "J", "selectGiftAddGoldCount", "K", "curPercent", "L", "Landroid/view/View$OnClickListener;", "userLevelRightTvClickListener", "M", "isRelease", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;ZLandroid/util/AttributeSet;I)V", "N", "a", "b", "SetGiftGoldProgressRunnable", "SetRealValueProgressRunnable", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GiftPanelUserPayLevelView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View giftUserLevelProcessBg;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private CornerImageView giftUserLevelProgressGoldIncrease;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View giftUserLevelProgressRealValue;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private b increaseAnim;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private SetGiftGoldProgressRunnable setGiftGoldProgressRunnable;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private SetRealValueProgressRunnable setRealValueProgressRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private UserPayLevelData userPayLevelData;

    /* renamed from: J, reason: from kotlin metadata */
    private long selectGiftAddGoldCount;

    /* renamed from: K, reason: from kotlin metadata */
    private float curPercent;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener userLevelRightTvClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isRelease;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isLandscapeStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView userLevelShowIconIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView userLevelShowTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView userLevelNoneTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView userLevelUpgradeTipsTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView userLevelRightTv;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$SetGiftGoldProgressRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", UserInfo.SEX_FEMALE, "percent", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView;F)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class SetGiftGoldProgressRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float percent;

        public SetGiftGoldProgressRunnable(float f16) {
            this.percent = f16;
        }

        @Override // java.lang.Runnable
        public void run() {
            CornerImageView cornerImageView = GiftPanelUserPayLevelView.this.giftUserLevelProgressGoldIncrease;
            if (cornerImageView != null) {
                GiftPanelUserPayLevelView giftPanelUserPayLevelView = GiftPanelUserPayLevelView.this;
                cornerImageView.setVisibility(0);
                giftPanelUserPayLevelView.L0(this.percent, cornerImageView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$SetRealValueProgressRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", UserInfo.SEX_FEMALE, "percent", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView;F)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class SetRealValueProgressRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final float percent;

        public SetRealValueProgressRunnable(float f16) {
            this.percent = f16;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = GiftPanelUserPayLevelView.this.giftUserLevelProgressRealValue;
            if (view != null) {
                GiftPanelUserPayLevelView giftPanelUserPayLevelView = GiftPanelUserPayLevelView.this;
                view.setVisibility(0);
                if (giftPanelUserPayLevelView.increaseAnim == null) {
                    giftPanelUserPayLevelView.increaseAnim = new b(giftPanelUserPayLevelView, view);
                }
                b bVar = giftPanelUserPayLevelView.increaseAnim;
                if (bVar != null) {
                    bVar.c(this.percent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u001e\u0010\u0016\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView$b;", "", "", "targetPercent", "", "e", "percent", "c", "b", "Landroid/view/View;", "a", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "", "I", "bgWidth", "d", "animStartPercent", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "Landroid/animation/ValueAnimator;", "animator", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/userlevel/GiftPanelUserPayLevelView;Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float percent;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int bgWidth;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float animStartPercent;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ValueAnimator animator;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ GiftPanelUserPayLevelView f378585f;

        public b(@NotNull GiftPanelUserPayLevelView giftPanelUserPayLevelView, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f378585f = giftPanelUserPayLevelView;
            this.view = view;
            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(float f16, b this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                this$0.e(this$0.animStartPercent + ((f16 - this$0.animStartPercent) * ((Number) animatedValue).floatValue()));
                if (Intrinsics.areEqual((Float) animatedValue, 1.0f)) {
                    this$0.animStartPercent = this$0.percent;
                }
            }
        }

        private final void e(float targetPercent) {
            boolean z16;
            if (this.bgWidth == 0) {
                View view = this.f378585f.giftUserLevelProcessBg;
                Intrinsics.checkNotNull(view);
                this.bgWidth = view.getMeasuredWidth() - x.c(this.f378585f.getContext(), 4.0f);
            }
            float f16 = (this.bgWidth * targetPercent) / 100.0f;
            if (f16 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.view.setVisibility(4);
            } else {
                this.view.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            layoutParams.width = (int) f16;
            this.view.setLayoutParams(layoutParams);
        }

        public final void b() {
            this.f378585f.isRelease = true;
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.animator = null;
        }

        public final void c(final float percent) {
            boolean z16;
            if (this.percent == percent) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                Intrinsics.checkNotNull(valueAnimator);
                valueAnimator.cancel();
                this.animator = null;
                this.animStartPercent = this.percent;
            }
            this.percent = percent;
            float f16 = this.animStartPercent;
            if (f16 > percent) {
                this.animStartPercent = percent;
                e(percent);
                return;
            }
            this.animStartPercent = Math.min(f16, percent);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = ofFloat;
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            this.animator.setDuration(300L);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    GiftPanelUserPayLevelView.b.d(percent, this, valueAnimator2);
                }
            });
            this.animator.start();
        }
    }

    @JvmOverloads
    public GiftPanelUserPayLevelView(@Nullable Context context, boolean z16) {
        this(context, z16, null, 0, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(GiftPanelUserPayLevelView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.userLevelRightTvClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K0(long level, long goldCount, long nextLevelGoldDiff, long addGoldCount, String iconUrl) {
        R0(level, iconUrl);
        N0(goldCount, addGoldCount, nextLevelGoldDiff, true, true);
        O0(level, addGoldCount, nextLevelGoldDiff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(float percent, View view) {
        boolean z16;
        Intrinsics.checkNotNull(this.giftUserLevelProcessBg);
        float measuredWidth = ((r0.getMeasuredWidth() - x.c(getContext(), 4.0f)) * percent) / 100;
        if (measuredWidth == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) measuredWidth;
        view.setLayoutParams(layoutParams);
    }

    private final void N0(long curGoldCount, long addGoldCount, long nextLevelGoldDiff, boolean refreshGoldPercent, boolean refreshAddPercent) {
        float coerceAtLeast;
        float coerceAtMost;
        float f16;
        if (this.isRelease) {
            return;
        }
        float f17 = 0.0f;
        if (refreshGoldPercent) {
            long j3 = curGoldCount + nextLevelGoldDiff;
            if (j3 <= 0) {
                f16 = 0.0f;
            } else {
                f16 = ((((float) curGoldCount) * 1.0f) / ((float) j3)) * 100;
            }
            this.curPercent = f16;
            Runnable runnable = this.setRealValueProgressRunnable;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            SetRealValueProgressRunnable setRealValueProgressRunnable = new SetRealValueProgressRunnable(this.curPercent);
            this.setRealValueProgressRunnable = setRealValueProgressRunnable;
            post(setRealValueProgressRunnable);
        }
        if (refreshAddPercent) {
            if (addGoldCount <= 0) {
                CornerImageView cornerImageView = this.giftUserLevelProgressGoldIncrease;
                if (cornerImageView != null) {
                    cornerImageView.setVisibility(8);
                    return;
                }
                return;
            }
            long j16 = nextLevelGoldDiff + curGoldCount;
            if (j16 > 0) {
                f17 = ((((float) (curGoldCount + addGoldCount)) * 1.0f) / ((float) j16)) * 100;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f17, this.curPercent + 0.5f);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 100.0f);
            Runnable runnable2 = this.setGiftGoldProgressRunnable;
            if (runnable2 != null) {
                removeCallbacks(runnable2);
            }
            SetGiftGoldProgressRunnable setGiftGoldProgressRunnable = new SetGiftGoldProgressRunnable(coerceAtMost);
            this.setGiftGoldProgressRunnable = setGiftGoldProgressRunnable;
            post(setGiftGoldProgressRunnable);
        }
    }

    private final void O0(long level, final long addGoldCount, long nextLevelGoldDiff) {
        final String string;
        TextView textView = this.userLevelUpgradeTipsTv;
        if (textView != null) {
            com.tencent.timi.game.liveroom.impl.util.c cVar = com.tencent.timi.game.liveroom.impl.util.c.f378976a;
            Typeface DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            textView.setTypeface(cVar.g("https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf", DEFAULT));
        }
        if (addGoldCount > 0) {
            post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.c
                @Override // java.lang.Runnable
                public final void run() {
                    GiftPanelUserPayLevelView.P0(GiftPanelUserPayLevelView.this, addGoldCount);
                }
            });
            return;
        }
        if (nextLevelGoldDiff == TTL.MAX_VALUE) {
            string = getContext().getString(R.string.f1381508s);
        } else {
            string = getContext().getString(R.string.f1381608t, Integer.valueOf((int) (level + 1)), Integer.valueOf((int) nextLevelGoldDiff));
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (nextLevelGoldDiff ==\u2026          )\n            }");
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.d
            @Override // java.lang.Runnable
            public final void run() {
                GiftPanelUserPayLevelView.Q0(GiftPanelUserPayLevelView.this, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(GiftPanelUserPayLevelView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.userLevelUpgradeTipsTv;
        if (textView != null) {
            textView.setText(Marker.ANY_NON_NULL_MARKER + j3);
            textView.setTextColor(Color.parseColor("#FFDF8B"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(GiftPanelUserPayLevelView this$0, String contentText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contentText, "$contentText");
        TextView textView = this$0.userLevelUpgradeTipsTv;
        if (textView != null) {
            textView.setText(contentText);
            textView.setTextColor(Color.parseColor("#4DFFFFFF"));
        }
    }

    private final void R0(long level, String iconUrl) {
        if (level <= 0) {
            TextView textView = this.userLevelNoneTv;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView2 = this.userLevelNoneTv;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ImageView imageView = this.userLevelShowIconIv;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView3 = this.userLevelShowTv;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        if (TextUtils.isEmpty(iconUrl)) {
            iconUrl = "https://yuhengpic.gtimg.com/29f399a1feefe8d6432b05314cd63ed2.png";
        }
        URLDrawable drawable = URLDrawable.getDrawable(iconUrl, URLDrawable.URLDrawableOptions.obtain());
        ImageView imageView2 = this.userLevelShowIconIv;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        TextView textView4 = this.userLevelShowTv;
        if (textView4 != null) {
            com.tencent.timi.game.liveroom.impl.util.c cVar = com.tencent.timi.game.liveroom.impl.util.c.f378976a;
            Typeface DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            textView4.setTypeface(cVar.g("https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf", DEFAULT));
        }
        TextView textView5 = this.userLevelShowTv;
        if (textView5 != null) {
            textView5.setText(String.valueOf(level));
        }
    }

    private final void initView() {
        View.inflate(getContext(), R.layout.i3n, this);
        this.userLevelShowIconIv = (ImageView) findViewById(R.id.f115536wa);
        this.userLevelShowTv = (TextView) findViewById(R.id.f115546wb);
        this.userLevelNoneTv = (TextView) findViewById(R.id.f115516w9);
        this.userLevelUpgradeTipsTv = (TextView) findViewById(R.id.f115556wc);
        this.userLevelRightTv = (TextView) findViewById(R.id.f115526w_);
        this.giftUserLevelProcessBg = findViewById(R.id.vqe);
        this.giftUserLevelProgressGoldIncrease = (CornerImageView) findViewById(R.id.vqf);
        this.giftUserLevelProgressRealValue = findViewById(R.id.vqg);
        TextView textView = this.userLevelRightTv;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.userlevel.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GiftPanelUserPayLevelView.J0(GiftPanelUserPayLevelView.this, view);
                }
            });
        }
        if (this.isLandscapeStyle) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(Color.parseColor("#191912"));
        }
        com.tencent.timi.game.liveroom.impl.util.c.f378976a.k(this.userLevelRightTv, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
    }

    public final void M0(long addGoldCount) {
        if (addGoldCount <= 0) {
            return;
        }
        this.selectGiftAddGoldCount = addGoldCount;
        UserPayLevelData userPayLevelData = this.userPayLevelData;
        if (userPayLevelData != null) {
            N0(userPayLevelData.getCurPayGoldCount(), this.selectGiftAddGoldCount, userPayLevelData.getNextLevelGoldDiff(), false, true);
            O0(userPayLevelData.getCurPayLevel(), this.selectGiftAddGoldCount, userPayLevelData.getNextLevelGoldDiff());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SetRealValueProgressRunnable setRealValueProgressRunnable = this.setRealValueProgressRunnable;
        if (setRealValueProgressRunnable != null) {
            removeCallbacks(setRealValueProgressRunnable);
        }
        SetGiftGoldProgressRunnable setGiftGoldProgressRunnable = this.setGiftGoldProgressRunnable;
        if (setGiftGoldProgressRunnable != null) {
            removeCallbacks(setGiftGoldProgressRunnable);
        }
    }

    public final void release() {
        this.isRelease = true;
        removeCallbacks(this.setGiftGoldProgressRunnable);
        removeCallbacks(this.setRealValueProgressRunnable);
        b bVar = this.increaseAnim;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void setAddGoldCount(long addGoldCount) {
        this.selectGiftAddGoldCount = addGoldCount;
    }

    public final void setUserLevelRightClickListener(@Nullable View.OnClickListener clickListener) {
        this.userLevelRightTvClickListener = clickListener;
    }

    public final void setUserPayLevelData(@NotNull UserPayLevelData userPayLevelData) {
        Intrinsics.checkNotNullParameter(userPayLevelData, "userPayLevelData");
        this.userPayLevelData = userPayLevelData;
        if (userPayLevelData != null) {
            K0(userPayLevelData.getCurPayLevel(), userPayLevelData.getCurPayGoldCount(), userPayLevelData.getNextLevelGoldDiff(), this.selectGiftAddGoldCount, userPayLevelData.getCurPayLevelIcon());
        }
    }

    public /* synthetic */ GiftPanelUserPayLevelView(Context context, boolean z16, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z16, (i16 & 4) != 0 ? null : attributeSet, (i16 & 8) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftPanelUserPayLevelView(@Nullable Context context, boolean z16, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
        this.isLandscapeStyle = z16;
        initView();
        com.tencent.timi.game.liveroom.impl.util.c.f378976a.i("https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
    }
}
