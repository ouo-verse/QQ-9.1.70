package com.tencent.mm.ui.widget.picker;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lo.h;
import com.tencent.luggage.wxa.lo.n;

/* loaded from: classes9.dex */
public class NumberPickerUtil {
    public static void fixDefaultValueDisplaying(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return;
        }
        try {
            EditText editText = (EditText) new h(numberPicker, "mInputText", null).a();
            if (editText != null) {
                editText.setFilters(new InputFilter[0]);
            }
        } catch (IllegalAccessException e16) {
            n.a("NumberPickerUtil", e16, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
        } catch (NoSuchFieldException e17) {
            n.a("NumberPickerUtil", e17, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
        }
    }

    public static EditText getInputText(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return null;
        }
        try {
            return (EditText) new h(numberPicker, "mInputText", null).a();
        } catch (IllegalAccessException e16) {
            n.a("NumberPickerUtil", e16, "getInputText IllegalAccessException", new Object[0]);
            return null;
        } catch (NoSuchFieldException e17) {
            n.a("NumberPickerUtil", e17, "getInputText NoSuchFieldException", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Paint getSelectorWheelPaint(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return null;
        }
        try {
            return (Paint) new h(numberPicker, "mSelectorWheelPaint", null).a();
        } catch (IllegalAccessException e16) {
            n.a("NumberPickerUtil", e16, "getSelectorWheelPaint IllegalAccessException", new Object[0]);
            return null;
        } catch (NoSuchFieldException e17) {
            n.a("NumberPickerUtil", e17, "getSelectorWheelPaint NoSuchFieldException", new Object[0]);
            return null;
        }
    }

    public static void reflectSetDividerDrawable(Object obj, String str, Drawable drawable) {
        try {
            Object a16 = new h(obj, str, null).a();
            if (a16 == null || !(a16 instanceof NumberPicker)) {
                return;
            }
            new h(a16, "mSelectionDivider", null).a(drawable);
        } catch (IllegalAccessException e16) {
            n.a("NumberPickerUtil", e16, "reflectSetDividerDrawable IllegalAccessException", new Object[0]);
        } catch (NoSuchFieldException e17) {
            n.a("NumberPickerUtil", e17, "reflectSetDividerDrawable NoSuchFieldException", new Object[0]);
        }
    }

    public static void reflectSetNumberPickerEditTextNotEditable(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return;
        }
        numberPicker.setDescendantFocusability(393216);
    }

    public static void removePendingSetSelectionCommand(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return;
        }
        try {
            Runnable runnable = (Runnable) new h(numberPicker, "mSetSelectionCommand", null).a();
            if (runnable != null) {
                numberPicker.removeCallbacks(runnable);
            }
        } catch (IllegalAccessException e16) {
            n.a("NumberPickerUtil", e16, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
        } catch (NoSuchFieldException e17) {
            n.a("NumberPickerUtil", e17, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
        }
    }

    public static void setNumberPickerTextColor(NumberPicker numberPicker, int i3) {
        int childCount = numberPicker.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = numberPicker.getChildAt(i16);
            if (childAt instanceof EditText) {
                Paint selectorWheelPaint = getSelectorWheelPaint(numberPicker);
                if (selectorWheelPaint != null) {
                    selectorWheelPaint.setColor(i3);
                }
                ((EditText) childAt).setTextColor(i3);
                numberPicker.invalidate();
            }
        }
    }

    public static void reflectSetDividerDrawable(NumberPicker numberPicker, Drawable drawable) {
        if (numberPicker != null) {
            try {
                new h(numberPicker, "mSelectionDivider", null).a(drawable);
            } catch (Exception unused) {
            }
        }
    }
}
