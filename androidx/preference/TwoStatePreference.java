package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean mChecked;
    private boolean mCheckedSet;
    private boolean mDisableDependentsState;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onClick() {
        super.onClick();
        boolean z16 = !isChecked();
        if (callChangeListener(Boolean.valueOf(z16))) {
            setChecked(z16);
        }
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return Boolean.valueOf(typedArray.getBoolean(i3, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setChecked(savedState.checked);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.checked = isChecked();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        setChecked(getPersistedBoolean(((Boolean) obj).booleanValue()));
    }

    public void setChecked(boolean z16) {
        boolean z17;
        if (this.mChecked != z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || !this.mCheckedSet) {
            this.mChecked = z16;
            this.mCheckedSet = true;
            persistBoolean(z16);
            if (z17) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

    public void setDisableDependentsState(boolean z16) {
        this.mDisableDependentsState = z16;
    }

    public void setSummaryOff(CharSequence charSequence) {
        this.mSummaryOff = charSequence;
        if (isChecked()) {
            return;
        }
        notifyChanged();
    }

    public void setSummaryOn(CharSequence charSequence) {
        this.mSummaryOn = charSequence;
        if (isChecked()) {
            notifyChanged();
        }
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        boolean z16;
        if (this.mDisableDependentsState) {
            z16 = this.mChecked;
        } else if (!this.mChecked) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || super.shouldDisableDependents()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void syncSummaryView(PreferenceViewHolder preferenceViewHolder) {
        syncSummaryView(preferenceViewHolder.findViewById(android.R.id.summary));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.TwoStatePreference.SavedState.1
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
        boolean checked;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.checked = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void syncSummaryView(View view) {
        boolean z16;
        int i3;
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        if (this.mChecked && !TextUtils.isEmpty(this.mSummaryOn)) {
            textView.setText(this.mSummaryOn);
        } else if (!this.mChecked && !TextUtils.isEmpty(this.mSummaryOff)) {
            textView.setText(this.mSummaryOff);
        } else {
            z16 = true;
            if (z16) {
                CharSequence summary = getSummary();
                if (!TextUtils.isEmpty(summary)) {
                    textView.setText(summary);
                    z16 = false;
                }
            }
            i3 = z16 ? 8 : 0;
            if (i3 == textView.getVisibility()) {
                textView.setVisibility(i3);
                return;
            }
            return;
        }
        z16 = false;
        if (z16) {
        }
        if (z16) {
        }
        if (i3 == textView.getVisibility()) {
        }
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }

    public void setSummaryOff(int i3) {
        setSummaryOff(getContext().getString(i3));
    }

    public void setSummaryOn(int i3) {
        setSummaryOn(getContext().getString(i3));
    }
}
