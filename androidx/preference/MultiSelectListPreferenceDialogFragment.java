package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    static IPatchRedirector $redirector_ = null;
    private static final String SAVE_STATE_CHANGED = "MultiSelectListPreferenceDialogFragment.changed";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_VALUES = "MultiSelectListPreferenceDialogFragment.values";
    CharSequence[] mEntries;
    CharSequence[] mEntryValues;
    Set<String> mNewValues;
    boolean mPreferenceChanged;

    public MultiSelectListPreferenceDialogFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mNewValues = new HashSet();
        }
    }

    private AbstractMultiSelectListPreference getListPreference() {
        return (AbstractMultiSelectListPreference) getPreference();
    }

    public static MultiSelectListPreferenceDialogFragment newInstance(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
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

    @Override // androidx.preference.PreferenceDialogFragment
    public void onDialogClosed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
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
    @Override // androidx.preference.PreferenceDialogFragment
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) builder);
            return;
        }
        super.onPrepareDialogBuilder(builder);
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.mNewValues.contains(this.mEntryValues[i3].toString());
        }
        builder.setMultiChoiceItems(this.mEntries, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragment.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i16, boolean z16) {
                if (z16) {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment.mPreferenceChanged = multiSelectListPreferenceDialogFragment.mNewValues.add(multiSelectListPreferenceDialogFragment.mEntryValues[i16].toString()) | multiSelectListPreferenceDialogFragment.mPreferenceChanged;
                } else {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment2.mPreferenceChanged = multiSelectListPreferenceDialogFragment2.mNewValues.remove(multiSelectListPreferenceDialogFragment2.mEntryValues[i16].toString()) | multiSelectListPreferenceDialogFragment2.mPreferenceChanged;
                }
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SAVE_STATE_VALUES, new ArrayList<>(this.mNewValues));
        bundle.putBoolean(SAVE_STATE_CHANGED, this.mPreferenceChanged);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }
}
