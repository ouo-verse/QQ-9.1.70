package com.tencent.mobileqq.qqlive.widget.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.util.c;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 N2\u00020\u0001:\u0001\u000fB\u001d\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u000f\u001a\u00020\b*\u0004\u0018\u00010\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\f\u0010\u0011\u001a\u00020\u0010*\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0012\u0010\u0013\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J \u0010\u0014\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\u0015\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\u0016\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\u001c\u0010\u001b\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J(\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0014J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0014R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010$R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010$R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010$R\u0014\u0010/\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010.R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00105R\u0014\u0010?\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00102R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00105R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "e", "f", "Landroid/graphics/Paint;", "", NodeProps.COLORS, "", "positions", "Landroid/graphics/RectF;", "drawRectF", "g", "", "", "a", "", h.F, "i", "j", "setTextColor", "setBorderColor", "setBackgroundColor", "", "text", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", UserInfo.SEX_FEMALE, "strokeWidth", "borderOffset", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "width", BdhLogUtil.LogTag.Tag_Conn, "height", "D", "roundCorner", "E", "Landroid/graphics/RectF;", "textRectF", "backgroundRect", "G", "[I", "textColors", "H", "[F", "textColorsPositions", "I", "Landroid/graphics/Paint;", "borderPaint", "J", "borderColors", "K", "borderColorsPositions", "L", "backgroundPaint", "M", NodeProps.BACKGROUND_COLORS, "N", "backgroundColorsPositions", "Ljava/text/DecimalFormat;", "P", "Ljava/text/DecimalFormat;", "df", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GradientBarrageView extends AppCompatTextView {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float height;

    /* renamed from: D, reason: from kotlin metadata */
    private float roundCorner;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RectF textRectF;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RectF backgroundRect;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private int[] textColors;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private float[] textColorsPositions;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Paint borderPaint;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private int[] borderColors;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private float[] borderColorsPositions;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Paint backgroundPaint;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private int[] backgroundColors;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private float[] backgroundColorsPositions;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final DecimalFormat df;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float strokeWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float borderOffset;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBarrageView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (r2 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float[] a(float[] fArr, List<String> list) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if (fArr != null && fArr.length == list.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int length = fArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    float f16 = fArr[i3];
                    if (f16 >= 0.0f && f16 <= 1.0f) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (z18) {
                        z17 = false;
                        break;
                    }
                    i3++;
                } else {
                    z17 = true;
                    break;
                }
            }
        }
        z19 = false;
        if (z19) {
            if (fArr == null) {
                return j(list);
            }
            return fArr;
        }
        return j(list);
    }

    private final void e() {
        f();
        invalidate();
    }

    private final void f() {
        RectF rectF = this.textRectF;
        rectF.left = getPaddingLeft();
        rectF.right = (this.width - getPaddingLeft()) - getPaddingRight();
        RectF rectF2 = this.backgroundRect;
        float f16 = this.borderOffset;
        rectF2.left = f16;
        rectF2.top = f16;
        rectF2.right = this.width - f16;
        rectF2.bottom = this.height - f16;
        TextPaint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        g(paint, this.textColors, this.textColorsPositions, this.textRectF);
        g(this.borderPaint, this.borderColors, this.borderColorsPositions, this.backgroundRect);
        g(this.backgroundPaint, this.backgroundColors, this.backgroundColorsPositions, this.backgroundRect);
    }

    private final void g(Paint paint, int[] iArr, float[] fArr, RectF rectF) {
        int first;
        if (iArr.length == 1) {
            first = ArraysKt___ArraysKt.first(iArr);
            paint.setColor(first);
            paint.setShader(null);
        } else if (iArr.length > 1) {
            try {
                float f16 = this.height / 2;
                paint.setColor(-1);
                paint.setShader(new LinearGradient(rectF.left, f16, rectF.right, f16, iArr, fArr, Shader.TileMode.CLAMP));
            } catch (Exception unused) {
                paint.setColor(-1);
                paint.setShader(null);
            }
        }
    }

    private final int h(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    private final int[] i(List<String> list) {
        int collectionSizeOrDefault;
        int[] intArray;
        List<String> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(h((String) it.next())));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        return intArray;
    }

    private final float[] j(List<String> list) {
        float[] floatArray;
        float size = list.size() - 1.0f;
        int size2 = list.size();
        ArrayList arrayList = new ArrayList(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            String format = this.df.format(Float.valueOf(i3 / size));
            Intrinsics.checkNotNullExpressionValue(format, "df.format(index / base)");
            arrayList.add(Float.valueOf(Float.parseFloat(format)));
        }
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
        return floatArray;
    }

    public static /* synthetic */ void setBackgroundColor$default(GradientBarrageView gradientBarrageView, List list, float[] fArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fArr = null;
        }
        gradientBarrageView.setBackgroundColor(list, fArr);
    }

    public static /* synthetic */ void setBorderColor$default(GradientBarrageView gradientBarrageView, List list, float[] fArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fArr = null;
        }
        gradientBarrageView.setBorderColor(list, fArr);
    }

    public static /* synthetic */ void setTextColor$default(GradientBarrageView gradientBarrageView, List list, float[] fArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fArr = null;
        }
        gradientBarrageView.setTextColor(list, fArr);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z17 = false;
        if (this.backgroundColors.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            RectF rectF = this.backgroundRect;
            float f16 = this.roundCorner;
            canvas.drawRoundRect(rectF, f16, f16, this.backgroundPaint);
        }
        if (this.borderColors.length == 0) {
            z17 = true;
        }
        if (!z17) {
            RectF rectF2 = this.backgroundRect;
            float f17 = this.roundCorner;
            canvas.drawRoundRect(rectF2, f17, f17, this.borderPaint);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.width = w3;
        float f16 = h16;
        this.height = f16;
        this.roundCorner = f16 / 2;
        f();
    }

    public final void setBackgroundColor(@NotNull List<String> colors, @Nullable float[] positions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colors, (Object) positions);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.backgroundColors = i(colors);
        this.backgroundColorsPositions = a(positions, colors);
        e();
    }

    public final void setBorderColor(@NotNull List<String> colors, @Nullable float[] positions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colors, (Object) positions);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.borderColors = i(colors);
        this.borderColorsPositions = a(positions, colors);
        e();
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) text, (Object) type);
            return;
        }
        if (c.d(String.valueOf(text))) {
            text = new QQText(c.a(String.valueOf(text)), 3, 16);
        }
        super.setText(text, type);
    }

    public final void setTextColor(@NotNull List<String> colors, @Nullable float[] positions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) colors, (Object) positions);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.textColors = i(colors);
        this.textColorsPositions = a(positions, colors);
        e();
    }

    public /* synthetic */ GradientBarrageView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBarrageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        float d16 = wi2.c.d(1);
        this.strokeWidth = d16;
        this.borderOffset = d16 / 2;
        this.textRectF = new RectF();
        this.backgroundRect = new RectF();
        this.textColors = new int[]{-1};
        this.textColorsPositions = new float[]{1.0f};
        Paint paint = new Paint();
        this.borderPaint = paint;
        this.borderColors = new int[0];
        this.borderColorsPositions = new float[0];
        Paint paint2 = new Paint();
        this.backgroundPaint = paint2;
        this.backgroundColors = new int[0];
        this.backgroundColorsPositions = new float[0];
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.df = decimalFormat;
        setTextColor(-1);
        setSingleLine();
        setTextSize(1, 14.0f);
        paint.setStrokeWidth(d16);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        decimalFormat.setRoundingMode(RoundingMode.UP);
    }
}
