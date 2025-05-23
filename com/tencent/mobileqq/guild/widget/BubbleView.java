package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.LayoutRes;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0004JKL\bB\u001d\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0014J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0014R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010$R\u0014\u0010'\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00104\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00103R\u0014\u00106\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u00108\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u0014\u00109\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0014\u0010;\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010-R\u001c\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b<\u00103\u0012\u0004\b=\u0010>R\u001c\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b@\u00103\u0012\u0004\bA\u0010>\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BubbleView;", "Landroid/widget/RelativeLayout;", "", "g", "Lcom/tencent/mobileqq/guild/widget/BubbleView$b;", "property", "Landroid/view/View;", "targetView", "b", "", "orientation", LayoutAttrDefine.Gravity.Gravity, "d", "c", "", "width", "height", "Landroid/graphics/Matrix;", "f", "e", tl.h.F, "j", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/view/View;", "mInnerView", "Landroid/graphics/Matrix;", "mMatrix", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mFillPaint", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "mPath", "i", "mBubbleArrowPath", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/RectF;", "mRoundRect", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "mWidth", "D", "mHeight", "E", "mBubbleArrowOffset", "I", "PADDING", "G", "LEG_HALF_BASE", "H", "STROKE_WIDTH", "CORNER_RADIUS", "J", "MIN_ARROW_DISTANCE", "K", "getMOrientation$annotations", "()V", "mOrientation", "L", "getMGravity$annotations", "mGravity", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "M", "BubbleGravity", "BubbleOrientation", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class BubbleView extends RelativeLayout {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private float mWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float mHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private float mBubbleArrowOffset;

    /* renamed from: F, reason: from kotlin metadata */
    private final int PADDING;

    /* renamed from: G, reason: from kotlin metadata */
    private final int LEG_HALF_BASE;

    /* renamed from: H, reason: from kotlin metadata */
    private final float STROKE_WIDTH;

    /* renamed from: I, reason: from kotlin metadata */
    private final float CORNER_RADIUS;

    /* renamed from: J, reason: from kotlin metadata */
    private final float MIN_ARROW_DISTANCE;

    /* renamed from: K, reason: from kotlin metadata */
    private int mOrientation;

    /* renamed from: L, reason: from kotlin metadata */
    private int mGravity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mInnerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Matrix mMatrix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mFillPaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mBubbleArrowPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RectF mRoundRect;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BubbleView$BubbleGravity;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes14.dex */
    public @interface BubbleGravity {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BubbleView$BubbleOrientation;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes14.dex */
    public @interface BubbleOrientation {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BubbleView$a;", "", "Landroid/content/Context;", "context", "", "dipValue", "a", "Lcom/tencent/mobileqq/guild/widget/BubbleView$b;", "b", "", "ARROW_BOTTOM", "I", "ARROW_LEFT", "ARROW_RIGHT", "ARROW_TOP", "GRAVITY_BOTTOM", "GRAVITY_CENTER", "GRAVITY_LEFT", "GRAVITY_RIGHT", "GRAVITY_TOP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.BubbleView$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a(@NotNull Context context, float dipValue) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (dipValue * context.getResources().getDisplayMetrics().density) + 0.5f;
        }

        @NotNull
        public final b b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new b(context);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R(\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u0011\u0010\t\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\b\u0010\u000b\"\u0004\b\u0015\u0010\rR\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/BubbleView$b;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "", "b", "I", "d", "()I", tl.h.F, "(I)V", "getMOrientation$annotations", "()V", "mOrientation", "c", "g", "getMGravity$annotations", "mGravity", "f", "mBackgroundColor", "e", "i", "mViewRes", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int mOrientation;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int mGravity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mBackgroundColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @LayoutRes
        private int mViewRes;

        public b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.mBackgroundColor = -1;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* renamed from: b, reason: from getter */
        public final int getMBackgroundColor() {
            return this.mBackgroundColor;
        }

        /* renamed from: c, reason: from getter */
        public final int getMGravity() {
            return this.mGravity;
        }

        /* renamed from: d, reason: from getter */
        public final int getMOrientation() {
            return this.mOrientation;
        }

        /* renamed from: e, reason: from getter */
        public final int getMViewRes() {
            return this.mViewRes;
        }

        public final void f(int i3) {
            this.mBackgroundColor = i3;
        }

        public final void g(int i3) {
            this.mGravity = i3;
        }

        public final void h(int i3) {
            this.mOrientation = i3;
        }

        public final void i(int i3) {
            this.mViewRes = i3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BubbleView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(b property, View targetView) {
        if (property.getMViewRes() != 0) {
            View view = null;
            View inflate = LayoutInflater.from(getContext()).inflate(property.getMViewRes(), (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(property.mViewRes, null)");
            this.mInnerView = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
            } else {
                view = inflate;
            }
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
            measure(View.MeasureSpec.makeMeasureSpec(targetView.getRootView().getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(targetView.getRootView().getHeight(), Integer.MIN_VALUE));
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        throw new Exception("viewRes must not be 0");
    }

    private final void c(View targetView, int orientation) {
        if (orientation != 0) {
            if (orientation != 1) {
                if (orientation != 2) {
                    if (orientation == 3) {
                        setTranslationY(getTranslationY() - getMeasuredHeight());
                        return;
                    }
                    return;
                }
                setTranslationX(getTranslationX() - getMeasuredWidth());
                return;
            }
            setTranslationX(getTranslationX() + getMeasuredWidth());
            return;
        }
        setTranslationY(getTranslationY() + targetView.getHeight());
    }

    private final void d(View targetView, int orientation, int gravity) {
        boolean z16;
        if (gravity == 0) {
            int[] iArr = new int[2];
            targetView.getLocationInWindow(iArr);
            if (targetView.getRootView().getMeasuredWidth() < iArr[0] + (targetView.getMeasuredWidth() / 2) + (getMeasuredWidth() / 2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                gravity = 2;
            }
            if (iArr[0] + (targetView.getMeasuredWidth() / 2) < getMeasuredWidth() / 2) {
                gravity = 1;
            }
        }
        if (gravity != 0) {
            if (gravity != 1) {
                if (gravity != 2) {
                    if (gravity != 3) {
                        if (gravity == 4) {
                            if (orientation == 1 || orientation == 2) {
                                setTranslationY(getTranslationY() - (getMeasuredHeight() - targetView.getHeight()));
                                this.mBubbleArrowOffset = getMeasuredHeight() / 2;
                                if (getMeasuredHeight() > targetView.getHeight()) {
                                    this.mBubbleArrowOffset += (getMeasuredHeight() / 2) - (targetView.getHeight() / 2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (orientation == 1 || orientation == 2) {
                        this.mBubbleArrowOffset = getMeasuredHeight() / 2;
                        if (getMeasuredHeight() > targetView.getHeight()) {
                            this.mBubbleArrowOffset -= (getMeasuredHeight() / 2) - (targetView.getHeight() / 2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (orientation == 0 || orientation == 3) {
                    setTranslationX(getTranslationX() - (getMeasuredWidth() - targetView.getWidth()));
                    this.mBubbleArrowOffset = getMeasuredWidth() / 2;
                    if (getMeasuredWidth() > targetView.getWidth()) {
                        this.mBubbleArrowOffset += (getMeasuredWidth() / 2) - (targetView.getWidth() / 2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (orientation == 0 || orientation == 3) {
                this.mBubbleArrowOffset = getMeasuredWidth() / 2;
                if (getMeasuredWidth() > targetView.getWidth()) {
                    this.mBubbleArrowOffset -= (getMeasuredWidth() / 2) - (targetView.getWidth() / 2);
                    return;
                }
                return;
            }
            return;
        }
        if (orientation != 0) {
            if (orientation != 1 && orientation != 2) {
                if (orientation != 3) {
                    return;
                }
            } else {
                setTranslationY(getTranslationY() - ((getMeasuredHeight() - targetView.getHeight()) / 2));
                this.mBubbleArrowOffset = getMeasuredHeight() / 2;
                return;
            }
        }
        setTranslationX(getTranslationX() - ((getMeasuredWidth() - targetView.getWidth()) / 2));
        this.mBubbleArrowOffset = getMeasuredWidth() / 2;
    }

    private final Matrix f(float width, float height) {
        float f16 = this.mBubbleArrowOffset;
        float min = Math.min(f16, height - this.MIN_ARROW_DISTANCE);
        Matrix matrix = new Matrix();
        int i3 = this.mOrientation;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        height = min;
                    } else {
                        width = Math.min(f16, width - this.MIN_ARROW_DISTANCE);
                        matrix.postRotate(270.0f);
                        setPadding(0, 0, 0, this.PADDING);
                        setGravity(17);
                        this.mRoundRect = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight - this.PADDING);
                    }
                } else {
                    height = Math.min(f16, height - this.MIN_ARROW_DISTANCE);
                    matrix.postRotate(180.0f);
                    setPadding(0, 0, this.PADDING, 0);
                    setGravity(17);
                    this.mRoundRect = new RectF(0.0f, 0.0f, this.mWidth - this.PADDING, this.mHeight);
                }
            } else {
                height = Math.min(f16, height - this.MIN_ARROW_DISTANCE);
                setPadding(this.PADDING, 0, 0, 0);
                setGravity(17);
                this.mRoundRect = new RectF(this.PADDING, 0.0f, this.mWidth, this.mHeight);
            }
            width = 0.0f;
        } else {
            width = Math.min(f16, width - this.MIN_ARROW_DISTANCE);
            matrix.postRotate(90.0f);
            setPadding(0, this.PADDING, 0, 0);
            setGravity(17);
            this.mRoundRect = new RectF(0.0f, this.PADDING, this.mWidth, this.mHeight);
            height = 0.0f;
        }
        matrix.postTranslate(width, height);
        return matrix;
    }

    private final void g() {
        this.mBubbleArrowPath.moveTo(0.0f, 0.0f);
        Path path = this.mBubbleArrowPath;
        int i3 = this.PADDING;
        path.lineTo(i3, -i3);
        Path path2 = this.mBubbleArrowPath;
        int i16 = this.PADDING;
        path2.lineTo(i16, i16);
        this.mBubbleArrowPath.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BubbleView this$0, b property, View targetView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(property, "$property");
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        this$0.b(property, targetView);
        View rootView = targetView.getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).getOverlay().add(this$0);
        int measuredWidth = this$0.getMeasuredWidth();
        View view = this$0.mInnerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
            view = null;
        }
        int measuredWidth2 = (measuredWidth - view.getMeasuredWidth()) / 2;
        int measuredHeight = this$0.getMeasuredHeight() - this$0.PADDING;
        View view3 = this$0.mInnerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
            view3 = null;
        }
        int measuredHeight2 = ((measuredHeight - view3.getMeasuredHeight()) / 2) + this$0.PADDING;
        View view4 = this$0.mInnerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
        } else {
            view2 = view4;
        }
        view2.layout(measuredWidth2, measuredHeight2, this$0.getMeasuredWidth() + measuredWidth2, this$0.getMeasuredHeight() + measuredHeight2);
        k(this$0, targetView, 0, 0, 6, null);
    }

    public static /* synthetic */ void k(BubbleView bubbleView, View view, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = bubbleView.mOrientation;
        }
        if ((i17 & 4) != 0) {
            i16 = bubbleView.mGravity;
        }
        bubbleView.j(view, i3, i16);
    }

    public final void e(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        View rootView = targetView.getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).getOverlay().remove(this);
    }

    public final void h(@NotNull final b property, @NotNull final View targetView) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.mOrientation = property.getMOrientation();
        this.mGravity = property.getMGravity();
        this.mFillPaint.setColor(property.getMBackgroundColor());
        targetView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                BubbleView.i(BubbleView.this, property, targetView);
            }
        });
    }

    public final void j(@NotNull View targetView, int orientation, int gravity) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        targetView.getLocationInWindow(new int[2]);
        setTranslationX(r0[0]);
        setTranslationY(r0[1]);
        c(targetView, orientation);
        d(targetView, orientation, gravity);
        this.mMatrix = f(this.mWidth, this.mHeight);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mMatrix != null) {
            this.mPath.rewind();
            Path path = this.mPath;
            RectF rectF = this.mRoundRect;
            Matrix matrix = null;
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
                rectF = null;
            }
            float f16 = this.CORNER_RADIUS;
            path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
            Path path2 = this.mPath;
            Path path3 = this.mBubbleArrowPath;
            Matrix matrix2 = this.mMatrix;
            if (matrix2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMatrix");
            } else {
                matrix = matrix2;
            }
            path2.addPath(path3, matrix);
            canvas.drawPath(this.mPath, this.mFillPaint);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View view = this.mInnerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
            view = null;
        }
        view.measure(widthMeasureSpec, heightMeasureSpec);
        View view3 = this.mInnerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
            view3 = null;
        }
        int measuredWidth = view3.getMeasuredWidth();
        View view4 = this.mInnerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerView");
        } else {
            view2 = view4;
        }
        int measuredHeight = view2.getMeasuredHeight();
        int i3 = this.mOrientation;
        if (i3 != 2 && i3 != 1) {
            measuredHeight += this.PADDING;
        } else {
            measuredWidth += this.PADDING;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    public /* synthetic */ BubbleView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BubbleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.mFillPaint = paint;
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        this.mBubbleArrowOffset = 0.75f;
        Companion companion = INSTANCE;
        this.PADDING = (int) companion.a(context, 7.0f);
        this.LEG_HALF_BASE = (int) companion.a(context, 6.0f);
        this.STROKE_WIDTH = 2.0f;
        this.CORNER_RADIUS = companion.a(context, 6.0f);
        this.MIN_ARROW_DISTANCE = r1 + r3;
        this.mOrientation = 1;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2.0f);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setColor(context.getResources().getColor(R.color.f158017al3));
        setLayerType(1, paint);
        g();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
