package com.tencent.mobileqq.tvideo.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.helpers.x;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0002YZB1\b\u0007\u0012\u0006\u0010Q\u001a\u00020P\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010R\u0012\b\b\u0002\u0010T\u001a\u00020\u0003\u0012\b\b\u0002\u0010U\u001a\u00020\u0003\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0003J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0017J \u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001bR\u0014\u00102\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010=\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010DR\u0016\u0010G\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010FR\u0016\u0010I\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010HR\u0016\u0010J\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010FR\u0014\u0010M\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010L\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "", "mode", "", "o", "fromMode", "toMode", "", "aniValue", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "w", "g", "j", "E", "Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar$b;", "seekBarChangeListener", "setQFSSeekBarChangeListener", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "v", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Landroid/widget/SeekBar;", "seekBar", "fromUser", "onProgressChanged", "onStartTrackingTouch", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onStopTrackingTouch", "B", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "max", "setMax", "D", "G", UserInfo.SEX_FEMALE, "landscape", "setIsLandScape", "d", "Landroid/widget/FrameLayout;", "mContainerView", "e", "Landroid/widget/SeekBar;", "mSeekBar", "Landroid/view/View;", "f", "Landroid/view/View;", "mThumbView", h.F, "mBackGroundView", "i", "mProgressView", "Lcom/tencent/biz/qqcircle/helpers/x;", "Lcom/tencent/biz/qqcircle/helpers/x;", "mEventHelper", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mToMinRunnable", "Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar$b;", "mQFSSeekBarChangeListener", "Z", "mIsOnAni", "I", "mCurrentMode", "mIsLandscape", "t", "()I", "displayWith", "y", "thumbWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "H", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QFSTVideoSeekBar extends FrameLayout implements SeekBar.OnSeekBarChangeListener {
    private static final int I = ImmersiveUtils.dpToPx(1.0f);
    private static final int J = ImmersiveUtils.dpToPx(2.0f);
    private static final int K = ImmersiveUtils.dpToPx(4.0f);
    private static final int L = ImmersiveUtils.dpToPx(1.0f);
    private static final int M = ImmersiveUtils.dpToPx(2.0f);
    private static final int N = ImmersiveUtils.dpToPx(12.0f);
    private static final int P = ImmersiveUtils.dpToPx(12.0f);
    private static final int Q = ImmersiveUtils.dpToPx(4.0f);
    private static final int R = ImmersiveUtils.dpToPx(16.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Runnable mToMinRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b mQFSSeekBarChangeListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsOnAni;

    /* renamed from: F, reason: from kotlin metadata */
    private int mCurrentMode;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout mContainerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SeekBar mSeekBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mThumbView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mBackGroundView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mProgressView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x mEventHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/QFSTVideoSeekBar$b;", "", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface b {
        void onProgressChanged(@Nullable SeekBar seekBar, int progress, boolean fromUser);

        void onStartTrackingTouch(@Nullable SeekBar seekBar);

        void onStopTrackingTouch(@Nullable SeekBar seekBar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSTVideoSeekBar(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void E() {
        int i3 = this.mCurrentMode;
        p(i3, i3, 1.0f);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void g() {
        o(2);
        QLog.d("QFSTVideoSeekBar", 1, "changeLayout fromMode:" + this.mCurrentMode + " toMode:2");
        int i3 = this.mCurrentMode;
        if (i3 == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSTVideoSeekBar.h(QFSTVideoSeekBar.this, valueAnimator);
                }
            });
            ofFloat.start();
            this.mCurrentMode = 2;
            return;
        }
        if (i3 == 1) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(160L);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSTVideoSeekBar.i(QFSTVideoSeekBar.this, valueAnimator);
                }
            });
            ofFloat2.start();
            this.mCurrentMode = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QFSTVideoSeekBar this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.p(0, 2, ((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QFSTVideoSeekBar this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.p(1, 2, ((Float) animatedValue).floatValue());
    }

    private final void j() {
        int i3 = this.mCurrentMode;
        if (i3 == 2) {
            QLog.d("QFSTVideoSeekBar", 1, "changeLayout fromMode:" + i3 + " toMode:1");
            this.mIsOnAni = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(160L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSTVideoSeekBar.k(QFSTVideoSeekBar.this, valueAnimator);
                }
            });
            ofFloat.start();
            this.mCurrentMode = 1;
            return;
        }
        if (i3 == 0) {
            this.mIsOnAni = true;
            o(1);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(160L);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSTVideoSeekBar.l(QFSTVideoSeekBar.this, valueAnimator);
                }
            });
            ofFloat2.start();
            this.mCurrentMode = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(QFSTVideoSeekBar this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.p(2, 1, floatValue);
        if (floatValue >= 1.0f) {
            this$0.mIsOnAni = false;
            this$0.o(1);
            this$0.post(this$0.mToMinRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QFSTVideoSeekBar this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.p(0, 1, floatValue);
        if (floatValue >= 1.0f) {
            this$0.mIsOnAni = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QFSTVideoSeekBar this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.p(1, 0, floatValue);
        if (floatValue >= 1.0f) {
            this$0.mIsOnAni = false;
            this$0.o(0);
        }
    }

    private final void o(int mode) {
        if (mode != 0) {
            if (mode != 1) {
                if (mode == 2) {
                    this.mProgressView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.km_));
                    this.mBackGroundView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.km9));
                    this.mThumbView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.lyr));
                    return;
                }
                return;
            }
            this.mProgressView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.kmb));
            this.mBackGroundView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.kma));
            this.mThumbView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.lyr));
            return;
        }
        this.mProgressView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.kmd));
        this.mBackGroundView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.kmc));
        this.mThumbView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.kme));
    }

    private final void p(int fromMode, int toMode, float aniValue) {
        q(fromMode, toMode, aniValue);
        r(fromMode, toMode, aniValue);
        this.mBackGroundView.requestLayout();
        this.mProgressView.requestLayout();
        this.mThumbView.requestLayout();
    }

    private final void q(int fromMode, int toMode, float aniValue) {
        int w3 = w(fromMode);
        int min = (int) Math.min(w3 + ((r3 - w3) * aniValue), w(toMode));
        this.mBackGroundView.getLayoutParams().height = min;
        this.mProgressView.getLayoutParams().height = min;
    }

    private final void r(int fromMode, int toMode, float aniValue) {
        float min;
        int x16 = x(fromMode);
        int x17 = x(toMode);
        int i3 = x17 - x16;
        if (fromMode > toMode) {
            min = Math.max(x16 + (i3 * aniValue), x17);
        } else {
            min = Math.min(x16 + (i3 * aniValue), x17);
        }
        int i16 = (int) min;
        ViewGroup.LayoutParams layoutParams = this.mThumbView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
        if (layoutParams2.leftMargin + i16 > t()) {
            layoutParams2.leftMargin = t() - i16;
        }
        this.mThumbView.requestLayout();
    }

    private final int t() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private final int w(int mode) {
        if (mode != 0) {
            if (mode != 1) {
                if (mode != 2) {
                    return J;
                }
                return K;
            }
            return J;
        }
        return I;
    }

    private final int x(int mode) {
        if (mode != 0) {
            if (mode != 1) {
                if (mode != 2) {
                    if (this.mIsLandscape) {
                        return Q;
                    }
                    return M;
                }
                if (this.mIsLandscape) {
                    return R;
                }
                return P;
            }
            if (this.mIsLandscape) {
                return Q;
            }
            return M;
        }
        return L;
    }

    private final int y() {
        int i3 = this.mCurrentMode;
        if (i3 != 1) {
            if (i3 != 2) {
                return L;
            }
            if (this.mIsLandscape) {
                return R;
            }
            return N;
        }
        if (this.mIsLandscape) {
            return Q;
        }
        return M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QFSTVideoSeekBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    public final void A(int progress) {
        this.mSeekBar.setProgress(progress);
        onProgressChanged(this.mSeekBar, progress, true);
    }

    public final void B() {
        onStartTrackingTouch(this.mSeekBar);
    }

    public final void C() {
        onStopTrackingTouch(this.mSeekBar);
    }

    public final void D() {
        removeCallbacks(this.mToMinRunnable);
        s();
    }

    public final void F() {
        removeCallbacks(this.mToMinRunnable);
        m();
    }

    public final void G(int mode) {
        if (mode == 1) {
            s();
        } else {
            F();
        }
    }

    public final void m() {
        if (this.mIsLandscape) {
            return;
        }
        QLog.d("QFSTVideoSeekBar", 1, "changeLayout fromMode:" + this.mCurrentMode + " toMode:0");
        if (this.mCurrentMode == 1) {
            this.mIsOnAni = true;
            removeCallbacks(this.mToMinRunnable);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(160L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ky2.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSTVideoSeekBar.n(QFSTVideoSeekBar.this, valueAnimator);
                }
            });
            ofFloat.start();
            this.mCurrentMode = 0;
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (this.mIsOnAni) {
            QLog.d("QFSTVideoSeekBar", 1, "mIsOnAni return");
            return;
        }
        QLog.d("QFSTVideoSeekBar", 1, "onProgressChanged progress = " + progress);
        int t16 = t();
        int y16 = y();
        int min = (int) Math.min((((float) progress) / ((float) this.mSeekBar.getMax())) * ((float) t16), (float) (t16 - y16));
        ViewGroup.LayoutParams layoutParams = this.mThumbView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(min, 0, 0, 0);
        this.mThumbView.setLayoutParams(layoutParams2);
        this.mThumbView.requestLayout();
        ViewGroup.LayoutParams layoutParams3 = this.mProgressView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        if (this.mIsLandscape) {
            layoutParams4.width = min + (Q / 2);
        } else {
            layoutParams4.width = min + (y16 / 2);
        }
        this.mProgressView.setLayoutParams(layoutParams4);
        b bVar = this.mQFSSeekBarChangeListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.onProgressChanged(seekBar, progress, fromUser);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        removeCallbacks(this.mToMinRunnable);
        g();
        b bVar = this.mQFSSeekBarChangeListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        j();
        b bVar = this.mQFSSeekBarChangeListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.onStopTrackingTouch(seekBar);
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return false;
        }
        return this.mSeekBar.onTouchEvent(event);
    }

    public final void s() {
        QLog.d("QFSTVideoSeekBar", 1, "changeToMiddleStatus");
        ViewGroup.LayoutParams layoutParams = this.mBackGroundView.getLayoutParams();
        int i3 = J;
        layoutParams.height = i3;
        this.mProgressView.getLayoutParams().height = i3;
        if (this.mIsLandscape) {
            ViewGroup.LayoutParams layoutParams2 = this.mThumbView.getLayoutParams();
            int i16 = Q;
            layoutParams2.width = i16;
            this.mThumbView.getLayoutParams().height = i16;
        } else {
            ViewGroup.LayoutParams layoutParams3 = this.mThumbView.getLayoutParams();
            int i17 = M;
            layoutParams3.width = i17;
            this.mThumbView.getLayoutParams().height = i17;
        }
        o(1);
        this.mBackGroundView.requestLayout();
        this.mProgressView.requestLayout();
        this.mThumbView.requestLayout();
        this.mCurrentMode = 1;
    }

    public final void setIsLandScape(boolean landscape) {
        if (this.mIsLandscape != landscape) {
            this.mIsLandscape = landscape;
            if (landscape && this.mCurrentMode == 0) {
                s();
            }
            E();
        }
    }

    public final void setMax(int max) {
        this.mSeekBar.setMax(max);
    }

    public final void setProgress(int progress) {
        this.mSeekBar.setProgress(progress);
    }

    public final void setQFSSeekBarChangeListener(@Nullable b seekBarChangeListener) {
        this.mQFSSeekBarChangeListener = seekBarChangeListener;
    }

    public final int u() {
        return this.mSeekBar.getMax();
    }

    public final int v() {
        return this.mSeekBar.getProgress();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSTVideoSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSTVideoSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QFSTVideoSeekBar(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSTVideoSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mToMinRunnable = new Runnable() { // from class: ky2.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSTVideoSeekBar.z(QFSTVideoSeekBar.this);
            }
        };
        FrameLayout frameLayout = new FrameLayout(context);
        this.mContainerView = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        addView(frameLayout, layoutParams);
        View view = new View(context);
        this.mBackGroundView = view;
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.kmc));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, cx.a(1.0f));
        layoutParams2.gravity = 80;
        frameLayout.addView(view, layoutParams2);
        View view2 = new View(context);
        this.mProgressView = view2;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(0, cx.a(1.0f));
        layoutParams3.gravity = 16;
        view2.setBackground(ContextCompat.getDrawable(context, R.drawable.kmd));
        frameLayout.addView(view2, layoutParams3);
        View view3 = new View(context);
        this.mThumbView = view3;
        view3.setBackground(ContextCompat.getDrawable(context, R.drawable.kme));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(cx.a(3.0f), cx.a(3.0f));
        layoutParams3.gravity = 16;
        frameLayout.addView(view3, layoutParams4);
        this.mEventHelper = new x();
        SeekBar seekBar = new SeekBar(context);
        this.mSeekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        ViewGroup.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, R);
        seekBar.setVisibility(4);
        addView(seekBar, layoutParams5);
    }
}
