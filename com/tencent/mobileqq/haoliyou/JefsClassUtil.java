package com.tencent.mobileqq.haoliyou;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JefsClassUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TeleScreen|JefsClass";
    private static boolean enable;
    private static PolicyConfig policyConfig;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Policy {
        static IPatchRedirector $redirector_;
        public String action;
        public String packageName;
        public String schema;

        public Policy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        boolean matches(String str, String str2, String str3) {
            if (!TextUtils.isEmpty(this.packageName) && !this.packageName.equalsIgnoreCase(str)) {
                return false;
            }
            if (!TextUtils.isEmpty(this.schema) && (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith(this.schema))) {
                return false;
            }
            if (!TextUtils.isEmpty(this.action) && !this.action.equalsIgnoreCase(str3)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class PolicyConfig {
        static IPatchRedirector $redirector_;
        public Set<String> packages;
        public List<Policy> policy;

        public PolicyConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.packages = new TreeSet();
                this.policy = new ArrayList();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            enable = false;
        }
    }

    public JefsClassUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean hasEnabled() {
        return enable;
    }

    public static synchronized void initPolicy(boolean z16, JSONObject jSONObject) {
        synchronized (JefsClassUtil.class) {
            enable = z16;
            policyConfig = parse(jSONObject);
        }
    }

    public static PolicyConfig parse(JSONObject jSONObject) {
        PolicyConfig policyConfig2 = new PolicyConfig();
        if (jSONObject == null) {
            return policyConfig2;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(Constants.Raft.PACKAGES);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String string = optJSONArray.getString(i3);
                    if (string != null) {
                        policyConfig2.packages.add(string);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("policy");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i16);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("package");
                        String optString2 = jSONObject2.optString(QZoneDTLoginReporter.SCHEMA);
                        String optString3 = jSONObject2.optString("action");
                        Policy policy = new Policy();
                        policy.packageName = optString;
                        policy.schema = optString2.toLowerCase();
                        policy.action = optString3.toLowerCase();
                        policyConfig2.policy.add(policy);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.d("TeleScreen|JefsClass", 1, th5, new Object[0]);
        }
        return policyConfig2;
    }
}
