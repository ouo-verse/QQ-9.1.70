package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<i<S>> C = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ph(i<S> iVar) {
        return this.C.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qh() {
        this.C.clear();
    }
}
