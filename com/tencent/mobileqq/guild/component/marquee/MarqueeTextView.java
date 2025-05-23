package com.tencent.mobileqq.guild.component.marquee;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 h2\u00020\u0001:\u0002ijB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010a\u001a\u00020\u0018\u0012\u0006\u0010b\u001a\u00020\u0018\u00a2\u0006\u0004\bc\u0010dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bc\u0010eB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\bc\u0010fB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010a\u001a\u00020\u0018\u00a2\u0006\u0004\bc\u0010gJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u001e\u001a\u00020\u0006H\u0014J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0018H\u0014J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0015J\b\u0010%\u001a\u00020\u0006H\u0014J\b\u0010&\u001a\u00020\u0006H\u0014J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0018H\u0014J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\fH\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010.R\u0016\u00102\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00101R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010>R\u0016\u0010B\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00101R\u0016\u0010D\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00101R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010P\u001a\n M*\u0004\u0018\u00010L0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00101R\u0016\u0010X\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010IR\u0016\u0010Z\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010>R\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010`\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010]\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "c", "", "text", h.F, "l", "", "e", "", "frameTimeNanos", "k", "d", "i", "j", IECSearchBar.METHOD_SET_TEXT, "", "dp", "setTextSize", "", "color", "setTextColor", "Landroid/content/res/ColorStateList;", "setLeftAlphaWidth", "setRightAlphaWidth", "drawableStateChanged", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "visibility", "onWindowVisibilityChanged", "hasWindowFocus", "onWindowFocusChanged", "Ljava/lang/String;", "drawingText", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "paint", "f", UserInfo.SEX_FEMALE, "textWidth", "posX", "posXStart", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "posY", BdhLogUtil.LogTag.Tag_Conn, "width", "Landroid/graphics/RectF;", "D", "Landroid/graphics/RectF;", Constants.KEYS.BANNER_RF, "E", "Z", "hasInit", "isMeasuredTextWidth", "G", "leftAlphaWidth", "H", "rightAlphaWidth", "Landroid/graphics/LinearGradient;", "I", "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "J", "Landroid/content/res/ColorStateList;", "colorStateList", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "K", "Landroid/view/Choreographer;", "choreographer", "Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView$RollingState;", "L", "Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView$RollingState;", "rollingState", "M", "currentLoopRollDistance", "N", "lastFrameTimeNanos", "P", "isAttachingToWindow", "Landroid/view/Choreographer$FrameCallback;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/Choreographer$FrameCallback;", "mStartCallback", BdhLogUtil.LogTag.Tag_Req, "mTickCallback", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "RollingState", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MarqueeTextView extends View {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private float width;

    /* renamed from: D, reason: from kotlin metadata */
    private RectF rf;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isMeasuredTextWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private float leftAlphaWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private float rightAlphaWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearGradient linearGradient;

    /* renamed from: J, reason: from kotlin metadata */
    private ColorStateList colorStateList;

    /* renamed from: K, reason: from kotlin metadata */
    private final Choreographer choreographer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private RollingState rollingState;

    /* renamed from: M, reason: from kotlin metadata */
    private float currentLoopRollDistance;

    /* renamed from: N, reason: from kotlin metadata */
    private long lastFrameTimeNanos;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isAttachingToWindow;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Choreographer.FrameCallback mStartCallback;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Choreographer.FrameCallback mTickCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String drawingText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextPaint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float textWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float posX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float posXStart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float posY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView$RollingState;", "", "(Ljava/lang/String;I)V", "STARTING", DebugCoroutineInfoImplKt.RUNNING, "STOPPED", "qqguild-component_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum RollingState {
        STARTING,
        RUNNING,
        STOPPED
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView$a;", "", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/RectF;", "targetRect", "", "b", "ROLL_DISTANCE_NANO_TIMES", UserInfo.SEX_FEMALE, "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.marquee.MarqueeTextView$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(Paint paint, RectF targetRect) {
            if (paint != null && targetRect != null) {
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                Intrinsics.checkNotNullExpressionValue(fontMetrics, "paint.fontMetrics");
                float f16 = targetRect.top;
                float height = targetRect.height() - fontMetrics.bottom;
                float f17 = fontMetrics.top;
                return (f16 + ((height + f17) / 2.0f)) - f17;
            }
            return 0.0f;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.choreographer = Choreographer.getInstance();
        this.rollingState = RollingState.STOPPED;
        this.currentLoopRollDistance = 2.0f;
        c(context, attributeSet);
        this.mStartCallback = new Choreographer.FrameCallback() { // from class: com.tencent.mobileqq.guild.component.marquee.a
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j3) {
                MarqueeTextView.f(MarqueeTextView.this, j3);
            }
        };
        this.mTickCallback = new Choreographer.FrameCallback() { // from class: com.tencent.mobileqq.guild.component.marquee.b
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j3) {
                MarqueeTextView.g(MarqueeTextView.this, j3);
            }
        };
    }

    private final void c(Context context, AttributeSet attrs) {
        this.paint = new TextPaint();
        this.rf = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        TextPaint textPaint = this.paint;
        if (textPaint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            textPaint = null;
        }
        textPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, com.tencent.mobileqq.guild.component.b.Q1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tyleable.MarqueeTextView)");
        setTextSize(obtainStyledAttributes.getDimension(com.tencent.mobileqq.guild.component.b.V1, 42.0f));
        setLeftAlphaWidth(obtainStyledAttributes.getDimension(com.tencent.mobileqq.guild.component.b.R1, 0.0f));
        setRightAlphaWidth(obtainStyledAttributes.getDimension(com.tencent.mobileqq.guild.component.b.S1, 0.0f));
        int i3 = com.tencent.mobileqq.guild.component.b.U1;
        setTextColor(obtainStyledAttributes.getColor(i3, -1));
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i3);
        if (colorStateList != null) {
            setTextColor(colorStateList);
        }
        h(obtainStyledAttributes.getString(com.tencent.mobileqq.guild.component.b.T1));
        obtainStyledAttributes.recycle();
    }

    private final boolean d() {
        if ((this.width - this.leftAlphaWidth) - this.rightAlphaWidth >= this.textWidth) {
            return true;
        }
        return false;
    }

    private final boolean e() {
        float f16 = this.posXStart;
        float f17 = this.leftAlphaWidth;
        if (f16 < f17 || f16 - this.currentLoopRollDistance >= f17) {
            float f18 = this.posX;
            if (f18 < f17 || f18 - this.currentLoopRollDistance >= f17) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MarqueeTextView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rollingState = RollingState.RUNNING;
        this$0.k(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MarqueeTextView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(j3);
    }

    private final void h(String text) {
        this.drawingText = text;
        if (text != null) {
            TextPaint textPaint = this.paint;
            if (textPaint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint = null;
            }
            String str = this.drawingText;
            Intrinsics.checkNotNull(str);
            this.textWidth = textPaint.measureText(str, 0, str.length());
        }
    }

    private final void k(long frameTimeNanos) {
        float coerceAtMost;
        float f16;
        if (!this.isAttachingToWindow) {
            this.choreographer.removeFrameCallback(this.mStartCallback);
            this.choreographer.removeFrameCallback(this.mTickCallback);
            return;
        }
        if (!this.isMeasuredTextWidth) {
            this.choreographer.postFrameCallback(this.mTickCallback);
            return;
        }
        if (!d()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(((float) (frameTimeNanos - this.lastFrameTimeNanos)) * 1.2E-7f, 4.0f);
            this.currentLoopRollDistance = coerceAtMost;
            this.lastFrameTimeNanos = frameTimeNanos;
            float f17 = this.posX - coerceAtMost;
            this.posX = f17;
            float f18 = (-1) * this.textWidth;
            TextPaint textPaint = this.paint;
            TextPaint textPaint2 = null;
            if (textPaint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint = null;
            }
            if (f17 < f18 - textPaint.measureText("", 0, 0)) {
                this.posX = this.posXStart;
            }
            float f19 = this.posX + this.textWidth;
            TextPaint textPaint3 = this.paint;
            if (textPaint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint3 = null;
            }
            float f26 = 2;
            if (f19 + (textPaint3.getTextSize() * f26) < this.width) {
                float f27 = this.posX + this.textWidth;
                TextPaint textPaint4 = this.paint;
                if (textPaint4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                } else {
                    textPaint2 = textPaint4;
                }
                f16 = f27 + (textPaint2.getTextSize() * f26);
            } else {
                f16 = -1.0f;
            }
            this.posXStart = f16;
            invalidate();
            this.choreographer.removeFrameCallback(this.mTickCallback);
            if (this.rollingState == RollingState.RUNNING) {
                if (e()) {
                    this.choreographer.postFrameCallbackDelayed(this.mTickCallback, 3000L);
                    return;
                } else {
                    this.choreographer.postFrameCallback(this.mTickCallback);
                    return;
                }
            }
            this.posX = this.leftAlphaWidth;
            this.posXStart = 0.0f;
            return;
        }
        j();
    }

    private final void l() {
        List listOf;
        List listOf2;
        int[] intArray;
        float[] floatArray;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(this.leftAlphaWidth / getMeasuredWidth()), Float.valueOf(1.0f - (this.rightAlphaWidth / getMeasuredWidth())), Float.valueOf(1.0f)});
        Integer[] numArr = new Integer[4];
        numArr[0] = 0;
        TextPaint textPaint = this.paint;
        TextPaint textPaint2 = null;
        if (textPaint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            textPaint = null;
        }
        numArr[1] = Integer.valueOf(textPaint.getColor());
        TextPaint textPaint3 = this.paint;
        if (textPaint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        } else {
            textPaint2 = textPaint3;
        }
        numArr[2] = Integer.valueOf(textPaint2.getColor());
        numArr[3] = 0;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) numArr);
        float measuredWidth = getMeasuredWidth();
        intArray = CollectionsKt___CollectionsKt.toIntArray(listOf2);
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(listOf);
        this.linearGradient = new LinearGradient(0.0f, 0.0f, measuredWidth, 0.0f, intArray, floatArray, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.colorStateList;
        if (colorStateList != null) {
            TextPaint textPaint = null;
            if (colorStateList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorStateList");
                colorStateList = null;
            }
            if (colorStateList.isStateful()) {
                ColorStateList colorStateList2 = this.colorStateList;
                if (colorStateList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("colorStateList");
                    colorStateList2 = null;
                }
                int colorForState = colorStateList2.getColorForState(getDrawableState(), -256);
                TextPaint textPaint2 = this.paint;
                if (textPaint2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                    textPaint2 = null;
                }
                if (textPaint2.getColor() != colorForState) {
                    TextPaint textPaint3 = this.paint;
                    if (textPaint3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("paint");
                    } else {
                        textPaint = textPaint3;
                    }
                    textPaint.setColor(colorForState);
                    l();
                    invalidate();
                }
            }
        }
    }

    public final void i() {
        if (this.rollingState != RollingState.STOPPED) {
            return;
        }
        this.rollingState = RollingState.STARTING;
        this.choreographer.postFrameCallback(this.mStartCallback);
        invalidate();
    }

    public final void j() {
        this.rollingState = RollingState.STOPPED;
        this.choreographer.removeFrameCallback(this.mStartCallback);
        this.choreographer.removeFrameCallback(this.mTickCallback);
        this.posX = this.leftAlphaWidth;
        this.posXStart = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.isAttachingToWindow = true;
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.isAttachingToWindow = false;
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        TextPaint textPaint;
        TextPaint textPaint2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getVisibility() == 0 && !TextUtils.isEmpty(this.drawingText)) {
            canvas.save();
            TextPaint textPaint3 = this.paint;
            if (textPaint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint3 = null;
            }
            LinearGradient linearGradient = this.linearGradient;
            if (linearGradient == null) {
                Intrinsics.throwUninitializedPropertyAccessException(NodeProps.LINEAR_GRADIENT);
                linearGradient = null;
            }
            textPaint3.setShader(linearGradient);
            String str = this.drawingText;
            Intrinsics.checkNotNull(str);
            String str2 = this.drawingText;
            Intrinsics.checkNotNull(str2);
            int length = str2.length();
            float f16 = this.posX;
            float f17 = this.posY;
            TextPaint textPaint4 = this.paint;
            if (textPaint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint = null;
            } else {
                textPaint = textPaint4;
            }
            canvas.drawText(str, 0, length, f16, f17, (Paint) textPaint);
            if (this.posXStart > 0.0f) {
                String str3 = this.drawingText;
                Intrinsics.checkNotNull(str3);
                String str4 = this.drawingText;
                Intrinsics.checkNotNull(str4);
                int length2 = str4.length();
                float f18 = this.posXStart;
                float f19 = this.posY;
                TextPaint textPaint5 = this.paint;
                if (textPaint5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                    textPaint2 = null;
                } else {
                    textPaint2 = textPaint5;
                }
                canvas.drawText(str3, 0, length2, f18, f19, (Paint) textPaint2);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z16;
        boolean z17;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = View.MeasureSpec.getSize(widthMeasureSpec);
        this.isMeasuredTextWidth = true;
        int i3 = 0;
        if (getLayoutParams().height == -2) {
            z16 = true;
        } else {
            z16 = false;
        }
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        RectF rectF = null;
        if (z16) {
            TextPaint textPaint = this.paint;
            if (textPaint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint = null;
            }
            size = ((int) textPaint.getTextSize()) + 8;
        }
        if (this.posX == this.leftAlphaWidth) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !this.hasInit) {
            RectF rectF2 = this.rf;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Constants.KEYS.BANNER_RF);
                rectF2 = null;
            }
            rectF2.right = 0.0f;
            RectF rectF3 = this.rf;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Constants.KEYS.BANNER_RF);
                rectF3 = null;
            }
            rectF3.bottom = View.MeasureSpec.getSize(size);
            Companion companion = INSTANCE;
            TextPaint textPaint2 = this.paint;
            if (textPaint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                textPaint2 = null;
            }
            RectF rectF4 = this.rf;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Constants.KEYS.BANNER_RF);
            } else {
                rectF = rectF4;
            }
            float b16 = companion.b(textPaint2, rectF);
            if (z16) {
                i3 = 4;
            }
            this.posY = b16 - i3;
            this.hasInit = true;
        }
        setMeasuredDimension(widthMeasureSpec, size);
        l();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            i();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            i();
        } else {
            j();
        }
    }

    public final void setLeftAlphaWidth(float dp5) {
        this.leftAlphaWidth = dp5;
        this.posX = dp5;
        this.posXStart = 0.0f;
        l();
        invalidate();
    }

    public final void setRightAlphaWidth(float dp5) {
        this.rightAlphaWidth = dp5;
        l();
        invalidate();
    }

    public final void setText(@Nullable String text) {
        if (TextUtils.equals(text, this.drawingText)) {
            return;
        }
        h(text);
        j();
        i();
        invalidate();
    }

    public final void setTextColor(int color) {
        ColorStateList valueOf = ColorStateList.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(color)");
        setTextColor(valueOf);
    }

    public final void setTextSize(float dp5) {
        TextPaint textPaint = this.paint;
        if (textPaint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            textPaint = null;
        }
        textPaint.setTextSize(dp5);
        invalidate();
    }

    public final void setTextColor(@NotNull ColorStateList color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.colorStateList = color;
        TextPaint textPaint = this.paint;
        if (textPaint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            textPaint = null;
        }
        textPaint.setColor(color.getDefaultColor());
        l();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
