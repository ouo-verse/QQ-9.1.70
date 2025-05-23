package com.tencent.mobileqq.microapp.widget.input;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.microapp.appbrand.a.a.f;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class c implements TextWatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246162a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f246163b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ PageWebview f246164c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ a f246165d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, f fVar, PageWebview pageWebview) {
        this.f246165d = aVar;
        this.f246162a = str;
        this.f246163b = fVar;
        this.f246164c = pageWebview;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, str, fVar, pageWebview);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inputId", this.f246165d.f246159h);
            jSONObject.put("cursor", editable.toString().length());
            jSONObject.put("value", editable.toString());
            jSONObject.put("data", new JSONObject(this.f246162a).optString("data"));
            this.f246163b.f245924a.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onKeyboardValueChange\", " + jSONObject + "," + this.f246164c.pageWebviewId + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}
