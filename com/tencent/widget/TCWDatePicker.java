package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.widget.TCWNumberPicker;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes27.dex */
public class TCWDatePicker extends FrameLayout {
    static IPatchRedirector $redirector_;
    private Calendar C;
    private Calendar D;
    private Calendar E;

    /* renamed from: d, reason: collision with root package name */
    private final DateFormat f384672d;

    /* renamed from: e, reason: collision with root package name */
    private final TCWNumberPicker f384673e;

    /* renamed from: f, reason: collision with root package name */
    private final TCWNumberPicker f384674f;

    /* renamed from: h, reason: collision with root package name */
    private final TCWNumberPicker f384675h;

    /* renamed from: i, reason: collision with root package name */
    private Locale f384676i;

    /* renamed from: m, reason: collision with root package name */
    private Calendar f384677m;

    /* loaded from: classes27.dex */
    class a implements TCWNumberPicker.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TCWDatePicker.this);
            }
        }

        @Override // com.tencent.widget.TCWNumberPicker.e
        public void a(TCWNumberPicker tCWNumberPicker, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, tCWNumberPicker, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            TCWDatePicker.this.C.setTimeInMillis(TCWDatePicker.this.f384677m.getTimeInMillis());
            if (tCWNumberPicker == TCWDatePicker.this.f384673e) {
                int actualMaximum = TCWDatePicker.this.C.getActualMaximum(5);
                if (i3 == actualMaximum && i16 == 1) {
                    TCWDatePicker.this.C.add(5, 1);
                } else if (i3 == 1 && i16 == actualMaximum) {
                    TCWDatePicker.this.C.add(5, -1);
                } else {
                    TCWDatePicker.this.C.add(5, i16 - i3);
                }
            } else if (tCWNumberPicker == TCWDatePicker.this.f384674f) {
                TCWDatePicker.this.t();
                if (i3 == 11 && i16 == 0) {
                    TCWDatePicker.this.C.add(2, 1);
                } else if (i3 == 0 && i16 == 11) {
                    TCWDatePicker.this.C.add(2, -1);
                } else {
                    TCWDatePicker.this.C.add(2, i16 - i3);
                }
            } else if (tCWNumberPicker == TCWDatePicker.this.f384675h) {
                TCWDatePicker.this.C.set(1, i16);
            }
            TCWDatePicker tCWDatePicker = TCWDatePicker.this;
            tCWDatePicker.s(tCWDatePicker.C.get(1), TCWDatePicker.this.C.get(2), TCWDatePicker.this.C.get(5));
            TCWDatePicker.this.u();
            TCWDatePicker.this.o();
        }
    }

    /* loaded from: classes27.dex */
    public interface b {
    }

    public TCWDatePicker(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private Calendar j(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    private boolean p(String str, Calendar calendar) {
        try {
            calendar.setTime(this.f384672d.parse(str));
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    private void q() {
        char[] dateFormatOrder = android.text.format.DateFormat.getDateFormatOrder(getContext());
        if (dateFormatOrder[0] == 'M' && dateFormatOrder[1] == 'd') {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fic);
        linearLayout.removeAllViews();
        for (char c16 : dateFormatOrder) {
            if (c16 == 'd') {
                linearLayout.addView(this.f384673e);
            } else if (c16 == 'M') {
                linearLayout.addView(this.f384674f);
            } else {
                linearLayout.addView(this.f384675h);
            }
        }
    }

    private void r(Locale locale) {
        if (locale.equals(this.f384676i)) {
            return;
        }
        this.f384676i = locale;
        this.C = j(this.C, locale);
        this.D = j(this.D, locale);
        this.E = j(this.E, locale);
        this.f384677m = j(this.f384677m, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3, int i16, int i17) {
        this.f384677m.set(i3, i16, i17);
        if (this.f384677m.before(this.D)) {
            this.f384677m.setTimeInMillis(this.D.getTimeInMillis());
        } else if (this.f384677m.after(this.E)) {
            this.f384677m.setTimeInMillis(this.E.getTimeInMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f384673e.setRange(1, this.f384677m.getActualMaximum(5));
        this.f384673e.setCurrent(this.f384677m.get(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        t();
        this.f384675h.setCurrent(this.f384677m.get(1));
        this.f384674f.setCurrent(this.f384677m.get(2) + 1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sparseArray);
        } else {
            dispatchThawSelfOnly(sparseArray);
        }
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f384677m.get(5);
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f384677m.get(2);
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f384677m.get(1);
    }

    public void n(int i3, int i16, int i17, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bVar);
            return;
        }
        s(i3, i16, i17);
        u();
        o();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        s(savedState.f384678d, savedState.f384679e, savedState.f384680f);
        u();
        o();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Parcelable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new SavedState(super.onSaveInstanceState(), m(), l(), k());
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.setEnabled(z16);
        this.f384673e.setEnabled(z16);
        this.f384674f.setEnabled(z16);
        this.f384675h.setEnabled(z16);
    }

    public void setMaxDate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        this.C.setTimeInMillis(j3);
        if (this.C.get(1) == this.E.get(1) && this.C.get(6) != this.E.get(6)) {
            return;
        }
        this.E.setTimeInMillis(j3);
        if (this.f384677m.after(this.E)) {
            this.f384677m.setTimeInMillis(this.E.getTimeInMillis());
            o();
        }
        u();
    }

    public void setMinDate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
            return;
        }
        this.C.setTimeInMillis(j3);
        if (this.C.get(1) == this.D.get(1) && this.C.get(6) != this.D.get(6)) {
            return;
        }
        this.D.setTimeInMillis(j3);
        if (this.f384677m.before(this.D)) {
            this.f384677m.setTimeInMillis(this.D.getTimeInMillis());
            o();
        }
        u();
    }

    public TCWDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TCWDatePicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384672d = new SimpleDateFormat("MM/dd/yyyy");
        r(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.l3, (ViewGroup) this, true);
        a aVar = new a();
        TCWNumberPicker tCWNumberPicker = (TCWNumberPicker) findViewById(R.id.bdu);
        this.f384673e = tCWNumberPicker;
        TCWNumberPicker.b bVar = TCWNumberPicker.M;
        tCWNumberPicker.setFormatter(bVar);
        tCWNumberPicker.setSpeed(100L);
        tCWNumberPicker.setOnChangeListener(aVar);
        TCWNumberPicker tCWNumberPicker2 = (TCWNumberPicker) findViewById(R.id.ezb);
        this.f384674f = tCWNumberPicker2;
        tCWNumberPicker2.setFormatter(bVar);
        tCWNumberPicker2.setRange(1, 12, new DateFormatSymbols().getShortMonths());
        tCWNumberPicker2.setSpeed(200L);
        tCWNumberPicker2.setOnChangeListener(aVar);
        TCWNumberPicker tCWNumberPicker3 = (TCWNumberPicker) findViewById(R.id.l6i);
        this.f384675h = tCWNumberPicker3;
        tCWNumberPicker3.setSpeed(100L);
        tCWNumberPicker3.setOnChangeListener(aVar);
        if (AppSetting.f99565y) {
            TCWNumberPickerButton tCWNumberPickerButton = (TCWNumberPickerButton) tCWNumberPicker.findViewById(R.id.dja);
            TCWNumberPickerButton tCWNumberPickerButton2 = (TCWNumberPickerButton) tCWNumberPicker.findViewById(R.id.beq);
            tCWNumberPickerButton.setContentDescription(getContext().getString(R.string.f13487do));
            tCWNumberPickerButton2.setContentDescription(getContext().getString(R.string.f171113ca1));
            TCWNumberPickerButton tCWNumberPickerButton3 = (TCWNumberPickerButton) tCWNumberPicker2.findViewById(R.id.dja);
            TCWNumberPickerButton tCWNumberPickerButton4 = (TCWNumberPickerButton) tCWNumberPicker2.findViewById(R.id.beq);
            tCWNumberPickerButton3.setContentDescription(getContext().getString(R.string.f170059ec));
            tCWNumberPickerButton4.setContentDescription(getContext().getString(R.string.f171114ca2));
            TCWNumberPickerButton tCWNumberPickerButton5 = (TCWNumberPickerButton) tCWNumberPicker3.findViewById(R.id.dja);
            TCWNumberPickerButton tCWNumberPickerButton6 = (TCWNumberPickerButton) tCWNumberPicker3.findViewById(R.id.beq);
            tCWNumberPickerButton5.setContentDescription(getContext().getString(R.string.f170081fc));
            tCWNumberPickerButton6.setContentDescription(getContext().getString(R.string.f171115ca3));
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TCWDatePicker);
        int i16 = obtainStyledAttributes.getInt(R.styleable.TCWDatePicker_startYear, 1900);
        int i17 = obtainStyledAttributes.getInt(R.styleable.TCWDatePicker_endYear, 2100);
        String string = obtainStyledAttributes.getString(R.styleable.TCWDatePicker_minDate);
        String string2 = obtainStyledAttributes.getString(R.styleable.TCWDatePicker_maxDate);
        tCWNumberPicker3.setRange(i16, i17);
        obtainStyledAttributes.recycle();
        this.C.clear();
        if (!TextUtils.isEmpty(string)) {
            if (!p(string, this.C)) {
                this.C.set(i16, 0, 1);
            }
        } else {
            this.C.set(i16, 0, 1);
        }
        setMinDate(this.C.getTimeInMillis());
        this.C.clear();
        if (!TextUtils.isEmpty(string2)) {
            if (!p(string2, this.C)) {
                this.C.set(i17, 11, 31);
            }
        } else {
            this.C.set(i17, 11, 31);
        }
        setMaxDate(this.C.getTimeInMillis());
        this.f384677m.setTimeInMillis(System.currentTimeMillis());
        n(this.f384677m.get(1), this.f384677m.get(2), this.f384677m.get(5), null);
        q();
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class SavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        private final int f384678d;

        /* renamed from: e, reason: collision with root package name */
        private final int f384679e;

        /* renamed from: f, reason: collision with root package name */
        private final int f384680f;

        /* loaded from: classes27.dex */
        class a implements Parcelable.Creator<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77694);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                CREATOR = new a();
            }
        }

        SavedState(Parcelable parcelable, int i3, int i16, int i17) {
            super(parcelable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, parcelable, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f384678d = i3;
            this.f384679e = i16;
            this.f384680f = i17;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f384678d);
            parcel.writeInt(this.f384679e);
            parcel.writeInt(this.f384680f);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.f384678d = parcel.readInt();
            this.f384679e = parcel.readInt();
            this.f384680f = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
    }
}
