package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Chip f34482d;

    /* renamed from: e, reason: collision with root package name */
    private final Chip f34483e;

    /* renamed from: f, reason: collision with root package name */
    private final ClockHandView f34484f;

    /* renamed from: h, reason: collision with root package name */
    private final ClockFaceView f34485h;

    /* renamed from: i, reason: collision with root package name */
    private final MaterialButtonToggleGroup f34486i;

    /* renamed from: m, reason: collision with root package name */
    private final View.OnClickListener f34487m;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TimePickerView.z0(TimePickerView.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes2.dex */
    class b implements MaterialButtonToggleGroup.d {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z16) {
            TimePickerView.A0(TimePickerView.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.B0(TimePickerView.this);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GestureDetector f34491d;

        d(GestureDetector gestureDetector) {
            this.f34491d = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f34491d.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    interface e {
    }

    /* loaded from: classes2.dex */
    interface f {
    }

    /* loaded from: classes2.dex */
    interface g {
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ f A0(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ e B0(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    private void C0() {
        this.f34482d.setTag(R.id.f82804hv, 12);
        this.f34483e.setTag(R.id.f82804hv, 10);
        this.f34482d.setOnClickListener(this.f34487m);
        this.f34483e.setOnClickListener(this.f34487m);
        this.f34482d.setAccessibilityClassName("android.view.View");
        this.f34483e.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void D0() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.f34482d.setOnTouchListener(dVar);
        this.f34483e.setOnTouchListener(dVar);
    }

    private void E0() {
        boolean z16;
        if (this.f34486i.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            int i3 = 1;
            if (ViewCompat.getLayoutDirection(this) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 2;
            }
            constraintSet.clear(R.id.yy9, i3);
            constraintSet.applyTo(this);
        }
    }

    static /* synthetic */ g z0(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        E0();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            E0();
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f34487m = new a();
        LayoutInflater.from(context).inflate(R.layout.fh5, this);
        this.f34485h = (ClockFaceView) findViewById(R.id.yy_);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.yyd);
        this.f34486i = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new b());
        this.f34482d = (Chip) findViewById(R.id.yyk);
        this.f34483e = (Chip) findViewById(R.id.yyh);
        this.f34484f = (ClockHandView) findViewById(R.id.yya);
        D0();
        C0();
    }
}
