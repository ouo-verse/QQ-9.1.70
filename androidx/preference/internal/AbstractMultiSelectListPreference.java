package androidx.preference.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.preference.DialogPreference;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }

    public abstract CharSequence[] getEntries();

    public abstract CharSequence[] getEntryValues();

    public abstract Set<String> getValues();

    public abstract void setValues(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractMultiSelectListPreference(Context context) {
        super(context);
    }
}
