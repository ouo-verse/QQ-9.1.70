package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a implements Callable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected String f199869d;

    /* renamed from: e, reason: collision with root package name */
    protected String f199870e;

    /* renamed from: f, reason: collision with root package name */
    protected String f199871f;

    /* renamed from: h, reason: collision with root package name */
    protected ASPluginBean f199872h;

    /* renamed from: i, reason: collision with root package name */
    protected int f199873i;

    /* renamed from: m, reason: collision with root package name */
    protected c f199874m;

    public a(ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
            return;
        }
        this.f199872h = aSPluginBean;
        this.f199871f = aSPluginBean.getType();
        this.f199869d = aSPluginBean.getPluginZipPath();
        this.f199870e = aSPluginBean.getPluginMangerApkPath();
        this.f199873i = aSPluginBean.getVersionCode();
        this.f199874m = new c(aSPluginBean);
    }

    private String b() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        String[] split = b().split("\\.");
        if (split != null && split.length >= 3) {
            StringBuilder sb5 = new StringBuilder(split[0]);
            if (split[1].length() == 1) {
                sb5.append("0");
                sb5.append(split[1]);
            } else {
                sb5.append(split[1]);
            }
            if (split[2].length() == 1) {
                sb5.append("0");
                sb5.append(split[2]);
            } else {
                sb5.append(split[2]);
            }
            return Integer.parseInt(sb5.toString());
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASPluginBean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ASPluginBean aSPluginBean = new ASPluginBean();
            if (jSONObject.has("version")) {
                aSPluginBean.setVersionCode(jSONObject.getInt("version"));
            }
            if (jSONObject.has("supportMinHostVersion")) {
                aSPluginBean.setSupportMinHostVersion(jSONObject.getInt("supportMinHostVersion"));
            }
            if (jSONObject.has("UUID")) {
                String string = jSONObject.getString("UUID");
                aSPluginBean.setUUid(string);
                QLog.d(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "parse json hasUUId\uff1a" + string);
            }
            return aSPluginBean;
        } catch (JSONException e16) {
            QLog.d(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "parse json failed" + e16.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!((IFileUtilsApi) QRoute.api(IFileUtilsApi.class)).fileExists(str)) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb5 = new StringBuilder("");
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                            sb5.append("\n");
                        } catch (Exception e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            QLog.d(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, "readConfigString failed" + e.getMessage());
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb5.toString();
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, str3)).booleanValue();
        }
        try {
            return this.f199874m.k(str, new File(str2));
        } catch (IOException e16) {
            QLog.d(ASDynamicEngine.q(this.f199872h.getBusinessKey()), 1, str3 + "unZip file failed msg:" + e16.getMessage());
            return false;
        }
    }
}
