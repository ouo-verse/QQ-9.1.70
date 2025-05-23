package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final String f302189h;

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f302190i;

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f302191m;

    /* renamed from: d, reason: collision with root package name */
    protected final QQAppInterface f302192d;

    /* renamed from: e, reason: collision with root package name */
    protected SparseArray<String[]> f302193e;

    /* renamed from: f, reason: collision with root package name */
    protected LinkedHashMap<String, Object> f302194f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f302189h = ".troop.school_troop." + m.class.getSimpleName();
        f302190i = new String[]{"", HardCodeUtil.qqStr(R.string.f172659t52), HardCodeUtil.qqStr(R.string.f172660t54)};
        f302191m = new String[]{"", HardCodeUtil.qqStr(R.string.f172661t55), HardCodeUtil.qqStr(R.string.f172658t51)};
    }

    public m(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f302193e = new SparseArray<>();
        this.f302194f = new LinkedHashMap<>();
        this.f302192d = qQAppInterface;
        a();
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        String string = this.f302192d.getApp().getSharedPreferences(AppConstants.Preferences.HOMEWORK_TROOP_CONFIG + this.f302192d.getCurrentUin(), 0).getString("troop_school_keyword_config", "");
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.w(f302189h, 2, "The configString is empty, new user or no config");
            }
        } else {
            b(string);
            QLog.i(f302189h, 1, "loadConfig cost time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(f302189h, 2, "update config, config=" + str);
        }
        try {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    int i16 = optJSONObject.getInt("action");
                    if (i16 < f302190i.length) {
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray2 = optJSONObject.getJSONArray("words");
                        int length2 = jSONArray2.length();
                        for (int i17 = 0; i17 < length2; i17++) {
                            arrayList.add(jSONArray2.getString(i17));
                        }
                        this.f302193e.put(i16, (String[]) arrayList.toArray(new String[arrayList.size()]));
                    }
                }
                this.f302194f.clear();
            } catch (JSONException unused) {
                String str2 = f302189h;
                QLog.w(str2, 2, "parse config error, config = " + str);
                QLog.i(str2, 1, "updateConfig cost time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } finally {
            QLog.i(f302189h, 1, "updateConfig cost time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
