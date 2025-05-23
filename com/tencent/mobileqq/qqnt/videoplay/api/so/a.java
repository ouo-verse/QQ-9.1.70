package com.tencent.mobileqq.qqnt.videoplay.api.so;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a;", "", "Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a$a;", "b", "Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a$a;", "a", "()Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a$a;", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a$a;)V", "thirdPartyLoader", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274211a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static InterfaceC8418a thirdPartyLoader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/so/a$a;", "", "", "b", "a", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.api.so.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC8418a {
        boolean a();

        boolean b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39538);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f274211a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final InterfaceC8418a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InterfaceC8418a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return thirdPartyLoader;
    }

    public final void b(@Nullable InterfaceC8418a interfaceC8418a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interfaceC8418a);
        } else {
            thirdPartyLoader = interfaceC8418a;
        }
    }
}
