package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final ArrayAdapter mAdapter;
    private final Context mContext;
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;
    private Spinner mSpinner;

    public DropDownPreference(Context context) {
        this(context, null);
    }

    private void updateEntries() {
        this.mAdapter.clear();
        if (getEntries() != null) {
            for (CharSequence charSequence : getEntries()) {
                this.mAdapter.add(charSequence.toString());
            }
        }
    }

    protected ArrayAdapter createAdapter() {
        return new ArrayAdapter(this.mContext, android.R.layout.simple_spinner_dropdown_item);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int findSpinnerIndexOfValue(String str) {
        CharSequence[] entryValues = getEntryValues();
        if (str != null && entryValues != null) {
            for (int length = entryValues.length - 1; length >= 0; length--) {
                if (entryValues[length].equals(str)) {
                    return length;
                }
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void notifyChanged() {
        super.notifyChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Spinner spinner = (Spinner) preferenceViewHolder.itemView.findViewById(com.tencent.mobileqq.R.id.j0k);
        this.mSpinner = spinner;
        spinner.setAdapter((SpinnerAdapter) this.mAdapter);
        this.mSpinner.setOnItemSelectedListener(this.mItemSelectedListener);
        this.mSpinner.setSelection(findSpinnerIndexOfValue(getValue()));
        super.onBindViewHolder(preferenceViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public void onClick() {
        this.mSpinner.performClick();
    }

    @Override // androidx.preference.ListPreference
    public void setEntries(@NonNull CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        updateEntries();
    }

    @Override // androidx.preference.ListPreference
    public void setValueIndex(int i3) {
        setValue(getEntryValues()[i3].toString());
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.f155568ad2);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i17, long j3) {
                if (i17 >= 0) {
                    String charSequence = DropDownPreference.this.getEntryValues()[i17].toString();
                    if (!charSequence.equals(DropDownPreference.this.getValue()) && DropDownPreference.this.callChangeListener(charSequence)) {
                        DropDownPreference.this.setValue(charSequence);
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mContext = context;
        this.mAdapter = createAdapter();
        updateEntries();
    }
}
