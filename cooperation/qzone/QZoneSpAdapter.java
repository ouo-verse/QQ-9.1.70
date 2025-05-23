package cooperation.qzone;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneSpAdapter implements SharedPreferences {
    private final String mMmkvFileName;
    private final SharedPreferences mSp;
    private final String mSpName;
    private final boolean mUseMMKV;

    public QZoneSpAdapter(@NonNull SharedPreferences sharedPreferences, String str, @NonNull String str2, boolean z16) {
        this.mSp = sharedPreferences;
        this.mUseMMKV = z16;
        this.mSpName = str;
        this.mMmkvFileName = str2;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mSp.contains(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mSp.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.mSp.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.mSp.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.mSp.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.mSp.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.mSp.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.mSp.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSp.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSp.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public QZoneSpEditor edit() {
        return new QZoneSpEditor(this.mSp.edit(), this.mSpName, this.mMmkvFileName, this.mUseMMKV);
    }
}
