package com.tencent.mobileqq.aio.msglist.holder;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0011\u0010\u0007\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\r\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/c;", "", "", "resId", "f", "g", "()I", "headSize", "b", "bubbleMarginLeft", "d", "bubbleMarginTop", "c", "bubbleMarginRight", "a", "bubbleMarginBottom", "e", "bubbleMaxWidth", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f190651a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f190651a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int f(int resId) {
        return BaseApplication.context.getResources().getDimensionPixelSize(resId);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return f(R.dimen.f158200a5);
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return p.c(8);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return p.c(8);
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return f(R.dimen.f158201a6);
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return ((PicUtil.f191410a.l() - b()) - c()) - g();
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return f(R.dimen.f158229ay);
    }
}
