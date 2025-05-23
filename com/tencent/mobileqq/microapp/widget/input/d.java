package com.tencent.mobileqq.microapp.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class d implements TextView.OnEditorActionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebEditText f246166a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PageWebview f246167b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f246168c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, WebEditText webEditText, PageWebview pageWebview) {
        this.f246168c = aVar;
        this.f246166a = webEditText;
        this.f246167b = pageWebview;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, webEditText, pageWebview);
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
        } else if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", this.f246168c.f246159h);
                jSONObject.put("value", this.f246166a.getText().toString());
                this.f246167b.evaluateSubcribeJS(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString(), this.f246167b.pageWebviewId);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.f246168c.a(true);
            z16 = true;
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z16;
    }
}
