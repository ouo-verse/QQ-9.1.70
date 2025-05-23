package com.tencent.mobileqq.qqgamepub.model;

import android.text.TextUtils;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f264609a;

    /* renamed from: b, reason: collision with root package name */
    public String f264610b;

    /* renamed from: c, reason: collision with root package name */
    public String f264611c;

    /* renamed from: d, reason: collision with root package name */
    public String f264612d;

    /* renamed from: e, reason: collision with root package name */
    public String f264613e;

    /* renamed from: f, reason: collision with root package name */
    public String f264614f;

    /* renamed from: g, reason: collision with root package name */
    public String f264615g;

    /* renamed from: h, reason: collision with root package name */
    public String f264616h;

    /* renamed from: i, reason: collision with root package name */
    public String f264617i;

    /* renamed from: j, reason: collision with root package name */
    public String f264618j;

    /* renamed from: k, reason: collision with root package name */
    public String f264619k;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject(str);
            bVar.f264609a = jSONObject.optString("id");
            bVar.f264610b = jSONObject.optString("title");
            bVar.f264611c = jSONObject.optString("content");
            bVar.f264612d = jSONObject.optString("icon");
            bVar.f264613e = jSONObject.optString("jump_url");
            bVar.f264614f = jSONObject.optString(IPublicAccountBrowser.KEY_PUB_UIN);
            String optString = jSONObject.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                bVar.f264615g = jSONObject2.optString("ad_id", "");
                bVar.f264616h = jSONObject2.optString("game_appid", "");
                bVar.f264617i = jSONObject2.optString("act_id", "");
                bVar.f264618j = jSONObject2.optString(Utils.KEY_BUSINESS_ID, "");
                bVar.f264619k = jSONObject2.optString("schedule_id", "");
            }
            return bVar;
        } catch (JSONException e16) {
            QLog.e("GamePushMsgData", 1, "fromJson e:", e16);
            return null;
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f264609a) && !TextUtils.isEmpty(this.f264610b) && !TextUtils.isEmpty(this.f264611c) && !TextUtils.isEmpty(this.f264613e)) {
            return true;
        }
        return false;
    }
}
