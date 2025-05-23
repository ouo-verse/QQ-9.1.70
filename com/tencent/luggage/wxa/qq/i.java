package com.tencent.luggage.wxa.qq;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.mobileqq.R;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.debug.XWebDebugEditTextPreference;
import com.tencent.xweb.debug.XWebDebugListPreference;
import com.tencent.xweb.debug.XWebDebugPreference;
import com.tencent.xweb.debug.XWebDebugSwitchPreference;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.xweb.debug.b f138980a;

    /* renamed from: b, reason: collision with root package name */
    public final f f138981b = new f();

    /* renamed from: c, reason: collision with root package name */
    public final String f138982c = "\u5f53\u524d\u4f7f\u7528\u6b63\u5f0f\u7248";

    /* renamed from: d, reason: collision with root package name */
    public final String f138983d = "\u5f53\u524d\u4f7f\u7528\u81ea\u5b9a\u4e49\u6d4b\u8bd5\u7248";

    /* renamed from: e, reason: collision with root package name */
    public final String f138984e = "\u5f53\u524d\u4f7f\u7528\u9ed8\u8ba4\u6d4b\u8bd5\u7248";

    /* renamed from: f, reason: collision with root package name */
    public String f138985f = "all";

    /* renamed from: g, reason: collision with root package name */
    public String f138986g = XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            p0.a(i.this.getContext(), "xweb_debug_info", m.c());
        }
    }

    public i(com.tencent.xweb.debug.b bVar) {
        this.f138980a = bVar;
    }

    public final void a() {
        Preference findPreference = findPreference("set_plugin_config_url");
        if (findPreference != null) {
            String i3 = z0.i();
            if (!TextUtils.isEmpty(i3)) {
                findPreference.setSummary(i3);
            } else {
                findPreference.setSummary("");
            }
        }
    }

    public final void d() {
        Preference findPreference = findPreference("switch_plugin_config_url");
        if (findPreference != null) {
            String i3 = z0.i();
            if (!TextUtils.isEmpty(i3)) {
                if (i3.equalsIgnoreCase("https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
                    findPreference.setSummary("\u5f53\u524d\u4f7f\u7528\u9ed8\u8ba4\u6d4b\u8bd5\u7248");
                    return;
                } else {
                    findPreference.setSummary("\u5f53\u524d\u4f7f\u7528\u81ea\u5b9a\u4e49\u6d4b\u8bd5\u7248");
                    return;
                }
            }
            findPreference.setSummary("\u5f53\u524d\u4f7f\u7528\u6b63\u5f0f\u7248");
        }
    }

    public final void e() {
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference("disable_file_reader_cache");
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setChecked(WebDebugCfg.getInst().getDisableFileReaderCache());
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference("disable_file_reader_crash_detect");
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.setChecked(WebDebugCfg.getInst().getDisableFileReaderCrashDetect());
        }
        d();
        a();
    }

    public final void f() {
        new AlertDialog.Builder(getContext()).setTitle("File Reader Type").setMessage(m.c()).setPositiveButton("\u590d\u5236\u5230\u526a\u8d34\u677f", new a()).setNegativeButton("\u53d6\u6d88", (DialogInterface.OnClickListener) null).show();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.f174393u, str);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        this.f138981b.a(preferenceScreen, this);
        x0.f("FragmentPlugin", "onCreatePreferences, SharedPreferences:" + preferenceScreen.getSharedPreferences());
        x0.f("FragmentPlugin", "onCreatePreferences, PreferenceDataStore:" + preferenceScreen.getPreferenceDataStore());
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        String key = preference.getKey();
        x0.d("FragmentPlugin", "onPreferenceChange, key:" + key + ", newValue:" + obj);
        if (!(preference instanceof XWebDebugEditTextPreference) && !(preference instanceof XWebDebugListPreference)) {
            if ("office_reader_format".equals(key)) {
                String valueOf = String.valueOf(obj);
                this.f138985f = valueOf;
                preference.setSummary(valueOf);
                return false;
            }
            if ("plugin_name".equals(key)) {
                String valueOf2 = String.valueOf(obj);
                this.f138986g = valueOf2;
                preference.setSummary(valueOf2);
                return false;
            }
            return false;
        }
        k kVar = (k) preference;
        com.tencent.luggage.wxa.qq.a a16 = kVar.a(this.f138980a, obj);
        x0.d("FragmentPlugin", "onPreferenceChange, debugKey:" + kVar.a() + ", commandResult:" + a16);
        com.tencent.xweb.debug.b bVar = this.f138980a;
        if (bVar != null) {
            bVar.a(getContext(), a16);
        }
        e();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        String key = preference.getKey();
        x0.d("FragmentPlugin", "onPreferenceTreeClick, key:" + key);
        boolean z16 = true;
        if (!(preference instanceof XWebDebugPreference) && !(preference instanceof XWebDebugSwitchPreference)) {
            if ("switch_plugin_config_url".equals(key)) {
                return this.f138981b.a(getContext(), this.f138980a, a(preference));
            }
            if ("use_office_reader_force_yes".equals(key)) {
                if (!TextUtils.isEmpty(this.f138985f)) {
                    return this.f138981b.a(getContext(), this.f138980a, m.a(this.f138985f, FileReaderHelper.UseOfficeReader.yes));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("use_office_reader_force_no".equals(key)) {
                if (!TextUtils.isEmpty(this.f138985f)) {
                    return this.f138981b.a(getContext(), this.f138980a, m.a(this.f138985f, FileReaderHelper.UseOfficeReader.no));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("use_office_reader_force_none".equals(key)) {
                if (!TextUtils.isEmpty(this.f138985f)) {
                    return this.f138981b.a(getContext(), this.f138980a, m.a(this.f138985f, FileReaderHelper.UseOfficeReader.none));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("update_plugin".equals(key)) {
                if (!TextUtils.isEmpty(this.f138986g)) {
                    f fVar = this.f138981b;
                    Context context = getContext();
                    com.tencent.xweb.debug.b bVar = this.f138980a;
                    Context context2 = getContext();
                    String str = this.f138986g;
                    if (this.f138980a == null) {
                        z16 = false;
                    }
                    return fVar.a(context, bVar, m.a(context2, str, "1", z16));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("clear_plugin".equals(key)) {
                if (!TextUtils.isEmpty(this.f138986g)) {
                    return this.f138981b.a(getContext(), this.f138980a, m.a(this.f138986g));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("install_plugin_32".equals(key)) {
                if (!TextUtils.isEmpty(this.f138986g)) {
                    return this.f138981b.a(getContext(), this.f138980a, m.b(getContext(), this.f138986g, false, false, null));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("install_plugin_64".equals(key)) {
                if (!TextUtils.isEmpty(this.f138986g)) {
                    return this.f138981b.a(getContext(), this.f138980a, m.b(getContext(), this.f138986g, false, true, null));
                }
                return this.f138981b.a(getContext(), this.f138980a, false);
            }
            if ("show_file_reader_info".equals(key)) {
                f();
            }
            return super.onPreferenceTreeClick(preference);
        }
        k kVar = (k) preference;
        com.tencent.luggage.wxa.qq.a a16 = kVar.a(this.f138980a);
        x0.d("FragmentPlugin", "onPreferenceTreeClick, debugKey:" + kVar.a() + ", commandResult:" + a16);
        com.tencent.xweb.debug.b bVar2 = this.f138980a;
        if (bVar2 != null) {
            bVar2.a(getContext(), a16);
        }
        return true;
    }

    public final boolean a(Preference preference) {
        if (!TextUtils.isEmpty(z0.i())) {
            if (!z0.e("")) {
                return false;
            }
            x0.d("FragmentPlugin", "switchPluginConfigUrl, clear test url success");
            preference.setSummary("\u5f53\u524d\u4f7f\u7528\u6b63\u5f0f\u7248");
            return true;
        }
        if (!z0.e("https://dldir1v6.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
            return false;
        }
        x0.d("FragmentPlugin", "switchPluginConfigUrl, set default test url success");
        preference.setSummary("\u5f53\u524d\u4f7f\u7528\u9ed8\u8ba4\u6d4b\u8bd5\u7248");
        return true;
    }
}
