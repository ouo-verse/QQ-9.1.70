package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001/\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010%\u001a\u00028\u0000\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010.\u001a\u00020*\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0017J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0017J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J(\u0010\u001d\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016R\u0017\u0010%\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010)\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b#\u0010'\u001a\u0004\b!\u0010(R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "T", "Lcom/tencent/mvi/base/route/g;", "", "j", "k", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "g", "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "c", "a", "Lcom/tencent/mobileqq/aio/msg/service/p;", "rsp", tl.h.F, "Lcom/tencent/aio/msgservice/h;", "i", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "aioMsgService", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "list", "", "source", "Landroid/os/Bundle;", "extra", "b", "newMsgItem", "oldMsgItem", "l", "d", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "e", "()Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "msgRepo", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "com/tencent/mobileqq/aio/msglist/msgrepo/g$a", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g$a;", "mAction", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class g<T extends BaseMsgRepo> implements com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final T msgRepo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/msgrepo/g$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g<T> f192579d;

        a(g<T> gVar) {
            this.f192579d = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                this.f192579d.g(i3);
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

    public g(@NotNull T msgRepo, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRepo, aioContext, scope);
            return;
        }
        this.msgRepo = msgRepo;
        this.aioContext = aioContext;
        this.scope = scope;
        this.mAction = new a(this);
    }

    public void a(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgItemList);
        } else {
            Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        }
    }

    public void b(@NotNull List<com.tencent.aio.data.msglist.a> list, @NotNull String source, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, list, source, extra);
        } else {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(source, "source");
        }
    }

    public void c(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgItemList);
        } else {
            Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        }
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioContext;
    }

    @NotNull
    public final T e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgRepo;
    }

    @NotNull
    public final CoroutineScope f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.scope;
    }

    public void g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    @Override // com.tencent.mvi.base.route.g
    public /* synthetic */ Set getSubscribeEventNames() {
        return com.tencent.mvi.base.route.f.a(this);
    }

    @Override // com.tencent.mvi.base.route.g
    public /* synthetic */ Set getSubscribeEventRNames() {
        return com.tencent.mvi.base.route.f.b(this);
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "beforeNotifyMsgChange, from\u53c2\u6570\u533a\u5206\u6765\u6e90", imports = {}))
    public void h(@NotNull com.tencent.mobileqq.aio.msg.service.p<com.tencent.aio.data.msglist.a> rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) rsp);
        } else {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
        }
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "beforeNotifyMsgChange, from\u53c2\u6570\u533a\u5206\u6765\u6e90", imports = {}))
    public void i(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) rsp);
        } else {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
        }
    }

    @CallSuper
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.aioContext.e().f(this, this.mAction);
        }
    }

    @CallSuper
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.aioContext.e().i(this, this.mAction);
        }
    }

    public void l(@NotNull com.tencent.aio.data.msglist.a newMsgItem, @NotNull com.tencent.aio.data.msglist.a oldMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newMsgItem, (Object) oldMsgItem);
        } else {
            Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
            Intrinsics.checkNotNullParameter(oldMsgItem, "oldMsgItem");
        }
    }

    public void m(@NotNull AIOMsgServiceWithContext aioMsgService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aioMsgService);
        } else {
            Intrinsics.checkNotNullParameter(aioMsgService, "aioMsgService");
        }
    }
}
