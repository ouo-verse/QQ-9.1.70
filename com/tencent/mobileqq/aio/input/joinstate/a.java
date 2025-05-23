package com.tencent.mobileqq.aio.input.joinstate;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent;
import com.tencent.mobileqq.aio.input.joinstate.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010\u001eJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fH\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0015H\u0016R\"\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/input/joinstate/a;", "Lcom/tencent/mobileqq/aio/mvi/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/AbsInputBarVMDelegate;", "", "isJoin", "", "j", "Lcom/tencent/mvi/base/route/k;", "k", "", "", "kotlin.jvm.PlatformType", "d", "e", "Ljava/lang/Class;", "d0", "intent", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "f", "g", h.F, "Lcom/tencent/mobileqq/aio/input/adorn/c;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Z", "joinState", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends com.tencent.mobileqq.aio.mvi.a<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean joinState;

    public a(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
            this.joinState = true;
        }
    }

    private final void j(boolean isJoin) {
        com.tencent.aio.api.runtime.a c16;
        j e16;
        this.joinState = isJoin;
        if (!isJoin && (c16 = c()) != null && (e16 = c16.e()) != null) {
            e16.h(MsgForwardEvent.ExitMultiForward.f188621d);
        }
    }

    private final k k() {
        return new c.a(this.joinState);
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(GroupJoinStateIntent.GroupJoinStateChange.class.getCanonicalName());
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    @NotNull
    public List<String> e() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(GroupJoinStateIntent.GetJoinState.class.getCanonicalName());
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    public void f(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
        if (msgIntent instanceof GroupJoinStateIntent.GroupJoinStateChange) {
            j(((GroupJoinStateIntent.GroupJoinStateChange) msgIntent).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.mvi.a
    @NotNull
    public k g(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (k) iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GroupJoinStateIntent.GetJoinState) {
            return k();
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }
}
