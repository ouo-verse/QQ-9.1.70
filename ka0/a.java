package ka0;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.tencent.qcircle.application.QCircleApplication;
import java.util.Set;

/* compiled from: P */
@Deprecated
/* loaded from: classes4.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: ka0.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class SharedPreferencesEditorC10643a implements SharedPreferences.Editor {

        /* renamed from: d, reason: collision with root package name */
        private SharedPreferences.Editor f411984d;

        public SharedPreferencesEditorC10643a(SharedPreferences.Editor editor) {
            this.f411984d = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f411984d.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @SuppressLint({"NewApi"})
        public boolean commit() {
            this.f411984d.apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            this.f411984d.putBoolean(str, z16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            this.f411984d.putFloat(str, f16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            this.f411984d.putInt(str, i3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            this.f411984d.putLong(str, j3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f411984d.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @SuppressLint({"NewApi"})
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.f411984d.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f411984d.remove(str);
            return this;
        }
    }

    private static SharedPreferences.Editor a(String str) {
        return new SharedPreferencesEditorC10643a(c(str).edit());
    }

    private static SharedPreferences.Editor b(long j3) {
        return new SharedPreferencesEditorC10643a(d(j3).edit());
    }

    @SuppressLint({"InlinedApi"})
    public static SharedPreferences c(String str) {
        return QCircleApplication.APP.getSharedPreferences(str, 0);
    }

    public static SharedPreferences d(long j3) {
        String str;
        if (j3 == 0) {
            str = "QC_setting";
        } else {
            str = j3 + "_preference";
        }
        return c(str);
    }

    public static void e(String str, boolean z16, long j3) {
        SharedPreferences.Editor b16 = b(j3);
        b16.putBoolean(str, z16);
        b16.commit();
    }

    public static void f(String str, String str2) {
        g("QC_setting", str, str2);
    }

    public static void g(String str, String str2, String str3) {
        SharedPreferences.Editor a16 = a(str);
        a16.putString(str2, str3);
        a16.commit();
    }
}
