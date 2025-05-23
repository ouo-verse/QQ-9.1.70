package com.tencent.mobileqq.profile.diy;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<String> f260153a;

    /* renamed from: b, reason: collision with root package name */
    public static int f260154b;

    /* renamed from: c, reason: collision with root package name */
    public static String f260155c;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f260156d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f260154b = 50;
        f260155c = HardCodeUtil.qqStr(R.string.vgo);
        f260156d = new AtomicBoolean(false);
    }

    public static synchronized void a(AppRuntime appRuntime) {
        synchronized (b.class) {
            if (appRuntime == null) {
                QLog.e("VipProfileDiyCardConfig", 1, "parseJson, app null");
                return;
            }
            if (!f260156d.compareAndSet(false, true)) {
                return;
            }
            JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(appRuntime, VasUpdateConstants.SCID_DIY_CARD_CONFIG, true, null);
            if (jSONFromLocal != null) {
                JSONArray optJSONArray = jSONFromLocal.optJSONArray("fontList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    SparseArray<String> sparseArray = f260153a;
                    if (sparseArray == null) {
                        f260153a = new SparseArray<>();
                    } else {
                        sparseArray.clear();
                    }
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        int optInt = optJSONObject.optInt("id");
                        String optString = optJSONObject.optString("imgUrl");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!optString.startsWith("http:") && !optString.startsWith("https:")) {
                                optString = "http:" + optString;
                            }
                            f260153a.put(optInt, optString);
                        }
                    }
                }
                f260154b = jSONFromLocal.optInt("maxTextLength", f260154b);
                f260155c = jSONFromLocal.optString("inputTip", f260155c);
            }
            f260156d.set(false);
        }
    }
}
