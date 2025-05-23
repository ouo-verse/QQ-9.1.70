package com.tencent.qqnt.datepicker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.datepicker.utils.a;
import com.tencent.qqnt.datepicker.utils.b;
import com.tencent.theme.SkinnableView;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u001d\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0014J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/datepicker/view/DateWeekTabView;", "Landroid/view/View;", "Lcom/tencent/theme/SkinnableView;", "", "pxTextSize", "", "setTextSize", "", "textColor", "setTextColor", "Ljava/util/Locale;", "locale", "firstWeekDay", "setLocal", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "onThemeChanged", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "", "", "e", "[Ljava/lang/String;", "weekdayNames", "f", UserInfo.SEX_FEMALE, "textHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DateWeekTabView extends View implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String[] weekdayNames;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float textHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/datepicker/view/DateWeekTabView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.datepicker.view.DateWeekTabView$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DateWeekTabView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) / this.weekdayNames.length;
        float paddingTop = getPaddingTop() - this.paint.getFontMetrics().top;
        String[] strArr = this.weekdayNames;
        int length = strArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            String str = strArr[i3];
            int i17 = i16 + 1;
            int paddingLeft = (i16 * measuredWidth) + getPaddingLeft();
            a aVar = a.f355927a;
            aVar.a("DateWeekTabView", " " + str + "  divider  " + paddingLeft);
            float measureText = ((float) paddingLeft) + ((((float) measuredWidth) - this.paint.measureText(str)) / ((float) 2));
            aVar.a("DateWeekTabView", " " + str + " textStart " + measureText + " baseLine " + getBaseline());
            if (canvas != null) {
                Intrinsics.checkNotNull(str);
                canvas.drawText(str, measureText, paddingTop, this.paint);
            }
            i3++;
            i16 = i17;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.weekdayNames.length == 0) {
            z16 = true;
        }
        if (!z16) {
            float abs = Math.abs(this.paint.getFontMetrics().top) + Math.abs(this.paint.getFontMetrics().bottom);
            this.textHeight = abs;
            setMeasuredDimension(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (abs + getPaddingTop() + getPaddingBottom()), 1073741824));
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary, null).getDefaultColor());
        invalidate();
        a.f355927a.a("DateWeekTabView", "Data Tab onThemeChanged invalidate");
    }

    public final void setLocal(@NotNull Locale locale, int firstWeekDay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) locale, firstWeekDay);
            return;
        }
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.weekdayNames = b.INSTANCE.b(locale, firstWeekDay, false);
        requestLayout();
    }

    public final void setTextColor(@ColorInt int textColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, textColor);
        } else {
            if (this.paint.getColor() == textColor) {
                return;
            }
            this.paint.setColor(textColor);
            invalidate();
        }
    }

    public final void setTextSize(float pxTextSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(pxTextSize));
            return;
        }
        if (this.paint.getTextSize() != pxTextSize) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.paint.setTextSize(pxTextSize);
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DateWeekTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        Paint paint = new Paint();
        paint.setTextSize(32.0f);
        this.paint = paint;
        b.Companion companion = b.INSTANCE;
        Locale CHINA = Locale.CHINA;
        Intrinsics.checkNotNullExpressionValue(CHINA, "CHINA");
        this.weekdayNames = companion.b(CHINA, 1, false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, cw3.a.D0, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl\u2026le.DateWeekTabView, 0, 0)");
        try {
            this.paint.setTextSize(obtainStyledAttributes.getDimensionPixelSize(cw3.a.F0, 0));
            this.paint.setColor(obtainStyledAttributes.getColor(cw3.a.E0, -16777216));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ DateWeekTabView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
