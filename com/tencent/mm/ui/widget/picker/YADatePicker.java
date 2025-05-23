package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes9.dex */
public class YADatePicker extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final String f153632a = "YADatePicker";
    public final DatePickerDelegate mDelegate;

    /* loaded from: classes9.dex */
    public interface DatePickerDelegate {
        boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        CalendarView getCalendarView();

        boolean getCalendarViewShown();

        int getDayOfMonth();

        int getFirstDayOfWeek();

        Calendar getMaxDate();

        Calendar getMinDate();

        int getMonth();

        boolean getSpinnersShown();

        int getYear();

        void init(int i3, int i16, int i17, OnDateChangedListener onDateChangedListener);

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onRestoreInstanceState(Parcelable parcelable);

        Parcelable onSaveInstanceState(Parcelable parcelable);

        void setCalendarViewShown(boolean z16);

        void setEnabled(boolean z16);

        void setFirstDayOfWeek(int i3);

        void setMaxDate(long j3);

        void setMinDate(long j3);

        void setSpinnersShown(boolean z16);

        void setValidationCallback(ValidationCallback validationCallback);

        void updateDate(int i3, int i16, int i17);
    }

    /* loaded from: classes9.dex */
    public static class DatePickerSpinnerDelegate extends AbstractDatePickerDelegate {

        /* renamed from: f, reason: collision with root package name */
        public final LinearLayout f153638f;

        /* renamed from: g, reason: collision with root package name */
        public final EditText f153639g;

        /* renamed from: h, reason: collision with root package name */
        public final EditText f153640h;

        /* renamed from: i, reason: collision with root package name */
        public final EditText f153641i;

        /* renamed from: j, reason: collision with root package name */
        public final CalendarView f153642j;

        /* renamed from: k, reason: collision with root package name */
        public final DateFormat f153643k;

        /* renamed from: l, reason: collision with root package name */
        public String[] f153644l;

        /* renamed from: m, reason: collision with root package name */
        public int f153645m;
        public final NumberPicker mDaySpinner;
        public final NumberPicker mMonthSpinner;
        public final NumberPicker mYearSpinner;

        /* renamed from: n, reason: collision with root package name */
        public Calendar f153646n;

        /* renamed from: o, reason: collision with root package name */
        public Calendar f153647o;

        /* renamed from: p, reason: collision with root package name */
        public Calendar f153648p;

        /* renamed from: q, reason: collision with root package name */
        public Calendar f153649q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f153650r;

        public DatePickerSpinnerDelegate(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i3, int i16) {
            super(yADatePicker, context);
            this.f153643k = new SimpleDateFormat("MM/dd/yyyy");
            this.f153650r = true;
            this.f153633a = yADatePicker;
            this.f153634b = context;
            b(Locale.getDefault());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i3, i16);
            boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.DatePicker_spinnersShown, true);
            boolean z17 = obtainStyledAttributes.getBoolean(R.styleable.DatePicker_calendarViewShown, true);
            int i17 = obtainStyledAttributes.getInt(R.styleable.DatePicker_startYear, 1900);
            int i18 = obtainStyledAttributes.getInt(R.styleable.DatePicker_endYear, 2100);
            String string = obtainStyledAttributes.getString(R.styleable.DatePicker_minDate);
            String string2 = obtainStyledAttributes.getString(R.styleable.DatePicker_maxDate);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.DatePicker_legacyLayout, com.tencent.mobileqq.R.layout.e5f);
            obtainStyledAttributes.recycle();
            ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, (ViewGroup) this.f153633a, true);
            NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerSpinnerDelegate.1
                @Override // android.widget.NumberPicker.OnValueChangeListener
                public void onValueChange(NumberPicker numberPicker, int i19, int i26) {
                    DatePickerSpinnerDelegate.this.e();
                    DatePickerSpinnerDelegate.this.f153646n.setTimeInMillis(DatePickerSpinnerDelegate.this.f153649q.getTimeInMillis());
                    DatePickerSpinnerDelegate datePickerSpinnerDelegate = DatePickerSpinnerDelegate.this;
                    if (numberPicker == datePickerSpinnerDelegate.mDaySpinner) {
                        int actualMaximum = datePickerSpinnerDelegate.f153646n.getActualMaximum(5);
                        if (i19 == actualMaximum && i26 == 1) {
                            DatePickerSpinnerDelegate.this.f153646n.add(5, 1);
                        } else if (i19 == 1 && i26 == actualMaximum) {
                            DatePickerSpinnerDelegate.this.f153646n.add(5, -1);
                        } else {
                            DatePickerSpinnerDelegate.this.f153646n.add(5, i26 - i19);
                        }
                    } else if (numberPicker == datePickerSpinnerDelegate.mMonthSpinner) {
                        if (i19 == 11 && i26 == 0) {
                            datePickerSpinnerDelegate.f153646n.add(2, 1);
                        } else if (i19 == 0 && i26 == 11) {
                            datePickerSpinnerDelegate.f153646n.add(2, -1);
                        } else {
                            datePickerSpinnerDelegate.f153646n.add(2, i26 - i19);
                        }
                    } else if (numberPicker == datePickerSpinnerDelegate.mYearSpinner) {
                        datePickerSpinnerDelegate.f153646n.set(1, i26);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    DatePickerSpinnerDelegate datePickerSpinnerDelegate2 = DatePickerSpinnerDelegate.this;
                    datePickerSpinnerDelegate2.b(datePickerSpinnerDelegate2.f153646n.get(1), DatePickerSpinnerDelegate.this.f153646n.get(2), DatePickerSpinnerDelegate.this.f153646n.get(5));
                    DatePickerSpinnerDelegate.this.f();
                    DatePickerSpinnerDelegate.this.d();
                    DatePickerSpinnerDelegate.this.a();
                }
            };
            this.f153638f = (LinearLayout) this.f153633a.findViewById(com.tencent.mobileqq.R.id.f25260ac);
            CalendarView calendarView = (CalendarView) this.f153633a.findViewById(com.tencent.mobileqq.R.id.tl5);
            this.f153642j = calendarView;
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { // from class: com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerSpinnerDelegate.2
                @Override // android.widget.CalendarView.OnDateChangeListener
                public void onSelectedDayChange(CalendarView calendarView2, int i19, int i26, int i27) {
                    DatePickerSpinnerDelegate.this.b(i19, i26, i27);
                    DatePickerSpinnerDelegate.this.f();
                    DatePickerSpinnerDelegate.this.a();
                }
            });
            NumberPicker numberPicker = (NumberPicker) this.f153633a.findViewById(com.tencent.mobileqq.R.id.bdu);
            this.mDaySpinner = numberPicker;
            numberPicker.setFormatter(new TwoDigitFormatter());
            numberPicker.setOnLongPressUpdateInterval(100L);
            numberPicker.setOnValueChangedListener(onValueChangeListener);
            this.f153639g = NumberPickerUtil.getInputText(numberPicker);
            NumberPicker numberPicker2 = (NumberPicker) this.f153633a.findViewById(com.tencent.mobileqq.R.id.ezb);
            this.mMonthSpinner = numberPicker2;
            numberPicker2.setMinValue(0);
            numberPicker2.setMaxValue(this.f153645m - 1);
            numberPicker2.setDisplayedValues(this.f153644l);
            numberPicker2.setOnLongPressUpdateInterval(200L);
            numberPicker2.setOnValueChangedListener(onValueChangeListener);
            this.f153640h = NumberPickerUtil.getInputText(numberPicker2);
            NumberPicker numberPicker3 = (NumberPicker) this.f153633a.findViewById(com.tencent.mobileqq.R.id.l6i);
            this.mYearSpinner = numberPicker3;
            numberPicker3.setOnLongPressUpdateInterval(100L);
            numberPicker3.setOnValueChangedListener(onValueChangeListener);
            this.f153641i = NumberPickerUtil.getInputText(numberPicker3);
            if (!z16 && !z17) {
                setSpinnersShown(true);
            } else {
                setSpinnersShown(z16);
                setCalendarViewShown(z17);
            }
            this.f153646n.clear();
            if (!TextUtils.isEmpty(string)) {
                if (!a(string, this.f153646n)) {
                    this.f153646n.set(i17, 0, 1);
                }
            } else {
                this.f153646n.set(i17, 0, 1);
            }
            setMinDate(this.f153646n.getTimeInMillis());
            this.f153646n.clear();
            if (!TextUtils.isEmpty(string2)) {
                if (!a(string2, this.f153646n)) {
                    this.f153646n.set(i18, 11, 31);
                }
            } else {
                this.f153646n.set(i18, 11, 31);
            }
            setMaxDate(this.f153646n.getTimeInMillis());
            this.f153649q.setTimeInMillis(System.currentTimeMillis());
            init(this.f153649q.get(1), this.f153649q.get(2), this.f153649q.get(5), null);
            b();
            c();
            if (this.f153633a.getImportantForAccessibility() == 0) {
                this.f153633a.setImportantForAccessibility(1);
            }
        }

        public final void c() {
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onPopulateAccessibilityEvent(accessibilityEvent);
            return true;
        }

        public final boolean g() {
            return Character.isDigit(this.f153644l[0].charAt(0));
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public CalendarView getCalendarView() {
            return this.f153642j;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public boolean getCalendarViewShown() {
            if (this.f153642j.getVisibility() == 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public int getDayOfMonth() {
            return this.f153649q.get(5);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public int getFirstDayOfWeek() {
            return this.f153642j.getFirstDayOfWeek();
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public Calendar getMaxDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.f153642j.getMaxDate());
            return calendar;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public Calendar getMinDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.f153642j.getMinDate());
            return calendar;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public int getMonth() {
            return this.f153649q.get(2);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public boolean getSpinnersShown() {
            return this.f153638f.isShown();
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public int getYear() {
            return this.f153649q.get(1);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void init(int i3, int i16, int i17, OnDateChangedListener onDateChangedListener) {
            b(i3, i16, i17);
            f();
            d();
            this.f153636d = onDateChangedListener;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public boolean isEnabled() {
            return this.f153650r;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void onConfigurationChanged(Configuration configuration) {
            b(configuration.locale);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(DateUtils.formatDateTime(this.f153634b, this.f153649q.getTimeInMillis(), 20));
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            b(savedState.f153653a, savedState.f153654b, savedState.f153655c);
            f();
            d();
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public Parcelable onSaveInstanceState(Parcelable parcelable) {
            return new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth());
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setCalendarViewShown(boolean z16) {
            int i3;
            CalendarView calendarView = this.f153642j;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            calendarView.setVisibility(i3);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setEnabled(boolean z16) {
            this.mDaySpinner.setEnabled(z16);
            this.mMonthSpinner.setEnabled(z16);
            this.mYearSpinner.setEnabled(z16);
            this.f153642j.setEnabled(z16);
            this.f153650r = z16;
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setFirstDayOfWeek(int i3) {
            this.f153642j.setFirstDayOfWeek(i3);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setMaxDate(long j3) {
            this.f153646n.setTimeInMillis(j3);
            if (this.f153646n.get(1) == this.f153648p.get(1) && this.f153646n.get(6) != this.f153648p.get(6)) {
                return;
            }
            this.f153648p.setTimeInMillis(j3);
            this.f153642j.setMaxDate(j3);
            if (this.f153649q.after(this.f153648p)) {
                this.f153649q.setTimeInMillis(this.f153648p.getTimeInMillis());
                d();
            }
            f();
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setMinDate(long j3) {
            this.f153646n.setTimeInMillis(j3);
            if (this.f153646n.get(1) == this.f153647o.get(1) && this.f153646n.get(6) != this.f153647o.get(6)) {
                return;
            }
            this.f153647o.setTimeInMillis(j3);
            this.f153642j.setMinDate(j3);
            if (this.f153649q.before(this.f153647o)) {
                this.f153649q.setTimeInMillis(this.f153647o.getTimeInMillis());
                d();
            }
            f();
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setSpinnersShown(boolean z16) {
            int i3;
            LinearLayout linearLayout = this.f153638f;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.AbstractDatePickerDelegate, com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public /* bridge */ /* synthetic */ void setValidationCallback(ValidationCallback validationCallback) {
            super.setValidationCallback(validationCallback);
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void updateDate(int i3, int i16, int i17) {
            if (!a(i3, i16, i17)) {
                return;
            }
            b(i3, i16, i17);
            f();
            d();
            a();
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.AbstractDatePickerDelegate
        public void b(Locale locale) {
            super.b(locale);
            this.f153646n = a(this.f153646n, locale);
            this.f153647o = a(this.f153647o, locale);
            this.f153648p = a(this.f153648p, locale);
            this.f153649q = a(this.f153649q, locale);
            this.f153645m = this.f153646n.getActualMaximum(2) + 1;
            this.f153644l = new DateFormatSymbols().getShortMonths();
            if (g()) {
                this.f153644l = new String[this.f153645m];
                int i3 = 0;
                while (i3 < this.f153645m) {
                    int i16 = i3 + 1;
                    this.f153644l[i3] = String.format("%d", Integer.valueOf(i16));
                    i3 = i16;
                }
            }
        }

        public final void d() {
            this.f153642j.setDate(this.f153649q.getTimeInMillis(), false, false);
        }

        public final void e() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f153633a.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                if (inputMethodManager.isActive(this.f153641i)) {
                    this.f153641i.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(this.f153633a.getWindowToken(), 0);
                } else if (inputMethodManager.isActive(this.f153640h)) {
                    this.f153640h.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(this.f153633a.getWindowToken(), 0);
                } else if (inputMethodManager.isActive(this.f153639g)) {
                    this.f153639g.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(this.f153633a.getWindowToken(), 0);
                }
            }
        }

        public final void f() {
            if (this.f153649q.equals(this.f153647o)) {
                this.mDaySpinner.setMinValue(this.f153649q.get(5));
                this.mDaySpinner.setMaxValue(this.f153649q.getActualMaximum(5));
                this.mDaySpinner.setWrapSelectorWheel(false);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(this.f153649q.get(2));
                this.mMonthSpinner.setMaxValue(this.f153649q.getActualMaximum(2));
                this.mMonthSpinner.setWrapSelectorWheel(false);
            } else if (this.f153649q.equals(this.f153648p)) {
                this.mDaySpinner.setMinValue(this.f153649q.getActualMinimum(5));
                this.mDaySpinner.setMaxValue(this.f153649q.get(5));
                this.mDaySpinner.setWrapSelectorWheel(false);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(this.f153649q.getActualMinimum(2));
                this.mMonthSpinner.setMaxValue(this.f153649q.get(2));
                this.mMonthSpinner.setWrapSelectorWheel(false);
            } else {
                this.mDaySpinner.setMinValue(1);
                this.mDaySpinner.setMaxValue(this.f153649q.getActualMaximum(5));
                this.mDaySpinner.setWrapSelectorWheel(true);
                this.mMonthSpinner.setDisplayedValues(null);
                this.mMonthSpinner.setMinValue(0);
                this.mMonthSpinner.setMaxValue(11);
                this.mMonthSpinner.setWrapSelectorWheel(true);
            }
            this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.f153644l, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
            this.mYearSpinner.setMinValue(this.f153647o.get(1));
            this.mYearSpinner.setMaxValue(this.f153648p.get(1));
            this.mYearSpinner.setWrapSelectorWheel(false);
            this.mYearSpinner.setValue(this.f153649q.get(1));
            this.mMonthSpinner.setValue(this.f153649q.get(2));
            this.mDaySpinner.setValue(this.f153649q.get(5));
            if (g()) {
                this.f153640h.setRawInputType(2);
            }
        }

        public final Calendar a(Calendar calendar, Locale locale) {
            if (calendar == null) {
                return Calendar.getInstance(locale);
            }
            long timeInMillis = calendar.getTimeInMillis();
            Calendar calendar2 = Calendar.getInstance(locale);
            calendar2.setTimeInMillis(timeInMillis);
            return calendar2;
        }

        public final boolean a(String str, Calendar calendar) {
            try {
                calendar.setTime(this.f153643k.parse(str));
                return true;
            } catch (ParseException unused) {
                n.e(YADatePicker.f153632a, "Date: " + str + " not in format: MM/dd/yyyy", new Object[0]);
                return false;
            }
        }

        public final boolean a(int i3, int i16, int i17) {
            return (this.f153649q.get(1) == i3 && this.f153649q.get(2) == i17 && this.f153649q.get(5) == i16) ? false : true;
        }

        public final void a() {
            this.f153633a.sendAccessibilityEvent(4);
            OnDateChangedListener onDateChangedListener = this.f153636d;
            if (onDateChangedListener != null) {
                onDateChangedListener.onDateChanged(this.f153633a, getYear(), getMonth(), getDayOfMonth());
            }
        }

        public final void b() {
            this.f153638f.removeAllViews();
            char[] dateFormatOrder = this.f153633a.getLayoutDirection() == 0 ? new char[]{'y', 'M', 'd'} : android.text.format.DateFormat.getDateFormatOrder(this.f153633a.getContext());
            int length = dateFormatOrder.length;
            for (int i3 = 0; i3 < length; i3++) {
                char c16 = dateFormatOrder[i3];
                if (c16 == 'M') {
                    this.f153638f.addView(this.mMonthSpinner);
                    a(this.mMonthSpinner, length, i3);
                } else if (c16 == 'd') {
                    this.f153638f.addView(this.mDaySpinner);
                    a(this.mDaySpinner, length, i3);
                } else if (c16 == 'y') {
                    this.f153638f.addView(this.mYearSpinner);
                    a(this.mYearSpinner, length, i3);
                } else {
                    throw new IllegalArgumentException(Arrays.toString(dateFormatOrder));
                }
            }
        }

        public final void a(NumberPicker numberPicker, int i3, int i16) {
            int i17 = i16 < i3 + (-1) ? 5 : 6;
            EditText inputText = NumberPickerUtil.getInputText(numberPicker);
            if (inputText != null) {
                inputText.setImeOptions(i17);
            }
        }

        public final void b(int i3, int i16, int i17) {
            this.f153649q.set(i3, i16, i17);
            if (this.f153649q.before(this.f153647o)) {
                this.f153649q.setTimeInMillis(this.f153647o.getTimeInMillis());
            } else if (this.f153649q.after(this.f153648p)) {
                this.f153649q.setTimeInMillis(this.f153648p.getTimeInMillis());
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface OnDateChangedListener {
        void onDateChanged(YADatePicker yADatePicker, int i3, int i16, int i17);
    }

    /* loaded from: classes9.dex */
    public interface ValidationCallback {
        void onValidationChanged(boolean z16);
    }

    public YADatePicker(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mDelegate.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return YADatePicker.class.getName();
    }

    public CalendarView getCalendarView() {
        return this.mDelegate.getCalendarView();
    }

    public boolean getCalendarViewShown() {
        return this.mDelegate.getCalendarViewShown();
    }

    public int getDayOfMonth() {
        return this.mDelegate.getDayOfMonth();
    }

    public int getFirstDayOfWeek() {
        return this.mDelegate.getFirstDayOfWeek();
    }

    public long getMaxDate() {
        return this.mDelegate.getMaxDate().getTimeInMillis();
    }

    public long getMinDate() {
        return this.mDelegate.getMinDate().getTimeInMillis();
    }

    public int getMonth() {
        return this.mDelegate.getMonth();
    }

    public boolean getSpinnersShown() {
        return this.mDelegate.getSpinnersShown();
    }

    @Keep
    public DatePickerDelegate getUIDelegate() {
        return this.mDelegate;
    }

    public int getYear() {
        return this.mDelegate.getYear();
    }

    public void init(int i3, int i16, int i17, OnDateChangedListener onDateChangedListener) {
        this.mDelegate.init(i3, i16, i17, onDateChangedListener);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mDelegate.isEnabled();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.mDelegate.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.mDelegate.onRestoreInstanceState(baseSavedState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return this.mDelegate.onSaveInstanceState(super.onSaveInstanceState());
    }

    public void setCalendarViewShown(boolean z16) {
        this.mDelegate.setCalendarViewShown(z16);
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        if (this.mDelegate.isEnabled() == z16) {
            return;
        }
        super.setEnabled(z16);
        this.mDelegate.setEnabled(z16);
    }

    public void setFirstDayOfWeek(int i3) {
        if (i3 >= 1 && i3 <= 7) {
            this.mDelegate.setFirstDayOfWeek(i3);
            return;
        }
        throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
    }

    public void setMaxDate(long j3) {
        this.mDelegate.setMaxDate(j3);
    }

    public void setMinDate(long j3) {
        this.mDelegate.setMinDate(j3);
    }

    public void setSpinnersShown(boolean z16) {
        this.mDelegate.setSpinnersShown(z16);
    }

    public void setValidationCallback(@Nullable ValidationCallback validationCallback) {
        this.mDelegate.setValidationCallback(validationCallback);
    }

    public void updateDate(int i3, int i16, int i17) {
        this.mDelegate.updateDate(i3, i16, i17);
    }

    /* loaded from: classes9.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.tencent.mm.ui.widget.picker.YADatePicker.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f153653a;

        /* renamed from: b, reason: collision with root package name */
        public final int f153654b;

        /* renamed from: c, reason: collision with root package name */
        public final int f153655c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f153653a);
            parcel.writeInt(this.f153654b);
            parcel.writeInt(this.f153655c);
        }

        SavedState(Parcelable parcelable, int i3, int i16, int i17) {
            super(parcelable);
            this.f153653a = i3;
            this.f153654b = i16;
            this.f153655c = i17;
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f153653a = parcel.readInt();
            this.f153654b = parcel.readInt();
            this.f153655c = parcel.readInt();
        }
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.a_y);
    }

    public final DatePickerDelegate a(Context context, AttributeSet attributeSet, int i3, int i16) {
        return new DatePickerSpinnerDelegate(this, context, attributeSet, i3, i16);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDelegate = a(context, attributeSet, i3, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i3, 0);
        int i16 = obtainStyledAttributes.getInt(R.styleable.DatePicker_firstDayOfWeek, 0);
        obtainStyledAttributes.recycle();
        if (i16 != 0) {
            setFirstDayOfWeek(i16);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class AbstractDatePickerDelegate implements DatePickerDelegate {

        /* renamed from: a, reason: collision with root package name */
        public YADatePicker f153633a;

        /* renamed from: b, reason: collision with root package name */
        public Context f153634b;

        /* renamed from: c, reason: collision with root package name */
        public Locale f153635c;

        /* renamed from: d, reason: collision with root package name */
        public OnDateChangedListener f153636d;

        /* renamed from: e, reason: collision with root package name */
        public ValidationCallback f153637e;

        public AbstractDatePickerDelegate(YADatePicker yADatePicker, Context context) {
            this.f153633a = yADatePicker;
            this.f153634b = context;
            b(Locale.getDefault());
        }

        public void b(Locale locale) {
            if (!locale.equals(this.f153635c)) {
                this.f153635c = locale;
                a(locale);
            }
        }

        @Override // com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
        public void setValidationCallback(ValidationCallback validationCallback) {
            this.f153637e = validationCallback;
        }

        public void a(Locale locale) {
        }
    }
}
