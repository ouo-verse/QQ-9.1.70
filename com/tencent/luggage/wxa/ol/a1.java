package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import java.util.Locale;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a1 {
    ;


    /* renamed from: a, reason: collision with root package name */
    public static final Class f136657a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        ;

        public static void b(EditText editText) {
            if (editText == null) {
                return;
            }
            editText.setShowSoftInputOnFocus(false);
        }

        public static a valueOf(String str) {
            com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(a.class, str));
            return null;
        }

        public static void a(EditText editText) {
            if (editText == null) {
                return;
            }
            a1.b(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
        }

        public static int a(EditText editText, float f16, float f17) {
            Editable editableText;
            TextPaint paint;
            if (editText == null) {
                return -1;
            }
            int paddingTop = editText.getPaddingTop();
            Layout layout = editText.getLayout();
            if (layout == null || (editableText = editText.getEditableText()) == null || (paint = editText.getPaint()) == null) {
                return -1;
            }
            Rect rect = new Rect();
            for (int i3 = 0; i3 < layout.getLineCount(); i3++) {
                layout.getLineBounds(i3, rect);
                paddingTop += rect.height();
                if (paddingTop >= f17) {
                    int lineStart = layout.getLineStart(i3);
                    int lineEnd = layout.getLineEnd(i3);
                    if (i3 != layout.getLineCount() - 1) {
                        lineEnd = Math.max(lineEnd - 1, lineStart);
                    }
                    if (lineStart == lineEnd) {
                        return lineStart;
                    }
                    RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) editableText.getSpans(lineStart, lineEnd, RelativeSizeSpan.class);
                    float f18 = 1.0f;
                    if (relativeSizeSpanArr != null) {
                        for (RelativeSizeSpan relativeSizeSpan : relativeSizeSpanArr) {
                            f18 = relativeSizeSpan.getSizeChange();
                        }
                    }
                    String charSequence = editableText.subSequence(lineStart, lineEnd).toString();
                    float[] fArr = new float[charSequence.length()];
                    paint.getTextWidths(charSequence, fArr);
                    float f19 = 0.0f;
                    for (int i16 = 0; i16 < charSequence.length(); i16++) {
                        f19 += fArr[i16] * f18;
                        if (i16 == charSequence.length() - 1 && f16 >= f19) {
                            return lineStart + charSequence.length();
                        }
                        if (f19 >= f16 || i16 == charSequence.length() - 1) {
                            return lineStart + i16;
                        }
                    }
                }
            }
            return -1;
        }
    }

    static {
        Class<?> cls;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", e16);
            cls = null;
        }
        f136657a = cls;
    }

    public static boolean b(CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(0, spanned.length(), f136657a);
        return spans != null && spans.length > 0;
    }

    public static a1 valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(a1.class, str));
        return null;
    }

    public static Spannable a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (charSequence instanceof Spannable) {
            return (Spannable) charSequence;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public static boolean a(Object obj) {
        return f136657a.isInstance(obj);
    }

    public static InputMethodManager b(View view) {
        Context c16;
        if (view == null || (c16 = view.getContext()) == null) {
            c16 = com.tencent.luggage.wxa.tn.z.c();
        }
        return (InputMethodManager) c16.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    public static void a(View view) {
        String format;
        if (Build.VERSION.SDK_INT >= 30) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo skip >=30");
            return;
        }
        InputMethodManager b16 = b(view);
        if (b16 == null) {
            format = "NULL Imm";
        } else {
            try {
                format = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", (View) Reflect.on(b16).get("mServedView"), (View) Reflect.on(b16).get("mNextServedView"));
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo reflect failed %s", e16);
                return;
            }
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", format);
    }

    public static boolean a(View view, View view2) {
        if (view != null && view2 != null) {
            ViewParent parent = view2.getParent();
            while (view != parent) {
                parent = parent.getParent();
                if (parent == null) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean a(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static int a(Integer num, int i3) {
        return num != null ? num.intValue() : i3;
    }
}
