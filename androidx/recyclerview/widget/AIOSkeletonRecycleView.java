package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.base.tool.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001JB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u00a2\u0006\u0004\bC\u0010GB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\u0006\u0010H\u001a\u00020\u0014\u00a2\u0006\u0004\bC\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u000f\u0010\u0011\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR\u001b\u0010'\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010 \u001a\u0004\b1\u0010.R!\u00107\u001a\b\u0012\u0004\u0012\u00020\n038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010 \u001a\u0004\b5\u00106R\u0014\u00108\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010 \u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00109\u00a8\u0006K"}, d2 = {"Landroidx/recyclerview/widget/AIOSkeletonRecycleView;", "Landroidx/recyclerview/widget/InnerAIORecycleView;", "Landroid/content/Context;", "context", "", "init", "updateSkeletonColors", "updateSkeletonGradient", "", "noAvatar", "Lcom/tencent/aio/widget/skeleton/c;", "getNewSkeleton", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "showSkeleton$sdk_debug", "()V", "showSkeleton", "hideSkeleton$sdk_debug", "hideSkeleton", "", "key_listSelector_color", "I", "skeletonColor0", "skeletonColor1", "Landroid/graphics/LinearGradient;", "skeletonGradient", "Landroid/graphics/LinearGradient;", "skeletonGradientWidth", "skeletonTotalTranslation", "Landroid/graphics/Paint;", "skeletonPaint$delegate", "Lkotlin/Lazy;", "getSkeletonPaint", "()Landroid/graphics/Paint;", "skeletonPaint", "skeletonOutlineGradient", "skeletonOutlinePaint$delegate", "getSkeletonOutlinePaint", "skeletonOutlinePaint", "", "skeletonLastUpdateTime", "J", "Landroid/graphics/Matrix;", "skeletonMatrix$delegate", "getSkeletonMatrix", "()Landroid/graphics/Matrix;", "skeletonMatrix", "skeletonOutlineMatrix$delegate", "getSkeletonOutlineMatrix", "skeletonOutlineMatrix", "Ljava/util/ArrayList;", "messageSkeletons$delegate", "getMessageSkeletons", "()Ljava/util/ArrayList;", "messageSkeletons", "fragmentBeginToShow", "Z", "Lcom/tencent/aio/widget/skeleton/d;", "skeletonBackgroundCacheParams$delegate", "getSkeletonBackgroundCacheParams", "()Lcom/tencent/aio/widget/skeleton/d;", "skeletonBackgroundCacheParams", "Lcom/tencent/aio/widget/skeleton/b;", "skeletonBackgroundDrawable", "Lcom/tencent/aio/widget/skeleton/b;", "isSkeletonVisible", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class AIOSkeletonRecycleView extends InnerAIORecycleView {
    private static final int SKELETON_DISAPPEAR_MS = 200;
    private static final int SKELETON_LIGHT_OVERLAY_ALPHA = 22;
    private static final String TAG = "AIOSkeletonRecycleView";
    private final boolean fragmentBeginToShow;
    private boolean isSkeletonVisible;
    private final int key_listSelector_color;

    /* renamed from: messageSkeletons$delegate, reason: from kotlin metadata */
    private final Lazy messageSkeletons;

    /* renamed from: skeletonBackgroundCacheParams$delegate, reason: from kotlin metadata */
    private final Lazy skeletonBackgroundCacheParams;
    private final com.tencent.aio.widget.skeleton.b skeletonBackgroundDrawable;
    private int skeletonColor0;
    private int skeletonColor1;
    private LinearGradient skeletonGradient;
    private int skeletonGradientWidth;
    private long skeletonLastUpdateTime;

    /* renamed from: skeletonMatrix$delegate, reason: from kotlin metadata */
    private final Lazy skeletonMatrix;
    private LinearGradient skeletonOutlineGradient;

    /* renamed from: skeletonOutlineMatrix$delegate, reason: from kotlin metadata */
    private final Lazy skeletonOutlineMatrix;

    /* renamed from: skeletonOutlinePaint$delegate, reason: from kotlin metadata */
    private final Lazy skeletonOutlinePaint;

    /* renamed from: skeletonPaint$delegate, reason: from kotlin metadata */
    private final Lazy skeletonPaint;
    private int skeletonTotalTranslation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOSkeletonRecycleView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        this.key_listSelector_color = RecentBaseData.MENU_FLAG_MASK_CANCEL_HIDE;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonPaint$2.INSTANCE);
        this.skeletonPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonOutlinePaint$2.INSTANCE);
        this.skeletonOutlinePaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonMatrix$2.INSTANCE);
        this.skeletonMatrix = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonOutlineMatrix$2.INSTANCE);
        this.skeletonOutlineMatrix = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$messageSkeletons$2.INSTANCE);
        this.messageSkeletons = lazy5;
        this.fragmentBeginToShow = true;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonBackgroundCacheParams$2.INSTANCE);
        this.skeletonBackgroundCacheParams = lazy6;
        this.skeletonBackgroundDrawable = new com.tencent.aio.widget.skeleton.b(new com.tencent.aio.widget.skeleton.a() { // from class: androidx.recyclerview.widget.AIOSkeletonRecycleView$skeletonBackgroundDrawable$1
            @Override // com.tencent.aio.widget.skeleton.a
            public final int getBubbleRadius() {
                a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
                Context context2 = AIOSkeletonRecycleView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                return companion.b(context2, 30);
            }
        });
        init(context);
    }

    private final ArrayList<com.tencent.aio.widget.skeleton.c> getMessageSkeletons() {
        return (ArrayList) this.messageSkeletons.getValue();
    }

    private final com.tencent.aio.widget.skeleton.c getNewSkeleton(boolean noAvatar) {
        int b16;
        com.tencent.aio.widget.skeleton.c cVar = new com.tencent.aio.widget.skeleton.c();
        a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int b17 = companion.b(context, 64);
        Random random = com.tencent.aio.runtime.d.f69808b;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        cVar.f69989b = b17 + random.nextInt(companion.b(context2, 64));
        float width = getWidth() * 0.8f;
        if (noAvatar) {
            b16 = 0;
        } else {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            b16 = companion.b(context3, 42);
        }
        double d16 = width - b16;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        cVar.f69988a = (int) Math.min(d16, companion.b(context4, 42) + (((com.tencent.aio.runtime.d.f69808b.nextFloat() * 0.35f) + 0.4f) * getWidth()));
        return cVar;
    }

    private final com.tencent.aio.widget.skeleton.d getSkeletonBackgroundCacheParams() {
        return (com.tencent.aio.widget.skeleton.d) this.skeletonBackgroundCacheParams.getValue();
    }

    private final Matrix getSkeletonMatrix() {
        return (Matrix) this.skeletonMatrix.getValue();
    }

    private final Matrix getSkeletonOutlineMatrix() {
        return (Matrix) this.skeletonOutlineMatrix.getValue();
    }

    private final Paint getSkeletonOutlinePaint() {
        return (Paint) this.skeletonOutlinePaint.getValue();
    }

    private final Paint getSkeletonPaint() {
        return (Paint) this.skeletonPaint.getValue();
    }

    private final void init(Context context) {
        getSkeletonOutlinePaint().setStyle(Paint.Style.STROKE);
        getSkeletonOutlinePaint().setStrokeWidth(com.tencent.aio.base.tool.a.INSTANCE.b(context, 1));
    }

    private final void updateSkeletonColors() {
        int blendARGB = ColorUtils.blendARGB(this.key_listSelector_color, Color.argb(3, 255, 255, 255), 0.5f);
        int alphaComponent = ColorUtils.setAlphaComponent(this.key_listSelector_color, 22);
        if (this.skeletonColor1 != alphaComponent || this.skeletonColor0 != blendARGB) {
            this.skeletonColor0 = blendARGB;
            this.skeletonColor1 = alphaComponent;
            a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.skeletonGradientWidth = companion.b(context, 200);
            this.skeletonGradient = new LinearGradient(0.0f, 0.0f, this.skeletonGradientWidth, 0.0f, new int[]{alphaComponent, blendARGB, blendARGB, alphaComponent}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
            this.skeletonTotalTranslation = (-this.skeletonGradientWidth) * 2;
            getSkeletonPaint().setShader(this.skeletonGradient);
            int argb = Color.argb(96, 255, 255, 255);
            this.skeletonOutlineGradient = new LinearGradient(0.0f, 0.0f, this.skeletonGradientWidth, 0.0f, new int[]{0, argb, argb, 0}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
            getSkeletonOutlinePaint().setShader(this.skeletonOutlineGradient);
        }
    }

    private final void updateSkeletonGradient() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long abs = (long) Math.abs(this.skeletonLastUpdateTime - elapsedRealtime);
        if (abs > 17) {
            abs = 16;
        }
        if (abs < 4) {
            abs = 0;
        }
        int width = getWidth();
        this.skeletonLastUpdateTime = elapsedRealtime;
        int i3 = (int) (this.skeletonTotalTranslation + (((float) (abs * width)) / 400.0f));
        this.skeletonTotalTranslation = i3;
        if (i3 >= width * 2) {
            this.skeletonTotalTranslation = (-this.skeletonGradientWidth) * 2;
        }
        getSkeletonMatrix().setTranslate(this.skeletonTotalTranslation, 0.0f);
        LinearGradient linearGradient = this.skeletonGradient;
        if (linearGradient != null) {
            Intrinsics.checkNotNull(linearGradient);
            linearGradient.setLocalMatrix(getSkeletonMatrix());
        }
        getSkeletonOutlineMatrix().setTranslate(this.skeletonTotalTranslation, 0.0f);
        LinearGradient linearGradient2 = this.skeletonOutlineGradient;
        if (linearGradient2 != null) {
            Intrinsics.checkNotNull(linearGradient2);
            linearGradient2.setLocalMatrix(getSkeletonOutlineMatrix());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(@NotNull Canvas canvas) {
        com.tencent.aio.widget.skeleton.c cVar;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getChildCount() == 0 && this.isSkeletonVisible) {
            updateSkeletonColors();
            updateSkeletonGradient();
            int height = getHeight();
            if (this.isSkeletonVisible) {
                int alpha = getSkeletonPaint().getAlpha();
                int alpha2 = getSkeletonOutlinePaint().getAlpha();
                int i3 = 0;
                while (height > 0) {
                    a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    int a16 = height - companion.a(context, 3.0f);
                    if (i3 >= getMessageSkeletons().size()) {
                        cVar = getNewSkeleton(false);
                        getMessageSkeletons().add(cVar);
                    } else {
                        com.tencent.aio.widget.skeleton.c cVar2 = getMessageSkeletons().get(i3);
                        Intrinsics.checkNotNullExpressionValue(cVar2, "messageSkeletons[j]");
                        cVar = cVar2;
                    }
                    cVar.f69990c = a16;
                    height = a16 - cVar.f69989b;
                    i3++;
                }
                if (getMessageSkeletons().isEmpty()) {
                    getHeight();
                } else {
                    int i16 = getMessageSkeletons().get(0).f69990c;
                    a.Companion companion2 = com.tencent.aio.base.tool.a.INSTANCE;
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    companion2.a(context2, 3.0f);
                }
                int size = getMessageSkeletons().size();
                for (int i17 = 0; i17 < size; i17++) {
                    a.Companion companion3 = com.tencent.aio.base.tool.a.INSTANCE;
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    companion3.a(context3, 3.0f);
                    com.tencent.aio.widget.skeleton.c cVar3 = getMessageSkeletons().get(i17);
                    Intrinsics.checkNotNullExpressionValue(cVar3, "messageSkeletons[i]");
                    com.tencent.aio.widget.skeleton.c cVar4 = cVar3;
                    int i18 = cVar4.f69990c;
                    com.tencent.aio.widget.skeleton.b bVar = this.skeletonBackgroundDrawable;
                    Context context4 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "context");
                    bVar.setBounds(companion3.b(context4, 51), i18 - cVar4.f69989b, cVar4.f69988a, i18);
                    this.skeletonBackgroundDrawable.b(canvas, getSkeletonBackgroundCacheParams(), getSkeletonPaint());
                    this.skeletonBackgroundDrawable.b(canvas, getSkeletonBackgroundCacheParams(), getSkeletonOutlinePaint());
                    Context context5 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "context");
                    float b16 = companion3.b(context5, 27);
                    Context context6 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context6, "context");
                    float b17 = i18 - companion3.b(context6, 21);
                    Context context7 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context7, "context");
                    canvas.drawCircle(b16, b17, companion3.b(context7, 21), getSkeletonPaint());
                    Context context8 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context8, "context");
                    float b18 = companion3.b(context8, 27);
                    Context context9 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context9, "context");
                    float b19 = i18 - companion3.b(context9, 21);
                    Context context10 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context10, "context");
                    canvas.drawCircle(b18, b19, companion3.b(context10, 21), getSkeletonOutlinePaint());
                }
                getSkeletonPaint().setAlpha(alpha);
                getSkeletonOutlinePaint().setAlpha(alpha2);
                invalidate();
            }
            super.draw(canvas);
            return;
        }
        if (!getMessageSkeletons().isEmpty()) {
            getMessageSkeletons().clear();
        }
        super.draw(canvas);
    }

    public final void hideSkeleton$sdk_debug() {
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d(TAG, "hideSkeleton");
        }
        this.isSkeletonVisible = false;
        invalidate();
    }

    public final void showSkeleton$sdk_debug() {
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d(TAG, "showSkeleton");
        }
        this.isSkeletonVisible = true;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOSkeletonRecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        this.key_listSelector_color = RecentBaseData.MENU_FLAG_MASK_CANCEL_HIDE;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonPaint$2.INSTANCE);
        this.skeletonPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonOutlinePaint$2.INSTANCE);
        this.skeletonOutlinePaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonMatrix$2.INSTANCE);
        this.skeletonMatrix = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonOutlineMatrix$2.INSTANCE);
        this.skeletonOutlineMatrix = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$messageSkeletons$2.INSTANCE);
        this.messageSkeletons = lazy5;
        this.fragmentBeginToShow = true;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonBackgroundCacheParams$2.INSTANCE);
        this.skeletonBackgroundCacheParams = lazy6;
        this.skeletonBackgroundDrawable = new com.tencent.aio.widget.skeleton.b(new com.tencent.aio.widget.skeleton.a() { // from class: androidx.recyclerview.widget.AIOSkeletonRecycleView$skeletonBackgroundDrawable$1
            @Override // com.tencent.aio.widget.skeleton.a
            public final int getBubbleRadius() {
                a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
                Context context2 = AIOSkeletonRecycleView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                return companion.b(context2, 30);
            }
        });
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOSkeletonRecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        this.key_listSelector_color = RecentBaseData.MENU_FLAG_MASK_CANCEL_HIDE;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonPaint$2.INSTANCE);
        this.skeletonPaint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonOutlinePaint$2.INSTANCE);
        this.skeletonOutlinePaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonMatrix$2.INSTANCE);
        this.skeletonMatrix = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonOutlineMatrix$2.INSTANCE);
        this.skeletonOutlineMatrix = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$messageSkeletons$2.INSTANCE);
        this.messageSkeletons = lazy5;
        this.fragmentBeginToShow = true;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AIOSkeletonRecycleView$skeletonBackgroundCacheParams$2.INSTANCE);
        this.skeletonBackgroundCacheParams = lazy6;
        this.skeletonBackgroundDrawable = new com.tencent.aio.widget.skeleton.b(new com.tencent.aio.widget.skeleton.a() { // from class: androidx.recyclerview.widget.AIOSkeletonRecycleView$skeletonBackgroundDrawable$1
            @Override // com.tencent.aio.widget.skeleton.a
            public final int getBubbleRadius() {
                a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
                Context context2 = AIOSkeletonRecycleView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                return companion.b(context2, 30);
            }
        });
        init(context);
    }
}
