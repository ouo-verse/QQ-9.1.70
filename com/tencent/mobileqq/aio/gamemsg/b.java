package com.tencent.mobileqq.aio.gamemsg;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.factory.inputadorn.c;
import com.tencent.mobileqq.aio.input.edit.delegate.p;
import com.tencent.mobileqq.aio.input.sendmsg.AIOSendMsgVMDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IGameMsgApi;
import com.tencent.qqnt.aio.interceptor.sendmsg.a;
import com.tencent.qqnt.aio.interceptor.sendmsg.d;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J2\u0010\n\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J2\u0010\u000f\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0005j\u0002`\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/gamemsg/b;", "Lcom/tencent/mobileqq/aio/factory/inputadorn/b;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "host", "", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "g", "Lcom/tencent/mobileqq/aio/input/sendmsg/AIOSendMsgVMDelegate;", "aioSendMsgVMDelegate", "", h.F, "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends com.tencent.mobileqq.aio.factory.inputadorn.b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/gamemsg/b$a", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "intercept", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.qqnt.aio.interceptor.sendmsg.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
        @NotNull
        public d intercept(@NotNull com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) paramWrapper);
            }
            Intrinsics.checkNotNullParameter(paramWrapper, "paramWrapper");
            return ((IGameMsgApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGameMsgApi.class)).onSendMsgIntercept(paramWrapper);
        }

        @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
        public boolean interceptResend(@NotNull com.tencent.aio.api.runtime.a aVar, @NotNull com.tencent.aio.data.msglist.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) aVar2)).booleanValue();
            }
            return a.C9483a.a(this, aVar, aVar2);
        }

        @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
        public void reportAfterKernelSend(boolean z16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3));
            } else {
                a.C9483a.b(this, z16, j3);
            }
        }

        @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
        public void reportBeforeKernelSend(boolean z16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Long.valueOf(j3));
            } else {
                a.C9483a.c(this, z16, j3);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> g(com.tencent.mobileqq.aio.input.adorn.c host) {
        List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> listOf;
        AIOSendMsgVMDelegate aIOSendMsgVMDelegate = new AIOSendMsgVMDelegate(host);
        h(aIOSendMsgVMDelegate);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new e[]{new p(host), new com.tencent.mobileqq.aio.input.edit.delegate.e(host), aIOSendMsgVMDelegate, new com.tencent.mobileqq.aio.input.inputbar.compat.d(host)});
        return listOf;
    }

    private final void h(AIOSendMsgVMDelegate aioSendMsgVMDelegate) {
        aioSendMsgVMDelegate.a(new a());
    }

    @Override // com.tencent.mobileqq.aio.factory.inputadorn.b, com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> c(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
        List plus;
        List plus2;
        List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> plus3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        List<e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> g16 = g(host);
        c.C7245c c7245c = c.C7245c.f188794a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) g16, (Iterable) c7245c.c(host));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) c7245c.e(host));
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Iterable) c7245c.a(host));
        return plus3;
    }
}
