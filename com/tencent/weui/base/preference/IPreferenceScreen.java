package com.tencent.weui.base.preference;

import android.preference.Preference;

/* loaded from: classes27.dex */
public interface IPreferenceScreen {
    void addPreference(Preference preference);

    void addPreference(Preference preference, int i3);

    void addPreference(Preference preference, boolean z16);

    void addPreferencesFromResource(int i3);

    Preference findPreference(String str);

    void hidePreference(String str, boolean z16);

    int indexOf(String str);

    int indexOfShow(String str);

    void notifyDataSetChanged();

    void removeAll();

    boolean removePreference(Preference preference);

    boolean removePreference(String str);
}
