package android.support.v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public final class SharedPreferencesCompat {

    /* loaded from: classes.dex */
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper = new Helper();

        /* loaded from: classes.dex */
        private static class Helper {
            Helper() {
            }

            public void apply(@NonNull SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        EditorCompat() {
        }

        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    SharedPreferencesCompat() {
    }
}
