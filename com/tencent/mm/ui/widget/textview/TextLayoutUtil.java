package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TextLayoutUtil {
    public static boolean a(View view, int i3) {
        if (i3 > 0 && getLineForOffset(view, i3) == getLineForOffset(view, i3 - 1) + 1) {
            return true;
        }
        return false;
    }

    public static int getHysteresisOffset(View view, int i3, int i16, int i17) {
        int lineForVertical = getLineForVertical(view, i16);
        if (a(view, i17)) {
            int primaryHorizontal = (int) getPrimaryHorizontal(view, i17 - 1);
            int lineRight = (int) getLineRight(view, lineForVertical);
            if (i3 > lineRight - ((lineRight - primaryHorizontal) / 2)) {
                i17--;
            }
        }
        int lineForOffset = getLineForOffset(view, i17);
        int lineTop = getLineTop(view, lineForOffset);
        int lineBottom = getLineBottom(view, lineForOffset);
        int i18 = (lineBottom - lineTop) / 2;
        if ((lineForVertical == lineForOffset + 1 && i16 - lineBottom < i18) || (lineForVertical == lineForOffset - 1 && lineTop - i16 < i18)) {
            lineForVertical = lineForOffset;
        }
        int offsetForHorizontal = getOffsetForHorizontal(view, lineForVertical, i3);
        if (offsetForHorizontal < getText(view).length() - 1) {
            int i19 = offsetForHorizontal + 1;
            if (a(view, i19)) {
                int primaryHorizontal2 = (int) getPrimaryHorizontal(view, offsetForHorizontal);
                int lineRight2 = (int) getLineRight(view, lineForVertical);
                if (i3 > lineRight2 - ((lineRight2 - primaryHorizontal2) / 2)) {
                    return i19;
                }
                return offsetForHorizontal;
            }
            return offsetForHorizontal;
        }
        return offsetForHorizontal;
    }

    public static int getLineBaseline(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineBaseline(i3);
        }
        return 0;
    }

    public static int getLineBottom(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineBottom(i3);
        }
        return 0;
    }

    public static int getLineForOffset(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineForOffset(i3);
        }
        return 0;
    }

    public static int getLineForVertical(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineForVertical(i3);
        }
        return 0;
    }

    public static int getLineHeight(View view) {
        if (view instanceof TextView) {
            return ((TextView) view).getLineHeight();
        }
        return 0;
    }

    public static float getLineLeft(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineLeft(i3);
        }
        return 0.0f;
    }

    public static float getLineRight(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineRight(i3);
        }
        return 0.0f;
    }

    public static int getLineStart(View view, int i3) {
        int i16;
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            i16 = layout.getLineStart(i3);
        } else {
            i16 = 0;
        }
        if (i16 < 0) {
            return 0;
        }
        return i16;
    }

    public static int getLineTop(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineTop(i3);
        }
        return 0;
    }

    public static float getLineWidth(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getLineWidth(i3);
        }
        return 0.0f;
    }

    public static int getOffsetForHorizontal(View view, int i3, float f16) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getOffsetForHorizontal(i3, f16);
        }
        return 0;
    }

    public static int getOffsetForPosition(View view, int i3, int i16) {
        if (view instanceof TextView) {
            return getPreciseOffset((TextView) view, i3, i16);
        }
        return 0;
    }

    public static TextPaint getPaint(View view) {
        if (view instanceof TextView) {
            return ((TextView) view).getPaint();
        }
        return null;
    }

    public static int getPreciseOffset(TextView textView, int i3, int i16) {
        Layout layout = textView.getLayout();
        if (layout != null) {
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i16), i3);
            if (((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > i3) {
                return layout.getOffsetToLeftOf(offsetForHorizontal);
            }
            return offsetForHorizontal;
        }
        return -1;
    }

    public static float getPrimaryHorizontal(View view, int i3) {
        Layout layout;
        if ((view instanceof TextView) && (layout = ((TextView) view).getLayout()) != null) {
            return layout.getPrimaryHorizontal(i3);
        }
        return 0.0f;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static CharSequence getText(View view) {
        if (view instanceof TextView) {
            return ((TextView) view).getText();
        }
        return "";
    }

    public static float getTextSize(View view) {
        if (view instanceof TextView) {
            return ((TextView) view).getTextSize();
        }
        return 0.0f;
    }

    public static void setText(View view, CharSequence charSequence, TextView.BufferType bufferType) {
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence, bufferType);
        }
    }
}
