package com.tencent.android.androidbypass.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.android.androidbypass.enhance.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickableUrlSpan extends URLSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final a f72431d;

    /* renamed from: e, reason: collision with root package name */
    private final j f72432e;

    /* renamed from: f, reason: collision with root package name */
    private long f72433f;

    /* renamed from: h, reason: collision with root package name */
    private String f72434h;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(View view, ClickableSpan clickableSpan, String str, String str2);
    }

    public ClickableUrlSpan(String str, String str2, a aVar, j jVar) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, aVar, jVar);
            return;
        }
        this.f72433f = 0L;
        this.f72434h = str2;
        this.f72431d = aVar;
        this.f72432e = jVar;
    }

    protected boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f72433f < 800) {
            com.tencent.android.androidbypass.config.a.f72049a.d("Markdown.ClickableUrlSpan", "click fast");
            this.f72433f = currentTimeMillis;
            return true;
        }
        this.f72433f = currentTimeMillis;
        return false;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            return;
        }
        if (a()) {
            return;
        }
        a aVar = this.f72431d;
        if ((aVar == null || !aVar.a(view, this, getURL(), this.f72434h)) && (jVar = this.f72432e) != null) {
            jVar.b(view, this, getURL());
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
        } else if (textPaint != null) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }
}
