package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.tencent.luggage.wxa.fc.e;
import com.tencent.luggage.wxa.fc.f;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes9.dex */
public class MMDatePicker implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public a f153540a;

    /* renamed from: b, reason: collision with root package name */
    public View f153541b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153542c;

    /* renamed from: d, reason: collision with root package name */
    public int f153543d;

    /* renamed from: e, reason: collision with root package name */
    public BottomSheetBehavior f153544e;

    /* renamed from: f, reason: collision with root package name */
    public Button f153545f;

    /* renamed from: g, reason: collision with root package name */
    public Button f153546g;

    /* renamed from: h, reason: collision with root package name */
    public Button f153547h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f153548i;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f153549j;

    /* renamed from: k, reason: collision with root package name */
    public CustomDatePickerNew f153550k;

    /* renamed from: l, reason: collision with root package name */
    public OnResultListener f153551l;

    /* loaded from: classes9.dex */
    public interface OnResultListener<T> {
        void onResult(boolean z16, int i3, int i16, int i17);
    }

    public MMDatePicker(Context context) {
        this.f153542c = context;
        a();
    }

    public String getCurrentValue() {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            return customDatePickerNew.currentValue();
        }
        return null;
    }

    public CustomDatePickerNew getDatePicker() {
        return this.f153550k;
    }

    public int getDay() {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            return customDatePickerNew.getDayOfMonth();
        }
        return 0;
    }

    public int getMonth() {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            return customDatePickerNew.getMonth();
        }
        return 0;
    }

    public int getYear() {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            return customDatePickerNew.getYear();
        }
        return 0;
    }

    public void hide() {
        a aVar = this.f153540a;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void setHeaderView(View view) {
        LinearLayout linearLayout = this.f153549j;
        if (linearLayout != null) {
            if (view == null) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            this.f153549j.removeAllViews();
            this.f153549j.setGravity(17);
            this.f153549j.addView(view, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void setInitDate(int i3, int i16, int i17) {
        CustomDatePickerNew customDatePickerNew;
        if (i3 >= 0 && i16 >= 0 && i17 >= 0 && (customDatePickerNew = this.f153550k) != null) {
            customDatePickerNew.init(i3, i16, i17);
        }
    }

    public void setLongTermYear(boolean z16) {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            customDatePickerNew.setLongTermYear(z16);
        }
    }

    public void setMaxDate(int i3, int i16, int i17) {
        if (i3 >= 0 && i16 >= 0 && i17 >= 0) {
            Calendar calendar = Calendar.getInstance(Locale.US);
            calendar.set(i3, i16 - 1, i17);
            CustomDatePickerNew customDatePickerNew = this.f153550k;
            if (customDatePickerNew != null) {
                customDatePickerNew.setMaxDate(Long.valueOf(calendar.getTimeInMillis()));
            }
        }
    }

    public void setMinDate(int i3, int i16, int i17) {
        if (i3 >= 0 && i16 >= 0 && i17 >= 0) {
            Calendar calendar = Calendar.getInstance(Locale.US);
            calendar.set(i3, i16 - 1, i17);
            CustomDatePickerNew customDatePickerNew = this.f153550k;
            if (customDatePickerNew != null) {
                customDatePickerNew.setMinDate(Long.valueOf(calendar.getTimeInMillis()));
            }
        }
    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.f153551l = onResultListener;
    }

    public void setOnTimeSelectChangeListener(e eVar) {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            customDatePickerNew.setTimeSelectChangeListener(eVar);
        }
    }

    public void setOnTimeSelectListener(f fVar) {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            customDatePickerNew.setOnTimeSelectListener(fVar);
        }
    }

    public void setPickersEnable(boolean z16, boolean z17, boolean z18) {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            customDatePickerNew.setPickersEnable(z16, z17, z18);
        }
    }

    public void setRightBtnText(CharSequence charSequence) {
        Button button = this.f153545f;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void setSingleBtnText(CharSequence charSequence) {
        Button button = this.f153547h;
        if (button != null) {
            button.setText(charSequence);
        }
    }

    public void show() {
        if (this.f153540a != null) {
            CustomDatePickerNew customDatePickerNew = this.f153550k;
            if (customDatePickerNew != null) {
                customDatePickerNew.onShow();
            }
            this.f153540a.show();
        }
    }

    public void showSingleBtn(boolean z16) {
        if (z16) {
            Button button = this.f153547h;
            if (button != null) {
                button.setVisibility(0);
            }
            Button button2 = this.f153545f;
            if (button2 != null) {
                button2.setVisibility(8);
            }
            Button button3 = this.f153546g;
            if (button3 != null) {
                button3.setVisibility(8);
                return;
            }
            return;
        }
        Button button4 = this.f153547h;
        if (button4 != null) {
            button4.setVisibility(8);
        }
        Button button5 = this.f153545f;
        if (button5 != null) {
            button5.setVisibility(0);
        }
        Button button6 = this.f153546g;
        if (button6 != null) {
            button6.setVisibility(0);
        }
    }

    public void setLongTermYear(boolean z16, int i3) {
        CustomDatePickerNew customDatePickerNew = this.f153550k;
        if (customDatePickerNew != null) {
            customDatePickerNew.setLongTermYear(z16, i3);
        }
    }

    public final void a() {
        this.f153540a = new a(this.f153542c);
        View inflate = View.inflate(this.f153542c, R.layout.e5g, null);
        this.f153541b = inflate;
        this.f153548i = (LinearLayout) inflate.findViewById(R.id.bdm);
        this.f153549j = (LinearLayout) this.f153541b.findViewById(R.id.ue7);
        this.f153550k = new CustomDatePickerNew(this.f153542c);
        this.f153548i.removeAllViews();
        this.f153548i.setGravity(17);
        this.f153548i.addView(this.f153550k.getView(), new LinearLayout.LayoutParams(-1, -1));
        Button button = (Button) this.f153541b.findViewById(R.id.fcw);
        this.f153545f = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMDatePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMDatePicker mMDatePicker = MMDatePicker.this;
                mMDatePicker.a(true, mMDatePicker.f153550k.getYear(), MMDatePicker.this.f153550k.getMonth(), MMDatePicker.this.f153550k.getDayOfMonth());
                MMDatePicker.this.hide();
            }
        });
        Button button2 = (Button) this.f153541b.findViewById(R.id.aou);
        this.f153546g = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMDatePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMDatePicker.this.a(false, 0, 0, 0);
                MMDatePicker.this.hide();
            }
        });
        Button button3 = (Button) this.f153541b.findViewById(R.id.f164686th3);
        this.f153547h = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMDatePicker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMDatePicker mMDatePicker = MMDatePicker.this;
                mMDatePicker.a(true, mMDatePicker.f153550k.getYear(), MMDatePicker.this.f153550k.getMonth(), MMDatePicker.this.f153550k.getDayOfMonth());
                MMDatePicker.this.hide();
            }
        });
        this.f153540a.setContentView(this.f153541b);
        this.f153540a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mm.ui.widget.picker.MMDatePicker.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                MMDatePicker.this.a(false, 0, 0, 0);
                MMDatePicker.this.hide();
            }
        });
        this.f153543d = o.a(this.f153542c, 420);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) this.f153541b.getParent());
        this.f153544e = from;
        if (from != null) {
            from.setPeekHeight(this.f153543d);
            this.f153544e.setHideable(false);
        }
        this.f153540a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.picker.MMDatePicker.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MMDatePicker.this.f153540a = null;
                MMDatePicker.this.a(false, 0, 0, 0);
            }
        });
    }

    public final void a(boolean z16, int i3, int i16, int i17) {
        OnResultListener onResultListener = this.f153551l;
        if (onResultListener != null) {
            onResultListener.onResult(z16, i3, i16, i17);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }
}
