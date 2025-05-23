package com.tencent.mobileqq.aio.msglist.holder.external;

import androidx.annotation.WorkerThread;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u0001\u001d\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016R(\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u00158\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "", "", "i", "", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "c", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/external/f;", "response", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "d", "", "g", "", "j", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "getHelperWeakReference", "()Ljava/lang/ref/WeakReference;", "helperWeakReference", "com/tencent/mobileqq/aio/msglist/holder/external/c$a", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c$a;", "mAction", "helper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/external/e;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<e> helperWeakReference;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/external/c$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                c.this.d(i3);
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

    public c(@NotNull e helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
            return;
        }
        this.helperWeakReference = new WeakReference<>(helper);
        this.mAction = new a();
        Iterator<T> it = g().iterator();
        while (it.hasNext()) {
            helper.a().e().d((String) it.next(), this.mAction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, f response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "$response");
        e eVar = this$0.helperWeakReference.get();
        if (eVar != null) {
            eVar.sendMessage(new MsgItemExternalRefreshEvent.DoRefresh(response));
        }
    }

    public final int b() {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        e eVar = this.helperWeakReference.get();
        if (eVar != null && (a16 = eVar.a()) != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            return c16.e();
        }
        return 0;
    }

    public abstract void c(@NotNull h request);

    protected void d(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    @WorkerThread
    public final void e(@NotNull final f response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) response);
        } else {
            Intrinsics.checkNotNullParameter(response, "response");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.external.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(c.this, response);
                }
            });
        }
    }

    @NotNull
    protected List<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new ArrayList();
    }

    public void h() {
        com.tencent.aio.api.runtime.a a16;
        j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        for (String str : g()) {
            e eVar = this.helperWeakReference.get();
            if (eVar != null && (a16 = eVar.a()) != null && (e16 = a16.e()) != null) {
                e16.d(str, this.mAction);
            }
        }
    }

    @NotNull
    public final String i() {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e eVar = this.helperWeakReference.get();
        if (eVar == null || (a16 = eVar.a()) == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return "";
        }
        return j3;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }
}
