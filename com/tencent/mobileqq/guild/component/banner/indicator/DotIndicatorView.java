package com.tencent.mobileqq.guild.component.banner.indicator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import og1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0014\u0007B%\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001dj\b\u0012\u0004\u0012\u00020\u0006`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\"\u0010%\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\u0018\u0010\"\"\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView;", "Landroid/widget/LinearLayout;", "Log1/b;", "Lcom/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView$b;", "", "index", "Landroid/widget/ImageView;", "b", "", "c", "e", "", "forward", "f", "g", h.F, "i", "j", "k", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "a", "count", "setCount", "setSelectedIndex", "d", "I", "curPos", "imageSize", "realPos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dotList", "Lcom/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView$b;", "()Lcom/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView$b;", "setOptions", "(Lcom/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView$b;)V", "options", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class DotIndicatorView extends LinearLayout implements og1.b<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int imageSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int realPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ImageView> dotList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b options;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView$b;", "Log1/a;", "", "b", "I", "c", "()I", "setDotSize", "(I)V", "dotSize", "e", "setRes", "res", "d", "setMarginSize", "marginSize", "", UserInfo.SEX_FEMALE, "f", "()F", "setScaleDot", "(F)V", "scaleDot", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int dotSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int res;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int marginSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float scaleDot;

        public b() {
            int roundToInt;
            int roundToInt2;
            roundToInt = MathKt__MathJVMKt.roundToInt(TypedValue.applyDimension(1, 5, Resources.getSystem().getDisplayMetrics()));
            this.dotSize = roundToInt;
            this.res = R.drawable.guild_indicator_bg;
            roundToInt2 = MathKt__MathJVMKt.roundToInt(TypedValue.applyDimension(1, 3, Resources.getSystem().getDisplayMetrics()));
            this.marginSize = roundToInt2;
            this.scaleDot = 0.6f;
        }

        /* renamed from: c, reason: from getter */
        public final int getDotSize() {
            return this.dotSize;
        }

        /* renamed from: d, reason: from getter */
        public final int getMarginSize() {
            return this.marginSize;
        }

        /* renamed from: e, reason: from getter */
        public final int getRes() {
            return this.res;
        }

        /* renamed from: f, reason: from getter */
        public final float getScaleDot() {
            return this.scaleDot;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/component/banner/indicator/DotIndicatorView$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            if (QLog.isColorLevel()) {
                QLog.d("DotIndicatorView", 1, "onPageSelected " + position);
            }
            DotIndicatorView.this.setSelectedIndex(position);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DotIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView b(int index) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getOptions().getDotSize(), getOptions().getDotSize());
        if (index > 0) {
            layoutParams.setMargins(getOptions().getMarginSize(), 0, 0, 0);
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(getOptions().getRes());
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private final void c(int index) {
        if (index < this.dotList.size()) {
            this.dotList.get(index).setScaleX(1.0f);
            this.dotList.get(index).setScaleY(1.0f);
        }
    }

    private final void e(int index) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        TransitionDrawable transitionDrawable;
        if (index == this.realPos) {
            return;
        }
        boolean z19 = true;
        if (index >= 0 && index < this.imageSize) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        int i16 = this.imageSize;
        if (i16 <= 5) {
            this.curPos = index;
        } else {
            int i17 = i16 - 4;
            if (index < i16 && i17 <= index) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = (i16 - 5) * (getOptions().getDotSize() + getOptions().getMarginSize());
                int i18 = this.imageSize;
                this.curPos = (index - i18) + 5;
                g(i18 - 5);
                int i19 = this.imageSize;
                for (int i26 = i19 - 4; i26 < i19; i26++) {
                    c(i26);
                }
            } else {
                if (2 <= index && index < i16 - 4) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    int i27 = index - 1;
                    int dotSize = (getOptions().getDotSize() + getOptions().getMarginSize()) * i27;
                    this.curPos = 1;
                    g(i27);
                    int i28 = index + 3;
                    g(i28);
                    for (int i29 = index; i29 < i28; i29++) {
                        this.dotList.get(i29).setScaleX(1.0f);
                        this.dotList.get(i29).setScaleY(1.0f);
                    }
                    i3 = dotSize;
                } else {
                    if (index < 0 || index >= 3) {
                        z19 = false;
                    }
                    if (z19) {
                        this.curPos = index;
                        for (int i36 = 0; i36 < 4; i36++) {
                            c(i36);
                        }
                        g(4);
                    }
                    i3 = 0;
                }
            }
            float x16 = (-i3) - this.dotList.get(0).getX();
            int i37 = this.imageSize;
            for (int i38 = 0; i38 < i37; i38++) {
                ImageView imageView = this.dotList.get(i38);
                Intrinsics.checkNotNullExpressionValue(imageView, "dotList[i]");
                ImageView imageView2 = imageView;
                imageView2.setX(imageView2.getX() + x16);
            }
        }
        Drawable drawable = this.dotList.get(this.realPos).getDrawable();
        TransitionDrawable transitionDrawable2 = null;
        if (drawable instanceof TransitionDrawable) {
            transitionDrawable = (TransitionDrawable) drawable;
        } else {
            transitionDrawable = null;
        }
        if (transitionDrawable != null) {
            transitionDrawable.reverseTransition(0);
        }
        Drawable drawable2 = this.dotList.get(index).getDrawable();
        if (drawable2 instanceof TransitionDrawable) {
            transitionDrawable2 = (TransitionDrawable) drawable2;
        }
        if (transitionDrawable2 != null) {
            transitionDrawable2.startTransition(0);
        }
        this.realPos = index;
    }

    private final void f(boolean forward) {
        int marginSize;
        AnimatorSet animatorSet = new AnimatorSet();
        if (forward) {
            marginSize = (-getOptions().getMarginSize()) - getOptions().getDotSize();
        } else {
            marginSize = getOptions().getMarginSize() + getOptions().getDotSize();
        }
        int i3 = this.imageSize;
        for (int i16 = 0; i16 < i3; i16++) {
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.dotList.get(i16), "translationX", this.dotList.get(i16).getTranslationX(), this.dotList.get(i16).getTranslationX() + marginSize));
        }
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private final void g(int index) {
        if (index < this.dotList.size()) {
            this.dotList.get(index).setScaleX(getOptions().getScaleDot());
            this.dotList.get(index).setScaleY(getOptions().getScaleDot());
        }
    }

    private final void h(int index) {
        boolean z16;
        if (index >= 0 && index < this.dotList.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dotList.get(index), BasicAnimation.KeyPath.SCALE_X, getOptions().getScaleDot(), 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dotList.get(index), BasicAnimation.KeyPath.SCALE_Y, getOptions().getScaleDot(), 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private final void i(int index) {
        boolean z16;
        if (index >= 0 && index < this.dotList.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dotList.get(index), BasicAnimation.KeyPath.SCALE_X, 1.0f, getOptions().getScaleDot());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dotList.get(index), BasicAnimation.KeyPath.SCALE_Y, 1.0f, getOptions().getScaleDot());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private final void j() {
        TransitionDrawable transitionDrawable;
        Drawable drawable = this.dotList.get(this.realPos).getDrawable();
        TransitionDrawable transitionDrawable2 = null;
        if (drawable instanceof TransitionDrawable) {
            transitionDrawable = (TransitionDrawable) drawable;
        } else {
            transitionDrawable = null;
        }
        if (transitionDrawable != null) {
            transitionDrawable.reverseTransition(200);
        }
        Drawable drawable2 = this.dotList.get(this.realPos - 1).getDrawable();
        if (drawable2 instanceof TransitionDrawable) {
            transitionDrawable2 = (TransitionDrawable) drawable2;
        }
        if (transitionDrawable2 != null) {
            transitionDrawable2.startTransition(200);
        }
        int i3 = this.curPos;
        if (i3 == 1 && this.realPos != 1) {
            f(false);
            int i16 = this.realPos;
            if (i16 != 2) {
                i(i16 - 2);
            }
            h(this.realPos - 1);
            i(this.realPos + 2);
        } else {
            this.curPos = i3 - 1;
        }
        this.realPos--;
    }

    private final void k() {
        TransitionDrawable transitionDrawable;
        Drawable drawable = this.dotList.get(this.realPos).getDrawable();
        TransitionDrawable transitionDrawable2 = null;
        if (drawable instanceof TransitionDrawable) {
            transitionDrawable = (TransitionDrawable) drawable;
        } else {
            transitionDrawable = null;
        }
        if (transitionDrawable != null) {
            transitionDrawable.reverseTransition(200);
        }
        Drawable drawable2 = this.dotList.get(this.realPos + 1).getDrawable();
        if (drawable2 instanceof TransitionDrawable) {
            transitionDrawable2 = (TransitionDrawable) drawable2;
        }
        if (transitionDrawable2 != null) {
            transitionDrawable2.startTransition(200);
        }
        int i3 = this.curPos;
        if (i3 == 3 && this.realPos != this.imageSize - 2) {
            f(true);
            int i16 = this.realPos;
            if (i16 != this.imageSize - 3) {
                i(i16 + 2);
            }
            h(this.realPos + 1);
            i(this.realPos - 2);
        } else {
            this.curPos = i3 + 1;
        }
        this.realPos++;
    }

    @Override // og1.b
    @NotNull
    public ViewPager2.OnPageChangeCallback a() {
        return new c();
    }

    @Override // og1.b
    @NotNull
    /* renamed from: d, reason: from getter */
    public b getOptions() {
        return this.options;
    }

    public final void setCount(int count) {
        int marginSize;
        int dotSize;
        TransitionDrawable transitionDrawable;
        if (count <= 1) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.dotList.clear();
        this.curPos = 0;
        this.realPos = 0;
        this.imageSize = count;
        if (count >= 5) {
            marginSize = getOptions().getDotSize() * 5;
            dotSize = getOptions().getMarginSize() * 4;
        } else {
            marginSize = (count - 1) * getOptions().getMarginSize();
            dotSize = getOptions().getDotSize() * count;
        }
        getLayoutParams().width = marginSize + dotSize;
        for (int i3 = 0; i3 < count; i3++) {
            ImageView b16 = b(i3);
            addView(b16);
            this.dotList.add(b16);
        }
        Drawable drawable = this.dotList.get(0).getDrawable();
        if (drawable instanceof TransitionDrawable) {
            transitionDrawable = (TransitionDrawable) drawable;
        } else {
            transitionDrawable = null;
        }
        if (transitionDrawable != null) {
            transitionDrawable.startTransition(0);
        }
        if (count <= 5) {
            return;
        }
        g(4);
    }

    public final void setSelectedIndex(int index) {
        TransitionDrawable transitionDrawable;
        int i3 = this.realPos;
        if (index == i3) {
            return;
        }
        boolean z16 = false;
        if (index >= 0 && index < this.imageSize) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        if (Math.abs(index - i3) > 1) {
            e(index);
            return;
        }
        if (this.imageSize <= 5) {
            Drawable drawable = this.dotList.get(this.curPos).getDrawable();
            TransitionDrawable transitionDrawable2 = null;
            if (drawable instanceof TransitionDrawable) {
                transitionDrawable = (TransitionDrawable) drawable;
            } else {
                transitionDrawable = null;
            }
            if (transitionDrawable != null) {
                transitionDrawable.reverseTransition(200);
            }
            Drawable drawable2 = this.dotList.get(index).getDrawable();
            if (drawable2 instanceof TransitionDrawable) {
                transitionDrawable2 = (TransitionDrawable) drawable2;
            }
            if (transitionDrawable2 != null) {
                transitionDrawable2.startTransition(200);
            }
            int i16 = this.realPos;
            if (index > i16) {
                this.realPos = i16 + 1;
                this.curPos++;
                return;
            } else {
                this.realPos = i16 - 1;
                this.curPos--;
                return;
            }
        }
        if (index > this.realPos) {
            k();
        } else {
            j();
        }
    }

    public /* synthetic */ DotIndicatorView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @Override // og1.b
    public void setOptions(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.options = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DotIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dotList = new ArrayList<>();
        this.options = new b();
    }
}
