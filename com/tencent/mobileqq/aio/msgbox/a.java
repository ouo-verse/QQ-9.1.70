package com.tencent.mobileqq.aio.msgbox;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msgbox/a;", "Ljv3/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "c", "", "b", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements jv3.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // jv3.a
    @Nullable
    public CharSequence a(@Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioContext, (Object) info);
        }
        return null;
    }

    @Override // jv3.a
    @Nullable
    public CharSequence b(@Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) info);
        }
        return null;
    }

    @Override // jv3.a
    public boolean c(@Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable RecentContactInfo info) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext, (Object) info)).booleanValue();
        }
        if (info != null && info.chatType == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (info != null && info.chatType == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (info != null && info.chatType == 3) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (info != null && info.chatType == 100) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
