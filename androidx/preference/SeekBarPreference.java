package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    private static final String TAG = "SeekBarPreference";
    boolean mAdjustable;
    private int mMax;
    int mMin;
    SeekBar mSeekBar;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private int mSeekBarIncrement;
    private View.OnKeyListener mSeekBarKeyListener;
    int mSeekBarValue;
    private TextView mSeekBarValueTextView;
    private boolean mShowSeekBarValue;
    boolean mTrackingTouch;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i17, boolean z16) {
                if (z16) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    if (!seekBarPreference.mTrackingTouch) {
                        seekBarPreference.syncValueInternal(seekBar);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.mTrackingTouch = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
                SeekBarPreference.this.mTrackingTouch = false;
                int progress = seekBar.getProgress();
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (progress + seekBarPreference.mMin != seekBarPreference.mSeekBarValue) {
                    seekBarPreference.syncValueInternal(seekBar);
                }
                EventCollector.getInstance().onStopTrackingTouch(seekBar);
            }
        };
        this.mSeekBarKeyListener = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i17, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.mAdjustable && (i17 == 21 || i17 == 22)) || i17 == 23 || i17 == 66) {
                    return false;
                }
                SeekBar seekBar = seekBarPreference.mSeekBar;
                if (seekBar == null) {
                    Log.e(SeekBarPreference.TAG, "SeekBar view is null and hence cannot be adjusted.");
                    return false;
                }
                return seekBar.onKeyDown(i17, keyEvent);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i3, i16);
        this.mMin = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        setMax(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        setSeekBarIncrement(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.mAdjustable = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.mShowSeekBarValue = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, true);
        obtainStyledAttributes.recycle();
    }

    private void setValueInternal(int i3, boolean z16) {
        int i16 = this.mMin;
        if (i3 < i16) {
            i3 = i16;
        }
        int i17 = this.mMax;
        if (i3 > i17) {
            i3 = i17;
        }
        if (i3 != this.mSeekBarValue) {
            this.mSeekBarValue = i3;
            TextView textView = this.mSeekBarValueTextView;
            if (textView != null) {
                textView.setText(String.valueOf(i3));
            }
            persistInt(i3);
            if (z16) {
                notifyChanged();
            }
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getMin() {
        return this.mMin;
    }

    public final int getSeekBarIncrement() {
        return this.mSeekBarIncrement;
    }

    public int getValue() {
        return this.mSeekBarValue;
    }

    public boolean isAdjustable() {
        return this.mAdjustable;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.mSeekBarKeyListener);
        this.mSeekBar = (SeekBar) preferenceViewHolder.findViewById(com.tencent.mobileqq.R.id.iln);
        TextView textView = (TextView) preferenceViewHolder.findViewById(com.tencent.mobileqq.R.id.f81904ff);
        this.mSeekBarValueTextView = textView;
        if (this.mShowSeekBarValue) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.mSeekBarValueTextView = null;
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Log.e(TAG, "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.mSeekBar.setMax(this.mMax - this.mMin);
        int i3 = this.mSeekBarIncrement;
        if (i3 != 0) {
            this.mSeekBar.setKeyProgressIncrement(i3);
        } else {
            this.mSeekBarIncrement = this.mSeekBar.getKeyProgressIncrement();
        }
        this.mSeekBar.setProgress(this.mSeekBarValue - this.mMin);
        TextView textView2 = this.mSeekBarValueTextView;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.mSeekBarValue));
        }
        this.mSeekBar.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return Integer.valueOf(typedArray.getInt(i3, 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSeekBarValue = savedState.seekBarValue;
        this.mMin = savedState.min;
        this.mMax = savedState.max;
        notifyChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.seekBarValue = this.mSeekBarValue;
        savedState.min = this.mMin;
        savedState.max = this.mMax;
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        setValue(getPersistedInt(((Integer) obj).intValue()));
    }

    public void setAdjustable(boolean z16) {
        this.mAdjustable = z16;
    }

    public final void setMax(int i3) {
        int i16 = this.mMin;
        if (i3 < i16) {
            i3 = i16;
        }
        if (i3 != this.mMax) {
            this.mMax = i3;
            notifyChanged();
        }
    }

    public void setMin(int i3) {
        int i16 = this.mMax;
        if (i3 > i16) {
            i3 = i16;
        }
        if (i3 != this.mMin) {
            this.mMin = i3;
            notifyChanged();
        }
    }

    public final void setSeekBarIncrement(int i3) {
        if (i3 != this.mSeekBarIncrement) {
            this.mSeekBarIncrement = Math.min(this.mMax - this.mMin, Math.abs(i3));
            notifyChanged();
        }
    }

    public void setValue(int i3) {
        setValueInternal(i3, true);
    }

    void syncValueInternal(SeekBar seekBar) {
        int progress = this.mMin + seekBar.getProgress();
        if (progress != this.mSeekBarValue) {
            if (callChangeListener(Integer.valueOf(progress))) {
                setValueInternal(progress, false);
            } else {
                seekBar.setProgress(this.mSeekBarValue - this.mMin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.SeekBarPreference.SavedState.1
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
        int max;
        int min;
        int seekBarValue;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.seekBarValue = parcel.readInt();
            this.min = parcel.readInt();
            this.max = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.seekBarValue);
            parcel.writeInt(this.min);
            parcel.writeInt(this.max);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.b7o);
    }

    public SeekBarPreference(Context context) {
        this(context, null);
    }
}
