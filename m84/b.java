package m84;

import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import pv4.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a*\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u0011\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f\u001a&\u0010\u0016\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u001a0\u0010\u001c\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u001a\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002\u00a8\u0006!"}, d2 = {"Landroid/widget/TextView;", "Lpv4/u;", "sceneText", "", h.F, "", "textColor", "g", "str", "", "spanColor", "start", "end", "i", "Landroid/view/View;", "Lm84/a;", "adjustObject", "a", "dstWidth", "dstHeight", "Landroid/graphics/Rect;", "marginParams", "b", "", "scale", "originalTxtSizeDp", "", "needMarginScale", "d", "Landroid/view/ViewGroup$MarginLayoutParams;", "left", "right", "f", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final void a(View view, ViewAdjustObject adjustObject) {
        int scale;
        int scale2;
        Rect originalMarginParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(adjustObject, "adjustObject");
        if (view.getLayoutParams() != null) {
            if (adjustObject.getOriginalWidth() <= 0) {
                scale = adjustObject.getOriginalWidth();
            } else {
                scale = (int) (adjustObject.getScale() * adjustObject.getOriginalWidth());
            }
            if (adjustObject.getOriginalHeight() <= 0) {
                scale2 = adjustObject.getOriginalHeight();
            } else {
                scale2 = (int) (adjustObject.getScale() * adjustObject.getOriginalHeight());
            }
            if (adjustObject.getNeedMarginScale() && adjustObject.getOriginalMarginParams() != null) {
                originalMarginParams = new Rect((int) (adjustObject.getScale() * adjustObject.getOriginalMarginParams().left), (int) (adjustObject.getScale() * adjustObject.getOriginalMarginParams().top), (int) (adjustObject.getScale() * adjustObject.getOriginalMarginParams().right), (int) (adjustObject.getScale() * adjustObject.getOriginalMarginParams().bottom));
            } else {
                originalMarginParams = adjustObject.getOriginalMarginParams();
            }
            b(view, scale, scale2, originalMarginParams);
        }
    }

    public static final void b(View view, int i3, int i16, Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width == i3 && layoutParams.height == i16 && (rect == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams) || f((ViewGroup.MarginLayoutParams) layoutParams, rect))) {
                return;
            }
            layoutParams.width = i3;
            layoutParams.height = i16;
            if (rect != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = rect.left;
                marginLayoutParams.rightMargin = rect.right;
                marginLayoutParams.topMargin = rect.top;
                marginLayoutParams.bottomMargin = rect.bottom;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static final void d(TextView textView, float f16, int i3, Rect rect, boolean z16) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        float f17 = i3 * f16;
        if (!(i.g(textView) == f17)) {
            i.i(textView, f17);
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (z16 && rect != null) {
            rect = new Rect((int) (rect.left * f16), (int) (rect.top * f16), (int) (rect.right * f16), (int) (f16 * rect.bottom));
        }
        if (layoutParams == null || rect == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (f(marginLayoutParams, rect)) {
            return;
        }
        marginLayoutParams.leftMargin = rect.left;
        marginLayoutParams.rightMargin = rect.right;
        marginLayoutParams.topMargin = rect.top;
        marginLayoutParams.bottomMargin = rect.bottom;
        textView.setLayoutParams(layoutParams);
    }

    private static final boolean f(ViewGroup.MarginLayoutParams marginLayoutParams, Rect rect) {
        return marginLayoutParams.leftMargin == rect.left && marginLayoutParams.rightMargin == rect.right && marginLayoutParams.topMargin == rect.top && marginLayoutParams.bottomMargin == rect.bottom;
    }

    public static final void g(TextView textView, String str) {
        boolean startsWith$default;
        String str2;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str == null) {
            return;
        }
        try {
            if (str.length() == 0) {
                return;
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "#", false, 2, null);
            if (startsWith$default) {
                str2 = str;
            } else {
                str2 = "#" + str;
            }
            textView.setTextColor(Color.parseColor(str2));
        } catch (Exception e16) {
            QLog.e("ViewExt", 1, "set color error " + str + MsgSummary.STR_COLON, e16);
        }
    }

    public static final void h(TextView textView, u uVar) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setText(uVar != null ? uVar.f427702a : null);
        g(textView, uVar != null ? uVar.f427704c : null);
    }

    public static final void i(TextView textView, String str, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, i16, i17, 33);
        textView.setText(spannableStringBuilder);
    }

    public static /* synthetic */ void c(View view, int i3, int i16, Rect rect, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            rect = null;
        }
        b(view, i3, i16, rect);
    }

    public static /* synthetic */ void e(TextView textView, float f16, int i3, Rect rect, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            rect = null;
        }
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        d(textView, f16, i3, rect, z16);
    }
}
