package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends e {
    static IPatchRedirector $redirector_;

    public f(String str, String str2, e.a aVar, int i3, Bundle bundle) {
        super(str, str2, aVar, i3, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, aVar, Integer.valueOf(i3), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.utils.e, android.os.AsyncTask
    /* renamed from: c */
    public JSONObject doInBackground(HashMap<String, Object>... hashMapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMapArr);
        }
        if (isCancelled()) {
            return null;
        }
        HashMap<String, Object> hashMap = hashMapArr[0];
        if (!(hashMap.get("CONTEXT") instanceof Context) || !(hashMap.get("BUNDLE") instanceof Bundle)) {
            return null;
        }
        Context context = (Context) hashMap.get("CONTEXT");
        Bundle bundle = (Bundle) hashMap.get("BUNDLE");
        try {
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("Cookie");
            String string2 = bundle.getString("Referer");
            String string3 = bundle.getString("Origin");
            if (string != null) {
                bundle2.putString("Cookie", string);
                bundle.remove("Cookie");
            }
            if (string2 != null) {
                bundle2.putString("Referer", string2);
                bundle.remove("Referer");
            }
            if (string3 != null) {
                bundle2.putString("Origin", string3);
                bundle.remove("Origin");
            }
            return new JSONObject(HttpUtil.openUrl(context, this.f341008a, this.f341009b, bundle, bundle2));
        } catch (IOException e16) {
            QLog.w("HttpWebCgiAsyncTask", 1, e16.getMessage(), e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.w("HttpWebCgiAsyncTask", 1, e17.getMessage(), e17);
            return null;
        } catch (JSONException e18) {
            QLog.w("HttpWebCgiAsyncTask", 1, e18.getMessage(), e18);
            return null;
        }
    }
}
