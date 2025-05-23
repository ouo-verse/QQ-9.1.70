package com.tencent.mm.ui.widget.picker;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.luggage.wxa.lo.h;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;
import java.util.Locale;

/* loaded from: classes9.dex */
public class CustomTimePicker extends TimePicker {

    /* renamed from: a, reason: collision with root package name */
    public NumberPicker f153517a;

    /* renamed from: b, reason: collision with root package name */
    public NumberPicker f153518b;

    /* renamed from: c, reason: collision with root package name */
    public int f153519c;

    /* renamed from: d, reason: collision with root package name */
    public int f153520d;

    /* renamed from: e, reason: collision with root package name */
    public int f153521e;

    /* renamed from: f, reason: collision with root package name */
    public int f153522f;

    public CustomTimePicker(Context context) {
        super(new ContextThemeWrapper(context, R.style.at_));
        this.f153519c = -1;
        this.f153520d = -1;
        this.f153521e = -1;
        this.f153522f = -1;
        a();
    }

    public final void b() {
        NumberPicker numberPicker;
        NumberPicker numberPicker2;
        if (PickerTimeUtil.checkHourIntValid(this.f153519c) && PickerTimeUtil.checkMinuteIntValid(this.f153520d) && (numberPicker2 = this.f153517a) != null && this.f153518b != null) {
            if (numberPicker2.getValue() == this.f153519c) {
                this.f153518b.setMinValue(this.f153520d);
            } else {
                this.f153518b.setMinValue(0);
            }
        }
        if (!PickerTimeUtil.checkHourIntValid(this.f153521e) || (numberPicker = this.f153517a) == null || this.f153518b == null) {
            return;
        }
        if (numberPicker.getValue() == this.f153521e) {
            this.f153518b.setMaxValue(this.f153522f);
        } else {
            this.f153518b.setMaxValue(59);
        }
    }

    public final NumberPicker c(String str) {
        try {
            return (NumberPicker) new h(this, str, null).a();
        } catch (Exception unused) {
            return null;
        }
    }

    public String currentValue() {
        return String.format(Locale.US, "%02d:%02d", getCurrentHour(), getCurrentMinute());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NumberPickerUtil.fixDefaultValueDisplaying(this.f153517a);
        NumberPickerUtil.fixDefaultValueDisplaying(this.f153518b);
    }

    public void onShow() {
        b();
    }

    public void setCurrentTime(int i3, int i16) {
        if (PickerTimeUtil.checkHourIntValid(i3) && PickerTimeUtil.checkMinuteIntValid(i16)) {
            setCurrentHour(Integer.valueOf(i3));
            setCurrentMinute(Integer.valueOf(i16));
        }
        b();
    }

    public void setMaxTime(int i3, int i16) {
        NumberPicker numberPicker;
        this.f153521e = i3;
        this.f153522f = i16;
        if (PickerTimeUtil.checkHourIntValid(i3) && (numberPicker = this.f153517a) != null) {
            numberPicker.setMaxValue(this.f153521e);
        }
    }

    public void setMinTime(int i3, int i16) {
        NumberPicker numberPicker;
        this.f153519c = i3;
        this.f153520d = i16;
        if (PickerTimeUtil.checkHourIntValid(i3) && (numberPicker = this.f153517a) != null) {
            numberPicker.setMinValue(this.f153519c);
        }
    }

    public final void a() {
        setIs24HourView(Boolean.TRUE);
        this.f153517a = a("mHourSpinner");
        this.f153518b = a("mMinuteSpinner");
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f153517a);
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f153518b);
        c();
        NumberPicker numberPicker = this.f153517a;
        if (numberPicker != null) {
            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.tencent.mm.ui.widget.picker.CustomTimePicker.1
                @Override // android.widget.NumberPicker.OnValueChangeListener
                public void onValueChange(NumberPicker numberPicker2, int i3, int i16) {
                    CustomTimePicker.this.b();
                }
            });
        }
        NumberPicker numberPicker2 = this.f153518b;
        if (numberPicker2 != null) {
            numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.tencent.mm.ui.widget.picker.CustomTimePicker.2
                @Override // android.widget.NumberPicker.OnValueChangeListener
                public void onValueChange(NumberPicker numberPicker3, int i3, int i16) {
                }
            });
        }
        NumberPickerUtil.removePendingSetSelectionCommand(this.f153517a);
        NumberPickerUtil.removePendingSetSelectionCommand(this.f153518b);
    }

    public final void c() {
        Drawable drawable = getResources().getDrawable(R.drawable.k6l);
        NumberPickerUtil.reflectSetDividerDrawable(this.f153517a, drawable);
        NumberPickerUtil.reflectSetDividerDrawable(this.f153518b, drawable);
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.at_), attributeSet);
        this.f153519c = -1;
        this.f153520d = -1;
        this.f153521e = -1;
        this.f153522f = -1;
        a();
    }

    public final NumberPicker b(String str) {
        try {
            Object a16 = new h(this, "mDelegate", null).a();
            if (a16 != null) {
                return (NumberPicker) new h(a16, str, null).a();
            }
        } catch (IllegalAccessException e16) {
            n.a("CustomTimePicker", e16, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
        } catch (NoSuchFieldException e17) {
            n.a("CustomTimePicker", e17, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
        }
        return null;
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153519c = -1;
        this.f153520d = -1;
        this.f153521e = -1;
        this.f153522f = -1;
        a();
    }

    public final NumberPicker a(String str) {
        return b(str);
    }

    @TargetApi(21)
    public CustomTimePicker(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f153519c = -1;
        this.f153520d = -1;
        this.f153521e = -1;
        this.f153522f = -1;
        a();
    }
}
