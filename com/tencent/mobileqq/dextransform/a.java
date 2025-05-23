package com.tencent.mobileqq.dextransform;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.reference.ImmutableMethodReference;
import org.jf.dexlib2.immutable.util.ParamUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    protected static final Pattern f203531g;

    /* renamed from: a, reason: collision with root package name */
    public InjectAction f203532a;

    /* renamed from: b, reason: collision with root package name */
    public String f203533b;

    /* renamed from: c, reason: collision with root package name */
    public String f203534c;

    /* renamed from: d, reason: collision with root package name */
    public String f203535d;

    /* renamed from: e, reason: collision with root package name */
    protected String f203536e;

    /* renamed from: f, reason: collision with root package name */
    protected String f203537f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f203531g = Pattern.compile("\\(([^)]*)\\)(.+)");
        }
    }

    public a(InjectAction injectAction, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, injectAction, str, str2, str3);
            return;
        }
        this.f203532a = injectAction;
        this.f203533b = str;
        this.f203534c = str2;
        this.f203535d = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f203536e != null) {
            return;
        }
        Matcher matcher = f203531g.matcher(this.f203535d);
        if (matcher.matches()) {
            this.f203536e = matcher.group(1);
            this.f203537f = matcher.group(2);
        }
    }

    @Nullable
    public MethodReference b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MethodReference) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        a();
        String str = this.f203536e;
        if (str == null) {
            return null;
        }
        try {
            return new ImmutableMethodReference(this.f203533b, this.f203534c, ParamUtil.parseParamString(str), this.f203537f);
        } catch (IllegalArgumentException e16) {
            com.tencent.mobileqq.nlog.c.b("AbstractConfig", "", e16);
            return null;
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (d() && f() && e()) {
            return true;
        }
        return false;
    }

    protected abstract boolean d();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f203533b != null && this.f203534c != null && this.f203535d != null) {
            return true;
        }
        return false;
    }

    protected abstract boolean f();
}
