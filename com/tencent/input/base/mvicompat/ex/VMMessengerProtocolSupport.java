package com.tencent.input.base.mvicompat.ex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007*\u0002\u000b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R%\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\f\u0010\u0016R%\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "", "Lcom/tencent/mvi/base/route/j;", "messenger", "", "d", "e", "Lcom/tencent/input/base/mvicompat/ex/a;", "a", "Lcom/tencent/input/base/mvicompat/ex/a;", "vmMessengerProtocol", "com/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport$a", "b", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport$a;", "action1", "com/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport$b", "c", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport$b;", "actionR1", "", "", "Lkotlin/Lazy;", "()Ljava/util/List;", "messageList", "messageRList", "<init>", "(Lcom/tencent/input/base/mvicompat/ex/a;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class VMMessengerProtocolSupport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.input.base.mvicompat.ex.a vmMessengerProtocol;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b actionR1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy messageList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy messageRList;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VMMessengerProtocolSupport.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                VMMessengerProtocolSupport.this.vmMessengerProtocol.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VMMessengerProtocolSupport.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return VMMessengerProtocolSupport.this.vmMessengerProtocol.I(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        }
    }

    public VMMessengerProtocolSupport(@NotNull com.tencent.input.base.mvicompat.ex.a vmMessengerProtocol) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(vmMessengerProtocol, "vmMessengerProtocol");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vmMessengerProtocol);
            return;
        }
        this.vmMessengerProtocol = vmMessengerProtocol;
        this.action1 = new a();
        this.actionR1 = new b();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends String>>() { // from class: com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport$messageList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VMMessengerProtocolSupport.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? VMMessengerProtocolSupport.this.vmMessengerProtocol.J2() : (List) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.messageList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends String>>() { // from class: com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport$messageRList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VMMessengerProtocolSupport.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final List<? extends String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? VMMessengerProtocolSupport.this.vmMessengerProtocol.f0() : (List) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.messageRList = lazy2;
    }

    private final List<String> b() {
        return (List) this.messageList.getValue();
    }

    private final List<String> c() {
        return (List) this.messageRList.getValue();
    }

    public final void d(@NotNull j messenger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messenger);
            return;
        }
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        List<String> b16 = b();
        if (b16 != null) {
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                messenger.d((String) it.next(), this.action1);
            }
        }
        List<String> c16 = c();
        if (c16 != null) {
            Iterator<T> it5 = c16.iterator();
            while (it5.hasNext()) {
                messenger.j((String) it5.next(), this.actionR1);
            }
        }
    }

    public final void e(@NotNull j messenger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messenger);
            return;
        }
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        List<String> b16 = b();
        if (b16 != null) {
            Iterator<T> it = b16.iterator();
            while (it.hasNext()) {
                messenger.b((String) it.next(), this.action1);
            }
        }
        List<String> c16 = c();
        if (c16 != null) {
            Iterator<T> it5 = c16.iterator();
            while (it5.hasNext()) {
                messenger.a((String) it5.next());
            }
        }
    }
}
