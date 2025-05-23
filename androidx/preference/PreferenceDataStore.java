package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class PreferenceDataStore {
    public void putBoolean(String str, boolean z16) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f16) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i3) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j3) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public boolean getBoolean(String str, boolean z16) {
        return z16;
    }

    public float getFloat(String str, float f16) {
        return f16;
    }

    public int getInt(String str, int i3) {
        return i3;
    }

    public long getLong(String str, long j3) {
        return j3;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }
}
