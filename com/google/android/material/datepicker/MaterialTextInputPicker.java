package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {

    @StyleRes
    private int D;

    @Nullable
    private DateSelector<S> E;

    @Nullable
    private CalendarConstraints F;

    /* loaded from: classes2.dex */
    class a extends i<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.i
        public void a() {
            Iterator<i<S>> it = MaterialTextInputPicker.this.C.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.i
        public void b(S s16) {
            Iterator<i<S>> it = MaterialTextInputPicker.this.C.iterator();
            while (it.hasNext()) {
                it.next().b(s16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <T> MaterialTextInputPicker<T> rh(DateSelector<T> dateSelector, @StyleRes int i3, @NonNull CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.D = bundle.getInt("THEME_RES_ID_KEY");
        this.E = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.F = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View d16 = this.E.d(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.D)), viewGroup, bundle, this.F, new a());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, d16);
        return d16;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.D);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.E);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.F);
    }
}
