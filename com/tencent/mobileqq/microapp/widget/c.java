package com.tencent.mobileqq.microapp.widget;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class c implements TextWatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f246109a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f246110b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246111c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WebviewContainer f246112d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ JSONObject f246113e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ MiniAppTextArea f246114f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MiniAppTextArea miniAppTextArea, JSONObject jSONObject, JSONObject jSONObject2, int i3, WebviewContainer webviewContainer, JSONObject jSONObject3) {
        this.f246114f = miniAppTextArea;
        this.f246109a = jSONObject;
        this.f246110b = jSONObject2;
        this.f246111c = i3;
        this.f246112d = webviewContainer;
        this.f246113e = jSONObject3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, miniAppTextArea, jSONObject, jSONObject2, Integer.valueOf(i3), webviewContainer, jSONObject3);
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
            jSONObject.put("inputId", this.f246111c);
            jSONObject.put("cursor", editable.toString().length());
            jSONObject.put("value", editable.toString());
            jSONObject.put("data", this.f246113e.optString("data"));
            this.f246112d.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onKeyboardValueChange\", " + jSONObject + "," + this.f246112d.getPageWebview().pageWebviewId + ")");
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
            return;
        }
        if (charSequence.length() == 0) {
            this.f246114f.setTextSize(2, this.f246109a.optInt("fontSize"));
            this.f246114f.setTextColor(Color.parseColor(this.f246109a.optString("color")));
        } else {
            this.f246114f.setTextSize(2, this.f246110b.optInt("fontSize"));
            this.f246114f.setTextColor(Color.parseColor(this.f246110b.optString("color")));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("height", this.f246114f.getMeasuredHeight());
            jSONObject.put("lineCount", this.f246114f.getLineCount());
            jSONObject.put("inputId", this.f246111c);
            this.f246112d.getPageWebview().evaluteJs("WeixinJSBridge.subscribeHandler(\"onTextAreaHeightChange\", " + jSONObject + "," + this.f246112d.getPageWebview().pageWebviewId + ")");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
