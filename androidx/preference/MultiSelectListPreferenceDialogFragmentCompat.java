package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragmentCompat.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.values";
    CharSequence[] mEntries;
    CharSequence[] mEntryValues;
    Set<String> mNewValues = new HashSet();
    boolean mPreferenceChanged;

    private AbstractMultiSelectListPreference getListPreference() {
        return (AbstractMultiSelectListPreference) getPreference();
    }

    public static MultiSelectListPreferenceDialogFragmentCompat newInstance(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            AbstractMultiSelectListPreference listPreference = getListPreference();
            if (listPreference.getEntries() != null && listPreference.getEntryValues() != null) {
                this.mNewValues.clear();
                this.mNewValues.addAll(listPreference.getValues());
                this.mPreferenceChanged = false;
                this.mEntries = listPreference.getEntries();
                this.mEntryValues = listPreference.getEntryValues();
                return;
            }
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.mNewValues.clear();
        this.mNewValues.addAll(bundle.getStringArrayList(SAVE_STATE_VALUES));
        this.mPreferenceChanged = bundle.getBoolean(SAVE_STATE_CHANGED, false);
        this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z16) {
        AbstractMultiSelectListPreference listPreference = getListPreference();
        if (z16 && this.mPreferenceChanged) {
            Set<String> set = this.mNewValues;
            if (listPreference.callChangeListener(set)) {
                listPreference.setValues(set);
            }
        }
        this.mPreferenceChanged = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.mNewValues.contains(this.mEntryValues[i3].toString());
        }
        builder.setMultiChoiceItems(this.mEntries, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i16, boolean z16) {
                if (z16) {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged = multiSelectListPreferenceDialogFragmentCompat.mNewValues.add(multiSelectListPreferenceDialogFragmentCompat.mEntryValues[i16].toString()) | multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged;
                } else {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat2.mPreferenceChanged = multiSelectListPreferenceDialogFragmentCompat2.mNewValues.remove(multiSelectListPreferenceDialogFragmentCompat2.mEntryValues[i16].toString()) | multiSelectListPreferenceDialogFragmentCompat2.mPreferenceChanged;
                }
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList<>(this.mNewValues));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.mPreferenceChanged);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }
}
