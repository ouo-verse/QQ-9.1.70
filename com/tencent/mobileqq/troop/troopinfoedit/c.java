package com.tencent.mobileqq.troop.troopinfoedit;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJD\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001e\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopinfoedit/c;", "", "", "event", "Lorg/json/JSONObject;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "domains", ISchemeApi.KEY_REFERER, "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f300471a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f300471a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable String event, @Nullable JSONObject data, @Nullable ArrayList<String> domains, @Nullable String referer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, event, data, domains, referer);
            return;
        }
        Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intent.putExtra("event", event);
        if (data != null) {
            intent.putExtra("data", data.toString());
        }
        intent.putStringArrayListExtra("domains", domains);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", referer);
        } catch (JSONException unused) {
        }
        intent.putExtra("source", jSONObject.toString());
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }
}
