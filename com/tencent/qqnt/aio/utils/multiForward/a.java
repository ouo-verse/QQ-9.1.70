package com.tencent.qqnt.aio.utils.multiForward;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Stack;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/utils/multiForward/a;", "", "", "b", "Ljava/util/Stack;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Ljava/util/Stack;", "a", "()Ljava/util/Stack;", "setMultiForwardMsgItemStack", "(Ljava/util/Stack;)V", "multiForwardMsgItemStack", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f352306a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Stack<MsgRecord> multiForwardMsgItemStack;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352306a = new a();
            multiForwardMsgItemStack = new Stack<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Stack<MsgRecord> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Stack) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return multiForwardMsgItemStack;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("8970_11635_113084475_multi_token", true);
    }
}
