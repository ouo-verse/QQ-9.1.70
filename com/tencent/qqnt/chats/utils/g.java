package com.tencent.qqnt.chats.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/utils/g;", "", "", "Lcom/tencent/qqnt/chats/data/converter/f;", "payloads", "Lcom/tencent/qqnt/chats/data/converter/g;", "processor", "", "a", "([Lcom/tencent/qqnt/chats/data/converter/f;Lcom/tencent/qqnt/chats/data/converter/g;)Z", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f355548a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f355548a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@Nullable com.tencent.qqnt.chats.data.converter.f[] payloads, @NotNull com.tencent.qqnt.chats.data.converter.g processor) {
        boolean z16;
        com.tencent.qqnt.chats.data.converter.f fVar;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) payloads, (Object) processor)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(processor, "processor");
        if (payloads != null) {
            if (payloads.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    int length = payloads.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            fVar = payloads[i3];
                            if (processor.matchPayload(fVar)) {
                                break;
                            }
                            i3++;
                        } else {
                            fVar = null;
                            break;
                        }
                    }
                    if (fVar == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
        return true;
    }
}
