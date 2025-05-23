package com.tencent.mobileqq.aio.msglist.holder.component.graptips;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/a;", "Lgv3/a;", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "msgItem", "", "c", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "curAIOMsgItem", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "aioContextRef", "<init>", "()V", "aioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements gv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem curAIOMsgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.aio.api.runtime.a> aioContextRef;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // gv3.a
    @Nullable
    public com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.aioContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // gv3.a
    @Nullable
    public AIOMsgItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.curAIOMsgItem;
    }

    @Override // gv3.a
    public void c(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem);
        } else {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            this.curAIOMsgItem = msgItem;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        this();
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.aioContextRef = new WeakReference<>(aioContext);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
        }
    }
}
