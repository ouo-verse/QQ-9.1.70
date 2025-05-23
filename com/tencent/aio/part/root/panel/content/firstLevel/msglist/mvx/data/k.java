package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010>\u001a\u00020<\u00a2\u0006\u0004\b?\u0010@J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u001e\u0010\u0010\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\rH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020 0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eH\u0016J\n\u0010(\u001a\u0004\u0018\u00010 H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00109\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/f;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgList;", "g", "", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function1;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "notifyAction", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "model", "j", "", "source", "i", "a", "e", "beginMsgSeq", "endMsgSeq", "f", "o", "msgSeq", tl.h.F, "", "Lcom/tencent/aio/data/msglist/a;", "list", "b", "", "displayList", "k", "msgListWithOpType", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "d", "()Lcom/tencent/aio/api/runtime/a;", "setContext", "(Lcom/tencent/aio/api/runtime/a;)V", "Lkotlinx/coroutines/CoroutineScope;", "r", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "getDisplayModel", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "setDisplayModel", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;)V", "displayModel", "Lkotlin/jvm/functions/Function1;", "msgNotifyAction", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class k implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public com.tencent.aio.api.runtime.a context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a displayModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<? super l, Unit> msgNotifyAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final MsgListRepo host;

    public k(@NotNull MsgListRepo host) {
        Intrinsics.checkNotNullParameter(host, "host");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) host);
        } else {
            this.host = host;
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.host.a();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Collection) iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        return this.host.b(list);
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        com.tencent.aio.api.runtime.a aVar = this.context;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return aVar;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.host.e();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq));
        } else {
            this.host.f(beginMsgSeq, endMsgSeq);
        }
    }

    @NotNull
    public final MsgList g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MsgList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.host.M();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, msgSeq);
        } else {
            this.host.h(msgSeq);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) source);
        } else {
            Intrinsics.checkNotNullParameter(source, "source");
            this.host.i(source);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void j(@NotNull a model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) model);
        } else {
            Intrinsics.checkNotNullParameter(model, "model");
            this.displayModel = model;
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        return this.host.k(displayList);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) scope);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.scope = scope;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void m(@Nullable Function1<? super l, Unit> notifyAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) notifyAction);
        } else {
            this.msgNotifyAction = notifyAction;
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public l n(@NotNull l msgListWithOpType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (l) iPatchRedirector.redirect((short) 23, (Object) this, (Object) msgListWithOpType);
        }
        Intrinsics.checkNotNullParameter(msgListWithOpType, "msgListWithOpType");
        return this.host.n(msgListWithOpType);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.host.o();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public final long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.host.O();
    }

    @Nullable
    public com.tencent.aio.data.msglist.a q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.host.H();
    }

    @NotNull
    public final CoroutineScope r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
        }
        return coroutineScope;
    }
}
