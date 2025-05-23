package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!SwitchPreference.this.callChangeListener(Boolean.valueOf(z16))) {
                compoundButton.setChecked(!z16);
            } else {
                SwitchPreference.this.setChecked(z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i3, i16);
        setSummaryOn(TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
        setSummaryOff(TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
        setSwitchTextOn(TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn));
        setSwitchTextOff(TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncSwitchView(View view) {
        boolean z16 = view instanceof Switch;
        if (z16) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z16) {
            Switch r46 = (Switch) view;
            r46.setTextOn(this.mSwitchOn);
            r46.setTextOff(this.mSwitchOff);
            r46.setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (!((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            return;
        }
        syncSwitchView(view.findViewById(16908352));
        syncSummaryView(view.findViewById(android.R.id.summary));
    }

    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncSwitchView(preferenceViewHolder.findViewById(16908352));
        syncSummaryView(preferenceViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick(View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public void setSwitchTextOff(CharSequence charSequence) {
        this.mSwitchOff = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOn(CharSequence charSequence) {
        this.mSwitchOn = charSequence;
        notifyChanged();
    }

    public void setSwitchTextOff(int i3) {
        setSwitchTextOff(getContext().getString(i3));
    }

    public void setSwitchTextOn(int i3) {
        setSwitchTextOn(getContext().getString(i3));
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, com.tencent.mobileqq.R.attr.bdo, android.R.attr.switchPreferenceStyle));
    }

    public SwitchPreference(Context context) {
        this(context, null);
    }
}
