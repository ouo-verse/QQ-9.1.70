package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RangeSlider extends BaseSlider<RangeSlider, Object, Object> {
    private float C0;
    private int D0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator<RangeSliderState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private float f34167d;

        /* renamed from: e, reason: collision with root package name */
        private int f34168e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<RangeSliderState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RangeSliderState createFromParcel(Parcel parcel) {
                return new RangeSliderState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public RangeSliderState[] newArray(int i3) {
                return new RangeSliderState[i3];
            }
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.f34167d);
            parcel.writeInt(this.f34168e);
        }

        RangeSliderState(Parcelable parcelable) {
            super(parcelable);
        }

        RangeSliderState(Parcel parcel) {
            super(parcel.readParcelable(RangeSliderState.class.getClassLoader()));
            this.f34167d = parcel.readFloat();
            this.f34168e = parcel.readInt();
        }
    }

    public RangeSlider(@NonNull Context context) {
        this(context, null);
    }

    private static List<Float> E0(TypedArray typedArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < typedArray.length(); i3++) {
            arrayList.add(Float.valueOf(typedArray.getFloat(i3, -1.0f)));
        }
        return arrayList;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public float G() {
        return this.C0;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float H() {
        return super.H();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ float K() {
        return super.K();
    }

    @Override // com.google.android.material.slider.BaseSlider
    @NonNull
    public List<Float> L() {
        return super.L();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ boolean M() {
        return super.M();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    @NonNull
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i3, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i3, @NonNull KeyEvent keyEvent) {
        return super.onKeyUp(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        RangeSliderState rangeSliderState = (RangeSliderState) parcelable;
        super.onRestoreInstanceState(rangeSliderState.getSuperState());
        this.C0 = rangeSliderState.f34167d;
        int i3 = rangeSliderState.f34168e;
        this.D0 = i3;
        j0(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        RangeSliderState rangeSliderState = new RangeSliderState(super.onSaveInstanceState());
        rangeSliderState.f34167d = this.C0;
        rangeSliderState.f34168e = this.D0;
        return rangeSliderState;
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@DrawableRes int i3) {
        super.setCustomThumbDrawable(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        super.setCustomThumbDrawablesForValues(iArr);
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z16) {
        super.setEnabled(z16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i3) {
        super.setFocusedThumbIndex(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadius(@IntRange(from = 0) @Dimension int i3) {
        super.setHaloRadius(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloRadiusResource(@DimenRes int i3) {
        super.setHaloRadiusResource(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelBehavior(int i3) {
        super.setLabelBehavior(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable c cVar) {
        super.setLabelFormatter(cVar);
    }

    public void setMinSeparation(@Dimension float f16) {
        this.C0 = f16;
        this.D0 = 0;
        j0(0);
    }

    public void setMinSeparationValue(float f16) {
        this.C0 = f16;
        this.D0 = 1;
        j0(1);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setStepSize(float f16) {
        super.setStepSize(f16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevation(float f16) {
        super.setThumbElevation(f16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbElevationResource(@DimenRes int i3) {
        super.setThumbElevationResource(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadius(@IntRange(from = 0) @Dimension int i3) {
        super.setThumbRadius(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbRadiusResource(@DimenRes int i3) {
        super.setThumbRadiusResource(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(@ColorRes int i3) {
        super.setThumbStrokeColorResource(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f16) {
        super.setThumbStrokeWidth(f16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(@DimenRes int i3) {
        super.setThumbStrokeWidthResource(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setThumbTintList(@NonNull ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickTintList(@NonNull ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTickVisible(boolean z16) {
        super.setTickVisible(z16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackHeight(@IntRange(from = 0) @Dimension int i3) {
        super.setTrackHeight(i3);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setTrackTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueFrom(float f16) {
        super.setValueFrom(f16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public /* bridge */ /* synthetic */ void setValueTo(float f16) {
        super.setValueTo(f16);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(@NonNull Float... fArr) {
        super.setValues(fArr);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f156224ba0);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        super.setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setValues(@NonNull List<Float> list) {
        super.setValues(list);
    }

    public RangeSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray h16 = o.h(context, attributeSet, w0.a.f443816a7, i3, BaseSlider.B0, new int[0]);
        int i16 = w0.a.f443840c7;
        if (h16.hasValue(i16)) {
            setValues(E0(h16.getResources().obtainTypedArray(h16.getResourceId(i16, 0))));
        }
        this.C0 = h16.getDimension(w0.a.f443828b7, 0.0f);
        h16.recycle();
    }
}
