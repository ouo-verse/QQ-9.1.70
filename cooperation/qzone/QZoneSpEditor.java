package cooperation.qzone;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneSpEditor implements SharedPreferences.Editor {
    private final SharedPreferences.Editor mEditor;
    private final String mMmkvFileName;
    private final String mSpName;
    private final boolean mUseMMKV;

    public QZoneSpEditor(@NonNull SharedPreferences.Editor editor, String str, @NonNull String str2, boolean z16) {
        this.mEditor = editor;
        this.mSpName = str;
        this.mMmkvFileName = str2;
        this.mUseMMKV = z16;
    }

    private SharedPreferences getMMKV() {
        return QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, this.mSpName, this.mMmkvFileName);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.mEditor.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.mEditor.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.mEditor.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        if (!this.mUseMMKV) {
            getMMKV().edit().putBoolean(str, z16).apply();
        }
        return this.mEditor.putBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        if (!this.mUseMMKV) {
            getMMKV().edit().putFloat(str, f16).apply();
        }
        return this.mEditor.putFloat(str, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        if (!this.mUseMMKV) {
            getMMKV().edit().putInt(str, i3).apply();
        }
        return this.mEditor.putInt(str, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        if (!this.mUseMMKV) {
            getMMKV().edit().putLong(str, j3).apply();
        }
        return this.mEditor.putLong(str, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        if (!this.mUseMMKV) {
            getMMKV().edit().putString(str, str2).apply();
        }
        return this.mEditor.putString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        if (!this.mUseMMKV) {
            getMMKV().edit().putStringSet(str, set).apply();
        }
        return this.mEditor.putStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        return this.mEditor.remove(str);
    }
}
