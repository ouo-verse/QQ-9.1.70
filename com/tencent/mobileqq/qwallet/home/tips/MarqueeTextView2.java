package com.tencent.mobileqq.qwallet.home.tips;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.tips.MarqueeTextView2;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u000e\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/tips/MarqueeTextView2;", "Landroidx/appcompat/widget/AppCompatTextView;", "", HippyTextInputController.COMMAND_IS_FOCUSED, "", "scrollDuration", "stopStayMs", "startStayMs", "", "setMarqueeParams", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", NodeProps.ON_DETACHED_FROM_WINDOW, "", "repeatTimes", "g", "j", tl.h.F, "J", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/ObjectAnimator;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/animation/ObjectAnimator;", "animator", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "handler", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MarqueeTextView2 extends AppCompatTextView {
    private static final int F = x.c(MobileQQ.sMobileQQ, 25.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ObjectAnimator animator;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long scrollDuration;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long stopStayMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long startStayMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/home/tips/MarqueeTextView2$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f278135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MarqueeTextView2 f278136e;

        b(int i3, MarqueeTextView2 marqueeTextView2) {
            this.f278135d = i3;
            this.f278136e = marqueeTextView2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MarqueeTextView2 this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setScrollX(0);
            this$0.g(i3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            final int i3 = this.f278135d + 1;
            Handler handler = this.f278136e.handler;
            final MarqueeTextView2 marqueeTextView2 = this.f278136e;
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.d
                @Override // java.lang.Runnable
                public final void run() {
                    MarqueeTextView2.b.b(MarqueeTextView2.this, i3);
                }
            }, this.f278136e.stopStayMs);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MarqueeTextView2(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MarqueeTextView2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h(this$0, 0, 1, null);
    }

    public static /* synthetic */ void h(MarqueeTextView2 marqueeTextView2, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        marqueeTextView2.g(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MarqueeTextView2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator objectAnimator = this$0.animator;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public static /* synthetic */ void setMarqueeParams$default(MarqueeTextView2 marqueeTextView2, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 5000;
        }
        long j18 = j3;
        if ((i3 & 2) != 0) {
            j16 = 1000;
        }
        long j19 = j16;
        if ((i3 & 4) != 0) {
            j17 = 3000;
        }
        marqueeTextView2.setMarqueeParams(j18, j19, j17);
    }

    public final void g(int repeatTimes) {
        boolean z16;
        if (getWidth() != 0) {
            CharSequence text = getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int measureText = (int) getPaint().measureText(getText().toString());
                if (measureText <= getWidth()) {
                    QLog.w("MarqueeTextView2", 1, "startMarquee fail: textWidth=" + measureText + " width=" + getWidth());
                    j();
                    return;
                }
                if (repeatTimes >= 2) {
                    QLog.w("MarqueeTextView2", 1, "stop repeat: reach limit times!");
                    j();
                    return;
                }
                j();
                int width = (measureText - getWidth()) + F;
                long abs = (Math.abs(width) * 1000) / x.c(MobileQQ.sMobileQQ, 20.0f);
                QLog.d("MarqueeTextView2", 2, "start marquee: totalLength=" + width + " duration=" + abs);
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "scrollX", 0, width);
                this.animator = ofInt;
                if (ofInt != null) {
                    ofInt.setDuration(abs);
                }
                ObjectAnimator objectAnimator = this.animator;
                if (objectAnimator != null) {
                    objectAnimator.addListener(new b(repeatTimes, this));
                }
                this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MarqueeTextView2.i(MarqueeTextView2.this);
                    }
                }, this.startStayMs);
                return;
            }
        }
        QLog.w("MarqueeTextView2", 1, "startMarquee fail: width=" + getWidth() + " text=" + ((Object) getText()));
        j();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public final void j() {
        ObjectAnimator objectAnimator;
        boolean z16 = false;
        setScrollX(0);
        ObjectAnimator objectAnimator2 = this.animator;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            z16 = true;
        }
        if (z16 && (objectAnimator = this.animator) != null) {
            objectAnimator.cancel();
        }
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.tips.b
            @Override // java.lang.Runnable
            public final void run() {
                MarqueeTextView2.f(MarqueeTextView2.this);
            }
        });
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    public final void setMarqueeParams(long scrollDuration, long stopStayMs, long startStayMs) {
        this.scrollDuration = scrollDuration;
        this.stopStayMs = stopStayMs;
        this.startStayMs = startStayMs;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MarqueeTextView2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MarqueeTextView2(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? R.attr.textViewStyle : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MarqueeTextView2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scrollDuration = 5000L;
        this.stopStayMs = 1000L;
        this.startStayMs = 3000L;
        this.handler = new Handler();
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(0);
    }
}
