package com.tencent.mobileqq.qqgift.updatasystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes16.dex */
public class QQGiftPanelResource {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f265001a;

    /* renamed from: b, reason: collision with root package name */
    public String f265002b;

    /* renamed from: c, reason: collision with root package name */
    public String f265003c;

    /* renamed from: d, reason: collision with root package name */
    public String f265004d;

    /* renamed from: e, reason: collision with root package name */
    public String f265005e;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    @interface PanelResourceType {
    }

    public QQGiftPanelResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f265001a = "png";
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQGiftPanelResource{thumbType='" + this.f265001a + "', thumbPath='" + this.f265002b + "', thumbPagPath='" + this.f265003c + "', bgType='" + this.f265004d + "', bgPath='" + this.f265005e + "'}";
    }
}
