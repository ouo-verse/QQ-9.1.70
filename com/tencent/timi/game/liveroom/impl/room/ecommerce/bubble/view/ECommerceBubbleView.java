package com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.view.ECommerceBubbleView;
import com.tencent.timi.game.liveroom.impl.room.event.PurchaseFloatingBannerChangedEvent;
import com.tencent.timi.game.liveroom.impl.room.message.stack.a;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yn4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/view/ECommerceBubbleView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "j", "Landroid/view/animation/AnimationSet;", "f", "", NodeProps.VISIBLE, "g", "", "info", "e", MiniChatConstants.MINI_APP_LANDSCAPE, "i", h.F, "Landroid/view/animation/AnimationSet;", "ecAnimationSet", "Z", "isAnimationPlaying", "Ljava/util/LinkedList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/LinkedList;", "waitingShowInfoList", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ECommerceBubbleView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimationSet ecAnimationSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimationPlaying;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedList<String> waitingShowInfoList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceBubbleView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final AnimationSet f() {
        AnimationSet animationSet = this.ecAnimationSet;
        if (animationSet == null) {
            AnimationSet animationSet2 = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setInterpolator(a.INSTANCE.a());
            translateAnimation.setFillAfter(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(100L);
            alphaAnimation.setStartOffset(2200L);
            animationSet2.addAnimation(translateAnimation);
            animationSet2.addAnimation(alphaAnimation);
            animationSet2.setAnimationListener(new b());
            return animationSet2;
        }
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean visible) {
        SimpleEventBus.getInstance().dispatchEvent(new PurchaseFloatingBannerChangedEvent(visible));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (!this.isAnimationPlaying && !this.waitingShowInfoList.isEmpty()) {
            String pollFirst = this.waitingShowInfoList.pollFirst();
            this.isAnimationPlaying = true;
            setText(pollFirst);
            startAnimation(f());
        }
    }

    public final void e(@NotNull String info) {
        boolean z16;
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.waitingShowInfoList.add(info);
        j();
    }

    public final void h() {
        this.waitingShowInfoList.clear();
        AnimationSet animationSet = this.ecAnimationSet;
        if (animationSet != null) {
            animationSet.cancel();
        }
        this.isAnimationPlaying = false;
        setVisibility(8);
    }

    public final void i(boolean isLandscape) {
        if (QLog.isColorLevel()) {
            QLog.i("Float_Banner|ECommerceBubbleView", 2, "onOrientationChange isLandscape=" + isLandscape);
        }
        if (isLandscape) {
            AnimationSet animationSet = this.ecAnimationSet;
            if (animationSet != null) {
                animationSet.cancel();
            }
            this.isAnimationPlaying = false;
            setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceBubbleView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ECommerceBubbleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ECommerceBubbleView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.waitingShowInfoList = new LinkedList<>();
        setLayoutParams(new FrameLayout.LayoutParams(-2, fh4.b.a(24.0f)));
        setBackground(c.b(R.drawable.l28));
        Drawable b16 = c.b(R.drawable.nmn);
        if (b16 != null) {
            b16.setBounds(0, 0, fh4.b.a(13.0f), fh4.b.a(13.0f));
        }
        setCompoundDrawables(b16, null, null, null);
        setCompoundDrawablePadding(fh4.b.a(6.0f));
        setPadding(fh4.b.a(8.0f), fh4.b.a(3.0f), fh4.b.a(8.0f), fh4.b.a(3.0f));
        setTextColor(c.a(R.color.f158017al3));
        setTextSize(12.0f);
        setGravity(17);
        setVisibility(8);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/view/ECommerceBubbleView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ECommerceBubbleView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isAnimationPlaying = false;
            this$0.j();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            AegisLogger.INSTANCE.i("Float_Banner|ECommerceBubbleView", "ECommerceBanner onAnimationEnd");
            ECommerceBubbleView.this.setVisibility(8);
            ECommerceBubbleView.this.g(false);
            final ECommerceBubbleView eCommerceBubbleView = ECommerceBubbleView.this;
            eCommerceBubbleView.postDelayed(new Runnable() { // from class: aj4.a
                @Override // java.lang.Runnable
                public final void run() {
                    ECommerceBubbleView.b.b(ECommerceBubbleView.this);
                }
            }, 100L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            AegisLogger.INSTANCE.i("Float_Banner|ECommerceBubbleView", "ECommerceBanner onAnimationStart");
            ECommerceBubbleView.this.setVisibility(0);
            ECommerceBubbleView.this.g(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }
    }
}
