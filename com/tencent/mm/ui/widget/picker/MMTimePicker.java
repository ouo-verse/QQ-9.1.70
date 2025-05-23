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

/* loaded from: classes9.dex */
public class MMTimePicker implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public a f153578a;

    /* renamed from: b, reason: collision with root package name */
    public View f153579b;

    /* renamed from: c, reason: collision with root package name */
    public Context f153580c;

    /* renamed from: d, reason: collision with root package name */
    public int f153581d;

    /* renamed from: e, reason: collision with root package name */
    public BottomSheetBehavior f153582e;

    /* renamed from: f, reason: collision with root package name */
    public Button f153583f;

    /* renamed from: g, reason: collision with root package name */
    public Button f153584g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f153585h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f153586i;

    /* renamed from: j, reason: collision with root package name */
    public CustomTimePickerNew f153587j;

    /* renamed from: k, reason: collision with root package name */
    public OnResultListener f153588k;

    /* loaded from: classes9.dex */
    public interface OnResultListener<T> {
        void onResult(boolean z16, T t16);
    }

    public MMTimePicker(Context context) {
        this.f153580c = context;
        a();
    }

    public String getCurrentValue() {
        CustomTimePickerNew customTimePickerNew = this.f153587j;
        if (customTimePickerNew != null) {
            return customTimePickerNew.currentValue();
        }
        return "";
    }

    public void hide() {
        a aVar = this.f153578a;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void setCurrentTime(int i3, int i16) {
        CustomTimePickerNew customTimePickerNew = this.f153587j;
        if (customTimePickerNew != null) {
            customTimePickerNew.init(i3, i16);
        }
    }

    public void setHeaderView(View view) {
        LinearLayout linearLayout = this.f153586i;
        if (linearLayout != null) {
            if (view == null) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            this.f153586i.removeAllViews();
            this.f153586i.setGravity(17);
            this.f153586i.addView(view, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void setMaxTime(int i3, int i16) {
        CustomTimePickerNew customTimePickerNew = this.f153587j;
        if (customTimePickerNew != null) {
            customTimePickerNew.setMaxTime(i3, i16);
        }
    }

    public void setMinTime(int i3, int i16) {
        CustomTimePickerNew customTimePickerNew = this.f153587j;
        if (customTimePickerNew != null) {
            customTimePickerNew.setMinTime(i3, i16);
        }
    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.f153588k = onResultListener;
    }

    public void setOnTimeSelectChangeListener(e eVar) {
        CustomTimePickerNew customTimePickerNew = this.f153587j;
        if (customTimePickerNew != null) {
            customTimePickerNew.setTimeSelectChangeListener(eVar);
        }
    }

    public void setOnTimeSelectListener(f fVar) {
        CustomTimePickerNew customTimePickerNew = this.f153587j;
        if (customTimePickerNew != null) {
            customTimePickerNew.setOnTimeSelectListener(fVar);
        }
    }

    public void show() {
        if (this.f153578a != null) {
            CustomTimePickerNew customTimePickerNew = this.f153587j;
            if (customTimePickerNew != null) {
                customTimePickerNew.onShow();
            }
            this.f153578a.show();
        }
    }

    public final void a() {
        this.f153578a = new a(this.f153580c);
        View inflate = View.inflate(this.f153580c, R.layout.hxk, null);
        this.f153579b = inflate;
        this.f153585h = (LinearLayout) inflate.findViewById(R.id.jlo);
        this.f153586i = (LinearLayout) this.f153579b.findViewById(R.id.f97305k1);
        this.f153587j = new CustomTimePickerNew(this.f153580c);
        this.f153585h.removeAllViews();
        this.f153585h.setGravity(17);
        this.f153585h.addView(this.f153587j.getView(), new LinearLayout.LayoutParams(-1, -1));
        Button button = (Button) this.f153579b.findViewById(R.id.fcw);
        this.f153583f = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMTimePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String currentValue;
                MMTimePicker mMTimePicker = MMTimePicker.this;
                if (mMTimePicker.f153587j == null) {
                    currentValue = null;
                } else {
                    currentValue = MMTimePicker.this.f153587j.currentValue();
                }
                mMTimePicker.a(true, (Object) currentValue);
            }
        });
        Button button2 = (Button) this.f153579b.findViewById(R.id.aou);
        this.f153584g = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.picker.MMTimePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MMTimePicker.this.a(false, (Object) null);
            }
        });
        this.f153578a.setContentView(this.f153579b);
        this.f153581d = o.a(this.f153580c, 420);
        BottomSheetBehavior from = BottomSheetBehavior.from((View) this.f153579b.getParent());
        this.f153582e = from;
        if (from != null) {
            from.setPeekHeight(this.f153581d);
            this.f153582e.setHideable(false);
        }
        this.f153578a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mm.ui.widget.picker.MMTimePicker.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MMTimePicker.this.f153578a = null;
                MMTimePicker.this.a(false, (Object) null);
            }
        });
    }

    public final void a(boolean z16, Object obj) {
        OnResultListener onResultListener = this.f153588k;
        if (onResultListener != null) {
            onResultListener.onResult(z16, obj);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }
}
