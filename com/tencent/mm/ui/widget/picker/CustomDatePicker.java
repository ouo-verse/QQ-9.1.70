package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mobileqq.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes9.dex */
public class CustomDatePicker extends YADatePicker {

    /* renamed from: b, reason: collision with root package name */
    public boolean f153486b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f153487c;

    /* renamed from: d, reason: collision with root package name */
    public NumberPicker f153488d;

    /* renamed from: e, reason: collision with root package name */
    public NumberPicker f153489e;

    /* renamed from: f, reason: collision with root package name */
    public NumberPicker f153490f;

    /* renamed from: g, reason: collision with root package name */
    public Date f153491g;

    /* renamed from: h, reason: collision with root package name */
    public Date f153492h;

    /* renamed from: i, reason: collision with root package name */
    public Calendar f153493i;

    /* renamed from: j, reason: collision with root package name */
    public String[] f153494j;

    public CustomDatePicker(Context context) {
        super(context);
        this.f153486b = true;
        this.f153487c = true;
        b();
    }

    public final void b() {
        this.f153494j = new String[12];
        int i3 = 0;
        while (true) {
            String[] strArr = this.f153494j;
            if (i3 >= strArr.length) {
                break;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            int i16 = i3 + 1;
            sb5.append(i16);
            strArr[i3] = sb5.toString();
            i3 = i16;
        }
        this.f153493i = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.f153488d = ((YADatePicker.DatePickerSpinnerDelegate) getUIDelegate()).mYearSpinner;
        this.f153489e = ((YADatePicker.DatePickerSpinnerDelegate) getUIDelegate()).mMonthSpinner;
        this.f153490f = ((YADatePicker.DatePickerSpinnerDelegate) getUIDelegate()).mDaySpinner;
        d();
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f153488d);
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f153489e);
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f153490f);
        NumberPickerUtil.setNumberPickerTextColor(this.f153488d, getResources().getColor(R.color.c7u));
        NumberPickerUtil.setNumberPickerTextColor(this.f153489e, getResources().getColor(R.color.c7u));
        NumberPickerUtil.setNumberPickerTextColor(this.f153490f, getResources().getColor(R.color.c7u));
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: com.tencent.mm.ui.widget.picker.CustomDatePicker.1
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i17, int i18) {
                CustomDatePicker.this.c();
            }
        };
        NumberPicker numberPicker = this.f153488d;
        if (numberPicker != null) {
            numberPicker.setOnValueChangedListener(onValueChangeListener);
            this.f153488d.setMinValue(1900);
        }
        NumberPicker numberPicker2 = this.f153489e;
        if (numberPicker2 != null) {
            numberPicker2.setOnValueChangedListener(onValueChangeListener);
        }
        NumberPicker numberPicker3 = this.f153490f;
        if (numberPicker3 != null) {
            numberPicker3.setOnValueChangedListener(onValueChangeListener);
        }
        c();
        NumberPickerUtil.removePendingSetSelectionCommand(this.f153488d);
        NumberPickerUtil.removePendingSetSelectionCommand(this.f153489e);
        NumberPickerUtil.removePendingSetSelectionCommand(this.f153490f);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        NumberPicker numberPicker;
        boolean z16;
        Date date;
        Date date2;
        Date date3;
        Date date4;
        if (this.f153488d != null && (numberPicker = this.f153489e) != null && this.f153490f != null) {
            numberPicker.setDisplayedValues(null);
            boolean z17 = false;
            if (this.f153488d.getValue() == this.f153488d.getMaxValue() && (date3 = this.f153492h) != null) {
                this.f153489e.setMaxValue(date3.getMonth());
                if (this.f153489e.getValue() == this.f153489e.getMaxValue() && (date4 = this.f153492h) != null) {
                    this.f153490f.setMaxValue(date4.getDate());
                    z16 = true;
                    if (!z16) {
                        this.f153493i.set(this.f153488d.getValue(), this.f153489e.getValue(), 1);
                        this.f153490f.setMaxValue(this.f153493i.getActualMaximum(5));
                    }
                    if (this.f153488d.getValue() != this.f153488d.getMinValue() && (date = this.f153491g) != null) {
                        this.f153489e.setMinValue(date.getMonth());
                        if (this.f153489e.getValue() == this.f153489e.getMinValue() && (date2 = this.f153491g) != null) {
                            this.f153490f.setMinValue(date2.getDate());
                            z17 = true;
                        }
                    } else {
                        this.f153489e.setMinValue(0);
                    }
                    if (!z17) {
                        this.f153490f.setMinValue(1);
                    }
                    NumberPicker numberPicker2 = this.f153489e;
                    numberPicker2.setDisplayedValues((String[]) Arrays.copyOfRange(this.f153494j, numberPicker2.getMinValue(), this.f153489e.getMaxValue() + 1));
                    this.f153488d.setWrapSelectorWheel(true);
                    this.f153489e.setWrapSelectorWheel(true);
                    this.f153490f.setWrapSelectorWheel(true);
                }
            } else {
                this.f153489e.setMaxValue(11);
            }
            z16 = false;
            if (!z16) {
            }
            if (this.f153488d.getValue() != this.f153488d.getMinValue()) {
            }
            this.f153489e.setMinValue(0);
            if (!z17) {
            }
            NumberPicker numberPicker22 = this.f153489e;
            numberPicker22.setDisplayedValues((String[]) Arrays.copyOfRange(this.f153494j, numberPicker22.getMinValue(), this.f153489e.getMaxValue() + 1));
            this.f153488d.setWrapSelectorWheel(true);
            this.f153489e.setWrapSelectorWheel(true);
            this.f153490f.setWrapSelectorWheel(true);
        }
    }

    public String currentValue() {
        if (this.f153487c) {
            return String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth()));
        }
        if (this.f153486b) {
            return String.format(Locale.US, "%04d-%02d", Integer.valueOf(getYear()), Integer.valueOf(getMonth()));
        }
        return String.format(Locale.US, "%04d", Integer.valueOf(getYear()));
    }

    public final void d() {
        Drawable drawable = getResources().getDrawable(R.drawable.k6l);
        NumberPickerUtil.reflectSetDividerDrawable(this.f153488d, drawable);
        NumberPickerUtil.reflectSetDividerDrawable(this.f153489e, drawable);
        NumberPickerUtil.reflectSetDividerDrawable(this.f153490f, drawable);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public int getDayOfMonth() {
        NumberPicker numberPicker = this.f153490f;
        if (numberPicker != null) {
            return numberPicker.getValue();
        }
        return super.getDayOfMonth();
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public int getMonth() {
        int month;
        NumberPicker numberPicker = this.f153489e;
        if (numberPicker != null) {
            month = numberPicker.getValue();
        } else {
            month = super.getMonth();
        }
        return Math.max(Math.min(month + 1, 12), 0);
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public int getYear() {
        NumberPicker numberPicker = this.f153488d;
        if (numberPicker != null) {
            return numberPicker.getValue();
        }
        return super.getYear();
    }

    public void init(int i3, int i16, int i17) {
        init(i3, i16, i17, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NumberPickerUtil.fixDefaultValueDisplaying(this.f153488d);
        NumberPickerUtil.fixDefaultValueDisplaying(this.f153489e);
        NumberPickerUtil.fixDefaultValueDisplaying(this.f153490f);
    }

    public void onShow() {
        c();
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public void setMaxDate(long j3) {
        super.setMaxDate(j3);
        Date date = new Date(j3);
        this.f153492h = date;
        NumberPicker numberPicker = this.f153488d;
        if (numberPicker != null) {
            numberPicker.setMaxValue(date.getYear() + 1900);
        }
        c();
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public void setMinDate(long j3) {
        super.setMinDate(j3);
        Date date = new Date(j3);
        this.f153491g = date;
        NumberPicker numberPicker = this.f153488d;
        if (numberPicker != null) {
            numberPicker.setMinValue(date.getYear() + 1900);
        }
    }

    public void setPickersEnable(boolean z16, boolean z17, boolean z18) {
        int i3;
        int i16;
        this.f153486b = z17;
        this.f153487c = z18;
        NumberPicker numberPicker = this.f153488d;
        int i17 = 0;
        if (numberPicker != null) {
            numberPicker.setEnabled(z16);
            NumberPicker numberPicker2 = this.f153488d;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            numberPicker2.setVisibility(i16);
        }
        NumberPicker numberPicker3 = this.f153489e;
        if (numberPicker3 != null) {
            numberPicker3.setEnabled(z17);
            NumberPicker numberPicker4 = this.f153489e;
            if (z17) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            numberPicker4.setVisibility(i3);
        }
        NumberPicker numberPicker5 = this.f153490f;
        if (numberPicker5 != null) {
            numberPicker5.setEnabled(z18);
            NumberPicker numberPicker6 = this.f153490f;
            if (!z18) {
                i17 = 8;
            }
            numberPicker6.setVisibility(i17);
        }
    }

    @Override // com.tencent.mm.ui.widget.picker.YADatePicker
    public void init(int i3, int i16, int i17, YADatePicker.OnDateChangedListener onDateChangedListener) {
        super.init(i3, Math.max(i16 - 1, 0), i17, onDateChangedListener);
        c();
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153486b = true;
        this.f153487c = true;
        b();
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153486b = true;
        this.f153487c = true;
        b();
    }
}
