package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.luggage.wxa.zl.e;
import com.tencent.luggage.wxa.zl.f;
import com.tencent.mm.ui.widget.picker.NumberPickerUtil;
import com.tencent.mm.ui.widget.picker.PickerTimeUtil;
import com.tencent.mobileqq.R;
import java.util.Locale;

/* loaded from: classes9.dex */
public final class AppBrandTimePicker extends TimePicker implements c {

    /* renamed from: a, reason: collision with root package name */
    public NumberPicker f152450a;

    /* renamed from: b, reason: collision with root package name */
    public NumberPicker f152451b;

    /* renamed from: c, reason: collision with root package name */
    public int f152452c;

    /* renamed from: d, reason: collision with root package name */
    public int f152453d;

    /* renamed from: e, reason: collision with root package name */
    public int f152454e;

    /* renamed from: f, reason: collision with root package name */
    public int f152455f;

    /* loaded from: classes9.dex */
    public class a implements NumberPicker.OnValueChangeListener {
        public a() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i3, int i16) {
            AppBrandTimePicker.this.b();
        }
    }

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, R.style.ajv));
        this.f152452c = -1;
        this.f152453d = -1;
        this.f152454e = -1;
        this.f152455f = -1;
        setIs24HourView(Boolean.TRUE);
        this.f152450a = a("mHourSpinner");
        this.f152451b = a("mMinuteSpinner");
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f152450a);
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.f152451b);
        e.a(this.f152450a);
        e.a(this.f152451b);
        c();
        NumberPicker numberPicker = this.f152450a;
        if (numberPicker != null) {
            numberPicker.setOnValueChangedListener(new a());
        }
        NumberPicker numberPicker2 = this.f152451b;
        if (numberPicker2 != null) {
            numberPicker2.setOnValueChangedListener(new b());
        }
        NumberPickerUtil.removePendingSetSelectionCommand(this.f152450a);
        NumberPickerUtil.removePendingSetSelectionCommand(this.f152451b);
    }

    public final void b() {
        NumberPicker numberPicker;
        NumberPicker numberPicker2;
        if (f.a(this.f152452c) && PickerTimeUtil.checkMinuteIntValid(this.f152453d) && (numberPicker2 = this.f152450a) != null && this.f152451b != null) {
            if (numberPicker2.getValue() == this.f152452c) {
                this.f152451b.setMinValue(this.f152453d);
            } else {
                this.f152451b.setMinValue(0);
            }
        }
        if (!f.a(this.f152454e) || (numberPicker = this.f152450a) == null || this.f152451b == null) {
            return;
        }
        if (numberPicker.getValue() == this.f152454e) {
            this.f152451b.setMaxValue(this.f152455f);
        } else {
            this.f152451b.setMaxValue(59);
        }
    }

    public final NumberPicker c(String str) {
        try {
            return (NumberPicker) new com.tencent.luggage.wxa.u9.b(this, str, null).a();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NumberPickerUtil.fixDefaultValueDisplaying(this.f152450a);
        NumberPickerUtil.fixDefaultValueDisplaying(this.f152451b);
    }

    @Override // android.widget.TimePicker
    public void setCurrentHour(Integer num) {
        int intValue;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        super.setCurrentHour(Integer.valueOf(intValue));
        b();
    }

    @Override // android.widget.TimePicker
    public void setCurrentMinute(Integer num) {
        int intValue;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        super.setCurrentMinute(Integer.valueOf(intValue));
        b();
    }

    public final NumberPicker a(String str) {
        return b(str);
    }

    public final void c() {
        Drawable drawable = getResources().getDrawable(R.drawable.ja_);
        NumberPickerUtil.reflectSetDividerDrawable(this.f152450a, drawable);
        NumberPickerUtil.reflectSetDividerDrawable(this.f152451b, drawable);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String currentValue() {
        return String.format(Locale.US, "%02d:%02d", getCurrentHour(), getCurrentMinute());
    }

    public final NumberPicker b(String str) {
        try {
            Object a16 = new com.tencent.luggage.wxa.u9.b(this, "mDelegate", null).a();
            if (a16 != null) {
                return (NumberPicker) new com.tencent.luggage.wxa.u9.b(a16, str, null).a();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
    }

    /* loaded from: classes9.dex */
    public class b implements NumberPicker.OnValueChangeListener {
        public b() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i3, int i16) {
        }
    }
}
