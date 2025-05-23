package com.tencent.mobileqq.guild.gift.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.gift.view.GiftBannerWipesAnimationView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import up1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u00a2\u0006\u0004\b;\u0010<J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0014\u0010%\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\"R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\"R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00100R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\"\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/gift/view/GiftBannerWipesAnimationView;", "Landroid/view/View;", "", "w", h.F, "repeatCount", "", "duration", "", "b", "d", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", NodeProps.ON_DETACHED_FROM_WINDOW, "", NodeProps.COLORS, "", "positions", "setColorAndPositions", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "path", "Landroid/animation/ValueAnimator;", "f", "Landroid/animation/ValueAnimator;", "valueAnimator", "I", "radius", "i", "clipPath", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, BdhLogUtil.LogTag.Tag_Conn, "[I", "D", "[F", "E", "playMode", UserInfo.SEX_FEMALE, "G", "", "H", "mk", "mw", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GiftBannerWipesAnimationView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private int[] colors;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private float[] positions;

    /* renamed from: E, reason: from kotlin metadata */
    private int playMode;

    /* renamed from: F, reason: from kotlin metadata */
    private int duration;

    /* renamed from: G, reason: from kotlin metadata */
    private int repeatCount;

    /* renamed from: H, reason: from kotlin metadata */
    private float mk;

    /* renamed from: I, reason: from kotlin metadata */
    private int mw;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator valueAnimator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int radius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path clipPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF rect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftBannerWipesAnimationView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(int w3, int h16, int repeatCount, long duration) {
        this.path.moveTo(0.0f, 0.0f);
        float f16 = w3;
        this.path.lineTo(f16, 0.0f);
        float f17 = h16;
        this.path.lineTo(f16, f17);
        this.path.lineTo(0.0f, f17);
        this.path.close();
        final float f18 = this.mk;
        if (this.mw < 0) {
            this.mw = w3 / 3;
        }
        final float f19 = this.mw;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.cancel();
        }
        float f26 = 2 * f19;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f - f26, f16 + f26);
        this.valueAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(repeatCount);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(duration);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: no1.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    GiftBannerWipesAnimationView.c(f18, f19, this, valueAnimator2);
                }
            });
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(float f16, float f17, GiftBannerWipesAnimationView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f18 = floatValue + f17;
        this$0.paint.setShader(new LinearGradient(floatValue, f16 * floatValue, f18, f16 * f18, this$0.colors, this$0.positions, Shader.TileMode.CLAMP));
        this$0.invalidate();
    }

    public final void d(long duration, int repeatCount) {
        b(getWidth(), getHeight(), repeatCount, duration);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.cancel();
        }
        this.valueAnimator = null;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.clipPath.reset();
        if (this.radius < 0) {
            this.radius = getHeight() / 2;
        }
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.clipPath;
        RectF rectF = this.rect;
        int i3 = this.radius;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        canvas.clipPath(this.clipPath);
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.playMode == 1) {
            b(size, size2, this.repeatCount, this.duration);
        }
    }

    public final void setColorAndPositions(@NotNull int[] colors, @NotNull float[] positions) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(positions, "positions");
        if (colors.length == positions.length) {
            this.colors = colors;
            this.positions = positions;
            return;
        }
        throw new RuntimeException("colors and positions \u6570\u7ec4\u5927\u5c0f\u5fc5\u987b\u4e00\u81f4");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftBannerWipesAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GiftBannerWipesAnimationView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftBannerWipesAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint();
        this.path = new Path();
        this.radius = -1;
        this.clipPath = new Path();
        this.rect = new RectF();
        this.colors = new int[]{16777215, 570425343, 1912602623, 16777215};
        this.positions = new float[]{0.0f, 0.4f, 0.5f, 1.0f};
        this.playMode = 1;
        this.duration = 800;
        this.repeatCount = -1;
        this.mk = 0.45f;
        this.mw = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f439529i2);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026BannerWipesAnimationView)");
            String string = obtainStyledAttributes.getString(a.f439542j2);
            String string2 = obtainStyledAttributes.getString(a.f439591n2);
            if (string != null && string2 != null) {
                List<String> split = new Regex(",").split(string, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                List<String> split2 = new Regex(",").split(string2, 0);
                if (!split2.isEmpty()) {
                    ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                    while (listIterator2.hasPrevious()) {
                        if (!(listIterator2.previous().length() == 0)) {
                            emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                Object[] array2 = emptyList2.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array2;
                int length = strArr.length;
                if (length == strArr2.length) {
                    this.colors = new int[length];
                    this.positions = new float[length];
                    for (int i16 = 0; i16 < length; i16++) {
                        this.colors[i16] = Color.parseColor(strArr[i16]);
                        this.positions[i16] = Float.parseFloat(strArr2[i16]);
                    }
                }
            }
            this.playMode = obtainStyledAttributes.getInt(a.f439579m2, this.playMode);
            int i17 = obtainStyledAttributes.getInt(a.f439616p2, this.repeatCount);
            this.repeatCount = i17;
            if (i17 < 0 && i17 != -1) {
                this.repeatCount = -1;
            }
            this.duration = obtainStyledAttributes.getInt(a.f439555k2, this.duration);
            this.radius = obtainStyledAttributes.getDimensionPixelSize(a.f439603o2, this.radius);
            this.mk = obtainStyledAttributes.getFloat(a.f439567l2, this.mk);
            this.mw = obtainStyledAttributes.getDimensionPixelSize(a.f439629q2, this.mw);
            obtainStyledAttributes.recycle();
        }
    }
}
