package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001/B!\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010)\u001a\u00020\u0019\u00a2\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b*\u0010,B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b*\u0010-J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSCommentPushRanView;", "Landroid/widget/LinearLayout;", "", "isPushRan", "withAnim", "", "c", "b", "Lcom/airbnb/lottie/LottieAnimationView;", "d", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieAnimView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTextView", "", "f", "Ljava/lang/String;", "mHasPushRanTxt", tl.h.F, "mNotPushRanTxt", "i", "Z", "mHasPushRan", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mHasPushRanDrawable", BdhLogUtil.LogTag.Tag_Conn, "mNotPushRanDrawable", "D", "mLottieAnimUrl", "Landroid/animation/Animator$AnimatorListener;", "E", "Landroid/animation/Animator$AnimatorListener;", "mLottieAnimatorLister", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSCommentPushRanView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int mNotPushRanDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mLottieAnimUrl;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Animator.AnimatorListener mLottieAnimatorLister;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView mLottieAnimView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mHasPushRanTxt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mNotPushRanTxt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mHasPushRan;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mHasPushRanDrawable;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/widgets/QFSCommentPushRanView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("QFSCommentPushRanView", 1, "lottie onAnimationCancel, hasPushRan:" + QFSCommentPushRanView.this.mHasPushRan);
            QFSCommentPushRanView qFSCommentPushRanView = QFSCommentPushRanView.this;
            qFSCommentPushRanView.b(qFSCommentPushRanView.mHasPushRan);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("QFSCommentPushRanView", 1, "lottie onAnimationEnd, hasPushRan:" + QFSCommentPushRanView.this.mHasPushRan);
            QFSCommentPushRanView qFSCommentPushRanView = QFSCommentPushRanView.this;
            qFSCommentPushRanView.b(qFSCommentPushRanView.mHasPushRan);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("QFSCommentPushRanView", 1, "lottie onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("QFSCommentPushRanView", 1, "lottie onAnimationStart");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSCommentPushRanView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHasPushRanDrawable = R.drawable.onk;
        this.mNotPushRanDrawable = R.drawable.onl;
        this.mLottieAnimUrl = "https://qq-video.cdn-go.cn/android/latest/defaultmode/edaxia/qvideo_comment_firelike_lo.json";
        b bVar = new b();
        this.mLottieAnimatorLister = bVar;
        this.mHasPushRanTxt = com.tencent.biz.qqcircle.utils.h.a(R.string.f189173yo);
        this.mNotPushRanTxt = com.tencent.biz.qqcircle.utils.h.a(R.string.f189073ye);
        setOrientation(0);
        setGravity(16);
        int a16 = cx.a(28.0f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(a16, a16));
        lottieAnimationView.setImageResource(this.mNotPushRanDrawable);
        lottieAnimationView.addAnimatorListener(bVar);
        this.mLottieAnimView = lottieAnimationView;
        addView(lottieAnimationView);
        TextView textView = new TextView(context);
        textView.setText(this.mNotPushRanTxt);
        textView.setTextSize(12.0f);
        textView.setTextColor(QFSQUIUtilsKt.d(context, R.color.qui_common_text_secondary));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mTextView = textView;
        addView(textView);
    }

    public final void b(boolean isPushRan) {
        this.mHasPushRan = isPushRan;
        if (isPushRan) {
            LottieAnimationView lottieAnimationView = this.mLottieAnimView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setImageResource(this.mHasPushRanDrawable);
            }
            TextView textView = this.mTextView;
            if (textView != null) {
                textView.setText(this.mHasPushRanTxt);
            }
            TextView textView2 = this.mTextView;
            if (textView2 != null) {
                textView2.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.mLottieAnimView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setImageResource(this.mNotPushRanDrawable);
        }
        TextView textView3 = this.mTextView;
        if (textView3 != null) {
            textView3.setText(this.mNotPushRanTxt);
        }
        TextView textView4 = this.mTextView;
        if (textView4 != null) {
            textView4.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
        }
    }

    public final void c(boolean isPushRan, boolean withAnim) {
        LottieAnimationView lottieAnimationView = this.mLottieAnimView;
        boolean z16 = false;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            z16 = true;
        }
        if (z16) {
            this.mHasPushRan = isPushRan;
            return;
        }
        if (isPushRan == this.mHasPushRan) {
            return;
        }
        this.mHasPushRan = isPushRan;
        if (isPushRan) {
            if (withAnim) {
                LottieAnimationView lottieAnimationView2 = this.mLottieAnimView;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setAnimationFromUrl(this.mLottieAnimUrl);
                }
                LottieAnimationView lottieAnimationView3 = this.mLottieAnimView;
                if (lottieAnimationView3 != null) {
                    lottieAnimationView3.playAnimation();
                    return;
                }
                return;
            }
            LottieAnimationView lottieAnimationView4 = this.mLottieAnimView;
            if (lottieAnimationView4 != null) {
                lottieAnimationView4.setImageResource(this.mHasPushRanDrawable);
            }
            TextView textView = this.mTextView;
            if (textView != null) {
                textView.setText(this.mHasPushRanTxt);
            }
            TextView textView2 = this.mTextView;
            if (textView2 != null) {
                textView2.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView5 = this.mLottieAnimView;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.setImageResource(this.mNotPushRanDrawable);
        }
        TextView textView3 = this.mTextView;
        if (textView3 != null) {
            textView3.setText(this.mNotPushRanTxt);
        }
        TextView textView4 = this.mTextView;
        if (textView4 != null) {
            textView4.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSCommentPushRanView(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSCommentPushRanView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
