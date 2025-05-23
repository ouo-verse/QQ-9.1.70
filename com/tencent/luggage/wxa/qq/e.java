package com.tencent.luggage.wxa.qq;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.mobileqq.R;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebEmbedSetting;
import com.tencent.xweb.debug.XWebDebugEditTextPreference;
import com.tencent.xweb.debug.XWebDebugListPreference;
import com.tencent.xweb.debug.XWebDebugPreference;
import com.tencent.xweb.debug.XWebDebugSwitchPreference;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.xweb.debug.b f138972a;

    /* renamed from: b, reason: collision with root package name */
    public final f f138973b = new f();

    public e(com.tencent.xweb.debug.b bVar) {
        this.f138972a = bVar;
    }

    public final int a(int i3, int i16) {
        if (i3 == 0) {
            return 3;
        }
        if (i3 != 2) {
            return 4;
        }
        if (i16 == 2) {
            return 1;
        }
        if (i16 == 1) {
            return 2;
        }
        return i16 == 0 ? 1 : 4;
    }

    public final void d() {
        EditTextPreference editTextPreference = (EditTextPreference) findPreference("set_gray_value");
        if (editTextPreference != null) {
            int c16 = v0.c();
            if (c16 > 0) {
                editTextPreference.setDefaultValue(c16 + "");
                editTextPreference.setSummary(c16 + "");
                return;
            }
            editTextPreference.setSummary("");
        }
    }

    public final void e() {
        EditTextPreference editTextPreference = (EditTextPreference) findPreference("set_config_url");
        if (editTextPreference != null) {
            String h16 = z0.h();
            if (!TextUtils.isEmpty(h16)) {
                editTextPreference.setDefaultValue(h16);
                editTextPreference.setSummary(h16);
            } else {
                editTextPreference.setSummary("");
            }
        }
    }

    public final void f() {
        WebView.WebViewKind webViewKind;
        WebView.WebViewKind webViewKind2;
        WebView.WebViewKind webViewKind3;
        ListPreference listPreference = (ListPreference) findPreference("set_mm_config");
        if (listPreference != null && (webViewKind3 = WebDebugCfg.getInst().getWebViewKind("mm")) != WebView.WebViewKind.WV_KIND_NONE) {
            listPreference.setValue(webViewKind3.name());
            listPreference.setSummary(listPreference.getEntry());
        }
        ListPreference listPreference2 = (ListPreference) findPreference("set_tools_config");
        if (listPreference2 != null && (webViewKind2 = WebDebugCfg.getInst().getWebViewKind("tools")) != WebView.WebViewKind.WV_KIND_NONE) {
            listPreference2.setValue(webViewKind2.name());
            listPreference2.setSummary(listPreference2.getEntry());
        }
        ListPreference listPreference3 = (ListPreference) findPreference("set_appbrand_config");
        if (listPreference3 != null && (webViewKind = WebDebugCfg.getInst().getWebViewKind("appbrand")) != WebView.WebViewKind.WV_KIND_NONE) {
            listPreference3.setValue(webViewKind.name());
            listPreference3.setSummary(listPreference3.getEntry());
        }
    }

    public final void g() {
        int webViewModeForMM;
        ListPreference listPreference = (ListPreference) findPreference("mm_webview_mode");
        if (listPreference != null && (webViewModeForMM = WebDebugCfg.getInst().getWebViewModeForMM()) >= 0) {
            listPreference.setValue(webViewModeForMM + "");
            listPreference.setSummary(listPreference.getEntry());
        }
    }

    public final void h() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference("enable_remote_debug");
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setChecked(WebDebugCfg.getInst().getEnableRemoteDebug());
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference("enable_show_version");
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.setChecked(WebDebugCfg.getInst().getEnableShowVersion());
        }
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) findPreference("enable_show_save_page");
        if (switchPreferenceCompat3 != null) {
            switchPreferenceCompat3.setChecked(WebDebugCfg.getInst().getEnableShowSavePage());
        }
        SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) findPreference("enable_show_fps");
        if (switchPreferenceCompat4 != null) {
            switchPreferenceCompat4.setChecked(WebDebugCfg.getInst().getEnableShowFps());
        }
        SwitchPreferenceCompat switchPreferenceCompat5 = (SwitchPreferenceCompat) findPreference("enable_debug_package");
        if (switchPreferenceCompat5 != null) {
            switchPreferenceCompat5.setChecked(WebDebugCfg.getInst().getEnableDebugPackage());
        }
        SwitchPreferenceCompat switchPreferenceCompat6 = (SwitchPreferenceCompat) findPreference("enable_new_debug_page");
        if (switchPreferenceCompat6 != null) {
            switchPreferenceCompat6.setChecked(WebDebugCfg.getInst().getEnableNewDebugPage());
        }
        SwitchPreferenceCompat switchPreferenceCompat7 = (SwitchPreferenceCompat) findPreference("enable_check_thread");
        if (switchPreferenceCompat7 != null) {
            switchPreferenceCompat7.setChecked(WebDebugCfg.getInst().getEnableCheckThread());
        }
        SwitchPreferenceCompat switchPreferenceCompat8 = (SwitchPreferenceCompat) findPreference("ignore_crash_watch");
        if (switchPreferenceCompat8 != null) {
            switchPreferenceCompat8.setChecked(WebDebugCfg.getInst().getIgnoreCrashWatch());
        }
        SwitchPreferenceCompat switchPreferenceCompat9 = (SwitchPreferenceCompat) findPreference("enable_check_storage");
        if (switchPreferenceCompat9 != null) {
            switchPreferenceCompat9.setChecked(WebDebugCfg.getInst().getEnableCheckStorage());
        }
        SwitchPreferenceCompat switchPreferenceCompat10 = (SwitchPreferenceCompat) findPreference("enable_forbid_download_code");
        if (switchPreferenceCompat10 != null) {
            switchPreferenceCompat10.setChecked(XWebEmbedSetting.getForbidDownloadCode());
            if (XWalkEnvironment.getBuildConfigNeedTurnOffDynamicCode()) {
                switchPreferenceCompat10.setVisible(false);
            }
        }
        SwitchPreferenceCompat switchPreferenceCompat11 = (SwitchPreferenceCompat) findPreference("enable_test_base_config");
        if (switchPreferenceCompat11 != null) {
            switchPreferenceCompat11.setChecked(WebDebugCfg.getInst().getEnableTestBaseConfig());
        }
        SwitchPreferenceCompat switchPreferenceCompat12 = (SwitchPreferenceCompat) findPreference("enable_auto_check_update");
        if (switchPreferenceCompat12 != null) {
            switchPreferenceCompat12.setChecked(com.tencent.luggage.wxa.yq.i.b());
        }
        d();
        e();
        a();
        g();
        f();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        Preference findPreference;
        setPreferencesFromResource(R.xml.f174392t, str);
        this.f138973b.a(getPreferenceScreen(), this);
        if (!p0.b() && (findPreference = findPreference("pref_category_wechat")) != null) {
            findPreference.setVisible(false);
        }
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        x0.d("FragmentCore", "onPreferenceChange, key:" + preference.getKey() + ", newValue:" + obj);
        if (!(preference instanceof XWebDebugEditTextPreference) && !(preference instanceof XWebDebugListPreference)) {
            return false;
        }
        k kVar = (k) preference;
        a a16 = kVar.a(this.f138972a, obj);
        x0.d("FragmentCore", "onPreferenceChange, debugKey:" + kVar.a() + ", commandResult:" + a16);
        com.tencent.xweb.debug.b bVar = this.f138972a;
        if (bVar != null) {
            bVar.a(getContext(), a16);
        }
        h();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        x0.d("FragmentCore", "onPreferenceTreeClick, key:" + preference.getKey());
        if (!(preference instanceof XWebDebugPreference) && !(preference instanceof XWebDebugSwitchPreference)) {
            return super.onPreferenceTreeClick(preference);
        }
        k kVar = (k) preference;
        a a16 = kVar.a(this.f138972a);
        x0.d("FragmentCore", "onPreferenceTreeClick, debugKey:" + kVar.a() + ", commandResult:" + a16);
        com.tencent.xweb.debug.b bVar = this.f138972a;
        if (bVar != null) {
            bVar.a(getContext(), a16);
            return true;
        }
        return true;
    }

    public final void a() {
        ListPreference listPreference = (ListPreference) findPreference("set_dark_mode");
        if (listPreference != null) {
            if (this.f138972a.d() == null) {
                listPreference.setVisible(false);
                return;
            }
            listPreference.setValue(a(this.f138972a.d().getSettings().getForceDarkMode(), this.f138972a.d().getSettings().getForceDarkBehavior()) + "");
            listPreference.setSummary(listPreference.getEntry());
        }
    }
}
