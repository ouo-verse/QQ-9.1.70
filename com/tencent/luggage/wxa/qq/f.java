package com.tencent.luggage.wxa.qq;

import android.content.Context;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {
    public void a(Preference preference, Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (!(preference instanceof EditTextPreference) && !(preference instanceof ListPreference)) {
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                for (int i3 = 0; i3 < preferenceGroup.getPreferenceCount(); i3++) {
                    a(preferenceGroup.getPreference(i3), onPreferenceChangeListener);
                }
                return;
            }
            return;
        }
        preference.setOnPreferenceChangeListener(onPreferenceChangeListener);
    }

    public boolean a(Context context, com.tencent.xweb.debug.b bVar, boolean z16) {
        if (bVar != null) {
            bVar.a(context, z16 ? a.b() : a.a());
        }
        return z16;
    }
}
