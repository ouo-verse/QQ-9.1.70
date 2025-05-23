package com.tencent.mobileqq.troop.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends com.tencent.open.base.http.a<HashMap<String, Object>, Void, JSONObject> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    protected a f302158c;

    /* renamed from: d, reason: collision with root package name */
    protected int f302159d;

    /* renamed from: e, reason: collision with root package name */
    protected Bundle f302160e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f302161f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void rg(JSONObject jSONObject, int i3, Bundle bundle);
    }

    public e(String str, String str2, a aVar, int i3, Bundle bundle) {
        super(str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, aVar, Integer.valueOf(i3), bundle);
            return;
        }
        this.f302161f = false;
        this.f302158c = aVar;
        this.f302159d = i3;
        this.f302160e = bundle;
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    public void b(HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
            return;
        }
        Executor a16 = a();
        if (a16 != null) {
            executeOnExecutor(a16, hashMap);
        } else {
            execute(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public JSONObject doInBackground(HashMap<String, Object>... hashMapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hashMapArr);
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
            String string3 = bundle.getString("Host");
            if (string != null) {
                bundle2.putString("Cookie", string);
                bundle.remove("Cookie");
            }
            if (string2 != null) {
                bundle2.putString("Referer", string2);
                bundle.remove("Referer");
            }
            if (string3 != null) {
                bundle2.putString("Host", string3);
                bundle.remove(string3);
            }
            JSONObject jSONObject = new JSONObject(HttpUtil.openUrl(context, this.f341008a, this.f341009b, bundle, bundle2));
            if (!this.f302161f && jSONObject.getInt("retcode") == 0) {
                return jSONObject.getJSONObject("result");
            }
            return jSONObject;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(JSONObject jSONObject) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
        } else if (!isCancelled() && (aVar = this.f302158c) != null) {
            aVar.rg(jSONObject, this.f302159d, this.f302160e);
        }
    }

    public e(String str, String str2, a aVar, int i3, Bundle bundle, boolean z16) {
        super(str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, aVar, Integer.valueOf(i3), bundle, Boolean.valueOf(z16));
            return;
        }
        this.f302158c = aVar;
        this.f302159d = i3;
        this.f302160e = bundle;
        this.f302161f = z16;
    }
}
