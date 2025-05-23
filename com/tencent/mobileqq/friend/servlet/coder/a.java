package com.tencent.mobileqq.friend.servlet.coder;

import com.qq.jce.wup.UniPacket;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fJ1\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/coder/a;", "", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/qq/jce/wup/UniPacket;", "client", "", "c", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "a", "", "", "e", "()[Ljava/lang/String;", "cmd", "d", "T", "", "wupBuf", "wupRetName", "tmp", "b", "([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public Object a(@NotNull ToServiceMsg request, @NotNull FromServiceMsg response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        return null;
    }

    @Nullable
    public final <T> T b(@Nullable byte[] wupBuf, @Nullable String wupRetName, T tmp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, this, wupBuf, wupRetName, tmp);
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(wupBuf);
            return (T) uniPacket.getByClass(wupRetName, tmp);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean c(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) client)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        return false;
    }

    public final boolean d(@NotNull String cmd) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cmd)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        String[] e16 = e();
        if (e16.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return false;
        }
        for (String str : e16) {
            if (Intrinsics.areEqual(cmd, str)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public abstract String[] e();
}
