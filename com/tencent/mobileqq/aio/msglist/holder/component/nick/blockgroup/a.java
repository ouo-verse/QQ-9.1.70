package com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/a;", "", "", "b", "", "a", "Ljava/lang/Boolean;", "isSwitchOn", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191356a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean isSwitchOn;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48755);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f191356a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            isSwitchOn = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("101894", false));
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (isSwitchOn == null) {
            Boolean valueOf = Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("101894", false));
            isSwitchOn = valueOf;
            QLog.i("AIONickIconConfigUtils", 2, "[AIONickIconConfigUtils] rtn = " + valueOf);
        }
        Boolean bool = isSwitchOn;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
