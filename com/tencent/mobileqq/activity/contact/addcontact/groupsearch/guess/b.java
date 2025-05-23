package com.tencent.mobileqq.activity.contact.addcontact.groupsearch.guess;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchGroupDiscovery$GuessWantItem;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f181186a;

    /* renamed from: b, reason: collision with root package name */
    public String f181187b;

    /* renamed from: c, reason: collision with root package name */
    public String f181188c;

    /* renamed from: d, reason: collision with root package name */
    public String f181189d;

    /* renamed from: e, reason: collision with root package name */
    public String f181190e;

    /* renamed from: f, reason: collision with root package name */
    public String f181191f;

    public b(UnifySearchGroupDiscovery$GuessWantItem unifySearchGroupDiscovery$GuessWantItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) unifySearchGroupDiscovery$GuessWantItem);
            return;
        }
        if (unifySearchGroupDiscovery$GuessWantItem == null) {
            return;
        }
        this.f181186a = unifySearchGroupDiscovery$GuessWantItem.word.get().toStringUtf8();
        this.f181190e = unifySearchGroupDiscovery$GuessWantItem.extension.get().toStringUtf8();
        this.f181191f = unifySearchGroupDiscovery$GuessWantItem.reportData.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.f181190e)) {
            try {
                JSONObject jSONObject = new JSONObject(this.f181190e);
                this.f181187b = jSONObject.optString("text");
                this.f181188c = jSONObject.optString("color");
                this.f181189d = jSONObject.optString("background");
            } catch (JSONException e16) {
                QLog.e("GuessItemInfo", 2, "[parseExtension] JSONException e = " + e16);
            }
        }
    }
}
