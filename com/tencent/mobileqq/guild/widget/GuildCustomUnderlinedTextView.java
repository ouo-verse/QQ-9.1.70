package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 <2\u00020\u0001:\u0001\tB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0006\u00a2\u0006\u0004\b:\u0010;J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010*R$\u00101\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00107\u001a\u00020\r2\u0006\u00102\u001a\u00020\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildCustomUnderlinedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "", "a", "offset", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "b", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Rect;", tl.h.F, "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "mPaint", "Landroid/text/StaticLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/text/StaticLayout;", "mStaticLayout", "Ljava/lang/reflect/Field;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/reflect/Field;", "mFieldMaximumVisibleLineCount", "D", UserInfo.SEX_FEMALE, "mUnderlinePadding", "E", "mStrokeWidth", "I", "mUnderLineColor", "mColor", "getUnderLineColor", "()I", "setUnderLineColor", "(I)V", "underLineColor", "width", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCustomUnderlinedTextView extends AppCompatTextView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Field mFieldMaximumVisibleLineCount;

    /* renamed from: D, reason: from kotlin metadata */
    private float mUnderlinePadding;

    /* renamed from: E, reason: from kotlin metadata */
    private float mStrokeWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int mUnderLineColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect mRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Paint mPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StaticLayout mStaticLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCustomUnderlinedTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context, AttributeSet attributeSet, int defStyle) {
        float f16 = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.Xb, defStyle, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026le, defStyle, 0\n        )");
        this.mUnderLineColor = obtainStyledAttributes.getColor(up1.a.Yb, ContextCompat.getColor(context, R.color.guild_skin_content_text));
        this.mStrokeWidth = obtainStyledAttributes.getDimension(up1.a.f439427ac, f16 * 2);
        this.mUnderlinePadding = obtainStyledAttributes.getDimension(up1.a.Zb, 1.0f);
        obtainStyledAttributes.recycle();
        this.mRect = new Rect();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.mUnderLineColor);
        paint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint = paint;
    }

    private final float b(int offset, Layout layout) {
        try {
            return layout.getPrimaryHorizontal(offset);
        } catch (Throwable unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[safeGetPrimaryHorizontal] ");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildCustomUnderlinedTextView", 1, (String) it.next(), null);
            }
            return 0.0f;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        float b16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int lineCount = getLineCount();
        Layout layout = getLayout();
        float f16 = 0.0f;
        int i3 = 0;
        while (i3 < lineCount) {
            if (i3 == lineCount - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int lineBounds = (int) (getLineBounds(i3, this.mRect) + this.mUnderlinePadding);
            int lineStart = layout.getLineStart(i3);
            int lineEnd = layout.getLineEnd(i3);
            Intrinsics.checkNotNullExpressionValue(layout, "layout");
            float b17 = b(lineStart, layout);
            if (lineEnd > lineStart) {
                f16 = b(lineStart + 1, layout) - b17;
            }
            float f17 = f16;
            if (lineEnd >= 1 && f17 > 0.0f && !z16) {
                b16 = b(lineEnd - 1, layout) + f17;
            } else {
                b16 = b(lineEnd, layout);
            }
            float f18 = b16;
            float f19 = lineBounds;
            float f26 = this.mStrokeWidth;
            Paint paint = this.mPaint;
            Intrinsics.checkNotNull(paint);
            canvas.drawLine(b17, f19 + f26, f18, f19 + f26, paint);
            i3++;
            f16 = f17;
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Field field;
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildCustomUnderlinedTextView", 1, "[onMeasure] onMeasure step1");
        }
        try {
            Field declaredField = DynamicLayout.class.getDeclaredField("sStaticLayout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(DynamicLayout.class);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.text.StaticLayout");
            this.mStaticLayout = (StaticLayout) obj;
        } catch (Exception e16) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[onMeasure] onMeasure getDeclaredField('sStaticLayout') error! ");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildCustomUnderlinedTextView", 1, (String) it.next(), e16);
            }
        }
        if (this.mStaticLayout != null) {
            try {
                Field declaredField2 = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                this.mFieldMaximumVisibleLineCount = declaredField2;
                Intrinsics.checkNotNull(declaredField2);
                declaredField2.setAccessible(true);
                Field field2 = this.mFieldMaximumVisibleLineCount;
                Intrinsics.checkNotNull(field2);
                field2.setInt(this.mStaticLayout, getMaxLines());
            } catch (Exception e17) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("[onMeasure] onMeasure getDeclaredField('sStaticLayout') error! ");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("GuildCustomUnderlinedTextView", 1, (String) it5.next(), e17);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger logger4 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger4.d().d("GuildCustomUnderlinedTextView", 1, "[onMeasure] onMeasure step2");
        }
        if (this.mStaticLayout != null && (field = this.mFieldMaximumVisibleLineCount) != null) {
            try {
                Intrinsics.checkNotNull(field);
                field.setInt(this.mStaticLayout, Integer.MAX_VALUE);
            } catch (Exception e18) {
                Logger logger5 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                bVar3.a().add("[onMeasure] onMeasure mFieldMaximumVisibleLineCount.setInt error!");
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("GuildCustomUnderlinedTextView", 1, (String) it6.next(), e18);
                }
            }
        }
    }

    public final void setStrokeWidth(float f16) {
        this.mStrokeWidth = f16;
        invalidate();
    }

    public final void setUnderLineColor(int i3) {
        this.mUnderLineColor = i3;
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i3);
        }
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCustomUnderlinedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildCustomUnderlinedTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCustomUnderlinedTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mUnderLineColor = -16777216;
        a(context, attributeSet, i3);
    }
}
