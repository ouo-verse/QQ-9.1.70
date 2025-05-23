package com.tencent.qqnt.chats.main.lightbusiness.reveal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/lightbusiness/reveal/b;", "Lcom/tencent/qqnt/biz/lightbusiness/b;", "", "jsonString", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "getBusinessType", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements com.tencent.qqnt.biz.lightbusiness.b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.b
    @Nullable
    public Object a(@NotNull String jsonString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonString);
        }
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        return com.tencent.qqnt.chats.biz.bean.a.INSTANCE.a(jsonString);
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.b
    @NotNull
    public LiteBusinessType getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiteBusinessType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return LiteBusinessType.KONLINESTATUS;
    }
}
