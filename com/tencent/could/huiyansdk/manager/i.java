package com.tencent.could.huiyansdk.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.could.component.common.ai.utils.GZipUtils;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f100188a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, Looper looper) {
        super(looper);
        this.f100188a = kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar, (Object) looper);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        if (message == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    k.a.f100197a.a(2, "LoggerManager", "handle with default what!");
                    return;
                }
                k kVar = this.f100188a;
                Map<String, Integer> map = kVar.f100189a;
                String str = "";
                if (map != null && map.size() != 0) {
                    ArrayList arrayList = new ArrayList(kVar.f100189a.entrySet());
                    Collections.sort(arrayList, new j(kVar));
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("platform", "Android");
                        JSONObject jSONObject2 = new JSONObject();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        jSONObject.put("tips", jSONObject2);
                        str = jSONObject.toString();
                    } catch (JSONException e16) {
                        k.a.f100197a.a(2, "LoggerManager", "create json error: " + e16.getLocalizedMessage());
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    Log.e("LoggerManager", "allTips real:" + str);
                    String encodeToString = Base64.encodeToString(GZipUtils.compress(str), 2);
                    Log.e("LoggerManager", "allTips zip:" + encodeToString);
                    kVar.a("tips_counts: " + encodeToString);
                    return;
                }
                return;
            }
            this.f100188a.a((String) message.obj);
            return;
        }
        k kVar2 = this.f100188a;
        String str2 = (String) message.obj;
        kVar2.getClass();
        if (TextUtils.isEmpty(str2)) {
            k.a.f100197a.a(2, "LoggerManager", "add tips event with empty!");
            return;
        }
        Map<String, Integer> map2 = kVar2.f100189a;
        if (map2 == null) {
            k.a.f100197a.a(2, "LoggerManager", "tips save map is null!");
        } else if (map2.containsKey(str2)) {
            kVar2.f100189a.put(str2, Integer.valueOf(kVar2.f100189a.get(str2).intValue() + 1));
        } else {
            kVar2.f100189a.put(str2, 1);
        }
    }
}
