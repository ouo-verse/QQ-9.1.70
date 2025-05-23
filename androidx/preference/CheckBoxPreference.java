package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    private final Listener mListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z16))) {
                compoundButton.setChecked(!z16);
            } else {
                CheckBoxPreference.this.setChecked(z16);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncCheckboxView(View view) {
        boolean z16 = view instanceof CompoundButton;
        if (z16) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z16) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) {
        if (!((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            return;
        }
        syncCheckboxView(view.findViewById(android.R.id.checkbox));
        syncSummaryView(view.findViewById(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncCheckboxView(preferenceViewHolder.findViewById(android.R.id.checkbox));
        syncSummaryView(preferenceViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick(View view) {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mListener = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckBoxPreference, i3, i16);
        setSummaryOn(TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOn, R.styleable.CheckBoxPreference_android_summaryOn));
        setSummaryOff(TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOff, R.styleable.CheckBoxPreference_android_summaryOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.CheckBoxPreference_disableDependentsState, R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, com.tencent.mobileqq.R.attr.a59, android.R.attr.checkBoxPreferenceStyle));
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
    }
}
