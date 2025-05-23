package com.tencent.mobileqq.winkpublish.common.config;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import java.util.Set;

/* compiled from: P */
@Deprecated
/* loaded from: classes21.dex */
public class LocalConfig {
    private static final String PREFS_NAME_4_UIN_DEFAULT = "preference";
    public static final String PREFS_NAME_QZ_SETTING = "QFS_setting";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class ConfigEditor implements SharedPreferences.Editor {
        private SharedPreferences.Editor mEditor;

        public ConfigEditor(SharedPreferences.Editor editor) {
            this.mEditor = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @SuppressLint({"NewApi"})
        public boolean commit() {
            this.mEditor.apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            this.mEditor.putBoolean(str, z16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            this.mEditor.putFloat(str, f16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            this.mEditor.putInt(str, i3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            this.mEditor.putLong(str, j3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.mEditor.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @SuppressLint({"NewApi"})
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.mEditor.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.mEditor.remove(str);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface Constants {
        public static final String KEY_WINK_VIDEO_BGM_DETECT_SHOW_DIALOG = "key_wink_video_bgm_detect_show_dialog";
    }

    private static SharedPreferences.Editor edit4Uin(long j3) {
        return new ConfigEditor(getPreferences4Uin(j3).edit());
    }

    public static boolean getBool4Uin(String str, boolean z16, long j3) {
        return getPreferences4Uin(j3).getBoolean(str, z16);
    }

    @SuppressLint({"InlinedApi"})
    public static SharedPreferences getPreferences(String str) {
        return RFWApplication.getApplication().getSharedPreferences(str, 4);
    }

    public static SharedPreferences getPreferences4Uin(long j3) {
        String str;
        if (j3 == 0) {
            str = PREFS_NAME_QZ_SETTING;
        } else {
            str = j3 + "_" + PREFS_NAME_4_UIN_DEFAULT;
        }
        return getPreferences(str);
    }

    public static void putBool4Uin(String str, boolean z16, long j3) {
        SharedPreferences.Editor edit4Uin = edit4Uin(j3);
        edit4Uin.putBoolean(str, z16);
        edit4Uin.commit();
    }
}
