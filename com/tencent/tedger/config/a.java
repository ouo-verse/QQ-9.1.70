package com.tencent.tedger.config;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import com.tencent.tedger.config.parse.QCircleConfigParse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ve4.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends com.tencent.tedgecontext.b implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String f375134f;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f375135a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f375136b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f375137c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f375138d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.tedger.config.parse.a f375139e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tedger.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9896a implements GetExperimentListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f375140a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f375141b;

        C9896a(String[] strArr, CountDownLatch countDownLatch) {
            this.f375140a = strArr;
            this.f375141b = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, strArr, countDownLatch);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            f375134f = a.class.getSimpleName();
        }
    }

    public a(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375136b = new JSONObject();
        this.f375138d = true;
        this.f375137c = new HashMap<>();
        if (!TextUtils.isEmpty(aVar.e())) {
            try {
                this.f375136b = new JSONObject(aVar.e());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        this.f375139e = L();
    }

    private String H(JSONArray jSONArray) throws JSONException {
        String b16 = getContext().b();
        String n3 = getContext().n();
        String o16 = getContext().o();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            JSONObject jSONObject2 = jSONObject.getJSONObject("app_version");
            JSONObject jSONObject3 = jSONObject.getJSONObject("so_version");
            JSONObject jSONObject4 = jSONObject.getJSONObject("sdk_version");
            if (!N(jSONObject2.getJSONArray("exclude"), b16) && O(b16, jSONObject2.optString(Element.ELEMENT_NAME_MIN), jSONObject2.optString("max")) && O(n3, jSONObject4.optString(Element.ELEMENT_NAME_MIN), jSONObject4.optString("max")) && O(o16, jSONObject3.optString(Element.ELEMENT_NAME_MIN), jSONObject3.optString("max"))) {
                String string = jSONObject.getString("exp_layer_list");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
        }
        return null;
    }

    private boolean J() throws JSONException, InterruptedException {
        if (getContext().f() == null) {
            this.mLog.f(f375134f, 1, "can't get context.");
            return false;
        }
        String[] strArr = new String[1];
        ABTestConfig aBTestConfig = new ABTestConfig();
        aBTestConfig.setAppId(getContext().a());
        aBTestConfig.setGuid(getContext().p());
        ABTestApi.init(getContext().f(), aBTestConfig);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ABTestApi.getAllExperiments(new C9896a(strArr, countDownLatch), 10000);
        countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
        if (TextUtils.isEmpty(strArr[0])) {
            this.mLog.f(f375134f, 1, "can't get config json.");
            return false;
        }
        this.f375136b = new JSONObject(strArr[0]);
        return true;
    }

    @Nullable
    private int K(String str) throws JSONException {
        Map<String, String> e16 = getContext().d().e(str);
        if (e16 == null) {
            this.mLog.f(f375134f, 1, "get getLayerConfig  is null");
            return -5;
        }
        String[] split = str.split("\\|");
        if (split.length > 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= split.length) {
                    break;
                }
                if (e16.containsKey(split[i3]) && !TextUtils.isEmpty(e16.get(split[i3]))) {
                    if (i3 == 0) {
                        this.f375136b = new JSONObject(e16.get(split[i3]));
                        break;
                    }
                    JSONObject jSONObject = new JSONObject(e16.get(split[i3]));
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        this.f375136b.put(str2, jSONObject.get(str2));
                    }
                } else {
                    this.mLog.f(f375134f, 1, "get getLayerConfig  " + split[i3] + "  is null");
                }
                i3++;
            }
        }
        return 0;
    }

    private com.tencent.tedger.config.parse.a L() {
        if (this.f375139e == null && getContext().c().equals("qcircle")) {
            this.f375139e = new QCircleConfigParse(getContext());
        }
        return this.f375139e;
    }

    private Object M(String str) {
        if (this.f375136b != null && str != null) {
            String[] split = str.split("\\.");
            if (split.length == 0) {
                this.mLog.e(f375134f, 1, "key path can't be empty!");
                return null;
            }
            Object obj = this.f375136b;
            for (int i3 = 0; i3 < split.length; i3++) {
                try {
                    if (obj instanceof JSONObject) {
                        if (!((JSONObject) obj).has(split[i3])) {
                            return null;
                        }
                        obj = ((JSONObject) obj).get(split[i3]);
                    } else {
                        this.mLog.e(f375134f, 1, "can't correct read key path (" + str + ") for conflict on key (" + split[i3] + ")");
                        return null;
                    }
                } catch (JSONException e16) {
                    this.mLog.e(f375134f, 1, "can't correct read key path (" + str + ") for exception: " + e16);
                }
            }
            this.mLog.d(f375134f, "getJSonObjectWithPath: " + str + " = " + obj);
            return obj;
        }
        return null;
    }

    private boolean N(JSONArray jSONArray, String str) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (str.equals(jSONArray.getString(i3))) {
                return true;
            }
        }
        return false;
    }

    private boolean O(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && str.compareTo(str2) >= 0 && str.compareTo(str3) <= 0) {
            return true;
        }
        return false;
    }

    private int P() {
        try {
            JSONObject jSONObject = this.f375136b;
            if (jSONObject == null) {
                return -1;
            }
            boolean z16 = jSONObject.getBoolean("enable_tedge");
            this.f375138d = z16;
            if (!z16) {
                return -3;
            }
            String H = H(this.f375136b.getJSONArray("version_config"));
            if (H == null) {
                return -4;
            }
            int K = K(H);
            if (K != 0) {
                return K;
            }
            int B = this.f375139e.B(this.f375136b);
            if (B != 0) {
                return B;
            }
            this.f375139e.parseConfig();
            return 0;
        } catch (Exception e16) {
            this.mLog.f(f375134f, 1, "parse config json have error: " + e16);
            return -2;
        }
    }

    private void Q() throws JSONException {
        if (this.f375136b != null) {
            return;
        }
        if (getContext().c().equals("qcircle")) {
            this.mLog.d(f375134f, "no config ");
            return;
        }
        try {
            J();
        } catch (InterruptedException e16) {
            this.mLog.f(f375134f, 1, "get config from ABTest have error: " + e16);
        }
    }

    @Override // ve4.g
    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (f() == null) {
            this.mLog.f(f375134f, 12, "require array for so on key path sdk.so");
            return true;
        }
        return true;
    }

    public boolean I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        Object M = M(str);
        if (M == null) {
            return false;
        }
        if (!M.toString().equals("1") && !Boolean.parseBoolean(M.toString())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f375139e.a();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.f375139e.e();
    }

    @Override // ve4.g
    public List<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f375136b == null) {
            return null;
        }
        List<String> list = this.f375135a;
        if (list != null) {
            return list;
        }
        JSONArray jSONArray = (JSONArray) M("sdk.so");
        if (jSONArray == null) {
            return null;
        }
        this.f375135a = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                this.f375135a.add(jSONArray.getString(i3));
            } catch (JSONException e16) {
                this.mLog.f(f375134f, 1, "can't read the required " + i3 + "th so config. for exception: " + e16);
                return null;
            }
        }
        return this.f375135a;
    }

    @Override // com.tencent.tedger.outapi.api.d
    public String getConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Object M = M(str);
        if (M == null) {
            return null;
        }
        return M.toString();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public long h(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3))).longValue();
        }
        Object M = M(str);
        if (M == null) {
            return j3;
        }
        try {
            return Long.parseLong(M.toString());
        } catch (Exception e16) {
            this.mLog.e(f375134f, 1, "can't correct read key path (" + str + ") for exception: " + e16);
            return 0L;
        }
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean i(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        Object M = M(str);
        if (M == null) {
            return z16;
        }
        if (M.toString().equals("1") || Boolean.parseBoolean(M.toString())) {
            return true;
        }
        return false;
    }

    @Override // ve4.g
    public int initConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        try {
            Q();
            return P();
        } catch (Exception e16) {
            this.mLog.f(f375134f, 1, "parse config json have error: " + e16);
            return -2;
        }
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return i("sdk.open_train", true);
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return I("sdk.open_infer");
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f375138d;
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return I("sdk.open_cloud_rank");
    }

    @Override // com.tencent.tedger.outapi.api.d
    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return I("sdk.open_client_rank");
    }

    @Override // com.tencent.tedger.outapi.api.d
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f375136b.toString();
    }

    @Override // com.tencent.tedger.outapi.api.d
    public String getConfig(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        Object M = M(str);
        return M == null ? str2 : M.toString();
    }
}
